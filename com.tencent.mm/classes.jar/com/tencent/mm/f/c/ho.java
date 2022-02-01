package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ho
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WalletKindInfo");
  public static final Column iGA = new Column("wallet_name", "string", "WalletKindInfo", "");
  public static final Column iGB = new Column("wallet_selected", "int", "WalletKindInfo", "");
  public static final Column iGC = new Column("wallet_balance", "int", "WalletKindInfo", "");
  public static final Column iGD = new Column("wallet_tpa_country_mask", "int", "WalletKindInfo", "");
  private static final int iGK = "wallet_tpa_country".hashCode();
  private static final int iGL = "wallet_type".hashCode();
  private static final int iGM = "wallet_name".hashCode();
  private static final int iGN = "wallet_selected".hashCode();
  private static final int iGO = "wallet_balance".hashCode();
  private static final int iGP = "wallet_tpa_country_mask".hashCode();
  public static final Column iGy;
  public static final Column iGz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_wallet_balance;
  public String field_wallet_name;
  public int field_wallet_selected;
  public String field_wallet_tpa_country;
  public int field_wallet_tpa_country_mask;
  public int field_wallet_type;
  private boolean iGE = true;
  private boolean iGF = true;
  private boolean iGG = true;
  private boolean iGH = true;
  private boolean iGI = true;
  private boolean iGJ = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WalletKindInfo", "");
    iGy = new Column("wallet_tpa_country", "string", "WalletKindInfo", "");
    iGz = new Column("wallet_type", "int", "WalletKindInfo", "");
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
      if (iGK != k) {
        break label65;
      }
      this.field_wallet_tpa_country = paramCursor.getString(i);
      this.iGE = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iGL == k) {
        this.field_wallet_type = paramCursor.getInt(i);
      } else if (iGM == k) {
        this.field_wallet_name = paramCursor.getString(i);
      } else if (iGN == k) {
        this.field_wallet_selected = paramCursor.getInt(i);
      } else if (iGO == k) {
        this.field_wallet_balance = paramCursor.getInt(i);
      } else if (iGP == k) {
        this.field_wallet_tpa_country_mask = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iGE) {
      localContentValues.put("wallet_tpa_country", this.field_wallet_tpa_country);
    }
    if (this.iGF) {
      localContentValues.put("wallet_type", Integer.valueOf(this.field_wallet_type));
    }
    if (this.iGG) {
      localContentValues.put("wallet_name", this.field_wallet_name);
    }
    if (this.iGH) {
      localContentValues.put("wallet_selected", Integer.valueOf(this.field_wallet_selected));
    }
    if (this.iGI) {
      localContentValues.put("wallet_balance", Integer.valueOf(this.field_wallet_balance));
    }
    if (this.iGJ) {
      localContentValues.put("wallet_tpa_country_mask", Integer.valueOf(this.field_wallet_tpa_country_mask));
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
    return "WalletKindInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.c.ho
 * JD-Core Version:    0.7.0.1
 */