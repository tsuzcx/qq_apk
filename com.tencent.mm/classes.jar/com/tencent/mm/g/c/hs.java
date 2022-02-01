package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hs
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int createTime_HASHCODE = "createTime".hashCode();
  private static final int fkX;
  private static final int flv;
  private static final int fss;
  private static final int fsu;
  private static final int fyf;
  private static final int ghR;
  private static final int ghS;
  private static final int ghT;
  private static final int ghU = "autoDownloadCount".hashCode();
  private static final int ghV = "fileDownloadCount".hashCode();
  private static final int ghj;
  private static final int ghn;
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetkey = true;
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
  private boolean fkV = true;
  private boolean flq = true;
  private boolean fsk = true;
  private boolean fsm = true;
  private boolean fxt = true;
  private boolean ghM = true;
  private boolean ghN = true;
  private boolean ghO = true;
  private boolean ghP = true;
  private boolean ghQ = true;
  private boolean ghe = true;
  private boolean ghi = true;
  
  static
  {
    ghj = "pkgId".hashCode();
    flv = "version".hashCode();
    fsu = "filePath".hashCode();
    ghR = "rid".hashCode();
    ghS = "mimeType".hashCode();
    fyf = "md5".hashCode();
    fss = "downloadUrl".hashCode();
    fkX = "size".hashCode();
    ghn = "downloadNetType".hashCode();
    ghT = "completeDownload".hashCode();
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
      if (ghj == k)
      {
        this.field_pkgId = paramCursor.getString(i);
      }
      else if (flv == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (fsu == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (ghR == k)
      {
        this.field_rid = paramCursor.getString(i);
      }
      else if (ghS == k)
      {
        this.field_mimeType = paramCursor.getString(i);
      }
      else if (fyf == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (fss == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (fkX == k)
      {
        this.field_size = paramCursor.getInt(i);
      }
      else if (ghn == k)
      {
        this.field_downloadNetType = paramCursor.getInt(i);
      }
      else
      {
        if (ghT == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_completeDownload = bool;
            break;
          }
        }
        if (createTime_HASHCODE == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (ghU == k) {
          this.field_autoDownloadCount = paramCursor.getInt(i);
        } else if (ghV == k) {
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
    if (this.ghe) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.flq) {
      localContentValues.put("version", this.field_version);
    }
    if (this.fsm) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.ghM) {
      localContentValues.put("rid", this.field_rid);
    }
    if (this.ghN) {
      localContentValues.put("mimeType", this.field_mimeType);
    }
    if (this.fxt) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.fsk) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.fkV) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.ghi) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.ghO) {
      localContentValues.put("completeDownload", Boolean.valueOf(this.field_completeDownload));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.ghP) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.ghQ) {
      localContentValues.put("fileDownloadCount", Integer.valueOf(this.field_fileDownloadCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.hs
 * JD-Core Version:    0.7.0.1
 */