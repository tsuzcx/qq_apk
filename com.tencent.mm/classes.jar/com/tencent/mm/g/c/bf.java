package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bf
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ejR;
  private static final int eoK = "flag".hashCode();
  private static final int exK = "productID".hashCode();
  private static final int exL = "packIconUrl".hashCode();
  private static final int exM = "packGrayIconUrl".hashCode();
  private static final int exN = "packCoverUrl".hashCode();
  private static final int exO = "packName".hashCode();
  private static final int exP = "packDesc".hashCode();
  private static final int exQ = "packAuthInfo".hashCode();
  private static final int exR = "packPrice".hashCode();
  private static final int exS = "packType".hashCode();
  private static final int exT = "packFlag".hashCode();
  private static final int exU = "packExpire".hashCode();
  private static final int exV = "packTimeStamp".hashCode();
  private static final int exW = "packCopyright".hashCode();
  private static final int exX;
  private static final int exY;
  private static final int exZ;
  private static final int eya = "recommand".hashCode();
  private static final int eyb = "sync".hashCode();
  private static final int eyc = "idx".hashCode();
  private static final int eyd = "BigIconUrl".hashCode();
  private static final int eyf = "MutiLanName".hashCode();
  private static final int eyg = "recommandType".hashCode();
  private static final int eyh = "lang".hashCode();
  private static final int eyi = "recommandWord".hashCode();
  private static final int eyj = "buttonType".hashCode();
  private static final int eyk = "count".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean ejO = true;
  private boolean eoI = true;
  private boolean exA = true;
  private boolean exB = true;
  private boolean exC = true;
  private boolean exD = true;
  private boolean exE = true;
  private boolean exF = true;
  private boolean exG = true;
  private boolean exH = true;
  private boolean exI = true;
  private boolean exJ = true;
  private boolean exk = true;
  private boolean exl = true;
  private boolean exm = true;
  private boolean exn = true;
  private boolean exo = true;
  private boolean exp = true;
  private boolean exq = true;
  private boolean exr = true;
  private boolean exs = true;
  private boolean ext = true;
  private boolean exu = true;
  private boolean exv = true;
  private boolean exw = true;
  private boolean exx = true;
  private boolean exy = true;
  private boolean exz = true;
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
    ejR = "status".hashCode();
    exX = "sort".hashCode();
    exY = "lastUseTime".hashCode();
    exZ = "packStatus".hashCode();
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
      if (exK != k) {
        break label65;
      }
      this.field_productID = paramCursor.getString(i);
      this.exk = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (exL == k) {
        this.field_packIconUrl = paramCursor.getString(i);
      } else if (exM == k) {
        this.field_packGrayIconUrl = paramCursor.getString(i);
      } else if (exN == k) {
        this.field_packCoverUrl = paramCursor.getString(i);
      } else if (exO == k) {
        this.field_packName = paramCursor.getString(i);
      } else if (exP == k) {
        this.field_packDesc = paramCursor.getString(i);
      } else if (exQ == k) {
        this.field_packAuthInfo = paramCursor.getString(i);
      } else if (exR == k) {
        this.field_packPrice = paramCursor.getString(i);
      } else if (exS == k) {
        this.field_packType = paramCursor.getInt(i);
      } else if (exT == k) {
        this.field_packFlag = paramCursor.getInt(i);
      } else if (exU == k) {
        this.field_packExpire = paramCursor.getLong(i);
      } else if (exV == k) {
        this.field_packTimeStamp = paramCursor.getLong(i);
      } else if (exW == k) {
        this.field_packCopyright = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (exX == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (exY == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (exZ == k) {
        this.field_packStatus = paramCursor.getInt(i);
      } else if (eoK == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eya == k) {
        this.field_recommand = paramCursor.getInt(i);
      } else if (eyb == k) {
        this.field_sync = paramCursor.getInt(i);
      } else if (eyc == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (eyd == k) {
        this.field_BigIconUrl = paramCursor.getString(i);
      } else if (eyf == k) {
        this.field_MutiLanName = paramCursor.getString(i);
      } else if (eyg == k) {
        this.field_recommandType = paramCursor.getInt(i);
      } else if (eyh == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (eyi == k) {
        this.field_recommandWord = paramCursor.getString(i);
      } else if (eyj == k) {
        this.field_buttonType = paramCursor.getInt(i);
      } else if (eyk == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.exk) {
      localContentValues.put("productID", this.field_productID);
    }
    if (this.exl) {
      localContentValues.put("packIconUrl", this.field_packIconUrl);
    }
    if (this.exm) {
      localContentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
    }
    if (this.exn) {
      localContentValues.put("packCoverUrl", this.field_packCoverUrl);
    }
    if (this.exo) {
      localContentValues.put("packName", this.field_packName);
    }
    if (this.exp) {
      localContentValues.put("packDesc", this.field_packDesc);
    }
    if (this.exq) {
      localContentValues.put("packAuthInfo", this.field_packAuthInfo);
    }
    if (this.exr) {
      localContentValues.put("packPrice", this.field_packPrice);
    }
    if (this.exs) {
      localContentValues.put("packType", Integer.valueOf(this.field_packType));
    }
    if (this.ext) {
      localContentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
    }
    if (this.exu) {
      localContentValues.put("packExpire", Long.valueOf(this.field_packExpire));
    }
    if (this.exv) {
      localContentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
    }
    if (this.exw) {
      localContentValues.put("packCopyright", this.field_packCopyright);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.exx) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
    }
    if (this.exy) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.exz) {
      localContentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
    }
    if (this.eoI) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.exA) {
      localContentValues.put("recommand", Integer.valueOf(this.field_recommand));
    }
    if (this.exB) {
      localContentValues.put("sync", Integer.valueOf(this.field_sync));
    }
    if (this.exC) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.exD) {
      localContentValues.put("BigIconUrl", this.field_BigIconUrl);
    }
    if (this.exE) {
      localContentValues.put("MutiLanName", this.field_MutiLanName);
    }
    if (this.exF) {
      localContentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
    }
    if (this.exG) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.exH) {
      localContentValues.put("recommandWord", this.field_recommandWord);
    }
    if (this.exI) {
      localContentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
    }
    if (this.exJ) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.bf
 * JD-Core Version:    0.7.0.1
 */