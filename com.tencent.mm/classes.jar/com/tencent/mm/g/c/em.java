package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class em
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDo = "startTime".hashCode();
  private static final int eEU;
  private static final int eFq;
  private static final int flH = "musicId".hashCode();
  private static final int flI = "originMusicId".hashCode();
  private static final int flJ = "musicType".hashCode();
  private static final int flK = "downloadedLength".hashCode();
  private static final int flL = "wifiDownloadedLength".hashCode();
  private static final int flM = "endFlag".hashCode();
  private static final int flN = "wifiEndFlag".hashCode();
  private static final int flO;
  private static final int flP;
  private static final int flQ;
  private static final int flR;
  private static final int flS;
  private static final int flT;
  private static final int flU;
  private static final int flV;
  private static final int flW;
  private static final int flX;
  private static final int flY;
  private static final int flZ;
  private static final int fma;
  private static final int fmb;
  private static final int fmc;
  private static final int fmd;
  private static final int fme;
  private static final int fmf;
  private static final int fmg;
  private static final int fmh;
  private static final int fmi;
  private static final int fmj;
  private static final int fmk = "mimetype".hashCode();
  private static final int fml = "protocol".hashCode();
  private static final int fmm = "barBackToWebView".hashCode();
  private static final int fmn = "musicbar_url".hashCode();
  private static final int fmo = "srcUsername".hashCode();
  private static final int fmp = "playbackRate".hashCode();
  private static final int fmq = "songMId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDh = true;
  private boolean eED = true;
  private boolean eFn = true;
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
  private boolean fkX = true;
  private boolean fkY = true;
  private boolean fkZ = true;
  private boolean flA = true;
  private boolean flB = true;
  private boolean flC = true;
  private boolean flD = true;
  private boolean flE = true;
  private boolean flF = true;
  private boolean flG = true;
  private boolean fla = true;
  private boolean flb = true;
  private boolean flc = true;
  private boolean fld = true;
  private boolean fle = true;
  private boolean flf = true;
  private boolean flg = true;
  private boolean flh = true;
  private boolean fli = true;
  private boolean flj = true;
  private boolean flk = true;
  private boolean fll = true;
  private boolean flm = true;
  private boolean fln = true;
  private boolean flo = true;
  private boolean flp = true;
  private boolean flq = true;
  private boolean flr = true;
  private boolean fls = true;
  private boolean flt = true;
  private boolean flu = true;
  private boolean flv = true;
  private boolean flw = true;
  private boolean flx = true;
  private boolean fly = true;
  private boolean flz = true;
  
  static
  {
    eFq = "updateTime".hashCode();
    flO = "songId".hashCode();
    flP = "songName".hashCode();
    flQ = "songSinger".hashCode();
    flR = "songAlbum".hashCode();
    flS = "songAlbumType".hashCode();
    flT = "songAlbumUrl".hashCode();
    flU = "songHAlbumUrl".hashCode();
    flV = "songAlbumLocalPath".hashCode();
    flW = "songWifiUrl".hashCode();
    flX = "songWapLinkUrl".hashCode();
    flY = "songWebUrl".hashCode();
    eEU = "appId".hashCode();
    flZ = "songMediaId".hashCode();
    fma = "songSnsAlbumUser".hashCode();
    fmb = "songSnsShareUser".hashCode();
    fmc = "songLyric".hashCode();
    fmd = "songBgColor".hashCode();
    fme = "songLyricColor".hashCode();
    fmf = "songFileLength".hashCode();
    fmg = "songWifiFileLength".hashCode();
    fmh = "hideBanner".hashCode();
    fmi = "jsWebUrlDomain".hashCode();
    fmj = "isBlock".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[39];
    locala.columns = new String[40];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "musicId";
    locala.IhC.put("musicId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" musicId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "musicId";
    locala.columns[1] = "originMusicId";
    locala.IhC.put("originMusicId", "TEXT");
    localStringBuilder.append(" originMusicId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "musicType";
    locala.IhC.put("musicType", "INTEGER");
    localStringBuilder.append(" musicType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "downloadedLength";
    locala.IhC.put("downloadedLength", "LONG");
    localStringBuilder.append(" downloadedLength LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "wifiDownloadedLength";
    locala.IhC.put("wifiDownloadedLength", "LONG");
    localStringBuilder.append(" wifiDownloadedLength LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "endFlag";
    locala.IhC.put("endFlag", "INTEGER");
    localStringBuilder.append(" endFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "wifiEndFlag";
    locala.IhC.put("wifiEndFlag", "INTEGER");
    localStringBuilder.append(" wifiEndFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "updateTime";
    locala.IhC.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "songId";
    locala.IhC.put("songId", "INTEGER");
    localStringBuilder.append(" songId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "songName";
    locala.IhC.put("songName", "TEXT");
    localStringBuilder.append(" songName TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "songSinger";
    locala.IhC.put("songSinger", "TEXT");
    localStringBuilder.append(" songSinger TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "songAlbum";
    locala.IhC.put("songAlbum", "TEXT");
    localStringBuilder.append(" songAlbum TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "songAlbumType";
    locala.IhC.put("songAlbumType", "INTEGER");
    localStringBuilder.append(" songAlbumType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "songAlbumUrl";
    locala.IhC.put("songAlbumUrl", "TEXT");
    localStringBuilder.append(" songAlbumUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "songHAlbumUrl";
    locala.IhC.put("songHAlbumUrl", "TEXT");
    localStringBuilder.append(" songHAlbumUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "songAlbumLocalPath";
    locala.IhC.put("songAlbumLocalPath", "TEXT");
    localStringBuilder.append(" songAlbumLocalPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "songWifiUrl";
    locala.IhC.put("songWifiUrl", "TEXT");
    localStringBuilder.append(" songWifiUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "songWapLinkUrl";
    locala.IhC.put("songWapLinkUrl", "TEXT");
    localStringBuilder.append(" songWapLinkUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "songWebUrl";
    locala.IhC.put("songWebUrl", "TEXT");
    localStringBuilder.append(" songWebUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "appId";
    locala.IhC.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "songMediaId";
    locala.IhC.put("songMediaId", "TEXT");
    localStringBuilder.append(" songMediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "songSnsAlbumUser";
    locala.IhC.put("songSnsAlbumUser", "TEXT");
    localStringBuilder.append(" songSnsAlbumUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "songSnsShareUser";
    locala.IhC.put("songSnsShareUser", "TEXT");
    localStringBuilder.append(" songSnsShareUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "songLyric";
    locala.IhC.put("songLyric", "TEXT");
    localStringBuilder.append(" songLyric TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "songBgColor";
    locala.IhC.put("songBgColor", "INTEGER");
    localStringBuilder.append(" songBgColor INTEGER");
    localStringBuilder.append(", ");
    locala.columns[25] = "songLyricColor";
    locala.IhC.put("songLyricColor", "INTEGER");
    localStringBuilder.append(" songLyricColor INTEGER");
    localStringBuilder.append(", ");
    locala.columns[26] = "songFileLength";
    locala.IhC.put("songFileLength", "LONG");
    localStringBuilder.append(" songFileLength LONG");
    localStringBuilder.append(", ");
    locala.columns[27] = "songWifiFileLength";
    locala.IhC.put("songWifiFileLength", "LONG");
    localStringBuilder.append(" songWifiFileLength LONG");
    localStringBuilder.append(", ");
    locala.columns[28] = "hideBanner";
    locala.IhC.put("hideBanner", "INTEGER");
    localStringBuilder.append(" hideBanner INTEGER");
    localStringBuilder.append(", ");
    locala.columns[29] = "jsWebUrlDomain";
    locala.IhC.put("jsWebUrlDomain", "TEXT");
    localStringBuilder.append(" jsWebUrlDomain TEXT");
    localStringBuilder.append(", ");
    locala.columns[30] = "isBlock";
    locala.IhC.put("isBlock", "INTEGER");
    localStringBuilder.append(" isBlock INTEGER");
    localStringBuilder.append(", ");
    locala.columns[31] = "startTime";
    locala.IhC.put("startTime", "INTEGER");
    localStringBuilder.append(" startTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[32] = "mimetype";
    locala.IhC.put("mimetype", "TEXT");
    localStringBuilder.append(" mimetype TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "protocol";
    locala.IhC.put("protocol", "TEXT");
    localStringBuilder.append(" protocol TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "barBackToWebView";
    locala.IhC.put("barBackToWebView", "INTEGER");
    localStringBuilder.append(" barBackToWebView INTEGER");
    localStringBuilder.append(", ");
    locala.columns[35] = "musicbar_url";
    locala.IhC.put("musicbar_url", "TEXT");
    localStringBuilder.append(" musicbar_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[36] = "srcUsername";
    locala.IhC.put("srcUsername", "TEXT");
    localStringBuilder.append(" srcUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[37] = "playbackRate";
    locala.IhC.put("playbackRate", "DOUBLE");
    localStringBuilder.append(" playbackRate DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[38] = "songMId";
    locala.IhC.put("songMId", "TEXT");
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
      if (flH != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.fkX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (flI == k)
      {
        this.field_originMusicId = paramCursor.getString(i);
      }
      else if (flJ == k)
      {
        this.field_musicType = paramCursor.getInt(i);
      }
      else if (flK == k)
      {
        this.field_downloadedLength = paramCursor.getLong(i);
      }
      else if (flL == k)
      {
        this.field_wifiDownloadedLength = paramCursor.getLong(i);
      }
      else if (flM == k)
      {
        this.field_endFlag = paramCursor.getInt(i);
      }
      else if (flN == k)
      {
        this.field_wifiEndFlag = paramCursor.getInt(i);
      }
      else if (eFq == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (flO == k)
      {
        this.field_songId = paramCursor.getInt(i);
      }
      else if (flP == k)
      {
        this.field_songName = paramCursor.getString(i);
      }
      else if (flQ == k)
      {
        this.field_songSinger = paramCursor.getString(i);
      }
      else if (flR == k)
      {
        this.field_songAlbum = paramCursor.getString(i);
      }
      else if (flS == k)
      {
        this.field_songAlbumType = paramCursor.getInt(i);
      }
      else if (flT == k)
      {
        this.field_songAlbumUrl = paramCursor.getString(i);
      }
      else if (flU == k)
      {
        this.field_songHAlbumUrl = paramCursor.getString(i);
      }
      else if (flV == k)
      {
        this.field_songAlbumLocalPath = paramCursor.getString(i);
      }
      else if (flW == k)
      {
        this.field_songWifiUrl = paramCursor.getString(i);
      }
      else if (flX == k)
      {
        this.field_songWapLinkUrl = paramCursor.getString(i);
      }
      else if (flY == k)
      {
        this.field_songWebUrl = paramCursor.getString(i);
      }
      else if (eEU == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (flZ == k)
      {
        this.field_songMediaId = paramCursor.getString(i);
      }
      else if (fma == k)
      {
        this.field_songSnsAlbumUser = paramCursor.getString(i);
      }
      else if (fmb == k)
      {
        this.field_songSnsShareUser = paramCursor.getString(i);
      }
      else if (fmc == k)
      {
        this.field_songLyric = paramCursor.getString(i);
      }
      else if (fmd == k)
      {
        this.field_songBgColor = paramCursor.getInt(i);
      }
      else if (fme == k)
      {
        this.field_songLyricColor = paramCursor.getInt(i);
      }
      else if (fmf == k)
      {
        this.field_songFileLength = paramCursor.getLong(i);
      }
      else if (fmg == k)
      {
        this.field_songWifiFileLength = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (fmh == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hideBanner = bool;
            break;
          }
        }
        if (fmi == k)
        {
          this.field_jsWebUrlDomain = paramCursor.getString(i);
        }
        else if (fmj == k)
        {
          this.field_isBlock = paramCursor.getInt(i);
        }
        else if (eDo == k)
        {
          this.field_startTime = paramCursor.getInt(i);
        }
        else if (fmk == k)
        {
          this.field_mimetype = paramCursor.getString(i);
        }
        else if (fml == k)
        {
          this.field_protocol = paramCursor.getString(i);
        }
        else
        {
          if (fmm == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_barBackToWebView = bool;
              break;
            }
          }
          if (fmn == k) {
            this.field_musicbar_url = paramCursor.getString(i);
          } else if (fmo == k) {
            this.field_srcUsername = paramCursor.getString(i);
          } else if (fmp == k) {
            this.field_playbackRate = paramCursor.getDouble(i);
          } else if (fmq == k) {
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
    if (this.fkX) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.fkY) {
      localContentValues.put("originMusicId", this.field_originMusicId);
    }
    if (this.fkZ) {
      localContentValues.put("musicType", Integer.valueOf(this.field_musicType));
    }
    if (this.fla) {
      localContentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
    }
    if (this.flb) {
      localContentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
    }
    if (this.flc) {
      localContentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
    }
    if (this.fld) {
      localContentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fle) {
      localContentValues.put("songId", Integer.valueOf(this.field_songId));
    }
    if (this.flf) {
      localContentValues.put("songName", this.field_songName);
    }
    if (this.flg) {
      localContentValues.put("songSinger", this.field_songSinger);
    }
    if (this.flh) {
      localContentValues.put("songAlbum", this.field_songAlbum);
    }
    if (this.fli) {
      localContentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
    }
    if (this.flj) {
      localContentValues.put("songAlbumUrl", this.field_songAlbumUrl);
    }
    if (this.flk) {
      localContentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
    }
    if (this.fll) {
      localContentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
    }
    if (this.flm) {
      localContentValues.put("songWifiUrl", this.field_songWifiUrl);
    }
    if (this.fln) {
      localContentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
    }
    if (this.flo) {
      localContentValues.put("songWebUrl", this.field_songWebUrl);
    }
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.flp) {
      localContentValues.put("songMediaId", this.field_songMediaId);
    }
    if (this.flq) {
      localContentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
    }
    if (this.flr) {
      localContentValues.put("songSnsShareUser", this.field_songSnsShareUser);
    }
    if (this.fls) {
      localContentValues.put("songLyric", this.field_songLyric);
    }
    if (this.flt) {
      localContentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
    }
    if (this.flu) {
      localContentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
    }
    if (this.flv) {
      localContentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
    }
    if (this.flw) {
      localContentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
    }
    if (this.flx) {
      localContentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
    }
    if (this.fly) {
      localContentValues.put("jsWebUrlDomain", this.field_jsWebUrlDomain);
    }
    if (this.flz) {
      localContentValues.put("isBlock", Integer.valueOf(this.field_isBlock));
    }
    if (this.eDh) {
      localContentValues.put("startTime", Integer.valueOf(this.field_startTime));
    }
    if (this.flA) {
      localContentValues.put("mimetype", this.field_mimetype);
    }
    if (this.flB) {
      localContentValues.put("protocol", this.field_protocol);
    }
    if (this.flC) {
      localContentValues.put("barBackToWebView", Boolean.valueOf(this.field_barBackToWebView));
    }
    if (this.flD) {
      localContentValues.put("musicbar_url", this.field_musicbar_url);
    }
    if (this.flE) {
      localContentValues.put("srcUsername", this.field_srcUsername);
    }
    if (this.flF) {
      localContentValues.put("playbackRate", Double.valueOf(this.field_playbackRate));
    }
    if (this.flG) {
      localContentValues.put("songMId", this.field_songMId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.em
 * JD-Core Version:    0.7.0.1
 */