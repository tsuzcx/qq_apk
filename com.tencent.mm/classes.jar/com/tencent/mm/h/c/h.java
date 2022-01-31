package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class h
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int csv;
  private static final int csy;
  private static final int ctA;
  private static final int ctB;
  private static final int ctC;
  private static final int ctl = "appId".hashCode();
  private static final int ctm = "sdkVer".hashCode();
  private static final int ctn = "mediaSvrId".hashCode();
  private static final int cto = "mediaId".hashCode();
  private static final int ctp = "clientAppDataId".hashCode();
  private static final int ctq;
  private static final int ctr;
  private static final int cts;
  private static final int ctt;
  private static final int ctu;
  private static final int ctv;
  private static final int ctw;
  private static final int cty;
  private static final int ctz;
  private boolean crX = true;
  private boolean crk = true;
  private boolean csU = true;
  private boolean csV = true;
  private boolean csW = true;
  private boolean csX = true;
  private boolean csY = true;
  private boolean csZ = true;
  private boolean csa = true;
  private boolean cta = true;
  private boolean ctb = true;
  private boolean ctc = true;
  private boolean ctd = true;
  private boolean cte = true;
  private boolean ctf = true;
  private boolean ctg = true;
  private boolean cth = true;
  private boolean cti = true;
  private boolean ctj = true;
  private boolean ctk = true;
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
    csy = "type".hashCode();
    ctq = "totalLen".hashCode();
    ctr = "offset".hashCode();
    crn = "status".hashCode();
    cts = "isUpload".hashCode();
    csv = "createTime".hashCode();
    ctt = "lastModifyTime".hashCode();
    ctu = "fileFullPath".hashCode();
    ctv = "fullXml".hashCode();
    ctw = "msgInfoId".hashCode();
    cty = "netTimes".hashCode();
    ctz = "isUseCdn".hashCode();
    ctA = "signature".hashCode();
    ctB = "fakeAeskey".hashCode();
    ctC = "fakeSignature".hashCode();
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
      if (ctl != k) {
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
      if (ctm == k)
      {
        this.field_sdkVer = paramCursor.getLong(i);
      }
      else if (ctn == k)
      {
        this.field_mediaSvrId = paramCursor.getString(i);
      }
      else if (cto == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (ctp == k)
      {
        this.field_clientAppDataId = paramCursor.getString(i);
      }
      else if (csy == k)
      {
        this.field_type = paramCursor.getLong(i);
      }
      else if (ctq == k)
      {
        this.field_totalLen = paramCursor.getLong(i);
      }
      else if (ctr == k)
      {
        this.field_offset = paramCursor.getLong(i);
      }
      else if (crn == k)
      {
        this.field_status = paramCursor.getLong(i);
      }
      else
      {
        if (cts == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isUpload = bool;
            break;
          }
        }
        if (csv == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (ctt == k) {
          this.field_lastModifyTime = paramCursor.getLong(i);
        } else if (ctu == k) {
          this.field_fileFullPath = paramCursor.getString(i);
        } else if (ctv == k) {
          this.field_fullXml = paramCursor.getString(i);
        } else if (ctw == k) {
          this.field_msgInfoId = paramCursor.getLong(i);
        } else if (cty == k) {
          this.field_netTimes = paramCursor.getLong(i);
        } else if (ctz == k) {
          this.field_isUseCdn = paramCursor.getInt(i);
        } else if (ctA == k) {
          this.field_signature = paramCursor.getString(i);
        } else if (ctB == k) {
          this.field_fakeAeskey = paramCursor.getString(i);
        } else if (ctC == k) {
          this.field_fakeSignature = paramCursor.getString(i);
        } else if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.csV) {
      localContentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
    }
    if (this.csW) {
      localContentValues.put("mediaSvrId", this.field_mediaSvrId);
    }
    if (this.csX) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.csY) {
      localContentValues.put("clientAppDataId", this.field_clientAppDataId);
    }
    if (this.csa) {
      localContentValues.put("type", Long.valueOf(this.field_type));
    }
    if (this.csZ) {
      localContentValues.put("totalLen", Long.valueOf(this.field_totalLen));
    }
    if (this.cta) {
      localContentValues.put("offset", Long.valueOf(this.field_offset));
    }
    if (this.crk) {
      localContentValues.put("status", Long.valueOf(this.field_status));
    }
    if (this.ctb) {
      localContentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
    }
    if (this.crX) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.ctc) {
      localContentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
    }
    if (this.ctd) {
      localContentValues.put("fileFullPath", this.field_fileFullPath);
    }
    if (this.cte) {
      localContentValues.put("fullXml", this.field_fullXml);
    }
    if (this.ctf) {
      localContentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
    }
    if (this.ctg) {
      localContentValues.put("netTimes", Long.valueOf(this.field_netTimes));
    }
    if (this.cth) {
      localContentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
    }
    if (this.cti) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.ctj) {
      localContentValues.put("fakeAeskey", this.field_fakeAeskey);
    }
    if (this.ctk) {
      localContentValues.put("fakeSignature", this.field_fakeSignature);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.h
 * JD-Core Version:    0.7.0.1
 */