package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class eg
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("LabAppInfo");
  private static final int hVW;
  private static final int hmC = "status".hashCode();
  public static final Column hmE;
  public static final Column hmF;
  public static final Column hmG;
  public static final Column hmH;
  public static final Column hmI;
  private static final int hmS;
  private static final int hmT;
  private static final int hmU;
  public static final Column hmw;
  public static final Column ifI;
  public static final Column ifJ;
  public static final Column ifK;
  public static final Column ifL;
  public static final Column ifM;
  public static final Column ifN;
  public static final Column ifO;
  public static final Column ifP;
  public static final Column ifQ;
  public static final Column ifR;
  public static final Column ifS;
  public static final Column ifT;
  public static final Column ifU;
  public static final Column ifV;
  public static final Column ifW;
  public static final Column ifX;
  public static final Column ifY;
  public static final Column ifZ;
  public static final Column iga;
  public static final Column igb;
  public static final Column igc;
  public static final Column igd;
  public static final Column ige;
  public static final Column igf;
  public static final Column igg;
  public static final Column igh;
  public static final Column igi;
  public static final Column igj;
  public static final Column igk;
  public static final Column igl;
  public static final Column igm;
  public static final Column ign;
  public static final Column igo;
  public static final Column igp;
  public static final Column igq;
  public static final Column igr;
  public static final Column igs;
  public static final Column igt;
  public static final Column igu;
  private static final int ihA;
  private static final int ihB;
  private static final int ihC;
  private static final int ihD;
  private static final int ihE;
  private static final int ihF;
  private static final int ihG;
  private static final int ihH = "ThumbUrl_cn".hashCode();
  private static final int ihI = "ThumbUrl_hk".hashCode();
  private static final int ihJ = "ThumbUrl_tw".hashCode();
  private static final int ihK = "ThumbUrl_en".hashCode();
  private static final int ihL = "ImgUrl_android_cn".hashCode();
  private static final int ihM = "ImgUrl_android_hk".hashCode();
  private static final int ihN = "ImgUrl_android_tw".hashCode();
  private static final int ihO = "ImgUrl_android_en".hashCode();
  private static final int ihP = "RedPoint".hashCode();
  private static final int ihQ = "WeAppDebugMode".hashCode();
  private static final int ihR = "idkey".hashCode();
  private static final int ihS = "idkeyValue".hashCode();
  private static final int ihT = "Icon".hashCode();
  private static final int ihU = "ImgUrl_cn".hashCode();
  private static final int ihV = "ImgUrl_hk".hashCode();
  private static final int ihW = "ImgUrl_tw".hashCode();
  private static final int ihX = "ImgUrl_en".hashCode();
  private static final int ihY = "bItemFromXExpt".hashCode();
  private static final int ihk;
  private static final int ihl;
  private static final int ihm;
  private static final int ihn;
  private static final int iho;
  private static final int ihp;
  private static final int ihq;
  private static final int ihr;
  private static final int ihs;
  private static final int iht;
  private static final int ihu;
  private static final int ihv;
  private static final int ihw;
  private static final int ihx;
  private static final int ihy;
  private static final int ihz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean hVN = true;
  private boolean hmL = true;
  private boolean hmM = true;
  private boolean hmN = true;
  private boolean hmz = true;
  private boolean igA = true;
  private boolean igB = true;
  private boolean igC = true;
  private boolean igD = true;
  private boolean igE = true;
  private boolean igF = true;
  private boolean igG = true;
  private boolean igH = true;
  private boolean igI = true;
  private boolean igJ = true;
  private boolean igK = true;
  private boolean igL = true;
  private boolean igM = true;
  private boolean igN = true;
  private boolean igO = true;
  private boolean igP = true;
  private boolean igQ = true;
  private boolean igR = true;
  private boolean igS = true;
  private boolean igT = true;
  private boolean igU = true;
  private boolean igV = true;
  private boolean igW = true;
  private boolean igX = true;
  private boolean igY = true;
  private boolean igZ = true;
  private boolean igv = true;
  private boolean igw = true;
  private boolean igx = true;
  private boolean igy = true;
  private boolean igz = true;
  private boolean iha = true;
  private boolean ihb = true;
  private boolean ihc = true;
  private boolean ihd = true;
  private boolean ihe = true;
  private boolean ihf = true;
  private boolean ihg = true;
  private boolean ihh = true;
  private boolean ihi = true;
  private boolean ihj = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "LabAppInfo", "");
    ifI = new Column("labsappid", "string", "LabAppInfo", "");
    hmE = new Column("expid", "string", "LabAppInfo", "");
    C_TYPE = new Column("type", "int", "LabAppInfo", "");
    ifJ = new Column("biztype", "int", "LabAppInfo", "");
    ifK = new Column("switch", "int", "LabAppInfo", "");
    ifL = new Column("allver", "int", "LabAppInfo", "");
    ifM = new Column("detailurl", "string", "LabAppInfo", "");
    ifN = new Column("weappuser", "string", "LabAppInfo", "");
    ifO = new Column("weapppath", "string", "LabAppInfo", "");
    ifP = new Column("pos", "int", "LabAppInfo", "");
    ifQ = new Column("titlekey_android", "string", "LabAppInfo", "");
    ifR = new Column("title_cn", "string", "LabAppInfo", "");
    ifS = new Column("title_hk", "string", "LabAppInfo", "");
    ifT = new Column("title_tw", "string", "LabAppInfo", "");
    ifU = new Column("title_en", "string", "LabAppInfo", "");
    ifV = new Column("desc_cn", "string", "LabAppInfo", "");
    ifW = new Column("desc_hk", "string", "LabAppInfo", "");
    ifX = new Column("desc_tw", "string", "LabAppInfo", "");
    ifY = new Column("desc_en", "string", "LabAppInfo", "");
    ifZ = new Column("introduce_cn", "string", "LabAppInfo", "");
    iga = new Column("introduce_hk", "string", "LabAppInfo", "");
    igb = new Column("introduce_tw", "string", "LabAppInfo", "");
    igc = new Column("introduce_en", "string", "LabAppInfo", "");
    hmH = new Column("starttime", "long", "LabAppInfo", "");
    hmI = new Column("endtime", "long", "LabAppInfo", "");
    hmF = new Column("sequence", "long", "LabAppInfo", "");
    hmG = new Column("prioritylevel", "int", "LabAppInfo", "");
    hmw = new Column("status", "int", "LabAppInfo", "");
    igd = new Column("thumburl_cn", "string", "LabAppInfo", "");
    ige = new Column("thumburl_hk", "string", "LabAppInfo", "");
    igf = new Column("thumburl_tw", "string", "LabAppInfo", "");
    igg = new Column("thumburl_en", "string", "LabAppInfo", "");
    igh = new Column("imgurl_android_cn", "string", "LabAppInfo", "");
    igi = new Column("imgurl_android_hk", "string", "LabAppInfo", "");
    igj = new Column("imgurl_android_tw", "string", "LabAppInfo", "");
    igk = new Column("imgurl_android_en", "string", "LabAppInfo", "");
    igl = new Column("redpoint", "int", "LabAppInfo", "");
    igm = new Column("weappdebugmode", "int", "LabAppInfo", "");
    ign = new Column("idkey", "int", "LabAppInfo", "");
    igo = new Column("idkeyvalue", "int", "LabAppInfo", "");
    igp = new Column("icon", "string", "LabAppInfo", "");
    igq = new Column("imgurl_cn", "string", "LabAppInfo", "");
    igr = new Column("imgurl_hk", "string", "LabAppInfo", "");
    igs = new Column("imgurl_tw", "string", "LabAppInfo", "");
    igt = new Column("imgurl_en", "string", "LabAppInfo", "");
    igu = new Column("bitemfromxexpt", "int", "LabAppInfo", "");
    ihk = "LabsAppId".hashCode();
    hmS = "expId".hashCode();
    hVW = "Type".hashCode();
    ihl = "BizType".hashCode();
    ihm = "Switch".hashCode();
    ihn = "AllVer".hashCode();
    iho = "DetailURL".hashCode();
    ihp = "WeAppUser".hashCode();
    ihq = "WeAppPath".hashCode();
    ihr = "Pos".hashCode();
    ihs = "TitleKey_android".hashCode();
    iht = "Title_cn".hashCode();
    ihu = "Title_hk".hashCode();
    ihv = "Title_tw".hashCode();
    ihw = "Title_en".hashCode();
    ihx = "Desc_cn".hashCode();
    ihy = "Desc_hk".hashCode();
    ihz = "Desc_tw".hashCode();
    ihA = "Desc_en".hashCode();
    ihB = "Introduce_cn".hashCode();
    ihC = "Introduce_hk".hashCode();
    ihD = "Introduce_tw".hashCode();
    ihE = "Introduce_en".hashCode();
    ihF = "starttime".hashCode();
    ihG = "endtime".hashCode();
    hmT = "sequence".hashCode();
    hmU = "prioritylevel".hashCode();
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
      if (ihk != k) {
        break label65;
      }
      this.field_LabsAppId = paramCursor.getString(i);
      this.igv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hmS == k) {
        this.field_expId = paramCursor.getString(i);
      } else if (hVW == k) {
        this.field_Type = paramCursor.getInt(i);
      } else if (ihl == k) {
        this.field_BizType = paramCursor.getInt(i);
      } else if (ihm == k) {
        this.field_Switch = paramCursor.getInt(i);
      } else if (ihn == k) {
        this.field_AllVer = paramCursor.getInt(i);
      } else if (iho == k) {
        this.field_DetailURL = paramCursor.getString(i);
      } else if (ihp == k) {
        this.field_WeAppUser = paramCursor.getString(i);
      } else if (ihq == k) {
        this.field_WeAppPath = paramCursor.getString(i);
      } else if (ihr == k) {
        this.field_Pos = paramCursor.getInt(i);
      } else if (ihs == k) {
        this.field_TitleKey_android = paramCursor.getString(i);
      } else if (iht == k) {
        this.field_Title_cn = paramCursor.getString(i);
      } else if (ihu == k) {
        this.field_Title_hk = paramCursor.getString(i);
      } else if (ihv == k) {
        this.field_Title_tw = paramCursor.getString(i);
      } else if (ihw == k) {
        this.field_Title_en = paramCursor.getString(i);
      } else if (ihx == k) {
        this.field_Desc_cn = paramCursor.getString(i);
      } else if (ihy == k) {
        this.field_Desc_hk = paramCursor.getString(i);
      } else if (ihz == k) {
        this.field_Desc_tw = paramCursor.getString(i);
      } else if (ihA == k) {
        this.field_Desc_en = paramCursor.getString(i);
      } else if (ihB == k) {
        this.field_Introduce_cn = paramCursor.getString(i);
      } else if (ihC == k) {
        this.field_Introduce_hk = paramCursor.getString(i);
      } else if (ihD == k) {
        this.field_Introduce_tw = paramCursor.getString(i);
      } else if (ihE == k) {
        this.field_Introduce_en = paramCursor.getString(i);
      } else if (ihF == k) {
        this.field_starttime = paramCursor.getLong(i);
      } else if (ihG == k) {
        this.field_endtime = paramCursor.getLong(i);
      } else if (hmT == k) {
        this.field_sequence = paramCursor.getLong(i);
      } else if (hmU == k) {
        this.field_prioritylevel = paramCursor.getInt(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (ihH == k) {
        this.field_ThumbUrl_cn = paramCursor.getString(i);
      } else if (ihI == k) {
        this.field_ThumbUrl_hk = paramCursor.getString(i);
      } else if (ihJ == k) {
        this.field_ThumbUrl_tw = paramCursor.getString(i);
      } else if (ihK == k) {
        this.field_ThumbUrl_en = paramCursor.getString(i);
      } else if (ihL == k) {
        this.field_ImgUrl_android_cn = paramCursor.getString(i);
      } else if (ihM == k) {
        this.field_ImgUrl_android_hk = paramCursor.getString(i);
      } else if (ihN == k) {
        this.field_ImgUrl_android_tw = paramCursor.getString(i);
      } else if (ihO == k) {
        this.field_ImgUrl_android_en = paramCursor.getString(i);
      } else if (ihP == k) {
        this.field_RedPoint = paramCursor.getInt(i);
      } else if (ihQ == k) {
        this.field_WeAppDebugMode = paramCursor.getInt(i);
      } else if (ihR == k) {
        this.field_idkey = paramCursor.getInt(i);
      } else if (ihS == k) {
        this.field_idkeyValue = paramCursor.getInt(i);
      } else if (ihT == k) {
        this.field_Icon = paramCursor.getString(i);
      } else if (ihU == k) {
        this.field_ImgUrl_cn = paramCursor.getString(i);
      } else if (ihV == k) {
        this.field_ImgUrl_hk = paramCursor.getString(i);
      } else if (ihW == k) {
        this.field_ImgUrl_tw = paramCursor.getString(i);
      } else if (ihX == k) {
        this.field_ImgUrl_en = paramCursor.getString(i);
      } else if (ihY == k) {
        this.field_bItemFromXExpt = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.igv) {
      localContentValues.put("LabsAppId", this.field_LabsAppId);
    }
    if (this.field_expId == null) {
      this.field_expId = "";
    }
    if (this.hmL) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.hVN) {
      localContentValues.put("Type", Integer.valueOf(this.field_Type));
    }
    if (this.igw) {
      localContentValues.put("BizType", Integer.valueOf(this.field_BizType));
    }
    if (this.igx) {
      localContentValues.put("Switch", Integer.valueOf(this.field_Switch));
    }
    if (this.igy) {
      localContentValues.put("AllVer", Integer.valueOf(this.field_AllVer));
    }
    if (this.igz) {
      localContentValues.put("DetailURL", this.field_DetailURL);
    }
    if (this.igA) {
      localContentValues.put("WeAppUser", this.field_WeAppUser);
    }
    if (this.igB) {
      localContentValues.put("WeAppPath", this.field_WeAppPath);
    }
    if (this.igC) {
      localContentValues.put("Pos", Integer.valueOf(this.field_Pos));
    }
    if (this.igD) {
      localContentValues.put("TitleKey_android", this.field_TitleKey_android);
    }
    if (this.igE) {
      localContentValues.put("Title_cn", this.field_Title_cn);
    }
    if (this.igF) {
      localContentValues.put("Title_hk", this.field_Title_hk);
    }
    if (this.igG) {
      localContentValues.put("Title_tw", this.field_Title_tw);
    }
    if (this.igH) {
      localContentValues.put("Title_en", this.field_Title_en);
    }
    if (this.igI) {
      localContentValues.put("Desc_cn", this.field_Desc_cn);
    }
    if (this.igJ) {
      localContentValues.put("Desc_hk", this.field_Desc_hk);
    }
    if (this.igK) {
      localContentValues.put("Desc_tw", this.field_Desc_tw);
    }
    if (this.igL) {
      localContentValues.put("Desc_en", this.field_Desc_en);
    }
    if (this.igM) {
      localContentValues.put("Introduce_cn", this.field_Introduce_cn);
    }
    if (this.igN) {
      localContentValues.put("Introduce_hk", this.field_Introduce_hk);
    }
    if (this.igO) {
      localContentValues.put("Introduce_tw", this.field_Introduce_tw);
    }
    if (this.igP) {
      localContentValues.put("Introduce_en", this.field_Introduce_en);
    }
    if (this.igQ) {
      localContentValues.put("starttime", Long.valueOf(this.field_starttime));
    }
    if (this.igR) {
      localContentValues.put("endtime", Long.valueOf(this.field_endtime));
    }
    if (this.hmM) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.hmN) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.igS) {
      localContentValues.put("ThumbUrl_cn", this.field_ThumbUrl_cn);
    }
    if (this.igT) {
      localContentValues.put("ThumbUrl_hk", this.field_ThumbUrl_hk);
    }
    if (this.igU) {
      localContentValues.put("ThumbUrl_tw", this.field_ThumbUrl_tw);
    }
    if (this.igV) {
      localContentValues.put("ThumbUrl_en", this.field_ThumbUrl_en);
    }
    if (this.igW) {
      localContentValues.put("ImgUrl_android_cn", this.field_ImgUrl_android_cn);
    }
    if (this.igX) {
      localContentValues.put("ImgUrl_android_hk", this.field_ImgUrl_android_hk);
    }
    if (this.igY) {
      localContentValues.put("ImgUrl_android_tw", this.field_ImgUrl_android_tw);
    }
    if (this.igZ) {
      localContentValues.put("ImgUrl_android_en", this.field_ImgUrl_android_en);
    }
    if (this.iha) {
      localContentValues.put("RedPoint", Integer.valueOf(this.field_RedPoint));
    }
    if (this.ihb) {
      localContentValues.put("WeAppDebugMode", Integer.valueOf(this.field_WeAppDebugMode));
    }
    if (this.ihc) {
      localContentValues.put("idkey", Integer.valueOf(this.field_idkey));
    }
    if (this.ihd) {
      localContentValues.put("idkeyValue", Integer.valueOf(this.field_idkeyValue));
    }
    if (this.ihe) {
      localContentValues.put("Icon", this.field_Icon);
    }
    if (this.ihf) {
      localContentValues.put("ImgUrl_cn", this.field_ImgUrl_cn);
    }
    if (this.ihg) {
      localContentValues.put("ImgUrl_hk", this.field_ImgUrl_hk);
    }
    if (this.ihh) {
      localContentValues.put("ImgUrl_tw", this.field_ImgUrl_tw);
    }
    if (this.ihi) {
      localContentValues.put("ImgUrl_en", this.field_ImgUrl_en);
    }
    if (this.ihj) {
      localContentValues.put("bItemFromXExpt", Integer.valueOf(this.field_bItemFromXExpt));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "LabAppInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.c.eg
 * JD-Core Version:    0.7.0.1
 */