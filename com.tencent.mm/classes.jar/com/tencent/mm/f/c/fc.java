package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fc
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("OfflineOrderStatus");
  private static final int hmC = "status".hashCode();
  public static final Column hmw;
  private static final int ipA;
  private static final int ipB;
  private static final int ipC = "receive_time".hashCode();
  public static final Column ipu;
  public static final Column ipv;
  public static final Column ipw;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_ack_key;
  public long field_receive_time;
  public String field_reqkey;
  public int field_status;
  private boolean hmz = true;
  private boolean ipx = true;
  private boolean ipy = true;
  private boolean ipz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "OfflineOrderStatus", "");
    ipu = new Column("reqkey", "string", "OfflineOrderStatus", "");
    ipv = new Column("ack_key", "string", "OfflineOrderStatus", "");
    hmw = new Column("status", "int", "OfflineOrderStatus", "");
    ipw = new Column("receive_time", "long", "OfflineOrderStatus", "");
    ipA = "reqkey".hashCode();
    ipB = "ack_key".hashCode();
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
      if (ipA != k) {
        break label65;
      }
      this.field_reqkey = paramCursor.getString(i);
      this.ipx = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ipB == k) {
        this.field_ack_key = paramCursor.getString(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (ipC == k) {
        this.field_receive_time = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ipx) {
      localContentValues.put("reqkey", this.field_reqkey);
    }
    if (this.ipy) {
      localContentValues.put("ack_key", this.field_ack_key);
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.ipz) {
      localContentValues.put("receive_time", Long.valueOf(this.field_receive_time));
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
    return "OfflineOrderStatus";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.fc
 * JD-Core Version:    0.7.0.1
 */