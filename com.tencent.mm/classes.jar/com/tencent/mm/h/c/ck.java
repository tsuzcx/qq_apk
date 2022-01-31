package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ck
  extends c
{
  private static final int cNI = "countryCode".hashCode();
  private static final int cNJ = "callTimeCount".hashCode();
  private static final int cNK = "lastCallTime".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private boolean cNF = true;
  private boolean cNG = true;
  private boolean cNH = true;
  public long field_callTimeCount;
  public int field_countryCode;
  public long field_lastCallTime;
  
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
      if (cNI != k) {
        break label65;
      }
      this.field_countryCode = paramCursor.getInt(i);
      this.cNF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cNJ == k) {
        this.field_callTimeCount = paramCursor.getLong(i);
      } else if (cNK == k) {
        this.field_lastCallTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cNF) {
      localContentValues.put("countryCode", Integer.valueOf(this.field_countryCode));
    }
    if (this.cNG) {
      localContentValues.put("callTimeCount", Long.valueOf(this.field_callTimeCount));
    }
    if (this.cNH) {
      localContentValues.put("lastCallTime", Long.valueOf(this.field_lastCallTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.ck
 * JD-Core Version:    0.7.0.1
 */