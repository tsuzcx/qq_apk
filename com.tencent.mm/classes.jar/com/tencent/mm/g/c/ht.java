package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ht
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGD = "appId".hashCode();
  private static final int fEF = "openDebug".hashCode();
  private static final int fkz = "appIdHash".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGm = true;
  private boolean fEE = true;
  public String field_appId;
  public int field_appIdHash;
  public boolean field_openDebug;
  private boolean fkt = true;
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (fkz != k) {
        break label65;
      }
      this.field_appIdHash = paramCursor.getInt(i);
      this.fkt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eGD == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else
      {
        if (fEF == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_openDebug = bool;
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fkt) {
      localContentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
    }
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fEE) {
      localContentValues.put("openDebug", Boolean.valueOf(this.field_openDebug));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ht
 * JD-Core Version:    0.7.0.1
 */