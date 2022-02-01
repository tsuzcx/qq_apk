package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.ContextWrapper;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends ContextWrapper
  implements g
{
  private int lvW;
  private String mToken;
  private final IListener<com.tencent.mm.plugin.appbrand.service.d> mZm;
  private d mZn;
  
  public e(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    super(paramAppBrandLaunchProxyUI);
    AppMethodBeat.i(47454);
    this.mZm = new IListener() {};
    this.lvW = 0;
    AppMethodBeat.o(47454);
  }
  
  private void acm(String paramString)
  {
    AppMethodBeat.i(47458);
    if ((this.mZn == null) || (this.mZn.mYU))
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
  
  public final void H(Intent paramIntent)
  {
    AppMethodBeat.i(47456);
    y.e(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow());
    y.d(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow(), true);
    paramIntent = paramIntent.getStringExtra("extra_entry_token");
    d locald = d.acl(paramIntent);
    if (locald == null)
    {
      finish();
      AppMethodBeat.o(47456);
      return;
    }
    locald.setBaseContext((AppBrandLaunchProxyUI)super.getBaseContext());
    this.mToken = paramIntent;
    this.mZn = locald;
    this.mZm.alive();
    AppMethodBeat.o(47456);
  }
  
  public final boolean bOi()
  {
    return true;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(47459);
    this.mZm.dead();
    if (this.mZn != null) {
      this.mZn.bOc();
    }
    AppMethodBeat.o(47459);
  }
  
  public final void onPause() {}
  
  public final void onResume()
  {
    AppMethodBeat.i(47457);
    this.lvW += 1;
    Log.i("MicroMsg.FromMMProxyUI", "onResume, resume count:%d", new Object[] { Integer.valueOf(this.lvW) });
    if (this.lvW > 1) {
      acm("NotFirstResume");
    }
    AppMethodBeat.o(47457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.e
 * JD-Core Version:    0.7.0.1
 */