package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class c
  extends com.tencent.mm.sdk.e.c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int emd = "abtestkey".hashCode();
  private static final int eme = "expId".hashCode();
  private static final int emf = "sequence".hashCode();
  private static final int emg = "prioritylevel".hashCode();
  private static final int emh = "startTime".hashCode();
  private static final int emi = "endTime".hashCode();
  private static final int emj = "noReport".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE = "value".hashCode();
  private boolean __hadSetvalue = true;
  private boolean elW = true;
  private boolean elX = true;
  private boolean elY = true;
  private boolean elZ = true;
  private boolean ema = true;
  private boolean emb = true;
  private boolean emc = true;
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
      if (emd != k) {
        break label65;
      }
      this.field_abtestkey = paramCursor.getString(i);
      this.elW = true;
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
      else if (eme == k)
      {
        this.field_expId = paramCursor.getString(i);
      }
      else if (emf == k)
      {
        this.field_sequence = paramCursor.getLong(i);
      }
      else if (emg == k)
      {
        this.field_prioritylevel = paramCursor.getInt(i);
      }
      else if (emh == k)
      {
        this.field_startTime = paramCursor.getLong(i);
      }
      else if (emi == k)
      {
        this.field_endTime = paramCursor.getLong(i);
      }
      else
      {
        if (emj == k)
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
    if (this.elW) {
      localContentValues.put("abtestkey", this.field_abtestkey);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.elX) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.elY) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.elZ) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.ema) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.emb) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.emc) {
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