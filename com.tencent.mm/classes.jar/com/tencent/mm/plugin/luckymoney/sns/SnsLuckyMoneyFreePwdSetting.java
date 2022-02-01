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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.ty;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

public class SnsLuckyMoneyFreePwdSetting
  extends WalletPreferenceUI
{
  protected f lZC;
  protected CheckBoxPreference uoV;
  
  private static void HQ(int paramInt)
  {
    AppMethodBeat.i(65353);
    ty localty = new ty();
    localty.dwH.key = paramInt;
    localty.dwH.value = 1;
    localty.dwH.dwI = true;
    com.tencent.mm.sdk.b.a.GpY.l(localty);
    AppMethodBeat.o(65353);
  }
  
  private void cZu()
  {
    boolean bool = true;
    AppMethodBeat.i(65357);
    if (com.tencent.mm.plugin.luckymoney.sns.b.a.cZw() == 1)
    {
      this.uoV.mF = bool;
      getDefaultSharedPreferences().edit().putBoolean("open_sns_pay_pref", bool).commit();
      if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.cZx())) {
        break label149;
      }
      ac.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle:" + com.tencent.mm.plugin.luckymoney.sns.b.a.cZx());
      this.uoV.setTitle(com.tencent.mm.plugin.luckymoney.sns.b.a.cZx());
      label87:
      if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.cZy())) {
        break label168;
      }
      ac.i("MicroMsg.mmui.MMPreference", "SetSnsPayWording:" + com.tencent.mm.plugin.luckymoney.sns.b.a.cZy());
      this.uoV.setSummary(com.tencent.mm.plugin.luckymoney.sns.b.a.cZy());
    }
    for (;;)
    {
      this.lZC.notifyDataSetChanged();
      AppMethodBeat.o(65357);
      return;
      bool = false;
      break;
      label149:
      ac.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle is empty");
      this.uoV.setTitle(2131760874);
      break label87;
      label168:
      ac.i("MicroMsg.mmui.MMPreference", "getSetSnsPayWording is empty");
      this.uoV.setSummary(2131760873);
    }
  }
  
  private void nE(boolean paramBoolean)
  {
    AppMethodBeat.i(65358);
    getDefaultSharedPreferences().edit().putBoolean("open_sns_pay_pref", paramBoolean).commit();
    this.uoV.mF = paramBoolean;
    this.lZC.notifyDataSetChanged();
    AppMethodBeat.o(65358);
  }
  
  public final boolean e(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65360);
    if ((paramn instanceof com.tencent.mm.plugin.luckymoney.sns.a.a))
    {
      ac.i("MicroMsg.mmui.MMPreference", "free pwd setting onWalletSceneEnd, errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label116;
      }
      if (((com.tencent.mm.plugin.luckymoney.sns.a.a)paramn).upl != 1) {
        break label96;
      }
      ac.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 1");
      HQ(119);
      nE(true);
    }
    for (;;)
    {
      AppMethodBeat.o(65360);
      return false;
      label96:
      nE(false);
      HQ(118);
      ac.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 0");
      continue;
      label116:
      HQ(119);
      ac.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is failed, do nothing");
      cZu();
    }
  }
  
  public int getResourceId()
  {
    return 2131951743;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65355);
    this.lZC = getPreferenceScreen();
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
    setMMTitle(2131760877);
    this.uoV = ((CheckBoxPreference)this.lZC.aPN("open_sns_pay_pref"));
    cZu();
    AppMethodBeat.o(65355);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65354);
    super.onCreate(paramBundle);
    initView();
    HQ(116);
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
      if ((this.uoV.isChecked()) || (com.tencent.mm.plugin.luckymoney.sns.b.a.cZw() != 1)) {
        break label67;
      }
      fAS().a(new com.tencent.mm.plugin.luckymoney.sns.a.a(0, "", ""), true, 1);
      HQ(117);
    }
    for (;;)
    {
      AppMethodBeat.o(65361);
      return false;
      label67:
      HQ(120);
      com.tencent.mm.wallet_core.a.a(this, a.class, null, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65356);
    cZu();
    super.onResume();
    AppMethodBeat.o(65356);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyFreePwdSetting
 * JD-Core Version:    0.7.0.1
 */