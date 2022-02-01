package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class et
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eWh;
  private static final int eWi;
  private static final int eWj;
  private static final int eWk;
  private static final int eWl;
  private static final int eWm;
  private static final int eWn;
  private static final int eWo;
  private static final int eWp = "cmdSequence".hashCode();
  private static final int enO = "appId".hashCode();
  private static final int env;
  private static final int epb = "version".hashCode();
  private static final int epl;
  private static final int epm;
  private static final int epp;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eVY = true;
  private boolean eVZ = true;
  private boolean eWa = true;
  private boolean eWb = true;
  private boolean eWc = true;
  private boolean eWd = true;
  private boolean eWe = true;
  private boolean eWf = true;
  private boolean eWg = true;
  private boolean ent = true;
  private boolean enx = true;
  private boolean eoW = true;
  private boolean epg = true;
  private boolean eph = true;
  private boolean epk = true;
  public String field_appId;
  public long field_cmdSequence;
  public boolean field_firstTimeTried;
  public long field_lastRetryTime;
  public int field_networkType;
  public String field_packageKey;
  public int field_packageType;
  public String field_pkgMd5;
  public int field_reportId;
  public int field_retriedCount;
  public long field_retryInterval;
  public int field_retryTimes;
  public int field_scene;
  public boolean field_splitDownloadURLCgi;
  public int field_type;
  public int field_version;
  
  static
  {
    eWh = "retryTimes".hashCode();
    eWi = "retriedCount".hashCode();
    eWj = "retryInterval".hashCode();
    eWk = "networkType".hashCode();
    eWl = "pkgMd5".hashCode();
    epm = "packageKey".hashCode();
    epl = "packageType".hashCode();
    eWm = "lastRetryTime".hashCode();
    eWn = "firstTimeTried".hashCode();
    epp = "reportId".hashCode();
    eWo = "splitDownloadURLCgi".hashCode();
    env = "scene".hashCode();
  }
  
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
      if (enO != k) {
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
      if (epb == k)
      {
        this.field_version = paramCursor.getInt(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else if (eWh == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (eWi == k)
      {
        this.field_retriedCount = paramCursor.getInt(i);
      }
      else if (eWj == k)
      {
        this.field_retryInterval = paramCursor.getLong(i);
      }
      else if (eWk == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (eWl == k)
      {
        this.field_pkgMd5 = paramCursor.getString(i);
      }
      else if (epm == k)
      {
        this.field_packageKey = paramCursor.getString(i);
      }
      else if (epl == k)
      {
        this.field_packageType = paramCursor.getInt(i);
      }
      else if (eWm == k)
      {
        this.field_lastRetryTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (eWn == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_firstTimeTried = bool;
            break;
          }
        }
        if (epp == k)
        {
          this.field_reportId = paramCursor.getInt(i);
        }
        else
        {
          if (eWo == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_splitDownloadURLCgi = bool;
              break;
            }
          }
          if (env == k) {
            this.field_scene = paramCursor.getInt(i);
          } else if (eWp == k) {
            this.field_cmdSequence = paramCursor.getLong(i);
          } else if (rowid_HASHCODE == k) {
            this.systemRowid = paramCursor.getLong(i);
          }
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eoW) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eVY) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.eVZ) {
      localContentValues.put("retriedCount", Integer.valueOf(this.field_retriedCount));
    }
    if (this.eWa) {
      localContentValues.put("retryInterval", Long.valueOf(this.field_retryInterval));
    }
    if (this.eWb) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.eWc) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.eph) {
      localContentValues.put("packageKey", this.field_packageKey);
    }
    if (this.epg) {
      localContentValues.put("packageType", Integer.valueOf(this.field_packageType));
    }
    if (this.eWd) {
      localContentValues.put("lastRetryTime", Long.valueOf(this.field_lastRetryTime));
    }
    if (this.eWe) {
      localContentValues.put("firstTimeTried", Boolean.valueOf(this.field_firstTimeTried));
    }
    if (this.epk) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.eWf) {
      localContentValues.put("splitDownloadURLCgi", Boolean.valueOf(this.field_splitDownloadURLCgi));
    }
    if (this.ent) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eWg) {
      localContentValues.put("cmdSequence", Long.valueOf(this.field_cmdSequence));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.et
 * JD-Core Version:    0.7.0.1
 */