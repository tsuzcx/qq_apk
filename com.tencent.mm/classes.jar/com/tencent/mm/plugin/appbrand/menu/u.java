package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/menu/MenuDelegate_TradeComplaint;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseMenuDelegate;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "attachTo", "", "context", "Landroid/content/Context;", "pageView", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "appId", "", "performItemClick", "menuInfo", "Lcom/tencent/mm/plugin/appbrand/menu/MenuInfo;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends com.tencent.mm.plugin.appbrand.menu.a.a<ah>
{
  public static final a tkd;
  
  static
  {
    AppMethodBeat.i(323870);
    tkd = new a((byte)0);
    AppMethodBeat.o(323870);
  }
  
  public u()
  {
    super(x.tkP.ordinal());
    AppMethodBeat.i(323859);
    AppMethodBeat.o(323859);
  }
  
  public static final y i(ah paramah)
  {
    AppMethodBeat.i(323865);
    paramah = a.i(paramah);
    AppMethodBeat.o(323865);
    return paramah;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/menu/MenuDelegate_TradeComplaint$Companion;", "", "()V", "TAG", "", "TRADE_COMPLAINT_FAKE_NATIVE_APP_ENTER_PATH_FORMAT", "TRADE_COMPLAINT_FAKE_NATIVE_APP_USER_NAME", "getState", "Lcom/tencent/mm/plugin/appbrand/menu/MenuState;", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static y i(ah paramah)
    {
      int j = 0;
      AppMethodBeat.i(323897);
      int i;
      if (paramah == null) {
        i = j;
      }
      for (;;)
      {
        Log.i("MicroMsg.AppBrand.MenuDelegate_TradeComplaint", s.X("getState, controlByte: ", Integer.valueOf(i)));
        if (i != 1) {
          break;
        }
        paramah = y.tkS;
        AppMethodBeat.o(323897);
        return paramah;
        paramah = paramah.getRuntime();
        i = j;
        if (paramah != null)
        {
          paramah = paramah.ccM();
          i = j;
          if (paramah != null) {
            i = com.tencent.mm.plugin.appbrand.config.a.a(com.tencent.mm.plugin.appbrand.config.a.qVx, paramah);
          }
        }
      }
      paramah = y.tkR;
      AppMethodBeat.o(323897);
      return paramah;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.u
 * JD-Core Version:    0.7.0.1
 */