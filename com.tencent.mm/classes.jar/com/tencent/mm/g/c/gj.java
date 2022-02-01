package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gj
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fZV = "newerIds".hashCode();
  private static final int fZW = "bgId".hashCode();
  private static final int fZX = "bgUrl".hashCode();
  private static final int fZY = "older_bgId".hashCode();
  private static final int fZZ = "local_flag".hashCode();
  private static final int fyf;
  private static final int gaa = "istyle".hashCode();
  private static final int gab = "iFlag".hashCode();
  private static final int gac = "icount".hashCode();
  private static final int gad = "faultS".hashCode();
  private static final int gae = "snsBgId".hashCode();
  private static final int gaf = "snsuser".hashCode();
  private static final int gag = "adsession".hashCode();
  private static final int gah = "lastFirstPageRequestErrCode".hashCode();
  private static final int gai = "lastFirstPageRequestErrType".hashCode();
  private static final int gaj = "snsYearMonthInfo".hashCode();
  private static final int gak = "albumMd5".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int userName_HASHCODE = "userName".hashCode();
  private boolean __hadSetuserName = true;
  private boolean fZF = true;
  private boolean fZG = true;
  private boolean fZH = true;
  private boolean fZI = true;
  private boolean fZJ = true;
  private boolean fZK = true;
  private boolean fZL = true;
  private boolean fZM = true;
  private boolean fZN = true;
  private boolean fZO = true;
  private boolean fZP = true;
  private boolean fZQ = true;
  private boolean fZR = true;
  private boolean fZS = true;
  private boolean fZT = true;
  private boolean fZU = true;
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
  private boolean fxt = true;
  
  static
  {
    fyf = "md5".hashCode();
  }
  
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
      if (userName_HASHCODE != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.__hadSetuserName = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fyf == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (fZV == k) {
        this.field_newerIds = paramCursor.getString(i);
      } else if (fZW == k) {
        this.field_bgId = paramCursor.getString(i);
      } else if (fZX == k) {
        this.field_bgUrl = paramCursor.getString(i);
      } else if (fZY == k) {
        this.field_older_bgId = paramCursor.getString(i);
      } else if (fZZ == k) {
        this.field_local_flag = paramCursor.getInt(i);
      } else if (gaa == k) {
        this.field_istyle = paramCursor.getInt(i);
      } else if (gab == k) {
        this.field_iFlag = paramCursor.getInt(i);
      } else if (gac == k) {
        this.field_icount = paramCursor.getInt(i);
      } else if (gad == k) {
        this.field_faultS = paramCursor.getBlob(i);
      } else if (gae == k) {
        this.field_snsBgId = paramCursor.getLong(i);
      } else if (gaf == k) {
        this.field_snsuser = paramCursor.getBlob(i);
      } else if (gag == k) {
        this.field_adsession = paramCursor.getBlob(i);
      } else if (gah == k) {
        this.field_lastFirstPageRequestErrCode = paramCursor.getInt(i);
      } else if (gai == k) {
        this.field_lastFirstPageRequestErrType = paramCursor.getInt(i);
      } else if (gaj == k) {
        this.field_snsYearMonthInfo = paramCursor.getBlob(i);
      } else if (gak == k) {
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
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.fxt) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.fZF) {
      localContentValues.put("newerIds", this.field_newerIds);
    }
    if (this.fZG) {
      localContentValues.put("bgId", this.field_bgId);
    }
    if (this.fZH) {
      localContentValues.put("bgUrl", this.field_bgUrl);
    }
    if (this.fZI) {
      localContentValues.put("older_bgId", this.field_older_bgId);
    }
    if (this.fZJ) {
      localContentValues.put("local_flag", Integer.valueOf(this.field_local_flag));
    }
    if (this.fZK) {
      localContentValues.put("istyle", Integer.valueOf(this.field_istyle));
    }
    if (this.fZL) {
      localContentValues.put("iFlag", Integer.valueOf(this.field_iFlag));
    }
    if (this.fZM) {
      localContentValues.put("icount", Integer.valueOf(this.field_icount));
    }
    if (this.fZN) {
      localContentValues.put("faultS", this.field_faultS);
    }
    if (this.fZO) {
      localContentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
    }
    if (this.fZP) {
      localContentValues.put("snsuser", this.field_snsuser);
    }
    if (this.fZQ) {
      localContentValues.put("adsession", this.field_adsession);
    }
    if (this.fZR) {
      localContentValues.put("lastFirstPageRequestErrCode", Integer.valueOf(this.field_lastFirstPageRequestErrCode));
    }
    if (this.fZS) {
      localContentValues.put("lastFirstPageRequestErrType", Integer.valueOf(this.field_lastFirstPageRequestErrType));
    }
    if (this.fZT) {
      localContentValues.put("snsYearMonthInfo", this.field_snsYearMonthInfo);
    }
    if (this.fZU) {
      localContentValues.put("albumMd5", this.field_albumMd5);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gj
 * JD-Core Version:    0.7.0.1
 */