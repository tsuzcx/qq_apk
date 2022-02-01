package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gu
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final Column SUBTYPE;
  public static final SingleTable TABLE = new SingleTable("ResDownloaderRecordTable");
  private static final int jIF;
  public static final Column jIz;
  private static final int jKX;
  public static final Column jKp;
  public static final Column jMP;
  private static final int jMZ;
  private static final int jPC;
  public static final Column jPu;
  private static final int jWL;
  public static final Column jWv;
  public static final Column kPb;
  private static final int kPr;
  public static final Column kSb;
  public static final Column kSd;
  private static final int kSs;
  private static final int kSv;
  public static final Column kUA;
  public static final Column kUB;
  public static final Column kUC;
  public static final Column kUD;
  public static final Column kUE;
  public static final Column kUF;
  public static final Column kUk;
  public static final Column kUl;
  public static final Column kUm;
  public static final Column kUn;
  public static final Column kUo;
  public static final Column kUp;
  public static final Column kUq;
  public static final Column kUr;
  public static final Column kUs;
  public static final Column kUt;
  public static final Column kUu;
  public static final Column kUv;
  public static final Column kUw;
  public static final Column kUx;
  public static final Column kUy;
  public static final Column kUz;
  private static final int kVc;
  private static final int kVd;
  private static final int kVe;
  private static final int kVf;
  private static final int kVg;
  private static final int kVh;
  private static final int kVi;
  private static final int kVj;
  private static final int kVk;
  private static final int kVl;
  private static final int kVm;
  private static final int kVn;
  private static final int kVo;
  private static final int kVp;
  private static final int kVq;
  private static final int kVr;
  private static final int kVs;
  private static final int kVt;
  private static final int kVu;
  private static final int kVv;
  private static final int kVw;
  private static final int kVx;
  public static final Column kea;
  private static final int kfD;
  public static final Column kkA;
  private static final int klI;
  private static final int kyM;
  public static final Column kyq;
  private static final StorageObserverOwner<gu> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
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
  private boolean jIC = true;
  private boolean jKG = true;
  private boolean jMU = true;
  private boolean jPy = true;
  private boolean jWD = true;
  private boolean kPj = true;
  private boolean kSj = true;
  private boolean kSm = true;
  private boolean kUG = true;
  private boolean kUH = true;
  private boolean kUI = true;
  private boolean kUJ = true;
  private boolean kUK = true;
  private boolean kUL = true;
  private boolean kUM = true;
  private boolean kUN = true;
  private boolean kUO = true;
  private boolean kUP = true;
  private boolean kUQ = true;
  private boolean kUR = true;
  private boolean kUS = true;
  private boolean kUT = true;
  private boolean kUU = true;
  private boolean kUV = true;
  private boolean kUW = true;
  private boolean kUX = true;
  private boolean kUY = true;
  private boolean kUZ = true;
  private boolean kVa = true;
  private boolean kVb = true;
  private boolean keP = true;
  private boolean kle = true;
  private boolean kyB = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kUk = new Column("urlKey_hashcode", "int", TABLE.getName(), "");
    kUl = new Column("urlKey", "string", TABLE.getName(), "");
    jPu = new Column("url", "string", TABLE.getName(), "");
    kUm = new Column("fileVersion", "string", TABLE.getName(), "");
    kSd = new Column("networkType", "int", TABLE.getName(), "");
    kUn = new Column("maxRetryTimes", "int", TABLE.getName(), "");
    kSb = new Column("retryTimes", "int", TABLE.getName(), "");
    jWv = new Column("filePath", "string", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    kUo = new Column("contentLength", "long", TABLE.getName(), "");
    kUp = new Column("contentType", "string", TABLE.getName(), "");
    kyq = new Column("expireTime", "long", TABLE.getName(), "");
    kea = new Column("md5", "string", TABLE.getName(), "");
    kUq = new Column("groupId1", "string", TABLE.getName(), "");
    kUr = new Column("groupId2", "string", TABLE.getName(), "");
    kPb = new Column("priority", "int", TABLE.getName(), "");
    kUs = new Column("fileUpdated", "boolean", TABLE.getName(), "");
    kUt = new Column("deleted", "boolean", TABLE.getName(), "");
    kUu = new Column("resType", "int", TABLE.getName(), "");
    SUBTYPE = new Column("subType", "int", TABLE.getName(), "");
    jMP = new Column("reportId", "long", TABLE.getName(), "");
    kUv = new Column("sampleId", "string", TABLE.getName(), "");
    kUw = new Column("eccSignature", "byte[]", TABLE.getName(), "");
    kUx = new Column("originalMd5", "string", TABLE.getName(), "");
    kUy = new Column("fileCompress", "boolean", TABLE.getName(), "");
    kUz = new Column("fileEncrypt", "boolean", TABLE.getName(), "");
    kUA = new Column("encryptKey", "string", TABLE.getName(), "");
    kUB = new Column("keyVersion", "int", TABLE.getName(), "");
    kUC = new Column("EID", "int", TABLE.getName(), "");
    kkA = new Column("fileSize", "long", TABLE.getName(), "");
    kUD = new Column("needRetry", "boolean", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    kUE = new Column("wvCacheType", "int", TABLE.getName(), "");
    kUF = new Column("packageId", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kVc = "urlKey_hashcode".hashCode();
    kVd = "urlKey".hashCode();
    jPC = "url".hashCode();
    kVe = "fileVersion".hashCode();
    kSv = "networkType".hashCode();
    kVf = "maxRetryTimes".hashCode();
    kSs = "retryTimes".hashCode();
    jWL = "filePath".hashCode();
    jIF = "status".hashCode();
    kVg = "contentLength".hashCode();
    kVh = "contentType".hashCode();
    kyM = "expireTime".hashCode();
    kfD = "md5".hashCode();
    kVi = "groupId1".hashCode();
    kVj = "groupId2".hashCode();
    kPr = "priority".hashCode();
    kVk = "fileUpdated".hashCode();
    kVl = "deleted".hashCode();
    kVm = "resType".hashCode();
    subType_HASHCODE = "subType".hashCode();
    jMZ = "reportId".hashCode();
    kVn = "sampleId".hashCode();
    kVo = "eccSignature".hashCode();
    kVp = "originalMd5".hashCode();
    kVq = "fileCompress".hashCode();
    kVr = "fileEncrypt".hashCode();
    kVs = "encryptKey".hashCode();
    kVt = "keyVersion".hashCode();
    kVu = "EID".hashCode();
    klI = "fileSize".hashCode();
    kVv = "needRetry".hashCode();
    jKX = "appId".hashCode();
    kVw = "wvCacheType".hashCode();
    kVx = "packageId".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[34];
    localMAutoDBInfo.columns = new String[35];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "urlKey_hashcode";
    localMAutoDBInfo.colsMap.put("urlKey_hashcode", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" urlKey_hashcode INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "urlKey_hashcode";
    localMAutoDBInfo.columns[1] = "urlKey";
    localMAutoDBInfo.colsMap.put("urlKey", "TEXT");
    localStringBuilder.append(" urlKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "fileVersion";
    localMAutoDBInfo.colsMap.put("fileVersion", "TEXT");
    localStringBuilder.append(" fileVersion TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "networkType";
    localMAutoDBInfo.colsMap.put("networkType", "INTEGER default '2' ");
    localStringBuilder.append(" networkType INTEGER default '2' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "maxRetryTimes";
    localMAutoDBInfo.colsMap.put("maxRetryTimes", "INTEGER default '3' ");
    localStringBuilder.append(" maxRetryTimes INTEGER default '3' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "retryTimes";
    localMAutoDBInfo.colsMap.put("retryTimes", "INTEGER default '3' ");
    localStringBuilder.append(" retryTimes INTEGER default '3' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "filePath";
    localMAutoDBInfo.colsMap.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "contentLength";
    localMAutoDBInfo.colsMap.put("contentLength", "LONG default '0' ");
    localStringBuilder.append(" contentLength LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "contentType";
    localMAutoDBInfo.colsMap.put("contentType", "TEXT");
    localStringBuilder.append(" contentType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "expireTime";
    localMAutoDBInfo.colsMap.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "groupId1";
    localMAutoDBInfo.colsMap.put("groupId1", "TEXT");
    localStringBuilder.append(" groupId1 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "groupId2";
    localMAutoDBInfo.colsMap.put("groupId2", "TEXT");
    localStringBuilder.append(" groupId2 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "priority";
    localMAutoDBInfo.colsMap.put("priority", "INTEGER default '0' ");
    localStringBuilder.append(" priority INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "fileUpdated";
    localMAutoDBInfo.colsMap.put("fileUpdated", "INTEGER");
    localStringBuilder.append(" fileUpdated INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "deleted";
    localMAutoDBInfo.colsMap.put("deleted", "INTEGER default 'false' ");
    localStringBuilder.append(" deleted INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "resType";
    localMAutoDBInfo.colsMap.put("resType", "INTEGER");
    localStringBuilder.append(" resType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "subType";
    localMAutoDBInfo.colsMap.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "reportId";
    localMAutoDBInfo.colsMap.put("reportId", "LONG");
    localStringBuilder.append(" reportId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "sampleId";
    localMAutoDBInfo.colsMap.put("sampleId", "TEXT");
    localStringBuilder.append(" sampleId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "eccSignature";
    localMAutoDBInfo.colsMap.put("eccSignature", "BLOB");
    localStringBuilder.append(" eccSignature BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "originalMd5";
    localMAutoDBInfo.colsMap.put("originalMd5", "TEXT");
    localStringBuilder.append(" originalMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "fileCompress";
    localMAutoDBInfo.colsMap.put("fileCompress", "INTEGER default 'false' ");
    localStringBuilder.append(" fileCompress INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "fileEncrypt";
    localMAutoDBInfo.colsMap.put("fileEncrypt", "INTEGER default 'false' ");
    localStringBuilder.append(" fileEncrypt INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "encryptKey";
    localMAutoDBInfo.colsMap.put("encryptKey", "TEXT");
    localStringBuilder.append(" encryptKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "keyVersion";
    localMAutoDBInfo.colsMap.put("keyVersion", "INTEGER default '0' ");
    localStringBuilder.append(" keyVersion INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "EID";
    localMAutoDBInfo.colsMap.put("EID", "INTEGER");
    localStringBuilder.append(" EID INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "fileSize";
    localMAutoDBInfo.colsMap.put("fileSize", "LONG");
    localStringBuilder.append(" fileSize LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "needRetry";
    localMAutoDBInfo.colsMap.put("needRetry", "INTEGER default '1' ");
    localStringBuilder.append(" needRetry INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "wvCacheType";
    localMAutoDBInfo.colsMap.put("wvCacheType", "INTEGER");
    localStringBuilder.append(" wvCacheType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[33] = "packageId";
    localMAutoDBInfo.colsMap.put("packageId", "TEXT");
    localStringBuilder.append(" packageId TEXT");
    localMAutoDBInfo.columns[34] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramContentValues.containsKey("urlKey_hashcode"))
    {
      this.field_urlKey_hashcode = paramContentValues.getAsInteger("urlKey_hashcode").intValue();
      if (paramBoolean) {
        this.kUG = true;
      }
    }
    if (paramContentValues.containsKey("urlKey"))
    {
      this.field_urlKey = paramContentValues.getAsString("urlKey");
      if (paramBoolean) {
        this.kUH = true;
      }
    }
    if (paramContentValues.containsKey("url"))
    {
      this.field_url = paramContentValues.getAsString("url");
      if (paramBoolean) {
        this.jPy = true;
      }
    }
    if (paramContentValues.containsKey("fileVersion"))
    {
      this.field_fileVersion = paramContentValues.getAsString("fileVersion");
      if (paramBoolean) {
        this.kUI = true;
      }
    }
    if (paramContentValues.containsKey("networkType"))
    {
      this.field_networkType = paramContentValues.getAsInteger("networkType").intValue();
      if (paramBoolean) {
        this.kSm = true;
      }
    }
    if (paramContentValues.containsKey("maxRetryTimes"))
    {
      this.field_maxRetryTimes = paramContentValues.getAsInteger("maxRetryTimes").intValue();
      if (paramBoolean) {
        this.kUJ = true;
      }
    }
    if (paramContentValues.containsKey("retryTimes"))
    {
      this.field_retryTimes = paramContentValues.getAsInteger("retryTimes").intValue();
      if (paramBoolean) {
        this.kSj = true;
      }
    }
    if (paramContentValues.containsKey("filePath"))
    {
      this.field_filePath = paramContentValues.getAsString("filePath");
      if (paramBoolean) {
        this.jWD = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("contentLength"))
    {
      this.field_contentLength = paramContentValues.getAsLong("contentLength").longValue();
      if (paramBoolean) {
        this.kUK = true;
      }
    }
    if (paramContentValues.containsKey("contentType"))
    {
      this.field_contentType = paramContentValues.getAsString("contentType");
      if (paramBoolean) {
        this.kUL = true;
      }
    }
    if (paramContentValues.containsKey("expireTime"))
    {
      this.field_expireTime = paramContentValues.getAsLong("expireTime").longValue();
      if (paramBoolean) {
        this.kyB = true;
      }
    }
    if (paramContentValues.containsKey("md5"))
    {
      this.field_md5 = paramContentValues.getAsString("md5");
      if (paramBoolean) {
        this.keP = true;
      }
    }
    if (paramContentValues.containsKey("groupId1"))
    {
      this.field_groupId1 = paramContentValues.getAsString("groupId1");
      if (paramBoolean) {
        this.kUM = true;
      }
    }
    if (paramContentValues.containsKey("groupId2"))
    {
      this.field_groupId2 = paramContentValues.getAsString("groupId2");
      if (paramBoolean) {
        this.kUN = true;
      }
    }
    if (paramContentValues.containsKey("priority"))
    {
      this.field_priority = paramContentValues.getAsInteger("priority").intValue();
      if (paramBoolean) {
        this.kPj = true;
      }
    }
    if (paramContentValues.containsKey("fileUpdated"))
    {
      if (paramContentValues.getAsInteger("fileUpdated").intValue() == 0) {
        break label1107;
      }
      bool1 = true;
      this.field_fileUpdated = bool1;
      if (paramBoolean) {
        this.kUO = true;
      }
    }
    if (paramContentValues.containsKey("deleted"))
    {
      if (paramContentValues.getAsInteger("deleted").intValue() == 0) {
        break label1112;
      }
      bool1 = true;
      label539:
      this.field_deleted = bool1;
      if (paramBoolean) {
        this.kUP = true;
      }
    }
    if (paramContentValues.containsKey("resType"))
    {
      this.field_resType = paramContentValues.getAsInteger("resType").intValue();
      if (paramBoolean) {
        this.kUQ = true;
      }
    }
    if (paramContentValues.containsKey("subType"))
    {
      this.field_subType = paramContentValues.getAsInteger("subType").intValue();
      if (paramBoolean) {
        this.__hadSetsubType = true;
      }
    }
    if (paramContentValues.containsKey("reportId"))
    {
      this.field_reportId = paramContentValues.getAsLong("reportId").longValue();
      if (paramBoolean) {
        this.jMU = true;
      }
    }
    if (paramContentValues.containsKey("sampleId"))
    {
      this.field_sampleId = paramContentValues.getAsString("sampleId");
      if (paramBoolean) {
        this.kUR = true;
      }
    }
    if (paramContentValues.containsKey("eccSignature"))
    {
      this.field_eccSignature = paramContentValues.getAsByteArray("eccSignature");
      if (paramBoolean) {
        this.kUS = true;
      }
    }
    if (paramContentValues.containsKey("originalMd5"))
    {
      this.field_originalMd5 = paramContentValues.getAsString("originalMd5");
      if (paramBoolean) {
        this.kUT = true;
      }
    }
    if (paramContentValues.containsKey("fileCompress"))
    {
      if (paramContentValues.getAsInteger("fileCompress").intValue() == 0) {
        break label1117;
      }
      bool1 = true;
      label767:
      this.field_fileCompress = bool1;
      if (paramBoolean) {
        this.kUU = true;
      }
    }
    if (paramContentValues.containsKey("fileEncrypt")) {
      if (paramContentValues.getAsInteger("fileEncrypt").intValue() == 0) {
        break label1122;
      }
    }
    label1107:
    label1112:
    label1117:
    label1122:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.field_fileEncrypt = bool1;
      if (paramBoolean) {
        this.kUV = true;
      }
      if (paramContentValues.containsKey("encryptKey"))
      {
        this.field_encryptKey = paramContentValues.getAsString("encryptKey");
        if (paramBoolean) {
          this.kUW = true;
        }
      }
      if (paramContentValues.containsKey("keyVersion"))
      {
        this.field_keyVersion = paramContentValues.getAsInteger("keyVersion").intValue();
        if (paramBoolean) {
          this.kUX = true;
        }
      }
      if (paramContentValues.containsKey("EID"))
      {
        this.field_EID = paramContentValues.getAsInteger("EID").intValue();
        if (paramBoolean) {
          this.kUY = true;
        }
      }
      if (paramContentValues.containsKey("fileSize"))
      {
        this.field_fileSize = paramContentValues.getAsLong("fileSize").longValue();
        if (paramBoolean) {
          this.kle = true;
        }
      }
      if (paramContentValues.containsKey("needRetry"))
      {
        bool1 = bool2;
        if (paramContentValues.getAsInteger("needRetry").intValue() != 0) {
          bool1 = true;
        }
        this.field_needRetry = bool1;
        if (paramBoolean) {
          this.kUZ = true;
        }
      }
      if (paramContentValues.containsKey("appId"))
      {
        this.field_appId = paramContentValues.getAsString("appId");
        if (paramBoolean) {
          this.jKG = true;
        }
      }
      if (paramContentValues.containsKey("wvCacheType"))
      {
        this.field_wvCacheType = paramContentValues.getAsInteger("wvCacheType").intValue();
        if (paramBoolean) {
          this.kVa = true;
        }
      }
      if (paramContentValues.containsKey("packageId"))
      {
        this.field_packageId = paramContentValues.getAsString("packageId");
        if (paramBoolean) {
          this.kVb = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label539;
      bool1 = false;
      break label767;
    }
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
      if (kVc != k) {
        break label65;
      }
      this.field_urlKey_hashcode = paramCursor.getInt(i);
      this.kUG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kVd == k)
      {
        this.field_urlKey = paramCursor.getString(i);
      }
      else if (jPC == k)
      {
        this.field_url = paramCursor.getString(i);
      }
      else if (kVe == k)
      {
        this.field_fileVersion = paramCursor.getString(i);
      }
      else if (kSv == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (kVf == k)
      {
        this.field_maxRetryTimes = paramCursor.getInt(i);
      }
      else if (kSs == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (jWL == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (jIF == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (kVg == k)
      {
        this.field_contentLength = paramCursor.getLong(i);
      }
      else if (kVh == k)
      {
        this.field_contentType = paramCursor.getString(i);
      }
      else if (kyM == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (kfD == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (kVi == k)
      {
        this.field_groupId1 = paramCursor.getString(i);
      }
      else if (kVj == k)
      {
        this.field_groupId2 = paramCursor.getString(i);
      }
      else if (kPr == k)
      {
        this.field_priority = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (kVk == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_fileUpdated = bool;
            break;
          }
        }
        if (kVl == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_deleted = bool;
            break;
          }
        }
        if (kVm == k)
        {
          this.field_resType = paramCursor.getInt(i);
        }
        else if (subType_HASHCODE == k)
        {
          this.field_subType = paramCursor.getInt(i);
        }
        else if (jMZ == k)
        {
          this.field_reportId = paramCursor.getLong(i);
        }
        else if (kVn == k)
        {
          this.field_sampleId = paramCursor.getString(i);
        }
        else if (kVo == k)
        {
          this.field_eccSignature = paramCursor.getBlob(i);
        }
        else if (kVp == k)
        {
          this.field_originalMd5 = paramCursor.getString(i);
        }
        else
        {
          if (kVq == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileCompress = bool;
              break;
            }
          }
          if (kVr == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_fileEncrypt = bool;
              break;
            }
          }
          if (kVs == k)
          {
            this.field_encryptKey = paramCursor.getString(i);
          }
          else if (kVt == k)
          {
            this.field_keyVersion = paramCursor.getInt(i);
          }
          else if (kVu == k)
          {
            this.field_EID = paramCursor.getInt(i);
          }
          else if (klI == k)
          {
            this.field_fileSize = paramCursor.getLong(i);
          }
          else
          {
            if (kVv == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_needRetry = bool;
                break;
              }
            }
            if (jKX == k) {
              this.field_appId = paramCursor.getString(i);
            } else if (kVw == k) {
              this.field_wvCacheType = paramCursor.getInt(i);
            } else if (kVx == k) {
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
    if (this.kUG) {
      localContentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
    }
    if (this.kUH) {
      localContentValues.put("urlKey", this.field_urlKey);
    }
    if (this.jPy) {
      localContentValues.put("url", this.field_url);
    }
    if (this.kUI) {
      localContentValues.put("fileVersion", this.field_fileVersion);
    }
    if (this.kSm) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.kUJ) {
      localContentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
    }
    if (this.kSj) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.jWD) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.kUK) {
      localContentValues.put("contentLength", Long.valueOf(this.field_contentLength));
    }
    if (this.kUL) {
      localContentValues.put("contentType", this.field_contentType);
    }
    if (this.kyB) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.keP) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.kUM) {
      localContentValues.put("groupId1", this.field_groupId1);
    }
    if (this.kUN) {
      localContentValues.put("groupId2", this.field_groupId2);
    }
    if (this.kPj) {
      localContentValues.put("priority", Integer.valueOf(this.field_priority));
    }
    if (this.kUO) {
      localContentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
    }
    if (this.kUP) {
      localContentValues.put("deleted", Boolean.valueOf(this.field_deleted));
    }
    if (this.kUQ) {
      localContentValues.put("resType", Integer.valueOf(this.field_resType));
    }
    if (this.__hadSetsubType) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.jMU) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.kUR) {
      localContentValues.put("sampleId", this.field_sampleId);
    }
    if (this.kUS) {
      localContentValues.put("eccSignature", this.field_eccSignature);
    }
    if (this.kUT) {
      localContentValues.put("originalMd5", this.field_originalMd5);
    }
    if (this.kUU) {
      localContentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
    }
    if (this.kUV) {
      localContentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
    }
    if (this.kUW) {
      localContentValues.put("encryptKey", this.field_encryptKey);
    }
    if (this.kUX) {
      localContentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
    }
    if (this.kUY) {
      localContentValues.put("EID", Integer.valueOf(this.field_EID));
    }
    if (this.kle) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.kUZ) {
      localContentValues.put("needRetry", Boolean.valueOf(this.field_needRetry));
    }
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.kVa) {
      localContentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
    }
    if (this.kVb) {
      localContentValues.put("packageId", this.field_packageId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends gu> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_urlKey_hashcode);
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.gu
 * JD-Core Version:    0.7.0.1
 */