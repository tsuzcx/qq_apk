package com.tencent.luggage.game.b;

import android.content.Context;
import android.text.TextUtils;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.ImageDecodeConfig.ReferrerPolicy;
import com.github.henryye.nativeiv.b.b;
import com.github.henryye.nativeiv.b.b.a;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.q.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.io.BufferedInputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

final class b$b
  implements b
{
  private int aQm;
  private int aQn;
  private WeakReference<AppBrandRuntime> cbr;
  private final String mUserAgent;
  
  public b$b(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(194644);
    this.aQm = 60000;
    this.aQn = 60000;
    this.cbr = new WeakReference(paramAppBrandRuntime);
    paramAppBrandRuntime = (com.tencent.mm.plugin.appbrand.q.a)paramAppBrandRuntime.ar(com.tencent.mm.plugin.appbrand.q.a.class);
    int i = paramAppBrandRuntime.kUs;
    int j = paramAppBrandRuntime.kUs;
    if ((i <= 0) || (j <= 0)) {}
    for (;;)
    {
      this.mUserAgent = paramAppBrandRuntime.kUx;
      AppMethodBeat.o(194644);
      return;
      this.aQm = i;
      this.aQn = j;
      ad.i("AppBrandImageHttpFetcher", "Http Timeout Set: connection[%d] read[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    }
  }
  
  private static ImageDecodeConfig.ReferrerPolicy a(c paramc)
  {
    if (paramc == null) {
      return ImageDecodeConfig.ReferrerPolicy.NOT_SET;
    }
    if (paramc == c.khR) {
      return ImageDecodeConfig.ReferrerPolicy.NO_REFERRER;
    }
    if (paramc == c.khQ) {
      return ImageDecodeConfig.ReferrerPolicy.ORIGIN;
    }
    return ImageDecodeConfig.ReferrerPolicy.NOT_SET;
  }
  
  public final b.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(194646);
    locala = new b.a();
    localAppBrandRuntime = (AppBrandRuntime)this.cbr.get();
    Object localObject1;
    if (localAppBrandRuntime != null)
    {
      localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.q.a)e.K(com.tencent.mm.plugin.appbrand.jsapi.q.a.class);
      localObject2 = paramImageDecodeConfig.mReferrerPolicy;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (localObject2 == ImageDecodeConfig.ReferrerPolicy.NOT_SET) {
          localObject1 = a(((com.tencent.mm.plugin.appbrand.jsapi.q.a)localObject3).x(localAppBrandRuntime.Du()));
        }
        localObject2 = localObject1;
        if (localObject1 == ImageDecodeConfig.ReferrerPolicy.NOT_SET) {
          localObject2 = a(((com.tencent.mm.plugin.appbrand.jsapi.q.a)localObject3).bbJ());
        }
        if (localObject2 != ImageDecodeConfig.ReferrerPolicy.ORIGIN) {
          break label320;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.q.a)localObject3).y(localAppBrandRuntime.Du());
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
        ad.e("AppBrandImageHttpFetcher", "ImageFetch Timeout! path[%s] connectionTimeout[%d] readTimeout[%d] error[%s]", new Object[] { paramObject, Integer.valueOf(this.aQm), Integer.valueOf(this.aQn), paramImageDecodeConfig.toString() });
        locala.errorMsg = aj.getContext().getString(2131757659);
        paramObject = localAppBrandRuntime;
      }
    }
    catch (Exception paramImageDecodeConfig)
    {
      for (;;)
      {
        int i;
        String str;
        ad.e("AppBrandImageHttpFetcher", "fetch error. path = [%s], error = [%s]", new Object[] { paramObject, paramImageDecodeConfig.toString() });
        locala.errorMsg = String.format(aj.getContext().getString(2131757582), new Object[] { paramImageDecodeConfig.toString() });
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
    ((HttpURLConnection)localObject3).setReadTimeout(this.aQn);
    ((HttpURLConnection)localObject3).setConnectTimeout(this.aQm);
    j = ((HttpURLConnection)localObject3).getResponseCode();
    if ((j == 301) || (j == 302))
    {
      str = ((HttpURLConnection)localObject3).getHeaderField("location");
      ad.i("AppBrandImageHttpFetcher", "redirect from[%s] to[%s]", new Object[] { localObject2, str });
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
      AppMethodBeat.o(194646);
      return locala;
      ad.w("AppBrandImageHttpFetcher", "referrer helper is null");
      label320:
      localObject1 = null;
      break;
      if ((j >= 200) && (j < 300)) {
        break label537;
      }
      locala.errorMsg = String.format(aj.getContext().getString(2131757277), new Object[] { Integer.valueOf(j) });
      break label537;
      label373:
      if (i < 3) {
        break label526;
      }
      ad.e("AppBrandImageHttpFetcher", "too much redirection!");
      locala.errorMsg = aj.getContext().getString(2131757583);
    }
  }
  
  public final boolean accept(Object paramObject)
  {
    AppMethodBeat.i(194645);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(194645);
      return false;
    }
    if ((((String)paramObject).startsWith("http://")) || (((String)paramObject).startsWith("https://")))
    {
      AppMethodBeat.o(194645);
      return true;
    }
    AppMethodBeat.o(194645);
    return false;
  }
  
  public final String rg()
  {
    return "http";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.game.b.b.b
 * JD-Core Version:    0.7.0.1
 */