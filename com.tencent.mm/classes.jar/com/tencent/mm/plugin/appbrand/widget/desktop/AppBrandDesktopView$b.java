package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.lang.ref.WeakReference;

final class AppBrandDesktopView$b
  implements MStorage.IOnStorageChange
{
  private int mType;
  boolean onL;
  private WeakReference<AppBrandDesktopView> ooi;
  
  public AppBrandDesktopView$b(AppBrandDesktopView paramAppBrandDesktopView, int paramInt)
  {
    AppMethodBeat.i(49583);
    this.onL = false;
    this.mType = paramInt;
    this.ooi = new WeakReference(paramAppBrandDesktopView);
    AppMethodBeat.o(49583);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(49584);
    Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onNotifyChange type: %d, ignore: %b, eventId: %d", new Object[] { Integer.valueOf(this.mType), Boolean.valueOf(this.onL), Integer.valueOf(paramMStorageEventData.eventId) });
    if (paramMStorageEventData.eventId == -1)
    {
      Log.w("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange pass eventId: %d", new Object[] { Integer.valueOf(paramMStorageEventData.eventId) });
      AppMethodBeat.o(49584);
      return;
    }
    if (this.onL)
    {
      Log.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange ignoreNotify");
      this.onL = false;
      AppMethodBeat.o(49584);
      return;
    }
    paramString = (AppBrandDesktopView)this.ooi.get();
    if (paramString != null) {
      AppBrandDesktopView.h(paramString);
    }
    AppMethodBeat.o(49584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.b
 * JD-Core Version:    0.7.0.1
 */