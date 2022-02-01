package com.tencent.mm.plugin.appbrand.weishi;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
{
  static void a(ImageView paramImageView, String paramString1, final String paramString2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(49352);
    Log.i("MicroMsg.AppBrandWeishiUtil", "loadThumbImage:%s", new Object[] { paramString1 });
    b.bEY().a(new b.k()
    {
      public final void bFg() {}
      
      public final void bFh()
      {
        AppMethodBeat.i(49347);
        Log.e("MicroMsg.AppBrandWeishiUtil", "thumb loaded fail");
        if (paramString2 != null) {
          h.a(h.this, paramString2, null, paramRunnable);
        }
        AppMethodBeat.o(49347);
      }
      
      public final String key()
      {
        return "AppBrandWeishiUtil#THUMB";
      }
      
      public final void onBitmapLoaded(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(49346);
        Log.i("MicroMsg.AppBrandWeishiUtil", "thumb loaded");
        ImageView localImageView = h.this;
        if ((localImageView != null) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          localImageView.setImageBitmap(paramAnonymousBitmap);
        }
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        AppMethodBeat.o(49346);
      }
    }, paramString1, null, null);
    AppMethodBeat.o(49352);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, ImageView paramImageView, Runnable paramRunnable)
  {
    AppMethodBeat.i(317632);
    if ((paramAppBrandRuntime.asH() instanceof AppBrandInitConfigLU))
    {
      Object localObject = (AppBrandInitConfigLU)paramAppBrandRuntime.asH();
      paramAppBrandRuntime = ((AppBrandInitConfigLU)localObject).eoW.thumbUrl;
      localObject = ((AppBrandInitConfigLU)localObject).eoW.qZi;
      Log.i("MicroMsg.AppBrandWeishiUtil", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", new Object[] { paramAppBrandRuntime, localObject });
      if (!Util.isNullOrNil(paramAppBrandRuntime))
      {
        a(paramImageView, paramAppBrandRuntime, "file://".concat(String.valueOf(localObject)), paramRunnable);
        AppMethodBeat.o(317632);
        return;
      }
      if (!Util.isNullOrNil((String)localObject)) {
        a(paramImageView, "file://".concat(String.valueOf(localObject)), null, paramRunnable);
      }
    }
    AppMethodBeat.o(317632);
  }
  
  public static boolean aD(AppBrandRuntime paramAppBrandRuntime)
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
  
  public static void cOB()
  {
    AppMethodBeat.i(49353);
    Log.d("MicroMsg.AppBrandWeishiUtil", "sendEventAppBrandWeishiUIReady");
    if (MMApplicationContext.isMMProcess())
    {
      cOC();
      AppMethodBeat.o(49353);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString("wxfe02ecfe70800f46"), a.class, new f() {});
    AppMethodBeat.o(49353);
  }
  
  static void cOC()
  {
    AppMethodBeat.i(49354);
    new g().publish();
    AppMethodBeat.o(49354);
  }
  
  static class a
    implements d<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.weishi.h
 * JD-Core Version:    0.7.0.1
 */