package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bm
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eAf = "productID".hashCode();
  private static final int eCq = "lan".hashCode();
  private static final int eng = "content".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCp = true;
  private boolean emI = true;
  private boolean ezF = true;
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
      if (eAf != k) {
        break label65;
      }
      this.field_productID = paramCursor.getString(i);
      this.ezF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eng == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (eCq == k) {
        this.field_lan = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ezF) {
      localContentValues.put("productID", this.field_productID);
    }
    if (this.emI) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_lan == null) {
      this.field_lan = "";
    }
    if (this.eCp) {
      localContentValues.put("lan", this.field_lan);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bm
 * JD-Core Version:    0.7.0.1
 */