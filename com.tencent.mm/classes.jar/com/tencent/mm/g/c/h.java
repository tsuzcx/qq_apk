package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class h
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL;
  private static final int eFO = "createTime".hashCode();
  private static final int eGD = "appId".hashCode();
  private static final int eGE = "sdkVer".hashCode();
  private static final int eGF = "mediaSvrId".hashCode();
  private static final int eGG = "mediaId".hashCode();
  private static final int eGH = "clientAppDataId".hashCode();
  private static final int eGI;
  private static final int eGJ;
  private static final int eGK;
  private static final int eGL = "lastModifyTime".hashCode();
  private static final int eGM = "fileFullPath".hashCode();
  private static final int eGN = "fullXml".hashCode();
  private static final int eGO = "msgInfoId".hashCode();
  private static final int eGP = "netTimes".hashCode();
  private static final int eGQ = "isUseCdn".hashCode();
  private static final int eGR = "signature".hashCode();
  private static final int eGS = "fakeAeskey".hashCode();
  private static final int eGT = "fakeSignature".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eEI = true;
  private boolean eFr = true;
  private boolean eGA = true;
  private boolean eGB = true;
  private boolean eGC = true;
  private boolean eGm = true;
  private boolean eGn = true;
  private boolean eGo = true;
  private boolean eGp = true;
  private boolean eGq = true;
  private boolean eGr = true;
  private boolean eGs = true;
  private boolean eGt = true;
  private boolean eGu = true;
  private boolean eGv = true;
  private boolean eGw = true;
  private boolean eGx = true;
  private boolean eGy = true;
  private boolean eGz = true;
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
  
  static
  {
    eGI = "totalLen".hashCode();
    eGJ = "offset".hashCode();
    eEL = "status".hashCode();
    eGK = "isUpload".hashCode();
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
      if (eGD != k) {
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
      if (eGE == k)
      {
        this.field_sdkVer = paramCursor.getLong(i);
      }
      else if (eGF == k)
      {
        this.field_mediaSvrId = paramCursor.getString(i);
      }
      else if (eGG == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (eGH == k)
      {
        this.field_clientAppDataId = paramCursor.getString(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getLong(i);
      }
      else if (eGI == k)
      {
        this.field_totalLen = paramCursor.getLong(i);
      }
      else if (eGJ == k)
      {
        this.field_offset = paramCursor.getLong(i);
      }
      else if (eEL == k)
      {
        this.field_status = paramCursor.getLong(i);
      }
      else
      {
        if (eGK == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isUpload = bool;
            break;
          }
        }
        if (eFO == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (eGL == k) {
          this.field_lastModifyTime = paramCursor.getLong(i);
        } else if (eGM == k) {
          this.field_fileFullPath = paramCursor.getString(i);
        } else if (eGN == k) {
          this.field_fullXml = paramCursor.getString(i);
        } else if (eGO == k) {
          this.field_msgInfoId = paramCursor.getLong(i);
        } else if (eGP == k) {
          this.field_netTimes = paramCursor.getLong(i);
        } else if (eGQ == k) {
          this.field_isUseCdn = paramCursor.getInt(i);
        } else if (eGR == k) {
          this.field_signature = paramCursor.getString(i);
        } else if (eGS == k) {
          this.field_fakeAeskey = paramCursor.getString(i);
        } else if (eGT == k) {
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
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eGn) {
      localContentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
    }
    if (this.eGo) {
      localContentValues.put("mediaSvrId", this.field_mediaSvrId);
    }
    if (this.eGp) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.eGq) {
      localContentValues.put("clientAppDataId", this.field_clientAppDataId);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Long.valueOf(this.field_type));
    }
    if (this.eGr) {
      localContentValues.put("totalLen", Long.valueOf(this.field_totalLen));
    }
    if (this.eGs) {
      localContentValues.put("offset", Long.valueOf(this.field_offset));
    }
    if (this.eEI) {
      localContentValues.put("status", Long.valueOf(this.field_status));
    }
    if (this.eGt) {
      localContentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
    }
    if (this.eFr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eGu) {
      localContentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
    }
    if (this.eGv) {
      localContentValues.put("fileFullPath", this.field_fileFullPath);
    }
    if (this.eGw) {
      localContentValues.put("fullXml", this.field_fullXml);
    }
    if (this.eGx) {
      localContentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
    }
    if (this.eGy) {
      localContentValues.put("netTimes", Long.valueOf(this.field_netTimes));
    }
    if (this.eGz) {
      localContentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
    }
    if (this.eGA) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.eGB) {
      localContentValues.put("fakeAeskey", this.field_fakeAeskey);
    }
    if (this.eGC) {
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