package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ft
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eMl = "card_id".hashCode();
  private static final int eYo = "retryCount".hashCode();
  private static final int fjF;
  private static final int fns;
  private static final int fsf = "state_flag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eLS = true;
  private boolean eYe = true;
  public String field_card_id;
  public int field_retryCount;
  public long field_seq;
  public int field_state_flag;
  public long field_update_time;
  private boolean fjx = true;
  private boolean fno = true;
  private boolean fse = true;
  
  static
  {
    fjF = "update_time".hashCode();
    fns = "seq".hashCode();
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
      if (eMl != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.eLS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fsf == k) {
        this.field_state_flag = paramCursor.getInt(i);
      } else if (fjF == k) {
        this.field_update_time = paramCursor.getLong(i);
      } else if (fns == k) {
        this.field_seq = paramCursor.getLong(i);
      } else if (eYo == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eLS) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.fse) {
      localContentValues.put("state_flag", Integer.valueOf(this.field_state_flag));
    }
    if (this.fjx) {
      localContentValues.put("update_time", Long.valueOf(this.field_update_time));
    }
    if (this.fno) {
      localContentValues.put("seq", Long.valueOf(this.field_seq));
    }
    if (this.eYe) {
      localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ft
 * JD-Core Version:    0.7.0.1
 */