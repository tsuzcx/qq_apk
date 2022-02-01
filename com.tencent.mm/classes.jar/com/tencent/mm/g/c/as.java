package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class as
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEX = "mediaId".hashCode();
  private static final int eMZ = "downloadUrlHashCode".hashCode();
  private static final int eNa = "downloadUrl".hashCode();
  private static final int eNb = "httpsUrl".hashCode();
  private static final int eNc = "filePath".hashCode();
  private static final int eNd = "verifyHeaders".hashCode();
  private static final int eNe = "game_package_download".hashCode();
  private static final int eNf = "allowMobileNetDownload".hashCode();
  private static final int eNg = "wifiAutoDownload".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEG = true;
  private boolean eMR = true;
  private boolean eMS = true;
  private boolean eMT = true;
  private boolean eMU = true;
  private boolean eMV = true;
  private boolean eMW = true;
  private boolean eMX = true;
  private boolean eMY = true;
  public Boolean field_allowMobileNetDownload;
  public String field_downloadUrl;
  public int field_downloadUrlHashCode;
  public String field_filePath;
  public Boolean field_game_package_download;
  public String field_httpsUrl;
  public String field_mediaId;
  public String field_verifyHeaders;
  public Boolean field_wifiAutoDownload;
  
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
      if (eEX != k) {
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
      if (eMZ == k)
      {
        this.field_downloadUrlHashCode = paramCursor.getInt(i);
        this.eMR = true;
      }
      else if (eNa == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (eNb == k)
      {
        this.field_httpsUrl = paramCursor.getString(i);
      }
      else if (eNc == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (eNd == k)
      {
        this.field_verifyHeaders = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (eNe == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_game_package_download = Boolean.valueOf(bool);
            break;
          }
        }
        if (eNf == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_allowMobileNetDownload = Boolean.valueOf(bool);
            break;
          }
        }
        if (eNg == k)
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
    if (this.eEG) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.eMR) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.eMS) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.eMT) {
      localContentValues.put("httpsUrl", this.field_httpsUrl);
    }
    if (this.eMU) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.eMV) {
      localContentValues.put("verifyHeaders", this.field_verifyHeaders);
    }
    if (this.eMW) {
      localContentValues.put("game_package_download", this.field_game_package_download);
    }
    if (this.eMX) {
      localContentValues.put("allowMobileNetDownload", this.field_allowMobileNetDownload);
    }
    if (this.eMY) {
      localContentValues.put("wifiAutoDownload", this.field_wifiAutoDownload);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.as
 * JD-Core Version:    0.7.0.1
 */