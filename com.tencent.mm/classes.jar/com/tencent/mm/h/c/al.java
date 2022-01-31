package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class al
  extends c
{
  private static final int cAE = "downloadUrlHashCode".hashCode();
  private static final int cAF = "downloadUrl".hashCode();
  private static final int cAG = "httpsUrl".hashCode();
  private static final int cAH = "filePath".hashCode();
  private static final int cAI = "verifyHeaders".hashCode();
  private static final int cAJ = "game_package_download".hashCode();
  private static final int cAK = "allowMobileNetDownload".hashCode();
  private static final int cAL = "wifiAutoDownload".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cto = "mediaId".hashCode();
  private boolean cAA = true;
  private boolean cAB = true;
  private boolean cAC = true;
  private boolean cAD = true;
  private boolean cAw = true;
  private boolean cAx = true;
  private boolean cAy = true;
  private boolean cAz = true;
  private boolean csX = true;
  public Boolean field_allowMobileNetDownload;
  public String field_downloadUrl;
  public int field_downloadUrlHashCode;
  public String field_filePath;
  public Boolean field_game_package_download;
  public String field_httpsUrl;
  public String field_mediaId;
  public String field_verifyHeaders;
  public Boolean field_wifiAutoDownload;
  
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
      if (cto != k) {
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
      if (cAE == k)
      {
        this.field_downloadUrlHashCode = paramCursor.getInt(i);
        this.cAw = true;
      }
      else if (cAF == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (cAG == k)
      {
        this.field_httpsUrl = paramCursor.getString(i);
      }
      else if (cAH == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (cAI == k)
      {
        this.field_verifyHeaders = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (cAJ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_game_package_download = Boolean.valueOf(bool);
            break;
          }
        }
        if (cAK == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_allowMobileNetDownload = Boolean.valueOf(bool);
            break;
          }
        }
        if (cAL == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_wifiAutoDownload = Boolean.valueOf(bool);
            break;
          }
        }
        if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.csX) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.cAw) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.cAx) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.cAy) {
      localContentValues.put("httpsUrl", this.field_httpsUrl);
    }
    if (this.cAz) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.cAA) {
      localContentValues.put("verifyHeaders", this.field_verifyHeaders);
    }
    if (this.cAB) {
      localContentValues.put("game_package_download", this.field_game_package_download);
    }
    if (this.cAC) {
      localContentValues.put("allowMobileNetDownload", this.field_allowMobileNetDownload);
    }
    if (this.cAD) {
      localContentValues.put("wifiAutoDownload", this.field_wifiAutoDownload);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.c.al
 * JD-Core Version:    0.7.0.1
 */