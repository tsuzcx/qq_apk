package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gs
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eVr;
  private static final int flk = "tips".hashCode();
  private static final int fzA;
  private static final int fzB;
  private static final int fzC;
  private static final int fzD;
  private static final int fzE;
  private static final int fzF;
  private static final int fzG;
  private static final int fzH = "forbid_title".hashCode();
  private static final int fzI = "forbid_url".hashCode();
  private static final int fzJ = "no_micro_word".hashCode();
  private static final int fzK = "card_bottom_wording".hashCode();
  private static final int fzL = "support_lqt_turn_in".hashCode();
  private static final int fzM = "support_lqt_turn_out".hashCode();
  private static final int fzN = "is_hightlight_pre_arrive_time_wording".hashCode();
  private static final int fzO = "card_state_name".hashCode();
  private static final int fzP = "prompt_info_prompt_text".hashCode();
  private static final int fzQ = "prompt_info_jump_text".hashCode();
  private static final int fzR = "prompt_info_jump_url".hashCode();
  private static final int fzd = "bindSerial".hashCode();
  private static final int fze = "cardType".hashCode();
  private static final int fzf = "bankcardState".hashCode();
  private static final int fzg = "forbidWord".hashCode();
  private static final int fzh = "bankName".hashCode();
  private static final int fzi = "bankcardType".hashCode();
  private static final int fzj = "bankcardTypeName".hashCode();
  private static final int fzk = "bankcardTag".hashCode();
  private static final int fzl = "bankcardTail".hashCode();
  private static final int fzm = "supportTag".hashCode();
  private static final int fzn = "mobile".hashCode();
  private static final int fzo = "trueName".hashCode();
  private static final int fzp;
  private static final int fzq;
  private static final int fzr;
  private static final int fzs;
  private static final int fzt;
  private static final int fzu;
  private static final int fzv;
  private static final int fzw;
  private static final int fzx;
  private static final int fzy;
  private static final int fzz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eVn = true;
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
  private boolean fle = true;
  private boolean fyA = true;
  private boolean fyB = true;
  private boolean fyC = true;
  private boolean fyD = true;
  private boolean fyE = true;
  private boolean fyF = true;
  private boolean fyG = true;
  private boolean fyH = true;
  private boolean fyI = true;
  private boolean fyJ = true;
  private boolean fyK = true;
  private boolean fyL = true;
  private boolean fyM = true;
  private boolean fyN = true;
  private boolean fyO = true;
  private boolean fyP = true;
  private boolean fyQ = true;
  private boolean fyR = true;
  private boolean fyS = true;
  private boolean fyT = true;
  private boolean fyU = true;
  private boolean fyV = true;
  private boolean fyW = true;
  private boolean fyX = true;
  private boolean fyY = true;
  private boolean fyZ = true;
  private boolean fyo = true;
  private boolean fyp = true;
  private boolean fyq = true;
  private boolean fyr = true;
  private boolean fys = true;
  private boolean fyt = true;
  private boolean fyu = true;
  private boolean fyv = true;
  private boolean fyw = true;
  private boolean fyx = true;
  private boolean fyy = true;
  private boolean fyz = true;
  private boolean fza = true;
  private boolean fzb = true;
  private boolean fzc = true;
  
  static
  {
    eVr = "desc".hashCode();
    fzp = "bankPhone".hashCode();
    fzq = "bizUsername".hashCode();
    fzr = "onceQuotaKind".hashCode();
    fzs = "onceQuotaVirtual".hashCode();
    fzt = "dayQuotaKind".hashCode();
    fzu = "dayQuotaVirtual".hashCode();
    fzv = "fetchArriveTime".hashCode();
    fzw = "fetchArriveTimeWording".hashCode();
    fzx = "repay_url".hashCode();
    fzy = "wxcreditState".hashCode();
    fzz = "bankcardClientType".hashCode();
    fzA = "ext_msg".hashCode();
    fzB = "support_micropay".hashCode();
    fzC = "arrive_type".hashCode();
    fzD = "avail_save_wording".hashCode();
    fzE = "fetch_charge_rate".hashCode();
    fzF = "full_fetch_charge_fee".hashCode();
    fzG = "fetch_charge_info".hashCode();
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
      if (fzd != k) {
        break label65;
      }
      this.field_bindSerial = paramCursor.getString(i);
      this.fyo = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fze == k)
      {
        this.field_cardType = paramCursor.getInt(i);
      }
      else if (fzf == k)
      {
        this.field_bankcardState = paramCursor.getInt(i);
      }
      else if (fzg == k)
      {
        this.field_forbidWord = paramCursor.getString(i);
      }
      else if (fzh == k)
      {
        this.field_bankName = paramCursor.getString(i);
      }
      else if (fzi == k)
      {
        this.field_bankcardType = paramCursor.getString(i);
      }
      else if (fzj == k)
      {
        this.field_bankcardTypeName = paramCursor.getString(i);
      }
      else if (fzk == k)
      {
        this.field_bankcardTag = paramCursor.getInt(i);
      }
      else if (fzl == k)
      {
        this.field_bankcardTail = paramCursor.getString(i);
      }
      else if (fzm == k)
      {
        this.field_supportTag = paramCursor.getInt(i);
      }
      else if (fzn == k)
      {
        this.field_mobile = paramCursor.getString(i);
      }
      else if (fzo == k)
      {
        this.field_trueName = paramCursor.getString(i);
      }
      else if (eVr == k)
      {
        this.field_desc = paramCursor.getString(i);
      }
      else if (fzp == k)
      {
        this.field_bankPhone = paramCursor.getString(i);
      }
      else if (fzq == k)
      {
        this.field_bizUsername = paramCursor.getString(i);
      }
      else if (fzr == k)
      {
        this.field_onceQuotaKind = paramCursor.getDouble(i);
      }
      else if (fzs == k)
      {
        this.field_onceQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (fzt == k)
      {
        this.field_dayQuotaKind = paramCursor.getDouble(i);
      }
      else if (fzu == k)
      {
        this.field_dayQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (fzv == k)
      {
        this.field_fetchArriveTime = paramCursor.getLong(i);
      }
      else if (fzw == k)
      {
        this.field_fetchArriveTimeWording = paramCursor.getString(i);
      }
      else if (fzx == k)
      {
        this.field_repay_url = paramCursor.getString(i);
      }
      else if (fzy == k)
      {
        this.field_wxcreditState = paramCursor.getInt(i);
      }
      else if (fzz == k)
      {
        this.field_bankcardClientType = paramCursor.getInt(i);
      }
      else if (fzA == k)
      {
        this.field_ext_msg = paramCursor.getString(i);
      }
      else
      {
        if (fzB == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_support_micropay = bool;
            break;
          }
        }
        if (fzC == k) {
          this.field_arrive_type = paramCursor.getString(i);
        } else if (fzD == k) {
          this.field_avail_save_wording = paramCursor.getString(i);
        } else if (fzE == k) {
          this.field_fetch_charge_rate = paramCursor.getDouble(i);
        } else if (fzF == k) {
          this.field_full_fetch_charge_fee = paramCursor.getDouble(i);
        } else if (fzG == k) {
          this.field_fetch_charge_info = paramCursor.getString(i);
        } else if (flk == k) {
          this.field_tips = paramCursor.getString(i);
        } else if (fzH == k) {
          this.field_forbid_title = paramCursor.getString(i);
        } else if (fzI == k) {
          this.field_forbid_url = paramCursor.getString(i);
        } else if (fzJ == k) {
          this.field_no_micro_word = paramCursor.getString(i);
        } else if (fzK == k) {
          this.field_card_bottom_wording = paramCursor.getString(i);
        } else if (fzL == k) {
          this.field_support_lqt_turn_in = paramCursor.getInt(i);
        } else if (fzM == k) {
          this.field_support_lqt_turn_out = paramCursor.getInt(i);
        } else if (fzN == k) {
          this.field_is_hightlight_pre_arrive_time_wording = paramCursor.getInt(i);
        } else if (fzO == k) {
          this.field_card_state_name = paramCursor.getString(i);
        } else if (fzP == k) {
          this.field_prompt_info_prompt_text = paramCursor.getString(i);
        } else if (fzQ == k) {
          this.field_prompt_info_jump_text = paramCursor.getString(i);
        } else if (fzR == k) {
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
    if (this.fyo) {
      localContentValues.put("bindSerial", this.field_bindSerial);
    }
    if (this.fyp) {
      localContentValues.put("cardType", Integer.valueOf(this.field_cardType));
    }
    if (this.fyq) {
      localContentValues.put("bankcardState", Integer.valueOf(this.field_bankcardState));
    }
    if (this.fyr) {
      localContentValues.put("forbidWord", this.field_forbidWord);
    }
    if (this.fys) {
      localContentValues.put("bankName", this.field_bankName);
    }
    if (this.fyt) {
      localContentValues.put("bankcardType", this.field_bankcardType);
    }
    if (this.fyu) {
      localContentValues.put("bankcardTypeName", this.field_bankcardTypeName);
    }
    if (this.fyv) {
      localContentValues.put("bankcardTag", Integer.valueOf(this.field_bankcardTag));
    }
    if (this.fyw) {
      localContentValues.put("bankcardTail", this.field_bankcardTail);
    }
    if (this.fyx) {
      localContentValues.put("supportTag", Integer.valueOf(this.field_supportTag));
    }
    if (this.fyy) {
      localContentValues.put("mobile", this.field_mobile);
    }
    if (this.fyz) {
      localContentValues.put("trueName", this.field_trueName);
    }
    if (this.eVn) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.fyA) {
      localContentValues.put("bankPhone", this.field_bankPhone);
    }
    if (this.fyB) {
      localContentValues.put("bizUsername", this.field_bizUsername);
    }
    if (this.fyC) {
      localContentValues.put("onceQuotaKind", Double.valueOf(this.field_onceQuotaKind));
    }
    if (this.fyD) {
      localContentValues.put("onceQuotaVirtual", Double.valueOf(this.field_onceQuotaVirtual));
    }
    if (this.fyE) {
      localContentValues.put("dayQuotaKind", Double.valueOf(this.field_dayQuotaKind));
    }
    if (this.fyF) {
      localContentValues.put("dayQuotaVirtual", Double.valueOf(this.field_dayQuotaVirtual));
    }
    if (this.fyG) {
      localContentValues.put("fetchArriveTime", Long.valueOf(this.field_fetchArriveTime));
    }
    if (this.fyH) {
      localContentValues.put("fetchArriveTimeWording", this.field_fetchArriveTimeWording);
    }
    if (this.fyI) {
      localContentValues.put("repay_url", this.field_repay_url);
    }
    if (this.fyJ) {
      localContentValues.put("wxcreditState", Integer.valueOf(this.field_wxcreditState));
    }
    if (this.fyK) {
      localContentValues.put("bankcardClientType", Integer.valueOf(this.field_bankcardClientType));
    }
    if (this.fyL) {
      localContentValues.put("ext_msg", this.field_ext_msg);
    }
    if (this.fyM) {
      localContentValues.put("support_micropay", Boolean.valueOf(this.field_support_micropay));
    }
    if (this.fyN) {
      localContentValues.put("arrive_type", this.field_arrive_type);
    }
    if (this.fyO) {
      localContentValues.put("avail_save_wording", this.field_avail_save_wording);
    }
    if (this.fyP) {
      localContentValues.put("fetch_charge_rate", Double.valueOf(this.field_fetch_charge_rate));
    }
    if (this.fyQ) {
      localContentValues.put("full_fetch_charge_fee", Double.valueOf(this.field_full_fetch_charge_fee));
    }
    if (this.fyR) {
      localContentValues.put("fetch_charge_info", this.field_fetch_charge_info);
    }
    if (this.fle) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.fyS) {
      localContentValues.put("forbid_title", this.field_forbid_title);
    }
    if (this.fyT) {
      localContentValues.put("forbid_url", this.field_forbid_url);
    }
    if (this.fyU) {
      localContentValues.put("no_micro_word", this.field_no_micro_word);
    }
    if (this.fyV) {
      localContentValues.put("card_bottom_wording", this.field_card_bottom_wording);
    }
    if (this.fyW) {
      localContentValues.put("support_lqt_turn_in", Integer.valueOf(this.field_support_lqt_turn_in));
    }
    if (this.fyX) {
      localContentValues.put("support_lqt_turn_out", Integer.valueOf(this.field_support_lqt_turn_out));
    }
    if (this.fyY) {
      localContentValues.put("is_hightlight_pre_arrive_time_wording", Integer.valueOf(this.field_is_hightlight_pre_arrive_time_wording));
    }
    if (this.fyZ) {
      localContentValues.put("card_state_name", this.field_card_state_name);
    }
    if (this.fza) {
      localContentValues.put("prompt_info_prompt_text", this.field_prompt_info_prompt_text);
    }
    if (this.fzb) {
      localContentValues.put("prompt_info_jump_text", this.field_prompt_info_jump_text);
    }
    if (this.fzc) {
      localContentValues.put("prompt_info_jump_url", this.field_prompt_info_jump_url);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.gs
 * JD-Core Version:    0.7.0.1
 */