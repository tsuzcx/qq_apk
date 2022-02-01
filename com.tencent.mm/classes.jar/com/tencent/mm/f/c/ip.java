package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ip
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WxaWidgetInfo");
  public static final Column hnz;
  private static final int hoh = "appId".hashCode();
  public static final Column iNX;
  private static final int iNZ = "openDebug".hashCode();
  public static final Column iic;
  private static final int iiq;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public int field_appIdHash;
  public boolean field_openDebug;
  private boolean hnQ = true;
  private boolean iNY = true;
  private boolean iij = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WxaWidgetInfo", "");
    iic = new Column("appidhash", "int", "WxaWidgetInfo", "");
    hnz = new Column("appid", "string", "WxaWidgetInfo", "");
    iNX = new Column("opendebug", "boolean", "WxaWidgetInfo", "");
    iiq = "appIdHash".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (iiq != k) {
        break label65;
      }
      this.field_appIdHash = paramCursor.getInt(i);
      this.iij = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hoh == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else
      {
        if (iNZ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_openDebug = bool;
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iij) {
      localContentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
    }
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.iNY) {
      localContentValues.put("openDebug", Boolean.valueOf(this.field_openDebug));
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
    return "WxaWidgetInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ip
 * JD-Core Version:    0.7.0.1
 */