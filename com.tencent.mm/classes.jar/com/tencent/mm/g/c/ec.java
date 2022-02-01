package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ec
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fOA;
  private static final int fOB;
  private static final int fOC;
  private static final int fOD = "ThumbUrl_cn".hashCode();
  private static final int fOE = "ThumbUrl_hk".hashCode();
  private static final int fOF = "ThumbUrl_tw".hashCode();
  private static final int fOG = "ThumbUrl_en".hashCode();
  private static final int fOH = "ImgUrl_android_cn".hashCode();
  private static final int fOI = "ImgUrl_android_hk".hashCode();
  private static final int fOJ = "ImgUrl_android_tw".hashCode();
  private static final int fOK = "ImgUrl_android_en".hashCode();
  private static final int fOL = "RedPoint".hashCode();
  private static final int fOM = "WeAppDebugMode".hashCode();
  private static final int fON = "idkey".hashCode();
  private static final int fOO = "idkeyValue".hashCode();
  private static final int fOP = "Icon".hashCode();
  private static final int fOQ = "ImgUrl_cn".hashCode();
  private static final int fOR = "ImgUrl_hk".hashCode();
  private static final int fOS = "ImgUrl_tw".hashCode();
  private static final int fOT = "ImgUrl_en".hashCode();
  private static final int fOU = "bItemFromXExpt".hashCode();
  private static final int fOf = "LabsAppId".hashCode();
  private static final int fOg;
  private static final int fOh;
  private static final int fOi;
  private static final int fOj;
  private static final int fOk;
  private static final int fOl;
  private static final int fOm;
  private static final int fOn;
  private static final int fOo;
  private static final int fOp;
  private static final int fOq;
  private static final int fOr;
  private static final int fOs;
  private static final int fOt;
  private static final int fOu;
  private static final int fOv;
  private static final int fOw;
  private static final int fOx;
  private static final int fOy;
  private static final int fOz;
  private static final int fjl;
  private static final int fju = "expId".hashCode();
  private static final int fjv;
  private static final int fjw;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fNA = true;
  private boolean fNB = true;
  private boolean fNC = true;
  private boolean fND = true;
  private boolean fNE = true;
  private boolean fNF = true;
  private boolean fNG = true;
  private boolean fNH = true;
  private boolean fNI = true;
  private boolean fNJ = true;
  private boolean fNK = true;
  private boolean fNL = true;
  private boolean fNM = true;
  private boolean fNN = true;
  private boolean fNO = true;
  private boolean fNP = true;
  private boolean fNQ = true;
  private boolean fNR = true;
  private boolean fNS = true;
  private boolean fNT = true;
  private boolean fNU = true;
  private boolean fNV = true;
  private boolean fNW = true;
  private boolean fNX = true;
  private boolean fNY = true;
  private boolean fNZ = true;
  private boolean fNp = true;
  private boolean fNq = true;
  private boolean fNr = true;
  private boolean fNs = true;
  private boolean fNt = true;
  private boolean fNu = true;
  private boolean fNv = true;
  private boolean fNw = true;
  private boolean fNx = true;
  private boolean fNy = true;
  private boolean fNz = true;
  private boolean fOa = true;
  private boolean fOb = true;
  private boolean fOc = true;
  private boolean fOd = true;
  private boolean fOe = true;
  public int field_AllVer;
  public int field_BizType;
  public String field_Desc_cn;
  public String field_Desc_en;
  public String field_Desc_hk;
  public String field_Desc_tw;
  public String field_DetailURL;
  public String field_Icon;
  public String field_ImgUrl_android_cn;
  public String field_ImgUrl_android_en;
  public String field_ImgUrl_android_hk;
  public String field_ImgUrl_android_tw;
  public String field_ImgUrl_cn;
  public String field_ImgUrl_en;
  public String field_ImgUrl_hk;
  public String field_ImgUrl_tw;
  public String field_Introduce_cn;
  public String field_Introduce_en;
  public String field_Introduce_hk;
  public String field_Introduce_tw;
  public String field_LabsAppId;
  public int field_Pos;
  public int field_RedPoint;
  public int field_Switch;
  public String field_ThumbUrl_cn;
  public String field_ThumbUrl_en;
  public String field_ThumbUrl_hk;
  public String field_ThumbUrl_tw;
  public String field_TitleKey_android;
  public String field_Title_cn;
  public String field_Title_en;
  public String field_Title_hk;
  public String field_Title_tw;
  public int field_Type;
  public int field_WeAppDebugMode;
  public String field_WeAppPath;
  public String field_WeAppUser;
  public int field_bItemFromXExpt;
  public long field_endtime;
  public String field_expId;
  public int field_idkey;
  public int field_idkeyValue;
  public int field_prioritylevel;
  public long field_sequence;
  public long field_starttime;
  public int field_status;
  private boolean fji = true;
  private boolean fjn = true;
  private boolean fjo = true;
  private boolean fjp = true;
  
  static
  {
    fOg = "Type".hashCode();
    fOh = "BizType".hashCode();
    fOi = "Switch".hashCode();
    fOj = "AllVer".hashCode();
    fOk = "DetailURL".hashCode();
    fOl = "WeAppUser".hashCode();
    fOm = "WeAppPath".hashCode();
    fOn = "Pos".hashCode();
    fOo = "TitleKey_android".hashCode();
    fOp = "Title_cn".hashCode();
    fOq = "Title_hk".hashCode();
    fOr = "Title_tw".hashCode();
    fOs = "Title_en".hashCode();
    fOt = "Desc_cn".hashCode();
    fOu = "Desc_hk".hashCode();
    fOv = "Desc_tw".hashCode();
    fOw = "Desc_en".hashCode();
    fOx = "Introduce_cn".hashCode();
    fOy = "Introduce_hk".hashCode();
    fOz = "Introduce_tw".hashCode();
    fOA = "Introduce_en".hashCode();
    fOB = "starttime".hashCode();
    fOC = "endtime".hashCode();
    fjv = "sequence".hashCode();
    fjw = "prioritylevel".hashCode();
    fjl = "status".hashCode();
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
      if (fOf != k) {
        break label65;
      }
      this.field_LabsAppId = paramCursor.getString(i);
      this.fNp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fju == k) {
        this.field_expId = paramCursor.getString(i);
      } else if (fOg == k) {
        this.field_Type = paramCursor.getInt(i);
      } else if (fOh == k) {
        this.field_BizType = paramCursor.getInt(i);
      } else if (fOi == k) {
        this.field_Switch = paramCursor.getInt(i);
      } else if (fOj == k) {
        this.field_AllVer = paramCursor.getInt(i);
      } else if (fOk == k) {
        this.field_DetailURL = paramCursor.getString(i);
      } else if (fOl == k) {
        this.field_WeAppUser = paramCursor.getString(i);
      } else if (fOm == k) {
        this.field_WeAppPath = paramCursor.getString(i);
      } else if (fOn == k) {
        this.field_Pos = paramCursor.getInt(i);
      } else if (fOo == k) {
        this.field_TitleKey_android = paramCursor.getString(i);
      } else if (fOp == k) {
        this.field_Title_cn = paramCursor.getString(i);
      } else if (fOq == k) {
        this.field_Title_hk = paramCursor.getString(i);
      } else if (fOr == k) {
        this.field_Title_tw = paramCursor.getString(i);
      } else if (fOs == k) {
        this.field_Title_en = paramCursor.getString(i);
      } else if (fOt == k) {
        this.field_Desc_cn = paramCursor.getString(i);
      } else if (fOu == k) {
        this.field_Desc_hk = paramCursor.getString(i);
      } else if (fOv == k) {
        this.field_Desc_tw = paramCursor.getString(i);
      } else if (fOw == k) {
        this.field_Desc_en = paramCursor.getString(i);
      } else if (fOx == k) {
        this.field_Introduce_cn = paramCursor.getString(i);
      } else if (fOy == k) {
        this.field_Introduce_hk = paramCursor.getString(i);
      } else if (fOz == k) {
        this.field_Introduce_tw = paramCursor.getString(i);
      } else if (fOA == k) {
        this.field_Introduce_en = paramCursor.getString(i);
      } else if (fOB == k) {
        this.field_starttime = paramCursor.getLong(i);
      } else if (fOC == k) {
        this.field_endtime = paramCursor.getLong(i);
      } else if (fjv == k) {
        this.field_sequence = paramCursor.getLong(i);
      } else if (fjw == k) {
        this.field_prioritylevel = paramCursor.getInt(i);
      } else if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fOD == k) {
        this.field_ThumbUrl_cn = paramCursor.getString(i);
      } else if (fOE == k) {
        this.field_ThumbUrl_hk = paramCursor.getString(i);
      } else if (fOF == k) {
        this.field_ThumbUrl_tw = paramCursor.getString(i);
      } else if (fOG == k) {
        this.field_ThumbUrl_en = paramCursor.getString(i);
      } else if (fOH == k) {
        this.field_ImgUrl_android_cn = paramCursor.getString(i);
      } else if (fOI == k) {
        this.field_ImgUrl_android_hk = paramCursor.getString(i);
      } else if (fOJ == k) {
        this.field_ImgUrl_android_tw = paramCursor.getString(i);
      } else if (fOK == k) {
        this.field_ImgUrl_android_en = paramCursor.getString(i);
      } else if (fOL == k) {
        this.field_RedPoint = paramCursor.getInt(i);
      } else if (fOM == k) {
        this.field_WeAppDebugMode = paramCursor.getInt(i);
      } else if (fON == k) {
        this.field_idkey = paramCursor.getInt(i);
      } else if (fOO == k) {
        this.field_idkeyValue = paramCursor.getInt(i);
      } else if (fOP == k) {
        this.field_Icon = paramCursor.getString(i);
      } else if (fOQ == k) {
        this.field_ImgUrl_cn = paramCursor.getString(i);
      } else if (fOR == k) {
        this.field_ImgUrl_hk = paramCursor.getString(i);
      } else if (fOS == k) {
        this.field_ImgUrl_tw = paramCursor.getString(i);
      } else if (fOT == k) {
        this.field_ImgUrl_en = paramCursor.getString(i);
      } else if (fOU == k) {
        this.field_bItemFromXExpt = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fNp) {
      localContentValues.put("LabsAppId", this.field_LabsAppId);
    }
    if (this.field_expId == null) {
      this.field_expId = "";
    }
    if (this.fjn) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.fNq) {
      localContentValues.put("Type", Integer.valueOf(this.field_Type));
    }
    if (this.fNr) {
      localContentValues.put("BizType", Integer.valueOf(this.field_BizType));
    }
    if (this.fNs) {
      localContentValues.put("Switch", Integer.valueOf(this.field_Switch));
    }
    if (this.fNt) {
      localContentValues.put("AllVer", Integer.valueOf(this.field_AllVer));
    }
    if (this.fNu) {
      localContentValues.put("DetailURL", this.field_DetailURL);
    }
    if (this.fNv) {
      localContentValues.put("WeAppUser", this.field_WeAppUser);
    }
    if (this.fNw) {
      localContentValues.put("WeAppPath", this.field_WeAppPath);
    }
    if (this.fNx) {
      localContentValues.put("Pos", Integer.valueOf(this.field_Pos));
    }
    if (this.fNy) {
      localContentValues.put("TitleKey_android", this.field_TitleKey_android);
    }
    if (this.fNz) {
      localContentValues.put("Title_cn", this.field_Title_cn);
    }
    if (this.fNA) {
      localContentValues.put("Title_hk", this.field_Title_hk);
    }
    if (this.fNB) {
      localContentValues.put("Title_tw", this.field_Title_tw);
    }
    if (this.fNC) {
      localContentValues.put("Title_en", this.field_Title_en);
    }
    if (this.fND) {
      localContentValues.put("Desc_cn", this.field_Desc_cn);
    }
    if (this.fNE) {
      localContentValues.put("Desc_hk", this.field_Desc_hk);
    }
    if (this.fNF) {
      localContentValues.put("Desc_tw", this.field_Desc_tw);
    }
    if (this.fNG) {
      localContentValues.put("Desc_en", this.field_Desc_en);
    }
    if (this.fNH) {
      localContentValues.put("Introduce_cn", this.field_Introduce_cn);
    }
    if (this.fNI) {
      localContentValues.put("Introduce_hk", this.field_Introduce_hk);
    }
    if (this.fNJ) {
      localContentValues.put("Introduce_tw", this.field_Introduce_tw);
    }
    if (this.fNK) {
      localContentValues.put("Introduce_en", this.field_Introduce_en);
    }
    if (this.fNL) {
      localContentValues.put("starttime", Long.valueOf(this.field_starttime));
    }
    if (this.fNM) {
      localContentValues.put("endtime", Long.valueOf(this.field_endtime));
    }
    if (this.fjo) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.fjp) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fNN) {
      localContentValues.put("ThumbUrl_cn", this.field_ThumbUrl_cn);
    }
    if (this.fNO) {
      localContentValues.put("ThumbUrl_hk", this.field_ThumbUrl_hk);
    }
    if (this.fNP) {
      localContentValues.put("ThumbUrl_tw", this.field_ThumbUrl_tw);
    }
    if (this.fNQ) {
      localContentValues.put("ThumbUrl_en", this.field_ThumbUrl_en);
    }
    if (this.fNR) {
      localContentValues.put("ImgUrl_android_cn", this.field_ImgUrl_android_cn);
    }
    if (this.fNS) {
      localContentValues.put("ImgUrl_android_hk", this.field_ImgUrl_android_hk);
    }
    if (this.fNT) {
      localContentValues.put("ImgUrl_android_tw", this.field_ImgUrl_android_tw);
    }
    if (this.fNU) {
      localContentValues.put("ImgUrl_android_en", this.field_ImgUrl_android_en);
    }
    if (this.fNV) {
      localContentValues.put("RedPoint", Integer.valueOf(this.field_RedPoint));
    }
    if (this.fNW) {
      localContentValues.put("WeAppDebugMode", Integer.valueOf(this.field_WeAppDebugMode));
    }
    if (this.fNX) {
      localContentValues.put("idkey", Integer.valueOf(this.field_idkey));
    }
    if (this.fNY) {
      localContentValues.put("idkeyValue", Integer.valueOf(this.field_idkeyValue));
    }
    if (this.fNZ) {
      localContentValues.put("Icon", this.field_Icon);
    }
    if (this.fOa) {
      localContentValues.put("ImgUrl_cn", this.field_ImgUrl_cn);
    }
    if (this.fOb) {
      localContentValues.put("ImgUrl_hk", this.field_ImgUrl_hk);
    }
    if (this.fOc) {
      localContentValues.put("ImgUrl_tw", this.field_ImgUrl_tw);
    }
    if (this.fOd) {
      localContentValues.put("ImgUrl_en", this.field_ImgUrl_en);
    }
    if (this.fOe) {
      localContentValues.put("bItemFromXExpt", Integer.valueOf(this.field_bItemFromXExpt));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.ec
 * JD-Core Version:    0.7.0.1
 */