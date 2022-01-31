package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bq
  extends c
{
  private static final int cAE;
  private static final int cAF;
  private static final int cAH;
  private static final int cFC;
  private static final int cJe;
  private static final int cJf;
  private static final int cJg;
  private static final int cJh;
  private static final int cJi;
  private static final int cJj;
  private static final int cJk;
  private static final int cJl;
  private static final int cJm;
  private static final int cJn;
  private static final int cJo;
  private static final int cJp;
  private static final int cJq;
  private static final int cJr;
  private static final int cJs;
  private static final int cJt;
  private static final int cJu;
  private static final int cJv;
  private static final int cJw = "finishTime".hashCode();
  private static final int cJx = "isSecondDownload".hashCode();
  private static final int cJy = "fromDownloadApp".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crB;
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int csS;
  private static final int ctl;
  private static final int cve;
  private static final int cyC;
  private boolean cAw = true;
  private boolean cAx = true;
  private boolean cAz = true;
  private boolean cEZ = true;
  private boolean cIJ = true;
  private boolean cIK = true;
  private boolean cIL = true;
  private boolean cIM = true;
  private boolean cIN = true;
  private boolean cIO = true;
  private boolean cIP = true;
  private boolean cIQ = true;
  private boolean cIR = true;
  private boolean cIS = true;
  private boolean cIT = true;
  private boolean cIU = true;
  private boolean cIV = true;
  private boolean cIW = true;
  private boolean cIX = true;
  private boolean cIY = true;
  private boolean cIZ = true;
  private boolean cJa = true;
  private boolean cJb = true;
  private boolean cJc = true;
  private boolean cJd = true;
  private boolean crk = true;
  private boolean crt = true;
  private boolean csQ = true;
  private boolean csU = true;
  private boolean cuH = true;
  private boolean cyo = true;
  public String field_appId;
  public boolean field_autoDownload;
  public boolean field_autoInstall;
  public String field_channelId;
  public long field_downloadId;
  public boolean field_downloadInWifi;
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
  public String field_packageName;
  public int field_scene;
  public String field_secondaryUrl;
  public boolean field_showNotification;
  public long field_startSize;
  public int field_startState;
  public long field_startTime;
  public int field_status;
  public long field_sysDownloadId;
  public long field_totalSize;
  
  static
  {
    cJe = "downloadId".hashCode();
    cAF = "downloadUrl".hashCode();
    cJf = "secondaryUrl".hashCode();
    cJg = "fileSize".hashCode();
    cJh = "fileName".hashCode();
    cAH = "filePath".hashCode();
    cJi = "fileType".hashCode();
    crn = "status".hashCode();
    cFC = "md5".hashCode();
    cJj = "autoInstall".hashCode();
    cJk = "showNotification".hashCode();
    cJl = "sysDownloadId".hashCode();
    cJm = "downloaderType".hashCode();
    ctl = "appId".hashCode();
    cAE = "downloadUrlHashCode".hashCode();
    cve = "packageName".hashCode();
    cJn = "downloadedSize".hashCode();
    cJo = "totalSize".hashCode();
    cJp = "autoDownload".hashCode();
    cJq = "channelId".hashCode();
    csS = "scene".hashCode();
    cJr = "errCode".hashCode();
    crB = "startTime".hashCode();
    cJs = "startSize".hashCode();
    cJt = "startState".hashCode();
    cJu = "fromWeApp".hashCode();
    cJv = "downloadInWifi".hashCode();
    cyC = "extInfo".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cJe != k) {
        break label65;
      }
      this.field_downloadId = paramCursor.getLong(i);
      this.cIJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cAF == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (cJf == k)
      {
        this.field_secondaryUrl = paramCursor.getString(i);
      }
      else if (cJg == k)
      {
        this.field_fileSize = paramCursor.getLong(i);
      }
      else if (cJh == k)
      {
        this.field_fileName = paramCursor.getString(i);
      }
      else if (cAH == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (cJi == k)
      {
        this.field_fileType = paramCursor.getInt(i);
      }
      else if (crn == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (cFC == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (cJj == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_autoInstall = bool;
            break;
          }
        }
        if (cJk == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showNotification = bool;
            break;
          }
        }
        if (cJl == k)
        {
          this.field_sysDownloadId = paramCursor.getLong(i);
        }
        else if (cJm == k)
        {
          this.field_downloaderType = paramCursor.getInt(i);
        }
        else if (ctl == k)
        {
          this.field_appId = paramCursor.getString(i);
        }
        else if (cAE == k)
        {
          this.field_downloadUrlHashCode = paramCursor.getInt(i);
        }
        else if (cve == k)
        {
          this.field_packageName = paramCursor.getString(i);
        }
        else if (cJn == k)
        {
          this.field_downloadedSize = paramCursor.getLong(i);
        }
        else if (cJo == k)
        {
          this.field_totalSize = paramCursor.getLong(i);
        }
        else
        {
          if (cJp == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_autoDownload = bool;
              break;
            }
          }
          if (cJq == k)
          {
            this.field_channelId = paramCursor.getString(i);
          }
          else if (csS == k)
          {
            this.field_scene = paramCursor.getInt(i);
          }
          else if (cJr == k)
          {
            this.field_errCode = paramCursor.getInt(i);
          }
          else if (crB == k)
          {
            this.field_startTime = paramCursor.getLong(i);
          }
          else if (cJs == k)
          {
            this.field_startSize = paramCursor.getLong(i);
          }
          else if (cJt == k)
          {
            this.field_startState = paramCursor.getInt(i);
          }
          else
          {
            if (cJu == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_fromWeApp = bool;
                break;
              }
            }
            if (cJv == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWifi = bool;
                break;
              }
            }
            if (cyC == k)
            {
              this.field_extInfo = paramCursor.getString(i);
            }
            else if (cJw == k)
            {
              this.field_finishTime = paramCursor.getLong(i);
            }
            else
            {
              if (cJx == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_isSecondDownload = bool;
                  break;
                }
              }
              if (cJy == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (bool = true;; bool = false)
                {
                  this.field_fromDownloadApp = bool;
                  break;
                }
              }
              if (crh == k) {
                this.ujK = paramCursor.getLong(i);
              }
            }
          }
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cIJ) {
      localContentValues.put("downloadId", Long.valueOf(this.field_downloadId));
    }
    if (this.field_downloadUrl == null) {
      this.field_downloadUrl = "";
    }
    if (this.cAx) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.field_secondaryUrl == null) {
      this.field_secondaryUrl = "";
    }
    if (this.cIK) {
      localContentValues.put("secondaryUrl", this.field_secondaryUrl);
    }
    if (this.cIL) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.field_fileName == null) {
      this.field_fileName = "";
    }
    if (this.cIM) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.field_filePath == null) {
      this.field_filePath = "";
    }
    if (this.cAz) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.cIN) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.field_md5 == null) {
      this.field_md5 = "";
    }
    if (this.cEZ) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.cIO) {
      localContentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
    }
    if (this.cIP) {
      localContentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
    }
    if (this.cIQ) {
      localContentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
    }
    if (this.cIR) {
      localContentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
    }
    if (this.field_appId == null) {
      this.field_appId = "";
    }
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.cAw) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.field_packageName == null) {
      this.field_packageName = "";
    }
    if (this.cuH) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.cIS) {
      localContentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
    }
    if (this.cIT) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.cIU) {
      localContentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
    }
    if (this.field_channelId == null) {
      this.field_channelId = "";
    }
    if (this.cIV) {
      localContentValues.put("channelId", this.field_channelId);
    }
    if (this.csQ) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.cIW) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.crt) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.cIX) {
      localContentValues.put("startSize", Long.valueOf(this.field_startSize));
    }
    if (this.cIY) {
      localContentValues.put("startState", Integer.valueOf(this.field_startState));
    }
    if (this.cIZ) {
      localContentValues.put("fromWeApp", Boolean.valueOf(this.field_fromWeApp));
    }
    if (this.cJa) {
      localContentValues.put("downloadInWifi", Boolean.valueOf(this.field_downloadInWifi));
    }
    if (this.field_extInfo == null) {
      this.field_extInfo = "";
    }
    if (this.cyo) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.cJb) {
      localContentValues.put("finishTime", Long.valueOf(this.field_finishTime));
    }
    if (this.cJc) {
      localContentValues.put("isSecondDownload", Boolean.valueOf(this.field_isSecondDownload));
    }
    if (this.cJd) {
      localContentValues.put("fromDownloadApp", Boolean.valueOf(this.field_fromDownloadApp));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.bq
 * JD-Core Version:    0.7.0.1
 */