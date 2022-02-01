package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ar
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("CardQrCodeConfi");
  private static final int hyM = "card_id".hashCode();
  public static final Column hya;
  public static final Column hzc;
  public static final Column hzd;
  public static final Column hze;
  public static final Column hzf;
  public static final Column hzg;
  public static final Column hzh;
  private static final int hzo = "lower_bound".hashCode();
  private static final int hzp = "need_insert_show_timestamp".hashCode();
  private static final int hzq = "show_timestamp_encrypt_key".hashCode();
  private static final int hzr = "expire_time_interval".hashCode();
  private static final int hzs = "show_expire_interval".hashCode();
  private static final int hzt = "fetch_time".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_card_id;
  public int field_expire_time_interval;
  public long field_fetch_time;
  public int field_lower_bound;
  public boolean field_need_insert_show_timestamp;
  public int field_show_expire_interval;
  public String field_show_timestamp_encrypt_key;
  private boolean hyt = true;
  private boolean hzi = true;
  private boolean hzj = true;
  private boolean hzk = true;
  private boolean hzl = true;
  private boolean hzm = true;
  private boolean hzn = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "CardQrCodeConfi", "");
    hya = new Column("card_id", "string", "CardQrCodeConfi", "");
    hzc = new Column("lower_bound", "int", "CardQrCodeConfi", "");
    hzd = new Column("need_insert_show_timestamp", "boolean", "CardQrCodeConfi", "");
    hze = new Column("show_timestamp_encrypt_key", "string", "CardQrCodeConfi", "");
    hzf = new Column("expire_time_interval", "int", "CardQrCodeConfi", "");
    hzg = new Column("show_expire_interval", "int", "CardQrCodeConfi", "");
    hzh = new Column("fetch_time", "long", "CardQrCodeConfi", "");
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (hyM != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.hyt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hzo == k)
      {
        this.field_lower_bound = paramCursor.getInt(i);
      }
      else
      {
        if (hzp == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_need_insert_show_timestamp = bool;
            break;
          }
        }
        if (hzq == k) {
          this.field_show_timestamp_encrypt_key = paramCursor.getString(i);
        } else if (hzr == k) {
          this.field_expire_time_interval = paramCursor.getInt(i);
        } else if (hzs == k) {
          this.field_show_expire_interval = paramCursor.getInt(i);
        } else if (hzt == k) {
          this.field_fetch_time = paramCursor.getLong(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hyt) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.hzi) {
      localContentValues.put("lower_bound", Integer.valueOf(this.field_lower_bound));
    }
    if (this.hzj) {
      localContentValues.put("need_insert_show_timestamp", Boolean.valueOf(this.field_need_insert_show_timestamp));
    }
    if (this.hzk) {
      localContentValues.put("show_timestamp_encrypt_key", this.field_show_timestamp_encrypt_key);
    }
    if (this.hzl) {
      localContentValues.put("expire_time_interval", Integer.valueOf(this.field_expire_time_interval));
    }
    if (this.hzm) {
      localContentValues.put("show_expire_interval", Integer.valueOf(this.field_show_expire_interval));
    }
    if (this.hzn) {
      localContentValues.put("fetch_time", Long.valueOf(this.field_fetch_time));
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
    return "CardQrCodeConfi";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.ar
 * JD-Core Version:    0.7.0.1
 */