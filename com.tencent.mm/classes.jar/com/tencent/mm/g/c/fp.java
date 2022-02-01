package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBr = "md5".hashCode();
  private static final int emW = "userName".hashCode();
  private static final int faY = "newerIds".hashCode();
  private static final int faZ = "bgId".hashCode();
  private static final int fba = "bgUrl".hashCode();
  private static final int fbb = "older_bgId".hashCode();
  private static final int fbc = "local_flag".hashCode();
  private static final int fbd = "istyle".hashCode();
  private static final int fbe = "iFlag".hashCode();
  private static final int fbf = "icount".hashCode();
  private static final int fbg = "faultS".hashCode();
  private static final int fbh = "snsBgId".hashCode();
  private static final int fbi = "snsuser".hashCode();
  private static final int fbj = "adsession".hashCode();
  private static final int fbk = "lastFirstPageRequestErrCode".hashCode();
  private static final int fbl = "lastFirstPageRequestErrType".hashCode();
  private static final int fbm = "snsYearMonthInfo".hashCode();
  private static final int fbn = "albumMd5".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAF = true;
  private boolean emz = true;
  private boolean faI = true;
  private boolean faJ = true;
  private boolean faK = true;
  private boolean faL = true;
  private boolean faM = true;
  private boolean faN = true;
  private boolean faO = true;
  private boolean faP = true;
  private boolean faQ = true;
  private boolean faR = true;
  private boolean faS = true;
  private boolean faT = true;
  private boolean faU = true;
  private boolean faV = true;
  private boolean faW = true;
  private boolean faX = true;
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
      if (emW != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.emz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eBr == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (faY == k) {
        this.field_newerIds = paramCursor.getString(i);
      } else if (faZ == k) {
        this.field_bgId = paramCursor.getString(i);
      } else if (fba == k) {
        this.field_bgUrl = paramCursor.getString(i);
      } else if (fbb == k) {
        this.field_older_bgId = paramCursor.getString(i);
      } else if (fbc == k) {
        this.field_local_flag = paramCursor.getInt(i);
      } else if (fbd == k) {
        this.field_istyle = paramCursor.getInt(i);
      } else if (fbe == k) {
        this.field_iFlag = paramCursor.getInt(i);
      } else if (fbf == k) {
        this.field_icount = paramCursor.getInt(i);
      } else if (fbg == k) {
        this.field_faultS = paramCursor.getBlob(i);
      } else if (fbh == k) {
        this.field_snsBgId = paramCursor.getLong(i);
      } else if (fbi == k) {
        this.field_snsuser = paramCursor.getBlob(i);
      } else if (fbj == k) {
        this.field_adsession = paramCursor.getBlob(i);
      } else if (fbk == k) {
        this.field_lastFirstPageRequestErrCode = paramCursor.getInt(i);
      } else if (fbl == k) {
        this.field_lastFirstPageRequestErrType = paramCursor.getInt(i);
      } else if (fbm == k) {
        this.field_snsYearMonthInfo = paramCursor.getBlob(i);
      } else if (fbn == k) {
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
    if (this.emz) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.eAF) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.faI) {
      localContentValues.put("newerIds", this.field_newerIds);
    }
    if (this.faJ) {
      localContentValues.put("bgId", this.field_bgId);
    }
    if (this.faK) {
      localContentValues.put("bgUrl", this.field_bgUrl);
    }
    if (this.faL) {
      localContentValues.put("older_bgId", this.field_older_bgId);
    }
    if (this.faM) {
      localContentValues.put("local_flag", Integer.valueOf(this.field_local_flag));
    }
    if (this.faN) {
      localContentValues.put("istyle", Integer.valueOf(this.field_istyle));
    }
    if (this.faO) {
      localContentValues.put("iFlag", Integer.valueOf(this.field_iFlag));
    }
    if (this.faP) {
      localContentValues.put("icount", Integer.valueOf(this.field_icount));
    }
    if (this.faQ) {
      localContentValues.put("faultS", this.field_faultS);
    }
    if (this.faR) {
      localContentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
    }
    if (this.faS) {
      localContentValues.put("snsuser", this.field_snsuser);
    }
    if (this.faT) {
      localContentValues.put("adsession", this.field_adsession);
    }
    if (this.faU) {
      localContentValues.put("lastFirstPageRequestErrCode", Integer.valueOf(this.field_lastFirstPageRequestErrCode));
    }
    if (this.faV) {
      localContentValues.put("lastFirstPageRequestErrType", Integer.valueOf(this.field_lastFirstPageRequestErrType));
    }
    if (this.faW) {
      localContentValues.put("snsYearMonthInfo", this.field_snsYearMonthInfo);
    }
    if (this.faX) {
      localContentValues.put("albumMd5", this.field_albumMd5);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fp
 * JD-Core Version:    0.7.0.1
 */