package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class dg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dHY = "musicId".hashCode();
  private static final int dHZ = "originMusicId".hashCode();
  private static final int dIA;
  private static final int dIB = "mimetype".hashCode();
  private static final int dIC = "protocol".hashCode();
  private static final int dID = "barBackToWebView".hashCode();
  private static final int dIE = "musicbar_url".hashCode();
  private static final int dIa = "musicType".hashCode();
  private static final int dIb = "downloadedLength".hashCode();
  private static final int dIc = "wifiDownloadedLength".hashCode();
  private static final int dId = "endFlag".hashCode();
  private static final int dIe = "wifiEndFlag".hashCode();
  private static final int dIf;
  private static final int dIg;
  private static final int dIh;
  private static final int dIi;
  private static final int dIj;
  private static final int dIk;
  private static final int dIl;
  private static final int dIm;
  private static final int dIn;
  private static final int dIo;
  private static final int dIp;
  private static final int dIq;
  private static final int dIr;
  private static final int dIs;
  private static final int dIt;
  private static final int dIu;
  private static final int dIv;
  private static final int dIw;
  private static final int dIx;
  private static final int dIy;
  private static final int dIz;
  private static final int dfV;
  private static final int dhB;
  private static final int dhV = "updateTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dHA = true;
  private boolean dHB = true;
  private boolean dHC = true;
  private boolean dHD = true;
  private boolean dHE = true;
  private boolean dHF = true;
  private boolean dHG = true;
  private boolean dHH = true;
  private boolean dHI = true;
  private boolean dHJ = true;
  private boolean dHK = true;
  private boolean dHL = true;
  private boolean dHM = true;
  private boolean dHN = true;
  private boolean dHO = true;
  private boolean dHP = true;
  private boolean dHQ = true;
  private boolean dHR = true;
  private boolean dHS = true;
  private boolean dHT = true;
  private boolean dHU = true;
  private boolean dHV = true;
  private boolean dHW = true;
  private boolean dHX = true;
  private boolean dHr = true;
  private boolean dHs = true;
  private boolean dHt = true;
  private boolean dHu = true;
  private boolean dHv = true;
  private boolean dHw = true;
  private boolean dHx = true;
  private boolean dHy = true;
  private boolean dHz = true;
  private boolean dfO = true;
  private boolean dhT = true;
  private boolean dhk = true;
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
    dIf = "songId".hashCode();
    dIg = "songName".hashCode();
    dIh = "songSinger".hashCode();
    dIi = "songAlbum".hashCode();
    dIj = "songAlbumType".hashCode();
    dIk = "songAlbumUrl".hashCode();
    dIl = "songHAlbumUrl".hashCode();
    dIm = "songAlbumLocalPath".hashCode();
    dIn = "songWifiUrl".hashCode();
    dIo = "songWapLinkUrl".hashCode();
    dIp = "songWebUrl".hashCode();
    dhB = "appId".hashCode();
    dIq = "songMediaId".hashCode();
    dIr = "songSnsAlbumUser".hashCode();
    dIs = "songSnsShareUser".hashCode();
    dIt = "songLyric".hashCode();
    dIu = "songBgColor".hashCode();
    dIv = "songLyricColor".hashCode();
    dIw = "songFileLength".hashCode();
    dIx = "songWifiFileLength".hashCode();
    dIy = "hideBanner".hashCode();
    dIz = "jsWebUrlDomain".hashCode();
    dIA = "isBlock".hashCode();
    dfV = "startTime".hashCode();
  }
  
  public static c.a Hm()
  {
    c.a locala = new c.a();
    locala.yrK = new Field[36];
    locala.columns = new String[37];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "musicId";
    locala.yrM.put("musicId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" musicId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "musicId";
    locala.columns[1] = "originMusicId";
    locala.yrM.put("originMusicId", "TEXT");
    localStringBuilder.append(" originMusicId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "musicType";
    locala.yrM.put("musicType", "INTEGER");
    localStringBuilder.append(" musicType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "downloadedLength";
    locala.yrM.put("downloadedLength", "LONG");
    localStringBuilder.append(" downloadedLength LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "wifiDownloadedLength";
    locala.yrM.put("wifiDownloadedLength", "LONG");
    localStringBuilder.append(" wifiDownloadedLength LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "endFlag";
    locala.yrM.put("endFlag", "INTEGER");
    localStringBuilder.append(" endFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "wifiEndFlag";
    locala.yrM.put("wifiEndFlag", "INTEGER");
    localStringBuilder.append(" wifiEndFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "updateTime";
    locala.yrM.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "songId";
    locala.yrM.put("songId", "INTEGER");
    localStringBuilder.append(" songId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "songName";
    locala.yrM.put("songName", "TEXT");
    localStringBuilder.append(" songName TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "songSinger";
    locala.yrM.put("songSinger", "TEXT");
    localStringBuilder.append(" songSinger TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "songAlbum";
    locala.yrM.put("songAlbum", "TEXT");
    localStringBuilder.append(" songAlbum TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "songAlbumType";
    locala.yrM.put("songAlbumType", "INTEGER");
    localStringBuilder.append(" songAlbumType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "songAlbumUrl";
    locala.yrM.put("songAlbumUrl", "TEXT");
    localStringBuilder.append(" songAlbumUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "songHAlbumUrl";
    locala.yrM.put("songHAlbumUrl", "TEXT");
    localStringBuilder.append(" songHAlbumUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "songAlbumLocalPath";
    locala.yrM.put("songAlbumLocalPath", "TEXT");
    localStringBuilder.append(" songAlbumLocalPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "songWifiUrl";
    locala.yrM.put("songWifiUrl", "TEXT");
    localStringBuilder.append(" songWifiUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "songWapLinkUrl";
    locala.yrM.put("songWapLinkUrl", "TEXT");
    localStringBuilder.append(" songWapLinkUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "songWebUrl";
    locala.yrM.put("songWebUrl", "TEXT");
    localStringBuilder.append(" songWebUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "appId";
    locala.yrM.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "songMediaId";
    locala.yrM.put("songMediaId", "TEXT");
    localStringBuilder.append(" songMediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "songSnsAlbumUser";
    locala.yrM.put("songSnsAlbumUser", "TEXT");
    localStringBuilder.append(" songSnsAlbumUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "songSnsShareUser";
    locala.yrM.put("songSnsShareUser", "TEXT");
    localStringBuilder.append(" songSnsShareUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "songLyric";
    locala.yrM.put("songLyric", "TEXT");
    localStringBuilder.append(" songLyric TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "songBgColor";
    locala.yrM.put("songBgColor", "INTEGER");
    localStringBuilder.append(" songBgColor INTEGER");
    localStringBuilder.append(", ");
    locala.columns[25] = "songLyricColor";
    locala.yrM.put("songLyricColor", "INTEGER");
    localStringBuilder.append(" songLyricColor INTEGER");
    localStringBuilder.append(", ");
    locala.columns[26] = "songFileLength";
    locala.yrM.put("songFileLength", "LONG");
    localStringBuilder.append(" songFileLength LONG");
    localStringBuilder.append(", ");
    locala.columns[27] = "songWifiFileLength";
    locala.yrM.put("songWifiFileLength", "LONG");
    localStringBuilder.append(" songWifiFileLength LONG");
    localStringBuilder.append(", ");
    locala.columns[28] = "hideBanner";
    locala.yrM.put("hideBanner", "INTEGER");
    localStringBuilder.append(" hideBanner INTEGER");
    localStringBuilder.append(", ");
    locala.columns[29] = "jsWebUrlDomain";
    locala.yrM.put("jsWebUrlDomain", "TEXT");
    localStringBuilder.append(" jsWebUrlDomain TEXT");
    localStringBuilder.append(", ");
    locala.columns[30] = "isBlock";
    locala.yrM.put("isBlock", "INTEGER");
    localStringBuilder.append(" isBlock INTEGER");
    localStringBuilder.append(", ");
    locala.columns[31] = "startTime";
    locala.yrM.put("startTime", "INTEGER");
    localStringBuilder.append(" startTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[32] = "mimetype";
    locala.yrM.put("mimetype", "TEXT");
    localStringBuilder.append(" mimetype TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "protocol";
    locala.yrM.put("protocol", "TEXT");
    localStringBuilder.append(" protocol TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "barBackToWebView";
    locala.yrM.put("barBackToWebView", "INTEGER");
    localStringBuilder.append(" barBackToWebView INTEGER");
    localStringBuilder.append(", ");
    locala.columns[35] = "musicbar_url";
    locala.yrM.put("musicbar_url", "TEXT");
    localStringBuilder.append(" musicbar_url TEXT");
    locala.columns[36] = "rowid";
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
      if (dHY != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.dHr = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dHZ == k)
      {
        this.field_originMusicId = paramCursor.getString(i);
      }
      else if (dIa == k)
      {
        this.field_musicType = paramCursor.getInt(i);
      }
      else if (dIb == k)
      {
        this.field_downloadedLength = paramCursor.getLong(i);
      }
      else if (dIc == k)
      {
        this.field_wifiDownloadedLength = paramCursor.getLong(i);
      }
      else if (dId == k)
      {
        this.field_endFlag = paramCursor.getInt(i);
      }
      else if (dIe == k)
      {
        this.field_wifiEndFlag = paramCursor.getInt(i);
      }
      else if (dhV == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (dIf == k)
      {
        this.field_songId = paramCursor.getInt(i);
      }
      else if (dIg == k)
      {
        this.field_songName = paramCursor.getString(i);
      }
      else if (dIh == k)
      {
        this.field_songSinger = paramCursor.getString(i);
      }
      else if (dIi == k)
      {
        this.field_songAlbum = paramCursor.getString(i);
      }
      else if (dIj == k)
      {
        this.field_songAlbumType = paramCursor.getInt(i);
      }
      else if (dIk == k)
      {
        this.field_songAlbumUrl = paramCursor.getString(i);
      }
      else if (dIl == k)
      {
        this.field_songHAlbumUrl = paramCursor.getString(i);
      }
      else if (dIm == k)
      {
        this.field_songAlbumLocalPath = paramCursor.getString(i);
      }
      else if (dIn == k)
      {
        this.field_songWifiUrl = paramCursor.getString(i);
      }
      else if (dIo == k)
      {
        this.field_songWapLinkUrl = paramCursor.getString(i);
      }
      else if (dIp == k)
      {
        this.field_songWebUrl = paramCursor.getString(i);
      }
      else if (dhB == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (dIq == k)
      {
        this.field_songMediaId = paramCursor.getString(i);
      }
      else if (dIr == k)
      {
        this.field_songSnsAlbumUser = paramCursor.getString(i);
      }
      else if (dIs == k)
      {
        this.field_songSnsShareUser = paramCursor.getString(i);
      }
      else if (dIt == k)
      {
        this.field_songLyric = paramCursor.getString(i);
      }
      else if (dIu == k)
      {
        this.field_songBgColor = paramCursor.getInt(i);
      }
      else if (dIv == k)
      {
        this.field_songLyricColor = paramCursor.getInt(i);
      }
      else if (dIw == k)
      {
        this.field_songFileLength = paramCursor.getLong(i);
      }
      else if (dIx == k)
      {
        this.field_songWifiFileLength = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (dIy == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hideBanner = bool;
            break;
          }
        }
        if (dIz == k)
        {
          this.field_jsWebUrlDomain = paramCursor.getString(i);
        }
        else if (dIA == k)
        {
          this.field_isBlock = paramCursor.getInt(i);
        }
        else if (dfV == k)
        {
          this.field_startTime = paramCursor.getInt(i);
        }
        else if (dIB == k)
        {
          this.field_mimetype = paramCursor.getString(i);
        }
        else if (dIC == k)
        {
          this.field_protocol = paramCursor.getString(i);
        }
        else
        {
          if (dID == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_barBackToWebView = bool;
              break;
            }
          }
          if (dIE == k) {
            this.field_musicbar_url = paramCursor.getString(i);
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
    if (this.dHr) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.dHs) {
      localContentValues.put("originMusicId", this.field_originMusicId);
    }
    if (this.dHt) {
      localContentValues.put("musicType", Integer.valueOf(this.field_musicType));
    }
    if (this.dHu) {
      localContentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
    }
    if (this.dHv) {
      localContentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
    }
    if (this.dHw) {
      localContentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
    }
    if (this.dHx) {
      localContentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
    }
    if (this.dhT) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.dHy) {
      localContentValues.put("songId", Integer.valueOf(this.field_songId));
    }
    if (this.dHz) {
      localContentValues.put("songName", this.field_songName);
    }
    if (this.dHA) {
      localContentValues.put("songSinger", this.field_songSinger);
    }
    if (this.dHB) {
      localContentValues.put("songAlbum", this.field_songAlbum);
    }
    if (this.dHC) {
      localContentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
    }
    if (this.dHD) {
      localContentValues.put("songAlbumUrl", this.field_songAlbumUrl);
    }
    if (this.dHE) {
      localContentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
    }
    if (this.dHF) {
      localContentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
    }
    if (this.dHG) {
      localContentValues.put("songWifiUrl", this.field_songWifiUrl);
    }
    if (this.dHH) {
      localContentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
    }
    if (this.dHI) {
      localContentValues.put("songWebUrl", this.field_songWebUrl);
    }
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.dHJ) {
      localContentValues.put("songMediaId", this.field_songMediaId);
    }
    if (this.dHK) {
      localContentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
    }
    if (this.dHL) {
      localContentValues.put("songSnsShareUser", this.field_songSnsShareUser);
    }
    if (this.dHM) {
      localContentValues.put("songLyric", this.field_songLyric);
    }
    if (this.dHN) {
      localContentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
    }
    if (this.dHO) {
      localContentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
    }
    if (this.dHP) {
      localContentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
    }
    if (this.dHQ) {
      localContentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
    }
    if (this.dHR) {
      localContentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
    }
    if (this.dHS) {
      localContentValues.put("jsWebUrlDomain", this.field_jsWebUrlDomain);
    }
    if (this.dHT) {
      localContentValues.put("isBlock", Integer.valueOf(this.field_isBlock));
    }
    if (this.dfO) {
      localContentValues.put("startTime", Integer.valueOf(this.field_startTime));
    }
    if (this.dHU) {
      localContentValues.put("mimetype", this.field_mimetype);
    }
    if (this.dHV) {
      localContentValues.put("protocol", this.field_protocol);
    }
    if (this.dHW) {
      localContentValues.put("barBackToWebView", Boolean.valueOf(this.field_barBackToWebView));
    }
    if (this.dHX) {
      localContentValues.put("musicbar_url", this.field_musicbar_url);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dg
 * JD-Core Version:    0.7.0.1
 */