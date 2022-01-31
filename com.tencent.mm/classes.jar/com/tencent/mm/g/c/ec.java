package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ec
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dAN;
  private static final int dKg;
  private static final int dKj;
  private static final int dLM = "urlKey_hashcode".hashCode();
  private static final int dLN = "urlKey".hashCode();
  private static final int dLO;
  private static final int dLP;
  private static final int dLQ;
  private static final int dLR;
  private static final int dLS;
  private static final int dLT;
  private static final int dLU;
  private static final int dLV;
  private static final int dLW;
  private static final int dLX;
  private static final int dLY;
  private static final int dLZ;
  private static final int dMa;
  private static final int dMb;
  private static final int dMc;
  private static final int dMd;
  private static final int dMe;
  private static final int dMf;
  private static final int dMg;
  private static final int dMh = "wvCacheType".hashCode();
  private static final int dMi = "packageId".hashCode();
  private static final int dfJ;
  private static final int dhB;
  private static final int dhc;
  private static final int diM;
  private static final int dkC = "url".hashCode();
  private static final int doK;
  private static final int dtX;
  private static final int dxW;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dAF = true;
  private boolean dJZ = true;
  private boolean dKc = true;
  private boolean dLA = true;
  private boolean dLB = true;
  private boolean dLC = true;
  private boolean dLD = true;
  private boolean dLE = true;
  private boolean dLF = true;
  private boolean dLG = true;
  private boolean dLH = true;
  private boolean dLI = true;
  private boolean dLJ = true;
  private boolean dLK = true;
  private boolean dLL = true;
  private boolean dLp = true;
  private boolean dLq = true;
  private boolean dLr = true;
  private boolean dLs = true;
  private boolean dLt = true;
  private boolean dLu = true;
  private boolean dLv = true;
  private boolean dLw = true;
  private boolean dLx = true;
  private boolean dLy = true;
  private boolean dLz = true;
  private boolean dfG = true;
  private boolean dgF = true;
  private boolean dhk = true;
  private boolean diJ = true;
  private boolean dky = true;
  private boolean doC = true;
  private boolean dtk = true;
  private boolean dxv = true;
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
    dLO = "fileVersion".hashCode();
    dKj = "networkType".hashCode();
    dLP = "maxRetryTimes".hashCode();
    dKg = "retryTimes".hashCode();
    doK = "filePath".hashCode();
    dfJ = "status".hashCode();
    dLQ = "contentLength".hashCode();
    dLR = "contentType".hashCode();
    dAN = "expireTime".hashCode();
    dtX = "md5".hashCode();
    dLS = "groupId1".hashCode();
    dLT = "groupId2".hashCode();
    dLU = "priority".hashCode();
    dLV = "fileUpdated".hashCode();
    dLW = "deleted".hashCode();
    dLX = "resType".hashCode();
    dhc = "subType".hashCode();
    diM = "reportId".hashCode();
    dLY = "sampleId".hashCode();
    dLZ = "eccSignature".hashCode();
    dMa = "originalMd5".hashCode();
    dMb = "fileCompress".hashCode();
    dMc = "fileEncrypt".hashCode();
    dMd = "encryptKey".hashCode();
    dMe = "keyVersion".hashCode();
    dMf = "EID".hashCode();
    dxW = "fileSize".hashCode();
    dMg = "needRetry".hashCode();
    dhB = "appId".hashCode();
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
      if (dLM != k) {
        break label65;
      }
      this.field_urlKey_hashcode = paramCursor.getInt(i);
      this.dLp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dLN == k)
      {
        this.field_urlKey = paramCursor.getString(i);
      }
      else if (dkC == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (dLO == k)
      {
        this.field_fileVersion = paramCursor.getString(i);
      }
      else if (dKj == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (dLP == k)
      {
        this.field_maxRetryTimes = paramCursor.getInt(i);
      }
      else if (dKg == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (doK == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (dfJ == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (dLQ == k)
      {
        this.field_contentLength = paramCursor.getLong(i);
      }
      else if (dLR == k)
      {
        this.field_contentType = paramCursor.getString(i);
      }
      else if (dAN == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (dtX == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (dLS == k)
      {
        this.field_groupId1 = paramCursor.getString(i);
      }
      else if (dLT == k)
      {
        this.field_groupId2 = paramCursor.getString(i);
      }
      else if (dLU == k)
      {
        this.field_priority = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (dLV == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_fileUpdated = bool;
            break;
          }
        }
        if (dLW == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_deleted = bool;
            break;
          }
        }
        if (dLX == k)
        {
          this.field_resType = paramCursor.getInt(i);
        }
        else if (dhc == k)
        {
          this.field_subType = paramCursor.getInt(i);
        }
        else if (diM == k)
        {
          this.field_reportId = paramCursor.getLong(i);
        }
        else if (dLY == k)
        {
          this.field_sampleId = paramCursor.getString(i);
        }
        else if (dLZ == k)
        {
          this.field_eccSignature = paramCursor.getBlob(i);
        }
        else if (dMa == k)
        {
          this.field_originalMd5 = paramCursor.getString(i);
        }
        else
        {
          if (dMb == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileCompress = bool;
              break;
            }
          }
          if (dMc == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileEncrypt = bool;
              break;
            }
          }
          if (dMd == k)
          {
            this.field_encryptKey = paramCursor.getString(i);
          }
          else if (dMe == k)
          {
            this.field_keyVersion = paramCursor.getInt(i);
          }
          else if (dMf == k)
          {
            this.field_EID = paramCursor.getInt(i);
          }
          else if (dxW == k)
          {
            this.field_fileSize = paramCursor.getLong(i);
          }
          else
          {
            if (dMg == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_needRetry = bool;
                break;
              }
            }
            if (dhB == k) {
              this.field_appId = paramCursor.getString(i);
            } else if (dMh == k) {
              this.field_wvCacheType = paramCursor.getInt(i);
            } else if (dMi == k) {
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
    if (this.dLp) {
      localContentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
    }
    if (this.dLq) {
      localContentValues.put("urlKey", this.field_urlKey);
    }
    if (this.dky) {
      localContentValues.put("url", this.field_url);
    }
    if (this.dLr) {
      localContentValues.put("fileVersion", this.field_fileVersion);
    }
    if (this.dKc) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.dLs) {
      localContentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
    }
    if (this.dJZ) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.doC) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.dLt) {
      localContentValues.put("contentLength", Long.valueOf(this.field_contentLength));
    }
    if (this.dLu) {
      localContentValues.put("contentType", this.field_contentType);
    }
    if (this.dAF) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.dtk) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.dLv) {
      localContentValues.put("groupId1", this.field_groupId1);
    }
    if (this.dLw) {
      localContentValues.put("groupId2", this.field_groupId2);
    }
    if (this.dLx) {
      localContentValues.put("priority", Integer.valueOf(this.field_priority));
    }
    if (this.dLy) {
      localContentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
    }
    if (this.dLz) {
      localContentValues.put("deleted", Boolean.valueOf(this.field_deleted));
    }
    if (this.dLA) {
      localContentValues.put("resType", Integer.valueOf(this.field_resType));
    }
    if (this.dgF) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.diJ) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.dLB) {
      localContentValues.put("sampleId", this.field_sampleId);
    }
    if (this.dLC) {
      localContentValues.put("eccSignature", this.field_eccSignature);
    }
    if (this.dLD) {
      localContentValues.put("originalMd5", this.field_originalMd5);
    }
    if (this.dLE) {
      localContentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
    }
    if (this.dLF) {
      localContentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
    }
    if (this.dLG) {
      localContentValues.put("encryptKey", this.field_encryptKey);
    }
    if (this.dLH) {
      localContentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
    }
    if (this.dLI) {
      localContentValues.put("EID", Integer.valueOf(this.field_EID));
    }
    if (this.dxv) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.dLJ) {
      localContentValues.put("needRetry", Boolean.valueOf(this.field_needRetry));
    }
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.dLK) {
      localContentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
    }
    if (this.dLL) {
      localContentValues.put("packageId", this.field_packageId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.ec
 * JD-Core Version:    0.7.0.1
 */