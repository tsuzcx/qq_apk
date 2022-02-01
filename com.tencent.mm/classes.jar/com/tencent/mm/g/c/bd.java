package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bd
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int elJ;
  private static final int emf = "updateTime".hashCode();
  private static final int emn;
  private static final int exb = "id".hashCode();
  private static final int exc = "cacheKey".hashCode();
  private static final int exd;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean els = true;
  private boolean emc = true;
  private boolean emj = true;
  private boolean ewY = true;
  private boolean ewZ = true;
  private boolean exa = true;
  public String field_appId;
  public String field_cacheKey;
  public String field_data;
  public String field_id;
  public int field_interval;
  public long field_updateTime;
  
  static
  {
    elJ = "appId".hashCode();
    emn = "data".hashCode();
    exd = "interval".hashCode();
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
      if (exb != k) {
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
      if (exc == k) {
        this.field_cacheKey = paramCursor.getString(i);
      } else if (elJ == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (emn == k) {
        this.field_data = paramCursor.getString(i);
      } else if (exd == k) {
        this.field_interval = paramCursor.getInt(i);
      } else if (emf == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ewY) {
      localContentValues.put("id", this.field_id);
    }
    if (this.ewZ) {
      localContentValues.put("cacheKey", this.field_cacheKey);
    }
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.emj) {
      localContentValues.put("data", this.field_data);
    }
    if (this.exa) {
      localContentValues.put("interval", Integer.valueOf(this.field_interval));
    }
    if (this.emc) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bd
 * JD-Core Version:    0.7.0.1
 */