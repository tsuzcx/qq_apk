package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ep
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eSX;
  private static final int eSY;
  private static final int eSZ;
  private static final int eTa;
  private static final int eTb;
  private static final int eTc;
  private static final int eTd;
  private static final int eTe;
  private static final int eTf = "cmdSequence".hashCode();
  private static final int elJ = "appId".hashCode();
  private static final int elq;
  private static final int emV = "version".hashCode();
  private static final int eng;
  private static final int enh;
  private static final int enk;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eSO = true;
  private boolean eSP = true;
  private boolean eSQ = true;
  private boolean eSR = true;
  private boolean eSS = true;
  private boolean eST = true;
  private boolean eSU = true;
  private boolean eSV = true;
  private boolean eSW = true;
  private boolean elo = true;
  private boolean els = true;
  private boolean emQ = true;
  private boolean ena = true;
  private boolean enb = true;
  private boolean enf = true;
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
    eSX = "retryTimes".hashCode();
    eSY = "retriedCount".hashCode();
    eSZ = "retryInterval".hashCode();
    eTa = "networkType".hashCode();
    eTb = "pkgMd5".hashCode();
    enh = "packageKey".hashCode();
    eng = "packageType".hashCode();
    eTc = "lastRetryTime".hashCode();
    eTd = "firstTimeTried".hashCode();
    enk = "reportId".hashCode();
    eTe = "splitDownloadURLCgi".hashCode();
    elq = "scene".hashCode();
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
      if (elJ != k) {
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
      if (emV == k)
      {
        this.field_version = paramCursor.getInt(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else if (eSX == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (eSY == k)
      {
        this.field_retriedCount = paramCursor.getInt(i);
      }
      else if (eSZ == k)
      {
        this.field_retryInterval = paramCursor.getLong(i);
      }
      else if (eTa == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (eTb == k)
      {
        this.field_pkgMd5 = paramCursor.getString(i);
      }
      else if (enh == k)
      {
        this.field_packageKey = paramCursor.getString(i);
      }
      else if (eng == k)
      {
        this.field_packageType = paramCursor.getInt(i);
      }
      else if (eTc == k)
      {
        this.field_lastRetryTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (eTd == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_firstTimeTried = bool;
            break;
          }
        }
        if (enk == k)
        {
          this.field_reportId = paramCursor.getInt(i);
        }
        else
        {
          if (eTe == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_splitDownloadURLCgi = bool;
              break;
            }
          }
          if (elq == k) {
            this.field_scene = paramCursor.getInt(i);
          } else if (eTf == k) {
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
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.emQ) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eSO) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.eSP) {
      localContentValues.put("retriedCount", Integer.valueOf(this.field_retriedCount));
    }
    if (this.eSQ) {
      localContentValues.put("retryInterval", Long.valueOf(this.field_retryInterval));
    }
    if (this.eSR) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.eSS) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.enb) {
      localContentValues.put("packageKey", this.field_packageKey);
    }
    if (this.ena) {
      localContentValues.put("packageType", Integer.valueOf(this.field_packageType));
    }
    if (this.eST) {
      localContentValues.put("lastRetryTime", Long.valueOf(this.field_lastRetryTime));
    }
    if (this.eSU) {
      localContentValues.put("firstTimeTried", Boolean.valueOf(this.field_firstTimeTried));
    }
    if (this.enf) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.eSV) {
      localContentValues.put("splitDownloadURLCgi", Boolean.valueOf(this.field_splitDownloadURLCgi));
    }
    if (this.elo) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eSW) {
      localContentValues.put("cmdSequence", Long.valueOf(this.field_cmdSequence));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ep
 * JD-Core Version:    0.7.0.1
 */