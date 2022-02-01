package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hd
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eHA = "recordId".hashCode();
  private static final int eIf = "source".hashCode();
  private static final int eJC;
  private static final int fCw = "link".hashCode();
  private static final int fCx = "imgUrl".hashCode();
  private static final int fla = "timeStamp".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eHw = true;
  private boolean eIa = true;
  private boolean eJz = true;
  private boolean fCu = true;
  private boolean fCv = true;
  public String field_imgUrl;
  public String field_link;
  public String field_recordId;
  public String field_source;
  public long field_timeStamp;
  public String field_title;
  private boolean fkU = true;
  
  static
  {
    eJC = "title".hashCode();
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
      if (eHA != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getString(i);
      this.eHw = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fCw == k) {
        this.field_link = paramCursor.getString(i);
      } else if (eJC == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eIf == k) {
        this.field_source = paramCursor.getString(i);
      } else if (fCx == k) {
        this.field_imgUrl = paramCursor.getString(i);
      } else if (fla == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eHw) {
      localContentValues.put("recordId", this.field_recordId);
    }
    if (this.fCu) {
      localContentValues.put("link", this.field_link);
    }
    if (this.eJz) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eIa) {
      localContentValues.put("source", this.field_source);
    }
    if (this.fCv) {
      localContentValues.put("imgUrl", this.field_imgUrl);
    }
    if (this.fkU) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hd
 * JD-Core Version:    0.7.0.1
 */