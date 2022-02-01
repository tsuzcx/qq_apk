package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gp
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fBI = "timestamp".hashCode();
  private static final int fMu;
  private static final int fQC;
  private static final int id_HASHCODE = "id".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetid = true;
  private boolean fBy = true;
  private boolean fMt = true;
  private boolean fQB = true;
  public String field_date;
  public int field_id;
  public int field_step;
  public long field_timestamp;
  
  static
  {
    fQC = "date".hashCode();
    fMu = "step".hashCode();
  }
  
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
      if (id_HASHCODE != k) {
        break label65;
      }
      this.field_id = paramCursor.getInt(i);
      this.__hadSetid = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fQC == k) {
        this.field_date = paramCursor.getString(i);
      } else if (fMu == k) {
        this.field_step = paramCursor.getInt(i);
      } else if (fBI == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetid) {
      localContentValues.put("id", Integer.valueOf(this.field_id));
    }
    if (this.fQB) {
      localContentValues.put("date", this.field_date);
    }
    if (this.fMt) {
      localContentValues.put("step", Integer.valueOf(this.field_step));
    }
    if (this.fBy) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gp
 * JD-Core Version:    0.7.0.1
 */