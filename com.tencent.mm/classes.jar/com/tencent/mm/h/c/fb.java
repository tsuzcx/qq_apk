package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fb
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctW = "recordId".hashCode();
  private static final int cvZ;
  private static final int cwb;
  private static final int ddV;
  private static final int ddY = "link".hashCode();
  private static final int ddZ;
  private boolean ctT = true;
  private boolean cvV = true;
  private boolean cvX = true;
  private boolean ddT = true;
  private boolean ddW = true;
  private boolean ddX = true;
  public String field_imgUrl;
  public String field_link;
  public String field_recordId;
  public String field_source;
  public long field_timeStamp;
  public String field_title;
  
  static
  {
    cvZ = "title".hashCode();
    cwb = "source".hashCode();
    ddZ = "imgUrl".hashCode();
    ddV = "timeStamp".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (ctW != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getString(i);
      this.ctT = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ddY == k) {
        this.field_link = paramCursor.getString(i);
      } else if (cvZ == k) {
        this.field_title = paramCursor.getString(i);
      } else if (cwb == k) {
        this.field_source = paramCursor.getString(i);
      } else if (ddZ == k) {
        this.field_imgUrl = paramCursor.getString(i);
      } else if (ddV == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ctT) {
      localContentValues.put("recordId", this.field_recordId);
    }
    if (this.ddW) {
      localContentValues.put("link", this.field_link);
    }
    if (this.cvV) {
      localContentValues.put("title", this.field_title);
    }
    if (this.cvX) {
      localContentValues.put("source", this.field_source);
    }
    if (this.ddX) {
      localContentValues.put("imgUrl", this.field_imgUrl);
    }
    if (this.ddT) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.fb
 * JD-Core Version:    0.7.0.1
 */