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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.ur;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

public class SnsLuckyMoneyFreePwdSetting
  extends WalletPreferenceUI
{
  protected f mzx;
  protected CheckBoxPreference vrz;
  
  private static void Jm(int paramInt)
  {
    AppMethodBeat.i(65353);
    ur localur = new ur();
    localur.dIT.key = paramInt;
    localur.dIT.value = 1;
    localur.dIT.dIU = true;
    com.tencent.mm.sdk.b.a.IbL.l(localur);
    AppMethodBeat.o(65353);
  }
  
  private void diG()
  {
    boolean bool = true;
    AppMethodBeat.i(65357);
    if (com.tencent.mm.plugin.luckymoney.sns.b.a.diI() == 1)
    {
      this.vrz.oB = bool;
      getDefaultSharedPreferences().edit().putBoolean("open_sns_pay_pref", bool).commit();
      if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.diJ())) {
        break label149;
      }
      ad.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle:" + com.tencent.mm.plugin.luckymoney.sns.b.a.diJ());
      this.vrz.setTitle(com.tencent.mm.plugin.luckymoney.sns.b.a.diJ());
      label87:
      if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.diK())) {
        break label168;
      }
      ad.i("MicroMsg.mmui.MMPreference", "SetSnsPayWording:" + com.tencent.mm.plugin.luckymoney.sns.b.a.diK());
      this.vrz.setSummary(com.tencent.mm.plugin.luckymoney.sns.b.a.diK());
    }
    for (;;)
    {
      this.mzx.notifyDataSetChanged();
      AppMethodBeat.o(65357);
      return;
      bool = false;
      break;
      label149:
      ad.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle is empty");
      this.vrz.setTitle(2131760874);
      break label87;
      label168:
      ad.i("MicroMsg.mmui.MMPreference", "getSetSnsPayWording is empty");
      this.vrz.setSummary(2131760873);
    }
  }
  
  private void nY(boolean paramBoolean)
  {
    AppMethodBeat.i(65358);
    getDefaultSharedPreferences().edit().putBoolean("open_sns_pay_pref", paramBoolean).commit();
    this.vrz.oB = paramBoolean;
    this.mzx.notifyDataSetChanged();
    AppMethodBeat.o(65358);
  }
  
  public final boolean e(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65360);
    if ((paramn instanceof com.tencent.mm.plugin.luckymoney.sns.a.a))
    {
      ad.i("MicroMsg.mmui.MMPreference", "free pwd setting onWalletSceneEnd, errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label116;
      }
      if (((com.tencent.mm.plugin.luckymoney.sns.a.a)paramn).vrP != 1) {
        break label96;
      }
      ad.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 1");
      Jm(119);
      nY(true);
    }
    for (;;)
    {
      AppMethodBeat.o(65360);
      return false;
      label96:
      nY(false);
      Jm(118);
      ad.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 0");
      continue;
      label116:
      Jm(119);
      ad.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is failed, do nothing");
      diG();
    }
  }
  
  public int getResourceId()
  {
    return 2131951743;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65355);
    this.mzx = getPreferenceScreen();
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
    this.vrz = ((CheckBoxPreference)this.mzx.aVD("open_sns_pay_pref"));
    diG();
    AppMethodBeat.o(65355);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65354);
    super.onCreate(paramBundle);
    initView();
    Jm(116);
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
      if ((this.vrz.isChecked()) || (com.tencent.mm.plugin.luckymoney.sns.b.a.diI() != 1)) {
        break label67;
      }
      fSc().a(new com.tencent.mm.plugin.luckymoney.sns.a.a(0, "", ""), true, 1);
      Jm(117);
    }
    for (;;)
    {
      AppMethodBeat.o(65361);
      return false;
      label67:
      Jm(120);
      com.tencent.mm.wallet_core.a.a(this, a.class, null, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65356);
    diG();
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