package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

public class SnsLuckyMoneyFreePwdSetting
  extends WalletPreferenceUI
{
  protected f iLA;
  protected CheckBoxPreference oqC;
  
  private void bNG()
  {
    boolean bool = true;
    AppMethodBeat.i(42502);
    if (com.tencent.mm.plugin.luckymoney.sns.b.a.bNI() == 1)
    {
      this.oqC.vxW = bool;
      getDefaultSharedPreferences().edit().putBoolean("open_sns_pay_pref", bool).commit();
      if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.bNJ())) {
        break label149;
      }
      ab.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle:" + com.tencent.mm.plugin.luckymoney.sns.b.a.bNJ());
      this.oqC.setTitle(com.tencent.mm.plugin.luckymoney.sns.b.a.bNJ());
      label87:
      if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.bNK())) {
        break label168;
      }
      ab.i("MicroMsg.mmui.MMPreference", "SetSnsPayWording:" + com.tencent.mm.plugin.luckymoney.sns.b.a.bNK());
      this.oqC.setSummary(com.tencent.mm.plugin.luckymoney.sns.b.a.bNK());
    }
    for (;;)
    {
      this.iLA.notifyDataSetChanged();
      AppMethodBeat.o(42502);
      return;
      bool = false;
      break;
      label149:
      ab.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle is empty");
      this.oqC.setTitle(2131301232);
      break label87;
      label168:
      ab.i("MicroMsg.mmui.MMPreference", "getSetSnsPayWording is empty");
      this.oqC.setSummary(2131301231);
    }
  }
  
  private void iY(boolean paramBoolean)
  {
    AppMethodBeat.i(42503);
    getDefaultSharedPreferences().edit().putBoolean("open_sns_pay_pref", paramBoolean).commit();
    this.oqC.vxW = paramBoolean;
    this.iLA.notifyDataSetChanged();
    AppMethodBeat.o(42503);
  }
  
  private static void ys(int paramInt)
  {
    AppMethodBeat.i(42498);
    rv localrv = new rv();
    localrv.cIf.key = paramInt;
    localrv.cIf.value = 1;
    localrv.cIf.cIg = true;
    com.tencent.mm.sdk.b.a.ymk.l(localrv);
    AppMethodBeat.o(42498);
  }
  
  public final boolean e(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(42505);
    if ((paramm instanceof com.tencent.mm.plugin.luckymoney.sns.a.a))
    {
      ab.i("MicroMsg.mmui.MMPreference", "free pwd setting onWalletSceneEnd, errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label116;
      }
      if (((com.tencent.mm.plugin.luckymoney.sns.a.a)paramm).oqS != 1) {
        break label96;
      }
      ab.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 1");
      ys(119);
      iY(true);
    }
    for (;;)
    {
      AppMethodBeat.o(42505);
      return false;
      label96:
      iY(false);
      ys(118);
      ab.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 0");
      continue;
      label116:
      ys(119);
      ab.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is failed, do nothing");
      bNG();
    }
  }
  
  public int getResourceId()
  {
    return 2131165299;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42500);
    this.iLA = getPreferenceScreen();
    setBackBtn(new SnsLuckyMoneyFreePwdSetting.1(this));
    setMMTitle(2131301235);
    this.oqC = ((CheckBoxPreference)this.iLA.atx("open_sns_pay_pref"));
    bNG();
    AppMethodBeat.o(42500);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42499);
    super.onCreate(paramBundle);
    initView();
    ys(116);
    AppMethodBeat.o(42499);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42504);
    super.onDestroy();
    AppMethodBeat.o(42504);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(42507);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(42507);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(42506);
    if ("open_sns_pay_pref".equals(paramPreference.mKey))
    {
      if ((this.oqC.isChecked()) || (com.tencent.mm.plugin.luckymoney.sns.b.a.bNI() != 1)) {
        break label67;
      }
      dSV().a(new com.tencent.mm.plugin.luckymoney.sns.a.a(0, "", ""), true, 1);
      ys(117);
    }
    for (;;)
    {
      AppMethodBeat.o(42506);
      return false;
      label67:
      ys(120);
      com.tencent.mm.wallet_core.a.a(this, a.class, null, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42501);
    bNG();
    super.onResume();
    AppMethodBeat.o(42501);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyFreePwdSetting
 * JD-Core Version:    0.7.0.1
 */