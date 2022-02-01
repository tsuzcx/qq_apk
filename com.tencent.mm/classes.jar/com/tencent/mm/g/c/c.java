package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class c
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fjt = "abtestkey".hashCode();
  private static final int fju = "expId".hashCode();
  private static final int fjv = "sequence".hashCode();
  private static final int fjw = "prioritylevel".hashCode();
  private static final int fjx = "startTime".hashCode();
  private static final int fjy = "endTime".hashCode();
  private static final int fjz = "noReport".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE = "value".hashCode();
  private boolean __hadSetvalue = true;
  public String field_abtestkey;
  public long field_endTime;
  public String field_expId;
  public boolean field_noReport;
  public int field_prioritylevel;
  public long field_sequence;
  public long field_startTime;
  public String field_value;
  private boolean fjm = true;
  private boolean fjn = true;
  private boolean fjo = true;
  private boolean fjp = true;
  private boolean fjq = true;
  private boolean fjr = true;
  private boolean fjs = true;
  
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
      if (fjt != k) {
        break label65;
      }
      this.field_abtestkey = paramCursor.getString(i);
      this.fjm = true;
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
        if (fjz == k)
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
    if (this.fjm) {
      localContentValues.put("abtestkey", this.field_abtestkey);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
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
    if (this.fjs) {
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