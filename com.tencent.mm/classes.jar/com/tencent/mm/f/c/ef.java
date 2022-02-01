package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ef
  extends IAutoDBItem
{
  public static final Column C_CONTENT;
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS lbsverifymessage_unread_index ON LBSVerifyMessage(status)", "CREATE INDEX IF NOT EXISTS lbsverifymessage_createtimeIndex ON LBSVerifyMessage(createtime)" };
  public static final SingleTable TABLE = new SingleTable("LBSVerifyMessage");
  private static final int content_HASHCODE;
  public static final Column hGX;
  private static final int hIz;
  private static final int hmC;
  public static final Column hmw;
  public static final Column hnt;
  public static final Column hnu;
  private static final int hnx;
  private static final int hny = "ticket".hashCode();
  public static final Column hsi;
  private static final int hsm = "flag".hashCode();
  private static final int htH;
  public static final Column htd;
  public static final Column hwI;
  public static final Column hwJ;
  private static final int hxk;
  private static final int icG;
  private static final int ifE;
  private static final int ifF;
  private static final int ifG;
  private static final int ifH;
  public static final Column ifx;
  public static final Column ify;
  public static final Column ifz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSettype = true;
  public String field_content;
  public long field_createtime;
  public int field_flag;
  public String field_imgpath;
  public int field_isSend;
  public String field_sayhicontent;
  public String field_sayhiencryptuser;
  public String field_sayhiuser;
  public int field_scene;
  public int field_status;
  public long field_svrid;
  public String field_talker;
  public String field_ticket;
  public int field_type;
  private boolean hHL = true;
  private boolean hmz = true;
  private boolean hnv = true;
  private boolean hnw = true;
  private boolean hsk = true;
  private boolean hts = true;
  private boolean hwW = true;
  private boolean icv = true;
  private boolean ifA = true;
  private boolean ifB = true;
  private boolean ifC = true;
  private boolean ifD = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "LBSVerifyMessage", "");
    hGX = new Column("svrid", "long", "LBSVerifyMessage", "");
    hmw = new Column("status", "int", "LBSVerifyMessage", "");
    C_TYPE = new Column("type", "int", "LBSVerifyMessage", "");
    hnt = new Column("scene", "int", "LBSVerifyMessage", "");
    C_CREATETIME = new Column("createtime", "long", "LBSVerifyMessage", "");
    hwI = new Column("talker", "string", "LBSVerifyMessage", "");
    C_CONTENT = new Column("content", "string", "LBSVerifyMessage", "");
    ifx = new Column("sayhiuser", "string", "LBSVerifyMessage", "");
    ify = new Column("sayhicontent", "string", "LBSVerifyMessage", "");
    hwJ = new Column("imgpath", "string", "LBSVerifyMessage", "");
    htd = new Column("issend", "int", "LBSVerifyMessage", "");
    ifz = new Column("sayhiencryptuser", "string", "LBSVerifyMessage", "");
    hnu = new Column("ticket", "string", "LBSVerifyMessage", "");
    hsi = new Column("flag", "int", "LBSVerifyMessage", "");
    hIz = "svrid".hashCode();
    hmC = "status".hashCode();
    type_HASHCODE = "type".hashCode();
    hnx = "scene".hashCode();
    icG = "createtime".hashCode();
    hxk = "talker".hashCode();
    content_HASHCODE = "content".hashCode();
    ifE = "sayhiuser".hashCode();
    ifF = "sayhicontent".hashCode();
    ifG = "imgpath".hashCode();
    htH = "isSend".hashCode();
    ifH = "sayhiencryptuser".hashCode();
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
      if (hIz != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.hHL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (hnx == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (icG == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (hxk == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (ifE == k) {
        this.field_sayhiuser = paramCursor.getString(i);
      } else if (ifF == k) {
        this.field_sayhicontent = paramCursor.getString(i);
      } else if (ifG == k) {
        this.field_imgpath = paramCursor.getString(i);
      } else if (htH == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (ifH == k) {
        this.field_sayhiencryptuser = paramCursor.getString(i);
      } else if (hny == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (hsm == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hHL) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.hnv) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.icv) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.hwW) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.ifA) {
      localContentValues.put("sayhiuser", this.field_sayhiuser);
    }
    if (this.ifB) {
      localContentValues.put("sayhicontent", this.field_sayhicontent);
    }
    if (this.ifC) {
      localContentValues.put("imgpath", this.field_imgpath);
    }
    if (this.hts) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.ifD) {
      localContentValues.put("sayhiencryptuser", this.field_sayhiencryptuser);
    }
    if (this.hnw) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.hsk) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
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
    return "LBSVerifyMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.ef
 * JD-Core Version:    0.7.0.1
 */