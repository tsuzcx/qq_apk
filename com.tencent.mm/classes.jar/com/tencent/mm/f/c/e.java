package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class e
  extends IAutoDBItem
{
  public static final Column C_KEY;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("ActiveInfo");
  public static final Column hnk;
  public static final Column hnl;
  public static final Column hnm;
  private static final int hnq = "mau".hashCode();
  private static final int hnr = "dau".hashCode();
  private static final int hns = "useTime".hashCode();
  private static final int key_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  public int field_dau;
  public int field_key;
  public int field_mau;
  public long field_useTime;
  private boolean hnn = true;
  private boolean hno = true;
  private boolean hnp = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ActiveInfo", "");
    C_KEY = new Column("key", "int", "ActiveInfo", "");
    hnk = new Column("mau", "int", "ActiveInfo", "");
    hnl = new Column("dau", "int", "ActiveInfo", "");
    hnm = new Column("usetime", "long", "ActiveInfo", "");
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
      this.field_key = paramCursor.getInt(i);
      this.__hadSetkey = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hnq == k) {
        this.field_mau = paramCursor.getInt(i);
      } else if (hnr == k) {
        this.field_dau = paramCursor.getInt(i);
      } else if (hns == k) {
        this.field_useTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetkey) {
      localContentValues.put("key", Integer.valueOf(this.field_key));
    }
    if (this.hnn) {
      localContentValues.put("mau", Integer.valueOf(this.field_mau));
    }
    if (this.hno) {
      localContentValues.put("dau", Integer.valueOf(this.field_dau));
    }
    if (this.hnp) {
      localContentValues.put("useTime", Long.valueOf(this.field_useTime));
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
    return "ActiveInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.e
 * JD-Core Version:    0.7.0.1
 */