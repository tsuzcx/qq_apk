package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ap
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int createTime_HASHCODE = "createTime".hashCode();
  private static final int frf = "canvasId".hashCode();
  private static final int frg = "canvasXml".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  public long field_canvasId;
  public String field_canvasXml;
  public long field_createTime;
  private boolean frd = true;
  private boolean fre = true;
  
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
      if (frf != k) {
        break label65;
      }
      this.field_canvasId = paramCursor.getLong(i);
      this.frd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (frg == k) {
        this.field_canvasXml = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.frd) {
      localContentValues.put("canvasId", Long.valueOf(this.field_canvasId));
    }
    if (this.fre) {
      localContentValues.put("canvasXml", this.field_canvasXml);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ap
 * JD-Core Version:    0.7.0.1
 */