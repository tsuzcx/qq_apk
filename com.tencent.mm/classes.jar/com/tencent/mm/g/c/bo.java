package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bo
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEm = "content".hashCode();
  private static final int eRD = "productID".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDP = true;
  private boolean eRd = true;
  public byte[] field_content;
  public String field_productID;
  
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
      if (eRD != k) {
        break label65;
      }
      this.field_productID = paramCursor.getString(i);
      this.eRd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eEm == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eRd) {
      localContentValues.put("productID", this.field_productID);
    }
    if (this.eDP) {
      localContentValues.put("content", this.field_content);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bo
 * JD-Core Version:    0.7.0.1
 */