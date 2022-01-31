package com.tencent.mm.plugin.appbrand.launching.precondition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.sdk.platformtools.ah;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(132046);
    ((AppBrandLaunchProxyUI)this.inO.getBaseContext()).finish();
    this.inO.setBaseContext(ah.getContext());
    AppMethodBeat.o(132046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.a.1
 * JD-Core Version:    0.7.0.1
 */