package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.na;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class KindaWrapProfessionActivity
  extends WalletSelectProfessionUI
{
  public static final String ACTIVITY_CLOSE_FLAG = "flag_activity_close_WalletSelectProfessionUI";
  
  public void onPause()
  {
    AppMethodBeat.i(144836);
    super.onPause();
    if (isFinishing())
    {
      na localna = new na();
      localna.cDg.cDh = "flag_activity_close_WalletSelectProfessionUI";
      a.ymk.l(localna);
    }
    AppMethodBeat.o(144836);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(144837);
    if (paramPreference.mKey.startsWith("index_"))
    {
      paramf = paramPreference.mKey.split("_");
      if (paramf.length != 2) {
        break label123;
      }
      int i = bo.getInt(paramf[1], 0);
      paramf = this.mProfessions[i];
      paramPreference = new na();
      paramPreference.cDg.cDh = paramf.ues;
      paramPreference.cDg.cDi = paramf.uet;
      a.ymk.l(paramPreference);
      ab.i("", "KindaWrapProfessionActivity.onPreferenceTreeClick，发送事件，当前线程：" + Thread.currentThread().getId());
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(144837);
      return true;
      label123:
      ab.w("", "KindaWrapProfessionActivity error key: %s, %s", new Object[] { paramPreference.mKey, paramPreference.getTitle() });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaWrapProfessionActivity
 * JD-Core Version:    0.7.0.1
 */