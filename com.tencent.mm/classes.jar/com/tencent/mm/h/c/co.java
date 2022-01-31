package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class co
  extends c
{
  private static final int cOW;
  private static final int cOX;
  private static final int cOY;
  private static final int cOZ;
  private static final int cPA = "ImgUrl_android_tw".hashCode();
  private static final int cPB = "ImgUrl_android_en".hashCode();
  private static final int cPC = "RedPoint".hashCode();
  private static final int cPD = "WeAppDebugMode".hashCode();
  private static final int cPE = "idkey".hashCode();
  private static final int cPF = "idkeyValue".hashCode();
  private static final int cPG = "Icon".hashCode();
  private static final int cPH = "ImgUrl_cn".hashCode();
  private static final int cPI = "ImgUrl_hk".hashCode();
  private static final int cPJ = "ImgUrl_tw".hashCode();
  private static final int cPK = "ImgUrl_en".hashCode();
  private static final int cPa;
  private static final int cPb;
  private static final int cPc;
  private static final int cPd;
  private static final int cPe;
  private static final int cPf;
  private static final int cPg;
  private static final int cPh;
  private static final int cPi;
  private static final int cPj;
  private static final int cPk;
  private static final int cPl;
  private static final int cPm;
  private static final int cPn;
  private static final int cPo;
  private static final int cPp;
  private static final int cPq;
  private static final int cPr;
  private static final int cPs;
  private static final int cPt;
  private static final int cPu;
  private static final int cPv;
  private static final int cPw;
  private static final int cPx;
  private static final int cPy;
  private static final int cPz;
  public static final String[] cqY = new String[0];
  private static final int crA;
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int cry;
  private static final int crz;
  private boolean cOA = true;
  private boolean cOB = true;
  private boolean cOC = true;
  private boolean cOD = true;
  private boolean cOE = true;
  private boolean cOF = true;
  private boolean cOG = true;
  private boolean cOH = true;
  private boolean cOI = true;
  private boolean cOJ = true;
  private boolean cOK = true;
  private boolean cOL = true;
  private boolean cOM = true;
  private boolean cON = true;
  private boolean cOO = true;
  private boolean cOP = true;
  private boolean cOQ = true;
  private boolean cOR = true;
  private boolean cOS = true;
  private boolean cOT = true;
  private boolean cOU = true;
  private boolean cOV = true;
  private boolean cOh = true;
  private boolean cOi = true;
  private boolean cOj = true;
  private boolean cOk = true;
  private boolean cOl = true;
  private boolean cOm = true;
  private boolean cOn = true;
  private boolean cOo = true;
  private boolean cOp = true;
  private boolean cOq = true;
  private boolean cOr = true;
  private boolean cOs = true;
  private boolean cOt = true;
  private boolean cOu = true;
  private boolean cOv = true;
  private boolean cOw = true;
  private boolean cOx = true;
  private boolean cOy = true;
  private boolean cOz = true;
  private boolean crk = true;
  private boolean crq = true;
  private boolean crr = true;
  private boolean crs = true;
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
    cOW = "LabsAppId".hashCode();
    cry = "expId".hashCode();
    cOX = "Type".hashCode();
    cOY = "BizType".hashCode();
    cOZ = "Switch".hashCode();
    cPa = "AllVer".hashCode();
    cPb = "DetailURL".hashCode();
    cPc = "WeAppUser".hashCode();
    cPd = "WeAppPath".hashCode();
    cPe = "Pos".hashCode();
    cPf = "TitleKey_android".hashCode();
    cPg = "Title_cn".hashCode();
    cPh = "Title_hk".hashCode();
    cPi = "Title_tw".hashCode();
    cPj = "Title_en".hashCode();
    cPk = "Desc_cn".hashCode();
    cPl = "Desc_hk".hashCode();
    cPm = "Desc_tw".hashCode();
    cPn = "Desc_en".hashCode();
    cPo = "Introduce_cn".hashCode();
    cPp = "Introduce_hk".hashCode();
    cPq = "Introduce_tw".hashCode();
    cPr = "Introduce_en".hashCode();
    cPs = "starttime".hashCode();
    cPt = "endtime".hashCode();
    crz = "sequence".hashCode();
    crA = "prioritylevel".hashCode();
    crn = "status".hashCode();
    cPu = "ThumbUrl_cn".hashCode();
    cPv = "ThumbUrl_hk".hashCode();
    cPw = "ThumbUrl_tw".hashCode();
    cPx = "ThumbUrl_en".hashCode();
    cPy = "ImgUrl_android_cn".hashCode();
    cPz = "ImgUrl_android_hk".hashCode();
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
      if (cOW != k) {
        break label65;
      }
      this.field_LabsAppId = paramCursor.getString(i);
      this.cOh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cry == k) {
        this.field_expId = paramCursor.getString(i);
      } else if (cOX == k) {
        this.field_Type = paramCursor.getInt(i);
      } else if (cOY == k) {
        this.field_BizType = paramCursor.getInt(i);
      } else if (cOZ == k) {
        this.field_Switch = paramCursor.getInt(i);
      } else if (cPa == k) {
        this.field_AllVer = paramCursor.getInt(i);
      } else if (cPb == k) {
        this.field_DetailURL = paramCursor.getString(i);
      } else if (cPc == k) {
        this.field_WeAppUser = paramCursor.getString(i);
      } else if (cPd == k) {
        this.field_WeAppPath = paramCursor.getString(i);
      } else if (cPe == k) {
        this.field_Pos = paramCursor.getInt(i);
      } else if (cPf == k) {
        this.field_TitleKey_android = paramCursor.getString(i);
      } else if (cPg == k) {
        this.field_Title_cn = paramCursor.getString(i);
      } else if (cPh == k) {
        this.field_Title_hk = paramCursor.getString(i);
      } else if (cPi == k) {
        this.field_Title_tw = paramCursor.getString(i);
      } else if (cPj == k) {
        this.field_Title_en = paramCursor.getString(i);
      } else if (cPk == k) {
        this.field_Desc_cn = paramCursor.getString(i);
      } else if (cPl == k) {
        this.field_Desc_hk = paramCursor.getString(i);
      } else if (cPm == k) {
        this.field_Desc_tw = paramCursor.getString(i);
      } else if (cPn == k) {
        this.field_Desc_en = paramCursor.getString(i);
      } else if (cPo == k) {
        this.field_Introduce_cn = paramCursor.getString(i);
      } else if (cPp == k) {
        this.field_Introduce_hk = paramCursor.getString(i);
      } else if (cPq == k) {
        this.field_Introduce_tw = paramCursor.getString(i);
      } else if (cPr == k) {
        this.field_Introduce_en = paramCursor.getString(i);
      } else if (cPs == k) {
        this.field_starttime = paramCursor.getLong(i);
      } else if (cPt == k) {
        this.field_endtime = paramCursor.getLong(i);
      } else if (crz == k) {
        this.field_sequence = paramCursor.getLong(i);
      } else if (crA == k) {
        this.field_prioritylevel = paramCursor.getInt(i);
      } else if (crn == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (cPu == k) {
        this.field_ThumbUrl_cn = paramCursor.getString(i);
      } else if (cPv == k) {
        this.field_ThumbUrl_hk = paramCursor.getString(i);
      } else if (cPw == k) {
        this.field_ThumbUrl_tw = paramCursor.getString(i);
      } else if (cPx == k) {
        this.field_ThumbUrl_en = paramCursor.getString(i);
      } else if (cPy == k) {
        this.field_ImgUrl_android_cn = paramCursor.getString(i);
      } else if (cPz == k) {
        this.field_ImgUrl_android_hk = paramCursor.getString(i);
      } else if (cPA == k) {
        this.field_ImgUrl_android_tw = paramCursor.getString(i);
      } else if (cPB == k) {
        this.field_ImgUrl_android_en = paramCursor.getString(i);
      } else if (cPC == k) {
        this.field_RedPoint = paramCursor.getInt(i);
      } else if (cPD == k) {
        this.field_WeAppDebugMode = paramCursor.getInt(i);
      } else if (cPE == k) {
        this.field_idkey = paramCursor.getInt(i);
      } else if (cPF == k) {
        this.field_idkeyValue = paramCursor.getInt(i);
      } else if (cPG == k) {
        this.field_Icon = paramCursor.getString(i);
      } else if (cPH == k) {
        this.field_ImgUrl_cn = paramCursor.getString(i);
      } else if (cPI == k) {
        this.field_ImgUrl_hk = paramCursor.getString(i);
      } else if (cPJ == k) {
        this.field_ImgUrl_tw = paramCursor.getString(i);
      } else if (cPK == k) {
        this.field_ImgUrl_en = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cOh) {
      localContentValues.put("LabsAppId", this.field_LabsAppId);
    }
    if (this.field_expId == null) {
      this.field_expId = "";
    }
    if (this.crq) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.cOi) {
      localContentValues.put("Type", Integer.valueOf(this.field_Type));
    }
    if (this.cOj) {
      localContentValues.put("BizType", Integer.valueOf(this.field_BizType));
    }
    if (this.cOk) {
      localContentValues.put("Switch", Integer.valueOf(this.field_Switch));
    }
    if (this.cOl) {
      localContentValues.put("AllVer", Integer.valueOf(this.field_AllVer));
    }
    if (this.cOm) {
      localContentValues.put("DetailURL", this.field_DetailURL);
    }
    if (this.cOn) {
      localContentValues.put("WeAppUser", this.field_WeAppUser);
    }
    if (this.cOo) {
      localContentValues.put("WeAppPath", this.field_WeAppPath);
    }
    if (this.cOp) {
      localContentValues.put("Pos", Integer.valueOf(this.field_Pos));
    }
    if (this.cOq) {
      localContentValues.put("TitleKey_android", this.field_TitleKey_android);
    }
    if (this.cOr) {
      localContentValues.put("Title_cn", this.field_Title_cn);
    }
    if (this.cOs) {
      localContentValues.put("Title_hk", this.field_Title_hk);
    }
    if (this.cOt) {
      localContentValues.put("Title_tw", this.field_Title_tw);
    }
    if (this.cOu) {
      localContentValues.put("Title_en", this.field_Title_en);
    }
    if (this.cOv) {
      localContentValues.put("Desc_cn", this.field_Desc_cn);
    }
    if (this.cOw) {
      localContentValues.put("Desc_hk", this.field_Desc_hk);
    }
    if (this.cOx) {
      localContentValues.put("Desc_tw", this.field_Desc_tw);
    }
    if (this.cOy) {
      localContentValues.put("Desc_en", this.field_Desc_en);
    }
    if (this.cOz) {
      localContentValues.put("Introduce_cn", this.field_Introduce_cn);
    }
    if (this.cOA) {
      localContentValues.put("Introduce_hk", this.field_Introduce_hk);
    }
    if (this.cOB) {
      localContentValues.put("Introduce_tw", this.field_Introduce_tw);
    }
    if (this.cOC) {
      localContentValues.put("Introduce_en", this.field_Introduce_en);
    }
    if (this.cOD) {
      localContentValues.put("starttime", Long.valueOf(this.field_starttime));
    }
    if (this.cOE) {
      localContentValues.put("endtime", Long.valueOf(this.field_endtime));
    }
    if (this.crr) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.crs) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.cOF) {
      localContentValues.put("ThumbUrl_cn", this.field_ThumbUrl_cn);
    }
    if (this.cOG) {
      localContentValues.put("ThumbUrl_hk", this.field_ThumbUrl_hk);
    }
    if (this.cOH) {
      localContentValues.put("ThumbUrl_tw", this.field_ThumbUrl_tw);
    }
    if (this.cOI) {
      localContentValues.put("ThumbUrl_en", this.field_ThumbUrl_en);
    }
    if (this.cOJ) {
      localContentValues.put("ImgUrl_android_cn", this.field_ImgUrl_android_cn);
    }
    if (this.cOK) {
      localContentValues.put("ImgUrl_android_hk", this.field_ImgUrl_android_hk);
    }
    if (this.cOL) {
      localContentValues.put("ImgUrl_android_tw", this.field_ImgUrl_android_tw);
    }
    if (this.cOM) {
      localContentValues.put("ImgUrl_android_en", this.field_ImgUrl_android_en);
    }
    if (this.cON) {
      localContentValues.put("RedPoint", Integer.valueOf(this.field_RedPoint));
    }
    if (this.cOO) {
      localContentValues.put("WeAppDebugMode", Integer.valueOf(this.field_WeAppDebugMode));
    }
    if (this.cOP) {
      localContentValues.put("idkey", Integer.valueOf(this.field_idkey));
    }
    if (this.cOQ) {
      localContentValues.put("idkeyValue", Integer.valueOf(this.field_idkeyValue));
    }
    if (this.cOR) {
      localContentValues.put("Icon", this.field_Icon);
    }
    if (this.cOS) {
      localContentValues.put("ImgUrl_cn", this.field_ImgUrl_cn);
    }
    if (this.cOT) {
      localContentValues.put("ImgUrl_hk", this.field_ImgUrl_hk);
    }
    if (this.cOU) {
      localContentValues.put("ImgUrl_tw", this.field_ImgUrl_tw);
    }
    if (this.cOV) {
      localContentValues.put("ImgUrl_en", this.field_ImgUrl_en);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.co
 * JD-Core Version:    0.7.0.1
 */