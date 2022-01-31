package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import java.util.HashMap;
import java.util.Map;

final class e$1
  implements View.OnClickListener
{
  e$1(e parame, v.b paramb, com.tencent.mm.plugin.appbrand.jsapi.e parame1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(126303);
    if (!this.hBX.oR("clickable"))
    {
      AppMethodBeat.o(126303);
      return;
    }
    paramView = new e.a((byte)0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", this.hBX.getString("data", ""));
    paramView.x(localHashMap);
    if ("webview".equals(this.hBX.getString("sendTo", null)))
    {
      this.hEL.a(paramView);
      AppMethodBeat.o(126303);
      return;
    }
    this.hEL.b(paramView);
    AppMethodBeat.o(126303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.e.1
 * JD-Core Version:    0.7.0.1
 */