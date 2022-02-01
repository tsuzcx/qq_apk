package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dq
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fMp = "appusername".hashCode();
  private static final int fMs = "score".hashCode();
  private static final int fne = "title".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fMm;
  private boolean fMr;
  public String field_appusername;
  public int field_score;
  public String field_title;
  private boolean fnb;
  
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
      if (fMp != k) {
        break label60;
      }
      this.field_appusername = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (fne == k) {
        this.field_title = paramCursor.getString(i);
      } else if (fMs == k) {
        this.field_score = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fMm) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.fnb) {
      localContentValues.put("title", this.field_title);
    }
    if (this.fMr) {
      localContentValues.put("score", Integer.valueOf(this.field_score));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dq
 * JD-Core Version:    0.7.0.1
 */