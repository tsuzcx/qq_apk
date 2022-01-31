package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class d
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dfS = "expId".hashCode();
  private static final int dfT = "sequence".hashCode();
  private static final int dfU = "prioritylevel".hashCode();
  private static final int dfV = "startTime".hashCode();
  private static final int dfW = "endTime".hashCode();
  private static final int dgc = "layerId".hashCode();
  private static final int dgd = "business".hashCode();
  private static final int dge = "needReport".hashCode();
  private static final int dgf = "rawXML".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dfL = true;
  private boolean dfM = true;
  private boolean dfN = true;
  private boolean dfO = true;
  private boolean dfP = true;
  private boolean dfY = true;
  private boolean dfZ = true;
  private boolean dga = true;
  private boolean dgb = true;
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
      if (dgc != k) {
        break label65;
      }
      this.field_layerId = paramCursor.getString(i);
      this.dfY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dgd == k)
      {
        this.field_business = paramCursor.getString(i);
      }
      else if (dfS == k)
      {
        this.field_expId = paramCursor.getString(i);
      }
      else if (dfT == k)
      {
        this.field_sequence = paramCursor.getLong(i);
      }
      else if (dfU == k)
      {
        this.field_prioritylevel = paramCursor.getInt(i);
      }
      else if (dfV == k)
      {
        this.field_startTime = paramCursor.getLong(i);
      }
      else if (dfW == k)
      {
        this.field_endTime = paramCursor.getLong(i);
      }
      else
      {
        if (dge == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needReport = bool;
            break;
          }
        }
        if (dgf == k) {
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
    if (this.dfY) {
      localContentValues.put("layerId", this.field_layerId);
    }
    if (this.dfZ) {
      localContentValues.put("business", this.field_business);
    }
    if (this.dfL) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.dfM) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.dfN) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.dfO) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.dfP) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.dga) {
      localContentValues.put("needReport", Boolean.valueOf(this.field_needReport));
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.dgb) {
      localContentValues.put("rawXML", this.field_rawXML);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.d
 * JD-Core Version:    0.7.0.1
 */