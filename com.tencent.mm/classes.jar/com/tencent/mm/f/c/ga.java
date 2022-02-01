package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ga
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_SUBTYPE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("ResDownloaderRecordTable");
  public static final Column hGW;
  private static final int hIy;
  public static final Column hNw;
  private static final int hOE;
  private static final int hZD;
  public static final Column hZf;
  private static final int hmC;
  public static final Column hmw;
  public static final Column hnz;
  private static final int hoh = "appId".hashCode();
  public static final Column hqc;
  private static final int hqm;
  public static final Column hsH;
  private static final int hsP;
  public static final Column hzC;
  private static final int hzS;
  public static final Column ioZ;
  private static final int ipp;
  private static final int irI;
  private static final int irL;
  public static final Column irq;
  public static final Column irt;
  public static final Column itA;
  public static final Column itB;
  public static final Column itC;
  public static final Column itD;
  public static final Column itE;
  public static final Column itF;
  public static final Column itG;
  public static final Column itH;
  public static final Column itI;
  public static final Column itJ;
  public static final Column itK;
  public static final Column itL;
  public static final Column itM;
  public static final Column itN;
  public static final Column itO;
  public static final Column itP;
  public static final Column itQ;
  public static final Column itR;
  public static final Column itS;
  public static final Column itT;
  public static final Column itU;
  public static final Column itV;
  private static final int iuA;
  private static final int iuB;
  private static final int iuC;
  private static final int iuD;
  private static final int iuE;
  private static final int iuF;
  private static final int iuG;
  private static final int iuH;
  private static final int iuI;
  private static final int iuJ;
  private static final int iuK;
  private static final int iuL;
  private static final int iuM = "wvCacheType".hashCode();
  private static final int iuN = "packageId".hashCode();
  private static final int ius;
  private static final int iut;
  private static final int iuu;
  private static final int iuv;
  private static final int iuw;
  private static final int iux;
  private static final int iuy;
  private static final int iuz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int subType_HASHCODE;
  private boolean __hadSetsubType = true;
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
  private boolean hHK = true;
  private boolean hOa = true;
  private boolean hZr = true;
  private boolean hmz = true;
  private boolean hnQ = true;
  private boolean hqh = true;
  private boolean hsL = true;
  private boolean hzK = true;
  private boolean iph = true;
  private boolean irC = true;
  private boolean irz = true;
  private boolean itW = true;
  private boolean itX = true;
  private boolean itY = true;
  private boolean itZ = true;
  private boolean iua = true;
  private boolean iub = true;
  private boolean iuc = true;
  private boolean iud = true;
  private boolean iue = true;
  private boolean iuf = true;
  private boolean iug = true;
  private boolean iuh = true;
  private boolean iui = true;
  private boolean iuj = true;
  private boolean iuk = true;
  private boolean iul = true;
  private boolean ium = true;
  private boolean iun = true;
  private boolean iuo = true;
  private boolean iup = true;
  private boolean iuq = true;
  private boolean iur = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ResDownloaderRecordTable", "");
    itA = new Column("urlkey_hashcode", "int", "ResDownloaderRecordTable", "");
    itB = new Column("urlkey", "string", "ResDownloaderRecordTable", "");
    hsH = new Column("url", "string", "ResDownloaderRecordTable", "");
    itC = new Column("fileversion", "string", "ResDownloaderRecordTable", "");
    irt = new Column("networktype", "int", "ResDownloaderRecordTable", "");
    itD = new Column("maxretrytimes", "int", "ResDownloaderRecordTable", "");
    irq = new Column("retrytimes", "int", "ResDownloaderRecordTable", "");
    hzC = new Column("filepath", "string", "ResDownloaderRecordTable", "");
    hmw = new Column("status", "int", "ResDownloaderRecordTable", "");
    itE = new Column("contentlength", "long", "ResDownloaderRecordTable", "");
    itF = new Column("contenttype", "string", "ResDownloaderRecordTable", "");
    hZf = new Column("expiretime", "long", "ResDownloaderRecordTable", "");
    hGW = new Column("md5", "string", "ResDownloaderRecordTable", "");
    itG = new Column("groupid1", "string", "ResDownloaderRecordTable", "");
    itH = new Column("groupid2", "string", "ResDownloaderRecordTable", "");
    ioZ = new Column("priority", "int", "ResDownloaderRecordTable", "");
    itI = new Column("fileupdated", "boolean", "ResDownloaderRecordTable", "");
    itJ = new Column("deleted", "boolean", "ResDownloaderRecordTable", "");
    itK = new Column("restype", "int", "ResDownloaderRecordTable", "");
    C_SUBTYPE = new Column("subtype", "int", "ResDownloaderRecordTable", "");
    hqc = new Column("reportid", "long", "ResDownloaderRecordTable", "");
    itL = new Column("sampleid", "string", "ResDownloaderRecordTable", "");
    itM = new Column("eccsignature", "byte[]", "ResDownloaderRecordTable", "");
    itN = new Column("originalmd5", "string", "ResDownloaderRecordTable", "");
    itO = new Column("filecompress", "boolean", "ResDownloaderRecordTable", "");
    itP = new Column("fileencrypt", "boolean", "ResDownloaderRecordTable", "");
    itQ = new Column("encryptkey", "string", "ResDownloaderRecordTable", "");
    itR = new Column("keyversion", "int", "ResDownloaderRecordTable", "");
    itS = new Column("eid", "int", "ResDownloaderRecordTable", "");
    hNw = new Column("filesize", "long", "ResDownloaderRecordTable", "");
    itT = new Column("needretry", "boolean", "ResDownloaderRecordTable", "");
    hnz = new Column("appid", "string", "ResDownloaderRecordTable", "");
    itU = new Column("wvcachetype", "int", "ResDownloaderRecordTable", "");
    itV = new Column("packageid", "string", "ResDownloaderRecordTable", "");
    ius = "urlKey_hashcode".hashCode();
    iut = "urlKey".hashCode();
    hsP = "url".hashCode();
    iuu = "fileVersion".hashCode();
    irL = "networkType".hashCode();
    iuv = "maxRetryTimes".hashCode();
    irI = "retryTimes".hashCode();
    hzS = "filePath".hashCode();
    hmC = "status".hashCode();
    iuw = "contentLength".hashCode();
    iux = "contentType".hashCode();
    hZD = "expireTime".hashCode();
    hIy = "md5".hashCode();
    iuy = "groupId1".hashCode();
    iuz = "groupId2".hashCode();
    ipp = "priority".hashCode();
    iuA = "fileUpdated".hashCode();
    iuB = "deleted".hashCode();
    iuC = "resType".hashCode();
    subType_HASHCODE = "subType".hashCode();
    hqm = "reportId".hashCode();
    iuD = "sampleId".hashCode();
    iuE = "eccSignature".hashCode();
    iuF = "originalMd5".hashCode();
    iuG = "fileCompress".hashCode();
    iuH = "fileEncrypt".hashCode();
    iuI = "encryptKey".hashCode();
    iuJ = "keyVersion".hashCode();
    iuK = "EID".hashCode();
    hOE = "fileSize".hashCode();
    iuL = "needRetry".hashCode();
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
      if (ius != k) {
        break label65;
      }
      this.field_urlKey_hashcode = paramCursor.getInt(i);
      this.itW = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iut == k)
      {
        this.field_urlKey = paramCursor.getString(i);
      }
      else if (hsP == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (iuu == k)
      {
        this.field_fileVersion = paramCursor.getString(i);
      }
      else if (irL == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (iuv == k)
      {
        this.field_maxRetryTimes = paramCursor.getInt(i);
      }
      else if (irI == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (hzS == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (hmC == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (iuw == k)
      {
        this.field_contentLength = paramCursor.getLong(i);
      }
      else if (iux == k)
      {
        this.field_contentType = paramCursor.getString(i);
      }
      else if (hZD == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (hIy == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (iuy == k)
      {
        this.field_groupId1 = paramCursor.getString(i);
      }
      else if (iuz == k)
      {
        this.field_groupId2 = paramCursor.getString(i);
      }
      else if (ipp == k)
      {
        this.field_priority = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (iuA == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_fileUpdated = bool;
            break;
          }
        }
        if (iuB == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_deleted = bool;
            break;
          }
        }
        if (iuC == k)
        {
          this.field_resType = paramCursor.getInt(i);
        }
        else if (subType_HASHCODE == k)
        {
          this.field_subType = paramCursor.getInt(i);
        }
        else if (hqm == k)
        {
          this.field_reportId = paramCursor.getLong(i);
        }
        else if (iuD == k)
        {
          this.field_sampleId = paramCursor.getString(i);
        }
        else if (iuE == k)
        {
          this.field_eccSignature = paramCursor.getBlob(i);
        }
        else if (iuF == k)
        {
          this.field_originalMd5 = paramCursor.getString(i);
        }
        else
        {
          if (iuG == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileCompress = bool;
              break;
            }
          }
          if (iuH == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileEncrypt = bool;
              break;
            }
          }
          if (iuI == k)
          {
            this.field_encryptKey = paramCursor.getString(i);
          }
          else if (iuJ == k)
          {
            this.field_keyVersion = paramCursor.getInt(i);
          }
          else if (iuK == k)
          {
            this.field_EID = paramCursor.getInt(i);
          }
          else if (hOE == k)
          {
            this.field_fileSize = paramCursor.getLong(i);
          }
          else
          {
            if (iuL == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_needRetry = bool;
                break;
              }
            }
            if (hoh == k) {
              this.field_appId = paramCursor.getString(i);
            } else if (iuM == k) {
              this.field_wvCacheType = paramCursor.getInt(i);
            } else if (iuN == k) {
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
    if (this.itW) {
      localContentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
    }
    if (this.itX) {
      localContentValues.put("urlKey", this.field_urlKey);
    }
    if (this.hsL) {
      localContentValues.put("url", this.field_url);
    }
    if (this.itY) {
      localContentValues.put("fileVersion", this.field_fileVersion);
    }
    if (this.irC) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.itZ) {
      localContentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
    }
    if (this.irz) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.hzK) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.iua) {
      localContentValues.put("contentLength", Long.valueOf(this.field_contentLength));
    }
    if (this.iub) {
      localContentValues.put("contentType", this.field_contentType);
    }
    if (this.hZr) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.hHK) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.iuc) {
      localContentValues.put("groupId1", this.field_groupId1);
    }
    if (this.iud) {
      localContentValues.put("groupId2", this.field_groupId2);
    }
    if (this.iph) {
      localContentValues.put("priority", Integer.valueOf(this.field_priority));
    }
    if (this.iue) {
      localContentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
    }
    if (this.iuf) {
      localContentValues.put("deleted", Boolean.valueOf(this.field_deleted));
    }
    if (this.iug) {
      localContentValues.put("resType", Integer.valueOf(this.field_resType));
    }
    if (this.__hadSetsubType) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.hqh) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.iuh) {
      localContentValues.put("sampleId", this.field_sampleId);
    }
    if (this.iui) {
      localContentValues.put("eccSignature", this.field_eccSignature);
    }
    if (this.iuj) {
      localContentValues.put("originalMd5", this.field_originalMd5);
    }
    if (this.iuk) {
      localContentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
    }
    if (this.iul) {
      localContentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
    }
    if (this.ium) {
      localContentValues.put("encryptKey", this.field_encryptKey);
    }
    if (this.iun) {
      localContentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
    }
    if (this.iuo) {
      localContentValues.put("EID", Integer.valueOf(this.field_EID));
    }
    if (this.hOa) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.iup) {
      localContentValues.put("needRetry", Boolean.valueOf(this.field_needRetry));
    }
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.iuq) {
      localContentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
    }
    if (this.iur) {
      localContentValues.put("packageId", this.field_packageId);
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
    return "ResDownloaderRecordTable";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.ga
 * JD-Core Version:    0.7.0.1
 */