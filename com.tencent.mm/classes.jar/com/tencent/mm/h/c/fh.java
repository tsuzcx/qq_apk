package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fh
  extends c
{
  private static final int cTh;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int dfi;
  private static final int dfj;
  private static final int dfk;
  private static final int dfl;
  private boolean cTf = true;
  private boolean dfe = true;
  private boolean dff = true;
  private boolean dfg = true;
  private boolean dfh = true;
  public String field_appid;
  public long field_beginTimestamp;
  public int field_crashCount;
  public int field_jsExceptionCount;
  public int field_pkgVersion;
  
  static
  {
    cTh = "appid".hashCode();
    dfi = "jsExceptionCount".hashCode();
    dfj = "crashCount".hashCode();
    dfk = "beginTimestamp".hashCode();
    dfl = "pkgVersion".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cTh != k) {
        break label65;
      }
      this.field_appid = paramCursor.getString(i);
      this.cTf = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dfi == k) {
        this.field_jsExceptionCount = paramCursor.getInt(i);
      } else if (dfj == k) {
        this.field_crashCount = paramCursor.getInt(i);
      } else if (dfk == k) {
        this.field_beginTimestamp = paramCursor.getLong(i);
      } else if (dfl == k) {
        this.field_pkgVersion = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cTf) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.dfe) {
      localContentValues.put("jsExceptionCount", Integer.valueOf(this.field_jsExceptionCount));
    }
    if (this.dff) {
      localContentValues.put("crashCount", Integer.valueOf(this.field_crashCount));
    }
    if (this.dfg) {
      localContentValues.put("beginTimestamp", Long.valueOf(this.field_beginTimestamp));
    }
    if (this.dfh) {
      localContentValues.put("pkgVersion", Integer.valueOf(this.field_pkgVersion));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.fh
 * JD-Core Version:    0.7.0.1
 */