package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gs
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eQG = "timeStamp".hashCode();
  private static final int eoK = "recordId".hashCode();
  private static final int epn;
  private static final int eqK;
  private static final int fio = "link".hashCode();
  private static final int fip;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eQA = true;
  private boolean eoI = true;
  private boolean epi = true;
  private boolean eqH = true;
  public String field_imgUrl;
  public String field_link;
  public String field_recordId;
  public String field_source;
  public long field_timeStamp;
  public String field_title;
  private boolean fim = true;
  private boolean fin = true;
  
  static
  {
    eqK = "title".hashCode();
    epn = "source".hashCode();
    fip = "imgUrl".hashCode();
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
      if (eoK != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getString(i);
      this.eoI = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fio == k) {
        this.field_link = paramCursor.getString(i);
      } else if (eqK == k) {
        this.field_title = paramCursor.getString(i);
      } else if (epn == k) {
        this.field_source = paramCursor.getString(i);
      } else if (fip == k) {
        this.field_imgUrl = paramCursor.getString(i);
      } else if (eQG == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eoI) {
      localContentValues.put("recordId", this.field_recordId);
    }
    if (this.fim) {
      localContentValues.put("link", this.field_link);
    }
    if (this.eqH) {
      localContentValues.put("title", this.field_title);
    }
    if (this.epi) {
      localContentValues.put("source", this.field_source);
    }
    if (this.fin) {
      localContentValues.put("imgUrl", this.field_imgUrl);
    }
    if (this.eQA) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gs
 * JD-Core Version:    0.7.0.1
 */