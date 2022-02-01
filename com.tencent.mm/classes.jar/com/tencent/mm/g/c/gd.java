package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gd
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eNM = "tips".hashCode();
  private static final int ezO;
  private static final int fbG = "bindSerial".hashCode();
  private static final int fbH = "cardType".hashCode();
  private static final int fbI = "bankcardState".hashCode();
  private static final int fbJ = "forbidWord".hashCode();
  private static final int fbK = "bankName".hashCode();
  private static final int fbL = "bankcardType".hashCode();
  private static final int fbM = "bankcardTypeName".hashCode();
  private static final int fbN = "bankcardTag".hashCode();
  private static final int fbO = "bankcardTail".hashCode();
  private static final int fbP = "supportTag".hashCode();
  private static final int fbQ = "mobile".hashCode();
  private static final int fbR = "trueName".hashCode();
  private static final int fbS;
  private static final int fbT;
  private static final int fbU;
  private static final int fbV;
  private static final int fbW;
  private static final int fbX;
  private static final int fbY;
  private static final int fbZ;
  private static final int fca;
  private static final int fcb;
  private static final int fcc;
  private static final int fcd;
  private static final int fce;
  private static final int fcf;
  private static final int fcg;
  private static final int fch;
  private static final int fci;
  private static final int fcj;
  private static final int fck = "forbid_title".hashCode();
  private static final int fcl = "forbid_url".hashCode();
  private static final int fcm = "no_micro_word".hashCode();
  private static final int fcn = "card_bottom_wording".hashCode();
  private static final int fco = "support_lqt_turn_in".hashCode();
  private static final int fcp = "support_lqt_turn_out".hashCode();
  private static final int fcq = "is_hightlight_pre_arrive_time_wording".hashCode();
  private static final int fcr = "card_state_name".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eNG = true;
  private boolean ezK = true;
  private boolean faU = true;
  private boolean faV = true;
  private boolean faW = true;
  private boolean faX = true;
  private boolean faY = true;
  private boolean faZ = true;
  private boolean fbA = true;
  private boolean fbB = true;
  private boolean fbC = true;
  private boolean fbD = true;
  private boolean fbE = true;
  private boolean fbF = true;
  private boolean fba = true;
  private boolean fbb = true;
  private boolean fbc = true;
  private boolean fbd = true;
  private boolean fbe = true;
  private boolean fbf = true;
  private boolean fbg = true;
  private boolean fbh = true;
  private boolean fbi = true;
  private boolean fbj = true;
  private boolean fbk = true;
  private boolean fbl = true;
  private boolean fbm = true;
  private boolean fbn = true;
  private boolean fbo = true;
  private boolean fbp = true;
  private boolean fbq = true;
  private boolean fbr = true;
  private boolean fbs = true;
  private boolean fbt = true;
  private boolean fbu = true;
  private boolean fbv = true;
  private boolean fbw = true;
  private boolean fbx = true;
  private boolean fby = true;
  private boolean fbz = true;
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
    ezO = "desc".hashCode();
    fbS = "bankPhone".hashCode();
    fbT = "bizUsername".hashCode();
    fbU = "onceQuotaKind".hashCode();
    fbV = "onceQuotaVirtual".hashCode();
    fbW = "dayQuotaKind".hashCode();
    fbX = "dayQuotaVirtual".hashCode();
    fbY = "fetchArriveTime".hashCode();
    fbZ = "fetchArriveTimeWording".hashCode();
    fca = "repay_url".hashCode();
    fcb = "wxcreditState".hashCode();
    fcc = "bankcardClientType".hashCode();
    fcd = "ext_msg".hashCode();
    fce = "support_micropay".hashCode();
    fcf = "arrive_type".hashCode();
    fcg = "avail_save_wording".hashCode();
    fch = "fetch_charge_rate".hashCode();
    fci = "full_fetch_charge_fee".hashCode();
    fcj = "fetch_charge_info".hashCode();
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
      if (fbG != k) {
        break label65;
      }
      this.field_bindSerial = paramCursor.getString(i);
      this.faU = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fbH == k)
      {
        this.field_cardType = paramCursor.getInt(i);
      }
      else if (fbI == k)
      {
        this.field_bankcardState = paramCursor.getInt(i);
      }
      else if (fbJ == k)
      {
        this.field_forbidWord = paramCursor.getString(i);
      }
      else if (fbK == k)
      {
        this.field_bankName = paramCursor.getString(i);
      }
      else if (fbL == k)
      {
        this.field_bankcardType = paramCursor.getString(i);
      }
      else if (fbM == k)
      {
        this.field_bankcardTypeName = paramCursor.getString(i);
      }
      else if (fbN == k)
      {
        this.field_bankcardTag = paramCursor.getInt(i);
      }
      else if (fbO == k)
      {
        this.field_bankcardTail = paramCursor.getString(i);
      }
      else if (fbP == k)
      {
        this.field_supportTag = paramCursor.getInt(i);
      }
      else if (fbQ == k)
      {
        this.field_mobile = paramCursor.getString(i);
      }
      else if (fbR == k)
      {
        this.field_trueName = paramCursor.getString(i);
      }
      else if (ezO == k)
      {
        this.field_desc = paramCursor.getString(i);
      }
      else if (fbS == k)
      {
        this.field_bankPhone = paramCursor.getString(i);
      }
      else if (fbT == k)
      {
        this.field_bizUsername = paramCursor.getString(i);
      }
      else if (fbU == k)
      {
        this.field_onceQuotaKind = paramCursor.getDouble(i);
      }
      else if (fbV == k)
      {
        this.field_onceQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (fbW == k)
      {
        this.field_dayQuotaKind = paramCursor.getDouble(i);
      }
      else if (fbX == k)
      {
        this.field_dayQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (fbY == k)
      {
        this.field_fetchArriveTime = paramCursor.getLong(i);
      }
      else if (fbZ == k)
      {
        this.field_fetchArriveTimeWording = paramCursor.getString(i);
      }
      else if (fca == k)
      {
        this.field_repay_url = paramCursor.getString(i);
      }
      else if (fcb == k)
      {
        this.field_wxcreditState = paramCursor.getInt(i);
      }
      else if (fcc == k)
      {
        this.field_bankcardClientType = paramCursor.getInt(i);
      }
      else if (fcd == k)
      {
        this.field_ext_msg = paramCursor.getString(i);
      }
      else
      {
        if (fce == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_support_micropay = bool;
            break;
          }
        }
        if (fcf == k) {
          this.field_arrive_type = paramCursor.getString(i);
        } else if (fcg == k) {
          this.field_avail_save_wording = paramCursor.getString(i);
        } else if (fch == k) {
          this.field_fetch_charge_rate = paramCursor.getDouble(i);
        } else if (fci == k) {
          this.field_full_fetch_charge_fee = paramCursor.getDouble(i);
        } else if (fcj == k) {
          this.field_fetch_charge_info = paramCursor.getString(i);
        } else if (eNM == k) {
          this.field_tips = paramCursor.getString(i);
        } else if (fck == k) {
          this.field_forbid_title = paramCursor.getString(i);
        } else if (fcl == k) {
          this.field_forbid_url = paramCursor.getString(i);
        } else if (fcm == k) {
          this.field_no_micro_word = paramCursor.getString(i);
        } else if (fcn == k) {
          this.field_card_bottom_wording = paramCursor.getString(i);
        } else if (fco == k) {
          this.field_support_lqt_turn_in = paramCursor.getInt(i);
        } else if (fcp == k) {
          this.field_support_lqt_turn_out = paramCursor.getInt(i);
        } else if (fcq == k) {
          this.field_is_hightlight_pre_arrive_time_wording = paramCursor.getInt(i);
        } else if (fcr == k) {
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
    if (this.faU) {
      localContentValues.put("bindSerial", this.field_bindSerial);
    }
    if (this.faV) {
      localContentValues.put("cardType", Integer.valueOf(this.field_cardType));
    }
    if (this.faW) {
      localContentValues.put("bankcardState", Integer.valueOf(this.field_bankcardState));
    }
    if (this.faX) {
      localContentValues.put("forbidWord", this.field_forbidWord);
    }
    if (this.faY) {
      localContentValues.put("bankName", this.field_bankName);
    }
    if (this.faZ) {
      localContentValues.put("bankcardType", this.field_bankcardType);
    }
    if (this.fba) {
      localContentValues.put("bankcardTypeName", this.field_bankcardTypeName);
    }
    if (this.fbb) {
      localContentValues.put("bankcardTag", Integer.valueOf(this.field_bankcardTag));
    }
    if (this.fbc) {
      localContentValues.put("bankcardTail", this.field_bankcardTail);
    }
    if (this.fbd) {
      localContentValues.put("supportTag", Integer.valueOf(this.field_supportTag));
    }
    if (this.fbe) {
      localContentValues.put("mobile", this.field_mobile);
    }
    if (this.fbf) {
      localContentValues.put("trueName", this.field_trueName);
    }
    if (this.ezK) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.fbg) {
      localContentValues.put("bankPhone", this.field_bankPhone);
    }
    if (this.fbh) {
      localContentValues.put("bizUsername", this.field_bizUsername);
    }
    if (this.fbi) {
      localContentValues.put("onceQuotaKind", Double.valueOf(this.field_onceQuotaKind));
    }
    if (this.fbj) {
      localContentValues.put("onceQuotaVirtual", Double.valueOf(this.field_onceQuotaVirtual));
    }
    if (this.fbk) {
      localContentValues.put("dayQuotaKind", Double.valueOf(this.field_dayQuotaKind));
    }
    if (this.fbl) {
      localContentValues.put("dayQuotaVirtual", Double.valueOf(this.field_dayQuotaVirtual));
    }
    if (this.fbm) {
      localContentValues.put("fetchArriveTime", Long.valueOf(this.field_fetchArriveTime));
    }
    if (this.fbn) {
      localContentValues.put("fetchArriveTimeWording", this.field_fetchArriveTimeWording);
    }
    if (this.fbo) {
      localContentValues.put("repay_url", this.field_repay_url);
    }
    if (this.fbp) {
      localContentValues.put("wxcreditState", Integer.valueOf(this.field_wxcreditState));
    }
    if (this.fbq) {
      localContentValues.put("bankcardClientType", Integer.valueOf(this.field_bankcardClientType));
    }
    if (this.fbr) {
      localContentValues.put("ext_msg", this.field_ext_msg);
    }
    if (this.fbs) {
      localContentValues.put("support_micropay", Boolean.valueOf(this.field_support_micropay));
    }
    if (this.fbt) {
      localContentValues.put("arrive_type", this.field_arrive_type);
    }
    if (this.fbu) {
      localContentValues.put("avail_save_wording", this.field_avail_save_wording);
    }
    if (this.fbv) {
      localContentValues.put("fetch_charge_rate", Double.valueOf(this.field_fetch_charge_rate));
    }
    if (this.fbw) {
      localContentValues.put("full_fetch_charge_fee", Double.valueOf(this.field_full_fetch_charge_fee));
    }
    if (this.fbx) {
      localContentValues.put("fetch_charge_info", this.field_fetch_charge_info);
    }
    if (this.eNG) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.fby) {
      localContentValues.put("forbid_title", this.field_forbid_title);
    }
    if (this.fbz) {
      localContentValues.put("forbid_url", this.field_forbid_url);
    }
    if (this.fbA) {
      localContentValues.put("no_micro_word", this.field_no_micro_word);
    }
    if (this.fbB) {
      localContentValues.put("card_bottom_wording", this.field_card_bottom_wording);
    }
    if (this.fbC) {
      localContentValues.put("support_lqt_turn_in", Integer.valueOf(this.field_support_lqt_turn_in));
    }
    if (this.fbD) {
      localContentValues.put("support_lqt_turn_out", Integer.valueOf(this.field_support_lqt_turn_out));
    }
    if (this.fbE) {
      localContentValues.put("is_hightlight_pre_arrive_time_wording", Integer.valueOf(this.field_is_hightlight_pre_arrive_time_wording));
    }
    if (this.fbF) {
      localContentValues.put("card_state_name", this.field_card_state_name);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.gd
 * JD-Core Version:    0.7.0.1
 */