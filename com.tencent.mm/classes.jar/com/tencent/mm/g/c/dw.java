package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dw
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL = "status".hashCode();
  private static final int eEU;
  private static final int eEV;
  private static final int eEW;
  private static final int fjB = "LabsAppId".hashCode();
  private static final int fjC;
  private static final int fjD;
  private static final int fjE;
  private static final int fjF;
  private static final int fjG;
  private static final int fjH;
  private static final int fjI;
  private static final int fjJ;
  private static final int fjK;
  private static final int fjL;
  private static final int fjM;
  private static final int fjN;
  private static final int fjO;
  private static final int fjP;
  private static final int fjQ;
  private static final int fjR;
  private static final int fjS;
  private static final int fjT;
  private static final int fjU;
  private static final int fjV;
  private static final int fjW;
  private static final int fjX;
  private static final int fjY;
  private static final int fjZ = "ThumbUrl_cn".hashCode();
  private static final int fka = "ThumbUrl_hk".hashCode();
  private static final int fkb = "ThumbUrl_tw".hashCode();
  private static final int fkc = "ThumbUrl_en".hashCode();
  private static final int fkd = "ImgUrl_android_cn".hashCode();
  private static final int fke = "ImgUrl_android_hk".hashCode();
  private static final int fkf = "ImgUrl_android_tw".hashCode();
  private static final int fkg = "ImgUrl_android_en".hashCode();
  private static final int fkh = "RedPoint".hashCode();
  private static final int fki = "WeAppDebugMode".hashCode();
  private static final int fkj = "idkey".hashCode();
  private static final int fkk = "idkeyValue".hashCode();
  private static final int fkl = "Icon".hashCode();
  private static final int fkm = "ImgUrl_cn".hashCode();
  private static final int fkn = "ImgUrl_hk".hashCode();
  private static final int fko = "ImgUrl_tw".hashCode();
  private static final int fkp = "ImgUrl_en".hashCode();
  private static final int fkq = "bItemFromXExpt".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  private boolean eEN = true;
  private boolean eEO = true;
  private boolean eEP = true;
  private boolean fiL = true;
  private boolean fiM = true;
  private boolean fiN = true;
  private boolean fiO = true;
  private boolean fiP = true;
  private boolean fiQ = true;
  private boolean fiR = true;
  private boolean fiS = true;
  private boolean fiT = true;
  private boolean fiU = true;
  private boolean fiV = true;
  private boolean fiW = true;
  private boolean fiX = true;
  private boolean fiY = true;
  private boolean fiZ = true;
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
  private boolean fjA = true;
  private boolean fja = true;
  private boolean fjb = true;
  private boolean fjc = true;
  private boolean fjd = true;
  private boolean fje = true;
  private boolean fjf = true;
  private boolean fjg = true;
  private boolean fjh = true;
  private boolean fji = true;
  private boolean fjj = true;
  private boolean fjk = true;
  private boolean fjl = true;
  private boolean fjm = true;
  private boolean fjn = true;
  private boolean fjo = true;
  private boolean fjp = true;
  private boolean fjq = true;
  private boolean fjr = true;
  private boolean fjs = true;
  private boolean fjt = true;
  private boolean fju = true;
  private boolean fjv = true;
  private boolean fjw = true;
  private boolean fjx = true;
  private boolean fjy = true;
  private boolean fjz = true;
  
  static
  {
    eEU = "expId".hashCode();
    fjC = "Type".hashCode();
    fjD = "BizType".hashCode();
    fjE = "Switch".hashCode();
    fjF = "AllVer".hashCode();
    fjG = "DetailURL".hashCode();
    fjH = "WeAppUser".hashCode();
    fjI = "WeAppPath".hashCode();
    fjJ = "Pos".hashCode();
    fjK = "TitleKey_android".hashCode();
    fjL = "Title_cn".hashCode();
    fjM = "Title_hk".hashCode();
    fjN = "Title_tw".hashCode();
    fjO = "Title_en".hashCode();
    fjP = "Desc_cn".hashCode();
    fjQ = "Desc_hk".hashCode();
    fjR = "Desc_tw".hashCode();
    fjS = "Desc_en".hashCode();
    fjT = "Introduce_cn".hashCode();
    fjU = "Introduce_hk".hashCode();
    fjV = "Introduce_tw".hashCode();
    fjW = "Introduce_en".hashCode();
    fjX = "starttime".hashCode();
    fjY = "endtime".hashCode();
    eEV = "sequence".hashCode();
    eEW = "prioritylevel".hashCode();
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
      if (fjB != k) {
        break label65;
      }
      this.field_LabsAppId = paramCursor.getString(i);
      this.fiL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eEU == k) {
        this.field_expId = paramCursor.getString(i);
      } else if (fjC == k) {
        this.field_Type = paramCursor.getInt(i);
      } else if (fjD == k) {
        this.field_BizType = paramCursor.getInt(i);
      } else if (fjE == k) {
        this.field_Switch = paramCursor.getInt(i);
      } else if (fjF == k) {
        this.field_AllVer = paramCursor.getInt(i);
      } else if (fjG == k) {
        this.field_DetailURL = paramCursor.getString(i);
      } else if (fjH == k) {
        this.field_WeAppUser = paramCursor.getString(i);
      } else if (fjI == k) {
        this.field_WeAppPath = paramCursor.getString(i);
      } else if (fjJ == k) {
        this.field_Pos = paramCursor.getInt(i);
      } else if (fjK == k) {
        this.field_TitleKey_android = paramCursor.getString(i);
      } else if (fjL == k) {
        this.field_Title_cn = paramCursor.getString(i);
      } else if (fjM == k) {
        this.field_Title_hk = paramCursor.getString(i);
      } else if (fjN == k) {
        this.field_Title_tw = paramCursor.getString(i);
      } else if (fjO == k) {
        this.field_Title_en = paramCursor.getString(i);
      } else if (fjP == k) {
        this.field_Desc_cn = paramCursor.getString(i);
      } else if (fjQ == k) {
        this.field_Desc_hk = paramCursor.getString(i);
      } else if (fjR == k) {
        this.field_Desc_tw = paramCursor.getString(i);
      } else if (fjS == k) {
        this.field_Desc_en = paramCursor.getString(i);
      } else if (fjT == k) {
        this.field_Introduce_cn = paramCursor.getString(i);
      } else if (fjU == k) {
        this.field_Introduce_hk = paramCursor.getString(i);
      } else if (fjV == k) {
        this.field_Introduce_tw = paramCursor.getString(i);
      } else if (fjW == k) {
        this.field_Introduce_en = paramCursor.getString(i);
      } else if (fjX == k) {
        this.field_starttime = paramCursor.getLong(i);
      } else if (fjY == k) {
        this.field_endtime = paramCursor.getLong(i);
      } else if (eEV == k) {
        this.field_sequence = paramCursor.getLong(i);
      } else if (eEW == k) {
        this.field_prioritylevel = paramCursor.getInt(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fjZ == k) {
        this.field_ThumbUrl_cn = paramCursor.getString(i);
      } else if (fka == k) {
        this.field_ThumbUrl_hk = paramCursor.getString(i);
      } else if (fkb == k) {
        this.field_ThumbUrl_tw = paramCursor.getString(i);
      } else if (fkc == k) {
        this.field_ThumbUrl_en = paramCursor.getString(i);
      } else if (fkd == k) {
        this.field_ImgUrl_android_cn = paramCursor.getString(i);
      } else if (fke == k) {
        this.field_ImgUrl_android_hk = paramCursor.getString(i);
      } else if (fkf == k) {
        this.field_ImgUrl_android_tw = paramCursor.getString(i);
      } else if (fkg == k) {
        this.field_ImgUrl_android_en = paramCursor.getString(i);
      } else if (fkh == k) {
        this.field_RedPoint = paramCursor.getInt(i);
      } else if (fki == k) {
        this.field_WeAppDebugMode = paramCursor.getInt(i);
      } else if (fkj == k) {
        this.field_idkey = paramCursor.getInt(i);
      } else if (fkk == k) {
        this.field_idkeyValue = paramCursor.getInt(i);
      } else if (fkl == k) {
        this.field_Icon = paramCursor.getString(i);
      } else if (fkm == k) {
        this.field_ImgUrl_cn = paramCursor.getString(i);
      } else if (fkn == k) {
        this.field_ImgUrl_hk = paramCursor.getString(i);
      } else if (fko == k) {
        this.field_ImgUrl_tw = paramCursor.getString(i);
      } else if (fkp == k) {
        this.field_ImgUrl_en = paramCursor.getString(i);
      } else if (fkq == k) {
        this.field_bItemFromXExpt = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fiL) {
      localContentValues.put("LabsAppId", this.field_LabsAppId);
    }
    if (this.field_expId == null) {
      this.field_expId = "";
    }
    if (this.eEN) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.fiM) {
      localContentValues.put("Type", Integer.valueOf(this.field_Type));
    }
    if (this.fiN) {
      localContentValues.put("BizType", Integer.valueOf(this.field_BizType));
    }
    if (this.fiO) {
      localContentValues.put("Switch", Integer.valueOf(this.field_Switch));
    }
    if (this.fiP) {
      localContentValues.put("AllVer", Integer.valueOf(this.field_AllVer));
    }
    if (this.fiQ) {
      localContentValues.put("DetailURL", this.field_DetailURL);
    }
    if (this.fiR) {
      localContentValues.put("WeAppUser", this.field_WeAppUser);
    }
    if (this.fiS) {
      localContentValues.put("WeAppPath", this.field_WeAppPath);
    }
    if (this.fiT) {
      localContentValues.put("Pos", Integer.valueOf(this.field_Pos));
    }
    if (this.fiU) {
      localContentValues.put("TitleKey_android", this.field_TitleKey_android);
    }
    if (this.fiV) {
      localContentValues.put("Title_cn", this.field_Title_cn);
    }
    if (this.fiW) {
      localContentValues.put("Title_hk", this.field_Title_hk);
    }
    if (this.fiX) {
      localContentValues.put("Title_tw", this.field_Title_tw);
    }
    if (this.fiY) {
      localContentValues.put("Title_en", this.field_Title_en);
    }
    if (this.fiZ) {
      localContentValues.put("Desc_cn", this.field_Desc_cn);
    }
    if (this.fja) {
      localContentValues.put("Desc_hk", this.field_Desc_hk);
    }
    if (this.fjb) {
      localContentValues.put("Desc_tw", this.field_Desc_tw);
    }
    if (this.fjc) {
      localContentValues.put("Desc_en", this.field_Desc_en);
    }
    if (this.fjd) {
      localContentValues.put("Introduce_cn", this.field_Introduce_cn);
    }
    if (this.fje) {
      localContentValues.put("Introduce_hk", this.field_Introduce_hk);
    }
    if (this.fjf) {
      localContentValues.put("Introduce_tw", this.field_Introduce_tw);
    }
    if (this.fjg) {
      localContentValues.put("Introduce_en", this.field_Introduce_en);
    }
    if (this.fjh) {
      localContentValues.put("starttime", Long.valueOf(this.field_starttime));
    }
    if (this.fji) {
      localContentValues.put("endtime", Long.valueOf(this.field_endtime));
    }
    if (this.eEO) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.eEP) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fjj) {
      localContentValues.put("ThumbUrl_cn", this.field_ThumbUrl_cn);
    }
    if (this.fjk) {
      localContentValues.put("ThumbUrl_hk", this.field_ThumbUrl_hk);
    }
    if (this.fjl) {
      localContentValues.put("ThumbUrl_tw", this.field_ThumbUrl_tw);
    }
    if (this.fjm) {
      localContentValues.put("ThumbUrl_en", this.field_ThumbUrl_en);
    }
    if (this.fjn) {
      localContentValues.put("ImgUrl_android_cn", this.field_ImgUrl_android_cn);
    }
    if (this.fjo) {
      localContentValues.put("ImgUrl_android_hk", this.field_ImgUrl_android_hk);
    }
    if (this.fjp) {
      localContentValues.put("ImgUrl_android_tw", this.field_ImgUrl_android_tw);
    }
    if (this.fjq) {
      localContentValues.put("ImgUrl_android_en", this.field_ImgUrl_android_en);
    }
    if (this.fjr) {
      localContentValues.put("RedPoint", Integer.valueOf(this.field_RedPoint));
    }
    if (this.fjs) {
      localContentValues.put("WeAppDebugMode", Integer.valueOf(this.field_WeAppDebugMode));
    }
    if (this.fjt) {
      localContentValues.put("idkey", Integer.valueOf(this.field_idkey));
    }
    if (this.fju) {
      localContentValues.put("idkeyValue", Integer.valueOf(this.field_idkeyValue));
    }
    if (this.fjv) {
      localContentValues.put("Icon", this.field_Icon);
    }
    if (this.fjw) {
      localContentValues.put("ImgUrl_cn", this.field_ImgUrl_cn);
    }
    if (this.fjx) {
      localContentValues.put("ImgUrl_hk", this.field_ImgUrl_hk);
    }
    if (this.fjy) {
      localContentValues.put("ImgUrl_tw", this.field_ImgUrl_tw);
    }
    if (this.fjz) {
      localContentValues.put("ImgUrl_en", this.field_ImgUrl_en);
    }
    if (this.fjA) {
      localContentValues.put("bItemFromXExpt", Integer.valueOf(this.field_bItemFromXExpt));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dw
 * JD-Core Version:    0.7.0.1
 */