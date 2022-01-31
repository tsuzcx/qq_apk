package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cv
  extends c
{
  private static final int cRO;
  private static final int cRP;
  private static final int cRQ;
  private static final int cRR;
  private static final int cRS;
  private static final int cRT;
  private static final int cRU;
  private static final int cRV;
  private static final int cRW;
  private static final int cRX;
  private static final int cRY;
  private static final int cRZ;
  private static final int cSa;
  private static final int cSb;
  private static final int cSc;
  private static final int cSd;
  private static final int cSe;
  private static final int cSf;
  private static final int cSg;
  private static final int cSh;
  private static final int cSi;
  private static final int cSj;
  private static final int cSk;
  private static final int cSl;
  private static final int cSm;
  private static final int cSn;
  private static final int cSo;
  private static final int cSp;
  private static final int cSq;
  private static final int cSr = "mimetype".hashCode();
  private static final int cSs = "protocol".hashCode();
  private static final int cSt = "barBackToWebView".hashCode();
  private static final int cSu = "musicbar_url".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crB;
  private static final int crh = "rowid".hashCode();
  private static final int ctG;
  private static final int ctl;
  private boolean cRA = true;
  private boolean cRB = true;
  private boolean cRC = true;
  private boolean cRD = true;
  private boolean cRE = true;
  private boolean cRF = true;
  private boolean cRG = true;
  private boolean cRH = true;
  private boolean cRI = true;
  private boolean cRJ = true;
  private boolean cRK = true;
  private boolean cRL = true;
  private boolean cRM = true;
  private boolean cRN = true;
  private boolean cRh = true;
  private boolean cRi = true;
  private boolean cRj = true;
  private boolean cRk = true;
  private boolean cRl = true;
  private boolean cRm = true;
  private boolean cRn = true;
  private boolean cRo = true;
  private boolean cRp = true;
  private boolean cRq = true;
  private boolean cRr = true;
  private boolean cRs = true;
  private boolean cRt = true;
  private boolean cRu = true;
  private boolean cRv = true;
  private boolean cRw = true;
  private boolean cRx = true;
  private boolean cRy = true;
  private boolean cRz = true;
  private boolean crt = true;
  private boolean csU = true;
  private boolean ctE = true;
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
  public int field_startTime;
  public long field_updateTime;
  public long field_wifiDownloadedLength;
  public int field_wifiEndFlag;
  
  static
  {
    cRO = "musicId".hashCode();
    cRP = "originMusicId".hashCode();
    cRQ = "musicType".hashCode();
    cRR = "downloadedLength".hashCode();
    cRS = "wifiDownloadedLength".hashCode();
    cRT = "endFlag".hashCode();
    cRU = "wifiEndFlag".hashCode();
    ctG = "updateTime".hashCode();
    cRV = "songId".hashCode();
    cRW = "songName".hashCode();
    cRX = "songSinger".hashCode();
    cRY = "songAlbum".hashCode();
    cRZ = "songAlbumType".hashCode();
    cSa = "songAlbumUrl".hashCode();
    cSb = "songHAlbumUrl".hashCode();
    cSc = "songAlbumLocalPath".hashCode();
    cSd = "songWifiUrl".hashCode();
    cSe = "songWapLinkUrl".hashCode();
    cSf = "songWebUrl".hashCode();
    ctl = "appId".hashCode();
    cSg = "songMediaId".hashCode();
    cSh = "songSnsAlbumUser".hashCode();
    cSi = "songSnsShareUser".hashCode();
    cSj = "songLyric".hashCode();
    cSk = "songBgColor".hashCode();
    cSl = "songLyricColor".hashCode();
    cSm = "songFileLength".hashCode();
    cSn = "songWifiFileLength".hashCode();
    cSo = "hideBanner".hashCode();
    cSp = "jsWebUrlDomain".hashCode();
    cSq = "isBlock".hashCode();
    crB = "startTime".hashCode();
  }
  
  public static c.a vg()
  {
    c.a locala = new c.a();
    locala.ujL = new Field[36];
    locala.columns = new String[37];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "musicId";
    locala.ujN.put("musicId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" musicId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "musicId";
    locala.columns[1] = "originMusicId";
    locala.ujN.put("originMusicId", "TEXT");
    localStringBuilder.append(" originMusicId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "musicType";
    locala.ujN.put("musicType", "INTEGER");
    localStringBuilder.append(" musicType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "downloadedLength";
    locala.ujN.put("downloadedLength", "LONG");
    localStringBuilder.append(" downloadedLength LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "wifiDownloadedLength";
    locala.ujN.put("wifiDownloadedLength", "LONG");
    localStringBuilder.append(" wifiDownloadedLength LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "endFlag";
    locala.ujN.put("endFlag", "INTEGER");
    localStringBuilder.append(" endFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "wifiEndFlag";
    locala.ujN.put("wifiEndFlag", "INTEGER");
    localStringBuilder.append(" wifiEndFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "updateTime";
    locala.ujN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "songId";
    locala.ujN.put("songId", "INTEGER");
    localStringBuilder.append(" songId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "songName";
    locala.ujN.put("songName", "TEXT");
    localStringBuilder.append(" songName TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "songSinger";
    locala.ujN.put("songSinger", "TEXT");
    localStringBuilder.append(" songSinger TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "songAlbum";
    locala.ujN.put("songAlbum", "TEXT");
    localStringBuilder.append(" songAlbum TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "songAlbumType";
    locala.ujN.put("songAlbumType", "INTEGER");
    localStringBuilder.append(" songAlbumType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "songAlbumUrl";
    locala.ujN.put("songAlbumUrl", "TEXT");
    localStringBuilder.append(" songAlbumUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "songHAlbumUrl";
    locala.ujN.put("songHAlbumUrl", "TEXT");
    localStringBuilder.append(" songHAlbumUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "songAlbumLocalPath";
    locala.ujN.put("songAlbumLocalPath", "TEXT");
    localStringBuilder.append(" songAlbumLocalPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "songWifiUrl";
    locala.ujN.put("songWifiUrl", "TEXT");
    localStringBuilder.append(" songWifiUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "songWapLinkUrl";
    locala.ujN.put("songWapLinkUrl", "TEXT");
    localStringBuilder.append(" songWapLinkUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "songWebUrl";
    locala.ujN.put("songWebUrl", "TEXT");
    localStringBuilder.append(" songWebUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "appId";
    locala.ujN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "songMediaId";
    locala.ujN.put("songMediaId", "TEXT");
    localStringBuilder.append(" songMediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "songSnsAlbumUser";
    locala.ujN.put("songSnsAlbumUser", "TEXT");
    localStringBuilder.append(" songSnsAlbumUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "songSnsShareUser";
    locala.ujN.put("songSnsShareUser", "TEXT");
    localStringBuilder.append(" songSnsShareUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "songLyric";
    locala.ujN.put("songLyric", "TEXT");
    localStringBuilder.append(" songLyric TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "songBgColor";
    locala.ujN.put("songBgColor", "INTEGER");
    localStringBuilder.append(" songBgColor INTEGER");
    localStringBuilder.append(", ");
    locala.columns[25] = "songLyricColor";
    locala.ujN.put("songLyricColor", "INTEGER");
    localStringBuilder.append(" songLyricColor INTEGER");
    localStringBuilder.append(", ");
    locala.columns[26] = "songFileLength";
    locala.ujN.put("songFileLength", "LONG");
    localStringBuilder.append(" songFileLength LONG");
    localStringBuilder.append(", ");
    locala.columns[27] = "songWifiFileLength";
    locala.ujN.put("songWifiFileLength", "LONG");
    localStringBuilder.append(" songWifiFileLength LONG");
    localStringBuilder.append(", ");
    locala.columns[28] = "hideBanner";
    locala.ujN.put("hideBanner", "INTEGER");
    localStringBuilder.append(" hideBanner INTEGER");
    localStringBuilder.append(", ");
    locala.columns[29] = "jsWebUrlDomain";
    locala.ujN.put("jsWebUrlDomain", "TEXT");
    localStringBuilder.append(" jsWebUrlDomain TEXT");
    localStringBuilder.append(", ");
    locala.columns[30] = "isBlock";
    locala.ujN.put("isBlock", "INTEGER");
    localStringBuilder.append(" isBlock INTEGER");
    localStringBuilder.append(", ");
    locala.columns[31] = "startTime";
    locala.ujN.put("startTime", "INTEGER");
    localStringBuilder.append(" startTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[32] = "mimetype";
    locala.ujN.put("mimetype", "TEXT");
    localStringBuilder.append(" mimetype TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "protocol";
    locala.ujN.put("protocol", "TEXT");
    localStringBuilder.append(" protocol TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "barBackToWebView";
    locala.ujN.put("barBackToWebView", "INTEGER");
    localStringBuilder.append(" barBackToWebView INTEGER");
    localStringBuilder.append(", ");
    locala.columns[35] = "musicbar_url";
    locala.ujN.put("musicbar_url", "TEXT");
    localStringBuilder.append(" musicbar_url TEXT");
    locala.columns[36] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
  }
  
  public final void d(Cursor paramCursor)
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
      if (cRO != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.cRh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cRP == k)
      {
        this.field_originMusicId = paramCursor.getString(i);
      }
      else if (cRQ == k)
      {
        this.field_musicType = paramCursor.getInt(i);
      }
      else if (cRR == k)
      {
        this.field_downloadedLength = paramCursor.getLong(i);
      }
      else if (cRS == k)
      {
        this.field_wifiDownloadedLength = paramCursor.getLong(i);
      }
      else if (cRT == k)
      {
        this.field_endFlag = paramCursor.getInt(i);
      }
      else if (cRU == k)
      {
        this.field_wifiEndFlag = paramCursor.getInt(i);
      }
      else if (ctG == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (cRV == k)
      {
        this.field_songId = paramCursor.getInt(i);
      }
      else if (cRW == k)
      {
        this.field_songName = paramCursor.getString(i);
      }
      else if (cRX == k)
      {
        this.field_songSinger = paramCursor.getString(i);
      }
      else if (cRY == k)
      {
        this.field_songAlbum = paramCursor.getString(i);
      }
      else if (cRZ == k)
      {
        this.field_songAlbumType = paramCursor.getInt(i);
      }
      else if (cSa == k)
      {
        this.field_songAlbumUrl = paramCursor.getString(i);
      }
      else if (cSb == k)
      {
        this.field_songHAlbumUrl = paramCursor.getString(i);
      }
      else if (cSc == k)
      {
        this.field_songAlbumLocalPath = paramCursor.getString(i);
      }
      else if (cSd == k)
      {
        this.field_songWifiUrl = paramCursor.getString(i);
      }
      else if (cSe == k)
      {
        this.field_songWapLinkUrl = paramCursor.getString(i);
      }
      else if (cSf == k)
      {
        this.field_songWebUrl = paramCursor.getString(i);
      }
      else if (ctl == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (cSg == k)
      {
        this.field_songMediaId = paramCursor.getString(i);
      }
      else if (cSh == k)
      {
        this.field_songSnsAlbumUser = paramCursor.getString(i);
      }
      else if (cSi == k)
      {
        this.field_songSnsShareUser = paramCursor.getString(i);
      }
      else if (cSj == k)
      {
        this.field_songLyric = paramCursor.getString(i);
      }
      else if (cSk == k)
      {
        this.field_songBgColor = paramCursor.getInt(i);
      }
      else if (cSl == k)
      {
        this.field_songLyricColor = paramCursor.getInt(i);
      }
      else if (cSm == k)
      {
        this.field_songFileLength = paramCursor.getLong(i);
      }
      else if (cSn == k)
      {
        this.field_songWifiFileLength = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (cSo == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hideBanner = bool;
            break;
          }
        }
        if (cSp == k)
        {
          this.field_jsWebUrlDomain = paramCursor.getString(i);
        }
        else if (cSq == k)
        {
          this.field_isBlock = paramCursor.getInt(i);
        }
        else if (crB == k)
        {
          this.field_startTime = paramCursor.getInt(i);
        }
        else if (cSr == k)
        {
          this.field_mimetype = paramCursor.getString(i);
        }
        else if (cSs == k)
        {
          this.field_protocol = paramCursor.getString(i);
        }
        else
        {
          if (cSt == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_barBackToWebView = bool;
              break;
            }
          }
          if (cSu == k) {
            this.field_musicbar_url = paramCursor.getString(i);
          } else if (crh == k) {
            this.ujK = paramCursor.getLong(i);
          }
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cRh) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.cRi) {
      localContentValues.put("originMusicId", this.field_originMusicId);
    }
    if (this.cRj) {
      localContentValues.put("musicType", Integer.valueOf(this.field_musicType));
    }
    if (this.cRk) {
      localContentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
    }
    if (this.cRl) {
      localContentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
    }
    if (this.cRm) {
      localContentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
    }
    if (this.cRn) {
      localContentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
    }
    if (this.ctE) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.cRo) {
      localContentValues.put("songId", Integer.valueOf(this.field_songId));
    }
    if (this.cRp) {
      localContentValues.put("songName", this.field_songName);
    }
    if (this.cRq) {
      localContentValues.put("songSinger", this.field_songSinger);
    }
    if (this.cRr) {
      localContentValues.put("songAlbum", this.field_songAlbum);
    }
    if (this.cRs) {
      localContentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
    }
    if (this.cRt) {
      localContentValues.put("songAlbumUrl", this.field_songAlbumUrl);
    }
    if (this.cRu) {
      localContentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
    }
    if (this.cRv) {
      localContentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
    }
    if (this.cRw) {
      localContentValues.put("songWifiUrl", this.field_songWifiUrl);
    }
    if (this.cRx) {
      localContentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
    }
    if (this.cRy) {
      localContentValues.put("songWebUrl", this.field_songWebUrl);
    }
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.cRz) {
      localContentValues.put("songMediaId", this.field_songMediaId);
    }
    if (this.cRA) {
      localContentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
    }
    if (this.cRB) {
      localContentValues.put("songSnsShareUser", this.field_songSnsShareUser);
    }
    if (this.cRC) {
      localContentValues.put("songLyric", this.field_songLyric);
    }
    if (this.cRD) {
      localContentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
    }
    if (this.cRE) {
      localContentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
    }
    if (this.cRF) {
      localContentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
    }
    if (this.cRG) {
      localContentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
    }
    if (this.cRH) {
      localContentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
    }
    if (this.cRI) {
      localContentValues.put("jsWebUrlDomain", this.field_jsWebUrlDomain);
    }
    if (this.cRJ) {
      localContentValues.put("isBlock", Integer.valueOf(this.field_isBlock));
    }
    if (this.crt) {
      localContentValues.put("startTime", Integer.valueOf(this.field_startTime));
    }
    if (this.cRK) {
      localContentValues.put("mimetype", this.field_mimetype);
    }
    if (this.cRL) {
      localContentValues.put("protocol", this.field_protocol);
    }
    if (this.cRM) {
      localContentValues.put("barBackToWebView", Boolean.valueOf(this.field_barBackToWebView));
    }
    if (this.cRN) {
      localContentValues.put("musicbar_url", this.field_musicbar_url);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.cv
 * JD-Core Version:    0.7.0.1
 */