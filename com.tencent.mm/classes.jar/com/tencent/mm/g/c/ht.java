package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ht
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int createTime_HASHCODE;
  private static final int fJJ;
  private static final int fkj;
  private static final int flv;
  private static final int flx;
  private static final int fss;
  private static final int fyf;
  private static final int ghU = "autoDownloadCount".hashCode();
  private static final int ghj = "pkgId".hashCode();
  private static final int ghm;
  private static final int ghn;
  private static final int gik;
  private static final int gil;
  private static final int gim;
  private static final int gin;
  private static final int gio;
  private static final int gip;
  private static final int giq;
  private static final int gir;
  private static final int gis;
  private static final int git;
  private static final int giu = "disable".hashCode();
  private static final int giv = "totalDownloadCount".hashCode();
  private static final int giw = "packageDownloadCount".hashCode();
  private static final int gix = "downloadTriggerType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  private boolean fJx = true;
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
  private boolean fjS = true;
  private boolean flq = true;
  private boolean fls = true;
  private boolean fsk = true;
  private boolean fxt = true;
  private boolean ghP = true;
  private boolean ghW = true;
  private boolean ghX = true;
  private boolean ghY = true;
  private boolean ghZ = true;
  private boolean ghe = true;
  private boolean ghh = true;
  private boolean ghi = true;
  private boolean gia = true;
  private boolean gib = true;
  private boolean gic = true;
  private boolean gid = true;
  private boolean gie = true;
  private boolean gif = true;
  private boolean gig = true;
  private boolean gih = true;
  private boolean gii = true;
  private boolean gij = true;
  
  static
  {
    fkj = "appId".hashCode();
    flv = "version".hashCode();
    flx = "pkgPath".hashCode();
    gik = "disableWvCache".hashCode();
    gil = "clearPkgTime".hashCode();
    gim = "checkIntervalTime".hashCode();
    gin = "packMethod".hashCode();
    gio = "domain".hashCode();
    fyf = "md5".hashCode();
    fss = "downloadUrl".hashCode();
    ghm = "pkgSize".hashCode();
    ghn = "downloadNetType".hashCode();
    fJJ = "nextCheckTime".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    gip = "accessTime".hashCode();
    giq = "charset".hashCode();
    gir = "bigPackageReady".hashCode();
    gis = "preloadFilesReady".hashCode();
    git = "preloadFilesAtomic".hashCode();
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
      if (ghj != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.ghe = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fkj == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (flv == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (flx == k)
      {
        this.field_pkgPath = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (gik == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_disableWvCache = bool;
            break;
          }
        }
        if (gil == k)
        {
          this.field_clearPkgTime = paramCursor.getLong(i);
        }
        else if (gim == k)
        {
          this.field_checkIntervalTime = paramCursor.getLong(i);
        }
        else if (gin == k)
        {
          this.field_packMethod = paramCursor.getInt(i);
        }
        else if (gio == k)
        {
          this.field_domain = paramCursor.getString(i);
        }
        else if (fyf == k)
        {
          this.field_md5 = paramCursor.getString(i);
        }
        else if (fss == k)
        {
          this.field_downloadUrl = paramCursor.getString(i);
        }
        else if (ghm == k)
        {
          this.field_pkgSize = paramCursor.getInt(i);
        }
        else if (ghn == k)
        {
          this.field_downloadNetType = paramCursor.getInt(i);
        }
        else if (fJJ == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else if (createTime_HASHCODE == k)
        {
          this.field_createTime = paramCursor.getLong(i);
        }
        else if (gip == k)
        {
          this.field_accessTime = paramCursor.getLong(i);
        }
        else if (giq == k)
        {
          this.field_charset = paramCursor.getString(i);
        }
        else
        {
          if (gir == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_bigPackageReady = bool;
              break;
            }
          }
          if (gis == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesReady = bool;
              break;
            }
          }
          if (git == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesAtomic = bool;
              break;
            }
          }
          if (ghU == k)
          {
            this.field_autoDownloadCount = paramCursor.getInt(i);
          }
          else
          {
            if (giu == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_disable = bool;
                break;
              }
            }
            if (giv == k) {
              this.field_totalDownloadCount = paramCursor.getInt(i);
            } else if (giw == k) {
              this.field_packageDownloadCount = paramCursor.getInt(i);
            } else if (gix == k) {
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
    if (this.ghe) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.flq) {
      localContentValues.put("version", this.field_version);
    }
    if (this.fls) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.ghW) {
      localContentValues.put("disableWvCache", Boolean.valueOf(this.field_disableWvCache));
    }
    if (this.ghX) {
      localContentValues.put("clearPkgTime", Long.valueOf(this.field_clearPkgTime));
    }
    if (this.ghY) {
      localContentValues.put("checkIntervalTime", Long.valueOf(this.field_checkIntervalTime));
    }
    if (this.ghZ) {
      localContentValues.put("packMethod", Integer.valueOf(this.field_packMethod));
    }
    if (this.gia) {
      localContentValues.put("domain", this.field_domain);
    }
    if (this.fxt) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.fsk) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.ghh) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.ghi) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.fJx) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.gib) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.field_charset == null) {
      this.field_charset = "UTF-8";
    }
    if (this.gic) {
      localContentValues.put("charset", this.field_charset);
    }
    if (this.gid) {
      localContentValues.put("bigPackageReady", Boolean.valueOf(this.field_bigPackageReady));
    }
    if (this.gie) {
      localContentValues.put("preloadFilesReady", Boolean.valueOf(this.field_preloadFilesReady));
    }
    if (this.gif) {
      localContentValues.put("preloadFilesAtomic", Boolean.valueOf(this.field_preloadFilesAtomic));
    }
    if (this.ghP) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.gig) {
      localContentValues.put("disable", Boolean.valueOf(this.field_disable));
    }
    if (this.gih) {
      localContentValues.put("totalDownloadCount", Integer.valueOf(this.field_totalDownloadCount));
    }
    if (this.gii) {
      localContentValues.put("packageDownloadCount", Integer.valueOf(this.field_packageDownloadCount));
    }
    if (this.gij) {
      localContentValues.put("downloadTriggerType", Integer.valueOf(this.field_downloadTriggerType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.ht
 * JD-Core Version:    0.7.0.1
 */