package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gd
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fDK = "retryCount".hashCode();
  private static final int fQg;
  private static final int fTY;
  private static final int fYO;
  private static final int frD = "card_id".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fDu = true;
  private boolean fPY = true;
  private boolean fTU = true;
  private boolean fYN = true;
  public String field_card_id;
  public int field_retryCount;
  public long field_seq;
  public int field_state_flag;
  public long field_update_time;
  private boolean frk = true;
  
  static
  {
    fYO = "state_flag".hashCode();
    fQg = "update_time".hashCode();
    fTY = "seq".hashCode();
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
      if (frD != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.frk = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fYO == k) {
        this.field_state_flag = paramCursor.getInt(i);
      } else if (fQg == k) {
        this.field_update_time = paramCursor.getLong(i);
      } else if (fTY == k) {
        this.field_seq = paramCursor.getLong(i);
      } else if (fDK == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.frk) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.fYN) {
      localContentValues.put("state_flag", Integer.valueOf(this.field_state_flag));
    }
    if (this.fPY) {
      localContentValues.put("update_time", Long.valueOf(this.field_update_time));
    }
    if (this.fTU) {
      localContentValues.put("seq", Long.valueOf(this.field_seq));
    }
    if (this.fDu) {
      localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gd
 * JD-Core Version:    0.7.0.1
 */