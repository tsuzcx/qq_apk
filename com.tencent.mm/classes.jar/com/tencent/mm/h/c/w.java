package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class w
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crB = "startTime".hashCode();
  private static final int crC = "endTime".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int cwk = "sessionName".hashCode();
  private boolean crt = true;
  private boolean cru = true;
  private boolean cwh = true;
  public long field_endTime;
  public String field_sessionName;
  public long field_startTime;
  
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
      if (cwk != k) {
        break label60;
      }
      this.field_sessionName = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (crB == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (crC == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_sessionName == null) {
      this.field_sessionName = "";
    }
    if (this.cwh) {
      localContentValues.put("sessionName", this.field_sessionName);
    }
    if (this.crt) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.cru) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.w
 * JD-Core Version:    0.7.0.1
 */