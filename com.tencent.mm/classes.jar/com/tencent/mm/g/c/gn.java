package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gn
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGD = "appId".hashCode();
  private static final int eGY = "username".hashCode();
  private static final int eIR = "openId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGV = true;
  private boolean eGm = true;
  private boolean eIv = true;
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
      if (eIR != k) {
        break label65;
      }
      this.field_openId = paramCursor.getString(i);
      this.eIv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eGD == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eGY == k) {
        this.field_username = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eIv) {
      localContentValues.put("openId", this.field_openId);
    }
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gn
 * JD-Core Version:    0.7.0.1
 */