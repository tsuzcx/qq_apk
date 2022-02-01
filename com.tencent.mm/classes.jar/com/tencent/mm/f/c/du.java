package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class du
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("HardDeviceProfileRankDetail");
  public static final Column hsa;
  private static final int hsg = "title".hashCode();
  public static final Column iee;
  private static final int iek;
  public static final Column iem;
  private static final int ien = "score".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appusername;
  public int field_score;
  public String field_title;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "HardDeviceProfileRankDetail", "");
    iee = new Column("appusername", "string", "HardDeviceProfileRankDetail", "");
    hsa = new Column("title", "string", "HardDeviceProfileRankDetail", "");
    iem = new Column("score", "int", "HardDeviceProfileRankDetail", "");
    iek = "appusername".hashCode();
  }
  
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
        if (iek == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (hsg == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (ien == k)
        {
          paramCursor.getInt(i);
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
    return "HardDeviceProfileRankDetail";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.du
 * JD-Core Version:    0.7.0.1
 */