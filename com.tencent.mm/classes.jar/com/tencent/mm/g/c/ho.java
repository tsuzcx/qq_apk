package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ho
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fPE = "timeStamp".hashCode();
  private static final int flH;
  private static final int flc = "recordId".hashCode();
  private static final int fne;
  private static final int ghu = "link".hashCode();
  private static final int ghv;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fPy = true;
  public String field_imgUrl;
  public String field_link;
  public String field_recordId;
  public String field_source;
  public long field_timeStamp;
  public String field_title;
  private boolean fkY = true;
  private boolean flC = true;
  private boolean fnb = true;
  private boolean ghs = true;
  private boolean ght = true;
  
  static
  {
    fne = "title".hashCode();
    flH = "source".hashCode();
    ghv = "imgUrl".hashCode();
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
      if (flc != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getString(i);
      this.fkY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ghu == k) {
        this.field_link = paramCursor.getString(i);
      } else if (fne == k) {
        this.field_title = paramCursor.getString(i);
      } else if (flH == k) {
        this.field_source = paramCursor.getString(i);
      } else if (ghv == k) {
        this.field_imgUrl = paramCursor.getString(i);
      } else if (fPE == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fkY) {
      localContentValues.put("recordId", this.field_recordId);
    }
    if (this.ghs) {
      localContentValues.put("link", this.field_link);
    }
    if (this.fnb) {
      localContentValues.put("title", this.field_title);
    }
    if (this.flC) {
      localContentValues.put("source", this.field_source);
    }
    if (this.ght) {
      localContentValues.put("imgUrl", this.field_imgUrl);
    }
    if (this.fPy) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ho
 * JD-Core Version:    0.7.0.1
 */