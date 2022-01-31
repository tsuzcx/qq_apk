package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.g.d;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$3
  implements ar
{
  a$3(a parama) {}
  
  public final void a(AppBrandPageFullScreenView paramAppBrandPageFullScreenView)
  {
    AppMethodBeat.i(140859);
    if (((c)this.iuH.bDN).ixs == null)
    {
      d.e("Luggage.AbstractMPPageViewRenderer", "FullScreenViewAttach getContainerPage is null, check time sequence, err, appId[%s], url[%s]", new Object[] { this.iuH.getAppId(), this.iuH.hzM });
      AppMethodBeat.o(140859);
      return;
    }
    ((c)this.iuH.bDN).ixs.a((v)this.iuH.bDN, paramAppBrandPageFullScreenView);
    AppMethodBeat.o(140859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.3
 * JD-Core Version:    0.7.0.1
 */