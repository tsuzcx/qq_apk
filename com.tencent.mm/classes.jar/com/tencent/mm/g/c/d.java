package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class d
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eka = "expId".hashCode();
  private static final int ekb = "sequence".hashCode();
  private static final int ekc = "prioritylevel".hashCode();
  private static final int ekd = "startTime".hashCode();
  private static final int eke = "endTime".hashCode();
  private static final int ekk = "layerId".hashCode();
  private static final int ekl = "business".hashCode();
  private static final int ekm = "needReport".hashCode();
  private static final int ekn = "rawXML".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ejT = true;
  private boolean ejU = true;
  private boolean ejV = true;
  private boolean ejW = true;
  private boolean ejX = true;
  private boolean ekg = true;
  private boolean ekh = true;
  private boolean eki = true;
  private boolean ekj = true;
  public String field_business;
  public long field_endTime;
  public String field_expId;
  public String field_layerId;
  public boolean field_needReport;
  public int field_prioritylevel;
  public String field_rawXML;
  public long field_sequence;
  public long field_startTime;
  
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
      if (ekk != k) {
        break label65;
      }
      this.field_layerId = paramCursor.getString(i);
      this.ekg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ekl == k)
      {
        this.field_business = paramCursor.getString(i);
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
        if (ekm == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needReport = bool;
            break;
          }
        }
        if (ekn == k) {
          this.field_rawXML = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ekg) {
      localContentValues.put("layerId", this.field_layerId);
    }
    if (this.ekh) {
      localContentValues.put("business", this.field_business);
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
    if (this.eki) {
      localContentValues.put("needReport", Boolean.valueOf(this.field_needReport));
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.ekj) {
      localContentValues.put("rawXML", this.field_rawXML);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.d
 * JD-Core Version:    0.7.0.1
 */