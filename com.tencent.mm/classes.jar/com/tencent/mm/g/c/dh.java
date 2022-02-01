package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dh
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFp = "username".hashCode();
  private static final int feZ = "championUrl".hashCode();
  private static final int ffa = "championMotto".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFm = true;
  private boolean feX = true;
  private boolean feY = true;
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
      if (eFp != k) {
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
      if (feZ == k) {
        this.field_championUrl = paramCursor.getString(i);
      } else if (ffa == k) {
        this.field_championMotto = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.feX) {
      localContentValues.put("championUrl", this.field_championUrl);
    }
    if (this.feY) {
      localContentValues.put("championMotto", this.field_championMotto);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dh
 * JD-Core Version:    0.7.0.1
 */