package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ep
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dOV = "newerIds".hashCode();
  private static final int dOW = "bgId".hashCode();
  private static final int dOX = "bgUrl".hashCode();
  private static final int dOY = "older_bgId".hashCode();
  private static final int dOZ = "local_flag".hashCode();
  private static final int dPa = "istyle".hashCode();
  private static final int dPb = "iFlag".hashCode();
  private static final int dPc = "icount".hashCode();
  private static final int dPd = "faultS".hashCode();
  private static final int dPe = "snsBgId".hashCode();
  private static final int dPf = "snsuser".hashCode();
  private static final int dPg = "adsession".hashCode();
  private static final int dPh = "lastFirstPageRequestErrCode".hashCode();
  private static final int dPi = "lastFirstPageRequestErrType".hashCode();
  private static final int dgK = "userName".hashCode();
  private static final int dtX = "md5".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dOH = true;
  private boolean dOI = true;
  private boolean dOJ = true;
  private boolean dOK = true;
  private boolean dOL = true;
  private boolean dOM = true;
  private boolean dON = true;
  private boolean dOO = true;
  private boolean dOP = true;
  private boolean dOQ = true;
  private boolean dOR = true;
  private boolean dOS = true;
  private boolean dOT = true;
  private boolean dOU = true;
  private boolean dgn = true;
  private boolean dtk = true;
  public byte[] field_adsession;
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
      if (dgK != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.dgn = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dtX == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (dOV == k) {
        this.field_newerIds = paramCursor.getString(i);
      } else if (dOW == k) {
        this.field_bgId = paramCursor.getString(i);
      } else if (dOX == k) {
        this.field_bgUrl = paramCursor.getString(i);
      } else if (dOY == k) {
        this.field_older_bgId = paramCursor.getString(i);
      } else if (dOZ == k) {
        this.field_local_flag = paramCursor.getInt(i);
      } else if (dPa == k) {
        this.field_istyle = paramCursor.getInt(i);
      } else if (dPb == k) {
        this.field_iFlag = paramCursor.getInt(i);
      } else if (dPc == k) {
        this.field_icount = paramCursor.getInt(i);
      } else if (dPd == k) {
        this.field_faultS = paramCursor.getBlob(i);
      } else if (dPe == k) {
        this.field_snsBgId = paramCursor.getLong(i);
      } else if (dPf == k) {
        this.field_snsuser = paramCursor.getBlob(i);
      } else if (dPg == k) {
        this.field_adsession = paramCursor.getBlob(i);
      } else if (dPh == k) {
        this.field_lastFirstPageRequestErrCode = paramCursor.getInt(i);
      } else if (dPi == k) {
        this.field_lastFirstPageRequestErrType = paramCursor.getInt(i);
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
    if (this.dgn) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.dtk) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.dOH) {
      localContentValues.put("newerIds", this.field_newerIds);
    }
    if (this.dOI) {
      localContentValues.put("bgId", this.field_bgId);
    }
    if (this.dOJ) {
      localContentValues.put("bgUrl", this.field_bgUrl);
    }
    if (this.dOK) {
      localContentValues.put("older_bgId", this.field_older_bgId);
    }
    if (this.dOL) {
      localContentValues.put("local_flag", Integer.valueOf(this.field_local_flag));
    }
    if (this.dOM) {
      localContentValues.put("istyle", Integer.valueOf(this.field_istyle));
    }
    if (this.dON) {
      localContentValues.put("iFlag", Integer.valueOf(this.field_iFlag));
    }
    if (this.dOO) {
      localContentValues.put("icount", Integer.valueOf(this.field_icount));
    }
    if (this.dOP) {
      localContentValues.put("faultS", this.field_faultS);
    }
    if (this.dOQ) {
      localContentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
    }
    if (this.dOR) {
      localContentValues.put("snsuser", this.field_snsuser);
    }
    if (this.dOS) {
      localContentValues.put("adsession", this.field_adsession);
    }
    if (this.dOT) {
      localContentValues.put("lastFirstPageRequestErrCode", Integer.valueOf(this.field_lastFirstPageRequestErrCode));
    }
    if (this.dOU) {
      localContentValues.put("lastFirstPageRequestErrType", Integer.valueOf(this.field_lastFirstPageRequestErrType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ep
 * JD-Core Version:    0.7.0.1
 */