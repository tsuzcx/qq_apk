package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class at
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fkm = "mediaId".hashCode();
  private static final int fsr = "downloadUrlHashCode".hashCode();
  private static final int fss = "downloadUrl".hashCode();
  private static final int fst = "httpsUrl".hashCode();
  private static final int fsu = "filePath".hashCode();
  private static final int fsv = "verifyHeaders".hashCode();
  private static final int fsw = "game_package_download".hashCode();
  private static final int fsx = "allowMobileNetDownload".hashCode();
  private static final int fsy = "wifiAutoDownload".hashCode();
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
  private boolean fjV = true;
  private boolean fsj = true;
  private boolean fsk = true;
  private boolean fsl = true;
  private boolean fsm = true;
  private boolean fsn = true;
  private boolean fso = true;
  private boolean fsp = true;
  private boolean fsq = true;
  
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
      if (fkm != k) {
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
      if (fsr == k)
      {
        this.field_downloadUrlHashCode = paramCursor.getInt(i);
        this.fsj = true;
      }
      else if (fss == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (fst == k)
      {
        this.field_httpsUrl = paramCursor.getString(i);
      }
      else if (fsu == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (fsv == k)
      {
        this.field_verifyHeaders = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (fsw == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_game_package_download = Boolean.valueOf(bool);
            break;
          }
        }
        if (fsx == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_allowMobileNetDownload = Boolean.valueOf(bool);
            break;
          }
        }
        if (fsy == k)
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
    if (this.fjV) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.fsj) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.fsk) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.fsl) {
      localContentValues.put("httpsUrl", this.field_httpsUrl);
    }
    if (this.fsm) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.fsn) {
      localContentValues.put("verifyHeaders", this.field_verifyHeaders);
    }
    if (this.fso) {
      localContentValues.put("game_package_download", this.field_game_package_download);
    }
    if (this.fsp) {
      localContentValues.put("allowMobileNetDownload", this.field_allowMobileNetDownload);
    }
    if (this.fsq) {
      localContentValues.put("wifiAutoDownload", this.field_wifiAutoDownload);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.at
 * JD-Core Version:    0.7.0.1
 */