package com.tencent.mm.plugin.appbrand.jsapi.r;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.ai;
import org.json.JSONObject;

public final class d
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  private static final int CTRL_INDEX = 470;
  private static final String NAME = "showStatusBar";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramc instanceof o)) {}
    for (paramJSONObject = ((o)paramc).E(q.class);; paramJSONObject = (q)paramc)
    {
      a(paramJSONObject.gTS, paramc, paramInt);
      return;
    }
  }
  
  final void a(com.tencent.mm.plugin.appbrand.page.a.c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1, int paramInt)
  {
    if (!ai.isMainThread())
    {
      ai.d(new d.1(this, paramc, paramc1, paramInt));
      return;
    }
    paramc.ahg();
    paramc1.C(paramInt, h("ok", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.d
 * JD-Core Version:    0.7.0.1
 */