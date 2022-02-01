package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class az
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eRQ = "labelId".hashCode();
  private static final int eRR = "contactName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eRO;
  private boolean eRP;
  public String field_contactName;
  public String field_labelId;
  
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
      if (eRQ != k) {
        break label60;
      }
      this.field_labelId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eRR == k) {
        this.field_contactName = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eRO) {
      localContentValues.put("labelId", this.field_labelId);
    }
    if (this.eRP) {
      localContentValues.put("contactName", this.field_contactName);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.az
 * JD-Core Version:    0.7.0.1
 */