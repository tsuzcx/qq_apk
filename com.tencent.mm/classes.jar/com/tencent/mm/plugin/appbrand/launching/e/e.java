package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.ContextWrapper;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.ui.t;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends ContextWrapper
  implements g
{
  private int ksm;
  private final c<com.tencent.mm.plugin.appbrand.service.d> lSa;
  private d lSb;
  private String mToken;
  
  public e(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    super(paramAppBrandLaunchProxyUI);
    AppMethodBeat.i(47454);
    this.lSa = new c() {};
    this.ksm = 0;
    AppMethodBeat.o(47454);
  }
  
  private void SI(String paramString)
  {
    AppMethodBeat.i(47458);
    if ((this.lSb == null) || (this.lSb.lRJ))
    {
      ae.i("MicroMsg.FromMMProxyUI", "reason[%s] process[%s] isFinished, just finish activity", new Object[] { paramString, this.mToken });
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
    t.b(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow());
    t.c(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow(), true);
    paramIntent = paramIntent.getStringExtra("extra_entry_token");
    d locald = d.SH(paramIntent);
    if (locald == null)
    {
      finish();
      AppMethodBeat.o(47456);
      return;
    }
    locald.setBaseContext((AppBrandLaunchProxyUI)super.getBaseContext());
    this.mToken = paramIntent;
    this.lSb = locald;
    this.lSa.alive();
    AppMethodBeat.o(47456);
  }
  
  public final boolean bsL()
  {
    return true;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(47459);
    this.lSa.dead();
    if (this.lSb != null) {
      this.lSb.bsG();
    }
    AppMethodBeat.o(47459);
  }
  
  public final void onPause() {}
  
  public final void onResume()
  {
    AppMethodBeat.i(47457);
    this.ksm += 1;
    ae.i("MicroMsg.FromMMProxyUI", "onResume, resume count:%d", new Object[] { Integer.valueOf(this.ksm) });
    if (this.ksm > 1) {
      SI("NotFirstResume");
    }
    AppMethodBeat.o(47457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.e
 * JD-Core Version:    0.7.0.1
 */