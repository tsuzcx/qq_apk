package com.tencent.mm.plugin.appbrand.af;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.menu.o;
import com.tencent.mm.plugin.appbrand.menu.u;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import org.json.JSONObject;

public final class h
  extends d<f>
{
  public static final int CTRL_INDEX = 621;
  public static final String NAME = "showShareActionSheet";
  e ojT;
  
  public final void a(f paramf, final JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(49360);
    if ((paramf instanceof c)) {
      paramJSONObject = ((c)paramf).bsz();
    }
    for (;;)
    {
      if (paramJSONObject == null)
      {
        Log.e("MicroMsg.JsApiShowShareActionSheet", "fail, page view is null");
        paramf.i(paramInt, h("fail:page don't exist", null));
        AppMethodBeat.o(49360);
        return;
        if ((paramf instanceof ag)) {
          paramJSONObject = (ag)paramf;
        }
      }
      else
      {
        Log.i("MicroMsg.JsApiShowShareActionSheet", "weishi show share action sheet");
        paramJSONObject.getRuntime().i(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49355);
            h localh = h.this;
            ag localag = paramJSONObject;
            localh.ojT = new e(localag.getContext(), false, 1);
            localh.ojT.HLX = new h.2(localh);
            localh.ojT.HLY = new h.3(localh, localag);
            localh.ojT.mLN = true;
            localh.ojT.mLO = true;
            localh.ojT.dGm();
            localag.a(new h.4(localh, localag));
            localag.a(new h.5(localh, localag));
            AppMethodBeat.o(49355);
          }
        }, 0L);
        paramf.i(paramInt, h("ok", null));
        AppMethodBeat.o(49360);
        return;
      }
      paramJSONObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.h
 * JD-Core Version:    0.7.0.1
 */