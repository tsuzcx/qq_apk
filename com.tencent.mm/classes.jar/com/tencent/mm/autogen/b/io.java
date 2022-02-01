package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class io
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WalletUserInfo");
  private static final int liC;
  public static final Column liq;
  public static final Column ljA;
  public static final Column ljB;
  public static final Column ljC;
  public static final Column ljD;
  public static final Column ljE;
  public static final Column ljF;
  public static final Column ljG;
  public static final Column ljH;
  public static final Column ljI;
  public static final Column ljJ;
  public static final Column ljK;
  public static final Column ljL;
  public static final Column ljM;
  public static final Column ljN;
  public static final Column ljO;
  public static final Column ljP;
  public static final Column ljQ;
  public static final Column ljR;
  public static final Column ljS;
  public static final Column ljT;
  public static final Column ljU;
  public static final Column ljV;
  public static final Column ljW;
  public static final Column ljX;
  public static final Column ljY;
  public static final Column ljZ;
  public static final Column ljx;
  public static final Column ljy;
  public static final Column ljz;
  private static final int lkJ;
  private static final int lkK;
  private static final int lkL;
  private static final int lkM;
  private static final int lkN;
  private static final int lkO;
  private static final int lkP;
  private static final int lkQ;
  private static final int lkR;
  private static final int lkS;
  private static final int lkT;
  private static final int lkU;
  private static final int lkV;
  private static final int lkW;
  private static final int lkX;
  private static final int lkY;
  private static final int lkZ;
  public static final Column lka;
  public static final Column lkb;
  public static final Column lkc;
  private static final int lla;
  private static final int llb;
  private static final int llc;
  private static final int lld;
  private static final int lle;
  private static final int llf;
  private static final int llg;
  private static final int llh;
  private static final int lli;
  private static final int llj;
  private static final int llk;
  private static final int lll;
  private static final int llm;
  private static final int lln;
  private static final int llo;
  private static final StorageObserverOwner<io> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_authen_account_type;
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
  private boolean liw = true;
  private boolean lkA = true;
  private boolean lkB = true;
  private boolean lkC = true;
  private boolean lkD = true;
  private boolean lkE = true;
  private boolean lkF = true;
  private boolean lkG = true;
  private boolean lkH = true;
  private boolean lkI = true;
  private boolean lkd = true;
  private boolean lke = true;
  private boolean lkf = true;
  private boolean lkg = true;
  private boolean lkh = true;
  private boolean lki = true;
  private boolean lkj = true;
  private boolean lkk = true;
  private boolean lkl = true;
  private boolean lkm = true;
  private boolean lkn = true;
  private boolean lko = true;
  private boolean lkp = true;
  private boolean lkq = true;
  private boolean lkr = true;
  private boolean lks = true;
  private boolean lkt = true;
  private boolean lku = true;
  private boolean lkv = true;
  private boolean lkw = true;
  private boolean lkx = true;
  private boolean lky = true;
  private boolean lkz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    ljx = new Column("uin", "string", TABLE.getName(), "");
    ljy = new Column("is_reg", "int", TABLE.getName(), "");
    ljz = new Column("true_name", "string", TABLE.getName(), "");
    ljA = new Column("card_num", "int", TABLE.getName(), "");
    ljB = new Column("isDomesticUser", "boolean", TABLE.getName(), "");
    ljC = new Column("cre_type", "int", TABLE.getName(), "");
    ljD = new Column("main_card_bind_serialno", "string", TABLE.getName(), "");
    ljE = new Column("ftf_pay_url", "string", TABLE.getName(), "");
    ljF = new Column("switchConfig", "int", TABLE.getName(), "");
    ljG = new Column("reset_passwd_flag", "string", TABLE.getName(), "");
    ljH = new Column("find_passwd_url", "string", TABLE.getName(), "");
    ljI = new Column("is_open_touch", "int", TABLE.getName(), "");
    ljJ = new Column("lct_wording", "string", TABLE.getName(), "");
    ljK = new Column("lct_url", "string", TABLE.getName(), "");
    ljL = new Column("cre_name", "string", TABLE.getName(), "");
    ljM = new Column("lqt_state", "int", TABLE.getName(), "");
    ljN = new Column("paymenu_use_new", "int", TABLE.getName(), "");
    ljO = new Column("is_show_lqb", "int", TABLE.getName(), "");
    ljP = new Column("is_open_lqb", "int", TABLE.getName(), "");
    ljQ = new Column("lqb_open_url", "string", TABLE.getName(), "");
    ljR = new Column("lqt_cell_is_show", "int", TABLE.getName(), "");
    ljS = new Column("lqt_cell_icon", "string", TABLE.getName(), "");
    ljT = new Column("lqt_cell_is_open_lqt", "int", TABLE.getName(), "");
    ljU = new Column("lqt_cell_lqt_open_url", "string", TABLE.getName(), "");
    ljV = new Column("lqt_cell_lqt_title", "string", TABLE.getName(), "");
    ljW = new Column("lqt_cell_lqt_wording", "string", TABLE.getName(), "");
    ljX = new Column("forget_passwd_url", "string", TABLE.getName(), "");
    ljY = new Column("unipay_order_state", "int", TABLE.getName(), "");
    ljZ = new Column("bank_priority", "string", TABLE.getName(), "");
    liq = new Column("wallet_balance", "long", TABLE.getName(), "");
    lka = new Column("wallet_entrance_balance_switch_state", "int", TABLE.getName(), "");
    lkb = new Column("soter_pay_open_type", "int", TABLE.getName(), "");
    lkc = new Column("authen_account_type", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    lkJ = "uin".hashCode();
    lkK = "is_reg".hashCode();
    lkL = "true_name".hashCode();
    lkM = "card_num".hashCode();
    lkN = "isDomesticUser".hashCode();
    lkO = "cre_type".hashCode();
    lkP = "main_card_bind_serialno".hashCode();
    lkQ = "ftf_pay_url".hashCode();
    lkR = "switchConfig".hashCode();
    lkS = "reset_passwd_flag".hashCode();
    lkT = "find_passwd_url".hashCode();
    lkU = "is_open_touch".hashCode();
    lkV = "lct_wording".hashCode();
    lkW = "lct_url".hashCode();
    lkX = "cre_name".hashCode();
    lkY = "lqt_state".hashCode();
    lkZ = "paymenu_use_new".hashCode();
    lla = "is_show_lqb".hashCode();
    llb = "is_open_lqb".hashCode();
    llc = "lqb_open_url".hashCode();
    lld = "lqt_cell_is_show".hashCode();
    lle = "lqt_cell_icon".hashCode();
    llf = "lqt_cell_is_open_lqt".hashCode();
    llg = "lqt_cell_lqt_open_url".hashCode();
    llh = "lqt_cell_lqt_title".hashCode();
    lli = "lqt_cell_lqt_wording".hashCode();
    llj = "forget_passwd_url".hashCode();
    llk = "unipay_order_state".hashCode();
    lll = "bank_priority".hashCode();
    liC = "wallet_balance".hashCode();
    llm = "wallet_entrance_balance_switch_state".hashCode();
    lln = "soter_pay_open_type".hashCode();
    llo = "authen_account_type".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[33];
    localMAutoDBInfo.columns = new String[34];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "uin";
    localMAutoDBInfo.colsMap.put("uin", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" uin TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "uin";
    localMAutoDBInfo.columns[1] = "is_reg";
    localMAutoDBInfo.colsMap.put("is_reg", "INTEGER");
    localStringBuilder.append(" is_reg INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "true_name";
    localMAutoDBInfo.colsMap.put("true_name", "TEXT");
    localStringBuilder.append(" true_name TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "card_num";
    localMAutoDBInfo.colsMap.put("card_num", "INTEGER");
    localStringBuilder.append(" card_num INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "isDomesticUser";
    localMAutoDBInfo.colsMap.put("isDomesticUser", "INTEGER");
    localStringBuilder.append(" isDomesticUser INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "cre_type";
    localMAutoDBInfo.colsMap.put("cre_type", "INTEGER");
    localStringBuilder.append(" cre_type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "main_card_bind_serialno";
    localMAutoDBInfo.colsMap.put("main_card_bind_serialno", "TEXT");
    localStringBuilder.append(" main_card_bind_serialno TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "ftf_pay_url";
    localMAutoDBInfo.colsMap.put("ftf_pay_url", "TEXT");
    localStringBuilder.append(" ftf_pay_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "switchConfig";
    localMAutoDBInfo.colsMap.put("switchConfig", "INTEGER");
    localStringBuilder.append(" switchConfig INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "reset_passwd_flag";
    localMAutoDBInfo.colsMap.put("reset_passwd_flag", "TEXT");
    localStringBuilder.append(" reset_passwd_flag TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "find_passwd_url";
    localMAutoDBInfo.colsMap.put("find_passwd_url", "TEXT");
    localStringBuilder.append(" find_passwd_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "is_open_touch";
    localMAutoDBInfo.colsMap.put("is_open_touch", "INTEGER");
    localStringBuilder.append(" is_open_touch INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "lct_wording";
    localMAutoDBInfo.colsMap.put("lct_wording", "TEXT");
    localStringBuilder.append(" lct_wording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "lct_url";
    localMAutoDBInfo.colsMap.put("lct_url", "TEXT");
    localStringBuilder.append(" lct_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "cre_name";
    localMAutoDBInfo.colsMap.put("cre_name", "TEXT");
    localStringBuilder.append(" cre_name TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "lqt_state";
    localMAutoDBInfo.colsMap.put("lqt_state", "INTEGER");
    localStringBuilder.append(" lqt_state INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "paymenu_use_new";
    localMAutoDBInfo.colsMap.put("paymenu_use_new", "INTEGER");
    localStringBuilder.append(" paymenu_use_new INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "is_show_lqb";
    localMAutoDBInfo.colsMap.put("is_show_lqb", "INTEGER");
    localStringBuilder.append(" is_show_lqb INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "is_open_lqb";
    localMAutoDBInfo.colsMap.put("is_open_lqb", "INTEGER");
    localStringBuilder.append(" is_open_lqb INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "lqb_open_url";
    localMAutoDBInfo.colsMap.put("lqb_open_url", "TEXT");
    localStringBuilder.append(" lqb_open_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "lqt_cell_is_show";
    localMAutoDBInfo.colsMap.put("lqt_cell_is_show", "INTEGER");
    localStringBuilder.append(" lqt_cell_is_show INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "lqt_cell_icon";
    localMAutoDBInfo.colsMap.put("lqt_cell_icon", "TEXT");
    localStringBuilder.append(" lqt_cell_icon TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "lqt_cell_is_open_lqt";
    localMAutoDBInfo.colsMap.put("lqt_cell_is_open_lqt", "INTEGER");
    localStringBuilder.append(" lqt_cell_is_open_lqt INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "lqt_cell_lqt_open_url";
    localMAutoDBInfo.colsMap.put("lqt_cell_lqt_open_url", "TEXT");
    localStringBuilder.append(" lqt_cell_lqt_open_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "lqt_cell_lqt_title";
    localMAutoDBInfo.colsMap.put("lqt_cell_lqt_title", "TEXT");
    localStringBuilder.append(" lqt_cell_lqt_title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "lqt_cell_lqt_wording";
    localMAutoDBInfo.colsMap.put("lqt_cell_lqt_wording", "TEXT");
    localStringBuilder.append(" lqt_cell_lqt_wording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "forget_passwd_url";
    localMAutoDBInfo.colsMap.put("forget_passwd_url", "TEXT");
    localStringBuilder.append(" forget_passwd_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "unipay_order_state";
    localMAutoDBInfo.colsMap.put("unipay_order_state", "INTEGER");
    localStringBuilder.append(" unipay_order_state INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "bank_priority";
    localMAutoDBInfo.colsMap.put("bank_priority", "TEXT");
    localStringBuilder.append(" bank_priority TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "wallet_balance";
    localMAutoDBInfo.colsMap.put("wallet_balance", "LONG");
    localStringBuilder.append(" wallet_balance LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "wallet_entrance_balance_switch_state";
    localMAutoDBInfo.colsMap.put("wallet_entrance_balance_switch_state", "INTEGER");
    localStringBuilder.append(" wallet_entrance_balance_switch_state INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "soter_pay_open_type";
    localMAutoDBInfo.colsMap.put("soter_pay_open_type", "INTEGER");
    localStringBuilder.append(" soter_pay_open_type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "authen_account_type";
    localMAutoDBInfo.colsMap.put("authen_account_type", "INTEGER default '-1' ");
    localStringBuilder.append(" authen_account_type INTEGER default '-1' ");
    localMAutoDBInfo.columns[33] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("uin"))
    {
      this.field_uin = paramContentValues.getAsString("uin");
      if (paramBoolean) {
        this.lkd = true;
      }
    }
    if (paramContentValues.containsKey("is_reg"))
    {
      this.field_is_reg = paramContentValues.getAsInteger("is_reg").intValue();
      if (paramBoolean) {
        this.lke = true;
      }
    }
    if (paramContentValues.containsKey("true_name"))
    {
      this.field_true_name = paramContentValues.getAsString("true_name");
      if (paramBoolean) {
        this.lkf = true;
      }
    }
    if (paramContentValues.containsKey("card_num"))
    {
      this.field_card_num = paramContentValues.getAsInteger("card_num").intValue();
      if (paramBoolean) {
        this.lkg = true;
      }
    }
    if (paramContentValues.containsKey("isDomesticUser")) {
      if (paramContentValues.getAsInteger("isDomesticUser").intValue() == 0) {
        break label1036;
      }
    }
    label1036:
    for (boolean bool = true;; bool = false)
    {
      this.field_isDomesticUser = bool;
      if (paramBoolean) {
        this.lkh = true;
      }
      if (paramContentValues.containsKey("cre_type"))
      {
        this.field_cre_type = paramContentValues.getAsInteger("cre_type").intValue();
        if (paramBoolean) {
          this.lki = true;
        }
      }
      if (paramContentValues.containsKey("main_card_bind_serialno"))
      {
        this.field_main_card_bind_serialno = paramContentValues.getAsString("main_card_bind_serialno");
        if (paramBoolean) {
          this.lkj = true;
        }
      }
      if (paramContentValues.containsKey("ftf_pay_url"))
      {
        this.field_ftf_pay_url = paramContentValues.getAsString("ftf_pay_url");
        if (paramBoolean) {
          this.lkk = true;
        }
      }
      if (paramContentValues.containsKey("switchConfig"))
      {
        this.field_switchConfig = paramContentValues.getAsInteger("switchConfig").intValue();
        if (paramBoolean) {
          this.lkl = true;
        }
      }
      if (paramContentValues.containsKey("reset_passwd_flag"))
      {
        this.field_reset_passwd_flag = paramContentValues.getAsString("reset_passwd_flag");
        if (paramBoolean) {
          this.lkm = true;
        }
      }
      if (paramContentValues.containsKey("find_passwd_url"))
      {
        this.field_find_passwd_url = paramContentValues.getAsString("find_passwd_url");
        if (paramBoolean) {
          this.lkn = true;
        }
      }
      if (paramContentValues.containsKey("is_open_touch"))
      {
        this.field_is_open_touch = paramContentValues.getAsInteger("is_open_touch").intValue();
        if (paramBoolean) {
          this.lko = true;
        }
      }
      if (paramContentValues.containsKey("lct_wording"))
      {
        this.field_lct_wording = paramContentValues.getAsString("lct_wording");
        if (paramBoolean) {
          this.lkp = true;
        }
      }
      if (paramContentValues.containsKey("lct_url"))
      {
        this.field_lct_url = paramContentValues.getAsString("lct_url");
        if (paramBoolean) {
          this.lkq = true;
        }
      }
      if (paramContentValues.containsKey("cre_name"))
      {
        this.field_cre_name = paramContentValues.getAsString("cre_name");
        if (paramBoolean) {
          this.lkr = true;
        }
      }
      if (paramContentValues.containsKey("lqt_state"))
      {
        this.field_lqt_state = paramContentValues.getAsInteger("lqt_state").intValue();
        if (paramBoolean) {
          this.lks = true;
        }
      }
      if (paramContentValues.containsKey("paymenu_use_new"))
      {
        this.field_paymenu_use_new = paramContentValues.getAsInteger("paymenu_use_new").intValue();
        if (paramBoolean) {
          this.lkt = true;
        }
      }
      if (paramContentValues.containsKey("is_show_lqb"))
      {
        this.field_is_show_lqb = paramContentValues.getAsInteger("is_show_lqb").intValue();
        if (paramBoolean) {
          this.lku = true;
        }
      }
      if (paramContentValues.containsKey("is_open_lqb"))
      {
        this.field_is_open_lqb = paramContentValues.getAsInteger("is_open_lqb").intValue();
        if (paramBoolean) {
          this.lkv = true;
        }
      }
      if (paramContentValues.containsKey("lqb_open_url"))
      {
        this.field_lqb_open_url = paramContentValues.getAsString("lqb_open_url");
        if (paramBoolean) {
          this.lkw = true;
        }
      }
      if (paramContentValues.containsKey("lqt_cell_is_show"))
      {
        this.field_lqt_cell_is_show = paramContentValues.getAsInteger("lqt_cell_is_show").intValue();
        if (paramBoolean) {
          this.lkx = true;
        }
      }
      if (paramContentValues.containsKey("lqt_cell_icon"))
      {
        this.field_lqt_cell_icon = paramContentValues.getAsString("lqt_cell_icon");
        if (paramBoolean) {
          this.lky = true;
        }
      }
      if (paramContentValues.containsKey("lqt_cell_is_open_lqt"))
      {
        this.field_lqt_cell_is_open_lqt = paramContentValues.getAsInteger("lqt_cell_is_open_lqt").intValue();
        if (paramBoolean) {
          this.lkz = true;
        }
      }
      if (paramContentValues.containsKey("lqt_cell_lqt_open_url"))
      {
        this.field_lqt_cell_lqt_open_url = paramContentValues.getAsString("lqt_cell_lqt_open_url");
        if (paramBoolean) {
          this.lkA = true;
        }
      }
      if (paramContentValues.containsKey("lqt_cell_lqt_title"))
      {
        this.field_lqt_cell_lqt_title = paramContentValues.getAsString("lqt_cell_lqt_title");
        if (paramBoolean) {
          this.lkB = true;
        }
      }
      if (paramContentValues.containsKey("lqt_cell_lqt_wording"))
      {
        this.field_lqt_cell_lqt_wording = paramContentValues.getAsString("lqt_cell_lqt_wording");
        if (paramBoolean) {
          this.lkC = true;
        }
      }
      if (paramContentValues.containsKey("forget_passwd_url"))
      {
        this.field_forget_passwd_url = paramContentValues.getAsString("forget_passwd_url");
        if (paramBoolean) {
          this.lkD = true;
        }
      }
      if (paramContentValues.containsKey("unipay_order_state"))
      {
        this.field_unipay_order_state = paramContentValues.getAsInteger("unipay_order_state").intValue();
        if (paramBoolean) {
          this.lkE = true;
        }
      }
      if (paramContentValues.containsKey("bank_priority"))
      {
        this.field_bank_priority = paramContentValues.getAsString("bank_priority");
        if (paramBoolean) {
          this.lkF = true;
        }
      }
      if (paramContentValues.containsKey("wallet_balance"))
      {
        this.field_wallet_balance = paramContentValues.getAsLong("wallet_balance").longValue();
        if (paramBoolean) {
          this.liw = true;
        }
      }
      if (paramContentValues.containsKey("wallet_entrance_balance_switch_state"))
      {
        this.field_wallet_entrance_balance_switch_state = paramContentValues.getAsInteger("wallet_entrance_balance_switch_state").intValue();
        if (paramBoolean) {
          this.lkG = true;
        }
      }
      if (paramContentValues.containsKey("soter_pay_open_type"))
      {
        this.field_soter_pay_open_type = paramContentValues.getAsInteger("soter_pay_open_type").intValue();
        if (paramBoolean) {
          this.lkH = true;
        }
      }
      if (paramContentValues.containsKey("authen_account_type"))
      {
        this.field_authen_account_type = paramContentValues.getAsInteger("authen_account_type").intValue();
        if (paramBoolean) {
          this.lkI = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
    }
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
      if (lkJ != k) {
        break label65;
      }
      this.field_uin = paramCursor.getString(i);
      this.lkd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (lkK == k)
      {
        this.field_is_reg = paramCursor.getInt(i);
      }
      else if (lkL == k)
      {
        this.field_true_name = paramCursor.getString(i);
      }
      else if (lkM == k)
      {
        this.field_card_num = paramCursor.getInt(i);
      }
      else
      {
        if (lkN == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isDomesticUser = bool;
            break;
          }
        }
        if (lkO == k) {
          this.field_cre_type = paramCursor.getInt(i);
        } else if (lkP == k) {
          this.field_main_card_bind_serialno = paramCursor.getString(i);
        } else if (lkQ == k) {
          this.field_ftf_pay_url = paramCursor.getString(i);
        } else if (lkR == k) {
          this.field_switchConfig = paramCursor.getInt(i);
        } else if (lkS == k) {
          this.field_reset_passwd_flag = paramCursor.getString(i);
        } else if (lkT == k) {
          this.field_find_passwd_url = paramCursor.getString(i);
        } else if (lkU == k) {
          this.field_is_open_touch = paramCursor.getInt(i);
        } else if (lkV == k) {
          this.field_lct_wording = paramCursor.getString(i);
        } else if (lkW == k) {
          this.field_lct_url = paramCursor.getString(i);
        } else if (lkX == k) {
          this.field_cre_name = paramCursor.getString(i);
        } else if (lkY == k) {
          this.field_lqt_state = paramCursor.getInt(i);
        } else if (lkZ == k) {
          this.field_paymenu_use_new = paramCursor.getInt(i);
        } else if (lla == k) {
          this.field_is_show_lqb = paramCursor.getInt(i);
        } else if (llb == k) {
          this.field_is_open_lqb = paramCursor.getInt(i);
        } else if (llc == k) {
          this.field_lqb_open_url = paramCursor.getString(i);
        } else if (lld == k) {
          this.field_lqt_cell_is_show = paramCursor.getInt(i);
        } else if (lle == k) {
          this.field_lqt_cell_icon = paramCursor.getString(i);
        } else if (llf == k) {
          this.field_lqt_cell_is_open_lqt = paramCursor.getInt(i);
        } else if (llg == k) {
          this.field_lqt_cell_lqt_open_url = paramCursor.getString(i);
        } else if (llh == k) {
          this.field_lqt_cell_lqt_title = paramCursor.getString(i);
        } else if (lli == k) {
          this.field_lqt_cell_lqt_wording = paramCursor.getString(i);
        } else if (llj == k) {
          this.field_forget_passwd_url = paramCursor.getString(i);
        } else if (llk == k) {
          this.field_unipay_order_state = paramCursor.getInt(i);
        } else if (lll == k) {
          this.field_bank_priority = paramCursor.getString(i);
        } else if (liC == k) {
          this.field_wallet_balance = paramCursor.getLong(i);
        } else if (llm == k) {
          this.field_wallet_entrance_balance_switch_state = paramCursor.getInt(i);
        } else if (lln == k) {
          this.field_soter_pay_open_type = paramCursor.getInt(i);
        } else if (llo == k) {
          this.field_authen_account_type = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.lkd) {
      localContentValues.put("uin", this.field_uin);
    }
    if (this.lke) {
      localContentValues.put("is_reg", Integer.valueOf(this.field_is_reg));
    }
    if (this.lkf) {
      localContentValues.put("true_name", this.field_true_name);
    }
    if (this.lkg) {
      localContentValues.put("card_num", Integer.valueOf(this.field_card_num));
    }
    if (this.lkh) {
      localContentValues.put("isDomesticUser", Boolean.valueOf(this.field_isDomesticUser));
    }
    if (this.lki) {
      localContentValues.put("cre_type", Integer.valueOf(this.field_cre_type));
    }
    if (this.lkj) {
      localContentValues.put("main_card_bind_serialno", this.field_main_card_bind_serialno);
    }
    if (this.lkk) {
      localContentValues.put("ftf_pay_url", this.field_ftf_pay_url);
    }
    if (this.lkl) {
      localContentValues.put("switchConfig", Integer.valueOf(this.field_switchConfig));
    }
    if (this.lkm) {
      localContentValues.put("reset_passwd_flag", this.field_reset_passwd_flag);
    }
    if (this.lkn) {
      localContentValues.put("find_passwd_url", this.field_find_passwd_url);
    }
    if (this.lko) {
      localContentValues.put("is_open_touch", Integer.valueOf(this.field_is_open_touch));
    }
    if (this.lkp) {
      localContentValues.put("lct_wording", this.field_lct_wording);
    }
    if (this.lkq) {
      localContentValues.put("lct_url", this.field_lct_url);
    }
    if (this.lkr) {
      localContentValues.put("cre_name", this.field_cre_name);
    }
    if (this.lks) {
      localContentValues.put("lqt_state", Integer.valueOf(this.field_lqt_state));
    }
    if (this.lkt) {
      localContentValues.put("paymenu_use_new", Integer.valueOf(this.field_paymenu_use_new));
    }
    if (this.lku) {
      localContentValues.put("is_show_lqb", Integer.valueOf(this.field_is_show_lqb));
    }
    if (this.lkv) {
      localContentValues.put("is_open_lqb", Integer.valueOf(this.field_is_open_lqb));
    }
    if (this.lkw) {
      localContentValues.put("lqb_open_url", this.field_lqb_open_url);
    }
    if (this.lkx) {
      localContentValues.put("lqt_cell_is_show", Integer.valueOf(this.field_lqt_cell_is_show));
    }
    if (this.lky) {
      localContentValues.put("lqt_cell_icon", this.field_lqt_cell_icon);
    }
    if (this.lkz) {
      localContentValues.put("lqt_cell_is_open_lqt", Integer.valueOf(this.field_lqt_cell_is_open_lqt));
    }
    if (this.lkA) {
      localContentValues.put("lqt_cell_lqt_open_url", this.field_lqt_cell_lqt_open_url);
    }
    if (this.lkB) {
      localContentValues.put("lqt_cell_lqt_title", this.field_lqt_cell_lqt_title);
    }
    if (this.lkC) {
      localContentValues.put("lqt_cell_lqt_wording", this.field_lqt_cell_lqt_wording);
    }
    if (this.lkD) {
      localContentValues.put("forget_passwd_url", this.field_forget_passwd_url);
    }
    if (this.lkE) {
      localContentValues.put("unipay_order_state", Integer.valueOf(this.field_unipay_order_state));
    }
    if (this.lkF) {
      localContentValues.put("bank_priority", this.field_bank_priority);
    }
    if (this.liw) {
      localContentValues.put("wallet_balance", Long.valueOf(this.field_wallet_balance));
    }
    if (this.lkG) {
      localContentValues.put("wallet_entrance_balance_switch_state", Integer.valueOf(this.field_wallet_entrance_balance_switch_state));
    }
    if (this.lkH) {
      localContentValues.put("soter_pay_open_type", Integer.valueOf(this.field_soter_pay_open_type));
    }
    if (this.lkI) {
      localContentValues.put("authen_account_type", Integer.valueOf(this.field_authen_account_type));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends io> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_uin;
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.io
 * JD-Core Version:    0.7.0.1
 */