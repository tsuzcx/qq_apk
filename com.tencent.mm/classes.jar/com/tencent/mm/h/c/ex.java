package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ex
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ddA;
  private static final int ddB;
  private static final int ddC;
  private static final int ddD;
  private static final int ddE;
  private static final int ddF;
  private static final int ddf = "uin".hashCode();
  private static final int ddg = "is_reg".hashCode();
  private static final int ddh = "true_name".hashCode();
  private static final int ddi = "card_num".hashCode();
  private static final int ddj = "isDomesticUser".hashCode();
  private static final int ddk = "cre_type".hashCode();
  private static final int ddl = "main_card_bind_serialno".hashCode();
  private static final int ddm = "ftf_pay_url".hashCode();
  private static final int ddn = "switchConfig".hashCode();
  private static final int ddo = "reset_passwd_flag".hashCode();
  private static final int ddp = "find_passwd_url".hashCode();
  private static final int ddq = "is_open_touch".hashCode();
  private static final int ddr = "lct_wording".hashCode();
  private static final int dds = "lct_url".hashCode();
  private static final int ddt = "cre_name".hashCode();
  private static final int ddu = "lqt_state".hashCode();
  private static final int ddv = "paymenu_use_new".hashCode();
  private static final int ddw = "is_show_lqb".hashCode();
  private static final int ddx = "is_open_lqb".hashCode();
  private static final int ddy = "lqb_open_url".hashCode();
  private static final int ddz = "lqt_cell_is_show".hashCode();
  private boolean dcE = true;
  private boolean dcF = true;
  private boolean dcG = true;
  private boolean dcH = true;
  private boolean dcI = true;
  private boolean dcJ = true;
  private boolean dcK = true;
  private boolean dcL = true;
  private boolean dcM = true;
  private boolean dcN = true;
  private boolean dcO = true;
  private boolean dcP = true;
  private boolean dcQ = true;
  private boolean dcR = true;
  private boolean dcS = true;
  private boolean dcT = true;
  private boolean dcU = true;
  private boolean dcV = true;
  private boolean dcW = true;
  private boolean dcX = true;
  private boolean dcY = true;
  private boolean dcZ = true;
  private boolean dda = true;
  private boolean ddb = true;
  private boolean ddc = true;
  private boolean ddd = true;
  private boolean dde = true;
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
  public int field_switchConfig;
  public String field_true_name;
  public String field_uin;
  
  static
  {
    ddA = "lqt_cell_icon".hashCode();
    ddB = "lqt_cell_is_open_lqt".hashCode();
    ddC = "lqt_cell_lqt_open_url".hashCode();
    ddD = "lqt_cell_lqt_title".hashCode();
    ddE = "lqt_cell_lqt_wording".hashCode();
    ddF = "forget_passwd_url".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (ddf != k) {
        break label65;
      }
      this.field_uin = paramCursor.getString(i);
      this.dcE = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ddg == k)
      {
        this.field_is_reg = paramCursor.getInt(i);
      }
      else if (ddh == k)
      {
        this.field_true_name = paramCursor.getString(i);
      }
      else if (ddi == k)
      {
        this.field_card_num = paramCursor.getInt(i);
      }
      else
      {
        if (ddj == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isDomesticUser = bool;
            break;
          }
        }
        if (ddk == k) {
          this.field_cre_type = paramCursor.getInt(i);
        } else if (ddl == k) {
          this.field_main_card_bind_serialno = paramCursor.getString(i);
        } else if (ddm == k) {
          this.field_ftf_pay_url = paramCursor.getString(i);
        } else if (ddn == k) {
          this.field_switchConfig = paramCursor.getInt(i);
        } else if (ddo == k) {
          this.field_reset_passwd_flag = paramCursor.getString(i);
        } else if (ddp == k) {
          this.field_find_passwd_url = paramCursor.getString(i);
        } else if (ddq == k) {
          this.field_is_open_touch = paramCursor.getInt(i);
        } else if (ddr == k) {
          this.field_lct_wording = paramCursor.getString(i);
        } else if (dds == k) {
          this.field_lct_url = paramCursor.getString(i);
        } else if (ddt == k) {
          this.field_cre_name = paramCursor.getString(i);
        } else if (ddu == k) {
          this.field_lqt_state = paramCursor.getInt(i);
        } else if (ddv == k) {
          this.field_paymenu_use_new = paramCursor.getInt(i);
        } else if (ddw == k) {
          this.field_is_show_lqb = paramCursor.getInt(i);
        } else if (ddx == k) {
          this.field_is_open_lqb = paramCursor.getInt(i);
        } else if (ddy == k) {
          this.field_lqb_open_url = paramCursor.getString(i);
        } else if (ddz == k) {
          this.field_lqt_cell_is_show = paramCursor.getInt(i);
        } else if (ddA == k) {
          this.field_lqt_cell_icon = paramCursor.getString(i);
        } else if (ddB == k) {
          this.field_lqt_cell_is_open_lqt = paramCursor.getInt(i);
        } else if (ddC == k) {
          this.field_lqt_cell_lqt_open_url = paramCursor.getString(i);
        } else if (ddD == k) {
          this.field_lqt_cell_lqt_title = paramCursor.getString(i);
        } else if (ddE == k) {
          this.field_lqt_cell_lqt_wording = paramCursor.getString(i);
        } else if (ddF == k) {
          this.field_forget_passwd_url = paramCursor.getString(i);
        } else if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dcE) {
      localContentValues.put("uin", this.field_uin);
    }
    if (this.dcF) {
      localContentValues.put("is_reg", Integer.valueOf(this.field_is_reg));
    }
    if (this.dcG) {
      localContentValues.put("true_name", this.field_true_name);
    }
    if (this.dcH) {
      localContentValues.put("card_num", Integer.valueOf(this.field_card_num));
    }
    if (this.dcI) {
      localContentValues.put("isDomesticUser", Boolean.valueOf(this.field_isDomesticUser));
    }
    if (this.dcJ) {
      localContentValues.put("cre_type", Integer.valueOf(this.field_cre_type));
    }
    if (this.dcK) {
      localContentValues.put("main_card_bind_serialno", this.field_main_card_bind_serialno);
    }
    if (this.dcL) {
      localContentValues.put("ftf_pay_url", this.field_ftf_pay_url);
    }
    if (this.dcM) {
      localContentValues.put("switchConfig", Integer.valueOf(this.field_switchConfig));
    }
    if (this.dcN) {
      localContentValues.put("reset_passwd_flag", this.field_reset_passwd_flag);
    }
    if (this.dcO) {
      localContentValues.put("find_passwd_url", this.field_find_passwd_url);
    }
    if (this.dcP) {
      localContentValues.put("is_open_touch", Integer.valueOf(this.field_is_open_touch));
    }
    if (this.dcQ) {
      localContentValues.put("lct_wording", this.field_lct_wording);
    }
    if (this.dcR) {
      localContentValues.put("lct_url", this.field_lct_url);
    }
    if (this.dcS) {
      localContentValues.put("cre_name", this.field_cre_name);
    }
    if (this.dcT) {
      localContentValues.put("lqt_state", Integer.valueOf(this.field_lqt_state));
    }
    if (this.dcU) {
      localContentValues.put("paymenu_use_new", Integer.valueOf(this.field_paymenu_use_new));
    }
    if (this.dcV) {
      localContentValues.put("is_show_lqb", Integer.valueOf(this.field_is_show_lqb));
    }
    if (this.dcW) {
      localContentValues.put("is_open_lqb", Integer.valueOf(this.field_is_open_lqb));
    }
    if (this.dcX) {
      localContentValues.put("lqb_open_url", this.field_lqb_open_url);
    }
    if (this.dcY) {
      localContentValues.put("lqt_cell_is_show", Integer.valueOf(this.field_lqt_cell_is_show));
    }
    if (this.dcZ) {
      localContentValues.put("lqt_cell_icon", this.field_lqt_cell_icon);
    }
    if (this.dda) {
      localContentValues.put("lqt_cell_is_open_lqt", Integer.valueOf(this.field_lqt_cell_is_open_lqt));
    }
    if (this.ddb) {
      localContentValues.put("lqt_cell_lqt_open_url", this.field_lqt_cell_lqt_open_url);
    }
    if (this.ddc) {
      localContentValues.put("lqt_cell_lqt_title", this.field_lqt_cell_lqt_title);
    }
    if (this.ddd) {
      localContentValues.put("lqt_cell_lqt_wording", this.field_lqt_cell_lqt_wording);
    }
    if (this.dde) {
      localContentValues.put("forget_passwd_url", this.field_forget_passwd_url);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.ex
 * JD-Core Version:    0.7.0.1
 */