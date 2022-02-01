package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dm
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ePA;
  private static final int ePB;
  private static final int ePC;
  private static final int ePD;
  private static final int ePE;
  private static final int ePF = "ThumbUrl_cn".hashCode();
  private static final int ePG = "ThumbUrl_hk".hashCode();
  private static final int ePH = "ThumbUrl_tw".hashCode();
  private static final int ePI = "ThumbUrl_en".hashCode();
  private static final int ePJ = "ImgUrl_android_cn".hashCode();
  private static final int ePK = "ImgUrl_android_hk".hashCode();
  private static final int ePL = "ImgUrl_android_tw".hashCode();
  private static final int ePM = "ImgUrl_android_en".hashCode();
  private static final int ePN = "RedPoint".hashCode();
  private static final int ePO = "WeAppDebugMode".hashCode();
  private static final int ePP = "idkey".hashCode();
  private static final int ePQ = "idkeyValue".hashCode();
  private static final int ePR = "Icon".hashCode();
  private static final int ePS = "ImgUrl_cn".hashCode();
  private static final int ePT = "ImgUrl_hk".hashCode();
  private static final int ePU = "ImgUrl_tw".hashCode();
  private static final int ePV = "ImgUrl_en".hashCode();
  private static final int ePW = "bItemFromXExpt".hashCode();
  private static final int ePh = "LabsAppId".hashCode();
  private static final int ePi;
  private static final int ePj;
  private static final int ePk;
  private static final int ePl;
  private static final int ePm;
  private static final int ePn;
  private static final int ePo;
  private static final int ePp;
  private static final int ePq;
  private static final int ePr;
  private static final int ePs;
  private static final int ePt;
  private static final int ePu;
  private static final int ePv;
  private static final int ePw;
  private static final int ePx;
  private static final int ePy;
  private static final int ePz;
  private static final int elV;
  private static final int eme = "expId".hashCode();
  private static final int emf;
  private static final int emg;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eOA = true;
  private boolean eOB = true;
  private boolean eOC = true;
  private boolean eOD = true;
  private boolean eOE = true;
  private boolean eOF = true;
  private boolean eOG = true;
  private boolean eOH = true;
  private boolean eOI = true;
  private boolean eOJ = true;
  private boolean eOK = true;
  private boolean eOL = true;
  private boolean eOM = true;
  private boolean eON = true;
  private boolean eOO = true;
  private boolean eOP = true;
  private boolean eOQ = true;
  private boolean eOR = true;
  private boolean eOS = true;
  private boolean eOT = true;
  private boolean eOU = true;
  private boolean eOV = true;
  private boolean eOW = true;
  private boolean eOX = true;
  private boolean eOY = true;
  private boolean eOZ = true;
  private boolean eOr = true;
  private boolean eOs = true;
  private boolean eOt = true;
  private boolean eOu = true;
  private boolean eOv = true;
  private boolean eOw = true;
  private boolean eOx = true;
  private boolean eOy = true;
  private boolean eOz = true;
  private boolean ePa = true;
  private boolean ePb = true;
  private boolean ePc = true;
  private boolean ePd = true;
  private boolean ePe = true;
  private boolean ePf = true;
  private boolean ePg = true;
  private boolean elS = true;
  private boolean elX = true;
  private boolean elY = true;
  private boolean elZ = true;
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
    ePi = "Type".hashCode();
    ePj = "BizType".hashCode();
    ePk = "Switch".hashCode();
    ePl = "AllVer".hashCode();
    ePm = "DetailURL".hashCode();
    ePn = "WeAppUser".hashCode();
    ePo = "WeAppPath".hashCode();
    ePp = "Pos".hashCode();
    ePq = "TitleKey_android".hashCode();
    ePr = "Title_cn".hashCode();
    ePs = "Title_hk".hashCode();
    ePt = "Title_tw".hashCode();
    ePu = "Title_en".hashCode();
    ePv = "Desc_cn".hashCode();
    ePw = "Desc_hk".hashCode();
    ePx = "Desc_tw".hashCode();
    ePy = "Desc_en".hashCode();
    ePz = "Introduce_cn".hashCode();
    ePA = "Introduce_hk".hashCode();
    ePB = "Introduce_tw".hashCode();
    ePC = "Introduce_en".hashCode();
    ePD = "starttime".hashCode();
    ePE = "endtime".hashCode();
    emf = "sequence".hashCode();
    emg = "prioritylevel".hashCode();
    elV = "status".hashCode();
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
      if (ePh != k) {
        break label65;
      }
      this.field_LabsAppId = paramCursor.getString(i);
      this.eOr = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eme == k) {
        this.field_expId = paramCursor.getString(i);
      } else if (ePi == k) {
        this.field_Type = paramCursor.getInt(i);
      } else if (ePj == k) {
        this.field_BizType = paramCursor.getInt(i);
      } else if (ePk == k) {
        this.field_Switch = paramCursor.getInt(i);
      } else if (ePl == k) {
        this.field_AllVer = paramCursor.getInt(i);
      } else if (ePm == k) {
        this.field_DetailURL = paramCursor.getString(i);
      } else if (ePn == k) {
        this.field_WeAppUser = paramCursor.getString(i);
      } else if (ePo == k) {
        this.field_WeAppPath = paramCursor.getString(i);
      } else if (ePp == k) {
        this.field_Pos = paramCursor.getInt(i);
      } else if (ePq == k) {
        this.field_TitleKey_android = paramCursor.getString(i);
      } else if (ePr == k) {
        this.field_Title_cn = paramCursor.getString(i);
      } else if (ePs == k) {
        this.field_Title_hk = paramCursor.getString(i);
      } else if (ePt == k) {
        this.field_Title_tw = paramCursor.getString(i);
      } else if (ePu == k) {
        this.field_Title_en = paramCursor.getString(i);
      } else if (ePv == k) {
        this.field_Desc_cn = paramCursor.getString(i);
      } else if (ePw == k) {
        this.field_Desc_hk = paramCursor.getString(i);
      } else if (ePx == k) {
        this.field_Desc_tw = paramCursor.getString(i);
      } else if (ePy == k) {
        this.field_Desc_en = paramCursor.getString(i);
      } else if (ePz == k) {
        this.field_Introduce_cn = paramCursor.getString(i);
      } else if (ePA == k) {
        this.field_Introduce_hk = paramCursor.getString(i);
      } else if (ePB == k) {
        this.field_Introduce_tw = paramCursor.getString(i);
      } else if (ePC == k) {
        this.field_Introduce_en = paramCursor.getString(i);
      } else if (ePD == k) {
        this.field_starttime = paramCursor.getLong(i);
      } else if (ePE == k) {
        this.field_endtime = paramCursor.getLong(i);
      } else if (emf == k) {
        this.field_sequence = paramCursor.getLong(i);
      } else if (emg == k) {
        this.field_prioritylevel = paramCursor.getInt(i);
      } else if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (ePF == k) {
        this.field_ThumbUrl_cn = paramCursor.getString(i);
      } else if (ePG == k) {
        this.field_ThumbUrl_hk = paramCursor.getString(i);
      } else if (ePH == k) {
        this.field_ThumbUrl_tw = paramCursor.getString(i);
      } else if (ePI == k) {
        this.field_ThumbUrl_en = paramCursor.getString(i);
      } else if (ePJ == k) {
        this.field_ImgUrl_android_cn = paramCursor.getString(i);
      } else if (ePK == k) {
        this.field_ImgUrl_android_hk = paramCursor.getString(i);
      } else if (ePL == k) {
        this.field_ImgUrl_android_tw = paramCursor.getString(i);
      } else if (ePM == k) {
        this.field_ImgUrl_android_en = paramCursor.getString(i);
      } else if (ePN == k) {
        this.field_RedPoint = paramCursor.getInt(i);
      } else if (ePO == k) {
        this.field_WeAppDebugMode = paramCursor.getInt(i);
      } else if (ePP == k) {
        this.field_idkey = paramCursor.getInt(i);
      } else if (ePQ == k) {
        this.field_idkeyValue = paramCursor.getInt(i);
      } else if (ePR == k) {
        this.field_Icon = paramCursor.getString(i);
      } else if (ePS == k) {
        this.field_ImgUrl_cn = paramCursor.getString(i);
      } else if (ePT == k) {
        this.field_ImgUrl_hk = paramCursor.getString(i);
      } else if (ePU == k) {
        this.field_ImgUrl_tw = paramCursor.getString(i);
      } else if (ePV == k) {
        this.field_ImgUrl_en = paramCursor.getString(i);
      } else if (ePW == k) {
        this.field_bItemFromXExpt = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eOr) {
      localContentValues.put("LabsAppId", this.field_LabsAppId);
    }
    if (this.field_expId == null) {
      this.field_expId = "";
    }
    if (this.elX) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.eOs) {
      localContentValues.put("Type", Integer.valueOf(this.field_Type));
    }
    if (this.eOt) {
      localContentValues.put("BizType", Integer.valueOf(this.field_BizType));
    }
    if (this.eOu) {
      localContentValues.put("Switch", Integer.valueOf(this.field_Switch));
    }
    if (this.eOv) {
      localContentValues.put("AllVer", Integer.valueOf(this.field_AllVer));
    }
    if (this.eOw) {
      localContentValues.put("DetailURL", this.field_DetailURL);
    }
    if (this.eOx) {
      localContentValues.put("WeAppUser", this.field_WeAppUser);
    }
    if (this.eOy) {
      localContentValues.put("WeAppPath", this.field_WeAppPath);
    }
    if (this.eOz) {
      localContentValues.put("Pos", Integer.valueOf(this.field_Pos));
    }
    if (this.eOA) {
      localContentValues.put("TitleKey_android", this.field_TitleKey_android);
    }
    if (this.eOB) {
      localContentValues.put("Title_cn", this.field_Title_cn);
    }
    if (this.eOC) {
      localContentValues.put("Title_hk", this.field_Title_hk);
    }
    if (this.eOD) {
      localContentValues.put("Title_tw", this.field_Title_tw);
    }
    if (this.eOE) {
      localContentValues.put("Title_en", this.field_Title_en);
    }
    if (this.eOF) {
      localContentValues.put("Desc_cn", this.field_Desc_cn);
    }
    if (this.eOG) {
      localContentValues.put("Desc_hk", this.field_Desc_hk);
    }
    if (this.eOH) {
      localContentValues.put("Desc_tw", this.field_Desc_tw);
    }
    if (this.eOI) {
      localContentValues.put("Desc_en", this.field_Desc_en);
    }
    if (this.eOJ) {
      localContentValues.put("Introduce_cn", this.field_Introduce_cn);
    }
    if (this.eOK) {
      localContentValues.put("Introduce_hk", this.field_Introduce_hk);
    }
    if (this.eOL) {
      localContentValues.put("Introduce_tw", this.field_Introduce_tw);
    }
    if (this.eOM) {
      localContentValues.put("Introduce_en", this.field_Introduce_en);
    }
    if (this.eON) {
      localContentValues.put("starttime", Long.valueOf(this.field_starttime));
    }
    if (this.eOO) {
      localContentValues.put("endtime", Long.valueOf(this.field_endtime));
    }
    if (this.elY) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.elZ) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eOP) {
      localContentValues.put("ThumbUrl_cn", this.field_ThumbUrl_cn);
    }
    if (this.eOQ) {
      localContentValues.put("ThumbUrl_hk", this.field_ThumbUrl_hk);
    }
    if (this.eOR) {
      localContentValues.put("ThumbUrl_tw", this.field_ThumbUrl_tw);
    }
    if (this.eOS) {
      localContentValues.put("ThumbUrl_en", this.field_ThumbUrl_en);
    }
    if (this.eOT) {
      localContentValues.put("ImgUrl_android_cn", this.field_ImgUrl_android_cn);
    }
    if (this.eOU) {
      localContentValues.put("ImgUrl_android_hk", this.field_ImgUrl_android_hk);
    }
    if (this.eOV) {
      localContentValues.put("ImgUrl_android_tw", this.field_ImgUrl_android_tw);
    }
    if (this.eOW) {
      localContentValues.put("ImgUrl_android_en", this.field_ImgUrl_android_en);
    }
    if (this.eOX) {
      localContentValues.put("RedPoint", Integer.valueOf(this.field_RedPoint));
    }
    if (this.eOY) {
      localContentValues.put("WeAppDebugMode", Integer.valueOf(this.field_WeAppDebugMode));
    }
    if (this.eOZ) {
      localContentValues.put("idkey", Integer.valueOf(this.field_idkey));
    }
    if (this.ePa) {
      localContentValues.put("idkeyValue", Integer.valueOf(this.field_idkeyValue));
    }
    if (this.ePb) {
      localContentValues.put("Icon", this.field_Icon);
    }
    if (this.ePc) {
      localContentValues.put("ImgUrl_cn", this.field_ImgUrl_cn);
    }
    if (this.ePd) {
      localContentValues.put("ImgUrl_hk", this.field_ImgUrl_hk);
    }
    if (this.ePe) {
      localContentValues.put("ImgUrl_tw", this.field_ImgUrl_tw);
    }
    if (this.ePf) {
      localContentValues.put("ImgUrl_en", this.field_ImgUrl_en);
    }
    if (this.ePg) {
      localContentValues.put("bItemFromXExpt", Integer.valueOf(this.field_bItemFromXExpt));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dm
 * JD-Core Version:    0.7.0.1
 */