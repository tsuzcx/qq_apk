package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class be
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eQR = "bakLogId".hashCode();
  private static final int eQS = "valueStr".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eQP;
  private boolean eQQ;
  public int field_bakLogId;
  public String field_valueStr;
  
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
      if (eQR != k) {
        break label60;
      }
      this.field_bakLogId = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eQS == k) {
        this.field_valueStr = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eQP) {
      localContentValues.put("bakLogId", Integer.valueOf(this.field_bakLogId));
    }
    if (this.eQQ) {
      localContentValues.put("valueStr", this.field_valueStr);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.be
 * JD-Core Version:    0.7.0.1
 */