package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class dl
  extends IAutoDBItem
{
  public static final Column C_CONTENT;
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("GetSysCmdMsgInfo");
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  public static final Column hHc;
  public static final Column hHd;
  public static final Column hHe;
  public static final Column hHf;
  private static final int hIE = "reserved1".hashCode();
  private static final int hIF = "reserved2".hashCode();
  private static final int hIG = "reserved3".hashCode();
  private static final int hIH = "reserved4".hashCode();
  public static final Column hsi;
  private static final int hsm;
  public static final Column hxG;
  public static final Column hxH;
  public static final Column hxI;
  private static final int hxO;
  public static final Column iaR;
  public static final Column iaS;
  public static final Column iaT;
  private static final int iba;
  private static final int ibb;
  private static final int ibc;
  private static final int ibd;
  private static final int ibe;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcontent = true;
  private boolean __hadSetcreateTime = true;
  public String field_content;
  public long field_createTime;
  public int field_flag;
  public String field_fromUserName;
  public int field_msgSeq;
  public String field_msgSource;
  public long field_newMsgId;
  public long field_originSvrId;
  public int field_reserved1;
  public long field_reserved2;
  public String field_reserved3;
  public String field_reserved4;
  public String field_toUserName;
  private boolean hHQ = true;
  private boolean hHR = true;
  private boolean hHS = true;
  private boolean hHT = true;
  private boolean hsk = true;
  private boolean iaU = true;
  private boolean iaV = true;
  private boolean iaW = true;
  private boolean iaX = true;
  private boolean iaY = true;
  private boolean iaZ = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "GetSysCmdMsgInfo", "");
    iaR = new Column("originsvrid", "long", "GetSysCmdMsgInfo", "");
    iaS = new Column("newmsgid", "long", "GetSysCmdMsgInfo", "");
    hxH = new Column("fromusername", "string", "GetSysCmdMsgInfo", "");
    hxI = new Column("tousername", "string", "GetSysCmdMsgInfo", "");
    C_CREATETIME = new Column("createtime", "long", "GetSysCmdMsgInfo", "");
    C_CONTENT = new Column("content", "string", "GetSysCmdMsgInfo", "");
    iaT = new Column("msgsource", "string", "GetSysCmdMsgInfo", "");
    hxG = new Column("msgseq", "int", "GetSysCmdMsgInfo", "");
    hsi = new Column("flag", "int", "GetSysCmdMsgInfo", "");
    hHc = new Column("reserved1", "int", "GetSysCmdMsgInfo", "");
    hHd = new Column("reserved2", "long", "GetSysCmdMsgInfo", "");
    hHe = new Column("reserved3", "string", "GetSysCmdMsgInfo", "");
    hHf = new Column("reserved4", "string", "GetSysCmdMsgInfo", "");
    iba = "originSvrId".hashCode();
    ibb = "newMsgId".hashCode();
    ibc = "fromUserName".hashCode();
    ibd = "toUserName".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    content_HASHCODE = "content".hashCode();
    ibe = "msgSource".hashCode();
    hxO = "msgSeq".hashCode();
    hsm = "flag".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (iba != k) {
        break label65;
      }
      this.field_originSvrId = paramCursor.getLong(i);
      this.iaU = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ibb == k) {
        this.field_newMsgId = paramCursor.getLong(i);
      } else if (ibc == k) {
        this.field_fromUserName = paramCursor.getString(i);
      } else if (ibd == k) {
        this.field_toUserName = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (ibe == k) {
        this.field_msgSource = paramCursor.getString(i);
      } else if (hxO == k) {
        this.field_msgSeq = paramCursor.getInt(i);
      } else if (hsm == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (hIE == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (hIF == k) {
        this.field_reserved2 = paramCursor.getLong(i);
      } else if (hIG == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (hIH == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iaU) {
      localContentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
    }
    if (this.iaV) {
      localContentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
    }
    if (this.field_fromUserName == null) {
      this.field_fromUserName = "";
    }
    if (this.iaW) {
      localContentValues.put("fromUserName", this.field_fromUserName);
    }
    if (this.field_toUserName == null) {
      this.field_toUserName = "";
    }
    if (this.iaX) {
      localContentValues.put("toUserName", this.field_toUserName);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgSource == null) {
      this.field_msgSource = "";
    }
    if (this.iaY) {
      localContentValues.put("msgSource", this.field_msgSource);
    }
    if (this.iaZ) {
      localContentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
    }
    if (this.hsk) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.hHQ) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.hHR) {
      localContentValues.put("reserved2", Long.valueOf(this.field_reserved2));
    }
    if (this.field_reserved3 == null) {
      this.field_reserved3 = "";
    }
    if (this.hHS) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.field_reserved4 == null) {
      this.field_reserved4 = "";
    }
    if (this.hHT) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "GetSysCmdMsgInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.dl
 * JD-Core Version:    0.7.0.1
 */