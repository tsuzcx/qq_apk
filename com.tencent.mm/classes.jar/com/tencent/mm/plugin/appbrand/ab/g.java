package com.tencent.mm.plugin.appbrand.ab;

import android.widget.ImageView;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
{
  public static boolean Vn(String paramString)
  {
    AppMethodBeat.i(221312);
    boolean bool = "wxfe02ecfe70800f46".equalsIgnoreCase(paramString);
    AppMethodBeat.o(221312);
    return bool;
  }
  
  static void a(ImageView paramImageView, String paramString1, String paramString2, Runnable paramRunnable)
  {
    AppMethodBeat.i(49352);
    ad.i("MicroMsg.AppBrandWeishiUtil", "loadThumbImage:%s", new Object[] { paramString1 });
    b.aDV().a(new g.1(paramImageView, paramRunnable, paramString2), paramString1, null, null);
    AppMethodBeat.o(49352);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, ImageView paramImageView)
  {
    AppMethodBeat.i(49351);
    if ((paramAppBrandRuntime.Fi() instanceof AppBrandInitConfigLU))
    {
      Object localObject = (AppBrandInitConfigLU)paramAppBrandRuntime.Fi();
      paramAppBrandRuntime = ((AppBrandInitConfigLU)localObject).cmw.thumbUrl;
      localObject = ((AppBrandInitConfigLU)localObject).cmw.jYq;
      ad.i("MicroMsg.AppBrandWeishiUtil", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", new Object[] { paramAppBrandRuntime, localObject });
      if (!bt.isNullOrNil(paramAppBrandRuntime))
      {
        a(paramImageView, paramAppBrandRuntime, "file://".concat(String.valueOf(localObject)), null);
        AppMethodBeat.o(49351);
        return;
      }
      if (!bt.isNullOrNil((String)localObject)) {
        a(paramImageView, "file://".concat(String.valueOf(localObject)), null, null);
      }
    }
    AppMethodBeat.o(49351);
  }
  
  public static boolean am(AppBrandRuntime paramAppBrandRuntime)
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
  
  public static void bBT()
  {
    AppMethodBeat.i(49353);
    ad.d("MicroMsg.AppBrandWeishiUtil", "sendEventAppBrandWeishiUIReady");
    if (aj.cnC())
    {
      bBU();
      AppMethodBeat.o(49353);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new IPCString("wxfe02ecfe70800f46"), g.a.class, new d() {});
    AppMethodBeat.o(49353);
  }
  
  static void bBU()
  {
    AppMethodBeat.i(49354);
    f localf = new f();
    a.IbL.l(localf);
    AppMethodBeat.o(49354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.g
 * JD-Core Version:    0.7.0.1
 */