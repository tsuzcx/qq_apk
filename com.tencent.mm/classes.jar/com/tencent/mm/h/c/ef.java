package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ef
  extends c
{
  private static final int cYS;
  private static final int cYT;
  private static final int cYU;
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS snsreport_kv_logtime ON SnsReportKv(logtime)" };
  private static final int crh = "rowid".hashCode();
  private static final int crx;
  private static final int ctr;
  private boolean cYP = true;
  private boolean cYQ = true;
  private boolean cYR = true;
  private boolean crp = true;
  private boolean cta = true;
  public int field_errorcount;
  public int field_logsize;
  public long field_logtime;
  public int field_offset;
  public byte[] field_value;
  
  static
  {
    cYS = "logtime".hashCode();
    ctr = "offset".hashCode();
    cYT = "logsize".hashCode();
    cYU = "errorcount".hashCode();
    crx = "value".hashCode();
  }
  
  public void d(Cursor paramCursor)
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
      if (cYS != k) {
        break label60;
      }
      this.field_logtime = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (ctr == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (cYT == k) {
        this.field_logsize = paramCursor.getInt(i);
      } else if (cYU == k) {
        this.field_errorcount = paramCursor.getInt(i);
      } else if (crx == k) {
        this.field_value = paramCursor.getBlob(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cYP) {
      localContentValues.put("logtime", Long.valueOf(this.field_logtime));
    }
    if (this.cta) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.cYQ) {
      localContentValues.put("logsize", Integer.valueOf(this.field_logsize));
    }
    if (this.cYR) {
      localContentValues.put("errorcount", Integer.valueOf(this.field_errorcount));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.c.ef
 * JD-Core Version:    0.7.0.1
 */