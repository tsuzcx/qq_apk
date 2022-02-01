package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dk
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eMA;
  private static final int eMB;
  private static final int eMC;
  private static final int eMD;
  private static final int eME;
  private static final int eMF;
  private static final int eMG;
  private static final int eMH;
  private static final int eMI;
  private static final int eMJ;
  private static final int eMK;
  private static final int eML;
  private static final int eMM;
  private static final int eMN = "ThumbUrl_cn".hashCode();
  private static final int eMO = "ThumbUrl_hk".hashCode();
  private static final int eMP = "ThumbUrl_tw".hashCode();
  private static final int eMQ = "ThumbUrl_en".hashCode();
  private static final int eMR = "ImgUrl_android_cn".hashCode();
  private static final int eMS = "ImgUrl_android_hk".hashCode();
  private static final int eMT = "ImgUrl_android_tw".hashCode();
  private static final int eMU = "ImgUrl_android_en".hashCode();
  private static final int eMV = "RedPoint".hashCode();
  private static final int eMW = "WeAppDebugMode".hashCode();
  private static final int eMX = "idkey".hashCode();
  private static final int eMY = "idkeyValue".hashCode();
  private static final int eMZ = "Icon".hashCode();
  private static final int eMp = "LabsAppId".hashCode();
  private static final int eMq;
  private static final int eMr;
  private static final int eMs;
  private static final int eMt;
  private static final int eMu;
  private static final int eMv;
  private static final int eMw;
  private static final int eMx;
  private static final int eMy;
  private static final int eMz;
  private static final int eNa = "ImgUrl_cn".hashCode();
  private static final int eNb = "ImgUrl_hk".hashCode();
  private static final int eNc = "ImgUrl_tw".hashCode();
  private static final int eNd = "ImgUrl_en".hashCode();
  private static final int eNe = "bItemFromXExpt".hashCode();
  private static final int ejR;
  private static final int eka = "expId".hashCode();
  private static final int ekb;
  private static final int ekc;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eLA = true;
  private boolean eLB = true;
  private boolean eLC = true;
  private boolean eLD = true;
  private boolean eLE = true;
  private boolean eLF = true;
  private boolean eLG = true;
  private boolean eLH = true;
  private boolean eLI = true;
  private boolean eLJ = true;
  private boolean eLK = true;
  private boolean eLL = true;
  private boolean eLM = true;
  private boolean eLN = true;
  private boolean eLO = true;
  private boolean eLP = true;
  private boolean eLQ = true;
  private boolean eLR = true;
  private boolean eLS = true;
  private boolean eLT = true;
  private boolean eLU = true;
  private boolean eLV = true;
  private boolean eLW = true;
  private boolean eLX = true;
  private boolean eLY = true;
  private boolean eLZ = true;
  private boolean eLz = true;
  private boolean eMa = true;
  private boolean eMb = true;
  private boolean eMc = true;
  private boolean eMd = true;
  private boolean eMe = true;
  private boolean eMf = true;
  private boolean eMg = true;
  private boolean eMh = true;
  private boolean eMi = true;
  private boolean eMj = true;
  private boolean eMk = true;
  private boolean eMl = true;
  private boolean eMm = true;
  private boolean eMn = true;
  private boolean eMo = true;
  private boolean ejO = true;
  private boolean ejT = true;
  private boolean ejU = true;
  private boolean ejV = true;
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
    eMq = "Type".hashCode();
    eMr = "BizType".hashCode();
    eMs = "Switch".hashCode();
    eMt = "AllVer".hashCode();
    eMu = "DetailURL".hashCode();
    eMv = "WeAppUser".hashCode();
    eMw = "WeAppPath".hashCode();
    eMx = "Pos".hashCode();
    eMy = "TitleKey_android".hashCode();
    eMz = "Title_cn".hashCode();
    eMA = "Title_hk".hashCode();
    eMB = "Title_tw".hashCode();
    eMC = "Title_en".hashCode();
    eMD = "Desc_cn".hashCode();
    eME = "Desc_hk".hashCode();
    eMF = "Desc_tw".hashCode();
    eMG = "Desc_en".hashCode();
    eMH = "Introduce_cn".hashCode();
    eMI = "Introduce_hk".hashCode();
    eMJ = "Introduce_tw".hashCode();
    eMK = "Introduce_en".hashCode();
    eML = "starttime".hashCode();
    eMM = "endtime".hashCode();
    ekb = "sequence".hashCode();
    ekc = "prioritylevel".hashCode();
    ejR = "status".hashCode();
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
      if (eMp != k) {
        break label65;
      }
      this.field_LabsAppId = paramCursor.getString(i);
      this.eLz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eka == k) {
        this.field_expId = paramCursor.getString(i);
      } else if (eMq == k) {
        this.field_Type = paramCursor.getInt(i);
      } else if (eMr == k) {
        this.field_BizType = paramCursor.getInt(i);
      } else if (eMs == k) {
        this.field_Switch = paramCursor.getInt(i);
      } else if (eMt == k) {
        this.field_AllVer = paramCursor.getInt(i);
      } else if (eMu == k) {
        this.field_DetailURL = paramCursor.getString(i);
      } else if (eMv == k) {
        this.field_WeAppUser = paramCursor.getString(i);
      } else if (eMw == k) {
        this.field_WeAppPath = paramCursor.getString(i);
      } else if (eMx == k) {
        this.field_Pos = paramCursor.getInt(i);
      } else if (eMy == k) {
        this.field_TitleKey_android = paramCursor.getString(i);
      } else if (eMz == k) {
        this.field_Title_cn = paramCursor.getString(i);
      } else if (eMA == k) {
        this.field_Title_hk = paramCursor.getString(i);
      } else if (eMB == k) {
        this.field_Title_tw = paramCursor.getString(i);
      } else if (eMC == k) {
        this.field_Title_en = paramCursor.getString(i);
      } else if (eMD == k) {
        this.field_Desc_cn = paramCursor.getString(i);
      } else if (eME == k) {
        this.field_Desc_hk = paramCursor.getString(i);
      } else if (eMF == k) {
        this.field_Desc_tw = paramCursor.getString(i);
      } else if (eMG == k) {
        this.field_Desc_en = paramCursor.getString(i);
      } else if (eMH == k) {
        this.field_Introduce_cn = paramCursor.getString(i);
      } else if (eMI == k) {
        this.field_Introduce_hk = paramCursor.getString(i);
      } else if (eMJ == k) {
        this.field_Introduce_tw = paramCursor.getString(i);
      } else if (eMK == k) {
        this.field_Introduce_en = paramCursor.getString(i);
      } else if (eML == k) {
        this.field_starttime = paramCursor.getLong(i);
      } else if (eMM == k) {
        this.field_endtime = paramCursor.getLong(i);
      } else if (ekb == k) {
        this.field_sequence = paramCursor.getLong(i);
      } else if (ekc == k) {
        this.field_prioritylevel = paramCursor.getInt(i);
      } else if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eMN == k) {
        this.field_ThumbUrl_cn = paramCursor.getString(i);
      } else if (eMO == k) {
        this.field_ThumbUrl_hk = paramCursor.getString(i);
      } else if (eMP == k) {
        this.field_ThumbUrl_tw = paramCursor.getString(i);
      } else if (eMQ == k) {
        this.field_ThumbUrl_en = paramCursor.getString(i);
      } else if (eMR == k) {
        this.field_ImgUrl_android_cn = paramCursor.getString(i);
      } else if (eMS == k) {
        this.field_ImgUrl_android_hk = paramCursor.getString(i);
      } else if (eMT == k) {
        this.field_ImgUrl_android_tw = paramCursor.getString(i);
      } else if (eMU == k) {
        this.field_ImgUrl_android_en = paramCursor.getString(i);
      } else if (eMV == k) {
        this.field_RedPoint = paramCursor.getInt(i);
      } else if (eMW == k) {
        this.field_WeAppDebugMode = paramCursor.getInt(i);
      } else if (eMX == k) {
        this.field_idkey = paramCursor.getInt(i);
      } else if (eMY == k) {
        this.field_idkeyValue = paramCursor.getInt(i);
      } else if (eMZ == k) {
        this.field_Icon = paramCursor.getString(i);
      } else if (eNa == k) {
        this.field_ImgUrl_cn = paramCursor.getString(i);
      } else if (eNb == k) {
        this.field_ImgUrl_hk = paramCursor.getString(i);
      } else if (eNc == k) {
        this.field_ImgUrl_tw = paramCursor.getString(i);
      } else if (eNd == k) {
        this.field_ImgUrl_en = paramCursor.getString(i);
      } else if (eNe == k) {
        this.field_bItemFromXExpt = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eLz) {
      localContentValues.put("LabsAppId", this.field_LabsAppId);
    }
    if (this.field_expId == null) {
      this.field_expId = "";
    }
    if (this.ejT) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.eLA) {
      localContentValues.put("Type", Integer.valueOf(this.field_Type));
    }
    if (this.eLB) {
      localContentValues.put("BizType", Integer.valueOf(this.field_BizType));
    }
    if (this.eLC) {
      localContentValues.put("Switch", Integer.valueOf(this.field_Switch));
    }
    if (this.eLD) {
      localContentValues.put("AllVer", Integer.valueOf(this.field_AllVer));
    }
    if (this.eLE) {
      localContentValues.put("DetailURL", this.field_DetailURL);
    }
    if (this.eLF) {
      localContentValues.put("WeAppUser", this.field_WeAppUser);
    }
    if (this.eLG) {
      localContentValues.put("WeAppPath", this.field_WeAppPath);
    }
    if (this.eLH) {
      localContentValues.put("Pos", Integer.valueOf(this.field_Pos));
    }
    if (this.eLI) {
      localContentValues.put("TitleKey_android", this.field_TitleKey_android);
    }
    if (this.eLJ) {
      localContentValues.put("Title_cn", this.field_Title_cn);
    }
    if (this.eLK) {
      localContentValues.put("Title_hk", this.field_Title_hk);
    }
    if (this.eLL) {
      localContentValues.put("Title_tw", this.field_Title_tw);
    }
    if (this.eLM) {
      localContentValues.put("Title_en", this.field_Title_en);
    }
    if (this.eLN) {
      localContentValues.put("Desc_cn", this.field_Desc_cn);
    }
    if (this.eLO) {
      localContentValues.put("Desc_hk", this.field_Desc_hk);
    }
    if (this.eLP) {
      localContentValues.put("Desc_tw", this.field_Desc_tw);
    }
    if (this.eLQ) {
      localContentValues.put("Desc_en", this.field_Desc_en);
    }
    if (this.eLR) {
      localContentValues.put("Introduce_cn", this.field_Introduce_cn);
    }
    if (this.eLS) {
      localContentValues.put("Introduce_hk", this.field_Introduce_hk);
    }
    if (this.eLT) {
      localContentValues.put("Introduce_tw", this.field_Introduce_tw);
    }
    if (this.eLU) {
      localContentValues.put("Introduce_en", this.field_Introduce_en);
    }
    if (this.eLV) {
      localContentValues.put("starttime", Long.valueOf(this.field_starttime));
    }
    if (this.eLW) {
      localContentValues.put("endtime", Long.valueOf(this.field_endtime));
    }
    if (this.ejU) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.ejV) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eLX) {
      localContentValues.put("ThumbUrl_cn", this.field_ThumbUrl_cn);
    }
    if (this.eLY) {
      localContentValues.put("ThumbUrl_hk", this.field_ThumbUrl_hk);
    }
    if (this.eLZ) {
      localContentValues.put("ThumbUrl_tw", this.field_ThumbUrl_tw);
    }
    if (this.eMa) {
      localContentValues.put("ThumbUrl_en", this.field_ThumbUrl_en);
    }
    if (this.eMb) {
      localContentValues.put("ImgUrl_android_cn", this.field_ImgUrl_android_cn);
    }
    if (this.eMc) {
      localContentValues.put("ImgUrl_android_hk", this.field_ImgUrl_android_hk);
    }
    if (this.eMd) {
      localContentValues.put("ImgUrl_android_tw", this.field_ImgUrl_android_tw);
    }
    if (this.eMe) {
      localContentValues.put("ImgUrl_android_en", this.field_ImgUrl_android_en);
    }
    if (this.eMf) {
      localContentValues.put("RedPoint", Integer.valueOf(this.field_RedPoint));
    }
    if (this.eMg) {
      localContentValues.put("WeAppDebugMode", Integer.valueOf(this.field_WeAppDebugMode));
    }
    if (this.eMh) {
      localContentValues.put("idkey", Integer.valueOf(this.field_idkey));
    }
    if (this.eMi) {
      localContentValues.put("idkeyValue", Integer.valueOf(this.field_idkeyValue));
    }
    if (this.eMj) {
      localContentValues.put("Icon", this.field_Icon);
    }
    if (this.eMk) {
      localContentValues.put("ImgUrl_cn", this.field_ImgUrl_cn);
    }
    if (this.eMl) {
      localContentValues.put("ImgUrl_hk", this.field_ImgUrl_hk);
    }
    if (this.eMm) {
      localContentValues.put("ImgUrl_tw", this.field_ImgUrl_tw);
    }
    if (this.eMn) {
      localContentValues.put("ImgUrl_en", this.field_ImgUrl_en);
    }
    if (this.eMo) {
      localContentValues.put("bItemFromXExpt", Integer.valueOf(this.field_bItemFromXExpt));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.dk
 * JD-Core Version:    0.7.0.1
 */