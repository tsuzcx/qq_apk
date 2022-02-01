package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class gk
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("ShareCardSyncItemInfo");
  public static final Column hPZ;
  private static final int hRb = "retryCount".hashCode();
  private static final int hyM;
  public static final Column hya;
  public static final Column ijB;
  private static final int ijT;
  public static final Column ipG;
  private static final int ipO;
  public static final Column ixj;
  private static final int ixl;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_card_id;
  public int field_retryCount;
  public long field_seq;
  public int field_state_flag;
  public long field_update_time;
  private boolean hQA = true;
  private boolean hyt = true;
  private boolean ijK = true;
  private boolean ipK = true;
  private boolean ixk = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ShareCardSyncItemInfo", "");
    hya = new Column("card_id", "string", "ShareCardSyncItemInfo", "");
    ixj = new Column("state_flag", "int", "ShareCardSyncItemInfo", "");
    ijB = new Column("update_time", "long", "ShareCardSyncItemInfo", "");
    ipG = new Column("seq", "long", "ShareCardSyncItemInfo", "");
    hPZ = new Column("retrycount", "int", "ShareCardSyncItemInfo", "");
    hyM = "card_id".hashCode();
    ixl = "state_flag".hashCode();
    ijT = "update_time".hashCode();
    ipO = "seq".hashCode();
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
      if (ixl == k) {
        this.field_state_flag = paramCursor.getInt(i);
      } else if (ijT == k) {
        this.field_update_time = paramCursor.getLong(i);
      } else if (ipO == k) {
        this.field_seq = paramCursor.getLong(i);
      } else if (hRb == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hyt) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.ixk) {
      localContentValues.put("state_flag", Integer.valueOf(this.field_state_flag));
    }
    if (this.ijK) {
      localContentValues.put("update_time", Long.valueOf(this.field_update_time));
    }
    if (this.ipK) {
      localContentValues.put("seq", Long.valueOf(this.field_seq));
    }
    if (this.hQA) {
      localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
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
    return "ShareCardSyncItemInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.gk
 * JD-Core Version:    0.7.0.1
 */