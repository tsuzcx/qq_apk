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

public abstract class cf
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FileDownloadInfo");
  public static final Column UPDATETIME;
  private static final int jIF;
  public static final Column jIK;
  private static final int jIY;
  public static final Column jIz;
  private static final int jJD;
  public static final Column jJz;
  private static final int jKX;
  public static final Column jKp;
  public static final Column jMA;
  private static final int jNX;
  public static final Column jNf;
  private static final int jSZ;
  public static final Column jSx;
  private static final int jWI;
  private static final int jWJ;
  private static final int jWL;
  public static final Column jWt;
  public static final Column jWv;
  public static final Column kea;
  private static final int kfD;
  public static final Column kkA;
  public static final Column kkB;
  public static final Column kkC;
  public static final Column kkD;
  public static final Column kkE;
  public static final Column kkF;
  public static final Column kkG;
  public static final Column kkH;
  public static final Column kkI;
  public static final Column kkJ;
  public static final Column kkK;
  public static final Column kkL;
  public static final Column kkM;
  public static final Column kkN;
  public static final Column kkO;
  public static final Column kkP;
  public static final Column kkQ;
  public static final Column kkR;
  public static final Column kkS;
  public static final Column kkT;
  public static final Column kkU;
  public static final Column kkV;
  public static final Column kkW;
  public static final Column kkX;
  public static final Column kkY;
  public static final Column kkZ;
  public static final Column kky;
  public static final Column kkz;
  private static final int klG;
  private static final int klH;
  private static final int klI;
  private static final int klJ;
  private static final int klK;
  private static final int klL;
  private static final int klM;
  private static final int klN;
  private static final int klO;
  private static final int klP;
  private static final int klQ;
  private static final int klR;
  private static final int klS;
  private static final int klT;
  private static final int klU;
  private static final int klV;
  private static final int klW;
  private static final int klX;
  private static final int klY;
  private static final int klZ;
  public static final Column kla;
  public static final Column klb;
  private static final int kma;
  private static final int kmb;
  private static final int kmc;
  private static final int kmd;
  private static final int kme;
  private static final int kmf;
  private static final int kmg;
  private static final int kmh;
  private static final int kmi;
  private static final int kmj;
  private static final StorageObserverOwner<cf> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public String field_appId;
  public boolean field_autoDownload;
  public boolean field_autoInstall;
  public String field_channelId;
  public long field_downloadId;
  public boolean field_downloadInWifi;
  public int field_downloadType;
  public String field_downloadUrl;
  public int field_downloadUrlHashCode;
  public long field_downloadedSize;
  public int field_downloaderType;
  public int field_errCode;
  public String field_extInfo;
  public String field_fileName;
  public String field_filePath;
  public long field_fileSize;
  public int field_fileType;
  public long field_finishTime;
  public boolean field_fromDownloadApp;
  public boolean field_fromWeApp;
  public boolean field_isSecondDownload;
  public String field_md5;
  public int field_noticeId;
  public String field_notificationTitle;
  public String field_packageName;
  public String field_rawAppId;
  public boolean field_reserveInWifi;
  public int field_scene;
  public String field_secondaryUrl;
  public byte[] field_sectionMd5Byte;
  public boolean field_showNotification;
  public int field_ssid;
  public int field_startScene;
  public long field_startSize;
  public int field_startState;
  public long field_startTime;
  public int field_status;
  public long field_sysDownloadId;
  public long field_totalSize;
  public int field_uiarea;
  public long field_updateTime;
  private boolean jIC = true;
  private boolean jIR = true;
  private boolean jJB = true;
  private boolean jKG = true;
  private boolean jNB = true;
  private boolean jSL = true;
  private boolean jWA = true;
  private boolean jWB = true;
  private boolean jWD = true;
  private boolean keP = true;
  private boolean klA = true;
  private boolean klB = true;
  private boolean klC = true;
  private boolean klD = true;
  private boolean klE = true;
  private boolean klF = true;
  private boolean klc = true;
  private boolean kld = true;
  private boolean kle = true;
  private boolean klf = true;
  private boolean klg = true;
  private boolean klh = true;
  private boolean kli = true;
  private boolean klj = true;
  private boolean klk = true;
  private boolean kll = true;
  private boolean klm = true;
  private boolean kln = true;
  private boolean klo = true;
  private boolean klp = true;
  private boolean klq = true;
  private boolean klr = true;
  private boolean kls = true;
  private boolean klt = true;
  private boolean klu = true;
  private boolean klv = true;
  private boolean klw = true;
  private boolean klx = true;
  private boolean kly = true;
  private boolean klz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kky = new Column("downloadId", "long", TABLE.getName(), "");
    jMA = new Column("downloadUrl", "string", TABLE.getName(), "");
    kkz = new Column("secondaryUrl", "string", TABLE.getName(), "");
    kkA = new Column("fileSize", "long", TABLE.getName(), "");
    kkB = new Column("fileName", "string", TABLE.getName(), "");
    jWv = new Column("filePath", "string", TABLE.getName(), "");
    kkC = new Column("fileType", "int", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    kea = new Column("md5", "string", TABLE.getName(), "");
    kkD = new Column("autoInstall", "boolean", TABLE.getName(), "");
    kkE = new Column("showNotification", "boolean", TABLE.getName(), "");
    kkF = new Column("sysDownloadId", "long", TABLE.getName(), "");
    kkG = new Column("downloaderType", "int", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jWt = new Column("downloadUrlHashCode", "int", TABLE.getName(), "");
    jNf = new Column("packageName", "string", TABLE.getName(), "");
    kkH = new Column("downloadedSize", "long", TABLE.getName(), "");
    kkI = new Column("totalSize", "long", TABLE.getName(), "");
    kkJ = new Column("autoDownload", "boolean", TABLE.getName(), "");
    kkK = new Column("channelId", "string", TABLE.getName(), "");
    jJz = new Column("scene", "int", TABLE.getName(), "");
    kkL = new Column("errCode", "int", TABLE.getName(), "");
    jIK = new Column("startTime", "long", TABLE.getName(), "");
    kkM = new Column("startSize", "long", TABLE.getName(), "");
    kkN = new Column("startState", "int", TABLE.getName(), "");
    kkO = new Column("fromWeApp", "boolean", TABLE.getName(), "");
    kkP = new Column("downloadInWifi", "boolean", TABLE.getName(), "");
    jSx = new Column("extInfo", "string", TABLE.getName(), "");
    kkQ = new Column("finishTime", "long", TABLE.getName(), "");
    kkR = new Column("isSecondDownload", "boolean", TABLE.getName(), "");
    kkS = new Column("fromDownloadApp", "boolean", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    kkT = new Column("reserveInWifi", "boolean", TABLE.getName(), "");
    kkU = new Column("ssid", "int", TABLE.getName(), "");
    kkV = new Column("uiarea", "int", TABLE.getName(), "");
    kkW = new Column("noticeId", "int", TABLE.getName(), "");
    kkX = new Column("downloadType", "int", TABLE.getName(), "");
    kkY = new Column("startScene", "int", TABLE.getName(), "");
    kkZ = new Column("sectionMd5Byte", "byte[]", TABLE.getName(), "");
    kla = new Column("rawAppId", "string", TABLE.getName(), "");
    klb = new Column("notificationTitle", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    klG = "downloadId".hashCode();
    jWJ = "downloadUrl".hashCode();
    klH = "secondaryUrl".hashCode();
    klI = "fileSize".hashCode();
    klJ = "fileName".hashCode();
    jWL = "filePath".hashCode();
    klK = "fileType".hashCode();
    jIF = "status".hashCode();
    kfD = "md5".hashCode();
    klL = "autoInstall".hashCode();
    klM = "showNotification".hashCode();
    klN = "sysDownloadId".hashCode();
    klO = "downloaderType".hashCode();
    jKX = "appId".hashCode();
    jWI = "downloadUrlHashCode".hashCode();
    jNX = "packageName".hashCode();
    klP = "downloadedSize".hashCode();
    klQ = "totalSize".hashCode();
    klR = "autoDownload".hashCode();
    klS = "channelId".hashCode();
    jJD = "scene".hashCode();
    klT = "errCode".hashCode();
    jIY = "startTime".hashCode();
    klU = "startSize".hashCode();
    klV = "startState".hashCode();
    klW = "fromWeApp".hashCode();
    klX = "downloadInWifi".hashCode();
    jSZ = "extInfo".hashCode();
    klY = "finishTime".hashCode();
    klZ = "isSecondDownload".hashCode();
    kma = "fromDownloadApp".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    kmb = "reserveInWifi".hashCode();
    kmc = "ssid".hashCode();
    kmd = "uiarea".hashCode();
    kme = "noticeId".hashCode();
    kmf = "downloadType".hashCode();
    kmg = "startScene".hashCode();
    kmh = "sectionMd5Byte".hashCode();
    kmi = "rawAppId".hashCode();
    kmj = "notificationTitle".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[41];
    localMAutoDBInfo.columns = new String[42];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "downloadId";
    localMAutoDBInfo.colsMap.put("downloadId", "LONG default '-1'  PRIMARY KEY ");
    localStringBuilder.append(" downloadId LONG default '-1'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "downloadId";
    localMAutoDBInfo.columns[1] = "downloadUrl";
    localMAutoDBInfo.colsMap.put("downloadUrl", "TEXT default '' ");
    localStringBuilder.append(" downloadUrl TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "secondaryUrl";
    localMAutoDBInfo.colsMap.put("secondaryUrl", "TEXT default '' ");
    localStringBuilder.append(" secondaryUrl TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "fileSize";
    localMAutoDBInfo.colsMap.put("fileSize", "LONG default '0' ");
    localStringBuilder.append(" fileSize LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "fileName";
    localMAutoDBInfo.colsMap.put("fileName", "TEXT default '' ");
    localStringBuilder.append(" fileName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "filePath";
    localMAutoDBInfo.colsMap.put("filePath", "TEXT default '' ");
    localStringBuilder.append(" filePath TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "fileType";
    localMAutoDBInfo.colsMap.put("fileType", "INTEGER default '0' ");
    localStringBuilder.append(" fileType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT default '' ");
    localStringBuilder.append(" md5 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "autoInstall";
    localMAutoDBInfo.colsMap.put("autoInstall", "INTEGER default 'false' ");
    localStringBuilder.append(" autoInstall INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "showNotification";
    localMAutoDBInfo.colsMap.put("showNotification", "INTEGER default 'false' ");
    localStringBuilder.append(" showNotification INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "sysDownloadId";
    localMAutoDBInfo.colsMap.put("sysDownloadId", "LONG default '-1' ");
    localStringBuilder.append(" sysDownloadId LONG default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "downloaderType";
    localMAutoDBInfo.colsMap.put("downloaderType", "INTEGER default '0' ");
    localStringBuilder.append(" downloaderType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT default '' ");
    localStringBuilder.append(" appId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "downloadUrlHashCode";
    localMAutoDBInfo.colsMap.put("downloadUrlHashCode", "INTEGER default '0' ");
    localStringBuilder.append(" downloadUrlHashCode INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "packageName";
    localMAutoDBInfo.colsMap.put("packageName", "TEXT default '' ");
    localStringBuilder.append(" packageName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "downloadedSize";
    localMAutoDBInfo.colsMap.put("downloadedSize", "LONG default '0' ");
    localStringBuilder.append(" downloadedSize LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "totalSize";
    localMAutoDBInfo.colsMap.put("totalSize", "LONG default '0' ");
    localStringBuilder.append(" totalSize LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "autoDownload";
    localMAutoDBInfo.colsMap.put("autoDownload", "INTEGER default 'false' ");
    localStringBuilder.append(" autoDownload INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "channelId";
    localMAutoDBInfo.colsMap.put("channelId", "TEXT default '' ");
    localStringBuilder.append(" channelId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER default '0' ");
    localStringBuilder.append(" scene INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "errCode";
    localMAutoDBInfo.colsMap.put("errCode", "INTEGER default '0' ");
    localStringBuilder.append(" errCode INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "startTime";
    localMAutoDBInfo.colsMap.put("startTime", "LONG default '0' ");
    localStringBuilder.append(" startTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "startSize";
    localMAutoDBInfo.colsMap.put("startSize", "LONG default '0' ");
    localStringBuilder.append(" startSize LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "startState";
    localMAutoDBInfo.colsMap.put("startState", "INTEGER default '0' ");
    localStringBuilder.append(" startState INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "fromWeApp";
    localMAutoDBInfo.colsMap.put("fromWeApp", "INTEGER default 'false' ");
    localStringBuilder.append(" fromWeApp INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "downloadInWifi";
    localMAutoDBInfo.colsMap.put("downloadInWifi", "INTEGER default 'false' ");
    localStringBuilder.append(" downloadInWifi INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "extInfo";
    localMAutoDBInfo.colsMap.put("extInfo", "TEXT default '' ");
    localStringBuilder.append(" extInfo TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "finishTime";
    localMAutoDBInfo.colsMap.put("finishTime", "LONG default '0' ");
    localStringBuilder.append(" finishTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "isSecondDownload";
    localMAutoDBInfo.colsMap.put("isSecondDownload", "INTEGER default 'false' ");
    localStringBuilder.append(" isSecondDownload INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "fromDownloadApp";
    localMAutoDBInfo.colsMap.put("fromDownloadApp", "INTEGER default 'false' ");
    localStringBuilder.append(" fromDownloadApp INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "reserveInWifi";
    localMAutoDBInfo.colsMap.put("reserveInWifi", "INTEGER default 'false' ");
    localStringBuilder.append(" reserveInWifi INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[33] = "ssid";
    localMAutoDBInfo.colsMap.put("ssid", "INTEGER default '0' ");
    localStringBuilder.append(" ssid INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[34] = "uiarea";
    localMAutoDBInfo.colsMap.put("uiarea", "INTEGER default '0' ");
    localStringBuilder.append(" uiarea INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[35] = "noticeId";
    localMAutoDBInfo.colsMap.put("noticeId", "INTEGER default '0' ");
    localStringBuilder.append(" noticeId INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[36] = "downloadType";
    localMAutoDBInfo.colsMap.put("downloadType", "INTEGER default '0' ");
    localStringBuilder.append(" downloadType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[37] = "startScene";
    localMAutoDBInfo.colsMap.put("startScene", "INTEGER default '0' ");
    localStringBuilder.append(" startScene INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[38] = "sectionMd5Byte";
    localMAutoDBInfo.colsMap.put("sectionMd5Byte", "BLOB");
    localStringBuilder.append(" sectionMd5Byte BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[39] = "rawAppId";
    localMAutoDBInfo.colsMap.put("rawAppId", "TEXT default '' ");
    localStringBuilder.append(" rawAppId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[40] = "notificationTitle";
    localMAutoDBInfo.colsMap.put("notificationTitle", "TEXT default '' ");
    localStringBuilder.append(" notificationTitle TEXT default '' ");
    localMAutoDBInfo.columns[41] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramContentValues.containsKey("downloadId"))
    {
      this.field_downloadId = paramContentValues.getAsLong("downloadId").longValue();
      if (paramBoolean) {
        this.klc = true;
      }
    }
    if (paramContentValues.containsKey("downloadUrl"))
    {
      this.field_downloadUrl = paramContentValues.getAsString("downloadUrl");
      if (paramBoolean) {
        this.jWB = true;
      }
    }
    if (paramContentValues.containsKey("secondaryUrl"))
    {
      this.field_secondaryUrl = paramContentValues.getAsString("secondaryUrl");
      if (paramBoolean) {
        this.kld = true;
      }
    }
    if (paramContentValues.containsKey("fileSize"))
    {
      this.field_fileSize = paramContentValues.getAsLong("fileSize").longValue();
      if (paramBoolean) {
        this.kle = true;
      }
    }
    if (paramContentValues.containsKey("fileName"))
    {
      this.field_fileName = paramContentValues.getAsString("fileName");
      if (paramBoolean) {
        this.klf = true;
      }
    }
    if (paramContentValues.containsKey("filePath"))
    {
      this.field_filePath = paramContentValues.getAsString("filePath");
      if (paramBoolean) {
        this.jWD = true;
      }
    }
    if (paramContentValues.containsKey("fileType"))
    {
      this.field_fileType = paramContentValues.getAsInteger("fileType").intValue();
      if (paramBoolean) {
        this.klg = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("md5"))
    {
      this.field_md5 = paramContentValues.getAsString("md5");
      if (paramBoolean) {
        this.keP = true;
      }
    }
    if (paramContentValues.containsKey("autoInstall"))
    {
      if (paramContentValues.getAsInteger("autoInstall").intValue() == 0) {
        break label1376;
      }
      bool1 = true;
      this.field_autoInstall = bool1;
      if (paramBoolean) {
        this.klh = true;
      }
    }
    if (paramContentValues.containsKey("showNotification"))
    {
      if (paramContentValues.getAsInteger("showNotification").intValue() == 0) {
        break label1381;
      }
      bool1 = true;
      label331:
      this.field_showNotification = bool1;
      if (paramBoolean) {
        this.kli = true;
      }
    }
    if (paramContentValues.containsKey("sysDownloadId"))
    {
      this.field_sysDownloadId = paramContentValues.getAsLong("sysDownloadId").longValue();
      if (paramBoolean) {
        this.klj = true;
      }
    }
    if (paramContentValues.containsKey("downloaderType"))
    {
      this.field_downloaderType = paramContentValues.getAsInteger("downloaderType").intValue();
      if (paramBoolean) {
        this.klk = true;
      }
    }
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("downloadUrlHashCode"))
    {
      this.field_downloadUrlHashCode = paramContentValues.getAsInteger("downloadUrlHashCode").intValue();
      if (paramBoolean) {
        this.jWA = true;
      }
    }
    if (paramContentValues.containsKey("packageName"))
    {
      this.field_packageName = paramContentValues.getAsString("packageName");
      if (paramBoolean) {
        this.jNB = true;
      }
    }
    if (paramContentValues.containsKey("downloadedSize"))
    {
      this.field_downloadedSize = paramContentValues.getAsLong("downloadedSize").longValue();
      if (paramBoolean) {
        this.kll = true;
      }
    }
    if (paramContentValues.containsKey("totalSize"))
    {
      this.field_totalSize = paramContentValues.getAsLong("totalSize").longValue();
      if (paramBoolean) {
        this.klm = true;
      }
    }
    if (paramContentValues.containsKey("autoDownload"))
    {
      if (paramContentValues.getAsInteger("autoDownload").intValue() == 0) {
        break label1386;
      }
      bool1 = true;
      label595:
      this.field_autoDownload = bool1;
      if (paramBoolean) {
        this.kln = true;
      }
    }
    if (paramContentValues.containsKey("channelId"))
    {
      this.field_channelId = paramContentValues.getAsString("channelId");
      if (paramBoolean) {
        this.klo = true;
      }
    }
    if (paramContentValues.containsKey("scene"))
    {
      this.field_scene = paramContentValues.getAsInteger("scene").intValue();
      if (paramBoolean) {
        this.jJB = true;
      }
    }
    if (paramContentValues.containsKey("errCode"))
    {
      this.field_errCode = paramContentValues.getAsInteger("errCode").intValue();
      if (paramBoolean) {
        this.klp = true;
      }
    }
    if (paramContentValues.containsKey("startTime"))
    {
      this.field_startTime = paramContentValues.getAsLong("startTime").longValue();
      if (paramBoolean) {
        this.jIR = true;
      }
    }
    if (paramContentValues.containsKey("startSize"))
    {
      this.field_startSize = paramContentValues.getAsLong("startSize").longValue();
      if (paramBoolean) {
        this.klq = true;
      }
    }
    if (paramContentValues.containsKey("startState"))
    {
      this.field_startState = paramContentValues.getAsInteger("startState").intValue();
      if (paramBoolean) {
        this.klr = true;
      }
    }
    if (paramContentValues.containsKey("fromWeApp"))
    {
      if (paramContentValues.getAsInteger("fromWeApp").intValue() == 0) {
        break label1391;
      }
      bool1 = true;
      label829:
      this.field_fromWeApp = bool1;
      if (paramBoolean) {
        this.kls = true;
      }
    }
    if (paramContentValues.containsKey("downloadInWifi"))
    {
      if (paramContentValues.getAsInteger("downloadInWifi").intValue() == 0) {
        break label1396;
      }
      bool1 = true;
      label868:
      this.field_downloadInWifi = bool1;
      if (paramBoolean) {
        this.klt = true;
      }
    }
    if (paramContentValues.containsKey("extInfo"))
    {
      this.field_extInfo = paramContentValues.getAsString("extInfo");
      if (paramBoolean) {
        this.jSL = true;
      }
    }
    if (paramContentValues.containsKey("finishTime"))
    {
      this.field_finishTime = paramContentValues.getAsLong("finishTime").longValue();
      if (paramBoolean) {
        this.klu = true;
      }
    }
    if (paramContentValues.containsKey("isSecondDownload"))
    {
      if (paramContentValues.getAsInteger("isSecondDownload").intValue() == 0) {
        break label1401;
      }
      bool1 = true;
      label970:
      this.field_isSecondDownload = bool1;
      if (paramBoolean) {
        this.klv = true;
      }
    }
    if (paramContentValues.containsKey("fromDownloadApp")) {
      if (paramContentValues.getAsInteger("fromDownloadApp").intValue() == 0) {
        break label1406;
      }
    }
    label1376:
    label1381:
    label1386:
    label1391:
    label1396:
    label1401:
    label1406:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.field_fromDownloadApp = bool1;
      if (paramBoolean) {
        this.klw = true;
      }
      if (paramContentValues.containsKey("updateTime"))
      {
        this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
        if (paramBoolean) {
          this.__hadSetupdateTime = true;
        }
      }
      if (paramContentValues.containsKey("reserveInWifi"))
      {
        bool1 = bool2;
        if (paramContentValues.getAsInteger("reserveInWifi").intValue() != 0) {
          bool1 = true;
        }
        this.field_reserveInWifi = bool1;
        if (paramBoolean) {
          this.klx = true;
        }
      }
      if (paramContentValues.containsKey("ssid"))
      {
        this.field_ssid = paramContentValues.getAsInteger("ssid").intValue();
        if (paramBoolean) {
          this.kly = true;
        }
      }
      if (paramContentValues.containsKey("uiarea"))
      {
        this.field_uiarea = paramContentValues.getAsInteger("uiarea").intValue();
        if (paramBoolean) {
          this.klz = true;
        }
      }
      if (paramContentValues.containsKey("noticeId"))
      {
        this.field_noticeId = paramContentValues.getAsInteger("noticeId").intValue();
        if (paramBoolean) {
          this.klA = true;
        }
      }
      if (paramContentValues.containsKey("downloadType"))
      {
        this.field_downloadType = paramContentValues.getAsInteger("downloadType").intValue();
        if (paramBoolean) {
          this.klB = true;
        }
      }
      if (paramContentValues.containsKey("startScene"))
      {
        this.field_startScene = paramContentValues.getAsInteger("startScene").intValue();
        if (paramBoolean) {
          this.klC = true;
        }
      }
      if (paramContentValues.containsKey("sectionMd5Byte"))
      {
        this.field_sectionMd5Byte = paramContentValues.getAsByteArray("sectionMd5Byte");
        if (paramBoolean) {
          this.klD = true;
        }
      }
      if (paramContentValues.containsKey("rawAppId"))
      {
        this.field_rawAppId = paramContentValues.getAsString("rawAppId");
        if (paramBoolean) {
          this.klE = true;
        }
      }
      if (paramContentValues.containsKey("notificationTitle"))
      {
        this.field_notificationTitle = paramContentValues.getAsString("notificationTitle");
        if (paramBoolean) {
          this.klF = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label331;
      bool1 = false;
      break label595;
      bool1 = false;
      break label829;
      bool1 = false;
      break label868;
      bool1 = false;
      break label970;
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
      if (klG != k) {
        break label65;
      }
      this.field_downloadId = paramCursor.getLong(i);
      this.klc = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jWJ == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (klH == k)
      {
        this.field_secondaryUrl = paramCursor.getString(i);
      }
      else if (klI == k)
      {
        this.field_fileSize = paramCursor.getLong(i);
      }
      else if (klJ == k)
      {
        this.field_fileName = paramCursor.getString(i);
      }
      else if (jWL == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (klK == k)
      {
        this.field_fileType = paramCursor.getInt(i);
      }
      else if (jIF == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (kfD == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (klL == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_autoInstall = bool;
            break;
          }
        }
        if (klM == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showNotification = bool;
            break;
          }
        }
        if (klN == k)
        {
          this.field_sysDownloadId = paramCursor.getLong(i);
        }
        else if (klO == k)
        {
          this.field_downloaderType = paramCursor.getInt(i);
        }
        else if (jKX == k)
        {
          this.field_appId = paramCursor.getString(i);
        }
        else if (jWI == k)
        {
          this.field_downloadUrlHashCode = paramCursor.getInt(i);
        }
        else if (jNX == k)
        {
          this.field_packageName = paramCursor.getString(i);
        }
        else if (klP == k)
        {
          this.field_downloadedSize = paramCursor.getLong(i);
        }
        else if (klQ == k)
        {
          this.field_totalSize = paramCursor.getLong(i);
        }
        else
        {
          if (klR == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_autoDownload = bool;
              break;
            }
          }
          if (klS == k)
          {
            this.field_channelId = paramCursor.getString(i);
          }
          else if (jJD == k)
          {
            this.field_scene = paramCursor.getInt(i);
          }
          else if (klT == k)
          {
            this.field_errCode = paramCursor.getInt(i);
          }
          else if (jIY == k)
          {
            this.field_startTime = paramCursor.getLong(i);
          }
          else if (klU == k)
          {
            this.field_startSize = paramCursor.getLong(i);
          }
          else if (klV == k)
          {
            this.field_startState = paramCursor.getInt(i);
          }
          else
          {
            if (klW == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_fromWeApp = bool;
                break;
              }
            }
            if (klX == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWifi = bool;
                break;
              }
            }
            if (jSZ == k)
            {
              this.field_extInfo = paramCursor.getString(i);
            }
            else if (klY == k)
            {
              this.field_finishTime = paramCursor.getLong(i);
            }
            else
            {
              if (klZ == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_isSecondDownload = bool;
                  break;
                }
              }
              if (kma == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_fromDownloadApp = bool;
                  break;
                }
              }
              if (updateTime_HASHCODE == k)
              {
                this.field_updateTime = paramCursor.getLong(i);
              }
              else
              {
                if (kmb == k)
                {
                  if (paramCursor.getInt(i) != 0) {}
                  for (bool = true;; bool = false)
                  {
                    this.field_reserveInWifi = bool;
                    break;
                  }
                }
                if (kmc == k) {
                  this.field_ssid = paramCursor.getInt(i);
                } else if (kmd == k) {
                  this.field_uiarea = paramCursor.getInt(i);
                } else if (kme == k) {
                  this.field_noticeId = paramCursor.getInt(i);
                } else if (kmf == k) {
                  this.field_downloadType = paramCursor.getInt(i);
                } else if (kmg == k) {
                  this.field_startScene = paramCursor.getInt(i);
                } else if (kmh == k) {
                  this.field_sectionMd5Byte = paramCursor.getBlob(i);
                } else if (kmi == k) {
                  this.field_rawAppId = paramCursor.getString(i);
                } else if (kmj == k) {
                  this.field_notificationTitle = paramCursor.getString(i);
                } else if (rowid_HASHCODE == k) {
                  this.systemRowid = paramCursor.getLong(i);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.klc) {
      localContentValues.put("downloadId", Long.valueOf(this.field_downloadId));
    }
    if (this.field_downloadUrl == null) {
      this.field_downloadUrl = "";
    }
    if (this.jWB) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.field_secondaryUrl == null) {
      this.field_secondaryUrl = "";
    }
    if (this.kld) {
      localContentValues.put("secondaryUrl", this.field_secondaryUrl);
    }
    if (this.kle) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.field_fileName == null) {
      this.field_fileName = "";
    }
    if (this.klf) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.field_filePath == null) {
      this.field_filePath = "";
    }
    if (this.jWD) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.klg) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.field_md5 == null) {
      this.field_md5 = "";
    }
    if (this.keP) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.klh) {
      localContentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
    }
    if (this.kli) {
      localContentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
    }
    if (this.klj) {
      localContentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
    }
    if (this.klk) {
      localContentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
    }
    if (this.field_appId == null) {
      this.field_appId = "";
    }
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.jWA) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.field_packageName == null) {
      this.field_packageName = "";
    }
    if (this.jNB) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.kll) {
      localContentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
    }
    if (this.klm) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.kln) {
      localContentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
    }
    if (this.field_channelId == null) {
      this.field_channelId = "";
    }
    if (this.klo) {
      localContentValues.put("channelId", this.field_channelId);
    }
    if (this.jJB) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.klp) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.jIR) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.klq) {
      localContentValues.put("startSize", Long.valueOf(this.field_startSize));
    }
    if (this.klr) {
      localContentValues.put("startState", Integer.valueOf(this.field_startState));
    }
    if (this.kls) {
      localContentValues.put("fromWeApp", Boolean.valueOf(this.field_fromWeApp));
    }
    if (this.klt) {
      localContentValues.put("downloadInWifi", Boolean.valueOf(this.field_downloadInWifi));
    }
    if (this.field_extInfo == null) {
      this.field_extInfo = "";
    }
    if (this.jSL) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.klu) {
      localContentValues.put("finishTime", Long.valueOf(this.field_finishTime));
    }
    if (this.klv) {
      localContentValues.put("isSecondDownload", Boolean.valueOf(this.field_isSecondDownload));
    }
    if (this.klw) {
      localContentValues.put("fromDownloadApp", Boolean.valueOf(this.field_fromDownloadApp));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.klx) {
      localContentValues.put("reserveInWifi", Boolean.valueOf(this.field_reserveInWifi));
    }
    if (this.kly) {
      localContentValues.put("ssid", Integer.valueOf(this.field_ssid));
    }
    if (this.klz) {
      localContentValues.put("uiarea", Integer.valueOf(this.field_uiarea));
    }
    if (this.klA) {
      localContentValues.put("noticeId", Integer.valueOf(this.field_noticeId));
    }
    if (this.klB) {
      localContentValues.put("downloadType", Integer.valueOf(this.field_downloadType));
    }
    if (this.klC) {
      localContentValues.put("startScene", Integer.valueOf(this.field_startScene));
    }
    if (this.klD) {
      localContentValues.put("sectionMd5Byte", this.field_sectionMd5Byte);
    }
    if (this.field_rawAppId == null) {
      this.field_rawAppId = "";
    }
    if (this.klE) {
      localContentValues.put("rawAppId", this.field_rawAppId);
    }
    if (this.field_notificationTitle == null) {
      this.field_notificationTitle = "";
    }
    if (this.klF) {
      localContentValues.put("notificationTitle", this.field_notificationTitle);
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
  
  public StorageObserverOwner<? extends cf> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_downloadId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.cf
 * JD-Core Version:    0.7.0.1
 */