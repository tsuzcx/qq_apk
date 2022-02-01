package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.ContextWrapper;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.ui.s;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends ContextWrapper
  implements g
{
  private int koW;
  private d lNA;
  private final c<com.tencent.mm.plugin.appbrand.service.d> lNz;
  private String mToken;
  
  public e(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    super(paramAppBrandLaunchProxyUI);
    AppMethodBeat.i(47454);
    this.lNz = new c() {};
    this.koW = 0;
    AppMethodBeat.o(47454);
  }
  
  private void RZ(String paramString)
  {
    AppMethodBeat.i(47458);
    if ((this.lNA == null) || (this.lNA.lNi))
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
  
  public final void H(Intent paramIntent)
  {
    AppMethodBeat.i(47456);
    s.b(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow());
    s.c(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow(), true);
    paramIntent = paramIntent.getStringExtra("extra_entry_token");
    d locald = d.RY(paramIntent);
    if (locald == null)
    {
      finish();
      AppMethodBeat.o(47456);
      return;
    }
    locald.setBaseContext((AppBrandLaunchProxyUI)super.getBaseContext());
    this.mToken = paramIntent;
    this.lNA = locald;
    this.lNz.alive();
    AppMethodBeat.o(47456);
  }
  
  public final boolean bsa()
  {
    return true;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(47459);
    this.lNz.dead();
    if (this.lNA != null) {
      this.lNA.brV();
    }
    AppMethodBeat.o(47459);
  }
  
  public final void onPause() {}
  
  public final void onResume()
  {
    AppMethodBeat.i(47457);
    this.koW += 1;
    ad.i("MicroMsg.FromMMProxyUI", "onResume, resume count:%d", new Object[] { Integer.valueOf(this.koW) });
    if (this.koW > 1) {
      RZ("NotFirstResume");
    }
    AppMethodBeat.o(47457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.e
 * JD-Core Version:    0.7.0.1
 */