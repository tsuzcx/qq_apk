package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ap
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int esK = "card_id".hashCode();
  private static final int etg = "lower_bound".hashCode();
  private static final int eth = "need_insert_show_timestamp".hashCode();
  private static final int eti = "show_timestamp_encrypt_key".hashCode();
  private static final int etj = "expire_time_interval".hashCode();
  private static final int etk = "show_expire_interval".hashCode();
  private static final int etl = "fetch_time".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean esr = true;
  private boolean eta = true;
  private boolean etb = true;
  private boolean etc = true;
  private boolean etd = true;
  private boolean ete = true;
  private boolean etf = true;
  public String field_card_id;
  public int field_expire_time_interval;
  public long field_fetch_time;
  public int field_lower_bound;
  public boolean field_need_insert_show_timestamp;
  public int field_show_expire_interval;
  public String field_show_timestamp_encrypt_key;
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
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
      if (etg == k)
      {
        this.field_lower_bound = paramCursor.getInt(i);
      }
      else
      {
        if (eth == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_need_insert_show_timestamp = bool;
            break;
          }
        }
        if (eti == k) {
          this.field_show_timestamp_encrypt_key = paramCursor.getString(i);
        } else if (etj == k) {
          this.field_expire_time_interval = paramCursor.getInt(i);
        } else if (etk == k) {
          this.field_show_expire_interval = paramCursor.getInt(i);
        } else if (etl == k) {
          this.field_fetch_time = paramCursor.getLong(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.esr) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.eta) {
      localContentValues.put("lower_bound", Integer.valueOf(this.field_lower_bound));
    }
    if (this.etb) {
      localContentValues.put("need_insert_show_timestamp", Boolean.valueOf(this.field_need_insert_show_timestamp));
    }
    if (this.etc) {
      localContentValues.put("show_timestamp_encrypt_key", this.field_show_timestamp_encrypt_key);
    }
    if (this.etd) {
      localContentValues.put("expire_time_interval", Integer.valueOf(this.field_expire_time_interval));
    }
    if (this.ete) {
      localContentValues.put("show_expire_interval", Integer.valueOf(this.field_show_expire_interval));
    }
    if (this.etf) {
      localContentValues.put("fetch_time", Long.valueOf(this.field_fetch_time));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ap
 * JD-Core Version:    0.7.0.1
 */