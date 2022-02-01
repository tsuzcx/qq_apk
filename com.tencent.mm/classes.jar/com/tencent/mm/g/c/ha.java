package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ha
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fAw = "wallet_balance".hashCode();
  private static final int fBB = "uin".hashCode();
  private static final int fBC = "is_reg".hashCode();
  private static final int fBD = "true_name".hashCode();
  private static final int fBE = "card_num".hashCode();
  private static final int fBF = "isDomesticUser".hashCode();
  private static final int fBG = "cre_type".hashCode();
  private static final int fBH = "main_card_bind_serialno".hashCode();
  private static final int fBI = "ftf_pay_url".hashCode();
  private static final int fBJ = "switchConfig".hashCode();
  private static final int fBK = "reset_passwd_flag".hashCode();
  private static final int fBL = "find_passwd_url".hashCode();
  private static final int fBM = "is_open_touch".hashCode();
  private static final int fBN = "lct_wording".hashCode();
  private static final int fBO = "lct_url".hashCode();
  private static final int fBP = "cre_name".hashCode();
  private static final int fBQ = "lqt_state".hashCode();
  private static final int fBR = "paymenu_use_new".hashCode();
  private static final int fBS = "is_show_lqb".hashCode();
  private static final int fBT = "is_open_lqb".hashCode();
  private static final int fBU = "lqb_open_url".hashCode();
  private static final int fBV = "lqt_cell_is_show".hashCode();
  private static final int fBW = "lqt_cell_icon".hashCode();
  private static final int fBX = "lqt_cell_is_open_lqt".hashCode();
  private static final int fBY = "lqt_cell_lqt_open_url".hashCode();
  private static final int fBZ = "lqt_cell_lqt_title".hashCode();
  private static final int fCa = "lqt_cell_lqt_wording".hashCode();
  private static final int fCb = "forget_passwd_url".hashCode();
  private static final int fCc = "unipay_order_state".hashCode();
  private static final int fCd = "bank_priority".hashCode();
  private static final int fCe = "wallet_entrance_balance_switch_state".hashCode();
  private static final int fCf = "soter_pay_open_type".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fAW = true;
  private boolean fAX = true;
  private boolean fAY = true;
  private boolean fAZ = true;
  private boolean fAq = true;
  private boolean fBA = true;
  private boolean fBa = true;
  private boolean fBb = true;
  private boolean fBc = true;
  private boolean fBd = true;
  private boolean fBe = true;
  private boolean fBf = true;
  private boolean fBg = true;
  private boolean fBh = true;
  private boolean fBi = true;
  private boolean fBj = true;
  private boolean fBk = true;
  private boolean fBl = true;
  private boolean fBm = true;
  private boolean fBn = true;
  private boolean fBo = true;
  private boolean fBp = true;
  private boolean fBq = true;
  private boolean fBr = true;
  private boolean fBs = true;
  private boolean fBt = true;
  private boolean fBu = true;
  private boolean fBv = true;
  private boolean fBw = true;
  private boolean fBx = true;
  private boolean fBy = true;
  private boolean fBz = true;
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
      if (fBB != k) {
        break label65;
      }
      this.field_uin = paramCursor.getString(i);
      this.fAW = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fBC == k)
      {
        this.field_is_reg = paramCursor.getInt(i);
      }
      else if (fBD == k)
      {
        this.field_true_name = paramCursor.getString(i);
      }
      else if (fBE == k)
      {
        this.field_card_num = paramCursor.getInt(i);
      }
      else
      {
        if (fBF == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isDomesticUser = bool;
            break;
          }
        }
        if (fBG == k) {
          this.field_cre_type = paramCursor.getInt(i);
        } else if (fBH == k) {
          this.field_main_card_bind_serialno = paramCursor.getString(i);
        } else if (fBI == k) {
          this.field_ftf_pay_url = paramCursor.getString(i);
        } else if (fBJ == k) {
          this.field_switchConfig = paramCursor.getInt(i);
        } else if (fBK == k) {
          this.field_reset_passwd_flag = paramCursor.getString(i);
        } else if (fBL == k) {
          this.field_find_passwd_url = paramCursor.getString(i);
        } else if (fBM == k) {
          this.field_is_open_touch = paramCursor.getInt(i);
        } else if (fBN == k) {
          this.field_lct_wording = paramCursor.getString(i);
        } else if (fBO == k) {
          this.field_lct_url = paramCursor.getString(i);
        } else if (fBP == k) {
          this.field_cre_name = paramCursor.getString(i);
        } else if (fBQ == k) {
          this.field_lqt_state = paramCursor.getInt(i);
        } else if (fBR == k) {
          this.field_paymenu_use_new = paramCursor.getInt(i);
        } else if (fBS == k) {
          this.field_is_show_lqb = paramCursor.getInt(i);
        } else if (fBT == k) {
          this.field_is_open_lqb = paramCursor.getInt(i);
        } else if (fBU == k) {
          this.field_lqb_open_url = paramCursor.getString(i);
        } else if (fBV == k) {
          this.field_lqt_cell_is_show = paramCursor.getInt(i);
        } else if (fBW == k) {
          this.field_lqt_cell_icon = paramCursor.getString(i);
        } else if (fBX == k) {
          this.field_lqt_cell_is_open_lqt = paramCursor.getInt(i);
        } else if (fBY == k) {
          this.field_lqt_cell_lqt_open_url = paramCursor.getString(i);
        } else if (fBZ == k) {
          this.field_lqt_cell_lqt_title = paramCursor.getString(i);
        } else if (fCa == k) {
          this.field_lqt_cell_lqt_wording = paramCursor.getString(i);
        } else if (fCb == k) {
          this.field_forget_passwd_url = paramCursor.getString(i);
        } else if (fCc == k) {
          this.field_unipay_order_state = paramCursor.getInt(i);
        } else if (fCd == k) {
          this.field_bank_priority = paramCursor.getString(i);
        } else if (fAw == k) {
          this.field_wallet_balance = paramCursor.getLong(i);
        } else if (fCe == k) {
          this.field_wallet_entrance_balance_switch_state = paramCursor.getInt(i);
        } else if (fCf == k) {
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
    if (this.fAW) {
      localContentValues.put("uin", this.field_uin);
    }
    if (this.fAX) {
      localContentValues.put("is_reg", Integer.valueOf(this.field_is_reg));
    }
    if (this.fAY) {
      localContentValues.put("true_name", this.field_true_name);
    }
    if (this.fAZ) {
      localContentValues.put("card_num", Integer.valueOf(this.field_card_num));
    }
    if (this.fBa) {
      localContentValues.put("isDomesticUser", Boolean.valueOf(this.field_isDomesticUser));
    }
    if (this.fBb) {
      localContentValues.put("cre_type", Integer.valueOf(this.field_cre_type));
    }
    if (this.fBc) {
      localContentValues.put("main_card_bind_serialno", this.field_main_card_bind_serialno);
    }
    if (this.fBd) {
      localContentValues.put("ftf_pay_url", this.field_ftf_pay_url);
    }
    if (this.fBe) {
      localContentValues.put("switchConfig", Integer.valueOf(this.field_switchConfig));
    }
    if (this.fBf) {
      localContentValues.put("reset_passwd_flag", this.field_reset_passwd_flag);
    }
    if (this.fBg) {
      localContentValues.put("find_passwd_url", this.field_find_passwd_url);
    }
    if (this.fBh) {
      localContentValues.put("is_open_touch", Integer.valueOf(this.field_is_open_touch));
    }
    if (this.fBi) {
      localContentValues.put("lct_wording", this.field_lct_wording);
    }
    if (this.fBj) {
      localContentValues.put("lct_url", this.field_lct_url);
    }
    if (this.fBk) {
      localContentValues.put("cre_name", this.field_cre_name);
    }
    if (this.fBl) {
      localContentValues.put("lqt_state", Integer.valueOf(this.field_lqt_state));
    }
    if (this.fBm) {
      localContentValues.put("paymenu_use_new", Integer.valueOf(this.field_paymenu_use_new));
    }
    if (this.fBn) {
      localContentValues.put("is_show_lqb", Integer.valueOf(this.field_is_show_lqb));
    }
    if (this.fBo) {
      localContentValues.put("is_open_lqb", Integer.valueOf(this.field_is_open_lqb));
    }
    if (this.fBp) {
      localContentValues.put("lqb_open_url", this.field_lqb_open_url);
    }
    if (this.fBq) {
      localContentValues.put("lqt_cell_is_show", Integer.valueOf(this.field_lqt_cell_is_show));
    }
    if (this.fBr) {
      localContentValues.put("lqt_cell_icon", this.field_lqt_cell_icon);
    }
    if (this.fBs) {
      localContentValues.put("lqt_cell_is_open_lqt", Integer.valueOf(this.field_lqt_cell_is_open_lqt));
    }
    if (this.fBt) {
      localContentValues.put("lqt_cell_lqt_open_url", this.field_lqt_cell_lqt_open_url);
    }
    if (this.fBu) {
      localContentValues.put("lqt_cell_lqt_title", this.field_lqt_cell_lqt_title);
    }
    if (this.fBv) {
      localContentValues.put("lqt_cell_lqt_wording", this.field_lqt_cell_lqt_wording);
    }
    if (this.fBw) {
      localContentValues.put("forget_passwd_url", this.field_forget_passwd_url);
    }
    if (this.fBx) {
      localContentValues.put("unipay_order_state", Integer.valueOf(this.field_unipay_order_state));
    }
    if (this.fBy) {
      localContentValues.put("bank_priority", this.field_bank_priority);
    }
    if (this.fAq) {
      localContentValues.put("wallet_balance", Long.valueOf(this.field_wallet_balance));
    }
    if (this.fBz) {
      localContentValues.put("wallet_entrance_balance_switch_state", Integer.valueOf(this.field_wallet_entrance_balance_switch_state));
    }
    if (this.fBA) {
      localContentValues.put("soter_pay_open_type", Integer.valueOf(this.field_soter_pay_open_type));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ha
 * JD-Core Version:    0.7.0.1
 */