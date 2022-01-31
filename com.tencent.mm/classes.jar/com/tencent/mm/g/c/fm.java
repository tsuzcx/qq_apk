package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fm
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dTn = "wallet_region".hashCode();
  private static final int dUc = "wallet_grey_item_buf".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dTh = true;
  private boolean dUb = true;
  public byte[] field_wallet_grey_item_buf;
  public int field_wallet_region;
  
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
      if (dTn != k) {
        break label65;
      }
      this.field_wallet_region = paramCursor.getInt(i);
      this.dTh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dUc == k) {
        this.field_wallet_grey_item_buf = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dTh) {
      localContentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
    }
    if (this.dUb) {
      localContentValues.put("wallet_grey_item_buf", this.field_wallet_grey_item_buf);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.fm
 * JD-Core Version:    0.7.0.1
 */