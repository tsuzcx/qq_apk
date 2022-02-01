package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eAA = "recommandType".hashCode();
  private static final int eAB = "lang".hashCode();
  private static final int eAC = "recommandWord".hashCode();
  private static final int eAD = "buttonType".hashCode();
  private static final int eAE = "count".hashCode();
  private static final int eAf = "productID".hashCode();
  private static final int eAg = "packIconUrl".hashCode();
  private static final int eAh = "packGrayIconUrl".hashCode();
  private static final int eAi = "packCoverUrl".hashCode();
  private static final int eAj = "packName".hashCode();
  private static final int eAk = "packDesc".hashCode();
  private static final int eAl = "packAuthInfo".hashCode();
  private static final int eAm = "packPrice".hashCode();
  private static final int eAn = "packType".hashCode();
  private static final int eAo = "packFlag".hashCode();
  private static final int eAp = "packExpire".hashCode();
  private static final int eAq = "packTimeStamp".hashCode();
  private static final int eAr = "packCopyright".hashCode();
  private static final int eAs;
  private static final int eAt;
  private static final int eAu;
  private static final int eAv;
  private static final int eAw;
  private static final int eAx;
  private static final int eAy;
  private static final int eAz;
  private static final int elV;
  private static final int eqO;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eAa = true;
  private boolean eAb = true;
  private boolean eAc = true;
  private boolean eAd = true;
  private boolean eAe = true;
  private boolean elS = true;
  private boolean eqM = true;
  private boolean ezF = true;
  private boolean ezG = true;
  private boolean ezH = true;
  private boolean ezI = true;
  private boolean ezJ = true;
  private boolean ezK = true;
  private boolean ezL = true;
  private boolean ezM = true;
  private boolean ezN = true;
  private boolean ezO = true;
  private boolean ezP = true;
  private boolean ezQ = true;
  private boolean ezR = true;
  private boolean ezS = true;
  private boolean ezT = true;
  private boolean ezU = true;
  private boolean ezV = true;
  private boolean ezW = true;
  private boolean ezX = true;
  private boolean ezY = true;
  private boolean ezZ = true;
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
    elV = "status".hashCode();
    eAs = "sort".hashCode();
    eAt = "lastUseTime".hashCode();
    eAu = "packStatus".hashCode();
    eqO = "flag".hashCode();
    eAv = "recommand".hashCode();
    eAw = "sync".hashCode();
    eAx = "idx".hashCode();
    eAy = "BigIconUrl".hashCode();
    eAz = "MutiLanName".hashCode();
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
      if (eAf != k) {
        break label65;
      }
      this.field_productID = paramCursor.getString(i);
      this.ezF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eAg == k) {
        this.field_packIconUrl = paramCursor.getString(i);
      } else if (eAh == k) {
        this.field_packGrayIconUrl = paramCursor.getString(i);
      } else if (eAi == k) {
        this.field_packCoverUrl = paramCursor.getString(i);
      } else if (eAj == k) {
        this.field_packName = paramCursor.getString(i);
      } else if (eAk == k) {
        this.field_packDesc = paramCursor.getString(i);
      } else if (eAl == k) {
        this.field_packAuthInfo = paramCursor.getString(i);
      } else if (eAm == k) {
        this.field_packPrice = paramCursor.getString(i);
      } else if (eAn == k) {
        this.field_packType = paramCursor.getInt(i);
      } else if (eAo == k) {
        this.field_packFlag = paramCursor.getInt(i);
      } else if (eAp == k) {
        this.field_packExpire = paramCursor.getLong(i);
      } else if (eAq == k) {
        this.field_packTimeStamp = paramCursor.getLong(i);
      } else if (eAr == k) {
        this.field_packCopyright = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eAs == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (eAt == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (eAu == k) {
        this.field_packStatus = paramCursor.getInt(i);
      } else if (eqO == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eAv == k) {
        this.field_recommand = paramCursor.getInt(i);
      } else if (eAw == k) {
        this.field_sync = paramCursor.getInt(i);
      } else if (eAx == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (eAy == k) {
        this.field_BigIconUrl = paramCursor.getString(i);
      } else if (eAz == k) {
        this.field_MutiLanName = paramCursor.getString(i);
      } else if (eAA == k) {
        this.field_recommandType = paramCursor.getInt(i);
      } else if (eAB == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (eAC == k) {
        this.field_recommandWord = paramCursor.getString(i);
      } else if (eAD == k) {
        this.field_buttonType = paramCursor.getInt(i);
      } else if (eAE == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ezF) {
      localContentValues.put("productID", this.field_productID);
    }
    if (this.ezG) {
      localContentValues.put("packIconUrl", this.field_packIconUrl);
    }
    if (this.ezH) {
      localContentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
    }
    if (this.ezI) {
      localContentValues.put("packCoverUrl", this.field_packCoverUrl);
    }
    if (this.ezJ) {
      localContentValues.put("packName", this.field_packName);
    }
    if (this.ezK) {
      localContentValues.put("packDesc", this.field_packDesc);
    }
    if (this.ezL) {
      localContentValues.put("packAuthInfo", this.field_packAuthInfo);
    }
    if (this.ezM) {
      localContentValues.put("packPrice", this.field_packPrice);
    }
    if (this.ezN) {
      localContentValues.put("packType", Integer.valueOf(this.field_packType));
    }
    if (this.ezO) {
      localContentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
    }
    if (this.ezP) {
      localContentValues.put("packExpire", Long.valueOf(this.field_packExpire));
    }
    if (this.ezQ) {
      localContentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
    }
    if (this.ezR) {
      localContentValues.put("packCopyright", this.field_packCopyright);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.ezS) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
    }
    if (this.ezT) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.ezU) {
      localContentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
    }
    if (this.eqM) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.ezV) {
      localContentValues.put("recommand", Integer.valueOf(this.field_recommand));
    }
    if (this.ezW) {
      localContentValues.put("sync", Integer.valueOf(this.field_sync));
    }
    if (this.ezX) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.ezY) {
      localContentValues.put("BigIconUrl", this.field_BigIconUrl);
    }
    if (this.ezZ) {
      localContentValues.put("MutiLanName", this.field_MutiLanName);
    }
    if (this.eAa) {
      localContentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
    }
    if (this.eAb) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.eAc) {
      localContentValues.put("recommandWord", this.field_recommandWord);
    }
    if (this.eAd) {
      localContentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
    }
    if (this.eAe) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bg
 * JD-Core Version:    0.7.0.1
 */