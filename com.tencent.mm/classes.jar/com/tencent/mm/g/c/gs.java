package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gs
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eIb;
  private static final int ekU;
  private static final int elJ;
  private static final int emV;
  private static final int emX;
  private static final int etz;
  private static final int eyX;
  private static final int feL = "pkgId".hashCode();
  private static final int feO;
  private static final int feP;
  private static final int ffA;
  private static final int ffB;
  private static final int ffC;
  private static final int ffD;
  private static final int ffE;
  private static final int ffF;
  private static final int ffG;
  private static final int ffH;
  private static final int ffI;
  private static final int ffJ;
  private static final int ffK = "disable".hashCode();
  private static final int ffL = "totalDownloadCount".hashCode();
  private static final int ffM = "packageDownloadCount".hashCode();
  private static final int ffN = "downloadTriggerType".hashCode();
  private static final int ffk;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eHP = true;
  private boolean ekx = true;
  private boolean els = true;
  private boolean emQ = true;
  private boolean emS = true;
  private boolean etr = true;
  private boolean eyl = true;
  private boolean feG = true;
  private boolean feJ = true;
  private boolean feK = true;
  private boolean fff = true;
  private boolean ffm = true;
  private boolean ffn = true;
  private boolean ffo = true;
  private boolean ffp = true;
  private boolean ffq = true;
  private boolean ffr = true;
  private boolean ffs = true;
  private boolean fft = true;
  private boolean ffu = true;
  private boolean ffv = true;
  private boolean ffw = true;
  private boolean ffx = true;
  private boolean ffy = true;
  private boolean ffz = true;
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
    elJ = "appId".hashCode();
    emV = "version".hashCode();
    emX = "pkgPath".hashCode();
    ffA = "disableWvCache".hashCode();
    ffB = "clearPkgTime".hashCode();
    ffC = "checkIntervalTime".hashCode();
    ffD = "packMethod".hashCode();
    ffE = "domain".hashCode();
    eyX = "md5".hashCode();
    etz = "downloadUrl".hashCode();
    feO = "pkgSize".hashCode();
    feP = "downloadNetType".hashCode();
    eIb = "nextCheckTime".hashCode();
    ekU = "createTime".hashCode();
    ffF = "accessTime".hashCode();
    ffG = "charset".hashCode();
    ffH = "bigPackageReady".hashCode();
    ffI = "preloadFilesReady".hashCode();
    ffJ = "preloadFilesAtomic".hashCode();
    ffk = "autoDownloadCount".hashCode();
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
      if (feL != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.feG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (elJ == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (emV == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (emX == k)
      {
        this.field_pkgPath = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (ffA == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_disableWvCache = bool;
            break;
          }
        }
        if (ffB == k)
        {
          this.field_clearPkgTime = paramCursor.getLong(i);
        }
        else if (ffC == k)
        {
          this.field_checkIntervalTime = paramCursor.getLong(i);
        }
        else if (ffD == k)
        {
          this.field_packMethod = paramCursor.getInt(i);
        }
        else if (ffE == k)
        {
          this.field_domain = paramCursor.getString(i);
        }
        else if (eyX == k)
        {
          this.field_md5 = paramCursor.getString(i);
        }
        else if (etz == k)
        {
          this.field_downloadUrl = paramCursor.getString(i);
        }
        else if (feO == k)
        {
          this.field_pkgSize = paramCursor.getInt(i);
        }
        else if (feP == k)
        {
          this.field_downloadNetType = paramCursor.getInt(i);
        }
        else if (eIb == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else if (ekU == k)
        {
          this.field_createTime = paramCursor.getLong(i);
        }
        else if (ffF == k)
        {
          this.field_accessTime = paramCursor.getLong(i);
        }
        else if (ffG == k)
        {
          this.field_charset = paramCursor.getString(i);
        }
        else
        {
          if (ffH == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_bigPackageReady = bool;
              break;
            }
          }
          if (ffI == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesReady = bool;
              break;
            }
          }
          if (ffJ == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesAtomic = bool;
              break;
            }
          }
          if (ffk == k)
          {
            this.field_autoDownloadCount = paramCursor.getInt(i);
          }
          else
          {
            if (ffK == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_disable = bool;
                break;
              }
            }
            if (ffL == k) {
              this.field_totalDownloadCount = paramCursor.getInt(i);
            } else if (ffM == k) {
              this.field_packageDownloadCount = paramCursor.getInt(i);
            } else if (ffN == k) {
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
    if (this.feG) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.emQ) {
      localContentValues.put("version", this.field_version);
    }
    if (this.emS) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.ffm) {
      localContentValues.put("disableWvCache", Boolean.valueOf(this.field_disableWvCache));
    }
    if (this.ffn) {
      localContentValues.put("clearPkgTime", Long.valueOf(this.field_clearPkgTime));
    }
    if (this.ffo) {
      localContentValues.put("checkIntervalTime", Long.valueOf(this.field_checkIntervalTime));
    }
    if (this.ffp) {
      localContentValues.put("packMethod", Integer.valueOf(this.field_packMethod));
    }
    if (this.ffq) {
      localContentValues.put("domain", this.field_domain);
    }
    if (this.eyl) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.etr) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.feJ) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.feK) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.eHP) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.ekx) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.ffr) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.field_charset == null) {
      this.field_charset = "UTF-8";
    }
    if (this.ffs) {
      localContentValues.put("charset", this.field_charset);
    }
    if (this.fft) {
      localContentValues.put("bigPackageReady", Boolean.valueOf(this.field_bigPackageReady));
    }
    if (this.ffu) {
      localContentValues.put("preloadFilesReady", Boolean.valueOf(this.field_preloadFilesReady));
    }
    if (this.ffv) {
      localContentValues.put("preloadFilesAtomic", Boolean.valueOf(this.field_preloadFilesAtomic));
    }
    if (this.fff) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.ffw) {
      localContentValues.put("disable", Boolean.valueOf(this.field_disable));
    }
    if (this.ffx) {
      localContentValues.put("totalDownloadCount", Integer.valueOf(this.field_totalDownloadCount));
    }
    if (this.ffy) {
      localContentValues.put("packageDownloadCount", Integer.valueOf(this.field_packageDownloadCount));
    }
    if (this.ffz) {
      localContentValues.put("downloadTriggerType", Integer.valueOf(this.field_downloadTriggerType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gs
 * JD-Core Version:    0.7.0.1
 */