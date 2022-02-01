package com.tencent.mm.plugin.appbrand.n;

import com.eclipsesource.mmv8.V8;
import com.tencent.luggage.sdk.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class w
{
  private static boolean rmM;
  
  static
  {
    AppMethodBeat.i(107806);
    czm();
    rmM = false;
    AppMethodBeat.o(107806);
  }
  
  public static i a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, g paramg)
  {
    AppMethodBeat.i(319089);
    IJSRuntime.Config localConfig = new IJSRuntime.Config();
    localConfig.hmb = paramString;
    localConfig.hmc = paramArrayOfByte;
    localConfig.hmd = "1";
    localConfig.hme = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yTO, true);
    localConfig.hmf = paramBoolean4;
    localConfig.hmg = paramBoolean2;
    localConfig.hmh = paramBoolean3;
    localConfig.hml = new WeakReference(paramg);
    localConfig.hmk = paramBoolean1;
    paramString = new x(localConfig);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(434L, 6L, 1L, false);
    Log.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandNodeJSBasedJsEngine");
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(434L, 0L, 1L, false);
    AppMethodBeat.o(319089);
    return paramString;
  }
  
  public static void czm()
  {
    AppMethodBeat.i(107804);
    if (rmM)
    {
      AppMethodBeat.o(107804);
      return;
    }
    Object localObject1 = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zhe, "--min_semi_space_size=4 --max_semi_space_size=8 --wasm_tier_up --wasm_lazy_compilation");
    Object localObject2 = o.ckM();
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
      rmM = true;
      com.tencent.mm.appbrand.v8.x.a(new w.1());
      AppMethodBeat.o(107804);
      return;
      if (!Util.isNullOrNil((String)localObject2)) {
        localObject1 = (String)localObject1 + " " + (String)localObject2;
      }
    }
  }
  
  public static String e(i parami)
  {
    AppMethodBeat.i(319091);
    parami = b.e(parami);
    AppMethodBeat.o(319091);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.w
 * JD-Core Version:    0.7.0.1
 */