package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class gw
  extends IAutoDBItem
{
  public static final Column C_ID;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("SportStepItem");
  public static final Column hMZ;
  private static final int hNt = "timestamp".hashCode();
  private static final int id_HASHCODE;
  public static final Column ieo;
  private static final int ieq;
  public static final Column ikC;
  private static final int ikE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetid = true;
  public String field_date;
  public int field_id;
  public int field_step;
  public long field_timestamp;
  private boolean hNj = true;
  private boolean iep = true;
  private boolean ikD = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "SportStepItem", "");
    C_ID = new Column("id", "int", "SportStepItem", "");
    ikC = new Column("date", "string", "SportStepItem", "");
    ieo = new Column("step", "int", "SportStepItem", "");
    hMZ = new Column("timestamp", "long", "SportStepItem", "");
    id_HASHCODE = "id".hashCode();
    ikE = "date".hashCode();
    ieq = "step".hashCode();
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
      if (id_HASHCODE != k) {
        break label65;
      }
      this.field_id = paramCursor.getInt(i);
      this.__hadSetid = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ikE == k) {
        this.field_date = paramCursor.getString(i);
      } else if (ieq == k) {
        this.field_step = paramCursor.getInt(i);
      } else if (hNt == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetid) {
      localContentValues.put("id", Integer.valueOf(this.field_id));
    }
    if (this.ikD) {
      localContentValues.put("date", this.field_date);
    }
    if (this.iep) {
      localContentValues.put("step", Integer.valueOf(this.field_step));
    }
    if (this.hNj) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
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
    return "SportStepItem";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.gw
 * JD-Core Version:    0.7.0.1
 */