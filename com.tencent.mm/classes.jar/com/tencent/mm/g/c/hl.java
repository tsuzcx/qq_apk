package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hl
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int gfo = "wallet_balance".hashCode();
  private static final int ggA;
  private static final int ggB;
  private static final int ggC;
  private static final int ggD;
  private static final int ggE;
  private static final int ggF;
  private static final int ggG;
  private static final int ggH;
  private static final int ggI;
  private static final int ggJ;
  private static final int ggK;
  private static final int ggL;
  private static final int ggM;
  private static final int ggN;
  private static final int ggO;
  private static final int ggP;
  private static final int ggQ;
  private static final int ggR;
  private static final int ggS;
  private static final int ggT;
  private static final int ggU;
  private static final int ggV;
  private static final int ggW;
  private static final int ggX;
  private static final int ggY;
  private static final int ggZ;
  private static final int ggz = "uin".hashCode();
  private static final int gha;
  private static final int ghb;
  private static final int ghc = "wallet_entrance_balance_switch_state".hashCode();
  private static final int ghd = "soter_pay_open_type".hashCode();
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
  private boolean gfU = true;
  private boolean gfV = true;
  private boolean gfW = true;
  private boolean gfX = true;
  private boolean gfY = true;
  private boolean gfZ = true;
  private boolean gfi = true;
  private boolean gga = true;
  private boolean ggb = true;
  private boolean ggc = true;
  private boolean ggd = true;
  private boolean gge = true;
  private boolean ggf = true;
  private boolean ggg = true;
  private boolean ggh = true;
  private boolean ggi = true;
  private boolean ggj = true;
  private boolean ggk = true;
  private boolean ggl = true;
  private boolean ggm = true;
  private boolean ggn = true;
  private boolean ggo = true;
  private boolean ggp = true;
  private boolean ggq = true;
  private boolean ggr = true;
  private boolean ggs = true;
  private boolean ggt = true;
  private boolean ggu = true;
  private boolean ggv = true;
  private boolean ggw = true;
  private boolean ggx = true;
  private boolean ggy = true;
  
  static
  {
    ggA = "is_reg".hashCode();
    ggB = "true_name".hashCode();
    ggC = "card_num".hashCode();
    ggD = "isDomesticUser".hashCode();
    ggE = "cre_type".hashCode();
    ggF = "main_card_bind_serialno".hashCode();
    ggG = "ftf_pay_url".hashCode();
    ggH = "switchConfig".hashCode();
    ggI = "reset_passwd_flag".hashCode();
    ggJ = "find_passwd_url".hashCode();
    ggK = "is_open_touch".hashCode();
    ggL = "lct_wording".hashCode();
    ggM = "lct_url".hashCode();
    ggN = "cre_name".hashCode();
    ggO = "lqt_state".hashCode();
    ggP = "paymenu_use_new".hashCode();
    ggQ = "is_show_lqb".hashCode();
    ggR = "is_open_lqb".hashCode();
    ggS = "lqb_open_url".hashCode();
    ggT = "lqt_cell_is_show".hashCode();
    ggU = "lqt_cell_icon".hashCode();
    ggV = "lqt_cell_is_open_lqt".hashCode();
    ggW = "lqt_cell_lqt_open_url".hashCode();
    ggX = "lqt_cell_lqt_title".hashCode();
    ggY = "lqt_cell_lqt_wording".hashCode();
    ggZ = "forget_passwd_url".hashCode();
    gha = "unipay_order_state".hashCode();
    ghb = "bank_priority".hashCode();
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
      if (ggz != k) {
        break label65;
      }
      this.field_uin = paramCursor.getString(i);
      this.gfU = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ggA == k)
      {
        this.field_is_reg = paramCursor.getInt(i);
      }
      else if (ggB == k)
      {
        this.field_true_name = paramCursor.getString(i);
      }
      else if (ggC == k)
      {
        this.field_card_num = paramCursor.getInt(i);
      }
      else
      {
        if (ggD == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isDomesticUser = bool;
            break;
          }
        }
        if (ggE == k) {
          this.field_cre_type = paramCursor.getInt(i);
        } else if (ggF == k) {
          this.field_main_card_bind_serialno = paramCursor.getString(i);
        } else if (ggG == k) {
          this.field_ftf_pay_url = paramCursor.getString(i);
        } else if (ggH == k) {
          this.field_switchConfig = paramCursor.getInt(i);
        } else if (ggI == k) {
          this.field_reset_passwd_flag = paramCursor.getString(i);
        } else if (ggJ == k) {
          this.field_find_passwd_url = paramCursor.getString(i);
        } else if (ggK == k) {
          this.field_is_open_touch = paramCursor.getInt(i);
        } else if (ggL == k) {
          this.field_lct_wording = paramCursor.getString(i);
        } else if (ggM == k) {
          this.field_lct_url = paramCursor.getString(i);
        } else if (ggN == k) {
          this.field_cre_name = paramCursor.getString(i);
        } else if (ggO == k) {
          this.field_lqt_state = paramCursor.getInt(i);
        } else if (ggP == k) {
          this.field_paymenu_use_new = paramCursor.getInt(i);
        } else if (ggQ == k) {
          this.field_is_show_lqb = paramCursor.getInt(i);
        } else if (ggR == k) {
          this.field_is_open_lqb = paramCursor.getInt(i);
        } else if (ggS == k) {
          this.field_lqb_open_url = paramCursor.getString(i);
        } else if (ggT == k) {
          this.field_lqt_cell_is_show = paramCursor.getInt(i);
        } else if (ggU == k) {
          this.field_lqt_cell_icon = paramCursor.getString(i);
        } else if (ggV == k) {
          this.field_lqt_cell_is_open_lqt = paramCursor.getInt(i);
        } else if (ggW == k) {
          this.field_lqt_cell_lqt_open_url = paramCursor.getString(i);
        } else if (ggX == k) {
          this.field_lqt_cell_lqt_title = paramCursor.getString(i);
        } else if (ggY == k) {
          this.field_lqt_cell_lqt_wording = paramCursor.getString(i);
        } else if (ggZ == k) {
          this.field_forget_passwd_url = paramCursor.getString(i);
        } else if (gha == k) {
          this.field_unipay_order_state = paramCursor.getInt(i);
        } else if (ghb == k) {
          this.field_bank_priority = paramCursor.getString(i);
        } else if (gfo == k) {
          this.field_wallet_balance = paramCursor.getLong(i);
        } else if (ghc == k) {
          this.field_wallet_entrance_balance_switch_state = paramCursor.getInt(i);
        } else if (ghd == k) {
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
    if (this.gfU) {
      localContentValues.put("uin", this.field_uin);
    }
    if (this.gfV) {
      localContentValues.put("is_reg", Integer.valueOf(this.field_is_reg));
    }
    if (this.gfW) {
      localContentValues.put("true_name", this.field_true_name);
    }
    if (this.gfX) {
      localContentValues.put("card_num", Integer.valueOf(this.field_card_num));
    }
    if (this.gfY) {
      localContentValues.put("isDomesticUser", Boolean.valueOf(this.field_isDomesticUser));
    }
    if (this.gfZ) {
      localContentValues.put("cre_type", Integer.valueOf(this.field_cre_type));
    }
    if (this.gga) {
      localContentValues.put("main_card_bind_serialno", this.field_main_card_bind_serialno);
    }
    if (this.ggb) {
      localContentValues.put("ftf_pay_url", this.field_ftf_pay_url);
    }
    if (this.ggc) {
      localContentValues.put("switchConfig", Integer.valueOf(this.field_switchConfig));
    }
    if (this.ggd) {
      localContentValues.put("reset_passwd_flag", this.field_reset_passwd_flag);
    }
    if (this.gge) {
      localContentValues.put("find_passwd_url", this.field_find_passwd_url);
    }
    if (this.ggf) {
      localContentValues.put("is_open_touch", Integer.valueOf(this.field_is_open_touch));
    }
    if (this.ggg) {
      localContentValues.put("lct_wording", this.field_lct_wording);
    }
    if (this.ggh) {
      localContentValues.put("lct_url", this.field_lct_url);
    }
    if (this.ggi) {
      localContentValues.put("cre_name", this.field_cre_name);
    }
    if (this.ggj) {
      localContentValues.put("lqt_state", Integer.valueOf(this.field_lqt_state));
    }
    if (this.ggk) {
      localContentValues.put("paymenu_use_new", Integer.valueOf(this.field_paymenu_use_new));
    }
    if (this.ggl) {
      localContentValues.put("is_show_lqb", Integer.valueOf(this.field_is_show_lqb));
    }
    if (this.ggm) {
      localContentValues.put("is_open_lqb", Integer.valueOf(this.field_is_open_lqb));
    }
    if (this.ggn) {
      localContentValues.put("lqb_open_url", this.field_lqb_open_url);
    }
    if (this.ggo) {
      localContentValues.put("lqt_cell_is_show", Integer.valueOf(this.field_lqt_cell_is_show));
    }
    if (this.ggp) {
      localContentValues.put("lqt_cell_icon", this.field_lqt_cell_icon);
    }
    if (this.ggq) {
      localContentValues.put("lqt_cell_is_open_lqt", Integer.valueOf(this.field_lqt_cell_is_open_lqt));
    }
    if (this.ggr) {
      localContentValues.put("lqt_cell_lqt_open_url", this.field_lqt_cell_lqt_open_url);
    }
    if (this.ggs) {
      localContentValues.put("lqt_cell_lqt_title", this.field_lqt_cell_lqt_title);
    }
    if (this.ggt) {
      localContentValues.put("lqt_cell_lqt_wording", this.field_lqt_cell_lqt_wording);
    }
    if (this.ggu) {
      localContentValues.put("forget_passwd_url", this.field_forget_passwd_url);
    }
    if (this.ggv) {
      localContentValues.put("unipay_order_state", Integer.valueOf(this.field_unipay_order_state));
    }
    if (this.ggw) {
      localContentValues.put("bank_priority", this.field_bank_priority);
    }
    if (this.gfi) {
      localContentValues.put("wallet_balance", Long.valueOf(this.field_wallet_balance));
    }
    if (this.ggx) {
      localContentValues.put("wallet_entrance_balance_switch_state", Integer.valueOf(this.field_wallet_entrance_balance_switch_state));
    }
    if (this.ggy) {
      localContentValues.put("soter_pay_open_type", Integer.valueOf(this.field_soter_pay_open_type));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.hl
 * JD-Core Version:    0.7.0.1
 */