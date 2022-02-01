package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ft
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEW = "timestamp".hashCode();
  private static final int eNy;
  private static final int eRE;
  private static final int ewX = "id".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEM = true;
  private boolean eNx = true;
  private boolean eRD = true;
  private boolean ewT = true;
  public String field_date;
  public int field_id;
  public int field_step;
  public long field_timestamp;
  
  static
  {
    eRE = "date".hashCode();
    eNy = "step".hashCode();
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
      if (ewX != k) {
        break label65;
      }
      this.field_id = paramCursor.getInt(i);
      this.ewT = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eRE == k) {
        this.field_date = paramCursor.getString(i);
      } else if (eNy == k) {
        this.field_step = paramCursor.getInt(i);
      } else if (eEW == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ewT) {
      localContentValues.put("id", Integer.valueOf(this.field_id));
    }
    if (this.eRD) {
      localContentValues.put("date", this.field_date);
    }
    if (this.eNx) {
      localContentValues.put("step", Integer.valueOf(this.field_step));
    }
    if (this.eEM) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ft
 * JD-Core Version:    0.7.0.1
 */