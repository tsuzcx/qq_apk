package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gv
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fys = "wallet_tpa_country".hashCode();
  private static final int fyt = "wallet_type".hashCode();
  private static final int fyu = "wallet_name".hashCode();
  private static final int fyv = "wallet_selected".hashCode();
  private static final int fyw = "wallet_balance".hashCode();
  private static final int fyx = "wallet_tpa_country_mask".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_wallet_balance;
  public String field_wallet_name;
  public int field_wallet_selected;
  public String field_wallet_tpa_country;
  public int field_wallet_tpa_country_mask;
  public int field_wallet_type;
  private boolean fym = true;
  private boolean fyn = true;
  private boolean fyo = true;
  private boolean fyp = true;
  private boolean fyq = true;
  private boolean fyr = true;
  
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
      if (fys != k) {
        break label65;
      }
      this.field_wallet_tpa_country = paramCursor.getString(i);
      this.fym = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fyt == k) {
        this.field_wallet_type = paramCursor.getInt(i);
      } else if (fyu == k) {
        this.field_wallet_name = paramCursor.getString(i);
      } else if (fyv == k) {
        this.field_wallet_selected = paramCursor.getInt(i);
      } else if (fyw == k) {
        this.field_wallet_balance = paramCursor.getInt(i);
      } else if (fyx == k) {
        this.field_wallet_tpa_country_mask = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fym) {
      localContentValues.put("wallet_tpa_country", this.field_wallet_tpa_country);
    }
    if (this.fyn) {
      localContentValues.put("wallet_type", Integer.valueOf(this.field_wallet_type));
    }
    if (this.fyo) {
      localContentValues.put("wallet_name", this.field_wallet_name);
    }
    if (this.fyp) {
      localContentValues.put("wallet_selected", Integer.valueOf(this.field_wallet_selected));
    }
    if (this.fyq) {
      localContentValues.put("wallet_balance", Integer.valueOf(this.field_wallet_balance));
    }
    if (this.fyr) {
      localContentValues.put("wallet_tpa_country_mask", Integer.valueOf(this.field_wallet_tpa_country_mask));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.gv
 * JD-Core Version:    0.7.0.1
 */