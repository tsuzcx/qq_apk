package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fv
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dJr = "appid".hashCode();
  private static final int dWA = "pkgVersion".hashCode();
  private static final int dWx = "jsExceptionCount".hashCode();
  private static final int dWy = "crashCount".hashCode();
  private static final int dWz = "beginTimestamp".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dJp = true;
  private boolean dWt = true;
  private boolean dWu = true;
  private boolean dWv = true;
  private boolean dWw = true;
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
      if (dJr != k) {
        break label65;
      }
      this.field_appid = paramCursor.getString(i);
      this.dJp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dWx == k) {
        this.field_jsExceptionCount = paramCursor.getInt(i);
      } else if (dWy == k) {
        this.field_crashCount = paramCursor.getInt(i);
      } else if (dWz == k) {
        this.field_beginTimestamp = paramCursor.getLong(i);
      } else if (dWA == k) {
        this.field_pkgVersion = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dJp) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.dWt) {
      localContentValues.put("jsExceptionCount", Integer.valueOf(this.field_jsExceptionCount));
    }
    if (this.dWu) {
      localContentValues.put("crashCount", Integer.valueOf(this.field_crashCount));
    }
    if (this.dWv) {
      localContentValues.put("beginTimestamp", Long.valueOf(this.field_beginTimestamp));
    }
    if (this.dWw) {
      localContentValues.put("pkgVersion", Integer.valueOf(this.field_pkgVersion));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.fv
 * JD-Core Version:    0.7.0.1
 */