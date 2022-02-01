package com.tencent.mm.plugin.lite.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class a
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ghx = "host".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private static final int yEW = "param".hashCode();
  private static final int yEX = "headerMap".hashCode();
  private static final int yEY = "paramMap".hashCode();
  private boolean __hadSetupdateTime = true;
  public String field_headerMap;
  public String field_host;
  public String field_param;
  public String field_paramMap;
  public long field_updateTime;
  private boolean ghw = true;
  private boolean yET = true;
  private boolean yEU = true;
  private boolean yEV = true;
  
  static
  {
    updateTime_HASHCODE = "updateTime".hashCode();
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
      if (ghx != k) {
        break label65;
      }
      this.field_host = paramCursor.getString(i);
      this.ghw = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (yEW == k) {
        this.field_param = paramCursor.getString(i);
      } else if (yEX == k) {
        this.field_headerMap = paramCursor.getString(i);
      } else if (yEY == k) {
        this.field_paramMap = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ghw) {
      localContentValues.put("host", this.field_host);
    }
    if (this.yET) {
      localContentValues.put("param", this.field_param);
    }
    if (this.yEU) {
      localContentValues.put("headerMap", this.field_headerMap);
    }
    if (this.yEV) {
      localContentValues.put("paramMap", this.field_paramMap);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.storage.a
 * JD-Core Version:    0.7.0.1
 */