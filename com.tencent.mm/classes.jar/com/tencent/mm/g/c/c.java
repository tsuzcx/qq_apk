package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class c
  extends com.tencent.mm.sdk.e.c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ejZ = "abtestkey".hashCode();
  private static final int eka = "expId".hashCode();
  private static final int ekb = "sequence".hashCode();
  private static final int ekc = "prioritylevel".hashCode();
  private static final int ekd = "startTime".hashCode();
  private static final int eke = "endTime".hashCode();
  private static final int ekf = "noReport".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE = "value".hashCode();
  private boolean __hadSetvalue = true;
  private boolean ejS = true;
  private boolean ejT = true;
  private boolean ejU = true;
  private boolean ejV = true;
  private boolean ejW = true;
  private boolean ejX = true;
  private boolean ejY = true;
  public String field_abtestkey;
  public long field_endTime;
  public String field_expId;
  public boolean field_noReport;
  public int field_prioritylevel;
  public long field_sequence;
  public long field_startTime;
  public String field_value;
  
  public void convertFrom(Cursor paramCursor)
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
      if (ejZ != k) {
        break label65;
      }
      this.field_abtestkey = paramCursor.getString(i);
      this.ejS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (value_HASHCODE == k)
      {
        this.field_value = paramCursor.getString(i);
      }
      else if (eka == k)
      {
        this.field_expId = paramCursor.getString(i);
      }
      else if (ekb == k)
      {
        this.field_sequence = paramCursor.getLong(i);
      }
      else if (ekc == k)
      {
        this.field_prioritylevel = paramCursor.getInt(i);
      }
      else if (ekd == k)
      {
        this.field_startTime = paramCursor.getLong(i);
      }
      else if (eke == k)
      {
        this.field_endTime = paramCursor.getLong(i);
      }
      else
      {
        if (ekf == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_noReport = bool;
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ejS) {
      localContentValues.put("abtestkey", this.field_abtestkey);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.ejT) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.ejU) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.ejV) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.ejW) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.ejX) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.ejY) {
      localContentValues.put("noReport", Boolean.valueOf(this.field_noReport));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.c
 * JD-Core Version:    0.7.0.1
 */