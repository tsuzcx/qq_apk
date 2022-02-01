package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fz
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEd = "userName".hashCode();
  private static final int eSP = "md5".hashCode();
  private static final int ftA = "snsYearMonthInfo".hashCode();
  private static final int ftB = "albumMd5".hashCode();
  private static final int ftm = "newerIds".hashCode();
  private static final int ftn = "bgId".hashCode();
  private static final int fto = "bgUrl".hashCode();
  private static final int ftp = "older_bgId".hashCode();
  private static final int ftq = "local_flag".hashCode();
  private static final int ftr = "istyle".hashCode();
  private static final int fts = "iFlag".hashCode();
  private static final int ftt = "icount".hashCode();
  private static final int ftu = "faultS".hashCode();
  private static final int ftv = "snsBgId".hashCode();
  private static final int ftw = "snsuser".hashCode();
  private static final int ftx = "adsession".hashCode();
  private static final int fty = "lastFirstPageRequestErrCode".hashCode();
  private static final int ftz = "lastFirstPageRequestErrType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDG = true;
  private boolean eSd = true;
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
  private boolean fsW = true;
  private boolean fsX = true;
  private boolean fsY = true;
  private boolean fsZ = true;
  private boolean fta = true;
  private boolean ftb = true;
  private boolean ftc = true;
  private boolean ftd = true;
  private boolean fte = true;
  private boolean ftf = true;
  private boolean ftg = true;
  private boolean fth = true;
  private boolean fti = true;
  private boolean ftj = true;
  private boolean ftk = true;
  private boolean ftl = true;
  
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
      if (eEd != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.eDG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eSP == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (ftm == k) {
        this.field_newerIds = paramCursor.getString(i);
      } else if (ftn == k) {
        this.field_bgId = paramCursor.getString(i);
      } else if (fto == k) {
        this.field_bgUrl = paramCursor.getString(i);
      } else if (ftp == k) {
        this.field_older_bgId = paramCursor.getString(i);
      } else if (ftq == k) {
        this.field_local_flag = paramCursor.getInt(i);
      } else if (ftr == k) {
        this.field_istyle = paramCursor.getInt(i);
      } else if (fts == k) {
        this.field_iFlag = paramCursor.getInt(i);
      } else if (ftt == k) {
        this.field_icount = paramCursor.getInt(i);
      } else if (ftu == k) {
        this.field_faultS = paramCursor.getBlob(i);
      } else if (ftv == k) {
        this.field_snsBgId = paramCursor.getLong(i);
      } else if (ftw == k) {
        this.field_snsuser = paramCursor.getBlob(i);
      } else if (ftx == k) {
        this.field_adsession = paramCursor.getBlob(i);
      } else if (fty == k) {
        this.field_lastFirstPageRequestErrCode = paramCursor.getInt(i);
      } else if (ftz == k) {
        this.field_lastFirstPageRequestErrType = paramCursor.getInt(i);
      } else if (ftA == k) {
        this.field_snsYearMonthInfo = paramCursor.getBlob(i);
      } else if (ftB == k) {
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
    if (this.eDG) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.eSd) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.fsW) {
      localContentValues.put("newerIds", this.field_newerIds);
    }
    if (this.fsX) {
      localContentValues.put("bgId", this.field_bgId);
    }
    if (this.fsY) {
      localContentValues.put("bgUrl", this.field_bgUrl);
    }
    if (this.fsZ) {
      localContentValues.put("older_bgId", this.field_older_bgId);
    }
    if (this.fta) {
      localContentValues.put("local_flag", Integer.valueOf(this.field_local_flag));
    }
    if (this.ftb) {
      localContentValues.put("istyle", Integer.valueOf(this.field_istyle));
    }
    if (this.ftc) {
      localContentValues.put("iFlag", Integer.valueOf(this.field_iFlag));
    }
    if (this.ftd) {
      localContentValues.put("icount", Integer.valueOf(this.field_icount));
    }
    if (this.fte) {
      localContentValues.put("faultS", this.field_faultS);
    }
    if (this.ftf) {
      localContentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
    }
    if (this.ftg) {
      localContentValues.put("snsuser", this.field_snsuser);
    }
    if (this.fth) {
      localContentValues.put("adsession", this.field_adsession);
    }
    if (this.fti) {
      localContentValues.put("lastFirstPageRequestErrCode", Integer.valueOf(this.field_lastFirstPageRequestErrCode));
    }
    if (this.ftj) {
      localContentValues.put("lastFirstPageRequestErrType", Integer.valueOf(this.field_lastFirstPageRequestErrType));
    }
    if (this.ftk) {
      localContentValues.put("snsYearMonthInfo", this.field_snsYearMonthInfo);
    }
    if (this.ftl) {
      localContentValues.put("albumMd5", this.field_albumMd5);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.fz
 * JD-Core Version:    0.7.0.1
 */