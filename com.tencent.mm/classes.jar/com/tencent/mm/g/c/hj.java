package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fDu = "jsExceptionCount".hashCode();
  private static final int fDv = "crashCount".hashCode();
  private static final int fDw = "beginTimestamp".hashCode();
  private static final int fDx = "pkgVersion".hashCode();
  private static final int fpC = "appid".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fDq = true;
  private boolean fDr = true;
  private boolean fDs = true;
  private boolean fDt = true;
  public String field_appid;
  public long field_beginTimestamp;
  public int field_crashCount;
  public int field_jsExceptionCount;
  public int field_pkgVersion;
  private boolean fpA = true;
  
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
      if (fpC != k) {
        break label65;
      }
      this.field_appid = paramCursor.getString(i);
      this.fpA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fDu == k) {
        this.field_jsExceptionCount = paramCursor.getInt(i);
      } else if (fDv == k) {
        this.field_crashCount = paramCursor.getInt(i);
      } else if (fDw == k) {
        this.field_beginTimestamp = paramCursor.getLong(i);
      } else if (fDx == k) {
        this.field_pkgVersion = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fpA) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.fDq) {
      localContentValues.put("jsExceptionCount", Integer.valueOf(this.field_jsExceptionCount));
    }
    if (this.fDr) {
      localContentValues.put("crashCount", Integer.valueOf(this.field_crashCount));
    }
    if (this.fDs) {
      localContentValues.put("beginTimestamp", Long.valueOf(this.field_beginTimestamp));
    }
    if (this.fDt) {
      localContentValues.put("pkgVersion", Integer.valueOf(this.field_pkgVersion));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hj
 * JD-Core Version:    0.7.0.1
 */