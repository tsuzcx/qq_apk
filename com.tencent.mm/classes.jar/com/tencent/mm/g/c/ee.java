package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ee
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int flP = "send_id".hashCode();
  private static final int flQ = "open_count".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_open_count;
  public String field_send_id;
  private boolean flN = true;
  private boolean flO = true;
  
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
      if (flP != k) {
        break label65;
      }
      this.field_send_id = paramCursor.getString(i);
      this.flN = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (flQ == k) {
        this.field_open_count = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.flN) {
      localContentValues.put("send_id", this.field_send_id);
    }
    if (this.flO) {
      localContentValues.put("open_count", Integer.valueOf(this.field_open_count));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ee
 * JD-Core Version:    0.7.0.1
 */