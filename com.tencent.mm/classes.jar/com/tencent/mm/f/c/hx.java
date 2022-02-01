package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hx
  extends IAutoDBItem
{
  public static final Column C_KEY;
  public static final Column C_ROWID;
  public static final Column C_VALUE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WebviewLocalData");
  public static final Column hnz;
  private static final int hoh;
  public static final Column hpi;
  private static final int hpq;
  public static final Column iKc;
  private static final int iKe;
  private static final int key_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE;
  private boolean __hadSetkey = true;
  private boolean __hadSetvalue = true;
  public String field_appId;
  public String field_domin;
  public String field_key;
  public int field_recordId;
  public String field_value;
  private boolean hnQ = true;
  private boolean hpm = true;
  private boolean iKd = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WebviewLocalData", "");
    hpi = new Column("recordid", "int", "WebviewLocalData", "");
    hnz = new Column("appid", "string", "WebviewLocalData", "");
    iKc = new Column("domin", "string", "WebviewLocalData", "");
    C_KEY = new Column("key", "string", "WebviewLocalData", "");
    C_VALUE = new Column("value", "string", "WebviewLocalData", "");
    hpq = "recordId".hashCode();
    hoh = "appId".hashCode();
    iKe = "domin".hashCode();
    key_HASHCODE = "key".hashCode();
    value_HASHCODE = "value".hashCode();
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
      if (hpq != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getInt(i);
      this.hpm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hoh == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (iKe == k) {
        this.field_domin = paramCursor.getString(i);
      } else if (key_HASHCODE == k) {
        this.field_key = paramCursor.getString(i);
      } else if (value_HASHCODE == k) {
        this.field_value = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hpm) {
      localContentValues.put("recordId", Integer.valueOf(this.field_recordId));
    }
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.iKd) {
      localContentValues.put("domin", this.field_domin);
    }
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
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
    return "WebviewLocalData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.hx
 * JD-Core Version:    0.7.0.1
 */