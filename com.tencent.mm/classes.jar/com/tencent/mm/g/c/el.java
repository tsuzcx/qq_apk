package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class el
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eVD = "msgContentXml".hashCode();
  private static final int elP = "msgId".hashCode();
  private static final int eug = "isRead".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eVC = true;
  private boolean elL = true;
  private boolean etS = true;
  public String field_isRead;
  public String field_msgContentXml;
  public String field_msgId;
  
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
      if (elP != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getString(i);
      this.elL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eVD == k) {
        this.field_msgContentXml = paramCursor.getString(i);
      } else if (eug == k) {
        this.field_isRead = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.elL) {
      localContentValues.put("msgId", this.field_msgId);
    }
    if (this.eVC) {
      localContentValues.put("msgContentXml", this.field_msgContentXml);
    }
    if (this.etS) {
      localContentValues.put("isRead", this.field_isRead);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.el
 * JD-Core Version:    0.7.0.1
 */