package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class be
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int enO;
  private static final int eol = "updateTime".hashCode();
  private static final int eot;
  private static final int ewX = "id".hashCode();
  private static final int ezx = "cacheKey".hashCode();
  private static final int ezy;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean enx = true;
  private boolean eoi = true;
  private boolean eop = true;
  private boolean ewT = true;
  private boolean ezv = true;
  private boolean ezw = true;
  public String field_appId;
  public String field_cacheKey;
  public String field_data;
  public String field_id;
  public int field_interval;
  public long field_updateTime;
  
  static
  {
    enO = "appId".hashCode();
    eot = "data".hashCode();
    ezy = "interval".hashCode();
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
      if (ewX != k) {
        break label60;
      }
      this.field_id = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (ezx == k) {
        this.field_cacheKey = paramCursor.getString(i);
      } else if (enO == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eot == k) {
        this.field_data = paramCursor.getString(i);
      } else if (ezy == k) {
        this.field_interval = paramCursor.getInt(i);
      } else if (eol == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ewT) {
      localContentValues.put("id", this.field_id);
    }
    if (this.ezv) {
      localContentValues.put("cacheKey", this.field_cacheKey);
    }
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eop) {
      localContentValues.put("data", this.field_data);
    }
    if (this.ezw) {
      localContentValues.put("interval", Integer.valueOf(this.field_interval));
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.be
 * JD-Core Version:    0.7.0.1
 */