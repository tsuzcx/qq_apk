package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ai
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dgM = "createTime".hashCode();
  private static final int dnv = "canvasId".hashCode();
  private static final int dnw = "canvasXml".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dgp = true;
  private boolean dnt = true;
  private boolean dnu = true;
  public long field_canvasId;
  public String field_canvasXml;
  public long field_createTime;
  
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
      if (dnv != k) {
        break label65;
      }
      this.field_canvasId = paramCursor.getLong(i);
      this.dnt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dnw == k) {
        this.field_canvasXml = paramCursor.getString(i);
      } else if (dgM == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dnt) {
      localContentValues.put("canvasId", Long.valueOf(this.field_canvasId));
    }
    if (this.dnu) {
      localContentValues.put("canvasXml", this.field_canvasXml);
    }
    if (this.dgp) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.ai
 * JD-Core Version:    0.7.0.1
 */