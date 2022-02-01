package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class as
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS CardQrCodeDataInfo_card_id_index ON CardQrCodeDataInfo(card_id)" };
  public static final SingleTable TABLE = new SingleTable("CardQrCodeDataInfo");
  private static final int hmC = "status".hashCode();
  public static final Column hmw;
  private static final int hyM;
  public static final Column hya;
  public static final Column hzu;
  public static final Column hzv;
  private static final int hzy;
  private static final int hzz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_card_id;
  public String field_code;
  public String field_code_id;
  public int field_status;
  private boolean hmz = true;
  private boolean hyt = true;
  private boolean hzw = true;
  private boolean hzx = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "CardQrCodeDataInfo", "");
    hzu = new Column("code_id", "string", "CardQrCodeDataInfo", "");
    hya = new Column("card_id", "string", "CardQrCodeDataInfo", "");
    hzv = new Column("code", "string", "CardQrCodeDataInfo", "");
    hmw = new Column("status", "int", "CardQrCodeDataInfo", "");
    hzy = "code_id".hashCode();
    hyM = "card_id".hashCode();
    hzz = "code".hashCode();
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
      if (hzy != k) {
        break label60;
      }
      this.field_code_id = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hyM == k) {
        this.field_card_id = paramCursor.getString(i);
      } else if (hzz == k) {
        this.field_code = paramCursor.getString(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hzw) {
      localContentValues.put("code_id", this.field_code_id);
    }
    if (this.hyt) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.hzx) {
      localContentValues.put("code", this.field_code);
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
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
    return "CardQrCodeDataInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.as
 * JD-Core Version:    0.7.0.1
 */