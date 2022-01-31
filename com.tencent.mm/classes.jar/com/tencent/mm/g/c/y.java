package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class y
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dfV = "startTime".hashCode();
  private static final int dfW = "endTime".hashCode();
  private static final int dkt = "sessionName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dfO = true;
  private boolean dfP = true;
  private boolean dkq = true;
  public long field_endTime;
  public String field_sessionName;
  public long field_startTime;
  
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
      if (dkt != k) {
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
      if (dfV == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (dfW == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_sessionName == null) {
      this.field_sessionName = "";
    }
    if (this.dkq) {
      localContentValues.put("sessionName", this.field_sessionName);
    }
    if (this.dfO) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.dfP) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.y
 * JD-Core Version:    0.7.0.1
 */