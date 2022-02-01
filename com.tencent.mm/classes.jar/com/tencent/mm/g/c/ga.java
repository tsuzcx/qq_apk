package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ga
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFM = "userName".hashCode();
  private static final int eUA = "md5".hashCode();
  private static final int fvA = "snsYearMonthInfo".hashCode();
  private static final int fvB = "albumMd5".hashCode();
  private static final int fvm = "newerIds".hashCode();
  private static final int fvn = "bgId".hashCode();
  private static final int fvo = "bgUrl".hashCode();
  private static final int fvp = "older_bgId".hashCode();
  private static final int fvq = "local_flag".hashCode();
  private static final int fvr = "istyle".hashCode();
  private static final int fvs = "iFlag".hashCode();
  private static final int fvt = "icount".hashCode();
  private static final int fvu = "faultS".hashCode();
  private static final int fvv = "snsBgId".hashCode();
  private static final int fvw = "snsuser".hashCode();
  private static final int fvx = "adsession".hashCode();
  private static final int fvy = "lastFirstPageRequestErrCode".hashCode();
  private static final int fvz = "lastFirstPageRequestErrType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFp = true;
  private boolean eTO = true;
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
  private boolean fuW = true;
  private boolean fuX = true;
  private boolean fuY = true;
  private boolean fuZ = true;
  private boolean fva = true;
  private boolean fvb = true;
  private boolean fvc = true;
  private boolean fvd = true;
  private boolean fve = true;
  private boolean fvf = true;
  private boolean fvg = true;
  private boolean fvh = true;
  private boolean fvi = true;
  private boolean fvj = true;
  private boolean fvk = true;
  private boolean fvl = true;
  
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
      if (eFM != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.eFp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eUA == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (fvm == k) {
        this.field_newerIds = paramCursor.getString(i);
      } else if (fvn == k) {
        this.field_bgId = paramCursor.getString(i);
      } else if (fvo == k) {
        this.field_bgUrl = paramCursor.getString(i);
      } else if (fvp == k) {
        this.field_older_bgId = paramCursor.getString(i);
      } else if (fvq == k) {
        this.field_local_flag = paramCursor.getInt(i);
      } else if (fvr == k) {
        this.field_istyle = paramCursor.getInt(i);
      } else if (fvs == k) {
        this.field_iFlag = paramCursor.getInt(i);
      } else if (fvt == k) {
        this.field_icount = paramCursor.getInt(i);
      } else if (fvu == k) {
        this.field_faultS = paramCursor.getBlob(i);
      } else if (fvv == k) {
        this.field_snsBgId = paramCursor.getLong(i);
      } else if (fvw == k) {
        this.field_snsuser = paramCursor.getBlob(i);
      } else if (fvx == k) {
        this.field_adsession = paramCursor.getBlob(i);
      } else if (fvy == k) {
        this.field_lastFirstPageRequestErrCode = paramCursor.getInt(i);
      } else if (fvz == k) {
        this.field_lastFirstPageRequestErrType = paramCursor.getInt(i);
      } else if (fvA == k) {
        this.field_snsYearMonthInfo = paramCursor.getBlob(i);
      } else if (fvB == k) {
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
    if (this.eFp) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.eTO) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.fuW) {
      localContentValues.put("newerIds", this.field_newerIds);
    }
    if (this.fuX) {
      localContentValues.put("bgId", this.field_bgId);
    }
    if (this.fuY) {
      localContentValues.put("bgUrl", this.field_bgUrl);
    }
    if (this.fuZ) {
      localContentValues.put("older_bgId", this.field_older_bgId);
    }
    if (this.fva) {
      localContentValues.put("local_flag", Integer.valueOf(this.field_local_flag));
    }
    if (this.fvb) {
      localContentValues.put("istyle", Integer.valueOf(this.field_istyle));
    }
    if (this.fvc) {
      localContentValues.put("iFlag", Integer.valueOf(this.field_iFlag));
    }
    if (this.fvd) {
      localContentValues.put("icount", Integer.valueOf(this.field_icount));
    }
    if (this.fve) {
      localContentValues.put("faultS", this.field_faultS);
    }
    if (this.fvf) {
      localContentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
    }
    if (this.fvg) {
      localContentValues.put("snsuser", this.field_snsuser);
    }
    if (this.fvh) {
      localContentValues.put("adsession", this.field_adsession);
    }
    if (this.fvi) {
      localContentValues.put("lastFirstPageRequestErrCode", Integer.valueOf(this.field_lastFirstPageRequestErrCode));
    }
    if (this.fvj) {
      localContentValues.put("lastFirstPageRequestErrType", Integer.valueOf(this.field_lastFirstPageRequestErrType));
    }
    if (this.fvk) {
      localContentValues.put("snsYearMonthInfo", this.field_snsYearMonthInfo);
    }
    if (this.fvl) {
      localContentValues.put("albumMd5", this.field_albumMd5);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ga
 * JD-Core Version:    0.7.0.1
 */