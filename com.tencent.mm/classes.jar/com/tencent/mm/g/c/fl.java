package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL;
  private static final int eGD = "appId".hashCode();
  private static final int eGe;
  private static final int eIh;
  private static final int eJV;
  private static final int eON;
  private static final int eUA;
  private static final int eYL;
  private static final int feI;
  private static final int fpa;
  private static final int fqA;
  private static final int fqx;
  private static final int fsA = "wvCacheType".hashCode();
  private static final int fsB = "packageId".hashCode();
  private static final int fsg = "urlKey_hashcode".hashCode();
  private static final int fsh = "urlKey".hashCode();
  private static final int fsi;
  private static final int fsj;
  private static final int fsk;
  private static final int fsl;
  private static final int fsm;
  private static final int fsn;
  private static final int fso;
  private static final int fsp;
  private static final int fsq;
  private static final int fsr;
  private static final int fss;
  private static final int fst;
  private static final int fsu;
  private static final int fsv;
  private static final int fsw;
  private static final int fsx;
  private static final int fsy;
  private static final int fsz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  private boolean eFH = true;
  private boolean eGm = true;
  private boolean eIc = true;
  private boolean eJR = true;
  private boolean eOF = true;
  private boolean eTO = true;
  private boolean eYi = true;
  private boolean few = true;
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
  private boolean foS = true;
  private boolean fqo = true;
  private boolean fqr = true;
  private boolean frK = true;
  private boolean frL = true;
  private boolean frM = true;
  private boolean frN = true;
  private boolean frO = true;
  private boolean frP = true;
  private boolean frQ = true;
  private boolean frR = true;
  private boolean frS = true;
  private boolean frT = true;
  private boolean frU = true;
  private boolean frV = true;
  private boolean frW = true;
  private boolean frX = true;
  private boolean frY = true;
  private boolean frZ = true;
  private boolean fsa = true;
  private boolean fsb = true;
  private boolean fsc = true;
  private boolean fsd = true;
  private boolean fse = true;
  private boolean fsf = true;
  
  static
  {
    eJV = "url".hashCode();
    fsi = "fileVersion".hashCode();
    fqA = "networkType".hashCode();
    fsj = "maxRetryTimes".hashCode();
    fqx = "retryTimes".hashCode();
    eON = "filePath".hashCode();
    eEL = "status".hashCode();
    fsk = "contentLength".hashCode();
    fsl = "contentType".hashCode();
    feI = "expireTime".hashCode();
    eUA = "md5".hashCode();
    fsm = "groupId1".hashCode();
    fsn = "groupId2".hashCode();
    fpa = "priority".hashCode();
    fso = "fileUpdated".hashCode();
    fsp = "deleted".hashCode();
    fsq = "resType".hashCode();
    eGe = "subType".hashCode();
    eIh = "reportId".hashCode();
    fsr = "sampleId".hashCode();
    fss = "eccSignature".hashCode();
    fst = "originalMd5".hashCode();
    fsu = "fileCompress".hashCode();
    fsv = "fileEncrypt".hashCode();
    fsw = "encryptKey".hashCode();
    fsx = "keyVersion".hashCode();
    fsy = "EID".hashCode();
    eYL = "fileSize".hashCode();
    fsz = "needRetry".hashCode();
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
      if (fsg != k) {
        break label65;
      }
      this.field_urlKey_hashcode = paramCursor.getInt(i);
      this.frK = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fsh == k)
      {
        this.field_urlKey = paramCursor.getString(i);
      }
      else if (eJV == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (fsi == k)
      {
        this.field_fileVersion = paramCursor.getString(i);
      }
      else if (fqA == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (fsj == k)
      {
        this.field_maxRetryTimes = paramCursor.getInt(i);
      }
      else if (fqx == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (eON == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (eEL == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (fsk == k)
      {
        this.field_contentLength = paramCursor.getLong(i);
      }
      else if (fsl == k)
      {
        this.field_contentType = paramCursor.getString(i);
      }
      else if (feI == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (eUA == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (fsm == k)
      {
        this.field_groupId1 = paramCursor.getString(i);
      }
      else if (fsn == k)
      {
        this.field_groupId2 = paramCursor.getString(i);
      }
      else if (fpa == k)
      {
        this.field_priority = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (fso == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_fileUpdated = bool;
            break;
          }
        }
        if (fsp == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_deleted = bool;
            break;
          }
        }
        if (fsq == k)
        {
          this.field_resType = paramCursor.getInt(i);
        }
        else if (eGe == k)
        {
          this.field_subType = paramCursor.getInt(i);
        }
        else if (eIh == k)
        {
          this.field_reportId = paramCursor.getLong(i);
        }
        else if (fsr == k)
        {
          this.field_sampleId = paramCursor.getString(i);
        }
        else if (fss == k)
        {
          this.field_eccSignature = paramCursor.getBlob(i);
        }
        else if (fst == k)
        {
          this.field_originalMd5 = paramCursor.getString(i);
        }
        else
        {
          if (fsu == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileCompress = bool;
              break;
            }
          }
          if (fsv == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileEncrypt = bool;
              break;
            }
          }
          if (fsw == k)
          {
            this.field_encryptKey = paramCursor.getString(i);
          }
          else if (fsx == k)
          {
            this.field_keyVersion = paramCursor.getInt(i);
          }
          else if (fsy == k)
          {
            this.field_EID = paramCursor.getInt(i);
          }
          else if (eYL == k)
          {
            this.field_fileSize = paramCursor.getLong(i);
          }
          else
          {
            if (fsz == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_needRetry = bool;
                break;
              }
            }
            if (eGD == k) {
              this.field_appId = paramCursor.getString(i);
            } else if (fsA == k) {
              this.field_wvCacheType = paramCursor.getInt(i);
            } else if (fsB == k) {
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
    if (this.frK) {
      localContentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
    }
    if (this.frL) {
      localContentValues.put("urlKey", this.field_urlKey);
    }
    if (this.eJR) {
      localContentValues.put("url", this.field_url);
    }
    if (this.frM) {
      localContentValues.put("fileVersion", this.field_fileVersion);
    }
    if (this.fqr) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.frN) {
      localContentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
    }
    if (this.fqo) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.eOF) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.frO) {
      localContentValues.put("contentLength", Long.valueOf(this.field_contentLength));
    }
    if (this.frP) {
      localContentValues.put("contentType", this.field_contentType);
    }
    if (this.few) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.eTO) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.frQ) {
      localContentValues.put("groupId1", this.field_groupId1);
    }
    if (this.frR) {
      localContentValues.put("groupId2", this.field_groupId2);
    }
    if (this.foS) {
      localContentValues.put("priority", Integer.valueOf(this.field_priority));
    }
    if (this.frS) {
      localContentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
    }
    if (this.frT) {
      localContentValues.put("deleted", Boolean.valueOf(this.field_deleted));
    }
    if (this.frU) {
      localContentValues.put("resType", Integer.valueOf(this.field_resType));
    }
    if (this.eFH) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.eIc) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.frV) {
      localContentValues.put("sampleId", this.field_sampleId);
    }
    if (this.frW) {
      localContentValues.put("eccSignature", this.field_eccSignature);
    }
    if (this.frX) {
      localContentValues.put("originalMd5", this.field_originalMd5);
    }
    if (this.frY) {
      localContentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
    }
    if (this.frZ) {
      localContentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
    }
    if (this.fsa) {
      localContentValues.put("encryptKey", this.field_encryptKey);
    }
    if (this.fsb) {
      localContentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
    }
    if (this.fsc) {
      localContentValues.put("EID", Integer.valueOf(this.field_EID));
    }
    if (this.eYi) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.fsd) {
      localContentValues.put("needRetry", Boolean.valueOf(this.field_needRetry));
    }
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fse) {
      localContentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
    }
    if (this.fsf) {
      localContentValues.put("packageId", this.field_packageId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.fl
 * JD-Core Version:    0.7.0.1
 */