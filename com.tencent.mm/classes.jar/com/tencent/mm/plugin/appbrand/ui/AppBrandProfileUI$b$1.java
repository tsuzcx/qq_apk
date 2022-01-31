package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.dat;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

final class AppBrandProfileUI$b$1
  implements Runnable
{
  AppBrandProfileUI$b$1(AppBrandProfileUI.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(133051);
    if ((this.iOu.iOr != null) && (this.iOu.iOr.get() != null))
    {
      AppBrandProfileUI localAppBrandProfileUI = (AppBrandProfileUI)this.iOu.iOr.get();
      if (AppBrandProfileUI.j(localAppBrandProfileUI))
      {
        AppBrandProfileUI.k(localAppBrandProfileUI).removeFirst();
        AppBrandProfileUI.l(localAppBrandProfileUI);
        if (AppBrandProfileUI.j(localAppBrandProfileUI)) {
          break label147;
        }
      }
      label147:
      for (boolean bool = true;; bool = false)
      {
        AppBrandProfileUI.a(localAppBrandProfileUI, bool);
        AppBrandProfileUI.n(localAppBrandProfileUI);
        if (!AppBrandProfileUI.o(localAppBrandProfileUI)) {
          break label152;
        }
        AppBrandProfileUI.a(localAppBrandProfileUI, 17, 1);
        AppMethodBeat.o(133051);
        return;
        dat localdat = new dat();
        localdat.yhc = true;
        localdat.oiD = b.qS(r.Zn());
        localdat.nickname = r.Zp();
        AppBrandProfileUI.k(localAppBrandProfileUI).addFirst(localdat);
        AppBrandProfileUI.m(localAppBrandProfileUI);
        break;
      }
      label152:
      AppBrandProfileUI.a(localAppBrandProfileUI, 18, 1);
    }
    AppMethodBeat.o(133051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.b.1
 * JD-Core Version:    0.7.0.1
 */