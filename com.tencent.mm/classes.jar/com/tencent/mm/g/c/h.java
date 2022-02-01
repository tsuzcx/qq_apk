package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class h
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int elV;
  private static final int emY = "createTime".hashCode();
  private static final int enO = "appId".hashCode();
  private static final int enP = "sdkVer".hashCode();
  private static final int enQ = "mediaSvrId".hashCode();
  private static final int enR = "mediaId".hashCode();
  private static final int enS = "clientAppDataId".hashCode();
  private static final int enT;
  private static final int enU;
  private static final int enV;
  private static final int enW = "lastModifyTime".hashCode();
  private static final int enX = "fileFullPath".hashCode();
  private static final int enY = "fullXml".hashCode();
  private static final int enZ = "msgInfoId".hashCode();
  private static final int eoa = "netTimes".hashCode();
  private static final int eob = "isUseCdn".hashCode();
  private static final int eoc = "signature".hashCode();
  private static final int eod = "fakeAeskey".hashCode();
  private static final int eoe = "fakeSignature".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean elS = true;
  private boolean emB = true;
  private boolean enA = true;
  private boolean enB = true;
  private boolean enC = true;
  private boolean enD = true;
  private boolean enE = true;
  private boolean enF = true;
  private boolean enG = true;
  private boolean enH = true;
  private boolean enI = true;
  private boolean enJ = true;
  private boolean enK = true;
  private boolean enL = true;
  private boolean enM = true;
  private boolean enN = true;
  private boolean enx = true;
  private boolean eny = true;
  private boolean enz = true;
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
    enT = "totalLen".hashCode();
    enU = "offset".hashCode();
    elV = "status".hashCode();
    enV = "isUpload".hashCode();
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
      if (enO != k) {
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
      if (enP == k)
      {
        this.field_sdkVer = paramCursor.getLong(i);
      }
      else if (enQ == k)
      {
        this.field_mediaSvrId = paramCursor.getString(i);
      }
      else if (enR == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (enS == k)
      {
        this.field_clientAppDataId = paramCursor.getString(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getLong(i);
      }
      else if (enT == k)
      {
        this.field_totalLen = paramCursor.getLong(i);
      }
      else if (enU == k)
      {
        this.field_offset = paramCursor.getLong(i);
      }
      else if (elV == k)
      {
        this.field_status = paramCursor.getLong(i);
      }
      else
      {
        if (enV == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isUpload = bool;
            break;
          }
        }
        if (emY == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (enW == k) {
          this.field_lastModifyTime = paramCursor.getLong(i);
        } else if (enX == k) {
          this.field_fileFullPath = paramCursor.getString(i);
        } else if (enY == k) {
          this.field_fullXml = paramCursor.getString(i);
        } else if (enZ == k) {
          this.field_msgInfoId = paramCursor.getLong(i);
        } else if (eoa == k) {
          this.field_netTimes = paramCursor.getLong(i);
        } else if (eob == k) {
          this.field_isUseCdn = paramCursor.getInt(i);
        } else if (eoc == k) {
          this.field_signature = paramCursor.getString(i);
        } else if (eod == k) {
          this.field_fakeAeskey = paramCursor.getString(i);
        } else if (eoe == k) {
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
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eny) {
      localContentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
    }
    if (this.enz) {
      localContentValues.put("mediaSvrId", this.field_mediaSvrId);
    }
    if (this.enA) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.enB) {
      localContentValues.put("clientAppDataId", this.field_clientAppDataId);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Long.valueOf(this.field_type));
    }
    if (this.enC) {
      localContentValues.put("totalLen", Long.valueOf(this.field_totalLen));
    }
    if (this.enD) {
      localContentValues.put("offset", Long.valueOf(this.field_offset));
    }
    if (this.elS) {
      localContentValues.put("status", Long.valueOf(this.field_status));
    }
    if (this.enE) {
      localContentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
    }
    if (this.emB) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.enF) {
      localContentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
    }
    if (this.enG) {
      localContentValues.put("fileFullPath", this.field_fileFullPath);
    }
    if (this.enH) {
      localContentValues.put("fullXml", this.field_fullXml);
    }
    if (this.enI) {
      localContentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
    }
    if (this.enJ) {
      localContentValues.put("netTimes", Long.valueOf(this.field_netTimes));
    }
    if (this.enK) {
      localContentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
    }
    if (this.enL) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.enM) {
      localContentValues.put("fakeAeskey", this.field_fakeAeskey);
    }
    if (this.enN) {
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