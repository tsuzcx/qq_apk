package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ew
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int dbV = "wallet_region".hashCode();
  private static final int dcD = "wallet_grey_item_buf".hashCode();
  private boolean dbQ = true;
  private boolean dcC = true;
  public byte[] field_wallet_grey_item_buf;
  public int field_wallet_region;
  
  public void d(Cursor paramCursor)
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
      if (dbV != k) {
        break label65;
      }
      this.field_wallet_region = paramCursor.getInt(i);
      this.dbQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dcD == k) {
        this.field_wallet_grey_item_buf = paramCursor.getBlob(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dbQ) {
      localContentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
    }
    if (this.dcC) {
      localContentValues.put("wallet_grey_item_buf", this.field_wallet_grey_item_buf);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.ew
 * JD-Core Version:    0.7.0.1
 */