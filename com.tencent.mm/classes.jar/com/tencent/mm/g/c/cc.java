package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class cc
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fCA;
  private static final int fCB;
  private static final int fCC;
  private static final int fCD;
  private static final int fCE;
  private static final int fCF;
  private static final int fCG;
  private static final int fCH;
  private static final int fCI = "reserveInWifi".hashCode();
  private static final int fCJ = "ssid".hashCode();
  private static final int fCK = "uiarea".hashCode();
  private static final int fCL = "noticeId".hashCode();
  private static final int fCM = "downloadType".hashCode();
  private static final int fCN = "startScene".hashCode();
  private static final int fCO = "sectionMd5Byte".hashCode();
  private static final int fCP = "rawAppId".hashCode();
  private static final int fCQ = "notificationTitle".hashCode();
  private static final int fCn = "downloadId".hashCode();
  private static final int fCo;
  private static final int fCp;
  private static final int fCq;
  private static final int fCr;
  private static final int fCs;
  private static final int fCt;
  private static final int fCu;
  private static final int fCv;
  private static final int fCw;
  private static final int fCx;
  private static final int fCy;
  private static final int fCz;
  private static final int fjQ;
  private static final int fjl;
  private static final int fjx;
  private static final int fkj;
  private static final int fml;
  private static final int fpP;
  private static final int fsr;
  private static final int fss = "downloadUrl".hashCode();
  private static final int fsu;
  private static final int fyf;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  private boolean fBJ = true;
  private boolean fBK = true;
  private boolean fBL = true;
  private boolean fBM = true;
  private boolean fBN = true;
  private boolean fBO = true;
  private boolean fBP = true;
  private boolean fBQ = true;
  private boolean fBR = true;
  private boolean fBS = true;
  private boolean fBT = true;
  private boolean fBU = true;
  private boolean fBV = true;
  private boolean fBW = true;
  private boolean fBX = true;
  private boolean fBY = true;
  private boolean fBZ = true;
  private boolean fCa = true;
  private boolean fCb = true;
  private boolean fCc = true;
  private boolean fCd = true;
  private boolean fCe = true;
  private boolean fCf = true;
  private boolean fCg = true;
  private boolean fCh = true;
  private boolean fCi = true;
  private boolean fCj = true;
  private boolean fCk = true;
  private boolean fCl = true;
  private boolean fCm = true;
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
  public String field_notificationTitle;
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
  private boolean fjO = true;
  private boolean fjS = true;
  private boolean fji = true;
  private boolean fjq = true;
  private boolean flP = true;
  private boolean fpB = true;
  private boolean fsj = true;
  private boolean fsk = true;
  private boolean fsm = true;
  private boolean fxt = true;
  
  static
  {
    fCo = "secondaryUrl".hashCode();
    fCp = "fileSize".hashCode();
    fCq = "fileName".hashCode();
    fsu = "filePath".hashCode();
    fCr = "fileType".hashCode();
    fjl = "status".hashCode();
    fyf = "md5".hashCode();
    fCs = "autoInstall".hashCode();
    fCt = "showNotification".hashCode();
    fCu = "sysDownloadId".hashCode();
    fCv = "downloaderType".hashCode();
    fkj = "appId".hashCode();
    fsr = "downloadUrlHashCode".hashCode();
    fml = "packageName".hashCode();
    fCw = "downloadedSize".hashCode();
    fCx = "totalSize".hashCode();
    fCy = "autoDownload".hashCode();
    fCz = "channelId".hashCode();
    fjQ = "scene".hashCode();
    fCA = "errCode".hashCode();
    fjx = "startTime".hashCode();
    fCB = "startSize".hashCode();
    fCC = "startState".hashCode();
    fCD = "fromWeApp".hashCode();
    fCE = "downloadInWifi".hashCode();
    fpP = "extInfo".hashCode();
    fCF = "finishTime".hashCode();
    fCG = "isSecondDownload".hashCode();
    fCH = "fromDownloadApp".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
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
      if (fCn != k) {
        break label65;
      }
      this.field_downloadId = paramCursor.getLong(i);
      this.fBJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fss == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (fCo == k)
      {
        this.field_secondaryUrl = paramCursor.getString(i);
      }
      else if (fCp == k)
      {
        this.field_fileSize = paramCursor.getLong(i);
      }
      else if (fCq == k)
      {
        this.field_fileName = paramCursor.getString(i);
      }
      else if (fsu == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (fCr == k)
      {
        this.field_fileType = paramCursor.getInt(i);
      }
      else if (fjl == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (fyf == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (fCs == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_autoInstall = bool;
            break;
          }
        }
        if (fCt == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showNotification = bool;
            break;
          }
        }
        if (fCu == k)
        {
          this.field_sysDownloadId = paramCursor.getLong(i);
        }
        else if (fCv == k)
        {
          this.field_downloaderType = paramCursor.getInt(i);
        }
        else if (fkj == k)
        {
          this.field_appId = paramCursor.getString(i);
        }
        else if (fsr == k)
        {
          this.field_downloadUrlHashCode = paramCursor.getInt(i);
        }
        else if (fml == k)
        {
          this.field_packageName = paramCursor.getString(i);
        }
        else if (fCw == k)
        {
          this.field_downloadedSize = paramCursor.getLong(i);
        }
        else if (fCx == k)
        {
          this.field_totalSize = paramCursor.getLong(i);
        }
        else
        {
          if (fCy == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_autoDownload = bool;
              break;
            }
          }
          if (fCz == k)
          {
            this.field_channelId = paramCursor.getString(i);
          }
          else if (fjQ == k)
          {
            this.field_scene = paramCursor.getInt(i);
          }
          else if (fCA == k)
          {
            this.field_errCode = paramCursor.getInt(i);
          }
          else if (fjx == k)
          {
            this.field_startTime = paramCursor.getLong(i);
          }
          else if (fCB == k)
          {
            this.field_startSize = paramCursor.getLong(i);
          }
          else if (fCC == k)
          {
            this.field_startState = paramCursor.getInt(i);
          }
          else
          {
            if (fCD == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_fromWeApp = bool;
                break;
              }
            }
            if (fCE == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWifi = bool;
                break;
              }
            }
            if (fpP == k)
            {
              this.field_extInfo = paramCursor.getString(i);
            }
            else if (fCF == k)
            {
              this.field_finishTime = paramCursor.getLong(i);
            }
            else
            {
              if (fCG == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_isSecondDownload = bool;
                  break;
                }
              }
              if (fCH == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_fromDownloadApp = bool;
                  break;
                }
              }
              if (updateTime_HASHCODE == k)
              {
                this.field_updateTime = paramCursor.getLong(i);
              }
              else
              {
                if (fCI == k)
                {
                  if (paramCursor.getInt(i) != 0) {}
                  for (bool = true;; bool = false)
                  {
                    this.field_reserveInWifi = bool;
                    break;
                  }
                }
                if (fCJ == k) {
                  this.field_ssid = paramCursor.getInt(i);
                } else if (fCK == k) {
                  this.field_uiarea = paramCursor.getInt(i);
                } else if (fCL == k) {
                  this.field_noticeId = paramCursor.getInt(i);
                } else if (fCM == k) {
                  this.field_downloadType = paramCursor.getInt(i);
                } else if (fCN == k) {
                  this.field_startScene = paramCursor.getInt(i);
                } else if (fCO == k) {
                  this.field_sectionMd5Byte = paramCursor.getBlob(i);
                } else if (fCP == k) {
                  this.field_rawAppId = paramCursor.getString(i);
                } else if (fCQ == k) {
                  this.field_notificationTitle = paramCursor.getString(i);
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
    if (this.fBJ) {
      localContentValues.put("downloadId", Long.valueOf(this.field_downloadId));
    }
    if (this.field_downloadUrl == null) {
      this.field_downloadUrl = "";
    }
    if (this.fsk) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.field_secondaryUrl == null) {
      this.field_secondaryUrl = "";
    }
    if (this.fBK) {
      localContentValues.put("secondaryUrl", this.field_secondaryUrl);
    }
    if (this.fBL) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.field_fileName == null) {
      this.field_fileName = "";
    }
    if (this.fBM) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.field_filePath == null) {
      this.field_filePath = "";
    }
    if (this.fsm) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.fBN) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.field_md5 == null) {
      this.field_md5 = "";
    }
    if (this.fxt) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.fBO) {
      localContentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
    }
    if (this.fBP) {
      localContentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
    }
    if (this.fBQ) {
      localContentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
    }
    if (this.fBR) {
      localContentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
    }
    if (this.field_appId == null) {
      this.field_appId = "";
    }
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fsj) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.field_packageName == null) {
      this.field_packageName = "";
    }
    if (this.flP) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.fBS) {
      localContentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
    }
    if (this.fBT) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.fBU) {
      localContentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
    }
    if (this.field_channelId == null) {
      this.field_channelId = "";
    }
    if (this.fBV) {
      localContentValues.put("channelId", this.field_channelId);
    }
    if (this.fjO) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.fBW) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.fjq) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.fBX) {
      localContentValues.put("startSize", Long.valueOf(this.field_startSize));
    }
    if (this.fBY) {
      localContentValues.put("startState", Integer.valueOf(this.field_startState));
    }
    if (this.fBZ) {
      localContentValues.put("fromWeApp", Boolean.valueOf(this.field_fromWeApp));
    }
    if (this.fCa) {
      localContentValues.put("downloadInWifi", Boolean.valueOf(this.field_downloadInWifi));
    }
    if (this.field_extInfo == null) {
      this.field_extInfo = "";
    }
    if (this.fpB) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.fCb) {
      localContentValues.put("finishTime", Long.valueOf(this.field_finishTime));
    }
    if (this.fCc) {
      localContentValues.put("isSecondDownload", Boolean.valueOf(this.field_isSecondDownload));
    }
    if (this.fCd) {
      localContentValues.put("fromDownloadApp", Boolean.valueOf(this.field_fromDownloadApp));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fCe) {
      localContentValues.put("reserveInWifi", Boolean.valueOf(this.field_reserveInWifi));
    }
    if (this.fCf) {
      localContentValues.put("ssid", Integer.valueOf(this.field_ssid));
    }
    if (this.fCg) {
      localContentValues.put("uiarea", Integer.valueOf(this.field_uiarea));
    }
    if (this.fCh) {
      localContentValues.put("noticeId", Integer.valueOf(this.field_noticeId));
    }
    if (this.fCi) {
      localContentValues.put("downloadType", Integer.valueOf(this.field_downloadType));
    }
    if (this.fCj) {
      localContentValues.put("startScene", Integer.valueOf(this.field_startScene));
    }
    if (this.fCk) {
      localContentValues.put("sectionMd5Byte", this.field_sectionMd5Byte);
    }
    if (this.field_rawAppId == null) {
      this.field_rawAppId = "";
    }
    if (this.fCl) {
      localContentValues.put("rawAppId", this.field_rawAppId);
    }
    if (this.field_notificationTitle == null) {
      this.field_notificationTitle = "";
    }
    if (this.fCm) {
      localContentValues.put("notificationTitle", this.field_notificationTitle);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.cc
 * JD-Core Version:    0.7.0.1
 */