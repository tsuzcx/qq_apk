package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ca
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBr;
  private static final int eFA = "downloadId".hashCode();
  private static final int eFB;
  private static final int eFC;
  private static final int eFD;
  private static final int eFE;
  private static final int eFF;
  private static final int eFG;
  private static final int eFH;
  private static final int eFI;
  private static final int eFJ;
  private static final int eFK;
  private static final int eFL;
  private static final int eFM;
  private static final int eFN;
  private static final int eFO;
  private static final int eFP;
  private static final int eFQ;
  private static final int eFR;
  private static final int eFS;
  private static final int eFT;
  private static final int eFU;
  private static final int eFV = "reserveInWifi".hashCode();
  private static final int eFW = "ssid".hashCode();
  private static final int eFX = "uiarea".hashCode();
  private static final int eFY = "noticeId".hashCode();
  private static final int eFZ = "downloadType".hashCode();
  private static final int eGa = "startScene".hashCode();
  private static final int eGb = "sectionMd5Byte".hashCode();
  private static final int eGc = "rawAppId".hashCode();
  private static final int elV;
  private static final int emh;
  private static final int enO;
  private static final int env;
  private static final int eol;
  private static final int epR;
  private static final int etq;
  private static final int evC;
  private static final int evD = "downloadUrl".hashCode();
  private static final int evF;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAF = true;
  private boolean eEX = true;
  private boolean eEY = true;
  private boolean eEZ = true;
  private boolean eFa = true;
  private boolean eFb = true;
  private boolean eFc = true;
  private boolean eFd = true;
  private boolean eFe = true;
  private boolean eFf = true;
  private boolean eFg = true;
  private boolean eFh = true;
  private boolean eFi = true;
  private boolean eFj = true;
  private boolean eFk = true;
  private boolean eFl = true;
  private boolean eFm = true;
  private boolean eFn = true;
  private boolean eFo = true;
  private boolean eFp = true;
  private boolean eFq = true;
  private boolean eFr = true;
  private boolean eFs = true;
  private boolean eFt = true;
  private boolean eFu = true;
  private boolean eFv = true;
  private boolean eFw = true;
  private boolean eFx = true;
  private boolean eFy = true;
  private boolean eFz = true;
  private boolean elS = true;
  private boolean ema = true;
  private boolean ent = true;
  private boolean enx = true;
  private boolean eoi = true;
  private boolean epv = true;
  private boolean etc = true;
  private boolean evu = true;
  private boolean evv = true;
  private boolean evx = true;
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
    eFB = "secondaryUrl".hashCode();
    eFC = "fileSize".hashCode();
    eFD = "fileName".hashCode();
    evF = "filePath".hashCode();
    eFE = "fileType".hashCode();
    elV = "status".hashCode();
    eBr = "md5".hashCode();
    eFF = "autoInstall".hashCode();
    eFG = "showNotification".hashCode();
    eFH = "sysDownloadId".hashCode();
    eFI = "downloaderType".hashCode();
    enO = "appId".hashCode();
    evC = "downloadUrlHashCode".hashCode();
    epR = "packageName".hashCode();
    eFJ = "downloadedSize".hashCode();
    eFK = "totalSize".hashCode();
    eFL = "autoDownload".hashCode();
    eFM = "channelId".hashCode();
    env = "scene".hashCode();
    eFN = "errCode".hashCode();
    emh = "startTime".hashCode();
    eFO = "startSize".hashCode();
    eFP = "startState".hashCode();
    eFQ = "fromWeApp".hashCode();
    eFR = "downloadInWifi".hashCode();
    etq = "extInfo".hashCode();
    eFS = "finishTime".hashCode();
    eFT = "isSecondDownload".hashCode();
    eFU = "fromDownloadApp".hashCode();
    eol = "updateTime".hashCode();
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
      if (eFA != k) {
        break label65;
      }
      this.field_downloadId = paramCursor.getLong(i);
      this.eEX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (evD == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (eFB == k)
      {
        this.field_secondaryUrl = paramCursor.getString(i);
      }
      else if (eFC == k)
      {
        this.field_fileSize = paramCursor.getLong(i);
      }
      else if (eFD == k)
      {
        this.field_fileName = paramCursor.getString(i);
      }
      else if (evF == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (eFE == k)
      {
        this.field_fileType = paramCursor.getInt(i);
      }
      else if (elV == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (eBr == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (eFF == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_autoInstall = bool;
            break;
          }
        }
        if (eFG == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showNotification = bool;
            break;
          }
        }
        if (eFH == k)
        {
          this.field_sysDownloadId = paramCursor.getLong(i);
        }
        else if (eFI == k)
        {
          this.field_downloaderType = paramCursor.getInt(i);
        }
        else if (enO == k)
        {
          this.field_appId = paramCursor.getString(i);
        }
        else if (evC == k)
        {
          this.field_downloadUrlHashCode = paramCursor.getInt(i);
        }
        else if (epR == k)
        {
          this.field_packageName = paramCursor.getString(i);
        }
        else if (eFJ == k)
        {
          this.field_downloadedSize = paramCursor.getLong(i);
        }
        else if (eFK == k)
        {
          this.field_totalSize = paramCursor.getLong(i);
        }
        else
        {
          if (eFL == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_autoDownload = bool;
              break;
            }
          }
          if (eFM == k)
          {
            this.field_channelId = paramCursor.getString(i);
          }
          else if (env == k)
          {
            this.field_scene = paramCursor.getInt(i);
          }
          else if (eFN == k)
          {
            this.field_errCode = paramCursor.getInt(i);
          }
          else if (emh == k)
          {
            this.field_startTime = paramCursor.getLong(i);
          }
          else if (eFO == k)
          {
            this.field_startSize = paramCursor.getLong(i);
          }
          else if (eFP == k)
          {
            this.field_startState = paramCursor.getInt(i);
          }
          else
          {
            if (eFQ == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_fromWeApp = bool;
                break;
              }
            }
            if (eFR == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWifi = bool;
                break;
              }
            }
            if (etq == k)
            {
              this.field_extInfo = paramCursor.getString(i);
            }
            else if (eFS == k)
            {
              this.field_finishTime = paramCursor.getLong(i);
            }
            else
            {
              if (eFT == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_isSecondDownload = bool;
                  break;
                }
              }
              if (eFU == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_fromDownloadApp = bool;
                  break;
                }
              }
              if (eol == k)
              {
                this.field_updateTime = paramCursor.getLong(i);
              }
              else
              {
                if (eFV == k)
                {
                  if (paramCursor.getInt(i) != 0) {}
                  for (bool = true;; bool = false)
                  {
                    this.field_reserveInWifi = bool;
                    break;
                  }
                }
                if (eFW == k) {
                  this.field_ssid = paramCursor.getInt(i);
                } else if (eFX == k) {
                  this.field_uiarea = paramCursor.getInt(i);
                } else if (eFY == k) {
                  this.field_noticeId = paramCursor.getInt(i);
                } else if (eFZ == k) {
                  this.field_downloadType = paramCursor.getInt(i);
                } else if (eGa == k) {
                  this.field_startScene = paramCursor.getInt(i);
                } else if (eGb == k) {
                  this.field_sectionMd5Byte = paramCursor.getBlob(i);
                } else if (eGc == k) {
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
    if (this.eEX) {
      localContentValues.put("downloadId", Long.valueOf(this.field_downloadId));
    }
    if (this.field_downloadUrl == null) {
      this.field_downloadUrl = "";
    }
    if (this.evv) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.field_secondaryUrl == null) {
      this.field_secondaryUrl = "";
    }
    if (this.eEY) {
      localContentValues.put("secondaryUrl", this.field_secondaryUrl);
    }
    if (this.eEZ) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.field_fileName == null) {
      this.field_fileName = "";
    }
    if (this.eFa) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.field_filePath == null) {
      this.field_filePath = "";
    }
    if (this.evx) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.eFb) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.field_md5 == null) {
      this.field_md5 = "";
    }
    if (this.eAF) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eFc) {
      localContentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
    }
    if (this.eFd) {
      localContentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
    }
    if (this.eFe) {
      localContentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
    }
    if (this.eFf) {
      localContentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
    }
    if (this.field_appId == null) {
      this.field_appId = "";
    }
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.evu) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.field_packageName == null) {
      this.field_packageName = "";
    }
    if (this.epv) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.eFg) {
      localContentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
    }
    if (this.eFh) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.eFi) {
      localContentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
    }
    if (this.field_channelId == null) {
      this.field_channelId = "";
    }
    if (this.eFj) {
      localContentValues.put("channelId", this.field_channelId);
    }
    if (this.ent) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eFk) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.ema) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.eFl) {
      localContentValues.put("startSize", Long.valueOf(this.field_startSize));
    }
    if (this.eFm) {
      localContentValues.put("startState", Integer.valueOf(this.field_startState));
    }
    if (this.eFn) {
      localContentValues.put("fromWeApp", Boolean.valueOf(this.field_fromWeApp));
    }
    if (this.eFo) {
      localContentValues.put("downloadInWifi", Boolean.valueOf(this.field_downloadInWifi));
    }
    if (this.field_extInfo == null) {
      this.field_extInfo = "";
    }
    if (this.etc) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.eFp) {
      localContentValues.put("finishTime", Long.valueOf(this.field_finishTime));
    }
    if (this.eFq) {
      localContentValues.put("isSecondDownload", Boolean.valueOf(this.field_isSecondDownload));
    }
    if (this.eFr) {
      localContentValues.put("fromDownloadApp", Boolean.valueOf(this.field_fromDownloadApp));
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eFs) {
      localContentValues.put("reserveInWifi", Boolean.valueOf(this.field_reserveInWifi));
    }
    if (this.eFt) {
      localContentValues.put("ssid", Integer.valueOf(this.field_ssid));
    }
    if (this.eFu) {
      localContentValues.put("uiarea", Integer.valueOf(this.field_uiarea));
    }
    if (this.eFv) {
      localContentValues.put("noticeId", Integer.valueOf(this.field_noticeId));
    }
    if (this.eFw) {
      localContentValues.put("downloadType", Integer.valueOf(this.field_downloadType));
    }
    if (this.eFx) {
      localContentValues.put("startScene", Integer.valueOf(this.field_startScene));
    }
    if (this.eFy) {
      localContentValues.put("sectionMd5Byte", this.field_sectionMd5Byte);
    }
    if (this.field_rawAppId == null) {
      this.field_rawAppId = "";
    }
    if (this.eFz) {
      localContentValues.put("rawAppId", this.field_rawAppId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ca
 * JD-Core Version:    0.7.0.1
 */