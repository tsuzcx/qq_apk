package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ar
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int elM = "mediaId".hashCode();
  private static final int etA = "httpsUrl".hashCode();
  private static final int etB = "filePath".hashCode();
  private static final int etC = "verifyHeaders".hashCode();
  private static final int etD = "game_package_download".hashCode();
  private static final int etE = "allowMobileNetDownload".hashCode();
  private static final int etF = "wifiAutoDownload".hashCode();
  private static final int ety = "downloadUrlHashCode".hashCode();
  private static final int etz = "downloadUrl".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean elv = true;
  private boolean etq = true;
  private boolean etr = true;
  private boolean ets = true;
  private boolean ett = true;
  private boolean etu = true;
  private boolean etv = true;
  private boolean etw = true;
  private boolean etx = true;
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
      if (elM != k) {
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
      if (ety == k)
      {
        this.field_downloadUrlHashCode = paramCursor.getInt(i);
        this.etq = true;
      }
      else if (etz == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (etA == k)
      {
        this.field_httpsUrl = paramCursor.getString(i);
      }
      else if (etB == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (etC == k)
      {
        this.field_verifyHeaders = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (etD == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_game_package_download = Boolean.valueOf(bool);
            break;
          }
        }
        if (etE == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_allowMobileNetDownload = Boolean.valueOf(bool);
            break;
          }
        }
        if (etF == k)
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
    if (this.elv) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.etq) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.etr) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.ets) {
      localContentValues.put("httpsUrl", this.field_httpsUrl);
    }
    if (this.ett) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.etu) {
      localContentValues.put("verifyHeaders", this.field_verifyHeaders);
    }
    if (this.etv) {
      localContentValues.put("game_package_download", this.field_game_package_download);
    }
    if (this.etw) {
      localContentValues.put("allowMobileNetDownload", this.field_allowMobileNetDownload);
    }
    if (this.etx) {
      localContentValues.put("wifiAutoDownload", this.field_wifiAutoDownload);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ar
 * JD-Core Version:    0.7.0.1
 */