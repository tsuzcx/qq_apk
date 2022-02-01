package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gu
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eSc = "appid".hashCode();
  private static final int ffU = "jsExceptionCount".hashCode();
  private static final int ffV = "crashCount".hashCode();
  private static final int ffW = "beginTimestamp".hashCode();
  private static final int ffX = "pkgVersion".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eSa = true;
  private boolean ffQ = true;
  private boolean ffR = true;
  private boolean ffS = true;
  private boolean ffT = true;
  public String field_appid;
  public long field_beginTimestamp;
  public int field_crashCount;
  public int field_jsExceptionCount;
  public int field_pkgVersion;
  
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
      if (eSc != k) {
        break label65;
      }
      this.field_appid = paramCursor.getString(i);
      this.eSa = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ffU == k) {
        this.field_jsExceptionCount = paramCursor.getInt(i);
      } else if (ffV == k) {
        this.field_crashCount = paramCursor.getInt(i);
      } else if (ffW == k) {
        this.field_beginTimestamp = paramCursor.getLong(i);
      } else if (ffX == k) {
        this.field_pkgVersion = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eSa) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.ffQ) {
      localContentValues.put("jsExceptionCount", Integer.valueOf(this.field_jsExceptionCount));
    }
    if (this.ffR) {
      localContentValues.put("crashCount", Integer.valueOf(this.field_crashCount));
    }
    if (this.ffS) {
      localContentValues.put("beginTimestamp", Long.valueOf(this.field_beginTimestamp));
    }
    if (this.ffT) {
      localContentValues.put("pkgVersion", Integer.valueOf(this.field_pkgVersion));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gu
 * JD-Core Version:    0.7.0.1
 */