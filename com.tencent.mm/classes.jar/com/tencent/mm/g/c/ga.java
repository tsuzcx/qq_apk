package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ga
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dFL = "appIdHash".hashCode();
  private static final int dXo = "openDebug".hashCode();
  private static final int dhB = "appId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dFF = true;
  private boolean dXn = true;
  private boolean dhk = true;
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
      if (dFL != k) {
        break label65;
      }
      this.field_appIdHash = paramCursor.getInt(i);
      this.dFF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dhB == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else
      {
        if (dXo == k)
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
    if (this.dFF) {
      localContentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
    }
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.dXn) {
      localContentValues.put("openDebug", Boolean.valueOf(this.field_openDebug));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.ga
 * JD-Core Version:    0.7.0.1
 */