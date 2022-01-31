package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fd
  extends c
{
  private static final int cHG;
  private static final int cKZ;
  private static final int cSs;
  private static final int cVE;
  private static final int cVF;
  private static final int cVW;
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS WebViewResourceCacheAppIdIndex ON WebViewResourceCache(appId)", "CREATE INDEX IF NOT EXISTS WebViewResourceCacheDomainIndex ON WebViewResourceCache(domain)", "CREATE INDEX IF NOT EXISTS WebViewResourceCachePackageIdIndex ON WebViewResourceCache(packageId)" };
  private static final int crh = "rowid".hashCode();
  private static final int csv;
  private static final int ctl;
  private static final int cuv;
  private static final int cwu;
  private static final int dej = "urlMd5Hashcode".hashCode();
  private static final int dek;
  private static final int del;
  private static final int dem;
  private static final int den;
  private static final int deo;
  private static final int dep;
  private boolean cHF = true;
  private boolean cKR = true;
  private boolean cRL = true;
  private boolean cVh = true;
  private boolean cVi = true;
  private boolean cVz = true;
  private boolean crX = true;
  private boolean csU = true;
  private boolean cup = true;
  private boolean cwp = true;
  private boolean dec = true;
  private boolean ded = true;
  private boolean dee = true;
  private boolean def = true;
  private boolean deg = true;
  private boolean deh = true;
  private boolean dei = true;
  public long field_accessTime;
  public String field_appId;
  public int field_cacheType;
  public String field_configId;
  public long field_contentLength;
  public String field_contentMd5;
  public String field_contentType;
  public long field_createTime;
  public String field_domain;
  public long field_expireTime;
  public boolean field_isLatestVersion;
  public String field_localPath;
  public String field_packageId;
  public int field_protocol;
  public String field_url;
  public int field_urlMd5Hashcode;
  public String field_version;
  
  static
  {
    cwu = "url".hashCode();
    ctl = "appId".hashCode();
    dek = "domain".hashCode();
    cuv = "version".hashCode();
    del = "localPath".hashCode();
    cVF = "contentType".hashCode();
    cVE = "contentLength".hashCode();
    dem = "isLatestVersion".hashCode();
    csv = "createTime".hashCode();
    den = "accessTime".hashCode();
    cKZ = "expireTime".hashCode();
    deo = "cacheType".hashCode();
    cHG = "configId".hashCode();
    cSs = "protocol".hashCode();
    cVW = "packageId".hashCode();
    dep = "contentMd5".hashCode();
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
      if (dej != k) {
        break label60;
      }
      this.field_urlMd5Hashcode = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (cwu == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (ctl == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (dek == k)
      {
        this.field_domain = paramCursor.getString(i);
      }
      else if (cuv == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (del == k)
      {
        this.field_localPath = paramCursor.getString(i);
      }
      else if (cVF == k)
      {
        this.field_contentType = paramCursor.getString(i);
      }
      else if (cVE == k)
      {
        this.field_contentLength = paramCursor.getLong(i);
      }
      else
      {
        if (dem == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isLatestVersion = bool;
            break;
          }
        }
        if (csv == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (den == k) {
          this.field_accessTime = paramCursor.getLong(i);
        } else if (cKZ == k) {
          this.field_expireTime = paramCursor.getLong(i);
        } else if (deo == k) {
          this.field_cacheType = paramCursor.getInt(i);
        } else if (cHG == k) {
          this.field_configId = paramCursor.getString(i);
        } else if (cSs == k) {
          this.field_protocol = paramCursor.getInt(i);
        } else if (cVW == k) {
          this.field_packageId = paramCursor.getString(i);
        } else if (dep == k) {
          this.field_contentMd5 = paramCursor.getString(i);
        } else if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dec) {
      localContentValues.put("urlMd5Hashcode", Integer.valueOf(this.field_urlMd5Hashcode));
    }
    if (this.cwp) {
      localContentValues.put("url", this.field_url);
    }
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.ded) {
      localContentValues.put("domain", this.field_domain);
    }
    if (this.cup) {
      localContentValues.put("version", this.field_version);
    }
    if (this.dee) {
      localContentValues.put("localPath", this.field_localPath);
    }
    if (this.cVi) {
      localContentValues.put("contentType", this.field_contentType);
    }
    if (this.cVh) {
      localContentValues.put("contentLength", Long.valueOf(this.field_contentLength));
    }
    if (this.def) {
      localContentValues.put("isLatestVersion", Boolean.valueOf(this.field_isLatestVersion));
    }
    if (this.crX) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.deg) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.cKR) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.deh) {
      localContentValues.put("cacheType", Integer.valueOf(this.field_cacheType));
    }
    if (this.cHF) {
      localContentValues.put("configId", this.field_configId);
    }
    if (this.cRL) {
      localContentValues.put("protocol", Integer.valueOf(this.field_protocol));
    }
    if (this.cVz) {
      localContentValues.put("packageId", this.field_packageId);
    }
    if (this.dei) {
      localContentValues.put("contentMd5", this.field_contentMd5);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.fd
 * JD-Core Version:    0.7.0.1
 */