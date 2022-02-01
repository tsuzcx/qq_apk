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

public abstract class fn
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("Music");
  public static final Column UPDATETIME;
  public static final Column jIK;
  private static final int jIY;
  private static final int jKX;
  public static final Column jKp;
  public static final Column kMA;
  public static final Column kMB;
  public static final Column kMC;
  public static final Column kMD;
  public static final Column kME;
  public static final Column kMF;
  public static final Column kMG;
  public static final Column kMH;
  public static final Column kMI;
  public static final Column kMJ;
  public static final Column kMK;
  public static final Column kML;
  public static final Column kMM;
  public static final Column kMN;
  public static final Column kMO;
  public static final Column kMP;
  public static final Column kMQ;
  public static final Column kMR;
  public static final Column kMh;
  public static final Column kMi;
  public static final Column kMj;
  public static final Column kMk;
  public static final Column kMl;
  public static final Column kMm;
  public static final Column kMn;
  public static final Column kMo;
  public static final Column kMp;
  public static final Column kMq;
  public static final Column kMr;
  public static final Column kMs;
  public static final Column kMt;
  public static final Column kMu;
  public static final Column kMv;
  public static final Column kMw;
  public static final Column kMx;
  public static final Column kMy;
  public static final Column kMz;
  private static final int kND;
  private static final int kNE;
  private static final int kNF;
  private static final int kNG;
  private static final int kNH;
  private static final int kNI;
  private static final int kNJ;
  private static final int kNK;
  private static final int kNL;
  private static final int kNM;
  private static final int kNN;
  private static final int kNO;
  private static final int kNP;
  private static final int kNQ;
  private static final int kNR;
  private static final int kNS;
  private static final int kNT;
  private static final int kNU;
  private static final int kNV;
  private static final int kNW;
  private static final int kNX;
  private static final int kNY;
  private static final int kNZ;
  private static final int kOa;
  private static final int kOb;
  private static final int kOc;
  private static final int kOd;
  private static final int kOe;
  private static final int kOf;
  private static final int kOg;
  private static final int kOh;
  private static final int kOi;
  private static final int kOj;
  private static final int kOk;
  private static final int kOl;
  private static final int kOm;
  private static final int kOn;
  private static final StorageObserverOwner<fn> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public String field_appId;
  public boolean field_barBackToWebView;
  public long field_downloadedLength;
  public int field_endFlag;
  public boolean field_hideBanner;
  public int field_isBlock;
  public String field_jsWebUrlDomain;
  public String field_mid;
  public String field_mimetype;
  public String field_musicId;
  public int field_musicType;
  public String field_musicbar_url;
  public String field_originMusicId;
  public double field_playbackRate;
  public String field_protocol;
  public String field_songAlbum;
  public String field_songAlbumLocalPath;
  public int field_songAlbumType;
  public String field_songAlbumUrl;
  public int field_songBgColor;
  public long field_songFileLength;
  public String field_songHAlbumUrl;
  public int field_songId;
  public String field_songLyric;
  public int field_songLyricColor;
  public String field_songMId;
  public String field_songMediaId;
  public String field_songName;
  public String field_songSinger;
  public String field_songSnsAlbumUser;
  public String field_songSnsShareUser;
  public String field_songWapLinkUrl;
  public String field_songWebUrl;
  public long field_songWifiFileLength;
  public String field_songWifiUrl;
  public String field_srcUsername;
  public int field_startTime;
  public long field_updateTime;
  public long field_wifiDownloadedLength;
  public int field_wifiEndFlag;
  private boolean jIR = true;
  private boolean jKG = true;
  private boolean kMS = true;
  private boolean kMT = true;
  private boolean kMU = true;
  private boolean kMV = true;
  private boolean kMW = true;
  private boolean kMX = true;
  private boolean kMY = true;
  private boolean kMZ = true;
  private boolean kNA = true;
  private boolean kNB = true;
  private boolean kNC = true;
  private boolean kNa = true;
  private boolean kNb = true;
  private boolean kNc = true;
  private boolean kNd = true;
  private boolean kNe = true;
  private boolean kNf = true;
  private boolean kNg = true;
  private boolean kNh = true;
  private boolean kNi = true;
  private boolean kNj = true;
  private boolean kNk = true;
  private boolean kNl = true;
  private boolean kNm = true;
  private boolean kNn = true;
  private boolean kNo = true;
  private boolean kNp = true;
  private boolean kNq = true;
  private boolean kNr = true;
  private boolean kNs = true;
  private boolean kNt = true;
  private boolean kNu = true;
  private boolean kNv = true;
  private boolean kNw = true;
  private boolean kNx = true;
  private boolean kNy = true;
  private boolean kNz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kMh = new Column("musicId", "string", TABLE.getName(), "");
    kMi = new Column("originMusicId", "string", TABLE.getName(), "");
    kMj = new Column("musicType", "int", TABLE.getName(), "");
    kMk = new Column("downloadedLength", "long", TABLE.getName(), "");
    kMl = new Column("wifiDownloadedLength", "long", TABLE.getName(), "");
    kMm = new Column("endFlag", "int", TABLE.getName(), "");
    kMn = new Column("wifiEndFlag", "int", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    kMo = new Column("songId", "int", TABLE.getName(), "");
    kMp = new Column("songName", "string", TABLE.getName(), "");
    kMq = new Column("songSinger", "string", TABLE.getName(), "");
    kMr = new Column("songAlbum", "string", TABLE.getName(), "");
    kMs = new Column("songAlbumType", "int", TABLE.getName(), "");
    kMt = new Column("songAlbumUrl", "string", TABLE.getName(), "");
    kMu = new Column("songHAlbumUrl", "string", TABLE.getName(), "");
    kMv = new Column("songAlbumLocalPath", "string", TABLE.getName(), "");
    kMw = new Column("songWifiUrl", "string", TABLE.getName(), "");
    kMx = new Column("songWapLinkUrl", "string", TABLE.getName(), "");
    kMy = new Column("songWebUrl", "string", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    kMz = new Column("songMediaId", "string", TABLE.getName(), "");
    kMA = new Column("songSnsAlbumUser", "string", TABLE.getName(), "");
    kMB = new Column("songSnsShareUser", "string", TABLE.getName(), "");
    kMC = new Column("songLyric", "string", TABLE.getName(), "");
    kMD = new Column("songBgColor", "int", TABLE.getName(), "");
    kME = new Column("songLyricColor", "int", TABLE.getName(), "");
    kMF = new Column("songFileLength", "long", TABLE.getName(), "");
    kMG = new Column("songWifiFileLength", "long", TABLE.getName(), "");
    kMH = new Column("hideBanner", "boolean", TABLE.getName(), "");
    kMI = new Column("jsWebUrlDomain", "string", TABLE.getName(), "");
    kMJ = new Column("isBlock", "int", TABLE.getName(), "");
    jIK = new Column("startTime", "int", TABLE.getName(), "");
    kMK = new Column("mimetype", "string", TABLE.getName(), "");
    kML = new Column("protocol", "string", TABLE.getName(), "");
    kMM = new Column("barBackToWebView", "boolean", TABLE.getName(), "");
    kMN = new Column("musicbar_url", "string", TABLE.getName(), "");
    kMO = new Column("srcUsername", "string", TABLE.getName(), "");
    kMP = new Column("playbackRate", "double", TABLE.getName(), "");
    kMQ = new Column("songMId", "string", TABLE.getName(), "");
    kMR = new Column("mid", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kND = "musicId".hashCode();
    kNE = "originMusicId".hashCode();
    kNF = "musicType".hashCode();
    kNG = "downloadedLength".hashCode();
    kNH = "wifiDownloadedLength".hashCode();
    kNI = "endFlag".hashCode();
    kNJ = "wifiEndFlag".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    kNK = "songId".hashCode();
    kNL = "songName".hashCode();
    kNM = "songSinger".hashCode();
    kNN = "songAlbum".hashCode();
    kNO = "songAlbumType".hashCode();
    kNP = "songAlbumUrl".hashCode();
    kNQ = "songHAlbumUrl".hashCode();
    kNR = "songAlbumLocalPath".hashCode();
    kNS = "songWifiUrl".hashCode();
    kNT = "songWapLinkUrl".hashCode();
    kNU = "songWebUrl".hashCode();
    jKX = "appId".hashCode();
    kNV = "songMediaId".hashCode();
    kNW = "songSnsAlbumUser".hashCode();
    kNX = "songSnsShareUser".hashCode();
    kNY = "songLyric".hashCode();
    kNZ = "songBgColor".hashCode();
    kOa = "songLyricColor".hashCode();
    kOb = "songFileLength".hashCode();
    kOc = "songWifiFileLength".hashCode();
    kOd = "hideBanner".hashCode();
    kOe = "jsWebUrlDomain".hashCode();
    kOf = "isBlock".hashCode();
    jIY = "startTime".hashCode();
    kOg = "mimetype".hashCode();
    kOh = "protocol".hashCode();
    kOi = "barBackToWebView".hashCode();
    kOj = "musicbar_url".hashCode();
    kOk = "srcUsername".hashCode();
    kOl = "playbackRate".hashCode();
    kOm = "songMId".hashCode();
    kOn = "mid".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[40];
    localMAutoDBInfo.columns = new String[41];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "musicId";
    localMAutoDBInfo.colsMap.put("musicId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" musicId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "musicId";
    localMAutoDBInfo.columns[1] = "originMusicId";
    localMAutoDBInfo.colsMap.put("originMusicId", "TEXT");
    localStringBuilder.append(" originMusicId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "musicType";
    localMAutoDBInfo.colsMap.put("musicType", "INTEGER");
    localStringBuilder.append(" musicType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "downloadedLength";
    localMAutoDBInfo.colsMap.put("downloadedLength", "LONG");
    localStringBuilder.append(" downloadedLength LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "wifiDownloadedLength";
    localMAutoDBInfo.colsMap.put("wifiDownloadedLength", "LONG");
    localStringBuilder.append(" wifiDownloadedLength LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "endFlag";
    localMAutoDBInfo.colsMap.put("endFlag", "INTEGER");
    localStringBuilder.append(" endFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "wifiEndFlag";
    localMAutoDBInfo.colsMap.put("wifiEndFlag", "INTEGER");
    localStringBuilder.append(" wifiEndFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "songId";
    localMAutoDBInfo.colsMap.put("songId", "INTEGER");
    localStringBuilder.append(" songId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "songName";
    localMAutoDBInfo.colsMap.put("songName", "TEXT");
    localStringBuilder.append(" songName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "songSinger";
    localMAutoDBInfo.colsMap.put("songSinger", "TEXT");
    localStringBuilder.append(" songSinger TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "songAlbum";
    localMAutoDBInfo.colsMap.put("songAlbum", "TEXT");
    localStringBuilder.append(" songAlbum TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "songAlbumType";
    localMAutoDBInfo.colsMap.put("songAlbumType", "INTEGER");
    localStringBuilder.append(" songAlbumType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "songAlbumUrl";
    localMAutoDBInfo.colsMap.put("songAlbumUrl", "TEXT");
    localStringBuilder.append(" songAlbumUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "songHAlbumUrl";
    localMAutoDBInfo.colsMap.put("songHAlbumUrl", "TEXT");
    localStringBuilder.append(" songHAlbumUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "songAlbumLocalPath";
    localMAutoDBInfo.colsMap.put("songAlbumLocalPath", "TEXT");
    localStringBuilder.append(" songAlbumLocalPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "songWifiUrl";
    localMAutoDBInfo.colsMap.put("songWifiUrl", "TEXT");
    localStringBuilder.append(" songWifiUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "songWapLinkUrl";
    localMAutoDBInfo.colsMap.put("songWapLinkUrl", "TEXT");
    localStringBuilder.append(" songWapLinkUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "songWebUrl";
    localMAutoDBInfo.colsMap.put("songWebUrl", "TEXT");
    localStringBuilder.append(" songWebUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "songMediaId";
    localMAutoDBInfo.colsMap.put("songMediaId", "TEXT");
    localStringBuilder.append(" songMediaId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "songSnsAlbumUser";
    localMAutoDBInfo.colsMap.put("songSnsAlbumUser", "TEXT");
    localStringBuilder.append(" songSnsAlbumUser TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "songSnsShareUser";
    localMAutoDBInfo.colsMap.put("songSnsShareUser", "TEXT");
    localStringBuilder.append(" songSnsShareUser TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "songLyric";
    localMAutoDBInfo.colsMap.put("songLyric", "TEXT");
    localStringBuilder.append(" songLyric TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "songBgColor";
    localMAutoDBInfo.colsMap.put("songBgColor", "INTEGER");
    localStringBuilder.append(" songBgColor INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "songLyricColor";
    localMAutoDBInfo.colsMap.put("songLyricColor", "INTEGER");
    localStringBuilder.append(" songLyricColor INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "songFileLength";
    localMAutoDBInfo.colsMap.put("songFileLength", "LONG");
    localStringBuilder.append(" songFileLength LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "songWifiFileLength";
    localMAutoDBInfo.colsMap.put("songWifiFileLength", "LONG");
    localStringBuilder.append(" songWifiFileLength LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "hideBanner";
    localMAutoDBInfo.colsMap.put("hideBanner", "INTEGER");
    localStringBuilder.append(" hideBanner INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "jsWebUrlDomain";
    localMAutoDBInfo.colsMap.put("jsWebUrlDomain", "TEXT");
    localStringBuilder.append(" jsWebUrlDomain TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "isBlock";
    localMAutoDBInfo.colsMap.put("isBlock", "INTEGER");
    localStringBuilder.append(" isBlock INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "startTime";
    localMAutoDBInfo.colsMap.put("startTime", "INTEGER");
    localStringBuilder.append(" startTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "mimetype";
    localMAutoDBInfo.colsMap.put("mimetype", "TEXT");
    localStringBuilder.append(" mimetype TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[33] = "protocol";
    localMAutoDBInfo.colsMap.put("protocol", "TEXT");
    localStringBuilder.append(" protocol TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[34] = "barBackToWebView";
    localMAutoDBInfo.colsMap.put("barBackToWebView", "INTEGER");
    localStringBuilder.append(" barBackToWebView INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[35] = "musicbar_url";
    localMAutoDBInfo.colsMap.put("musicbar_url", "TEXT");
    localStringBuilder.append(" musicbar_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[36] = "srcUsername";
    localMAutoDBInfo.colsMap.put("srcUsername", "TEXT");
    localStringBuilder.append(" srcUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[37] = "playbackRate";
    localMAutoDBInfo.colsMap.put("playbackRate", "DOUBLE");
    localStringBuilder.append(" playbackRate DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[38] = "songMId";
    localMAutoDBInfo.colsMap.put("songMId", "TEXT");
    localStringBuilder.append(" songMId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[39] = "mid";
    localMAutoDBInfo.colsMap.put("mid", "TEXT");
    localStringBuilder.append(" mid TEXT");
    localMAutoDBInfo.columns[40] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramContentValues.containsKey("musicId"))
    {
      this.field_musicId = paramContentValues.getAsString("musicId");
      if (paramBoolean) {
        this.kMS = true;
      }
    }
    if (paramContentValues.containsKey("originMusicId"))
    {
      this.field_originMusicId = paramContentValues.getAsString("originMusicId");
      if (paramBoolean) {
        this.kMT = true;
      }
    }
    if (paramContentValues.containsKey("musicType"))
    {
      this.field_musicType = paramContentValues.getAsInteger("musicType").intValue();
      if (paramBoolean) {
        this.kMU = true;
      }
    }
    if (paramContentValues.containsKey("downloadedLength"))
    {
      this.field_downloadedLength = paramContentValues.getAsLong("downloadedLength").longValue();
      if (paramBoolean) {
        this.kMV = true;
      }
    }
    if (paramContentValues.containsKey("wifiDownloadedLength"))
    {
      this.field_wifiDownloadedLength = paramContentValues.getAsLong("wifiDownloadedLength").longValue();
      if (paramBoolean) {
        this.kMW = true;
      }
    }
    if (paramContentValues.containsKey("endFlag"))
    {
      this.field_endFlag = paramContentValues.getAsInteger("endFlag").intValue();
      if (paramBoolean) {
        this.kMX = true;
      }
    }
    if (paramContentValues.containsKey("wifiEndFlag"))
    {
      this.field_wifiEndFlag = paramContentValues.getAsInteger("wifiEndFlag").intValue();
      if (paramBoolean) {
        this.kMY = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("songId"))
    {
      this.field_songId = paramContentValues.getAsInteger("songId").intValue();
      if (paramBoolean) {
        this.kMZ = true;
      }
    }
    if (paramContentValues.containsKey("songName"))
    {
      this.field_songName = paramContentValues.getAsString("songName");
      if (paramBoolean) {
        this.kNa = true;
      }
    }
    if (paramContentValues.containsKey("songSinger"))
    {
      this.field_songSinger = paramContentValues.getAsString("songSinger");
      if (paramBoolean) {
        this.kNb = true;
      }
    }
    if (paramContentValues.containsKey("songAlbum"))
    {
      this.field_songAlbum = paramContentValues.getAsString("songAlbum");
      if (paramBoolean) {
        this.kNc = true;
      }
    }
    if (paramContentValues.containsKey("songAlbumType"))
    {
      this.field_songAlbumType = paramContentValues.getAsInteger("songAlbumType").intValue();
      if (paramBoolean) {
        this.kNd = true;
      }
    }
    if (paramContentValues.containsKey("songAlbumUrl"))
    {
      this.field_songAlbumUrl = paramContentValues.getAsString("songAlbumUrl");
      if (paramBoolean) {
        this.kNe = true;
      }
    }
    if (paramContentValues.containsKey("songHAlbumUrl"))
    {
      this.field_songHAlbumUrl = paramContentValues.getAsString("songHAlbumUrl");
      if (paramBoolean) {
        this.kNf = true;
      }
    }
    if (paramContentValues.containsKey("songAlbumLocalPath"))
    {
      this.field_songAlbumLocalPath = paramContentValues.getAsString("songAlbumLocalPath");
      if (paramBoolean) {
        this.kNg = true;
      }
    }
    if (paramContentValues.containsKey("songWifiUrl"))
    {
      this.field_songWifiUrl = paramContentValues.getAsString("songWifiUrl");
      if (paramBoolean) {
        this.kNh = true;
      }
    }
    if (paramContentValues.containsKey("songWapLinkUrl"))
    {
      this.field_songWapLinkUrl = paramContentValues.getAsString("songWapLinkUrl");
      if (paramBoolean) {
        this.kNi = true;
      }
    }
    if (paramContentValues.containsKey("songWebUrl"))
    {
      this.field_songWebUrl = paramContentValues.getAsString("songWebUrl");
      if (paramBoolean) {
        this.kNj = true;
      }
    }
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("songMediaId"))
    {
      this.field_songMediaId = paramContentValues.getAsString("songMediaId");
      if (paramBoolean) {
        this.kNk = true;
      }
    }
    if (paramContentValues.containsKey("songSnsAlbumUser"))
    {
      this.field_songSnsAlbumUser = paramContentValues.getAsString("songSnsAlbumUser");
      if (paramBoolean) {
        this.kNl = true;
      }
    }
    if (paramContentValues.containsKey("songSnsShareUser"))
    {
      this.field_songSnsShareUser = paramContentValues.getAsString("songSnsShareUser");
      if (paramBoolean) {
        this.kNm = true;
      }
    }
    if (paramContentValues.containsKey("songLyric"))
    {
      this.field_songLyric = paramContentValues.getAsString("songLyric");
      if (paramBoolean) {
        this.kNn = true;
      }
    }
    if (paramContentValues.containsKey("songBgColor"))
    {
      this.field_songBgColor = paramContentValues.getAsInteger("songBgColor").intValue();
      if (paramBoolean) {
        this.kNo = true;
      }
    }
    if (paramContentValues.containsKey("songLyricColor"))
    {
      this.field_songLyricColor = paramContentValues.getAsInteger("songLyricColor").intValue();
      if (paramBoolean) {
        this.kNp = true;
      }
    }
    if (paramContentValues.containsKey("songFileLength"))
    {
      this.field_songFileLength = paramContentValues.getAsLong("songFileLength").longValue();
      if (paramBoolean) {
        this.kNq = true;
      }
    }
    if (paramContentValues.containsKey("songWifiFileLength"))
    {
      this.field_songWifiFileLength = paramContentValues.getAsLong("songWifiFileLength").longValue();
      if (paramBoolean) {
        this.kNr = true;
      }
    }
    if (paramContentValues.containsKey("hideBanner")) {
      if (paramContentValues.getAsInteger("hideBanner").intValue() == 0) {
        break label1272;
      }
    }
    label1272:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.field_hideBanner = bool1;
      if (paramBoolean) {
        this.kNs = true;
      }
      if (paramContentValues.containsKey("jsWebUrlDomain"))
      {
        this.field_jsWebUrlDomain = paramContentValues.getAsString("jsWebUrlDomain");
        if (paramBoolean) {
          this.kNt = true;
        }
      }
      if (paramContentValues.containsKey("isBlock"))
      {
        this.field_isBlock = paramContentValues.getAsInteger("isBlock").intValue();
        if (paramBoolean) {
          this.kNu = true;
        }
      }
      if (paramContentValues.containsKey("startTime"))
      {
        this.field_startTime = paramContentValues.getAsInteger("startTime").intValue();
        if (paramBoolean) {
          this.jIR = true;
        }
      }
      if (paramContentValues.containsKey("mimetype"))
      {
        this.field_mimetype = paramContentValues.getAsString("mimetype");
        if (paramBoolean) {
          this.kNv = true;
        }
      }
      if (paramContentValues.containsKey("protocol"))
      {
        this.field_protocol = paramContentValues.getAsString("protocol");
        if (paramBoolean) {
          this.kNw = true;
        }
      }
      if (paramContentValues.containsKey("barBackToWebView"))
      {
        bool1 = bool2;
        if (paramContentValues.getAsInteger("barBackToWebView").intValue() != 0) {
          bool1 = true;
        }
        this.field_barBackToWebView = bool1;
        if (paramBoolean) {
          this.kNx = true;
        }
      }
      if (paramContentValues.containsKey("musicbar_url"))
      {
        this.field_musicbar_url = paramContentValues.getAsString("musicbar_url");
        if (paramBoolean) {
          this.kNy = true;
        }
      }
      if (paramContentValues.containsKey("srcUsername"))
      {
        this.field_srcUsername = paramContentValues.getAsString("srcUsername");
        if (paramBoolean) {
          this.kNz = true;
        }
      }
      if (paramContentValues.containsKey("playbackRate"))
      {
        this.field_playbackRate = paramContentValues.getAsDouble("playbackRate").doubleValue();
        if (paramBoolean) {
          this.kNA = true;
        }
      }
      if (paramContentValues.containsKey("songMId"))
      {
        this.field_songMId = paramContentValues.getAsString("songMId");
        if (paramBoolean) {
          this.kNB = true;
        }
      }
      if (paramContentValues.containsKey("mid"))
      {
        this.field_mid = paramContentValues.getAsString("mid");
        if (paramBoolean) {
          this.kNC = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
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
      if (kND != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.kMS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kNE == k)
      {
        this.field_originMusicId = paramCursor.getString(i);
      }
      else if (kNF == k)
      {
        this.field_musicType = paramCursor.getInt(i);
      }
      else if (kNG == k)
      {
        this.field_downloadedLength = paramCursor.getLong(i);
      }
      else if (kNH == k)
      {
        this.field_wifiDownloadedLength = paramCursor.getLong(i);
      }
      else if (kNI == k)
      {
        this.field_endFlag = paramCursor.getInt(i);
      }
      else if (kNJ == k)
      {
        this.field_wifiEndFlag = paramCursor.getInt(i);
      }
      else if (updateTime_HASHCODE == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (kNK == k)
      {
        this.field_songId = paramCursor.getInt(i);
      }
      else if (kNL == k)
      {
        this.field_songName = paramCursor.getString(i);
      }
      else if (kNM == k)
      {
        this.field_songSinger = paramCursor.getString(i);
      }
      else if (kNN == k)
      {
        this.field_songAlbum = paramCursor.getString(i);
      }
      else if (kNO == k)
      {
        this.field_songAlbumType = paramCursor.getInt(i);
      }
      else if (kNP == k)
      {
        this.field_songAlbumUrl = paramCursor.getString(i);
      }
      else if (kNQ == k)
      {
        this.field_songHAlbumUrl = paramCursor.getString(i);
      }
      else if (kNR == k)
      {
        this.field_songAlbumLocalPath = paramCursor.getString(i);
      }
      else if (kNS == k)
      {
        this.field_songWifiUrl = paramCursor.getString(i);
      }
      else if (kNT == k)
      {
        this.field_songWapLinkUrl = paramCursor.getString(i);
      }
      else if (kNU == k)
      {
        this.field_songWebUrl = paramCursor.getString(i);
      }
      else if (jKX == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (kNV == k)
      {
        this.field_songMediaId = paramCursor.getString(i);
      }
      else if (kNW == k)
      {
        this.field_songSnsAlbumUser = paramCursor.getString(i);
      }
      else if (kNX == k)
      {
        this.field_songSnsShareUser = paramCursor.getString(i);
      }
      else if (kNY == k)
      {
        this.field_songLyric = paramCursor.getString(i);
      }
      else if (kNZ == k)
      {
        this.field_songBgColor = paramCursor.getInt(i);
      }
      else if (kOa == k)
      {
        this.field_songLyricColor = paramCursor.getInt(i);
      }
      else if (kOb == k)
      {
        this.field_songFileLength = paramCursor.getLong(i);
      }
      else if (kOc == k)
      {
        this.field_songWifiFileLength = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (kOd == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hideBanner = bool;
            break;
          }
        }
        if (kOe == k)
        {
          this.field_jsWebUrlDomain = paramCursor.getString(i);
        }
        else if (kOf == k)
        {
          this.field_isBlock = paramCursor.getInt(i);
        }
        else if (jIY == k)
        {
          this.field_startTime = paramCursor.getInt(i);
        }
        else if (kOg == k)
        {
          this.field_mimetype = paramCursor.getString(i);
        }
        else if (kOh == k)
        {
          this.field_protocol = paramCursor.getString(i);
        }
        else
        {
          if (kOi == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_barBackToWebView = bool;
              break;
            }
          }
          if (kOj == k) {
            this.field_musicbar_url = paramCursor.getString(i);
          } else if (kOk == k) {
            this.field_srcUsername = paramCursor.getString(i);
          } else if (kOl == k) {
            this.field_playbackRate = paramCursor.getDouble(i);
          } else if (kOm == k) {
            this.field_songMId = paramCursor.getString(i);
          } else if (kOn == k) {
            this.field_mid = paramCursor.getString(i);
          } else if (rowid_HASHCODE == k) {
            this.systemRowid = paramCursor.getLong(i);
          }
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kMS) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.kMT) {
      localContentValues.put("originMusicId", this.field_originMusicId);
    }
    if (this.kMU) {
      localContentValues.put("musicType", Integer.valueOf(this.field_musicType));
    }
    if (this.kMV) {
      localContentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
    }
    if (this.kMW) {
      localContentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
    }
    if (this.kMX) {
      localContentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
    }
    if (this.kMY) {
      localContentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.kMZ) {
      localContentValues.put("songId", Integer.valueOf(this.field_songId));
    }
    if (this.kNa) {
      localContentValues.put("songName", this.field_songName);
    }
    if (this.kNb) {
      localContentValues.put("songSinger", this.field_songSinger);
    }
    if (this.kNc) {
      localContentValues.put("songAlbum", this.field_songAlbum);
    }
    if (this.kNd) {
      localContentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
    }
    if (this.kNe) {
      localContentValues.put("songAlbumUrl", this.field_songAlbumUrl);
    }
    if (this.kNf) {
      localContentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
    }
    if (this.kNg) {
      localContentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
    }
    if (this.kNh) {
      localContentValues.put("songWifiUrl", this.field_songWifiUrl);
    }
    if (this.kNi) {
      localContentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
    }
    if (this.kNj) {
      localContentValues.put("songWebUrl", this.field_songWebUrl);
    }
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.kNk) {
      localContentValues.put("songMediaId", this.field_songMediaId);
    }
    if (this.kNl) {
      localContentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
    }
    if (this.kNm) {
      localContentValues.put("songSnsShareUser", this.field_songSnsShareUser);
    }
    if (this.kNn) {
      localContentValues.put("songLyric", this.field_songLyric);
    }
    if (this.kNo) {
      localContentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
    }
    if (this.kNp) {
      localContentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
    }
    if (this.kNq) {
      localContentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
    }
    if (this.kNr) {
      localContentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
    }
    if (this.kNs) {
      localContentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
    }
    if (this.kNt) {
      localContentValues.put("jsWebUrlDomain", this.field_jsWebUrlDomain);
    }
    if (this.kNu) {
      localContentValues.put("isBlock", Integer.valueOf(this.field_isBlock));
    }
    if (this.jIR) {
      localContentValues.put("startTime", Integer.valueOf(this.field_startTime));
    }
    if (this.kNv) {
      localContentValues.put("mimetype", this.field_mimetype);
    }
    if (this.kNw) {
      localContentValues.put("protocol", this.field_protocol);
    }
    if (this.kNx) {
      localContentValues.put("barBackToWebView", Boolean.valueOf(this.field_barBackToWebView));
    }
    if (this.kNy) {
      localContentValues.put("musicbar_url", this.field_musicbar_url);
    }
    if (this.kNz) {
      localContentValues.put("srcUsername", this.field_srcUsername);
    }
    if (this.kNA) {
      localContentValues.put("playbackRate", Double.valueOf(this.field_playbackRate));
    }
    if (this.kNB) {
      localContentValues.put("songMId", this.field_songMId);
    }
    if (this.kNC) {
      localContentValues.put("mid", this.field_mid);
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
  
  public StorageObserverOwner<? extends fn> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_musicId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.fn
 * JD-Core Version:    0.7.0.1
 */