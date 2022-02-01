package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gi
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fAt = "extFlag".hashCode();
  private static final int fBI;
  private static final int fZE = "draft".hashCode();
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean fAo = true;
  private boolean fBy = true;
  private boolean fZD = true;
  public byte[] field_draft;
  public int field_extFlag;
  public String field_key;
  public long field_timestamp;
  
  static
  {
    fBI = "timestamp".hashCode();
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
      if (fBI == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (fAt == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (fZE == k) {
        this.field_draft = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_key == null) {
      this.field_key = "";
    }
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.fBy) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
    }
    if (this.fAo) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.fZD) {
      localContentValues.put("draft", this.field_draft);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gi
 * JD-Core Version:    0.7.0.1
 */