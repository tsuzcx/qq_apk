package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ar
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int frD = "card_id".hashCode();
  private static final int frZ = "lower_bound".hashCode();
  private static final int fsa = "need_insert_show_timestamp".hashCode();
  private static final int fsb = "show_timestamp_encrypt_key".hashCode();
  private static final int fsc = "expire_time_interval".hashCode();
  private static final int fsd = "show_expire_interval".hashCode();
  private static final int fse = "fetch_time".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_card_id;
  public int field_expire_time_interval;
  public long field_fetch_time;
  public int field_lower_bound;
  public boolean field_need_insert_show_timestamp;
  public int field_show_expire_interval;
  public String field_show_timestamp_encrypt_key;
  private boolean frT = true;
  private boolean frU = true;
  private boolean frV = true;
  private boolean frW = true;
  private boolean frX = true;
  private boolean frY = true;
  private boolean frk = true;
  
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
      if (frZ == k)
      {
        this.field_lower_bound = paramCursor.getInt(i);
      }
      else
      {
        if (fsa == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_need_insert_show_timestamp = bool;
            break;
          }
        }
        if (fsb == k) {
          this.field_show_timestamp_encrypt_key = paramCursor.getString(i);
        } else if (fsc == k) {
          this.field_expire_time_interval = paramCursor.getInt(i);
        } else if (fsd == k) {
          this.field_show_expire_interval = paramCursor.getInt(i);
        } else if (fse == k) {
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
    if (this.frk) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.frT) {
      localContentValues.put("lower_bound", Integer.valueOf(this.field_lower_bound));
    }
    if (this.frU) {
      localContentValues.put("need_insert_show_timestamp", Boolean.valueOf(this.field_need_insert_show_timestamp));
    }
    if (this.frV) {
      localContentValues.put("show_timestamp_encrypt_key", this.field_show_timestamp_encrypt_key);
    }
    if (this.frW) {
      localContentValues.put("expire_time_interval", Integer.valueOf(this.field_expire_time_interval));
    }
    if (this.frX) {
      localContentValues.put("show_expire_interval", Integer.valueOf(this.field_show_expire_interval));
    }
    if (this.frY) {
      localContentValues.put("fetch_time", Long.valueOf(this.field_fetch_time));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.ar
 * JD-Core Version:    0.7.0.1
 */