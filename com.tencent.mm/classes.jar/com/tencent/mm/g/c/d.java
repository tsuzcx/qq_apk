package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class d
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fjE = "layerId".hashCode();
  private static final int fjF = "business".hashCode();
  private static final int fjG = "needReport".hashCode();
  private static final int fjH = "rawXML".hashCode();
  private static final int fju = "expId".hashCode();
  private static final int fjv = "sequence".hashCode();
  private static final int fjw = "prioritylevel".hashCode();
  private static final int fjx = "startTime".hashCode();
  private static final int fjy = "endTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_business;
  public long field_endTime;
  public String field_expId;
  public String field_layerId;
  public boolean field_needReport;
  public int field_prioritylevel;
  public String field_rawXML;
  public long field_sequence;
  public long field_startTime;
  private boolean fjA = true;
  private boolean fjB = true;
  private boolean fjC = true;
  private boolean fjD = true;
  private boolean fjn = true;
  private boolean fjo = true;
  private boolean fjp = true;
  private boolean fjq = true;
  private boolean fjr = true;
  
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
      if (fjE != k) {
        break label65;
      }
      this.field_layerId = paramCursor.getString(i);
      this.fjA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fjF == k)
      {
        this.field_business = paramCursor.getString(i);
      }
      else if (fju == k)
      {
        this.field_expId = paramCursor.getString(i);
      }
      else if (fjv == k)
      {
        this.field_sequence = paramCursor.getLong(i);
      }
      else if (fjw == k)
      {
        this.field_prioritylevel = paramCursor.getInt(i);
      }
      else if (fjx == k)
      {
        this.field_startTime = paramCursor.getLong(i);
      }
      else if (fjy == k)
      {
        this.field_endTime = paramCursor.getLong(i);
      }
      else
      {
        if (fjG == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needReport = bool;
            break;
          }
        }
        if (fjH == k) {
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
    if (this.fjA) {
      localContentValues.put("layerId", this.field_layerId);
    }
    if (this.fjB) {
      localContentValues.put("business", this.field_business);
    }
    if (this.fjn) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.fjo) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.fjp) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.fjq) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.fjr) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.fjC) {
      localContentValues.put("needReport", Boolean.valueOf(this.field_needReport));
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.fjD) {
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