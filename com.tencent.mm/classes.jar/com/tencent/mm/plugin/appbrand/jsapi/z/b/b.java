package com.tencent.mm.plugin.appbrand.jsapi.z.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.p.c;
import com.tencent.mm.plugin.appbrand.jsapi.p.d;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.xweb.skia_canvas.resource_loader.IResourceLoader;
import com.tencent.xweb.skia_canvas.resource_loader.IResourceLoader.ResourceLoadCallback;
import java.io.IOException;
import java.io.InputStream;

public final class b
  implements IResourceLoader
{
  com.tencent.mm.plugin.appbrand.g.a bWO;
  com.tencent.mm.plugin.appbrand.q lav;
  com.tencent.mm.plugin.appbrand.g.b law;
  
  public b(com.tencent.mm.plugin.appbrand.g.b paramb, com.tencent.mm.plugin.appbrand.g.a parama, com.tencent.mm.plugin.appbrand.q paramq)
  {
    this.law = paramb;
    this.bWO = parama;
    this.lav = paramq;
  }
  
  public final byte[] loadResource(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206718);
    if ((this.bWO == null) || (this.law == null) || (this.lav == null))
    {
      ac.e("MicroMsg.WxaNativeImageLoader", "mImageLoader or mUrlBuilder is null, return");
      AppMethodBeat.o(206718);
      return null;
    }
    paramString1 = this.lav.DH().IW(paramString1);
    try
    {
      paramString1 = org.apache.commons.a.e.toByteArray(paramString1);
      if (paramString1 != null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.i("MicroMsg.WxaNativeImageLoader", "loadResource bytes:%b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(206718);
        return paramString1;
      }
      return null;
    }
    catch (IOException paramString1)
    {
      ac.e("MicroMsg.WxaNativeImageLoader", "loadResource sync fail: %s", new Object[] { paramString1.getMessage() });
      AppMethodBeat.o(206718);
    }
  }
  
  public final void loadResourceAsync(final String paramString1, String paramString2, final IResourceLoader.ResourceLoadCallback paramResourceLoadCallback)
  {
    AppMethodBeat.i(206719);
    if ((this.bWO == null) || (this.law == null) || (this.lav == null) || (bs.isNullOrNil(paramString1)))
    {
      ac.e("MicroMsg.WxaNativeImageLoader", "mImageLoader or mUrlBuilder or path:%s is null, return", new Object[] { paramString1 });
      paramResourceLoadCallback.onResourceLoaded(null);
      AppMethodBeat.o(206719);
      return;
    }
    if ((paramString1.startsWith("http")) || (paramString1.startsWith("https")))
    {
      String str = this.law.b(this.lav, paramString1);
      ac.i("MicroMsg.WxaNativeImageLoader", "finalUrl : %s", new Object[] { str });
      com.tencent.mm.plugin.appbrand.g.a locala = this.bWO;
      com.tencent.mm.plugin.appbrand.jsapi.p.a locala1 = (com.tencent.mm.plugin.appbrand.jsapi.p.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.p.a.class);
      if (locala1 == null)
      {
        ac.w("MicroMsg.WxaNativeImageLoader", "buildHeaders, referrerHelper is null");
        paramString1 = null;
      }
      for (;;)
      {
        locala.a(str, paramString1, new a.c()
        {
          public final void z(final InputStream paramAnonymousInputStream)
          {
            AppMethodBeat.i(206716);
            try
            {
              paramAnonymousInputStream = org.apache.commons.a.e.toByteArray(paramAnonymousInputStream);
              if (paramAnonymousInputStream != null) {}
              for (boolean bool = true;; bool = false)
              {
                ac.i("MicroMsg.WxaNativeImageLoader", "loadResourceAsync bytes:%b", new Object[] { Boolean.valueOf(bool) });
                com.tencent.mm.plugin.appbrand.jsruntime.q localq = (com.tencent.mm.plugin.appbrand.jsruntime.q)b.this.lav.aUV().P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
                if (localq != null) {
                  localq.post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(206715);
                      if (b.1.this.lax != null) {
                        b.1.this.lax.onResourceLoaded(paramAnonymousInputStream);
                      }
                      AppMethodBeat.o(206715);
                    }
                  });
                }
                AppMethodBeat.o(206716);
                return;
              }
              return;
            }
            catch (IOException paramAnonymousInputStream)
            {
              ac.e("MicroMsg.WxaNativeImageLoader", "loadResource Async fail: %s", new Object[] { paramAnonymousInputStream.getMessage() });
              if (paramResourceLoadCallback != null) {
                paramResourceLoadCallback.onResourceLoaded(null);
              }
              AppMethodBeat.o(206716);
            }
          }
        });
        AppMethodBeat.o(206719);
        return;
        if (paramString2 == null)
        {
          ac.w("MicroMsg.WxaNativeImageLoader", "buildHeaders, referrerPolicyStr is null");
          paramString1 = null;
        }
        else
        {
          paramString2 = locala1.MX(paramString2);
          paramString1 = paramString2;
          if (paramString2 == null) {
            if (this.lav == null) {
              break label242;
            }
          }
          for (paramString1 = locala1.x(this.lav);; paramString1 = paramString2)
          {
            paramString2 = paramString1;
            if (paramString1 == null) {
              paramString2 = locala1.biC();
            }
            if (c.kIJ != paramString2) {
              break label254;
            }
            paramString1 = null;
            break;
            label242:
            ac.w("MicroMsg.WxaNativeImageLoader", "buildHeaders, mAppBrandService is null");
          }
          label254:
          if (this.lav == null)
          {
            ac.w("MicroMsg.WxaNativeImageLoader", "buildHeaders, mAppBrandService is null");
            paramString1 = null;
          }
          else
          {
            paramString1 = locala1.y(this.lav);
            ac.i("MicroMsg.WxaNativeImageLoader", "buildHeaders, referrer: ".concat(String.valueOf(paramString1)));
            paramString1 = d.MY(paramString1);
          }
        }
      }
    }
    paramString2 = (com.tencent.mm.plugin.appbrand.jsruntime.q)this.lav.aUV().P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
    if (paramString2 != null) {
      paramString2.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206717);
          Object localObject = b.this.lav.DH().IW(paramString1);
          try
          {
            localObject = org.apache.commons.a.e.toByteArray((InputStream)localObject);
            if (localObject != null) {}
            for (boolean bool = true;; bool = false)
            {
              ac.i("MicroMsg.WxaNativeImageLoader", "loadResource bytes:%b", new Object[] { Boolean.valueOf(bool) });
              if (paramResourceLoadCallback != null) {
                paramResourceLoadCallback.onResourceLoaded((byte[])localObject);
              }
              AppMethodBeat.o(206717);
              return;
            }
            return;
          }
          catch (IOException localIOException)
          {
            ac.e("MicroMsg.WxaNativeImageLoader", "loadResource sync fail: %s", new Object[] { localIOException.getMessage() });
            if (paramResourceLoadCallback != null) {
              paramResourceLoadCallback.onResourceLoaded(null);
            }
            AppMethodBeat.o(206717);
          }
        }
      });
    }
    AppMethodBeat.o(206719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.b.b
 * JD-Core Version:    0.7.0.1
 */