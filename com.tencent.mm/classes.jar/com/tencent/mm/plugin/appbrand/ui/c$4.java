package com.tencent.mm.plugin.appbrand.ui;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class c$4
  implements Runnable
{
  c$4(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(188796);
    if ((this.mzv.getParent() instanceof ViewGroup))
    {
      ad.i("MicroMsg.AppBrandAdLoadingSplash", "remove AdLoadingSplash");
      this.mzv.setVisibility(8);
      ((ViewGroup)this.mzv.getParent()).removeView(this.mzv);
      c.b(this.mzv).jwK = null;
    }
    AppMethodBeat.o(188796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c.4
 * JD-Core Version:    0.7.0.1
 */