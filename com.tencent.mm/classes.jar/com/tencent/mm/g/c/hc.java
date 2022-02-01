package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hc
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFR = "recordId".hashCode();
  private static final int eGw = "source".hashCode();
  private static final int eHT;
  private static final int fAw = "link".hashCode();
  private static final int fAx = "imgUrl".hashCode();
  private static final int fjd = "timeStamp".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFN = true;
  private boolean eGr = true;
  private boolean eHQ = true;
  private boolean fAu = true;
  private boolean fAv = true;
  private boolean fiX = true;
  public String field_imgUrl;
  public String field_link;
  public String field_recordId;
  public String field_source;
  public long field_timeStamp;
  public String field_title;
  
  static
  {
    eHT = "title".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (eFR != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getString(i);
      this.eFN = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fAw == k) {
        this.field_link = paramCursor.getString(i);
      } else if (eHT == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eGw == k) {
        this.field_source = paramCursor.getString(i);
      } else if (fAx == k) {
        this.field_imgUrl = paramCursor.getString(i);
      } else if (fjd == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFN) {
      localContentValues.put("recordId", this.field_recordId);
    }
    if (this.fAu) {
      localContentValues.put("link", this.field_link);
    }
    if (this.eHQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eGr) {
      localContentValues.put("source", this.field_source);
    }
    if (this.fAv) {
      localContentValues.put("imgUrl", this.field_imgUrl);
    }
    if (this.fiX) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hc
 * JD-Core Version:    0.7.0.1
 */