package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dr
  extends c
{
  private static final int cAH;
  private static final int cFC;
  private static final int cJg;
  private static final int cKZ;
  private static final int cTS;
  private static final int cUa;
  private static final int cUd;
  private static final int cVA;
  private static final int cVB;
  private static final int cVC;
  private static final int cVD;
  private static final int cVE;
  private static final int cVF;
  private static final int cVG;
  private static final int cVH;
  private static final int cVI;
  private static final int cVJ;
  private static final int cVK;
  private static final int cVL;
  private static final int cVM;
  private static final int cVN;
  private static final int cVO;
  private static final int cVP;
  private static final int cVQ;
  private static final int cVR;
  private static final int cVS;
  private static final int cVT;
  private static final int cVU;
  private static final int cVV = "wvCacheType".hashCode();
  private static final int cVW = "packageId".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int csM;
  private static final int ctl;
  private static final int cwu;
  private boolean cAz = true;
  private boolean cEZ = true;
  private boolean cIL = true;
  private boolean cKR = true;
  private boolean cTP = true;
  private boolean cTT = true;
  private boolean cTW = true;
  private boolean cVd = true;
  private boolean cVe = true;
  private boolean cVf = true;
  private boolean cVg = true;
  private boolean cVh = true;
  private boolean cVi = true;
  private boolean cVj = true;
  private boolean cVk = true;
  private boolean cVl = true;
  private boolean cVm = true;
  private boolean cVn = true;
  private boolean cVo = true;
  private boolean cVp = true;
  private boolean cVq = true;
  private boolean cVr = true;
  private boolean cVs = true;
  private boolean cVt = true;
  private boolean cVu = true;
  private boolean cVv = true;
  private boolean cVw = true;
  private boolean cVx = true;
  private boolean cVy = true;
  private boolean cVz = true;
  private boolean crk = true;
  private boolean csU = true;
  private boolean cso = true;
  private boolean cwp = true;
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
    cVA = "urlKey_hashcode".hashCode();
    cVB = "urlKey".hashCode();
    cwu = "url".hashCode();
    cVC = "fileVersion".hashCode();
    cUd = "networkType".hashCode();
    cVD = "maxRetryTimes".hashCode();
    cUa = "retryTimes".hashCode();
    cAH = "filePath".hashCode();
    crn = "status".hashCode();
    cVE = "contentLength".hashCode();
    cVF = "contentType".hashCode();
    cKZ = "expireTime".hashCode();
    cFC = "md5".hashCode();
    cVG = "groupId1".hashCode();
    cVH = "groupId2".hashCode();
    cVI = "priority".hashCode();
    cVJ = "fileUpdated".hashCode();
    cVK = "deleted".hashCode();
    cVL = "resType".hashCode();
    csM = "subType".hashCode();
    cTS = "reportId".hashCode();
    cVM = "sampleId".hashCode();
    cVN = "eccSignature".hashCode();
    cVO = "originalMd5".hashCode();
    cVP = "fileCompress".hashCode();
    cVQ = "fileEncrypt".hashCode();
    cVR = "encryptKey".hashCode();
    cVS = "keyVersion".hashCode();
    cVT = "EID".hashCode();
    cJg = "fileSize".hashCode();
    cVU = "needRetry".hashCode();
    ctl = "appId".hashCode();
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
      if (cVA != k) {
        break label65;
      }
      this.field_urlKey_hashcode = paramCursor.getInt(i);
      this.cVd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cVB == k)
      {
        this.field_urlKey = paramCursor.getString(i);
      }
      else if (cwu == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (cVC == k)
      {
        this.field_fileVersion = paramCursor.getString(i);
      }
      else if (cUd == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (cVD == k)
      {
        this.field_maxRetryTimes = paramCursor.getInt(i);
      }
      else if (cUa == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (cAH == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (crn == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (cVE == k)
      {
        this.field_contentLength = paramCursor.getLong(i);
      }
      else if (cVF == k)
      {
        this.field_contentType = paramCursor.getString(i);
      }
      else if (cKZ == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (cFC == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (cVG == k)
      {
        this.field_groupId1 = paramCursor.getString(i);
      }
      else if (cVH == k)
      {
        this.field_groupId2 = paramCursor.getString(i);
      }
      else if (cVI == k)
      {
        this.field_priority = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (cVJ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_fileUpdated = bool;
            break;
          }
        }
        if (cVK == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_deleted = bool;
            break;
          }
        }
        if (cVL == k)
        {
          this.field_resType = paramCursor.getInt(i);
        }
        else if (csM == k)
        {
          this.field_subType = paramCursor.getInt(i);
        }
        else if (cTS == k)
        {
          this.field_reportId = paramCursor.getLong(i);
        }
        else if (cVM == k)
        {
          this.field_sampleId = paramCursor.getString(i);
        }
        else if (cVN == k)
        {
          this.field_eccSignature = paramCursor.getBlob(i);
        }
        else if (cVO == k)
        {
          this.field_originalMd5 = paramCursor.getString(i);
        }
        else
        {
          if (cVP == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileCompress = bool;
              break;
            }
          }
          if (cVQ == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileEncrypt = bool;
              break;
            }
          }
          if (cVR == k)
          {
            this.field_encryptKey = paramCursor.getString(i);
          }
          else if (cVS == k)
          {
            this.field_keyVersion = paramCursor.getInt(i);
          }
          else if (cVT == k)
          {
            this.field_EID = paramCursor.getInt(i);
          }
          else if (cJg == k)
          {
            this.field_fileSize = paramCursor.getLong(i);
          }
          else
          {
            if (cVU == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_needRetry = bool;
                break;
              }
            }
            if (ctl == k) {
              this.field_appId = paramCursor.getString(i);
            } else if (cVV == k) {
              this.field_wvCacheType = paramCursor.getInt(i);
            } else if (cVW == k) {
              this.field_packageId = paramCursor.getString(i);
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
    if (this.cVd) {
      localContentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
    }
    if (this.cVe) {
      localContentValues.put("urlKey", this.field_urlKey);
    }
    if (this.cwp) {
      localContentValues.put("url", this.field_url);
    }
    if (this.cVf) {
      localContentValues.put("fileVersion", this.field_fileVersion);
    }
    if (this.cTW) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.cVg) {
      localContentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
    }
    if (this.cTT) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.cAz) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.cVh) {
      localContentValues.put("contentLength", Long.valueOf(this.field_contentLength));
    }
    if (this.cVi) {
      localContentValues.put("contentType", this.field_contentType);
    }
    if (this.cKR) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.cEZ) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.cVj) {
      localContentValues.put("groupId1", this.field_groupId1);
    }
    if (this.cVk) {
      localContentValues.put("groupId2", this.field_groupId2);
    }
    if (this.cVl) {
      localContentValues.put("priority", Integer.valueOf(this.field_priority));
    }
    if (this.cVm) {
      localContentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
    }
    if (this.cVn) {
      localContentValues.put("deleted", Boolean.valueOf(this.field_deleted));
    }
    if (this.cVo) {
      localContentValues.put("resType", Integer.valueOf(this.field_resType));
    }
    if (this.cso) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.cTP) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.cVp) {
      localContentValues.put("sampleId", this.field_sampleId);
    }
    if (this.cVq) {
      localContentValues.put("eccSignature", this.field_eccSignature);
    }
    if (this.cVr) {
      localContentValues.put("originalMd5", this.field_originalMd5);
    }
    if (this.cVs) {
      localContentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
    }
    if (this.cVt) {
      localContentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
    }
    if (this.cVu) {
      localContentValues.put("encryptKey", this.field_encryptKey);
    }
    if (this.cVv) {
      localContentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
    }
    if (this.cVw) {
      localContentValues.put("EID", Integer.valueOf(this.field_EID));
    }
    if (this.cIL) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.cVx) {
      localContentValues.put("needRetry", Boolean.valueOf(this.field_needRetry));
    }
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.cVy) {
      localContentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
    }
    if (this.cVz) {
      localContentValues.put("packageId", this.field_packageId);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.dr
 * JD-Core Version:    0.7.0.1
 */