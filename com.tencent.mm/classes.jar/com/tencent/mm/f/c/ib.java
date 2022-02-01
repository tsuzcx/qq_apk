package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ib
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WepkgVersion");
  private static final int createTime_HASHCODE;
  public static final Column hGW;
  private static final int hIy;
  public static final Column hnz;
  private static final int hoh;
  public static final Column hpJ;
  public static final Column hpL;
  public static final Column hpN;
  private static final int hpT;
  private static final int hpV;
  private static final int hzQ;
  public static final Column iJB;
  public static final Column iJC;
  private static final int iJI;
  private static final int iJL;
  private static final int iJM;
  public static final Column iJy;
  public static final Column iKR;
  private static final int iLF;
  private static final int iLG;
  private static final int iLH;
  private static final int iLI;
  private static final int iLJ;
  private static final int iLK;
  private static final int iLL;
  private static final int iLM;
  private static final int iLN;
  private static final int iLO;
  private static final int iLP = "disable".hashCode();
  private static final int iLQ = "totalDownloadCount".hashCode();
  private static final int iLR = "packageDownloadCount".hashCode();
  private static final int iLS = "downloadTriggerType".hashCode();
  private static final int iLb;
  public static final Column iLd;
  public static final Column iLe;
  public static final Column iLf;
  public static final Column iLg;
  public static final Column iLh;
  public static final Column iLi;
  public static final Column iLj;
  public static final Column iLk;
  public static final Column iLl;
  public static final Column iLm;
  public static final Column iLn;
  public static final Column iLo;
  public static final Column iLp;
  public static final Column iLq;
  private static final int iaB;
  public static final Column iae;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
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
  private boolean hHK = true;
  private boolean hnQ = true;
  private boolean hpO = true;
  private boolean hpQ = true;
  private boolean hzI = true;
  private boolean iJD = true;
  private boolean iJG = true;
  private boolean iJH = true;
  private boolean iKW = true;
  private boolean iLA = true;
  private boolean iLB = true;
  private boolean iLC = true;
  private boolean iLD = true;
  private boolean iLE = true;
  private boolean iLr = true;
  private boolean iLs = true;
  private boolean iLt = true;
  private boolean iLu = true;
  private boolean iLv = true;
  private boolean iLw = true;
  private boolean iLx = true;
  private boolean iLy = true;
  private boolean iLz = true;
  private boolean iap = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WepkgVersion", "");
    iJy = new Column("pkgid", "string", "WepkgVersion", "");
    hnz = new Column("appid", "string", "WepkgVersion", "");
    hpJ = new Column("version", "string", "WepkgVersion", "");
    hpL = new Column("pkgpath", "string", "WepkgVersion", "");
    iLd = new Column("disablewvcache", "boolean", "WepkgVersion", "");
    iLe = new Column("clearpkgtime", "long", "WepkgVersion", "");
    iLf = new Column("checkintervaltime", "long", "WepkgVersion", "");
    iLg = new Column("packmethod", "int", "WepkgVersion", "");
    iLh = new Column("domain", "string", "WepkgVersion", "");
    hGW = new Column("md5", "string", "WepkgVersion", "");
    hpN = new Column("downloadurl", "string", "WepkgVersion", "");
    iJB = new Column("pkgsize", "int", "WepkgVersion", "");
    iJC = new Column("downloadnettype", "int", "WepkgVersion", "");
    iae = new Column("nextchecktime", "long", "WepkgVersion", "");
    C_CREATETIME = new Column("createtime", "long", "WepkgVersion", "");
    iLi = new Column("accesstime", "long", "WepkgVersion", "");
    iLj = new Column("charset", "string", "WepkgVersion", "");
    iLk = new Column("bigpackageready", "boolean", "WepkgVersion", "");
    iLl = new Column("preloadfilesready", "boolean", "WepkgVersion", "");
    iLm = new Column("preloadfilesatomic", "boolean", "WepkgVersion", "");
    iKR = new Column("autodownloadcount", "int", "WepkgVersion", "");
    iLn = new Column("disable", "boolean", "WepkgVersion", "");
    iLo = new Column("totaldownloadcount", "int", "WepkgVersion", "");
    iLp = new Column("packagedownloadcount", "int", "WepkgVersion", "");
    iLq = new Column("downloadtriggertype", "int", "WepkgVersion", "");
    iJI = "pkgId".hashCode();
    hoh = "appId".hashCode();
    hpT = "version".hashCode();
    hpV = "pkgPath".hashCode();
    iLF = "disableWvCache".hashCode();
    iLG = "clearPkgTime".hashCode();
    iLH = "checkIntervalTime".hashCode();
    iLI = "packMethod".hashCode();
    iLJ = "domain".hashCode();
    hIy = "md5".hashCode();
    hzQ = "downloadUrl".hashCode();
    iJL = "pkgSize".hashCode();
    iJM = "downloadNetType".hashCode();
    iaB = "nextCheckTime".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    iLK = "accessTime".hashCode();
    iLL = "charset".hashCode();
    iLM = "bigPackageReady".hashCode();
    iLN = "preloadFilesReady".hashCode();
    iLO = "preloadFilesAtomic".hashCode();
    iLb = "autoDownloadCount".hashCode();
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
      if (iJI != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.iJD = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hoh == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (hpT == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (hpV == k)
      {
        this.field_pkgPath = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (iLF == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_disableWvCache = bool;
            break;
          }
        }
        if (iLG == k)
        {
          this.field_clearPkgTime = paramCursor.getLong(i);
        }
        else if (iLH == k)
        {
          this.field_checkIntervalTime = paramCursor.getLong(i);
        }
        else if (iLI == k)
        {
          this.field_packMethod = paramCursor.getInt(i);
        }
        else if (iLJ == k)
        {
          this.field_domain = paramCursor.getString(i);
        }
        else if (hIy == k)
        {
          this.field_md5 = paramCursor.getString(i);
        }
        else if (hzQ == k)
        {
          this.field_downloadUrl = paramCursor.getString(i);
        }
        else if (iJL == k)
        {
          this.field_pkgSize = paramCursor.getInt(i);
        }
        else if (iJM == k)
        {
          this.field_downloadNetType = paramCursor.getInt(i);
        }
        else if (iaB == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else if (createTime_HASHCODE == k)
        {
          this.field_createTime = paramCursor.getLong(i);
        }
        else if (iLK == k)
        {
          this.field_accessTime = paramCursor.getLong(i);
        }
        else if (iLL == k)
        {
          this.field_charset = paramCursor.getString(i);
        }
        else
        {
          if (iLM == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_bigPackageReady = bool;
              break;
            }
          }
          if (iLN == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesReady = bool;
              break;
            }
          }
          if (iLO == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesAtomic = bool;
              break;
            }
          }
          if (iLb == k)
          {
            this.field_autoDownloadCount = paramCursor.getInt(i);
          }
          else
          {
            if (iLP == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_disable = bool;
                break;
              }
            }
            if (iLQ == k) {
              this.field_totalDownloadCount = paramCursor.getInt(i);
            } else if (iLR == k) {
              this.field_packageDownloadCount = paramCursor.getInt(i);
            } else if (iLS == k) {
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
    if (this.iJD) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hpO) {
      localContentValues.put("version", this.field_version);
    }
    if (this.hpQ) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.iLr) {
      localContentValues.put("disableWvCache", Boolean.valueOf(this.field_disableWvCache));
    }
    if (this.iLs) {
      localContentValues.put("clearPkgTime", Long.valueOf(this.field_clearPkgTime));
    }
    if (this.iLt) {
      localContentValues.put("checkIntervalTime", Long.valueOf(this.field_checkIntervalTime));
    }
    if (this.iLu) {
      localContentValues.put("packMethod", Integer.valueOf(this.field_packMethod));
    }
    if (this.iLv) {
      localContentValues.put("domain", this.field_domain);
    }
    if (this.hHK) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.hzI) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.iJG) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.iJH) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.iap) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.iLw) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.field_charset == null) {
      this.field_charset = "UTF-8";
    }
    if (this.iLx) {
      localContentValues.put("charset", this.field_charset);
    }
    if (this.iLy) {
      localContentValues.put("bigPackageReady", Boolean.valueOf(this.field_bigPackageReady));
    }
    if (this.iLz) {
      localContentValues.put("preloadFilesReady", Boolean.valueOf(this.field_preloadFilesReady));
    }
    if (this.iLA) {
      localContentValues.put("preloadFilesAtomic", Boolean.valueOf(this.field_preloadFilesAtomic));
    }
    if (this.iKW) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.iLB) {
      localContentValues.put("disable", Boolean.valueOf(this.field_disable));
    }
    if (this.iLC) {
      localContentValues.put("totalDownloadCount", Integer.valueOf(this.field_totalDownloadCount));
    }
    if (this.iLD) {
      localContentValues.put("packageDownloadCount", Integer.valueOf(this.field_packageDownloadCount));
    }
    if (this.iLE) {
      localContentValues.put("downloadTriggerType", Integer.valueOf(this.field_downloadTriggerType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "WepkgVersion";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ib
 * JD-Core Version:    0.7.0.1
 */