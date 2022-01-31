package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class i
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandAppLaunchRecordUpdateTimeIndex ON AppBrandAppLaunchUsernameDuplicateRecord(updateTime)" };
  private static final int dhU = "username".hashCode();
  private static final int dhV = "updateTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dhS = true;
  private boolean dhT = true;
  public long field_updateTime;
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
      if (dhU != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.dhS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dhV == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dhS) {
      localContentValues.put("username", this.field_username);
    }
    if (this.dhT) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.i
 * JD-Core Version:    0.7.0.1
 */