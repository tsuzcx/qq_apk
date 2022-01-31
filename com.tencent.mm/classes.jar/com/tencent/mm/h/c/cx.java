package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cx
  extends c
{
  private static final int cSW;
  private static final int cSX;
  private static final int cSY = "receive_time".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private boolean cST = true;
  private boolean cSU = true;
  private boolean cSV = true;
  private boolean crk = true;
  public String field_ack_key;
  public long field_receive_time;
  public String field_reqkey;
  public int field_status;
  
  static
  {
    cSW = "reqkey".hashCode();
    cSX = "ack_key".hashCode();
    crn = "status".hashCode();
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
      if (cSW != k) {
        break label65;
      }
      this.field_reqkey = paramCursor.getString(i);
      this.cST = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cSX == k) {
        this.field_ack_key = paramCursor.getString(i);
      } else if (crn == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (cSY == k) {
        this.field_receive_time = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cST) {
      localContentValues.put("reqkey", this.field_reqkey);
    }
    if (this.cSU) {
      localContentValues.put("ack_key", this.field_ack_key);
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.cSV) {
      localContentValues.put("receive_time", Long.valueOf(this.field_receive_time));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.cx
 * JD-Core Version:    0.7.0.1
 */