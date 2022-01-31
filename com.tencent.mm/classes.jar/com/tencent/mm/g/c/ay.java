package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ay
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dsb = "bakLogId".hashCode();
  private static final int dsc = "valueStr".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean drZ;
  private boolean dsa;
  public int field_bakLogId;
  public String field_valueStr;
  
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
      if (dsb != k) {
        break label60;
      }
      this.field_bakLogId = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (dsc == k) {
        this.field_valueStr = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.drZ) {
      localContentValues.put("bakLogId", Integer.valueOf(this.field_bakLogId));
    }
    if (this.dsa) {
      localContentValues.put("valueStr", this.field_valueStr);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ay
 * JD-Core Version:    0.7.0.1
 */