package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gn
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fkX = "size".hashCode();
  private static final int fyj = "state".hashCode();
  private static final int gaA = "top".hashCode();
  private static final int gaB = "bottom".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_bottom;
  public int field_size;
  public int field_state;
  public long field_top;
  private boolean fkV = true;
  private boolean fxx = true;
  private boolean gay = true;
  private boolean gaz = true;
  
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
      if (gaA != k) {
        break label60;
      }
      this.field_top = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (gaB == k)
      {
        this.field_bottom = paramCursor.getLong(i);
        this.gaz = true;
      }
      else if (fkX == k)
      {
        this.field_size = paramCursor.getInt(i);
      }
      else if (fyj == k)
      {
        this.field_state = paramCursor.getInt(i);
      }
      else if (rowid_HASHCODE == k)
      {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.gay) {
      localContentValues.put("top", Long.valueOf(this.field_top));
    }
    if (this.gaz) {
      localContentValues.put("bottom", Long.valueOf(this.field_bottom));
    }
    if (this.fkV) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.fxx) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gn
 * JD-Core Version:    0.7.0.1
 */