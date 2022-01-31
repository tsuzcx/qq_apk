package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import java.util.HashMap;
import java.util.Map;

final class c$1
  implements View.OnClickListener
{
  c$1(c paramc, u.b paramb, e parame) {}
  
  public final void onClick(View paramView)
  {
    if (!this.giE.ik("clickable")) {
      return;
    }
    paramView = new c.a((byte)0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", this.giE.getString("data", ""));
    paramView.p(localHashMap);
    paramView.e(this.gkV);
    if ("webview".equals(this.giE.getString("sendTo", null)))
    {
      this.gkV.a(paramView);
      return;
    }
    this.gkV.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.c.1
 * JD-Core Version:    0.7.0.1
 */