package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.u.b;
import java.util.HashMap;
import java.util.Map;

final class e$1
  implements View.OnClickListener
{
  e$1(e parame, u.b paramb, com.tencent.mm.plugin.appbrand.jsapi.e parame1) {}
  
  public final void onClick(View paramView)
  {
    if (!this.giE.ik("clickable")) {
      return;
    }
    paramView = new e.a((byte)0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", this.giE.getString("data", ""));
    paramView.p(localHashMap);
    if ("webview".equals(this.giE.getString("sendTo", null)))
    {
      this.gkV.a(paramView);
      return;
    }
    this.gkV.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.e.1
 * JD-Core Version:    0.7.0.1
 */