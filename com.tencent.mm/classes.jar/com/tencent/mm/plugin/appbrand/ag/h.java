package com.tencent.mm.plugin.appbrand.ag;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.menu.w;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import org.json.JSONObject;

public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.jsapi.e>
{
  public static final int CTRL_INDEX = 621;
  public static final String NAME = "showShareActionSheet";
  com.tencent.mm.ui.widget.a.e rmh;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, final JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(49360);
    if ((parame instanceof com.tencent.mm.plugin.appbrand.service.c)) {
      paramJSONObject = ((com.tencent.mm.plugin.appbrand.service.c)parame).bDv();
    }
    for (;;)
    {
      if (paramJSONObject == null)
      {
        Log.e("MicroMsg.JsApiShowShareActionSheet", "fail, page view is null");
        parame.j(paramInt, h("fail:page don't exist", null));
        AppMethodBeat.o(49360);
        return;
        if ((parame instanceof ah)) {
          paramJSONObject = (ah)parame;
        }
      }
      else
      {
        Log.i("MicroMsg.JsApiShowShareActionSheet", "weishi show share action sheet");
        paramJSONObject.getRuntime().h(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49355);
            h localh = h.this;
            ah localah = paramJSONObject;
            localh.rmh = new com.tencent.mm.ui.widget.a.e(localah.getContext(), false, 1);
            localh.rmh.ODT = new h.2(localh);
            localh.rmh.ODU = new h.3(localh, localah);
            localh.rmh.pMF = true;
            localh.rmh.pMG = true;
            localh.rmh.eik();
            localah.a(new h.4(localh, localah));
            localah.a(new h.5(localh, localah));
            AppMethodBeat.o(49355);
          }
        }, 0L);
        parame.j(paramInt, h("ok", null));
        AppMethodBeat.o(49360);
        return;
      }
      paramJSONObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.h
 * JD-Core Version:    0.7.0.1
 */