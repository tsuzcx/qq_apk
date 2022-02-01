package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDc;
  private static final int eEU = "appId".hashCode();
  private static final int eEv;
  private static final int eGy;
  private static final int eIm;
  private static final int eNc;
  private static final int eSP;
  private static final int eXa;
  private static final int fcQ;
  private static final int fna;
  private static final int fow;
  private static final int foz;
  private static final int fqA = "wvCacheType".hashCode();
  private static final int fqB = "packageId".hashCode();
  private static final int fqg = "urlKey_hashcode".hashCode();
  private static final int fqh = "urlKey".hashCode();
  private static final int fqi;
  private static final int fqj;
  private static final int fqk;
  private static final int fql;
  private static final int fqm;
  private static final int fqn;
  private static final int fqo;
  private static final int fqp;
  private static final int fqq;
  private static final int fqr;
  private static final int fqs;
  private static final int fqt;
  private static final int fqu;
  private static final int fqv;
  private static final int fqw;
  private static final int fqx;
  private static final int fqy;
  private static final int fqz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eDY = true;
  private boolean eED = true;
  private boolean eGt = true;
  private boolean eIi = true;
  private boolean eMU = true;
  private boolean eSd = true;
  private boolean eWx = true;
  private boolean fcF = true;
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
  private boolean fmS = true;
  private boolean fon = true;
  private boolean foq = true;
  private boolean fpK = true;
  private boolean fpL = true;
  private boolean fpM = true;
  private boolean fpN = true;
  private boolean fpO = true;
  private boolean fpP = true;
  private boolean fpQ = true;
  private boolean fpR = true;
  private boolean fpS = true;
  private boolean fpT = true;
  private boolean fpU = true;
  private boolean fpV = true;
  private boolean fpW = true;
  private boolean fpX = true;
  private boolean fpY = true;
  private boolean fpZ = true;
  private boolean fqa = true;
  private boolean fqb = true;
  private boolean fqc = true;
  private boolean fqd = true;
  private boolean fqe = true;
  private boolean fqf = true;
  
  static
  {
    eIm = "url".hashCode();
    fqi = "fileVersion".hashCode();
    foz = "networkType".hashCode();
    fqj = "maxRetryTimes".hashCode();
    fow = "retryTimes".hashCode();
    eNc = "filePath".hashCode();
    eDc = "status".hashCode();
    fqk = "contentLength".hashCode();
    fql = "contentType".hashCode();
    fcQ = "expireTime".hashCode();
    eSP = "md5".hashCode();
    fqm = "groupId1".hashCode();
    fqn = "groupId2".hashCode();
    fna = "priority".hashCode();
    fqo = "fileUpdated".hashCode();
    fqp = "deleted".hashCode();
    fqq = "resType".hashCode();
    eEv = "subType".hashCode();
    eGy = "reportId".hashCode();
    fqr = "sampleId".hashCode();
    fqs = "eccSignature".hashCode();
    fqt = "originalMd5".hashCode();
    fqu = "fileCompress".hashCode();
    fqv = "fileEncrypt".hashCode();
    fqw = "encryptKey".hashCode();
    fqx = "keyVersion".hashCode();
    fqy = "EID".hashCode();
    eXa = "fileSize".hashCode();
    fqz = "needRetry".hashCode();
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
      if (fqg != k) {
        break label65;
      }
      this.field_urlKey_hashcode = paramCursor.getInt(i);
      this.fpK = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fqh == k)
      {
        this.field_urlKey = paramCursor.getString(i);
      }
      else if (eIm == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (fqi == k)
      {
        this.field_fileVersion = paramCursor.getString(i);
      }
      else if (foz == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (fqj == k)
      {
        this.field_maxRetryTimes = paramCursor.getInt(i);
      }
      else if (fow == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (eNc == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (eDc == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (fqk == k)
      {
        this.field_contentLength = paramCursor.getLong(i);
      }
      else if (fql == k)
      {
        this.field_contentType = paramCursor.getString(i);
      }
      else if (fcQ == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (eSP == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (fqm == k)
      {
        this.field_groupId1 = paramCursor.getString(i);
      }
      else if (fqn == k)
      {
        this.field_groupId2 = paramCursor.getString(i);
      }
      else if (fna == k)
      {
        this.field_priority = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (fqo == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_fileUpdated = bool;
            break;
          }
        }
        if (fqp == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_deleted = bool;
            break;
          }
        }
        if (fqq == k)
        {
          this.field_resType = paramCursor.getInt(i);
        }
        else if (eEv == k)
        {
          this.field_subType = paramCursor.getInt(i);
        }
        else if (eGy == k)
        {
          this.field_reportId = paramCursor.getLong(i);
        }
        else if (fqr == k)
        {
          this.field_sampleId = paramCursor.getString(i);
        }
        else if (fqs == k)
        {
          this.field_eccSignature = paramCursor.getBlob(i);
        }
        else if (fqt == k)
        {
          this.field_originalMd5 = paramCursor.getString(i);
        }
        else
        {
          if (fqu == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileCompress = bool;
              break;
            }
          }
          if (fqv == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileEncrypt = bool;
              break;
            }
          }
          if (fqw == k)
          {
            this.field_encryptKey = paramCursor.getString(i);
          }
          else if (fqx == k)
          {
            this.field_keyVersion = paramCursor.getInt(i);
          }
          else if (fqy == k)
          {
            this.field_EID = paramCursor.getInt(i);
          }
          else if (eXa == k)
          {
            this.field_fileSize = paramCursor.getLong(i);
          }
          else
          {
            if (fqz == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_needRetry = bool;
                break;
              }
            }
            if (eEU == k) {
              this.field_appId = paramCursor.getString(i);
            } else if (fqA == k) {
              this.field_wvCacheType = paramCursor.getInt(i);
            } else if (fqB == k) {
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
    if (this.fpK) {
      localContentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
    }
    if (this.fpL) {
      localContentValues.put("urlKey", this.field_urlKey);
    }
    if (this.eIi) {
      localContentValues.put("url", this.field_url);
    }
    if (this.fpM) {
      localContentValues.put("fileVersion", this.field_fileVersion);
    }
    if (this.foq) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.fpN) {
      localContentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
    }
    if (this.fon) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.eMU) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fpO) {
      localContentValues.put("contentLength", Long.valueOf(this.field_contentLength));
    }
    if (this.fpP) {
      localContentValues.put("contentType", this.field_contentType);
    }
    if (this.fcF) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.eSd) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.fpQ) {
      localContentValues.put("groupId1", this.field_groupId1);
    }
    if (this.fpR) {
      localContentValues.put("groupId2", this.field_groupId2);
    }
    if (this.fmS) {
      localContentValues.put("priority", Integer.valueOf(this.field_priority));
    }
    if (this.fpS) {
      localContentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
    }
    if (this.fpT) {
      localContentValues.put("deleted", Boolean.valueOf(this.field_deleted));
    }
    if (this.fpU) {
      localContentValues.put("resType", Integer.valueOf(this.field_resType));
    }
    if (this.eDY) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.eGt) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.fpV) {
      localContentValues.put("sampleId", this.field_sampleId);
    }
    if (this.fpW) {
      localContentValues.put("eccSignature", this.field_eccSignature);
    }
    if (this.fpX) {
      localContentValues.put("originalMd5", this.field_originalMd5);
    }
    if (this.fpY) {
      localContentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
    }
    if (this.fpZ) {
      localContentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
    }
    if (this.fqa) {
      localContentValues.put("encryptKey", this.field_encryptKey);
    }
    if (this.fqb) {
      localContentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
    }
    if (this.fqc) {
      localContentValues.put("EID", Integer.valueOf(this.field_EID));
    }
    if (this.eWx) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.fqd) {
      localContentValues.put("needRetry", Boolean.valueOf(this.field_needRetry));
    }
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fqe) {
      localContentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
    }
    if (this.fqf) {
      localContentValues.put("packageId", this.field_packageId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fl
 * JD-Core Version:    0.7.0.1
 */