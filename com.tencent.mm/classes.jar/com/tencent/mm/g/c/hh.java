package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hh
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFO;
  private static final int eGD;
  private static final int eHT;
  private static final int eHV;
  private static final int eOL;
  private static final int eUA;
  private static final int fCK = "autoDownloadCount".hashCode();
  private static final int fCl = "pkgId".hashCode();
  private static final int fCo;
  private static final int fCp;
  private static final int fDa;
  private static final int fDb;
  private static final int fDc;
  private static final int fDd;
  private static final int fDe;
  private static final int fDf;
  private static final int fDg;
  private static final int fDh;
  private static final int fDi;
  private static final int fDj;
  private static final int fDk = "disable".hashCode();
  private static final int fDl = "totalDownloadCount".hashCode();
  private static final int fDm = "packageDownloadCount".hashCode();
  private static final int fDn = "downloadTriggerType".hashCode();
  private static final int ffg;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFr = true;
  private boolean eGm = true;
  private boolean eHO = true;
  private boolean eHQ = true;
  private boolean eOD = true;
  private boolean eTO = true;
  private boolean fCF = true;
  private boolean fCM = true;
  private boolean fCN = true;
  private boolean fCO = true;
  private boolean fCP = true;
  private boolean fCQ = true;
  private boolean fCR = true;
  private boolean fCS = true;
  private boolean fCT = true;
  private boolean fCU = true;
  private boolean fCV = true;
  private boolean fCW = true;
  private boolean fCX = true;
  private boolean fCY = true;
  private boolean fCZ = true;
  private boolean fCg = true;
  private boolean fCj = true;
  private boolean fCk = true;
  private boolean feU = true;
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
    eGD = "appId".hashCode();
    eHT = "version".hashCode();
    eHV = "pkgPath".hashCode();
    fDa = "disableWvCache".hashCode();
    fDb = "clearPkgTime".hashCode();
    fDc = "checkIntervalTime".hashCode();
    fDd = "packMethod".hashCode();
    fDe = "domain".hashCode();
    eUA = "md5".hashCode();
    eOL = "downloadUrl".hashCode();
    fCo = "pkgSize".hashCode();
    fCp = "downloadNetType".hashCode();
    ffg = "nextCheckTime".hashCode();
    eFO = "createTime".hashCode();
    fDf = "accessTime".hashCode();
    fDg = "charset".hashCode();
    fDh = "bigPackageReady".hashCode();
    fDi = "preloadFilesReady".hashCode();
    fDj = "preloadFilesAtomic".hashCode();
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
      if (fCl != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.fCg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eGD == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (eHT == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (eHV == k)
      {
        this.field_pkgPath = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (fDa == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_disableWvCache = bool;
            break;
          }
        }
        if (fDb == k)
        {
          this.field_clearPkgTime = paramCursor.getLong(i);
        }
        else if (fDc == k)
        {
          this.field_checkIntervalTime = paramCursor.getLong(i);
        }
        else if (fDd == k)
        {
          this.field_packMethod = paramCursor.getInt(i);
        }
        else if (fDe == k)
        {
          this.field_domain = paramCursor.getString(i);
        }
        else if (eUA == k)
        {
          this.field_md5 = paramCursor.getString(i);
        }
        else if (eOL == k)
        {
          this.field_downloadUrl = paramCursor.getString(i);
        }
        else if (fCo == k)
        {
          this.field_pkgSize = paramCursor.getInt(i);
        }
        else if (fCp == k)
        {
          this.field_downloadNetType = paramCursor.getInt(i);
        }
        else if (ffg == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else if (eFO == k)
        {
          this.field_createTime = paramCursor.getLong(i);
        }
        else if (fDf == k)
        {
          this.field_accessTime = paramCursor.getLong(i);
        }
        else if (fDg == k)
        {
          this.field_charset = paramCursor.getString(i);
        }
        else
        {
          if (fDh == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_bigPackageReady = bool;
              break;
            }
          }
          if (fDi == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesReady = bool;
              break;
            }
          }
          if (fDj == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesAtomic = bool;
              break;
            }
          }
          if (fCK == k)
          {
            this.field_autoDownloadCount = paramCursor.getInt(i);
          }
          else
          {
            if (fDk == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_disable = bool;
                break;
              }
            }
            if (fDl == k) {
              this.field_totalDownloadCount = paramCursor.getInt(i);
            } else if (fDm == k) {
              this.field_packageDownloadCount = paramCursor.getInt(i);
            } else if (fDn == k) {
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
    if (this.fCg) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eHO) {
      localContentValues.put("version", this.field_version);
    }
    if (this.eHQ) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.fCM) {
      localContentValues.put("disableWvCache", Boolean.valueOf(this.field_disableWvCache));
    }
    if (this.fCN) {
      localContentValues.put("clearPkgTime", Long.valueOf(this.field_clearPkgTime));
    }
    if (this.fCO) {
      localContentValues.put("checkIntervalTime", Long.valueOf(this.field_checkIntervalTime));
    }
    if (this.fCP) {
      localContentValues.put("packMethod", Integer.valueOf(this.field_packMethod));
    }
    if (this.fCQ) {
      localContentValues.put("domain", this.field_domain);
    }
    if (this.eTO) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eOD) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.fCj) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.fCk) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.feU) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.eFr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fCR) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.field_charset == null) {
      this.field_charset = "UTF-8";
    }
    if (this.fCS) {
      localContentValues.put("charset", this.field_charset);
    }
    if (this.fCT) {
      localContentValues.put("bigPackageReady", Boolean.valueOf(this.field_bigPackageReady));
    }
    if (this.fCU) {
      localContentValues.put("preloadFilesReady", Boolean.valueOf(this.field_preloadFilesReady));
    }
    if (this.fCV) {
      localContentValues.put("preloadFilesAtomic", Boolean.valueOf(this.field_preloadFilesAtomic));
    }
    if (this.fCF) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.fCW) {
      localContentValues.put("disable", Boolean.valueOf(this.field_disable));
    }
    if (this.fCX) {
      localContentValues.put("totalDownloadCount", Integer.valueOf(this.field_totalDownloadCount));
    }
    if (this.fCY) {
      localContentValues.put("packageDownloadCount", Integer.valueOf(this.field_packageDownloadCount));
    }
    if (this.fCZ) {
      localContentValues.put("downloadTriggerType", Integer.valueOf(this.field_downloadTriggerType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hh
 * JD-Core Version:    0.7.0.1
 */