package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ej
  extends c
{
  private static final int cZl = "tableHash".hashCode();
  private static final int cZm = "tableSQLMD5".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private boolean cZj = true;
  private boolean cZk = true;
  public int field_tableHash;
  public String field_tableSQLMD5;
  
  public final void d(Cursor paramCursor)
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
      if (cZl != k) {
        break label65;
      }
      this.field_tableHash = paramCursor.getInt(i);
      this.cZj = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cZm == k) {
        this.field_tableSQLMD5 = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cZj) {
      localContentValues.put("tableHash", Integer.valueOf(this.field_tableHash));
    }
    if (this.cZk) {
      localContentValues.put("tableSQLMD5", this.field_tableSQLMD5);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.c.ej
 * JD-Core Version:    0.7.0.1
 */