package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class eu
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("LabAppInfo");
  public static final Column TYPE;
  private static final int jIF;
  public static final Column jIH;
  public static final Column jII;
  public static final Column jIJ;
  public static final Column jIK;
  public static final Column jIL;
  private static final int jIV;
  private static final int jIW;
  private static final int jIX;
  public static final Column jIz;
  public static final Column kFA;
  public static final Column kFB;
  public static final Column kFC;
  public static final Column kFD;
  public static final Column kFE;
  public static final Column kFF;
  public static final Column kFG;
  public static final Column kFH;
  public static final Column kFI;
  public static final Column kFJ;
  public static final Column kFK;
  public static final Column kFL;
  public static final Column kFM;
  public static final Column kFN;
  public static final Column kFO;
  public static final Column kFP;
  public static final Column kFd;
  public static final Column kFe;
  public static final Column kFf;
  public static final Column kFg;
  public static final Column kFh;
  public static final Column kFi;
  public static final Column kFj;
  public static final Column kFk;
  public static final Column kFl;
  public static final Column kFm;
  public static final Column kFn;
  public static final Column kFo;
  public static final Column kFp;
  public static final Column kFq;
  public static final Column kFr;
  public static final Column kFs;
  public static final Column kFt;
  public static final Column kFu;
  public static final Column kFv;
  public static final Column kFw;
  public static final Column kFx;
  public static final Column kFy;
  public static final Column kFz;
  private static final int kGF;
  private static final int kGG;
  private static final int kGH;
  private static final int kGI;
  private static final int kGJ;
  private static final int kGK;
  private static final int kGL;
  private static final int kGM;
  private static final int kGN;
  private static final int kGO;
  private static final int kGP;
  private static final int kGQ;
  private static final int kGR;
  private static final int kGS;
  private static final int kGT;
  private static final int kGU;
  private static final int kGV;
  private static final int kGW;
  private static final int kGX;
  private static final int kGY;
  private static final int kGZ;
  private static final int kHa;
  private static final int kHb;
  private static final int kHc;
  private static final int kHd;
  private static final int kHe;
  private static final int kHf;
  private static final int kHg;
  private static final int kHh;
  private static final int kHi;
  private static final int kHj;
  private static final int kHk;
  private static final int kHl;
  private static final int kHm;
  private static final int kHn;
  private static final int kHo;
  private static final int kHp;
  private static final int kHq;
  private static final int kHr;
  private static final int kHs;
  private static final int kHt;
  private static final int kvi;
  private static final StorageObserverOwner<eu> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
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
  private boolean jIC = true;
  private boolean jIO = true;
  private boolean jIP = true;
  private boolean jIQ = true;
  private boolean kFQ = true;
  private boolean kFR = true;
  private boolean kFS = true;
  private boolean kFT = true;
  private boolean kFU = true;
  private boolean kFV = true;
  private boolean kFW = true;
  private boolean kFX = true;
  private boolean kFY = true;
  private boolean kFZ = true;
  private boolean kGA = true;
  private boolean kGB = true;
  private boolean kGC = true;
  private boolean kGD = true;
  private boolean kGE = true;
  private boolean kGa = true;
  private boolean kGb = true;
  private boolean kGc = true;
  private boolean kGd = true;
  private boolean kGe = true;
  private boolean kGf = true;
  private boolean kGg = true;
  private boolean kGh = true;
  private boolean kGi = true;
  private boolean kGj = true;
  private boolean kGk = true;
  private boolean kGl = true;
  private boolean kGm = true;
  private boolean kGn = true;
  private boolean kGo = true;
  private boolean kGp = true;
  private boolean kGq = true;
  private boolean kGr = true;
  private boolean kGs = true;
  private boolean kGt = true;
  private boolean kGu = true;
  private boolean kGv = true;
  private boolean kGw = true;
  private boolean kGx = true;
  private boolean kGy = true;
  private boolean kGz = true;
  private boolean kuZ = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kFd = new Column("LabsAppId", "string", TABLE.getName(), "");
    jIH = new Column("expId", "string", TABLE.getName(), "");
    TYPE = new Column("Type", "int", TABLE.getName(), "");
    kFe = new Column("BizType", "int", TABLE.getName(), "");
    kFf = new Column("Switch", "int", TABLE.getName(), "");
    kFg = new Column("AllVer", "int", TABLE.getName(), "");
    kFh = new Column("DetailURL", "string", TABLE.getName(), "");
    kFi = new Column("WeAppUser", "string", TABLE.getName(), "");
    kFj = new Column("WeAppPath", "string", TABLE.getName(), "");
    kFk = new Column("Pos", "int", TABLE.getName(), "");
    kFl = new Column("TitleKey_android", "string", TABLE.getName(), "");
    kFm = new Column("Title_cn", "string", TABLE.getName(), "");
    kFn = new Column("Title_hk", "string", TABLE.getName(), "");
    kFo = new Column("Title_tw", "string", TABLE.getName(), "");
    kFp = new Column("Title_en", "string", TABLE.getName(), "");
    kFq = new Column("Desc_cn", "string", TABLE.getName(), "");
    kFr = new Column("Desc_hk", "string", TABLE.getName(), "");
    kFs = new Column("Desc_tw", "string", TABLE.getName(), "");
    kFt = new Column("Desc_en", "string", TABLE.getName(), "");
    kFu = new Column("Introduce_cn", "string", TABLE.getName(), "");
    kFv = new Column("Introduce_hk", "string", TABLE.getName(), "");
    kFw = new Column("Introduce_tw", "string", TABLE.getName(), "");
    kFx = new Column("Introduce_en", "string", TABLE.getName(), "");
    jIK = new Column("starttime", "long", TABLE.getName(), "");
    jIL = new Column("endtime", "long", TABLE.getName(), "");
    jII = new Column("sequence", "long", TABLE.getName(), "");
    jIJ = new Column("prioritylevel", "int", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    kFy = new Column("ThumbUrl_cn", "string", TABLE.getName(), "");
    kFz = new Column("ThumbUrl_hk", "string", TABLE.getName(), "");
    kFA = new Column("ThumbUrl_tw", "string", TABLE.getName(), "");
    kFB = new Column("ThumbUrl_en", "string", TABLE.getName(), "");
    kFC = new Column("ImgUrl_android_cn", "string", TABLE.getName(), "");
    kFD = new Column("ImgUrl_android_hk", "string", TABLE.getName(), "");
    kFE = new Column("ImgUrl_android_tw", "string", TABLE.getName(), "");
    kFF = new Column("ImgUrl_android_en", "string", TABLE.getName(), "");
    kFG = new Column("RedPoint", "int", TABLE.getName(), "");
    kFH = new Column("WeAppDebugMode", "int", TABLE.getName(), "");
    kFI = new Column("idkey", "int", TABLE.getName(), "");
    kFJ = new Column("idkeyValue", "int", TABLE.getName(), "");
    kFK = new Column("Icon", "string", TABLE.getName(), "");
    kFL = new Column("ImgUrl_cn", "string", TABLE.getName(), "");
    kFM = new Column("ImgUrl_hk", "string", TABLE.getName(), "");
    kFN = new Column("ImgUrl_tw", "string", TABLE.getName(), "");
    kFO = new Column("ImgUrl_en", "string", TABLE.getName(), "");
    kFP = new Column("bItemFromXExpt", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kGF = "LabsAppId".hashCode();
    jIV = "expId".hashCode();
    kvi = "Type".hashCode();
    kGG = "BizType".hashCode();
    kGH = "Switch".hashCode();
    kGI = "AllVer".hashCode();
    kGJ = "DetailURL".hashCode();
    kGK = "WeAppUser".hashCode();
    kGL = "WeAppPath".hashCode();
    kGM = "Pos".hashCode();
    kGN = "TitleKey_android".hashCode();
    kGO = "Title_cn".hashCode();
    kGP = "Title_hk".hashCode();
    kGQ = "Title_tw".hashCode();
    kGR = "Title_en".hashCode();
    kGS = "Desc_cn".hashCode();
    kGT = "Desc_hk".hashCode();
    kGU = "Desc_tw".hashCode();
    kGV = "Desc_en".hashCode();
    kGW = "Introduce_cn".hashCode();
    kGX = "Introduce_hk".hashCode();
    kGY = "Introduce_tw".hashCode();
    kGZ = "Introduce_en".hashCode();
    kHa = "starttime".hashCode();
    kHb = "endtime".hashCode();
    jIW = "sequence".hashCode();
    jIX = "prioritylevel".hashCode();
    jIF = "status".hashCode();
    kHc = "ThumbUrl_cn".hashCode();
    kHd = "ThumbUrl_hk".hashCode();
    kHe = "ThumbUrl_tw".hashCode();
    kHf = "ThumbUrl_en".hashCode();
    kHg = "ImgUrl_android_cn".hashCode();
    kHh = "ImgUrl_android_hk".hashCode();
    kHi = "ImgUrl_android_tw".hashCode();
    kHj = "ImgUrl_android_en".hashCode();
    kHk = "RedPoint".hashCode();
    kHl = "WeAppDebugMode".hashCode();
    kHm = "idkey".hashCode();
    kHn = "idkeyValue".hashCode();
    kHo = "Icon".hashCode();
    kHp = "ImgUrl_cn".hashCode();
    kHq = "ImgUrl_hk".hashCode();
    kHr = "ImgUrl_tw".hashCode();
    kHs = "ImgUrl_en".hashCode();
    kHt = "bItemFromXExpt".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[46];
    localMAutoDBInfo.columns = new String[47];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "LabsAppId";
    localMAutoDBInfo.colsMap.put("LabsAppId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" LabsAppId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "LabsAppId";
    localMAutoDBInfo.columns[1] = "expId";
    localMAutoDBInfo.colsMap.put("expId", "TEXT default '' ");
    localStringBuilder.append(" expId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "Type";
    localMAutoDBInfo.colsMap.put("Type", "INTEGER default '0' ");
    localStringBuilder.append(" Type INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "BizType";
    localMAutoDBInfo.colsMap.put("BizType", "INTEGER default '0' ");
    localStringBuilder.append(" BizType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "Switch";
    localMAutoDBInfo.colsMap.put("Switch", "INTEGER default '0' ");
    localStringBuilder.append(" Switch INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "AllVer";
    localMAutoDBInfo.colsMap.put("AllVer", "INTEGER default '0' ");
    localStringBuilder.append(" AllVer INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "DetailURL";
    localMAutoDBInfo.colsMap.put("DetailURL", "TEXT");
    localStringBuilder.append(" DetailURL TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "WeAppUser";
    localMAutoDBInfo.colsMap.put("WeAppUser", "TEXT");
    localStringBuilder.append(" WeAppUser TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "WeAppPath";
    localMAutoDBInfo.colsMap.put("WeAppPath", "TEXT");
    localStringBuilder.append(" WeAppPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "Pos";
    localMAutoDBInfo.colsMap.put("Pos", "INTEGER default '0' ");
    localStringBuilder.append(" Pos INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "TitleKey_android";
    localMAutoDBInfo.colsMap.put("TitleKey_android", "TEXT");
    localStringBuilder.append(" TitleKey_android TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "Title_cn";
    localMAutoDBInfo.colsMap.put("Title_cn", "TEXT");
    localStringBuilder.append(" Title_cn TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "Title_hk";
    localMAutoDBInfo.colsMap.put("Title_hk", "TEXT");
    localStringBuilder.append(" Title_hk TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "Title_tw";
    localMAutoDBInfo.colsMap.put("Title_tw", "TEXT");
    localStringBuilder.append(" Title_tw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "Title_en";
    localMAutoDBInfo.colsMap.put("Title_en", "TEXT");
    localStringBuilder.append(" Title_en TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "Desc_cn";
    localMAutoDBInfo.colsMap.put("Desc_cn", "TEXT");
    localStringBuilder.append(" Desc_cn TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "Desc_hk";
    localMAutoDBInfo.colsMap.put("Desc_hk", "TEXT");
    localStringBuilder.append(" Desc_hk TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "Desc_tw";
    localMAutoDBInfo.colsMap.put("Desc_tw", "TEXT");
    localStringBuilder.append(" Desc_tw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "Desc_en";
    localMAutoDBInfo.colsMap.put("Desc_en", "TEXT");
    localStringBuilder.append(" Desc_en TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "Introduce_cn";
    localMAutoDBInfo.colsMap.put("Introduce_cn", "TEXT");
    localStringBuilder.append(" Introduce_cn TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "Introduce_hk";
    localMAutoDBInfo.colsMap.put("Introduce_hk", "TEXT");
    localStringBuilder.append(" Introduce_hk TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "Introduce_tw";
    localMAutoDBInfo.colsMap.put("Introduce_tw", "TEXT");
    localStringBuilder.append(" Introduce_tw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "Introduce_en";
    localMAutoDBInfo.colsMap.put("Introduce_en", "TEXT");
    localStringBuilder.append(" Introduce_en TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "starttime";
    localMAutoDBInfo.colsMap.put("starttime", "LONG");
    localStringBuilder.append(" starttime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "endtime";
    localMAutoDBInfo.colsMap.put("endtime", "LONG");
    localStringBuilder.append(" endtime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "sequence";
    localMAutoDBInfo.colsMap.put("sequence", "LONG");
    localStringBuilder.append(" sequence LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "prioritylevel";
    localMAutoDBInfo.colsMap.put("prioritylevel", "INTEGER");
    localStringBuilder.append(" prioritylevel INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "ThumbUrl_cn";
    localMAutoDBInfo.colsMap.put("ThumbUrl_cn", "TEXT");
    localStringBuilder.append(" ThumbUrl_cn TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "ThumbUrl_hk";
    localMAutoDBInfo.colsMap.put("ThumbUrl_hk", "TEXT");
    localStringBuilder.append(" ThumbUrl_hk TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "ThumbUrl_tw";
    localMAutoDBInfo.colsMap.put("ThumbUrl_tw", "TEXT");
    localStringBuilder.append(" ThumbUrl_tw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "ThumbUrl_en";
    localMAutoDBInfo.colsMap.put("ThumbUrl_en", "TEXT");
    localStringBuilder.append(" ThumbUrl_en TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "ImgUrl_android_cn";
    localMAutoDBInfo.colsMap.put("ImgUrl_android_cn", "TEXT");
    localStringBuilder.append(" ImgUrl_android_cn TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[33] = "ImgUrl_android_hk";
    localMAutoDBInfo.colsMap.put("ImgUrl_android_hk", "TEXT");
    localStringBuilder.append(" ImgUrl_android_hk TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[34] = "ImgUrl_android_tw";
    localMAutoDBInfo.colsMap.put("ImgUrl_android_tw", "TEXT");
    localStringBuilder.append(" ImgUrl_android_tw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[35] = "ImgUrl_android_en";
    localMAutoDBInfo.colsMap.put("ImgUrl_android_en", "TEXT");
    localStringBuilder.append(" ImgUrl_android_en TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[36] = "RedPoint";
    localMAutoDBInfo.colsMap.put("RedPoint", "INTEGER");
    localStringBuilder.append(" RedPoint INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[37] = "WeAppDebugMode";
    localMAutoDBInfo.colsMap.put("WeAppDebugMode", "INTEGER");
    localStringBuilder.append(" WeAppDebugMode INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[38] = "idkey";
    localMAutoDBInfo.colsMap.put("idkey", "INTEGER");
    localStringBuilder.append(" idkey INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[39] = "idkeyValue";
    localMAutoDBInfo.colsMap.put("idkeyValue", "INTEGER");
    localStringBuilder.append(" idkeyValue INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[40] = "Icon";
    localMAutoDBInfo.colsMap.put("Icon", "TEXT");
    localStringBuilder.append(" Icon TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[41] = "ImgUrl_cn";
    localMAutoDBInfo.colsMap.put("ImgUrl_cn", "TEXT");
    localStringBuilder.append(" ImgUrl_cn TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[42] = "ImgUrl_hk";
    localMAutoDBInfo.colsMap.put("ImgUrl_hk", "TEXT");
    localStringBuilder.append(" ImgUrl_hk TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[43] = "ImgUrl_tw";
    localMAutoDBInfo.colsMap.put("ImgUrl_tw", "TEXT");
    localStringBuilder.append(" ImgUrl_tw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[44] = "ImgUrl_en";
    localMAutoDBInfo.colsMap.put("ImgUrl_en", "TEXT");
    localStringBuilder.append(" ImgUrl_en TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[45] = "bItemFromXExpt";
    localMAutoDBInfo.colsMap.put("bItemFromXExpt", "INTEGER");
    localStringBuilder.append(" bItemFromXExpt INTEGER");
    localMAutoDBInfo.columns[46] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("LabsAppId"))
    {
      this.field_LabsAppId = paramContentValues.getAsString("LabsAppId");
      if (paramBoolean) {
        this.kFQ = true;
      }
    }
    if (paramContentValues.containsKey("expId"))
    {
      this.field_expId = paramContentValues.getAsString("expId");
      if (paramBoolean) {
        this.jIO = true;
      }
    }
    if (paramContentValues.containsKey("Type"))
    {
      this.field_Type = paramContentValues.getAsInteger("Type").intValue();
      if (paramBoolean) {
        this.kuZ = true;
      }
    }
    if (paramContentValues.containsKey("BizType"))
    {
      this.field_BizType = paramContentValues.getAsInteger("BizType").intValue();
      if (paramBoolean) {
        this.kFR = true;
      }
    }
    if (paramContentValues.containsKey("Switch"))
    {
      this.field_Switch = paramContentValues.getAsInteger("Switch").intValue();
      if (paramBoolean) {
        this.kFS = true;
      }
    }
    if (paramContentValues.containsKey("AllVer"))
    {
      this.field_AllVer = paramContentValues.getAsInteger("AllVer").intValue();
      if (paramBoolean) {
        this.kFT = true;
      }
    }
    if (paramContentValues.containsKey("DetailURL"))
    {
      this.field_DetailURL = paramContentValues.getAsString("DetailURL");
      if (paramBoolean) {
        this.kFU = true;
      }
    }
    if (paramContentValues.containsKey("WeAppUser"))
    {
      this.field_WeAppUser = paramContentValues.getAsString("WeAppUser");
      if (paramBoolean) {
        this.kFV = true;
      }
    }
    if (paramContentValues.containsKey("WeAppPath"))
    {
      this.field_WeAppPath = paramContentValues.getAsString("WeAppPath");
      if (paramBoolean) {
        this.kFW = true;
      }
    }
    if (paramContentValues.containsKey("Pos"))
    {
      this.field_Pos = paramContentValues.getAsInteger("Pos").intValue();
      if (paramBoolean) {
        this.kFX = true;
      }
    }
    if (paramContentValues.containsKey("TitleKey_android"))
    {
      this.field_TitleKey_android = paramContentValues.getAsString("TitleKey_android");
      if (paramBoolean) {
        this.kFY = true;
      }
    }
    if (paramContentValues.containsKey("Title_cn"))
    {
      this.field_Title_cn = paramContentValues.getAsString("Title_cn");
      if (paramBoolean) {
        this.kFZ = true;
      }
    }
    if (paramContentValues.containsKey("Title_hk"))
    {
      this.field_Title_hk = paramContentValues.getAsString("Title_hk");
      if (paramBoolean) {
        this.kGa = true;
      }
    }
    if (paramContentValues.containsKey("Title_tw"))
    {
      this.field_Title_tw = paramContentValues.getAsString("Title_tw");
      if (paramBoolean) {
        this.kGb = true;
      }
    }
    if (paramContentValues.containsKey("Title_en"))
    {
      this.field_Title_en = paramContentValues.getAsString("Title_en");
      if (paramBoolean) {
        this.kGc = true;
      }
    }
    if (paramContentValues.containsKey("Desc_cn"))
    {
      this.field_Desc_cn = paramContentValues.getAsString("Desc_cn");
      if (paramBoolean) {
        this.kGd = true;
      }
    }
    if (paramContentValues.containsKey("Desc_hk"))
    {
      this.field_Desc_hk = paramContentValues.getAsString("Desc_hk");
      if (paramBoolean) {
        this.kGe = true;
      }
    }
    if (paramContentValues.containsKey("Desc_tw"))
    {
      this.field_Desc_tw = paramContentValues.getAsString("Desc_tw");
      if (paramBoolean) {
        this.kGf = true;
      }
    }
    if (paramContentValues.containsKey("Desc_en"))
    {
      this.field_Desc_en = paramContentValues.getAsString("Desc_en");
      if (paramBoolean) {
        this.kGg = true;
      }
    }
    if (paramContentValues.containsKey("Introduce_cn"))
    {
      this.field_Introduce_cn = paramContentValues.getAsString("Introduce_cn");
      if (paramBoolean) {
        this.kGh = true;
      }
    }
    if (paramContentValues.containsKey("Introduce_hk"))
    {
      this.field_Introduce_hk = paramContentValues.getAsString("Introduce_hk");
      if (paramBoolean) {
        this.kGi = true;
      }
    }
    if (paramContentValues.containsKey("Introduce_tw"))
    {
      this.field_Introduce_tw = paramContentValues.getAsString("Introduce_tw");
      if (paramBoolean) {
        this.kGj = true;
      }
    }
    if (paramContentValues.containsKey("Introduce_en"))
    {
      this.field_Introduce_en = paramContentValues.getAsString("Introduce_en");
      if (paramBoolean) {
        this.kGk = true;
      }
    }
    if (paramContentValues.containsKey("starttime"))
    {
      this.field_starttime = paramContentValues.getAsLong("starttime").longValue();
      if (paramBoolean) {
        this.kGl = true;
      }
    }
    if (paramContentValues.containsKey("endtime"))
    {
      this.field_endtime = paramContentValues.getAsLong("endtime").longValue();
      if (paramBoolean) {
        this.kGm = true;
      }
    }
    if (paramContentValues.containsKey("sequence"))
    {
      this.field_sequence = paramContentValues.getAsLong("sequence").longValue();
      if (paramBoolean) {
        this.jIP = true;
      }
    }
    if (paramContentValues.containsKey("prioritylevel"))
    {
      this.field_prioritylevel = paramContentValues.getAsInteger("prioritylevel").intValue();
      if (paramBoolean) {
        this.jIQ = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("ThumbUrl_cn"))
    {
      this.field_ThumbUrl_cn = paramContentValues.getAsString("ThumbUrl_cn");
      if (paramBoolean) {
        this.kGn = true;
      }
    }
    if (paramContentValues.containsKey("ThumbUrl_hk"))
    {
      this.field_ThumbUrl_hk = paramContentValues.getAsString("ThumbUrl_hk");
      if (paramBoolean) {
        this.kGo = true;
      }
    }
    if (paramContentValues.containsKey("ThumbUrl_tw"))
    {
      this.field_ThumbUrl_tw = paramContentValues.getAsString("ThumbUrl_tw");
      if (paramBoolean) {
        this.kGp = true;
      }
    }
    if (paramContentValues.containsKey("ThumbUrl_en"))
    {
      this.field_ThumbUrl_en = paramContentValues.getAsString("ThumbUrl_en");
      if (paramBoolean) {
        this.kGq = true;
      }
    }
    if (paramContentValues.containsKey("ImgUrl_android_cn"))
    {
      this.field_ImgUrl_android_cn = paramContentValues.getAsString("ImgUrl_android_cn");
      if (paramBoolean) {
        this.kGr = true;
      }
    }
    if (paramContentValues.containsKey("ImgUrl_android_hk"))
    {
      this.field_ImgUrl_android_hk = paramContentValues.getAsString("ImgUrl_android_hk");
      if (paramBoolean) {
        this.kGs = true;
      }
    }
    if (paramContentValues.containsKey("ImgUrl_android_tw"))
    {
      this.field_ImgUrl_android_tw = paramContentValues.getAsString("ImgUrl_android_tw");
      if (paramBoolean) {
        this.kGt = true;
      }
    }
    if (paramContentValues.containsKey("ImgUrl_android_en"))
    {
      this.field_ImgUrl_android_en = paramContentValues.getAsString("ImgUrl_android_en");
      if (paramBoolean) {
        this.kGu = true;
      }
    }
    if (paramContentValues.containsKey("RedPoint"))
    {
      this.field_RedPoint = paramContentValues.getAsInteger("RedPoint").intValue();
      if (paramBoolean) {
        this.kGv = true;
      }
    }
    if (paramContentValues.containsKey("WeAppDebugMode"))
    {
      this.field_WeAppDebugMode = paramContentValues.getAsInteger("WeAppDebugMode").intValue();
      if (paramBoolean) {
        this.kGw = true;
      }
    }
    if (paramContentValues.containsKey("idkey"))
    {
      this.field_idkey = paramContentValues.getAsInteger("idkey").intValue();
      if (paramBoolean) {
        this.kGx = true;
      }
    }
    if (paramContentValues.containsKey("idkeyValue"))
    {
      this.field_idkeyValue = paramContentValues.getAsInteger("idkeyValue").intValue();
      if (paramBoolean) {
        this.kGy = true;
      }
    }
    if (paramContentValues.containsKey("Icon"))
    {
      this.field_Icon = paramContentValues.getAsString("Icon");
      if (paramBoolean) {
        this.kGz = true;
      }
    }
    if (paramContentValues.containsKey("ImgUrl_cn"))
    {
      this.field_ImgUrl_cn = paramContentValues.getAsString("ImgUrl_cn");
      if (paramBoolean) {
        this.kGA = true;
      }
    }
    if (paramContentValues.containsKey("ImgUrl_hk"))
    {
      this.field_ImgUrl_hk = paramContentValues.getAsString("ImgUrl_hk");
      if (paramBoolean) {
        this.kGB = true;
      }
    }
    if (paramContentValues.containsKey("ImgUrl_tw"))
    {
      this.field_ImgUrl_tw = paramContentValues.getAsString("ImgUrl_tw");
      if (paramBoolean) {
        this.kGC = true;
      }
    }
    if (paramContentValues.containsKey("ImgUrl_en"))
    {
      this.field_ImgUrl_en = paramContentValues.getAsString("ImgUrl_en");
      if (paramBoolean) {
        this.kGD = true;
      }
    }
    if (paramContentValues.containsKey("bItemFromXExpt"))
    {
      this.field_bItemFromXExpt = paramContentValues.getAsInteger("bItemFromXExpt").intValue();
      if (paramBoolean) {
        this.kGE = true;
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
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
      if (kGF != k) {
        break label65;
      }
      this.field_LabsAppId = paramCursor.getString(i);
      this.kFQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jIV == k) {
        this.field_expId = paramCursor.getString(i);
      } else if (kvi == k) {
        this.field_Type = paramCursor.getInt(i);
      } else if (kGG == k) {
        this.field_BizType = paramCursor.getInt(i);
      } else if (kGH == k) {
        this.field_Switch = paramCursor.getInt(i);
      } else if (kGI == k) {
        this.field_AllVer = paramCursor.getInt(i);
      } else if (kGJ == k) {
        this.field_DetailURL = paramCursor.getString(i);
      } else if (kGK == k) {
        this.field_WeAppUser = paramCursor.getString(i);
      } else if (kGL == k) {
        this.field_WeAppPath = paramCursor.getString(i);
      } else if (kGM == k) {
        this.field_Pos = paramCursor.getInt(i);
      } else if (kGN == k) {
        this.field_TitleKey_android = paramCursor.getString(i);
      } else if (kGO == k) {
        this.field_Title_cn = paramCursor.getString(i);
      } else if (kGP == k) {
        this.field_Title_hk = paramCursor.getString(i);
      } else if (kGQ == k) {
        this.field_Title_tw = paramCursor.getString(i);
      } else if (kGR == k) {
        this.field_Title_en = paramCursor.getString(i);
      } else if (kGS == k) {
        this.field_Desc_cn = paramCursor.getString(i);
      } else if (kGT == k) {
        this.field_Desc_hk = paramCursor.getString(i);
      } else if (kGU == k) {
        this.field_Desc_tw = paramCursor.getString(i);
      } else if (kGV == k) {
        this.field_Desc_en = paramCursor.getString(i);
      } else if (kGW == k) {
        this.field_Introduce_cn = paramCursor.getString(i);
      } else if (kGX == k) {
        this.field_Introduce_hk = paramCursor.getString(i);
      } else if (kGY == k) {
        this.field_Introduce_tw = paramCursor.getString(i);
      } else if (kGZ == k) {
        this.field_Introduce_en = paramCursor.getString(i);
      } else if (kHa == k) {
        this.field_starttime = paramCursor.getLong(i);
      } else if (kHb == k) {
        this.field_endtime = paramCursor.getLong(i);
      } else if (jIW == k) {
        this.field_sequence = paramCursor.getLong(i);
      } else if (jIX == k) {
        this.field_prioritylevel = paramCursor.getInt(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (kHc == k) {
        this.field_ThumbUrl_cn = paramCursor.getString(i);
      } else if (kHd == k) {
        this.field_ThumbUrl_hk = paramCursor.getString(i);
      } else if (kHe == k) {
        this.field_ThumbUrl_tw = paramCursor.getString(i);
      } else if (kHf == k) {
        this.field_ThumbUrl_en = paramCursor.getString(i);
      } else if (kHg == k) {
        this.field_ImgUrl_android_cn = paramCursor.getString(i);
      } else if (kHh == k) {
        this.field_ImgUrl_android_hk = paramCursor.getString(i);
      } else if (kHi == k) {
        this.field_ImgUrl_android_tw = paramCursor.getString(i);
      } else if (kHj == k) {
        this.field_ImgUrl_android_en = paramCursor.getString(i);
      } else if (kHk == k) {
        this.field_RedPoint = paramCursor.getInt(i);
      } else if (kHl == k) {
        this.field_WeAppDebugMode = paramCursor.getInt(i);
      } else if (kHm == k) {
        this.field_idkey = paramCursor.getInt(i);
      } else if (kHn == k) {
        this.field_idkeyValue = paramCursor.getInt(i);
      } else if (kHo == k) {
        this.field_Icon = paramCursor.getString(i);
      } else if (kHp == k) {
        this.field_ImgUrl_cn = paramCursor.getString(i);
      } else if (kHq == k) {
        this.field_ImgUrl_hk = paramCursor.getString(i);
      } else if (kHr == k) {
        this.field_ImgUrl_tw = paramCursor.getString(i);
      } else if (kHs == k) {
        this.field_ImgUrl_en = paramCursor.getString(i);
      } else if (kHt == k) {
        this.field_bItemFromXExpt = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kFQ) {
      localContentValues.put("LabsAppId", this.field_LabsAppId);
    }
    if (this.field_expId == null) {
      this.field_expId = "";
    }
    if (this.jIO) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.kuZ) {
      localContentValues.put("Type", Integer.valueOf(this.field_Type));
    }
    if (this.kFR) {
      localContentValues.put("BizType", Integer.valueOf(this.field_BizType));
    }
    if (this.kFS) {
      localContentValues.put("Switch", Integer.valueOf(this.field_Switch));
    }
    if (this.kFT) {
      localContentValues.put("AllVer", Integer.valueOf(this.field_AllVer));
    }
    if (this.kFU) {
      localContentValues.put("DetailURL", this.field_DetailURL);
    }
    if (this.kFV) {
      localContentValues.put("WeAppUser", this.field_WeAppUser);
    }
    if (this.kFW) {
      localContentValues.put("WeAppPath", this.field_WeAppPath);
    }
    if (this.kFX) {
      localContentValues.put("Pos", Integer.valueOf(this.field_Pos));
    }
    if (this.kFY) {
      localContentValues.put("TitleKey_android", this.field_TitleKey_android);
    }
    if (this.kFZ) {
      localContentValues.put("Title_cn", this.field_Title_cn);
    }
    if (this.kGa) {
      localContentValues.put("Title_hk", this.field_Title_hk);
    }
    if (this.kGb) {
      localContentValues.put("Title_tw", this.field_Title_tw);
    }
    if (this.kGc) {
      localContentValues.put("Title_en", this.field_Title_en);
    }
    if (this.kGd) {
      localContentValues.put("Desc_cn", this.field_Desc_cn);
    }
    if (this.kGe) {
      localContentValues.put("Desc_hk", this.field_Desc_hk);
    }
    if (this.kGf) {
      localContentValues.put("Desc_tw", this.field_Desc_tw);
    }
    if (this.kGg) {
      localContentValues.put("Desc_en", this.field_Desc_en);
    }
    if (this.kGh) {
      localContentValues.put("Introduce_cn", this.field_Introduce_cn);
    }
    if (this.kGi) {
      localContentValues.put("Introduce_hk", this.field_Introduce_hk);
    }
    if (this.kGj) {
      localContentValues.put("Introduce_tw", this.field_Introduce_tw);
    }
    if (this.kGk) {
      localContentValues.put("Introduce_en", this.field_Introduce_en);
    }
    if (this.kGl) {
      localContentValues.put("starttime", Long.valueOf(this.field_starttime));
    }
    if (this.kGm) {
      localContentValues.put("endtime", Long.valueOf(this.field_endtime));
    }
    if (this.jIP) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.jIQ) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.kGn) {
      localContentValues.put("ThumbUrl_cn", this.field_ThumbUrl_cn);
    }
    if (this.kGo) {
      localContentValues.put("ThumbUrl_hk", this.field_ThumbUrl_hk);
    }
    if (this.kGp) {
      localContentValues.put("ThumbUrl_tw", this.field_ThumbUrl_tw);
    }
    if (this.kGq) {
      localContentValues.put("ThumbUrl_en", this.field_ThumbUrl_en);
    }
    if (this.kGr) {
      localContentValues.put("ImgUrl_android_cn", this.field_ImgUrl_android_cn);
    }
    if (this.kGs) {
      localContentValues.put("ImgUrl_android_hk", this.field_ImgUrl_android_hk);
    }
    if (this.kGt) {
      localContentValues.put("ImgUrl_android_tw", this.field_ImgUrl_android_tw);
    }
    if (this.kGu) {
      localContentValues.put("ImgUrl_android_en", this.field_ImgUrl_android_en);
    }
    if (this.kGv) {
      localContentValues.put("RedPoint", Integer.valueOf(this.field_RedPoint));
    }
    if (this.kGw) {
      localContentValues.put("WeAppDebugMode", Integer.valueOf(this.field_WeAppDebugMode));
    }
    if (this.kGx) {
      localContentValues.put("idkey", Integer.valueOf(this.field_idkey));
    }
    if (this.kGy) {
      localContentValues.put("idkeyValue", Integer.valueOf(this.field_idkeyValue));
    }
    if (this.kGz) {
      localContentValues.put("Icon", this.field_Icon);
    }
    if (this.kGA) {
      localContentValues.put("ImgUrl_cn", this.field_ImgUrl_cn);
    }
    if (this.kGB) {
      localContentValues.put("ImgUrl_hk", this.field_ImgUrl_hk);
    }
    if (this.kGC) {
      localContentValues.put("ImgUrl_tw", this.field_ImgUrl_tw);
    }
    if (this.kGD) {
      localContentValues.put("ImgUrl_en", this.field_ImgUrl_en);
    }
    if (this.kGE) {
      localContentValues.put("bItemFromXExpt", Integer.valueOf(this.field_bItemFromXExpt));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends eu> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_LabsAppId;
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.b.eu
 * JD-Core Version:    0.7.0.1
 */