package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fy
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eVd = "extFlag".hashCode();
  private static final int eWu;
  private static final int fsV = "draft".hashCode();
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean eUY = true;
  private boolean eWk = true;
  public byte[] field_draft;
  public int field_extFlag;
  public String field_key;
  public long field_timestamp;
  private boolean fsU = true;
  
  static
  {
    eWu = "timestamp".hashCode();
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
      if (eWu == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (eVd == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (fsV == k) {
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
    if (this.eWk) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
    }
    if (this.eUY) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.fsU) {
      localContentValues.put("draft", this.field_draft);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fy
 * JD-Core Version:    0.7.0.1
 */