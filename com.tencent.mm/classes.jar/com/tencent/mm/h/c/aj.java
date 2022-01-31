package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aj
  extends c
{
  private static final int cAm = "lower_bound".hashCode();
  private static final int cAn = "need_insert_show_timestamp".hashCode();
  private static final int cAo = "show_timestamp_encrypt_key".hashCode();
  private static final int cAp = "expire_time_interval".hashCode();
  private static final int cAq = "show_expire_interval".hashCode();
  private static final int cAr = "fetch_time".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int czR = "card_id".hashCode();
  private boolean cAg = true;
  private boolean cAh = true;
  private boolean cAi = true;
  private boolean cAj = true;
  private boolean cAk = true;
  private boolean cAl = true;
  private boolean czz = true;
  public String field_card_id;
  public int field_expire_time_interval;
  public long field_fetch_time;
  public int field_lower_bound;
  public boolean field_need_insert_show_timestamp;
  public int field_show_expire_interval;
  public String field_show_timestamp_encrypt_key;
  
  public final void d(Cursor paramCursor)
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
      if (cAm == k)
      {
        this.field_lower_bound = paramCursor.getInt(i);
      }
      else
      {
        if (cAn == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_need_insert_show_timestamp = bool;
            break;
          }
        }
        if (cAo == k) {
          this.field_show_timestamp_encrypt_key = paramCursor.getString(i);
        } else if (cAp == k) {
          this.field_expire_time_interval = paramCursor.getInt(i);
        } else if (cAq == k) {
          this.field_show_expire_interval = paramCursor.getInt(i);
        } else if (cAr == k) {
          this.field_fetch_time = paramCursor.getLong(i);
        } else if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.czz) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.cAg) {
      localContentValues.put("lower_bound", Integer.valueOf(this.field_lower_bound));
    }
    if (this.cAh) {
      localContentValues.put("need_insert_show_timestamp", Boolean.valueOf(this.field_need_insert_show_timestamp));
    }
    if (this.cAi) {
      localContentValues.put("show_timestamp_encrypt_key", this.field_show_timestamp_encrypt_key);
    }
    if (this.cAj) {
      localContentValues.put("expire_time_interval", Integer.valueOf(this.field_expire_time_interval));
    }
    if (this.cAk) {
      localContentValues.put("show_expire_interval", Integer.valueOf(this.field_show_expire_interval));
    }
    if (this.cAl) {
      localContentValues.put("fetch_time", Long.valueOf(this.field_fetch_time));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.aj
 * JD-Core Version:    0.7.0.1
 */