package com.tencent.mm.plugin.appbrand.aa;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.plugin.appbrand.menu.s;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import org.json.JSONObject;

public final class h
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 621;
  public static final String NAME = "showShareActionSheet";
  e mWQ;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, final JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(49360);
    if ((paramc instanceof com.tencent.mm.plugin.appbrand.service.c)) {
      paramJSONObject = ((com.tencent.mm.plugin.appbrand.service.c)paramc).aXu();
    }
    for (;;)
    {
      if (paramJSONObject == null)
      {
        ae.e("MicroMsg.JsApiShowShareActionSheet", "fail, page view is null");
        paramc.h(paramInt, e("fail:page don't exist", null));
        AppMethodBeat.o(49360);
        return;
        if ((paramc instanceof ad)) {
          paramJSONObject = (ad)paramc;
        }
      }
      else
      {
        ae.i("MicroMsg.JsApiShowShareActionSheet", "weishi show share action sheet");
        paramJSONObject.getRuntime().j(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49355);
            h localh = h.this;
            ad localad = paramJSONObject;
            localh.mWQ = new e(localad.getContext(), true, 1);
            localh.mWQ.LfS = new h.2(localh);
            localh.mWQ.LfT = new h.3(localh, localad);
            localh.mWQ.lEe = true;
            localh.mWQ.lEf = true;
            localh.mWQ.cPF();
            localad.a(new h.4(localh, localad));
            localad.a(new h.5(localh, localad));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.h
 * JD-Core Version:    0.7.0.1
 */