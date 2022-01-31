package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ax
  extends c
{
  private static final int cDW;
  private static final int cDX;
  private static final int cDY;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctG;
  private static final int ctO;
  private static final int ctl;
  private boolean cDT = true;
  private boolean cDU = true;
  private boolean cDV = true;
  private boolean csU = true;
  private boolean ctE = true;
  private boolean ctK = true;
  public String field_appId;
  public String field_cacheKey;
  public String field_data;
  public String field_id;
  public int field_interval;
  public long field_updateTime;
  
  static
  {
    cDW = "id".hashCode();
    cDX = "cacheKey".hashCode();
    ctl = "appId".hashCode();
    ctO = "data".hashCode();
    cDY = "interval".hashCode();
    ctG = "updateTime".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cDW != k) {
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
      if (cDX == k) {
        this.field_cacheKey = paramCursor.getString(i);
      } else if (ctl == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (ctO == k) {
        this.field_data = paramCursor.getString(i);
      } else if (cDY == k) {
        this.field_interval = paramCursor.getInt(i);
      } else if (ctG == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cDT) {
      localContentValues.put("id", this.field_id);
    }
    if (this.cDU) {
      localContentValues.put("cacheKey", this.field_cacheKey);
    }
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.ctK) {
      localContentValues.put("data", this.field_data);
    }
    if (this.cDV) {
      localContentValues.put("interval", Integer.valueOf(this.field_interval));
    }
    if (this.ctE) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.ax
 * JD-Core Version:    0.7.0.1
 */