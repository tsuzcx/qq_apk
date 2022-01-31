package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ed
  extends c
{
  private static final int cFC = "md5".hashCode();
  private static final int cYB = "newerIds".hashCode();
  private static final int cYC = "bgId".hashCode();
  private static final int cYD = "bgUrl".hashCode();
  private static final int cYE = "older_bgId".hashCode();
  private static final int cYF = "local_flag".hashCode();
  private static final int cYG = "istyle".hashCode();
  private static final int cYH = "iFlag".hashCode();
  private static final int cYI = "icount".hashCode();
  private static final int cYJ = "faultS".hashCode();
  private static final int cYK = "snsBgId".hashCode();
  private static final int cYL = "snsuser".hashCode();
  private static final int cYM = "adsession".hashCode();
  private static final int cYN = "lastFirstPageRequestErrCode".hashCode();
  private static final int cYO = "lastFirstPageRequestErrType".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cst = "userName".hashCode();
  private boolean cEZ = true;
  private boolean cYA = true;
  private boolean cYn = true;
  private boolean cYo = true;
  private boolean cYp = true;
  private boolean cYq = true;
  private boolean cYr = true;
  private boolean cYs = true;
  private boolean cYt = true;
  private boolean cYu = true;
  private boolean cYv = true;
  private boolean cYw = true;
  private boolean cYx = true;
  private boolean cYy = true;
  private boolean cYz = true;
  private boolean crV = true;
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
  
  public final void d(Cursor paramCursor)
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
      if (cst != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.crV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cFC == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (cYB == k) {
        this.field_newerIds = paramCursor.getString(i);
      } else if (cYC == k) {
        this.field_bgId = paramCursor.getString(i);
      } else if (cYD == k) {
        this.field_bgUrl = paramCursor.getString(i);
      } else if (cYE == k) {
        this.field_older_bgId = paramCursor.getString(i);
      } else if (cYF == k) {
        this.field_local_flag = paramCursor.getInt(i);
      } else if (cYG == k) {
        this.field_istyle = paramCursor.getInt(i);
      } else if (cYH == k) {
        this.field_iFlag = paramCursor.getInt(i);
      } else if (cYI == k) {
        this.field_icount = paramCursor.getInt(i);
      } else if (cYJ == k) {
        this.field_faultS = paramCursor.getBlob(i);
      } else if (cYK == k) {
        this.field_snsBgId = paramCursor.getLong(i);
      } else if (cYL == k) {
        this.field_snsuser = paramCursor.getBlob(i);
      } else if (cYM == k) {
        this.field_adsession = paramCursor.getBlob(i);
      } else if (cYN == k) {
        this.field_lastFirstPageRequestErrCode = paramCursor.getInt(i);
      } else if (cYO == k) {
        this.field_lastFirstPageRequestErrType = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.crV) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.cEZ) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.cYn) {
      localContentValues.put("newerIds", this.field_newerIds);
    }
    if (this.cYo) {
      localContentValues.put("bgId", this.field_bgId);
    }
    if (this.cYp) {
      localContentValues.put("bgUrl", this.field_bgUrl);
    }
    if (this.cYq) {
      localContentValues.put("older_bgId", this.field_older_bgId);
    }
    if (this.cYr) {
      localContentValues.put("local_flag", Integer.valueOf(this.field_local_flag));
    }
    if (this.cYs) {
      localContentValues.put("istyle", Integer.valueOf(this.field_istyle));
    }
    if (this.cYt) {
      localContentValues.put("iFlag", Integer.valueOf(this.field_iFlag));
    }
    if (this.cYu) {
      localContentValues.put("icount", Integer.valueOf(this.field_icount));
    }
    if (this.cYv) {
      localContentValues.put("faultS", this.field_faultS);
    }
    if (this.cYw) {
      localContentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
    }
    if (this.cYx) {
      localContentValues.put("snsuser", this.field_snsuser);
    }
    if (this.cYy) {
      localContentValues.put("adsession", this.field_adsession);
    }
    if (this.cYz) {
      localContentValues.put("lastFirstPageRequestErrCode", Integer.valueOf(this.field_lastFirstPageRequestErrCode));
    }
    if (this.cYA) {
      localContentValues.put("lastFirstPageRequestErrType", Integer.valueOf(this.field_lastFirstPageRequestErrType));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.ed
 * JD-Core Version:    0.7.0.1
 */