package com.tencent.mm.plugin.appbrand.dynamic.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.a.a;
import com.tencent.mm.plugin.appbrand.widget.n;
import com.tencent.mm.plugin.appbrand.widget.o;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class WxaWidgetDebugUI$2
  implements MMSwitchBtn.a
{
  WxaWidgetDebugUI$2(WxaWidgetDebugUI paramWxaWidgetDebugUI) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(11011);
    this.hqW.hqV.field_openDebug = paramBoolean;
    o localo = ((a)g.E(a.class)).auI();
    n localn = this.hqW.hqV;
    if ((localn != null) && (!bo.isNullOrNil(localn.field_appId)))
    {
      localn.field_appIdHash = localn.field_appId.hashCode();
      localo.replace(localn);
    }
    AppMethodBeat.o(11011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI.2
 * JD-Core Version:    0.7.0.1
 */