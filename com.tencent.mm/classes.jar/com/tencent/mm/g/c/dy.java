package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class dy
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eQA;
  private static final int eQB;
  private static final int eQC;
  private static final int eQD;
  private static final int eQE;
  private static final int eQF;
  private static final int eQG;
  private static final int eQH;
  private static final int eQI;
  private static final int eQJ;
  private static final int eQK;
  private static final int eQL;
  private static final int eQM = "mimetype".hashCode();
  private static final int eQN = "protocol".hashCode();
  private static final int eQO = "barBackToWebView".hashCode();
  private static final int eQP = "musicbar_url".hashCode();
  private static final int eQQ = "srcUsername".hashCode();
  private static final int eQR = "playbackRate".hashCode();
  private static final int eQj = "musicId".hashCode();
  private static final int eQk = "originMusicId".hashCode();
  private static final int eQl = "musicType".hashCode();
  private static final int eQm = "downloadedLength".hashCode();
  private static final int eQn = "wifiDownloadedLength".hashCode();
  private static final int eQo = "endFlag".hashCode();
  private static final int eQp = "wifiEndFlag".hashCode();
  private static final int eQq;
  private static final int eQr;
  private static final int eQs;
  private static final int eQt;
  private static final int eQu;
  private static final int eQv;
  private static final int eQw;
  private static final int eQx;
  private static final int eQy;
  private static final int eQz;
  private static final int ekd;
  private static final int elJ;
  private static final int emf = "updateTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ePA = true;
  private boolean ePB = true;
  private boolean ePC = true;
  private boolean ePD = true;
  private boolean ePE = true;
  private boolean ePF = true;
  private boolean ePG = true;
  private boolean ePH = true;
  private boolean ePI = true;
  private boolean ePJ = true;
  private boolean ePK = true;
  private boolean ePL = true;
  private boolean ePM = true;
  private boolean ePN = true;
  private boolean ePO = true;
  private boolean ePP = true;
  private boolean ePQ = true;
  private boolean ePR = true;
  private boolean ePS = true;
  private boolean ePT = true;
  private boolean ePU = true;
  private boolean ePV = true;
  private boolean ePW = true;
  private boolean ePX = true;
  private boolean ePY = true;
  private boolean ePZ = true;
  private boolean eQa = true;
  private boolean eQb = true;
  private boolean eQc = true;
  private boolean eQd = true;
  private boolean eQe = true;
  private boolean eQf = true;
  private boolean eQg = true;
  private boolean eQh = true;
  private boolean eQi = true;
  private boolean ejW = true;
  private boolean els = true;
  private boolean emc = true;
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
  
  static
  {
    eQq = "songId".hashCode();
    eQr = "songName".hashCode();
    eQs = "songSinger".hashCode();
    eQt = "songAlbum".hashCode();
    eQu = "songAlbumType".hashCode();
    eQv = "songAlbumUrl".hashCode();
    eQw = "songHAlbumUrl".hashCode();
    eQx = "songAlbumLocalPath".hashCode();
    eQy = "songWifiUrl".hashCode();
    eQz = "songWapLinkUrl".hashCode();
    eQA = "songWebUrl".hashCode();
    elJ = "appId".hashCode();
    eQB = "songMediaId".hashCode();
    eQC = "songSnsAlbumUser".hashCode();
    eQD = "songSnsShareUser".hashCode();
    eQE = "songLyric".hashCode();
    eQF = "songBgColor".hashCode();
    eQG = "songLyricColor".hashCode();
    eQH = "songFileLength".hashCode();
    eQI = "songWifiFileLength".hashCode();
    eQJ = "hideBanner".hashCode();
    eQK = "jsWebUrlDomain".hashCode();
    eQL = "isBlock".hashCode();
    ekd = "startTime".hashCode();
  }
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[38];
    locala.columns = new String[39];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "musicId";
    locala.EYv.put("musicId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" musicId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "musicId";
    locala.columns[1] = "originMusicId";
    locala.EYv.put("originMusicId", "TEXT");
    localStringBuilder.append(" originMusicId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "musicType";
    locala.EYv.put("musicType", "INTEGER");
    localStringBuilder.append(" musicType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "downloadedLength";
    locala.EYv.put("downloadedLength", "LONG");
    localStringBuilder.append(" downloadedLength LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "wifiDownloadedLength";
    locala.EYv.put("wifiDownloadedLength", "LONG");
    localStringBuilder.append(" wifiDownloadedLength LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "endFlag";
    locala.EYv.put("endFlag", "INTEGER");
    localStringBuilder.append(" endFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "wifiEndFlag";
    locala.EYv.put("wifiEndFlag", "INTEGER");
    localStringBuilder.append(" wifiEndFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "updateTime";
    locala.EYv.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "songId";
    locala.EYv.put("songId", "INTEGER");
    localStringBuilder.append(" songId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "songName";
    locala.EYv.put("songName", "TEXT");
    localStringBuilder.append(" songName TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "songSinger";
    locala.EYv.put("songSinger", "TEXT");
    localStringBuilder.append(" songSinger TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "songAlbum";
    locala.EYv.put("songAlbum", "TEXT");
    localStringBuilder.append(" songAlbum TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "songAlbumType";
    locala.EYv.put("songAlbumType", "INTEGER");
    localStringBuilder.append(" songAlbumType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "songAlbumUrl";
    locala.EYv.put("songAlbumUrl", "TEXT");
    localStringBuilder.append(" songAlbumUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "songHAlbumUrl";
    locala.EYv.put("songHAlbumUrl", "TEXT");
    localStringBuilder.append(" songHAlbumUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "songAlbumLocalPath";
    locala.EYv.put("songAlbumLocalPath", "TEXT");
    localStringBuilder.append(" songAlbumLocalPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "songWifiUrl";
    locala.EYv.put("songWifiUrl", "TEXT");
    localStringBuilder.append(" songWifiUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "songWapLinkUrl";
    locala.EYv.put("songWapLinkUrl", "TEXT");
    localStringBuilder.append(" songWapLinkUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "songWebUrl";
    locala.EYv.put("songWebUrl", "TEXT");
    localStringBuilder.append(" songWebUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "appId";
    locala.EYv.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "songMediaId";
    locala.EYv.put("songMediaId", "TEXT");
    localStringBuilder.append(" songMediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "songSnsAlbumUser";
    locala.EYv.put("songSnsAlbumUser", "TEXT");
    localStringBuilder.append(" songSnsAlbumUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "songSnsShareUser";
    locala.EYv.put("songSnsShareUser", "TEXT");
    localStringBuilder.append(" songSnsShareUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "songLyric";
    locala.EYv.put("songLyric", "TEXT");
    localStringBuilder.append(" songLyric TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "songBgColor";
    locala.EYv.put("songBgColor", "INTEGER");
    localStringBuilder.append(" songBgColor INTEGER");
    localStringBuilder.append(", ");
    locala.columns[25] = "songLyricColor";
    locala.EYv.put("songLyricColor", "INTEGER");
    localStringBuilder.append(" songLyricColor INTEGER");
    localStringBuilder.append(", ");
    locala.columns[26] = "songFileLength";
    locala.EYv.put("songFileLength", "LONG");
    localStringBuilder.append(" songFileLength LONG");
    localStringBuilder.append(", ");
    locala.columns[27] = "songWifiFileLength";
    locala.EYv.put("songWifiFileLength", "LONG");
    localStringBuilder.append(" songWifiFileLength LONG");
    localStringBuilder.append(", ");
    locala.columns[28] = "hideBanner";
    locala.EYv.put("hideBanner", "INTEGER");
    localStringBuilder.append(" hideBanner INTEGER");
    localStringBuilder.append(", ");
    locala.columns[29] = "jsWebUrlDomain";
    locala.EYv.put("jsWebUrlDomain", "TEXT");
    localStringBuilder.append(" jsWebUrlDomain TEXT");
    localStringBuilder.append(", ");
    locala.columns[30] = "isBlock";
    locala.EYv.put("isBlock", "INTEGER");
    localStringBuilder.append(" isBlock INTEGER");
    localStringBuilder.append(", ");
    locala.columns[31] = "startTime";
    locala.EYv.put("startTime", "INTEGER");
    localStringBuilder.append(" startTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[32] = "mimetype";
    locala.EYv.put("mimetype", "TEXT");
    localStringBuilder.append(" mimetype TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "protocol";
    locala.EYv.put("protocol", "TEXT");
    localStringBuilder.append(" protocol TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "barBackToWebView";
    locala.EYv.put("barBackToWebView", "INTEGER");
    localStringBuilder.append(" barBackToWebView INTEGER");
    localStringBuilder.append(", ");
    locala.columns[35] = "musicbar_url";
    locala.EYv.put("musicbar_url", "TEXT");
    localStringBuilder.append(" musicbar_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[36] = "srcUsername";
    locala.EYv.put("srcUsername", "TEXT");
    localStringBuilder.append(" srcUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[37] = "playbackRate";
    locala.EYv.put("playbackRate", "DOUBLE");
    localStringBuilder.append(" playbackRate DOUBLE");
    locala.columns[38] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
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
      if (eQj != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.ePA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eQk == k)
      {
        this.field_originMusicId = paramCursor.getString(i);
      }
      else if (eQl == k)
      {
        this.field_musicType = paramCursor.getInt(i);
      }
      else if (eQm == k)
      {
        this.field_downloadedLength = paramCursor.getLong(i);
      }
      else if (eQn == k)
      {
        this.field_wifiDownloadedLength = paramCursor.getLong(i);
      }
      else if (eQo == k)
      {
        this.field_endFlag = paramCursor.getInt(i);
      }
      else if (eQp == k)
      {
        this.field_wifiEndFlag = paramCursor.getInt(i);
      }
      else if (emf == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (eQq == k)
      {
        this.field_songId = paramCursor.getInt(i);
      }
      else if (eQr == k)
      {
        this.field_songName = paramCursor.getString(i);
      }
      else if (eQs == k)
      {
        this.field_songSinger = paramCursor.getString(i);
      }
      else if (eQt == k)
      {
        this.field_songAlbum = paramCursor.getString(i);
      }
      else if (eQu == k)
      {
        this.field_songAlbumType = paramCursor.getInt(i);
      }
      else if (eQv == k)
      {
        this.field_songAlbumUrl = paramCursor.getString(i);
      }
      else if (eQw == k)
      {
        this.field_songHAlbumUrl = paramCursor.getString(i);
      }
      else if (eQx == k)
      {
        this.field_songAlbumLocalPath = paramCursor.getString(i);
      }
      else if (eQy == k)
      {
        this.field_songWifiUrl = paramCursor.getString(i);
      }
      else if (eQz == k)
      {
        this.field_songWapLinkUrl = paramCursor.getString(i);
      }
      else if (eQA == k)
      {
        this.field_songWebUrl = paramCursor.getString(i);
      }
      else if (elJ == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (eQB == k)
      {
        this.field_songMediaId = paramCursor.getString(i);
      }
      else if (eQC == k)
      {
        this.field_songSnsAlbumUser = paramCursor.getString(i);
      }
      else if (eQD == k)
      {
        this.field_songSnsShareUser = paramCursor.getString(i);
      }
      else if (eQE == k)
      {
        this.field_songLyric = paramCursor.getString(i);
      }
      else if (eQF == k)
      {
        this.field_songBgColor = paramCursor.getInt(i);
      }
      else if (eQG == k)
      {
        this.field_songLyricColor = paramCursor.getInt(i);
      }
      else if (eQH == k)
      {
        this.field_songFileLength = paramCursor.getLong(i);
      }
      else if (eQI == k)
      {
        this.field_songWifiFileLength = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (eQJ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hideBanner = bool;
            break;
          }
        }
        if (eQK == k)
        {
          this.field_jsWebUrlDomain = paramCursor.getString(i);
        }
        else if (eQL == k)
        {
          this.field_isBlock = paramCursor.getInt(i);
        }
        else if (ekd == k)
        {
          this.field_startTime = paramCursor.getInt(i);
        }
        else if (eQM == k)
        {
          this.field_mimetype = paramCursor.getString(i);
        }
        else if (eQN == k)
        {
          this.field_protocol = paramCursor.getString(i);
        }
        else
        {
          if (eQO == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_barBackToWebView = bool;
              break;
            }
          }
          if (eQP == k) {
            this.field_musicbar_url = paramCursor.getString(i);
          } else if (eQQ == k) {
            this.field_srcUsername = paramCursor.getString(i);
          } else if (eQR == k) {
            this.field_playbackRate = paramCursor.getDouble(i);
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
    if (this.ePA) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.ePB) {
      localContentValues.put("originMusicId", this.field_originMusicId);
    }
    if (this.ePC) {
      localContentValues.put("musicType", Integer.valueOf(this.field_musicType));
    }
    if (this.ePD) {
      localContentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
    }
    if (this.ePE) {
      localContentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
    }
    if (this.ePF) {
      localContentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
    }
    if (this.ePG) {
      localContentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
    }
    if (this.emc) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.ePH) {
      localContentValues.put("songId", Integer.valueOf(this.field_songId));
    }
    if (this.ePI) {
      localContentValues.put("songName", this.field_songName);
    }
    if (this.ePJ) {
      localContentValues.put("songSinger", this.field_songSinger);
    }
    if (this.ePK) {
      localContentValues.put("songAlbum", this.field_songAlbum);
    }
    if (this.ePL) {
      localContentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
    }
    if (this.ePM) {
      localContentValues.put("songAlbumUrl", this.field_songAlbumUrl);
    }
    if (this.ePN) {
      localContentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
    }
    if (this.ePO) {
      localContentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
    }
    if (this.ePP) {
      localContentValues.put("songWifiUrl", this.field_songWifiUrl);
    }
    if (this.ePQ) {
      localContentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
    }
    if (this.ePR) {
      localContentValues.put("songWebUrl", this.field_songWebUrl);
    }
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.ePS) {
      localContentValues.put("songMediaId", this.field_songMediaId);
    }
    if (this.ePT) {
      localContentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
    }
    if (this.ePU) {
      localContentValues.put("songSnsShareUser", this.field_songSnsShareUser);
    }
    if (this.ePV) {
      localContentValues.put("songLyric", this.field_songLyric);
    }
    if (this.ePW) {
      localContentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
    }
    if (this.ePX) {
      localContentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
    }
    if (this.ePY) {
      localContentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
    }
    if (this.ePZ) {
      localContentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
    }
    if (this.eQa) {
      localContentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
    }
    if (this.eQb) {
      localContentValues.put("jsWebUrlDomain", this.field_jsWebUrlDomain);
    }
    if (this.eQc) {
      localContentValues.put("isBlock", Integer.valueOf(this.field_isBlock));
    }
    if (this.ejW) {
      localContentValues.put("startTime", Integer.valueOf(this.field_startTime));
    }
    if (this.eQd) {
      localContentValues.put("mimetype", this.field_mimetype);
    }
    if (this.eQe) {
      localContentValues.put("protocol", this.field_protocol);
    }
    if (this.eQf) {
      localContentValues.put("barBackToWebView", Boolean.valueOf(this.field_barBackToWebView));
    }
    if (this.eQg) {
      localContentValues.put("musicbar_url", this.field_musicbar_url);
    }
    if (this.eQh) {
      localContentValues.put("srcUsername", this.field_srcUsername);
    }
    if (this.eQi) {
      localContentValues.put("playbackRate", Double.valueOf(this.field_playbackRate));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.dy
 * JD-Core Version:    0.7.0.1
 */