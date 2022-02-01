package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hh
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int gfk = "wallet_tpa_country".hashCode();
  private static final int gfl = "wallet_type".hashCode();
  private static final int gfm = "wallet_name".hashCode();
  private static final int gfn = "wallet_selected".hashCode();
  private static final int gfo = "wallet_balance".hashCode();
  private static final int gfp = "wallet_tpa_country_mask".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_wallet_balance;
  public String field_wallet_name;
  public int field_wallet_selected;
  public String field_wallet_tpa_country;
  public int field_wallet_tpa_country_mask;
  public int field_wallet_type;
  private boolean gfe = true;
  private boolean gff = true;
  private boolean gfg = true;
  private boolean gfh = true;
  private boolean gfi = true;
  private boolean gfj = true;
  
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
      if (gfk != k) {
        break label65;
      }
      this.field_wallet_tpa_country = paramCursor.getString(i);
      this.gfe = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (gfl == k) {
        this.field_wallet_type = paramCursor.getInt(i);
      } else if (gfm == k) {
        this.field_wallet_name = paramCursor.getString(i);
      } else if (gfn == k) {
        this.field_wallet_selected = paramCursor.getInt(i);
      } else if (gfo == k) {
        this.field_wallet_balance = paramCursor.getInt(i);
      } else if (gfp == k) {
        this.field_wallet_tpa_country_mask = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.gfe) {
      localContentValues.put("wallet_tpa_country", this.field_wallet_tpa_country);
    }
    if (this.gff) {
      localContentValues.put("wallet_type", Integer.valueOf(this.field_wallet_type));
    }
    if (this.gfg) {
      localContentValues.put("wallet_name", this.field_wallet_name);
    }
    if (this.gfh) {
      localContentValues.put("wallet_selected", Integer.valueOf(this.field_wallet_selected));
    }
    if (this.gfi) {
      localContentValues.put("wallet_balance", Integer.valueOf(this.field_wallet_balance));
    }
    if (this.gfj) {
      localContentValues.put("wallet_tpa_country_mask", Integer.valueOf(this.field_wallet_tpa_country_mask));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.hh
 * JD-Core Version:    0.7.0.1
 */