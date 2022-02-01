package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hn
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "WalletFunciontList", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WalletFunciontList");
  public static final Column iGg = new Column("wallet_region", "int", "WalletFunciontList", "");
  public static final Column iGh = new Column("function_list", "string", "WalletFunciontList", "");
  public static final Column iGi = new Column("new_list", "string", "WalletFunciontList", "");
  public static final Column iGj = new Column("banner_list", "string", "WalletFunciontList", "");
  public static final Column iGk = new Column("type_name_list", "string", "WalletFunciontList", "");
  public static final Column iGl = new Column("isshowsetting", "int", "WalletFunciontList", "");
  private static final int iGs = "wallet_region".hashCode();
  private static final int iGt = "function_list".hashCode();
  private static final int iGu = "new_list".hashCode();
  private static final int iGv = "banner_list".hashCode();
  private static final int iGw = "type_name_list".hashCode();
  private static final int iGx = "isShowSetting".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_banner_list;
  public String field_function_list;
  public int field_isShowSetting;
  public String field_new_list;
  public String field_type_name_list;
  public int field_wallet_region;
  private boolean iGm = true;
  private boolean iGn = true;
  private boolean iGo = true;
  private boolean iGp = true;
  private boolean iGq = true;
  private boolean iGr = true;
  
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
      if (iGt == k) {
        this.field_function_list = paramCursor.getString(i);
      } else if (iGu == k) {
        this.field_new_list = paramCursor.getString(i);
      } else if (iGv == k) {
        this.field_banner_list = paramCursor.getString(i);
      } else if (iGw == k) {
        this.field_type_name_list = paramCursor.getString(i);
      } else if (iGx == k) {
        this.field_isShowSetting = paramCursor.getInt(i);
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
    if (this.iGn) {
      localContentValues.put("function_list", this.field_function_list);
    }
    if (this.iGo) {
      localContentValues.put("new_list", this.field_new_list);
    }
    if (this.iGp) {
      localContentValues.put("banner_list", this.field_banner_list);
    }
    if (this.iGq) {
      localContentValues.put("type_name_list", this.field_type_name_list);
    }
    if (this.iGr) {
      localContentValues.put("isShowSetting", Integer.valueOf(this.field_isShowSetting));
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
    return "WalletFunciontList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.c.hn
 * JD-Core Version:    0.7.0.1
 */