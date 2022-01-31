package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class du
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dKg = "retryTimes".hashCode();
  private static final int dKh = "retriedCount".hashCode();
  private static final int dKi = "retryInterval".hashCode();
  private static final int dKj = "networkType".hashCode();
  private static final int dKk = "pkgMd5".hashCode();
  private static final int dKl = "lastRetryTime".hashCode();
  private static final int dKm = "firstTimeTried".hashCode();
  private static final int dhB = "appId".hashCode();
  private static final int diB = "version".hashCode();
  private static final int diM = "reportId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean dJZ = true;
  private boolean dKa = true;
  private boolean dKb = true;
  private boolean dKc = true;
  private boolean dKd = true;
  private boolean dKe = true;
  private boolean dKf = true;
  private boolean dhk = true;
  private boolean diJ = true;
  private boolean div = true;
  public String field_appId;
  public boolean field_firstTimeTried;
  public long field_lastRetryTime;
  public int field_networkType;
  public String field_pkgMd5;
  public int field_reportId;
  public int field_retriedCount;
  public long field_retryInterval;
  public int field_retryTimes;
  public int field_type;
  public int field_version;
  
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
      if (dhB != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (diB == k)
      {
        this.field_version = paramCursor.getInt(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else if (dKg == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (dKh == k)
      {
        this.field_retriedCount = paramCursor.getInt(i);
      }
      else if (dKi == k)
      {
        this.field_retryInterval = paramCursor.getLong(i);
      }
      else if (dKj == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (dKk == k)
      {
        this.field_pkgMd5 = paramCursor.getString(i);
      }
      else if (dKl == k)
      {
        this.field_lastRetryTime = paramCursor.getLong(i);
      }
      else
      {
        if (dKm == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_firstTimeTried = bool;
            break;
          }
        }
        if (diM == k) {
          this.field_reportId = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.div) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.dJZ) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.dKa) {
      localContentValues.put("retriedCount", Integer.valueOf(this.field_retriedCount));
    }
    if (this.dKb) {
      localContentValues.put("retryInterval", Long.valueOf(this.field_retryInterval));
    }
    if (this.dKc) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.dKd) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.dKe) {
      localContentValues.put("lastRetryTime", Long.valueOf(this.field_lastRetryTime));
    }
    if (this.dKf) {
      localContentValues.put("firstTimeTried", Boolean.valueOf(this.field_firstTimeTried));
    }
    if (this.diJ) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.du
 * JD-Core Version:    0.7.0.1
 */