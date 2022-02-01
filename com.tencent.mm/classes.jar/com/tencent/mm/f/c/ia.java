package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ia
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_KEY;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WepkgPreloadFiles");
  private static final int createTime_HASHCODE = "createTime".hashCode();
  public static final Column hGW;
  private static final int hIy;
  public static final Column hpJ;
  public static final Column hpN;
  private static final int hpT;
  public static final Column hpd;
  private static final int hph;
  public static final Column hzC;
  private static final int hzQ;
  private static final int hzS;
  public static final Column iJC;
  private static final int iJI;
  private static final int iJM;
  public static final Column iJy;
  public static final Column iKP;
  public static final Column iKQ;
  public static final Column iKR;
  public static final Column iKS;
  private static final int iKY;
  private static final int iKZ;
  private static final int iLa;
  private static final int iLb = "autoDownloadCount".hashCode();
  private static final int iLc = "fileDownloadCount".hashCode();
  public static final Column imL;
  private static final int key_HASHCODE;
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
  private boolean hHK = true;
  private boolean hpO = true;
  private boolean hpf = true;
  private boolean hzI = true;
  private boolean hzK = true;
  private boolean iJD = true;
  private boolean iJH = true;
  private boolean iKT = true;
  private boolean iKU = true;
  private boolean iKV = true;
  private boolean iKW = true;
  private boolean iKX = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WepkgPreloadFiles", "");
    C_KEY = new Column("key", "string", "WepkgPreloadFiles", "");
    iJy = new Column("pkgid", "string", "WepkgPreloadFiles", "");
    hpJ = new Column("version", "string", "WepkgPreloadFiles", "");
    hzC = new Column("filepath", "string", "WepkgPreloadFiles", "");
    iKP = new Column("rid", "string", "WepkgPreloadFiles", "");
    imL = new Column("mimetype", "string", "WepkgPreloadFiles", "");
    hGW = new Column("md5", "string", "WepkgPreloadFiles", "");
    hpN = new Column("downloadurl", "string", "WepkgPreloadFiles", "");
    hpd = new Column("size", "int", "WepkgPreloadFiles", "");
    iJC = new Column("downloadnettype", "int", "WepkgPreloadFiles", "");
    iKQ = new Column("completedownload", "boolean", "WepkgPreloadFiles", "");
    C_CREATETIME = new Column("createtime", "long", "WepkgPreloadFiles", "");
    iKR = new Column("autodownloadcount", "int", "WepkgPreloadFiles", "");
    iKS = new Column("filedownloadcount", "int", "WepkgPreloadFiles", "");
    key_HASHCODE = "key".hashCode();
    iJI = "pkgId".hashCode();
    hpT = "version".hashCode();
    hzS = "filePath".hashCode();
    iKY = "rid".hashCode();
    iKZ = "mimeType".hashCode();
    hIy = "md5".hashCode();
    hzQ = "downloadUrl".hashCode();
    hph = "size".hashCode();
    iJM = "downloadNetType".hashCode();
    iLa = "completeDownload".hashCode();
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
      if (iJI == k)
      {
        this.field_pkgId = paramCursor.getString(i);
      }
      else if (hpT == k)
      {
        this.field_version = paramCursor.getString(i);
      }
      else if (hzS == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (iKY == k)
      {
        this.field_rid = paramCursor.getString(i);
      }
      else if (iKZ == k)
      {
        this.field_mimeType = paramCursor.getString(i);
      }
      else if (hIy == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (hzQ == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (hph == k)
      {
        this.field_size = paramCursor.getInt(i);
      }
      else if (iJM == k)
      {
        this.field_downloadNetType = paramCursor.getInt(i);
      }
      else
      {
        if (iLa == k)
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
        } else if (iLb == k) {
          this.field_autoDownloadCount = paramCursor.getInt(i);
        } else if (iLc == k) {
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
    if (this.iJD) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.hpO) {
      localContentValues.put("version", this.field_version);
    }
    if (this.hzK) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.iKT) {
      localContentValues.put("rid", this.field_rid);
    }
    if (this.iKU) {
      localContentValues.put("mimeType", this.field_mimeType);
    }
    if (this.hHK) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.hzI) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.hpf) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.iJH) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.iKV) {
      localContentValues.put("completeDownload", Boolean.valueOf(this.field_completeDownload));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.iKW) {
      localContentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
    }
    if (this.iKX) {
      localContentValues.put("fileDownloadCount", Integer.valueOf(this.field_fileDownloadCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "WepkgPreloadFiles";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ia
 * JD-Core Version:    0.7.0.1
 */