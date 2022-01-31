package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class l
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crQ = "key".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int ctO = "data".hashCode();
  private static final int ctR = "dataType".hashCode();
  private static final int ctS = "size".hashCode();
  private boolean crM = true;
  private boolean ctK = true;
  private boolean ctP = true;
  private boolean ctQ = true;
  public String field_data;
  public String field_dataType;
  public String field_key;
  public int field_size;
  
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
      if (crQ != k) {
        break label65;
      }
      this.field_key = paramCursor.getString(i);
      this.crM = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ctO == k) {
        this.field_data = paramCursor.getString(i);
      } else if (ctR == k) {
        this.field_dataType = paramCursor.getString(i);
      } else if (ctS == k) {
        this.field_size = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.crM) {
      localContentValues.put("key", this.field_key);
    }
    if (this.ctK) {
      localContentValues.put("data", this.field_data);
    }
    if (this.ctP) {
      localContentValues.put("dataType", this.field_dataType);
    }
    if (this.ctQ) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.c.l
 * JD-Core Version:    0.7.0.1
 */