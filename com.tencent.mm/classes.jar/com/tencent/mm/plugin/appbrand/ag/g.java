package com.tencent.mm.plugin.appbrand.ag;

import android.widget.ImageView;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
{
  static void a(ImageView paramImageView, String paramString1, String paramString2, Runnable paramRunnable)
  {
    AppMethodBeat.i(49352);
    Log.i("MicroMsg.AppBrandWeishiUtil", "loadThumbImage:%s", new Object[] { paramString1 });
    b.bhh().a(new g.1(paramImageView, paramRunnable, paramString2), paramString1, null, null);
    AppMethodBeat.o(49352);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, ImageView paramImageView, Runnable paramRunnable)
  {
    AppMethodBeat.i(280152);
    if ((paramAppBrandRuntime.Sq() instanceof AppBrandInitConfigLU))
    {
      Object localObject = (AppBrandInitConfigLU)paramAppBrandRuntime.Sq();
      paramAppBrandRuntime = ((AppBrandInitConfigLU)localObject).cwW.thumbUrl;
      localObject = ((AppBrandInitConfigLU)localObject).cwW.nZa;
      Log.i("MicroMsg.AppBrandWeishiUtil", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", new Object[] { paramAppBrandRuntime, localObject });
      if (!Util.isNullOrNil(paramAppBrandRuntime))
      {
        a(paramImageView, paramAppBrandRuntime, "file://".concat(String.valueOf(localObject)), paramRunnable);
        AppMethodBeat.o(280152);
        return;
      }
      if (!Util.isNullOrNil((String)localObject)) {
        a(paramImageView, "file://".concat(String.valueOf(localObject)), null, paramRunnable);
      }
    }
    AppMethodBeat.o(280152);
  }
  
  public static boolean anz(String paramString)
  {
    AppMethodBeat.i(293293);
    boolean bool = "wxfe02ecfe70800f46".equalsIgnoreCase(paramString);
    AppMethodBeat.o(293293);
    return bool;
  }
  
  public static boolean ap(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(49349);
    if (paramAppBrandRuntime != null)
    {
      boolean bool = "wxfe02ecfe70800f46".equalsIgnoreCase(paramAppBrandRuntime.mAppId);
      AppMethodBeat.o(49349);
      return bool;
    }
    AppMethodBeat.o(49349);
    return false;
  }
  
  public static String cmM()
  {
    return "appbrand0";
  }
  
  public static void cmN()
  {
    AppMethodBeat.i(49353);
    Log.d("MicroMsg.AppBrandWeishiUtil", "sendEventAppBrandWeishiUIReady");
    if (MMApplicationContext.isMMProcess())
    {
      cmO();
      AppMethodBeat.o(49353);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString("wxfe02ecfe70800f46"), g.a.class, new com.tencent.mm.ipcinvoker.f() {});
    AppMethodBeat.o(49353);
  }
  
  static void cmO()
  {
    AppMethodBeat.i(49354);
    f localf = new f();
    EventCenter.instance.publish(localf);
    AppMethodBeat.o(49354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.g
 * JD-Core Version:    0.7.0.1
 */