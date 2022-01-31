package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bs
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dfJ;
  private static final int dfV;
  private static final int dhB;
  private static final int dhV = "updateTime".hashCode();
  private static final int dhi;
  private static final int djq;
  private static final int dmD;
  private static final int doH;
  private static final int doI;
  private static final int doK;
  private static final int dtX;
  private static final int dxU = "downloadId".hashCode();
  private static final int dxV;
  private static final int dxW;
  private static final int dxX;
  private static final int dxY;
  private static final int dxZ;
  private static final int dya;
  private static final int dyb;
  private static final int dyc;
  private static final int dyd;
  private static final int dye;
  private static final int dyf;
  private static final int dyg;
  private static final int dyh;
  private static final int dyi;
  private static final int dyj;
  private static final int dyk;
  private static final int dyl;
  private static final int dym;
  private static final int dyn;
  private static final int dyo;
  private static final int dyp = "reserveInWifi".hashCode();
  private static final int dyq = "ssid".hashCode();
  private static final int dyr = "uiarea".hashCode();
  private static final int dys = "noticeId".hashCode();
  private static final int dyt = "downloadType".hashCode();
  private static final int dyu = "startScene".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dfG = true;
  private boolean dfO = true;
  private boolean dhT = true;
  private boolean dhg = true;
  private boolean dhk = true;
  private boolean diT = true;
  private boolean dmp = true;
  private boolean doA = true;
  private boolean doC = true;
  private boolean doz = true;
  private boolean dtk = true;
  private boolean dxA = true;
  private boolean dxB = true;
  private boolean dxC = true;
  private boolean dxD = true;
  private boolean dxE = true;
  private boolean dxF = true;
  private boolean dxG = true;
  private boolean dxH = true;
  private boolean dxI = true;
  private boolean dxJ = true;
  private boolean dxK = true;
  private boolean dxL = true;
  private boolean dxM = true;
  private boolean dxN = true;
  private boolean dxO = true;
  private boolean dxP = true;
  private boolean dxQ = true;
  private boolean dxR = true;
  private boolean dxS = true;
  private boolean dxT = true;
  private boolean dxt = true;
  private boolean dxu = true;
  private boolean dxv = true;
  private boolean dxw = true;
  private boolean dxx = true;
  private boolean dxy = true;
  private boolean dxz = true;
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
  public String field_packageName;
  public boolean field_reserveInWifi;
  public int field_scene;
  public String field_secondaryUrl;
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
  
  static
  {
    doI = "downloadUrl".hashCode();
    dxV = "secondaryUrl".hashCode();
    dxW = "fileSize".hashCode();
    dxX = "fileName".hashCode();
    doK = "filePath".hashCode();
    dxY = "fileType".hashCode();
    dfJ = "status".hashCode();
    dtX = "md5".hashCode();
    dxZ = "autoInstall".hashCode();
    dya = "showNotification".hashCode();
    dyb = "sysDownloadId".hashCode();
    dyc = "downloaderType".hashCode();
    dhB = "appId".hashCode();
    doH = "downloadUrlHashCode".hashCode();
    djq = "packageName".hashCode();
    dyd = "downloadedSize".hashCode();
    dye = "totalSize".hashCode();
    dyf = "autoDownload".hashCode();
    dyg = "channelId".hashCode();
    dhi = "scene".hashCode();
    dyh = "errCode".hashCode();
    dfV = "startTime".hashCode();
    dyi = "startSize".hashCode();
    dyj = "startState".hashCode();
    dyk = "fromWeApp".hashCode();
    dyl = "downloadInWifi".hashCode();
    dmD = "extInfo".hashCode();
    dym = "finishTime".hashCode();
    dyn = "isSecondDownload".hashCode();
    dyo = "fromDownloadApp".hashCode();
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
      if (dxU != k) {
        break label65;
      }
      this.field_downloadId = paramCursor.getLong(i);
      this.dxt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (doI == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (dxV == k)
      {
        this.field_secondaryUrl = paramCursor.getString(i);
      }
      else if (dxW == k)
      {
        this.field_fileSize = paramCursor.getLong(i);
      }
      else if (dxX == k)
      {
        this.field_fileName = paramCursor.getString(i);
      }
      else if (doK == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (dxY == k)
      {
        this.field_fileType = paramCursor.getInt(i);
      }
      else if (dfJ == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (dtX == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (dxZ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_autoInstall = bool;
            break;
          }
        }
        if (dya == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showNotification = bool;
            break;
          }
        }
        if (dyb == k)
        {
          this.field_sysDownloadId = paramCursor.getLong(i);
        }
        else if (dyc == k)
        {
          this.field_downloaderType = paramCursor.getInt(i);
        }
        else if (dhB == k)
        {
          this.field_appId = paramCursor.getString(i);
        }
        else if (doH == k)
        {
          this.field_downloadUrlHashCode = paramCursor.getInt(i);
        }
        else if (djq == k)
        {
          this.field_packageName = paramCursor.getString(i);
        }
        else if (dyd == k)
        {
          this.field_downloadedSize = paramCursor.getLong(i);
        }
        else if (dye == k)
        {
          this.field_totalSize = paramCursor.getLong(i);
        }
        else
        {
          if (dyf == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_autoDownload = bool;
              break;
            }
          }
          if (dyg == k)
          {
            this.field_channelId = paramCursor.getString(i);
          }
          else if (dhi == k)
          {
            this.field_scene = paramCursor.getInt(i);
          }
          else if (dyh == k)
          {
            this.field_errCode = paramCursor.getInt(i);
          }
          else if (dfV == k)
          {
            this.field_startTime = paramCursor.getLong(i);
          }
          else if (dyi == k)
          {
            this.field_startSize = paramCursor.getLong(i);
          }
          else if (dyj == k)
          {
            this.field_startState = paramCursor.getInt(i);
          }
          else
          {
            if (dyk == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_fromWeApp = bool;
                break;
              }
            }
            if (dyl == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWifi = bool;
                break;
              }
            }
            if (dmD == k)
            {
              this.field_extInfo = paramCursor.getString(i);
            }
            else if (dym == k)
            {
              this.field_finishTime = paramCursor.getLong(i);
            }
            else
            {
              if (dyn == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_isSecondDownload = bool;
                  break;
                }
              }
              if (dyo == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_fromDownloadApp = bool;
                  break;
                }
              }
              if (dhV == k)
              {
                this.field_updateTime = paramCursor.getLong(i);
              }
              else
              {
                if (dyp == k)
                {
                  if (paramCursor.getInt(i) != 0) {}
                  for (bool = true;; bool = false)
                  {
                    this.field_reserveInWifi = bool;
                    break;
                  }
                }
                if (dyq == k) {
                  this.field_ssid = paramCursor.getInt(i);
                } else if (dyr == k) {
                  this.field_uiarea = paramCursor.getInt(i);
                } else if (dys == k) {
                  this.field_noticeId = paramCursor.getInt(i);
                } else if (dyt == k) {
                  this.field_downloadType = paramCursor.getInt(i);
                } else if (dyu == k) {
                  this.field_startScene = paramCursor.getInt(i);
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
    if (this.dxt) {
      localContentValues.put("downloadId", Long.valueOf(this.field_downloadId));
    }
    if (this.field_downloadUrl == null) {
      this.field_downloadUrl = "";
    }
    if (this.doA) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.field_secondaryUrl == null) {
      this.field_secondaryUrl = "";
    }
    if (this.dxu) {
      localContentValues.put("secondaryUrl", this.field_secondaryUrl);
    }
    if (this.dxv) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.field_fileName == null) {
      this.field_fileName = "";
    }
    if (this.dxw) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.field_filePath == null) {
      this.field_filePath = "";
    }
    if (this.doC) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.dxx) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.field_md5 == null) {
      this.field_md5 = "";
    }
    if (this.dtk) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.dxy) {
      localContentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
    }
    if (this.dxz) {
      localContentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
    }
    if (this.dxA) {
      localContentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
    }
    if (this.dxB) {
      localContentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
    }
    if (this.field_appId == null) {
      this.field_appId = "";
    }
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.doz) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.field_packageName == null) {
      this.field_packageName = "";
    }
    if (this.diT) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.dxC) {
      localContentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
    }
    if (this.dxD) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.dxE) {
      localContentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
    }
    if (this.field_channelId == null) {
      this.field_channelId = "";
    }
    if (this.dxF) {
      localContentValues.put("channelId", this.field_channelId);
    }
    if (this.dhg) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.dxG) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.dfO) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.dxH) {
      localContentValues.put("startSize", Long.valueOf(this.field_startSize));
    }
    if (this.dxI) {
      localContentValues.put("startState", Integer.valueOf(this.field_startState));
    }
    if (this.dxJ) {
      localContentValues.put("fromWeApp", Boolean.valueOf(this.field_fromWeApp));
    }
    if (this.dxK) {
      localContentValues.put("downloadInWifi", Boolean.valueOf(this.field_downloadInWifi));
    }
    if (this.field_extInfo == null) {
      this.field_extInfo = "";
    }
    if (this.dmp) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.dxL) {
      localContentValues.put("finishTime", Long.valueOf(this.field_finishTime));
    }
    if (this.dxM) {
      localContentValues.put("isSecondDownload", Boolean.valueOf(this.field_isSecondDownload));
    }
    if (this.dxN) {
      localContentValues.put("fromDownloadApp", Boolean.valueOf(this.field_fromDownloadApp));
    }
    if (this.dhT) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.dxO) {
      localContentValues.put("reserveInWifi", Boolean.valueOf(this.field_reserveInWifi));
    }
    if (this.dxP) {
      localContentValues.put("ssid", Integer.valueOf(this.field_ssid));
    }
    if (this.dxQ) {
      localContentValues.put("uiarea", Integer.valueOf(this.field_uiarea));
    }
    if (this.dxR) {
      localContentValues.put("noticeId", Integer.valueOf(this.field_noticeId));
    }
    if (this.dxS) {
      localContentValues.put("downloadType", Integer.valueOf(this.field_downloadType));
    }
    if (this.dxT) {
      localContentValues.put("startScene", Integer.valueOf(this.field_startScene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.bs
 * JD-Core Version:    0.7.0.1
 */