package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class gg
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("SelectRecord");
  public static final Column hml;
  private static final int hmt = "msgId".hashCode();
  public static final Column ikV;
  private static final int ilg;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_historyId;
  public long field_msgId;
  private boolean hmp = true;
  private boolean ile = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "SelectRecord", "");
    ikV = new Column("historyid", "string", "SelectRecord", "");
    hml = new Column("msgid", "long", "SelectRecord", "");
    ilg = "historyId".hashCode();
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
      if (ilg != k) {
        break label60;
      }
      this.field_historyId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hmt == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ile) {
      localContentValues.put("historyId", this.field_historyId);
    }
    if (this.hmp) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
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
    return "SelectRecord";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.gg
 * JD-Core Version:    0.7.0.1
 */