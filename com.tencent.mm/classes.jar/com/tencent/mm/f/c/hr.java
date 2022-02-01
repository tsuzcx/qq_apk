package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hr
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WalletRegionGreyAreaList");
  public static final Column iGg;
  private static final int iGs = "wallet_region".hashCode();
  public static final Column iHG;
  private static final int iHI = "wallet_grey_item_buf".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public byte[] field_wallet_grey_item_buf;
  public int field_wallet_region;
  private boolean iGm = true;
  private boolean iHH = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WalletRegionGreyAreaList", "");
    iGg = new Column("wallet_region", "int", "WalletRegionGreyAreaList", "");
    iHG = new Column("wallet_grey_item_buf", "byte[]", "WalletRegionGreyAreaList", "");
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
      if (iGs != k) {
        break label65;
      }
      this.field_wallet_region = paramCursor.getInt(i);
      this.iGm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iHI == k) {
        this.field_wallet_grey_item_buf = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iGm) {
      localContentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
    }
    if (this.iHH) {
      localContentValues.put("wallet_grey_item_buf", this.field_wallet_grey_item_buf);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "WalletRegionGreyAreaList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.hr
 * JD-Core Version:    0.7.0.1
 */