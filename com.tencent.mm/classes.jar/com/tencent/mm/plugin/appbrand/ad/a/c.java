package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class c
  extends r
{
  private static final int CTRL_INDEX = 753;
  public static final String NAME = "onSplashAdClose";
  public String source = "launch";
  
  public final void a(final com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    AppMethodBeat.i(282584);
    if ((paramc == null) || (paramc.getRuntime() == null))
    {
      AppMethodBeat.o(282584);
      return;
    }
    final HashMap localHashMap = new HashMap();
    localHashMap.put("source", Util.nullAs(this.source, "launch"));
    Log.i("MicroMsg.JsApiEventOnSplashAdClosed[AppBrandSplashAd]", "dispatch, source:%s", new Object[] { this.source });
    paramc.getRuntime().nwF.a(new b.b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.m.o paramAnonymouso, kotlin.o<Long, Long> paramAnonymouso1)
      {
        AppMethodBeat.i(284455);
        if (paramAnonymouso == null)
        {
          AppMethodBeat.o(284455);
          return;
        }
        c.this.D(localHashMap).i(paramc).b(paramAnonymouso);
        AppMethodBeat.o(284455);
      }
    });
    AppMethodBeat.o(282584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.c
 * JD-Core Version:    0.7.0.1
 */