package com.tencent.mm.plugin.appbrand.jsruntime;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.appbrand.v8.x.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class w
{
  private static boolean jNo;
  
  static
  {
    AppMethodBeat.i(107806);
    bmA();
    jNo = false;
    AppMethodBeat.o(107806);
  }
  
  public static i a(int paramInt, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, d paramd)
  {
    AppMethodBeat.i(205652);
    IJSRuntime.Config localConfig = new IJSRuntime.Config();
    localConfig.cMs = paramString;
    localConfig.cMt = paramArrayOfByte;
    if (((b)g.ab(b.class)).a(b.a.pZL, false))
    {
      paramString = "1";
      ac.i("MicroMsg.AppBrandJsRuntimeFactory", "hy: use native buffer type: %s", new Object[] { paramString });
      localConfig.cMu = paramString;
      localConfig.cMv = ((b)g.ab(b.class)).a(b.a.pSP, true);
      localConfig.cMw = paramBoolean3;
      localConfig.cMx = paramBoolean1;
      localConfig.cMy = paramBoolean2;
      localConfig.cMz = new WeakReference(paramd);
      paramString = a.a.geG;
      paramString = a.tJ("100377");
      if ((paramString == null) || (!paramString.isValid())) {
        break label420;
      }
    }
    label256:
    label389:
    label420:
    for (int j = bs.getInt((String)paramString.eYV().get("isolateContextLibVersion"), 0);; j = 0)
    {
      paramString = a.a.geG;
      paramString = a.tJ("100377");
      int i;
      if (paramString == null)
      {
        ac.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item is null");
        i = 2;
        label191:
        if ((i != 2) || ((paramInt < j) && (paramInt != 0))) {
          break label371;
        }
        paramBoolean1 = true;
        label209:
        ac.i("MicroMsg.AppBrand.JsRuntimeABTests", "supportLibVer:%d currentLibVer:%d userNodeJS:%b", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1) });
        if (!paramBoolean1) {
          break label376;
        }
        paramString = new x(localConfig);
        if (!(paramString instanceof c)) {
          break label389;
        }
        h.wUl.idkeyStat(434L, 5L, 1L, false);
        ac.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandJ2V8BasedJsEngine");
      }
      for (;;)
      {
        h.wUl.idkeyStat(434L, 0L, 1L, false);
        AppMethodBeat.o(205652);
        return paramString;
        paramString = "0";
        break;
        if (!paramString.isValid())
        {
          ac.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item not valid");
          i = 2;
          break label191;
        }
        i = bs.getInt((String)paramString.eYV().get("JsRuntime"), 2);
        ac.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal:%d", new Object[] { Integer.valueOf(i) });
        break label191;
        label371:
        paramBoolean1 = false;
        break label209;
        label376:
        paramString = new c(localConfig);
        break label256;
        if ((paramString instanceof x))
        {
          h.wUl.idkeyStat(434L, 6L, 1L, false);
          ac.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandNodeJSBasedJsEngine");
        }
      }
    }
  }
  
  public static void bmA()
  {
    AppMethodBeat.i(107804);
    if (jNo)
    {
      AppMethodBeat.o(107804);
      return;
    }
    Object localObject = ((b)g.ab(b.class)).a(b.a.pWT, "");
    String str = l.baF();
    if (bs.isNullOrNil((String)localObject)) {
      localObject = str;
    }
    for (;;)
    {
      ac.i("MicroMsg.AppBrandJsRuntimeFactory", "set v8 flag:%s", new Object[] { localObject });
      V8.setFlags((String)localObject);
      jNo = true;
      com.tencent.mm.appbrand.v8.x.a(new x.a()
      {
        public final void eM(String paramAnonymousString)
        {
          AppMethodBeat.i(107803);
          h.wUl.kvStat(17693, paramAnonymousString);
          AppMethodBeat.o(107803);
        }
      });
      AppMethodBeat.o(107804);
      return;
      if (!bs.isNullOrNil(str)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.w
 * JD-Core Version:    0.7.0.1
 */