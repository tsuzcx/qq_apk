package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class u
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandStarAppUpdateTimeIndex ON AppBrandStarApp(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandStarAppOrderSequenceIndex ON AppBrandStarApp(orderSequence)" };
  private static final int eoA;
  private static final int eoT = "orderSequence".hashCode();
  private static final int eok = "username".hashCode();
  private static final int eol;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eoS = true;
  private boolean eoh = true;
  private boolean eoi = true;
  private boolean eow = true;
  public long field_orderSequence;
  public long field_updateTime;
  public String field_username;
  public int field_versionType;
  
  static
  {
    eoA = "versionType".hashCode();
    eol = "updateTime".hashCode();
  }
  
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
      if (eok != k) {
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
      if (eoA == k) {
        this.field_versionType = paramCursor.getInt(i);
      } else if (eol == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eoT == k) {
        this.field_orderSequence = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eow) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eoS) {
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