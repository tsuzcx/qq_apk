package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hw
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WebViewHostsFilter");
  private static final int hZD = "expireTime".hashCode();
  public static final Column hZf;
  public static final Column iJZ;
  private static final int iKb;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_expireTime;
  public String field_host;
  private boolean hZr = true;
  private boolean iKa = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WebViewHostsFilter", "");
    iJZ = new Column("host", "string", "WebViewHostsFilter", "");
    hZf = new Column("expiretime", "long", "WebViewHostsFilter", "");
    iKb = "host".hashCode();
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
      if (iKb != k) {
        break label60;
      }
      this.field_host = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hZD == k) {
        this.field_expireTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iKa) {
      localContentValues.put("host", this.field_host);
    }
    if (this.hZr) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
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
    return "WebViewHostsFilter";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.hw
 * JD-Core Version:    0.7.0.1
 */