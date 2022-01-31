package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.cg.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.modelappbrand.e;

final class WxaWidgetDebugUI$3
  implements View.OnClickListener
{
  WxaWidgetDebugUI$3(WxaWidgetDebugUI paramWxaWidgetDebugUI) {}
  
  public final void onClick(View paramView)
  {
    ((e)g.r(e.class)).Jm().restart();
    a.e(new WxaWidgetDebugUI.3.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI.3
 * JD-Core Version:    0.7.0.1
 */