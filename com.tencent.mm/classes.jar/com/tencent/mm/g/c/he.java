package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class he
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fCz = "host".hashCode();
  private static final int feI = "expireTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fCy = true;
  private boolean few = true;
  public long field_expireTime;
  public String field_host;
  
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
      if (fCz != k) {
        break label60;
      }
      this.field_host = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (feI == k) {
        this.field_expireTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fCy) {
      localContentValues.put("host", this.field_host);
    }
    if (this.few) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.he
 * JD-Core Version:    0.7.0.1
 */