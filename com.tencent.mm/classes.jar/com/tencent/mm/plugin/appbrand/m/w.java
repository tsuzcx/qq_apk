package com.tencent.mm.plugin.appbrand.m;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.appbrand.v8.x.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class w
{
  private static boolean loA;
  
  static
  {
    AppMethodBeat.i(107806);
    bMH();
    loA = false;
    AppMethodBeat.o(107806);
  }
  
  public static i a(int paramInt, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, com.tencent.mm.plugin.appbrand.jsapi.g paramg)
  {
    AppMethodBeat.i(204363);
    IJSRuntime.Config localConfig = new IJSRuntime.Config();
    localConfig.dpj = paramString;
    localConfig.dpk = paramArrayOfByte;
    if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.sjx, false))
    {
      paramString = "1";
      Log.i("MicroMsg.AppBrandJsRuntimeFactory", "hy: use native buffer type: %s", new Object[] { paramString });
      localConfig.dpl = paramString;
      localConfig.dpm = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rXG, true);
      localConfig.dpn = paramBoolean3;
      localConfig.dpo = paramBoolean1;
      localConfig.dpp = paramBoolean2;
      localConfig.dps = new WeakReference(paramg);
      paramString = a.a.hnM;
      paramString = a.Fu("100377");
      if ((paramString == null) || (!paramString.isValid())) {
        break label420;
      }
    }
    label256:
    label389:
    label420:
    for (int j = Util.getInt((String)paramString.gzz().get("isolateContextLibVersion"), 0);; j = 0)
    {
      paramString = a.a.hnM;
      paramString = a.Fu("100377");
      int i;
      if (paramString == null)
      {
        Log.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item is null");
        i = 2;
        label191:
        if ((i != 2) || ((paramInt < j) && (paramInt != 0))) {
          break label371;
        }
        paramBoolean1 = true;
        label209:
        Log.i("MicroMsg.AppBrand.JsRuntimeABTests", "supportLibVer:%d currentLibVer:%d userNodeJS:%b", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1) });
        if (!paramBoolean1) {
          break label376;
        }
        paramString = new x(localConfig);
        if (!(paramString instanceof c)) {
          break label389;
        }
        h.CyF.idkeyStat(434L, 5L, 1L, false);
        Log.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandJ2V8BasedJsEngine");
      }
      for (;;)
      {
        h.CyF.idkeyStat(434L, 0L, 1L, false);
        AppMethodBeat.o(204363);
        return paramString;
        paramString = "0";
        break;
        if (!paramString.isValid())
        {
          Log.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item not valid");
          i = 2;
          break label191;
        }
        i = Util.getInt((String)paramString.gzz().get("JsRuntime"), 2);
        Log.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal:%d", new Object[] { Integer.valueOf(i) });
        break label191;
        label371:
        paramBoolean1 = false;
        break label209;
        label376:
        paramString = new c(localConfig);
        break label256;
        if ((paramString instanceof x))
        {
          h.CyF.idkeyStat(434L, 6L, 1L, false);
          Log.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandNodeJSBasedJsEngine");
        }
      }
    }
  }
  
  public static void bMH()
  {
    AppMethodBeat.i(107804);
    if (loA)
    {
      AppMethodBeat.o(107804);
      return;
    }
    Object localObject1 = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.seS, "");
    Object localObject2 = m.bAc();
    if (Util.isNullOrNil((String)localObject1)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject2 = "--min_semi_space_size=4 --max_semi_space_size=8 --wasm_tier_up --wasm_lazy_compilation";
      }
      localObject1 = localObject2;
      if (MMApplicationContext.isAppBrandProcess()) {
        localObject1 = (String)localObject2 + " --no-wasm-code-gc";
      }
      Log.i("MicroMsg.AppBrandJsRuntimeFactory", "set v8 flag:%s", new Object[] { localObject1 });
      V8.setFlags((String)localObject1);
      loA = true;
      com.tencent.mm.appbrand.v8.x.a(new x.a()
      {
        public final void gz(String paramAnonymousString)
        {
          AppMethodBeat.i(107803);
          h.CyF.kvStat(17693, paramAnonymousString);
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
  
  public static String c(i parami)
  {
    if ((parami instanceof c)) {
      return "J2V8-Package";
    }
    if ((parami instanceof x)) {
      return "NodeJS";
    }
    return "unknown";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.w
 * JD-Core Version:    0.7.0.1
 */