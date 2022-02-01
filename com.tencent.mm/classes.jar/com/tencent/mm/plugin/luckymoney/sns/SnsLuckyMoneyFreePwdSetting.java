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
import com.tencent.mm.g.a.uv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

public class SnsLuckyMoneyFreePwdSetting
  extends WalletPreferenceUI
{
  protected f mEx;
  protected CheckBoxPreference vDE;
  
  private static void JL(int paramInt)
  {
    AppMethodBeat.i(65353);
    uv localuv = new uv();
    localuv.dKh.key = paramInt;
    localuv.dKh.value = 1;
    localuv.dKh.dKi = true;
    com.tencent.mm.sdk.b.a.IvT.l(localuv);
    AppMethodBeat.o(65353);
  }
  
  private void dlF()
  {
    boolean bool = true;
    AppMethodBeat.i(65357);
    if (com.tencent.mm.plugin.luckymoney.sns.b.a.dlH() == 1)
    {
      this.vDE.setChecked(bool);
      getDefaultSharedPreferences().edit().putBoolean("open_sns_pay_pref", bool).commit();
      if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.dlI())) {
        break label149;
      }
      ae.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle:" + com.tencent.mm.plugin.luckymoney.sns.b.a.dlI());
      this.vDE.setTitle(com.tencent.mm.plugin.luckymoney.sns.b.a.dlI());
      label87:
      if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.dlJ())) {
        break label168;
      }
      ae.i("MicroMsg.mmui.MMPreference", "SetSnsPayWording:" + com.tencent.mm.plugin.luckymoney.sns.b.a.dlJ());
      this.vDE.setSummary(com.tencent.mm.plugin.luckymoney.sns.b.a.dlJ());
    }
    for (;;)
    {
      this.mEx.notifyDataSetChanged();
      AppMethodBeat.o(65357);
      return;
      bool = false;
      break;
      label149:
      ae.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle is empty");
      this.vDE.setTitle(2131760874);
      break label87;
      label168:
      ae.i("MicroMsg.mmui.MMPreference", "getSetSnsPayWording is empty");
      this.vDE.setSummary(2131760873);
    }
  }
  
  private void od(boolean paramBoolean)
  {
    AppMethodBeat.i(65358);
    getDefaultSharedPreferences().edit().putBoolean("open_sns_pay_pref", paramBoolean).commit();
    this.vDE.setChecked(paramBoolean);
    this.mEx.notifyDataSetChanged();
    AppMethodBeat.o(65358);
  }
  
  public final boolean e(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65360);
    if ((paramn instanceof com.tencent.mm.plugin.luckymoney.sns.a.a))
    {
      ae.i("MicroMsg.mmui.MMPreference", "free pwd setting onWalletSceneEnd, errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label116;
      }
      if (((com.tencent.mm.plugin.luckymoney.sns.a.a)paramn).vDU != 1) {
        break label96;
      }
      ae.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 1");
      JL(119);
      od(true);
    }
    for (;;)
    {
      AppMethodBeat.o(65360);
      return false;
      label96:
      od(false);
      JL(118);
      ae.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 0");
      continue;
      label116:
      JL(119);
      ae.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is failed, do nothing");
      dlF();
    }
  }
  
  public int getResourceId()
  {
    return 2131951743;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65355);
    this.mEx = getPreferenceScreen();
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
    this.vDE = ((CheckBoxPreference)this.mEx.aXe("open_sns_pay_pref"));
    dlF();
    AppMethodBeat.o(65355);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65354);
    super.onCreate(paramBundle);
    initView();
    JL(116);
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
      if ((this.vDE.isChecked()) || (com.tencent.mm.plugin.luckymoney.sns.b.a.dlH() != 1)) {
        break label67;
      }
      fWy().a(new com.tencent.mm.plugin.luckymoney.sns.a.a(0, "", ""), true, 1);
      JL(117);
    }
    for (;;)
    {
      AppMethodBeat.o(65361);
      return false;
      label67:
      JL(120);
      com.tencent.mm.wallet_core.a.a(this, a.class, null, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65356);
    dlF();
    super.onResume();
    AppMethodBeat.o(65356);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyFreePwdSetting
 * JD-Core Version:    0.7.0.1
 */