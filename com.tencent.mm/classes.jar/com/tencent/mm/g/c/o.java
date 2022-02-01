package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class o
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eoG = "dataType".hashCode();
  private static final int eoH = "size".hashCode();
  private static final int eot;
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean eoE = true;
  private boolean eoF = true;
  private boolean eop = true;
  public String field_data;
  public String field_dataType;
  public String field_key;
  public int field_size;
  
  static
  {
    eot = "data".hashCode();
  }
  
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
      if (eot == k) {
        this.field_data = paramCursor.getString(i);
      } else if (eoG == k) {
        this.field_dataType = paramCursor.getString(i);
      } else if (eoH == k) {
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
    if (this.eop) {
      localContentValues.put("data", this.field_data);
    }
    if (this.eoE) {
      localContentValues.put("dataType", this.field_dataType);
    }
    if (this.eoF) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.o
 * JD-Core Version:    0.7.0.1
 */