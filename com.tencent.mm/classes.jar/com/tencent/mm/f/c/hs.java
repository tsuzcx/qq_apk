package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hs
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WalletUserInfo");
  public static final Column iGC;
  private static final int iGO = "wallet_balance".hashCode();
  public static final Column iHJ;
  public static final Column iHK;
  public static final Column iHL;
  public static final Column iHM;
  public static final Column iHN;
  public static final Column iHO;
  public static final Column iHP;
  public static final Column iHQ;
  public static final Column iHR;
  public static final Column iHS;
  public static final Column iHT;
  public static final Column iHU;
  public static final Column iHV;
  public static final Column iHW;
  public static final Column iHX;
  public static final Column iHY;
  public static final Column iHZ;
  private static final int iIT;
  private static final int iIU;
  private static final int iIV;
  private static final int iIW;
  private static final int iIX;
  private static final int iIY;
  private static final int iIZ;
  public static final Column iIa;
  public static final Column iIb;
  public static final Column iIc;
  public static final Column iId;
  public static final Column iIe;
  public static final Column iIf;
  public static final Column iIg;
  public static final Column iIh;
  public static final Column iIi;
  public static final Column iIj;
  public static final Column iIk;
  public static final Column iIl;
  public static final Column iIm;
  public static final Column iIn;
  private static final int iJa;
  private static final int iJb;
  private static final int iJc;
  private static final int iJd;
  private static final int iJe;
  private static final int iJf;
  private static final int iJg;
  private static final int iJh;
  private static final int iJi;
  private static final int iJj;
  private static final int iJk;
  private static final int iJl;
  private static final int iJm;
  private static final int iJn;
  private static final int iJo;
  private static final int iJp;
  private static final int iJq;
  private static final int iJr;
  private static final int iJs;
  private static final int iJt;
  private static final int iJu;
  private static final int iJv;
  private static final int iJw = "wallet_entrance_balance_switch_state".hashCode();
  private static final int iJx = "soter_pay_open_type".hashCode();
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
  private boolean iGI = true;
  private boolean iIA = true;
  private boolean iIB = true;
  private boolean iIC = true;
  private boolean iID = true;
  private boolean iIE = true;
  private boolean iIF = true;
  private boolean iIG = true;
  private boolean iIH = true;
  private boolean iII = true;
  private boolean iIJ = true;
  private boolean iIK = true;
  private boolean iIL = true;
  private boolean iIM = true;
  private boolean iIN = true;
  private boolean iIO = true;
  private boolean iIP = true;
  private boolean iIQ = true;
  private boolean iIR = true;
  private boolean iIS = true;
  private boolean iIo = true;
  private boolean iIp = true;
  private boolean iIq = true;
  private boolean iIr = true;
  private boolean iIs = true;
  private boolean iIt = true;
  private boolean iIu = true;
  private boolean iIv = true;
  private boolean iIw = true;
  private boolean iIx = true;
  private boolean iIy = true;
  private boolean iIz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WalletUserInfo", "");
    iHJ = new Column("uin", "string", "WalletUserInfo", "");
    iHK = new Column("is_reg", "int", "WalletUserInfo", "");
    iHL = new Column("true_name", "string", "WalletUserInfo", "");
    iHM = new Column("card_num", "int", "WalletUserInfo", "");
    iHN = new Column("isdomesticuser", "boolean", "WalletUserInfo", "");
    iHO = new Column("cre_type", "int", "WalletUserInfo", "");
    iHP = new Column("main_card_bind_serialno", "string", "WalletUserInfo", "");
    iHQ = new Column("ftf_pay_url", "string", "WalletUserInfo", "");
    iHR = new Column("switchconfig", "int", "WalletUserInfo", "");
    iHS = new Column("reset_passwd_flag", "string", "WalletUserInfo", "");
    iHT = new Column("find_passwd_url", "string", "WalletUserInfo", "");
    iHU = new Column("is_open_touch", "int", "WalletUserInfo", "");
    iHV = new Column("lct_wording", "string", "WalletUserInfo", "");
    iHW = new Column("lct_url", "string", "WalletUserInfo", "");
    iHX = new Column("cre_name", "string", "WalletUserInfo", "");
    iHY = new Column("lqt_state", "int", "WalletUserInfo", "");
    iHZ = new Column("paymenu_use_new", "int", "WalletUserInfo", "");
    iIa = new Column("is_show_lqb", "int", "WalletUserInfo", "");
    iIb = new Column("is_open_lqb", "int", "WalletUserInfo", "");
    iIc = new Column("lqb_open_url", "string", "WalletUserInfo", "");
    iId = new Column("lqt_cell_is_show", "int", "WalletUserInfo", "");
    iIe = new Column("lqt_cell_icon", "string", "WalletUserInfo", "");
    iIf = new Column("lqt_cell_is_open_lqt", "int", "WalletUserInfo", "");
    iIg = new Column("lqt_cell_lqt_open_url", "string", "WalletUserInfo", "");
    iIh = new Column("lqt_cell_lqt_title", "string", "WalletUserInfo", "");
    iIi = new Column("lqt_cell_lqt_wording", "string", "WalletUserInfo", "");
    iIj = new Column("forget_passwd_url", "string", "WalletUserInfo", "");
    iIk = new Column("unipay_order_state", "int", "WalletUserInfo", "");
    iIl = new Column("bank_priority", "string", "WalletUserInfo", "");
    iGC = new Column("wallet_balance", "long", "WalletUserInfo", "");
    iIm = new Column("wallet_entrance_balance_switch_state", "int", "WalletUserInfo", "");
    iIn = new Column("soter_pay_open_type", "int", "WalletUserInfo", "");
    iIT = "uin".hashCode();
    iIU = "is_reg".hashCode();
    iIV = "true_name".hashCode();
    iIW = "card_num".hashCode();
    iIX = "isDomesticUser".hashCode();
    iIY = "cre_type".hashCode();
    iIZ = "main_card_bind_serialno".hashCode();
    iJa = "ftf_pay_url".hashCode();
    iJb = "switchConfig".hashCode();
    iJc = "reset_passwd_flag".hashCode();
    iJd = "find_passwd_url".hashCode();
    iJe = "is_open_touch".hashCode();
    iJf = "lct_wording".hashCode();
    iJg = "lct_url".hashCode();
    iJh = "cre_name".hashCode();
    iJi = "lqt_state".hashCode();
    iJj = "paymenu_use_new".hashCode();
    iJk = "is_show_lqb".hashCode();
    iJl = "is_open_lqb".hashCode();
    iJm = "lqb_open_url".hashCode();
    iJn = "lqt_cell_is_show".hashCode();
    iJo = "lqt_cell_icon".hashCode();
    iJp = "lqt_cell_is_open_lqt".hashCode();
    iJq = "lqt_cell_lqt_open_url".hashCode();
    iJr = "lqt_cell_lqt_title".hashCode();
    iJs = "lqt_cell_lqt_wording".hashCode();
    iJt = "forget_passwd_url".hashCode();
    iJu = "unipay_order_state".hashCode();
    iJv = "bank_priority".hashCode();
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
      if (iIT != k) {
        break label65;
      }
      this.field_uin = paramCursor.getString(i);
      this.iIo = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iIU == k)
      {
        this.field_is_reg = paramCursor.getInt(i);
      }
      else if (iIV == k)
      {
        this.field_true_name = paramCursor.getString(i);
      }
      else if (iIW == k)
      {
        this.field_card_num = paramCursor.getInt(i);
      }
      else
      {
        if (iIX == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isDomesticUser = bool;
            break;
          }
        }
        if (iIY == k) {
          this.field_cre_type = paramCursor.getInt(i);
        } else if (iIZ == k) {
          this.field_main_card_bind_serialno = paramCursor.getString(i);
        } else if (iJa == k) {
          this.field_ftf_pay_url = paramCursor.getString(i);
        } else if (iJb == k) {
          this.field_switchConfig = paramCursor.getInt(i);
        } else if (iJc == k) {
          this.field_reset_passwd_flag = paramCursor.getString(i);
        } else if (iJd == k) {
          this.field_find_passwd_url = paramCursor.getString(i);
        } else if (iJe == k) {
          this.field_is_open_touch = paramCursor.getInt(i);
        } else if (iJf == k) {
          this.field_lct_wording = paramCursor.getString(i);
        } else if (iJg == k) {
          this.field_lct_url = paramCursor.getString(i);
        } else if (iJh == k) {
          this.field_cre_name = paramCursor.getString(i);
        } else if (iJi == k) {
          this.field_lqt_state = paramCursor.getInt(i);
        } else if (iJj == k) {
          this.field_paymenu_use_new = paramCursor.getInt(i);
        } else if (iJk == k) {
          this.field_is_show_lqb = paramCursor.getInt(i);
        } else if (iJl == k) {
          this.field_is_open_lqb = paramCursor.getInt(i);
        } else if (iJm == k) {
          this.field_lqb_open_url = paramCursor.getString(i);
        } else if (iJn == k) {
          this.field_lqt_cell_is_show = paramCursor.getInt(i);
        } else if (iJo == k) {
          this.field_lqt_cell_icon = paramCursor.getString(i);
        } else if (iJp == k) {
          this.field_lqt_cell_is_open_lqt = paramCursor.getInt(i);
        } else if (iJq == k) {
          this.field_lqt_cell_lqt_open_url = paramCursor.getString(i);
        } else if (iJr == k) {
          this.field_lqt_cell_lqt_title = paramCursor.getString(i);
        } else if (iJs == k) {
          this.field_lqt_cell_lqt_wording = paramCursor.getString(i);
        } else if (iJt == k) {
          this.field_forget_passwd_url = paramCursor.getString(i);
        } else if (iJu == k) {
          this.field_unipay_order_state = paramCursor.getInt(i);
        } else if (iJv == k) {
          this.field_bank_priority = paramCursor.getString(i);
        } else if (iGO == k) {
          this.field_wallet_balance = paramCursor.getLong(i);
        } else if (iJw == k) {
          this.field_wallet_entrance_balance_switch_state = paramCursor.getInt(i);
        } else if (iJx == k) {
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
    if (this.iIo) {
      localContentValues.put("uin", this.field_uin);
    }
    if (this.iIp) {
      localContentValues.put("is_reg", Integer.valueOf(this.field_is_reg));
    }
    if (this.iIq) {
      localContentValues.put("true_name", this.field_true_name);
    }
    if (this.iIr) {
      localContentValues.put("card_num", Integer.valueOf(this.field_card_num));
    }
    if (this.iIs) {
      localContentValues.put("isDomesticUser", Boolean.valueOf(this.field_isDomesticUser));
    }
    if (this.iIt) {
      localContentValues.put("cre_type", Integer.valueOf(this.field_cre_type));
    }
    if (this.iIu) {
      localContentValues.put("main_card_bind_serialno", this.field_main_card_bind_serialno);
    }
    if (this.iIv) {
      localContentValues.put("ftf_pay_url", this.field_ftf_pay_url);
    }
    if (this.iIw) {
      localContentValues.put("switchConfig", Integer.valueOf(this.field_switchConfig));
    }
    if (this.iIx) {
      localContentValues.put("reset_passwd_flag", this.field_reset_passwd_flag);
    }
    if (this.iIy) {
      localContentValues.put("find_passwd_url", this.field_find_passwd_url);
    }
    if (this.iIz) {
      localContentValues.put("is_open_touch", Integer.valueOf(this.field_is_open_touch));
    }
    if (this.iIA) {
      localContentValues.put("lct_wording", this.field_lct_wording);
    }
    if (this.iIB) {
      localContentValues.put("lct_url", this.field_lct_url);
    }
    if (this.iIC) {
      localContentValues.put("cre_name", this.field_cre_name);
    }
    if (this.iID) {
      localContentValues.put("lqt_state", Integer.valueOf(this.field_lqt_state));
    }
    if (this.iIE) {
      localContentValues.put("paymenu_use_new", Integer.valueOf(this.field_paymenu_use_new));
    }
    if (this.iIF) {
      localContentValues.put("is_show_lqb", Integer.valueOf(this.field_is_show_lqb));
    }
    if (this.iIG) {
      localContentValues.put("is_open_lqb", Integer.valueOf(this.field_is_open_lqb));
    }
    if (this.iIH) {
      localContentValues.put("lqb_open_url", this.field_lqb_open_url);
    }
    if (this.iII) {
      localContentValues.put("lqt_cell_is_show", Integer.valueOf(this.field_lqt_cell_is_show));
    }
    if (this.iIJ) {
      localContentValues.put("lqt_cell_icon", this.field_lqt_cell_icon);
    }
    if (this.iIK) {
      localContentValues.put("lqt_cell_is_open_lqt", Integer.valueOf(this.field_lqt_cell_is_open_lqt));
    }
    if (this.iIL) {
      localContentValues.put("lqt_cell_lqt_open_url", this.field_lqt_cell_lqt_open_url);
    }
    if (this.iIM) {
      localContentValues.put("lqt_cell_lqt_title", this.field_lqt_cell_lqt_title);
    }
    if (this.iIN) {
      localContentValues.put("lqt_cell_lqt_wording", this.field_lqt_cell_lqt_wording);
    }
    if (this.iIO) {
      localContentValues.put("forget_passwd_url", this.field_forget_passwd_url);
    }
    if (this.iIP) {
      localContentValues.put("unipay_order_state", Integer.valueOf(this.field_unipay_order_state));
    }
    if (this.iIQ) {
      localContentValues.put("bank_priority", this.field_bank_priority);
    }
    if (this.iGI) {
      localContentValues.put("wallet_balance", Long.valueOf(this.field_wallet_balance));
    }
    if (this.iIR) {
      localContentValues.put("wallet_entrance_balance_switch_state", Integer.valueOf(this.field_wallet_entrance_balance_switch_state));
    }
    if (this.iIS) {
      localContentValues.put("soter_pay_open_type", Integer.valueOf(this.field_soter_pay_open_type));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "WalletUserInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.c.hs
 * JD-Core Version:    0.7.0.1
 */