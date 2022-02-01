package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hu
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCW = "msgId".hashCode();
  private static final int fkp = "historyId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCS = true;
  public String field_historyId;
  public long field_msgId;
  private boolean fkn = true;
  
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
      if (fkp != k) {
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
      if (eCW == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fkn) {
      localContentValues.put("historyId", this.field_historyId);
    }
    if (this.eCS) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.hu
 * JD-Core Version:    0.7.0.1
 */