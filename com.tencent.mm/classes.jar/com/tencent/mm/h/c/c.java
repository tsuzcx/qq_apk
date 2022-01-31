package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class c
  extends com.tencent.mm.sdk.e.c
{
  public static final String[] cqY = new String[0];
  private static final int crA = "prioritylevel".hashCode();
  private static final int crB = "startTime".hashCode();
  private static final int crC = "endTime".hashCode();
  private static final int crD = "noReport".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int crw = "abtestkey".hashCode();
  private static final int crx = "value".hashCode();
  private static final int cry = "expId".hashCode();
  private static final int crz = "sequence".hashCode();
  private boolean cro = true;
  private boolean crp = true;
  private boolean crq = true;
  private boolean crr = true;
  private boolean crs = true;
  private boolean crt = true;
  private boolean cru = true;
  private boolean crv = true;
  public String field_abtestkey;
  public long field_endTime;
  public String field_expId;
  public boolean field_noReport;
  public int field_prioritylevel;
  public long field_sequence;
  public long field_startTime;
  public String field_value;
  
  public final void d(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (crw != k) {
        break label65;
      }
      this.field_abtestkey = paramCursor.getString(i);
      this.cro = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (crx == k)
      {
        this.field_value = paramCursor.getString(i);
      }
      else if (cry == k)
      {
        this.field_expId = paramCursor.getString(i);
      }
      else if (crz == k)
      {
        this.field_sequence = paramCursor.getLong(i);
      }
      else if (crA == k)
      {
        this.field_prioritylevel = paramCursor.getInt(i);
      }
      else if (crB == k)
      {
        this.field_startTime = paramCursor.getLong(i);
      }
      else if (crC == k)
      {
        this.field_endTime = paramCursor.getLong(i);
      }
      else
      {
        if (crD == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_noReport = bool;
            break;
          }
        }
        if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cro) {
      localContentValues.put("abtestkey", this.field_abtestkey);
    }
    if (this.crp) {
      localContentValues.put("value", this.field_value);
    }
    if (this.crq) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.crr) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.crs) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.crt) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.cru) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.crv) {
      localContentValues.put("noReport", Boolean.valueOf(this.field_noReport));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.c
 * JD-Core Version:    0.7.0.1
 */