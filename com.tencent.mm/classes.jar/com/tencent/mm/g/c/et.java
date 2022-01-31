package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class et
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dDc = "step".hashCode();
  private static final int dGu;
  private static final int dsg = "id".hashCode();
  private static final int dxs = "timestamp".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dDb = true;
  private boolean dGt = true;
  private boolean dsd = true;
  private boolean dxi = true;
  public String field_date;
  public int field_id;
  public int field_step;
  public long field_timestamp;
  
  static
  {
    dGu = "date".hashCode();
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
      if (dsg != k) {
        break label65;
      }
      this.field_id = paramCursor.getInt(i);
      this.dsd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dGu == k) {
        this.field_date = paramCursor.getString(i);
      } else if (dDc == k) {
        this.field_step = paramCursor.getInt(i);
      } else if (dxs == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dsd) {
      localContentValues.put("id", Integer.valueOf(this.field_id));
    }
    if (this.dGt) {
      localContentValues.put("date", this.field_date);
    }
    if (this.dDb) {
      localContentValues.put("step", Integer.valueOf(this.field_step));
    }
    if (this.dxi) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.et
 * JD-Core Version:    0.7.0.1
 */