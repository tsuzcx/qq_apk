package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fin = "countryCode".hashCode();
  private static final int fio = "callTimeCount".hashCode();
  private static final int fip = "lastCallTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_callTimeCount;
  public int field_countryCode;
  public long field_lastCallTime;
  private boolean fik = true;
  private boolean fil = true;
  private boolean fim = true;
  
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
      if (fin != k) {
        break label65;
      }
      this.field_countryCode = paramCursor.getInt(i);
      this.fik = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fio == k) {
        this.field_callTimeCount = paramCursor.getLong(i);
      } else if (fip == k) {
        this.field_lastCallTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fik) {
      localContentValues.put("countryCode", Integer.valueOf(this.field_countryCode));
    }
    if (this.fil) {
      localContentValues.put("callTimeCount", Long.valueOf(this.field_callTimeCount));
    }
    if (this.fim) {
      localContentValues.put("lastCallTime", Long.valueOf(this.field_lastCallTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dq
 * JD-Core Version:    0.7.0.1
 */