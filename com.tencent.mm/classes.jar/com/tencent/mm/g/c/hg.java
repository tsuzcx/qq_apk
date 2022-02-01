package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFO = "createTime".hashCode();
  private static final int eHT;
  private static final int eHv;
  private static final int eOL;
  private static final int eON;
  private static final int eUA;
  private static final int fCH;
  private static final int fCI;
  private static final int fCJ;
  private static final int fCK = "autoDownloadCount".hashCode();
  private static final int fCL = "fileDownloadCount".hashCode();
  private static final int fCl;
  private static final int fCp;
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean eFr = true;
  private boolean eHO = true;
  private boolean eHt = true;
  private boolean eOD = true;
  private boolean eOF = true;
  private boolean eTO = true;
  private boolean fCC = true;
  private boolean fCD = true;
  private boolean fCE = true;
  private boolean fCF = true;
  private boolean fCG = true;
  private boolean fCg = true;
  private boolean fCk = true;
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
    fCl = "pkgId".hashCode();
    eHT = "version".hashCode();
    eON = "filePath".hashCode();
    fCH = "rid".hashCode();
    fCI = "mimeType".hashCode();
    eUA = "md5".hashCode();
    eOL = "downloadUrl".hashCode();
    eHv = "size".hashCode();
    fCp = "downloadNetType".hashCode();
    fCJ = "completeDownload".hashCode();
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
      if (fCl == k)
      {
        this.field_pkgId = paramCursor.getString(i);
      }
      else if (eHT == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (eON == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (fCH == k)
      {
        this.field_rid = paramCursor.getString(i);
      }
      else if (fCI == k)
      {
        this.field_mimeType = paramCursor.getString(i);
      }
      else if (eUA == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (eOL == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (eHv == k)
      {
        this.field_size = paramCursor.getInt(i);
      }
      else if (fCp == k)
      {
        this.field_downloadNetType = paramCursor.getInt(i);
      }
      else
      {
        if (fCJ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_completeDownload = bool;
            break;
          }
        }
        if (eFO == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (fCK == k) {
          this.field_autoDownloadCount = paramCursor.getInt(i);
        } else if (fCL == k) {
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
    if (this.fCg) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.eHO) {
      localContentValues.put("version", this.field_version);
    }
    if (this.eOF) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.fCC) {
      localContentValues.put("rid", this.field_rid);
    }
    if (this.fCD) {
      localContentValues.put("mimeType", this.field_mimeType);
    }
    if (this.eTO) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eOD) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.eHt) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.fCk) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.fCE) {
      localContentValues.put("completeDownload", Boolean.valueOf(this.field_completeDownload));
    }
    if (this.eFr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fCF) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.fCG) {
      localContentValues.put("fileDownloadCount", Integer.valueOf(this.field_fileDownloadCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hg
 * JD-Core Version:    0.7.0.1
 */