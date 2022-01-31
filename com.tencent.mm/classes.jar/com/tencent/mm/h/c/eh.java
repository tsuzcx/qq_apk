package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eh
  extends c
{
  private static final int cDW;
  private static final int cII = "timestamp".hashCode();
  private static final int cNm;
  private static final int cZc;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private boolean cDT = true;
  private boolean cIy = true;
  private boolean cNl = true;
  private boolean cZb = true;
  public String field_date;
  public int field_id;
  public int field_step;
  public long field_timestamp;
  
  static
  {
    cDW = "id".hashCode();
    cZc = "date".hashCode();
    cNm = "step".hashCode();
  }
  
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
      if (cDW != k) {
        break label65;
      }
      this.field_id = paramCursor.getInt(i);
      this.cDT = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cZc == k) {
        this.field_date = paramCursor.getString(i);
      } else if (cNm == k) {
        this.field_step = paramCursor.getInt(i);
      } else if (cII == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cDT) {
      localContentValues.put("id", Integer.valueOf(this.field_id));
    }
    if (this.cZb) {
      localContentValues.put("date", this.field_date);
    }
    if (this.cNl) {
      localContentValues.put("step", Integer.valueOf(this.field_step));
    }
    if (this.cIy) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.eh
 * JD-Core Version:    0.7.0.1
 */