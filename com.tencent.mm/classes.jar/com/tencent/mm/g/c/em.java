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
  private static final int eEX = "startTime".hashCode();
  private static final int eGD;
  private static final int eGZ;
  private static final int fnH = "musicId".hashCode();
  private static final int fnI = "originMusicId".hashCode();
  private static final int fnJ = "musicType".hashCode();
  private static final int fnK = "downloadedLength".hashCode();
  private static final int fnL = "wifiDownloadedLength".hashCode();
  private static final int fnM = "endFlag".hashCode();
  private static final int fnN = "wifiEndFlag".hashCode();
  private static final int fnO;
  private static final int fnP;
  private static final int fnQ;
  private static final int fnR;
  private static final int fnS;
  private static final int fnT;
  private static final int fnU;
  private static final int fnV;
  private static final int fnW;
  private static final int fnX;
  private static final int fnY;
  private static final int fnZ;
  private static final int foa;
  private static final int fob;
  private static final int foc;
  private static final int fod;
  private static final int foe;
  private static final int fof;
  private static final int fog;
  private static final int foh;
  private static final int foi;
  private static final int foj;
  private static final int fok = "mimetype".hashCode();
  private static final int fol = "protocol".hashCode();
  private static final int fom = "barBackToWebView".hashCode();
  private static final int fon = "musicbar_url".hashCode();
  private static final int foo = "srcUsername".hashCode();
  private static final int fop = "playbackRate".hashCode();
  private static final int foq = "songMId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEQ = true;
  private boolean eGW = true;
  private boolean eGm = true;
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
  private boolean fmX = true;
  private boolean fmY = true;
  private boolean fmZ = true;
  private boolean fnA = true;
  private boolean fnB = true;
  private boolean fnC = true;
  private boolean fnD = true;
  private boolean fnE = true;
  private boolean fnF = true;
  private boolean fnG = true;
  private boolean fna = true;
  private boolean fnb = true;
  private boolean fnc = true;
  private boolean fnd = true;
  private boolean fne = true;
  private boolean fnf = true;
  private boolean fng = true;
  private boolean fnh = true;
  private boolean fni = true;
  private boolean fnj = true;
  private boolean fnk = true;
  private boolean fnl = true;
  private boolean fnm = true;
  private boolean fnn = true;
  private boolean fno = true;
  private boolean fnp = true;
  private boolean fnq = true;
  private boolean fnr = true;
  private boolean fns = true;
  private boolean fnt = true;
  private boolean fnu = true;
  private boolean fnv = true;
  private boolean fnw = true;
  private boolean fnx = true;
  private boolean fny = true;
  private boolean fnz = true;
  
  static
  {
    eGZ = "updateTime".hashCode();
    fnO = "songId".hashCode();
    fnP = "songName".hashCode();
    fnQ = "songSinger".hashCode();
    fnR = "songAlbum".hashCode();
    fnS = "songAlbumType".hashCode();
    fnT = "songAlbumUrl".hashCode();
    fnU = "songHAlbumUrl".hashCode();
    fnV = "songAlbumLocalPath".hashCode();
    fnW = "songWifiUrl".hashCode();
    fnX = "songWapLinkUrl".hashCode();
    fnY = "songWebUrl".hashCode();
    eGD = "appId".hashCode();
    fnZ = "songMediaId".hashCode();
    foa = "songSnsAlbumUser".hashCode();
    fob = "songSnsShareUser".hashCode();
    foc = "songLyric".hashCode();
    fod = "songBgColor".hashCode();
    foe = "songLyricColor".hashCode();
    fof = "songFileLength".hashCode();
    fog = "songWifiFileLength".hashCode();
    foh = "hideBanner".hashCode();
    foi = "jsWebUrlDomain".hashCode();
    foj = "isBlock".hashCode();
  }
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[39];
    locala.columns = new String[40];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "musicId";
    locala.IBN.put("musicId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" musicId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "musicId";
    locala.columns[1] = "originMusicId";
    locala.IBN.put("originMusicId", "TEXT");
    localStringBuilder.append(" originMusicId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "musicType";
    locala.IBN.put("musicType", "INTEGER");
    localStringBuilder.append(" musicType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "downloadedLength";
    locala.IBN.put("downloadedLength", "LONG");
    localStringBuilder.append(" downloadedLength LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "wifiDownloadedLength";
    locala.IBN.put("wifiDownloadedLength", "LONG");
    localStringBuilder.append(" wifiDownloadedLength LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "endFlag";
    locala.IBN.put("endFlag", "INTEGER");
    localStringBuilder.append(" endFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "wifiEndFlag";
    locala.IBN.put("wifiEndFlag", "INTEGER");
    localStringBuilder.append(" wifiEndFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "updateTime";
    locala.IBN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "songId";
    locala.IBN.put("songId", "INTEGER");
    localStringBuilder.append(" songId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "songName";
    locala.IBN.put("songName", "TEXT");
    localStringBuilder.append(" songName TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "songSinger";
    locala.IBN.put("songSinger", "TEXT");
    localStringBuilder.append(" songSinger TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "songAlbum";
    locala.IBN.put("songAlbum", "TEXT");
    localStringBuilder.append(" songAlbum TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "songAlbumType";
    locala.IBN.put("songAlbumType", "INTEGER");
    localStringBuilder.append(" songAlbumType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "songAlbumUrl";
    locala.IBN.put("songAlbumUrl", "TEXT");
    localStringBuilder.append(" songAlbumUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "songHAlbumUrl";
    locala.IBN.put("songHAlbumUrl", "TEXT");
    localStringBuilder.append(" songHAlbumUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "songAlbumLocalPath";
    locala.IBN.put("songAlbumLocalPath", "TEXT");
    localStringBuilder.append(" songAlbumLocalPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "songWifiUrl";
    locala.IBN.put("songWifiUrl", "TEXT");
    localStringBuilder.append(" songWifiUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "songWapLinkUrl";
    locala.IBN.put("songWapLinkUrl", "TEXT");
    localStringBuilder.append(" songWapLinkUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "songWebUrl";
    locala.IBN.put("songWebUrl", "TEXT");
    localStringBuilder.append(" songWebUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "appId";
    locala.IBN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "songMediaId";
    locala.IBN.put("songMediaId", "TEXT");
    localStringBuilder.append(" songMediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "songSnsAlbumUser";
    locala.IBN.put("songSnsAlbumUser", "TEXT");
    localStringBuilder.append(" songSnsAlbumUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "songSnsShareUser";
    locala.IBN.put("songSnsShareUser", "TEXT");
    localStringBuilder.append(" songSnsShareUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "songLyric";
    locala.IBN.put("songLyric", "TEXT");
    localStringBuilder.append(" songLyric TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "songBgColor";
    locala.IBN.put("songBgColor", "INTEGER");
    localStringBuilder.append(" songBgColor INTEGER");
    localStringBuilder.append(", ");
    locala.columns[25] = "songLyricColor";
    locala.IBN.put("songLyricColor", "INTEGER");
    localStringBuilder.append(" songLyricColor INTEGER");
    localStringBuilder.append(", ");
    locala.columns[26] = "songFileLength";
    locala.IBN.put("songFileLength", "LONG");
    localStringBuilder.append(" songFileLength LONG");
    localStringBuilder.append(", ");
    locala.columns[27] = "songWifiFileLength";
    locala.IBN.put("songWifiFileLength", "LONG");
    localStringBuilder.append(" songWifiFileLength LONG");
    localStringBuilder.append(", ");
    locala.columns[28] = "hideBanner";
    locala.IBN.put("hideBanner", "INTEGER");
    localStringBuilder.append(" hideBanner INTEGER");
    localStringBuilder.append(", ");
    locala.columns[29] = "jsWebUrlDomain";
    locala.IBN.put("jsWebUrlDomain", "TEXT");
    localStringBuilder.append(" jsWebUrlDomain TEXT");
    localStringBuilder.append(", ");
    locala.columns[30] = "isBlock";
    locala.IBN.put("isBlock", "INTEGER");
    localStringBuilder.append(" isBlock INTEGER");
    localStringBuilder.append(", ");
    locala.columns[31] = "startTime";
    locala.IBN.put("startTime", "INTEGER");
    localStringBuilder.append(" startTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[32] = "mimetype";
    locala.IBN.put("mimetype", "TEXT");
    localStringBuilder.append(" mimetype TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "protocol";
    locala.IBN.put("protocol", "TEXT");
    localStringBuilder.append(" protocol TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "barBackToWebView";
    locala.IBN.put("barBackToWebView", "INTEGER");
    localStringBuilder.append(" barBackToWebView INTEGER");
    localStringBuilder.append(", ");
    locala.columns[35] = "musicbar_url";
    locala.IBN.put("musicbar_url", "TEXT");
    localStringBuilder.append(" musicbar_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[36] = "srcUsername";
    locala.IBN.put("srcUsername", "TEXT");
    localStringBuilder.append(" srcUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[37] = "playbackRate";
    locala.IBN.put("playbackRate", "DOUBLE");
    localStringBuilder.append(" playbackRate DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[38] = "songMId";
    locala.IBN.put("songMId", "TEXT");
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
      if (fnH != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.fmX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fnI == k)
      {
        this.field_originMusicId = paramCursor.getString(i);
      }
      else if (fnJ == k)
      {
        this.field_musicType = paramCursor.getInt(i);
      }
      else if (fnK == k)
      {
        this.field_downloadedLength = paramCursor.getLong(i);
      }
      else if (fnL == k)
      {
        this.field_wifiDownloadedLength = paramCursor.getLong(i);
      }
      else if (fnM == k)
      {
        this.field_endFlag = paramCursor.getInt(i);
      }
      else if (fnN == k)
      {
        this.field_wifiEndFlag = paramCursor.getInt(i);
      }
      else if (eGZ == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (fnO == k)
      {
        this.field_songId = paramCursor.getInt(i);
      }
      else if (fnP == k)
      {
        this.field_songName = paramCursor.getString(i);
      }
      else if (fnQ == k)
      {
        this.field_songSinger = paramCursor.getString(i);
      }
      else if (fnR == k)
      {
        this.field_songAlbum = paramCursor.getString(i);
      }
      else if (fnS == k)
      {
        this.field_songAlbumType = paramCursor.getInt(i);
      }
      else if (fnT == k)
      {
        this.field_songAlbumUrl = paramCursor.getString(i);
      }
      else if (fnU == k)
      {
        this.field_songHAlbumUrl = paramCursor.getString(i);
      }
      else if (fnV == k)
      {
        this.field_songAlbumLocalPath = paramCursor.getString(i);
      }
      else if (fnW == k)
      {
        this.field_songWifiUrl = paramCursor.getString(i);
      }
      else if (fnX == k)
      {
        this.field_songWapLinkUrl = paramCursor.getString(i);
      }
      else if (fnY == k)
      {
        this.field_songWebUrl = paramCursor.getString(i);
      }
      else if (eGD == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else if (fnZ == k)
      {
        this.field_songMediaId = paramCursor.getString(i);
      }
      else if (foa == k)
      {
        this.field_songSnsAlbumUser = paramCursor.getString(i);
      }
      else if (fob == k)
      {
        this.field_songSnsShareUser = paramCursor.getString(i);
      }
      else if (foc == k)
      {
        this.field_songLyric = paramCursor.getString(i);
      }
      else if (fod == k)
      {
        this.field_songBgColor = paramCursor.getInt(i);
      }
      else if (foe == k)
      {
        this.field_songLyricColor = paramCursor.getInt(i);
      }
      else if (fof == k)
      {
        this.field_songFileLength = paramCursor.getLong(i);
      }
      else if (fog == k)
      {
        this.field_songWifiFileLength = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (foh == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hideBanner = bool;
            break;
          }
        }
        if (foi == k)
        {
          this.field_jsWebUrlDomain = paramCursor.getString(i);
        }
        else if (foj == k)
        {
          this.field_isBlock = paramCursor.getInt(i);
        }
        else if (eEX == k)
        {
          this.field_startTime = paramCursor.getInt(i);
        }
        else if (fok == k)
        {
          this.field_mimetype = paramCursor.getString(i);
        }
        else if (fol == k)
        {
          this.field_protocol = paramCursor.getString(i);
        }
        else
        {
          if (fom == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_barBackToWebView = bool;
              break;
            }
          }
          if (fon == k) {
            this.field_musicbar_url = paramCursor.getString(i);
          } else if (foo == k) {
            this.field_srcUsername = paramCursor.getString(i);
          } else if (fop == k) {
            this.field_playbackRate = paramCursor.getDouble(i);
          } else if (foq == k) {
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
    if (this.fmX) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.fmY) {
      localContentValues.put("originMusicId", this.field_originMusicId);
    }
    if (this.fmZ) {
      localContentValues.put("musicType", Integer.valueOf(this.field_musicType));
    }
    if (this.fna) {
      localContentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
    }
    if (this.fnb) {
      localContentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
    }
    if (this.fnc) {
      localContentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
    }
    if (this.fnd) {
      localContentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fne) {
      localContentValues.put("songId", Integer.valueOf(this.field_songId));
    }
    if (this.fnf) {
      localContentValues.put("songName", this.field_songName);
    }
    if (this.fng) {
      localContentValues.put("songSinger", this.field_songSinger);
    }
    if (this.fnh) {
      localContentValues.put("songAlbum", this.field_songAlbum);
    }
    if (this.fni) {
      localContentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
    }
    if (this.fnj) {
      localContentValues.put("songAlbumUrl", this.field_songAlbumUrl);
    }
    if (this.fnk) {
      localContentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
    }
    if (this.fnl) {
      localContentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
    }
    if (this.fnm) {
      localContentValues.put("songWifiUrl", this.field_songWifiUrl);
    }
    if (this.fnn) {
      localContentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
    }
    if (this.fno) {
      localContentValues.put("songWebUrl", this.field_songWebUrl);
    }
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fnp) {
      localContentValues.put("songMediaId", this.field_songMediaId);
    }
    if (this.fnq) {
      localContentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
    }
    if (this.fnr) {
      localContentValues.put("songSnsShareUser", this.field_songSnsShareUser);
    }
    if (this.fns) {
      localContentValues.put("songLyric", this.field_songLyric);
    }
    if (this.fnt) {
      localContentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
    }
    if (this.fnu) {
      localContentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
    }
    if (this.fnv) {
      localContentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
    }
    if (this.fnw) {
      localContentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
    }
    if (this.fnx) {
      localContentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
    }
    if (this.fny) {
      localContentValues.put("jsWebUrlDomain", this.field_jsWebUrlDomain);
    }
    if (this.fnz) {
      localContentValues.put("isBlock", Integer.valueOf(this.field_isBlock));
    }
    if (this.eEQ) {
      localContentValues.put("startTime", Integer.valueOf(this.field_startTime));
    }
    if (this.fnA) {
      localContentValues.put("mimetype", this.field_mimetype);
    }
    if (this.fnB) {
      localContentValues.put("protocol", this.field_protocol);
    }
    if (this.fnC) {
      localContentValues.put("barBackToWebView", Boolean.valueOf(this.field_barBackToWebView));
    }
    if (this.fnD) {
      localContentValues.put("musicbar_url", this.field_musicbar_url);
    }
    if (this.fnE) {
      localContentValues.put("srcUsername", this.field_srcUsername);
    }
    if (this.fnF) {
      localContentValues.put("playbackRate", Double.valueOf(this.field_playbackRate));
    }
    if (this.fnG) {
      localContentValues.put("songMId", this.field_songMId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.em
 * JD-Core Version:    0.7.0.1
 */