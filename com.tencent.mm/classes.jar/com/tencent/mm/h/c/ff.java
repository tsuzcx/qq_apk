package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ff
  extends c
{
  private static final int cAF;
  private static final int cAH;
  private static final int cFC;
  public static final String[] cqY = new String[0];
  private static final int crQ = "key".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int csv;
  private static final int ctS;
  private static final int cuv;
  private static final int deA;
  private static final int deB;
  private static final int deC;
  private static final int deD;
  private static final int deE;
  private static final int deF;
  private static final int dez = "pkgId".hashCode();
  private boolean cAx = true;
  private boolean cAz = true;
  private boolean cEZ = true;
  private boolean crM = true;
  private boolean crX = true;
  private boolean ctQ = true;
  private boolean cup = true;
  private boolean des = true;
  private boolean det = true;
  private boolean deu = true;
  private boolean dev = true;
  private boolean dew = true;
  private boolean dex = true;
  private boolean dey = true;
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
    cuv = "version".hashCode();
    cAH = "filePath".hashCode();
    deA = "rid".hashCode();
    deB = "mimeType".hashCode();
    cFC = "md5".hashCode();
    cAF = "downloadUrl".hashCode();
    ctS = "size".hashCode();
    deC = "downloadNetType".hashCode();
    deD = "completeDownload".hashCode();
    csv = "createTime".hashCode();
    deE = "autoDownloadCount".hashCode();
    deF = "fileDownloadCount".hashCode();
  }
  
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
      if (crQ != k) {
        break label65;
      }
      this.field_key = paramCursor.getString(i);
      this.crM = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dez == k)
      {
        this.field_pkgId = paramCursor.getString(i);
      }
      else if (cuv == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (cAH == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (deA == k)
      {
        this.field_rid = paramCursor.getString(i);
      }
      else if (deB == k)
      {
        this.field_mimeType = paramCursor.getString(i);
      }
      else if (cFC == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (cAF == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (ctS == k)
      {
        this.field_size = paramCursor.getInt(i);
      }
      else if (deC == k)
      {
        this.field_downloadNetType = paramCursor.getInt(i);
      }
      else
      {
        if (deD == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_completeDownload = bool;
            break;
          }
        }
        if (csv == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (deE == k) {
          this.field_autoDownloadCount = paramCursor.getInt(i);
        } else if (deF == k) {
          this.field_fileDownloadCount = paramCursor.getInt(i);
        } else if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.crM) {
      localContentValues.put("key", this.field_key);
    }
    if (this.des) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.cup) {
      localContentValues.put("version", this.field_version);
    }
    if (this.cAz) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.det) {
      localContentValues.put("rid", this.field_rid);
    }
    if (this.deu) {
      localContentValues.put("mimeType", this.field_mimeType);
    }
    if (this.cEZ) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.cAx) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.ctQ) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.dev) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.dew) {
      localContentValues.put("completeDownload", Boolean.valueOf(this.field_completeDownload));
    }
    if (this.crX) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.dex) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.dey) {
      localContentValues.put("fileDownloadCount", Integer.valueOf(this.field_fileDownloadCount));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.ff
 * JD-Core Version:    0.7.0.1
 */