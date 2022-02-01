package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class u
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandStarAppUpdateTimeIndex ON AppBrandStarApp(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandStarAppOrderSequenceIndex ON AppBrandStarApp(orderSequence)" };
  private static final int eFF = "versionType".hashCode();
  private static final int eFp = "username".hashCode();
  private static final int eFq = "updateTime".hashCode();
  private static final int eGc = "orderSequence".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFB = true;
  private boolean eFm = true;
  private boolean eFn = true;
  private boolean eGb = true;
  public long field_orderSequence;
  public long field_updateTime;
  public String field_username;
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
      if (eFF == k) {
        this.field_versionType = paramCursor.getInt(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eGc == k) {
        this.field_orderSequence = paramCursor.getLong(i);
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
    if (this.eFB) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eGb) {
      localContentValues.put("orderSequence", Long.valueOf(this.field_orderSequence));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.u
 * JD-Core Version:    0.7.0.1
 */