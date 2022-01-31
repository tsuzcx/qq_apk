package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dPO = "timeStamp".hashCode();
  private static final int dVB;
  private static final int dVC;
  private static final int diK;
  private static final int din = "recordId".hashCode();
  private static final int dkj;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dPI = true;
  private boolean dVA = true;
  private boolean dVz = true;
  private boolean diH = true;
  private boolean dik = true;
  private boolean dkg = true;
  public String field_imgUrl;
  public String field_link;
  public String field_recordId;
  public String field_source;
  public long field_timeStamp;
  public String field_title;
  
  static
  {
    dVB = "link".hashCode();
    dkj = "title".hashCode();
    diK = "source".hashCode();
    dVC = "imgUrl".hashCode();
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
      if (din != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getString(i);
      this.dik = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dVB == k) {
        this.field_link = paramCursor.getString(i);
      } else if (dkj == k) {
        this.field_title = paramCursor.getString(i);
      } else if (diK == k) {
        this.field_source = paramCursor.getString(i);
      } else if (dVC == k) {
        this.field_imgUrl = paramCursor.getString(i);
      } else if (dPO == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dik) {
      localContentValues.put("recordId", this.field_recordId);
    }
    if (this.dVz) {
      localContentValues.put("link", this.field_link);
    }
    if (this.dkg) {
      localContentValues.put("title", this.field_title);
    }
    if (this.diH) {
      localContentValues.put("source", this.field_source);
    }
    if (this.dVA) {
      localContentValues.put("imgUrl", this.field_imgUrl);
    }
    if (this.dPI) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.fq
 * JD-Core Version:    0.7.0.1
 */