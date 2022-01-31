package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragmentActivity.a;

public final class AppBrandEmbedUI
  extends AppBrandUI
{
  public final long iLR;
  
  public AppBrandEmbedUI()
  {
    AppMethodBeat.i(132928);
    this.iLR = SystemClock.elapsedRealtimeNanos();
    AppMethodBeat.o(132928);
  }
  
  static boolean I(Intent paramIntent)
  {
    AppMethodBeat.i(132927);
    if (paramIntent != null) {}
    try
    {
      if ((paramIntent.getComponent() != null) && (paramIntent.getComponent().getClassName().equals(AppBrandEmbedUI.class.getName())))
      {
        AppMethodBeat.o(132927);
        return true;
      }
      AppMethodBeat.o(132927);
      return false;
    }
    catch (Exception paramIntent)
    {
      ab.e("MicroMsg.AppBrandEmbedUI", "isIntentForEmbedUI e=%s", new Object[] { paramIntent });
      AppMethodBeat.o(132927);
    }
    return false;
  }
  
  private boolean aMb()
  {
    AppMethodBeat.i(132932);
    if ((this.iOW != null) && (p.n(this.iOW.atG())))
    {
      AppMethodBeat.o(132932);
      return true;
    }
    AppMethodBeat.o(132932);
    return false;
  }
  
  protected final void e(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(132930);
    if (aMb())
    {
      super.overridePendingTransition(MMFragmentActivity.a.zbX, MMFragmentActivity.a.zbY);
      AppMethodBeat.o(132930);
      return;
    }
    super.overridePendingTransition(2131034144, 2131034130);
    AppMethodBeat.o(132930);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(132929);
    if (isFinishing())
    {
      AppMethodBeat.o(132929);
      return;
    }
    aMr();
    AppMethodBeat.o(132929);
  }
  
  public final void initActivityCloseAnimation()
  {
    AppMethodBeat.i(132931);
    if (aMb())
    {
      super.overridePendingTransition(MMFragmentActivity.a.zbZ, MMFragmentActivity.a.zca);
      AppMethodBeat.o(132931);
      return;
    }
    overridePendingTransition(2131034130, 2131034142);
    AppMethodBeat.o(132931);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI
 * JD-Core Version:    0.7.0.1
 */