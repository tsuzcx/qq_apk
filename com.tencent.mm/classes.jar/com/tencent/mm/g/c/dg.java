package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eNU = "countryCode".hashCode();
  private static final int eNV = "callTimeCount".hashCode();
  private static final int eNW = "lastCallTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eNR = true;
  private boolean eNS = true;
  private boolean eNT = true;
  public long field_callTimeCount;
  public int field_countryCode;
  public long field_lastCallTime;
  
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
      if (eNU != k) {
        break label65;
      }
      this.field_countryCode = paramCursor.getInt(i);
      this.eNR = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eNV == k) {
        this.field_callTimeCount = paramCursor.getLong(i);
      } else if (eNW == k) {
        this.field_lastCallTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eNR) {
      localContentValues.put("countryCode", Integer.valueOf(this.field_countryCode));
    }
    if (this.eNS) {
      localContentValues.put("callTimeCount", Long.valueOf(this.field_callTimeCount));
    }
    if (this.eNT) {
      localContentValues.put("lastCallTime", Long.valueOf(this.field_lastCallTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dg
 * JD-Core Version:    0.7.0.1
 */