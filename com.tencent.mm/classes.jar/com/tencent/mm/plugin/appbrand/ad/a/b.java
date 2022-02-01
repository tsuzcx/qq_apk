package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class b
  extends r
{
  private static final int CTRL_INDEX = 760;
  public static final String NAME = "onSplashAdButtonClicked";
  public String source = "launch";
  public String type = "close";
  
  public final void a(final c paramc)
  {
    AppMethodBeat.i(281752);
    if ((paramc == null) || (paramc.getRuntime() == null))
    {
      AppMethodBeat.o(281752);
      return;
    }
    final HashMap localHashMap = new HashMap();
    localHashMap.put("source", Util.nullAs(this.source, "launch"));
    localHashMap.put("buttonType", Util.nullAs(this.type, "close"));
    Log.i("MicroMsg.JsApiEventOnSplashAdButtonClicked[AppBrandSplashAd]", "dispatch, source:%s, buttonType:%s", new Object[] { this.source, this.type });
    paramc.getRuntime().nwF.a(new b.b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.m.o paramAnonymouso, kotlin.o<Long, Long> paramAnonymouso1)
      {
        AppMethodBeat.i(274810);
        if (paramAnonymouso == null)
        {
          AppMethodBeat.o(274810);
          return;
        }
        b.this.D(localHashMap).i(paramc).b(paramAnonymouso);
        AppMethodBeat.o(274810);
      }
    });
    AppMethodBeat.o(281752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.b
 * JD-Core Version:    0.7.0.1
 */