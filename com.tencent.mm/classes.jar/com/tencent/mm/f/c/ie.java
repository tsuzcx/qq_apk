package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ie
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WxFileIndex2");
  public static final Column hml;
  private static final int hmt;
  public static final Column hoC;
  private static final int hoK = "path".hashCode();
  public static final Column hpd;
  private static final int hph = "size".hashCode();
  private static final int htI;
  public static final Column hte;
  public static final Column iMi;
  public static final Column iMj;
  private static final int iMm;
  private static final int iMn = "msgtime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public long field_msgId;
  public int field_msgSubType;
  public int field_msgType;
  public long field_msgtime;
  public String field_path;
  public long field_size;
  public String field_username;
  private boolean hmp = true;
  private boolean hoG = true;
  private boolean hpf = true;
  private boolean htt = true;
  private boolean iMk = true;
  private boolean iMl = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WxFileIndex2", "");
    hml = new Column("msgid", "long", "WxFileIndex2", "");
    C_USERNAME = new Column("username", "string", "WxFileIndex2", "");
    hte = new Column("msgtype", "int", "WxFileIndex2", "");
    iMi = new Column("msgsubtype", "int", "WxFileIndex2", "");
    hoC = new Column("path", "string", "WxFileIndex2", "");
    hpd = new Column("size", "long", "WxFileIndex2", "");
    iMj = new Column("msgtime", "long", "WxFileIndex2", "");
    hmt = "msgId".hashCode();
    username_HASHCODE = "username".hashCode();
    htI = "msgType".hashCode();
    iMm = "msgSubType".hashCode();
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
      if (hmt != k) {
        break label60;
      }
      this.field_msgId = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (htI == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (iMm == k) {
        this.field_msgSubType = paramCursor.getInt(i);
      } else if (hoK == k) {
        this.field_path = paramCursor.getString(i);
      } else if (hph == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (iMn == k) {
        this.field_msgtime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hmp) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.htt) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.iMk) {
      localContentValues.put("msgSubType", Integer.valueOf(this.field_msgSubType));
    }
    if (this.hoG) {
      localContentValues.put("path", this.field_path);
    }
    if (this.hpf) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.iMl) {
      localContentValues.put("msgtime", Long.valueOf(this.field_msgtime));
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
    return "WxFileIndex2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ie
 * JD-Core Version:    0.7.0.1
 */