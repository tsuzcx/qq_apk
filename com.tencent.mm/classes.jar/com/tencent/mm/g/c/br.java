package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class br
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eVP = "exptId".hashCode();
  private static final int eVV = "exptKey".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eVK = true;
  private boolean eVU = true;
  public int field_exptId;
  public String field_exptKey;
  
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
      if (eVV != k) {
        break label65;
      }
      this.field_exptKey = paramCursor.getString(i);
      this.eVU = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eVP == k) {
        this.field_exptId = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eVU) {
      localContentValues.put("exptKey", this.field_exptKey);
    }
    if (this.eVK) {
      localContentValues.put("exptId", Integer.valueOf(this.field_exptId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.br
 * JD-Core Version:    0.7.0.1
 */