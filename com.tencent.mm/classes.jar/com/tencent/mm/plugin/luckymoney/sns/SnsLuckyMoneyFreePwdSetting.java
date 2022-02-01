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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.vt;
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
  protected f nRm;
  protected CheckBoxPreference yYG;
  
  private static void PN(int paramInt)
  {
    AppMethodBeat.i(65353);
    vt localvt = new vt();
    localvt.ebU.key = paramInt;
    localvt.ebU.value = 1;
    localvt.ebU.ebV = true;
    EventCenter.instance.publish(localvt);
    AppMethodBeat.o(65353);
  }
  
  private void efA()
  {
    boolean bool = true;
    AppMethodBeat.i(65357);
    if (com.tencent.mm.plugin.luckymoney.sns.b.a.efC() == 1)
    {
      this.yYG.setChecked(bool);
      getDefaultSharedPreferences().edit().putBoolean("open_sns_pay_pref", bool).commit();
      if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.efD())) {
        break label149;
      }
      Log.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle:" + com.tencent.mm.plugin.luckymoney.sns.b.a.efD());
      this.yYG.setTitle(com.tencent.mm.plugin.luckymoney.sns.b.a.efD());
      label87:
      if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.efE())) {
        break label168;
      }
      Log.i("MicroMsg.mmui.MMPreference", "SetSnsPayWording:" + com.tencent.mm.plugin.luckymoney.sns.b.a.efE());
      this.yYG.setSummary(com.tencent.mm.plugin.luckymoney.sns.b.a.efE());
    }
    for (;;)
    {
      this.nRm.notifyDataSetChanged();
      AppMethodBeat.o(65357);
      return;
      bool = false;
      break;
      label149:
      Log.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle is empty");
      this.yYG.setTitle(2131762643);
      break label87;
      label168:
      Log.i("MicroMsg.mmui.MMPreference", "getSetSnsPayWording is empty");
      this.yYG.setSummary(2131762642);
    }
  }
  
  private void qL(boolean paramBoolean)
  {
    AppMethodBeat.i(65358);
    getDefaultSharedPreferences().edit().putBoolean("open_sns_pay_pref", paramBoolean).commit();
    this.yYG.setChecked(paramBoolean);
    this.nRm.notifyDataSetChanged();
    AppMethodBeat.o(65358);
  }
  
  public final boolean e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(65360);
    if ((paramq instanceof com.tencent.mm.plugin.luckymoney.sns.a.a))
    {
      Log.i("MicroMsg.mmui.MMPreference", "free pwd setting onWalletSceneEnd, errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label116;
      }
      if (((com.tencent.mm.plugin.luckymoney.sns.a.a)paramq).yYV != 1) {
        break label96;
      }
      Log.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 1");
      PN(119);
      qL(true);
    }
    for (;;)
    {
      AppMethodBeat.o(65360);
      return false;
      label96:
      qL(false);
      PN(118);
      Log.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 0");
      continue;
      label116:
      PN(119);
      Log.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is failed, do nothing");
      efA();
    }
  }
  
  public int getResourceId()
  {
    return 2132017288;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65355);
    this.nRm = getPreferenceScreen();
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
    setMMTitle(2131762646);
    this.yYG = ((CheckBoxPreference)this.nRm.bmg("open_sns_pay_pref"));
    efA();
    AppMethodBeat.o(65355);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65354);
    super.onCreate(paramBundle);
    initView();
    PN(116);
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
      if ((this.yYG.isChecked()) || (com.tencent.mm.plugin.luckymoney.sns.b.a.efC() != 1)) {
        break label67;
      }
      hhW().a(new com.tencent.mm.plugin.luckymoney.sns.a.a(0, "", ""), true, 1);
      PN(117);
    }
    for (;;)
    {
      AppMethodBeat.o(65361);
      return false;
      label67:
      PN(120);
      com.tencent.mm.wallet_core.a.a(this, a.class, null, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65356);
    efA();
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