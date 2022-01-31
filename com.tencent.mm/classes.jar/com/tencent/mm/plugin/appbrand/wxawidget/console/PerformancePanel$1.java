package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.collector.c;

final class PerformancePanel$1
  implements View.OnClickListener
{
  PerformancePanel$1(PerformancePanel paramPerformancePanel, TextView paramTextView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(11173);
    Object localObject = c.zL("jsapi_draw_canvas").toString();
    paramView = new StringBuilder();
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      int i = c.bJ("jsapi_draw_canvas", "__invoke_jsapi_data_size");
      paramView.append("data size :").append(i).append("\n").append((String)localObject);
    }
    localObject = (IPCString)com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:support", new IPCString("widget_launch"), PerformancePanel.e.class);
    if (localObject != null) {
      paramView.append("\n\n").append(localObject);
    }
    if (com.tencent.mm.plugin.appbrand.collector.f.ayl()) {
      paramView.append("\n\n").append(com.tencent.mm.plugin.appbrand.collector.f.aym());
    }
    this.hrc.setText(paramView.toString());
    AppMethodBeat.o(11173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.1
 * JD-Core Version:    0.7.0.1
 */