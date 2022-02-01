package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.ContextWrapper;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.ui.x;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends ContextWrapper
  implements g
{
  private String mToken;
  private int oqF;
  private final IListener<com.tencent.mm.plugin.appbrand.service.d> pZK;
  private d pZL;
  
  public e(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    super(paramAppBrandLaunchProxyUI);
    AppMethodBeat.i(47454);
    this.pZK = new e.1(this);
    this.oqF = 0;
    AppMethodBeat.o(47454);
  }
  
  private void akg(String paramString)
  {
    AppMethodBeat.i(47458);
    if ((this.pZL == null) || (this.pZL.pZs))
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
  
  public final void I(Intent paramIntent)
  {
    AppMethodBeat.i(47456);
    x.e(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow());
    x.d(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow(), true);
    paramIntent = paramIntent.getStringExtra("extra_entry_token");
    d locald = d.akf(paramIntent);
    if (locald == null)
    {
      finish();
      AppMethodBeat.o(47456);
      return;
    }
    ((AppBrandLaunchProxyUI)super.getBaseContext()).overridePendingTransition(0, 0);
    locald.setBaseContext((AppBrandLaunchProxyUI)super.getBaseContext());
    this.mToken = paramIntent;
    this.pZL = locald;
    this.pZK.alive();
    AppMethodBeat.o(47456);
  }
  
  public final boolean caC()
  {
    return true;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(47459);
    this.pZK.dead();
    if (this.pZL != null) {
      this.pZL.caw();
    }
    AppMethodBeat.o(47459);
  }
  
  public final void onPause() {}
  
  public final void onResume()
  {
    AppMethodBeat.i(47457);
    this.oqF += 1;
    Log.i("MicroMsg.FromMMProxyUI", "onResume, resume count:%d", new Object[] { Integer.valueOf(this.oqF) });
    if (this.oqF > 1) {
      akg("NotFirstResume");
    }
    AppMethodBeat.o(47457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.e
 * JD-Core Version:    0.7.0.1
 */