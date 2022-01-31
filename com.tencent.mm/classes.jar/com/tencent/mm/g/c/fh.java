package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fh
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dTe = "bulletin_scene".hashCode();
  private static final int dTf = "bulletin_content".hashCode();
  private static final int dTg = "bulletin_url".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dTb = true;
  private boolean dTc = true;
  private boolean dTd = true;
  public String field_bulletin_content;
  public String field_bulletin_scene;
  public String field_bulletin_url;
  
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
      if (dTe != k) {
        break label65;
      }
      this.field_bulletin_scene = paramCursor.getString(i);
      this.dTb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dTf == k) {
        this.field_bulletin_content = paramCursor.getString(i);
      } else if (dTg == k) {
        this.field_bulletin_url = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dTb) {
      localContentValues.put("bulletin_scene", this.field_bulletin_scene);
    }
    if (this.dTc) {
      localContentValues.put("bulletin_content", this.field_bulletin_content);
    }
    if (this.dTd) {
      localContentValues.put("bulletin_url", this.field_bulletin_url);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.fh
 * JD-Core Version:    0.7.0.1
 */