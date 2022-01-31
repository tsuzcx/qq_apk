package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ak
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dnT = "card_id".hashCode();
  private static final int dop = "lower_bound".hashCode();
  private static final int doq = "need_insert_show_timestamp".hashCode();
  private static final int dor = "show_timestamp_encrypt_key".hashCode();
  private static final int dos = "expire_time_interval".hashCode();
  private static final int dot = "show_expire_interval".hashCode();
  private static final int dou = "fetch_time".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dnA = true;
  private boolean doj = true;
  private boolean dok = true;
  private boolean dol = true;
  private boolean dom = true;
  private boolean don = true;
  private boolean doo = true;
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
      if (dop == k)
      {
        this.field_lower_bound = paramCursor.getInt(i);
      }
      else
      {
        if (doq == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_need_insert_show_timestamp = bool;
            break;
          }
        }
        if (dor == k) {
          this.field_show_timestamp_encrypt_key = paramCursor.getString(i);
        } else if (dos == k) {
          this.field_expire_time_interval = paramCursor.getInt(i);
        } else if (dot == k) {
          this.field_show_expire_interval = paramCursor.getInt(i);
        } else if (dou == k) {
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
    if (this.dnA) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.doj) {
      localContentValues.put("lower_bound", Integer.valueOf(this.field_lower_bound));
    }
    if (this.dok) {
      localContentValues.put("need_insert_show_timestamp", Boolean.valueOf(this.field_need_insert_show_timestamp));
    }
    if (this.dol) {
      localContentValues.put("show_timestamp_encrypt_key", this.field_show_timestamp_encrypt_key);
    }
    if (this.dom) {
      localContentValues.put("expire_time_interval", Integer.valueOf(this.field_expire_time_interval));
    }
    if (this.don) {
      localContentValues.put("show_expire_interval", Integer.valueOf(this.field_show_expire_interval));
    }
    if (this.doo) {
      localContentValues.put("fetch_time", Long.valueOf(this.field_fetch_time));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.ak
 * JD-Core Version:    0.7.0.1
 */