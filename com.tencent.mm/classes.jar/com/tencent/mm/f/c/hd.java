package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hd
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "TablesVersion", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("TablesVersion");
  public static final Column iBD = new Column("tablehash", "int", "TablesVersion", "");
  public static final Column iBE = new Column("tablesqlmd5", "string", "TablesVersion", "");
  private static final int iBH = "tableHash".hashCode();
  private static final int iBI = "tableSQLMD5".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_tableHash;
  public String field_tableSQLMD5;
  private boolean iBF = true;
  private boolean iBG = true;
  
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
      if (iBH != k) {
        break label65;
      }
      this.field_tableHash = paramCursor.getInt(i);
      this.iBF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iBI == k) {
        this.field_tableSQLMD5 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iBF) {
      localContentValues.put("tableHash", Integer.valueOf(this.field_tableHash));
    }
    if (this.iBG) {
      localContentValues.put("tableSQLMD5", this.field_tableSQLMD5);
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
    return "TablesVersion";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.hd
 * JD-Core Version:    0.7.0.1
 */