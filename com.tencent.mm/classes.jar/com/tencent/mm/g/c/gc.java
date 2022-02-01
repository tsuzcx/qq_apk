package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gc
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ejL = "msgId".hashCode();
  private static final int elb = "content".hashCode();
  private static final int faT = "cmsgId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ejH = true;
  private boolean ekE = true;
  private boolean faS = true;
  public String field_cmsgId;
  public String field_content;
  public long field_msgId;
  
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
      if (ejL != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.ejH = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (faT == k) {
        this.field_cmsgId = paramCursor.getString(i);
      } else if (elb == k) {
        this.field_content = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ejH) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.faS) {
      localContentValues.put("cmsgId", this.field_cmsgId);
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.ekE) {
      localContentValues.put("content", this.field_content);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gc
 * JD-Core Version:    0.7.0.1
 */