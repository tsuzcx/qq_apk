package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ij
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WxaCheckDemoInfo");
  public static final Column hnz;
  private static final int hoh = "appId".hashCode();
  public static final Column iNq;
  public static final Column iNr;
  private static final int iNu = "permissionDemo".hashCode();
  private static final int iNv = "versiontime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public boolean field_permissionDemo;
  public long field_versiontime;
  private boolean hnQ = true;
  private boolean iNs = true;
  private boolean iNt = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WxaCheckDemoInfo", "");
    hnz = new Column("appid", "string", "WxaCheckDemoInfo", "");
    iNq = new Column("permissiondemo", "boolean", "WxaCheckDemoInfo", "");
    iNr = new Column("versiontime", "long", "WxaCheckDemoInfo", "");
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
      if (hoh != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.hnQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iNu == k)
      {
        if (paramCursor.getInt(i) != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.field_permissionDemo = bool;
          break;
        }
      }
      if (iNv == k) {
        this.field_versiontime = paramCursor.getLong(i);
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
    if (this.iNs) {
      localContentValues.put("permissionDemo", Boolean.valueOf(this.field_permissionDemo));
    }
    if (this.iNt) {
      localContentValues.put("versiontime", Long.valueOf(this.field_versiontime));
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
    return "WxaCheckDemoInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ij
 * JD-Core Version:    0.7.0.1
 */