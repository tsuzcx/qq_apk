package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class h
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int createTime_HASHCODE = "createTime".hashCode();
  private static final int fjl;
  private static final int fkj = "appId".hashCode();
  private static final int fkk = "sdkVer".hashCode();
  private static final int fkl = "mediaSvrId".hashCode();
  private static final int fkm = "mediaId".hashCode();
  private static final int fkn = "clientAppDataId".hashCode();
  private static final int fko;
  private static final int fkp;
  private static final int fkq;
  private static final int fkr = "lastModifyTime".hashCode();
  private static final int fks = "fileFullPath".hashCode();
  private static final int fkt = "fullXml".hashCode();
  private static final int fku = "msgInfoId".hashCode();
  private static final int fkv = "netTimes".hashCode();
  private static final int fkw = "isUseCdn".hashCode();
  private static final int fkx = "signature".hashCode();
  private static final int fky = "fakeAeskey".hashCode();
  private static final int fkz = "fakeSignature".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSetcreateTime = true;
  private boolean __hadSettype = true;
  public String field_appId;
  public String field_clientAppDataId;
  public long field_createTime;
  public String field_fakeAeskey;
  public String field_fakeSignature;
  public String field_fileFullPath;
  public String field_fullXml;
  public boolean field_isUpload;
  public int field_isUseCdn;
  public long field_lastModifyTime;
  public String field_mediaId;
  public String field_mediaSvrId;
  public long field_msgInfoId;
  public long field_netTimes;
  public long field_offset;
  public long field_sdkVer;
  public String field_signature;
  public long field_status;
  public long field_totalLen;
  public long field_type;
  private boolean fjS = true;
  private boolean fjT = true;
  private boolean fjU = true;
  private boolean fjV = true;
  private boolean fjW = true;
  private boolean fjX = true;
  private boolean fjY = true;
  private boolean fjZ = true;
  private boolean fji = true;
  private boolean fka = true;
  private boolean fkb = true;
  private boolean fkc = true;
  private boolean fkd = true;
  private boolean fke = true;
  private boolean fkf = true;
  private boolean fkg = true;
  private boolean fkh = true;
  private boolean fki = true;
  
  static
  {
    fko = "totalLen".hashCode();
    fkp = "offset".hashCode();
    fjl = "status".hashCode();
    fkq = "isUpload".hashCode();
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
      if (fkj != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (fkk == k)
      {
        this.field_sdkVer = paramCursor.getLong(i);
      }
      else if (fkl == k)
      {
        this.field_mediaSvrId = paramCursor.getString(i);
      }
      else if (fkm == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (fkn == k)
      {
        this.field_clientAppDataId = paramCursor.getString(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getLong(i);
      }
      else if (fko == k)
      {
        this.field_totalLen = paramCursor.getLong(i);
      }
      else if (fkp == k)
      {
        this.field_offset = paramCursor.getLong(i);
      }
      else if (fjl == k)
      {
        this.field_status = paramCursor.getLong(i);
      }
      else
      {
        if (fkq == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isUpload = bool;
            break;
          }
        }
        if (createTime_HASHCODE == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (fkr == k) {
          this.field_lastModifyTime = paramCursor.getLong(i);
        } else if (fks == k) {
          this.field_fileFullPath = paramCursor.getString(i);
        } else if (fkt == k) {
          this.field_fullXml = paramCursor.getString(i);
        } else if (fku == k) {
          this.field_msgInfoId = paramCursor.getLong(i);
        } else if (fkv == k) {
          this.field_netTimes = paramCursor.getLong(i);
        } else if (fkw == k) {
          this.field_isUseCdn = paramCursor.getInt(i);
        } else if (fkx == k) {
          this.field_signature = paramCursor.getString(i);
        } else if (fky == k) {
          this.field_fakeAeskey = paramCursor.getString(i);
        } else if (fkz == k) {
          this.field_fakeSignature = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fjT) {
      localContentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
    }
    if (this.fjU) {
      localContentValues.put("mediaSvrId", this.field_mediaSvrId);
    }
    if (this.fjV) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.fjW) {
      localContentValues.put("clientAppDataId", this.field_clientAppDataId);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Long.valueOf(this.field_type));
    }
    if (this.fjX) {
      localContentValues.put("totalLen", Long.valueOf(this.field_totalLen));
    }
    if (this.fjY) {
      localContentValues.put("offset", Long.valueOf(this.field_offset));
    }
    if (this.fji) {
      localContentValues.put("status", Long.valueOf(this.field_status));
    }
    if (this.fjZ) {
      localContentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fka) {
      localContentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
    }
    if (this.fkb) {
      localContentValues.put("fileFullPath", this.field_fileFullPath);
    }
    if (this.fkc) {
      localContentValues.put("fullXml", this.field_fullXml);
    }
    if (this.fkd) {
      localContentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
    }
    if (this.fke) {
      localContentValues.put("netTimes", Long.valueOf(this.field_netTimes));
    }
    if (this.fkf) {
      localContentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
    }
    if (this.fkg) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.fkh) {
      localContentValues.put("fakeAeskey", this.field_fakeAeskey);
    }
    if (this.fki) {
      localContentValues.put("fakeSignature", this.field_fakeSignature);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.h
 * JD-Core Version:    0.7.0.1
 */