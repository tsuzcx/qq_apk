package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ig
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WxaAppidABTestInfo");
  public static final Column hnz;
  public static final Column hoQ;
  private static final int hoY = "versionType".hashCode();
  private static final int hoh;
  public static final Column hqz;
  private static final int hrr;
  public static final Column iMA;
  private static final int iMC = "permissionBytes".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public int field_appType;
  public byte[] field_permissionBytes;
  public int field_versionType;
  private boolean hnQ = true;
  private boolean hoU = true;
  private boolean hqV = true;
  private boolean iMB = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WxaAppidABTestInfo", "");
    hnz = new Column("appid", "string", "WxaAppidABTestInfo", "");
    hqz = new Column("apptype", "int", "WxaAppidABTestInfo", "");
    hoQ = new Column("versiontype", "int", "WxaAppidABTestInfo", "");
    iMA = new Column("permissionbytes", "byte[]", "WxaAppidABTestInfo", "");
    hoh = "appId".hashCode();
    hrr = "appType".hashCode();
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
      if (hrr == k) {
        this.field_appType = paramCursor.getInt(i);
      } else if (hoY == k) {
        this.field_versionType = paramCursor.getInt(i);
      } else if (iMC == k) {
        this.field_permissionBytes = paramCursor.getBlob(i);
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
    if (this.hqV) {
      localContentValues.put("appType", Integer.valueOf(this.field_appType));
    }
    if (this.hoU) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.iMB) {
      localContentValues.put("permissionBytes", this.field_permissionBytes);
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
    return "WxaAppidABTestInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ig
 * JD-Core Version:    0.7.0.1
 */