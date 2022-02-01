package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class d
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eme = "expId".hashCode();
  private static final int emf = "sequence".hashCode();
  private static final int emg = "prioritylevel".hashCode();
  private static final int emh = "startTime".hashCode();
  private static final int emi = "endTime".hashCode();
  private static final int emo = "layerId".hashCode();
  private static final int emp = "business".hashCode();
  private static final int emq = "needReport".hashCode();
  private static final int emr = "rawXML".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean elX = true;
  private boolean elY = true;
  private boolean elZ = true;
  private boolean ema = true;
  private boolean emb = true;
  private boolean emk = true;
  private boolean eml = true;
  private boolean emm = true;
  private boolean emn = true;
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
      if (emo != k) {
        break label65;
      }
      this.field_layerId = paramCursor.getString(i);
      this.emk = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (emp == k)
      {
        this.field_business = paramCursor.getString(i);
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
        if (emq == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needReport = bool;
            break;
          }
        }
        if (emr == k) {
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
    if (this.emk) {
      localContentValues.put("layerId", this.field_layerId);
    }
    if (this.eml) {
      localContentValues.put("business", this.field_business);
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
    if (this.emm) {
      localContentValues.put("needReport", Boolean.valueOf(this.field_needReport));
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.emn) {
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