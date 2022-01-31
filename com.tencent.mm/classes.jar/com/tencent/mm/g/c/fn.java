package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fn
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dTD = "wallet_balance".hashCode();
  private static final int dUI = "uin".hashCode();
  private static final int dUJ = "is_reg".hashCode();
  private static final int dUK = "true_name".hashCode();
  private static final int dUL = "card_num".hashCode();
  private static final int dUM = "isDomesticUser".hashCode();
  private static final int dUN = "cre_type".hashCode();
  private static final int dUO = "main_card_bind_serialno".hashCode();
  private static final int dUP = "ftf_pay_url".hashCode();
  private static final int dUQ = "switchConfig".hashCode();
  private static final int dUR = "reset_passwd_flag".hashCode();
  private static final int dUS = "find_passwd_url".hashCode();
  private static final int dUT = "is_open_touch".hashCode();
  private static final int dUU = "lct_wording".hashCode();
  private static final int dUV = "lct_url".hashCode();
  private static final int dUW = "cre_name".hashCode();
  private static final int dUX = "lqt_state".hashCode();
  private static final int dUY = "paymenu_use_new".hashCode();
  private static final int dUZ = "is_show_lqb".hashCode();
  private static final int dVa = "is_open_lqb".hashCode();
  private static final int dVb = "lqb_open_url".hashCode();
  private static final int dVc = "lqt_cell_is_show".hashCode();
  private static final int dVd = "lqt_cell_icon".hashCode();
  private static final int dVe = "lqt_cell_is_open_lqt".hashCode();
  private static final int dVf = "lqt_cell_lqt_open_url".hashCode();
  private static final int dVg = "lqt_cell_lqt_title".hashCode();
  private static final int dVh = "lqt_cell_lqt_wording".hashCode();
  private static final int dVi = "forget_passwd_url".hashCode();
  private static final int dVj = "unipay_order_state".hashCode();
  private static final int dVk = "bank_priority".hashCode();
  private static final int dVl = "wallet_entrance_balance_switch_state".hashCode();
  private static final int dVm = "soter_pay_open_type".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dTx = true;
  private boolean dUA = true;
  private boolean dUB = true;
  private boolean dUC = true;
  private boolean dUD = true;
  private boolean dUE = true;
  private boolean dUF = true;
  private boolean dUG = true;
  private boolean dUH = true;
  private boolean dUd = true;
  private boolean dUe = true;
  private boolean dUf = true;
  private boolean dUg = true;
  private boolean dUh = true;
  private boolean dUi = true;
  private boolean dUj = true;
  private boolean dUk = true;
  private boolean dUl = true;
  private boolean dUm = true;
  private boolean dUn = true;
  private boolean dUo = true;
  private boolean dUp = true;
  private boolean dUq = true;
  private boolean dUr = true;
  private boolean dUs = true;
  private boolean dUt = true;
  private boolean dUu = true;
  private boolean dUv = true;
  private boolean dUw = true;
  private boolean dUx = true;
  private boolean dUy = true;
  private boolean dUz = true;
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
      if (dUI != k) {
        break label65;
      }
      this.field_uin = paramCursor.getString(i);
      this.dUd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dUJ == k)
      {
        this.field_is_reg = paramCursor.getInt(i);
      }
      else if (dUK == k)
      {
        this.field_true_name = paramCursor.getString(i);
      }
      else if (dUL == k)
      {
        this.field_card_num = paramCursor.getInt(i);
      }
      else
      {
        if (dUM == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isDomesticUser = bool;
            break;
          }
        }
        if (dUN == k) {
          this.field_cre_type = paramCursor.getInt(i);
        } else if (dUO == k) {
          this.field_main_card_bind_serialno = paramCursor.getString(i);
        } else if (dUP == k) {
          this.field_ftf_pay_url = paramCursor.getString(i);
        } else if (dUQ == k) {
          this.field_switchConfig = paramCursor.getInt(i);
        } else if (dUR == k) {
          this.field_reset_passwd_flag = paramCursor.getString(i);
        } else if (dUS == k) {
          this.field_find_passwd_url = paramCursor.getString(i);
        } else if (dUT == k) {
          this.field_is_open_touch = paramCursor.getInt(i);
        } else if (dUU == k) {
          this.field_lct_wording = paramCursor.getString(i);
        } else if (dUV == k) {
          this.field_lct_url = paramCursor.getString(i);
        } else if (dUW == k) {
          this.field_cre_name = paramCursor.getString(i);
        } else if (dUX == k) {
          this.field_lqt_state = paramCursor.getInt(i);
        } else if (dUY == k) {
          this.field_paymenu_use_new = paramCursor.getInt(i);
        } else if (dUZ == k) {
          this.field_is_show_lqb = paramCursor.getInt(i);
        } else if (dVa == k) {
          this.field_is_open_lqb = paramCursor.getInt(i);
        } else if (dVb == k) {
          this.field_lqb_open_url = paramCursor.getString(i);
        } else if (dVc == k) {
          this.field_lqt_cell_is_show = paramCursor.getInt(i);
        } else if (dVd == k) {
          this.field_lqt_cell_icon = paramCursor.getString(i);
        } else if (dVe == k) {
          this.field_lqt_cell_is_open_lqt = paramCursor.getInt(i);
        } else if (dVf == k) {
          this.field_lqt_cell_lqt_open_url = paramCursor.getString(i);
        } else if (dVg == k) {
          this.field_lqt_cell_lqt_title = paramCursor.getString(i);
        } else if (dVh == k) {
          this.field_lqt_cell_lqt_wording = paramCursor.getString(i);
        } else if (dVi == k) {
          this.field_forget_passwd_url = paramCursor.getString(i);
        } else if (dVj == k) {
          this.field_unipay_order_state = paramCursor.getInt(i);
        } else if (dVk == k) {
          this.field_bank_priority = paramCursor.getString(i);
        } else if (dTD == k) {
          this.field_wallet_balance = paramCursor.getLong(i);
        } else if (dVl == k) {
          this.field_wallet_entrance_balance_switch_state = paramCursor.getInt(i);
        } else if (dVm == k) {
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
    if (this.dUd) {
      localContentValues.put("uin", this.field_uin);
    }
    if (this.dUe) {
      localContentValues.put("is_reg", Integer.valueOf(this.field_is_reg));
    }
    if (this.dUf) {
      localContentValues.put("true_name", this.field_true_name);
    }
    if (this.dUg) {
      localContentValues.put("card_num", Integer.valueOf(this.field_card_num));
    }
    if (this.dUh) {
      localContentValues.put("isDomesticUser", Boolean.valueOf(this.field_isDomesticUser));
    }
    if (this.dUi) {
      localContentValues.put("cre_type", Integer.valueOf(this.field_cre_type));
    }
    if (this.dUj) {
      localContentValues.put("main_card_bind_serialno", this.field_main_card_bind_serialno);
    }
    if (this.dUk) {
      localContentValues.put("ftf_pay_url", this.field_ftf_pay_url);
    }
    if (this.dUl) {
      localContentValues.put("switchConfig", Integer.valueOf(this.field_switchConfig));
    }
    if (this.dUm) {
      localContentValues.put("reset_passwd_flag", this.field_reset_passwd_flag);
    }
    if (this.dUn) {
      localContentValues.put("find_passwd_url", this.field_find_passwd_url);
    }
    if (this.dUo) {
      localContentValues.put("is_open_touch", Integer.valueOf(this.field_is_open_touch));
    }
    if (this.dUp) {
      localContentValues.put("lct_wording", this.field_lct_wording);
    }
    if (this.dUq) {
      localContentValues.put("lct_url", this.field_lct_url);
    }
    if (this.dUr) {
      localContentValues.put("cre_name", this.field_cre_name);
    }
    if (this.dUs) {
      localContentValues.put("lqt_state", Integer.valueOf(this.field_lqt_state));
    }
    if (this.dUt) {
      localContentValues.put("paymenu_use_new", Integer.valueOf(this.field_paymenu_use_new));
    }
    if (this.dUu) {
      localContentValues.put("is_show_lqb", Integer.valueOf(this.field_is_show_lqb));
    }
    if (this.dUv) {
      localContentValues.put("is_open_lqb", Integer.valueOf(this.field_is_open_lqb));
    }
    if (this.dUw) {
      localContentValues.put("lqb_open_url", this.field_lqb_open_url);
    }
    if (this.dUx) {
      localContentValues.put("lqt_cell_is_show", Integer.valueOf(this.field_lqt_cell_is_show));
    }
    if (this.dUy) {
      localContentValues.put("lqt_cell_icon", this.field_lqt_cell_icon);
    }
    if (this.dUz) {
      localContentValues.put("lqt_cell_is_open_lqt", Integer.valueOf(this.field_lqt_cell_is_open_lqt));
    }
    if (this.dUA) {
      localContentValues.put("lqt_cell_lqt_open_url", this.field_lqt_cell_lqt_open_url);
    }
    if (this.dUB) {
      localContentValues.put("lqt_cell_lqt_title", this.field_lqt_cell_lqt_title);
    }
    if (this.dUC) {
      localContentValues.put("lqt_cell_lqt_wording", this.field_lqt_cell_lqt_wording);
    }
    if (this.dUD) {
      localContentValues.put("forget_passwd_url", this.field_forget_passwd_url);
    }
    if (this.dUE) {
      localContentValues.put("unipay_order_state", Integer.valueOf(this.field_unipay_order_state));
    }
    if (this.dUF) {
      localContentValues.put("bank_priority", this.field_bank_priority);
    }
    if (this.dTx) {
      localContentValues.put("wallet_balance", Long.valueOf(this.field_wallet_balance));
    }
    if (this.dUG) {
      localContentValues.put("wallet_entrance_balance_switch_state", Integer.valueOf(this.field_wallet_entrance_balance_switch_state));
    }
    if (this.dUH) {
      localContentValues.put("soter_pay_open_type", Integer.valueOf(this.field_soter_pay_open_type));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fn
 * JD-Core Version:    0.7.0.1
 */