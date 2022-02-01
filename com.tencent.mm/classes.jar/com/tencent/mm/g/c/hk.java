package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hk
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int geY = "wallet_region".hashCode();
  private static final int gfT = "wallet_grey_item_buf".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public byte[] field_wallet_grey_item_buf;
  public int field_wallet_region;
  private boolean geS = true;
  private boolean gfS = true;
  
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
      if (geY != k) {
        break label65;
      }
      this.field_wallet_region = paramCursor.getInt(i);
      this.geS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (gfT == k) {
        this.field_wallet_grey_item_buf = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.geS) {
      localContentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
    }
    if (this.gfS) {
      localContentValues.put("wallet_grey_item_buf", this.field_wallet_grey_item_buf);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.hk
 * JD-Core Version:    0.7.0.1
 */