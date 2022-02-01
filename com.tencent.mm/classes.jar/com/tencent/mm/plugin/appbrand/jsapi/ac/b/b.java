package com.tencent.mm.plugin.appbrand.jsapi.ac.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.s.c;
import com.tencent.mm.plugin.appbrand.jsapi.s.d;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.xweb.skia_canvas.resource_loader.IResourceLoader;
import com.tencent.xweb.skia_canvas.resource_loader.IResourceLoader.ResourceLoadCallback;
import java.io.IOException;
import java.io.InputStream;

public final class b
  implements IResourceLoader
{
  com.tencent.mm.plugin.appbrand.f.a chd;
  com.tencent.mm.plugin.appbrand.q lxv;
  com.tencent.mm.plugin.appbrand.f.b lxw;
  
  public b(com.tencent.mm.plugin.appbrand.f.b paramb, com.tencent.mm.plugin.appbrand.f.a parama, com.tencent.mm.plugin.appbrand.q paramq)
  {
    this.lxw = paramb;
    this.chd = parama;
    this.lxv = paramq;
  }
  
  public final byte[] loadResource(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186904);
    if ((this.chd == null) || (this.lxw == null) || (this.lxv == null))
    {
      ad.e("MicroMsg.WxaNativeImageLoader", "mImageLoader or mUrlBuilder is null, return");
      AppMethodBeat.o(186904);
      return null;
    }
    paramString1 = this.lxv.Fg().Mn(paramString1);
    try
    {
      paramString1 = org.apache.commons.a.e.toByteArray(paramString1);
      if (paramString1 != null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.WxaNativeImageLoader", "loadResource bytes:%b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(186904);
        return paramString1;
      }
      return null;
    }
    catch (IOException paramString1)
    {
      ad.e("MicroMsg.WxaNativeImageLoader", "loadResource sync fail: %s", new Object[] { paramString1.getMessage() });
      AppMethodBeat.o(186904);
    }
  }
  
  public final void loadResourceAsync(final String paramString1, String paramString2, final IResourceLoader.ResourceLoadCallback paramResourceLoadCallback)
  {
    AppMethodBeat.i(186905);
    if ((this.chd == null) || (this.lxw == null) || (this.lxv == null) || (bt.isNullOrNil(paramString1)))
    {
      ad.e("MicroMsg.WxaNativeImageLoader", "mImageLoader or mUrlBuilder or path:%s is null, return", new Object[] { paramString1 });
      paramResourceLoadCallback.onResourceLoaded(null);
      AppMethodBeat.o(186905);
      return;
    }
    if ((paramString1.startsWith("http")) || (paramString1.startsWith("https")))
    {
      String str = this.lxw.b(this.lxv, paramString1);
      ad.i("MicroMsg.WxaNativeImageLoader", "finalUrl : %s", new Object[] { str });
      com.tencent.mm.plugin.appbrand.f.a locala = this.chd;
      com.tencent.mm.plugin.appbrand.jsapi.s.a locala1 = (com.tencent.mm.plugin.appbrand.jsapi.s.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.s.a.class);
      if (locala1 == null)
      {
        ad.w("MicroMsg.WxaNativeImageLoader", "buildHeaders, referrerHelper is null");
        paramString1 = null;
      }
      for (;;)
      {
        locala.a(str, paramString1, new a.c()
        {
          public final void D(final InputStream paramAnonymousInputStream)
          {
            AppMethodBeat.i(186902);
            try
            {
              paramAnonymousInputStream = org.apache.commons.a.e.toByteArray(paramAnonymousInputStream);
              if (paramAnonymousInputStream != null) {}
              for (boolean bool = true;; bool = false)
              {
                ad.i("MicroMsg.WxaNativeImageLoader", "loadResourceAsync bytes:%b", new Object[] { Boolean.valueOf(bool) });
                com.tencent.mm.plugin.appbrand.jsruntime.q localq = (com.tencent.mm.plugin.appbrand.jsruntime.q)b.this.lxv.aYh().P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
                if (localq != null) {
                  localq.post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(186901);
                      if (b.1.this.lxx != null) {
                        b.1.this.lxx.onResourceLoaded(paramAnonymousInputStream);
                      }
                      AppMethodBeat.o(186901);
                    }
                  });
                }
                AppMethodBeat.o(186902);
                return;
              }
              return;
            }
            catch (IOException paramAnonymousInputStream)
            {
              ad.e("MicroMsg.WxaNativeImageLoader", "loadResource Async fail: %s", new Object[] { paramAnonymousInputStream.getMessage() });
              if (paramResourceLoadCallback != null) {
                paramResourceLoadCallback.onResourceLoaded(null);
              }
              AppMethodBeat.o(186902);
            }
          }
        });
        AppMethodBeat.o(186905);
        return;
        if (paramString2 == null)
        {
          ad.w("MicroMsg.WxaNativeImageLoader", "buildHeaders, referrerPolicyStr is null");
          paramString1 = null;
        }
        else
        {
          paramString2 = locala1.Qu(paramString2);
          paramString1 = paramString2;
          if (paramString2 == null) {
            if (this.lxv == null) {
              break label242;
            }
          }
          for (paramString1 = locala1.x(this.lxv);; paramString1 = paramString2)
          {
            paramString2 = paramString1;
            if (paramString1 == null) {
              paramString2 = locala1.bmo();
            }
            if (c.lfc != paramString2) {
              break label254;
            }
            paramString1 = null;
            break;
            label242:
            ad.w("MicroMsg.WxaNativeImageLoader", "buildHeaders, mAppBrandService is null");
          }
          label254:
          if (this.lxv == null)
          {
            ad.w("MicroMsg.WxaNativeImageLoader", "buildHeaders, mAppBrandService is null");
            paramString1 = null;
          }
          else
          {
            paramString1 = locala1.y(this.lxv);
            ad.i("MicroMsg.WxaNativeImageLoader", "buildHeaders, referrer: ".concat(String.valueOf(paramString1)));
            paramString1 = d.Qv(paramString1);
          }
        }
      }
    }
    paramString2 = (com.tencent.mm.plugin.appbrand.jsruntime.q)this.lxv.aYh().P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
    if (paramString2 != null) {
      paramString2.post(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc 35
          //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_0
          //   6: getfield 21	com/tencent/mm/plugin/appbrand/jsapi/ac/b/b$2:lxy	Lcom/tencent/mm/plugin/appbrand/jsapi/ac/b/b;
          //   9: getfield 45	com/tencent/mm/plugin/appbrand/jsapi/ac/b/b:lxv	Lcom/tencent/mm/plugin/appbrand/q;
          //   12: invokevirtual 51	com/tencent/mm/plugin/appbrand/q:Fg	()Lcom/tencent/mm/plugin/appbrand/appstorage/p;
          //   15: aload_0
          //   16: getfield 23	com/tencent/mm/plugin/appbrand/jsapi/ac/b/b$2:val$path	Ljava/lang/String;
          //   19: invokeinterface 57 2 0
          //   24: astore_2
          //   25: aload_2
          //   26: invokestatic 63	org/apache/commons/a/e:toByteArray	(Ljava/io/InputStream;)[B
          //   29: astore_2
          //   30: aload_2
          //   31: ifnull +46 -> 77
          //   34: iconst_1
          //   35: istore_1
          //   36: ldc 65
          //   38: ldc 67
          //   40: iconst_1
          //   41: anewarray 4	java/lang/Object
          //   44: dup
          //   45: iconst_0
          //   46: iload_1
          //   47: invokestatic 73	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   50: aastore
          //   51: invokestatic 78	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   54: aload_0
          //   55: getfield 25	com/tencent/mm/plugin/appbrand/jsapi/ac/b/b$2:lxx	Lcom/tencent/xweb/skia_canvas/resource_loader/IResourceLoader$ResourceLoadCallback;
          //   58: ifnull +13 -> 71
          //   61: aload_0
          //   62: getfield 25	com/tencent/mm/plugin/appbrand/jsapi/ac/b/b$2:lxx	Lcom/tencent/xweb/skia_canvas/resource_loader/IResourceLoader$ResourceLoadCallback;
          //   65: aload_2
          //   66: invokeinterface 84 2 0
          //   71: ldc 35
          //   73: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   76: return
          //   77: iconst_0
          //   78: istore_1
          //   79: goto -43 -> 36
          //   82: astore_2
          //   83: ldc 65
          //   85: ldc 89
          //   87: iconst_1
          //   88: anewarray 4	java/lang/Object
          //   91: dup
          //   92: iconst_0
          //   93: aload_2
          //   94: invokevirtual 95	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   97: aastore
          //   98: invokestatic 98	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   101: aload_0
          //   102: getfield 25	com/tencent/mm/plugin/appbrand/jsapi/ac/b/b$2:lxx	Lcom/tencent/xweb/skia_canvas/resource_loader/IResourceLoader$ResourceLoadCallback;
          //   105: ifnull +13 -> 118
          //   108: aload_0
          //   109: getfield 25	com/tencent/mm/plugin/appbrand/jsapi/ac/b/b$2:lxx	Lcom/tencent/xweb/skia_canvas/resource_loader/IResourceLoader$ResourceLoadCallback;
          //   112: aconst_null
          //   113: invokeinterface 84 2 0
          //   118: ldc 35
          //   120: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   123: return
          //   124: astore_2
          //   125: goto -42 -> 83
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	128	0	this	2
          //   35	44	1	bool	boolean
          //   24	42	2	localObject	Object
          //   82	12	2	localNullPointerException	java.lang.NullPointerException
          //   124	1	2	localIOException	IOException
          // Exception table:
          //   from	to	target	type
          //   25	30	82	java/lang/NullPointerException
          //   36	71	82	java/lang/NullPointerException
          //   25	30	124	java/io/IOException
          //   36	71	124	java/io/IOException
        }
      });
    }
    AppMethodBeat.o(186905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.b.b
 * JD-Core Version:    0.7.0.1
 */