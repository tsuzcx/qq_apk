package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ffP = "bulletin_scene".hashCode();
  private static final int ffQ = "bulletin_content".hashCode();
  private static final int ffR = "bulletin_url".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ffM = true;
  private boolean ffN = true;
  private boolean ffO = true;
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
      if (ffP != k) {
        break label65;
      }
      this.field_bulletin_scene = paramCursor.getString(i);
      this.ffM = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ffQ == k) {
        this.field_bulletin_content = paramCursor.getString(i);
      } else if (ffR == k) {
        this.field_bulletin_url = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ffM) {
      localContentValues.put("bulletin_scene", this.field_bulletin_scene);
    }
    if (this.ffN) {
      localContentValues.put("bulletin_content", this.field_bulletin_content);
    }
    if (this.ffO) {
      localContentValues.put("bulletin_url", this.field_bulletin_url);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gj
 * JD-Core Version:    0.7.0.1
 */