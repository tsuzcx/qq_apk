package com.tencent.mm.plugin.appbrand.af;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
{
  static void a(ImageView paramImageView, String paramString1, final String paramString2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(49352);
    Log.i("MicroMsg.AppBrandWeishiUtil", "loadThumbImage:%s", new Object[] { paramString1 });
    com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k()
    {
      public final void I(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(49346);
        Log.i("MicroMsg.AppBrandWeishiUtil", "thumb loaded");
        ImageView localImageView = this.Bw;
        if ((localImageView != null) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          localImageView.setImageBitmap(paramAnonymousBitmap);
        }
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        AppMethodBeat.o(49346);
      }
      
      public final String Lb()
      {
        return "AppBrandWeishiUtil#THUMB";
      }
      
      public final void aYg() {}
      
      public final void oD()
      {
        AppMethodBeat.i(49347);
        Log.e("MicroMsg.AppBrandWeishiUtil", "thumb loaded fail");
        if (paramString2 != null) {
          g.a(this.Bw, paramString2, null, paramRunnable);
        }
        AppMethodBeat.o(49347);
      }
    }, paramString1, null, null);
    AppMethodBeat.o(49352);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, ImageView paramImageView, Runnable paramRunnable)
  {
    AppMethodBeat.i(227749);
    if ((paramAppBrandRuntime.OU() instanceof AppBrandInitConfigLU))
    {
      Object localObject = (AppBrandInitConfigLU)paramAppBrandRuntime.OU();
      paramAppBrandRuntime = ((AppBrandInitConfigLU)localObject).cyt.thumbUrl;
      localObject = ((AppBrandInitConfigLU)localObject).cyt.leN;
      Log.i("MicroMsg.AppBrandWeishiUtil", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", new Object[] { paramAppBrandRuntime, localObject });
      if (!Util.isNullOrNil(paramAppBrandRuntime))
      {
        a(paramImageView, paramAppBrandRuntime, "file://".concat(String.valueOf(localObject)), paramRunnable);
        AppMethodBeat.o(227749);
        return;
      }
      if (!Util.isNullOrNil((String)localObject)) {
        a(paramImageView, "file://".concat(String.valueOf(localObject)), null, paramRunnable);
      }
    }
    AppMethodBeat.o(227749);
  }
  
  public static boolean afU(String paramString)
  {
    AppMethodBeat.i(258367);
    boolean bool = "wxfe02ecfe70800f46".equalsIgnoreCase(paramString);
    AppMethodBeat.o(258367);
    return bool;
  }
  
  public static boolean an(AppBrandRuntime paramAppBrandRuntime)
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
  
  public static String bZR()
  {
    return "appbrand0";
  }
  
  public static void bZS()
  {
    AppMethodBeat.i(49353);
    Log.d("MicroMsg.AppBrandWeishiUtil", "sendEventAppBrandWeishiUIReady");
    if (MMApplicationContext.isMMProcess())
    {
      bZT();
      AppMethodBeat.o(49353);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString("wxfe02ecfe70800f46"), a.class, new d() {});
    AppMethodBeat.o(49353);
  }
  
  static void bZT()
  {
    AppMethodBeat.i(49354);
    f localf = new f();
    EventCenter.instance.publish(localf);
    AppMethodBeat.o(49354);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.g
 * JD-Core Version:    0.7.0.1
 */