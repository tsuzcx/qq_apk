package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class az
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dhB;
  private static final int dhV = "updateTime".hashCode();
  private static final int did;
  private static final int dsg = "id".hashCode();
  private static final int dsh = "cacheKey".hashCode();
  private static final int dsi;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dhT = true;
  private boolean dhZ = true;
  private boolean dhk = true;
  private boolean dsd = true;
  private boolean dse = true;
  private boolean dsf = true;
  public String field_appId;
  public String field_cacheKey;
  public String field_data;
  public String field_id;
  public int field_interval;
  public long field_updateTime;
  
  static
  {
    dhB = "appId".hashCode();
    did = "data".hashCode();
    dsi = "interval".hashCode();
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
      if (dsg != k) {
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
      if (dsh == k) {
        this.field_cacheKey = paramCursor.getString(i);
      } else if (dhB == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (did == k) {
        this.field_data = paramCursor.getString(i);
      } else if (dsi == k) {
        this.field_interval = paramCursor.getInt(i);
      } else if (dhV == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dsd) {
      localContentValues.put("id", this.field_id);
    }
    if (this.dse) {
      localContentValues.put("cacheKey", this.field_cacheKey);
    }
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.dhZ) {
      localContentValues.put("data", this.field_data);
    }
    if (this.dsf) {
      localContentValues.put("interval", Integer.valueOf(this.field_interval));
    }
    if (this.dhT) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.az
 * JD-Core Version:    0.7.0.1
 */