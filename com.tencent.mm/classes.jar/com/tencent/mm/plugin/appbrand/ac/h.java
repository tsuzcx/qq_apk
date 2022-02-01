package com.tencent.mm.plugin.appbrand.ac;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import org.json.JSONObject;

public final class h
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 621;
  public static final String NAME = "showShareActionSheet";
  e lPb;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, final JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(49360);
    if ((paramc instanceof com.tencent.mm.plugin.appbrand.service.c)) {
      paramJSONObject = ((com.tencent.mm.plugin.appbrand.service.c)paramc).aMZ();
    }
    for (;;)
    {
      if (paramJSONObject == null)
      {
        ad.e("MicroMsg.JsApiShowShareActionSheet", "fail, page view is null");
        paramc.h(paramInt, e("fail:page don't exist", null));
        AppMethodBeat.o(49360);
        return;
        if ((paramc instanceof ae)) {
          paramJSONObject = (ae)paramc;
        }
      }
      else
      {
        ad.i("MicroMsg.JsApiShowShareActionSheet", "weishi show share action sheet");
        paramJSONObject.getRuntime().i(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49355);
            h localh = h.this;
            ae localae = paramJSONObject;
            localh.lPb = new e(localae.getContext(), true, 1);
            localh.lPb.HrX = new h.2(localh);
            localh.lPb.HrY = new h.3(localh, localae);
            localh.lPb.kBo = true;
            localh.lPb.kBp = true;
            localh.lPb.csG();
            localae.a(new h.4(localh, localae));
            localae.a(new h.5(localh, localae));
            AppMethodBeat.o(49355);
          }
        }, 0L);
        paramc.h(paramInt, e("ok", null));
        AppMethodBeat.o(49360);
        return;
      }
      paramJSONObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.h
 * JD-Core Version:    0.7.0.1
 */