package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class de
  extends c
{
  private static final int cKL = "retryCount".hashCode();
  private static final int cTA;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private boolean cKs = true;
  private boolean cTz = true;
  public String field_cardUserId;
  public int field_retryCount;
  
  static
  {
    cTA = "cardUserId".hashCode();
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
      if (cTA != k) {
        break label65;
      }
      this.field_cardUserId = paramCursor.getString(i);
      this.cTz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cKL == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cTz) {
      localContentValues.put("cardUserId", this.field_cardUserId);
    }
    if (this.cKs) {
      localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.de
 * JD-Core Version:    0.7.0.1
 */