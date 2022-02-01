package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class e
  extends r
{
  private static final int CTRL_INDEX = 751;
  public static final String NAME = "onSplashAdShow";
  public String source = "launch";
  
  public final void a(final c paramc)
  {
    AppMethodBeat.i(280735);
    if ((paramc == null) || (paramc.getRuntime() == null))
    {
      AppMethodBeat.o(280735);
      return;
    }
    final HashMap localHashMap = new HashMap();
    localHashMap.put("source", Util.nullAs(this.source, "launch"));
    Log.i("MicroMsg.JsApiEventOnSplashAdShow[AppBrandSplashAd]", "dispatch, source:%s", new Object[] { this.source });
    paramc.getRuntime().nwF.a(new b.b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.m.o paramAnonymouso, kotlin.o<Long, Long> paramAnonymouso1)
      {
        AppMethodBeat.i(280662);
        if (paramAnonymouso == null)
        {
          AppMethodBeat.o(280662);
          return;
        }
        e.this.D(localHashMap).i(paramc).b(paramAnonymouso);
        AppMethodBeat.o(280662);
      }
    });
    AppMethodBeat.o(280735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.e
 * JD-Core Version:    0.7.0.1
 */