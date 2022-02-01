package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gr
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eTG;
  private static final int fjn = "tips".hashCode();
  private static final int fxA;
  private static final int fxB;
  private static final int fxC;
  private static final int fxD;
  private static final int fxE;
  private static final int fxF;
  private static final int fxG;
  private static final int fxH = "forbid_title".hashCode();
  private static final int fxI = "forbid_url".hashCode();
  private static final int fxJ = "no_micro_word".hashCode();
  private static final int fxK = "card_bottom_wording".hashCode();
  private static final int fxL = "support_lqt_turn_in".hashCode();
  private static final int fxM = "support_lqt_turn_out".hashCode();
  private static final int fxN = "is_hightlight_pre_arrive_time_wording".hashCode();
  private static final int fxO = "card_state_name".hashCode();
  private static final int fxP = "prompt_info_prompt_text".hashCode();
  private static final int fxQ = "prompt_info_jump_text".hashCode();
  private static final int fxR = "prompt_info_jump_url".hashCode();
  private static final int fxd = "bindSerial".hashCode();
  private static final int fxe = "cardType".hashCode();
  private static final int fxf = "bankcardState".hashCode();
  private static final int fxg = "forbidWord".hashCode();
  private static final int fxh = "bankName".hashCode();
  private static final int fxi = "bankcardType".hashCode();
  private static final int fxj = "bankcardTypeName".hashCode();
  private static final int fxk = "bankcardTag".hashCode();
  private static final int fxl = "bankcardTail".hashCode();
  private static final int fxm = "supportTag".hashCode();
  private static final int fxn = "mobile".hashCode();
  private static final int fxo = "trueName".hashCode();
  private static final int fxp;
  private static final int fxq;
  private static final int fxr;
  private static final int fxs;
  private static final int fxt;
  private static final int fxu;
  private static final int fxv;
  private static final int fxw;
  private static final int fxx;
  private static final int fxy;
  private static final int fxz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eTC = true;
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
  private boolean fjh = true;
  private boolean fwA = true;
  private boolean fwB = true;
  private boolean fwC = true;
  private boolean fwD = true;
  private boolean fwE = true;
  private boolean fwF = true;
  private boolean fwG = true;
  private boolean fwH = true;
  private boolean fwI = true;
  private boolean fwJ = true;
  private boolean fwK = true;
  private boolean fwL = true;
  private boolean fwM = true;
  private boolean fwN = true;
  private boolean fwO = true;
  private boolean fwP = true;
  private boolean fwQ = true;
  private boolean fwR = true;
  private boolean fwS = true;
  private boolean fwT = true;
  private boolean fwU = true;
  private boolean fwV = true;
  private boolean fwW = true;
  private boolean fwX = true;
  private boolean fwY = true;
  private boolean fwZ = true;
  private boolean fwo = true;
  private boolean fwp = true;
  private boolean fwq = true;
  private boolean fwr = true;
  private boolean fws = true;
  private boolean fwt = true;
  private boolean fwu = true;
  private boolean fwv = true;
  private boolean fww = true;
  private boolean fwx = true;
  private boolean fwy = true;
  private boolean fwz = true;
  private boolean fxa = true;
  private boolean fxb = true;
  private boolean fxc = true;
  
  static
  {
    eTG = "desc".hashCode();
    fxp = "bankPhone".hashCode();
    fxq = "bizUsername".hashCode();
    fxr = "onceQuotaKind".hashCode();
    fxs = "onceQuotaVirtual".hashCode();
    fxt = "dayQuotaKind".hashCode();
    fxu = "dayQuotaVirtual".hashCode();
    fxv = "fetchArriveTime".hashCode();
    fxw = "fetchArriveTimeWording".hashCode();
    fxx = "repay_url".hashCode();
    fxy = "wxcreditState".hashCode();
    fxz = "bankcardClientType".hashCode();
    fxA = "ext_msg".hashCode();
    fxB = "support_micropay".hashCode();
    fxC = "arrive_type".hashCode();
    fxD = "avail_save_wording".hashCode();
    fxE = "fetch_charge_rate".hashCode();
    fxF = "full_fetch_charge_fee".hashCode();
    fxG = "fetch_charge_info".hashCode();
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
      if (fxd != k) {
        break label65;
      }
      this.field_bindSerial = paramCursor.getString(i);
      this.fwo = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fxe == k)
      {
        this.field_cardType = paramCursor.getInt(i);
      }
      else if (fxf == k)
      {
        this.field_bankcardState = paramCursor.getInt(i);
      }
      else if (fxg == k)
      {
        this.field_forbidWord = paramCursor.getString(i);
      }
      else if (fxh == k)
      {
        this.field_bankName = paramCursor.getString(i);
      }
      else if (fxi == k)
      {
        this.field_bankcardType = paramCursor.getString(i);
      }
      else if (fxj == k)
      {
        this.field_bankcardTypeName = paramCursor.getString(i);
      }
      else if (fxk == k)
      {
        this.field_bankcardTag = paramCursor.getInt(i);
      }
      else if (fxl == k)
      {
        this.field_bankcardTail = paramCursor.getString(i);
      }
      else if (fxm == k)
      {
        this.field_supportTag = paramCursor.getInt(i);
      }
      else if (fxn == k)
      {
        this.field_mobile = paramCursor.getString(i);
      }
      else if (fxo == k)
      {
        this.field_trueName = paramCursor.getString(i);
      }
      else if (eTG == k)
      {
        this.field_desc = paramCursor.getString(i);
      }
      else if (fxp == k)
      {
        this.field_bankPhone = paramCursor.getString(i);
      }
      else if (fxq == k)
      {
        this.field_bizUsername = paramCursor.getString(i);
      }
      else if (fxr == k)
      {
        this.field_onceQuotaKind = paramCursor.getDouble(i);
      }
      else if (fxs == k)
      {
        this.field_onceQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (fxt == k)
      {
        this.field_dayQuotaKind = paramCursor.getDouble(i);
      }
      else if (fxu == k)
      {
        this.field_dayQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (fxv == k)
      {
        this.field_fetchArriveTime = paramCursor.getLong(i);
      }
      else if (fxw == k)
      {
        this.field_fetchArriveTimeWording = paramCursor.getString(i);
      }
      else if (fxx == k)
      {
        this.field_repay_url = paramCursor.getString(i);
      }
      else if (fxy == k)
      {
        this.field_wxcreditState = paramCursor.getInt(i);
      }
      else if (fxz == k)
      {
        this.field_bankcardClientType = paramCursor.getInt(i);
      }
      else if (fxA == k)
      {
        this.field_ext_msg = paramCursor.getString(i);
      }
      else
      {
        if (fxB == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_support_micropay = bool;
            break;
          }
        }
        if (fxC == k) {
          this.field_arrive_type = paramCursor.getString(i);
        } else if (fxD == k) {
          this.field_avail_save_wording = paramCursor.getString(i);
        } else if (fxE == k) {
          this.field_fetch_charge_rate = paramCursor.getDouble(i);
        } else if (fxF == k) {
          this.field_full_fetch_charge_fee = paramCursor.getDouble(i);
        } else if (fxG == k) {
          this.field_fetch_charge_info = paramCursor.getString(i);
        } else if (fjn == k) {
          this.field_tips = paramCursor.getString(i);
        } else if (fxH == k) {
          this.field_forbid_title = paramCursor.getString(i);
        } else if (fxI == k) {
          this.field_forbid_url = paramCursor.getString(i);
        } else if (fxJ == k) {
          this.field_no_micro_word = paramCursor.getString(i);
        } else if (fxK == k) {
          this.field_card_bottom_wording = paramCursor.getString(i);
        } else if (fxL == k) {
          this.field_support_lqt_turn_in = paramCursor.getInt(i);
        } else if (fxM == k) {
          this.field_support_lqt_turn_out = paramCursor.getInt(i);
        } else if (fxN == k) {
          this.field_is_hightlight_pre_arrive_time_wording = paramCursor.getInt(i);
        } else if (fxO == k) {
          this.field_card_state_name = paramCursor.getString(i);
        } else if (fxP == k) {
          this.field_prompt_info_prompt_text = paramCursor.getString(i);
        } else if (fxQ == k) {
          this.field_prompt_info_jump_text = paramCursor.getString(i);
        } else if (fxR == k) {
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
    if (this.fwo) {
      localContentValues.put("bindSerial", this.field_bindSerial);
    }
    if (this.fwp) {
      localContentValues.put("cardType", Integer.valueOf(this.field_cardType));
    }
    if (this.fwq) {
      localContentValues.put("bankcardState", Integer.valueOf(this.field_bankcardState));
    }
    if (this.fwr) {
      localContentValues.put("forbidWord", this.field_forbidWord);
    }
    if (this.fws) {
      localContentValues.put("bankName", this.field_bankName);
    }
    if (this.fwt) {
      localContentValues.put("bankcardType", this.field_bankcardType);
    }
    if (this.fwu) {
      localContentValues.put("bankcardTypeName", this.field_bankcardTypeName);
    }
    if (this.fwv) {
      localContentValues.put("bankcardTag", Integer.valueOf(this.field_bankcardTag));
    }
    if (this.fww) {
      localContentValues.put("bankcardTail", this.field_bankcardTail);
    }
    if (this.fwx) {
      localContentValues.put("supportTag", Integer.valueOf(this.field_supportTag));
    }
    if (this.fwy) {
      localContentValues.put("mobile", this.field_mobile);
    }
    if (this.fwz) {
      localContentValues.put("trueName", this.field_trueName);
    }
    if (this.eTC) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.fwA) {
      localContentValues.put("bankPhone", this.field_bankPhone);
    }
    if (this.fwB) {
      localContentValues.put("bizUsername", this.field_bizUsername);
    }
    if (this.fwC) {
      localContentValues.put("onceQuotaKind", Double.valueOf(this.field_onceQuotaKind));
    }
    if (this.fwD) {
      localContentValues.put("onceQuotaVirtual", Double.valueOf(this.field_onceQuotaVirtual));
    }
    if (this.fwE) {
      localContentValues.put("dayQuotaKind", Double.valueOf(this.field_dayQuotaKind));
    }
    if (this.fwF) {
      localContentValues.put("dayQuotaVirtual", Double.valueOf(this.field_dayQuotaVirtual));
    }
    if (this.fwG) {
      localContentValues.put("fetchArriveTime", Long.valueOf(this.field_fetchArriveTime));
    }
    if (this.fwH) {
      localContentValues.put("fetchArriveTimeWording", this.field_fetchArriveTimeWording);
    }
    if (this.fwI) {
      localContentValues.put("repay_url", this.field_repay_url);
    }
    if (this.fwJ) {
      localContentValues.put("wxcreditState", Integer.valueOf(this.field_wxcreditState));
    }
    if (this.fwK) {
      localContentValues.put("bankcardClientType", Integer.valueOf(this.field_bankcardClientType));
    }
    if (this.fwL) {
      localContentValues.put("ext_msg", this.field_ext_msg);
    }
    if (this.fwM) {
      localContentValues.put("support_micropay", Boolean.valueOf(this.field_support_micropay));
    }
    if (this.fwN) {
      localContentValues.put("arrive_type", this.field_arrive_type);
    }
    if (this.fwO) {
      localContentValues.put("avail_save_wording", this.field_avail_save_wording);
    }
    if (this.fwP) {
      localContentValues.put("fetch_charge_rate", Double.valueOf(this.field_fetch_charge_rate));
    }
    if (this.fwQ) {
      localContentValues.put("full_fetch_charge_fee", Double.valueOf(this.field_full_fetch_charge_fee));
    }
    if (this.fwR) {
      localContentValues.put("fetch_charge_info", this.field_fetch_charge_info);
    }
    if (this.fjh) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.fwS) {
      localContentValues.put("forbid_title", this.field_forbid_title);
    }
    if (this.fwT) {
      localContentValues.put("forbid_url", this.field_forbid_url);
    }
    if (this.fwU) {
      localContentValues.put("no_micro_word", this.field_no_micro_word);
    }
    if (this.fwV) {
      localContentValues.put("card_bottom_wording", this.field_card_bottom_wording);
    }
    if (this.fwW) {
      localContentValues.put("support_lqt_turn_in", Integer.valueOf(this.field_support_lqt_turn_in));
    }
    if (this.fwX) {
      localContentValues.put("support_lqt_turn_out", Integer.valueOf(this.field_support_lqt_turn_out));
    }
    if (this.fwY) {
      localContentValues.put("is_hightlight_pre_arrive_time_wording", Integer.valueOf(this.field_is_hightlight_pre_arrive_time_wording));
    }
    if (this.fwZ) {
      localContentValues.put("card_state_name", this.field_card_state_name);
    }
    if (this.fxa) {
      localContentValues.put("prompt_info_prompt_text", this.field_prompt_info_prompt_text);
    }
    if (this.fxb) {
      localContentValues.put("prompt_info_jump_text", this.field_prompt_info_jump_text);
    }
    if (this.fxc) {
      localContentValues.put("prompt_info_jump_url", this.field_prompt_info_jump_url);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.gr
 * JD-Core Version:    0.7.0.1
 */