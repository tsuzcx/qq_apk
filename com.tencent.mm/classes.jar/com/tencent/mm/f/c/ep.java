package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ep
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "LuckyMoneyDetailOpenRecord", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("LuckyMoneyDetailOpenRecord");
  public static final Column ikk = new Column("send_id", "string", "LuckyMoneyDetailOpenRecord", "");
  public static final Column ikl = new Column("open_count", "int", "LuckyMoneyDetailOpenRecord", "");
  private static final int iko = "send_id".hashCode();
  private static final int ikp = "open_count".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_open_count;
  public String field_send_id;
  private boolean ikm = true;
  private boolean ikn = true;
  
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
      if (iko != k) {
        break label65;
      }
      this.field_send_id = paramCursor.getString(i);
      this.ikm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ikp == k) {
        this.field_open_count = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ikm) {
      localContentValues.put("send_id", this.field_send_id);
    }
    if (this.ikn) {
      localContentValues.put("open_count", Integer.valueOf(this.field_open_count));
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
    return "LuckyMoneyDetailOpenRecord";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ep
 * JD-Core Version:    0.7.0.1
 */