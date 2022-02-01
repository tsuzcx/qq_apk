package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class bu
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("fmessage_msginfo");
  private static final int createTime_HASHCODE = "createTime".hashCode();
  public static final Column hGX;
  private static final int hKQ;
  public static final Column hKn;
  public static final Column hLf;
  private static final int hLj;
  private static final int hLk;
  private static final int hLl = "chatroomName".hashCode();
  private static final int htH;
  public static final Column htd;
  public static final Column hwI;
  private static final int hxk;
  public static final Column hzX;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSettype = true;
  public String field_chatroomName;
  public long field_createTime;
  public String field_encryptTalker;
  public int field_isSend;
  public String field_msgContent;
  public long field_svrId;
  public String field_talker;
  public int field_type;
  private boolean hKB = true;
  private boolean hLg = true;
  private boolean hLh = true;
  private boolean hLi = true;
  private boolean hts = true;
  private boolean hwW = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "fmessage_msginfo", "");
    hLf = new Column("msgcontent", "string", "fmessage_msginfo", "");
    htd = new Column("issend", "int", "fmessage_msginfo", "");
    hwI = new Column("talker", "string", "fmessage_msginfo", "");
    hKn = new Column("encrypttalker", "string", "fmessage_msginfo", "");
    hGX = new Column("svrid", "long", "fmessage_msginfo", "");
    C_TYPE = new Column("type", "int", "fmessage_msginfo", "");
    C_CREATETIME = new Column("createtime", "long", "fmessage_msginfo", "");
    hzX = new Column("chatroomname", "string", "fmessage_msginfo", "");
    hLj = "msgContent".hashCode();
    htH = "isSend".hashCode();
    hxk = "talker".hashCode();
    hKQ = "encryptTalker".hashCode();
    hLk = "svrId".hashCode();
    type_HASHCODE = "type".hashCode();
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
      if (hLj != k) {
        break label60;
      }
      this.field_msgContent = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (htH == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (hxk == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (hKQ == k) {
        this.field_encryptTalker = paramCursor.getString(i);
      } else if (hLk == k) {
        this.field_svrId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (hLl == k) {
        this.field_chatroomName = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_msgContent == null) {
      this.field_msgContent = "";
    }
    if (this.hLg) {
      localContentValues.put("msgContent", this.field_msgContent);
    }
    if (this.hts) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.hwW) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.hKB) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.hLh) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_chatroomName == null) {
      this.field_chatroomName = "";
    }
    if (this.hLi) {
      localContentValues.put("chatroomName", this.field_chatroomName);
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
    return "fmessage_msginfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.bu
 * JD-Core Version:    0.7.0.1
 */