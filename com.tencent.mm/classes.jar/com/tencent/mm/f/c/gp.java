package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class gp
  extends IAutoDBItem
{
  public static final Column C_KEY;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("SnsDraft");
  public static final Column hLp;
  private static final int hLy = "extFlag".hashCode();
  public static final Column hMZ;
  private static final int hNt;
  public static final Column iyt;
  private static final int iyv = "draft".hashCode();
  private static final int key_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  public byte[] field_draft;
  public int field_extFlag;
  public String field_key;
  public long field_timestamp;
  private boolean hLt = true;
  private boolean hNj = true;
  private boolean iyu = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "SnsDraft", "");
    C_KEY = new Column("key", "string", "SnsDraft", "");
    hMZ = new Column("timestamp", "long", "SnsDraft", "");
    hLp = new Column("extflag", "int", "SnsDraft", "");
    iyt = new Column("draft", "byte[]", "SnsDraft", "");
    key_HASHCODE = "key".hashCode();
    hNt = "timestamp".hashCode();
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
      if (hNt == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (hLy == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (iyv == k) {
        this.field_draft = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_key == null) {
      this.field_key = "";
    }
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.hNj) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
    }
    if (this.hLt) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.iyu) {
      localContentValues.put("draft", this.field_draft);
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
    return "SnsDraft";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.gp
 * JD-Core Version:    0.7.0.1
 */