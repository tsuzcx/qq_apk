package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eq
  extends c
{
  private static final int cGk;
  private static final int cQq;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int daY = "bindSerial".hashCode();
  private static final int daZ = "cardType".hashCode();
  private static final int dbA;
  private static final int dbB;
  private static final int dbC;
  private static final int dbD;
  private static final int dbE;
  private static final int dbF;
  private static final int dbG;
  private static final int dbH;
  private static final int dbI;
  private static final int dbJ;
  private static final int dba = "bankcardState".hashCode();
  private static final int dbb = "forbidWord".hashCode();
  private static final int dbc = "bankName".hashCode();
  private static final int dbd = "bankcardType".hashCode();
  private static final int dbe = "bankcardTypeName".hashCode();
  private static final int dbf = "bankcardTag".hashCode();
  private static final int dbg = "bankcardTail".hashCode();
  private static final int dbh = "supportTag".hashCode();
  private static final int dbi = "mobile".hashCode();
  private static final int dbj = "trueName".hashCode();
  private static final int dbk;
  private static final int dbl;
  private static final int dbm;
  private static final int dbn;
  private static final int dbo;
  private static final int dbp;
  private static final int dbq;
  private static final int dbr;
  private static final int dbs;
  private static final int dbt;
  private static final int dbu;
  private static final int dbv;
  private static final int dbw;
  private static final int dbx;
  private static final int dby;
  private static final int dbz;
  private boolean cGg = true;
  private boolean cQk = true;
  private boolean daA = true;
  private boolean daB = true;
  private boolean daC = true;
  private boolean daD = true;
  private boolean daE = true;
  private boolean daF = true;
  private boolean daG = true;
  private boolean daH = true;
  private boolean daI = true;
  private boolean daJ = true;
  private boolean daK = true;
  private boolean daL = true;
  private boolean daM = true;
  private boolean daN = true;
  private boolean daO = true;
  private boolean daP = true;
  private boolean daQ = true;
  private boolean daR = true;
  private boolean daS = true;
  private boolean daT = true;
  private boolean daU = true;
  private boolean daV = true;
  private boolean daW = true;
  private boolean daX = true;
  private boolean dal = true;
  private boolean dam = true;
  private boolean dan = true;
  private boolean dao = true;
  private boolean dap = true;
  private boolean daq = true;
  private boolean dar = true;
  private boolean das = true;
  private boolean dat = true;
  private boolean dau = true;
  private boolean dav = true;
  private boolean daw = true;
  private boolean dax = true;
  private boolean daz = true;
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
    cGk = "desc".hashCode();
    dbk = "bankPhone".hashCode();
    dbl = "bizUsername".hashCode();
    dbm = "onceQuotaKind".hashCode();
    dbn = "onceQuotaVirtual".hashCode();
    dbo = "dayQuotaKind".hashCode();
    dbp = "dayQuotaVirtual".hashCode();
    dbq = "fetchArriveTime".hashCode();
    dbr = "fetchArriveTimeWording".hashCode();
    dbs = "repay_url".hashCode();
    dbt = "wxcreditState".hashCode();
    dbu = "bankcardClientType".hashCode();
    dbv = "ext_msg".hashCode();
    dbw = "support_micropay".hashCode();
    dbx = "arrive_type".hashCode();
    dby = "avail_save_wording".hashCode();
    dbz = "fetch_charge_rate".hashCode();
    dbA = "full_fetch_charge_fee".hashCode();
    dbB = "fetch_charge_info".hashCode();
    cQq = "tips".hashCode();
    dbC = "forbid_title".hashCode();
    dbD = "forbid_url".hashCode();
    dbE = "no_micro_word".hashCode();
    dbF = "card_bottom_wording".hashCode();
    dbG = "support_lqt_turn_in".hashCode();
    dbH = "support_lqt_turn_out".hashCode();
    dbI = "is_hightlight_pre_arrive_time_wording".hashCode();
    dbJ = "card_state_name".hashCode();
  }
  
  public void d(Cursor paramCursor)
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
      if (daY != k) {
        break label65;
      }
      this.field_bindSerial = paramCursor.getString(i);
      this.dal = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (daZ == k)
      {
        this.field_cardType = paramCursor.getInt(i);
      }
      else if (dba == k)
      {
        this.field_bankcardState = paramCursor.getInt(i);
      }
      else if (dbb == k)
      {
        this.field_forbidWord = paramCursor.getString(i);
      }
      else if (dbc == k)
      {
        this.field_bankName = paramCursor.getString(i);
      }
      else if (dbd == k)
      {
        this.field_bankcardType = paramCursor.getString(i);
      }
      else if (dbe == k)
      {
        this.field_bankcardTypeName = paramCursor.getString(i);
      }
      else if (dbf == k)
      {
        this.field_bankcardTag = paramCursor.getInt(i);
      }
      else if (dbg == k)
      {
        this.field_bankcardTail = paramCursor.getString(i);
      }
      else if (dbh == k)
      {
        this.field_supportTag = paramCursor.getInt(i);
      }
      else if (dbi == k)
      {
        this.field_mobile = paramCursor.getString(i);
      }
      else if (dbj == k)
      {
        this.field_trueName = paramCursor.getString(i);
      }
      else if (cGk == k)
      {
        this.field_desc = paramCursor.getString(i);
      }
      else if (dbk == k)
      {
        this.field_bankPhone = paramCursor.getString(i);
      }
      else if (dbl == k)
      {
        this.field_bizUsername = paramCursor.getString(i);
      }
      else if (dbm == k)
      {
        this.field_onceQuotaKind = paramCursor.getDouble(i);
      }
      else if (dbn == k)
      {
        this.field_onceQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (dbo == k)
      {
        this.field_dayQuotaKind = paramCursor.getDouble(i);
      }
      else if (dbp == k)
      {
        this.field_dayQuotaVirtual = paramCursor.getDouble(i);
      }
      else if (dbq == k)
      {
        this.field_fetchArriveTime = paramCursor.getLong(i);
      }
      else if (dbr == k)
      {
        this.field_fetchArriveTimeWording = paramCursor.getString(i);
      }
      else if (dbs == k)
      {
        this.field_repay_url = paramCursor.getString(i);
      }
      else if (dbt == k)
      {
        this.field_wxcreditState = paramCursor.getInt(i);
      }
      else if (dbu == k)
      {
        this.field_bankcardClientType = paramCursor.getInt(i);
      }
      else if (dbv == k)
      {
        this.field_ext_msg = paramCursor.getString(i);
      }
      else
      {
        if (dbw == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_support_micropay = bool;
            break;
          }
        }
        if (dbx == k) {
          this.field_arrive_type = paramCursor.getString(i);
        } else if (dby == k) {
          this.field_avail_save_wording = paramCursor.getString(i);
        } else if (dbz == k) {
          this.field_fetch_charge_rate = paramCursor.getDouble(i);
        } else if (dbA == k) {
          this.field_full_fetch_charge_fee = paramCursor.getDouble(i);
        } else if (dbB == k) {
          this.field_fetch_charge_info = paramCursor.getString(i);
        } else if (cQq == k) {
          this.field_tips = paramCursor.getString(i);
        } else if (dbC == k) {
          this.field_forbid_title = paramCursor.getString(i);
        } else if (dbD == k) {
          this.field_forbid_url = paramCursor.getString(i);
        } else if (dbE == k) {
          this.field_no_micro_word = paramCursor.getString(i);
        } else if (dbF == k) {
          this.field_card_bottom_wording = paramCursor.getString(i);
        } else if (dbG == k) {
          this.field_support_lqt_turn_in = paramCursor.getInt(i);
        } else if (dbH == k) {
          this.field_support_lqt_turn_out = paramCursor.getInt(i);
        } else if (dbI == k) {
          this.field_is_hightlight_pre_arrive_time_wording = paramCursor.getInt(i);
        } else if (dbJ == k) {
          this.field_card_state_name = paramCursor.getString(i);
        } else if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dal) {
      localContentValues.put("bindSerial", this.field_bindSerial);
    }
    if (this.dam) {
      localContentValues.put("cardType", Integer.valueOf(this.field_cardType));
    }
    if (this.dan) {
      localContentValues.put("bankcardState", Integer.valueOf(this.field_bankcardState));
    }
    if (this.dao) {
      localContentValues.put("forbidWord", this.field_forbidWord);
    }
    if (this.dap) {
      localContentValues.put("bankName", this.field_bankName);
    }
    if (this.daq) {
      localContentValues.put("bankcardType", this.field_bankcardType);
    }
    if (this.dar) {
      localContentValues.put("bankcardTypeName", this.field_bankcardTypeName);
    }
    if (this.das) {
      localContentValues.put("bankcardTag", Integer.valueOf(this.field_bankcardTag));
    }
    if (this.dat) {
      localContentValues.put("bankcardTail", this.field_bankcardTail);
    }
    if (this.dau) {
      localContentValues.put("supportTag", Integer.valueOf(this.field_supportTag));
    }
    if (this.dav) {
      localContentValues.put("mobile", this.field_mobile);
    }
    if (this.daw) {
      localContentValues.put("trueName", this.field_trueName);
    }
    if (this.cGg) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.dax) {
      localContentValues.put("bankPhone", this.field_bankPhone);
    }
    if (this.daz) {
      localContentValues.put("bizUsername", this.field_bizUsername);
    }
    if (this.daA) {
      localContentValues.put("onceQuotaKind", Double.valueOf(this.field_onceQuotaKind));
    }
    if (this.daB) {
      localContentValues.put("onceQuotaVirtual", Double.valueOf(this.field_onceQuotaVirtual));
    }
    if (this.daC) {
      localContentValues.put("dayQuotaKind", Double.valueOf(this.field_dayQuotaKind));
    }
    if (this.daD) {
      localContentValues.put("dayQuotaVirtual", Double.valueOf(this.field_dayQuotaVirtual));
    }
    if (this.daE) {
      localContentValues.put("fetchArriveTime", Long.valueOf(this.field_fetchArriveTime));
    }
    if (this.daF) {
      localContentValues.put("fetchArriveTimeWording", this.field_fetchArriveTimeWording);
    }
    if (this.daG) {
      localContentValues.put("repay_url", this.field_repay_url);
    }
    if (this.daH) {
      localContentValues.put("wxcreditState", Integer.valueOf(this.field_wxcreditState));
    }
    if (this.daI) {
      localContentValues.put("bankcardClientType", Integer.valueOf(this.field_bankcardClientType));
    }
    if (this.daJ) {
      localContentValues.put("ext_msg", this.field_ext_msg);
    }
    if (this.daK) {
      localContentValues.put("support_micropay", Boolean.valueOf(this.field_support_micropay));
    }
    if (this.daL) {
      localContentValues.put("arrive_type", this.field_arrive_type);
    }
    if (this.daM) {
      localContentValues.put("avail_save_wording", this.field_avail_save_wording);
    }
    if (this.daN) {
      localContentValues.put("fetch_charge_rate", Double.valueOf(this.field_fetch_charge_rate));
    }
    if (this.daO) {
      localContentValues.put("full_fetch_charge_fee", Double.valueOf(this.field_full_fetch_charge_fee));
    }
    if (this.daP) {
      localContentValues.put("fetch_charge_info", this.field_fetch_charge_info);
    }
    if (this.cQk) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.daQ) {
      localContentValues.put("forbid_title", this.field_forbid_title);
    }
    if (this.daR) {
      localContentValues.put("forbid_url", this.field_forbid_url);
    }
    if (this.daS) {
      localContentValues.put("no_micro_word", this.field_no_micro_word);
    }
    if (this.daT) {
      localContentValues.put("card_bottom_wording", this.field_card_bottom_wording);
    }
    if (this.daU) {
      localContentValues.put("support_lqt_turn_in", Integer.valueOf(this.field_support_lqt_turn_in));
    }
    if (this.daV) {
      localContentValues.put("support_lqt_turn_out", Integer.valueOf(this.field_support_lqt_turn_out));
    }
    if (this.daW) {
      localContentValues.put("is_hightlight_pre_arrive_time_wording", Integer.valueOf(this.field_is_hightlight_pre_arrive_time_wording));
    }
    if (this.daX) {
      localContentValues.put("card_state_name", this.field_card_state_name);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.eq
 * JD-Core Version:    0.7.0.1
 */