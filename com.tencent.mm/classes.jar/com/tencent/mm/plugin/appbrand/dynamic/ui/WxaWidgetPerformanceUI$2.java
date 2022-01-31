package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.collector.c;

final class WxaWidgetPerformanceUI$2
  implements View.OnClickListener
{
  WxaWidgetPerformanceUI$2(WxaWidgetPerformanceUI paramWxaWidgetPerformanceUI, TextView paramTextView) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = c.rV("jsapi_draw_canvas").toString();
    paramView = new StringBuilder();
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      int i = c.bh("jsapi_draw_canvas", "__invoke_jsapi_data_size");
      paramView.append("data size :").append(i).append("\n").append((String)localObject);
    }
    localObject = (IPCString)com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:support", new IPCString("widget_launch"), WxaWidgetPerformanceUI.e.class);
    if (localObject != null) {
      paramView.append("\n\n").append(localObject);
    }
    if (com.tencent.mm.plugin.appbrand.collector.f.adT()) {
      paramView.append("\n\n").append(com.tencent.mm.plugin.appbrand.collector.f.adU());
    }
    this.fXC.setText(paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.2
 * JD-Core Version:    0.7.0.1
 */