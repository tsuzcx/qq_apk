package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ba
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "ContactLabelCache", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("ContactLabelCache");
  public static final Column hDH = new Column("labelid", "string", "ContactLabelCache", "");
  public static final Column hDW = new Column("contactname", "string", "ContactLabelCache", "");
  private static final int hDX = "labelId".hashCode();
  private static final int hDY = "contactName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_contactName;
  public String field_labelId;
  
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
        if (hDX == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (hDY == k)
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
    return "ContactLabelCache";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ba
 * JD-Core Version:    0.7.0.1
 */