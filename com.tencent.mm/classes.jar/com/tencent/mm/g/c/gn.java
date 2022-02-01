package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gn
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEf = "createTime".hashCode();
  private static final int eLN = "canvasId".hashCode();
  private static final int eLO = "canvasXml".hashCode();
  private static final int fvr = "canvasExt".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDI = true;
  private boolean eLL = true;
  private boolean eLM = true;
  public String field_canvasExt;
  public String field_canvasId;
  public String field_canvasXml;
  public long field_createTime;
  private boolean fvq = true;
  
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
      if (eLN != k) {
        break label65;
      }
      this.field_canvasId = paramCursor.getString(i);
      this.eLL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eLO == k) {
        this.field_canvasXml = paramCursor.getString(i);
      } else if (eEf == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (fvr == k) {
        this.field_canvasExt = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eLL) {
      localContentValues.put("canvasId", this.field_canvasId);
    }
    if (this.eLM) {
      localContentValues.put("canvasXml", this.field_canvasXml);
    }
    if (this.eDI) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fvq) {
      localContentValues.put("canvasExt", this.field_canvasExt);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.gn
 * JD-Core Version:    0.7.0.1
 */