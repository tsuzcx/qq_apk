package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cv
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJL = "championUrl".hashCode();
  private static final int eJM = "championMotto".hashCode();
  private static final int eme = "username".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eJJ = true;
  private boolean eJK = true;
  private boolean emb = true;
  public String field_championMotto;
  public String field_championUrl;
  public String field_username;
  
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
      if (eme != k) {
        break label60;
      }
      this.field_username = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eJL == k) {
        this.field_championUrl = paramCursor.getString(i);
      } else if (eJM == k) {
        this.field_championMotto = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eJJ) {
      localContentValues.put("championUrl", this.field_championUrl);
    }
    if (this.eJK) {
      localContentValues.put("championMotto", this.field_championMotto);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cv
 * JD-Core Version:    0.7.0.1
 */