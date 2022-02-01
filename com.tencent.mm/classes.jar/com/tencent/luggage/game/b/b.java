package com.tencent.luggage.game.b;

import android.content.Context;
import android.text.TextUtils;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.ImageDecodeConfig.ReferrerPolicy;
import com.github.henryye.nativeiv.a.c.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.b.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.c;
import com.tencent.e.h;
import com.tencent.luggage.game.c.e.a;
import com.tencent.luggage.game.e.a.4;
import com.tencent.luggage.game.e.a.6;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.io.BufferedInputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b
  implements IImageDecodeService.b
{
  public static final b bYj;
  private final int bYh = 2048;
  private final int bYi = 2048;
  private boolean bYk;
  private WeakReference<com.tencent.luggage.game.d.a.a.b> bYl = null;
  
  static
  {
    AppMethodBeat.i(130469);
    bYj = new b();
    AppMethodBeat.o(130469);
  }
  
  private void a(String paramString1, e.a parama, String paramString2)
  {
    AppMethodBeat.i(130467);
    if (this.bYl.get() != null) {
      ((com.tencent.luggage.game.d.a.a.b)this.bYl.get()).Bi().a(parama, paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(130467);
  }
  
  private static void gp(int paramInt)
  {
    AppMethodBeat.i(130468);
    ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(807L, paramInt, 1L, false);
    AppMethodBeat.o(130468);
  }
  
  public final void a(MBRuntime paramMBRuntime, AppBrandRuntime paramAppBrandRuntime, boolean paramBoolean)
  {
    AppMethodBeat.i(130465);
    this.bYk = paramBoolean;
    ac.i("MicroMsg.MBImageHandlerRegistry", "dl: MBImageHandlerRegistry register ");
    if ((paramBoolean) && (paramAppBrandRuntime != null) && ((paramAppBrandRuntime.CX() instanceof com.tencent.luggage.sdk.b.a.c.c))) {}
    for (com.tencent.luggage.game.d.a.a.b localb = (com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c.c)paramAppBrandRuntime.CX()).Q(com.tencent.luggage.game.d.a.a.b.class);; localb = null)
    {
      this.bYl = new WeakReference(localb);
      paramMBRuntime = paramMBRuntime.FO();
      paramMBRuntime.addImageStreamFetcher(new a(paramAppBrandRuntime, (byte)0), true);
      paramMBRuntime.addImageStreamFetcher(new b(paramAppBrandRuntime), false);
      paramMBRuntime.setKvReportDelegate(new c());
      paramAppBrandRuntime = new com.github.henryye.nativeiv.c();
      paramAppBrandRuntime.ba(2048, 2048);
      paramMBRuntime.setBitmapDecodeSlave(paramAppBrandRuntime);
      paramMBRuntime.addDecodeEventListener(this);
      AppMethodBeat.o(130465);
      return;
    }
  }
  
  public final void a(String paramString, IImageDecodeService.b.a parama, com.github.henryye.nativeiv.api.a parama1)
  {
    AppMethodBeat.i(130466);
    switch (1.bYm[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130466);
      return;
      parama = com.tencent.luggage.game.e.a.Cp();
      long l1 = parama1.aQw;
      long l2 = parama1.aQx;
      h.JZN.aS(new a.4(parama, l1));
      parama.cbr.add(Long.valueOf(l2));
      h.JZN.aS(new a.6(parama, paramString, parama1));
      if (parama1.aQx >= 1000L)
      {
        gp(11);
        AppMethodBeat.o(130466);
        return;
        if (TextUtils.isEmpty(parama1.aQz)) {
          a(paramString, e.a.bYZ, ai.getContext().getString(2131755963));
        }
        for (;;)
        {
          gp(7);
          AppMethodBeat.o(130466);
          return;
          a(paramString, e.a.bYZ, String.format("%s: %s", new Object[] { ai.getContext().getString(2131755963), parama1.aQz }));
        }
        a(paramString, e.a.bYZ, ai.getContext().getString(2131755964));
        gp(5);
        AppMethodBeat.o(130466);
        return;
        a(paramString, e.a.bYZ, ai.getContext().getString(2131755959));
        gp(0);
        AppMethodBeat.o(130466);
        return;
        a(paramString, e.a.bYZ, String.format(ai.getContext().getString(2131755965), new Object[] { Integer.valueOf(parama1.mMaxWidth), Integer.valueOf(parama1.mMaxHeight), Long.valueOf(parama1.mWidth), Long.valueOf(parama1.mHeight) }));
        gp(3);
        AppMethodBeat.o(130466);
        return;
        ac.e("MicroMsg.MBImageHandlerRegistry", "IOEXCEPTION path:%s", new Object[] { paramString });
        a(paramString, e.a.bYZ, ai.getContext().getString(2131755960));
        gp(4);
        AppMethodBeat.o(130466);
        return;
        ac.e("MicroMsg.MBImageHandlerRegistry", "OUT_OF_MEMORY path:%s", new Object[] { paramString });
        a(paramString, e.a.bYZ, ai.getContext().getString(2131755961));
        gp(1);
        AppMethodBeat.o(130466);
        return;
        ac.e("MicroMsg.MBImageHandlerRegistry", "NATIVE_DECODE_ERROR path:%s", new Object[] { paramString });
        a(paramString, e.a.bYZ, ai.getContext().getString(2131755956));
        gp(5);
        AppMethodBeat.o(130466);
        return;
        ac.i("MicroMsg.MBImageHandlerRegistry", "USE_LEGACY path:%s", new Object[] { paramString });
        gp(8);
      }
    }
  }
  
  public final void a(String paramString, Object paramObject, IImageDecodeService.c paramc, ImageDecodeConfig paramImageDecodeConfig) {}
  
  static final class a
    implements com.github.henryye.nativeiv.b.b
  {
    private final String appId;
    private final p bYn;
    
    private a(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(130463);
      this.appId = paramAppBrandRuntime.mAppId;
      this.bYn = paramAppBrandRuntime.DH();
      AppMethodBeat.o(130463);
    }
    
    public final com.github.henryye.nativeiv.b.b.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
    {
      AppMethodBeat.i(206090);
      paramImageDecodeConfig = new com.github.henryye.nativeiv.b.b.a();
      paramObject = (String)paramObject;
      if (this.bYn == null)
      {
        ac.e("MicroMsg.WAGameRuntimeFileSystemImageStreamFetcher", "fetch %s, appId[%s] fs NULL", new Object[] { paramObject, this.appId });
        paramImageDecodeConfig.errorMsg = ai.getContext().getString(2131757205);
        AppMethodBeat.o(206090);
        return paramImageDecodeConfig;
      }
      com.tencent.mm.plugin.appbrand.z.i locali = new com.tencent.mm.plugin.appbrand.z.i();
      l locall = this.bYn.b(paramObject, locali);
      if ((locall == l.jsB) && (locali.value != null)) {
        paramImageDecodeConfig.inputStream = new com.tencent.luggage.h.a((ByteBuffer)locali.value);
      }
      for (;;)
      {
        AppMethodBeat.o(206090);
        return paramImageDecodeConfig;
        ac.e("MicroMsg.WAGameRuntimeFileSystemImageStreamFetcher", "fetch %s, ret %s, appId[%s]", new Object[] { paramObject, locall.name(), this.appId });
        paramImageDecodeConfig.errorMsg = String.format(ai.getContext().getString(2131757119), new Object[] { locall.name() });
      }
    }
    
    public final boolean accept(Object paramObject)
    {
      return true;
    }
    
    public final String rq()
    {
      return "appbrand_file";
    }
  }
  
  static final class b
    implements com.github.henryye.nativeiv.b.b
  {
    private int aRc;
    private int aRd;
    private WeakReference<AppBrandRuntime> bYo;
    private final String mUserAgent;
    
    public b(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(206091);
      this.aRc = 60000;
      this.aRd = 60000;
      this.bYo = new WeakReference(paramAppBrandRuntime);
      paramAppBrandRuntime = (com.tencent.mm.plugin.appbrand.p.a)paramAppBrandRuntime.ar(com.tencent.mm.plugin.appbrand.p.a.class);
      int i = paramAppBrandRuntime.lwc;
      int j = paramAppBrandRuntime.lwc;
      if ((i <= 0) || (j <= 0)) {}
      for (;;)
      {
        this.mUserAgent = paramAppBrandRuntime.lwh;
        AppMethodBeat.o(206091);
        return;
        this.aRc = i;
        this.aRd = j;
        ac.i("AppBrandImageHttpFetcher", "Http Timeout Set: connection[%d] read[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      }
    }
    
    private static ImageDecodeConfig.ReferrerPolicy a(com.tencent.mm.plugin.appbrand.jsapi.p.c paramc)
    {
      if (paramc == null) {
        return ImageDecodeConfig.ReferrerPolicy.NOT_SET;
      }
      if (paramc == com.tencent.mm.plugin.appbrand.jsapi.p.c.kIJ) {
        return ImageDecodeConfig.ReferrerPolicy.NO_REFERRER;
      }
      if (paramc == com.tencent.mm.plugin.appbrand.jsapi.p.c.kII) {
        return ImageDecodeConfig.ReferrerPolicy.ORIGIN;
      }
      return ImageDecodeConfig.ReferrerPolicy.NOT_SET;
    }
    
    public final com.github.henryye.nativeiv.b.b.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
    {
      AppMethodBeat.i(206093);
      locala = new com.github.henryye.nativeiv.b.b.a();
      localAppBrandRuntime = (AppBrandRuntime)this.bYo.get();
      Object localObject1;
      if (localAppBrandRuntime != null)
      {
        localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.p.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.p.a.class);
        localObject2 = paramImageDecodeConfig.mReferrerPolicy;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (localObject2 == ImageDecodeConfig.ReferrerPolicy.NOT_SET) {
            localObject1 = a(((com.tencent.mm.plugin.appbrand.jsapi.p.a)localObject3).x(localAppBrandRuntime.CX()));
          }
          localObject2 = localObject1;
          if (localObject1 == ImageDecodeConfig.ReferrerPolicy.NOT_SET) {
            localObject2 = a(((com.tencent.mm.plugin.appbrand.jsapi.p.a)localObject3).biC());
          }
          if (localObject2 != ImageDecodeConfig.ReferrerPolicy.ORIGIN) {
            break label320;
          }
          localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.p.a)localObject3).y(localAppBrandRuntime.CX());
          localAppBrandRuntime = null;
        }
      }
      try
      {
        localObject2 = (String)paramObject;
        i = 0;
      }
      catch (SocketTimeoutException paramImageDecodeConfig)
      {
        for (;;)
        {
          int j;
          ac.e("AppBrandImageHttpFetcher", "ImageFetch Timeout! path[%s] connectionTimeout[%d] readTimeout[%d] error[%s]", new Object[] { paramObject, Integer.valueOf(this.aRc), Integer.valueOf(this.aRd), paramImageDecodeConfig.toString() });
          locala.errorMsg = ai.getContext().getString(2131757659);
          paramObject = localAppBrandRuntime;
        }
      }
      catch (Exception paramImageDecodeConfig)
      {
        for (;;)
        {
          int i;
          String str;
          ac.e("AppBrandImageHttpFetcher", "fetch error. path = [%s], error = [%s]", new Object[] { paramObject, paramImageDecodeConfig.toString() });
          locala.errorMsg = String.format(ai.getContext().getString(2131757582), new Object[] { paramImageDecodeConfig.toString() });
          paramObject = localAppBrandRuntime;
          continue;
          paramObject = null;
          continue;
          i += 1;
          localObject2 = str;
          continue;
          paramImageDecodeConfig = (ImageDecodeConfig)localObject3;
        }
      }
      localObject3 = (HttpURLConnection)new URL((String)localObject2).openConnection();
      if ((paramImageDecodeConfig != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
        ((HttpURLConnection)localObject3).addRequestProperty("Referer", (String)localObject1);
      }
      ((HttpURLConnection)localObject3).setRequestProperty("User-Agent", this.mUserAgent);
      ((HttpURLConnection)localObject3).setReadTimeout(this.aRd);
      ((HttpURLConnection)localObject3).setConnectTimeout(this.aRc);
      j = ((HttpURLConnection)localObject3).getResponseCode();
      if ((j == 301) || (j == 302))
      {
        str = ((HttpURLConnection)localObject3).getHeaderField("location");
        ac.i("AppBrandImageHttpFetcher", "redirect from[%s] to[%s]", new Object[] { localObject2, str });
        ((HttpURLConnection)localObject3).disconnect();
        if (str != null) {
          break label373;
        }
      }
      for (paramImageDecodeConfig = null;; paramImageDecodeConfig = null)
      {
        if ((paramImageDecodeConfig == null) || (!TextUtils.isEmpty(locala.errorMsg))) {
          break label521;
        }
        paramImageDecodeConfig = new BufferedInputStream(paramImageDecodeConfig.getInputStream());
        paramObject = paramImageDecodeConfig;
        locala.inputStream = paramObject;
        AppMethodBeat.o(206093);
        return locala;
        ac.w("AppBrandImageHttpFetcher", "referrer helper is null");
        label320:
        localObject1 = null;
        break;
        if ((j >= 200) && (j < 300)) {
          break label537;
        }
        locala.errorMsg = String.format(ai.getContext().getString(2131757277), new Object[] { Integer.valueOf(j) });
        break label537;
        label373:
        if (i < 3) {
          break label526;
        }
        ac.e("AppBrandImageHttpFetcher", "too much redirection!");
        locala.errorMsg = ai.getContext().getString(2131757583);
      }
    }
    
    public final boolean accept(Object paramObject)
    {
      AppMethodBeat.i(206092);
      if (!(paramObject instanceof String))
      {
        AppMethodBeat.o(206092);
        return false;
      }
      if ((((String)paramObject).startsWith("http://")) || (((String)paramObject).startsWith("https://")))
      {
        AppMethodBeat.o(206092);
        return true;
      }
      AppMethodBeat.o(206092);
      return false;
    }
    
    public final String rq()
    {
      return "http";
    }
  }
  
  public static final class c
    implements c.b
  {
    private int bYp = 14883;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.b.b
 * JD-Core Version:    0.7.0.1
 */