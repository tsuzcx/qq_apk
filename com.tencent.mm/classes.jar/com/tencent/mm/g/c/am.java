package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class am
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dhE = "mediaId".hashCode();
  private static final int doH = "downloadUrlHashCode".hashCode();
  private static final int doI = "downloadUrl".hashCode();
  private static final int doJ = "httpsUrl".hashCode();
  private static final int doK = "filePath".hashCode();
  private static final int doL = "verifyHeaders".hashCode();
  private static final int doM = "game_package_download".hashCode();
  private static final int doN = "allowMobileNetDownload".hashCode();
  private static final int doO = "wifiAutoDownload".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dhn = true;
  private boolean doA = true;
  private boolean doB = true;
  private boolean doC = true;
  private boolean doD = true;
  private boolean doE = true;
  private boolean doF = true;
  private boolean doG = true;
  private boolean doz = true;
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
      if (dhE != k) {
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
      if (doH == k)
      {
        this.field_downloadUrlHashCode = paramCursor.getInt(i);
        this.doz = true;
      }
      else if (doI == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (doJ == k)
      {
        this.field_httpsUrl = paramCursor.getString(i);
      }
      else if (doK == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (doL == k)
      {
        this.field_verifyHeaders = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (doM == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_game_package_download = Boolean.valueOf(bool);
            break;
          }
        }
        if (doN == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_allowMobileNetDownload = Boolean.valueOf(bool);
            break;
          }
        }
        if (doO == k)
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
    if (this.dhn) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.doz) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.doA) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.doB) {
      localContentValues.put("httpsUrl", this.field_httpsUrl);
    }
    if (this.doC) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.doD) {
      localContentValues.put("verifyHeaders", this.field_verifyHeaders);
    }
    if (this.doE) {
      localContentValues.put("game_package_download", this.field_game_package_download);
    }
    if (this.doF) {
      localContentValues.put("allowMobileNetDownload", this.field_allowMobileNetDownload);
    }
    if (this.doG) {
      localContentValues.put("wifiAutoDownload", this.field_wifiAutoDownload);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.am
 * JD-Core Version:    0.7.0.1
 */