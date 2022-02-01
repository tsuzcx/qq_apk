package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ft
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fCp;
  private static final int fJb;
  private static final int fTG;
  private static final int fVc;
  private static final int fVf;
  private static final int fWL = "urlKey_hashcode".hashCode();
  private static final int fWM = "urlKey".hashCode();
  private static final int fWN;
  private static final int fWO;
  private static final int fWP;
  private static final int fWQ;
  private static final int fWR;
  private static final int fWS;
  private static final int fWT;
  private static final int fWU;
  private static final int fWV;
  private static final int fWW;
  private static final int fWX;
  private static final int fWY;
  private static final int fWZ;
  private static final int fXa;
  private static final int fXb;
  private static final int fXc;
  private static final int fXd;
  private static final int fXe;
  private static final int fXf = "wvCacheType".hashCode();
  private static final int fXg = "packageId".hashCode();
  private static final int fjl;
  private static final int fkj;
  private static final int flJ;
  private static final int fnB = "url".hashCode();
  private static final int fsu;
  private static final int fyf;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int subType_HASHCODE;
  private boolean __hadSetsubType = true;
  private boolean fBL = true;
  private boolean fIP = true;
  private boolean fTy = true;
  private boolean fUT = true;
  private boolean fUW = true;
  private boolean fWA = true;
  private boolean fWB = true;
  private boolean fWC = true;
  private boolean fWD = true;
  private boolean fWE = true;
  private boolean fWF = true;
  private boolean fWG = true;
  private boolean fWH = true;
  private boolean fWI = true;
  private boolean fWJ = true;
  private boolean fWK = true;
  private boolean fWp = true;
  private boolean fWq = true;
  private boolean fWr = true;
  private boolean fWs = true;
  private boolean fWt = true;
  private boolean fWu = true;
  private boolean fWv = true;
  private boolean fWw = true;
  private boolean fWx = true;
  private boolean fWy = true;
  private boolean fWz = true;
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
  private boolean fjS = true;
  private boolean fji = true;
  private boolean flE = true;
  private boolean fnx = true;
  private boolean fsm = true;
  private boolean fxt = true;
  
  static
  {
    fWN = "fileVersion".hashCode();
    fVf = "networkType".hashCode();
    fWO = "maxRetryTimes".hashCode();
    fVc = "retryTimes".hashCode();
    fsu = "filePath".hashCode();
    fjl = "status".hashCode();
    fWP = "contentLength".hashCode();
    fWQ = "contentType".hashCode();
    fJb = "expireTime".hashCode();
    fyf = "md5".hashCode();
    fWR = "groupId1".hashCode();
    fWS = "groupId2".hashCode();
    fTG = "priority".hashCode();
    fWT = "fileUpdated".hashCode();
    fWU = "deleted".hashCode();
    fWV = "resType".hashCode();
    subType_HASHCODE = "subType".hashCode();
    flJ = "reportId".hashCode();
    fWW = "sampleId".hashCode();
    fWX = "eccSignature".hashCode();
    fWY = "originalMd5".hashCode();
    fWZ = "fileCompress".hashCode();
    fXa = "fileEncrypt".hashCode();
    fXb = "encryptKey".hashCode();
    fXc = "keyVersion".hashCode();
    fXd = "EID".hashCode();
    fCp = "fileSize".hashCode();
    fXe = "needRetry".hashCode();
    fkj = "appId".hashCode();
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
      if (fWL != k) {
        break label65;
      }
      this.field_urlKey_hashcode = paramCursor.getInt(i);
      this.fWp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fWM == k)
      {
        this.field_urlKey = paramCursor.getString(i);
      }
      else if (fnB == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (fWN == k)
      {
        this.field_fileVersion = paramCursor.getString(i);
      }
      else if (fVf == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (fWO == k)
      {
        this.field_maxRetryTimes = paramCursor.getInt(i);
      }
      else if (fVc == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (fsu == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (fjl == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (fWP == k)
      {
        this.field_contentLength = paramCursor.getLong(i);
      }
      else if (fWQ == k)
      {
        this.field_contentType = paramCursor.getString(i);
      }
      else if (fJb == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (fyf == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (fWR == k)
      {
        this.field_groupId1 = paramCursor.getString(i);
      }
      else if (fWS == k)
      {
        this.field_groupId2 = paramCursor.getString(i);
      }
      else if (fTG == k)
      {
        this.field_priority = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (fWT == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_fileUpdated = bool;
            break;
          }
        }
        if (fWU == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_deleted = bool;
            break;
          }
        }
        if (fWV == k)
        {
          this.field_resType = paramCursor.getInt(i);
        }
        else if (subType_HASHCODE == k)
        {
          this.field_subType = paramCursor.getInt(i);
        }
        else if (flJ == k)
        {
          this.field_reportId = paramCursor.getLong(i);
        }
        else if (fWW == k)
        {
          this.field_sampleId = paramCursor.getString(i);
        }
        else if (fWX == k)
        {
          this.field_eccSignature = paramCursor.getBlob(i);
        }
        else if (fWY == k)
        {
          this.field_originalMd5 = paramCursor.getString(i);
        }
        else
        {
          if (fWZ == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileCompress = bool;
              break;
            }
          }
          if (fXa == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileEncrypt = bool;
              break;
            }
          }
          if (fXb == k)
          {
            this.field_encryptKey = paramCursor.getString(i);
          }
          else if (fXc == k)
          {
            this.field_keyVersion = paramCursor.getInt(i);
          }
          else if (fXd == k)
          {
            this.field_EID = paramCursor.getInt(i);
          }
          else if (fCp == k)
          {
            this.field_fileSize = paramCursor.getLong(i);
          }
          else
          {
            if (fXe == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_needRetry = bool;
                break;
              }
            }
            if (fkj == k) {
              this.field_appId = paramCursor.getString(i);
            } else if (fXf == k) {
              this.field_wvCacheType = paramCursor.getInt(i);
            } else if (fXg == k) {
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
    if (this.fWp) {
      localContentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
    }
    if (this.fWq) {
      localContentValues.put("urlKey", this.field_urlKey);
    }
    if (this.fnx) {
      localContentValues.put("url", this.field_url);
    }
    if (this.fWr) {
      localContentValues.put("fileVersion", this.field_fileVersion);
    }
    if (this.fUW) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.fWs) {
      localContentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
    }
    if (this.fUT) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.fsm) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fWt) {
      localContentValues.put("contentLength", Long.valueOf(this.field_contentLength));
    }
    if (this.fWu) {
      localContentValues.put("contentType", this.field_contentType);
    }
    if (this.fIP) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.fxt) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.fWv) {
      localContentValues.put("groupId1", this.field_groupId1);
    }
    if (this.fWw) {
      localContentValues.put("groupId2", this.field_groupId2);
    }
    if (this.fTy) {
      localContentValues.put("priority", Integer.valueOf(this.field_priority));
    }
    if (this.fWx) {
      localContentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
    }
    if (this.fWy) {
      localContentValues.put("deleted", Boolean.valueOf(this.field_deleted));
    }
    if (this.fWz) {
      localContentValues.put("resType", Integer.valueOf(this.field_resType));
    }
    if (this.__hadSetsubType) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.flE) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.fWA) {
      localContentValues.put("sampleId", this.field_sampleId);
    }
    if (this.fWB) {
      localContentValues.put("eccSignature", this.field_eccSignature);
    }
    if (this.fWC) {
      localContentValues.put("originalMd5", this.field_originalMd5);
    }
    if (this.fWD) {
      localContentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
    }
    if (this.fWE) {
      localContentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
    }
    if (this.fWF) {
      localContentValues.put("encryptKey", this.field_encryptKey);
    }
    if (this.fWG) {
      localContentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
    }
    if (this.fWH) {
      localContentValues.put("EID", Integer.valueOf(this.field_EID));
    }
    if (this.fBL) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.fWI) {
      localContentValues.put("needRetry", Boolean.valueOf(this.field_needRetry));
    }
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fWJ) {
      localContentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
    }
    if (this.fWK) {
      localContentValues.put("packageId", this.field_packageId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ft
 * JD-Core Version:    0.7.0.1
 */