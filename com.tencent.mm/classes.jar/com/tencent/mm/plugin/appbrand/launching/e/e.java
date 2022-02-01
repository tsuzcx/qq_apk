package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.ContextWrapper;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends ContextWrapper
  implements g
{
  private int jUI;
  private final c<com.tencent.mm.plugin.appbrand.service.d> lqe;
  private d lqf;
  private String mToken;
  
  public e(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    super(paramAppBrandLaunchProxyUI);
    AppMethodBeat.i(47454);
    this.lqe = new c() {};
    this.jUI = 0;
    AppMethodBeat.o(47454);
  }
  
  private void OA(String paramString)
  {
    AppMethodBeat.i(47458);
    if ((this.lqf == null) || (this.lqf.lpN))
    {
      ac.i("MicroMsg.FromMMProxyUI", "reason[%s] process[%s] isFinished, just finish activity", new Object[] { paramString, this.mToken });
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
    d locald = d.Oz(paramIntent);
    if (locald == null)
    {
      finish();
      AppMethodBeat.o(47456);
      return;
    }
    locald.setBaseContext((AppBrandLaunchProxyUI)super.getBaseContext());
    this.mToken = paramIntent;
    this.lqf = locald;
    this.lqe.alive();
    AppMethodBeat.o(47456);
  }
  
  public final boolean boh()
  {
    return true;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(47459);
    this.lqe.dead();
    if (this.lqf != null) {
      this.lqf.boc();
    }
    AppMethodBeat.o(47459);
  }
  
  public final void onPause() {}
  
  public final void onResume()
  {
    AppMethodBeat.i(47457);
    this.jUI += 1;
    ac.i("MicroMsg.FromMMProxyUI", "onResume, resume count:%d", new Object[] { Integer.valueOf(this.jUI) });
    if (this.jUI > 1) {
      OA("NotFirstResume");
    }
    AppMethodBeat.o(47457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.e
 * JD-Core Version:    0.7.0.1
 */