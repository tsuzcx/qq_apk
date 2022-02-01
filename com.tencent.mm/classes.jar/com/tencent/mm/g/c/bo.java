package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bo
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int content_HASHCODE = "content".hashCode();
  private static final int fwT = "productID".hashCode();
  private static final int fze = "lan".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcontent = true;
  public byte[] field_content;
  public String field_lan;
  public String field_productID;
  private boolean fwt = true;
  private boolean fzd = true;
  
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
      if (fwT != k) {
        break label65;
      }
      this.field_productID = paramCursor.getString(i);
      this.fwt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (content_HASHCODE == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (fze == k) {
        this.field_lan = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fwt) {
      localContentValues.put("productID", this.field_productID);
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_lan == null) {
      this.field_lan = "";
    }
    if (this.fzd) {
      localContentValues.put("lan", this.field_lan);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.bo
 * JD-Core Version:    0.7.0.1
 */