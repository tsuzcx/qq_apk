package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gz
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fAa;
  private static final int fAb;
  private static final int fAc;
  private static final int fAd;
  private static final int fAe = "wallet_entrance_balance_switch_state".hashCode();
  private static final int fAf = "soter_pay_open_type".hashCode();
  private static final int fyw;
  private static final int fzB = "uin".hashCode();
  private static final int fzC = "is_reg".hashCode();
  private static final int fzD = "true_name".hashCode();
  private static final int fzE = "card_num".hashCode();
  private static final int fzF = "isDomesticUser".hashCode();
  private static final int fzG = "cre_type".hashCode();
  private static final int fzH = "main_card_bind_serialno".hashCode();
  private static final int fzI = "ftf_pay_url".hashCode();
  private static final int fzJ = "switchConfig".hashCode();
  private static final int fzK = "reset_passwd_flag".hashCode();
  private static final int fzL = "find_passwd_url".hashCode();
  private static final int fzM = "is_open_touch".hashCode();
  private static final int fzN = "lct_wording".hashCode();
  private static final int fzO = "lct_url".hashCode();
  private static final int fzP = "cre_name".hashCode();
  private static final int fzQ = "lqt_state".hashCode();
  private static final int fzR = "paymenu_use_new".hashCode();
  private static final int fzS = "is_show_lqb".hashCode();
  private static final int fzT = "is_open_lqb".hashCode();
  private static final int fzU = "lqb_open_url".hashCode();
  private static final int fzV = "lqt_cell_is_show".hashCode();
  private static final int fzW = "lqt_cell_icon".hashCode();
  private static final int fzX = "lqt_cell_is_open_lqt".hashCode();
  private static final int fzY = "lqt_cell_lqt_open_url".hashCode();
  private static final int fzZ = "lqt_cell_lqt_title".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean fyW = true;
  private boolean fyX = true;
  private boolean fyY = true;
  private boolean fyZ = true;
  private boolean fyq = true;
  private boolean fzA = true;
  private boolean fza = true;
  private boolean fzb = true;
  private boolean fzc = true;
  private boolean fzd = true;
  private boolean fze = true;
  private boolean fzf = true;
  private boolean fzg = true;
  private boolean fzh = true;
  private boolean fzi = true;
  private boolean fzj = true;
  private boolean fzk = true;
  private boolean fzl = true;
  private boolean fzm = true;
  private boolean fzn = true;
  private boolean fzo = true;
  private boolean fzp = true;
  private boolean fzq = true;
  private boolean fzr = true;
  private boolean fzs = true;
  private boolean fzt = true;
  private boolean fzu = true;
  private boolean fzv = true;
  private boolean fzw = true;
  private boolean fzx = true;
  private boolean fzy = true;
  private boolean fzz = true;
  
  static
  {
    fAa = "lqt_cell_lqt_wording".hashCode();
    fAb = "forget_passwd_url".hashCode();
    fAc = "unipay_order_state".hashCode();
    fAd = "bank_priority".hashCode();
    fyw = "wallet_balance".hashCode();
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
      if (fzB != k) {
        break label65;
      }
      this.field_uin = paramCursor.getString(i);
      this.fyW = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fzC == k)
      {
        this.field_is_reg = paramCursor.getInt(i);
      }
      else if (fzD == k)
      {
        this.field_true_name = paramCursor.getString(i);
      }
      else if (fzE == k)
      {
        this.field_card_num = paramCursor.getInt(i);
      }
      else
      {
        if (fzF == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isDomesticUser = bool;
            break;
          }
        }
        if (fzG == k) {
          this.field_cre_type = paramCursor.getInt(i);
        } else if (fzH == k) {
          this.field_main_card_bind_serialno = paramCursor.getString(i);
        } else if (fzI == k) {
          this.field_ftf_pay_url = paramCursor.getString(i);
        } else if (fzJ == k) {
          this.field_switchConfig = paramCursor.getInt(i);
        } else if (fzK == k) {
          this.field_reset_passwd_flag = paramCursor.getString(i);
        } else if (fzL == k) {
          this.field_find_passwd_url = paramCursor.getString(i);
        } else if (fzM == k) {
          this.field_is_open_touch = paramCursor.getInt(i);
        } else if (fzN == k) {
          this.field_lct_wording = paramCursor.getString(i);
        } else if (fzO == k) {
          this.field_lct_url = paramCursor.getString(i);
        } else if (fzP == k) {
          this.field_cre_name = paramCursor.getString(i);
        } else if (fzQ == k) {
          this.field_lqt_state = paramCursor.getInt(i);
        } else if (fzR == k) {
          this.field_paymenu_use_new = paramCursor.getInt(i);
        } else if (fzS == k) {
          this.field_is_show_lqb = paramCursor.getInt(i);
        } else if (fzT == k) {
          this.field_is_open_lqb = paramCursor.getInt(i);
        } else if (fzU == k) {
          this.field_lqb_open_url = paramCursor.getString(i);
        } else if (fzV == k) {
          this.field_lqt_cell_is_show = paramCursor.getInt(i);
        } else if (fzW == k) {
          this.field_lqt_cell_icon = paramCursor.getString(i);
        } else if (fzX == k) {
          this.field_lqt_cell_is_open_lqt = paramCursor.getInt(i);
        } else if (fzY == k) {
          this.field_lqt_cell_lqt_open_url = paramCursor.getString(i);
        } else if (fzZ == k) {
          this.field_lqt_cell_lqt_title = paramCursor.getString(i);
        } else if (fAa == k) {
          this.field_lqt_cell_lqt_wording = paramCursor.getString(i);
        } else if (fAb == k) {
          this.field_forget_passwd_url = paramCursor.getString(i);
        } else if (fAc == k) {
          this.field_unipay_order_state = paramCursor.getInt(i);
        } else if (fAd == k) {
          this.field_bank_priority = paramCursor.getString(i);
        } else if (fyw == k) {
          this.field_wallet_balance = paramCursor.getLong(i);
        } else if (fAe == k) {
          this.field_wallet_entrance_balance_switch_state = paramCursor.getInt(i);
        } else if (fAf == k) {
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
    if (this.fyW) {
      localContentValues.put("uin", this.field_uin);
    }
    if (this.fyX) {
      localContentValues.put("is_reg", Integer.valueOf(this.field_is_reg));
    }
    if (this.fyY) {
      localContentValues.put("true_name", this.field_true_name);
    }
    if (this.fyZ) {
      localContentValues.put("card_num", Integer.valueOf(this.field_card_num));
    }
    if (this.fza) {
      localContentValues.put("isDomesticUser", Boolean.valueOf(this.field_isDomesticUser));
    }
    if (this.fzb) {
      localContentValues.put("cre_type", Integer.valueOf(this.field_cre_type));
    }
    if (this.fzc) {
      localContentValues.put("main_card_bind_serialno", this.field_main_card_bind_serialno);
    }
    if (this.fzd) {
      localContentValues.put("ftf_pay_url", this.field_ftf_pay_url);
    }
    if (this.fze) {
      localContentValues.put("switchConfig", Integer.valueOf(this.field_switchConfig));
    }
    if (this.fzf) {
      localContentValues.put("reset_passwd_flag", this.field_reset_passwd_flag);
    }
    if (this.fzg) {
      localContentValues.put("find_passwd_url", this.field_find_passwd_url);
    }
    if (this.fzh) {
      localContentValues.put("is_open_touch", Integer.valueOf(this.field_is_open_touch));
    }
    if (this.fzi) {
      localContentValues.put("lct_wording", this.field_lct_wording);
    }
    if (this.fzj) {
      localContentValues.put("lct_url", this.field_lct_url);
    }
    if (this.fzk) {
      localContentValues.put("cre_name", this.field_cre_name);
    }
    if (this.fzl) {
      localContentValues.put("lqt_state", Integer.valueOf(this.field_lqt_state));
    }
    if (this.fzm) {
      localContentValues.put("paymenu_use_new", Integer.valueOf(this.field_paymenu_use_new));
    }
    if (this.fzn) {
      localContentValues.put("is_show_lqb", Integer.valueOf(this.field_is_show_lqb));
    }
    if (this.fzo) {
      localContentValues.put("is_open_lqb", Integer.valueOf(this.field_is_open_lqb));
    }
    if (this.fzp) {
      localContentValues.put("lqb_open_url", this.field_lqb_open_url);
    }
    if (this.fzq) {
      localContentValues.put("lqt_cell_is_show", Integer.valueOf(this.field_lqt_cell_is_show));
    }
    if (this.fzr) {
      localContentValues.put("lqt_cell_icon", this.field_lqt_cell_icon);
    }
    if (this.fzs) {
      localContentValues.put("lqt_cell_is_open_lqt", Integer.valueOf(this.field_lqt_cell_is_open_lqt));
    }
    if (this.fzt) {
      localContentValues.put("lqt_cell_lqt_open_url", this.field_lqt_cell_lqt_open_url);
    }
    if (this.fzu) {
      localContentValues.put("lqt_cell_lqt_title", this.field_lqt_cell_lqt_title);
    }
    if (this.fzv) {
      localContentValues.put("lqt_cell_lqt_wording", this.field_lqt_cell_lqt_wording);
    }
    if (this.fzw) {
      localContentValues.put("forget_passwd_url", this.field_forget_passwd_url);
    }
    if (this.fzx) {
      localContentValues.put("unipay_order_state", Integer.valueOf(this.field_unipay_order_state));
    }
    if (this.fzy) {
      localContentValues.put("bank_priority", this.field_bank_priority);
    }
    if (this.fyq) {
      localContentValues.put("wallet_balance", Long.valueOf(this.field_wallet_balance));
    }
    if (this.fzz) {
      localContentValues.put("wallet_entrance_balance_switch_state", Integer.valueOf(this.field_wallet_entrance_balance_switch_state));
    }
    if (this.fzA) {
      localContentValues.put("soter_pay_open_type", Integer.valueOf(this.field_soter_pay_open_type));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gz
 * JD-Core Version:    0.7.0.1
 */