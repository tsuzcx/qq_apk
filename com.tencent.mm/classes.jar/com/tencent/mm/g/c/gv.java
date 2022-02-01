package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gv
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBr;
  private static final int emY = "createTime".hashCode();
  private static final int eoH;
  private static final int epb;
  private static final int evD;
  private static final int evF;
  private static final int fiA;
  private static final int fiB;
  private static final int fiC;
  private static final int fiD = "autoDownloadCount".hashCode();
  private static final int fiE = "fileDownloadCount".hashCode();
  private static final int fid;
  private static final int fih;
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean eAF = true;
  private boolean emB = true;
  private boolean eoF = true;
  private boolean eoW = true;
  private boolean evv = true;
  private boolean evx = true;
  private boolean fhY = true;
  private boolean fic = true;
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
  private boolean fiv = true;
  private boolean fiw = true;
  private boolean fix = true;
  private boolean fiy = true;
  private boolean fiz = true;
  
  static
  {
    fid = "pkgId".hashCode();
    epb = "version".hashCode();
    evF = "filePath".hashCode();
    fiA = "rid".hashCode();
    fiB = "mimeType".hashCode();
    eBr = "md5".hashCode();
    evD = "downloadUrl".hashCode();
    eoH = "size".hashCode();
    fih = "downloadNetType".hashCode();
    fiC = "completeDownload".hashCode();
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
      if (fid == k)
      {
        this.field_pkgId = paramCursor.getString(i);
      }
      else if (epb == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (evF == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (fiA == k)
      {
        this.field_rid = paramCursor.getString(i);
      }
      else if (fiB == k)
      {
        this.field_mimeType = paramCursor.getString(i);
      }
      else if (eBr == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (evD == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (eoH == k)
      {
        this.field_size = paramCursor.getInt(i);
      }
      else if (fih == k)
      {
        this.field_downloadNetType = paramCursor.getInt(i);
      }
      else
      {
        if (fiC == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_completeDownload = bool;
            break;
          }
        }
        if (emY == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (fiD == k) {
          this.field_autoDownloadCount = paramCursor.getInt(i);
        } else if (fiE == k) {
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
    if (this.fhY) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.eoW) {
      localContentValues.put("version", this.field_version);
    }
    if (this.evx) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.fiv) {
      localContentValues.put("rid", this.field_rid);
    }
    if (this.fiw) {
      localContentValues.put("mimeType", this.field_mimeType);
    }
    if (this.eAF) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.evv) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.eoF) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.fic) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.fix) {
      localContentValues.put("completeDownload", Boolean.valueOf(this.field_completeDownload));
    }
    if (this.emB) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fiy) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.fiz) {
      localContentValues.put("fileDownloadCount", Integer.valueOf(this.field_fileDownloadCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gv
 * JD-Core Version:    0.7.0.1
 */