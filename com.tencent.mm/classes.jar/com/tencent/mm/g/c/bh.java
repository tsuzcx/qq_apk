package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bh
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL;
  private static final int eJG = "flag".hashCode();
  private static final int eTA;
  private static final int eTB;
  private static final int eTC;
  private static final int eTD;
  private static final int eTE = "recommand".hashCode();
  private static final int eTF = "sync".hashCode();
  private static final int eTG = "idx".hashCode();
  private static final int eTH = "BigIconUrl".hashCode();
  private static final int eTI = "MutiLanName".hashCode();
  private static final int eTJ = "recommandType".hashCode();
  private static final int eTK = "lang".hashCode();
  private static final int eTL = "recommandWord".hashCode();
  private static final int eTM = "buttonType".hashCode();
  private static final int eTN = "count".hashCode();
  private static final int eTo = "productID".hashCode();
  private static final int eTp = "packIconUrl".hashCode();
  private static final int eTq = "packGrayIconUrl".hashCode();
  private static final int eTr = "packCoverUrl".hashCode();
  private static final int eTs = "packName".hashCode();
  private static final int eTt = "packDesc".hashCode();
  private static final int eTu = "packAuthInfo".hashCode();
  private static final int eTv = "packPrice".hashCode();
  private static final int eTw = "packType".hashCode();
  private static final int eTx = "packFlag".hashCode();
  private static final int eTy = "packExpire".hashCode();
  private static final int eTz = "packTimeStamp".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eEI = true;
  private boolean eJE = true;
  private boolean eSO = true;
  private boolean eSP = true;
  private boolean eSQ = true;
  private boolean eSR = true;
  private boolean eSS = true;
  private boolean eST = true;
  private boolean eSU = true;
  private boolean eSV = true;
  private boolean eSW = true;
  private boolean eSX = true;
  private boolean eSY = true;
  private boolean eSZ = true;
  private boolean eTa = true;
  private boolean eTb = true;
  private boolean eTc = true;
  private boolean eTd = true;
  private boolean eTe = true;
  private boolean eTf = true;
  private boolean eTg = true;
  private boolean eTh = true;
  private boolean eTi = true;
  private boolean eTj = true;
  private boolean eTk = true;
  private boolean eTl = true;
  private boolean eTm = true;
  private boolean eTn = true;
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
    eTA = "packCopyright".hashCode();
    type_HASHCODE = "type".hashCode();
    eEL = "status".hashCode();
    eTB = "sort".hashCode();
    eTC = "lastUseTime".hashCode();
    eTD = "packStatus".hashCode();
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
      if (eTo != k) {
        break label65;
      }
      this.field_productID = paramCursor.getString(i);
      this.eSO = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eTp == k) {
        this.field_packIconUrl = paramCursor.getString(i);
      } else if (eTq == k) {
        this.field_packGrayIconUrl = paramCursor.getString(i);
      } else if (eTr == k) {
        this.field_packCoverUrl = paramCursor.getString(i);
      } else if (eTs == k) {
        this.field_packName = paramCursor.getString(i);
      } else if (eTt == k) {
        this.field_packDesc = paramCursor.getString(i);
      } else if (eTu == k) {
        this.field_packAuthInfo = paramCursor.getString(i);
      } else if (eTv == k) {
        this.field_packPrice = paramCursor.getString(i);
      } else if (eTw == k) {
        this.field_packType = paramCursor.getInt(i);
      } else if (eTx == k) {
        this.field_packFlag = paramCursor.getInt(i);
      } else if (eTy == k) {
        this.field_packExpire = paramCursor.getLong(i);
      } else if (eTz == k) {
        this.field_packTimeStamp = paramCursor.getLong(i);
      } else if (eTA == k) {
        this.field_packCopyright = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eTB == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (eTC == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (eTD == k) {
        this.field_packStatus = paramCursor.getInt(i);
      } else if (eJG == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eTE == k) {
        this.field_recommand = paramCursor.getInt(i);
      } else if (eTF == k) {
        this.field_sync = paramCursor.getInt(i);
      } else if (eTG == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (eTH == k) {
        this.field_BigIconUrl = paramCursor.getString(i);
      } else if (eTI == k) {
        this.field_MutiLanName = paramCursor.getString(i);
      } else if (eTJ == k) {
        this.field_recommandType = paramCursor.getInt(i);
      } else if (eTK == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (eTL == k) {
        this.field_recommandWord = paramCursor.getString(i);
      } else if (eTM == k) {
        this.field_buttonType = paramCursor.getInt(i);
      } else if (eTN == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eSO) {
      localContentValues.put("productID", this.field_productID);
    }
    if (this.eSP) {
      localContentValues.put("packIconUrl", this.field_packIconUrl);
    }
    if (this.eSQ) {
      localContentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
    }
    if (this.eSR) {
      localContentValues.put("packCoverUrl", this.field_packCoverUrl);
    }
    if (this.eSS) {
      localContentValues.put("packName", this.field_packName);
    }
    if (this.eST) {
      localContentValues.put("packDesc", this.field_packDesc);
    }
    if (this.eSU) {
      localContentValues.put("packAuthInfo", this.field_packAuthInfo);
    }
    if (this.eSV) {
      localContentValues.put("packPrice", this.field_packPrice);
    }
    if (this.eSW) {
      localContentValues.put("packType", Integer.valueOf(this.field_packType));
    }
    if (this.eSX) {
      localContentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
    }
    if (this.eSY) {
      localContentValues.put("packExpire", Long.valueOf(this.field_packExpire));
    }
    if (this.eSZ) {
      localContentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
    }
    if (this.eTa) {
      localContentValues.put("packCopyright", this.field_packCopyright);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eTb) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
    }
    if (this.eTc) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.eTd) {
      localContentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
    }
    if (this.eJE) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eTe) {
      localContentValues.put("recommand", Integer.valueOf(this.field_recommand));
    }
    if (this.eTf) {
      localContentValues.put("sync", Integer.valueOf(this.field_sync));
    }
    if (this.eTg) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.eTh) {
      localContentValues.put("BigIconUrl", this.field_BigIconUrl);
    }
    if (this.eTi) {
      localContentValues.put("MutiLanName", this.field_MutiLanName);
    }
    if (this.eTj) {
      localContentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
    }
    if (this.eTk) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.eTl) {
      localContentValues.put("recommandWord", this.field_recommandWord);
    }
    if (this.eTm) {
      localContentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
    }
    if (this.eTn) {
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