package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gw
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBr;
  private static final int eKT;
  private static final int emY;
  private static final int enO;
  private static final int epb;
  private static final int epd;
  private static final int evD;
  private static final int fiD = "autoDownloadCount".hashCode();
  private static final int fiT;
  private static final int fiU;
  private static final int fiV;
  private static final int fiW;
  private static final int fiX;
  private static final int fiY;
  private static final int fiZ;
  private static final int fid = "pkgId".hashCode();
  private static final int fig;
  private static final int fih;
  private static final int fja;
  private static final int fjb;
  private static final int fjc;
  private static final int fjd = "disable".hashCode();
  private static final int fje = "totalDownloadCount".hashCode();
  private static final int fjf = "packageDownloadCount".hashCode();
  private static final int fjg = "downloadTriggerType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAF = true;
  private boolean eKH = true;
  private boolean emB = true;
  private boolean enx = true;
  private boolean eoW = true;
  private boolean eoY = true;
  private boolean evv = true;
  private boolean fhY = true;
  private boolean fiF = true;
  private boolean fiG = true;
  private boolean fiH = true;
  private boolean fiI = true;
  private boolean fiJ = true;
  private boolean fiK = true;
  private boolean fiL = true;
  private boolean fiM = true;
  private boolean fiN = true;
  private boolean fiO = true;
  private boolean fiP = true;
  private boolean fiQ = true;
  private boolean fiR = true;
  private boolean fiS = true;
  private boolean fib = true;
  private boolean fic = true;
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
  private boolean fiy = true;
  
  static
  {
    enO = "appId".hashCode();
    epb = "version".hashCode();
    epd = "pkgPath".hashCode();
    fiT = "disableWvCache".hashCode();
    fiU = "clearPkgTime".hashCode();
    fiV = "checkIntervalTime".hashCode();
    fiW = "packMethod".hashCode();
    fiX = "domain".hashCode();
    eBr = "md5".hashCode();
    evD = "downloadUrl".hashCode();
    fig = "pkgSize".hashCode();
    fih = "downloadNetType".hashCode();
    eKT = "nextCheckTime".hashCode();
    emY = "createTime".hashCode();
    fiY = "accessTime".hashCode();
    fiZ = "charset".hashCode();
    fja = "bigPackageReady".hashCode();
    fjb = "preloadFilesReady".hashCode();
    fjc = "preloadFilesAtomic".hashCode();
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
      if (fid != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.fhY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (enO == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (epb == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (epd == k)
      {
        this.field_pkgPath = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (fiT == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_disableWvCache = bool;
            break;
          }
        }
        if (fiU == k)
        {
          this.field_clearPkgTime = paramCursor.getLong(i);
        }
        else if (fiV == k)
        {
          this.field_checkIntervalTime = paramCursor.getLong(i);
        }
        else if (fiW == k)
        {
          this.field_packMethod = paramCursor.getInt(i);
        }
        else if (fiX == k)
        {
          this.field_domain = paramCursor.getString(i);
        }
        else if (eBr == k)
        {
          this.field_md5 = paramCursor.getString(i);
        }
        else if (evD == k)
        {
          this.field_downloadUrl = paramCursor.getString(i);
        }
        else if (fig == k)
        {
          this.field_pkgSize = paramCursor.getInt(i);
        }
        else if (fih == k)
        {
          this.field_downloadNetType = paramCursor.getInt(i);
        }
        else if (eKT == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else if (emY == k)
        {
          this.field_createTime = paramCursor.getLong(i);
        }
        else if (fiY == k)
        {
          this.field_accessTime = paramCursor.getLong(i);
        }
        else if (fiZ == k)
        {
          this.field_charset = paramCursor.getString(i);
        }
        else
        {
          if (fja == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_bigPackageReady = bool;
              break;
            }
          }
          if (fjb == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesReady = bool;
              break;
            }
          }
          if (fjc == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesAtomic = bool;
              break;
            }
          }
          if (fiD == k)
          {
            this.field_autoDownloadCount = paramCursor.getInt(i);
          }
          else
          {
            if (fjd == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_disable = bool;
                break;
              }
            }
            if (fje == k) {
              this.field_totalDownloadCount = paramCursor.getInt(i);
            } else if (fjf == k) {
              this.field_packageDownloadCount = paramCursor.getInt(i);
            } else if (fjg == k) {
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
    if (this.fhY) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eoW) {
      localContentValues.put("version", this.field_version);
    }
    if (this.eoY) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.fiF) {
      localContentValues.put("disableWvCache", Boolean.valueOf(this.field_disableWvCache));
    }
    if (this.fiG) {
      localContentValues.put("clearPkgTime", Long.valueOf(this.field_clearPkgTime));
    }
    if (this.fiH) {
      localContentValues.put("checkIntervalTime", Long.valueOf(this.field_checkIntervalTime));
    }
    if (this.fiI) {
      localContentValues.put("packMethod", Integer.valueOf(this.field_packMethod));
    }
    if (this.fiJ) {
      localContentValues.put("domain", this.field_domain);
    }
    if (this.eAF) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.evv) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.fib) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.fic) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.eKH) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.emB) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fiK) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.field_charset == null) {
      this.field_charset = "UTF-8";
    }
    if (this.fiL) {
      localContentValues.put("charset", this.field_charset);
    }
    if (this.fiM) {
      localContentValues.put("bigPackageReady", Boolean.valueOf(this.field_bigPackageReady));
    }
    if (this.fiN) {
      localContentValues.put("preloadFilesReady", Boolean.valueOf(this.field_preloadFilesReady));
    }
    if (this.fiO) {
      localContentValues.put("preloadFilesAtomic", Boolean.valueOf(this.field_preloadFilesAtomic));
    }
    if (this.fiy) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.fiP) {
      localContentValues.put("disable", Boolean.valueOf(this.field_disable));
    }
    if (this.fiQ) {
      localContentValues.put("totalDownloadCount", Integer.valueOf(this.field_totalDownloadCount));
    }
    if (this.fiR) {
      localContentValues.put("packageDownloadCount", Integer.valueOf(this.field_packageDownloadCount));
    }
    if (this.fiS) {
      localContentValues.put("downloadTriggerType", Integer.valueOf(this.field_downloadTriggerType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gw
 * JD-Core Version:    0.7.0.1
 */