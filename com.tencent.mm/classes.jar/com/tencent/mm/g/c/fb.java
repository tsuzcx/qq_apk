package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fb
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBr;
  private static final int eFC;
  private static final int eKw;
  private static final int eUL;
  private static final int eWh;
  private static final int eWk;
  private static final int eXQ = "urlKey_hashcode".hashCode();
  private static final int eXR = "urlKey".hashCode();
  private static final int eXS;
  private static final int eXT;
  private static final int eXU;
  private static final int eXV;
  private static final int eXW;
  private static final int eXX;
  private static final int eXY;
  private static final int eXZ;
  private static final int eYa;
  private static final int eYb;
  private static final int eYc;
  private static final int eYd;
  private static final int eYe;
  private static final int eYf;
  private static final int eYg;
  private static final int eYh;
  private static final int eYi;
  private static final int eYj;
  private static final int eYk = "wvCacheType".hashCode();
  private static final int eYl = "packageId".hashCode();
  private static final int elV;
  private static final int enO;
  private static final int enp;
  private static final int epp;
  private static final int erd = "url".hashCode();
  private static final int evF;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAF = true;
  private boolean eEZ = true;
  private boolean eKl = true;
  private boolean eUD = true;
  private boolean eVY = true;
  private boolean eWb = true;
  private boolean eXA = true;
  private boolean eXB = true;
  private boolean eXC = true;
  private boolean eXD = true;
  private boolean eXE = true;
  private boolean eXF = true;
  private boolean eXG = true;
  private boolean eXH = true;
  private boolean eXI = true;
  private boolean eXJ = true;
  private boolean eXK = true;
  private boolean eXL = true;
  private boolean eXM = true;
  private boolean eXN = true;
  private boolean eXO = true;
  private boolean eXP = true;
  private boolean eXu = true;
  private boolean eXv = true;
  private boolean eXw = true;
  private boolean eXx = true;
  private boolean eXy = true;
  private boolean eXz = true;
  private boolean elS = true;
  private boolean emR = true;
  private boolean enx = true;
  private boolean epk = true;
  private boolean eqZ = true;
  private boolean evx = true;
  public int field_EID;
  public String field_appId;
  public long field_contentLength;
  public String field_contentType;
  public boolean field_deleted;
  public byte[] field_eccSignature;
  public String field_encryptKey;
  public long field_expireTime;
  public boolean field_fileCompress;
  public boolean field_fileEncrypt;
  public String field_filePath;
  public long field_fileSize;
  public boolean field_fileUpdated;
  public String field_fileVersion;
  public String field_groupId1;
  public String field_groupId2;
  public int field_keyVersion;
  public int field_maxRetryTimes;
  public String field_md5;
  public boolean field_needRetry;
  public int field_networkType;
  public String field_originalMd5;
  public String field_packageId;
  public int field_priority;
  public long field_reportId;
  public int field_resType;
  public int field_retryTimes;
  public String field_sampleId;
  public int field_status;
  public int field_subType;
  public String field_url;
  public String field_urlKey;
  public int field_urlKey_hashcode;
  public int field_wvCacheType;
  
  static
  {
    eXS = "fileVersion".hashCode();
    eWk = "networkType".hashCode();
    eXT = "maxRetryTimes".hashCode();
    eWh = "retryTimes".hashCode();
    evF = "filePath".hashCode();
    elV = "status".hashCode();
    eXU = "contentLength".hashCode();
    eXV = "contentType".hashCode();
    eKw = "expireTime".hashCode();
    eBr = "md5".hashCode();
    eXW = "groupId1".hashCode();
    eXX = "groupId2".hashCode();
    eUL = "priority".hashCode();
    eXY = "fileUpdated".hashCode();
    eXZ = "deleted".hashCode();
    eYa = "resType".hashCode();
    enp = "subType".hashCode();
    epp = "reportId".hashCode();
    eYb = "sampleId".hashCode();
    eYc = "eccSignature".hashCode();
    eYd = "originalMd5".hashCode();
    eYe = "fileCompress".hashCode();
    eYf = "fileEncrypt".hashCode();
    eYg = "encryptKey".hashCode();
    eYh = "keyVersion".hashCode();
    eYi = "EID".hashCode();
    eFC = "fileSize".hashCode();
    eYj = "needRetry".hashCode();
    enO = "appId".hashCode();
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
      if (eXQ != k) {
        break label65;
      }
      this.field_urlKey_hashcode = paramCursor.getInt(i);
      this.eXu = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eXR == k)
      {
        this.field_urlKey = paramCursor.getString(i);
      }
      else if (erd == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (eXS == k)
      {
        this.field_fileVersion = paramCursor.getString(i);
      }
      else if (eWk == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (eXT == k)
      {
        this.field_maxRetryTimes = paramCursor.getInt(i);
      }
      else if (eWh == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (evF == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (elV == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (eXU == k)
      {
        this.field_contentLength = paramCursor.getLong(i);
      }
      else if (eXV == k)
      {
        this.field_contentType = paramCursor.getString(i);
      }
      else if (eKw == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (eBr == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (eXW == k)
      {
        this.field_groupId1 = paramCursor.getString(i);
      }
      else if (eXX == k)
      {
        this.field_groupId2 = paramCursor.getString(i);
      }
      else if (eUL == k)
      {
        this.field_priority = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (eXY == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_fileUpdated = bool;
            break;
          }
        }
        if (eXZ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_deleted = bool;
            break;
          }
        }
        if (eYa == k)
        {
          this.field_resType = paramCursor.getInt(i);
        }
        else if (enp == k)
        {
          this.field_subType = paramCursor.getInt(i);
        }
        else if (epp == k)
        {
          this.field_reportId = paramCursor.getLong(i);
        }
        else if (eYb == k)
        {
          this.field_sampleId = paramCursor.getString(i);
        }
        else if (eYc == k)
        {
          this.field_eccSignature = paramCursor.getBlob(i);
        }
        else if (eYd == k)
        {
          this.field_originalMd5 = paramCursor.getString(i);
        }
        else
        {
          if (eYe == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileCompress = bool;
              break;
            }
          }
          if (eYf == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileEncrypt = bool;
              break;
            }
          }
          if (eYg == k)
          {
            this.field_encryptKey = paramCursor.getString(i);
          }
          else if (eYh == k)
          {
            this.field_keyVersion = paramCursor.getInt(i);
          }
          else if (eYi == k)
          {
            this.field_EID = paramCursor.getInt(i);
          }
          else if (eFC == k)
          {
            this.field_fileSize = paramCursor.getLong(i);
          }
          else
          {
            if (eYj == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_needRetry = bool;
                break;
              }
            }
            if (enO == k) {
              this.field_appId = paramCursor.getString(i);
            } else if (eYk == k) {
              this.field_wvCacheType = paramCursor.getInt(i);
            } else if (eYl == k) {
              this.field_packageId = paramCursor.getString(i);
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
    if (this.eXu) {
      localContentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
    }
    if (this.eXv) {
      localContentValues.put("urlKey", this.field_urlKey);
    }
    if (this.eqZ) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eXw) {
      localContentValues.put("fileVersion", this.field_fileVersion);
    }
    if (this.eWb) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.eXx) {
      localContentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
    }
    if (this.eVY) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.evx) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eXy) {
      localContentValues.put("contentLength", Long.valueOf(this.field_contentLength));
    }
    if (this.eXz) {
      localContentValues.put("contentType", this.field_contentType);
    }
    if (this.eKl) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.eAF) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eXA) {
      localContentValues.put("groupId1", this.field_groupId1);
    }
    if (this.eXB) {
      localContentValues.put("groupId2", this.field_groupId2);
    }
    if (this.eUD) {
      localContentValues.put("priority", Integer.valueOf(this.field_priority));
    }
    if (this.eXC) {
      localContentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
    }
    if (this.eXD) {
      localContentValues.put("deleted", Boolean.valueOf(this.field_deleted));
    }
    if (this.eXE) {
      localContentValues.put("resType", Integer.valueOf(this.field_resType));
    }
    if (this.emR) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.epk) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.eXF) {
      localContentValues.put("sampleId", this.field_sampleId);
    }
    if (this.eXG) {
      localContentValues.put("eccSignature", this.field_eccSignature);
    }
    if (this.eXH) {
      localContentValues.put("originalMd5", this.field_originalMd5);
    }
    if (this.eXI) {
      localContentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
    }
    if (this.eXJ) {
      localContentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
    }
    if (this.eXK) {
      localContentValues.put("encryptKey", this.field_encryptKey);
    }
    if (this.eXL) {
      localContentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
    }
    if (this.eXM) {
      localContentValues.put("EID", Integer.valueOf(this.field_EID));
    }
    if (this.eEZ) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.eXN) {
      localContentValues.put("needRetry", Boolean.valueOf(this.field_needRetry));
    }
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eXO) {
      localContentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
    }
    if (this.eXP) {
      localContentValues.put("packageId", this.field_packageId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fb
 * JD-Core Version:    0.7.0.1
 */