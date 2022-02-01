package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.header.c;

final class AppBrandDesktopContainer$3
  implements View.OnClickListener
{
  AppBrandDesktopContainer$3(AppBrandDesktopContainer paramAppBrandDesktopContainer) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49442);
    if ((AppBrandDesktopContainer.a(this.lTG) != null) && (AppBrandDesktopContainer.a(this.lTG).bru())) {
      AppBrandDesktopContainer.a(this.lTG).uA(14);
    }
    AppMethodBeat.o(49442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainer.3
 * JD-Core Version:    0.7.0.1
 */