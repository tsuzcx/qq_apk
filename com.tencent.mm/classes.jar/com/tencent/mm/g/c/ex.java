package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ex
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDi;
  private static final int eHE;
  private static final int eRB;
  private static final int eSX;
  private static final int eTa;
  private static final int eUE = "urlKey_hashcode".hashCode();
  private static final int eUF = "urlKey".hashCode();
  private static final int eUG;
  private static final int eUH;
  private static final int eUI;
  private static final int eUJ;
  private static final int eUK;
  private static final int eUL;
  private static final int eUM;
  private static final int eUN;
  private static final int eUO;
  private static final int eUP;
  private static final int eUQ;
  private static final int eUR;
  private static final int eUS;
  private static final int eUT;
  private static final int eUU;
  private static final int eUV;
  private static final int eUW;
  private static final int eUX;
  private static final int eUY = "wvCacheType".hashCode();
  private static final int eUZ = "packageId".hashCode();
  private static final int ejR;
  private static final int elJ;
  private static final int elk;
  private static final int enk;
  private static final int eoZ = "url".hashCode();
  private static final int etB;
  private static final int eyX;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCF = true;
  private boolean eHt = true;
  private boolean eRt = true;
  private boolean eSO = true;
  private boolean eSR = true;
  private boolean eUA = true;
  private boolean eUB = true;
  private boolean eUC = true;
  private boolean eUD = true;
  private boolean eUi = true;
  private boolean eUj = true;
  private boolean eUk = true;
  private boolean eUl = true;
  private boolean eUm = true;
  private boolean eUn = true;
  private boolean eUo = true;
  private boolean eUp = true;
  private boolean eUq = true;
  private boolean eUr = true;
  private boolean eUs = true;
  private boolean eUt = true;
  private boolean eUu = true;
  private boolean eUv = true;
  private boolean eUw = true;
  private boolean eUx = true;
  private boolean eUy = true;
  private boolean eUz = true;
  private boolean ejO = true;
  private boolean ekN = true;
  private boolean els = true;
  private boolean enf = true;
  private boolean eoV = true;
  private boolean ett = true;
  private boolean eyl = true;
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
    eUG = "fileVersion".hashCode();
    eTa = "networkType".hashCode();
    eUH = "maxRetryTimes".hashCode();
    eSX = "retryTimes".hashCode();
    etB = "filePath".hashCode();
    ejR = "status".hashCode();
    eUI = "contentLength".hashCode();
    eUJ = "contentType".hashCode();
    eHE = "expireTime".hashCode();
    eyX = "md5".hashCode();
    eUK = "groupId1".hashCode();
    eUL = "groupId2".hashCode();
    eRB = "priority".hashCode();
    eUM = "fileUpdated".hashCode();
    eUN = "deleted".hashCode();
    eUO = "resType".hashCode();
    elk = "subType".hashCode();
    enk = "reportId".hashCode();
    eUP = "sampleId".hashCode();
    eUQ = "eccSignature".hashCode();
    eUR = "originalMd5".hashCode();
    eUS = "fileCompress".hashCode();
    eUT = "fileEncrypt".hashCode();
    eUU = "encryptKey".hashCode();
    eUV = "keyVersion".hashCode();
    eUW = "EID".hashCode();
    eDi = "fileSize".hashCode();
    eUX = "needRetry".hashCode();
    elJ = "appId".hashCode();
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
      if (eUE != k) {
        break label65;
      }
      this.field_urlKey_hashcode = paramCursor.getInt(i);
      this.eUi = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eUF == k)
      {
        this.field_urlKey = paramCursor.getString(i);
      }
      else if (eoZ == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (eUG == k)
      {
        this.field_fileVersion = paramCursor.getString(i);
      }
      else if (eTa == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (eUH == k)
      {
        this.field_maxRetryTimes = paramCursor.getInt(i);
      }
      else if (eSX == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (etB == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (ejR == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (eUI == k)
      {
        this.field_contentLength = paramCursor.getLong(i);
      }
      else if (eUJ == k)
      {
        this.field_contentType = paramCursor.getString(i);
      }
      else if (eHE == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (eyX == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (eUK == k)
      {
        this.field_groupId1 = paramCursor.getString(i);
      }
      else if (eUL == k)
      {
        this.field_groupId2 = paramCursor.getString(i);
      }
      else if (eRB == k)
      {
        this.field_priority = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (eUM == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_fileUpdated = bool;
            break;
          }
        }
        if (eUN == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_deleted = bool;
            break;
          }
        }
        if (eUO == k)
        {
          this.field_resType = paramCursor.getInt(i);
        }
        else if (elk == k)
        {
          this.field_subType = paramCursor.getInt(i);
        }
        else if (enk == k)
        {
          this.field_reportId = paramCursor.getLong(i);
        }
        else if (eUP == k)
        {
          this.field_sampleId = paramCursor.getString(i);
        }
        else if (eUQ == k)
        {
          this.field_eccSignature = paramCursor.getBlob(i);
        }
        else if (eUR == k)
        {
          this.field_originalMd5 = paramCursor.getString(i);
        }
        else
        {
          if (eUS == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileCompress = bool;
              break;
            }
          }
          if (eUT == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileEncrypt = bool;
              break;
            }
          }
          if (eUU == k)
          {
            this.field_encryptKey = paramCursor.getString(i);
          }
          else if (eUV == k)
          {
            this.field_keyVersion = paramCursor.getInt(i);
          }
          else if (eUW == k)
          {
            this.field_EID = paramCursor.getInt(i);
          }
          else if (eDi == k)
          {
            this.field_fileSize = paramCursor.getLong(i);
          }
          else
          {
            if (eUX == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_needRetry = bool;
                break;
              }
            }
            if (elJ == k) {
              this.field_appId = paramCursor.getString(i);
            } else if (eUY == k) {
              this.field_wvCacheType = paramCursor.getInt(i);
            } else if (eUZ == k) {
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
    if (this.eUi) {
      localContentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
    }
    if (this.eUj) {
      localContentValues.put("urlKey", this.field_urlKey);
    }
    if (this.eoV) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eUk) {
      localContentValues.put("fileVersion", this.field_fileVersion);
    }
    if (this.eSR) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.eUl) {
      localContentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
    }
    if (this.eSO) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.ett) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eUm) {
      localContentValues.put("contentLength", Long.valueOf(this.field_contentLength));
    }
    if (this.eUn) {
      localContentValues.put("contentType", this.field_contentType);
    }
    if (this.eHt) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.eyl) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eUo) {
      localContentValues.put("groupId1", this.field_groupId1);
    }
    if (this.eUp) {
      localContentValues.put("groupId2", this.field_groupId2);
    }
    if (this.eRt) {
      localContentValues.put("priority", Integer.valueOf(this.field_priority));
    }
    if (this.eUq) {
      localContentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
    }
    if (this.eUr) {
      localContentValues.put("deleted", Boolean.valueOf(this.field_deleted));
    }
    if (this.eUs) {
      localContentValues.put("resType", Integer.valueOf(this.field_resType));
    }
    if (this.ekN) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.enf) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.eUt) {
      localContentValues.put("sampleId", this.field_sampleId);
    }
    if (this.eUu) {
      localContentValues.put("eccSignature", this.field_eccSignature);
    }
    if (this.eUv) {
      localContentValues.put("originalMd5", this.field_originalMd5);
    }
    if (this.eUw) {
      localContentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
    }
    if (this.eUx) {
      localContentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
    }
    if (this.eUy) {
      localContentValues.put("encryptKey", this.field_encryptKey);
    }
    if (this.eUz) {
      localContentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
    }
    if (this.eUA) {
      localContentValues.put("EID", Integer.valueOf(this.field_EID));
    }
    if (this.eCF) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.eUB) {
      localContentValues.put("needRetry", Boolean.valueOf(this.field_needRetry));
    }
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eUC) {
      localContentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
    }
    if (this.eUD) {
      localContentValues.put("packageId", this.field_packageId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ex
 * JD-Core Version:    0.7.0.1
 */