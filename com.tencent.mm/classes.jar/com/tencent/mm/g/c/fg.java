package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dGk = "tips".hashCode();
  private static final int dSA;
  private static final int dSB;
  private static final int dSC;
  private static final int dSD;
  private static final int dSE;
  private static final int dSF;
  private static final int dSG;
  private static final int dSH;
  private static final int dSI;
  private static final int dSJ;
  private static final int dSK;
  private static final int dSL;
  private static final int dSM;
  private static final int dSN;
  private static final int dSO;
  private static final int dSP;
  private static final int dSQ;
  private static final int dSR;
  private static final int dSS;
  private static final int dST = "forbid_title".hashCode();
  private static final int dSU = "forbid_url".hashCode();
  private static final int dSV = "no_micro_word".hashCode();
  private static final int dSW = "card_bottom_wording".hashCode();
  private static final int dSX = "support_lqt_turn_in".hashCode();
  private static final int dSY = "support_lqt_turn_out".hashCode();
  private static final int dSZ = "is_hightlight_pre_arrive_time_wording".hashCode();
  private static final int dSp = "bindSerial".hashCode();
  private static final int dSq = "cardType".hashCode();
  private static final int dSr = "bankcardState".hashCode();
  private static final int dSs = "forbidWord".hashCode();
  private static final int dSt = "bankName".hashCode();
  private static final int dSu = "bankcardType".hashCode();
  private static final int dSv = "bankcardTypeName".hashCode();
  private static final int dSw = "bankcardTag".hashCode();
  private static final int dSx = "bankcardTail".hashCode();
  private static final int dSy = "supportTag".hashCode();
  private static final int dSz = "mobile".hashCode();
  private static final int dTa = "card_state_name".hashCode();
  private static final int duO;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dGe = true;
  private boolean dRD = true;
  private boolean dRE = true;
  private boolean dRF = true;
  private boolean dRG = true;
  private boolean dRH = true;
  private boolean dRI = true;
  private boolean dRJ = true;
  private boolean dRK = true;
  private boolean dRL = true;
  private boolean dRM = true;
  private boolean dRN = true;
  private boolean dRO = true;
  private boolean dRP = true;
  private boolean dRQ = true;
  private boolean dRR = true;
  private boolean dRS = true;
  private boolean dRT = true;
  private boolean dRU = true;
  private boolean dRV = true;
  private boolean dRW = true;
  private boolean dRX = true;
  private boolean dRY = true;
  private boolean dRZ = true;
  private boolean dSa = true;
  private boolean dSb = true;
  private boolean dSc = true;
  private boolean dSd = true;
  private boolean dSe = true;
  private boolean dSf = true;
  private boolean dSg = true;
  private boolean dSh = true;
  private boolean dSi = true;
  private boolean dSj = true;
  private boolean dSk = true;
  private boolean dSl = true;
  private boolean dSm = true;
  private boolean dSn = true;
  private boolean dSo = true;
  private boolean duK = true;
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
  public String field_repay_url;
  public int field_supportTag;
  public int field_support_lqt_turn_in;
  public int field_support_lqt_turn_out;
  public boolean field_support_micropay;
  public String field_tips;
  public String field_trueName;
  public int field_wxcreditState;
  
  static
  {
    dSA = "trueName".hashCode();
    duO = "desc".hashCode();
    dSB = "bankPhone".hashCode();
    dSC = "bizUsername".hashCode();
    dSD = "onceQuotaKind".hashCode();
    dSE = "onceQuotaVirtual".hashCode();
    dSF = "dayQuotaKind".hashCode();
    dSG = "dayQuotaVirtual".hashCode();
    dSH = "fetchArriveTime".hashCode();
    dSI = "fetchArriveTimeWording".hashCode();
    dSJ = "repay_url".hashCode();
    dSK = "wxcreditState".hashCode();
    dSL = "bankcardClientType".hashCode();
    dSM = "ext_msg".hashCode();
    dSN = "support_micropay".hashCode();
    dSO = "arrive_type".hashCode();
    dSP = "avail_save_wording".hashCode();
    dSQ = "fetch_charge_rate".hashCode();
    dSR = "full_fetch_charge_fee".hashCode();
    dSS = "fetch_charge_info".hashCode();
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
      if (dSp != k) {
        break label65;
      }
      this.field_bindSerial = paramCursor.getString(i);
      this.dRD = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dSq == k)
      {
        this.field_cardType = paramCursor.getInt(i);
      }
      else if (dSr == k)
      {
        this.field_bankcardState = paramCursor.getInt(i);
      }
      else if (dSs == k)
      {
        this.field_forbidWord = paramCursor.getString(i);
      }
      else if (dSt == k)
      {
        this.field_bankName = paramCursor.getString(i);
      }
      else if (dSu == k)
      {
        this.field_bankcardType = paramCursor.getString(i);
      }
      else if (dSv == k)
      {
        this.field_bankcardTypeName = paramCursor.getString(i);
      }
      else if (dSw == k)
      {
        this.field_bankcardTag = paramCursor.getInt(i);
      }
      else if (dSx == k)
      {
        this.field_bankcardTail = paramCursor.getString(i);
      }
      else if (dSy == k)
      {
        this.field_supportTag = paramCursor.getInt(i);
      }
      else if (dSz == k)
      {
        this.field_mobile = paramCursor.getString(i);
      }
      else if (dSA == k)
      {
        this.field_trueName = paramCursor.getString(i);
      }
      else if (duO == k)
      {
        this.field_desc = paramCursor.getString(i);
      }
      else if (dSB == k)
      {
        this.field_bankPhone = paramCursor.getString(i);
      }
      else if (dSC == k)
      {
        this.field_bizUsername = paramCursor.getString(i);
      }
      else if (dSD == k)
      {
        this.field_onceQuotaKind = paramCursor.getDouble(i);
      }
      else if (dSE == k)
      {
        this.field_onceQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (dSF == k)
      {
        this.field_dayQuotaKind = paramCursor.getDouble(i);
      }
      else if (dSG == k)
      {
        this.field_dayQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (dSH == k)
      {
        this.field_fetchArriveTime = paramCursor.getLong(i);
      }
      else if (dSI == k)
      {
        this.field_fetchArriveTimeWording = paramCursor.getString(i);
      }
      else if (dSJ == k)
      {
        this.field_repay_url = paramCursor.getString(i);
      }
      else if (dSK == k)
      {
        this.field_wxcreditState = paramCursor.getInt(i);
      }
      else if (dSL == k)
      {
        this.field_bankcardClientType = paramCursor.getInt(i);
      }
      else if (dSM == k)
      {
        this.field_ext_msg = paramCursor.getString(i);
      }
      else
      {
        if (dSN == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_support_micropay = bool;
            break;
          }
        }
        if (dSO == k) {
          this.field_arrive_type = paramCursor.getString(i);
        } else if (dSP == k) {
          this.field_avail_save_wording = paramCursor.getString(i);
        } else if (dSQ == k) {
          this.field_fetch_charge_rate = paramCursor.getDouble(i);
        } else if (dSR == k) {
          this.field_full_fetch_charge_fee = paramCursor.getDouble(i);
        } else if (dSS == k) {
          this.field_fetch_charge_info = paramCursor.getString(i);
        } else if (dGk == k) {
          this.field_tips = paramCursor.getString(i);
        } else if (dST == k) {
          this.field_forbid_title = paramCursor.getString(i);
        } else if (dSU == k) {
          this.field_forbid_url = paramCursor.getString(i);
        } else if (dSV == k) {
          this.field_no_micro_word = paramCursor.getString(i);
        } else if (dSW == k) {
          this.field_card_bottom_wording = paramCursor.getString(i);
        } else if (dSX == k) {
          this.field_support_lqt_turn_in = paramCursor.getInt(i);
        } else if (dSY == k) {
          this.field_support_lqt_turn_out = paramCursor.getInt(i);
        } else if (dSZ == k) {
          this.field_is_hightlight_pre_arrive_time_wording = paramCursor.getInt(i);
        } else if (dTa == k) {
          this.field_card_state_name = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dRD) {
      localContentValues.put("bindSerial", this.field_bindSerial);
    }
    if (this.dRE) {
      localContentValues.put("cardType", Integer.valueOf(this.field_cardType));
    }
    if (this.dRF) {
      localContentValues.put("bankcardState", Integer.valueOf(this.field_bankcardState));
    }
    if (this.dRG) {
      localContentValues.put("forbidWord", this.field_forbidWord);
    }
    if (this.dRH) {
      localContentValues.put("bankName", this.field_bankName);
    }
    if (this.dRI) {
      localContentValues.put("bankcardType", this.field_bankcardType);
    }
    if (this.dRJ) {
      localContentValues.put("bankcardTypeName", this.field_bankcardTypeName);
    }
    if (this.dRK) {
      localContentValues.put("bankcardTag", Integer.valueOf(this.field_bankcardTag));
    }
    if (this.dRL) {
      localContentValues.put("bankcardTail", this.field_bankcardTail);
    }
    if (this.dRM) {
      localContentValues.put("supportTag", Integer.valueOf(this.field_supportTag));
    }
    if (this.dRN) {
      localContentValues.put("mobile", this.field_mobile);
    }
    if (this.dRO) {
      localContentValues.put("trueName", this.field_trueName);
    }
    if (this.duK) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.dRP) {
      localContentValues.put("bankPhone", this.field_bankPhone);
    }
    if (this.dRQ) {
      localContentValues.put("bizUsername", this.field_bizUsername);
    }
    if (this.dRR) {
      localContentValues.put("onceQuotaKind", Double.valueOf(this.field_onceQuotaKind));
    }
    if (this.dRS) {
      localContentValues.put("onceQuotaVirtual", Double.valueOf(this.field_onceQuotaVirtual));
    }
    if (this.dRT) {
      localContentValues.put("dayQuotaKind", Double.valueOf(this.field_dayQuotaKind));
    }
    if (this.dRU) {
      localContentValues.put("dayQuotaVirtual", Double.valueOf(this.field_dayQuotaVirtual));
    }
    if (this.dRV) {
      localContentValues.put("fetchArriveTime", Long.valueOf(this.field_fetchArriveTime));
    }
    if (this.dRW) {
      localContentValues.put("fetchArriveTimeWording", this.field_fetchArriveTimeWording);
    }
    if (this.dRX) {
      localContentValues.put("repay_url", this.field_repay_url);
    }
    if (this.dRY) {
      localContentValues.put("wxcreditState", Integer.valueOf(this.field_wxcreditState));
    }
    if (this.dRZ) {
      localContentValues.put("bankcardClientType", Integer.valueOf(this.field_bankcardClientType));
    }
    if (this.dSa) {
      localContentValues.put("ext_msg", this.field_ext_msg);
    }
    if (this.dSb) {
      localContentValues.put("support_micropay", Boolean.valueOf(this.field_support_micropay));
    }
    if (this.dSc) {
      localContentValues.put("arrive_type", this.field_arrive_type);
    }
    if (this.dSd) {
      localContentValues.put("avail_save_wording", this.field_avail_save_wording);
    }
    if (this.dSe) {
      localContentValues.put("fetch_charge_rate", Double.valueOf(this.field_fetch_charge_rate));
    }
    if (this.dSf) {
      localContentValues.put("full_fetch_charge_fee", Double.valueOf(this.field_full_fetch_charge_fee));
    }
    if (this.dSg) {
      localContentValues.put("fetch_charge_info", this.field_fetch_charge_info);
    }
    if (this.dGe) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.dSh) {
      localContentValues.put("forbid_title", this.field_forbid_title);
    }
    if (this.dSi) {
      localContentValues.put("forbid_url", this.field_forbid_url);
    }
    if (this.dSj) {
      localContentValues.put("no_micro_word", this.field_no_micro_word);
    }
    if (this.dSk) {
      localContentValues.put("card_bottom_wording", this.field_card_bottom_wording);
    }
    if (this.dSl) {
      localContentValues.put("support_lqt_turn_in", Integer.valueOf(this.field_support_lqt_turn_in));
    }
    if (this.dSm) {
      localContentValues.put("support_lqt_turn_out", Integer.valueOf(this.field_support_lqt_turn_out));
    }
    if (this.dSn) {
      localContentValues.put("is_hightlight_pre_arrive_time_wording", Integer.valueOf(this.field_is_hightlight_pre_arrive_time_wording));
    }
    if (this.dSo) {
      localContentValues.put("card_state_name", this.field_card_state_name);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.fg
 * JD-Core Version:    0.7.0.1
 */