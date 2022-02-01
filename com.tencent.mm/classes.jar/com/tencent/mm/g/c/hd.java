package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hd
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fPO;
  private static final int fyW;
  private static final int gdV = "bindSerial".hashCode();
  private static final int gdW = "cardType".hashCode();
  private static final int gdX = "bankcardState".hashCode();
  private static final int gdY = "forbidWord".hashCode();
  private static final int gdZ = "bankName".hashCode();
  private static final int geA = "forbid_url".hashCode();
  private static final int geB = "no_micro_word".hashCode();
  private static final int geC = "card_bottom_wording".hashCode();
  private static final int geD = "support_lqt_turn_in".hashCode();
  private static final int geE = "support_lqt_turn_out".hashCode();
  private static final int geF = "is_hightlight_pre_arrive_time_wording".hashCode();
  private static final int geG = "card_state_name".hashCode();
  private static final int geH = "prompt_info_prompt_text".hashCode();
  private static final int geI = "prompt_info_jump_text".hashCode();
  private static final int geJ = "prompt_info_jump_url".hashCode();
  private static final int gea = "bankcardType".hashCode();
  private static final int geb = "bankcardTypeName".hashCode();
  private static final int gec = "bankcardTag".hashCode();
  private static final int ged = "bankcardTail".hashCode();
  private static final int gee = "supportTag".hashCode();
  private static final int gef = "mobile".hashCode();
  private static final int geg = "trueName".hashCode();
  private static final int geh;
  private static final int gei;
  private static final int gej;
  private static final int gek;
  private static final int gel;
  private static final int gem;
  private static final int gen;
  private static final int geo;
  private static final int gep;
  private static final int geq;
  private static final int ger;
  private static final int ges;
  private static final int get;
  private static final int geu;
  private static final int gev;
  private static final int gew;
  private static final int gex;
  private static final int gey;
  private static final int gez;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fPI = true;
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
  private boolean fyS = true;
  private boolean gdA = true;
  private boolean gdB = true;
  private boolean gdC = true;
  private boolean gdD = true;
  private boolean gdE = true;
  private boolean gdF = true;
  private boolean gdG = true;
  private boolean gdH = true;
  private boolean gdI = true;
  private boolean gdJ = true;
  private boolean gdK = true;
  private boolean gdL = true;
  private boolean gdM = true;
  private boolean gdN = true;
  private boolean gdO = true;
  private boolean gdP = true;
  private boolean gdQ = true;
  private boolean gdR = true;
  private boolean gdS = true;
  private boolean gdT = true;
  private boolean gdU = true;
  private boolean gdg = true;
  private boolean gdh = true;
  private boolean gdi = true;
  private boolean gdj = true;
  private boolean gdk = true;
  private boolean gdl = true;
  private boolean gdm = true;
  private boolean gdn = true;
  private boolean gdo = true;
  private boolean gdp = true;
  private boolean gdq = true;
  private boolean gdr = true;
  private boolean gds = true;
  private boolean gdt = true;
  private boolean gdu = true;
  private boolean gdv = true;
  private boolean gdw = true;
  private boolean gdx = true;
  private boolean gdy = true;
  private boolean gdz = true;
  
  static
  {
    fyW = "desc".hashCode();
    geh = "bankPhone".hashCode();
    gei = "bizUsername".hashCode();
    gej = "onceQuotaKind".hashCode();
    gek = "onceQuotaVirtual".hashCode();
    gel = "dayQuotaKind".hashCode();
    gem = "dayQuotaVirtual".hashCode();
    gen = "fetchArriveTime".hashCode();
    geo = "fetchArriveTimeWording".hashCode();
    gep = "repay_url".hashCode();
    geq = "wxcreditState".hashCode();
    ger = "bankcardClientType".hashCode();
    ges = "ext_msg".hashCode();
    get = "support_micropay".hashCode();
    geu = "arrive_type".hashCode();
    gev = "avail_save_wording".hashCode();
    gew = "fetch_charge_rate".hashCode();
    gex = "full_fetch_charge_fee".hashCode();
    gey = "fetch_charge_info".hashCode();
    fPO = "tips".hashCode();
    gez = "forbid_title".hashCode();
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
      if (gdV != k) {
        break label65;
      }
      this.field_bindSerial = paramCursor.getString(i);
      this.gdg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (gdW == k)
      {
        this.field_cardType = paramCursor.getInt(i);
      }
      else if (gdX == k)
      {
        this.field_bankcardState = paramCursor.getInt(i);
      }
      else if (gdY == k)
      {
        this.field_forbidWord = paramCursor.getString(i);
      }
      else if (gdZ == k)
      {
        this.field_bankName = paramCursor.getString(i);
      }
      else if (gea == k)
      {
        this.field_bankcardType = paramCursor.getString(i);
      }
      else if (geb == k)
      {
        this.field_bankcardTypeName = paramCursor.getString(i);
      }
      else if (gec == k)
      {
        this.field_bankcardTag = paramCursor.getInt(i);
      }
      else if (ged == k)
      {
        this.field_bankcardTail = paramCursor.getString(i);
      }
      else if (gee == k)
      {
        this.field_supportTag = paramCursor.getInt(i);
      }
      else if (gef == k)
      {
        this.field_mobile = paramCursor.getString(i);
      }
      else if (geg == k)
      {
        this.field_trueName = paramCursor.getString(i);
      }
      else if (fyW == k)
      {
        this.field_desc = paramCursor.getString(i);
      }
      else if (geh == k)
      {
        this.field_bankPhone = paramCursor.getString(i);
      }
      else if (gei == k)
      {
        this.field_bizUsername = paramCursor.getString(i);
      }
      else if (gej == k)
      {
        this.field_onceQuotaKind = paramCursor.getDouble(i);
      }
      else if (gek == k)
      {
        this.field_onceQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (gel == k)
      {
        this.field_dayQuotaKind = paramCursor.getDouble(i);
      }
      else if (gem == k)
      {
        this.field_dayQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (gen == k)
      {
        this.field_fetchArriveTime = paramCursor.getLong(i);
      }
      else if (geo == k)
      {
        this.field_fetchArriveTimeWording = paramCursor.getString(i);
      }
      else if (gep == k)
      {
        this.field_repay_url = paramCursor.getString(i);
      }
      else if (geq == k)
      {
        this.field_wxcreditState = paramCursor.getInt(i);
      }
      else if (ger == k)
      {
        this.field_bankcardClientType = paramCursor.getInt(i);
      }
      else if (ges == k)
      {
        this.field_ext_msg = paramCursor.getString(i);
      }
      else
      {
        if (get == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_support_micropay = bool;
            break;
          }
        }
        if (geu == k) {
          this.field_arrive_type = paramCursor.getString(i);
        } else if (gev == k) {
          this.field_avail_save_wording = paramCursor.getString(i);
        } else if (gew == k) {
          this.field_fetch_charge_rate = paramCursor.getDouble(i);
        } else if (gex == k) {
          this.field_full_fetch_charge_fee = paramCursor.getDouble(i);
        } else if (gey == k) {
          this.field_fetch_charge_info = paramCursor.getString(i);
        } else if (fPO == k) {
          this.field_tips = paramCursor.getString(i);
        } else if (gez == k) {
          this.field_forbid_title = paramCursor.getString(i);
        } else if (geA == k) {
          this.field_forbid_url = paramCursor.getString(i);
        } else if (geB == k) {
          this.field_no_micro_word = paramCursor.getString(i);
        } else if (geC == k) {
          this.field_card_bottom_wording = paramCursor.getString(i);
        } else if (geD == k) {
          this.field_support_lqt_turn_in = paramCursor.getInt(i);
        } else if (geE == k) {
          this.field_support_lqt_turn_out = paramCursor.getInt(i);
        } else if (geF == k) {
          this.field_is_hightlight_pre_arrive_time_wording = paramCursor.getInt(i);
        } else if (geG == k) {
          this.field_card_state_name = paramCursor.getString(i);
        } else if (geH == k) {
          this.field_prompt_info_prompt_text = paramCursor.getString(i);
        } else if (geI == k) {
          this.field_prompt_info_jump_text = paramCursor.getString(i);
        } else if (geJ == k) {
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
    if (this.gdg) {
      localContentValues.put("bindSerial", this.field_bindSerial);
    }
    if (this.gdh) {
      localContentValues.put("cardType", Integer.valueOf(this.field_cardType));
    }
    if (this.gdi) {
      localContentValues.put("bankcardState", Integer.valueOf(this.field_bankcardState));
    }
    if (this.gdj) {
      localContentValues.put("forbidWord", this.field_forbidWord);
    }
    if (this.gdk) {
      localContentValues.put("bankName", this.field_bankName);
    }
    if (this.gdl) {
      localContentValues.put("bankcardType", this.field_bankcardType);
    }
    if (this.gdm) {
      localContentValues.put("bankcardTypeName", this.field_bankcardTypeName);
    }
    if (this.gdn) {
      localContentValues.put("bankcardTag", Integer.valueOf(this.field_bankcardTag));
    }
    if (this.gdo) {
      localContentValues.put("bankcardTail", this.field_bankcardTail);
    }
    if (this.gdp) {
      localContentValues.put("supportTag", Integer.valueOf(this.field_supportTag));
    }
    if (this.gdq) {
      localContentValues.put("mobile", this.field_mobile);
    }
    if (this.gdr) {
      localContentValues.put("trueName", this.field_trueName);
    }
    if (this.fyS) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.gds) {
      localContentValues.put("bankPhone", this.field_bankPhone);
    }
    if (this.gdt) {
      localContentValues.put("bizUsername", this.field_bizUsername);
    }
    if (this.gdu) {
      localContentValues.put("onceQuotaKind", Double.valueOf(this.field_onceQuotaKind));
    }
    if (this.gdv) {
      localContentValues.put("onceQuotaVirtual", Double.valueOf(this.field_onceQuotaVirtual));
    }
    if (this.gdw) {
      localContentValues.put("dayQuotaKind", Double.valueOf(this.field_dayQuotaKind));
    }
    if (this.gdx) {
      localContentValues.put("dayQuotaVirtual", Double.valueOf(this.field_dayQuotaVirtual));
    }
    if (this.gdy) {
      localContentValues.put("fetchArriveTime", Long.valueOf(this.field_fetchArriveTime));
    }
    if (this.gdz) {
      localContentValues.put("fetchArriveTimeWording", this.field_fetchArriveTimeWording);
    }
    if (this.gdA) {
      localContentValues.put("repay_url", this.field_repay_url);
    }
    if (this.gdB) {
      localContentValues.put("wxcreditState", Integer.valueOf(this.field_wxcreditState));
    }
    if (this.gdC) {
      localContentValues.put("bankcardClientType", Integer.valueOf(this.field_bankcardClientType));
    }
    if (this.gdD) {
      localContentValues.put("ext_msg", this.field_ext_msg);
    }
    if (this.gdE) {
      localContentValues.put("support_micropay", Boolean.valueOf(this.field_support_micropay));
    }
    if (this.gdF) {
      localContentValues.put("arrive_type", this.field_arrive_type);
    }
    if (this.gdG) {
      localContentValues.put("avail_save_wording", this.field_avail_save_wording);
    }
    if (this.gdH) {
      localContentValues.put("fetch_charge_rate", Double.valueOf(this.field_fetch_charge_rate));
    }
    if (this.gdI) {
      localContentValues.put("full_fetch_charge_fee", Double.valueOf(this.field_full_fetch_charge_fee));
    }
    if (this.gdJ) {
      localContentValues.put("fetch_charge_info", this.field_fetch_charge_info);
    }
    if (this.fPI) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.gdK) {
      localContentValues.put("forbid_title", this.field_forbid_title);
    }
    if (this.gdL) {
      localContentValues.put("forbid_url", this.field_forbid_url);
    }
    if (this.gdM) {
      localContentValues.put("no_micro_word", this.field_no_micro_word);
    }
    if (this.gdN) {
      localContentValues.put("card_bottom_wording", this.field_card_bottom_wording);
    }
    if (this.gdO) {
      localContentValues.put("support_lqt_turn_in", Integer.valueOf(this.field_support_lqt_turn_in));
    }
    if (this.gdP) {
      localContentValues.put("support_lqt_turn_out", Integer.valueOf(this.field_support_lqt_turn_out));
    }
    if (this.gdQ) {
      localContentValues.put("is_hightlight_pre_arrive_time_wording", Integer.valueOf(this.field_is_hightlight_pre_arrive_time_wording));
    }
    if (this.gdR) {
      localContentValues.put("card_state_name", this.field_card_state_name);
    }
    if (this.gdS) {
      localContentValues.put("prompt_info_prompt_text", this.field_prompt_info_prompt_text);
    }
    if (this.gdT) {
      localContentValues.put("prompt_info_jump_text", this.field_prompt_info_jump_text);
    }
    if (this.gdU) {
      localContentValues.put("prompt_info_jump_url", this.field_prompt_info_jump_url);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.c.hd
 * JD-Core Version:    0.7.0.1
 */