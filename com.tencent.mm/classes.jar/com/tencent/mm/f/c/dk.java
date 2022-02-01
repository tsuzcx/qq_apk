package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class dk
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "GetEmotionListCache", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("GetEmotionListCache");
  public static final Column iaL = new Column("reqtype", "string", "GetEmotionListCache", "");
  public static final Column iaM = new Column("cache", "byte[]", "GetEmotionListCache", "");
  private static final int iaP = "reqType".hashCode();
  private static final int iaQ = "cache".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public byte[] field_cache;
  public String field_reqType;
  private boolean iaN = true;
  private boolean iaO = true;
  
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
      if (iaP != k) {
        break label65;
      }
      this.field_reqType = paramCursor.getString(i);
      this.iaN = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iaQ == k) {
        this.field_cache = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iaN) {
      localContentValues.put("reqType", this.field_reqType);
    }
    if (this.iaO) {
      localContentValues.put("cache", this.field_cache);
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
    return "GetEmotionListCache";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.dk
 * JD-Core Version:    0.7.0.1
 */