package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class t
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("AppBrandSeparatedPluginsCompatMarkTable");
  public static final Column hnz;
  public static final Column hoR;
  private static final int hoZ = "appVersion".hashCode();
  private static final int hoh;
  public static final Column hpA;
  private static final int hpC = "isSeparatedPluginsUsed".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public int field_appVersion;
  public int field_isSeparatedPluginsUsed;
  private boolean hnQ = true;
  private boolean hoV = true;
  private boolean hpB = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "AppBrandSeparatedPluginsCompatMarkTable", "");
    hnz = new Column("appid", "string", "AppBrandSeparatedPluginsCompatMarkTable", "");
    hoR = new Column("appversion", "int", "AppBrandSeparatedPluginsCompatMarkTable", "");
    hpA = new Column("isseparatedpluginsused", "int", "AppBrandSeparatedPluginsCompatMarkTable", "");
    hoh = "appId".hashCode();
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
      if (hoh != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hoZ == k) {
        this.field_appVersion = paramCursor.getInt(i);
      } else if (hpC == k) {
        this.field_isSeparatedPluginsUsed = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hoV) {
      localContentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
    }
    if (this.hpB) {
      localContentValues.put("isSeparatedPluginsUsed", Integer.valueOf(this.field_isSeparatedPluginsUsed));
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
    return "AppBrandSeparatedPluginsCompatMarkTable";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.t
 * JD-Core Version:    0.7.0.1
 */