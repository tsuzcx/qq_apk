package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hk
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WalletBankcard");
  public static final Column hJn;
  private static final int hJv;
  public static final Column iDA;
  public static final Column iDB;
  public static final Column iDC;
  public static final Column iDD;
  public static final Column iDE;
  public static final Column iDF;
  public static final Column iDG;
  public static final Column iDH;
  public static final Column iDI;
  public static final Column iDJ;
  public static final Column iDK;
  public static final Column iDL;
  public static final Column iDM;
  public static final Column iDN;
  public static final Column iDO;
  public static final Column iDP;
  public static final Column iDQ;
  public static final Column iDR;
  public static final Column iDS;
  public static final Column iDT;
  public static final Column iDU;
  public static final Column iDV;
  public static final Column iDW;
  public static final Column iDX;
  public static final Column iDY;
  public static final Column iDZ;
  public static final Column iDy;
  public static final Column iDz;
  public static final Column iEa;
  public static final Column iEb;
  public static final Column iEc;
  public static final Column iEd;
  public static final Column iEe;
  public static final Column iEf;
  public static final Column iEg;
  public static final Column iEh;
  public static final Column iEi;
  public static final Column iEj;
  public static final Column iEk;
  public static final Column iEl;
  public static final Column iEm;
  public static final Column iEn;
  private static final int iFA;
  private static final int iFB;
  private static final int iFC;
  private static final int iFD;
  private static final int iFE;
  private static final int iFF;
  private static final int iFG;
  private static final int iFH;
  private static final int iFI;
  private static final int iFJ = "forbid_title".hashCode();
  private static final int iFK = "forbid_url".hashCode();
  private static final int iFL = "no_micro_word".hashCode();
  private static final int iFM = "card_bottom_wording".hashCode();
  private static final int iFN = "support_lqt_turn_in".hashCode();
  private static final int iFO = "support_lqt_turn_out".hashCode();
  private static final int iFP = "is_hightlight_pre_arrive_time_wording".hashCode();
  private static final int iFQ = "card_state_name".hashCode();
  private static final int iFR = "prompt_info_prompt_text".hashCode();
  private static final int iFS = "prompt_info_jump_text".hashCode();
  private static final int iFT = "prompt_info_jump_url".hashCode();
  private static final int iFe;
  private static final int iFf;
  private static final int iFg;
  private static final int iFh;
  private static final int iFi;
  private static final int iFj;
  private static final int iFk;
  private static final int iFl;
  private static final int iFm;
  private static final int iFn;
  private static final int iFo;
  private static final int iFp;
  private static final int iFq;
  private static final int iFr;
  private static final int iFs;
  private static final int iFt;
  private static final int iFu;
  private static final int iFv;
  private static final int iFw;
  private static final int iFx;
  private static final int iFy;
  private static final int iFz;
  public static final Column ijf;
  private static final int ijr;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean hJr = true;
  private boolean iEA = true;
  private boolean iEB = true;
  private boolean iEC = true;
  private boolean iED = true;
  private boolean iEE = true;
  private boolean iEF = true;
  private boolean iEG = true;
  private boolean iEH = true;
  private boolean iEI = true;
  private boolean iEJ = true;
  private boolean iEK = true;
  private boolean iEL = true;
  private boolean iEM = true;
  private boolean iEN = true;
  private boolean iEO = true;
  private boolean iEP = true;
  private boolean iEQ = true;
  private boolean iER = true;
  private boolean iES = true;
  private boolean iET = true;
  private boolean iEU = true;
  private boolean iEV = true;
  private boolean iEW = true;
  private boolean iEX = true;
  private boolean iEY = true;
  private boolean iEZ = true;
  private boolean iEo = true;
  private boolean iEp = true;
  private boolean iEq = true;
  private boolean iEr = true;
  private boolean iEs = true;
  private boolean iEt = true;
  private boolean iEu = true;
  private boolean iEv = true;
  private boolean iEw = true;
  private boolean iEx = true;
  private boolean iEy = true;
  private boolean iEz = true;
  private boolean iFa = true;
  private boolean iFb = true;
  private boolean iFc = true;
  private boolean iFd = true;
  private boolean ijl = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WalletBankcard", "");
    iDy = new Column("bindserial", "string", "WalletBankcard", "");
    iDz = new Column("defaultcardstate", "int", "WalletBankcard", "");
    iDA = new Column("cardtype", "int", "WalletBankcard", "");
    iDB = new Column("bankcardstate", "int", "WalletBankcard", "");
    iDC = new Column("forbidword", "string", "WalletBankcard", "");
    iDD = new Column("bankname", "string", "WalletBankcard", "");
    iDE = new Column("bankcardtype", "string", "WalletBankcard", "");
    iDF = new Column("bankcardtypename", "string", "WalletBankcard", "");
    iDG = new Column("bankcardtag", "int", "WalletBankcard", "");
    iDH = new Column("bankcardtail", "string", "WalletBankcard", "");
    iDI = new Column("supporttag", "int", "WalletBankcard", "");
    iDJ = new Column("mobile", "string", "WalletBankcard", "");
    iDK = new Column("truename", "string", "WalletBankcard", "");
    hJn = new Column("desc", "string", "WalletBankcard", "");
    iDL = new Column("bankphone", "string", "WalletBankcard", "");
    iDM = new Column("bizusername", "string", "WalletBankcard", "");
    iDN = new Column("oncequotakind", "double", "WalletBankcard", "");
    iDO = new Column("oncequotavirtual", "double", "WalletBankcard", "");
    iDP = new Column("dayquotakind", "double", "WalletBankcard", "");
    iDQ = new Column("dayquotavirtual", "double", "WalletBankcard", "");
    iDR = new Column("fetcharrivetime", "long", "WalletBankcard", "");
    iDS = new Column("fetcharrivetimewording", "string", "WalletBankcard", "");
    iDT = new Column("repay_url", "string", "WalletBankcard", "");
    iDU = new Column("wxcreditstate", "int", "WalletBankcard", "");
    iDV = new Column("bankcardclienttype", "int", "WalletBankcard", "");
    iDW = new Column("ext_msg", "string", "WalletBankcard", "");
    iDX = new Column("support_micropay", "boolean", "WalletBankcard", "");
    iDY = new Column("arrive_type", "string", "WalletBankcard", "");
    iDZ = new Column("avail_save_wording", "string", "WalletBankcard", "");
    iEa = new Column("fetch_charge_rate", "double", "WalletBankcard", "");
    iEb = new Column("full_fetch_charge_fee", "double", "WalletBankcard", "");
    iEc = new Column("fetch_charge_info", "string", "WalletBankcard", "");
    ijf = new Column("tips", "string", "WalletBankcard", "");
    iEd = new Column("forbid_title", "string", "WalletBankcard", "");
    iEe = new Column("forbid_url", "string", "WalletBankcard", "");
    iEf = new Column("no_micro_word", "string", "WalletBankcard", "");
    iEg = new Column("card_bottom_wording", "string", "WalletBankcard", "");
    iEh = new Column("support_lqt_turn_in", "int", "WalletBankcard", "");
    iEi = new Column("support_lqt_turn_out", "int", "WalletBankcard", "");
    iEj = new Column("is_hightlight_pre_arrive_time_wording", "int", "WalletBankcard", "");
    iEk = new Column("card_state_name", "string", "WalletBankcard", "");
    iEl = new Column("prompt_info_prompt_text", "string", "WalletBankcard", "");
    iEm = new Column("prompt_info_jump_text", "string", "WalletBankcard", "");
    iEn = new Column("prompt_info_jump_url", "string", "WalletBankcard", "");
    iFe = "bindSerial".hashCode();
    iFf = "defaultCardState".hashCode();
    iFg = "cardType".hashCode();
    iFh = "bankcardState".hashCode();
    iFi = "forbidWord".hashCode();
    iFj = "bankName".hashCode();
    iFk = "bankcardType".hashCode();
    iFl = "bankcardTypeName".hashCode();
    iFm = "bankcardTag".hashCode();
    iFn = "bankcardTail".hashCode();
    iFo = "supportTag".hashCode();
    iFp = "mobile".hashCode();
    iFq = "trueName".hashCode();
    hJv = "desc".hashCode();
    iFr = "bankPhone".hashCode();
    iFs = "bizUsername".hashCode();
    iFt = "onceQuotaKind".hashCode();
    iFu = "onceQuotaVirtual".hashCode();
    iFv = "dayQuotaKind".hashCode();
    iFw = "dayQuotaVirtual".hashCode();
    iFx = "fetchArriveTime".hashCode();
    iFy = "fetchArriveTimeWording".hashCode();
    iFz = "repay_url".hashCode();
    iFA = "wxcreditState".hashCode();
    iFB = "bankcardClientType".hashCode();
    iFC = "ext_msg".hashCode();
    iFD = "support_micropay".hashCode();
    iFE = "arrive_type".hashCode();
    iFF = "avail_save_wording".hashCode();
    iFG = "fetch_charge_rate".hashCode();
    iFH = "full_fetch_charge_fee".hashCode();
    iFI = "fetch_charge_info".hashCode();
    ijr = "tips".hashCode();
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
      if (iFe != k) {
        break label65;
      }
      this.field_bindSerial = paramCursor.getString(i);
      this.iEo = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iFf == k)
      {
        this.field_defaultCardState = paramCursor.getInt(i);
      }
      else if (iFg == k)
      {
        this.field_cardType = paramCursor.getInt(i);
      }
      else if (iFh == k)
      {
        this.field_bankcardState = paramCursor.getInt(i);
      }
      else if (iFi == k)
      {
        this.field_forbidWord = paramCursor.getString(i);
      }
      else if (iFj == k)
      {
        this.field_bankName = paramCursor.getString(i);
      }
      else if (iFk == k)
      {
        this.field_bankcardType = paramCursor.getString(i);
      }
      else if (iFl == k)
      {
        this.field_bankcardTypeName = paramCursor.getString(i);
      }
      else if (iFm == k)
      {
        this.field_bankcardTag = paramCursor.getInt(i);
      }
      else if (iFn == k)
      {
        this.field_bankcardTail = paramCursor.getString(i);
      }
      else if (iFo == k)
      {
        this.field_supportTag = paramCursor.getInt(i);
      }
      else if (iFp == k)
      {
        this.field_mobile = paramCursor.getString(i);
      }
      else if (iFq == k)
      {
        this.field_trueName = paramCursor.getString(i);
      }
      else if (hJv == k)
      {
        this.field_desc = paramCursor.getString(i);
      }
      else if (iFr == k)
      {
        this.field_bankPhone = paramCursor.getString(i);
      }
      else if (iFs == k)
      {
        this.field_bizUsername = paramCursor.getString(i);
      }
      else if (iFt == k)
      {
        this.field_onceQuotaKind = paramCursor.getDouble(i);
      }
      else if (iFu == k)
      {
        this.field_onceQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (iFv == k)
      {
        this.field_dayQuotaKind = paramCursor.getDouble(i);
      }
      else if (iFw == k)
      {
        this.field_dayQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (iFx == k)
      {
        this.field_fetchArriveTime = paramCursor.getLong(i);
      }
      else if (iFy == k)
      {
        this.field_fetchArriveTimeWording = paramCursor.getString(i);
      }
      else if (iFz == k)
      {
        this.field_repay_url = paramCursor.getString(i);
      }
      else if (iFA == k)
      {
        this.field_wxcreditState = paramCursor.getInt(i);
      }
      else if (iFB == k)
      {
        this.field_bankcardClientType = paramCursor.getInt(i);
      }
      else if (iFC == k)
      {
        this.field_ext_msg = paramCursor.getString(i);
      }
      else
      {
        if (iFD == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_support_micropay = bool;
            break;
          }
        }
        if (iFE == k) {
          this.field_arrive_type = paramCursor.getString(i);
        } else if (iFF == k) {
          this.field_avail_save_wording = paramCursor.getString(i);
        } else if (iFG == k) {
          this.field_fetch_charge_rate = paramCursor.getDouble(i);
        } else if (iFH == k) {
          this.field_full_fetch_charge_fee = paramCursor.getDouble(i);
        } else if (iFI == k) {
          this.field_fetch_charge_info = paramCursor.getString(i);
        } else if (ijr == k) {
          this.field_tips = paramCursor.getString(i);
        } else if (iFJ == k) {
          this.field_forbid_title = paramCursor.getString(i);
        } else if (iFK == k) {
          this.field_forbid_url = paramCursor.getString(i);
        } else if (iFL == k) {
          this.field_no_micro_word = paramCursor.getString(i);
        } else if (iFM == k) {
          this.field_card_bottom_wording = paramCursor.getString(i);
        } else if (iFN == k) {
          this.field_support_lqt_turn_in = paramCursor.getInt(i);
        } else if (iFO == k) {
          this.field_support_lqt_turn_out = paramCursor.getInt(i);
        } else if (iFP == k) {
          this.field_is_hightlight_pre_arrive_time_wording = paramCursor.getInt(i);
        } else if (iFQ == k) {
          this.field_card_state_name = paramCursor.getString(i);
        } else if (iFR == k) {
          this.field_prompt_info_prompt_text = paramCursor.getString(i);
        } else if (iFS == k) {
          this.field_prompt_info_jump_text = paramCursor.getString(i);
        } else if (iFT == k) {
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
    if (this.iEo) {
      localContentValues.put("bindSerial", this.field_bindSerial);
    }
    if (this.iEp) {
      localContentValues.put("defaultCardState", Integer.valueOf(this.field_defaultCardState));
    }
    if (this.iEq) {
      localContentValues.put("cardType", Integer.valueOf(this.field_cardType));
    }
    if (this.iEr) {
      localContentValues.put("bankcardState", Integer.valueOf(this.field_bankcardState));
    }
    if (this.iEs) {
      localContentValues.put("forbidWord", this.field_forbidWord);
    }
    if (this.iEt) {
      localContentValues.put("bankName", this.field_bankName);
    }
    if (this.iEu) {
      localContentValues.put("bankcardType", this.field_bankcardType);
    }
    if (this.iEv) {
      localContentValues.put("bankcardTypeName", this.field_bankcardTypeName);
    }
    if (this.iEw) {
      localContentValues.put("bankcardTag", Integer.valueOf(this.field_bankcardTag));
    }
    if (this.iEx) {
      localContentValues.put("bankcardTail", this.field_bankcardTail);
    }
    if (this.iEy) {
      localContentValues.put("supportTag", Integer.valueOf(this.field_supportTag));
    }
    if (this.iEz) {
      localContentValues.put("mobile", this.field_mobile);
    }
    if (this.iEA) {
      localContentValues.put("trueName", this.field_trueName);
    }
    if (this.hJr) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.iEB) {
      localContentValues.put("bankPhone", this.field_bankPhone);
    }
    if (this.iEC) {
      localContentValues.put("bizUsername", this.field_bizUsername);
    }
    if (this.iED) {
      localContentValues.put("onceQuotaKind", Double.valueOf(this.field_onceQuotaKind));
    }
    if (this.iEE) {
      localContentValues.put("onceQuotaVirtual", Double.valueOf(this.field_onceQuotaVirtual));
    }
    if (this.iEF) {
      localContentValues.put("dayQuotaKind", Double.valueOf(this.field_dayQuotaKind));
    }
    if (this.iEG) {
      localContentValues.put("dayQuotaVirtual", Double.valueOf(this.field_dayQuotaVirtual));
    }
    if (this.iEH) {
      localContentValues.put("fetchArriveTime", Long.valueOf(this.field_fetchArriveTime));
    }
    if (this.iEI) {
      localContentValues.put("fetchArriveTimeWording", this.field_fetchArriveTimeWording);
    }
    if (this.iEJ) {
      localContentValues.put("repay_url", this.field_repay_url);
    }
    if (this.iEK) {
      localContentValues.put("wxcreditState", Integer.valueOf(this.field_wxcreditState));
    }
    if (this.iEL) {
      localContentValues.put("bankcardClientType", Integer.valueOf(this.field_bankcardClientType));
    }
    if (this.iEM) {
      localContentValues.put("ext_msg", this.field_ext_msg);
    }
    if (this.iEN) {
      localContentValues.put("support_micropay", Boolean.valueOf(this.field_support_micropay));
    }
    if (this.iEO) {
      localContentValues.put("arrive_type", this.field_arrive_type);
    }
    if (this.iEP) {
      localContentValues.put("avail_save_wording", this.field_avail_save_wording);
    }
    if (this.iEQ) {
      localContentValues.put("fetch_charge_rate", Double.valueOf(this.field_fetch_charge_rate));
    }
    if (this.iER) {
      localContentValues.put("full_fetch_charge_fee", Double.valueOf(this.field_full_fetch_charge_fee));
    }
    if (this.iES) {
      localContentValues.put("fetch_charge_info", this.field_fetch_charge_info);
    }
    if (this.ijl) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.iET) {
      localContentValues.put("forbid_title", this.field_forbid_title);
    }
    if (this.iEU) {
      localContentValues.put("forbid_url", this.field_forbid_url);
    }
    if (this.iEV) {
      localContentValues.put("no_micro_word", this.field_no_micro_word);
    }
    if (this.iEW) {
      localContentValues.put("card_bottom_wording", this.field_card_bottom_wording);
    }
    if (this.iEX) {
      localContentValues.put("support_lqt_turn_in", Integer.valueOf(this.field_support_lqt_turn_in));
    }
    if (this.iEY) {
      localContentValues.put("support_lqt_turn_out", Integer.valueOf(this.field_support_lqt_turn_out));
    }
    if (this.iEZ) {
      localContentValues.put("is_hightlight_pre_arrive_time_wording", Integer.valueOf(this.field_is_hightlight_pre_arrive_time_wording));
    }
    if (this.iFa) {
      localContentValues.put("card_state_name", this.field_card_state_name);
    }
    if (this.iFb) {
      localContentValues.put("prompt_info_prompt_text", this.field_prompt_info_prompt_text);
    }
    if (this.iFc) {
      localContentValues.put("prompt_info_jump_text", this.field_prompt_info_jump_text);
    }
    if (this.iFd) {
      localContentValues.put("prompt_info_jump_url", this.field_prompt_info_jump_url);
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
    return "WalletBankcard";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.c.hk
 * JD-Core Version:    0.7.0.1
 */