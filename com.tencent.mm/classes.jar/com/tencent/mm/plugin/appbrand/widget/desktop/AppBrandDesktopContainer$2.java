package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.widget.header.c;

final class AppBrandDesktopContainer$2
  implements View.OnClickListener
{
  AppBrandDesktopContainer$2(AppBrandDesktopContainer paramAppBrandDesktopContainer) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49441);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((AppBrandDesktopContainer.a(this.nbv) != null) && (AppBrandDesktopContainer.a(this.nbv).bDr())) {
      AppBrandDesktopContainer.a(this.nbv).wc(16);
    }
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(49441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainer.2
 * JD-Core Version:    0.7.0.1
 */