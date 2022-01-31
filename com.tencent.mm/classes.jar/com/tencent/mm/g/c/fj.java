package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dTA = "wallet_type".hashCode();
  private static final int dTB = "wallet_name".hashCode();
  private static final int dTC = "wallet_selected".hashCode();
  private static final int dTD = "wallet_balance".hashCode();
  private static final int dTE = "wallet_tpa_country_mask".hashCode();
  private static final int dTz = "wallet_tpa_country".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dTt = true;
  private boolean dTu = true;
  private boolean dTv = true;
  private boolean dTw = true;
  private boolean dTx = true;
  private boolean dTy = true;
  public int field_wallet_balance;
  public String field_wallet_name;
  public int field_wallet_selected;
  public String field_wallet_tpa_country;
  public int field_wallet_tpa_country_mask;
  public int field_wallet_type;
  
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
      if (dTz != k) {
        break label65;
      }
      this.field_wallet_tpa_country = paramCursor.getString(i);
      this.dTt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dTA == k) {
        this.field_wallet_type = paramCursor.getInt(i);
      } else if (dTB == k) {
        this.field_wallet_name = paramCursor.getString(i);
      } else if (dTC == k) {
        this.field_wallet_selected = paramCursor.getInt(i);
      } else if (dTD == k) {
        this.field_wallet_balance = paramCursor.getInt(i);
      } else if (dTE == k) {
        this.field_wallet_tpa_country_mask = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dTt) {
      localContentValues.put("wallet_tpa_country", this.field_wallet_tpa_country);
    }
    if (this.dTu) {
      localContentValues.put("wallet_type", Integer.valueOf(this.field_wallet_type));
    }
    if (this.dTv) {
      localContentValues.put("wallet_name", this.field_wallet_name);
    }
    if (this.dTw) {
      localContentValues.put("wallet_selected", Integer.valueOf(this.field_wallet_selected));
    }
    if (this.dTx) {
      localContentValues.put("wallet_balance", Integer.valueOf(this.field_wallet_balance));
    }
    if (this.dTy) {
      localContentValues.put("wallet_tpa_country_mask", Integer.valueOf(this.field_wallet_tpa_country_mask));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.fj
 * JD-Core Version:    0.7.0.1
 */