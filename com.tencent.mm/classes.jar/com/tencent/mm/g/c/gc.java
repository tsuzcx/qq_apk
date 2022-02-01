package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gc
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int enO = "appId".hashCode();
  private static final int eok = "username".hashCode();
  private static final int epZ = "openId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean enx = true;
  private boolean eoh = true;
  private boolean epD = true;
  public String field_appId;
  public String field_openId;
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
      if (epZ != k) {
        break label65;
      }
      this.field_openId = paramCursor.getString(i);
      this.epD = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (enO == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eok == k) {
        this.field_username = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.epD) {
      localContentValues.put("openId", this.field_openId);
    }
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gc
 * JD-Core Version:    0.7.0.1
 */