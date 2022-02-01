package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ek
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fQt = "send_id".hashCode();
  private static final int fQu = "open_count".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fQr = true;
  private boolean fQs = true;
  public int field_open_count;
  public String field_send_id;
  
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
      if (fQt != k) {
        break label65;
      }
      this.field_send_id = paramCursor.getString(i);
      this.fQr = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fQu == k) {
        this.field_open_count = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fQr) {
      localContentValues.put("send_id", this.field_send_id);
    }
    if (this.fQs) {
      localContentValues.put("open_count", Integer.valueOf(this.field_open_count));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ek
 * JD-Core Version:    0.7.0.1
 */