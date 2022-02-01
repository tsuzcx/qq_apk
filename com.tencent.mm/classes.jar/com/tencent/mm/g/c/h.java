package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class h
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ejR;
  private static final int ekU = "createTime".hashCode();
  private static final int elJ = "appId".hashCode();
  private static final int elK = "sdkVer".hashCode();
  private static final int elL = "mediaSvrId".hashCode();
  private static final int elM = "mediaId".hashCode();
  private static final int elN = "clientAppDataId".hashCode();
  private static final int elO;
  private static final int elP;
  private static final int elQ;
  private static final int elR = "lastModifyTime".hashCode();
  private static final int elS = "fileFullPath".hashCode();
  private static final int elT = "fullXml".hashCode();
  private static final int elU = "msgInfoId".hashCode();
  private static final int elV = "netTimes".hashCode();
  private static final int elW = "isUseCdn".hashCode();
  private static final int elX = "signature".hashCode();
  private static final int elY = "fakeAeskey".hashCode();
  private static final int elZ = "fakeSignature".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean ejO = true;
  private boolean ekx = true;
  private boolean elA = true;
  private boolean elB = true;
  private boolean elC = true;
  private boolean elD = true;
  private boolean elE = true;
  private boolean elF = true;
  private boolean elG = true;
  private boolean elH = true;
  private boolean elI = true;
  private boolean els = true;
  private boolean elt = true;
  private boolean elu = true;
  private boolean elv = true;
  private boolean elw = true;
  private boolean elx = true;
  private boolean ely = true;
  private boolean elz = true;
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
    elO = "totalLen".hashCode();
    elP = "offset".hashCode();
    ejR = "status".hashCode();
    elQ = "isUpload".hashCode();
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
      if (elJ != k) {
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
      if (elK == k)
      {
        this.field_sdkVer = paramCursor.getLong(i);
      }
      else if (elL == k)
      {
        this.field_mediaSvrId = paramCursor.getString(i);
      }
      else if (elM == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (elN == k)
      {
        this.field_clientAppDataId = paramCursor.getString(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getLong(i);
      }
      else if (elO == k)
      {
        this.field_totalLen = paramCursor.getLong(i);
      }
      else if (elP == k)
      {
        this.field_offset = paramCursor.getLong(i);
      }
      else if (ejR == k)
      {
        this.field_status = paramCursor.getLong(i);
      }
      else
      {
        if (elQ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isUpload = bool;
            break;
          }
        }
        if (ekU == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (elR == k) {
          this.field_lastModifyTime = paramCursor.getLong(i);
        } else if (elS == k) {
          this.field_fileFullPath = paramCursor.getString(i);
        } else if (elT == k) {
          this.field_fullXml = paramCursor.getString(i);
        } else if (elU == k) {
          this.field_msgInfoId = paramCursor.getLong(i);
        } else if (elV == k) {
          this.field_netTimes = paramCursor.getLong(i);
        } else if (elW == k) {
          this.field_isUseCdn = paramCursor.getInt(i);
        } else if (elX == k) {
          this.field_signature = paramCursor.getString(i);
        } else if (elY == k) {
          this.field_fakeAeskey = paramCursor.getString(i);
        } else if (elZ == k) {
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
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.elt) {
      localContentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
    }
    if (this.elu) {
      localContentValues.put("mediaSvrId", this.field_mediaSvrId);
    }
    if (this.elv) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.elw) {
      localContentValues.put("clientAppDataId", this.field_clientAppDataId);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Long.valueOf(this.field_type));
    }
    if (this.elx) {
      localContentValues.put("totalLen", Long.valueOf(this.field_totalLen));
    }
    if (this.ely) {
      localContentValues.put("offset", Long.valueOf(this.field_offset));
    }
    if (this.ejO) {
      localContentValues.put("status", Long.valueOf(this.field_status));
    }
    if (this.elz) {
      localContentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
    }
    if (this.ekx) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.elA) {
      localContentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
    }
    if (this.elB) {
      localContentValues.put("fileFullPath", this.field_fileFullPath);
    }
    if (this.elC) {
      localContentValues.put("fullXml", this.field_fullXml);
    }
    if (this.elD) {
      localContentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
    }
    if (this.elE) {
      localContentValues.put("netTimes", Long.valueOf(this.field_netTimes));
    }
    if (this.elF) {
      localContentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
    }
    if (this.elG) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.elH) {
      localContentValues.put("fakeAeskey", this.field_fakeAeskey);
    }
    if (this.elI) {
      localContentValues.put("fakeSignature", this.field_fakeSignature);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.h
 * JD-Core Version:    0.7.0.1
 */