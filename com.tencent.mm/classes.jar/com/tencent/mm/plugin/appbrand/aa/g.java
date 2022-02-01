package com.tencent.mm.plugin.appbrand.aa;

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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class g
{
  public static boolean VY(String paramString)
  {
    AppMethodBeat.i(224375);
    boolean bool = "wxfe02ecfe70800f46".equalsIgnoreCase(paramString);
    AppMethodBeat.o(224375);
    return bool;
  }
  
  static void a(ImageView paramImageView, String paramString1, final String paramString2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(49352);
    ae.i("MicroMsg.AppBrandWeishiUtil", "loadThumbImage:%s", new Object[] { paramString1 });
    com.tencent.mm.modelappbrand.a.b.aEl().a(new b.k()
    {
      public final String BN()
      {
        return "AppBrandWeishiUtil#THUMB";
      }
      
      public final void F(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(49346);
        ae.i("MicroMsg.AppBrandWeishiUtil", "thumb loaded");
        ImageView localImageView = this.Bq;
        if ((localImageView != null) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          localImageView.setImageBitmap(paramAnonymousBitmap);
        }
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        AppMethodBeat.o(49346);
      }
      
      public final void aEt() {}
      
      public final void ox()
      {
        AppMethodBeat.i(49347);
        ae.e("MicroMsg.AppBrandWeishiUtil", "thumb loaded fail");
        if (paramString2 != null) {
          g.a(this.Bq, paramString2, null, paramRunnable);
        }
        AppMethodBeat.o(49347);
      }
    }, paramString1, null, null);
    AppMethodBeat.o(49352);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, ImageView paramImageView)
  {
    AppMethodBeat.i(49351);
    if ((paramAppBrandRuntime.Fn() instanceof AppBrandInitConfigLU))
    {
      Object localObject = (AppBrandInitConfigLU)paramAppBrandRuntime.Fn();
      paramAppBrandRuntime = ((AppBrandInitConfigLU)localObject).cmy.thumbUrl;
      localObject = ((AppBrandInitConfigLU)localObject).cmy.kbF;
      ae.i("MicroMsg.AppBrandWeishiUtil", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", new Object[] { paramAppBrandRuntime, localObject });
      if (!bu.isNullOrNil(paramAppBrandRuntime))
      {
        a(paramImageView, paramAppBrandRuntime, "file://".concat(String.valueOf(localObject)), null);
        AppMethodBeat.o(49351);
        return;
      }
      if (!bu.isNullOrNil((String)localObject)) {
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
  
  public static void bCN()
  {
    AppMethodBeat.i(49353);
    ae.d("MicroMsg.AppBrandWeishiUtil", "sendEventAppBrandWeishiUIReady");
    if (ak.cpe())
    {
      bCO();
      AppMethodBeat.o(49353);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new IPCString("wxfe02ecfe70800f46"), a.class, new d() {});
    AppMethodBeat.o(49353);
  }
  
  static void bCO()
  {
    AppMethodBeat.i(49354);
    f localf = new f();
    a.IvT.l(localf);
    AppMethodBeat.o(49354);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.g
 * JD-Core Version:    0.7.0.1
 */