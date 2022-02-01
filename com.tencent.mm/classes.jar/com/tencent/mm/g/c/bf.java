package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bf
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGD;
  private static final int eGZ = "updateTime".hashCode();
  private static final int eHh;
  private static final int eQh = "id".hashCode();
  private static final int eSG = "cacheKey".hashCode();
  private static final int eSH;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGW = true;
  private boolean eGm = true;
  private boolean eHd = true;
  private boolean eQd = true;
  private boolean eSE = true;
  private boolean eSF = true;
  public String field_appId;
  public String field_cacheKey;
  public String field_data;
  public String field_id;
  public int field_interval;
  public long field_updateTime;
  
  static
  {
    eGD = "appId".hashCode();
    eHh = "data".hashCode();
    eSH = "interval".hashCode();
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
      if (eQh != k) {
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
      if (eSG == k) {
        this.field_cacheKey = paramCursor.getString(i);
      } else if (eGD == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eHh == k) {
        this.field_data = paramCursor.getString(i);
      } else if (eSH == k) {
        this.field_interval = paramCursor.getInt(i);
      } else if (eGZ == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eQd) {
      localContentValues.put("id", this.field_id);
    }
    if (this.eSE) {
      localContentValues.put("cacheKey", this.field_cacheKey);
    }
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eHd) {
      localContentValues.put("data", this.field_data);
    }
    if (this.eSF) {
      localContentValues.put("interval", Integer.valueOf(this.field_interval));
    }
    if (this.eGW) {
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