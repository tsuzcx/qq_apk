package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eXK = "newerIds".hashCode();
  private static final int eXL = "bgId".hashCode();
  private static final int eXM = "bgUrl".hashCode();
  private static final int eXN = "older_bgId".hashCode();
  private static final int eXO = "local_flag".hashCode();
  private static final int eXP = "istyle".hashCode();
  private static final int eXQ = "iFlag".hashCode();
  private static final int eXR = "icount".hashCode();
  private static final int eXS = "faultS".hashCode();
  private static final int eXT = "snsBgId".hashCode();
  private static final int eXU = "snsuser".hashCode();
  private static final int eXV = "adsession".hashCode();
  private static final int eXW = "lastFirstPageRequestErrCode".hashCode();
  private static final int eXX = "lastFirstPageRequestErrType".hashCode();
  private static final int eXY = "snsYearMonthInfo".hashCode();
  private static final int eXZ = "albumMd5".hashCode();
  private static final int ekS = "userName".hashCode();
  private static final int eyX = "md5".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eXA = true;
  private boolean eXB = true;
  private boolean eXC = true;
  private boolean eXD = true;
  private boolean eXE = true;
  private boolean eXF = true;
  private boolean eXG = true;
  private boolean eXH = true;
  private boolean eXI = true;
  private boolean eXJ = true;
  private boolean eXu = true;
  private boolean eXv = true;
  private boolean eXw = true;
  private boolean eXx = true;
  private boolean eXy = true;
  private boolean eXz = true;
  private boolean ekv = true;
  private boolean eyl = true;
  public byte[] field_adsession;
  public String field_albumMd5;
  public String field_bgId;
  public String field_bgUrl;
  public byte[] field_faultS;
  public int field_iFlag;
  public int field_icount;
  public int field_istyle;
  public int field_lastFirstPageRequestErrCode;
  public int field_lastFirstPageRequestErrType;
  public int field_local_flag;
  public String field_md5;
  public String field_newerIds;
  public String field_older_bgId;
  public long field_snsBgId;
  public byte[] field_snsYearMonthInfo;
  public byte[] field_snsuser;
  public String field_userName;
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (ekS != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.ekv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eyX == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (eXK == k) {
        this.field_newerIds = paramCursor.getString(i);
      } else if (eXL == k) {
        this.field_bgId = paramCursor.getString(i);
      } else if (eXM == k) {
        this.field_bgUrl = paramCursor.getString(i);
      } else if (eXN == k) {
        this.field_older_bgId = paramCursor.getString(i);
      } else if (eXO == k) {
        this.field_local_flag = paramCursor.getInt(i);
      } else if (eXP == k) {
        this.field_istyle = paramCursor.getInt(i);
      } else if (eXQ == k) {
        this.field_iFlag = paramCursor.getInt(i);
      } else if (eXR == k) {
        this.field_icount = paramCursor.getInt(i);
      } else if (eXS == k) {
        this.field_faultS = paramCursor.getBlob(i);
      } else if (eXT == k) {
        this.field_snsBgId = paramCursor.getLong(i);
      } else if (eXU == k) {
        this.field_snsuser = paramCursor.getBlob(i);
      } else if (eXV == k) {
        this.field_adsession = paramCursor.getBlob(i);
      } else if (eXW == k) {
        this.field_lastFirstPageRequestErrCode = paramCursor.getInt(i);
      } else if (eXX == k) {
        this.field_lastFirstPageRequestErrType = paramCursor.getInt(i);
      } else if (eXY == k) {
        this.field_snsYearMonthInfo = paramCursor.getBlob(i);
      } else if (eXZ == k) {
        this.field_albumMd5 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.ekv) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.eyl) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eXu) {
      localContentValues.put("newerIds", this.field_newerIds);
    }
    if (this.eXv) {
      localContentValues.put("bgId", this.field_bgId);
    }
    if (this.eXw) {
      localContentValues.put("bgUrl", this.field_bgUrl);
    }
    if (this.eXx) {
      localContentValues.put("older_bgId", this.field_older_bgId);
    }
    if (this.eXy) {
      localContentValues.put("local_flag", Integer.valueOf(this.field_local_flag));
    }
    if (this.eXz) {
      localContentValues.put("istyle", Integer.valueOf(this.field_istyle));
    }
    if (this.eXA) {
      localContentValues.put("iFlag", Integer.valueOf(this.field_iFlag));
    }
    if (this.eXB) {
      localContentValues.put("icount", Integer.valueOf(this.field_icount));
    }
    if (this.eXC) {
      localContentValues.put("faultS", this.field_faultS);
    }
    if (this.eXD) {
      localContentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
    }
    if (this.eXE) {
      localContentValues.put("snsuser", this.field_snsuser);
    }
    if (this.eXF) {
      localContentValues.put("adsession", this.field_adsession);
    }
    if (this.eXG) {
      localContentValues.put("lastFirstPageRequestErrCode", Integer.valueOf(this.field_lastFirstPageRequestErrCode));
    }
    if (this.eXH) {
      localContentValues.put("lastFirstPageRequestErrType", Integer.valueOf(this.field_lastFirstPageRequestErrType));
    }
    if (this.eXI) {
      localContentValues.put("snsYearMonthInfo", this.field_snsYearMonthInfo);
    }
    if (this.eXJ) {
      localContentValues.put("albumMd5", this.field_albumMd5);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fl
 * JD-Core Version:    0.7.0.1
 */