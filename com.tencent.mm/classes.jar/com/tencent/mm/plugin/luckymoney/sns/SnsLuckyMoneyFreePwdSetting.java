package com.tencent.mm.plugin.luckymoney.sns;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.yr;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

public class SnsLuckyMoneyFreePwdSetting
  extends WalletPreferenceUI
{
  protected CheckBoxPreference KvS;
  protected f pkD;
  
  private static void ZV(int paramInt)
  {
    AppMethodBeat.i(65353);
    yr localyr = new yr();
    localyr.ibW.key = paramInt;
    localyr.ibW.value = 1;
    localyr.ibW.ibX = true;
    localyr.publish();
    AppMethodBeat.o(65353);
  }
  
  private void fXC()
  {
    boolean bool = true;
    AppMethodBeat.i(65357);
    if (com.tencent.mm.plugin.luckymoney.sns.b.a.fXE() == 1)
    {
      this.KvS.setChecked(bool);
      getDefaultSharedPreferences().edit().putBoolean("open_sns_pay_pref", bool).commit();
      if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.fXF())) {
        break label149;
      }
      Log.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle:" + com.tencent.mm.plugin.luckymoney.sns.b.a.fXF());
      this.KvS.setTitle(com.tencent.mm.plugin.luckymoney.sns.b.a.fXF());
      label87:
      if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.fXG())) {
        break label169;
      }
      Log.i("MicroMsg.mmui.MMPreference", "SetSnsPayWording:" + com.tencent.mm.plugin.luckymoney.sns.b.a.fXG());
      this.KvS.aS(com.tencent.mm.plugin.luckymoney.sns.b.a.fXG());
    }
    for (;;)
    {
      this.pkD.notifyDataSetChanged();
      AppMethodBeat.o(65357);
      return;
      bool = false;
      break;
      label149:
      Log.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle is empty");
      this.KvS.setTitle(a.i.lucky_money_free_pwd_key_title);
      break label87;
      label169:
      Log.i("MicroMsg.mmui.MMPreference", "getSetSnsPayWording is empty");
      this.KvS.aBk(a.i.lucky_money_free_pwd_key_decs);
    }
  }
  
  private void xZ(boolean paramBoolean)
  {
    AppMethodBeat.i(65358);
    getDefaultSharedPreferences().edit().putBoolean("open_sns_pay_pref", paramBoolean).commit();
    this.KvS.setChecked(paramBoolean);
    this.pkD.notifyDataSetChanged();
    AppMethodBeat.o(65358);
  }
  
  public final boolean d(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(65360);
    if ((paramp instanceof com.tencent.mm.plugin.luckymoney.sns.a.a))
    {
      Log.i("MicroMsg.mmui.MMPreference", "free pwd setting onWalletSceneEnd, errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label116;
      }
      if (((com.tencent.mm.plugin.luckymoney.sns.a.a)paramp).Kwh != 1) {
        break label96;
      }
      Log.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 1");
      ZV(119);
      xZ(true);
    }
    for (;;)
    {
      AppMethodBeat.o(65360);
      return false;
      label96:
      xZ(false);
      ZV(118);
      Log.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 0");
      continue;
      label116:
      ZV(119);
      Log.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is failed, do nothing");
      fXC();
    }
  }
  
  public int getResourceId()
  {
    return a.m.sns_lucky_money_free_pwd_pref;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65355);
    this.pkD = getPreferenceScreen();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65352);
        SnsLuckyMoneyFreePwdSetting.this.finish();
        AppMethodBeat.o(65352);
        return false;
      }
    });
    setMMTitle(a.i.lucky_money_free_pwd_setting_title);
    this.KvS = ((CheckBoxPreference)this.pkD.bAi("open_sns_pay_pref"));
    fXC();
    AppMethodBeat.o(65355);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65354);
    super.onCreate(paramBundle);
    initView();
    ZV(116);
    AppMethodBeat.o(65354);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65359);
    super.onDestroy();
    AppMethodBeat.o(65359);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(65362);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(65362);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(65361);
    if ("open_sns_pay_pref".equals(paramPreference.mKey))
    {
      if ((this.KvS.isChecked()) || (com.tencent.mm.plugin.luckymoney.sns.b.a.fXE() != 1)) {
        break label67;
      }
      jPx().a(new com.tencent.mm.plugin.luckymoney.sns.a.a(0, "", ""), true, 1);
      ZV(117);
    }
    for (;;)
    {
      AppMethodBeat.o(65361);
      return false;
      label67:
      ZV(120);
      com.tencent.mm.wallet_core.a.a(this, b.class, null, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65356);
    fXC();
    super.onResume();
    AppMethodBeat.o(65356);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyFreePwdSetting
 * JD-Core Version:    0.7.0.1
 */