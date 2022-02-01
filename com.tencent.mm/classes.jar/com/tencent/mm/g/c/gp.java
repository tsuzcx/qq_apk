package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fgo = "wallet_balance".hashCode();
  private static final int fhA;
  private static final int fhB;
  private static final int fhC;
  private static final int fhD;
  private static final int fhE;
  private static final int fhF;
  private static final int fhG;
  private static final int fhH;
  private static final int fhI;
  private static final int fhJ;
  private static final int fhK;
  private static final int fhL;
  private static final int fhM;
  private static final int fhN;
  private static final int fhO;
  private static final int fhP;
  private static final int fhQ;
  private static final int fhR;
  private static final int fhS;
  private static final int fhT;
  private static final int fhU;
  private static final int fhV;
  private static final int fhW = "wallet_entrance_balance_switch_state".hashCode();
  private static final int fhX = "soter_pay_open_type".hashCode();
  private static final int fht = "uin".hashCode();
  private static final int fhu = "is_reg".hashCode();
  private static final int fhv = "true_name".hashCode();
  private static final int fhw = "card_num".hashCode();
  private static final int fhx = "isDomesticUser".hashCode();
  private static final int fhy = "cre_type".hashCode();
  private static final int fhz = "main_card_bind_serialno".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fgO = true;
  private boolean fgP = true;
  private boolean fgQ = true;
  private boolean fgR = true;
  private boolean fgS = true;
  private boolean fgT = true;
  private boolean fgU = true;
  private boolean fgV = true;
  private boolean fgW = true;
  private boolean fgX = true;
  private boolean fgY = true;
  private boolean fgZ = true;
  private boolean fgi = true;
  private boolean fha = true;
  private boolean fhb = true;
  private boolean fhc = true;
  private boolean fhd = true;
  private boolean fhe = true;
  private boolean fhf = true;
  private boolean fhg = true;
  private boolean fhh = true;
  private boolean fhi = true;
  private boolean fhj = true;
  private boolean fhk = true;
  private boolean fhl = true;
  private boolean fhm = true;
  private boolean fhn = true;
  private boolean fho = true;
  private boolean fhp = true;
  private boolean fhq = true;
  private boolean fhr = true;
  private boolean fhs = true;
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
    fhA = "ftf_pay_url".hashCode();
    fhB = "switchConfig".hashCode();
    fhC = "reset_passwd_flag".hashCode();
    fhD = "find_passwd_url".hashCode();
    fhE = "is_open_touch".hashCode();
    fhF = "lct_wording".hashCode();
    fhG = "lct_url".hashCode();
    fhH = "cre_name".hashCode();
    fhI = "lqt_state".hashCode();
    fhJ = "paymenu_use_new".hashCode();
    fhK = "is_show_lqb".hashCode();
    fhL = "is_open_lqb".hashCode();
    fhM = "lqb_open_url".hashCode();
    fhN = "lqt_cell_is_show".hashCode();
    fhO = "lqt_cell_icon".hashCode();
    fhP = "lqt_cell_is_open_lqt".hashCode();
    fhQ = "lqt_cell_lqt_open_url".hashCode();
    fhR = "lqt_cell_lqt_title".hashCode();
    fhS = "lqt_cell_lqt_wording".hashCode();
    fhT = "forget_passwd_url".hashCode();
    fhU = "unipay_order_state".hashCode();
    fhV = "bank_priority".hashCode();
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
      if (fht != k) {
        break label65;
      }
      this.field_uin = paramCursor.getString(i);
      this.fgO = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fhu == k)
      {
        this.field_is_reg = paramCursor.getInt(i);
      }
      else if (fhv == k)
      {
        this.field_true_name = paramCursor.getString(i);
      }
      else if (fhw == k)
      {
        this.field_card_num = paramCursor.getInt(i);
      }
      else
      {
        if (fhx == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isDomesticUser = bool;
            break;
          }
        }
        if (fhy == k) {
          this.field_cre_type = paramCursor.getInt(i);
        } else if (fhz == k) {
          this.field_main_card_bind_serialno = paramCursor.getString(i);
        } else if (fhA == k) {
          this.field_ftf_pay_url = paramCursor.getString(i);
        } else if (fhB == k) {
          this.field_switchConfig = paramCursor.getInt(i);
        } else if (fhC == k) {
          this.field_reset_passwd_flag = paramCursor.getString(i);
        } else if (fhD == k) {
          this.field_find_passwd_url = paramCursor.getString(i);
        } else if (fhE == k) {
          this.field_is_open_touch = paramCursor.getInt(i);
        } else if (fhF == k) {
          this.field_lct_wording = paramCursor.getString(i);
        } else if (fhG == k) {
          this.field_lct_url = paramCursor.getString(i);
        } else if (fhH == k) {
          this.field_cre_name = paramCursor.getString(i);
        } else if (fhI == k) {
          this.field_lqt_state = paramCursor.getInt(i);
        } else if (fhJ == k) {
          this.field_paymenu_use_new = paramCursor.getInt(i);
        } else if (fhK == k) {
          this.field_is_show_lqb = paramCursor.getInt(i);
        } else if (fhL == k) {
          this.field_is_open_lqb = paramCursor.getInt(i);
        } else if (fhM == k) {
          this.field_lqb_open_url = paramCursor.getString(i);
        } else if (fhN == k) {
          this.field_lqt_cell_is_show = paramCursor.getInt(i);
        } else if (fhO == k) {
          this.field_lqt_cell_icon = paramCursor.getString(i);
        } else if (fhP == k) {
          this.field_lqt_cell_is_open_lqt = paramCursor.getInt(i);
        } else if (fhQ == k) {
          this.field_lqt_cell_lqt_open_url = paramCursor.getString(i);
        } else if (fhR == k) {
          this.field_lqt_cell_lqt_title = paramCursor.getString(i);
        } else if (fhS == k) {
          this.field_lqt_cell_lqt_wording = paramCursor.getString(i);
        } else if (fhT == k) {
          this.field_forget_passwd_url = paramCursor.getString(i);
        } else if (fhU == k) {
          this.field_unipay_order_state = paramCursor.getInt(i);
        } else if (fhV == k) {
          this.field_bank_priority = paramCursor.getString(i);
        } else if (fgo == k) {
          this.field_wallet_balance = paramCursor.getLong(i);
        } else if (fhW == k) {
          this.field_wallet_entrance_balance_switch_state = paramCursor.getInt(i);
        } else if (fhX == k) {
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
    if (this.fgO) {
      localContentValues.put("uin", this.field_uin);
    }
    if (this.fgP) {
      localContentValues.put("is_reg", Integer.valueOf(this.field_is_reg));
    }
    if (this.fgQ) {
      localContentValues.put("true_name", this.field_true_name);
    }
    if (this.fgR) {
      localContentValues.put("card_num", Integer.valueOf(this.field_card_num));
    }
    if (this.fgS) {
      localContentValues.put("isDomesticUser", Boolean.valueOf(this.field_isDomesticUser));
    }
    if (this.fgT) {
      localContentValues.put("cre_type", Integer.valueOf(this.field_cre_type));
    }
    if (this.fgU) {
      localContentValues.put("main_card_bind_serialno", this.field_main_card_bind_serialno);
    }
    if (this.fgV) {
      localContentValues.put("ftf_pay_url", this.field_ftf_pay_url);
    }
    if (this.fgW) {
      localContentValues.put("switchConfig", Integer.valueOf(this.field_switchConfig));
    }
    if (this.fgX) {
      localContentValues.put("reset_passwd_flag", this.field_reset_passwd_flag);
    }
    if (this.fgY) {
      localContentValues.put("find_passwd_url", this.field_find_passwd_url);
    }
    if (this.fgZ) {
      localContentValues.put("is_open_touch", Integer.valueOf(this.field_is_open_touch));
    }
    if (this.fha) {
      localContentValues.put("lct_wording", this.field_lct_wording);
    }
    if (this.fhb) {
      localContentValues.put("lct_url", this.field_lct_url);
    }
    if (this.fhc) {
      localContentValues.put("cre_name", this.field_cre_name);
    }
    if (this.fhd) {
      localContentValues.put("lqt_state", Integer.valueOf(this.field_lqt_state));
    }
    if (this.fhe) {
      localContentValues.put("paymenu_use_new", Integer.valueOf(this.field_paymenu_use_new));
    }
    if (this.fhf) {
      localContentValues.put("is_show_lqb", Integer.valueOf(this.field_is_show_lqb));
    }
    if (this.fhg) {
      localContentValues.put("is_open_lqb", Integer.valueOf(this.field_is_open_lqb));
    }
    if (this.fhh) {
      localContentValues.put("lqb_open_url", this.field_lqb_open_url);
    }
    if (this.fhi) {
      localContentValues.put("lqt_cell_is_show", Integer.valueOf(this.field_lqt_cell_is_show));
    }
    if (this.fhj) {
      localContentValues.put("lqt_cell_icon", this.field_lqt_cell_icon);
    }
    if (this.fhk) {
      localContentValues.put("lqt_cell_is_open_lqt", Integer.valueOf(this.field_lqt_cell_is_open_lqt));
    }
    if (this.fhl) {
      localContentValues.put("lqt_cell_lqt_open_url", this.field_lqt_cell_lqt_open_url);
    }
    if (this.fhm) {
      localContentValues.put("lqt_cell_lqt_title", this.field_lqt_cell_lqt_title);
    }
    if (this.fhn) {
      localContentValues.put("lqt_cell_lqt_wording", this.field_lqt_cell_lqt_wording);
    }
    if (this.fho) {
      localContentValues.put("forget_passwd_url", this.field_forget_passwd_url);
    }
    if (this.fhp) {
      localContentValues.put("unipay_order_state", Integer.valueOf(this.field_unipay_order_state));
    }
    if (this.fhq) {
      localContentValues.put("bank_priority", this.field_bank_priority);
    }
    if (this.fgi) {
      localContentValues.put("wallet_balance", Long.valueOf(this.field_wallet_balance));
    }
    if (this.fhr) {
      localContentValues.put("wallet_entrance_balance_switch_state", Integer.valueOf(this.field_wallet_entrance_balance_switch_state));
    }
    if (this.fhs) {
      localContentValues.put("soter_pay_open_type", Integer.valueOf(this.field_soter_pay_open_type));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gp
 * JD-Core Version:    0.7.0.1
 */