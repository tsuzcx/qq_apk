package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gw
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int gbS = "tableHash".hashCode();
  private static final int gbT = "tableSQLMD5".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_tableHash;
  public String field_tableSQLMD5;
  private boolean gbQ = true;
  private boolean gbR = true;
  
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
      if (gbS != k) {
        break label65;
      }
      this.field_tableHash = paramCursor.getInt(i);
      this.gbQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (gbT == k) {
        this.field_tableSQLMD5 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.gbQ) {
      localContentValues.put("tableHash", Integer.valueOf(this.field_tableHash));
    }
    if (this.gbR) {
      localContentValues.put("tableSQLMD5", this.field_tableSQLMD5);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gw
 * JD-Core Version:    0.7.0.1
 */