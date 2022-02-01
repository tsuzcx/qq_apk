package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dw
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDc = "status".hashCode();
  private static final int eDl;
  private static final int eDm;
  private static final int eDn;
  private static final int fhD = "LabsAppId".hashCode();
  private static final int fhE;
  private static final int fhF;
  private static final int fhG;
  private static final int fhH;
  private static final int fhI;
  private static final int fhJ;
  private static final int fhK;
  private static final int fhL;
  private static final int fhM;
  private static final int fhN;
  private static final int fhO;
  private static final int fhP;
  private static final int fhQ;
  private static final int fhR;
  private static final int fhS;
  private static final int fhT;
  private static final int fhU;
  private static final int fhV;
  private static final int fhW;
  private static final int fhX;
  private static final int fhY;
  private static final int fhZ;
  private static final int fia;
  private static final int fib = "ThumbUrl_cn".hashCode();
  private static final int fic = "ThumbUrl_hk".hashCode();
  private static final int fid = "ThumbUrl_tw".hashCode();
  private static final int fie = "ThumbUrl_en".hashCode();
  private static final int fif = "ImgUrl_android_cn".hashCode();
  private static final int fig = "ImgUrl_android_hk".hashCode();
  private static final int fih = "ImgUrl_android_tw".hashCode();
  private static final int fii = "ImgUrl_android_en".hashCode();
  private static final int fij = "RedPoint".hashCode();
  private static final int fik = "WeAppDebugMode".hashCode();
  private static final int fil = "idkey".hashCode();
  private static final int fim = "idkeyValue".hashCode();
  private static final int fin = "Icon".hashCode();
  private static final int fio = "ImgUrl_cn".hashCode();
  private static final int fip = "ImgUrl_hk".hashCode();
  private static final int fiq = "ImgUrl_tw".hashCode();
  private static final int fir = "ImgUrl_en".hashCode();
  private static final int fit = "bItemFromXExpt".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eDe = true;
  private boolean eDf = true;
  private boolean eDg = true;
  private boolean fgN = true;
  private boolean fgO = true;
  private boolean fgP = true;
  private boolean fgQ = true;
  private boolean fgR = true;
  private boolean fgS = true;
  private boolean fgT = true;
  private boolean fgU = true;
  private boolean fgV = true;
  private boolean fgW = true;
  private boolean fgX = true;
  private boolean fgY = true;
  private boolean fgZ = true;
  private boolean fhA = true;
  private boolean fhB = true;
  private boolean fhC = true;
  private boolean fha = true;
  private boolean fhb = true;
  private boolean fhc = true;
  private boolean fhd = true;
  private boolean fhe = true;
  private boolean fhf = true;
  private boolean fhg = true;
  private boolean fhh = true;
  private boolean fhi = true;
  private boolean fhj = true;
  private boolean fhk = true;
  private boolean fhl = true;
  private boolean fhm = true;
  private boolean fhn = true;
  private boolean fho = true;
  private boolean fhp = true;
  private boolean fhq = true;
  private boolean fhr = true;
  private boolean fhs = true;
  private boolean fht = true;
  private boolean fhu = true;
  private boolean fhv = true;
  private boolean fhw = true;
  private boolean fhx = true;
  private boolean fhy = true;
  private boolean fhz = true;
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
    eDl = "expId".hashCode();
    fhE = "Type".hashCode();
    fhF = "BizType".hashCode();
    fhG = "Switch".hashCode();
    fhH = "AllVer".hashCode();
    fhI = "DetailURL".hashCode();
    fhJ = "WeAppUser".hashCode();
    fhK = "WeAppPath".hashCode();
    fhL = "Pos".hashCode();
    fhM = "TitleKey_android".hashCode();
    fhN = "Title_cn".hashCode();
    fhO = "Title_hk".hashCode();
    fhP = "Title_tw".hashCode();
    fhQ = "Title_en".hashCode();
    fhR = "Desc_cn".hashCode();
    fhS = "Desc_hk".hashCode();
    fhT = "Desc_tw".hashCode();
    fhU = "Desc_en".hashCode();
    fhV = "Introduce_cn".hashCode();
    fhW = "Introduce_hk".hashCode();
    fhX = "Introduce_tw".hashCode();
    fhY = "Introduce_en".hashCode();
    fhZ = "starttime".hashCode();
    fia = "endtime".hashCode();
    eDm = "sequence".hashCode();
    eDn = "prioritylevel".hashCode();
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
      if (fhD != k) {
        break label65;
      }
      this.field_LabsAppId = paramCursor.getString(i);
      this.fgN = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eDl == k) {
        this.field_expId = paramCursor.getString(i);
      } else if (fhE == k) {
        this.field_Type = paramCursor.getInt(i);
      } else if (fhF == k) {
        this.field_BizType = paramCursor.getInt(i);
      } else if (fhG == k) {
        this.field_Switch = paramCursor.getInt(i);
      } else if (fhH == k) {
        this.field_AllVer = paramCursor.getInt(i);
      } else if (fhI == k) {
        this.field_DetailURL = paramCursor.getString(i);
      } else if (fhJ == k) {
        this.field_WeAppUser = paramCursor.getString(i);
      } else if (fhK == k) {
        this.field_WeAppPath = paramCursor.getString(i);
      } else if (fhL == k) {
        this.field_Pos = paramCursor.getInt(i);
      } else if (fhM == k) {
        this.field_TitleKey_android = paramCursor.getString(i);
      } else if (fhN == k) {
        this.field_Title_cn = paramCursor.getString(i);
      } else if (fhO == k) {
        this.field_Title_hk = paramCursor.getString(i);
      } else if (fhP == k) {
        this.field_Title_tw = paramCursor.getString(i);
      } else if (fhQ == k) {
        this.field_Title_en = paramCursor.getString(i);
      } else if (fhR == k) {
        this.field_Desc_cn = paramCursor.getString(i);
      } else if (fhS == k) {
        this.field_Desc_hk = paramCursor.getString(i);
      } else if (fhT == k) {
        this.field_Desc_tw = paramCursor.getString(i);
      } else if (fhU == k) {
        this.field_Desc_en = paramCursor.getString(i);
      } else if (fhV == k) {
        this.field_Introduce_cn = paramCursor.getString(i);
      } else if (fhW == k) {
        this.field_Introduce_hk = paramCursor.getString(i);
      } else if (fhX == k) {
        this.field_Introduce_tw = paramCursor.getString(i);
      } else if (fhY == k) {
        this.field_Introduce_en = paramCursor.getString(i);
      } else if (fhZ == k) {
        this.field_starttime = paramCursor.getLong(i);
      } else if (fia == k) {
        this.field_endtime = paramCursor.getLong(i);
      } else if (eDm == k) {
        this.field_sequence = paramCursor.getLong(i);
      } else if (eDn == k) {
        this.field_prioritylevel = paramCursor.getInt(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fib == k) {
        this.field_ThumbUrl_cn = paramCursor.getString(i);
      } else if (fic == k) {
        this.field_ThumbUrl_hk = paramCursor.getString(i);
      } else if (fid == k) {
        this.field_ThumbUrl_tw = paramCursor.getString(i);
      } else if (fie == k) {
        this.field_ThumbUrl_en = paramCursor.getString(i);
      } else if (fif == k) {
        this.field_ImgUrl_android_cn = paramCursor.getString(i);
      } else if (fig == k) {
        this.field_ImgUrl_android_hk = paramCursor.getString(i);
      } else if (fih == k) {
        this.field_ImgUrl_android_tw = paramCursor.getString(i);
      } else if (fii == k) {
        this.field_ImgUrl_android_en = paramCursor.getString(i);
      } else if (fij == k) {
        this.field_RedPoint = paramCursor.getInt(i);
      } else if (fik == k) {
        this.field_WeAppDebugMode = paramCursor.getInt(i);
      } else if (fil == k) {
        this.field_idkey = paramCursor.getInt(i);
      } else if (fim == k) {
        this.field_idkeyValue = paramCursor.getInt(i);
      } else if (fin == k) {
        this.field_Icon = paramCursor.getString(i);
      } else if (fio == k) {
        this.field_ImgUrl_cn = paramCursor.getString(i);
      } else if (fip == k) {
        this.field_ImgUrl_hk = paramCursor.getString(i);
      } else if (fiq == k) {
        this.field_ImgUrl_tw = paramCursor.getString(i);
      } else if (fir == k) {
        this.field_ImgUrl_en = paramCursor.getString(i);
      } else if (fit == k) {
        this.field_bItemFromXExpt = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fgN) {
      localContentValues.put("LabsAppId", this.field_LabsAppId);
    }
    if (this.field_expId == null) {
      this.field_expId = "";
    }
    if (this.eDe) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.fgO) {
      localContentValues.put("Type", Integer.valueOf(this.field_Type));
    }
    if (this.fgP) {
      localContentValues.put("BizType", Integer.valueOf(this.field_BizType));
    }
    if (this.fgQ) {
      localContentValues.put("Switch", Integer.valueOf(this.field_Switch));
    }
    if (this.fgR) {
      localContentValues.put("AllVer", Integer.valueOf(this.field_AllVer));
    }
    if (this.fgS) {
      localContentValues.put("DetailURL", this.field_DetailURL);
    }
    if (this.fgT) {
      localContentValues.put("WeAppUser", this.field_WeAppUser);
    }
    if (this.fgU) {
      localContentValues.put("WeAppPath", this.field_WeAppPath);
    }
    if (this.fgV) {
      localContentValues.put("Pos", Integer.valueOf(this.field_Pos));
    }
    if (this.fgW) {
      localContentValues.put("TitleKey_android", this.field_TitleKey_android);
    }
    if (this.fgX) {
      localContentValues.put("Title_cn", this.field_Title_cn);
    }
    if (this.fgY) {
      localContentValues.put("Title_hk", this.field_Title_hk);
    }
    if (this.fgZ) {
      localContentValues.put("Title_tw", this.field_Title_tw);
    }
    if (this.fha) {
      localContentValues.put("Title_en", this.field_Title_en);
    }
    if (this.fhb) {
      localContentValues.put("Desc_cn", this.field_Desc_cn);
    }
    if (this.fhc) {
      localContentValues.put("Desc_hk", this.field_Desc_hk);
    }
    if (this.fhd) {
      localContentValues.put("Desc_tw", this.field_Desc_tw);
    }
    if (this.fhe) {
      localContentValues.put("Desc_en", this.field_Desc_en);
    }
    if (this.fhf) {
      localContentValues.put("Introduce_cn", this.field_Introduce_cn);
    }
    if (this.fhg) {
      localContentValues.put("Introduce_hk", this.field_Introduce_hk);
    }
    if (this.fhh) {
      localContentValues.put("Introduce_tw", this.field_Introduce_tw);
    }
    if (this.fhi) {
      localContentValues.put("Introduce_en", this.field_Introduce_en);
    }
    if (this.fhj) {
      localContentValues.put("starttime", Long.valueOf(this.field_starttime));
    }
    if (this.fhk) {
      localContentValues.put("endtime", Long.valueOf(this.field_endtime));
    }
    if (this.eDf) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.eDg) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fhl) {
      localContentValues.put("ThumbUrl_cn", this.field_ThumbUrl_cn);
    }
    if (this.fhm) {
      localContentValues.put("ThumbUrl_hk", this.field_ThumbUrl_hk);
    }
    if (this.fhn) {
      localContentValues.put("ThumbUrl_tw", this.field_ThumbUrl_tw);
    }
    if (this.fho) {
      localContentValues.put("ThumbUrl_en", this.field_ThumbUrl_en);
    }
    if (this.fhp) {
      localContentValues.put("ImgUrl_android_cn", this.field_ImgUrl_android_cn);
    }
    if (this.fhq) {
      localContentValues.put("ImgUrl_android_hk", this.field_ImgUrl_android_hk);
    }
    if (this.fhr) {
      localContentValues.put("ImgUrl_android_tw", this.field_ImgUrl_android_tw);
    }
    if (this.fhs) {
      localContentValues.put("ImgUrl_android_en", this.field_ImgUrl_android_en);
    }
    if (this.fht) {
      localContentValues.put("RedPoint", Integer.valueOf(this.field_RedPoint));
    }
    if (this.fhu) {
      localContentValues.put("WeAppDebugMode", Integer.valueOf(this.field_WeAppDebugMode));
    }
    if (this.fhv) {
      localContentValues.put("idkey", Integer.valueOf(this.field_idkey));
    }
    if (this.fhw) {
      localContentValues.put("idkeyValue", Integer.valueOf(this.field_idkeyValue));
    }
    if (this.fhx) {
      localContentValues.put("Icon", this.field_Icon);
    }
    if (this.fhy) {
      localContentValues.put("ImgUrl_cn", this.field_ImgUrl_cn);
    }
    if (this.fhz) {
      localContentValues.put("ImgUrl_hk", this.field_ImgUrl_hk);
    }
    if (this.fhA) {
      localContentValues.put("ImgUrl_tw", this.field_ImgUrl_tw);
    }
    if (this.fhB) {
      localContentValues.put("ImgUrl_en", this.field_ImgUrl_en);
    }
    if (this.fhC) {
      localContentValues.put("bItemFromXExpt", Integer.valueOf(this.field_bItemFromXExpt));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.dw
 * JD-Core Version:    0.7.0.1
 */