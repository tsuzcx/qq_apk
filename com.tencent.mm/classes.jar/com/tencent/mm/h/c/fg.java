package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fg
  extends c
{
  private static final int cAF;
  private static final int cFC;
  private static final int cLr;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csv;
  private static final int ctl;
  private static final int cuv;
  private static final int cuy;
  private static final int ddN;
  private static final int deC;
  private static final int deE;
  private static final int deS;
  private static final int deT;
  private static final int deU;
  private static final int deV;
  private static final int deW;
  private static final int deX;
  private static final int deY;
  private static final int deZ;
  private static final int dek;
  private static final int den;
  private static final int dez = "pkgId".hashCode();
  private static final int dfa;
  private static final int dfb;
  private static final int dfc;
  private static final int dfd;
  private boolean cAx = true;
  private boolean cEZ = true;
  private boolean cLh = true;
  private boolean crX = true;
  private boolean csU = true;
  private boolean cup = true;
  private boolean cus = true;
  private boolean ddI = true;
  private boolean deG = true;
  private boolean deH = true;
  private boolean deI = true;
  private boolean deJ = true;
  private boolean deK = true;
  private boolean deL = true;
  private boolean deM = true;
  private boolean deN = true;
  private boolean deO = true;
  private boolean deP = true;
  private boolean deQ = true;
  private boolean deR = true;
  private boolean ded = true;
  private boolean deg = true;
  private boolean des = true;
  private boolean dev = true;
  private boolean dex = true;
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
    ctl = "appId".hashCode();
    cuv = "version".hashCode();
    cuy = "pkgPath".hashCode();
    deS = "disableWvCache".hashCode();
    deT = "clearPkgTime".hashCode();
    deU = "checkIntervalTime".hashCode();
    deV = "packMethod".hashCode();
    dek = "domain".hashCode();
    cFC = "md5".hashCode();
    cAF = "downloadUrl".hashCode();
    deW = "pkgSize".hashCode();
    deC = "downloadNetType".hashCode();
    cLr = "nextCheckTime".hashCode();
    csv = "createTime".hashCode();
    den = "accessTime".hashCode();
    deX = "charset".hashCode();
    deY = "bigPackageReady".hashCode();
    deZ = "preloadFilesReady".hashCode();
    dfa = "preloadFilesAtomic".hashCode();
    deE = "autoDownloadCount".hashCode();
    ddN = "disable".hashCode();
    dfb = "totalDownloadCount".hashCode();
    dfc = "packageDownloadCount".hashCode();
    dfd = "downloadTriggerType".hashCode();
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
      if (dez != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.des = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ctl == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (cuv == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (cuy == k)
      {
        this.field_pkgPath = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (deS == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_disableWvCache = bool;
            break;
          }
        }
        if (deT == k)
        {
          this.field_clearPkgTime = paramCursor.getLong(i);
        }
        else if (deU == k)
        {
          this.field_checkIntervalTime = paramCursor.getLong(i);
        }
        else if (deV == k)
        {
          this.field_packMethod = paramCursor.getInt(i);
        }
        else if (dek == k)
        {
          this.field_domain = paramCursor.getString(i);
        }
        else if (cFC == k)
        {
          this.field_md5 = paramCursor.getString(i);
        }
        else if (cAF == k)
        {
          this.field_downloadUrl = paramCursor.getString(i);
        }
        else if (deW == k)
        {
          this.field_pkgSize = paramCursor.getInt(i);
        }
        else if (deC == k)
        {
          this.field_downloadNetType = paramCursor.getInt(i);
        }
        else if (cLr == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else if (csv == k)
        {
          this.field_createTime = paramCursor.getLong(i);
        }
        else if (den == k)
        {
          this.field_accessTime = paramCursor.getLong(i);
        }
        else if (deX == k)
        {
          this.field_charset = paramCursor.getString(i);
        }
        else
        {
          if (deY == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_bigPackageReady = bool;
              break;
            }
          }
          if (deZ == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesReady = bool;
              break;
            }
          }
          if (dfa == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesAtomic = bool;
              break;
            }
          }
          if (deE == k)
          {
            this.field_autoDownloadCount = paramCursor.getInt(i);
          }
          else
          {
            if (ddN == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_disable = bool;
                break;
              }
            }
            if (dfb == k) {
              this.field_totalDownloadCount = paramCursor.getInt(i);
            } else if (dfc == k) {
              this.field_packageDownloadCount = paramCursor.getInt(i);
            } else if (dfd == k) {
              this.field_downloadTriggerType = paramCursor.getInt(i);
            } else if (crh == k) {
              this.ujK = paramCursor.getLong(i);
            }
          }
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.des) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.cup) {
      localContentValues.put("version", this.field_version);
    }
    if (this.cus) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.deG) {
      localContentValues.put("disableWvCache", Boolean.valueOf(this.field_disableWvCache));
    }
    if (this.deH) {
      localContentValues.put("clearPkgTime", Long.valueOf(this.field_clearPkgTime));
    }
    if (this.deI) {
      localContentValues.put("checkIntervalTime", Long.valueOf(this.field_checkIntervalTime));
    }
    if (this.deJ) {
      localContentValues.put("packMethod", Integer.valueOf(this.field_packMethod));
    }
    if (this.ded) {
      localContentValues.put("domain", this.field_domain);
    }
    if (this.cEZ) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.cAx) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.deK) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.dev) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.cLh) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.crX) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.deg) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.field_charset == null) {
      this.field_charset = "UTF-8";
    }
    if (this.deL) {
      localContentValues.put("charset", this.field_charset);
    }
    if (this.deM) {
      localContentValues.put("bigPackageReady", Boolean.valueOf(this.field_bigPackageReady));
    }
    if (this.deN) {
      localContentValues.put("preloadFilesReady", Boolean.valueOf(this.field_preloadFilesReady));
    }
    if (this.deO) {
      localContentValues.put("preloadFilesAtomic", Boolean.valueOf(this.field_preloadFilesAtomic));
    }
    if (this.dex) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.ddI) {
      localContentValues.put("disable", Boolean.valueOf(this.field_disable));
    }
    if (this.deP) {
      localContentValues.put("totalDownloadCount", Integer.valueOf(this.field_totalDownloadCount));
    }
    if (this.deQ) {
      localContentValues.put("packageDownloadCount", Integer.valueOf(this.field_packageDownloadCount));
    }
    if (this.deR) {
      localContentValues.put("downloadTriggerType", Integer.valueOf(this.field_downloadTriggerType));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.fg
 * JD-Core Version:    0.7.0.1
 */