package com.tencent.mm.plugin.appbrand.jsapi.aa.b;

import android.graphics.Bitmap;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.a.b;
import com.tencent.mm.plugin.appbrand.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.q.c;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.skia_canvas.IXWebImageLoader;
import com.tencent.xweb.skia_canvas.IXWebImageLoader.LoadImageCallback;
import java.io.InputStream;

public final class b
  implements IXWebImageLoader
{
  com.tencent.mm.plugin.appbrand.g.a bZR;
  com.tencent.mm.plugin.appbrand.q kzh;
  com.tencent.mm.plugin.appbrand.g.b kzi;
  
  public b(com.tencent.mm.plugin.appbrand.g.b paramb, com.tencent.mm.plugin.appbrand.g.a parama, com.tencent.mm.plugin.appbrand.q paramq)
  {
    this.kzi = paramb;
    this.bZR = parama;
    this.kzh = paramq;
  }
  
  public final Bitmap loadImage(String paramString)
  {
    AppMethodBeat.i(139443);
    if ((this.bZR == null) || (this.kzi == null) || (this.kzh == null))
    {
      ad.e("MicroMsg.WxaNativeImageLoader", "mImageLoader or mUrlBuilder is null, return");
      AppMethodBeat.o(139443);
      return null;
    }
    paramString = this.kzi.b(this.kzh, paramString);
    paramString = this.bZR.a(paramString, null, new a.b()
    {
      public final void M(Bitmap paramAnonymousBitmap) {}
    });
    AppMethodBeat.o(139443);
    return paramString;
  }
  
  public final void loadImageAsync(String paramString1, String paramString2, final IXWebImageLoader.LoadImageCallback paramLoadImageCallback)
  {
    AppMethodBeat.i(195076);
    if ((this.bZR == null) || (this.kzi == null) || (this.kzh == null))
    {
      ad.e("MicroMsg.WxaNativeImageLoader", "mImageLoader or mUrlBuilder is null, return");
      paramLoadImageCallback.onLoadImageCallback(null);
      AppMethodBeat.o(195076);
      return;
    }
    String str = this.kzi.b(this.kzh, paramString1);
    ad.i("MicroMsg.WxaNativeImageLoader", "finalUrl : %s", new Object[] { str });
    com.tencent.mm.plugin.appbrand.g.a locala = this.bZR;
    com.tencent.mm.plugin.appbrand.jsapi.q.a locala1 = (com.tencent.mm.plugin.appbrand.jsapi.q.a)e.K(com.tencent.mm.plugin.appbrand.jsapi.q.a.class);
    if (locala1 == null)
    {
      ad.w("MicroMsg.WxaNativeImageLoader", "buildHeaders, referrerHelper is null");
      paramString1 = null;
    }
    for (;;)
    {
      locala.a(str, paramString1, new a.c()
      {
        public final void A(final InputStream paramAnonymousInputStream)
        {
          AppMethodBeat.i(195075);
          try
          {
            paramAnonymousInputStream = b.aZI().decodeStream(paramAnonymousInputStream);
            if (paramAnonymousInputStream != null)
            {
              bool = true;
              ad.i("MicroMsg.WxaNativeImageLoader", "imageBytesCallback bitmap:%b", new Object[] { Boolean.valueOf(bool) });
              com.tencent.mm.plugin.appbrand.jsruntime.q localq = (com.tencent.mm.plugin.appbrand.jsruntime.q)b.this.kzh.aOf().P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
              if (localq != null) {
                localq.post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(139441);
                    if (b.2.this.val$loadImageCallback != null) {
                      b.2.this.val$loadImageCallback.onLoadImageCallback(paramAnonymousInputStream);
                    }
                    AppMethodBeat.o(139441);
                  }
                });
              }
              AppMethodBeat.o(195075);
              return;
            }
          }
          catch (Exception paramAnonymousInputStream)
          {
            for (;;)
            {
              ad.m("MicroMsg.WxaNativeImageLoader", "", new Object[] { paramAnonymousInputStream });
              paramAnonymousInputStream = null;
              continue;
              boolean bool = false;
            }
          }
        }
      });
      AppMethodBeat.o(195076);
      return;
      if (paramString2 == null)
      {
        ad.w("MicroMsg.WxaNativeImageLoader", "buildHeaders, referrerPolicyStr is null");
        paramString1 = null;
      }
      else
      {
        paramString2 = locala1.IU(paramString2);
        paramString1 = paramString2;
        if (paramString2 == null) {
          if (this.kzh == null) {
            break label209;
          }
        }
        for (paramString1 = locala1.x(this.kzh);; paramString1 = paramString2)
        {
          paramString2 = paramString1;
          if (paramString1 == null) {
            paramString2 = locala1.bbJ();
          }
          if (c.khR != paramString2) {
            break label221;
          }
          paramString1 = null;
          break;
          label209:
          ad.w("MicroMsg.WxaNativeImageLoader", "buildHeaders, mAppBrandService is null");
        }
        label221:
        if (this.kzh == null)
        {
          ad.w("MicroMsg.WxaNativeImageLoader", "buildHeaders, mAppBrandService is null");
          paramString1 = null;
        }
        else
        {
          paramString1 = locala1.y(this.kzh);
          ad.i("MicroMsg.WxaNativeImageLoader", "buildHeaders, referrer: ".concat(String.valueOf(paramString1)));
          paramString1 = com.tencent.mm.plugin.appbrand.jsapi.q.d.IV(paramString1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.b.b
 * JD-Core Version:    0.7.0.1
 */