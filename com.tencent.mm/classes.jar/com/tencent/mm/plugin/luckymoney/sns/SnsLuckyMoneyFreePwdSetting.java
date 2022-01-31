package com.tencent.mm.plugin.luckymoney.sns;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.ql;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

public class SnsLuckyMoneyFreePwdSetting
  extends WalletPreferenceUI
{
  protected f hcp;
  protected CheckBoxPreference lTv;
  
  private void bfU()
  {
    boolean bool = true;
    if (com.tencent.mm.plugin.luckymoney.sns.b.a.bfW() == 1)
    {
      this.lTv.rHo = bool;
      this.dnD.edit().putBoolean("open_sns_pay_pref", bool).commit();
      if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.bfX())) {
        break label139;
      }
      y.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle:" + com.tencent.mm.plugin.luckymoney.sns.b.a.bfX());
      this.lTv.setTitle(com.tencent.mm.plugin.luckymoney.sns.b.a.bfX());
      label82:
      if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.bfY())) {
        break label159;
      }
      y.i("MicroMsg.mmui.MMPreference", "SetSnsPayWording:" + com.tencent.mm.plugin.luckymoney.sns.b.a.bfY());
      this.lTv.setSummary(com.tencent.mm.plugin.luckymoney.sns.b.a.bfY());
    }
    for (;;)
    {
      this.hcp.notifyDataSetChanged();
      return;
      bool = false;
      break;
      label139:
      y.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle is empty");
      this.lTv.setTitle(a.i.lucky_money_free_pwd_key_title);
      break label82;
      label159:
      y.i("MicroMsg.mmui.MMPreference", "getSetSnsPayWording is empty");
      this.lTv.setSummary(a.i.lucky_money_free_pwd_key_decs);
    }
  }
  
  private void hn(boolean paramBoolean)
  {
    this.dnD.edit().putBoolean("open_sns_pay_pref", paramBoolean).commit();
    this.lTv.rHo = paramBoolean;
    this.hcp.notifyDataSetChanged();
  }
  
  private static void to(int paramInt)
  {
    ql localql = new ql();
    localql.bZN.key = paramInt;
    localql.bZN.value = 1;
    localql.bZN.bZO = true;
    com.tencent.mm.sdk.b.a.udP.m(localql);
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    if ("open_sns_pay_pref".equals(paramPreference.mKey))
    {
      if ((!this.lTv.isChecked()) && (com.tencent.mm.plugin.luckymoney.sns.b.a.bfW() == 1))
      {
        cNr().a(new com.tencent.mm.plugin.luckymoney.sns.a.a(0, "", ""), true, 1);
        to(117);
      }
    }
    else {
      return false;
    }
    to(120);
    com.tencent.mm.wallet_core.a.a(this, a.class, null, null);
    return false;
  }
  
  public final boolean g(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.luckymoney.sns.a.a))
    {
      y.i("MicroMsg.mmui.MMPreference", "free pwd setting onWalletSceneEnd, errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label105;
      }
      if (((com.tencent.mm.plugin.luckymoney.sns.a.a)paramm).lTN == 1)
      {
        y.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 1");
        to(119);
        hn(true);
      }
    }
    else
    {
      return false;
    }
    hn(false);
    to(118);
    y.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 0");
    return false;
    label105:
    to(119);
    y.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is failed, do nothing");
    bfU();
    return false;
  }
  
  protected final void initView()
  {
    this.hcp = this.vdd;
    setBackBtn(new SnsLuckyMoneyFreePwdSetting.1(this));
    setMMTitle(a.i.lucky_money_free_pwd_setting_title);
    this.lTv = ((CheckBoxPreference)this.hcp.add("open_sns_pay_pref"));
    bfU();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    to(116);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
  }
  
  protected void onResume()
  {
    bfU();
    super.onResume();
  }
  
  public final int xj()
  {
    return a.l.sns_lucky_money_free_pwd_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyFreePwdSetting
 * JD-Core Version:    0.7.0.1
 */