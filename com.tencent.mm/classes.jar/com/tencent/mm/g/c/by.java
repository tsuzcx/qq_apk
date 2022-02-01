package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class by
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDA;
  private static final int eDB = "reserveInWifi".hashCode();
  private static final int eDC = "ssid".hashCode();
  private static final int eDD = "uiarea".hashCode();
  private static final int eDE = "noticeId".hashCode();
  private static final int eDF = "downloadType".hashCode();
  private static final int eDG = "startScene".hashCode();
  private static final int eDH = "sectionMd5Byte".hashCode();
  private static final int eDI = "rawAppId".hashCode();
  private static final int eDg = "downloadId".hashCode();
  private static final int eDh;
  private static final int eDi;
  private static final int eDj;
  private static final int eDk;
  private static final int eDl;
  private static final int eDm;
  private static final int eDn;
  private static final int eDo;
  private static final int eDp;
  private static final int eDq;
  private static final int eDr;
  private static final int eDs;
  private static final int eDt;
  private static final int eDu;
  private static final int eDv;
  private static final int eDw;
  private static final int eDx;
  private static final int eDy;
  private static final int eDz;
  private static final int ejR;
  private static final int ekd;
  private static final int elJ;
  private static final int elq;
  private static final int emf;
  private static final int enM;
  private static final int erm;
  private static final int etB;
  private static final int ety;
  private static final int etz = "downloadUrl".hashCode();
  private static final int eyX;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCD = true;
  private boolean eCE = true;
  private boolean eCF = true;
  private boolean eCG = true;
  private boolean eCH = true;
  private boolean eCI = true;
  private boolean eCJ = true;
  private boolean eCK = true;
  private boolean eCL = true;
  private boolean eCM = true;
  private boolean eCN = true;
  private boolean eCO = true;
  private boolean eCP = true;
  private boolean eCQ = true;
  private boolean eCR = true;
  private boolean eCS = true;
  private boolean eCT = true;
  private boolean eCU = true;
  private boolean eCV = true;
  private boolean eCW = true;
  private boolean eCX = true;
  private boolean eCY = true;
  private boolean eCZ = true;
  private boolean eDa = true;
  private boolean eDb = true;
  private boolean eDc = true;
  private boolean eDd = true;
  private boolean eDe = true;
  private boolean eDf = true;
  private boolean ejO = true;
  private boolean ejW = true;
  private boolean elo = true;
  private boolean els = true;
  private boolean emc = true;
  private boolean enq = true;
  private boolean eqY = true;
  private boolean etq = true;
  private boolean etr = true;
  private boolean ett = true;
  private boolean eyl = true;
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
    eDh = "secondaryUrl".hashCode();
    eDi = "fileSize".hashCode();
    eDj = "fileName".hashCode();
    etB = "filePath".hashCode();
    eDk = "fileType".hashCode();
    ejR = "status".hashCode();
    eyX = "md5".hashCode();
    eDl = "autoInstall".hashCode();
    eDm = "showNotification".hashCode();
    eDn = "sysDownloadId".hashCode();
    eDo = "downloaderType".hashCode();
    elJ = "appId".hashCode();
    ety = "downloadUrlHashCode".hashCode();
    enM = "packageName".hashCode();
    eDp = "downloadedSize".hashCode();
    eDq = "totalSize".hashCode();
    eDr = "autoDownload".hashCode();
    eDs = "channelId".hashCode();
    elq = "scene".hashCode();
    eDt = "errCode".hashCode();
    ekd = "startTime".hashCode();
    eDu = "startSize".hashCode();
    eDv = "startState".hashCode();
    eDw = "fromWeApp".hashCode();
    eDx = "downloadInWifi".hashCode();
    erm = "extInfo".hashCode();
    eDy = "finishTime".hashCode();
    eDz = "isSecondDownload".hashCode();
    eDA = "fromDownloadApp".hashCode();
    emf = "updateTime".hashCode();
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
      if (eDg != k) {
        break label65;
      }
      this.field_downloadId = paramCursor.getLong(i);
      this.eCD = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (etz == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (eDh == k)
      {
        this.field_secondaryUrl = paramCursor.getString(i);
      }
      else if (eDi == k)
      {
        this.field_fileSize = paramCursor.getLong(i);
      }
      else if (eDj == k)
      {
        this.field_fileName = paramCursor.getString(i);
      }
      else if (etB == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (eDk == k)
      {
        this.field_fileType = paramCursor.getInt(i);
      }
      else if (ejR == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (eyX == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (eDl == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_autoInstall = bool;
            break;
          }
        }
        if (eDm == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showNotification = bool;
            break;
          }
        }
        if (eDn == k)
        {
          this.field_sysDownloadId = paramCursor.getLong(i);
        }
        else if (eDo == k)
        {
          this.field_downloaderType = paramCursor.getInt(i);
        }
        else if (elJ == k)
        {
          this.field_appId = paramCursor.getString(i);
        }
        else if (ety == k)
        {
          this.field_downloadUrlHashCode = paramCursor.getInt(i);
        }
        else if (enM == k)
        {
          this.field_packageName = paramCursor.getString(i);
        }
        else if (eDp == k)
        {
          this.field_downloadedSize = paramCursor.getLong(i);
        }
        else if (eDq == k)
        {
          this.field_totalSize = paramCursor.getLong(i);
        }
        else
        {
          if (eDr == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_autoDownload = bool;
              break;
            }
          }
          if (eDs == k)
          {
            this.field_channelId = paramCursor.getString(i);
          }
          else if (elq == k)
          {
            this.field_scene = paramCursor.getInt(i);
          }
          else if (eDt == k)
          {
            this.field_errCode = paramCursor.getInt(i);
          }
          else if (ekd == k)
          {
            this.field_startTime = paramCursor.getLong(i);
          }
          else if (eDu == k)
          {
            this.field_startSize = paramCursor.getLong(i);
          }
          else if (eDv == k)
          {
            this.field_startState = paramCursor.getInt(i);
          }
          else
          {
            if (eDw == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_fromWeApp = bool;
                break;
              }
            }
            if (eDx == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWifi = bool;
                break;
              }
            }
            if (erm == k)
            {
              this.field_extInfo = paramCursor.getString(i);
            }
            else if (eDy == k)
            {
              this.field_finishTime = paramCursor.getLong(i);
            }
            else
            {
              if (eDz == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_isSecondDownload = bool;
                  break;
                }
              }
              if (eDA == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_fromDownloadApp = bool;
                  break;
                }
              }
              if (emf == k)
              {
                this.field_updateTime = paramCursor.getLong(i);
              }
              else
              {
                if (eDB == k)
                {
                  if (paramCursor.getInt(i) != 0) {}
                  for (bool = true;; bool = false)
                  {
                    this.field_reserveInWifi = bool;
                    break;
                  }
                }
                if (eDC == k) {
                  this.field_ssid = paramCursor.getInt(i);
                } else if (eDD == k) {
                  this.field_uiarea = paramCursor.getInt(i);
                } else if (eDE == k) {
                  this.field_noticeId = paramCursor.getInt(i);
                } else if (eDF == k) {
                  this.field_downloadType = paramCursor.getInt(i);
                } else if (eDG == k) {
                  this.field_startScene = paramCursor.getInt(i);
                } else if (eDH == k) {
                  this.field_sectionMd5Byte = paramCursor.getBlob(i);
                } else if (eDI == k) {
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
    if (this.eCD) {
      localContentValues.put("downloadId", Long.valueOf(this.field_downloadId));
    }
    if (this.field_downloadUrl == null) {
      this.field_downloadUrl = "";
    }
    if (this.etr) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.field_secondaryUrl == null) {
      this.field_secondaryUrl = "";
    }
    if (this.eCE) {
      localContentValues.put("secondaryUrl", this.field_secondaryUrl);
    }
    if (this.eCF) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.field_fileName == null) {
      this.field_fileName = "";
    }
    if (this.eCG) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.field_filePath == null) {
      this.field_filePath = "";
    }
    if (this.ett) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.eCH) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.field_md5 == null) {
      this.field_md5 = "";
    }
    if (this.eyl) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eCI) {
      localContentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
    }
    if (this.eCJ) {
      localContentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
    }
    if (this.eCK) {
      localContentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
    }
    if (this.eCL) {
      localContentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
    }
    if (this.field_appId == null) {
      this.field_appId = "";
    }
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.etq) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.field_packageName == null) {
      this.field_packageName = "";
    }
    if (this.enq) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.eCM) {
      localContentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
    }
    if (this.eCN) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.eCO) {
      localContentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
    }
    if (this.field_channelId == null) {
      this.field_channelId = "";
    }
    if (this.eCP) {
      localContentValues.put("channelId", this.field_channelId);
    }
    if (this.elo) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eCQ) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.ejW) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.eCR) {
      localContentValues.put("startSize", Long.valueOf(this.field_startSize));
    }
    if (this.eCS) {
      localContentValues.put("startState", Integer.valueOf(this.field_startState));
    }
    if (this.eCT) {
      localContentValues.put("fromWeApp", Boolean.valueOf(this.field_fromWeApp));
    }
    if (this.eCU) {
      localContentValues.put("downloadInWifi", Boolean.valueOf(this.field_downloadInWifi));
    }
    if (this.field_extInfo == null) {
      this.field_extInfo = "";
    }
    if (this.eqY) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.eCV) {
      localContentValues.put("finishTime", Long.valueOf(this.field_finishTime));
    }
    if (this.eCW) {
      localContentValues.put("isSecondDownload", Boolean.valueOf(this.field_isSecondDownload));
    }
    if (this.eCX) {
      localContentValues.put("fromDownloadApp", Boolean.valueOf(this.field_fromDownloadApp));
    }
    if (this.emc) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eCY) {
      localContentValues.put("reserveInWifi", Boolean.valueOf(this.field_reserveInWifi));
    }
    if (this.eCZ) {
      localContentValues.put("ssid", Integer.valueOf(this.field_ssid));
    }
    if (this.eDa) {
      localContentValues.put("uiarea", Integer.valueOf(this.field_uiarea));
    }
    if (this.eDb) {
      localContentValues.put("noticeId", Integer.valueOf(this.field_noticeId));
    }
    if (this.eDc) {
      localContentValues.put("downloadType", Integer.valueOf(this.field_downloadType));
    }
    if (this.eDd) {
      localContentValues.put("startScene", Integer.valueOf(this.field_startScene));
    }
    if (this.eDe) {
      localContentValues.put("sectionMd5Byte", this.field_sectionMd5Byte);
    }
    if (this.field_rawAppId == null) {
      this.field_rawAppId = "";
    }
    if (this.eDf) {
      localContentValues.put("rawAppId", this.field_rawAppId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.by
 * JD-Core Version:    0.7.0.1
 */