package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class h
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dfJ;
  private static final int dgM = "createTime".hashCode();
  private static final int dhB = "appId".hashCode();
  private static final int dhC = "sdkVer".hashCode();
  private static final int dhD = "mediaSvrId".hashCode();
  private static final int dhE = "mediaId".hashCode();
  private static final int dhF = "clientAppDataId".hashCode();
  private static final int dhG;
  private static final int dhH;
  private static final int dhI;
  private static final int dhJ = "lastModifyTime".hashCode();
  private static final int dhK = "fileFullPath".hashCode();
  private static final int dhL = "fullXml".hashCode();
  private static final int dhM = "msgInfoId".hashCode();
  private static final int dhN = "netTimes".hashCode();
  private static final int dhO = "isUseCdn".hashCode();
  private static final int dhP = "signature".hashCode();
  private static final int dhQ = "fakeAeskey".hashCode();
  private static final int dhR = "fakeSignature".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean dfG = true;
  private boolean dgp = true;
  private boolean dhA = true;
  private boolean dhk = true;
  private boolean dhl = true;
  private boolean dhm = true;
  private boolean dhn = true;
  private boolean dho = true;
  private boolean dhp = true;
  private boolean dhq = true;
  private boolean dhr = true;
  private boolean dhs = true;
  private boolean dht = true;
  private boolean dhu = true;
  private boolean dhv = true;
  private boolean dhw = true;
  private boolean dhx = true;
  private boolean dhy = true;
  private boolean dhz = true;
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
    dhG = "totalLen".hashCode();
    dhH = "offset".hashCode();
    dfJ = "status".hashCode();
    dhI = "isUpload".hashCode();
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
      if (dhB != k) {
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
      if (dhC == k)
      {
        this.field_sdkVer = paramCursor.getLong(i);
      }
      else if (dhD == k)
      {
        this.field_mediaSvrId = paramCursor.getString(i);
      }
      else if (dhE == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (dhF == k)
      {
        this.field_clientAppDataId = paramCursor.getString(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getLong(i);
      }
      else if (dhG == k)
      {
        this.field_totalLen = paramCursor.getLong(i);
      }
      else if (dhH == k)
      {
        this.field_offset = paramCursor.getLong(i);
      }
      else if (dfJ == k)
      {
        this.field_status = paramCursor.getLong(i);
      }
      else
      {
        if (dhI == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isUpload = bool;
            break;
          }
        }
        if (dgM == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (dhJ == k) {
          this.field_lastModifyTime = paramCursor.getLong(i);
        } else if (dhK == k) {
          this.field_fileFullPath = paramCursor.getString(i);
        } else if (dhL == k) {
          this.field_fullXml = paramCursor.getString(i);
        } else if (dhM == k) {
          this.field_msgInfoId = paramCursor.getLong(i);
        } else if (dhN == k) {
          this.field_netTimes = paramCursor.getLong(i);
        } else if (dhO == k) {
          this.field_isUseCdn = paramCursor.getInt(i);
        } else if (dhP == k) {
          this.field_signature = paramCursor.getString(i);
        } else if (dhQ == k) {
          this.field_fakeAeskey = paramCursor.getString(i);
        } else if (dhR == k) {
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
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.dhl) {
      localContentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
    }
    if (this.dhm) {
      localContentValues.put("mediaSvrId", this.field_mediaSvrId);
    }
    if (this.dhn) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.dho) {
      localContentValues.put("clientAppDataId", this.field_clientAppDataId);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Long.valueOf(this.field_type));
    }
    if (this.dhp) {
      localContentValues.put("totalLen", Long.valueOf(this.field_totalLen));
    }
    if (this.dhq) {
      localContentValues.put("offset", Long.valueOf(this.field_offset));
    }
    if (this.dfG) {
      localContentValues.put("status", Long.valueOf(this.field_status));
    }
    if (this.dhr) {
      localContentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
    }
    if (this.dgp) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.dhs) {
      localContentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
    }
    if (this.dht) {
      localContentValues.put("fileFullPath", this.field_fileFullPath);
    }
    if (this.dhu) {
      localContentValues.put("fullXml", this.field_fullXml);
    }
    if (this.dhv) {
      localContentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
    }
    if (this.dhw) {
      localContentValues.put("netTimes", Long.valueOf(this.field_netTimes));
    }
    if (this.dhx) {
      localContentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
    }
    if (this.dhy) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.dhz) {
      localContentValues.put("fakeAeskey", this.field_fakeAeskey);
    }
    if (this.dhA) {
      localContentValues.put("fakeSignature", this.field_fakeSignature);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.h
 * JD-Core Version:    0.7.0.1
 */