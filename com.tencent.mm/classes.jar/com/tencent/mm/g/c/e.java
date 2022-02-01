package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class e
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fjL = "mau".hashCode();
  private static final int fjM = "dau".hashCode();
  private static final int fjN = "useTime".hashCode();
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  public int field_dau;
  public int field_key;
  public int field_mau;
  public long field_useTime;
  private boolean fjI = true;
  private boolean fjJ = true;
  private boolean fjK = true;
  
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
      this.field_key = paramCursor.getInt(i);
      this.__hadSetkey = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fjL == k) {
        this.field_mau = paramCursor.getInt(i);
      } else if (fjM == k) {
        this.field_dau = paramCursor.getInt(i);
      } else if (fjN == k) {
        this.field_useTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetkey) {
      localContentValues.put("key", Integer.valueOf(this.field_key));
    }
    if (this.fjI) {
      localContentValues.put("mau", Integer.valueOf(this.field_mau));
    }
    if (this.fjJ) {
      localContentValues.put("dau", Integer.valueOf(this.field_dau));
    }
    if (this.fjK) {
      localContentValues.put("useTime", Long.valueOf(this.field_useTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.e
 * JD-Core Version:    0.7.0.1
 */