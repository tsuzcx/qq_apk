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

public abstract class ig
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WalletBankcard");
  public static final Column kID;
  private static final int kIP;
  private static final int kgA;
  public static final Column kgs;
  public static final Column lfA;
  public static final Column lfB;
  public static final Column lfC;
  public static final Column lfD;
  public static final Column lfE;
  public static final Column lfF;
  public static final Column lfG;
  public static final Column lfH;
  public static final Column lfI;
  public static final Column lfJ;
  public static final Column lfK;
  public static final Column lfL;
  public static final Column lfM;
  public static final Column lfN;
  public static final Column lfO;
  public static final Column lfP;
  public static final Column lfa;
  public static final Column lfb;
  public static final Column lfc;
  public static final Column lfd;
  public static final Column lfe;
  public static final Column lff;
  public static final Column lfg;
  public static final Column lfh;
  public static final Column lfi;
  public static final Column lfj;
  public static final Column lfk;
  public static final Column lfl;
  public static final Column lfm;
  public static final Column lfn;
  public static final Column lfo;
  public static final Column lfp;
  public static final Column lfq;
  public static final Column lfr;
  public static final Column lfs;
  public static final Column lft;
  public static final Column lfu;
  public static final Column lfv;
  public static final Column lfw;
  public static final Column lfx;
  public static final Column lfy;
  public static final Column lfz;
  private static final int lgG;
  private static final int lgH;
  private static final int lgI;
  private static final int lgJ;
  private static final int lgK;
  private static final int lgL;
  private static final int lgM;
  private static final int lgN;
  private static final int lgO;
  private static final int lgP;
  private static final int lgQ;
  private static final int lgR;
  private static final int lgS;
  private static final int lgT;
  private static final int lgU;
  private static final int lgV;
  private static final int lgW;
  private static final int lgX;
  private static final int lgY;
  private static final int lgZ;
  private static final int lha;
  private static final int lhb;
  private static final int lhc;
  private static final int lhd;
  private static final int lhe;
  private static final int lhf;
  private static final int lhg;
  private static final int lhh;
  private static final int lhi;
  private static final int lhj;
  private static final int lhk;
  private static final int lhl;
  private static final int lhm;
  private static final int lhn;
  private static final int lho;
  private static final int lhp;
  private static final int lhq;
  private static final int lhr;
  private static final int lhs;
  private static final int lht;
  private static final int lhu;
  private static final int lhv;
  private static final StorageObserverOwner<ig> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_arrive_type;
  public String field_avail_save_wording;
  public String field_bankName;
  public String field_bankPhone;
  public int field_bankcardClientType;
  public int field_bankcardState;
  public int field_bankcardTag;
  public String field_bankcardTail;
  public String field_bankcardType;
  public String field_bankcardTypeName;
  public String field_bindSerial;
  public String field_bizUsername;
  public int field_cardType;
  public String field_card_bottom_wording;
  public String field_card_state_name;
  public double field_dayQuotaKind;
  public double field_dayQuotaVirtual;
  public int field_defaultCardState;
  public String field_desc;
  public String field_ext_msg;
  public long field_fetchArriveTime;
  public String field_fetchArriveTimeWording;
  public String field_fetch_charge_info;
  public double field_fetch_charge_rate;
  public String field_forbidWord;
  public String field_forbid_title;
  public String field_forbid_url;
  public double field_full_fetch_charge_fee;
  public int field_is_hightlight_pre_arrive_time_wording;
  public String field_mobile;
  public String field_no_micro_word;
  public double field_onceQuotaKind;
  public double field_onceQuotaVirtual;
  public String field_prompt_info_jump_text;
  public String field_prompt_info_jump_url;
  public String field_prompt_info_prompt_text;
  public String field_repay_url;
  public int field_supportTag;
  public int field_support_lqt_turn_in;
  public int field_support_lqt_turn_out;
  public boolean field_support_micropay;
  public String field_tips;
  public String field_trueName;
  public int field_wxcreditState;
  private boolean kIJ = true;
  private boolean kgw = true;
  private boolean lfQ = true;
  private boolean lfR = true;
  private boolean lfS = true;
  private boolean lfT = true;
  private boolean lfU = true;
  private boolean lfV = true;
  private boolean lfW = true;
  private boolean lfX = true;
  private boolean lfY = true;
  private boolean lfZ = true;
  private boolean lgA = true;
  private boolean lgB = true;
  private boolean lgC = true;
  private boolean lgD = true;
  private boolean lgE = true;
  private boolean lgF = true;
  private boolean lga = true;
  private boolean lgb = true;
  private boolean lgc = true;
  private boolean lgd = true;
  private boolean lge = true;
  private boolean lgf = true;
  private boolean lgg = true;
  private boolean lgh = true;
  private boolean lgi = true;
  private boolean lgj = true;
  private boolean lgk = true;
  private boolean lgl = true;
  private boolean lgm = true;
  private boolean lgn = true;
  private boolean lgo = true;
  private boolean lgp = true;
  private boolean lgq = true;
  private boolean lgr = true;
  private boolean lgs = true;
  private boolean lgt = true;
  private boolean lgu = true;
  private boolean lgv = true;
  private boolean lgw = true;
  private boolean lgx = true;
  private boolean lgy = true;
  private boolean lgz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    lfa = new Column("bindSerial", "string", TABLE.getName(), "");
    lfb = new Column("defaultCardState", "int", TABLE.getName(), "");
    lfc = new Column("cardType", "int", TABLE.getName(), "");
    lfd = new Column("bankcardState", "int", TABLE.getName(), "");
    lfe = new Column("forbidWord", "string", TABLE.getName(), "");
    lff = new Column("bankName", "string", TABLE.getName(), "");
    lfg = new Column("bankcardType", "string", TABLE.getName(), "");
    lfh = new Column("bankcardTypeName", "string", TABLE.getName(), "");
    lfi = new Column("bankcardTag", "int", TABLE.getName(), "");
    lfj = new Column("bankcardTail", "string", TABLE.getName(), "");
    lfk = new Column("supportTag", "int", TABLE.getName(), "");
    lfl = new Column("mobile", "string", TABLE.getName(), "");
    lfm = new Column("trueName", "string", TABLE.getName(), "");
    kgs = new Column("desc", "string", TABLE.getName(), "");
    lfn = new Column("bankPhone", "string", TABLE.getName(), "");
    lfo = new Column("bizUsername", "string", TABLE.getName(), "");
    lfp = new Column("onceQuotaKind", "double", TABLE.getName(), "");
    lfq = new Column("onceQuotaVirtual", "double", TABLE.getName(), "");
    lfr = new Column("dayQuotaKind", "double", TABLE.getName(), "");
    lfs = new Column("dayQuotaVirtual", "double", TABLE.getName(), "");
    lft = new Column("fetchArriveTime", "long", TABLE.getName(), "");
    lfu = new Column("fetchArriveTimeWording", "string", TABLE.getName(), "");
    lfv = new Column("repay_url", "string", TABLE.getName(), "");
    lfw = new Column("wxcreditState", "int", TABLE.getName(), "");
    lfx = new Column("bankcardClientType", "int", TABLE.getName(), "");
    lfy = new Column("ext_msg", "string", TABLE.getName(), "");
    lfz = new Column("support_micropay", "boolean", TABLE.getName(), "");
    lfA = new Column("arrive_type", "string", TABLE.getName(), "");
    lfB = new Column("avail_save_wording", "string", TABLE.getName(), "");
    lfC = new Column("fetch_charge_rate", "double", TABLE.getName(), "");
    lfD = new Column("full_fetch_charge_fee", "double", TABLE.getName(), "");
    lfE = new Column("fetch_charge_info", "string", TABLE.getName(), "");
    kID = new Column("tips", "string", TABLE.getName(), "");
    lfF = new Column("forbid_title", "string", TABLE.getName(), "");
    lfG = new Column("forbid_url", "string", TABLE.getName(), "");
    lfH = new Column("no_micro_word", "string", TABLE.getName(), "");
    lfI = new Column("card_bottom_wording", "string", TABLE.getName(), "");
    lfJ = new Column("support_lqt_turn_in", "int", TABLE.getName(), "");
    lfK = new Column("support_lqt_turn_out", "int", TABLE.getName(), "");
    lfL = new Column("is_hightlight_pre_arrive_time_wording", "int", TABLE.getName(), "");
    lfM = new Column("card_state_name", "string", TABLE.getName(), "");
    lfN = new Column("prompt_info_prompt_text", "string", TABLE.getName(), "");
    lfO = new Column("prompt_info_jump_text", "string", TABLE.getName(), "");
    lfP = new Column("prompt_info_jump_url", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    lgG = "bindSerial".hashCode();
    lgH = "defaultCardState".hashCode();
    lgI = "cardType".hashCode();
    lgJ = "bankcardState".hashCode();
    lgK = "forbidWord".hashCode();
    lgL = "bankName".hashCode();
    lgM = "bankcardType".hashCode();
    lgN = "bankcardTypeName".hashCode();
    lgO = "bankcardTag".hashCode();
    lgP = "bankcardTail".hashCode();
    lgQ = "supportTag".hashCode();
    lgR = "mobile".hashCode();
    lgS = "trueName".hashCode();
    kgA = "desc".hashCode();
    lgT = "bankPhone".hashCode();
    lgU = "bizUsername".hashCode();
    lgV = "onceQuotaKind".hashCode();
    lgW = "onceQuotaVirtual".hashCode();
    lgX = "dayQuotaKind".hashCode();
    lgY = "dayQuotaVirtual".hashCode();
    lgZ = "fetchArriveTime".hashCode();
    lha = "fetchArriveTimeWording".hashCode();
    lhb = "repay_url".hashCode();
    lhc = "wxcreditState".hashCode();
    lhd = "bankcardClientType".hashCode();
    lhe = "ext_msg".hashCode();
    lhf = "support_micropay".hashCode();
    lhg = "arrive_type".hashCode();
    lhh = "avail_save_wording".hashCode();
    lhi = "fetch_charge_rate".hashCode();
    lhj = "full_fetch_charge_fee".hashCode();
    lhk = "fetch_charge_info".hashCode();
    kIP = "tips".hashCode();
    lhl = "forbid_title".hashCode();
    lhm = "forbid_url".hashCode();
    lhn = "no_micro_word".hashCode();
    lho = "card_bottom_wording".hashCode();
    lhp = "support_lqt_turn_in".hashCode();
    lhq = "support_lqt_turn_out".hashCode();
    lhr = "is_hightlight_pre_arrive_time_wording".hashCode();
    lhs = "card_state_name".hashCode();
    lht = "prompt_info_prompt_text".hashCode();
    lhu = "prompt_info_jump_text".hashCode();
    lhv = "prompt_info_jump_url".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[44];
    localMAutoDBInfo.columns = new String[45];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "bindSerial";
    localMAutoDBInfo.colsMap.put("bindSerial", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" bindSerial TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "bindSerial";
    localMAutoDBInfo.columns[1] = "defaultCardState";
    localMAutoDBInfo.colsMap.put("defaultCardState", "INTEGER");
    localStringBuilder.append(" defaultCardState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "cardType";
    localMAutoDBInfo.colsMap.put("cardType", "INTEGER");
    localStringBuilder.append(" cardType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "bankcardState";
    localMAutoDBInfo.colsMap.put("bankcardState", "INTEGER");
    localStringBuilder.append(" bankcardState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "forbidWord";
    localMAutoDBInfo.colsMap.put("forbidWord", "TEXT");
    localStringBuilder.append(" forbidWord TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "bankName";
    localMAutoDBInfo.colsMap.put("bankName", "TEXT");
    localStringBuilder.append(" bankName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "bankcardType";
    localMAutoDBInfo.colsMap.put("bankcardType", "TEXT");
    localStringBuilder.append(" bankcardType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "bankcardTypeName";
    localMAutoDBInfo.colsMap.put("bankcardTypeName", "TEXT");
    localStringBuilder.append(" bankcardTypeName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "bankcardTag";
    localMAutoDBInfo.colsMap.put("bankcardTag", "INTEGER");
    localStringBuilder.append(" bankcardTag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "bankcardTail";
    localMAutoDBInfo.colsMap.put("bankcardTail", "TEXT");
    localStringBuilder.append(" bankcardTail TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "supportTag";
    localMAutoDBInfo.colsMap.put("supportTag", "INTEGER");
    localStringBuilder.append(" supportTag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "mobile";
    localMAutoDBInfo.colsMap.put("mobile", "TEXT");
    localStringBuilder.append(" mobile TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "trueName";
    localMAutoDBInfo.colsMap.put("trueName", "TEXT");
    localStringBuilder.append(" trueName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "desc";
    localMAutoDBInfo.colsMap.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "bankPhone";
    localMAutoDBInfo.colsMap.put("bankPhone", "TEXT");
    localStringBuilder.append(" bankPhone TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "bizUsername";
    localMAutoDBInfo.colsMap.put("bizUsername", "TEXT");
    localStringBuilder.append(" bizUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "onceQuotaKind";
    localMAutoDBInfo.colsMap.put("onceQuotaKind", "DOUBLE");
    localStringBuilder.append(" onceQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "onceQuotaVirtual";
    localMAutoDBInfo.colsMap.put("onceQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" onceQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "dayQuotaKind";
    localMAutoDBInfo.colsMap.put("dayQuotaKind", "DOUBLE");
    localStringBuilder.append(" dayQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "dayQuotaVirtual";
    localMAutoDBInfo.colsMap.put("dayQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" dayQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "fetchArriveTime";
    localMAutoDBInfo.colsMap.put("fetchArriveTime", "LONG");
    localStringBuilder.append(" fetchArriveTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "fetchArriveTimeWording";
    localMAutoDBInfo.colsMap.put("fetchArriveTimeWording", "TEXT");
    localStringBuilder.append(" fetchArriveTimeWording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "repay_url";
    localMAutoDBInfo.colsMap.put("repay_url", "TEXT");
    localStringBuilder.append(" repay_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "wxcreditState";
    localMAutoDBInfo.colsMap.put("wxcreditState", "INTEGER");
    localStringBuilder.append(" wxcreditState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "bankcardClientType";
    localMAutoDBInfo.colsMap.put("bankcardClientType", "INTEGER");
    localStringBuilder.append(" bankcardClientType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "ext_msg";
    localMAutoDBInfo.colsMap.put("ext_msg", "TEXT");
    localStringBuilder.append(" ext_msg TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "support_micropay";
    localMAutoDBInfo.colsMap.put("support_micropay", "INTEGER");
    localStringBuilder.append(" support_micropay INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "arrive_type";
    localMAutoDBInfo.colsMap.put("arrive_type", "TEXT");
    localStringBuilder.append(" arrive_type TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "avail_save_wording";
    localMAutoDBInfo.colsMap.put("avail_save_wording", "TEXT");
    localStringBuilder.append(" avail_save_wording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "fetch_charge_rate";
    localMAutoDBInfo.colsMap.put("fetch_charge_rate", "DOUBLE");
    localStringBuilder.append(" fetch_charge_rate DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "full_fetch_charge_fee";
    localMAutoDBInfo.colsMap.put("full_fetch_charge_fee", "DOUBLE");
    localStringBuilder.append(" full_fetch_charge_fee DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "fetch_charge_info";
    localMAutoDBInfo.colsMap.put("fetch_charge_info", "TEXT");
    localStringBuilder.append(" fetch_charge_info TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "tips";
    localMAutoDBInfo.colsMap.put("tips", "TEXT");
    localStringBuilder.append(" tips TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[33] = "forbid_title";
    localMAutoDBInfo.colsMap.put("forbid_title", "TEXT");
    localStringBuilder.append(" forbid_title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[34] = "forbid_url";
    localMAutoDBInfo.colsMap.put("forbid_url", "TEXT");
    localStringBuilder.append(" forbid_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[35] = "no_micro_word";
    localMAutoDBInfo.colsMap.put("no_micro_word", "TEXT");
    localStringBuilder.append(" no_micro_word TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[36] = "card_bottom_wording";
    localMAutoDBInfo.colsMap.put("card_bottom_wording", "TEXT");
    localStringBuilder.append(" card_bottom_wording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[37] = "support_lqt_turn_in";
    localMAutoDBInfo.colsMap.put("support_lqt_turn_in", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_in INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[38] = "support_lqt_turn_out";
    localMAutoDBInfo.colsMap.put("support_lqt_turn_out", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_out INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[39] = "is_hightlight_pre_arrive_time_wording";
    localMAutoDBInfo.colsMap.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
    localStringBuilder.append(" is_hightlight_pre_arrive_time_wording INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[40] = "card_state_name";
    localMAutoDBInfo.colsMap.put("card_state_name", "TEXT");
    localStringBuilder.append(" card_state_name TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[41] = "prompt_info_prompt_text";
    localMAutoDBInfo.colsMap.put("prompt_info_prompt_text", "TEXT");
    localStringBuilder.append(" prompt_info_prompt_text TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[42] = "prompt_info_jump_text";
    localMAutoDBInfo.colsMap.put("prompt_info_jump_text", "TEXT");
    localStringBuilder.append(" prompt_info_jump_text TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[43] = "prompt_info_jump_url";
    localMAutoDBInfo.colsMap.put("prompt_info_jump_url", "TEXT");
    localStringBuilder.append(" prompt_info_jump_url TEXT");
    localMAutoDBInfo.columns[44] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("bindSerial"))
    {
      this.field_bindSerial = paramContentValues.getAsString("bindSerial");
      if (paramBoolean) {
        this.lfQ = true;
      }
    }
    if (paramContentValues.containsKey("defaultCardState"))
    {
      this.field_defaultCardState = paramContentValues.getAsInteger("defaultCardState").intValue();
      if (paramBoolean) {
        this.lfR = true;
      }
    }
    if (paramContentValues.containsKey("cardType"))
    {
      this.field_cardType = paramContentValues.getAsInteger("cardType").intValue();
      if (paramBoolean) {
        this.lfS = true;
      }
    }
    if (paramContentValues.containsKey("bankcardState"))
    {
      this.field_bankcardState = paramContentValues.getAsInteger("bankcardState").intValue();
      if (paramBoolean) {
        this.lfT = true;
      }
    }
    if (paramContentValues.containsKey("forbidWord"))
    {
      this.field_forbidWord = paramContentValues.getAsString("forbidWord");
      if (paramBoolean) {
        this.lfU = true;
      }
    }
    if (paramContentValues.containsKey("bankName"))
    {
      this.field_bankName = paramContentValues.getAsString("bankName");
      if (paramBoolean) {
        this.lfV = true;
      }
    }
    if (paramContentValues.containsKey("bankcardType"))
    {
      this.field_bankcardType = paramContentValues.getAsString("bankcardType");
      if (paramBoolean) {
        this.lfW = true;
      }
    }
    if (paramContentValues.containsKey("bankcardTypeName"))
    {
      this.field_bankcardTypeName = paramContentValues.getAsString("bankcardTypeName");
      if (paramBoolean) {
        this.lfX = true;
      }
    }
    if (paramContentValues.containsKey("bankcardTag"))
    {
      this.field_bankcardTag = paramContentValues.getAsInteger("bankcardTag").intValue();
      if (paramBoolean) {
        this.lfY = true;
      }
    }
    if (paramContentValues.containsKey("bankcardTail"))
    {
      this.field_bankcardTail = paramContentValues.getAsString("bankcardTail");
      if (paramBoolean) {
        this.lfZ = true;
      }
    }
    if (paramContentValues.containsKey("supportTag"))
    {
      this.field_supportTag = paramContentValues.getAsInteger("supportTag").intValue();
      if (paramBoolean) {
        this.lga = true;
      }
    }
    if (paramContentValues.containsKey("mobile"))
    {
      this.field_mobile = paramContentValues.getAsString("mobile");
      if (paramBoolean) {
        this.lgb = true;
      }
    }
    if (paramContentValues.containsKey("trueName"))
    {
      this.field_trueName = paramContentValues.getAsString("trueName");
      if (paramBoolean) {
        this.lgc = true;
      }
    }
    if (paramContentValues.containsKey("desc"))
    {
      this.field_desc = paramContentValues.getAsString("desc");
      if (paramBoolean) {
        this.kgw = true;
      }
    }
    if (paramContentValues.containsKey("bankPhone"))
    {
      this.field_bankPhone = paramContentValues.getAsString("bankPhone");
      if (paramBoolean) {
        this.lgd = true;
      }
    }
    if (paramContentValues.containsKey("bizUsername"))
    {
      this.field_bizUsername = paramContentValues.getAsString("bizUsername");
      if (paramBoolean) {
        this.lge = true;
      }
    }
    if (paramContentValues.containsKey("onceQuotaKind"))
    {
      this.field_onceQuotaKind = paramContentValues.getAsDouble("onceQuotaKind").doubleValue();
      if (paramBoolean) {
        this.lgf = true;
      }
    }
    if (paramContentValues.containsKey("onceQuotaVirtual"))
    {
      this.field_onceQuotaVirtual = paramContentValues.getAsDouble("onceQuotaVirtual").doubleValue();
      if (paramBoolean) {
        this.lgg = true;
      }
    }
    if (paramContentValues.containsKey("dayQuotaKind"))
    {
      this.field_dayQuotaKind = paramContentValues.getAsDouble("dayQuotaKind").doubleValue();
      if (paramBoolean) {
        this.lgh = true;
      }
    }
    if (paramContentValues.containsKey("dayQuotaVirtual"))
    {
      this.field_dayQuotaVirtual = paramContentValues.getAsDouble("dayQuotaVirtual").doubleValue();
      if (paramBoolean) {
        this.lgi = true;
      }
    }
    if (paramContentValues.containsKey("fetchArriveTime"))
    {
      this.field_fetchArriveTime = paramContentValues.getAsLong("fetchArriveTime").longValue();
      if (paramBoolean) {
        this.lgj = true;
      }
    }
    if (paramContentValues.containsKey("fetchArriveTimeWording"))
    {
      this.field_fetchArriveTimeWording = paramContentValues.getAsString("fetchArriveTimeWording");
      if (paramBoolean) {
        this.lgk = true;
      }
    }
    if (paramContentValues.containsKey("repay_url"))
    {
      this.field_repay_url = paramContentValues.getAsString("repay_url");
      if (paramBoolean) {
        this.lgl = true;
      }
    }
    if (paramContentValues.containsKey("wxcreditState"))
    {
      this.field_wxcreditState = paramContentValues.getAsInteger("wxcreditState").intValue();
      if (paramBoolean) {
        this.lgm = true;
      }
    }
    if (paramContentValues.containsKey("bankcardClientType"))
    {
      this.field_bankcardClientType = paramContentValues.getAsInteger("bankcardClientType").intValue();
      if (paramBoolean) {
        this.lgn = true;
      }
    }
    if (paramContentValues.containsKey("ext_msg"))
    {
      this.field_ext_msg = paramContentValues.getAsString("ext_msg");
      if (paramBoolean) {
        this.lgo = true;
      }
    }
    if (paramContentValues.containsKey("support_micropay")) {
      if (paramContentValues.getAsInteger("support_micropay").intValue() == 0) {
        break label1391;
      }
    }
    label1391:
    for (boolean bool = true;; bool = false)
    {
      this.field_support_micropay = bool;
      if (paramBoolean) {
        this.lgp = true;
      }
      if (paramContentValues.containsKey("arrive_type"))
      {
        this.field_arrive_type = paramContentValues.getAsString("arrive_type");
        if (paramBoolean) {
          this.lgq = true;
        }
      }
      if (paramContentValues.containsKey("avail_save_wording"))
      {
        this.field_avail_save_wording = paramContentValues.getAsString("avail_save_wording");
        if (paramBoolean) {
          this.lgr = true;
        }
      }
      if (paramContentValues.containsKey("fetch_charge_rate"))
      {
        this.field_fetch_charge_rate = paramContentValues.getAsDouble("fetch_charge_rate").doubleValue();
        if (paramBoolean) {
          this.lgs = true;
        }
      }
      if (paramContentValues.containsKey("full_fetch_charge_fee"))
      {
        this.field_full_fetch_charge_fee = paramContentValues.getAsDouble("full_fetch_charge_fee").doubleValue();
        if (paramBoolean) {
          this.lgt = true;
        }
      }
      if (paramContentValues.containsKey("fetch_charge_info"))
      {
        this.field_fetch_charge_info = paramContentValues.getAsString("fetch_charge_info");
        if (paramBoolean) {
          this.lgu = true;
        }
      }
      if (paramContentValues.containsKey("tips"))
      {
        this.field_tips = paramContentValues.getAsString("tips");
        if (paramBoolean) {
          this.kIJ = true;
        }
      }
      if (paramContentValues.containsKey("forbid_title"))
      {
        this.field_forbid_title = paramContentValues.getAsString("forbid_title");
        if (paramBoolean) {
          this.lgv = true;
        }
      }
      if (paramContentValues.containsKey("forbid_url"))
      {
        this.field_forbid_url = paramContentValues.getAsString("forbid_url");
        if (paramBoolean) {
          this.lgw = true;
        }
      }
      if (paramContentValues.containsKey("no_micro_word"))
      {
        this.field_no_micro_word = paramContentValues.getAsString("no_micro_word");
        if (paramBoolean) {
          this.lgx = true;
        }
      }
      if (paramContentValues.containsKey("card_bottom_wording"))
      {
        this.field_card_bottom_wording = paramContentValues.getAsString("card_bottom_wording");
        if (paramBoolean) {
          this.lgy = true;
        }
      }
      if (paramContentValues.containsKey("support_lqt_turn_in"))
      {
        this.field_support_lqt_turn_in = paramContentValues.getAsInteger("support_lqt_turn_in").intValue();
        if (paramBoolean) {
          this.lgz = true;
        }
      }
      if (paramContentValues.containsKey("support_lqt_turn_out"))
      {
        this.field_support_lqt_turn_out = paramContentValues.getAsInteger("support_lqt_turn_out").intValue();
        if (paramBoolean) {
          this.lgA = true;
        }
      }
      if (paramContentValues.containsKey("is_hightlight_pre_arrive_time_wording"))
      {
        this.field_is_hightlight_pre_arrive_time_wording = paramContentValues.getAsInteger("is_hightlight_pre_arrive_time_wording").intValue();
        if (paramBoolean) {
          this.lgB = true;
        }
      }
      if (paramContentValues.containsKey("card_state_name"))
      {
        this.field_card_state_name = paramContentValues.getAsString("card_state_name");
        if (paramBoolean) {
          this.lgC = true;
        }
      }
      if (paramContentValues.containsKey("prompt_info_prompt_text"))
      {
        this.field_prompt_info_prompt_text = paramContentValues.getAsString("prompt_info_prompt_text");
        if (paramBoolean) {
          this.lgD = true;
        }
      }
      if (paramContentValues.containsKey("prompt_info_jump_text"))
      {
        this.field_prompt_info_jump_text = paramContentValues.getAsString("prompt_info_jump_text");
        if (paramBoolean) {
          this.lgE = true;
        }
      }
      if (paramContentValues.containsKey("prompt_info_jump_url"))
      {
        this.field_prompt_info_jump_url = paramContentValues.getAsString("prompt_info_jump_url");
        if (paramBoolean) {
          this.lgF = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (lgG != k) {
        break label65;
      }
      this.field_bindSerial = paramCursor.getString(i);
      this.lfQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (lgH == k)
      {
        this.field_defaultCardState = paramCursor.getInt(i);
      }
      else if (lgI == k)
      {
        this.field_cardType = paramCursor.getInt(i);
      }
      else if (lgJ == k)
      {
        this.field_bankcardState = paramCursor.getInt(i);
      }
      else if (lgK == k)
      {
        this.field_forbidWord = paramCursor.getString(i);
      }
      else if (lgL == k)
      {
        this.field_bankName = paramCursor.getString(i);
      }
      else if (lgM == k)
      {
        this.field_bankcardType = paramCursor.getString(i);
      }
      else if (lgN == k)
      {
        this.field_bankcardTypeName = paramCursor.getString(i);
      }
      else if (lgO == k)
      {
        this.field_bankcardTag = paramCursor.getInt(i);
      }
      else if (lgP == k)
      {
        this.field_bankcardTail = paramCursor.getString(i);
      }
      else if (lgQ == k)
      {
        this.field_supportTag = paramCursor.getInt(i);
      }
      else if (lgR == k)
      {
        this.field_mobile = paramCursor.getString(i);
      }
      else if (lgS == k)
      {
        this.field_trueName = paramCursor.getString(i);
      }
      else if (kgA == k)
      {
        this.field_desc = paramCursor.getString(i);
      }
      else if (lgT == k)
      {
        this.field_bankPhone = paramCursor.getString(i);
      }
      else if (lgU == k)
      {
        this.field_bizUsername = paramCursor.getString(i);
      }
      else if (lgV == k)
      {
        this.field_onceQuotaKind = paramCursor.getDouble(i);
      }
      else if (lgW == k)
      {
        this.field_onceQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (lgX == k)
      {
        this.field_dayQuotaKind = paramCursor.getDouble(i);
      }
      else if (lgY == k)
      {
        this.field_dayQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (lgZ == k)
      {
        this.field_fetchArriveTime = paramCursor.getLong(i);
      }
      else if (lha == k)
      {
        this.field_fetchArriveTimeWording = paramCursor.getString(i);
      }
      else if (lhb == k)
      {
        this.field_repay_url = paramCursor.getString(i);
      }
      else if (lhc == k)
      {
        this.field_wxcreditState = paramCursor.getInt(i);
      }
      else if (lhd == k)
      {
        this.field_bankcardClientType = paramCursor.getInt(i);
      }
      else if (lhe == k)
      {
        this.field_ext_msg = paramCursor.getString(i);
      }
      else
      {
        if (lhf == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_support_micropay = bool;
            break;
          }
        }
        if (lhg == k) {
          this.field_arrive_type = paramCursor.getString(i);
        } else if (lhh == k) {
          this.field_avail_save_wording = paramCursor.getString(i);
        } else if (lhi == k) {
          this.field_fetch_charge_rate = paramCursor.getDouble(i);
        } else if (lhj == k) {
          this.field_full_fetch_charge_fee = paramCursor.getDouble(i);
        } else if (lhk == k) {
          this.field_fetch_charge_info = paramCursor.getString(i);
        } else if (kIP == k) {
          this.field_tips = paramCursor.getString(i);
        } else if (lhl == k) {
          this.field_forbid_title = paramCursor.getString(i);
        } else if (lhm == k) {
          this.field_forbid_url = paramCursor.getString(i);
        } else if (lhn == k) {
          this.field_no_micro_word = paramCursor.getString(i);
        } else if (lho == k) {
          this.field_card_bottom_wording = paramCursor.getString(i);
        } else if (lhp == k) {
          this.field_support_lqt_turn_in = paramCursor.getInt(i);
        } else if (lhq == k) {
          this.field_support_lqt_turn_out = paramCursor.getInt(i);
        } else if (lhr == k) {
          this.field_is_hightlight_pre_arrive_time_wording = paramCursor.getInt(i);
        } else if (lhs == k) {
          this.field_card_state_name = paramCursor.getString(i);
        } else if (lht == k) {
          this.field_prompt_info_prompt_text = paramCursor.getString(i);
        } else if (lhu == k) {
          this.field_prompt_info_jump_text = paramCursor.getString(i);
        } else if (lhv == k) {
          this.field_prompt_info_jump_url = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.lfQ) {
      localContentValues.put("bindSerial", this.field_bindSerial);
    }
    if (this.lfR) {
      localContentValues.put("defaultCardState", Integer.valueOf(this.field_defaultCardState));
    }
    if (this.lfS) {
      localContentValues.put("cardType", Integer.valueOf(this.field_cardType));
    }
    if (this.lfT) {
      localContentValues.put("bankcardState", Integer.valueOf(this.field_bankcardState));
    }
    if (this.lfU) {
      localContentValues.put("forbidWord", this.field_forbidWord);
    }
    if (this.lfV) {
      localContentValues.put("bankName", this.field_bankName);
    }
    if (this.lfW) {
      localContentValues.put("bankcardType", this.field_bankcardType);
    }
    if (this.lfX) {
      localContentValues.put("bankcardTypeName", this.field_bankcardTypeName);
    }
    if (this.lfY) {
      localContentValues.put("bankcardTag", Integer.valueOf(this.field_bankcardTag));
    }
    if (this.lfZ) {
      localContentValues.put("bankcardTail", this.field_bankcardTail);
    }
    if (this.lga) {
      localContentValues.put("supportTag", Integer.valueOf(this.field_supportTag));
    }
    if (this.lgb) {
      localContentValues.put("mobile", this.field_mobile);
    }
    if (this.lgc) {
      localContentValues.put("trueName", this.field_trueName);
    }
    if (this.kgw) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.lgd) {
      localContentValues.put("bankPhone", this.field_bankPhone);
    }
    if (this.lge) {
      localContentValues.put("bizUsername", this.field_bizUsername);
    }
    if (this.lgf) {
      localContentValues.put("onceQuotaKind", Double.valueOf(this.field_onceQuotaKind));
    }
    if (this.lgg) {
      localContentValues.put("onceQuotaVirtual", Double.valueOf(this.field_onceQuotaVirtual));
    }
    if (this.lgh) {
      localContentValues.put("dayQuotaKind", Double.valueOf(this.field_dayQuotaKind));
    }
    if (this.lgi) {
      localContentValues.put("dayQuotaVirtual", Double.valueOf(this.field_dayQuotaVirtual));
    }
    if (this.lgj) {
      localContentValues.put("fetchArriveTime", Long.valueOf(this.field_fetchArriveTime));
    }
    if (this.lgk) {
      localContentValues.put("fetchArriveTimeWording", this.field_fetchArriveTimeWording);
    }
    if (this.lgl) {
      localContentValues.put("repay_url", this.field_repay_url);
    }
    if (this.lgm) {
      localContentValues.put("wxcreditState", Integer.valueOf(this.field_wxcreditState));
    }
    if (this.lgn) {
      localContentValues.put("bankcardClientType", Integer.valueOf(this.field_bankcardClientType));
    }
    if (this.lgo) {
      localContentValues.put("ext_msg", this.field_ext_msg);
    }
    if (this.lgp) {
      localContentValues.put("support_micropay", Boolean.valueOf(this.field_support_micropay));
    }
    if (this.lgq) {
      localContentValues.put("arrive_type", this.field_arrive_type);
    }
    if (this.lgr) {
      localContentValues.put("avail_save_wording", this.field_avail_save_wording);
    }
    if (this.lgs) {
      localContentValues.put("fetch_charge_rate", Double.valueOf(this.field_fetch_charge_rate));
    }
    if (this.lgt) {
      localContentValues.put("full_fetch_charge_fee", Double.valueOf(this.field_full_fetch_charge_fee));
    }
    if (this.lgu) {
      localContentValues.put("fetch_charge_info", this.field_fetch_charge_info);
    }
    if (this.kIJ) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.lgv) {
      localContentValues.put("forbid_title", this.field_forbid_title);
    }
    if (this.lgw) {
      localContentValues.put("forbid_url", this.field_forbid_url);
    }
    if (this.lgx) {
      localContentValues.put("no_micro_word", this.field_no_micro_word);
    }
    if (this.lgy) {
      localContentValues.put("card_bottom_wording", this.field_card_bottom_wording);
    }
    if (this.lgz) {
      localContentValues.put("support_lqt_turn_in", Integer.valueOf(this.field_support_lqt_turn_in));
    }
    if (this.lgA) {
      localContentValues.put("support_lqt_turn_out", Integer.valueOf(this.field_support_lqt_turn_out));
    }
    if (this.lgB) {
      localContentValues.put("is_hightlight_pre_arrive_time_wording", Integer.valueOf(this.field_is_hightlight_pre_arrive_time_wording));
    }
    if (this.lgC) {
      localContentValues.put("card_state_name", this.field_card_state_name);
    }
    if (this.lgD) {
      localContentValues.put("prompt_info_prompt_text", this.field_prompt_info_prompt_text);
    }
    if (this.lgE) {
      localContentValues.put("prompt_info_jump_text", this.field_prompt_info_jump_text);
    }
    if (this.lgF) {
      localContentValues.put("prompt_info_jump_url", this.field_prompt_info_jump_url);
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
  
  public StorageObserverOwner<? extends ig> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_bindSerial;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.autogen.b.ig
 * JD-Core Version:    0.7.0.1
 */