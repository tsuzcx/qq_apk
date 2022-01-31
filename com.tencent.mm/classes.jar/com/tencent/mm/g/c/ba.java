package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ba
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dfJ;
  private static final int dkn = "flag".hashCode();
  private static final int dsK = "productID".hashCode();
  private static final int dsL = "packIconUrl".hashCode();
  private static final int dsM = "packGrayIconUrl".hashCode();
  private static final int dsN = "packCoverUrl".hashCode();
  private static final int dsO = "packName".hashCode();
  private static final int dsP = "packDesc".hashCode();
  private static final int dsQ = "packAuthInfo".hashCode();
  private static final int dsR = "packPrice".hashCode();
  private static final int dsS = "packType".hashCode();
  private static final int dsT = "packFlag".hashCode();
  private static final int dsU = "packExpire".hashCode();
  private static final int dsV = "packTimeStamp".hashCode();
  private static final int dsW = "packCopyright".hashCode();
  private static final int dsX;
  private static final int dsY;
  private static final int dsZ;
  private static final int dta = "recommand".hashCode();
  private static final int dtb = "sync".hashCode();
  private static final int dtc = "idx".hashCode();
  private static final int dtd = "BigIconUrl".hashCode();
  private static final int dte = "MutiLanName".hashCode();
  private static final int dtf = "recommandType".hashCode();
  private static final int dtg = "lang".hashCode();
  private static final int dth = "recommandWord".hashCode();
  private static final int dti = "buttonType".hashCode();
  private static final int dtj = "count".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean dfG = true;
  private boolean dkl = true;
  private boolean dsA = true;
  private boolean dsB = true;
  private boolean dsC = true;
  private boolean dsD = true;
  private boolean dsE = true;
  private boolean dsF = true;
  private boolean dsG = true;
  private boolean dsH = true;
  private boolean dsI = true;
  private boolean dsJ = true;
  private boolean dsj = true;
  private boolean dsk = true;
  private boolean dsl = true;
  private boolean dsm = true;
  private boolean dsn = true;
  private boolean dso = true;
  private boolean dsp = true;
  private boolean dsq = true;
  private boolean dsr = true;
  private boolean dss = true;
  private boolean dsu = true;
  private boolean dsv = true;
  private boolean dsw = true;
  private boolean dsx = true;
  private boolean dsy = true;
  private boolean dsz = true;
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
    dfJ = "status".hashCode();
    dsX = "sort".hashCode();
    dsY = "lastUseTime".hashCode();
    dsZ = "packStatus".hashCode();
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
      if (dsK != k) {
        break label65;
      }
      this.field_productID = paramCursor.getString(i);
      this.dsj = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dsL == k) {
        this.field_packIconUrl = paramCursor.getString(i);
      } else if (dsM == k) {
        this.field_packGrayIconUrl = paramCursor.getString(i);
      } else if (dsN == k) {
        this.field_packCoverUrl = paramCursor.getString(i);
      } else if (dsO == k) {
        this.field_packName = paramCursor.getString(i);
      } else if (dsP == k) {
        this.field_packDesc = paramCursor.getString(i);
      } else if (dsQ == k) {
        this.field_packAuthInfo = paramCursor.getString(i);
      } else if (dsR == k) {
        this.field_packPrice = paramCursor.getString(i);
      } else if (dsS == k) {
        this.field_packType = paramCursor.getInt(i);
      } else if (dsT == k) {
        this.field_packFlag = paramCursor.getInt(i);
      } else if (dsU == k) {
        this.field_packExpire = paramCursor.getLong(i);
      } else if (dsV == k) {
        this.field_packTimeStamp = paramCursor.getLong(i);
      } else if (dsW == k) {
        this.field_packCopyright = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (dfJ == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (dsX == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (dsY == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (dsZ == k) {
        this.field_packStatus = paramCursor.getInt(i);
      } else if (dkn == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (dta == k) {
        this.field_recommand = paramCursor.getInt(i);
      } else if (dtb == k) {
        this.field_sync = paramCursor.getInt(i);
      } else if (dtc == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (dtd == k) {
        this.field_BigIconUrl = paramCursor.getString(i);
      } else if (dte == k) {
        this.field_MutiLanName = paramCursor.getString(i);
      } else if (dtf == k) {
        this.field_recommandType = paramCursor.getInt(i);
      } else if (dtg == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (dth == k) {
        this.field_recommandWord = paramCursor.getString(i);
      } else if (dti == k) {
        this.field_buttonType = paramCursor.getInt(i);
      } else if (dtj == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dsj) {
      localContentValues.put("productID", this.field_productID);
    }
    if (this.dsk) {
      localContentValues.put("packIconUrl", this.field_packIconUrl);
    }
    if (this.dsl) {
      localContentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
    }
    if (this.dsm) {
      localContentValues.put("packCoverUrl", this.field_packCoverUrl);
    }
    if (this.dsn) {
      localContentValues.put("packName", this.field_packName);
    }
    if (this.dso) {
      localContentValues.put("packDesc", this.field_packDesc);
    }
    if (this.dsp) {
      localContentValues.put("packAuthInfo", this.field_packAuthInfo);
    }
    if (this.dsq) {
      localContentValues.put("packPrice", this.field_packPrice);
    }
    if (this.dsr) {
      localContentValues.put("packType", Integer.valueOf(this.field_packType));
    }
    if (this.dss) {
      localContentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
    }
    if (this.dsu) {
      localContentValues.put("packExpire", Long.valueOf(this.field_packExpire));
    }
    if (this.dsv) {
      localContentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
    }
    if (this.dsw) {
      localContentValues.put("packCopyright", this.field_packCopyright);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.dsx) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
    }
    if (this.dsy) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.dsz) {
      localContentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
    }
    if (this.dkl) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.dsA) {
      localContentValues.put("recommand", Integer.valueOf(this.field_recommand));
    }
    if (this.dsB) {
      localContentValues.put("sync", Integer.valueOf(this.field_sync));
    }
    if (this.dsC) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.dsD) {
      localContentValues.put("BigIconUrl", this.field_BigIconUrl);
    }
    if (this.dsE) {
      localContentValues.put("MutiLanName", this.field_MutiLanName);
    }
    if (this.dsF) {
      localContentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
    }
    if (this.dsG) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.dsH) {
      localContentValues.put("recommandWord", this.field_recommandWord);
    }
    if (this.dsI) {
      localContentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
    }
    if (this.dsJ) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.ba
 * JD-Core Version:    0.7.0.1
 */