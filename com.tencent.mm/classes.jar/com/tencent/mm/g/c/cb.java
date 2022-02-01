package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cb
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDc;
  private static final int eDo;
  private static final int eEB;
  private static final int eEU;
  private static final int eFq;
  private static final int eHa;
  private static final int eKz;
  private static final int eMZ;
  private static final int eNa;
  private static final int eNc;
  private static final int eSP;
  private static final int eWY = "downloadId".hashCode();
  private static final int eWZ;
  private static final int eXA = "rawAppId".hashCode();
  private static final int eXa;
  private static final int eXb;
  private static final int eXc;
  private static final int eXd;
  private static final int eXe;
  private static final int eXf;
  private static final int eXg;
  private static final int eXh;
  private static final int eXi;
  private static final int eXj;
  private static final int eXk;
  private static final int eXl;
  private static final int eXm;
  private static final int eXn;
  private static final int eXo;
  private static final int eXp;
  private static final int eXq;
  private static final int eXr;
  private static final int eXs;
  private static final int eXt;
  private static final int eXu;
  private static final int eXv;
  private static final int eXw;
  private static final int eXx;
  private static final int eXy;
  private static final int eXz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eDh = true;
  private boolean eED = true;
  private boolean eEz = true;
  private boolean eFn = true;
  private boolean eGE = true;
  private boolean eKl = true;
  private boolean eMR = true;
  private boolean eMS = true;
  private boolean eMU = true;
  private boolean eSd = true;
  private boolean eWA = true;
  private boolean eWB = true;
  private boolean eWC = true;
  private boolean eWD = true;
  private boolean eWE = true;
  private boolean eWF = true;
  private boolean eWG = true;
  private boolean eWH = true;
  private boolean eWI = true;
  private boolean eWJ = true;
  private boolean eWK = true;
  private boolean eWL = true;
  private boolean eWM = true;
  private boolean eWN = true;
  private boolean eWO = true;
  private boolean eWP = true;
  private boolean eWQ = true;
  private boolean eWR = true;
  private boolean eWS = true;
  private boolean eWT = true;
  private boolean eWU = true;
  private boolean eWV = true;
  private boolean eWW = true;
  private boolean eWX = true;
  private boolean eWv = true;
  private boolean eWw = true;
  private boolean eWx = true;
  private boolean eWy = true;
  private boolean eWz = true;
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
    eNa = "downloadUrl".hashCode();
    eWZ = "secondaryUrl".hashCode();
    eXa = "fileSize".hashCode();
    eXb = "fileName".hashCode();
    eNc = "filePath".hashCode();
    eXc = "fileType".hashCode();
    eDc = "status".hashCode();
    eSP = "md5".hashCode();
    eXd = "autoInstall".hashCode();
    eXe = "showNotification".hashCode();
    eXf = "sysDownloadId".hashCode();
    eXg = "downloaderType".hashCode();
    eEU = "appId".hashCode();
    eMZ = "downloadUrlHashCode".hashCode();
    eHa = "packageName".hashCode();
    eXh = "downloadedSize".hashCode();
    eXi = "totalSize".hashCode();
    eXj = "autoDownload".hashCode();
    eXk = "channelId".hashCode();
    eEB = "scene".hashCode();
    eXl = "errCode".hashCode();
    eDo = "startTime".hashCode();
    eXm = "startSize".hashCode();
    eXn = "startState".hashCode();
    eXo = "fromWeApp".hashCode();
    eXp = "downloadInWifi".hashCode();
    eKz = "extInfo".hashCode();
    eXq = "finishTime".hashCode();
    eXr = "isSecondDownload".hashCode();
    eXs = "fromDownloadApp".hashCode();
    eFq = "updateTime".hashCode();
    eXt = "reserveInWifi".hashCode();
    eXu = "ssid".hashCode();
    eXv = "uiarea".hashCode();
    eXw = "noticeId".hashCode();
    eXx = "downloadType".hashCode();
    eXy = "startScene".hashCode();
    eXz = "sectionMd5Byte".hashCode();
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
      if (eWY != k) {
        break label65;
      }
      this.field_downloadId = paramCursor.getLong(i);
      this.eWv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eNa == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (eWZ == k)
      {
        this.field_secondaryUrl = paramCursor.getString(i);
      }
      else if (eXa == k)
      {
        this.field_fileSize = paramCursor.getLong(i);
      }
      else if (eXb == k)
      {
        this.field_fileName = paramCursor.getString(i);
      }
      else if (eNc == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (eXc == k)
      {
        this.field_fileType = paramCursor.getInt(i);
      }
      else if (eDc == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (eSP == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (eXd == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_autoInstall = bool;
            break;
          }
        }
        if (eXe == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showNotification = bool;
            break;
          }
        }
        if (eXf == k)
        {
          this.field_sysDownloadId = paramCursor.getLong(i);
        }
        else if (eXg == k)
        {
          this.field_downloaderType = paramCursor.getInt(i);
        }
        else if (eEU == k)
        {
          this.field_appId = paramCursor.getString(i);
        }
        else if (eMZ == k)
        {
          this.field_downloadUrlHashCode = paramCursor.getInt(i);
        }
        else if (eHa == k)
        {
          this.field_packageName = paramCursor.getString(i);
        }
        else if (eXh == k)
        {
          this.field_downloadedSize = paramCursor.getLong(i);
        }
        else if (eXi == k)
        {
          this.field_totalSize = paramCursor.getLong(i);
        }
        else
        {
          if (eXj == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_autoDownload = bool;
              break;
            }
          }
          if (eXk == k)
          {
            this.field_channelId = paramCursor.getString(i);
          }
          else if (eEB == k)
          {
            this.field_scene = paramCursor.getInt(i);
          }
          else if (eXl == k)
          {
            this.field_errCode = paramCursor.getInt(i);
          }
          else if (eDo == k)
          {
            this.field_startTime = paramCursor.getLong(i);
          }
          else if (eXm == k)
          {
            this.field_startSize = paramCursor.getLong(i);
          }
          else if (eXn == k)
          {
            this.field_startState = paramCursor.getInt(i);
          }
          else
          {
            if (eXo == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_fromWeApp = bool;
                break;
              }
            }
            if (eXp == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWifi = bool;
                break;
              }
            }
            if (eKz == k)
            {
              this.field_extInfo = paramCursor.getString(i);
            }
            else if (eXq == k)
            {
              this.field_finishTime = paramCursor.getLong(i);
            }
            else
            {
              if (eXr == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_isSecondDownload = bool;
                  break;
                }
              }
              if (eXs == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_fromDownloadApp = bool;
                  break;
                }
              }
              if (eFq == k)
              {
                this.field_updateTime = paramCursor.getLong(i);
              }
              else
              {
                if (eXt == k)
                {
                  if (paramCursor.getInt(i) != 0) {}
                  for (bool = true;; bool = false)
                  {
                    this.field_reserveInWifi = bool;
                    break;
                  }
                }
                if (eXu == k) {
                  this.field_ssid = paramCursor.getInt(i);
                } else if (eXv == k) {
                  this.field_uiarea = paramCursor.getInt(i);
                } else if (eXw == k) {
                  this.field_noticeId = paramCursor.getInt(i);
                } else if (eXx == k) {
                  this.field_downloadType = paramCursor.getInt(i);
                } else if (eXy == k) {
                  this.field_startScene = paramCursor.getInt(i);
                } else if (eXz == k) {
                  this.field_sectionMd5Byte = paramCursor.getBlob(i);
                } else if (eXA == k) {
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
    if (this.eWv) {
      localContentValues.put("downloadId", Long.valueOf(this.field_downloadId));
    }
    if (this.field_downloadUrl == null) {
      this.field_downloadUrl = "";
    }
    if (this.eMS) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.field_secondaryUrl == null) {
      this.field_secondaryUrl = "";
    }
    if (this.eWw) {
      localContentValues.put("secondaryUrl", this.field_secondaryUrl);
    }
    if (this.eWx) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.field_fileName == null) {
      this.field_fileName = "";
    }
    if (this.eWy) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.field_filePath == null) {
      this.field_filePath = "";
    }
    if (this.eMU) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.eWz) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.field_md5 == null) {
      this.field_md5 = "";
    }
    if (this.eSd) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eWA) {
      localContentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
    }
    if (this.eWB) {
      localContentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
    }
    if (this.eWC) {
      localContentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
    }
    if (this.eWD) {
      localContentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
    }
    if (this.field_appId == null) {
      this.field_appId = "";
    }
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eMR) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.field_packageName == null) {
      this.field_packageName = "";
    }
    if (this.eGE) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.eWE) {
      localContentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
    }
    if (this.eWF) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.eWG) {
      localContentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
    }
    if (this.field_channelId == null) {
      this.field_channelId = "";
    }
    if (this.eWH) {
      localContentValues.put("channelId", this.field_channelId);
    }
    if (this.eEz) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eWI) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.eDh) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.eWJ) {
      localContentValues.put("startSize", Long.valueOf(this.field_startSize));
    }
    if (this.eWK) {
      localContentValues.put("startState", Integer.valueOf(this.field_startState));
    }
    if (this.eWL) {
      localContentValues.put("fromWeApp", Boolean.valueOf(this.field_fromWeApp));
    }
    if (this.eWM) {
      localContentValues.put("downloadInWifi", Boolean.valueOf(this.field_downloadInWifi));
    }
    if (this.field_extInfo == null) {
      this.field_extInfo = "";
    }
    if (this.eKl) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.eWN) {
      localContentValues.put("finishTime", Long.valueOf(this.field_finishTime));
    }
    if (this.eWO) {
      localContentValues.put("isSecondDownload", Boolean.valueOf(this.field_isSecondDownload));
    }
    if (this.eWP) {
      localContentValues.put("fromDownloadApp", Boolean.valueOf(this.field_fromDownloadApp));
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eWQ) {
      localContentValues.put("reserveInWifi", Boolean.valueOf(this.field_reserveInWifi));
    }
    if (this.eWR) {
      localContentValues.put("ssid", Integer.valueOf(this.field_ssid));
    }
    if (this.eWS) {
      localContentValues.put("uiarea", Integer.valueOf(this.field_uiarea));
    }
    if (this.eWT) {
      localContentValues.put("noticeId", Integer.valueOf(this.field_noticeId));
    }
    if (this.eWU) {
      localContentValues.put("downloadType", Integer.valueOf(this.field_downloadType));
    }
    if (this.eWV) {
      localContentValues.put("startScene", Integer.valueOf(this.field_startScene));
    }
    if (this.eWW) {
      localContentValues.put("sectionMd5Byte", this.field_sectionMd5Byte);
    }
    if (this.field_rawAppId == null) {
      this.field_rawAppId = "";
    }
    if (this.eWX) {
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