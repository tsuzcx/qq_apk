package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dg
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fJV = "reqType".hashCode();
  private static final int fJW = "cache".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fJT = true;
  private boolean fJU = true;
  public byte[] field_cache;
  public String field_reqType;
  
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
      if (fJV != k) {
        break label65;
      }
      this.field_reqType = paramCursor.getString(i);
      this.fJT = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fJW == k) {
        this.field_cache = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fJT) {
      localContentValues.put("reqType", this.field_reqType);
    }
    if (this.fJU) {
      localContentValues.put("cache", this.field_cache);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dg
 * JD-Core Version:    0.7.0.1
 */