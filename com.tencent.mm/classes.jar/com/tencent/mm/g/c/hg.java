package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEU;
  private static final int eEf;
  private static final int eGk;
  private static final int eGm;
  private static final int eNa;
  private static final int eSP;
  private static final int fAK = "autoDownloadCount".hashCode();
  private static final int fAl = "pkgId".hashCode();
  private static final int fAo;
  private static final int fAp;
  private static final int fBa;
  private static final int fBb;
  private static final int fBc;
  private static final int fBd;
  private static final int fBe;
  private static final int fBf;
  private static final int fBg;
  private static final int fBh;
  private static final int fBi;
  private static final int fBj;
  private static final int fBk = "disable".hashCode();
  private static final int fBl = "totalDownloadCount".hashCode();
  private static final int fBm = "packageDownloadCount".hashCode();
  private static final int fBn = "downloadTriggerType".hashCode();
  private static final int fdn;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDI = true;
  private boolean eED = true;
  private boolean eGf = true;
  private boolean eGh = true;
  private boolean eMS = true;
  private boolean eSd = true;
  private boolean fAF = true;
  private boolean fAM = true;
  private boolean fAN = true;
  private boolean fAO = true;
  private boolean fAP = true;
  private boolean fAQ = true;
  private boolean fAR = true;
  private boolean fAS = true;
  private boolean fAT = true;
  private boolean fAU = true;
  private boolean fAV = true;
  private boolean fAW = true;
  private boolean fAX = true;
  private boolean fAY = true;
  private boolean fAZ = true;
  private boolean fAg = true;
  private boolean fAj = true;
  private boolean fAk = true;
  private boolean fdb = true;
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
    eEU = "appId".hashCode();
    eGk = "version".hashCode();
    eGm = "pkgPath".hashCode();
    fBa = "disableWvCache".hashCode();
    fBb = "clearPkgTime".hashCode();
    fBc = "checkIntervalTime".hashCode();
    fBd = "packMethod".hashCode();
    fBe = "domain".hashCode();
    eSP = "md5".hashCode();
    eNa = "downloadUrl".hashCode();
    fAo = "pkgSize".hashCode();
    fAp = "downloadNetType".hashCode();
    fdn = "nextCheckTime".hashCode();
    eEf = "createTime".hashCode();
    fBf = "accessTime".hashCode();
    fBg = "charset".hashCode();
    fBh = "bigPackageReady".hashCode();
    fBi = "preloadFilesReady".hashCode();
    fBj = "preloadFilesAtomic".hashCode();
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
      if (fAl != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.fAg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eEU == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (eGk == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (eGm == k)
      {
        this.field_pkgPath = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (fBa == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_disableWvCache = bool;
            break;
          }
        }
        if (fBb == k)
        {
          this.field_clearPkgTime = paramCursor.getLong(i);
        }
        else if (fBc == k)
        {
          this.field_checkIntervalTime = paramCursor.getLong(i);
        }
        else if (fBd == k)
        {
          this.field_packMethod = paramCursor.getInt(i);
        }
        else if (fBe == k)
        {
          this.field_domain = paramCursor.getString(i);
        }
        else if (eSP == k)
        {
          this.field_md5 = paramCursor.getString(i);
        }
        else if (eNa == k)
        {
          this.field_downloadUrl = paramCursor.getString(i);
        }
        else if (fAo == k)
        {
          this.field_pkgSize = paramCursor.getInt(i);
        }
        else if (fAp == k)
        {
          this.field_downloadNetType = paramCursor.getInt(i);
        }
        else if (fdn == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else if (eEf == k)
        {
          this.field_createTime = paramCursor.getLong(i);
        }
        else if (fBf == k)
        {
          this.field_accessTime = paramCursor.getLong(i);
        }
        else if (fBg == k)
        {
          this.field_charset = paramCursor.getString(i);
        }
        else
        {
          if (fBh == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_bigPackageReady = bool;
              break;
            }
          }
          if (fBi == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesReady = bool;
              break;
            }
          }
          if (fBj == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesAtomic = bool;
              break;
            }
          }
          if (fAK == k)
          {
            this.field_autoDownloadCount = paramCursor.getInt(i);
          }
          else
          {
            if (fBk == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_disable = bool;
                break;
              }
            }
            if (fBl == k) {
              this.field_totalDownloadCount = paramCursor.getInt(i);
            } else if (fBm == k) {
              this.field_packageDownloadCount = paramCursor.getInt(i);
            } else if (fBn == k) {
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
    if (this.fAg) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eGf) {
      localContentValues.put("version", this.field_version);
    }
    if (this.eGh) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.fAM) {
      localContentValues.put("disableWvCache", Boolean.valueOf(this.field_disableWvCache));
    }
    if (this.fAN) {
      localContentValues.put("clearPkgTime", Long.valueOf(this.field_clearPkgTime));
    }
    if (this.fAO) {
      localContentValues.put("checkIntervalTime", Long.valueOf(this.field_checkIntervalTime));
    }
    if (this.fAP) {
      localContentValues.put("packMethod", Integer.valueOf(this.field_packMethod));
    }
    if (this.fAQ) {
      localContentValues.put("domain", this.field_domain);
    }
    if (this.eSd) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eMS) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.fAj) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.fAk) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.fdb) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.eDI) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fAR) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.field_charset == null) {
      this.field_charset = "UTF-8";
    }
    if (this.fAS) {
      localContentValues.put("charset", this.field_charset);
    }
    if (this.fAT) {
      localContentValues.put("bigPackageReady", Boolean.valueOf(this.field_bigPackageReady));
    }
    if (this.fAU) {
      localContentValues.put("preloadFilesReady", Boolean.valueOf(this.field_preloadFilesReady));
    }
    if (this.fAV) {
      localContentValues.put("preloadFilesAtomic", Boolean.valueOf(this.field_preloadFilesAtomic));
    }
    if (this.fAF) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.fAW) {
      localContentValues.put("disable", Boolean.valueOf(this.field_disable));
    }
    if (this.fAX) {
      localContentValues.put("totalDownloadCount", Integer.valueOf(this.field_totalDownloadCount));
    }
    if (this.fAY) {
      localContentValues.put("packageDownloadCount", Integer.valueOf(this.field_packageDownloadCount));
    }
    if (this.fAZ) {
      localContentValues.put("downloadTriggerType", Integer.valueOf(this.field_downloadTriggerType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hg
 * JD-Core Version:    0.7.0.1
 */