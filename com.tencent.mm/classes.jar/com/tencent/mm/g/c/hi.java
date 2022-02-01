package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hi
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fBu = "jsExceptionCount".hashCode();
  private static final int fBv = "crashCount".hashCode();
  private static final int fBw = "beginTimestamp".hashCode();
  private static final int fBx = "pkgVersion".hashCode();
  private static final int fnB = "appid".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fBq = true;
  private boolean fBr = true;
  private boolean fBs = true;
  private boolean fBt = true;
  public String field_appid;
  public long field_beginTimestamp;
  public int field_crashCount;
  public int field_jsExceptionCount;
  public int field_pkgVersion;
  private boolean fnz = true;
  
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
      if (fnB != k) {
        break label65;
      }
      this.field_appid = paramCursor.getString(i);
      this.fnz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fBu == k) {
        this.field_jsExceptionCount = paramCursor.getInt(i);
      } else if (fBv == k) {
        this.field_crashCount = paramCursor.getInt(i);
      } else if (fBw == k) {
        this.field_beginTimestamp = paramCursor.getLong(i);
      } else if (fBx == k) {
        this.field_pkgVersion = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fnz) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.fBq) {
      localContentValues.put("jsExceptionCount", Integer.valueOf(this.field_jsExceptionCount));
    }
    if (this.fBr) {
      localContentValues.put("crashCount", Integer.valueOf(this.field_crashCount));
    }
    if (this.fBs) {
      localContentValues.put("beginTimestamp", Long.valueOf(this.field_beginTimestamp));
    }
    if (this.fBt) {
      localContentValues.put("pkgVersion", Integer.valueOf(this.field_pkgVersion));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.hi
 * JD-Core Version:    0.7.0.1
 */