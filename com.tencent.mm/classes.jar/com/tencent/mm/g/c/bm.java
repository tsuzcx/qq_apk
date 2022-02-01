package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bm
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFV = "content".hashCode();
  private static final int eVx = "designerIDAndType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFy = true;
  private boolean eVw = true;
  public byte[] field_content;
  public String field_designerIDAndType;
  
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
      if (eVx != k) {
        break label65;
      }
      this.field_designerIDAndType = paramCursor.getString(i);
      this.eVw = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eFV == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eVw) {
      localContentValues.put("designerIDAndType", this.field_designerIDAndType);
    }
    if (this.eFy) {
      localContentValues.put("content", this.field_content);
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