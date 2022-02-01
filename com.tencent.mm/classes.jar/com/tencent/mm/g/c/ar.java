package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ar
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int enR = "mediaId".hashCode();
  private static final int evC = "downloadUrlHashCode".hashCode();
  private static final int evD = "downloadUrl".hashCode();
  private static final int evE = "httpsUrl".hashCode();
  private static final int evF = "filePath".hashCode();
  private static final int evG = "verifyHeaders".hashCode();
  private static final int evH = "game_package_download".hashCode();
  private static final int evI = "allowMobileNetDownload".hashCode();
  private static final int evJ = "wifiAutoDownload".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean enA = true;
  private boolean evA = true;
  private boolean evB = true;
  private boolean evu = true;
  private boolean evv = true;
  private boolean evw = true;
  private boolean evx = true;
  private boolean evy = true;
  private boolean evz = true;
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
      if (enR != k) {
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
      if (evC == k)
      {
        this.field_downloadUrlHashCode = paramCursor.getInt(i);
        this.evu = true;
      }
      else if (evD == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (evE == k)
      {
        this.field_httpsUrl = paramCursor.getString(i);
      }
      else if (evF == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (evG == k)
      {
        this.field_verifyHeaders = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (evH == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_game_package_download = Boolean.valueOf(bool);
            break;
          }
        }
        if (evI == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_allowMobileNetDownload = Boolean.valueOf(bool);
            break;
          }
        }
        if (evJ == k)
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
    if (this.enA) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.evu) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.evv) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.evw) {
      localContentValues.put("httpsUrl", this.field_httpsUrl);
    }
    if (this.evx) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.evy) {
      localContentValues.put("verifyHeaders", this.field_verifyHeaders);
    }
    if (this.evz) {
      localContentValues.put("game_package_download", this.field_game_package_download);
    }
    if (this.evA) {
      localContentValues.put("allowMobileNetDownload", this.field_allowMobileNetDownload);
    }
    if (this.evB) {
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