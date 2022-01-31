package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bh
  extends c
{
  private static final int cGG = "exptId".hashCode();
  private static final int cGK;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private boolean cGD = true;
  private boolean cGJ = true;
  public int field_exptId;
  public String field_exptKey;
  
  static
  {
    cGK = "exptKey".hashCode();
  }
  
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
      if (cGK != k) {
        break label65;
      }
      this.field_exptKey = paramCursor.getString(i);
      this.cGJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cGG == k) {
        this.field_exptId = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cGJ) {
      localContentValues.put("exptKey", this.field_exptKey);
    }
    if (this.cGD) {
      localContentValues.put("exptId", Integer.valueOf(this.field_exptId));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.bh
 * JD-Core Version:    0.7.0.1
 */