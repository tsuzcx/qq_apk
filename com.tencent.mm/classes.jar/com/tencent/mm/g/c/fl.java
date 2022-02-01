package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fl
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fVc;
  private static final int fVd;
  private static final int fVe;
  private static final int fVf;
  private static final int fVg;
  private static final int fVh;
  private static final int fVi;
  private static final int fVj;
  private static final int fVk = "cmdSequence".hashCode();
  private static final int fjQ;
  private static final int fkj = "appId".hashCode();
  private static final int flF;
  private static final int flG;
  private static final int flJ;
  private static final int flv = "version".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean fUT = true;
  private boolean fUU = true;
  private boolean fUV = true;
  private boolean fUW = true;
  private boolean fUX = true;
  private boolean fUY = true;
  private boolean fUZ = true;
  private boolean fVa = true;
  private boolean fVb = true;
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
  private boolean fjO = true;
  private boolean fjS = true;
  private boolean flA = true;
  private boolean flB = true;
  private boolean flE = true;
  private boolean flq = true;
  
  static
  {
    fVc = "retryTimes".hashCode();
    fVd = "retriedCount".hashCode();
    fVe = "retryInterval".hashCode();
    fVf = "networkType".hashCode();
    fVg = "pkgMd5".hashCode();
    flG = "packageKey".hashCode();
    flF = "packageType".hashCode();
    fVh = "lastRetryTime".hashCode();
    fVi = "firstTimeTried".hashCode();
    flJ = "reportId".hashCode();
    fVj = "splitDownloadURLCgi".hashCode();
    fjQ = "scene".hashCode();
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
      if (fkj != k) {
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
      if (flv == k)
      {
        this.field_version = paramCursor.getInt(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else if (fVc == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (fVd == k)
      {
        this.field_retriedCount = paramCursor.getInt(i);
      }
      else if (fVe == k)
      {
        this.field_retryInterval = paramCursor.getLong(i);
      }
      else if (fVf == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (fVg == k)
      {
        this.field_pkgMd5 = paramCursor.getString(i);
      }
      else if (flG == k)
      {
        this.field_packageKey = paramCursor.getString(i);
      }
      else if (flF == k)
      {
        this.field_packageType = paramCursor.getInt(i);
      }
      else if (fVh == k)
      {
        this.field_lastRetryTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (fVi == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_firstTimeTried = bool;
            break;
          }
        }
        if (flJ == k)
        {
          this.field_reportId = paramCursor.getInt(i);
        }
        else
        {
          if (fVj == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_splitDownloadURLCgi = bool;
              break;
            }
          }
          if (fjQ == k) {
            this.field_scene = paramCursor.getInt(i);
          } else if (fVk == k) {
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
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.flq) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fUT) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.fUU) {
      localContentValues.put("retriedCount", Integer.valueOf(this.field_retriedCount));
    }
    if (this.fUV) {
      localContentValues.put("retryInterval", Long.valueOf(this.field_retryInterval));
    }
    if (this.fUW) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.fUX) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.flB) {
      localContentValues.put("packageKey", this.field_packageKey);
    }
    if (this.flA) {
      localContentValues.put("packageType", Integer.valueOf(this.field_packageType));
    }
    if (this.fUY) {
      localContentValues.put("lastRetryTime", Long.valueOf(this.field_lastRetryTime));
    }
    if (this.fUZ) {
      localContentValues.put("firstTimeTried", Boolean.valueOf(this.field_firstTimeTried));
    }
    if (this.flE) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.fVa) {
      localContentValues.put("splitDownloadURLCgi", Boolean.valueOf(this.field_splitDownloadURLCgi));
    }
    if (this.fjO) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.fVb) {
      localContentValues.put("cmdSequence", Long.valueOf(this.field_cmdSequence));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fl
 * JD-Core Version:    0.7.0.1
 */