package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ft
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dVM;
  private static final int dVN;
  private static final int dVO;
  private static final int dVP = "autoDownloadCount".hashCode();
  private static final int dVQ = "fileDownloadCount".hashCode();
  private static final int dVs;
  private static final int dVw;
  private static final int dgM;
  private static final int diB;
  private static final int dij;
  private static final int doI;
  private static final int doK;
  private static final int dtX;
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean dVH = true;
  private boolean dVI = true;
  private boolean dVJ = true;
  private boolean dVK = true;
  private boolean dVL = true;
  private boolean dVn = true;
  private boolean dVr = true;
  private boolean dgp = true;
  private boolean dih = true;
  private boolean div = true;
  private boolean doA = true;
  private boolean doC = true;
  private boolean dtk = true;
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
    dVs = "pkgId".hashCode();
    diB = "version".hashCode();
    doK = "filePath".hashCode();
    dVM = "rid".hashCode();
    dVN = "mimeType".hashCode();
    dtX = "md5".hashCode();
    doI = "downloadUrl".hashCode();
    dij = "size".hashCode();
    dVw = "downloadNetType".hashCode();
    dVO = "completeDownload".hashCode();
    dgM = "createTime".hashCode();
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
      if (dVs == k)
      {
        this.field_pkgId = paramCursor.getString(i);
      }
      else if (diB == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (doK == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (dVM == k)
      {
        this.field_rid = paramCursor.getString(i);
      }
      else if (dVN == k)
      {
        this.field_mimeType = paramCursor.getString(i);
      }
      else if (dtX == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (doI == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (dij == k)
      {
        this.field_size = paramCursor.getInt(i);
      }
      else if (dVw == k)
      {
        this.field_downloadNetType = paramCursor.getInt(i);
      }
      else
      {
        if (dVO == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_completeDownload = bool;
            break;
          }
        }
        if (dgM == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (dVP == k) {
          this.field_autoDownloadCount = paramCursor.getInt(i);
        } else if (dVQ == k) {
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
    if (this.dVn) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.div) {
      localContentValues.put("version", this.field_version);
    }
    if (this.doC) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.dVH) {
      localContentValues.put("rid", this.field_rid);
    }
    if (this.dVI) {
      localContentValues.put("mimeType", this.field_mimeType);
    }
    if (this.dtk) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.doA) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.dih) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.dVr) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.dVJ) {
      localContentValues.put("completeDownload", Boolean.valueOf(this.field_completeDownload));
    }
    if (this.dgp) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.dVK) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.dVL) {
      localContentValues.put("fileDownloadCount", Integer.valueOf(this.field_fileDownloadCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.ft
 * JD-Core Version:    0.7.0.1
 */