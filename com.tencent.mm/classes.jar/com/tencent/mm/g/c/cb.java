package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cb
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL;
  private static final int eEX;
  private static final int eGD;
  private static final int eGZ = "updateTime".hashCode();
  private static final int eGk;
  private static final int eIJ;
  private static final int eMi;
  private static final int eOK;
  private static final int eOL;
  private static final int eON;
  private static final int eUA;
  private static final int eYJ = "downloadId".hashCode();
  private static final int eYK;
  private static final int eYL;
  private static final int eYM;
  private static final int eYN;
  private static final int eYO;
  private static final int eYP;
  private static final int eYQ;
  private static final int eYR;
  private static final int eYS;
  private static final int eYT;
  private static final int eYU;
  private static final int eYV;
  private static final int eYW;
  private static final int eYX;
  private static final int eYY;
  private static final int eYZ;
  private static final int eZa;
  private static final int eZb;
  private static final int eZc;
  private static final int eZd;
  private static final int eZe = "reserveInWifi".hashCode();
  private static final int eZf = "ssid".hashCode();
  private static final int eZg = "uiarea".hashCode();
  private static final int eZh = "noticeId".hashCode();
  private static final int eZi = "downloadType".hashCode();
  private static final int eZj = "startScene".hashCode();
  private static final int eZk = "sectionMd5Byte".hashCode();
  private static final int eZl = "rawAppId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  private boolean eEQ = true;
  private boolean eGW = true;
  private boolean eGi = true;
  private boolean eGm = true;
  private boolean eIn = true;
  private boolean eLU = true;
  private boolean eOC = true;
  private boolean eOD = true;
  private boolean eOF = true;
  private boolean eTO = true;
  private boolean eYA = true;
  private boolean eYB = true;
  private boolean eYC = true;
  private boolean eYD = true;
  private boolean eYE = true;
  private boolean eYF = true;
  private boolean eYG = true;
  private boolean eYH = true;
  private boolean eYI = true;
  private boolean eYg = true;
  private boolean eYh = true;
  private boolean eYi = true;
  private boolean eYj = true;
  private boolean eYk = true;
  private boolean eYl = true;
  private boolean eYm = true;
  private boolean eYn = true;
  private boolean eYo = true;
  private boolean eYp = true;
  private boolean eYq = true;
  private boolean eYr = true;
  private boolean eYs = true;
  private boolean eYt = true;
  private boolean eYu = true;
  private boolean eYv = true;
  private boolean eYw = true;
  private boolean eYx = true;
  private boolean eYy = true;
  private boolean eYz = true;
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
  public String field_rawAppId;
  public boolean field_reserveInWifi;
  public int field_scene;
  public String field_secondaryUrl;
  public byte[] field_sectionMd5Byte;
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
    eOL = "downloadUrl".hashCode();
    eYK = "secondaryUrl".hashCode();
    eYL = "fileSize".hashCode();
    eYM = "fileName".hashCode();
    eON = "filePath".hashCode();
    eYN = "fileType".hashCode();
    eEL = "status".hashCode();
    eUA = "md5".hashCode();
    eYO = "autoInstall".hashCode();
    eYP = "showNotification".hashCode();
    eYQ = "sysDownloadId".hashCode();
    eYR = "downloaderType".hashCode();
    eGD = "appId".hashCode();
    eOK = "downloadUrlHashCode".hashCode();
    eIJ = "packageName".hashCode();
    eYS = "downloadedSize".hashCode();
    eYT = "totalSize".hashCode();
    eYU = "autoDownload".hashCode();
    eYV = "channelId".hashCode();
    eGk = "scene".hashCode();
    eYW = "errCode".hashCode();
    eEX = "startTime".hashCode();
    eYX = "startSize".hashCode();
    eYY = "startState".hashCode();
    eYZ = "fromWeApp".hashCode();
    eZa = "downloadInWifi".hashCode();
    eMi = "extInfo".hashCode();
    eZb = "finishTime".hashCode();
    eZc = "isSecondDownload".hashCode();
    eZd = "fromDownloadApp".hashCode();
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
      if (eYJ != k) {
        break label65;
      }
      this.field_downloadId = paramCursor.getLong(i);
      this.eYg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eOL == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (eYK == k)
      {
        this.field_secondaryUrl = paramCursor.getString(i);
      }
      else if (eYL == k)
      {
        this.field_fileSize = paramCursor.getLong(i);
      }
      else if (eYM == k)
      {
        this.field_fileName = paramCursor.getString(i);
      }
      else if (eON == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (eYN == k)
      {
        this.field_fileType = paramCursor.getInt(i);
      }
      else if (eEL == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (eUA == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (eYO == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_autoInstall = bool;
            break;
          }
        }
        if (eYP == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showNotification = bool;
            break;
          }
        }
        if (eYQ == k)
        {
          this.field_sysDownloadId = paramCursor.getLong(i);
        }
        else if (eYR == k)
        {
          this.field_downloaderType = paramCursor.getInt(i);
        }
        else if (eGD == k)
        {
          this.field_appId = paramCursor.getString(i);
        }
        else if (eOK == k)
        {
          this.field_downloadUrlHashCode = paramCursor.getInt(i);
        }
        else if (eIJ == k)
        {
          this.field_packageName = paramCursor.getString(i);
        }
        else if (eYS == k)
        {
          this.field_downloadedSize = paramCursor.getLong(i);
        }
        else if (eYT == k)
        {
          this.field_totalSize = paramCursor.getLong(i);
        }
        else
        {
          if (eYU == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_autoDownload = bool;
              break;
            }
          }
          if (eYV == k)
          {
            this.field_channelId = paramCursor.getString(i);
          }
          else if (eGk == k)
          {
            this.field_scene = paramCursor.getInt(i);
          }
          else if (eYW == k)
          {
            this.field_errCode = paramCursor.getInt(i);
          }
          else if (eEX == k)
          {
            this.field_startTime = paramCursor.getLong(i);
          }
          else if (eYX == k)
          {
            this.field_startSize = paramCursor.getLong(i);
          }
          else if (eYY == k)
          {
            this.field_startState = paramCursor.getInt(i);
          }
          else
          {
            if (eYZ == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_fromWeApp = bool;
                break;
              }
            }
            if (eZa == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWifi = bool;
                break;
              }
            }
            if (eMi == k)
            {
              this.field_extInfo = paramCursor.getString(i);
            }
            else if (eZb == k)
            {
              this.field_finishTime = paramCursor.getLong(i);
            }
            else
            {
              if (eZc == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_isSecondDownload = bool;
                  break;
                }
              }
              if (eZd == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_fromDownloadApp = bool;
                  break;
                }
              }
              if (eGZ == k)
              {
                this.field_updateTime = paramCursor.getLong(i);
              }
              else
              {
                if (eZe == k)
                {
                  if (paramCursor.getInt(i) != 0) {}
                  for (bool = true;; bool = false)
                  {
                    this.field_reserveInWifi = bool;
                    break;
                  }
                }
                if (eZf == k) {
                  this.field_ssid = paramCursor.getInt(i);
                } else if (eZg == k) {
                  this.field_uiarea = paramCursor.getInt(i);
                } else if (eZh == k) {
                  this.field_noticeId = paramCursor.getInt(i);
                } else if (eZi == k) {
                  this.field_downloadType = paramCursor.getInt(i);
                } else if (eZj == k) {
                  this.field_startScene = paramCursor.getInt(i);
                } else if (eZk == k) {
                  this.field_sectionMd5Byte = paramCursor.getBlob(i);
                } else if (eZl == k) {
                  this.field_rawAppId = paramCursor.getString(i);
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
    if (this.eYg) {
      localContentValues.put("downloadId", Long.valueOf(this.field_downloadId));
    }
    if (this.field_downloadUrl == null) {
      this.field_downloadUrl = "";
    }
    if (this.eOD) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.field_secondaryUrl == null) {
      this.field_secondaryUrl = "";
    }
    if (this.eYh) {
      localContentValues.put("secondaryUrl", this.field_secondaryUrl);
    }
    if (this.eYi) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.field_fileName == null) {
      this.field_fileName = "";
    }
    if (this.eYj) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.field_filePath == null) {
      this.field_filePath = "";
    }
    if (this.eOF) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.eYk) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.field_md5 == null) {
      this.field_md5 = "";
    }
    if (this.eTO) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eYl) {
      localContentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
    }
    if (this.eYm) {
      localContentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
    }
    if (this.eYn) {
      localContentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
    }
    if (this.eYo) {
      localContentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
    }
    if (this.field_appId == null) {
      this.field_appId = "";
    }
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eOC) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.field_packageName == null) {
      this.field_packageName = "";
    }
    if (this.eIn) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.eYp) {
      localContentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
    }
    if (this.eYq) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.eYr) {
      localContentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
    }
    if (this.field_channelId == null) {
      this.field_channelId = "";
    }
    if (this.eYs) {
      localContentValues.put("channelId", this.field_channelId);
    }
    if (this.eGi) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eYt) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.eEQ) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.eYu) {
      localContentValues.put("startSize", Long.valueOf(this.field_startSize));
    }
    if (this.eYv) {
      localContentValues.put("startState", Integer.valueOf(this.field_startState));
    }
    if (this.eYw) {
      localContentValues.put("fromWeApp", Boolean.valueOf(this.field_fromWeApp));
    }
    if (this.eYx) {
      localContentValues.put("downloadInWifi", Boolean.valueOf(this.field_downloadInWifi));
    }
    if (this.field_extInfo == null) {
      this.field_extInfo = "";
    }
    if (this.eLU) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.eYy) {
      localContentValues.put("finishTime", Long.valueOf(this.field_finishTime));
    }
    if (this.eYz) {
      localContentValues.put("isSecondDownload", Boolean.valueOf(this.field_isSecondDownload));
    }
    if (this.eYA) {
      localContentValues.put("fromDownloadApp", Boolean.valueOf(this.field_fromDownloadApp));
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eYB) {
      localContentValues.put("reserveInWifi", Boolean.valueOf(this.field_reserveInWifi));
    }
    if (this.eYC) {
      localContentValues.put("ssid", Integer.valueOf(this.field_ssid));
    }
    if (this.eYD) {
      localContentValues.put("uiarea", Integer.valueOf(this.field_uiarea));
    }
    if (this.eYE) {
      localContentValues.put("noticeId", Integer.valueOf(this.field_noticeId));
    }
    if (this.eYF) {
      localContentValues.put("downloadType", Integer.valueOf(this.field_downloadType));
    }
    if (this.eYG) {
      localContentValues.put("startScene", Integer.valueOf(this.field_startScene));
    }
    if (this.eYH) {
      localContentValues.put("sectionMd5Byte", this.field_sectionMd5Byte);
    }
    if (this.field_rawAppId == null) {
      this.field_rawAppId = "";
    }
    if (this.eYI) {
      localContentValues.put("rawAppId", this.field_rawAppId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cb
 * JD-Core Version:    0.7.0.1
 */