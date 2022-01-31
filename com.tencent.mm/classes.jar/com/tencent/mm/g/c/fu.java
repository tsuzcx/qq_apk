package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fu
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dBg;
  private static final int dVP = "autoDownloadCount".hashCode();
  private static final int dVs = "pkgId".hashCode();
  private static final int dVv;
  private static final int dVw;
  private static final int dWf;
  private static final int dWg;
  private static final int dWh;
  private static final int dWi;
  private static final int dWj;
  private static final int dWk;
  private static final int dWl;
  private static final int dWm;
  private static final int dWn;
  private static final int dWo;
  private static final int dWp = "disable".hashCode();
  private static final int dWq = "totalDownloadCount".hashCode();
  private static final int dWr = "packageDownloadCount".hashCode();
  private static final int dWs = "downloadTriggerType".hashCode();
  private static final int dgM;
  private static final int dhB = "appId".hashCode();
  private static final int diB = "version".hashCode();
  private static final int diE = "pkgPath".hashCode();
  private static final int doI;
  private static final int dtX;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dAV = true;
  private boolean dVK = true;
  private boolean dVR = true;
  private boolean dVS = true;
  private boolean dVT = true;
  private boolean dVU = true;
  private boolean dVV = true;
  private boolean dVW = true;
  private boolean dVX = true;
  private boolean dVY = true;
  private boolean dVZ = true;
  private boolean dVn = true;
  private boolean dVq = true;
  private boolean dVr = true;
  private boolean dWa = true;
  private boolean dWb = true;
  private boolean dWc = true;
  private boolean dWd = true;
  private boolean dWe = true;
  private boolean dgp = true;
  private boolean dhk = true;
  private boolean div = true;
  private boolean diy = true;
  private boolean doA = true;
  private boolean dtk = true;
  public long field_accessTime;
  public String field_appId;
  public int field_autoDownloadCount;
  public boolean field_bigPackageReady;
  public String field_charset;
  public long field_checkIntervalTime;
  public long field_clearPkgTime;
  public long field_createTime;
  public boolean field_disable;
  public boolean field_disableWvCache;
  public String field_domain;
  public int field_downloadNetType;
  public int field_downloadTriggerType;
  public String field_downloadUrl;
  public String field_md5;
  public long field_nextCheckTime;
  public int field_packMethod;
  public int field_packageDownloadCount;
  public String field_pkgId;
  public String field_pkgPath;
  public int field_pkgSize;
  public boolean field_preloadFilesAtomic;
  public boolean field_preloadFilesReady;
  public int field_totalDownloadCount;
  public String field_version;
  
  static
  {
    dWf = "disableWvCache".hashCode();
    dWg = "clearPkgTime".hashCode();
    dWh = "checkIntervalTime".hashCode();
    dWi = "packMethod".hashCode();
    dWj = "domain".hashCode();
    dtX = "md5".hashCode();
    doI = "downloadUrl".hashCode();
    dVv = "pkgSize".hashCode();
    dVw = "downloadNetType".hashCode();
    dBg = "nextCheckTime".hashCode();
    dgM = "createTime".hashCode();
    dWk = "accessTime".hashCode();
    dWl = "charset".hashCode();
    dWm = "bigPackageReady".hashCode();
    dWn = "preloadFilesReady".hashCode();
    dWo = "preloadFilesAtomic".hashCode();
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
      if (dVs != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.dVn = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dhB == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (diB == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (diE == k)
      {
        this.field_pkgPath = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (dWf == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_disableWvCache = bool;
            break;
          }
        }
        if (dWg == k)
        {
          this.field_clearPkgTime = paramCursor.getLong(i);
        }
        else if (dWh == k)
        {
          this.field_checkIntervalTime = paramCursor.getLong(i);
        }
        else if (dWi == k)
        {
          this.field_packMethod = paramCursor.getInt(i);
        }
        else if (dWj == k)
        {
          this.field_domain = paramCursor.getString(i);
        }
        else if (dtX == k)
        {
          this.field_md5 = paramCursor.getString(i);
        }
        else if (doI == k)
        {
          this.field_downloadUrl = paramCursor.getString(i);
        }
        else if (dVv == k)
        {
          this.field_pkgSize = paramCursor.getInt(i);
        }
        else if (dVw == k)
        {
          this.field_downloadNetType = paramCursor.getInt(i);
        }
        else if (dBg == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else if (dgM == k)
        {
          this.field_createTime = paramCursor.getLong(i);
        }
        else if (dWk == k)
        {
          this.field_accessTime = paramCursor.getLong(i);
        }
        else if (dWl == k)
        {
          this.field_charset = paramCursor.getString(i);
        }
        else
        {
          if (dWm == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_bigPackageReady = bool;
              break;
            }
          }
          if (dWn == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesReady = bool;
              break;
            }
          }
          if (dWo == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesAtomic = bool;
              break;
            }
          }
          if (dVP == k)
          {
            this.field_autoDownloadCount = paramCursor.getInt(i);
          }
          else
          {
            if (dWp == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_disable = bool;
                break;
              }
            }
            if (dWq == k) {
              this.field_totalDownloadCount = paramCursor.getInt(i);
            } else if (dWr == k) {
              this.field_packageDownloadCount = paramCursor.getInt(i);
            } else if (dWs == k) {
              this.field_downloadTriggerType = paramCursor.getInt(i);
            } else if (rowid_HASHCODE == k) {
              this.systemRowid = paramCursor.getLong(i);
            }
          }
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dVn) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.div) {
      localContentValues.put("version", this.field_version);
    }
    if (this.diy) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.dVR) {
      localContentValues.put("disableWvCache", Boolean.valueOf(this.field_disableWvCache));
    }
    if (this.dVS) {
      localContentValues.put("clearPkgTime", Long.valueOf(this.field_clearPkgTime));
    }
    if (this.dVT) {
      localContentValues.put("checkIntervalTime", Long.valueOf(this.field_checkIntervalTime));
    }
    if (this.dVU) {
      localContentValues.put("packMethod", Integer.valueOf(this.field_packMethod));
    }
    if (this.dVV) {
      localContentValues.put("domain", this.field_domain);
    }
    if (this.dtk) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.doA) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.dVq) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.dVr) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.dAV) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.dgp) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.dVW) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.field_charset == null) {
      this.field_charset = "UTF-8";
    }
    if (this.dVX) {
      localContentValues.put("charset", this.field_charset);
    }
    if (this.dVY) {
      localContentValues.put("bigPackageReady", Boolean.valueOf(this.field_bigPackageReady));
    }
    if (this.dVZ) {
      localContentValues.put("preloadFilesReady", Boolean.valueOf(this.field_preloadFilesReady));
    }
    if (this.dWa) {
      localContentValues.put("preloadFilesAtomic", Boolean.valueOf(this.field_preloadFilesAtomic));
    }
    if (this.dVK) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.dWb) {
      localContentValues.put("disable", Boolean.valueOf(this.field_disable));
    }
    if (this.dWc) {
      localContentValues.put("totalDownloadCount", Integer.valueOf(this.field_totalDownloadCount));
    }
    if (this.dWd) {
      localContentValues.put("packageDownloadCount", Integer.valueOf(this.field_packageDownloadCount));
    }
    if (this.dWe) {
      localContentValues.put("downloadTriggerType", Integer.valueOf(this.field_downloadTriggerType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fu
 * JD-Core Version:    0.7.0.1
 */