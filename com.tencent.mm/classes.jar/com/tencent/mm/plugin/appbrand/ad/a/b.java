package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.as;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.r;

public final class b
  extends s
{
  private static final int CTRL_INDEX = 760;
  public static final String NAME = "onSplashAdButtonClicked";
  public String source = "launch";
  public String type = "close";
  
  public final void a(final c paramc)
  {
    AppMethodBeat.i(321309);
    if ((paramc == null) || (paramc.getRuntime() == null))
    {
      AppMethodBeat.o(321309);
      return;
    }
    final HashMap localHashMap = new HashMap();
    localHashMap.put("source", Util.nullAs(this.source, "launch"));
    localHashMap.put("buttonType", Util.nullAs(this.type, "close"));
    Log.i("MicroMsg.JsApiEventOnSplashAdButtonClicked[AppBrandSplashAd]", "dispatch, source:%s, buttonType:%s", new Object[] { this.source, this.type });
    paramc.getRuntime().qvK.a(new as()
    {
      public final void a(o paramAnonymouso, r<Long, Long> paramAnonymousr, String paramAnonymousString)
      {
        AppMethodBeat.i(321311);
        if (paramAnonymouso == null)
        {
          AppMethodBeat.o(321311);
          return;
        }
        b.this.K(localHashMap).h(paramc).b(paramAnonymouso);
        AppMethodBeat.o(321311);
      }
    });
    AppMethodBeat.o(321309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.b
 * JD-Core Version:    0.7.0.1
 */