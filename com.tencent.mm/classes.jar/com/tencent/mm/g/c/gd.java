package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gd
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int emY = "createTime".hashCode();
  private static final int euq = "canvasId".hashCode();
  private static final int eur = "canvasXml".hashCode();
  private static final int fdd = "canvasExt".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean emB = true;
  private boolean euo = true;
  private boolean eup = true;
  private boolean fdc = true;
  public String field_canvasExt;
  public String field_canvasId;
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
      if (euq != k) {
        break label65;
      }
      this.field_canvasId = paramCursor.getString(i);
      this.euo = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eur == k) {
        this.field_canvasXml = paramCursor.getString(i);
      } else if (emY == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (fdd == k) {
        this.field_canvasExt = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.euo) {
      localContentValues.put("canvasId", this.field_canvasId);
    }
    if (this.eup) {
      localContentValues.put("canvasXml", this.field_canvasXml);
    }
    if (this.emB) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fdc) {
      localContentValues.put("canvasExt", this.field_canvasExt);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gd
 * JD-Core Version:    0.7.0.1
 */