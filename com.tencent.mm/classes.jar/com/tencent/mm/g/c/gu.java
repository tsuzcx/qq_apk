package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gu
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fzX = "bulletin_scene".hashCode();
  private static final int fzY = "bulletin_content".hashCode();
  private static final int fzZ = "bulletin_url".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_bulletin_content;
  public String field_bulletin_scene;
  public String field_bulletin_url;
  private boolean fzU = true;
  private boolean fzV = true;
  private boolean fzW = true;
  
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
      if (fzX != k) {
        break label65;
      }
      this.field_bulletin_scene = paramCursor.getString(i);
      this.fzU = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fzY == k) {
        this.field_bulletin_content = paramCursor.getString(i);
      } else if (fzZ == k) {
        this.field_bulletin_url = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fzU) {
      localContentValues.put("bulletin_scene", this.field_bulletin_scene);
    }
    if (this.fzV) {
      localContentValues.put("bulletin_content", this.field_bulletin_content);
    }
    if (this.fzW) {
      localContentValues.put("bulletin_url", this.field_bulletin_url);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gu
 * JD-Core Version:    0.7.0.1
 */