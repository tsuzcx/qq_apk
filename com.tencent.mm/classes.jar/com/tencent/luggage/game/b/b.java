package com.tencent.luggage.game.b;

import android.content.Context;
import android.text.TextUtils;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.ImageDecodeConfig.ReferrerPolicy;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.b.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.c;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.luggage.game.b.a.c.c;
import com.tencent.luggage.game.c.e.a;
import com.tencent.luggage.game.e.a.4;
import com.tencent.luggage.game.e.a.6;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.u.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b
  implements IImageDecodeService.b
{
  public static final b cux;
  private final int cuv = 2048;
  private final int cuw = 2048;
  private boolean cuy;
  private WeakReference<com.tencent.luggage.game.d.a.a.b> cuz = null;
  
  static
  {
    AppMethodBeat.i(130469);
    cux = new b();
    AppMethodBeat.o(130469);
  }
  
  private void a(String paramString1, e.a parama, String paramString2)
  {
    AppMethodBeat.i(130467);
    if (this.cuz.get() != null) {
      ((com.tencent.luggage.game.d.a.a.b)this.cuz.get()).Mg().a(parama, paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(130467);
  }
  
  private static void hG(int paramInt)
  {
    AppMethodBeat.i(130468);
    ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(807L, paramInt, 1L, false);
    AppMethodBeat.o(130468);
  }
  
  public final void a(MBRuntime paramMBRuntime, AppBrandRuntime paramAppBrandRuntime, boolean paramBoolean)
  {
    AppMethodBeat.i(130465);
    this.cuy = paramBoolean;
    Log.i("MicroMsg.MBImageHandlerRegistry", "dl: MBImageHandlerRegistry register ");
    if ((paramBoolean) && (paramAppBrandRuntime != null) && ((paramAppBrandRuntime.NY() instanceof d))) {}
    for (com.tencent.luggage.game.d.a.a.b localb = (com.tencent.luggage.game.d.a.a.b)((d)paramAppBrandRuntime.NY()).S(com.tencent.luggage.game.d.a.a.b.class);; localb = null)
    {
      this.cuz = new WeakReference(localb);
      paramMBRuntime = paramMBRuntime.Rg();
      paramAppBrandRuntime = new a(paramAppBrandRuntime, (byte)0);
      paramMBRuntime.addImageStreamFetcher(new com.tencent.luggage.game.b.a.a(paramAppBrandRuntime), true);
      paramMBRuntime.addImageStreamFetcher(new com.tencent.luggage.game.b.a.b(paramAppBrandRuntime), false);
      paramMBRuntime.setKvReportDelegate(new b());
      paramAppBrandRuntime = new com.tencent.magicbrush.b.a();
      paramAppBrandRuntime.aW(2048, 2048);
      paramMBRuntime.setBitmapDecodeSlave(paramAppBrandRuntime);
      paramMBRuntime.addDecodeEventListener(this);
      AppMethodBeat.o(130465);
      return;
    }
  }
  
  public final void a(String paramString, IImageDecodeService.b.a parama, com.github.henryye.nativeiv.api.a parama1)
  {
    AppMethodBeat.i(130466);
    switch (b.1.cuA[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130466);
      return;
      parama = com.tencent.luggage.game.e.a.Nn();
      long l1 = parama1.baM;
      long l2 = parama1.baN;
      h.RTc.aX(new a.4(parama, l1));
      parama.cxF.add(Long.valueOf(l2));
      h.RTc.aX(new a.6(parama, paramString, parama1));
      if (parama1.baN >= 1000L)
      {
        hG(11);
        AppMethodBeat.o(130466);
        return;
        if (TextUtils.isEmpty(parama1.baP)) {
          a(paramString, e.a.cvp, MMApplicationContext.getContext().getString(2131756063));
        }
        for (;;)
        {
          hG(7);
          AppMethodBeat.o(130466);
          return;
          a(paramString, e.a.cvp, String.format("%s: %s", new Object[] { MMApplicationContext.getContext().getString(2131756063), parama1.baP }));
        }
        a(paramString, e.a.cvp, MMApplicationContext.getContext().getString(2131756064));
        hG(5);
        AppMethodBeat.o(130466);
        return;
        a(paramString, e.a.cvp, MMApplicationContext.getContext().getString(2131756059));
        hG(0);
        AppMethodBeat.o(130466);
        return;
        a(paramString, e.a.cvp, String.format(MMApplicationContext.getContext().getString(2131756065), new Object[] { Integer.valueOf(parama1.mMaxWidth), Integer.valueOf(parama1.mMaxHeight), Long.valueOf(parama1.mWidth), Long.valueOf(parama1.mHeight) }));
        hG(3);
        AppMethodBeat.o(130466);
        return;
        Log.e("MicroMsg.MBImageHandlerRegistry", "IOEXCEPTION path:%s", new Object[] { paramString });
        a(paramString, e.a.cvp, MMApplicationContext.getContext().getString(2131756060));
        hG(4);
        AppMethodBeat.o(130466);
        return;
        Log.e("MicroMsg.MBImageHandlerRegistry", "OUT_OF_MEMORY path:%s", new Object[] { paramString });
        a(paramString, e.a.cvp, MMApplicationContext.getContext().getString(2131756061));
        hG(1);
        AppMethodBeat.o(130466);
        return;
        Log.e("MicroMsg.MBImageHandlerRegistry", "NATIVE_DECODE_ERROR path:%s", new Object[] { paramString });
        a(paramString, e.a.cvp, MMApplicationContext.getContext().getString(2131756056));
        hG(5);
        AppMethodBeat.o(130466);
        return;
        Log.e("MicroMsg.MBImageHandlerRegistry", "THROW_EXCEPTION path:%s", new Object[] { paramString });
        a(paramString, e.a.cvp, MMApplicationContext.getContext().getString(2131756062));
        hG(16);
        AppMethodBeat.o(130466);
        return;
        Log.i("MicroMsg.MBImageHandlerRegistry", "USE_LEGACY path:%s", new Object[] { paramString });
        hG(8);
      }
    }
  }
  
  public final void a(String paramString, Object paramObject, IImageDecodeService.c paramc, ImageDecodeConfig paramImageDecodeConfig) {}
  
  static final class a
    implements com.tencent.luggage.game.b.a.c.b, c.c
  {
    private final WeakReference<AppBrandRuntime> cuB;
    
    private a(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(222859);
      this.cuB = new WeakReference(paramAppBrandRuntime);
      AppMethodBeat.o(222859);
    }
    
    private int LT()
    {
      AppMethodBeat.i(222863);
      Object localObject = (AppBrandRuntime)this.cuB.get();
      if (localObject == null)
      {
        AppMethodBeat.o(222863);
        return 0;
      }
      localObject = (com.tencent.mm.plugin.appbrand.s.a)((AppBrandRuntime)localObject).av(com.tencent.mm.plugin.appbrand.s.a.class);
      if (localObject == null)
      {
        AppMethodBeat.o(222863);
        return 0;
      }
      int i = ((com.tencent.mm.plugin.appbrand.s.a)localObject).nhH;
      AppMethodBeat.o(222863);
      return i;
    }
    
    private static ImageDecodeConfig.ReferrerPolicy a(c paramc)
    {
      if (paramc == null) {
        return ImageDecodeConfig.ReferrerPolicy.NOT_SET;
      }
      if (paramc == c.mou) {
        return ImageDecodeConfig.ReferrerPolicy.NO_REFERRER;
      }
      if (paramc == c.mot) {
        return ImageDecodeConfig.ReferrerPolicy.ORIGIN;
      }
      return ImageDecodeConfig.ReferrerPolicy.NOT_SET;
    }
    
    public final String LR()
    {
      AppMethodBeat.i(222860);
      if (this.cuB.get() != null)
      {
        String str = ((AppBrandRuntime)this.cuB.get()).mAppId;
        AppMethodBeat.o(222860);
        return str;
      }
      AppMethodBeat.o(222860);
      return "";
    }
    
    public final int LS()
    {
      AppMethodBeat.i(222862);
      int i = LT();
      AppMethodBeat.o(222862);
      return i;
    }
    
    public final int LU()
    {
      AppMethodBeat.i(222864);
      int i = LT();
      AppMethodBeat.o(222864);
      return i;
    }
    
    public final String a(ImageDecodeConfig.ReferrerPolicy paramReferrerPolicy)
    {
      AppMethodBeat.i(222866);
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.cuB.get();
      com.tencent.mm.plugin.appbrand.jsapi.u.a locala;
      if (localAppBrandRuntime != null)
      {
        locala = (com.tencent.mm.plugin.appbrand.jsapi.u.a)com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.u.a.class);
        if (locala != null)
        {
          ImageDecodeConfig.ReferrerPolicy localReferrerPolicy = paramReferrerPolicy;
          if (paramReferrerPolicy == ImageDecodeConfig.ReferrerPolicy.NOT_SET) {
            localReferrerPolicy = a(locala.x(localAppBrandRuntime.NY()));
          }
          paramReferrerPolicy = localReferrerPolicy;
          if (localReferrerPolicy == ImageDecodeConfig.ReferrerPolicy.NOT_SET) {
            paramReferrerPolicy = a(locala.bIw());
          }
          if (paramReferrerPolicy != ImageDecodeConfig.ReferrerPolicy.ORIGIN) {
            break label112;
          }
        }
      }
      label112:
      for (paramReferrerPolicy = locala.y(localAppBrandRuntime.NY());; paramReferrerPolicy = null)
      {
        AppMethodBeat.o(222866);
        return paramReferrerPolicy;
        Log.w("MicroMsg.ImageFetcherConfigImp", "referrer helper is null");
      }
    }
    
    public final q getFileSystem()
    {
      AppMethodBeat.i(222861);
      if (this.cuB.get() != null)
      {
        q localq = ((AppBrandRuntime)this.cuB.get()).getFileSystem();
        AppMethodBeat.o(222861);
        return localq;
      }
      AppMethodBeat.o(222861);
      return null;
    }
    
    public final String getUserAgentString()
    {
      AppMethodBeat.i(222865);
      Object localObject = (AppBrandRuntime)this.cuB.get();
      if (localObject == null)
      {
        AppMethodBeat.o(222865);
        return "";
      }
      localObject = (com.tencent.mm.plugin.appbrand.s.a)((AppBrandRuntime)localObject).av(com.tencent.mm.plugin.appbrand.s.a.class);
      if (localObject == null)
      {
        AppMethodBeat.o(222865);
        return "";
      }
      localObject = ((com.tencent.mm.plugin.appbrand.s.a)localObject).nhM;
      AppMethodBeat.o(222865);
      return localObject;
    }
  }
  
  public static final class b
    implements com.github.henryye.nativeiv.a.c.b
  {
    private int cuC = 14883;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.b.b
 * JD-Core Version:    0.7.0.1
 */