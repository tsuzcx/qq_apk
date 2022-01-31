package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.sdk.platformtools.al;

final class WxaWidgetDebugUI$3
  implements View.OnClickListener
{
  WxaWidgetDebugUI$3(WxaWidgetDebugUI paramWxaWidgetDebugUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(11013);
    ((e)g.E(e.class)).ack().restart();
    al.p(new WxaWidgetDebugUI.3.1(this), 1000L);
    AppMethodBeat.o(11013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI.3
 * JD-Core Version:    0.7.0.1
 */