package com.tencent.mm.plugin.appbrand.m;

import com.eclipsesource.mmv8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.appbrand.v8.x.a;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class w
{
  private static boolean ojk;
  
  static
  {
    AppMethodBeat.i(107806);
    bYY();
    ojk = false;
    AppMethodBeat.o(107806);
  }
  
  public static i a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, f paramf)
  {
    AppMethodBeat.i(217415);
    IJSRuntime.Config localConfig = new IJSRuntime.Config();
    localConfig.fhP = paramString;
    localConfig.fhQ = paramArrayOfByte;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vTX, false)) {}
    for (paramString = "1";; paramString = "0")
    {
      Log.i("MicroMsg.AppBrandJsRuntimeFactory", "hy: use native buffer type: %s", new Object[] { paramString });
      localConfig.fhR = paramString;
      localConfig.fhS = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEz, true);
      localConfig.fhT = paramBoolean3;
      localConfig.fhU = paramBoolean1;
      localConfig.fhV = paramBoolean2;
      localConfig.fhY = new WeakReference(paramf);
      paramString = new x(localConfig);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(434L, 6L, 1L, false);
      Log.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandNodeJSBasedJsEngine");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(434L, 0L, 1L, false);
      AppMethodBeat.o(217415);
      return paramString;
    }
  }
  
  public static void bYY()
  {
    AppMethodBeat.i(107804);
    if (ojk)
    {
      AppMethodBeat.o(107804);
      return;
    }
    Object localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vOC, "--min_semi_space_size=4 --max_semi_space_size=8 --wasm_tier_up --wasm_lazy_compilation");
    Object localObject2 = m.bLr();
    if (Util.isNullOrNil((String)localObject1)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (MMApplicationContext.isAppBrandProcess()) {
        localObject2 = (String)localObject1 + " --no-wasm-code-gc";
      }
      Log.i("MicroMsg.AppBrandJsRuntimeFactory", "set v8 flag:%s", new Object[] { localObject2 });
      V8.setFlags((String)localObject2);
      ojk = true;
      com.tencent.mm.appbrand.v8.x.a(new x.a()
      {
        public final void hl(String paramAnonymousString)
        {
          AppMethodBeat.i(107803);
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(17693, paramAnonymousString);
          AppMethodBeat.o(107803);
        }
      });
      AppMethodBeat.o(107804);
      return;
      if (!Util.isNullOrNil((String)localObject2)) {
        localObject1 = (String)localObject1 + " " + (String)localObject2;
      }
    }
  }
  
  public static String e(i parami)
  {
    AppMethodBeat.i(217417);
    parami = com.tencent.luggage.sdk.c.b.e(parami);
    AppMethodBeat.o(217417);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.w
 * JD-Core Version:    0.7.0.1
 */