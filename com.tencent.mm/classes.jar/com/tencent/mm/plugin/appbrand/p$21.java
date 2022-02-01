package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.networking.g;
import com.tencent.mm.sdk.platformtools.ae;

final class p$21
  implements com.tencent.mm.plugin.appbrand.task.d
{
  p$21(p paramp) {}
  
  private boolean aG(String paramString, int paramInt)
  {
    AppMethodBeat.i(224353);
    if (this.jCE.jCl == null)
    {
      ae.e("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeController checkTokenOk with reason[%s], get NULL mRemoteController from runtime", new Object[] { paramString });
      AppMethodBeat.o(224353);
      return true;
    }
    if (paramInt == this.jCE.jCl.hashCode())
    {
      AppMethodBeat.o(224353);
      return true;
    }
    AppMethodBeat.o(224353);
    return false;
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(224355);
    if (aG("onNetworkChange", paramInt))
    {
      com.tencent.mm.plugin.appbrand.networking.d locald = (com.tencent.mm.plugin.appbrand.networking.d)this.jCE.ab(com.tencent.mm.plugin.appbrand.networking.d.class);
      if ((locald instanceof g)) {
        ((g)locald).buh();
      }
    }
    AppMethodBeat.o(224355);
  }
  
  public final void rH(int paramInt)
  {
    AppMethodBeat.i(224354);
    if (aG("finish", paramInt)) {
      this.jCE.finish();
    }
    AppMethodBeat.o(224354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.21
 * JD-Core Version:    0.7.0.1
 */