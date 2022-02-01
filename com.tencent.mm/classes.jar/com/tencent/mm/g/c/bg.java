package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bg
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fkJ;
  private static final int fkj;
  private static final int fwl;
  private static final int fwm;
  private static final int id_HASHCODE = "id".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetid = true;
  private boolean __hadSetupdateTime = true;
  public String field_appId;
  public String field_cacheKey;
  public String field_data;
  public String field_id;
  public int field_interval;
  public long field_updateTime;
  private boolean fjS = true;
  private boolean fkF = true;
  private boolean fwj = true;
  private boolean fwk = true;
  
  static
  {
    fwl = "cacheKey".hashCode();
    fkj = "appId".hashCode();
    fkJ = "data".hashCode();
    fwm = "interval".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
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
      if (id_HASHCODE != k) {
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
      if (fwl == k) {
        this.field_cacheKey = paramCursor.getString(i);
      } else if (fkj == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (fkJ == k) {
        this.field_data = paramCursor.getString(i);
      } else if (fwm == k) {
        this.field_interval = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetid) {
      localContentValues.put("id", this.field_id);
    }
    if (this.fwj) {
      localContentValues.put("cacheKey", this.field_cacheKey);
    }
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fkF) {
      localContentValues.put("data", this.field_data);
    }
    if (this.fwk) {
      localContentValues.put("interval", Integer.valueOf(this.field_interval));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.bg
 * JD-Core Version:    0.7.0.1
 */