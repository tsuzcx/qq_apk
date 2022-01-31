package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class et
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int dcg = "wallet_tpa_country".hashCode();
  private static final int dch = "wallet_type".hashCode();
  private static final int dci = "wallet_name".hashCode();
  private static final int dcj = "wallet_selected".hashCode();
  private static final int dck = "wallet_balance".hashCode();
  private static final int dcl = "wallet_tpa_country_mask".hashCode();
  private boolean dca = true;
  private boolean dcb = true;
  private boolean dcc = true;
  private boolean dcd = true;
  private boolean dce = true;
  private boolean dcf = true;
  public int field_wallet_balance;
  public String field_wallet_name;
  public int field_wallet_selected;
  public String field_wallet_tpa_country;
  public int field_wallet_tpa_country_mask;
  public int field_wallet_type;
  
  public final void d(Cursor paramCursor)
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
      if (dcg != k) {
        break label65;
      }
      this.field_wallet_tpa_country = paramCursor.getString(i);
      this.dca = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dch == k) {
        this.field_wallet_type = paramCursor.getInt(i);
      } else if (dci == k) {
        this.field_wallet_name = paramCursor.getString(i);
      } else if (dcj == k) {
        this.field_wallet_selected = paramCursor.getInt(i);
      } else if (dck == k) {
        this.field_wallet_balance = paramCursor.getInt(i);
      } else if (dcl == k) {
        this.field_wallet_tpa_country_mask = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dca) {
      localContentValues.put("wallet_tpa_country", this.field_wallet_tpa_country);
    }
    if (this.dcb) {
      localContentValues.put("wallet_type", Integer.valueOf(this.field_wallet_type));
    }
    if (this.dcc) {
      localContentValues.put("wallet_name", this.field_wallet_name);
    }
    if (this.dcd) {
      localContentValues.put("wallet_selected", Integer.valueOf(this.field_wallet_selected));
    }
    if (this.dce) {
      localContentValues.put("wallet_balance", Integer.valueOf(this.field_wallet_balance));
    }
    if (this.dcf) {
      localContentValues.put("wallet_tpa_country_mask", Integer.valueOf(this.field_wallet_tpa_country_mask));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.et
 * JD-Core Version:    0.7.0.1
 */