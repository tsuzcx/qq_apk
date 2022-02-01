package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fcW = "wallet_balance".hashCode();
  private static final int feA;
  private static final int feB;
  private static final int feC;
  private static final int feD;
  private static final int feE = "wallet_entrance_balance_switch_state".hashCode();
  private static final int feF = "soter_pay_open_type".hashCode();
  private static final int feb = "uin".hashCode();
  private static final int fec = "is_reg".hashCode();
  private static final int fed = "true_name".hashCode();
  private static final int fee = "card_num".hashCode();
  private static final int fef = "isDomesticUser".hashCode();
  private static final int feg = "cre_type".hashCode();
  private static final int feh = "main_card_bind_serialno".hashCode();
  private static final int fei = "ftf_pay_url".hashCode();
  private static final int fej = "switchConfig".hashCode();
  private static final int fek = "reset_passwd_flag".hashCode();
  private static final int fel = "find_passwd_url".hashCode();
  private static final int fem = "is_open_touch".hashCode();
  private static final int fen = "lct_wording".hashCode();
  private static final int feo = "lct_url".hashCode();
  private static final int fep = "cre_name".hashCode();
  private static final int feq = "lqt_state".hashCode();
  private static final int fer = "paymenu_use_new".hashCode();
  private static final int fes = "is_show_lqb".hashCode();
  private static final int fet = "is_open_lqb".hashCode();
  private static final int feu = "lqb_open_url".hashCode();
  private static final int fev = "lqt_cell_is_show".hashCode();
  private static final int few = "lqt_cell_icon".hashCode();
  private static final int fex = "lqt_cell_is_open_lqt".hashCode();
  private static final int fey = "lqt_cell_lqt_open_url".hashCode();
  private static final int fez = "lqt_cell_lqt_title".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fcQ = true;
  private boolean fdA = true;
  private boolean fdB = true;
  private boolean fdC = true;
  private boolean fdD = true;
  private boolean fdE = true;
  private boolean fdF = true;
  private boolean fdG = true;
  private boolean fdH = true;
  private boolean fdI = true;
  private boolean fdJ = true;
  private boolean fdK = true;
  private boolean fdL = true;
  private boolean fdM = true;
  private boolean fdN = true;
  private boolean fdO = true;
  private boolean fdP = true;
  private boolean fdQ = true;
  private boolean fdR = true;
  private boolean fdS = true;
  private boolean fdT = true;
  private boolean fdU = true;
  private boolean fdV = true;
  private boolean fdW = true;
  private boolean fdX = true;
  private boolean fdY = true;
  private boolean fdZ = true;
  private boolean fdw = true;
  private boolean fdx = true;
  private boolean fdy = true;
  private boolean fdz = true;
  private boolean fea = true;
  public String field_bank_priority;
  public int field_card_num;
  public String field_cre_name;
  public int field_cre_type;
  public String field_find_passwd_url;
  public String field_forget_passwd_url;
  public String field_ftf_pay_url;
  public boolean field_isDomesticUser;
  public int field_is_open_lqb;
  public int field_is_open_touch;
  public int field_is_reg;
  public int field_is_show_lqb;
  public String field_lct_url;
  public String field_lct_wording;
  public String field_lqb_open_url;
  public String field_lqt_cell_icon;
  public int field_lqt_cell_is_open_lqt;
  public int field_lqt_cell_is_show;
  public String field_lqt_cell_lqt_open_url;
  public String field_lqt_cell_lqt_title;
  public String field_lqt_cell_lqt_wording;
  public int field_lqt_state;
  public String field_main_card_bind_serialno;
  public int field_paymenu_use_new;
  public String field_reset_passwd_flag;
  public int field_soter_pay_open_type;
  public int field_switchConfig;
  public String field_true_name;
  public String field_uin;
  public int field_unipay_order_state;
  public long field_wallet_balance;
  public int field_wallet_entrance_balance_switch_state;
  
  static
  {
    feA = "lqt_cell_lqt_wording".hashCode();
    feB = "forget_passwd_url".hashCode();
    feC = "unipay_order_state".hashCode();
    feD = "bank_priority".hashCode();
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
      if (feb != k) {
        break label65;
      }
      this.field_uin = paramCursor.getString(i);
      this.fdw = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fec == k)
      {
        this.field_is_reg = paramCursor.getInt(i);
      }
      else if (fed == k)
      {
        this.field_true_name = paramCursor.getString(i);
      }
      else if (fee == k)
      {
        this.field_card_num = paramCursor.getInt(i);
      }
      else
      {
        if (fef == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isDomesticUser = bool;
            break;
          }
        }
        if (feg == k) {
          this.field_cre_type = paramCursor.getInt(i);
        } else if (feh == k) {
          this.field_main_card_bind_serialno = paramCursor.getString(i);
        } else if (fei == k) {
          this.field_ftf_pay_url = paramCursor.getString(i);
        } else if (fej == k) {
          this.field_switchConfig = paramCursor.getInt(i);
        } else if (fek == k) {
          this.field_reset_passwd_flag = paramCursor.getString(i);
        } else if (fel == k) {
          this.field_find_passwd_url = paramCursor.getString(i);
        } else if (fem == k) {
          this.field_is_open_touch = paramCursor.getInt(i);
        } else if (fen == k) {
          this.field_lct_wording = paramCursor.getString(i);
        } else if (feo == k) {
          this.field_lct_url = paramCursor.getString(i);
        } else if (fep == k) {
          this.field_cre_name = paramCursor.getString(i);
        } else if (feq == k) {
          this.field_lqt_state = paramCursor.getInt(i);
        } else if (fer == k) {
          this.field_paymenu_use_new = paramCursor.getInt(i);
        } else if (fes == k) {
          this.field_is_show_lqb = paramCursor.getInt(i);
        } else if (fet == k) {
          this.field_is_open_lqb = paramCursor.getInt(i);
        } else if (feu == k) {
          this.field_lqb_open_url = paramCursor.getString(i);
        } else if (fev == k) {
          this.field_lqt_cell_is_show = paramCursor.getInt(i);
        } else if (few == k) {
          this.field_lqt_cell_icon = paramCursor.getString(i);
        } else if (fex == k) {
          this.field_lqt_cell_is_open_lqt = paramCursor.getInt(i);
        } else if (fey == k) {
          this.field_lqt_cell_lqt_open_url = paramCursor.getString(i);
        } else if (fez == k) {
          this.field_lqt_cell_lqt_title = paramCursor.getString(i);
        } else if (feA == k) {
          this.field_lqt_cell_lqt_wording = paramCursor.getString(i);
        } else if (feB == k) {
          this.field_forget_passwd_url = paramCursor.getString(i);
        } else if (feC == k) {
          this.field_unipay_order_state = paramCursor.getInt(i);
        } else if (feD == k) {
          this.field_bank_priority = paramCursor.getString(i);
        } else if (fcW == k) {
          this.field_wallet_balance = paramCursor.getLong(i);
        } else if (feE == k) {
          this.field_wallet_entrance_balance_switch_state = paramCursor.getInt(i);
        } else if (feF == k) {
          this.field_soter_pay_open_type = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fdw) {
      localContentValues.put("uin", this.field_uin);
    }
    if (this.fdx) {
      localContentValues.put("is_reg", Integer.valueOf(this.field_is_reg));
    }
    if (this.fdy) {
      localContentValues.put("true_name", this.field_true_name);
    }
    if (this.fdz) {
      localContentValues.put("card_num", Integer.valueOf(this.field_card_num));
    }
    if (this.fdA) {
      localContentValues.put("isDomesticUser", Boolean.valueOf(this.field_isDomesticUser));
    }
    if (this.fdB) {
      localContentValues.put("cre_type", Integer.valueOf(this.field_cre_type));
    }
    if (this.fdC) {
      localContentValues.put("main_card_bind_serialno", this.field_main_card_bind_serialno);
    }
    if (this.fdD) {
      localContentValues.put("ftf_pay_url", this.field_ftf_pay_url);
    }
    if (this.fdE) {
      localContentValues.put("switchConfig", Integer.valueOf(this.field_switchConfig));
    }
    if (this.fdF) {
      localContentValues.put("reset_passwd_flag", this.field_reset_passwd_flag);
    }
    if (this.fdG) {
      localContentValues.put("find_passwd_url", this.field_find_passwd_url);
    }
    if (this.fdH) {
      localContentValues.put("is_open_touch", Integer.valueOf(this.field_is_open_touch));
    }
    if (this.fdI) {
      localContentValues.put("lct_wording", this.field_lct_wording);
    }
    if (this.fdJ) {
      localContentValues.put("lct_url", this.field_lct_url);
    }
    if (this.fdK) {
      localContentValues.put("cre_name", this.field_cre_name);
    }
    if (this.fdL) {
      localContentValues.put("lqt_state", Integer.valueOf(this.field_lqt_state));
    }
    if (this.fdM) {
      localContentValues.put("paymenu_use_new", Integer.valueOf(this.field_paymenu_use_new));
    }
    if (this.fdN) {
      localContentValues.put("is_show_lqb", Integer.valueOf(this.field_is_show_lqb));
    }
    if (this.fdO) {
      localContentValues.put("is_open_lqb", Integer.valueOf(this.field_is_open_lqb));
    }
    if (this.fdP) {
      localContentValues.put("lqb_open_url", this.field_lqb_open_url);
    }
    if (this.fdQ) {
      localContentValues.put("lqt_cell_is_show", Integer.valueOf(this.field_lqt_cell_is_show));
    }
    if (this.fdR) {
      localContentValues.put("lqt_cell_icon", this.field_lqt_cell_icon);
    }
    if (this.fdS) {
      localContentValues.put("lqt_cell_is_open_lqt", Integer.valueOf(this.field_lqt_cell_is_open_lqt));
    }
    if (this.fdT) {
      localContentValues.put("lqt_cell_lqt_open_url", this.field_lqt_cell_lqt_open_url);
    }
    if (this.fdU) {
      localContentValues.put("lqt_cell_lqt_title", this.field_lqt_cell_lqt_title);
    }
    if (this.fdV) {
      localContentValues.put("lqt_cell_lqt_wording", this.field_lqt_cell_lqt_wording);
    }
    if (this.fdW) {
      localContentValues.put("forget_passwd_url", this.field_forget_passwd_url);
    }
    if (this.fdX) {
      localContentValues.put("unipay_order_state", Integer.valueOf(this.field_unipay_order_state));
    }
    if (this.fdY) {
      localContentValues.put("bank_priority", this.field_bank_priority);
    }
    if (this.fcQ) {
      localContentValues.put("wallet_balance", Long.valueOf(this.field_wallet_balance));
    }
    if (this.fdZ) {
      localContentValues.put("wallet_entrance_balance_switch_state", Integer.valueOf(this.field_wallet_entrance_balance_switch_state));
    }
    if (this.fea) {
      localContentValues.put("soter_pay_open_type", Integer.valueOf(this.field_soter_pay_open_type));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.gl
 * JD-Core Version:    0.7.0.1
 */