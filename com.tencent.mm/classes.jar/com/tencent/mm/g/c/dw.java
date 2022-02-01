package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dw
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fMS = "countryCode".hashCode();
  private static final int fMT = "callTimeCount".hashCode();
  private static final int fMU = "lastCallTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fMP = true;
  private boolean fMQ = true;
  private boolean fMR = true;
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
      if (fMS != k) {
        break label65;
      }
      this.field_countryCode = paramCursor.getInt(i);
      this.fMP = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fMT == k) {
        this.field_callTimeCount = paramCursor.getLong(i);
      } else if (fMU == k) {
        this.field_lastCallTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fMP) {
      localContentValues.put("countryCode", Integer.valueOf(this.field_countryCode));
    }
    if (this.fMQ) {
      localContentValues.put("callTimeCount", Long.valueOf(this.field_callTimeCount));
    }
    if (this.fMR) {
      localContentValues.put("lastCallTime", Long.valueOf(this.field_lastCallTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dw
 * JD-Core Version:    0.7.0.1
 */