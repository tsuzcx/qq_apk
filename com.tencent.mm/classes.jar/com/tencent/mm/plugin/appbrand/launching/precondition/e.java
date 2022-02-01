package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.ContextWrapper;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends ContextWrapper
  implements g
{
  private String mToken;
  private int ruz;
  private final IListener<com.tencent.mm.plugin.appbrand.service.d> teE;
  private d teF;
  
  public e(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    super(paramAppBrandLaunchProxyUI);
    AppMethodBeat.i(47454);
    this.teE = new FromMMProxyUI.1(this, f.hfK);
    this.ruz = 0;
    AppMethodBeat.o(47454);
  }
  
  private void adl(String paramString)
  {
    AppMethodBeat.i(47458);
    if ((this.teF == null) || (this.teF.teg))
    {
      Log.i("MicroMsg.FromMMProxyUI", "reason[%s] process[%s] isFinished, just finish activity", new Object[] { paramString, this.mToken });
      finish();
    }
    AppMethodBeat.o(47458);
  }
  
  private void finish()
  {
    AppMethodBeat.i(47455);
    ((AppBrandLaunchProxyUI)super.getBaseContext()).finish();
    AppMethodBeat.o(47455);
  }
  
  public final void L(Intent paramIntent)
  {
    AppMethodBeat.i(47456);
    ae.g(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow());
    ae.c(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow(), true);
    paramIntent = paramIntent.getStringExtra("extra_entry_token");
    d locald = d.adk(paramIntent);
    if (locald == null)
    {
      finish();
      AppMethodBeat.o(47456);
      return;
    }
    ((AppBrandLaunchProxyUI)super.getBaseContext()).overridePendingTransition(0, 0);
    locald.setBaseContext((AppBrandLaunchProxyUI)super.getBaseContext());
    this.mToken = paramIntent;
    this.teF = locald;
    this.teE.alive();
    AppMethodBeat.o(47456);
  }
  
  public final boolean cAU()
  {
    return true;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(47459);
    this.teE.dead();
    if (this.teF != null) {
      this.teF.cAO();
    }
    AppMethodBeat.o(47459);
  }
  
  public final void onPause() {}
  
  public final void onResume()
  {
    AppMethodBeat.i(47457);
    this.ruz += 1;
    Log.i("MicroMsg.FromMMProxyUI", "onResume, resume count:%d", new Object[] { Integer.valueOf(this.ruz) });
    if (this.ruz > 1) {
      adl("NotFirstResume");
    }
    AppMethodBeat.o(47457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.e
 * JD-Core Version:    0.7.0.1
 */