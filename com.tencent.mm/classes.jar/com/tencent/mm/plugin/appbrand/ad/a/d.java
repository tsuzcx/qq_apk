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

public final class d
  extends r
{
  private static final int CTRL_INDEX = 752;
  public static final String NAME = "onSplashAdHide";
  public String source = "launch";
  
  public final void a(final c paramc)
  {
    AppMethodBeat.i(281275);
    if ((paramc == null) || (paramc.getRuntime() == null))
    {
      AppMethodBeat.o(281275);
      return;
    }
    final HashMap localHashMap = new HashMap();
    localHashMap.put("source", Util.nullAs(this.source, "launch"));
    Log.i("MicroMsg.JsApiEventOnSplashAdHide[AppBrandSplashAd]", "dispatch, source:%s", new Object[] { this.source });
    paramc.getRuntime().nwF.a(new b.b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.m.o paramAnonymouso, kotlin.o<Long, Long> paramAnonymouso1)
      {
        AppMethodBeat.i(256198);
        if (paramAnonymouso == null)
        {
          AppMethodBeat.o(256198);
          return;
        }
        d.this.D(localHashMap).i(paramc).b(paramAnonymouso);
        AppMethodBeat.o(256198);
      }
    });
    AppMethodBeat.o(281275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.d
 * JD-Core Version:    0.7.0.1
 */