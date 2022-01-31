package com.tencent.mm.plugin.appbrand.jsapi.v.b.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.d;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements Runnable
{
  a$1(a parama, v paramv, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(140037);
    d locald = this.iiz.iuy.getFullscreenImpl();
    View localView = this.iiz.iuy.getWrapperView();
    if ((locald != null) && (localView != null))
    {
      locald.J(localView, this.iiA);
      ab.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, target orientation:%s", new Object[] { Integer.valueOf(this.iiA) });
      AppMethodBeat.o(140037);
      return;
    }
    ab.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, state error, FullscreenImp[%s], fullscreenWebView[%s]", new Object[] { locald, localView });
    AppMethodBeat.o(140037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.b.a.a.1
 * JD-Core Version:    0.7.0.1
 */