package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hq
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fkj;
  private static final int flc = "recordId".hashCode();
  private static final int ghz;
  private static final int key_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE;
  private boolean __hadSetkey = true;
  private boolean __hadSetvalue = true;
  public String field_appId;
  public String field_domin;
  public String field_key;
  public int field_recordId;
  public String field_value;
  private boolean fjS = true;
  private boolean fkY = true;
  private boolean ghy = true;
  
  static
  {
    fkj = "appId".hashCode();
    ghz = "domin".hashCode();
    key_HASHCODE = "key".hashCode();
    value_HASHCODE = "value".hashCode();
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
      if (flc != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getInt(i);
      this.fkY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fkj == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (ghz == k) {
        this.field_domin = paramCursor.getString(i);
      } else if (key_HASHCODE == k) {
        this.field_key = paramCursor.getString(i);
      } else if (value_HASHCODE == k) {
        this.field_value = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fkY) {
      localContentValues.put("recordId", Integer.valueOf(this.field_recordId));
    }
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.ghy) {
      localContentValues.put("domin", this.field_domin);
    }
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.hq
 * JD-Core Version:    0.7.0.1
 */