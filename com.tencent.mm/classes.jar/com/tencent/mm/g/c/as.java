package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class as
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGG = "mediaId".hashCode();
  private static final int eOK = "downloadUrlHashCode".hashCode();
  private static final int eOL = "downloadUrl".hashCode();
  private static final int eOM = "httpsUrl".hashCode();
  private static final int eON = "filePath".hashCode();
  private static final int eOO = "verifyHeaders".hashCode();
  private static final int eOP = "game_package_download".hashCode();
  private static final int eOQ = "allowMobileNetDownload".hashCode();
  private static final int eOR = "wifiAutoDownload".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGp = true;
  private boolean eOC = true;
  private boolean eOD = true;
  private boolean eOE = true;
  private boolean eOF = true;
  private boolean eOG = true;
  private boolean eOH = true;
  private boolean eOI = true;
  private boolean eOJ = true;
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
      if (eGG != k) {
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
      if (eOK == k)
      {
        this.field_downloadUrlHashCode = paramCursor.getInt(i);
        this.eOC = true;
      }
      else if (eOL == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (eOM == k)
      {
        this.field_httpsUrl = paramCursor.getString(i);
      }
      else if (eON == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (eOO == k)
      {
        this.field_verifyHeaders = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (eOP == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_game_package_download = Boolean.valueOf(bool);
            break;
          }
        }
        if (eOQ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_allowMobileNetDownload = Boolean.valueOf(bool);
            break;
          }
        }
        if (eOR == k)
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
    if (this.eGp) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.eOC) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.eOD) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.eOE) {
      localContentValues.put("httpsUrl", this.field_httpsUrl);
    }
    if (this.eOF) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.eOG) {
      localContentValues.put("verifyHeaders", this.field_verifyHeaders);
    }
    if (this.eOH) {
      localContentValues.put("game_package_download", this.field_game_package_download);
    }
    if (this.eOI) {
      localContentValues.put("allowMobileNetDownload", this.field_allowMobileNetDownload);
    }
    if (this.eOJ) {
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