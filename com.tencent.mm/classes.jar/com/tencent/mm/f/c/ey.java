package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ey
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("Music");
  public static final Column hmH;
  private static final int hmV = "startTime".hashCode();
  public static final Column hnz;
  private static final int hoh;
  public static final Column imA;
  public static final Column imB;
  public static final Column imC;
  public static final Column imD;
  public static final Column imE;
  public static final Column imF;
  public static final Column imG;
  public static final Column imH;
  public static final Column imI;
  public static final Column imJ;
  public static final Column imK;
  public static final Column imL;
  public static final Column imM;
  public static final Column imN;
  public static final Column imO;
  public static final Column imP;
  public static final Column imQ;
  public static final Column imR;
  public static final Column imi;
  public static final Column imj;
  public static final Column imk;
  public static final Column iml;
  public static final Column imm;
  public static final Column imn;
  public static final Column imo;
  public static final Column imp;
  public static final Column imq;
  public static final Column imr;
  public static final Column ims;
  public static final Column imt;
  public static final Column imu;
  public static final Column imv;
  public static final Column imw;
  public static final Column imx;
  public static final Column imy;
  public static final Column imz;
  private static final int inC;
  private static final int inD;
  private static final int inE;
  private static final int inF;
  private static final int inG;
  private static final int inH;
  private static final int inI;
  private static final int inJ;
  private static final int inK;
  private static final int inL;
  private static final int inM;
  private static final int inN;
  private static final int inO;
  private static final int inP;
  private static final int inQ;
  private static final int inR;
  private static final int inS;
  private static final int inT;
  private static final int inU;
  private static final int inV;
  private static final int inW;
  private static final int inX;
  private static final int inY;
  private static final int inZ;
  private static final int ioa;
  private static final int iob;
  private static final int ioc;
  private static final int iod;
  private static final int ioe;
  private static final int iof = "mimetype".hashCode();
  private static final int iog = "protocol".hashCode();
  private static final int ioh = "barBackToWebView".hashCode();
  private static final int ioi = "musicbar_url".hashCode();
  private static final int ioj = "srcUsername".hashCode();
  private static final int iok = "playbackRate".hashCode();
  private static final int iol = "songMId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public String field_appId;
  public boolean field_barBackToWebView;
  public long field_downloadedLength;
  public int field_endFlag;
  public boolean field_hideBanner;
  public int field_isBlock;
  public String field_jsWebUrlDomain;
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
  private boolean hmO = true;
  private boolean hnQ = true;
  private boolean imS = true;
  private boolean imT = true;
  private boolean imU = true;
  private boolean imV = true;
  private boolean imW = true;
  private boolean imX = true;
  private boolean imY = true;
  private boolean imZ = true;
  private boolean inA = true;
  private boolean inB = true;
  private boolean ina = true;
  private boolean inb = true;
  private boolean inc = true;
  private boolean ind = true;
  private boolean ine = true;
  private boolean inf = true;
  private boolean ing = true;
  private boolean inh = true;
  private boolean ini = true;
  private boolean inj = true;
  private boolean ink = true;
  private boolean inl = true;
  private boolean inm = true;
  private boolean inn = true;
  private boolean ino = true;
  private boolean inp = true;
  private boolean inq = true;
  private boolean inr = true;
  private boolean ins = true;
  private boolean jdField_int = true;
  private boolean inu = true;
  private boolean inv = true;
  private boolean inw = true;
  private boolean inx = true;
  private boolean iny = true;
  private boolean inz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "Music", "");
    imi = new Column("musicid", "string", "Music", "");
    imj = new Column("originmusicid", "string", "Music", "");
    imk = new Column("musictype", "jdField_int", "Music", "");
    iml = new Column("downloadedlength", "long", "Music", "");
    imm = new Column("wifidownloadedlength", "long", "Music", "");
    imn = new Column("endflag", "jdField_int", "Music", "");
    imo = new Column("wifiendflag", "jdField_int", "Music", "");
    C_UPDATETIME = new Column("updatetime", "long", "Music", "");
    imp = new Column("songid", "jdField_int", "Music", "");
    imq = new Column("songname", "string", "Music", "");
    imr = new Column("songsinger", "string", "Music", "");
    ims = new Column("songalbum", "string", "Music", "");
    imt = new Column("songalbumtype", "jdField_int", "Music", "");
    imu = new Column("songalbumurl", "string", "Music", "");
    imv = new Column("songhalbumurl", "string", "Music", "");
    imw = new Column("songalbumlocalpath", "string", "Music", "");
    imx = new Column("songwifiurl", "string", "Music", "");
    imy = new Column("songwaplinkurl", "string", "Music", "");
    imz = new Column("songweburl", "string", "Music", "");
    hnz = new Column("appid", "string", "Music", "");
    imA = new Column("songmediaid", "string", "Music", "");
    imB = new Column("songsnsalbumuser", "string", "Music", "");
    imC = new Column("songsnsshareuser", "string", "Music", "");
    imD = new Column("songlyric", "string", "Music", "");
    imE = new Column("songbgcolor", "jdField_int", "Music", "");
    imF = new Column("songlyriccolor", "jdField_int", "Music", "");
    imG = new Column("songfilelength", "long", "Music", "");
    imH = new Column("songwififilelength", "long", "Music", "");
    imI = new Column("hidebanner", "boolean", "Music", "");
    imJ = new Column("jsweburldomain", "string", "Music", "");
    imK = new Column("isblock", "jdField_int", "Music", "");
    hmH = new Column("starttime", "jdField_int", "Music", "");
    imL = new Column("mimetype", "string", "Music", "");
    imM = new Column("protocol", "string", "Music", "");
    imN = new Column("barbacktowebview", "boolean", "Music", "");
    imO = new Column("musicbar_url", "string", "Music", "");
    imP = new Column("srcusername", "string", "Music", "");
    imQ = new Column("playbackrate", "double", "Music", "");
    imR = new Column("songmid", "string", "Music", "");
    inC = "musicId".hashCode();
    inD = "originMusicId".hashCode();
    inE = "musicType".hashCode();
    inF = "downloadedLength".hashCode();
    inG = "wifiDownloadedLength".hashCode();
    inH = "endFlag".hashCode();
    inI = "wifiEndFlag".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    inJ = "songId".hashCode();
    inK = "songName".hashCode();
    inL = "songSinger".hashCode();
    inM = "songAlbum".hashCode();
    inN = "songAlbumType".hashCode();
    inO = "songAlbumUrl".hashCode();
    inP = "songHAlbumUrl".hashCode();
    inQ = "songAlbumLocalPath".hashCode();
    inR = "songWifiUrl".hashCode();
    inS = "songWapLinkUrl".hashCode();
    inT = "songWebUrl".hashCode();
    hoh = "appId".hashCode();
    inU = "songMediaId".hashCode();
    inV = "songSnsAlbumUser".hashCode();
    inW = "songSnsShareUser".hashCode();
    inX = "songLyric".hashCode();
    inY = "songBgColor".hashCode();
    inZ = "songLyricColor".hashCode();
    ioa = "songFileLength".hashCode();
    iob = "songWifiFileLength".hashCode();
    ioc = "hideBanner".hashCode();
    iod = "jsWebUrlDomain".hashCode();
    ioe = "isBlock".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[39];
    localMAutoDBInfo.columns = new String[40];
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
    localMAutoDBInfo.columns[39] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (inC != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.imS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (inD == k)
      {
        this.field_originMusicId = paramCursor.getString(i);
      }
      else if (inE == k)
      {
        this.field_musicType = paramCursor.getInt(i);
      }
      else if (inF == k)
      {
        this.field_downloadedLength = paramCursor.getLong(i);
      }
      else if (inG == k)
      {
        this.field_wifiDownloadedLength = paramCursor.getLong(i);
      }
      else if (inH == k)
      {
        this.field_endFlag = paramCursor.getInt(i);
      }
      else if (inI == k)
      {
        this.field_wifiEndFlag = paramCursor.getInt(i);
      }
      else if (updateTime_HASHCODE == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (inJ == k)
      {
        this.field_songId = paramCursor.getInt(i);
      }
      else if (inK == k)
      {
        this.field_songName = paramCursor.getString(i);
      }
      else if (inL == k)
      {
        this.field_songSinger = paramCursor.getString(i);
      }
      else if (inM == k)
      {
        this.field_songAlbum = paramCursor.getString(i);
      }
      else if (inN == k)
      {
        this.field_songAlbumType = paramCursor.getInt(i);
      }
      else if (inO == k)
      {
        this.field_songAlbumUrl = paramCursor.getString(i);
      }
      else if (inP == k)
      {
        this.field_songHAlbumUrl = paramCursor.getString(i);
      }
      else if (inQ == k)
      {
        this.field_songAlbumLocalPath = paramCursor.getString(i);
      }
      else if (inR == k)
      {
        this.field_songWifiUrl = paramCursor.getString(i);
      }
      else if (inS == k)
      {
        this.field_songWapLinkUrl = paramCursor.getString(i);
      }
      else if (inT == k)
      {
        this.field_songWebUrl = paramCursor.getString(i);
      }
      else if (hoh == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (inU == k)
      {
        this.field_songMediaId = paramCursor.getString(i);
      }
      else if (inV == k)
      {
        this.field_songSnsAlbumUser = paramCursor.getString(i);
      }
      else if (inW == k)
      {
        this.field_songSnsShareUser = paramCursor.getString(i);
      }
      else if (inX == k)
      {
        this.field_songLyric = paramCursor.getString(i);
      }
      else if (inY == k)
      {
        this.field_songBgColor = paramCursor.getInt(i);
      }
      else if (inZ == k)
      {
        this.field_songLyricColor = paramCursor.getInt(i);
      }
      else if (ioa == k)
      {
        this.field_songFileLength = paramCursor.getLong(i);
      }
      else if (iob == k)
      {
        this.field_songWifiFileLength = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (ioc == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hideBanner = bool;
            break;
          }
        }
        if (iod == k)
        {
          this.field_jsWebUrlDomain = paramCursor.getString(i);
        }
        else if (ioe == k)
        {
          this.field_isBlock = paramCursor.getInt(i);
        }
        else if (hmV == k)
        {
          this.field_startTime = paramCursor.getInt(i);
        }
        else if (iof == k)
        {
          this.field_mimetype = paramCursor.getString(i);
        }
        else if (iog == k)
        {
          this.field_protocol = paramCursor.getString(i);
        }
        else
        {
          if (ioh == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_barBackToWebView = bool;
              break;
            }
          }
          if (ioi == k) {
            this.field_musicbar_url = paramCursor.getString(i);
          } else if (ioj == k) {
            this.field_srcUsername = paramCursor.getString(i);
          } else if (iok == k) {
            this.field_playbackRate = paramCursor.getDouble(i);
          } else if (iol == k) {
            this.field_songMId = paramCursor.getString(i);
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
    if (this.imS) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.imT) {
      localContentValues.put("originMusicId", this.field_originMusicId);
    }
    if (this.imU) {
      localContentValues.put("musicType", Integer.valueOf(this.field_musicType));
    }
    if (this.imV) {
      localContentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
    }
    if (this.imW) {
      localContentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
    }
    if (this.imX) {
      localContentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
    }
    if (this.imY) {
      localContentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.imZ) {
      localContentValues.put("songId", Integer.valueOf(this.field_songId));
    }
    if (this.ina) {
      localContentValues.put("songName", this.field_songName);
    }
    if (this.inb) {
      localContentValues.put("songSinger", this.field_songSinger);
    }
    if (this.inc) {
      localContentValues.put("songAlbum", this.field_songAlbum);
    }
    if (this.ind) {
      localContentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
    }
    if (this.ine) {
      localContentValues.put("songAlbumUrl", this.field_songAlbumUrl);
    }
    if (this.inf) {
      localContentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
    }
    if (this.ing) {
      localContentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
    }
    if (this.inh) {
      localContentValues.put("songWifiUrl", this.field_songWifiUrl);
    }
    if (this.ini) {
      localContentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
    }
    if (this.inj) {
      localContentValues.put("songWebUrl", this.field_songWebUrl);
    }
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.ink) {
      localContentValues.put("songMediaId", this.field_songMediaId);
    }
    if (this.inl) {
      localContentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
    }
    if (this.inm) {
      localContentValues.put("songSnsShareUser", this.field_songSnsShareUser);
    }
    if (this.inn) {
      localContentValues.put("songLyric", this.field_songLyric);
    }
    if (this.ino) {
      localContentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
    }
    if (this.inp) {
      localContentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
    }
    if (this.inq) {
      localContentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
    }
    if (this.inr) {
      localContentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
    }
    if (this.ins) {
      localContentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
    }
    if (this.jdField_int) {
      localContentValues.put("jsWebUrlDomain", this.field_jsWebUrlDomain);
    }
    if (this.inu) {
      localContentValues.put("isBlock", Integer.valueOf(this.field_isBlock));
    }
    if (this.hmO) {
      localContentValues.put("startTime", Integer.valueOf(this.field_startTime));
    }
    if (this.inv) {
      localContentValues.put("mimetype", this.field_mimetype);
    }
    if (this.inw) {
      localContentValues.put("protocol", this.field_protocol);
    }
    if (this.inx) {
      localContentValues.put("barBackToWebView", Boolean.valueOf(this.field_barBackToWebView));
    }
    if (this.iny) {
      localContentValues.put("musicbar_url", this.field_musicbar_url);
    }
    if (this.inz) {
      localContentValues.put("srcUsername", this.field_srcUsername);
    }
    if (this.inA) {
      localContentValues.put("playbackRate", Double.valueOf(this.field_playbackRate));
    }
    if (this.inB) {
      localContentValues.put("songMId", this.field_songMId);
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
    return "Music";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.ey
 * JD-Core Version:    0.7.0.1
 */