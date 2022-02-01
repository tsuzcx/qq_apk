package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ff
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGD = "retryCount".hashCode();
  private static final int eOe;
  private static final int eRT;
  private static final int eWD;
  private static final int esK = "card_id".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGl = true;
  private boolean eNW = true;
  private boolean eRP = true;
  private boolean eWC = true;
  private boolean esr = true;
  public String field_card_id;
  public int field_retryCount;
  public long field_seq;
  public int field_state_flag;
  public long field_update_time;
  
  static
  {
    eWD = "state_flag".hashCode();
    eOe = "update_time".hashCode();
    eRT = "seq".hashCode();
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
      if (esK != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.esr = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eWD == k) {
        this.field_state_flag = paramCursor.getInt(i);
      } else if (eOe == k) {
        this.field_update_time = paramCursor.getLong(i);
      } else if (eRT == k) {
        this.field_seq = paramCursor.getLong(i);
      } else if (eGD == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.esr) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.eWC) {
      localContentValues.put("state_flag", Integer.valueOf(this.field_state_flag));
    }
    if (this.eNW) {
      localContentValues.put("update_time", Long.valueOf(this.field_update_time));
    }
    if (this.eRP) {
      localContentValues.put("seq", Long.valueOf(this.field_seq));
    }
    if (this.eGl) {
      localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ff
 * JD-Core Version:    0.7.0.1
 */