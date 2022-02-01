package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fg
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "OpenIMFinderInfo", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("OpenIMFinderInfo");
  public static final Column iqd = new Column("openimusername", "string", "OpenIMFinderInfo", "");
  public static final Column iqe = new Column("finder_username", "string", "OpenIMFinderInfo", "");
  private static final int iqh = "openIMUsername".hashCode();
  private static final int iqi = "finder_username".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_finder_username;
  public String field_openIMUsername;
  private boolean iqf = true;
  private boolean iqg = true;
  
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
      if (iqh != k) {
        break label60;
      }
      this.field_openIMUsername = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (iqi == k) {
        this.field_finder_username = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iqf) {
      localContentValues.put("openIMUsername", this.field_openIMUsername);
    }
    if (this.iqg) {
      localContentValues.put("finder_username", this.field_finder_username);
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
    return "OpenIMFinderInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.fg
 * JD-Core Version:    0.7.0.1
 */