package com.tencent.mm.plugin.appbrand.ac;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
{
  public static boolean Nz(String paramString)
  {
    AppMethodBeat.i(205047);
    boolean bool = "wxfe02ecfe70800f46".equalsIgnoreCase(paramString);
    AppMethodBeat.o(205047);
    return bool;
  }
  
  static void a(ImageView paramImageView, String paramString1, final String paramString2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(49352);
    ad.i("MicroMsg.AppBrandWeishiUtil", "loadThumbImage:%s", new Object[] { paramString1 });
    com.tencent.mm.modelappbrand.a.b.aub().a(new b.k()
    {
      public final String AL()
      {
        return "AppBrandWeishiUtil#THUMB";
      }
      
      public final void E(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(49346);
        ad.i("MicroMsg.AppBrandWeishiUtil", "thumb loaded");
        ImageView localImageView = this.yz;
        if ((localImageView != null) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          localImageView.setImageBitmap(paramAnonymousBitmap);
        }
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        AppMethodBeat.o(49346);
      }
      
      public final void auj() {}
      
      public final void nV()
      {
        AppMethodBeat.i(49347);
        ad.e("MicroMsg.AppBrandWeishiUtil", "thumb loaded fail");
        if (paramString2 != null) {
          g.a(this.yz, paramString2, null, paramRunnable);
        }
        AppMethodBeat.o(49347);
      }
    }, paramString1, null, null);
    AppMethodBeat.o(49352);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, ImageView paramImageView)
  {
    AppMethodBeat.i(49351);
    if ((paramAppBrandRuntime.Eg() instanceof AppBrandInitConfigLU))
    {
      Object localObject = (AppBrandInitConfigLU)paramAppBrandRuntime.Eg();
      paramAppBrandRuntime = ((AppBrandInitConfigLU)localObject).cfj.thumbUrl;
      localObject = ((AppBrandInitConfigLU)localObject).cfj.jea;
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
  
  public static boolean as(AppBrandRuntime paramAppBrandRuntime)
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
  
  public static void bqO()
  {
    AppMethodBeat.i(49353);
    ad.d("MicroMsg.AppBrandWeishiUtil", "sendEventAppBrandWeishiUIReady");
    if (aj.cbv())
    {
      bqP();
      AppMethodBeat.o(49353);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new IPCString("wxfe02ecfe70800f46"), a.class, new d() {});
    AppMethodBeat.o(49353);
  }
  
  static void bqP()
  {
    AppMethodBeat.i(49354);
    f localf = new f();
    a.ESL.l(localf);
    AppMethodBeat.o(49354);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.g
 * JD-Core Version:    0.7.0.1
 */