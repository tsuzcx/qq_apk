package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bk
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int elb = "content".hashCode();
  private static final int exK = "productID".hashCode();
  private static final int ezW = "lan".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ekE = true;
  private boolean exk = true;
  private boolean ezV = true;
  public byte[] field_content;
  public String field_lan;
  public String field_productID;
  
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
      if (exK != k) {
        break label65;
      }
      this.field_productID = paramCursor.getString(i);
      this.exk = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (elb == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (ezW == k) {
        this.field_lan = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.exk) {
      localContentValues.put("productID", this.field_productID);
    }
    if (this.ekE) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_lan == null) {
      this.field_lan = "";
    }
    if (this.ezV) {
      localContentValues.put("lan", this.field_lan);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bk
 * JD-Core Version:    0.7.0.1
 */