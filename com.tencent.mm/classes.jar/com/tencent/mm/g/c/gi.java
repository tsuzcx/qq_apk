package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gi
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCi;
  private static final int eQQ;
  private static final int env = "scene".hashCode();
  private static final int feV;
  private static final int feW;
  private static final int feX;
  private static final int feY;
  private static final int feZ;
  private static final int ffA;
  private static final int ffB;
  private static final int ffC;
  private static final int ffD;
  private static final int ffE;
  private static final int ffF;
  private static final int ffG;
  private static final int ffH;
  private static final int ffI;
  private static final int ffJ;
  private static final int ffL = "fakePk".hashCode();
  private static final int ffa;
  private static final int ffb;
  private static final int ffc;
  private static final int ffd;
  private static final int ffe;
  private static final int fff;
  private static final int ffg;
  private static final int ffh;
  private static final int ffi;
  private static final int ffj;
  private static final int ffk;
  private static final int ffl;
  private static final int ffm;
  private static final int ffn;
  private static final int ffo;
  private static final int ffp;
  private static final int ffq;
  private static final int ffr;
  private static final int ffs;
  private static final int fft;
  private static final int ffu;
  private static final int ffv;
  private static final int ffw;
  private static final int ffx;
  private static final int ffy;
  private static final int ffz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCe = true;
  private boolean eQK = true;
  private boolean ent = true;
  private boolean feA = true;
  private boolean feB = true;
  private boolean feC = true;
  private boolean feD = true;
  private boolean feE = true;
  private boolean feF = true;
  private boolean feG = true;
  private boolean feH = true;
  private boolean feI = true;
  private boolean feJ = true;
  private boolean feK = true;
  private boolean feL = true;
  private boolean feM = true;
  private boolean feN = true;
  private boolean feO = true;
  private boolean feP = true;
  private boolean feQ = true;
  private boolean feR = true;
  private boolean feS = true;
  private boolean feT = true;
  private boolean feU = true;
  private boolean feg = true;
  private boolean feh = true;
  private boolean fei = true;
  private boolean fej = true;
  private boolean fek = true;
  private boolean fel = true;
  private boolean fem = true;
  private boolean fen = true;
  private boolean feo = true;
  private boolean fep = true;
  private boolean feq = true;
  private boolean fer = true;
  private boolean fes = true;
  private boolean fet = true;
  private boolean feu = true;
  private boolean fev = true;
  private boolean few = true;
  private boolean fex = true;
  private boolean fey = true;
  private boolean fez = true;
  private boolean ffK = true;
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
  public int field_fakePk;
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
  public int field_scene;
  public int field_supportTag;
  public int field_support_lqt_turn_in;
  public int field_support_lqt_turn_out;
  public boolean field_support_micropay;
  public String field_tips;
  public String field_trueName;
  public int field_wxcreditState;
  
  static
  {
    feV = "bindSerial".hashCode();
    feW = "cardType".hashCode();
    feX = "bankcardState".hashCode();
    feY = "forbidWord".hashCode();
    feZ = "bankName".hashCode();
    ffa = "bankcardType".hashCode();
    ffb = "bankcardTypeName".hashCode();
    ffc = "bankcardTag".hashCode();
    ffd = "bankcardTail".hashCode();
    ffe = "supportTag".hashCode();
    fff = "mobile".hashCode();
    ffg = "trueName".hashCode();
    eCi = "desc".hashCode();
    ffh = "bankPhone".hashCode();
    ffi = "bizUsername".hashCode();
    ffj = "onceQuotaKind".hashCode();
    ffk = "onceQuotaVirtual".hashCode();
    ffl = "dayQuotaKind".hashCode();
    ffm = "dayQuotaVirtual".hashCode();
    ffn = "fetchArriveTime".hashCode();
    ffo = "fetchArriveTimeWording".hashCode();
    ffp = "repay_url".hashCode();
    ffq = "wxcreditState".hashCode();
    ffr = "bankcardClientType".hashCode();
    ffs = "ext_msg".hashCode();
    fft = "support_micropay".hashCode();
    ffu = "arrive_type".hashCode();
    ffv = "avail_save_wording".hashCode();
    ffw = "fetch_charge_rate".hashCode();
    ffx = "full_fetch_charge_fee".hashCode();
    ffy = "fetch_charge_info".hashCode();
    eQQ = "tips".hashCode();
    ffz = "forbid_title".hashCode();
    ffA = "forbid_url".hashCode();
    ffB = "no_micro_word".hashCode();
    ffC = "card_bottom_wording".hashCode();
    ffD = "support_lqt_turn_in".hashCode();
    ffE = "support_lqt_turn_out".hashCode();
    ffF = "is_hightlight_pre_arrive_time_wording".hashCode();
    ffG = "card_state_name".hashCode();
    ffH = "prompt_info_prompt_text".hashCode();
    ffI = "prompt_info_jump_text".hashCode();
    ffJ = "prompt_info_jump_url".hashCode();
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
      if (ffL != k) {
        break label65;
      }
      this.field_fakePk = paramCursor.getInt(i);
      this.ffK = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (feV == k)
      {
        this.field_bindSerial = paramCursor.getString(i);
      }
      else if (feW == k)
      {
        this.field_cardType = paramCursor.getInt(i);
      }
      else if (feX == k)
      {
        this.field_bankcardState = paramCursor.getInt(i);
      }
      else if (feY == k)
      {
        this.field_forbidWord = paramCursor.getString(i);
      }
      else if (feZ == k)
      {
        this.field_bankName = paramCursor.getString(i);
      }
      else if (ffa == k)
      {
        this.field_bankcardType = paramCursor.getString(i);
      }
      else if (ffb == k)
      {
        this.field_bankcardTypeName = paramCursor.getString(i);
      }
      else if (ffc == k)
      {
        this.field_bankcardTag = paramCursor.getInt(i);
      }
      else if (ffd == k)
      {
        this.field_bankcardTail = paramCursor.getString(i);
      }
      else if (ffe == k)
      {
        this.field_supportTag = paramCursor.getInt(i);
      }
      else if (fff == k)
      {
        this.field_mobile = paramCursor.getString(i);
      }
      else if (ffg == k)
      {
        this.field_trueName = paramCursor.getString(i);
      }
      else if (eCi == k)
      {
        this.field_desc = paramCursor.getString(i);
      }
      else if (ffh == k)
      {
        this.field_bankPhone = paramCursor.getString(i);
      }
      else if (ffi == k)
      {
        this.field_bizUsername = paramCursor.getString(i);
      }
      else if (ffj == k)
      {
        this.field_onceQuotaKind = paramCursor.getDouble(i);
      }
      else if (ffk == k)
      {
        this.field_onceQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (ffl == k)
      {
        this.field_dayQuotaKind = paramCursor.getDouble(i);
      }
      else if (ffm == k)
      {
        this.field_dayQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (ffn == k)
      {
        this.field_fetchArriveTime = paramCursor.getLong(i);
      }
      else if (ffo == k)
      {
        this.field_fetchArriveTimeWording = paramCursor.getString(i);
      }
      else if (ffp == k)
      {
        this.field_repay_url = paramCursor.getString(i);
      }
      else if (ffq == k)
      {
        this.field_wxcreditState = paramCursor.getInt(i);
      }
      else if (ffr == k)
      {
        this.field_bankcardClientType = paramCursor.getInt(i);
      }
      else if (ffs == k)
      {
        this.field_ext_msg = paramCursor.getString(i);
      }
      else
      {
        if (fft == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_support_micropay = bool;
            break;
          }
        }
        if (ffu == k) {
          this.field_arrive_type = paramCursor.getString(i);
        } else if (ffv == k) {
          this.field_avail_save_wording = paramCursor.getString(i);
        } else if (ffw == k) {
          this.field_fetch_charge_rate = paramCursor.getDouble(i);
        } else if (ffx == k) {
          this.field_full_fetch_charge_fee = paramCursor.getDouble(i);
        } else if (ffy == k) {
          this.field_fetch_charge_info = paramCursor.getString(i);
        } else if (eQQ == k) {
          this.field_tips = paramCursor.getString(i);
        } else if (ffz == k) {
          this.field_forbid_title = paramCursor.getString(i);
        } else if (ffA == k) {
          this.field_forbid_url = paramCursor.getString(i);
        } else if (ffB == k) {
          this.field_no_micro_word = paramCursor.getString(i);
        } else if (ffC == k) {
          this.field_card_bottom_wording = paramCursor.getString(i);
        } else if (ffD == k) {
          this.field_support_lqt_turn_in = paramCursor.getInt(i);
        } else if (ffE == k) {
          this.field_support_lqt_turn_out = paramCursor.getInt(i);
        } else if (ffF == k) {
          this.field_is_hightlight_pre_arrive_time_wording = paramCursor.getInt(i);
        } else if (ffG == k) {
          this.field_card_state_name = paramCursor.getString(i);
        } else if (ffH == k) {
          this.field_prompt_info_prompt_text = paramCursor.getString(i);
        } else if (ffI == k) {
          this.field_prompt_info_jump_text = paramCursor.getString(i);
        } else if (ffJ == k) {
          this.field_prompt_info_jump_url = paramCursor.getString(i);
        } else if (env == k) {
          this.field_scene = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ffK) {
      localContentValues.put("fakePk", Integer.valueOf(this.field_fakePk));
    }
    if (this.feg) {
      localContentValues.put("bindSerial", this.field_bindSerial);
    }
    if (this.feh) {
      localContentValues.put("cardType", Integer.valueOf(this.field_cardType));
    }
    if (this.fei) {
      localContentValues.put("bankcardState", Integer.valueOf(this.field_bankcardState));
    }
    if (this.fej) {
      localContentValues.put("forbidWord", this.field_forbidWord);
    }
    if (this.fek) {
      localContentValues.put("bankName", this.field_bankName);
    }
    if (this.fel) {
      localContentValues.put("bankcardType", this.field_bankcardType);
    }
    if (this.fem) {
      localContentValues.put("bankcardTypeName", this.field_bankcardTypeName);
    }
    if (this.fen) {
      localContentValues.put("bankcardTag", Integer.valueOf(this.field_bankcardTag));
    }
    if (this.feo) {
      localContentValues.put("bankcardTail", this.field_bankcardTail);
    }
    if (this.fep) {
      localContentValues.put("supportTag", Integer.valueOf(this.field_supportTag));
    }
    if (this.feq) {
      localContentValues.put("mobile", this.field_mobile);
    }
    if (this.fer) {
      localContentValues.put("trueName", this.field_trueName);
    }
    if (this.eCe) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.fes) {
      localContentValues.put("bankPhone", this.field_bankPhone);
    }
    if (this.fet) {
      localContentValues.put("bizUsername", this.field_bizUsername);
    }
    if (this.feu) {
      localContentValues.put("onceQuotaKind", Double.valueOf(this.field_onceQuotaKind));
    }
    if (this.fev) {
      localContentValues.put("onceQuotaVirtual", Double.valueOf(this.field_onceQuotaVirtual));
    }
    if (this.few) {
      localContentValues.put("dayQuotaKind", Double.valueOf(this.field_dayQuotaKind));
    }
    if (this.fex) {
      localContentValues.put("dayQuotaVirtual", Double.valueOf(this.field_dayQuotaVirtual));
    }
    if (this.fey) {
      localContentValues.put("fetchArriveTime", Long.valueOf(this.field_fetchArriveTime));
    }
    if (this.fez) {
      localContentValues.put("fetchArriveTimeWording", this.field_fetchArriveTimeWording);
    }
    if (this.feA) {
      localContentValues.put("repay_url", this.field_repay_url);
    }
    if (this.feB) {
      localContentValues.put("wxcreditState", Integer.valueOf(this.field_wxcreditState));
    }
    if (this.feC) {
      localContentValues.put("bankcardClientType", Integer.valueOf(this.field_bankcardClientType));
    }
    if (this.feD) {
      localContentValues.put("ext_msg", this.field_ext_msg);
    }
    if (this.feE) {
      localContentValues.put("support_micropay", Boolean.valueOf(this.field_support_micropay));
    }
    if (this.feF) {
      localContentValues.put("arrive_type", this.field_arrive_type);
    }
    if (this.feG) {
      localContentValues.put("avail_save_wording", this.field_avail_save_wording);
    }
    if (this.feH) {
      localContentValues.put("fetch_charge_rate", Double.valueOf(this.field_fetch_charge_rate));
    }
    if (this.feI) {
      localContentValues.put("full_fetch_charge_fee", Double.valueOf(this.field_full_fetch_charge_fee));
    }
    if (this.feJ) {
      localContentValues.put("fetch_charge_info", this.field_fetch_charge_info);
    }
    if (this.eQK) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.feK) {
      localContentValues.put("forbid_title", this.field_forbid_title);
    }
    if (this.feL) {
      localContentValues.put("forbid_url", this.field_forbid_url);
    }
    if (this.feM) {
      localContentValues.put("no_micro_word", this.field_no_micro_word);
    }
    if (this.feN) {
      localContentValues.put("card_bottom_wording", this.field_card_bottom_wording);
    }
    if (this.feO) {
      localContentValues.put("support_lqt_turn_in", Integer.valueOf(this.field_support_lqt_turn_in));
    }
    if (this.feP) {
      localContentValues.put("support_lqt_turn_out", Integer.valueOf(this.field_support_lqt_turn_out));
    }
    if (this.feQ) {
      localContentValues.put("is_hightlight_pre_arrive_time_wording", Integer.valueOf(this.field_is_hightlight_pre_arrive_time_wording));
    }
    if (this.feR) {
      localContentValues.put("card_state_name", this.field_card_state_name);
    }
    if (this.feS) {
      localContentValues.put("prompt_info_prompt_text", this.field_prompt_info_prompt_text);
    }
    if (this.feT) {
      localContentValues.put("prompt_info_jump_text", this.field_prompt_info_jump_text);
    }
    if (this.feU) {
      localContentValues.put("prompt_info_jump_url", this.field_prompt_info_jump_url);
    }
    if (this.ent) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.gi
 * JD-Core Version:    0.7.0.1
 */