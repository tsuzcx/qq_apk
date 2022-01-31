package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class by
  extends c
{
  private static final int cLB = "reqType".hashCode();
  private static final int cLC = "cache".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private boolean cLA = true;
  private boolean cLz = true;
  public byte[] field_cache;
  public String field_reqType;
  
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
      if (cLB != k) {
        break label65;
      }
      this.field_reqType = paramCursor.getString(i);
      this.cLz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cLC == k) {
        this.field_cache = paramCursor.getBlob(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cLz) {
      localContentValues.put("reqType", this.field_reqType);
    }
    if (this.cLA) {
      localContentValues.put("cache", this.field_cache);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.c.by
 * JD-Core Version:    0.7.0.1
 */