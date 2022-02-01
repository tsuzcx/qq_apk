package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ho
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fCp = "pluginAppID".hashCode();
  private static final int fCq = "pluginAppVersion".hashCode();
  private static final int fCr = "pluginStringVersion".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fCm = true;
  private boolean fCn = true;
  private boolean fCo = true;
  public String field_pluginAppID;
  public int field_pluginAppVersion;
  public String field_pluginStringVersion;
  
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
      if (fCp != k) {
        break label60;
      }
      this.field_pluginAppID = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (fCq == k) {
        this.field_pluginAppVersion = paramCursor.getInt(i);
      } else if (fCr == k) {
        this.field_pluginStringVersion = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fCm) {
      localContentValues.put("pluginAppID", this.field_pluginAppID);
    }
    if (this.fCn) {
      localContentValues.put("pluginAppVersion", Integer.valueOf(this.field_pluginAppVersion));
    }
    if (this.fCo) {
      localContentValues.put("pluginStringVersion", this.field_pluginStringVersion);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ho
 * JD-Core Version:    0.7.0.1
 */