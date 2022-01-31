package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class k
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crQ = "key".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int crx = "value".hashCode();
  private boolean crM = true;
  private boolean crp = true;
  public String field_key;
  public String field_value;
  
  public final void d(Cursor paramCursor)
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
      if (crQ != k) {
        break label65;
      }
      this.field_key = paramCursor.getString(i);
      this.crM = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (crx == k) {
        this.field_value = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.crM) {
      localContentValues.put("key", this.field_key);
    }
    if (this.crp) {
      localContentValues.put("value", this.field_value);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.k
 * JD-Core Version:    0.7.0.1
 */