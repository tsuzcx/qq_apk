package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class il
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WxaPluginCodeVersionInfo");
  public static final Column iNA = new Column("pluginappversion", "int", "WxaPluginCodeVersionInfo", "");
  public static final Column iNB = new Column("pluginstringversion", "string", "WxaPluginCodeVersionInfo", "");
  private static final int iNF = "pluginAppID".hashCode();
  private static final int iNG = "pluginAppVersion".hashCode();
  private static final int iNH = "pluginStringVersion".hashCode();
  public static final Column iNz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_pluginAppID;
  public int field_pluginAppVersion;
  public String field_pluginStringVersion;
  private boolean iNC = true;
  private boolean iND = true;
  private boolean iNE = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WxaPluginCodeVersionInfo", "");
    iNz = new Column("pluginappid", "string", "WxaPluginCodeVersionInfo", "");
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
      if (iNF != k) {
        break label60;
      }
      this.field_pluginAppID = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (iNG == k) {
        this.field_pluginAppVersion = paramCursor.getInt(i);
      } else if (iNH == k) {
        this.field_pluginStringVersion = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iNC) {
      localContentValues.put("pluginAppID", this.field_pluginAppID);
    }
    if (this.iND) {
      localContentValues.put("pluginAppVersion", Integer.valueOf(this.field_pluginAppVersion));
    }
    if (this.iNE) {
      localContentValues.put("pluginStringVersion", this.field_pluginStringVersion);
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
    return "WxaPluginCodeVersionInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.il
 * JD-Core Version:    0.7.0.1
 */