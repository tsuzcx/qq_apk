package com.tencent.luggage.game.b;

import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig.ReferrerPolicy;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.tencent.luggage.a.e;
import com.tencent.luggage.game.b.a.d.b;
import com.tencent.luggage.game.b.a.d.c;
import com.tencent.luggage.game.b.a.d.d;
import com.tencent.luggage.sdk.b.a.d.d;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.k;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class c
{
  public static final c ekG;
  private final int ekE = 2048;
  private final int ekF = 2048;
  private boolean ekt;
  private WeakReference<com.tencent.luggage.game.d.a.a.b> eku = null;
  
  static
  {
    AppMethodBeat.i(130469);
    ekG = new c();
    AppMethodBeat.o(130469);
  }
  
  public final void a(MBRuntime paramMBRuntime, AppBrandRuntime paramAppBrandRuntime, boolean paramBoolean)
  {
    AppMethodBeat.i(130465);
    this.ekt = paramBoolean;
    Log.i("MicroMsg.MBImageHandlerRegistry", "dl: MBImageHandlerRegistry register ");
    if ((paramBoolean) && (paramAppBrandRuntime != null) && ((paramAppBrandRuntime.ari() instanceof d))) {}
    for (com.tencent.luggage.game.d.a.a.b localb = (com.tencent.luggage.game.d.a.a.b)((d)paramAppBrandRuntime.ari()).aa(com.tencent.luggage.game.d.a.a.b.class);; localb = null)
    {
      this.eku = new WeakReference(localb);
      paramMBRuntime = paramMBRuntime.avq();
      paramAppBrandRuntime = new a(paramAppBrandRuntime, (byte)0);
      paramMBRuntime.addImageStreamFetcher(new com.tencent.luggage.game.b.a.a(paramAppBrandRuntime), true);
      paramMBRuntime.addImageStreamFetcher(new com.tencent.luggage.game.b.a.b(paramAppBrandRuntime), false);
      paramMBRuntime.addImageStreamFetcher(new com.tencent.luggage.game.b.a.c(paramAppBrandRuntime), false);
      paramMBRuntime.setKvReportDelegate(new b());
      paramAppBrandRuntime = new com.tencent.magicbrush.b.a();
      paramAppBrandRuntime.bX(2048, 2048);
      paramMBRuntime.setBitmapDecodeSlave(paramAppBrandRuntime);
      AppMethodBeat.o(130465);
      return;
    }
  }
  
  static final class a
    implements d.b, d.c, d.d
  {
    private final WeakReference<AppBrandRuntime> ekH;
    
    private a(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(220124);
      this.ekH = new WeakReference(paramAppBrandRuntime);
      AppMethodBeat.o(220124);
    }
    
    private static ImageDecodeConfig.ReferrerPolicy a(com.tencent.mm.plugin.appbrand.jsapi.y.c paramc)
    {
      if (paramc == null) {
        return ImageDecodeConfig.ReferrerPolicy.NOT_SET;
      }
      if (paramc == com.tencent.mm.plugin.appbrand.jsapi.y.c.srt) {
        return ImageDecodeConfig.ReferrerPolicy.NO_REFERRER;
      }
      if (paramc == com.tencent.mm.plugin.appbrand.jsapi.y.c.srs) {
        return ImageDecodeConfig.ReferrerPolicy.ORIGIN;
      }
      return ImageDecodeConfig.ReferrerPolicy.NOT_SET;
    }
    
    private int aoS()
    {
      AppMethodBeat.i(220127);
      Object localObject = (AppBrandRuntime)this.ekH.get();
      if (localObject == null)
      {
        AppMethodBeat.o(220127);
        return 0;
      }
      localObject = (com.tencent.mm.plugin.appbrand.t.a)((AppBrandRuntime)localObject).aN(com.tencent.mm.plugin.appbrand.t.a.class);
      if (localObject == null)
      {
        AppMethodBeat.o(220127);
        return 0;
      }
      int i = ((com.tencent.mm.plugin.appbrand.t.a)localObject).tnc;
      AppMethodBeat.o(220127);
      return i;
    }
    
    public final String a(ImageDecodeConfig.ReferrerPolicy paramReferrerPolicy)
    {
      AppMethodBeat.i(220140);
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.ekH.get();
      com.tencent.mm.plugin.appbrand.jsapi.y.a locala;
      if (localAppBrandRuntime != null)
      {
        locala = (com.tencent.mm.plugin.appbrand.jsapi.y.a)e.T(com.tencent.mm.plugin.appbrand.jsapi.y.a.class);
        if (locala != null)
        {
          ImageDecodeConfig.ReferrerPolicy localReferrerPolicy = paramReferrerPolicy;
          if (paramReferrerPolicy == ImageDecodeConfig.ReferrerPolicy.NOT_SET) {
            localReferrerPolicy = a(locala.C(localAppBrandRuntime.ari()));
          }
          paramReferrerPolicy = localReferrerPolicy;
          if (localReferrerPolicy == ImageDecodeConfig.ReferrerPolicy.NOT_SET) {
            paramReferrerPolicy = a(locala.cuq());
          }
          if (paramReferrerPolicy != ImageDecodeConfig.ReferrerPolicy.ORIGIN) {
            break label112;
          }
        }
      }
      label112:
      for (paramReferrerPolicy = locala.D(localAppBrandRuntime.ari());; paramReferrerPolicy = null)
      {
        AppMethodBeat.o(220140);
        return paramReferrerPolicy;
        Log.w("MicroMsg.ImageFetcherConfigImp", "referrer helper is null");
      }
    }
    
    public final String aoQ()
    {
      AppMethodBeat.i(220133);
      if (this.ekH.get() != null)
      {
        String str = ((AppBrandRuntime)this.ekH.get()).mAppId;
        AppMethodBeat.o(220133);
        return str;
      }
      AppMethodBeat.o(220133);
      return "";
    }
    
    public final int aoR()
    {
      AppMethodBeat.i(220135);
      int i = aoS();
      AppMethodBeat.o(220135);
      return i;
    }
    
    public final int aoT()
    {
      AppMethodBeat.i(220136);
      int i = aoS();
      AppMethodBeat.o(220136);
      return i;
    }
    
    public final k aoU()
    {
      AppMethodBeat.i(220142);
      if (this.ekH.get() != null)
      {
        k localk = (k)((AppBrandRuntime)this.ekH.get()).ari().getJsRuntime().Z(k.class);
        AppMethodBeat.o(220142);
        return localk;
      }
      AppMethodBeat.o(220142);
      return null;
    }
    
    public final w getFileSystem()
    {
      AppMethodBeat.i(220134);
      if (this.ekH.get() != null)
      {
        w localw = ((AppBrandRuntime)this.ekH.get()).getFileSystem();
        AppMethodBeat.o(220134);
        return localw;
      }
      AppMethodBeat.o(220134);
      return null;
    }
    
    public final String getUserAgentString()
    {
      AppMethodBeat.i(220138);
      Object localObject = (AppBrandRuntime)this.ekH.get();
      if (localObject == null)
      {
        AppMethodBeat.o(220138);
        return "";
      }
      localObject = (com.tencent.mm.plugin.appbrand.t.a)((AppBrandRuntime)localObject).aN(com.tencent.mm.plugin.appbrand.t.a.class);
      if (localObject == null)
      {
        AppMethodBeat.o(220138);
        return "";
      }
      localObject = ((com.tencent.mm.plugin.appbrand.t.a)localObject).tnh;
      AppMethodBeat.o(220138);
      return localObject;
    }
  }
  
  public static final class b
    implements com.github.henryye.nativeiv.a.c.b
  {
    private int ekI = 14883;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.b.c
 * JD-Core Version:    0.7.0.1
 */