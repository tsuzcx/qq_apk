package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class bf
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "DuplicateKVLog", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("DuplicateKVLog");
  public static final Column hFe = new Column("baklogid", "int", "DuplicateKVLog", "");
  public static final Column hFf = new Column("valuestr", "string", "DuplicateKVLog", "");
  private static final int hFg = "bakLogId".hashCode();
  private static final int hFh = "valueStr".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_bakLogId;
  public String field_valueStr;
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {}
    for (;;)
    {
      return;
      int i = 0;
      int j = arrayOfString.length;
      while (i < j)
      {
        int k = arrayOfString[i].hashCode();
        if (hFg == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (hFh == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
        i += 1;
      }
    }
  }
  
  public ContentValues convertTo()
  {
    new ContentValues();
    throw null;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "DuplicateKVLog";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.bf
 * JD-Core Version:    0.7.0.1
 */