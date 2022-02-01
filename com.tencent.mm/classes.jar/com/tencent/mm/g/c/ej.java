package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ej
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGD = "retryCount".hashCode();
  private static final int eSv = "cardUserId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGl = true;
  private boolean eSu = true;
  public String field_cardUserId;
  public int field_retryCount;
  
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
      if (eSv != k) {
        break label65;
      }
      this.field_cardUserId = paramCursor.getString(i);
      this.eSu = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eGD == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eSu) {
      localContentValues.put("cardUserId", this.field_cardUserId);
    }
    if (this.eGl) {
      localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ej
 * JD-Core Version:    0.7.0.1
 */