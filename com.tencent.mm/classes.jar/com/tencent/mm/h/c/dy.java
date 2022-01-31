package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dy
  extends c
{
  private static final int cKL = "retryCount".hashCode();
  private static final int cXw;
  private static final int cXx;
  private static final int cXy;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int czR = "card_id".hashCode();
  private boolean cKs = true;
  private boolean cXt = true;
  private boolean cXu = true;
  private boolean cXv = true;
  private boolean czz = true;
  public String field_card_id;
  public int field_retryCount;
  public long field_seq;
  public int field_state_flag;
  public long field_update_time;
  
  static
  {
    cXw = "state_flag".hashCode();
    cXx = "update_time".hashCode();
    cXy = "seq".hashCode();
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
      if (czR != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.czz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cXw == k) {
        this.field_state_flag = paramCursor.getInt(i);
      } else if (cXx == k) {
        this.field_update_time = paramCursor.getLong(i);
      } else if (cXy == k) {
        this.field_seq = paramCursor.getLong(i);
      } else if (cKL == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.czz) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.cXt) {
      localContentValues.put("state_flag", Integer.valueOf(this.field_state_flag));
    }
    if (this.cXu) {
      localContentValues.put("update_time", Long.valueOf(this.field_update_time));
    }
    if (this.cXv) {
      localContentValues.put("seq", Long.valueOf(this.field_seq));
    }
    if (this.cKs) {
      localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.dy
 * JD-Core Version:    0.7.0.1
 */