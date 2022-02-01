package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.ContextWrapper;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends ContextWrapper
  implements g
{
  private int jun;
  private final c<com.tencent.mm.plugin.appbrand.service.d> kOF;
  private d kOG;
  private String mToken;
  
  public e(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    super(paramAppBrandLaunchProxyUI);
    AppMethodBeat.i(47454);
    this.kOF = new c() {};
    this.jun = 0;
    AppMethodBeat.o(47454);
  }
  
  private void Kt(String paramString)
  {
    AppMethodBeat.i(47458);
    if ((this.kOG == null) || (this.kOG.kOo))
    {
      ad.i("MicroMsg.FromMMProxyUI", "reason[%s] process[%s] isFinished, just finish activity", new Object[] { paramString, this.mToken });
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
  
  public final void G(Intent paramIntent)
  {
    AppMethodBeat.i(47456);
    r.b(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow());
    r.c(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow(), true);
    paramIntent = paramIntent.getStringExtra("extra_entry_token");
    d locald = d.Ks(paramIntent);
    if (locald == null)
    {
      finish();
      AppMethodBeat.o(47456);
      return;
    }
    locald.setBaseContext((AppBrandLaunchProxyUI)super.getBaseContext());
    this.mToken = paramIntent;
    this.kOG = locald;
    this.kOF.alive();
    AppMethodBeat.o(47456);
  }
  
  public final boolean bhn()
  {
    return true;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(47459);
    this.kOF.dead();
    if (this.kOG != null) {
      this.kOG.bhi();
    }
    AppMethodBeat.o(47459);
  }
  
  public final void onPause() {}
  
  public final void onResume()
  {
    AppMethodBeat.i(47457);
    this.jun += 1;
    ad.i("MicroMsg.FromMMProxyUI", "onResume, resume count:%d", new Object[] { Integer.valueOf(this.jun) });
    if (this.jun > 1) {
      Kt("NotFirstResume");
    }
    AppMethodBeat.o(47457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.e
 * JD-Core Version:    0.7.0.1
 */