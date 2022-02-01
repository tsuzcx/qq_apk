package com.tencent.mm.plugin.appbrand.jsruntime;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.appbrand.v8.x.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class w
{
  private static boolean kkP;
  
  static
  {
    AppMethodBeat.i(107806);
    bqV();
    kkP = false;
    AppMethodBeat.o(107806);
  }
  
  public static i a(int paramInt, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, d paramd)
  {
    AppMethodBeat.i(217738);
    IJSRuntime.Config localConfig = new IJSRuntime.Config();
    localConfig.cYF = paramString;
    localConfig.cYG = paramArrayOfByte;
    if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qMG, false))
    {
      paramString = "1";
      ae.i("MicroMsg.AppBrandJsRuntimeFactory", "hy: use native buffer type: %s", new Object[] { paramString });
      localConfig.cYH = paramString;
      localConfig.cYI = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qEz, true);
      localConfig.cYJ = paramBoolean3;
      localConfig.cYK = paramBoolean1;
      localConfig.cYL = paramBoolean2;
      localConfig.cYN = new WeakReference(paramd);
      paramString = a.a.gAX;
      paramString = a.xi("100377");
      if ((paramString == null) || (!paramString.isValid())) {
        break label420;
      }
    }
    label256:
    label389:
    label420:
    for (int j = bu.getInt((String)paramString.fsy().get("isolateContextLibVersion"), 0);; j = 0)
    {
      paramString = a.a.gAX;
      paramString = a.xi("100377");
      int i;
      if (paramString == null)
      {
        ae.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item is null");
        i = 2;
        label191:
        if ((i != 2) || ((paramInt < j) && (paramInt != 0))) {
          break label371;
        }
        paramBoolean1 = true;
        label209:
        ae.i("MicroMsg.AppBrand.JsRuntimeABTests", "supportLibVer:%d currentLibVer:%d userNodeJS:%b", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1) });
        if (!paramBoolean1) {
          break label376;
        }
        paramString = new x(localConfig);
        if (!(paramString instanceof c)) {
          break label389;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(434L, 5L, 1L, false);
        ae.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandJ2V8BasedJsEngine");
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(434L, 0L, 1L, false);
        AppMethodBeat.o(217738);
        return paramString;
        paramString = "0";
        break;
        if (!paramString.isValid())
        {
          ae.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item not valid");
          i = 2;
          break label191;
        }
        i = bu.getInt((String)paramString.fsy().get("JsRuntime"), 2);
        ae.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal:%d", new Object[] { Integer.valueOf(i) });
        break label191;
        label371:
        paramBoolean1 = false;
        break label209;
        label376:
        paramString = new c(localConfig);
        break label256;
        if ((paramString instanceof x))
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(434L, 6L, 1L, false);
          ae.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandNodeJSBasedJsEngine");
        }
      }
    }
  }
  
  public static void bqV()
  {
    AppMethodBeat.i(107804);
    if (kkP)
    {
      AppMethodBeat.o(107804);
      return;
    }
    Object localObject = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qJq, "");
    String str = l.beL();
    if (bu.isNullOrNil((String)localObject)) {
      localObject = str;
    }
    for (;;)
    {
      ae.i("MicroMsg.AppBrandJsRuntimeFactory", "set v8 flag:%s", new Object[] { localObject });
      V8.setFlags((String)localObject);
      kkP = true;
      com.tencent.mm.appbrand.v8.x.a(new x.a()
      {
        public final void fN(String paramAnonymousString)
        {
          AppMethodBeat.i(107803);
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(17693, paramAnonymousString);
          AppMethodBeat.o(107803);
        }
      });
      AppMethodBeat.o(107804);
      return;
      if (!bu.isNullOrNil(str)) {
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