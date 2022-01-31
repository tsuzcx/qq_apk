package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cd
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dBr = "reqType".hashCode();
  private static final int dBs = "cache".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dBp = true;
  private boolean dBq = true;
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
      if (dBr != k) {
        break label65;
      }
      this.field_reqType = paramCursor.getString(i);
      this.dBp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dBs == k) {
        this.field_cache = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dBp) {
      localContentValues.put("reqType", this.field_reqType);
    }
    if (this.dBq) {
      localContentValues.put("cache", this.field_cache);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.cd
 * JD-Core Version:    0.7.0.1
 */