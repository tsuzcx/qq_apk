package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.wy;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

public class SnsLuckyMoneyFreePwdSetting
  extends WalletPreferenceUI
{
  protected CheckBoxPreference ECO;
  protected f mrf;
  
  private static void VZ(int paramInt)
  {
    AppMethodBeat.i(65353);
    wy localwy = new wy();
    localwy.fVW.key = paramInt;
    localwy.fVW.value = 1;
    localwy.fVW.fVX = true;
    EventCenter.instance.publish(localwy);
    AppMethodBeat.o(65353);
  }
  
  private void eOY()
  {
    boolean bool = true;
    AppMethodBeat.i(65357);
    if (com.tencent.mm.plugin.luckymoney.sns.b.a.ePa() == 1)
    {
      this.ECO.setChecked(bool);
      getDefaultSharedPreferences().edit().putBoolean("open_sns_pay_pref", bool).commit();
      if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.ePb())) {
        break label149;
      }
      Log.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle:" + com.tencent.mm.plugin.luckymoney.sns.b.a.ePb());
      this.ECO.setTitle(com.tencent.mm.plugin.luckymoney.sns.b.a.ePb());
      label87:
      if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.ePc())) {
        break label169;
      }
      Log.i("MicroMsg.mmui.MMPreference", "SetSnsPayWording:" + com.tencent.mm.plugin.luckymoney.sns.b.a.ePc());
      this.ECO.aF(com.tencent.mm.plugin.luckymoney.sns.b.a.ePc());
    }
    for (;;)
    {
      this.mrf.notifyDataSetChanged();
      AppMethodBeat.o(65357);
      return;
      bool = false;
      break;
      label149:
      Log.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle is empty");
      this.ECO.setTitle(a.i.lucky_money_free_pwd_key_title);
      break label87;
      label169:
      Log.i("MicroMsg.mmui.MMPreference", "getSetSnsPayWording is empty");
      this.ECO.auI(a.i.lucky_money_free_pwd_key_decs);
    }
  }
  
  private void tN(boolean paramBoolean)
  {
    AppMethodBeat.i(65358);
    getDefaultSharedPreferences().edit().putBoolean("open_sns_pay_pref", paramBoolean).commit();
    this.ECO.setChecked(paramBoolean);
    this.mrf.notifyDataSetChanged();
    AppMethodBeat.o(65358);
  }
  
  public final boolean f(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(65360);
    if ((paramq instanceof com.tencent.mm.plugin.luckymoney.sns.a.a))
    {
      Log.i("MicroMsg.mmui.MMPreference", "free pwd setting onWalletSceneEnd, errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label116;
      }
      if (((com.tencent.mm.plugin.luckymoney.sns.a.a)paramq).EDd != 1) {
        break label96;
      }
      Log.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 1");
      VZ(119);
      tN(true);
    }
    for (;;)
    {
      AppMethodBeat.o(65360);
      return false;
      label96:
      tN(false);
      VZ(118);
      Log.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 0");
      continue;
      label116:
      VZ(119);
      Log.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is failed, do nothing");
      eOY();
    }
  }
  
  public int getResourceId()
  {
    return a.m.sns_lucky_money_free_pwd_pref;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65355);
    this.mrf = getPreferenceScreen();
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
    this.ECO = ((CheckBoxPreference)this.mrf.byG("open_sns_pay_pref"));
    eOY();
    AppMethodBeat.o(65355);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65354);
    super.onCreate(paramBundle);
    initView();
    VZ(116);
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
      if ((this.ECO.isChecked()) || (com.tencent.mm.plugin.luckymoney.sns.b.a.ePa() != 1)) {
        break label69;
      }
      ijz().a(new com.tencent.mm.plugin.luckymoney.sns.a.a(0, "", ""), true, 1);
      VZ(117);
    }
    for (;;)
    {
      AppMethodBeat.o(65361);
      return false;
      label69:
      VZ(120);
      com.tencent.mm.wallet_core.a.a(this, a.class, null, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65356);
    eOY();
    super.onResume();
    AppMethodBeat.o(65356);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyFreePwdSetting
 * JD-Core Version:    0.7.0.1
 */