package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class d
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDl = "expId".hashCode();
  private static final int eDm = "sequence".hashCode();
  private static final int eDn = "prioritylevel".hashCode();
  private static final int eDo = "startTime".hashCode();
  private static final int eDp = "endTime".hashCode();
  private static final int eDv = "layerId".hashCode();
  private static final int eDw = "business".hashCode();
  private static final int eDx = "needReport".hashCode();
  private static final int eDy = "rawXML".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDe = true;
  private boolean eDf = true;
  private boolean eDg = true;
  private boolean eDh = true;
  private boolean eDi = true;
  private boolean eDr = true;
  private boolean eDs = true;
  private boolean eDt = true;
  private boolean eDu = true;
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
      if (eDv != k) {
        break label65;
      }
      this.field_layerId = paramCursor.getString(i);
      this.eDr = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eDw == k)
      {
        this.field_business = paramCursor.getString(i);
      }
      else if (eDl == k)
      {
        this.field_expId = paramCursor.getString(i);
      }
      else if (eDm == k)
      {
        this.field_sequence = paramCursor.getLong(i);
      }
      else if (eDn == k)
      {
        this.field_prioritylevel = paramCursor.getInt(i);
      }
      else if (eDo == k)
      {
        this.field_startTime = paramCursor.getLong(i);
      }
      else if (eDp == k)
      {
        this.field_endTime = paramCursor.getLong(i);
      }
      else
      {
        if (eDx == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needReport = bool;
            break;
          }
        }
        if (eDy == k) {
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
    if (this.eDr) {
      localContentValues.put("layerId", this.field_layerId);
    }
    if (this.eDs) {
      localContentValues.put("business", this.field_business);
    }
    if (this.eDe) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.eDf) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.eDg) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.eDh) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.eDi) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.eDt) {
      localContentValues.put("needReport", Boolean.valueOf(this.field_needReport));
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.eDu) {
      localContentValues.put("rawXML", this.field_rawXML);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.d
 * JD-Core Version:    0.7.0.1
 */