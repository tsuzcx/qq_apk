package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEF = "msgId".hashCode();
  private static final int fmm = "historyId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEB = true;
  public String field_historyId;
  public long field_msgId;
  private boolean fmk = true;
  
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
      if (fmm != k) {
        break label60;
      }
      this.field_historyId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eEF == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fmk) {
      localContentValues.put("historyId", this.field_historyId);
    }
    if (this.eEB) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fq
 * JD-Core Version:    0.7.0.1
 */