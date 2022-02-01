package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

final class AppBrandDesktopView$b
  implements k.a
{
  private int mType;
  boolean mwS;
  private WeakReference<AppBrandDesktopView> mxr;
  
  public AppBrandDesktopView$b(AppBrandDesktopView paramAppBrandDesktopView, int paramInt)
  {
    AppMethodBeat.i(49583);
    this.mwS = false;
    this.mType = paramInt;
    this.mxr = new WeakReference(paramAppBrandDesktopView);
    AppMethodBeat.o(49583);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(49584);
    ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onNotifyChange type: %d, ignore: %b, eventId: %d", new Object[] { Integer.valueOf(this.mType), Boolean.valueOf(this.mwS), Integer.valueOf(paramm.jRj) });
    if (paramm.jRj == -1)
    {
      ac.w("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange pass eventId: %d", new Object[] { Integer.valueOf(paramm.jRj) });
      AppMethodBeat.o(49584);
      return;
    }
    if (this.mwS)
    {
      ac.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange ignoreNotify");
      this.mwS = false;
      AppMethodBeat.o(49584);
      return;
    }
    paramString = (AppBrandDesktopView)this.mxr.get();
    if (paramString != null) {
      AppBrandDesktopView.h(paramString);
    }
    AppMethodBeat.o(49584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.b
 * JD-Core Version:    0.7.0.1
 */