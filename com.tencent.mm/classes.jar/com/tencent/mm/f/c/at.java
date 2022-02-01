package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class at
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("CdnDownloadInfo");
  public static final Column hnC;
  private static final int hok = "mediaId".hashCode();
  public static final Column hpN;
  public static final Column hzA;
  public static final Column hzB;
  public static final Column hzC;
  public static final Column hzD;
  public static final Column hzE;
  public static final Column hzF;
  public static final Column hzG;
  private static final int hzP = "downloadUrlHashCode".hashCode();
  private static final int hzQ = "downloadUrl".hashCode();
  private static final int hzR = "httpsUrl".hashCode();
  private static final int hzS = "filePath".hashCode();
  private static final int hzT = "verifyHeaders".hashCode();
  private static final int hzU = "game_package_download".hashCode();
  private static final int hzV = "allowMobileNetDownload".hashCode();
  private static final int hzW = "wifiAutoDownload".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public Boolean field_allowMobileNetDownload;
  public String field_downloadUrl;
  public int field_downloadUrlHashCode;
  public String field_filePath;
  public Boolean field_game_package_download;
  public String field_httpsUrl;
  public String field_mediaId;
  public String field_verifyHeaders;
  public Boolean field_wifiAutoDownload;
  private boolean hnT = true;
  private boolean hzH = true;
  private boolean hzI = true;
  private boolean hzJ = true;
  private boolean hzK = true;
  private boolean hzL = true;
  private boolean hzM = true;
  private boolean hzN = true;
  private boolean hzO = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "CdnDownloadInfo", "");
    hnC = new Column("mediaid", "string", "CdnDownloadInfo", "");
    hzA = new Column("downloadurlhashcode", "int", "CdnDownloadInfo", "");
    hpN = new Column("downloadurl", "string", "CdnDownloadInfo", "");
    hzB = new Column("httpsurl", "string", "CdnDownloadInfo", "");
    hzC = new Column("filepath", "string", "CdnDownloadInfo", "");
    hzD = new Column("verifyheaders", "string", "CdnDownloadInfo", "");
    hzE = new Column("game_package_download", "boolean", "CdnDownloadInfo", "");
    hzF = new Column("allowmobilenetdownload", "boolean", "CdnDownloadInfo", "");
    hzG = new Column("wifiautodownload", "boolean", "CdnDownloadInfo", "");
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
      if (hok != k) {
        break label60;
      }
      this.field_mediaId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hzP == k)
      {
        this.field_downloadUrlHashCode = paramCursor.getInt(i);
        this.hzH = true;
      }
      else if (hzQ == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (hzR == k)
      {
        this.field_httpsUrl = paramCursor.getString(i);
      }
      else if (hzS == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (hzT == k)
      {
        this.field_verifyHeaders = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (hzU == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_game_package_download = Boolean.valueOf(bool);
            break;
          }
        }
        if (hzV == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_allowMobileNetDownload = Boolean.valueOf(bool);
            break;
          }
        }
        if (hzW == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_wifiAutoDownload = Boolean.valueOf(bool);
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hnT) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.hzH) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.hzI) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.hzJ) {
      localContentValues.put("httpsUrl", this.field_httpsUrl);
    }
    if (this.hzK) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.hzL) {
      localContentValues.put("verifyHeaders", this.field_verifyHeaders);
    }
    if (this.hzM) {
      localContentValues.put("game_package_download", this.field_game_package_download);
    }
    if (this.hzN) {
      localContentValues.put("allowMobileNetDownload", this.field_allowMobileNetDownload);
    }
    if (this.hzO) {
      localContentValues.put("wifiAutoDownload", this.field_wifiAutoDownload);
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
    return "CdnDownloadInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.at
 * JD-Core Version:    0.7.0.1
 */