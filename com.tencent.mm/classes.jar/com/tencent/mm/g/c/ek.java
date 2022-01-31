package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ek
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dNQ = "state_flag".hashCode();
  private static final int dNR = "update_time".hashCode();
  private static final int dNS = "seq".hashCode();
  private static final int dnT = "card_id".hashCode();
  private static final int dzV = "retryCount".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dNN = true;
  private boolean dNO = true;
  private boolean dNP = true;
  private boolean dnA = true;
  private boolean dzC = true;
  public String field_card_id;
  public int field_retryCount;
  public long field_seq;
  public int field_state_flag;
  public long field_update_time;
  
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
      if (dnT != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.dnA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dNQ == k) {
        this.field_state_flag = paramCursor.getInt(i);
      } else if (dNR == k) {
        this.field_update_time = paramCursor.getLong(i);
      } else if (dNS == k) {
        this.field_seq = paramCursor.getLong(i);
      } else if (dzV == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dnA) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.dNN) {
      localContentValues.put("state_flag", Integer.valueOf(this.field_state_flag));
    }
    if (this.dNO) {
      localContentValues.put("update_time", Long.valueOf(this.field_update_time));
    }
    if (this.dNP) {
      localContentValues.put("seq", Long.valueOf(this.field_seq));
    }
    if (this.dzC) {
      localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ek
 * JD-Core Version:    0.7.0.1
 */