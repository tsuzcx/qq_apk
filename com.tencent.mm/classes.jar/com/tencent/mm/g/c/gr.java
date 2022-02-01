package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gr
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ekU = "createTime".hashCode();
  private static final int emB;
  private static final int emV;
  private static final int etB;
  private static final int etz;
  private static final int eyX;
  private static final int feL;
  private static final int feP;
  private static final int ffh;
  private static final int ffi;
  private static final int ffj;
  private static final int ffk = "autoDownloadCount".hashCode();
  private static final int ffl = "fileDownloadCount".hashCode();
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean ekx = true;
  private boolean emQ = true;
  private boolean emz = true;
  private boolean etr = true;
  private boolean ett = true;
  private boolean eyl = true;
  private boolean feG = true;
  private boolean feK = true;
  private boolean ffc = true;
  private boolean ffd = true;
  private boolean ffe = true;
  private boolean fff = true;
  private boolean ffg = true;
  public int field_autoDownloadCount;
  public boolean field_completeDownload;
  public long field_createTime;
  public int field_downloadNetType;
  public String field_downloadUrl;
  public int field_fileDownloadCount;
  public String field_filePath;
  public String field_key;
  public String field_md5;
  public String field_mimeType;
  public String field_pkgId;
  public String field_rid;
  public int field_size;
  public String field_version;
  
  static
  {
    feL = "pkgId".hashCode();
    emV = "version".hashCode();
    etB = "filePath".hashCode();
    ffh = "rid".hashCode();
    ffi = "mimeType".hashCode();
    eyX = "md5".hashCode();
    etz = "downloadUrl".hashCode();
    emB = "size".hashCode();
    feP = "downloadNetType".hashCode();
    ffj = "completeDownload".hashCode();
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
      if (key_HASHCODE != k) {
        break label65;
      }
      this.field_key = paramCursor.getString(i);
      this.__hadSetkey = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (feL == k)
      {
        this.field_pkgId = paramCursor.getString(i);
      }
      else if (emV == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (etB == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (ffh == k)
      {
        this.field_rid = paramCursor.getString(i);
      }
      else if (ffi == k)
      {
        this.field_mimeType = paramCursor.getString(i);
      }
      else if (eyX == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (etz == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (emB == k)
      {
        this.field_size = paramCursor.getInt(i);
      }
      else if (feP == k)
      {
        this.field_downloadNetType = paramCursor.getInt(i);
      }
      else
      {
        if (ffj == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_completeDownload = bool;
            break;
          }
        }
        if (ekU == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (ffk == k) {
          this.field_autoDownloadCount = paramCursor.getInt(i);
        } else if (ffl == k) {
          this.field_fileDownloadCount = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.feG) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.emQ) {
      localContentValues.put("version", this.field_version);
    }
    if (this.ett) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.ffc) {
      localContentValues.put("rid", this.field_rid);
    }
    if (this.ffd) {
      localContentValues.put("mimeType", this.field_mimeType);
    }
    if (this.eyl) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.etr) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.emz) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.feK) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.ffe) {
      localContentValues.put("completeDownload", Boolean.valueOf(this.field_completeDownload));
    }
    if (this.ekx) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fff) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.ffg) {
      localContentValues.put("fileDownloadCount", Integer.valueOf(this.field_fileDownloadCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gr
 * JD-Core Version:    0.7.0.1
 */