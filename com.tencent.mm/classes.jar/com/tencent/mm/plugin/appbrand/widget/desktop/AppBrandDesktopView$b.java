package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandDesktopView$b
  implements k.a
{
  boolean jeM = false;
  private int mType;
  
  public AppBrandDesktopView$b(AppBrandDesktopView paramAppBrandDesktopView, int paramInt)
  {
    this.mType = paramInt;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(133840);
    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onNotifyChange type: %d, ignore: %b, eventId: %d", new Object[] { Integer.valueOf(this.mType), Boolean.valueOf(this.jeM), Integer.valueOf(paramm.htj) });
    if (paramm.htj == -1)
    {
      ab.w("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange pass eventId: %d", new Object[] { Integer.valueOf(paramm.htj) });
      AppMethodBeat.o(133840);
      return;
    }
    if (this.jeM)
    {
      ab.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange ignoreNotify");
      this.jeM = false;
      AppMethodBeat.o(133840);
      return;
    }
    AppBrandDesktopView.i(this.jfg);
    AppMethodBeat.o(133840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.b
 * JD-Core Version:    0.7.0.1
 */