package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class h
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDc;
  private static final int eEU = "appId".hashCode();
  private static final int eEV = "sdkVer".hashCode();
  private static final int eEW = "mediaSvrId".hashCode();
  private static final int eEX = "mediaId".hashCode();
  private static final int eEY = "clientAppDataId".hashCode();
  private static final int eEZ;
  private static final int eEf = "createTime".hashCode();
  private static final int eFa;
  private static final int eFb;
  private static final int eFc = "lastModifyTime".hashCode();
  private static final int eFd = "fileFullPath".hashCode();
  private static final int eFe = "fullXml".hashCode();
  private static final int eFf = "msgInfoId".hashCode();
  private static final int eFg = "netTimes".hashCode();
  private static final int eFh = "isUseCdn".hashCode();
  private static final int eFi = "signature".hashCode();
  private static final int eFj = "fakeAeskey".hashCode();
  private static final int eFk = "fakeSignature".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eCZ = true;
  private boolean eDI = true;
  private boolean eED = true;
  private boolean eEE = true;
  private boolean eEF = true;
  private boolean eEG = true;
  private boolean eEH = true;
  private boolean eEI = true;
  private boolean eEJ = true;
  private boolean eEK = true;
  private boolean eEL = true;
  private boolean eEM = true;
  private boolean eEN = true;
  private boolean eEO = true;
  private boolean eEP = true;
  private boolean eEQ = true;
  private boolean eER = true;
  private boolean eES = true;
  private boolean eET = true;
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
    eEZ = "totalLen".hashCode();
    eFa = "offset".hashCode();
    eDc = "status".hashCode();
    eFb = "isUpload".hashCode();
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
      if (eEU != k) {
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
      if (eEV == k)
      {
        this.field_sdkVer = paramCursor.getLong(i);
      }
      else if (eEW == k)
      {
        this.field_mediaSvrId = paramCursor.getString(i);
      }
      else if (eEX == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (eEY == k)
      {
        this.field_clientAppDataId = paramCursor.getString(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getLong(i);
      }
      else if (eEZ == k)
      {
        this.field_totalLen = paramCursor.getLong(i);
      }
      else if (eFa == k)
      {
        this.field_offset = paramCursor.getLong(i);
      }
      else if (eDc == k)
      {
        this.field_status = paramCursor.getLong(i);
      }
      else
      {
        if (eFb == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isUpload = bool;
            break;
          }
        }
        if (eEf == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (eFc == k) {
          this.field_lastModifyTime = paramCursor.getLong(i);
        } else if (eFd == k) {
          this.field_fileFullPath = paramCursor.getString(i);
        } else if (eFe == k) {
          this.field_fullXml = paramCursor.getString(i);
        } else if (eFf == k) {
          this.field_msgInfoId = paramCursor.getLong(i);
        } else if (eFg == k) {
          this.field_netTimes = paramCursor.getLong(i);
        } else if (eFh == k) {
          this.field_isUseCdn = paramCursor.getInt(i);
        } else if (eFi == k) {
          this.field_signature = paramCursor.getString(i);
        } else if (eFj == k) {
          this.field_fakeAeskey = paramCursor.getString(i);
        } else if (eFk == k) {
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
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eEE) {
      localContentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
    }
    if (this.eEF) {
      localContentValues.put("mediaSvrId", this.field_mediaSvrId);
    }
    if (this.eEG) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.eEH) {
      localContentValues.put("clientAppDataId", this.field_clientAppDataId);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Long.valueOf(this.field_type));
    }
    if (this.eEI) {
      localContentValues.put("totalLen", Long.valueOf(this.field_totalLen));
    }
    if (this.eEJ) {
      localContentValues.put("offset", Long.valueOf(this.field_offset));
    }
    if (this.eCZ) {
      localContentValues.put("status", Long.valueOf(this.field_status));
    }
    if (this.eEK) {
      localContentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
    }
    if (this.eDI) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eEL) {
      localContentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
    }
    if (this.eEM) {
      localContentValues.put("fileFullPath", this.field_fileFullPath);
    }
    if (this.eEN) {
      localContentValues.put("fullXml", this.field_fullXml);
    }
    if (this.eEO) {
      localContentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
    }
    if (this.eEP) {
      localContentValues.put("netTimes", Long.valueOf(this.field_netTimes));
    }
    if (this.eEQ) {
      localContentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
    }
    if (this.eER) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.eES) {
      localContentValues.put("fakeAeskey", this.field_fakeAeskey);
    }
    if (this.eET) {
      localContentValues.put("fakeSignature", this.field_fakeSignature);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.h
 * JD-Core Version:    0.7.0.1
 */