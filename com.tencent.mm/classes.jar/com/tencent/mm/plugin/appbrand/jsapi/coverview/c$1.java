package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import java.util.HashMap;
import java.util.Map;

final class c$1
  implements View.OnClickListener
{
  c$1(c paramc, v.b paramb, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(126293);
    if (!this.hBX.oR("clickable"))
    {
      AppMethodBeat.o(126293);
      return;
    }
    paramView = new c.a((byte)0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", this.hBX.getString("data", ""));
    paramView.x(localHashMap);
    paramView.j(this.hEL);
    if ("webview".equals(this.hBX.getString("sendTo", null)))
    {
      this.hEL.a(paramView);
      AppMethodBeat.o(126293);
      return;
    }
    this.hEL.b(paramView);
    AppMethodBeat.o(126293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.c.1
 * JD-Core Version:    0.7.0.1
 */