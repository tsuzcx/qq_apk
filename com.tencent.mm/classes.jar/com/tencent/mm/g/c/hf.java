package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hf
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEf = "createTime".hashCode();
  private static final int eFM;
  private static final int eGk;
  private static final int eNa;
  private static final int eNc;
  private static final int eSP;
  private static final int fAH;
  private static final int fAI;
  private static final int fAJ;
  private static final int fAK = "autoDownloadCount".hashCode();
  private static final int fAL = "fileDownloadCount".hashCode();
  private static final int fAl;
  private static final int fAp;
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean eDI = true;
  private boolean eFK = true;
  private boolean eGf = true;
  private boolean eMS = true;
  private boolean eMU = true;
  private boolean eSd = true;
  private boolean fAC = true;
  private boolean fAD = true;
  private boolean fAE = true;
  private boolean fAF = true;
  private boolean fAG = true;
  private boolean fAg = true;
  private boolean fAk = true;
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
    fAl = "pkgId".hashCode();
    eGk = "version".hashCode();
    eNc = "filePath".hashCode();
    fAH = "rid".hashCode();
    fAI = "mimeType".hashCode();
    eSP = "md5".hashCode();
    eNa = "downloadUrl".hashCode();
    eFM = "size".hashCode();
    fAp = "downloadNetType".hashCode();
    fAJ = "completeDownload".hashCode();
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
      if (fAl == k)
      {
        this.field_pkgId = paramCursor.getString(i);
      }
      else if (eGk == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (eNc == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (fAH == k)
      {
        this.field_rid = paramCursor.getString(i);
      }
      else if (fAI == k)
      {
        this.field_mimeType = paramCursor.getString(i);
      }
      else if (eSP == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (eNa == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (eFM == k)
      {
        this.field_size = paramCursor.getInt(i);
      }
      else if (fAp == k)
      {
        this.field_downloadNetType = paramCursor.getInt(i);
      }
      else
      {
        if (fAJ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_completeDownload = bool;
            break;
          }
        }
        if (eEf == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (fAK == k) {
          this.field_autoDownloadCount = paramCursor.getInt(i);
        } else if (fAL == k) {
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
    if (this.fAg) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.eGf) {
      localContentValues.put("version", this.field_version);
    }
    if (this.eMU) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.fAC) {
      localContentValues.put("rid", this.field_rid);
    }
    if (this.fAD) {
      localContentValues.put("mimeType", this.field_mimeType);
    }
    if (this.eSd) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eMS) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.eFK) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.fAk) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.fAE) {
      localContentValues.put("completeDownload", Boolean.valueOf(this.field_completeDownload));
    }
    if (this.eDI) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fAF) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.fAG) {
      localContentValues.put("fileDownloadCount", Integer.valueOf(this.field_fileDownloadCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hf
 * JD-Core Version:    0.7.0.1
 */