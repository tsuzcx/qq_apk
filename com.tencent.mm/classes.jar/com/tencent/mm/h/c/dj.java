package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dj
  extends c
{
  private static final int cTS = "reportId".hashCode();
  private static final int cUa;
  private static final int cUb;
  private static final int cUc;
  private static final int cUd;
  private static final int cUe;
  private static final int cUf;
  private static final int cUg;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csy;
  private static final int ctl = "appId".hashCode();
  private static final int cuv = "version".hashCode();
  private boolean cTP = true;
  private boolean cTT = true;
  private boolean cTU = true;
  private boolean cTV = true;
  private boolean cTW = true;
  private boolean cTX = true;
  private boolean cTY = true;
  private boolean cTZ = true;
  private boolean csU = true;
  private boolean csa = true;
  private boolean cup = true;
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
  
  static
  {
    csy = "type".hashCode();
    cUa = "retryTimes".hashCode();
    cUb = "retriedCount".hashCode();
    cUc = "retryInterval".hashCode();
    cUd = "networkType".hashCode();
    cUe = "pkgMd5".hashCode();
    cUf = "lastRetryTime".hashCode();
    cUg = "firstTimeTried".hashCode();
  }
  
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
      if (ctl != k) {
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
      if (cuv == k)
      {
        this.field_version = paramCursor.getInt(i);
      }
      else if (csy == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else if (cUa == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (cUb == k)
      {
        this.field_retriedCount = paramCursor.getInt(i);
      }
      else if (cUc == k)
      {
        this.field_retryInterval = paramCursor.getLong(i);
      }
      else if (cUd == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (cUe == k)
      {
        this.field_pkgMd5 = paramCursor.getString(i);
      }
      else if (cUf == k)
      {
        this.field_lastRetryTime = paramCursor.getLong(i);
      }
      else
      {
        if (cUg == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_firstTimeTried = bool;
            break;
          }
        }
        if (cTS == k) {
          this.field_reportId = paramCursor.getInt(i);
        } else if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.cup) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.cTT) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.cTU) {
      localContentValues.put("retriedCount", Integer.valueOf(this.field_retriedCount));
    }
    if (this.cTV) {
      localContentValues.put("retryInterval", Long.valueOf(this.field_retryInterval));
    }
    if (this.cTW) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.cTX) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.cTY) {
      localContentValues.put("lastRetryTime", Long.valueOf(this.field_lastRetryTime));
    }
    if (this.cTZ) {
      localContentValues.put("firstTimeTried", Boolean.valueOf(this.field_firstTimeTried));
    }
    if (this.cTP) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.c.dj
 * JD-Core Version:    0.7.0.1
 */