package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.as;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.r;

public final class c
  extends s
{
  private static final int CTRL_INDEX = 753;
  public static final String NAME = "onSplashAdClose";
  public String source = "launch";
  
  public final void a(final com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    AppMethodBeat.i(321305);
    if ((paramc == null) || (paramc.getRuntime() == null))
    {
      AppMethodBeat.o(321305);
      return;
    }
    final HashMap localHashMap = new HashMap();
    localHashMap.put("source", Util.nullAs(this.source, "launch"));
    Log.i("MicroMsg.JsApiEventOnSplashAdClosed[AppBrandSplashAd]", "dispatch, source:%s", new Object[] { this.source });
    paramc.getRuntime().qvK.a(new as()
    {
      public final void a(o paramAnonymouso, r<Long, Long> paramAnonymousr, String paramAnonymousString)
      {
        AppMethodBeat.i(321319);
        if (paramAnonymouso == null)
        {
          AppMethodBeat.o(321319);
          return;
        }
        c.this.K(localHashMap).h(paramc).b(paramAnonymouso);
        AppMethodBeat.o(321319);
      }
    });
    AppMethodBeat.o(321305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.c
 * JD-Core Version:    0.7.0.1
 */