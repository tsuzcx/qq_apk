package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ik
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WxaJsApiPluginInfo");
  public static final Column hnz;
  private static final int hoh = "appId".hashCode();
  public static final Column iNw;
  private static final int iNy = "permissionProtoBlob".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public byte[] field_permissionProtoBlob;
  private boolean hnQ = true;
  private boolean iNx = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WxaJsApiPluginInfo", "");
    hnz = new Column("appid", "string", "WxaJsApiPluginInfo", "");
    iNw = new Column("permissionprotoblob", "byte[]", "WxaJsApiPluginInfo", "");
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
      if (iNy == k) {
        this.field_permissionProtoBlob = paramCursor.getBlob(i);
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
    if (this.iNx) {
      localContentValues.put("permissionProtoBlob", this.field_permissionProtoBlob);
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
    return "WxaJsApiPluginInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ik
 * JD-Core Version:    0.7.0.1
 */