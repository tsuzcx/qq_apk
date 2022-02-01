package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class cn
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fFV = "ds".hashCode();
  private static final int fFW = "hour".hashCode();
  private static final int fFX = "actionMs".hashCode();
  private static final int fFY = "isGoToFinderUI".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fFR = true;
  private boolean fFS = true;
  private boolean fFT = true;
  private boolean fFU = true;
  public long field_actionMs;
  public int field_ds;
  public int field_hour;
  public int field_isGoToFinderUI;
  
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
      if (fFV != k) {
        break label60;
      }
      this.field_ds = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (fFW == k) {
        this.field_hour = paramCursor.getInt(i);
      } else if (fFX == k) {
        this.field_actionMs = paramCursor.getLong(i);
      } else if (fFY == k) {
        this.field_isGoToFinderUI = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fFR) {
      localContentValues.put("ds", Integer.valueOf(this.field_ds));
    }
    if (this.fFS) {
      localContentValues.put("hour", Integer.valueOf(this.field_hour));
    }
    if (this.fFT) {
      localContentValues.put("actionMs", Long.valueOf(this.field_actionMs));
    }
    if (this.fFU) {
      localContentValues.put("isGoToFinderUI", Integer.valueOf(this.field_isGoToFinderUI));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.cn
 * JD-Core Version:    0.7.0.1
 */