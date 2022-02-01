package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ec
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eTA;
  private static final int eTB;
  private static final int eTC;
  private static final int eTD;
  private static final int eTE;
  private static final int eTF;
  private static final int eTG;
  private static final int eTH;
  private static final int eTI;
  private static final int eTJ;
  private static final int eTK;
  private static final int eTL;
  private static final int eTM;
  private static final int eTN;
  private static final int eTO;
  private static final int eTP;
  private static final int eTQ;
  private static final int eTR;
  private static final int eTS;
  private static final int eTT;
  private static final int eTU;
  private static final int eTV = "mimetype".hashCode();
  private static final int eTW = "protocol".hashCode();
  private static final int eTX = "barBackToWebView".hashCode();
  private static final int eTY = "musicbar_url".hashCode();
  private static final int eTZ = "srcUsername".hashCode();
  private static final int eTs = "musicId".hashCode();
  private static final int eTt = "originMusicId".hashCode();
  private static final int eTu = "musicType".hashCode();
  private static final int eTv = "downloadedLength".hashCode();
  private static final int eTw = "wifiDownloadedLength".hashCode();
  private static final int eTx = "endFlag".hashCode();
  private static final int eTy = "wifiEndFlag".hashCode();
  private static final int eTz;
  private static final int eUa = "playbackRate".hashCode();
  private static final int eUb = "songMId".hashCode();
  private static final int emh;
  private static final int enO;
  private static final int eol = "updateTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eSI = true;
  private boolean eSJ = true;
  private boolean eSK = true;
  private boolean eSL = true;
  private boolean eSM = true;
  private boolean eSN = true;
  private boolean eSO = true;
  private boolean eSP = true;
  private boolean eSQ = true;
  private boolean eSR = true;
  private boolean eSS = true;
  private boolean eST = true;
  private boolean eSU = true;
  private boolean eSV = true;
  private boolean eSW = true;
  private boolean eSX = true;
  private boolean eSY = true;
  private boolean eSZ = true;
  private boolean eTa = true;
  private boolean eTb = true;
  private boolean eTc = true;
  private boolean eTd = true;
  private boolean eTe = true;
  private boolean eTf = true;
  private boolean eTg = true;
  private boolean eTh = true;
  private boolean eTi = true;
  private boolean eTj = true;
  private boolean eTk = true;
  private boolean eTl = true;
  private boolean eTm = true;
  private boolean eTn = true;
  private boolean eTo = true;
  private boolean eTp = true;
  private boolean eTq = true;
  private boolean eTr = true;
  private boolean ema = true;
  private boolean enx = true;
  private boolean eoi = true;
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
  
  static
  {
    eTz = "songId".hashCode();
    eTA = "songName".hashCode();
    eTB = "songSinger".hashCode();
    eTC = "songAlbum".hashCode();
    eTD = "songAlbumType".hashCode();
    eTE = "songAlbumUrl".hashCode();
    eTF = "songHAlbumUrl".hashCode();
    eTG = "songAlbumLocalPath".hashCode();
    eTH = "songWifiUrl".hashCode();
    eTI = "songWapLinkUrl".hashCode();
    eTJ = "songWebUrl".hashCode();
    enO = "appId".hashCode();
    eTK = "songMediaId".hashCode();
    eTL = "songSnsAlbumUser".hashCode();
    eTM = "songSnsShareUser".hashCode();
    eTN = "songLyric".hashCode();
    eTO = "songBgColor".hashCode();
    eTP = "songLyricColor".hashCode();
    eTQ = "songFileLength".hashCode();
    eTR = "songWifiFileLength".hashCode();
    eTS = "hideBanner".hashCode();
    eTT = "jsWebUrlDomain".hashCode();
    eTU = "isBlock".hashCode();
    emh = "startTime".hashCode();
  }
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[39];
    locala.columns = new String[40];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "musicId";
    locala.GvH.put("musicId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" musicId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "musicId";
    locala.columns[1] = "originMusicId";
    locala.GvH.put("originMusicId", "TEXT");
    localStringBuilder.append(" originMusicId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "musicType";
    locala.GvH.put("musicType", "INTEGER");
    localStringBuilder.append(" musicType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "downloadedLength";
    locala.GvH.put("downloadedLength", "LONG");
    localStringBuilder.append(" downloadedLength LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "wifiDownloadedLength";
    locala.GvH.put("wifiDownloadedLength", "LONG");
    localStringBuilder.append(" wifiDownloadedLength LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "endFlag";
    locala.GvH.put("endFlag", "INTEGER");
    localStringBuilder.append(" endFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "wifiEndFlag";
    locala.GvH.put("wifiEndFlag", "INTEGER");
    localStringBuilder.append(" wifiEndFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "updateTime";
    locala.GvH.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "songId";
    locala.GvH.put("songId", "INTEGER");
    localStringBuilder.append(" songId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "songName";
    locala.GvH.put("songName", "TEXT");
    localStringBuilder.append(" songName TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "songSinger";
    locala.GvH.put("songSinger", "TEXT");
    localStringBuilder.append(" songSinger TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "songAlbum";
    locala.GvH.put("songAlbum", "TEXT");
    localStringBuilder.append(" songAlbum TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "songAlbumType";
    locala.GvH.put("songAlbumType", "INTEGER");
    localStringBuilder.append(" songAlbumType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "songAlbumUrl";
    locala.GvH.put("songAlbumUrl", "TEXT");
    localStringBuilder.append(" songAlbumUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "songHAlbumUrl";
    locala.GvH.put("songHAlbumUrl", "TEXT");
    localStringBuilder.append(" songHAlbumUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "songAlbumLocalPath";
    locala.GvH.put("songAlbumLocalPath", "TEXT");
    localStringBuilder.append(" songAlbumLocalPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "songWifiUrl";
    locala.GvH.put("songWifiUrl", "TEXT");
    localStringBuilder.append(" songWifiUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "songWapLinkUrl";
    locala.GvH.put("songWapLinkUrl", "TEXT");
    localStringBuilder.append(" songWapLinkUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "songWebUrl";
    locala.GvH.put("songWebUrl", "TEXT");
    localStringBuilder.append(" songWebUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "appId";
    locala.GvH.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "songMediaId";
    locala.GvH.put("songMediaId", "TEXT");
    localStringBuilder.append(" songMediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "songSnsAlbumUser";
    locala.GvH.put("songSnsAlbumUser", "TEXT");
    localStringBuilder.append(" songSnsAlbumUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "songSnsShareUser";
    locala.GvH.put("songSnsShareUser", "TEXT");
    localStringBuilder.append(" songSnsShareUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "songLyric";
    locala.GvH.put("songLyric", "TEXT");
    localStringBuilder.append(" songLyric TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "songBgColor";
    locala.GvH.put("songBgColor", "INTEGER");
    localStringBuilder.append(" songBgColor INTEGER");
    localStringBuilder.append(", ");
    locala.columns[25] = "songLyricColor";
    locala.GvH.put("songLyricColor", "INTEGER");
    localStringBuilder.append(" songLyricColor INTEGER");
    localStringBuilder.append(", ");
    locala.columns[26] = "songFileLength";
    locala.GvH.put("songFileLength", "LONG");
    localStringBuilder.append(" songFileLength LONG");
    localStringBuilder.append(", ");
    locala.columns[27] = "songWifiFileLength";
    locala.GvH.put("songWifiFileLength", "LONG");
    localStringBuilder.append(" songWifiFileLength LONG");
    localStringBuilder.append(", ");
    locala.columns[28] = "hideBanner";
    locala.GvH.put("hideBanner", "INTEGER");
    localStringBuilder.append(" hideBanner INTEGER");
    localStringBuilder.append(", ");
    locala.columns[29] = "jsWebUrlDomain";
    locala.GvH.put("jsWebUrlDomain", "TEXT");
    localStringBuilder.append(" jsWebUrlDomain TEXT");
    localStringBuilder.append(", ");
    locala.columns[30] = "isBlock";
    locala.GvH.put("isBlock", "INTEGER");
    localStringBuilder.append(" isBlock INTEGER");
    localStringBuilder.append(", ");
    locala.columns[31] = "startTime";
    locala.GvH.put("startTime", "INTEGER");
    localStringBuilder.append(" startTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[32] = "mimetype";
    locala.GvH.put("mimetype", "TEXT");
    localStringBuilder.append(" mimetype TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "protocol";
    locala.GvH.put("protocol", "TEXT");
    localStringBuilder.append(" protocol TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "barBackToWebView";
    locala.GvH.put("barBackToWebView", "INTEGER");
    localStringBuilder.append(" barBackToWebView INTEGER");
    localStringBuilder.append(", ");
    locala.columns[35] = "musicbar_url";
    locala.GvH.put("musicbar_url", "TEXT");
    localStringBuilder.append(" musicbar_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[36] = "srcUsername";
    locala.GvH.put("srcUsername", "TEXT");
    localStringBuilder.append(" srcUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[37] = "playbackRate";
    locala.GvH.put("playbackRate", "DOUBLE");
    localStringBuilder.append(" playbackRate DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[38] = "songMId";
    locala.GvH.put("songMId", "TEXT");
    localStringBuilder.append(" songMId TEXT");
    locala.columns[39] = "rowid";
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
      if (eTs != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.eSI = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eTt == k)
      {
        this.field_originMusicId = paramCursor.getString(i);
      }
      else if (eTu == k)
      {
        this.field_musicType = paramCursor.getInt(i);
      }
      else if (eTv == k)
      {
        this.field_downloadedLength = paramCursor.getLong(i);
      }
      else if (eTw == k)
      {
        this.field_wifiDownloadedLength = paramCursor.getLong(i);
      }
      else if (eTx == k)
      {
        this.field_endFlag = paramCursor.getInt(i);
      }
      else if (eTy == k)
      {
        this.field_wifiEndFlag = paramCursor.getInt(i);
      }
      else if (eol == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (eTz == k)
      {
        this.field_songId = paramCursor.getInt(i);
      }
      else if (eTA == k)
      {
        this.field_songName = paramCursor.getString(i);
      }
      else if (eTB == k)
      {
        this.field_songSinger = paramCursor.getString(i);
      }
      else if (eTC == k)
      {
        this.field_songAlbum = paramCursor.getString(i);
      }
      else if (eTD == k)
      {
        this.field_songAlbumType = paramCursor.getInt(i);
      }
      else if (eTE == k)
      {
        this.field_songAlbumUrl = paramCursor.getString(i);
      }
      else if (eTF == k)
      {
        this.field_songHAlbumUrl = paramCursor.getString(i);
      }
      else if (eTG == k)
      {
        this.field_songAlbumLocalPath = paramCursor.getString(i);
      }
      else if (eTH == k)
      {
        this.field_songWifiUrl = paramCursor.getString(i);
      }
      else if (eTI == k)
      {
        this.field_songWapLinkUrl = paramCursor.getString(i);
      }
      else if (eTJ == k)
      {
        this.field_songWebUrl = paramCursor.getString(i);
      }
      else if (enO == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (eTK == k)
      {
        this.field_songMediaId = paramCursor.getString(i);
      }
      else if (eTL == k)
      {
        this.field_songSnsAlbumUser = paramCursor.getString(i);
      }
      else if (eTM == k)
      {
        this.field_songSnsShareUser = paramCursor.getString(i);
      }
      else if (eTN == k)
      {
        this.field_songLyric = paramCursor.getString(i);
      }
      else if (eTO == k)
      {
        this.field_songBgColor = paramCursor.getInt(i);
      }
      else if (eTP == k)
      {
        this.field_songLyricColor = paramCursor.getInt(i);
      }
      else if (eTQ == k)
      {
        this.field_songFileLength = paramCursor.getLong(i);
      }
      else if (eTR == k)
      {
        this.field_songWifiFileLength = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (eTS == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hideBanner = bool;
            break;
          }
        }
        if (eTT == k)
        {
          this.field_jsWebUrlDomain = paramCursor.getString(i);
        }
        else if (eTU == k)
        {
          this.field_isBlock = paramCursor.getInt(i);
        }
        else if (emh == k)
        {
          this.field_startTime = paramCursor.getInt(i);
        }
        else if (eTV == k)
        {
          this.field_mimetype = paramCursor.getString(i);
        }
        else if (eTW == k)
        {
          this.field_protocol = paramCursor.getString(i);
        }
        else
        {
          if (eTX == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_barBackToWebView = bool;
              break;
            }
          }
          if (eTY == k) {
            this.field_musicbar_url = paramCursor.getString(i);
          } else if (eTZ == k) {
            this.field_srcUsername = paramCursor.getString(i);
          } else if (eUa == k) {
            this.field_playbackRate = paramCursor.getDouble(i);
          } else if (eUb == k) {
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
    if (this.eSI) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.eSJ) {
      localContentValues.put("originMusicId", this.field_originMusicId);
    }
    if (this.eSK) {
      localContentValues.put("musicType", Integer.valueOf(this.field_musicType));
    }
    if (this.eSL) {
      localContentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
    }
    if (this.eSM) {
      localContentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
    }
    if (this.eSN) {
      localContentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
    }
    if (this.eSO) {
      localContentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eSP) {
      localContentValues.put("songId", Integer.valueOf(this.field_songId));
    }
    if (this.eSQ) {
      localContentValues.put("songName", this.field_songName);
    }
    if (this.eSR) {
      localContentValues.put("songSinger", this.field_songSinger);
    }
    if (this.eSS) {
      localContentValues.put("songAlbum", this.field_songAlbum);
    }
    if (this.eST) {
      localContentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
    }
    if (this.eSU) {
      localContentValues.put("songAlbumUrl", this.field_songAlbumUrl);
    }
    if (this.eSV) {
      localContentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
    }
    if (this.eSW) {
      localContentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
    }
    if (this.eSX) {
      localContentValues.put("songWifiUrl", this.field_songWifiUrl);
    }
    if (this.eSY) {
      localContentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
    }
    if (this.eSZ) {
      localContentValues.put("songWebUrl", this.field_songWebUrl);
    }
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eTa) {
      localContentValues.put("songMediaId", this.field_songMediaId);
    }
    if (this.eTb) {
      localContentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
    }
    if (this.eTc) {
      localContentValues.put("songSnsShareUser", this.field_songSnsShareUser);
    }
    if (this.eTd) {
      localContentValues.put("songLyric", this.field_songLyric);
    }
    if (this.eTe) {
      localContentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
    }
    if (this.eTf) {
      localContentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
    }
    if (this.eTg) {
      localContentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
    }
    if (this.eTh) {
      localContentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
    }
    if (this.eTi) {
      localContentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
    }
    if (this.eTj) {
      localContentValues.put("jsWebUrlDomain", this.field_jsWebUrlDomain);
    }
    if (this.eTk) {
      localContentValues.put("isBlock", Integer.valueOf(this.field_isBlock));
    }
    if (this.ema) {
      localContentValues.put("startTime", Integer.valueOf(this.field_startTime));
    }
    if (this.eTl) {
      localContentValues.put("mimetype", this.field_mimetype);
    }
    if (this.eTm) {
      localContentValues.put("protocol", this.field_protocol);
    }
    if (this.eTn) {
      localContentValues.put("barBackToWebView", Boolean.valueOf(this.field_barBackToWebView));
    }
    if (this.eTo) {
      localContentValues.put("musicbar_url", this.field_musicbar_url);
    }
    if (this.eTp) {
      localContentValues.put("srcUsername", this.field_srcUsername);
    }
    if (this.eTq) {
      localContentValues.put("playbackRate", Double.valueOf(this.field_playbackRate));
    }
    if (this.eTr) {
      localContentValues.put("songMId", this.field_songMId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.ec
 * JD-Core Version:    0.7.0.1
 */