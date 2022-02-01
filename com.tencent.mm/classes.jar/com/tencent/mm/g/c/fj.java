package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJv = "retryCount".hashCode();
  private static final int eRi;
  private static final int eVd;
  private static final int eZR;
  private static final int euO = "card_id".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eJd = true;
  private boolean eRa = true;
  private boolean eUZ = true;
  private boolean eZQ = true;
  private boolean euv = true;
  public String field_card_id;
  public int field_retryCount;
  public long field_seq;
  public int field_state_flag;
  public long field_update_time;
  
  static
  {
    eZR = "state_flag".hashCode();
    eRi = "update_time".hashCode();
    eVd = "seq".hashCode();
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
      if (euO != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.euv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eZR == k) {
        this.field_state_flag = paramCursor.getInt(i);
      } else if (eRi == k) {
        this.field_update_time = paramCursor.getLong(i);
      } else if (eVd == k) {
        this.field_seq = paramCursor.getLong(i);
      } else if (eJv == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.euv) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.eZQ) {
      localContentValues.put("state_flag", Integer.valueOf(this.field_state_flag));
    }
    if (this.eRa) {
      localContentValues.put("update_time", Long.valueOf(this.field_update_time));
    }
    if (this.eUZ) {
      localContentValues.put("seq", Long.valueOf(this.field_seq));
    }
    if (this.eJd) {
      localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fj
 * JD-Core Version:    0.7.0.1
 */