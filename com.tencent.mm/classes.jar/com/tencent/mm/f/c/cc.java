package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class cc
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("FileDownloadInfo");
  public static final Column hGW;
  private static final int hIy;
  public static final Column hNA;
  public static final Column hNB;
  public static final Column hNC;
  public static final Column hND;
  public static final Column hNE;
  public static final Column hNF;
  public static final Column hNG;
  public static final Column hNH;
  public static final Column hNI;
  public static final Column hNJ;
  public static final Column hNK;
  public static final Column hNL;
  public static final Column hNM;
  public static final Column hNN;
  public static final Column hNO;
  public static final Column hNP;
  public static final Column hNQ;
  public static final Column hNR;
  public static final Column hNS;
  public static final Column hNT;
  public static final Column hNU;
  public static final Column hNV;
  public static final Column hNW;
  public static final Column hNX;
  public static final Column hNu;
  public static final Column hNv;
  public static final Column hNw;
  public static final Column hNx;
  public static final Column hNy;
  public static final Column hNz;
  private static final int hOC;
  private static final int hOD;
  private static final int hOE;
  private static final int hOF;
  private static final int hOG;
  private static final int hOH;
  private static final int hOI;
  private static final int hOJ;
  private static final int hOK;
  private static final int hOL;
  private static final int hOM;
  private static final int hON;
  private static final int hOO;
  private static final int hOP;
  private static final int hOQ;
  private static final int hOR;
  private static final int hOS;
  private static final int hOT;
  private static final int hOU;
  private static final int hOV;
  private static final int hOW;
  private static final int hOX = "reserveInWifi".hashCode();
  private static final int hOY = "ssid".hashCode();
  private static final int hOZ = "uiarea".hashCode();
  private static final int hPa = "noticeId".hashCode();
  private static final int hPb = "downloadType".hashCode();
  private static final int hPc = "startScene".hashCode();
  private static final int hPd = "sectionMd5Byte".hashCode();
  private static final int hPe = "rawAppId".hashCode();
  private static final int hPf = "notificationTitle".hashCode();
  private static final int hmC;
  public static final Column hmH;
  private static final int hmV;
  public static final Column hmw;
  public static final Column hnt;
  private static final int hnx;
  public static final Column hnz;
  private static final int hoh;
  public static final Column hpN;
  public static final Column hqs;
  private static final int hrk;
  public static final Column hvK;
  private static final int hwm;
  public static final Column hzA;
  public static final Column hzC;
  private static final int hzP;
  private static final int hzQ;
  private static final int hzS;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
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
  private boolean hHK = true;
  private boolean hNY = true;
  private boolean hNZ = true;
  private boolean hOA = true;
  private boolean hOB = true;
  private boolean hOa = true;
  private boolean hOb = true;
  private boolean hOc = true;
  private boolean hOd = true;
  private boolean hOe = true;
  private boolean hOf = true;
  private boolean hOg = true;
  private boolean hOh = true;
  private boolean hOi = true;
  private boolean hOj = true;
  private boolean hOk = true;
  private boolean hOl = true;
  private boolean hOm = true;
  private boolean hOn = true;
  private boolean hOo = true;
  private boolean hOp = true;
  private boolean hOq = true;
  private boolean hOr = true;
  private boolean hOs = true;
  private boolean hOt = true;
  private boolean hOu = true;
  private boolean hOv = true;
  private boolean hOw = true;
  private boolean hOx = true;
  private boolean hOy = true;
  private boolean hOz = true;
  private boolean hmO = true;
  private boolean hmz = true;
  private boolean hnQ = true;
  private boolean hnv = true;
  private boolean hqO = true;
  private boolean hvY = true;
  private boolean hzH = true;
  private boolean hzI = true;
  private boolean hzK = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FileDownloadInfo", "");
    hNu = new Column("downloadid", "long", "FileDownloadInfo", "");
    hpN = new Column("downloadurl", "string", "FileDownloadInfo", "");
    hNv = new Column("secondaryurl", "string", "FileDownloadInfo", "");
    hNw = new Column("filesize", "long", "FileDownloadInfo", "");
    hNx = new Column("filename", "string", "FileDownloadInfo", "");
    hzC = new Column("filepath", "string", "FileDownloadInfo", "");
    hNy = new Column("filetype", "int", "FileDownloadInfo", "");
    hmw = new Column("status", "int", "FileDownloadInfo", "");
    hGW = new Column("md5", "string", "FileDownloadInfo", "");
    hNz = new Column("autoinstall", "boolean", "FileDownloadInfo", "");
    hNA = new Column("shownotification", "boolean", "FileDownloadInfo", "");
    hNB = new Column("sysdownloadid", "long", "FileDownloadInfo", "");
    hNC = new Column("downloadertype", "int", "FileDownloadInfo", "");
    hnz = new Column("appid", "string", "FileDownloadInfo", "");
    hzA = new Column("downloadurlhashcode", "int", "FileDownloadInfo", "");
    hqs = new Column("packagename", "string", "FileDownloadInfo", "");
    hND = new Column("downloadedsize", "long", "FileDownloadInfo", "");
    hNE = new Column("totalsize", "long", "FileDownloadInfo", "");
    hNF = new Column("autodownload", "boolean", "FileDownloadInfo", "");
    hNG = new Column("channelid", "string", "FileDownloadInfo", "");
    hnt = new Column("scene", "int", "FileDownloadInfo", "");
    hNH = new Column("errcode", "int", "FileDownloadInfo", "");
    hmH = new Column("starttime", "long", "FileDownloadInfo", "");
    hNI = new Column("startsize", "long", "FileDownloadInfo", "");
    hNJ = new Column("startstate", "int", "FileDownloadInfo", "");
    hNK = new Column("fromweapp", "boolean", "FileDownloadInfo", "");
    hNL = new Column("downloadinwifi", "boolean", "FileDownloadInfo", "");
    hvK = new Column("extinfo", "string", "FileDownloadInfo", "");
    hNM = new Column("finishtime", "long", "FileDownloadInfo", "");
    hNN = new Column("isseconddownload", "boolean", "FileDownloadInfo", "");
    hNO = new Column("fromdownloadapp", "boolean", "FileDownloadInfo", "");
    C_UPDATETIME = new Column("updatetime", "long", "FileDownloadInfo", "");
    hNP = new Column("reserveinwifi", "boolean", "FileDownloadInfo", "");
    hNQ = new Column("ssid", "int", "FileDownloadInfo", "");
    hNR = new Column("uiarea", "int", "FileDownloadInfo", "");
    hNS = new Column("noticeid", "int", "FileDownloadInfo", "");
    hNT = new Column("downloadtype", "int", "FileDownloadInfo", "");
    hNU = new Column("startscene", "int", "FileDownloadInfo", "");
    hNV = new Column("sectionmd5byte", "byte[]", "FileDownloadInfo", "");
    hNW = new Column("rawappid", "string", "FileDownloadInfo", "");
    hNX = new Column("notificationtitle", "string", "FileDownloadInfo", "");
    hOC = "downloadId".hashCode();
    hzQ = "downloadUrl".hashCode();
    hOD = "secondaryUrl".hashCode();
    hOE = "fileSize".hashCode();
    hOF = "fileName".hashCode();
    hzS = "filePath".hashCode();
    hOG = "fileType".hashCode();
    hmC = "status".hashCode();
    hIy = "md5".hashCode();
    hOH = "autoInstall".hashCode();
    hOI = "showNotification".hashCode();
    hOJ = "sysDownloadId".hashCode();
    hOK = "downloaderType".hashCode();
    hoh = "appId".hashCode();
    hzP = "downloadUrlHashCode".hashCode();
    hrk = "packageName".hashCode();
    hOL = "downloadedSize".hashCode();
    hOM = "totalSize".hashCode();
    hON = "autoDownload".hashCode();
    hOO = "channelId".hashCode();
    hnx = "scene".hashCode();
    hOP = "errCode".hashCode();
    hmV = "startTime".hashCode();
    hOQ = "startSize".hashCode();
    hOR = "startState".hashCode();
    hOS = "fromWeApp".hashCode();
    hOT = "downloadInWifi".hashCode();
    hwm = "extInfo".hashCode();
    hOU = "finishTime".hashCode();
    hOV = "isSecondDownload".hashCode();
    hOW = "fromDownloadApp".hashCode();
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
      if (hOC != k) {
        break label65;
      }
      this.field_downloadId = paramCursor.getLong(i);
      this.hNY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hzQ == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (hOD == k)
      {
        this.field_secondaryUrl = paramCursor.getString(i);
      }
      else if (hOE == k)
      {
        this.field_fileSize = paramCursor.getLong(i);
      }
      else if (hOF == k)
      {
        this.field_fileName = paramCursor.getString(i);
      }
      else if (hzS == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (hOG == k)
      {
        this.field_fileType = paramCursor.getInt(i);
      }
      else if (hmC == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (hIy == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (hOH == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_autoInstall = bool;
            break;
          }
        }
        if (hOI == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showNotification = bool;
            break;
          }
        }
        if (hOJ == k)
        {
          this.field_sysDownloadId = paramCursor.getLong(i);
        }
        else if (hOK == k)
        {
          this.field_downloaderType = paramCursor.getInt(i);
        }
        else if (hoh == k)
        {
          this.field_appId = paramCursor.getString(i);
        }
        else if (hzP == k)
        {
          this.field_downloadUrlHashCode = paramCursor.getInt(i);
        }
        else if (hrk == k)
        {
          this.field_packageName = paramCursor.getString(i);
        }
        else if (hOL == k)
        {
          this.field_downloadedSize = paramCursor.getLong(i);
        }
        else if (hOM == k)
        {
          this.field_totalSize = paramCursor.getLong(i);
        }
        else
        {
          if (hON == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_autoDownload = bool;
              break;
            }
          }
          if (hOO == k)
          {
            this.field_channelId = paramCursor.getString(i);
          }
          else if (hnx == k)
          {
            this.field_scene = paramCursor.getInt(i);
          }
          else if (hOP == k)
          {
            this.field_errCode = paramCursor.getInt(i);
          }
          else if (hmV == k)
          {
            this.field_startTime = paramCursor.getLong(i);
          }
          else if (hOQ == k)
          {
            this.field_startSize = paramCursor.getLong(i);
          }
          else if (hOR == k)
          {
            this.field_startState = paramCursor.getInt(i);
          }
          else
          {
            if (hOS == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_fromWeApp = bool;
                break;
              }
            }
            if (hOT == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWifi = bool;
                break;
              }
            }
            if (hwm == k)
            {
              this.field_extInfo = paramCursor.getString(i);
            }
            else if (hOU == k)
            {
              this.field_finishTime = paramCursor.getLong(i);
            }
            else
            {
              if (hOV == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_isSecondDownload = bool;
                  break;
                }
              }
              if (hOW == k)
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
                if (hOX == k)
                {
                  if (paramCursor.getInt(i) != 0) {}
                  for (bool = true;; bool = false)
                  {
                    this.field_reserveInWifi = bool;
                    break;
                  }
                }
                if (hOY == k) {
                  this.field_ssid = paramCursor.getInt(i);
                } else if (hOZ == k) {
                  this.field_uiarea = paramCursor.getInt(i);
                } else if (hPa == k) {
                  this.field_noticeId = paramCursor.getInt(i);
                } else if (hPb == k) {
                  this.field_downloadType = paramCursor.getInt(i);
                } else if (hPc == k) {
                  this.field_startScene = paramCursor.getInt(i);
                } else if (hPd == k) {
                  this.field_sectionMd5Byte = paramCursor.getBlob(i);
                } else if (hPe == k) {
                  this.field_rawAppId = paramCursor.getString(i);
                } else if (hPf == k) {
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
    if (this.hNY) {
      localContentValues.put("downloadId", Long.valueOf(this.field_downloadId));
    }
    if (this.field_downloadUrl == null) {
      this.field_downloadUrl = "";
    }
    if (this.hzI) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.field_secondaryUrl == null) {
      this.field_secondaryUrl = "";
    }
    if (this.hNZ) {
      localContentValues.put("secondaryUrl", this.field_secondaryUrl);
    }
    if (this.hOa) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.field_fileName == null) {
      this.field_fileName = "";
    }
    if (this.hOb) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.field_filePath == null) {
      this.field_filePath = "";
    }
    if (this.hzK) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.hOc) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.field_md5 == null) {
      this.field_md5 = "";
    }
    if (this.hHK) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.hOd) {
      localContentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
    }
    if (this.hOe) {
      localContentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
    }
    if (this.hOf) {
      localContentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
    }
    if (this.hOg) {
      localContentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
    }
    if (this.field_appId == null) {
      this.field_appId = "";
    }
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hzH) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.field_packageName == null) {
      this.field_packageName = "";
    }
    if (this.hqO) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.hOh) {
      localContentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
    }
    if (this.hOi) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.hOj) {
      localContentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
    }
    if (this.field_channelId == null) {
      this.field_channelId = "";
    }
    if (this.hOk) {
      localContentValues.put("channelId", this.field_channelId);
    }
    if (this.hnv) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.hOl) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.hmO) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.hOm) {
      localContentValues.put("startSize", Long.valueOf(this.field_startSize));
    }
    if (this.hOn) {
      localContentValues.put("startState", Integer.valueOf(this.field_startState));
    }
    if (this.hOo) {
      localContentValues.put("fromWeApp", Boolean.valueOf(this.field_fromWeApp));
    }
    if (this.hOp) {
      localContentValues.put("downloadInWifi", Boolean.valueOf(this.field_downloadInWifi));
    }
    if (this.field_extInfo == null) {
      this.field_extInfo = "";
    }
    if (this.hvY) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.hOq) {
      localContentValues.put("finishTime", Long.valueOf(this.field_finishTime));
    }
    if (this.hOr) {
      localContentValues.put("isSecondDownload", Boolean.valueOf(this.field_isSecondDownload));
    }
    if (this.hOs) {
      localContentValues.put("fromDownloadApp", Boolean.valueOf(this.field_fromDownloadApp));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.hOt) {
      localContentValues.put("reserveInWifi", Boolean.valueOf(this.field_reserveInWifi));
    }
    if (this.hOu) {
      localContentValues.put("ssid", Integer.valueOf(this.field_ssid));
    }
    if (this.hOv) {
      localContentValues.put("uiarea", Integer.valueOf(this.field_uiarea));
    }
    if (this.hOw) {
      localContentValues.put("noticeId", Integer.valueOf(this.field_noticeId));
    }
    if (this.hOx) {
      localContentValues.put("downloadType", Integer.valueOf(this.field_downloadType));
    }
    if (this.hOy) {
      localContentValues.put("startScene", Integer.valueOf(this.field_startScene));
    }
    if (this.hOz) {
      localContentValues.put("sectionMd5Byte", this.field_sectionMd5Byte);
    }
    if (this.field_rawAppId == null) {
      this.field_rawAppId = "";
    }
    if (this.hOA) {
      localContentValues.put("rawAppId", this.field_rawAppId);
    }
    if (this.field_notificationTitle == null) {
      this.field_notificationTitle = "";
    }
    if (this.hOB) {
      localContentValues.put("notificationTitle", this.field_notificationTitle);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "FileDownloadInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.cc
 * JD-Core Version:    0.7.0.1
 */