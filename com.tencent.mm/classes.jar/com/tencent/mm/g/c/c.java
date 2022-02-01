package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class c
  extends com.tencent.mm.sdk.e.c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eET = "abtestkey".hashCode();
  private static final int eEU = "expId".hashCode();
  private static final int eEV = "sequence".hashCode();
  private static final int eEW = "prioritylevel".hashCode();
  private static final int eEX = "startTime".hashCode();
  private static final int eEY = "endTime".hashCode();
  private static final int eEZ = "noReport".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE = "value".hashCode();
  private boolean __hadSetvalue = true;
  private boolean eEM = true;
  private boolean eEN = true;
  private boolean eEO = true;
  private boolean eEP = true;
  private boolean eEQ = true;
  private boolean eER = true;
  private boolean eES = true;
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
      if (eET != k) {
        break label65;
      }
      this.field_abtestkey = paramCursor.getString(i);
      this.eEM = true;
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
      else if (eEU == k)
      {
        this.field_expId = paramCursor.getString(i);
      }
      else if (eEV == k)
      {
        this.field_sequence = paramCursor.getLong(i);
      }
      else if (eEW == k)
      {
        this.field_prioritylevel = paramCursor.getInt(i);
      }
      else if (eEX == k)
      {
        this.field_startTime = paramCursor.getLong(i);
      }
      else if (eEY == k)
      {
        this.field_endTime = paramCursor.getLong(i);
      }
      else
      {
        if (eEZ == k)
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
    if (this.eEM) {
      localContentValues.put("abtestkey", this.field_abtestkey);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.eEN) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.eEO) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.eEP) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.eEQ) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.eER) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.eES) {
      localContentValues.put("noReport", Boolean.valueOf(this.field_noReport));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.c
 * JD-Core Version:    0.7.0.1
 */