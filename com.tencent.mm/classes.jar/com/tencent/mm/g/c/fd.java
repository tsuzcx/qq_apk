package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fd
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGD = "appId".hashCode();
  private static final int eGk = "scene".hashCode();
  private static final int eHT = "version".hashCode();
  private static final int eId;
  private static final int eIe;
  private static final int eIh;
  private static final int fqA;
  private static final int fqB;
  private static final int fqC;
  private static final int fqD;
  private static final int fqE;
  private static final int fqF = "cmdSequence".hashCode();
  private static final int fqx;
  private static final int fqy;
  private static final int fqz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eGi = true;
  private boolean eGm = true;
  private boolean eHO = true;
  private boolean eHY = true;
  private boolean eHZ = true;
  private boolean eIc = true;
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
  private boolean fqo = true;
  private boolean fqp = true;
  private boolean fqq = true;
  private boolean fqr = true;
  private boolean fqs = true;
  private boolean fqt = true;
  private boolean fqu = true;
  private boolean fqv = true;
  private boolean fqw = true;
  
  static
  {
    fqx = "retryTimes".hashCode();
    fqy = "retriedCount".hashCode();
    fqz = "retryInterval".hashCode();
    fqA = "networkType".hashCode();
    fqB = "pkgMd5".hashCode();
    eIe = "packageKey".hashCode();
    eId = "packageType".hashCode();
    fqC = "lastRetryTime".hashCode();
    fqD = "firstTimeTried".hashCode();
    eIh = "reportId".hashCode();
    fqE = "splitDownloadURLCgi".hashCode();
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
      if (eGD != k) {
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
      if (eHT == k)
      {
        this.field_version = paramCursor.getInt(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else if (fqx == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (fqy == k)
      {
        this.field_retriedCount = paramCursor.getInt(i);
      }
      else if (fqz == k)
      {
        this.field_retryInterval = paramCursor.getLong(i);
      }
      else if (fqA == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (fqB == k)
      {
        this.field_pkgMd5 = paramCursor.getString(i);
      }
      else if (eIe == k)
      {
        this.field_packageKey = paramCursor.getString(i);
      }
      else if (eId == k)
      {
        this.field_packageType = paramCursor.getInt(i);
      }
      else if (fqC == k)
      {
        this.field_lastRetryTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (fqD == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_firstTimeTried = bool;
            break;
          }
        }
        if (eIh == k)
        {
          this.field_reportId = paramCursor.getInt(i);
        }
        else
        {
          if (fqE == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_splitDownloadURLCgi = bool;
              break;
            }
          }
          if (eGk == k) {
            this.field_scene = paramCursor.getInt(i);
          } else if (fqF == k) {
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
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eHO) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fqo) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.fqp) {
      localContentValues.put("retriedCount", Integer.valueOf(this.field_retriedCount));
    }
    if (this.fqq) {
      localContentValues.put("retryInterval", Long.valueOf(this.field_retryInterval));
    }
    if (this.fqr) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.fqs) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.eHZ) {
      localContentValues.put("packageKey", this.field_packageKey);
    }
    if (this.eHY) {
      localContentValues.put("packageType", Integer.valueOf(this.field_packageType));
    }
    if (this.fqt) {
      localContentValues.put("lastRetryTime", Long.valueOf(this.field_lastRetryTime));
    }
    if (this.fqu) {
      localContentValues.put("firstTimeTried", Boolean.valueOf(this.field_firstTimeTried));
    }
    if (this.eIc) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.fqv) {
      localContentValues.put("splitDownloadURLCgi", Boolean.valueOf(this.field_splitDownloadURLCgi));
    }
    if (this.eGi) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.fqw) {
      localContentValues.put("cmdSequence", Long.valueOf(this.field_cmdSequence));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fd
 * JD-Core Version:    0.7.0.1
 */