package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gc
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS snsreport_kv_logtime ON SnsReportKv(logtime)" };
  private static final int eGJ;
  private static final int fvF = "logtime".hashCode();
  private static final int fvG;
  private static final int fvH;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE;
  private boolean __hadSetvalue = true;
  private boolean eGs = true;
  public int field_errorcount;
  public int field_logsize;
  public long field_logtime;
  public int field_offset;
  public byte[] field_value;
  private boolean fvC = true;
  private boolean fvD = true;
  private boolean fvE = true;
  
  static
  {
    eGJ = "offset".hashCode();
    fvG = "logsize".hashCode();
    fvH = "errorcount".hashCode();
    value_HASHCODE = "value".hashCode();
  }
  
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
      if (fvF != k) {
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
      if (eGJ == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (fvG == k) {
        this.field_logsize = paramCursor.getInt(i);
      } else if (fvH == k) {
        this.field_errorcount = paramCursor.getInt(i);
      } else if (value_HASHCODE == k) {
        this.field_value = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fvC) {
      localContentValues.put("logtime", Long.valueOf(this.field_logtime));
    }
    if (this.eGs) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.fvD) {
      localContentValues.put("logsize", Integer.valueOf(this.field_logsize));
    }
    if (this.fvE) {
      localContentValues.put("errorcount", Integer.valueOf(this.field_errorcount));
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gc
 * JD-Core Version:    0.7.0.1
 */