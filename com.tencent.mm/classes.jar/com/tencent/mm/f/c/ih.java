package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ih
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS WxaAttrVersionServerNotifyRecordAppVersionIndex ON WxaAttrVersionServerNotifyRecord(appVersion)" };
  public static final SingleTable TABLE = new SingleTable("WxaAttrVersionServerNotifyRecord");
  public static final Column hoR;
  private static final int hoZ = "appVersion".hashCode();
  public static final Column hqc;
  private static final int hqm = "reportId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public int field_appVersion;
  public int field_reportId;
  public String field_username;
  private boolean hoV = true;
  private boolean hqh = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WxaAttrVersionServerNotifyRecord", "");
    C_USERNAME = new Column("username", "string", "WxaAttrVersionServerNotifyRecord", "");
    hoR = new Column("appversion", "int", "WxaAttrVersionServerNotifyRecord", "");
    hqc = new Column("reportid", "int", "WxaAttrVersionServerNotifyRecord", "");
    username_HASHCODE = "username".hashCode();
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
      if (username_HASHCODE != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.__hadSetusername = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hoZ == k) {
        this.field_appVersion = paramCursor.getInt(i);
      } else if (hqm == k) {
        this.field_reportId = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.hoV) {
      localContentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
    }
    if (this.hqh) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
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
    return "WxaAttrVersionServerNotifyRecord";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ih
 * JD-Core Version:    0.7.0.1
 */