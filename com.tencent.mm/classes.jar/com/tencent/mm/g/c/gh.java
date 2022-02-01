package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gh
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fcS = "wallet_tpa_country".hashCode();
  private static final int fcT = "wallet_type".hashCode();
  private static final int fcU = "wallet_name".hashCode();
  private static final int fcV = "wallet_selected".hashCode();
  private static final int fcW = "wallet_balance".hashCode();
  private static final int fcX = "wallet_tpa_country_mask".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fcM = true;
  private boolean fcN = true;
  private boolean fcO = true;
  private boolean fcP = true;
  private boolean fcQ = true;
  private boolean fcR = true;
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
      if (fcS != k) {
        break label65;
      }
      this.field_wallet_tpa_country = paramCursor.getString(i);
      this.fcM = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fcT == k) {
        this.field_wallet_type = paramCursor.getInt(i);
      } else if (fcU == k) {
        this.field_wallet_name = paramCursor.getString(i);
      } else if (fcV == k) {
        this.field_wallet_selected = paramCursor.getInt(i);
      } else if (fcW == k) {
        this.field_wallet_balance = paramCursor.getInt(i);
      } else if (fcX == k) {
        this.field_wallet_tpa_country_mask = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fcM) {
      localContentValues.put("wallet_tpa_country", this.field_wallet_tpa_country);
    }
    if (this.fcN) {
      localContentValues.put("wallet_type", Integer.valueOf(this.field_wallet_type));
    }
    if (this.fcO) {
      localContentValues.put("wallet_name", this.field_wallet_name);
    }
    if (this.fcP) {
      localContentValues.put("wallet_selected", Integer.valueOf(this.field_wallet_selected));
    }
    if (this.fcQ) {
      localContentValues.put("wallet_balance", Integer.valueOf(this.field_wallet_balance));
    }
    if (this.fcR) {
      localContentValues.put("wallet_tpa_country_mask", Integer.valueOf(this.field_wallet_tpa_country_mask));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.gh
 * JD-Core Version:    0.7.0.1
 */