package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fu
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eNW = "card_id".hashCode();
  private static final int faa = "retryCount".hashCode();
  private static final int flC;
  private static final int fpt;
  private static final int fuf = "state_flag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eND = true;
  private boolean eZP = true;
  public String field_card_id;
  public int field_retryCount;
  public long field_seq;
  public int field_state_flag;
  public long field_update_time;
  private boolean flu = true;
  private boolean fpo = true;
  private boolean fue = true;
  
  static
  {
    flC = "update_time".hashCode();
    fpt = "seq".hashCode();
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
      if (eNW != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.eND = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fuf == k) {
        this.field_state_flag = paramCursor.getInt(i);
      } else if (flC == k) {
        this.field_update_time = paramCursor.getLong(i);
      } else if (fpt == k) {
        this.field_seq = paramCursor.getLong(i);
      } else if (faa == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eND) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.fue) {
      localContentValues.put("state_flag", Integer.valueOf(this.field_state_flag));
    }
    if (this.flu) {
      localContentValues.put("update_time", Long.valueOf(this.field_update_time));
    }
    if (this.fpo) {
      localContentValues.put("seq", Long.valueOf(this.field_seq));
    }
    if (this.eZP) {
      localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fu
 * JD-Core Version:    0.7.0.1
 */