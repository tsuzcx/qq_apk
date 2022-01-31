package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class be
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dgT = "content".hashCode();
  private static final int duU = "designerIDAndType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dgw = true;
  private boolean duT = true;
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
      if (duU != k) {
        break label65;
      }
      this.field_designerIDAndType = paramCursor.getString(i);
      this.duT = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dgT == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.duT) {
      localContentValues.put("designerIDAndType", this.field_designerIDAndType);
    }
    if (this.dgw) {
      localContentValues.put("content", this.field_content);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.c.be
 * JD-Core Version:    0.7.0.1
 */