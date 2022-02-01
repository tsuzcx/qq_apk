package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class o
  extends IAutoDBItem
{
  public static final Column C_KEY;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("AppBrandKVData");
  public static final Column hoE;
  private static final int hoM = "data".hashCode();
  public static final Column hpc;
  public static final Column hpd;
  private static final int hpg = "dataType".hashCode();
  private static final int hph = "size".hashCode();
  private static final int key_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  public String field_data;
  public String field_dataType;
  public String field_key;
  public int field_size;
  private boolean hoI = true;
  private boolean hpe = true;
  private boolean hpf = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "AppBrandKVData", "");
    C_KEY = new Column("key", "string", "AppBrandKVData", "");
    hoE = new Column("data", "string", "AppBrandKVData", "");
    hpc = new Column("datatype", "string", "AppBrandKVData", "");
    hpd = new Column("size", "int", "AppBrandKVData", "");
    key_HASHCODE = "key".hashCode();
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
      if (key_HASHCODE != k) {
        break label65;
      }
      this.field_key = paramCursor.getString(i);
      this.__hadSetkey = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hoM == k) {
        this.field_data = paramCursor.getString(i);
      } else if (hpg == k) {
        this.field_dataType = paramCursor.getString(i);
      } else if (hph == k) {
        this.field_size = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.hoI) {
      localContentValues.put("data", this.field_data);
    }
    if (this.hpe) {
      localContentValues.put("dataType", this.field_dataType);
    }
    if (this.hpf) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
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
    return "AppBrandKVData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.o
 * JD-Core Version:    0.7.0.1
 */