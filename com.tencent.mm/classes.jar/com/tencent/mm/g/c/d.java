package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class d
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEU = "expId".hashCode();
  private static final int eEV = "sequence".hashCode();
  private static final int eEW = "prioritylevel".hashCode();
  private static final int eEX = "startTime".hashCode();
  private static final int eEY = "endTime".hashCode();
  private static final int eFe = "layerId".hashCode();
  private static final int eFf = "business".hashCode();
  private static final int eFg = "needReport".hashCode();
  private static final int eFh = "rawXML".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEN = true;
  private boolean eEO = true;
  private boolean eEP = true;
  private boolean eEQ = true;
  private boolean eER = true;
  private boolean eFa = true;
  private boolean eFb = true;
  private boolean eFc = true;
  private boolean eFd = true;
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
      if (eFe != k) {
        break label65;
      }
      this.field_layerId = paramCursor.getString(i);
      this.eFa = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eFf == k)
      {
        this.field_business = paramCursor.getString(i);
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
        if (eFg == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needReport = bool;
            break;
          }
        }
        if (eFh == k) {
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
    if (this.eFa) {
      localContentValues.put("layerId", this.field_layerId);
    }
    if (this.eFb) {
      localContentValues.put("business", this.field_business);
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
    if (this.eFc) {
      localContentValues.put("needReport", Boolean.valueOf(this.field_needReport));
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.eFd) {
      localContentValues.put("rawXML", this.field_rawXML);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.d
 * JD-Core Version:    0.7.0.1
 */