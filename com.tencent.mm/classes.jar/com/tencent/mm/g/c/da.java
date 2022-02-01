package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class da
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ffs = "reqType".hashCode();
  private static final int fft = "cache".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ffq = true;
  private boolean ffr = true;
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
      if (ffs != k) {
        break label65;
      }
      this.field_reqType = paramCursor.getString(i);
      this.ffq = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fft == k) {
        this.field_cache = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ffq) {
      localContentValues.put("reqType", this.field_reqType);
    }
    if (this.ffr) {
      localContentValues.put("cache", this.field_cache);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.da
 * JD-Core Version:    0.7.0.1
 */