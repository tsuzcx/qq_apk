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

public abstract class ix
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WepkgVersion");
  private static final int createTime_HASHCODE;
  private static final int jKX;
  public static final Column jKp;
  public static final Column jMA;
  private static final int jMG;
  private static final int jMI;
  public static final Column jMw;
  public static final Column jMy;
  private static final int jWJ;
  public static final Column kea;
  private static final int kfD;
  private static final int kzJ;
  public static final Column kzm;
  private static final int llC;
  private static final int llD;
  public static final Column llp;
  public static final Column lls;
  public static final Column llt;
  private static final int llz;
  public static final Column lmI;
  private static final int lmS;
  public static final Column lmU;
  public static final Column lmV;
  public static final Column lmW;
  public static final Column lmX;
  public static final Column lmY;
  public static final Column lmZ;
  private static final int lnA;
  private static final int lnB;
  private static final int lnC;
  private static final int lnD;
  private static final int lnE;
  private static final int lnF;
  private static final int lnG;
  private static final int lnH;
  private static final int lnI;
  private static final int lnJ;
  private static final int lnK;
  public static final Column lna;
  public static final Column lnb;
  public static final Column lnc;
  public static final Column lnd;
  public static final Column lne;
  public static final Column lnf;
  public static final Column lnh;
  public static final Column lni;
  private static final int lnx;
  private static final int lny;
  private static final int lnz;
  private static final StorageObserverOwner<ix> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcreateTime = true;
  public long field_accessTime;
  public String field_appId;
  public int field_autoDownloadCount;
  public boolean field_bigPackageReady;
  public String field_charset;
  public long field_checkIntervalTime;
  public long field_clearPkgTime;
  public long field_createTime;
  public boolean field_disable;
  public boolean field_disableWvCache;
  public String field_domain;
  public int field_downloadNetType;
  public int field_downloadTriggerType;
  public String field_downloadUrl;
  public String field_md5;
  public long field_nextCheckTime;
  public int field_packMethod;
  public int field_packageDownloadCount;
  public String field_pkgId;
  public String field_pkgPath;
  public int field_pkgSize;
  public boolean field_preloadFilesAtomic;
  public boolean field_preloadFilesReady;
  public int field_totalDownloadCount;
  public String field_version;
  private boolean jKG = true;
  private boolean jMB = true;
  private boolean jMD = true;
  private boolean jWB = true;
  private boolean keP = true;
  private boolean kzx = true;
  private boolean llu = true;
  private boolean llx = true;
  private boolean lly = true;
  private boolean lmN = true;
  private boolean lnj = true;
  private boolean lnk = true;
  private boolean lnl = true;
  private boolean lnm = true;
  private boolean lnn = true;
  private boolean lno = true;
  private boolean lnp = true;
  private boolean lnq = true;
  private boolean lnr = true;
  private boolean lns = true;
  private boolean lnt = true;
  private boolean lnu = true;
  private boolean lnv = true;
  private boolean lnw = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    llp = new Column("pkgId", "string", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jMw = new Column("version", "string", TABLE.getName(), "");
    jMy = new Column("pkgPath", "string", TABLE.getName(), "");
    lmU = new Column("disableWvCache", "boolean", TABLE.getName(), "");
    lmV = new Column("clearPkgTime", "long", TABLE.getName(), "");
    lmW = new Column("checkIntervalTime", "long", TABLE.getName(), "");
    lmX = new Column("packMethod", "int", TABLE.getName(), "");
    lmY = new Column("domain", "string", TABLE.getName(), "");
    kea = new Column("md5", "string", TABLE.getName(), "");
    jMA = new Column("downloadUrl", "string", TABLE.getName(), "");
    lls = new Column("pkgSize", "int", TABLE.getName(), "");
    llt = new Column("downloadNetType", "int", TABLE.getName(), "");
    kzm = new Column("nextCheckTime", "long", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    lmZ = new Column("accessTime", "long", TABLE.getName(), "");
    lna = new Column("charset", "string", TABLE.getName(), "");
    lnb = new Column("bigPackageReady", "boolean", TABLE.getName(), "");
    lnc = new Column("preloadFilesReady", "boolean", TABLE.getName(), "");
    lnd = new Column("preloadFilesAtomic", "boolean", TABLE.getName(), "");
    lmI = new Column("autoDownloadCount", "int", TABLE.getName(), "");
    lne = new Column("disable", "boolean", TABLE.getName(), "");
    lnf = new Column("totalDownloadCount", "int", TABLE.getName(), "");
    lnh = new Column("packageDownloadCount", "int", TABLE.getName(), "");
    lni = new Column("downloadTriggerType", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    llz = "pkgId".hashCode();
    jKX = "appId".hashCode();
    jMG = "version".hashCode();
    jMI = "pkgPath".hashCode();
    lnx = "disableWvCache".hashCode();
    lny = "clearPkgTime".hashCode();
    lnz = "checkIntervalTime".hashCode();
    lnA = "packMethod".hashCode();
    lnB = "domain".hashCode();
    kfD = "md5".hashCode();
    jWJ = "downloadUrl".hashCode();
    llC = "pkgSize".hashCode();
    llD = "downloadNetType".hashCode();
    kzJ = "nextCheckTime".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    lnC = "accessTime".hashCode();
    lnD = "charset".hashCode();
    lnE = "bigPackageReady".hashCode();
    lnF = "preloadFilesReady".hashCode();
    lnG = "preloadFilesAtomic".hashCode();
    lmS = "autoDownloadCount".hashCode();
    lnH = "disable".hashCode();
    lnI = "totalDownloadCount".hashCode();
    lnJ = "packageDownloadCount".hashCode();
    lnK = "downloadTriggerType".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[25];
    localMAutoDBInfo.columns = new String[26];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "pkgId";
    localMAutoDBInfo.colsMap.put("pkgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" pkgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "pkgId";
    localMAutoDBInfo.columns[1] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "version";
    localMAutoDBInfo.colsMap.put("version", "TEXT");
    localStringBuilder.append(" version TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "pkgPath";
    localMAutoDBInfo.colsMap.put("pkgPath", "TEXT");
    localStringBuilder.append(" pkgPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "disableWvCache";
    localMAutoDBInfo.colsMap.put("disableWvCache", "INTEGER default 'true' ");
    localStringBuilder.append(" disableWvCache INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "clearPkgTime";
    localMAutoDBInfo.colsMap.put("clearPkgTime", "LONG");
    localStringBuilder.append(" clearPkgTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "checkIntervalTime";
    localMAutoDBInfo.colsMap.put("checkIntervalTime", "LONG");
    localStringBuilder.append(" checkIntervalTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "packMethod";
    localMAutoDBInfo.colsMap.put("packMethod", "INTEGER");
    localStringBuilder.append(" packMethod INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "domain";
    localMAutoDBInfo.colsMap.put("domain", "TEXT");
    localStringBuilder.append(" domain TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "downloadUrl";
    localMAutoDBInfo.colsMap.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "pkgSize";
    localMAutoDBInfo.colsMap.put("pkgSize", "INTEGER");
    localStringBuilder.append(" pkgSize INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "downloadNetType";
    localMAutoDBInfo.colsMap.put("downloadNetType", "INTEGER");
    localStringBuilder.append(" downloadNetType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "nextCheckTime";
    localMAutoDBInfo.colsMap.put("nextCheckTime", "LONG");
    localStringBuilder.append(" nextCheckTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "accessTime";
    localMAutoDBInfo.colsMap.put("accessTime", "LONG default '0' ");
    localStringBuilder.append(" accessTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "charset";
    localMAutoDBInfo.colsMap.put("charset", "TEXT default 'UTF-8' ");
    localStringBuilder.append(" charset TEXT default 'UTF-8' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "bigPackageReady";
    localMAutoDBInfo.colsMap.put("bigPackageReady", "INTEGER default 'false' ");
    localStringBuilder.append(" bigPackageReady INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "preloadFilesReady";
    localMAutoDBInfo.colsMap.put("preloadFilesReady", "INTEGER default 'false' ");
    localStringBuilder.append(" preloadFilesReady INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "preloadFilesAtomic";
    localMAutoDBInfo.colsMap.put("preloadFilesAtomic", "INTEGER default 'false' ");
    localStringBuilder.append(" preloadFilesAtomic INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "autoDownloadCount";
    localMAutoDBInfo.colsMap.put("autoDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" autoDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "disable";
    localMAutoDBInfo.colsMap.put("disable", "INTEGER default 'false' ");
    localStringBuilder.append(" disable INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "totalDownloadCount";
    localMAutoDBInfo.colsMap.put("totalDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" totalDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "packageDownloadCount";
    localMAutoDBInfo.colsMap.put("packageDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" packageDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "downloadTriggerType";
    localMAutoDBInfo.colsMap.put("downloadTriggerType", "INTEGER default '-1' ");
    localStringBuilder.append(" downloadTriggerType INTEGER default '-1' ");
    localMAutoDBInfo.columns[25] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramContentValues.containsKey("pkgId"))
    {
      this.field_pkgId = paramContentValues.getAsString("pkgId");
      if (paramBoolean) {
        this.llu = true;
      }
    }
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("version"))
    {
      this.field_version = paramContentValues.getAsString("version");
      if (paramBoolean) {
        this.jMB = true;
      }
    }
    if (paramContentValues.containsKey("pkgPath"))
    {
      this.field_pkgPath = paramContentValues.getAsString("pkgPath");
      if (paramBoolean) {
        this.jMD = true;
      }
    }
    if (paramContentValues.containsKey("disableWvCache"))
    {
      if (paramContentValues.getAsInteger("disableWvCache").intValue() == 0) {
        break label810;
      }
      bool1 = true;
      this.field_disableWvCache = bool1;
      if (paramBoolean) {
        this.lnj = true;
      }
    }
    if (paramContentValues.containsKey("clearPkgTime"))
    {
      this.field_clearPkgTime = paramContentValues.getAsLong("clearPkgTime").longValue();
      if (paramBoolean) {
        this.lnk = true;
      }
    }
    if (paramContentValues.containsKey("checkIntervalTime"))
    {
      this.field_checkIntervalTime = paramContentValues.getAsLong("checkIntervalTime").longValue();
      if (paramBoolean) {
        this.lnl = true;
      }
    }
    if (paramContentValues.containsKey("packMethod"))
    {
      this.field_packMethod = paramContentValues.getAsInteger("packMethod").intValue();
      if (paramBoolean) {
        this.lnm = true;
      }
    }
    if (paramContentValues.containsKey("domain"))
    {
      this.field_domain = paramContentValues.getAsString("domain");
      if (paramBoolean) {
        this.lnn = true;
      }
    }
    if (paramContentValues.containsKey("md5"))
    {
      this.field_md5 = paramContentValues.getAsString("md5");
      if (paramBoolean) {
        this.keP = true;
      }
    }
    if (paramContentValues.containsKey("downloadUrl"))
    {
      this.field_downloadUrl = paramContentValues.getAsString("downloadUrl");
      if (paramBoolean) {
        this.jWB = true;
      }
    }
    if (paramContentValues.containsKey("pkgSize"))
    {
      this.field_pkgSize = paramContentValues.getAsInteger("pkgSize").intValue();
      if (paramBoolean) {
        this.llx = true;
      }
    }
    if (paramContentValues.containsKey("downloadNetType"))
    {
      this.field_downloadNetType = paramContentValues.getAsInteger("downloadNetType").intValue();
      if (paramBoolean) {
        this.lly = true;
      }
    }
    if (paramContentValues.containsKey("nextCheckTime"))
    {
      this.field_nextCheckTime = paramContentValues.getAsLong("nextCheckTime").longValue();
      if (paramBoolean) {
        this.kzx = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("accessTime"))
    {
      this.field_accessTime = paramContentValues.getAsLong("accessTime").longValue();
      if (paramBoolean) {
        this.lno = true;
      }
    }
    if (paramContentValues.containsKey("charset"))
    {
      this.field_charset = paramContentValues.getAsString("charset");
      if (paramBoolean) {
        this.lnp = true;
      }
    }
    if (paramContentValues.containsKey("bigPackageReady"))
    {
      if (paramContentValues.getAsInteger("bigPackageReady").intValue() == 0) {
        break label815;
      }
      bool1 = true;
      label535:
      this.field_bigPackageReady = bool1;
      if (paramBoolean) {
        this.lnq = true;
      }
    }
    if (paramContentValues.containsKey("preloadFilesReady"))
    {
      if (paramContentValues.getAsInteger("preloadFilesReady").intValue() == 0) {
        break label820;
      }
      bool1 = true;
      label572:
      this.field_preloadFilesReady = bool1;
      if (paramBoolean) {
        this.lnr = true;
      }
    }
    if (paramContentValues.containsKey("preloadFilesAtomic")) {
      if (paramContentValues.getAsInteger("preloadFilesAtomic").intValue() == 0) {
        break label825;
      }
    }
    label810:
    label815:
    label820:
    label825:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.field_preloadFilesAtomic = bool1;
      if (paramBoolean) {
        this.lns = true;
      }
      if (paramContentValues.containsKey("autoDownloadCount"))
      {
        this.field_autoDownloadCount = paramContentValues.getAsInteger("autoDownloadCount").intValue();
        if (paramBoolean) {
          this.lmN = true;
        }
      }
      if (paramContentValues.containsKey("disable"))
      {
        bool1 = bool2;
        if (paramContentValues.getAsInteger("disable").intValue() != 0) {
          bool1 = true;
        }
        this.field_disable = bool1;
        if (paramBoolean) {
          this.lnt = true;
        }
      }
      if (paramContentValues.containsKey("totalDownloadCount"))
      {
        this.field_totalDownloadCount = paramContentValues.getAsInteger("totalDownloadCount").intValue();
        if (paramBoolean) {
          this.lnu = true;
        }
      }
      if (paramContentValues.containsKey("packageDownloadCount"))
      {
        this.field_packageDownloadCount = paramContentValues.getAsInteger("packageDownloadCount").intValue();
        if (paramBoolean) {
          this.lnv = true;
        }
      }
      if (paramContentValues.containsKey("downloadTriggerType"))
      {
        this.field_downloadTriggerType = paramContentValues.getAsInteger("downloadTriggerType").intValue();
        if (paramBoolean) {
          this.lnw = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label535;
      bool1 = false;
      break label572;
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
      if (llz != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.llu = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jKX == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (jMG == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (jMI == k)
      {
        this.field_pkgPath = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (lnx == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_disableWvCache = bool;
            break;
          }
        }
        if (lny == k)
        {
          this.field_clearPkgTime = paramCursor.getLong(i);
        }
        else if (lnz == k)
        {
          this.field_checkIntervalTime = paramCursor.getLong(i);
        }
        else if (lnA == k)
        {
          this.field_packMethod = paramCursor.getInt(i);
        }
        else if (lnB == k)
        {
          this.field_domain = paramCursor.getString(i);
        }
        else if (kfD == k)
        {
          this.field_md5 = paramCursor.getString(i);
        }
        else if (jWJ == k)
        {
          this.field_downloadUrl = paramCursor.getString(i);
        }
        else if (llC == k)
        {
          this.field_pkgSize = paramCursor.getInt(i);
        }
        else if (llD == k)
        {
          this.field_downloadNetType = paramCursor.getInt(i);
        }
        else if (kzJ == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else if (createTime_HASHCODE == k)
        {
          this.field_createTime = paramCursor.getLong(i);
        }
        else if (lnC == k)
        {
          this.field_accessTime = paramCursor.getLong(i);
        }
        else if (lnD == k)
        {
          this.field_charset = paramCursor.getString(i);
        }
        else
        {
          if (lnE == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_bigPackageReady = bool;
              break;
            }
          }
          if (lnF == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesReady = bool;
              break;
            }
          }
          if (lnG == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_preloadFilesAtomic = bool;
              break;
            }
          }
          if (lmS == k)
          {
            this.field_autoDownloadCount = paramCursor.getInt(i);
          }
          else
          {
            if (lnH == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_disable = bool;
                break;
              }
            }
            if (lnI == k) {
              this.field_totalDownloadCount = paramCursor.getInt(i);
            } else if (lnJ == k) {
              this.field_packageDownloadCount = paramCursor.getInt(i);
            } else if (lnK == k) {
              this.field_downloadTriggerType = paramCursor.getInt(i);
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
    if (this.llu) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.jMB) {
      localContentValues.put("version", this.field_version);
    }
    if (this.jMD) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.lnj) {
      localContentValues.put("disableWvCache", Boolean.valueOf(this.field_disableWvCache));
    }
    if (this.lnk) {
      localContentValues.put("clearPkgTime", Long.valueOf(this.field_clearPkgTime));
    }
    if (this.lnl) {
      localContentValues.put("checkIntervalTime", Long.valueOf(this.field_checkIntervalTime));
    }
    if (this.lnm) {
      localContentValues.put("packMethod", Integer.valueOf(this.field_packMethod));
    }
    if (this.lnn) {
      localContentValues.put("domain", this.field_domain);
    }
    if (this.keP) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.jWB) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.llx) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.lly) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.kzx) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.lno) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.field_charset == null) {
      this.field_charset = "UTF-8";
    }
    if (this.lnp) {
      localContentValues.put("charset", this.field_charset);
    }
    if (this.lnq) {
      localContentValues.put("bigPackageReady", Boolean.valueOf(this.field_bigPackageReady));
    }
    if (this.lnr) {
      localContentValues.put("preloadFilesReady", Boolean.valueOf(this.field_preloadFilesReady));
    }
    if (this.lns) {
      localContentValues.put("preloadFilesAtomic", Boolean.valueOf(this.field_preloadFilesAtomic));
    }
    if (this.lmN) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.lnt) {
      localContentValues.put("disable", Boolean.valueOf(this.field_disable));
    }
    if (this.lnu) {
      localContentValues.put("totalDownloadCount", Integer.valueOf(this.field_totalDownloadCount));
    }
    if (this.lnv) {
      localContentValues.put("packageDownloadCount", Integer.valueOf(this.field_packageDownloadCount));
    }
    if (this.lnw) {
      localContentValues.put("downloadTriggerType", Integer.valueOf(this.field_downloadTriggerType));
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
  
  public StorageObserverOwner<? extends ix> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_pkgId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.ix
 * JD-Core Version:    0.7.0.1
 */