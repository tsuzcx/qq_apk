package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class o
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fkJ = "data".hashCode();
  private static final int fkW = "dataType".hashCode();
  private static final int fkX = "size".hashCode();
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  public String field_data;
  public String field_dataType;
  public String field_key;
  public int field_size;
  private boolean fkF = true;
  private boolean fkU = true;
  private boolean fkV = true;
  
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
      if (key_HASHCODE != k) {
        break label65;
      }
      this.field_key = paramCursor.getString(i);
      this.__hadSetkey = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fkJ == k) {
        this.field_data = paramCursor.getString(i);
      } else if (fkW == k) {
        this.field_dataType = paramCursor.getString(i);
      } else if (fkX == k) {
        this.field_size = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.fkF) {
      localContentValues.put("data", this.field_data);
    }
    if (this.fkU) {
      localContentValues.put("dataType", this.field_dataType);
    }
    if (this.fkV) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.o
 * JD-Core Version:    0.7.0.1
 */