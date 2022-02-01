package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCC = "timestamp".hashCode();
  private static final int eKG;
  private static final int eOw;
  private static final int exb = "id".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCs = true;
  private boolean eKF = true;
  private boolean eOv = true;
  private boolean ewY = true;
  public String field_date;
  public int field_id;
  public int field_step;
  public long field_timestamp;
  
  static
  {
    eOw = "date".hashCode();
    eKG = "step".hashCode();
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
      if (exb != k) {
        break label65;
      }
      this.field_id = paramCursor.getInt(i);
      this.ewY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eOw == k) {
        this.field_date = paramCursor.getString(i);
      } else if (eKG == k) {
        this.field_step = paramCursor.getInt(i);
      } else if (eCC == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ewY) {
      localContentValues.put("id", Integer.valueOf(this.field_id));
    }
    if (this.eOv) {
      localContentValues.put("date", this.field_date);
    }
    if (this.eKF) {
      localContentValues.put("step", Integer.valueOf(this.field_step));
    }
    if (this.eCs) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fp
 * JD-Core Version:    0.7.0.1
 */