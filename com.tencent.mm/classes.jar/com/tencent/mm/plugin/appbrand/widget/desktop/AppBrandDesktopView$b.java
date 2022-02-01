package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class AppBrandDesktopView$b
  implements k.a
{
  boolean lUQ;
  private WeakReference<AppBrandDesktopView> lVp;
  private int mType;
  
  public AppBrandDesktopView$b(AppBrandDesktopView paramAppBrandDesktopView, int paramInt)
  {
    AppMethodBeat.i(49583);
    this.lUQ = false;
    this.mType = paramInt;
    this.lVp = new WeakReference(paramAppBrandDesktopView);
    AppMethodBeat.o(49583);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(49584);
    ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onNotifyChange type: %d, ignore: %b, eventId: %d", new Object[] { Integer.valueOf(this.mType), Boolean.valueOf(this.lUQ), Integer.valueOf(paramm.jqR) });
    if (paramm.jqR == -1)
    {
      ad.w("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange pass eventId: %d", new Object[] { Integer.valueOf(paramm.jqR) });
      AppMethodBeat.o(49584);
      return;
    }
    if (this.lUQ)
    {
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange ignoreNotify");
      this.lUQ = false;
      AppMethodBeat.o(49584);
      return;
    }
    paramString = (AppBrandDesktopView)this.lVp.get();
    if (paramString != null) {
      AppBrandDesktopView.h(paramString);
    }
    AppMethodBeat.o(49584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.b
 * JD-Core Version:    0.7.0.1
 */