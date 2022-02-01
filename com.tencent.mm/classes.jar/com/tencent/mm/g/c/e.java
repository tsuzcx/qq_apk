package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class e
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFl = "mau".hashCode();
  private static final int eFm = "dau".hashCode();
  private static final int eFn = "useTime".hashCode();
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean eFi = true;
  private boolean eFj = true;
  private boolean eFk = true;
  public int field_dau;
  public int field_key;
  public int field_mau;
  public long field_useTime;
  
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
      if (eFl == k) {
        this.field_mau = paramCursor.getInt(i);
      } else if (eFm == k) {
        this.field_dau = paramCursor.getInt(i);
      } else if (eFn == k) {
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
    if (this.eFi) {
      localContentValues.put("mau", Integer.valueOf(this.field_mau));
    }
    if (this.eFj) {
      localContentValues.put("dau", Integer.valueOf(this.field_dau));
    }
    if (this.eFk) {
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