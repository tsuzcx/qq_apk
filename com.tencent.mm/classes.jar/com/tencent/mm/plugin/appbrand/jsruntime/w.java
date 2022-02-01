package com.tencent.mm.plugin.appbrand.jsruntime;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class w
{
  private static boolean jnb;
  
  static
  {
    AppMethodBeat.i(107806);
    bfG();
    jnb = false;
    AppMethodBeat.o(107806);
  }
  
  public static i a(int paramInt, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, d paramd)
  {
    AppMethodBeat.i(192557);
    IJSRuntime.Config localConfig = new IJSRuntime.Config();
    localConfig.cOX = paramString;
    localConfig.cOY = paramArrayOfByte;
    if (((b)g.ab(b.class)).a(b.a.pvx, false))
    {
      paramString = "1";
      ad.i("MicroMsg.AppBrandJsRuntimeFactory", "hy: use native buffer type: %s", new Object[] { paramString });
      localConfig.cOZ = paramString;
      localConfig.cPa = ((b)g.ab(b.class)).a(b.a.ppe, true);
      localConfig.cPb = paramBoolean3;
      localConfig.cPc = paramBoolean1;
      localConfig.cPd = paramBoolean2;
      localConfig.cPe = new WeakReference(paramd);
      paramString = a.a.gaa;
      paramString = a.qu("100377");
      if ((paramString == null) || (!paramString.isValid())) {
        break label420;
      }
    }
    label256:
    label389:
    label420:
    for (int j = bt.getInt((String)paramString.eJy().get("isolateContextLibVersion"), 0);; j = 0)
    {
      paramString = a.a.gaa;
      paramString = a.qu("100377");
      int i;
      if (paramString == null)
      {
        ad.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item is null");
        i = 2;
        label191:
        if ((i != 2) || ((paramInt < j) && (paramInt != 0))) {
          break label371;
        }
        paramBoolean1 = true;
        label209:
        ad.i("MicroMsg.AppBrand.JsRuntimeABTests", "supportLibVer:%d currentLibVer:%d userNodeJS:%b", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1) });
        if (!paramBoolean1) {
          break label376;
        }
        paramString = new x(localConfig);
        if (!(paramString instanceof c)) {
          break label389;
        }
        h.vKh.idkeyStat(434L, 5L, 1L, false);
        ad.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandJ2V8BasedJsEngine");
      }
      for (;;)
      {
        h.vKh.idkeyStat(434L, 0L, 1L, false);
        AppMethodBeat.o(192557);
        return paramString;
        paramString = "0";
        break;
        if (!paramString.isValid())
        {
          ad.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item not valid");
          i = 2;
          break label191;
        }
        i = bt.getInt((String)paramString.eJy().get("JsRuntime"), 2);
        ad.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal:%d", new Object[] { Integer.valueOf(i) });
        break label191;
        label371:
        paramBoolean1 = false;
        break label209;
        label376:
        paramString = new c(localConfig);
        break label256;
        if ((paramString instanceof x))
        {
          h.vKh.idkeyStat(434L, 6L, 1L, false);
          ad.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandNodeJSBasedJsEngine");
        }
      }
    }
  }
  
  public static void bfG()
  {
    AppMethodBeat.i(107804);
    if (jnb)
    {
      AppMethodBeat.o(107804);
      return;
    }
    Object localObject = ((b)g.ab(b.class)).a(b.a.psK, "");
    String str = l.aTH();
    if (bt.isNullOrNil((String)localObject)) {
      localObject = str;
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrandJsRuntimeFactory", "set v8 flag:%s", new Object[] { localObject });
      V8.setFlags((String)localObject);
      jnb = true;
      com.tencent.mm.appbrand.v8.x.a(new w.1());
      AppMethodBeat.o(107804);
      return;
      if (!bt.isNullOrNil(str)) {
        localObject = (String)localObject + " " + str;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.w
 * JD-Core Version:    0.7.0.1
 */