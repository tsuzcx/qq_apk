package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bf
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEU;
  private static final int eFq = "updateTime".hashCode();
  private static final int eFy;
  private static final int eOw = "id".hashCode();
  private static final int eQV = "cacheKey".hashCode();
  private static final int eQW;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eED = true;
  private boolean eFn = true;
  private boolean eFu = true;
  private boolean eOs = true;
  private boolean eQT = true;
  private boolean eQU = true;
  public String field_appId;
  public String field_cacheKey;
  public String field_data;
  public String field_id;
  public int field_interval;
  public long field_updateTime;
  
  static
  {
    eEU = "appId".hashCode();
    eFy = "data".hashCode();
    eQW = "interval".hashCode();
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
      if (eOw != k) {
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
      if (eQV == k) {
        this.field_cacheKey = paramCursor.getString(i);
      } else if (eEU == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eFy == k) {
        this.field_data = paramCursor.getString(i);
      } else if (eQW == k) {
        this.field_interval = paramCursor.getInt(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eOs) {
      localContentValues.put("id", this.field_id);
    }
    if (this.eQT) {
      localContentValues.put("cacheKey", this.field_cacheKey);
    }
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eFu) {
      localContentValues.put("data", this.field_data);
    }
    if (this.eQU) {
      localContentValues.put("interval", Integer.valueOf(this.field_interval));
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bf
 * JD-Core Version:    0.7.0.1
 */