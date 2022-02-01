package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class KindaWrapProfessionActivity
  extends WalletSelectProfessionUI
{
  public static final String ACTIVITY_CLOSE_FLAG = "flag_activity_close_WalletSelectProfessionUI";
  
  public void onPause()
  {
    AppMethodBeat.i(18987);
    super.onPause();
    if (isFinishing())
    {
      pg localpg = new pg();
      localpg.dEp.dEq = "flag_activity_close_WalletSelectProfessionUI";
      a.IvT.l(localpg);
    }
    AppMethodBeat.o(18987);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(18988);
    if (paramPreference.mKey.startsWith("index_"))
    {
      paramf = paramPreference.mKey.split("_");
      if (paramf.length != 2) {
        break label125;
      }
      int i = bu.getInt(paramf[1], 0);
      paramf = this.mProfessions[i];
      paramPreference = new pg();
      paramPreference.dEp.dEq = paramf.DkE;
      paramPreference.dEp.dEr = paramf.DkF;
      a.IvT.l(paramPreference);
      ae.i("", "KindaWrapProfessionActivity.onPreferenceTreeClick，发送事件，当前线程：" + Thread.currentThread().getId());
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(18988);
      return true;
      label125:
      ae.w("", "KindaWrapProfessionActivity error key: %s, %s", new Object[] { paramPreference.mKey, paramPreference.getTitle() });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaWrapProfessionActivity
 * JD-Core Version:    0.7.0.1
 */