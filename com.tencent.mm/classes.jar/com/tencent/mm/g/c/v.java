package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class v
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int enO = "appId".hashCode();
  private static final int eoA = "versionType".hashCode();
  private static final int eoV = "versionMd5".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean enx = true;
  private boolean eoU = true;
  private boolean eow = true;
  public String field_appId;
  public String field_versionMd5;
  public int field_versionType;
  
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
      if (enO != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eoA == k) {
        this.field_versionType = paramCursor.getInt(i);
      } else if (eoV == k) {
        this.field_versionMd5 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eow) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.eoU) {
      localContentValues.put("versionMd5", this.field_versionMd5);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.v
 * JD-Core Version:    0.7.0.1
 */