package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.collector.c;

final class WxaWidgetPerformanceUI$3
  implements View.OnClickListener
{
  WxaWidgetPerformanceUI$3(WxaWidgetPerformanceUI paramWxaWidgetPerformanceUI, TextView paramTextView) {}
  
  public final void onClick(View paramView)
  {
    com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:support", null, WxaWidgetPerformanceUI.a.class, null);
    c.clear();
    com.tencent.mm.plugin.appbrand.collector.f.reset();
    this.fXC.setText(c.rV("jsapi_draw_canvas").toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.3
 * JD-Core Version:    0.7.0.1
 */