package com.tencent.luggage.game.b;

import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig.ReferrerPolicy;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.tencent.luggage.a.e;
import com.tencent.luggage.game.b.a.d.b;
import com.tencent.luggage.game.b.a.d.c;
import com.tencent.luggage.game.b.a.d.d;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class c
{
  public static final c csM;
  private WeakReference<com.tencent.luggage.game.d.a.a.b> csA = null;
  private final int csK = 2048;
  private final int csL = 2048;
  private boolean csz;
  
  static
  {
    AppMethodBeat.i(130469);
    csM = new c();
    AppMethodBeat.o(130469);
  }
  
  public final void a(MBRuntime paramMBRuntime, AppBrandRuntime paramAppBrandRuntime, boolean paramBoolean)
  {
    AppMethodBeat.i(130465);
    this.csz = paramBoolean;
    Log.i("MicroMsg.MBImageHandlerRegistry", "dl: MBImageHandlerRegistry register ");
    if ((paramBoolean) && (paramAppBrandRuntime != null) && ((paramAppBrandRuntime.QW() instanceof d))) {}
    for (com.tencent.luggage.game.d.a.a.b localb = (com.tencent.luggage.game.d.a.a.b)((d)paramAppBrandRuntime.QW()).R(com.tencent.luggage.game.d.a.a.b.class);; localb = null)
    {
      this.csA = new WeakReference(localb);
      paramMBRuntime = paramMBRuntime.UN();
      paramAppBrandRuntime = new a(paramAppBrandRuntime, (byte)0);
      paramMBRuntime.addImageStreamFetcher(new com.tencent.luggage.game.b.a.a(paramAppBrandRuntime), true);
      paramMBRuntime.addImageStreamFetcher(new com.tencent.luggage.game.b.a.b(paramAppBrandRuntime), false);
      paramMBRuntime.addImageStreamFetcher(new com.tencent.luggage.game.b.a.c(paramAppBrandRuntime), false);
      paramMBRuntime.setKvReportDelegate(new b());
      paramAppBrandRuntime = new com.tencent.magicbrush.b.a();
      paramAppBrandRuntime.bc(2048, 2048);
      paramMBRuntime.setBitmapDecodeSlave(paramAppBrandRuntime);
      AppMethodBeat.o(130465);
      return;
    }
  }
  
  static final class a
    implements d.b, d.c, d.d
  {
    private final WeakReference<AppBrandRuntime> csN;
    
    private a(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(246905);
      this.csN = new WeakReference(paramAppBrandRuntime);
      AppMethodBeat.o(246905);
    }
    
    private int OK()
    {
      AppMethodBeat.i(246913);
      Object localObject = (AppBrandRuntime)this.csN.get();
      if (localObject == null)
      {
        AppMethodBeat.o(246913);
        return 0;
      }
      localObject = (com.tencent.mm.plugin.appbrand.s.a)((AppBrandRuntime)localObject).au(com.tencent.mm.plugin.appbrand.s.a.class);
      if (localObject == null)
      {
        AppMethodBeat.o(246913);
        return 0;
      }
      int i = ((com.tencent.mm.plugin.appbrand.s.a)localObject).qiq;
      AppMethodBeat.o(246913);
      return i;
    }
    
    private static ImageDecodeConfig.ReferrerPolicy a(com.tencent.mm.plugin.appbrand.jsapi.v.c paramc)
    {
      if (paramc == null) {
        return ImageDecodeConfig.ReferrerPolicy.NOT_SET;
      }
      if (paramc == com.tencent.mm.plugin.appbrand.jsapi.v.c.pmz) {
        return ImageDecodeConfig.ReferrerPolicy.NO_REFERRER;
      }
      if (paramc == com.tencent.mm.plugin.appbrand.jsapi.v.c.pmy) {
        return ImageDecodeConfig.ReferrerPolicy.ORIGIN;
      }
      return ImageDecodeConfig.ReferrerPolicy.NOT_SET;
    }
    
    public final String OI()
    {
      AppMethodBeat.i(246907);
      if (this.csN.get() != null)
      {
        String str = ((AppBrandRuntime)this.csN.get()).mAppId;
        AppMethodBeat.o(246907);
        return str;
      }
      AppMethodBeat.o(246907);
      return "";
    }
    
    public final int OJ()
    {
      AppMethodBeat.i(246911);
      int i = OK();
      AppMethodBeat.o(246911);
      return i;
    }
    
    public final int OL()
    {
      AppMethodBeat.i(246914);
      int i = OK();
      AppMethodBeat.o(246914);
      return i;
    }
    
    public final k OM()
    {
      AppMethodBeat.i(246921);
      if (this.csN.get() != null)
      {
        k localk = (k)((AppBrandRuntime)this.csN.get()).QW().getJsRuntime().Q(k.class);
        AppMethodBeat.o(246921);
        return localk;
      }
      AppMethodBeat.o(246921);
      return null;
    }
    
    public final String a(ImageDecodeConfig.ReferrerPolicy paramReferrerPolicy)
    {
      AppMethodBeat.i(246918);
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.csN.get();
      com.tencent.mm.plugin.appbrand.jsapi.v.a locala;
      if (localAppBrandRuntime != null)
      {
        locala = (com.tencent.mm.plugin.appbrand.jsapi.v.a)e.K(com.tencent.mm.plugin.appbrand.jsapi.v.a.class);
        if (locala != null)
        {
          ImageDecodeConfig.ReferrerPolicy localReferrerPolicy = paramReferrerPolicy;
          if (paramReferrerPolicy == ImageDecodeConfig.ReferrerPolicy.NOT_SET) {
            localReferrerPolicy = a(locala.A(localAppBrandRuntime.QW()));
          }
          paramReferrerPolicy = localReferrerPolicy;
          if (localReferrerPolicy == ImageDecodeConfig.ReferrerPolicy.NOT_SET) {
            paramReferrerPolicy = a(locala.bUd());
          }
          if (paramReferrerPolicy != ImageDecodeConfig.ReferrerPolicy.ORIGIN) {
            break label112;
          }
        }
      }
      label112:
      for (paramReferrerPolicy = locala.B(localAppBrandRuntime.QW());; paramReferrerPolicy = null)
      {
        AppMethodBeat.o(246918);
        return paramReferrerPolicy;
        Log.w("MicroMsg.ImageFetcherConfigImp", "referrer helper is null");
      }
    }
    
    public final r getFileSystem()
    {
      AppMethodBeat.i(246910);
      if (this.csN.get() != null)
      {
        r localr = ((AppBrandRuntime)this.csN.get()).getFileSystem();
        AppMethodBeat.o(246910);
        return localr;
      }
      AppMethodBeat.o(246910);
      return null;
    }
    
    public final String getUserAgentString()
    {
      AppMethodBeat.i(246915);
      Object localObject = (AppBrandRuntime)this.csN.get();
      if (localObject == null)
      {
        AppMethodBeat.o(246915);
        return "";
      }
      localObject = (com.tencent.mm.plugin.appbrand.s.a)((AppBrandRuntime)localObject).au(com.tencent.mm.plugin.appbrand.s.a.class);
      if (localObject == null)
      {
        AppMethodBeat.o(246915);
        return "";
      }
      localObject = ((com.tencent.mm.plugin.appbrand.s.a)localObject).qiv;
      AppMethodBeat.o(246915);
      return localObject;
    }
  }
  
  public static final class b
    implements com.github.henryye.nativeiv.a.c.b
  {
    private int csO = 14883;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.b.c
 * JD-Core Version:    0.7.0.1
 */