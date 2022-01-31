package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cv
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dEN = "LabsAppId".hashCode();
  private static final int dEO;
  private static final int dEP;
  private static final int dEQ;
  private static final int dER;
  private static final int dES;
  private static final int dET;
  private static final int dEU;
  private static final int dEV;
  private static final int dEW;
  private static final int dEX;
  private static final int dEY;
  private static final int dEZ;
  private static final int dFA = "ImgUrl_tw".hashCode();
  private static final int dFB = "ImgUrl_en".hashCode();
  private static final int dFC = "bItemFromXExpt".hashCode();
  private static final int dFa;
  private static final int dFb;
  private static final int dFc;
  private static final int dFd;
  private static final int dFe;
  private static final int dFf;
  private static final int dFg;
  private static final int dFh;
  private static final int dFi;
  private static final int dFj;
  private static final int dFk;
  private static final int dFl;
  private static final int dFm;
  private static final int dFn;
  private static final int dFo;
  private static final int dFp;
  private static final int dFq;
  private static final int dFr;
  private static final int dFs;
  private static final int dFt;
  private static final int dFu;
  private static final int dFv;
  private static final int dFw;
  private static final int dFx;
  private static final int dFy;
  private static final int dFz;
  private static final int dfJ;
  private static final int dfS = "expId".hashCode();
  private static final int dfT;
  private static final int dfU;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dDX = true;
  private boolean dDY = true;
  private boolean dDZ = true;
  private boolean dEA = true;
  private boolean dEB = true;
  private boolean dEC = true;
  private boolean dED = true;
  private boolean dEE = true;
  private boolean dEF = true;
  private boolean dEG = true;
  private boolean dEH = true;
  private boolean dEI = true;
  private boolean dEJ = true;
  private boolean dEK = true;
  private boolean dEL = true;
  private boolean dEM = true;
  private boolean dEa = true;
  private boolean dEb = true;
  private boolean dEc = true;
  private boolean dEd = true;
  private boolean dEe = true;
  private boolean dEf = true;
  private boolean dEg = true;
  private boolean dEh = true;
  private boolean dEi = true;
  private boolean dEj = true;
  private boolean dEk = true;
  private boolean dEl = true;
  private boolean dEm = true;
  private boolean dEn = true;
  private boolean dEo = true;
  private boolean dEp = true;
  private boolean dEq = true;
  private boolean dEr = true;
  private boolean dEs = true;
  private boolean dEt = true;
  private boolean dEu = true;
  private boolean dEv = true;
  private boolean dEw = true;
  private boolean dEx = true;
  private boolean dEy = true;
  private boolean dEz = true;
  private boolean dfG = true;
  private boolean dfL = true;
  private boolean dfM = true;
  private boolean dfN = true;
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
  
  static
  {
    dEO = "Type".hashCode();
    dEP = "BizType".hashCode();
    dEQ = "Switch".hashCode();
    dER = "AllVer".hashCode();
    dES = "DetailURL".hashCode();
    dET = "WeAppUser".hashCode();
    dEU = "WeAppPath".hashCode();
    dEV = "Pos".hashCode();
    dEW = "TitleKey_android".hashCode();
    dEX = "Title_cn".hashCode();
    dEY = "Title_hk".hashCode();
    dEZ = "Title_tw".hashCode();
    dFa = "Title_en".hashCode();
    dFb = "Desc_cn".hashCode();
    dFc = "Desc_hk".hashCode();
    dFd = "Desc_tw".hashCode();
    dFe = "Desc_en".hashCode();
    dFf = "Introduce_cn".hashCode();
    dFg = "Introduce_hk".hashCode();
    dFh = "Introduce_tw".hashCode();
    dFi = "Introduce_en".hashCode();
    dFj = "starttime".hashCode();
    dFk = "endtime".hashCode();
    dfT = "sequence".hashCode();
    dfU = "prioritylevel".hashCode();
    dfJ = "status".hashCode();
    dFl = "ThumbUrl_cn".hashCode();
    dFm = "ThumbUrl_hk".hashCode();
    dFn = "ThumbUrl_tw".hashCode();
    dFo = "ThumbUrl_en".hashCode();
    dFp = "ImgUrl_android_cn".hashCode();
    dFq = "ImgUrl_android_hk".hashCode();
    dFr = "ImgUrl_android_tw".hashCode();
    dFs = "ImgUrl_android_en".hashCode();
    dFt = "RedPoint".hashCode();
    dFu = "WeAppDebugMode".hashCode();
    dFv = "idkey".hashCode();
    dFw = "idkeyValue".hashCode();
    dFx = "Icon".hashCode();
    dFy = "ImgUrl_cn".hashCode();
    dFz = "ImgUrl_hk".hashCode();
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
      if (dEN != k) {
        break label65;
      }
      this.field_LabsAppId = paramCursor.getString(i);
      this.dDX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dfS == k) {
        this.field_expId = paramCursor.getString(i);
      } else if (dEO == k) {
        this.field_Type = paramCursor.getInt(i);
      } else if (dEP == k) {
        this.field_BizType = paramCursor.getInt(i);
      } else if (dEQ == k) {
        this.field_Switch = paramCursor.getInt(i);
      } else if (dER == k) {
        this.field_AllVer = paramCursor.getInt(i);
      } else if (dES == k) {
        this.field_DetailURL = paramCursor.getString(i);
      } else if (dET == k) {
        this.field_WeAppUser = paramCursor.getString(i);
      } else if (dEU == k) {
        this.field_WeAppPath = paramCursor.getString(i);
      } else if (dEV == k) {
        this.field_Pos = paramCursor.getInt(i);
      } else if (dEW == k) {
        this.field_TitleKey_android = paramCursor.getString(i);
      } else if (dEX == k) {
        this.field_Title_cn = paramCursor.getString(i);
      } else if (dEY == k) {
        this.field_Title_hk = paramCursor.getString(i);
      } else if (dEZ == k) {
        this.field_Title_tw = paramCursor.getString(i);
      } else if (dFa == k) {
        this.field_Title_en = paramCursor.getString(i);
      } else if (dFb == k) {
        this.field_Desc_cn = paramCursor.getString(i);
      } else if (dFc == k) {
        this.field_Desc_hk = paramCursor.getString(i);
      } else if (dFd == k) {
        this.field_Desc_tw = paramCursor.getString(i);
      } else if (dFe == k) {
        this.field_Desc_en = paramCursor.getString(i);
      } else if (dFf == k) {
        this.field_Introduce_cn = paramCursor.getString(i);
      } else if (dFg == k) {
        this.field_Introduce_hk = paramCursor.getString(i);
      } else if (dFh == k) {
        this.field_Introduce_tw = paramCursor.getString(i);
      } else if (dFi == k) {
        this.field_Introduce_en = paramCursor.getString(i);
      } else if (dFj == k) {
        this.field_starttime = paramCursor.getLong(i);
      } else if (dFk == k) {
        this.field_endtime = paramCursor.getLong(i);
      } else if (dfT == k) {
        this.field_sequence = paramCursor.getLong(i);
      } else if (dfU == k) {
        this.field_prioritylevel = paramCursor.getInt(i);
      } else if (dfJ == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (dFl == k) {
        this.field_ThumbUrl_cn = paramCursor.getString(i);
      } else if (dFm == k) {
        this.field_ThumbUrl_hk = paramCursor.getString(i);
      } else if (dFn == k) {
        this.field_ThumbUrl_tw = paramCursor.getString(i);
      } else if (dFo == k) {
        this.field_ThumbUrl_en = paramCursor.getString(i);
      } else if (dFp == k) {
        this.field_ImgUrl_android_cn = paramCursor.getString(i);
      } else if (dFq == k) {
        this.field_ImgUrl_android_hk = paramCursor.getString(i);
      } else if (dFr == k) {
        this.field_ImgUrl_android_tw = paramCursor.getString(i);
      } else if (dFs == k) {
        this.field_ImgUrl_android_en = paramCursor.getString(i);
      } else if (dFt == k) {
        this.field_RedPoint = paramCursor.getInt(i);
      } else if (dFu == k) {
        this.field_WeAppDebugMode = paramCursor.getInt(i);
      } else if (dFv == k) {
        this.field_idkey = paramCursor.getInt(i);
      } else if (dFw == k) {
        this.field_idkeyValue = paramCursor.getInt(i);
      } else if (dFx == k) {
        this.field_Icon = paramCursor.getString(i);
      } else if (dFy == k) {
        this.field_ImgUrl_cn = paramCursor.getString(i);
      } else if (dFz == k) {
        this.field_ImgUrl_hk = paramCursor.getString(i);
      } else if (dFA == k) {
        this.field_ImgUrl_tw = paramCursor.getString(i);
      } else if (dFB == k) {
        this.field_ImgUrl_en = paramCursor.getString(i);
      } else if (dFC == k) {
        this.field_bItemFromXExpt = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dDX) {
      localContentValues.put("LabsAppId", this.field_LabsAppId);
    }
    if (this.field_expId == null) {
      this.field_expId = "";
    }
    if (this.dfL) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.dDY) {
      localContentValues.put("Type", Integer.valueOf(this.field_Type));
    }
    if (this.dDZ) {
      localContentValues.put("BizType", Integer.valueOf(this.field_BizType));
    }
    if (this.dEa) {
      localContentValues.put("Switch", Integer.valueOf(this.field_Switch));
    }
    if (this.dEb) {
      localContentValues.put("AllVer", Integer.valueOf(this.field_AllVer));
    }
    if (this.dEc) {
      localContentValues.put("DetailURL", this.field_DetailURL);
    }
    if (this.dEd) {
      localContentValues.put("WeAppUser", this.field_WeAppUser);
    }
    if (this.dEe) {
      localContentValues.put("WeAppPath", this.field_WeAppPath);
    }
    if (this.dEf) {
      localContentValues.put("Pos", Integer.valueOf(this.field_Pos));
    }
    if (this.dEg) {
      localContentValues.put("TitleKey_android", this.field_TitleKey_android);
    }
    if (this.dEh) {
      localContentValues.put("Title_cn", this.field_Title_cn);
    }
    if (this.dEi) {
      localContentValues.put("Title_hk", this.field_Title_hk);
    }
    if (this.dEj) {
      localContentValues.put("Title_tw", this.field_Title_tw);
    }
    if (this.dEk) {
      localContentValues.put("Title_en", this.field_Title_en);
    }
    if (this.dEl) {
      localContentValues.put("Desc_cn", this.field_Desc_cn);
    }
    if (this.dEm) {
      localContentValues.put("Desc_hk", this.field_Desc_hk);
    }
    if (this.dEn) {
      localContentValues.put("Desc_tw", this.field_Desc_tw);
    }
    if (this.dEo) {
      localContentValues.put("Desc_en", this.field_Desc_en);
    }
    if (this.dEp) {
      localContentValues.put("Introduce_cn", this.field_Introduce_cn);
    }
    if (this.dEq) {
      localContentValues.put("Introduce_hk", this.field_Introduce_hk);
    }
    if (this.dEr) {
      localContentValues.put("Introduce_tw", this.field_Introduce_tw);
    }
    if (this.dEs) {
      localContentValues.put("Introduce_en", this.field_Introduce_en);
    }
    if (this.dEt) {
      localContentValues.put("starttime", Long.valueOf(this.field_starttime));
    }
    if (this.dEu) {
      localContentValues.put("endtime", Long.valueOf(this.field_endtime));
    }
    if (this.dfM) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.dfN) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.dEv) {
      localContentValues.put("ThumbUrl_cn", this.field_ThumbUrl_cn);
    }
    if (this.dEw) {
      localContentValues.put("ThumbUrl_hk", this.field_ThumbUrl_hk);
    }
    if (this.dEx) {
      localContentValues.put("ThumbUrl_tw", this.field_ThumbUrl_tw);
    }
    if (this.dEy) {
      localContentValues.put("ThumbUrl_en", this.field_ThumbUrl_en);
    }
    if (this.dEz) {
      localContentValues.put("ImgUrl_android_cn", this.field_ImgUrl_android_cn);
    }
    if (this.dEA) {
      localContentValues.put("ImgUrl_android_hk", this.field_ImgUrl_android_hk);
    }
    if (this.dEB) {
      localContentValues.put("ImgUrl_android_tw", this.field_ImgUrl_android_tw);
    }
    if (this.dEC) {
      localContentValues.put("ImgUrl_android_en", this.field_ImgUrl_android_en);
    }
    if (this.dED) {
      localContentValues.put("RedPoint", Integer.valueOf(this.field_RedPoint));
    }
    if (this.dEE) {
      localContentValues.put("WeAppDebugMode", Integer.valueOf(this.field_WeAppDebugMode));
    }
    if (this.dEF) {
      localContentValues.put("idkey", Integer.valueOf(this.field_idkey));
    }
    if (this.dEG) {
      localContentValues.put("idkeyValue", Integer.valueOf(this.field_idkeyValue));
    }
    if (this.dEH) {
      localContentValues.put("Icon", this.field_Icon);
    }
    if (this.dEI) {
      localContentValues.put("ImgUrl_cn", this.field_ImgUrl_cn);
    }
    if (this.dEJ) {
      localContentValues.put("ImgUrl_hk", this.field_ImgUrl_hk);
    }
    if (this.dEK) {
      localContentValues.put("ImgUrl_tw", this.field_ImgUrl_tw);
    }
    if (this.dEL) {
      localContentValues.put("ImgUrl_en", this.field_ImgUrl_en);
    }
    if (this.dEM) {
      localContentValues.put("bItemFromXExpt", Integer.valueOf(this.field_bItemFromXExpt));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.c.cv
 * JD-Core Version:    0.7.0.1
 */