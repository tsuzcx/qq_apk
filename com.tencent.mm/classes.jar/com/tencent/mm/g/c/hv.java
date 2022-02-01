package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hv
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fUh = "appid".hashCode();
  private static final int giE = "jsExceptionCount".hashCode();
  private static final int giF = "crashCount".hashCode();
  private static final int giG = "beginTimestamp".hashCode();
  private static final int giH = "pkgVersion".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fUf = true;
  public String field_appid;
  public long field_beginTimestamp;
  public int field_crashCount;
  public int field_jsExceptionCount;
  public int field_pkgVersion;
  private boolean giA = true;
  private boolean giB = true;
  private boolean giC = true;
  private boolean giD = true;
  
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
      if (fUh != k) {
        break label65;
      }
      this.field_appid = paramCursor.getString(i);
      this.fUf = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (giE == k) {
        this.field_jsExceptionCount = paramCursor.getInt(i);
      } else if (giF == k) {
        this.field_crashCount = paramCursor.getInt(i);
      } else if (giG == k) {
        this.field_beginTimestamp = paramCursor.getLong(i);
      } else if (giH == k) {
        this.field_pkgVersion = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fUf) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.giA) {
      localContentValues.put("jsExceptionCount", Integer.valueOf(this.field_jsExceptionCount));
    }
    if (this.giB) {
      localContentValues.put("crashCount", Integer.valueOf(this.field_crashCount));
    }
    if (this.giC) {
      localContentValues.put("beginTimestamp", Long.valueOf(this.field_beginTimestamp));
    }
    if (this.giD) {
      localContentValues.put("pkgVersion", Integer.valueOf(this.field_pkgVersion));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.hv
 * JD-Core Version:    0.7.0.1
 */