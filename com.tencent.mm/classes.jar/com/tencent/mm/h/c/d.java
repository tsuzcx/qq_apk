package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class d
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crA = "prioritylevel".hashCode();
  private static final int crB = "startTime".hashCode();
  private static final int crC = "endTime".hashCode();
  private static final int crI = "layerId".hashCode();
  private static final int crJ = "business".hashCode();
  private static final int crK = "needReport".hashCode();
  private static final int crL = "rawXML".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int cry = "expId".hashCode();
  private static final int crz = "sequence".hashCode();
  private boolean crE = true;
  private boolean crF = true;
  private boolean crG = true;
  private boolean crH = true;
  private boolean crq = true;
  private boolean crr = true;
  private boolean crs = true;
  private boolean crt = true;
  private boolean cru = true;
  public String field_business;
  public long field_endTime;
  public String field_expId;
  public String field_layerId;
  public boolean field_needReport;
  public int field_prioritylevel;
  public String field_rawXML;
  public long field_sequence;
  public long field_startTime;
  
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
      if (crI != k) {
        break label65;
      }
      this.field_layerId = paramCursor.getString(i);
      this.crE = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (crJ == k)
      {
        this.field_business = paramCursor.getString(i);
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
        if (crK == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needReport = bool;
            break;
          }
        }
        if (crL == k) {
          this.field_rawXML = paramCursor.getString(i);
        } else if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.crE) {
      localContentValues.put("layerId", this.field_layerId);
    }
    if (this.crF) {
      localContentValues.put("business", this.field_business);
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
    if (this.crG) {
      localContentValues.put("needReport", Boolean.valueOf(this.field_needReport));
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.crH) {
      localContentValues.put("rawXML", this.field_rawXML);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.d
 * JD-Core Version:    0.7.0.1
 */