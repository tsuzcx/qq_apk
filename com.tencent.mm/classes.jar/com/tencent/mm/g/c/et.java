package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class et
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fSA;
  private static final int fSB;
  private static final int fSC;
  private static final int fSD;
  private static final int fSE;
  private static final int fSF;
  private static final int fSG;
  private static final int fSH;
  private static final int fSI;
  private static final int fSJ;
  private static final int fSK;
  private static final int fSL;
  private static final int fSM;
  private static final int fSN;
  private static final int fSO;
  private static final int fSP;
  private static final int fSQ = "mimetype".hashCode();
  private static final int fSR = "protocol".hashCode();
  private static final int fSS = "barBackToWebView".hashCode();
  private static final int fST = "musicbar_url".hashCode();
  private static final int fSU = "srcUsername".hashCode();
  private static final int fSV = "playbackRate".hashCode();
  private static final int fSW = "songMId".hashCode();
  private static final int fSn = "musicId".hashCode();
  private static final int fSo = "originMusicId".hashCode();
  private static final int fSp = "musicType".hashCode();
  private static final int fSq = "downloadedLength".hashCode();
  private static final int fSr = "wifiDownloadedLength".hashCode();
  private static final int fSs = "endFlag".hashCode();
  private static final int fSt = "wifiEndFlag".hashCode();
  private static final int fSu;
  private static final int fSv;
  private static final int fSw;
  private static final int fSx;
  private static final int fSy;
  private static final int fSz;
  private static final int fjx;
  private static final int fkj;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE = "updateTime".hashCode();
  private boolean __hadSetupdateTime = true;
  private boolean fRD = true;
  private boolean fRE = true;
  private boolean fRF = true;
  private boolean fRG = true;
  private boolean fRH = true;
  private boolean fRI = true;
  private boolean fRJ = true;
  private boolean fRK = true;
  private boolean fRL = true;
  private boolean fRM = true;
  private boolean fRN = true;
  private boolean fRO = true;
  private boolean fRP = true;
  private boolean fRQ = true;
  private boolean fRR = true;
  private boolean fRS = true;
  private boolean fRT = true;
  private boolean fRU = true;
  private boolean fRV = true;
  private boolean fRW = true;
  private boolean fRX = true;
  private boolean fRY = true;
  private boolean fRZ = true;
  private boolean fSa = true;
  private boolean fSb = true;
  private boolean fSc = true;
  private boolean fSd = true;
  private boolean fSe = true;
  private boolean fSf = true;
  private boolean fSg = true;
  private boolean fSh = true;
  private boolean fSi = true;
  private boolean fSj = true;
  private boolean fSk = true;
  private boolean fSl = true;
  private boolean fSm = true;
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
  private boolean fjS = true;
  private boolean fjq = true;
  
  static
  {
    fSu = "songId".hashCode();
    fSv = "songName".hashCode();
    fSw = "songSinger".hashCode();
    fSx = "songAlbum".hashCode();
    fSy = "songAlbumType".hashCode();
    fSz = "songAlbumUrl".hashCode();
    fSA = "songHAlbumUrl".hashCode();
    fSB = "songAlbumLocalPath".hashCode();
    fSC = "songWifiUrl".hashCode();
    fSD = "songWapLinkUrl".hashCode();
    fSE = "songWebUrl".hashCode();
    fkj = "appId".hashCode();
    fSF = "songMediaId".hashCode();
    fSG = "songSnsAlbumUser".hashCode();
    fSH = "songSnsShareUser".hashCode();
    fSI = "songLyric".hashCode();
    fSJ = "songBgColor".hashCode();
    fSK = "songLyricColor".hashCode();
    fSL = "songFileLength".hashCode();
    fSM = "songWifiFileLength".hashCode();
    fSN = "hideBanner".hashCode();
    fSO = "jsWebUrlDomain".hashCode();
    fSP = "isBlock".hashCode();
    fjx = "startTime".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      if (fSn != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.fRD = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fSo == k)
      {
        this.field_originMusicId = paramCursor.getString(i);
      }
      else if (fSp == k)
      {
        this.field_musicType = paramCursor.getInt(i);
      }
      else if (fSq == k)
      {
        this.field_downloadedLength = paramCursor.getLong(i);
      }
      else if (fSr == k)
      {
        this.field_wifiDownloadedLength = paramCursor.getLong(i);
      }
      else if (fSs == k)
      {
        this.field_endFlag = paramCursor.getInt(i);
      }
      else if (fSt == k)
      {
        this.field_wifiEndFlag = paramCursor.getInt(i);
      }
      else if (updateTime_HASHCODE == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (fSu == k)
      {
        this.field_songId = paramCursor.getInt(i);
      }
      else if (fSv == k)
      {
        this.field_songName = paramCursor.getString(i);
      }
      else if (fSw == k)
      {
        this.field_songSinger = paramCursor.getString(i);
      }
      else if (fSx == k)
      {
        this.field_songAlbum = paramCursor.getString(i);
      }
      else if (fSy == k)
      {
        this.field_songAlbumType = paramCursor.getInt(i);
      }
      else if (fSz == k)
      {
        this.field_songAlbumUrl = paramCursor.getString(i);
      }
      else if (fSA == k)
      {
        this.field_songHAlbumUrl = paramCursor.getString(i);
      }
      else if (fSB == k)
      {
        this.field_songAlbumLocalPath = paramCursor.getString(i);
      }
      else if (fSC == k)
      {
        this.field_songWifiUrl = paramCursor.getString(i);
      }
      else if (fSD == k)
      {
        this.field_songWapLinkUrl = paramCursor.getString(i);
      }
      else if (fSE == k)
      {
        this.field_songWebUrl = paramCursor.getString(i);
      }
      else if (fkj == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (fSF == k)
      {
        this.field_songMediaId = paramCursor.getString(i);
      }
      else if (fSG == k)
      {
        this.field_songSnsAlbumUser = paramCursor.getString(i);
      }
      else if (fSH == k)
      {
        this.field_songSnsShareUser = paramCursor.getString(i);
      }
      else if (fSI == k)
      {
        this.field_songLyric = paramCursor.getString(i);
      }
      else if (fSJ == k)
      {
        this.field_songBgColor = paramCursor.getInt(i);
      }
      else if (fSK == k)
      {
        this.field_songLyricColor = paramCursor.getInt(i);
      }
      else if (fSL == k)
      {
        this.field_songFileLength = paramCursor.getLong(i);
      }
      else if (fSM == k)
      {
        this.field_songWifiFileLength = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (fSN == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hideBanner = bool;
            break;
          }
        }
        if (fSO == k)
        {
          this.field_jsWebUrlDomain = paramCursor.getString(i);
        }
        else if (fSP == k)
        {
          this.field_isBlock = paramCursor.getInt(i);
        }
        else if (fjx == k)
        {
          this.field_startTime = paramCursor.getInt(i);
        }
        else if (fSQ == k)
        {
          this.field_mimetype = paramCursor.getString(i);
        }
        else if (fSR == k)
        {
          this.field_protocol = paramCursor.getString(i);
        }
        else
        {
          if (fSS == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_barBackToWebView = bool;
              break;
            }
          }
          if (fST == k) {
            this.field_musicbar_url = paramCursor.getString(i);
          } else if (fSU == k) {
            this.field_srcUsername = paramCursor.getString(i);
          } else if (fSV == k) {
            this.field_playbackRate = paramCursor.getDouble(i);
          } else if (fSW == k) {
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
    if (this.fRD) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.fRE) {
      localContentValues.put("originMusicId", this.field_originMusicId);
    }
    if (this.fRF) {
      localContentValues.put("musicType", Integer.valueOf(this.field_musicType));
    }
    if (this.fRG) {
      localContentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
    }
    if (this.fRH) {
      localContentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
    }
    if (this.fRI) {
      localContentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
    }
    if (this.fRJ) {
      localContentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fRK) {
      localContentValues.put("songId", Integer.valueOf(this.field_songId));
    }
    if (this.fRL) {
      localContentValues.put("songName", this.field_songName);
    }
    if (this.fRM) {
      localContentValues.put("songSinger", this.field_songSinger);
    }
    if (this.fRN) {
      localContentValues.put("songAlbum", this.field_songAlbum);
    }
    if (this.fRO) {
      localContentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
    }
    if (this.fRP) {
      localContentValues.put("songAlbumUrl", this.field_songAlbumUrl);
    }
    if (this.fRQ) {
      localContentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
    }
    if (this.fRR) {
      localContentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
    }
    if (this.fRS) {
      localContentValues.put("songWifiUrl", this.field_songWifiUrl);
    }
    if (this.fRT) {
      localContentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
    }
    if (this.fRU) {
      localContentValues.put("songWebUrl", this.field_songWebUrl);
    }
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fRV) {
      localContentValues.put("songMediaId", this.field_songMediaId);
    }
    if (this.fRW) {
      localContentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
    }
    if (this.fRX) {
      localContentValues.put("songSnsShareUser", this.field_songSnsShareUser);
    }
    if (this.fRY) {
      localContentValues.put("songLyric", this.field_songLyric);
    }
    if (this.fRZ) {
      localContentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
    }
    if (this.fSa) {
      localContentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
    }
    if (this.fSb) {
      localContentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
    }
    if (this.fSc) {
      localContentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
    }
    if (this.fSd) {
      localContentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
    }
    if (this.fSe) {
      localContentValues.put("jsWebUrlDomain", this.field_jsWebUrlDomain);
    }
    if (this.fSf) {
      localContentValues.put("isBlock", Integer.valueOf(this.field_isBlock));
    }
    if (this.fjq) {
      localContentValues.put("startTime", Integer.valueOf(this.field_startTime));
    }
    if (this.fSg) {
      localContentValues.put("mimetype", this.field_mimetype);
    }
    if (this.fSh) {
      localContentValues.put("protocol", this.field_protocol);
    }
    if (this.fSi) {
      localContentValues.put("barBackToWebView", Boolean.valueOf(this.field_barBackToWebView));
    }
    if (this.fSj) {
      localContentValues.put("musicbar_url", this.field_musicbar_url);
    }
    if (this.fSk) {
      localContentValues.put("srcUsername", this.field_srcUsername);
    }
    if (this.fSl) {
      localContentValues.put("playbackRate", Double.valueOf(this.field_playbackRate));
    }
    if (this.fSm) {
      localContentValues.put("songMId", this.field_songMId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.et
 * JD-Core Version:    0.7.0.1
 */