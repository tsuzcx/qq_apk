package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ay
  extends c
{
  private static final int cEA;
  private static final int cEB;
  private static final int cEC;
  private static final int cED;
  private static final int cEE;
  private static final int cEF;
  private static final int cEG;
  private static final int cEH;
  private static final int cEI;
  private static final int cEJ;
  private static final int cEK;
  private static final int cEL;
  private static final int cEM;
  private static final int cEN;
  private static final int cEO;
  private static final int cEP = "recommand".hashCode();
  private static final int cEQ = "sync".hashCode();
  private static final int cER = "idx".hashCode();
  private static final int cES = "BigIconUrl".hashCode();
  private static final int cET = "MutiLanName".hashCode();
  private static final int cEU = "recommandType".hashCode();
  private static final int cEV = "lang".hashCode();
  private static final int cEW = "recommandWord".hashCode();
  private static final int cEX = "buttonType".hashCode();
  private static final int cEY = "count".hashCode();
  private static final int cEz;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int csy;
  private static final int cwe;
  private boolean cDZ = true;
  private boolean cEa = true;
  private boolean cEb = true;
  private boolean cEc = true;
  private boolean cEd = true;
  private boolean cEe = true;
  private boolean cEf = true;
  private boolean cEg = true;
  private boolean cEh = true;
  private boolean cEi = true;
  private boolean cEj = true;
  private boolean cEk = true;
  private boolean cEl = true;
  private boolean cEm = true;
  private boolean cEn = true;
  private boolean cEo = true;
  private boolean cEp = true;
  private boolean cEq = true;
  private boolean cEr = true;
  private boolean cEs = true;
  private boolean cEt = true;
  private boolean cEu = true;
  private boolean cEv = true;
  private boolean cEw = true;
  private boolean cEx = true;
  private boolean cEy = true;
  private boolean crk = true;
  private boolean csa = true;
  private boolean cwc = true;
  public String field_BigIconUrl;
  public String field_MutiLanName;
  public int field_buttonType;
  public int field_count;
  public int field_flag;
  public int field_idx;
  public String field_lang;
  public long field_lastUseTime;
  public String field_packAuthInfo;
  public String field_packCopyright;
  public String field_packCoverUrl;
  public String field_packDesc;
  public long field_packExpire;
  public int field_packFlag;
  public String field_packGrayIconUrl;
  public String field_packIconUrl;
  public String field_packName;
  public String field_packPrice;
  public int field_packStatus;
  public long field_packTimeStamp;
  public int field_packType;
  public String field_productID;
  public int field_recommand;
  public int field_recommandType;
  public String field_recommandWord;
  public int field_sort;
  public int field_status;
  public int field_sync;
  public int field_type;
  
  static
  {
    cEz = "productID".hashCode();
    cEA = "packIconUrl".hashCode();
    cEB = "packGrayIconUrl".hashCode();
    cEC = "packCoverUrl".hashCode();
    cED = "packName".hashCode();
    cEE = "packDesc".hashCode();
    cEF = "packAuthInfo".hashCode();
    cEG = "packPrice".hashCode();
    cEH = "packType".hashCode();
    cEI = "packFlag".hashCode();
    cEJ = "packExpire".hashCode();
    cEK = "packTimeStamp".hashCode();
    cEL = "packCopyright".hashCode();
    csy = "type".hashCode();
    crn = "status".hashCode();
    cEM = "sort".hashCode();
    cEN = "lastUseTime".hashCode();
    cEO = "packStatus".hashCode();
    cwe = "flag".hashCode();
  }
  
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
      if (cEz != k) {
        break label65;
      }
      this.field_productID = paramCursor.getString(i);
      this.cDZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cEA == k) {
        this.field_packIconUrl = paramCursor.getString(i);
      } else if (cEB == k) {
        this.field_packGrayIconUrl = paramCursor.getString(i);
      } else if (cEC == k) {
        this.field_packCoverUrl = paramCursor.getString(i);
      } else if (cED == k) {
        this.field_packName = paramCursor.getString(i);
      } else if (cEE == k) {
        this.field_packDesc = paramCursor.getString(i);
      } else if (cEF == k) {
        this.field_packAuthInfo = paramCursor.getString(i);
      } else if (cEG == k) {
        this.field_packPrice = paramCursor.getString(i);
      } else if (cEH == k) {
        this.field_packType = paramCursor.getInt(i);
      } else if (cEI == k) {
        this.field_packFlag = paramCursor.getInt(i);
      } else if (cEJ == k) {
        this.field_packExpire = paramCursor.getLong(i);
      } else if (cEK == k) {
        this.field_packTimeStamp = paramCursor.getLong(i);
      } else if (cEL == k) {
        this.field_packCopyright = paramCursor.getString(i);
      } else if (csy == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (crn == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (cEM == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (cEN == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (cEO == k) {
        this.field_packStatus = paramCursor.getInt(i);
      } else if (cwe == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (cEP == k) {
        this.field_recommand = paramCursor.getInt(i);
      } else if (cEQ == k) {
        this.field_sync = paramCursor.getInt(i);
      } else if (cER == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (cES == k) {
        this.field_BigIconUrl = paramCursor.getString(i);
      } else if (cET == k) {
        this.field_MutiLanName = paramCursor.getString(i);
      } else if (cEU == k) {
        this.field_recommandType = paramCursor.getInt(i);
      } else if (cEV == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (cEW == k) {
        this.field_recommandWord = paramCursor.getString(i);
      } else if (cEX == k) {
        this.field_buttonType = paramCursor.getInt(i);
      } else if (cEY == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cDZ) {
      localContentValues.put("productID", this.field_productID);
    }
    if (this.cEa) {
      localContentValues.put("packIconUrl", this.field_packIconUrl);
    }
    if (this.cEb) {
      localContentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
    }
    if (this.cEc) {
      localContentValues.put("packCoverUrl", this.field_packCoverUrl);
    }
    if (this.cEd) {
      localContentValues.put("packName", this.field_packName);
    }
    if (this.cEe) {
      localContentValues.put("packDesc", this.field_packDesc);
    }
    if (this.cEf) {
      localContentValues.put("packAuthInfo", this.field_packAuthInfo);
    }
    if (this.cEg) {
      localContentValues.put("packPrice", this.field_packPrice);
    }
    if (this.cEh) {
      localContentValues.put("packType", Integer.valueOf(this.field_packType));
    }
    if (this.cEi) {
      localContentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
    }
    if (this.cEj) {
      localContentValues.put("packExpire", Long.valueOf(this.field_packExpire));
    }
    if (this.cEk) {
      localContentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
    }
    if (this.cEl) {
      localContentValues.put("packCopyright", this.field_packCopyright);
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.cEm) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
    }
    if (this.cEn) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.cEo) {
      localContentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
    }
    if (this.cwc) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.cEp) {
      localContentValues.put("recommand", Integer.valueOf(this.field_recommand));
    }
    if (this.cEq) {
      localContentValues.put("sync", Integer.valueOf(this.field_sync));
    }
    if (this.cEr) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.cEs) {
      localContentValues.put("BigIconUrl", this.field_BigIconUrl);
    }
    if (this.cEt) {
      localContentValues.put("MutiLanName", this.field_MutiLanName);
    }
    if (this.cEu) {
      localContentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
    }
    if (this.cEv) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.cEw) {
      localContentValues.put("recommandWord", this.field_recommandWord);
    }
    if (this.cEx) {
      localContentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
    }
    if (this.cEy) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.c.ay
 * JD-Core Version:    0.7.0.1
 */