package com.tencent.mm.plugin.appbrand.weishi;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.menu.x;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import org.json.JSONObject;

public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  public static final int CTRL_INDEX = 621;
  public static final String NAME = "showShareActionSheet";
  com.tencent.mm.ui.widget.a.f uvV;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, final JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(49360);
    paramJSONObject = null;
    if ((paramf instanceof com.tencent.mm.plugin.appbrand.service.c)) {
      paramJSONObject = ((com.tencent.mm.plugin.appbrand.service.c)paramf).ccK();
    }
    while (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiShowShareActionSheet", "fail, page view is null");
      paramf.callback(paramInt, ZP("fail:page don't exist"));
      AppMethodBeat.o(49360);
      return;
      if ((paramf instanceof ah)) {
        paramJSONObject = (ah)paramf;
      }
    }
    Log.i("MicroMsg.JsApiShowShareActionSheet", "weishi show share action sheet");
    paramJSONObject.getRuntime().i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49355);
        i locali = i.this;
        ah localah = paramJSONObject;
        locali.uvV = new com.tencent.mm.ui.widget.a.f(localah.getContext(), false, 1);
        locali.uvV.Vtg = new i.2(locali);
        locali.uvV.GAC = new i.3(locali, localah);
        locali.uvV.sRy = true;
        locali.uvV.sRz = true;
        locali.uvV.dDn();
        localah.a(new i.4(locali, localah));
        localah.a(new i.5(locali, localah));
        AppMethodBeat.o(49355);
      }
    }, 0L);
    paramf.callback(paramInt, ZP("ok"));
    AppMethodBeat.o(49360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.weishi.i
 * JD-Core Version:    0.7.0.1
 */