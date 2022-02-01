package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hd
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eNn = "appIdHash".hashCode();
  private static final int elJ = "appId".hashCode();
  private static final int fgZ = "openDebug".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eNh = true;
  private boolean els = true;
  private boolean fgY = true;
  public String field_appId;
  public int field_appIdHash;
  public boolean field_openDebug;
  
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
      if (eNn != k) {
        break label65;
      }
      this.field_appIdHash = paramCursor.getInt(i);
      this.eNh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (elJ == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else
      {
        if (fgZ == k)
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
    if (this.eNh) {
      localContentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
    }
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fgY) {
      localContentValues.put("openDebug", Boolean.valueOf(this.field_openDebug));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hd
 * JD-Core Version:    0.7.0.1
 */