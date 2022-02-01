package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bh
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDc;
  private static final int eHX = "flag".hashCode();
  private static final int eRD = "productID".hashCode();
  private static final int eRE = "packIconUrl".hashCode();
  private static final int eRF = "packGrayIconUrl".hashCode();
  private static final int eRG = "packCoverUrl".hashCode();
  private static final int eRH = "packName".hashCode();
  private static final int eRI = "packDesc".hashCode();
  private static final int eRJ = "packAuthInfo".hashCode();
  private static final int eRK = "packPrice".hashCode();
  private static final int eRL = "packType".hashCode();
  private static final int eRM = "packFlag".hashCode();
  private static final int eRN = "packExpire".hashCode();
  private static final int eRO = "packTimeStamp".hashCode();
  private static final int eRP = "packCopyright".hashCode();
  private static final int eRQ;
  private static final int eRR;
  private static final int eRS;
  private static final int eRT = "recommand".hashCode();
  private static final int eRU = "sync".hashCode();
  private static final int eRV = "idx".hashCode();
  private static final int eRW = "BigIconUrl".hashCode();
  private static final int eRX = "MutiLanName".hashCode();
  private static final int eRY = "recommandType".hashCode();
  private static final int eRZ = "lang".hashCode();
  private static final int eSa = "recommandWord".hashCode();
  private static final int eSb = "buttonType".hashCode();
  private static final int eSc = "count".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eCZ = true;
  private boolean eHV = true;
  private boolean eRA = true;
  private boolean eRB = true;
  private boolean eRC = true;
  private boolean eRd = true;
  private boolean eRe = true;
  private boolean eRf = true;
  private boolean eRg = true;
  private boolean eRh = true;
  private boolean eRi = true;
  private boolean eRj = true;
  private boolean eRk = true;
  private boolean eRl = true;
  private boolean eRm = true;
  private boolean eRn = true;
  private boolean eRo = true;
  private boolean eRp = true;
  private boolean eRq = true;
  private boolean eRr = true;
  private boolean eRs = true;
  private boolean eRt = true;
  private boolean eRu = true;
  private boolean eRv = true;
  private boolean eRw = true;
  private boolean eRx = true;
  private boolean eRy = true;
  private boolean eRz = true;
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
    eDc = "status".hashCode();
    eRQ = "sort".hashCode();
    eRR = "lastUseTime".hashCode();
    eRS = "packStatus".hashCode();
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
      if (eRD != k) {
        break label65;
      }
      this.field_productID = paramCursor.getString(i);
      this.eRd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eRE == k) {
        this.field_packIconUrl = paramCursor.getString(i);
      } else if (eRF == k) {
        this.field_packGrayIconUrl = paramCursor.getString(i);
      } else if (eRG == k) {
        this.field_packCoverUrl = paramCursor.getString(i);
      } else if (eRH == k) {
        this.field_packName = paramCursor.getString(i);
      } else if (eRI == k) {
        this.field_packDesc = paramCursor.getString(i);
      } else if (eRJ == k) {
        this.field_packAuthInfo = paramCursor.getString(i);
      } else if (eRK == k) {
        this.field_packPrice = paramCursor.getString(i);
      } else if (eRL == k) {
        this.field_packType = paramCursor.getInt(i);
      } else if (eRM == k) {
        this.field_packFlag = paramCursor.getInt(i);
      } else if (eRN == k) {
        this.field_packExpire = paramCursor.getLong(i);
      } else if (eRO == k) {
        this.field_packTimeStamp = paramCursor.getLong(i);
      } else if (eRP == k) {
        this.field_packCopyright = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eRQ == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (eRR == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (eRS == k) {
        this.field_packStatus = paramCursor.getInt(i);
      } else if (eHX == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eRT == k) {
        this.field_recommand = paramCursor.getInt(i);
      } else if (eRU == k) {
        this.field_sync = paramCursor.getInt(i);
      } else if (eRV == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (eRW == k) {
        this.field_BigIconUrl = paramCursor.getString(i);
      } else if (eRX == k) {
        this.field_MutiLanName = paramCursor.getString(i);
      } else if (eRY == k) {
        this.field_recommandType = paramCursor.getInt(i);
      } else if (eRZ == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (eSa == k) {
        this.field_recommandWord = paramCursor.getString(i);
      } else if (eSb == k) {
        this.field_buttonType = paramCursor.getInt(i);
      } else if (eSc == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eRd) {
      localContentValues.put("productID", this.field_productID);
    }
    if (this.eRe) {
      localContentValues.put("packIconUrl", this.field_packIconUrl);
    }
    if (this.eRf) {
      localContentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
    }
    if (this.eRg) {
      localContentValues.put("packCoverUrl", this.field_packCoverUrl);
    }
    if (this.eRh) {
      localContentValues.put("packName", this.field_packName);
    }
    if (this.eRi) {
      localContentValues.put("packDesc", this.field_packDesc);
    }
    if (this.eRj) {
      localContentValues.put("packAuthInfo", this.field_packAuthInfo);
    }
    if (this.eRk) {
      localContentValues.put("packPrice", this.field_packPrice);
    }
    if (this.eRl) {
      localContentValues.put("packType", Integer.valueOf(this.field_packType));
    }
    if (this.eRm) {
      localContentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
    }
    if (this.eRn) {
      localContentValues.put("packExpire", Long.valueOf(this.field_packExpire));
    }
    if (this.eRo) {
      localContentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
    }
    if (this.eRp) {
      localContentValues.put("packCopyright", this.field_packCopyright);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eRq) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
    }
    if (this.eRr) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.eRs) {
      localContentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
    }
    if (this.eHV) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eRt) {
      localContentValues.put("recommand", Integer.valueOf(this.field_recommand));
    }
    if (this.eRu) {
      localContentValues.put("sync", Integer.valueOf(this.field_sync));
    }
    if (this.eRv) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.eRw) {
      localContentValues.put("BigIconUrl", this.field_BigIconUrl);
    }
    if (this.eRx) {
      localContentValues.put("MutiLanName", this.field_MutiLanName);
    }
    if (this.eRy) {
      localContentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
    }
    if (this.eRz) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.eRA) {
      localContentValues.put("recommandWord", this.field_recommandWord);
    }
    if (this.eRB) {
      localContentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
    }
    if (this.eRC) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bh
 * JD-Core Version:    0.7.0.1
 */