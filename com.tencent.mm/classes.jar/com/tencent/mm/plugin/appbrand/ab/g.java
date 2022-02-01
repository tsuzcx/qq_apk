package com.tencent.mm.plugin.appbrand.ab;

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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class g
{
  public static boolean RI(String paramString)
  {
    AppMethodBeat.i(210162);
    boolean bool = "wxfe02ecfe70800f46".equalsIgnoreCase(paramString);
    AppMethodBeat.o(210162);
    return bool;
  }
  
  static void a(ImageView paramImageView, String paramString1, final String paramString2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(49352);
    ac.i("MicroMsg.AppBrandWeishiUtil", "loadThumbImage:%s", new Object[] { paramString1 });
    com.tencent.mm.modelappbrand.a.b.aAS().a(new b.k()
    {
      public final String Ap()
      {
        return "AppBrandWeishiUtil#THUMB";
      }
      
      public final void E(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(49346);
        ac.i("MicroMsg.AppBrandWeishiUtil", "thumb loaded");
        ImageView localImageView = this.zz;
        if ((localImageView != null) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          localImageView.setImageBitmap(paramAnonymousBitmap);
        }
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        AppMethodBeat.o(49346);
      }
      
      public final void aBa() {}
      
      public final void of()
      {
        AppMethodBeat.i(49347);
        ac.e("MicroMsg.AppBrandWeishiUtil", "thumb loaded fail");
        if (paramString2 != null) {
          g.a(this.zz, paramString2, null, paramRunnable);
        }
        AppMethodBeat.o(49347);
      }
    }, paramString1, null, null);
    AppMethodBeat.o(49352);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, ImageView paramImageView)
  {
    AppMethodBeat.i(49351);
    if ((paramAppBrandRuntime.DJ() instanceof AppBrandInitConfigLU))
    {
      Object localObject = (AppBrandInitConfigLU)paramAppBrandRuntime.DJ();
      paramAppBrandRuntime = ((AppBrandInitConfigLU)localObject).ccf.thumbUrl;
      localObject = ((AppBrandInitConfigLU)localObject).ccf.jEo;
      ac.i("MicroMsg.AppBrandWeishiUtil", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", new Object[] { paramAppBrandRuntime, localObject });
      if (!bs.isNullOrNil(paramAppBrandRuntime))
      {
        a(paramImageView, paramAppBrandRuntime, "file://".concat(String.valueOf(localObject)), null);
        AppMethodBeat.o(49351);
        return;
      }
      if (!bs.isNullOrNil((String)localObject)) {
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
  
  public static void bxO()
  {
    AppMethodBeat.i(49353);
    ac.d("MicroMsg.AppBrandWeishiUtil", "sendEventAppBrandWeishiUIReady");
    if (ai.ciE())
    {
      bxP();
      AppMethodBeat.o(49353);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new IPCString("wxfe02ecfe70800f46"), a.class, new d() {});
    AppMethodBeat.o(49353);
  }
  
  static void bxP()
  {
    AppMethodBeat.i(49354);
    f localf = new f();
    a.GpY.l(localf);
    AppMethodBeat.o(49354);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.g
 * JD-Core Version:    0.7.0.1
 */