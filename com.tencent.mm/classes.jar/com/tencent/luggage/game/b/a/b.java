package com.tencent.luggage.game.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b.a;
import com.tencent.luggage.wxa.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

public final class b
  extends d<d.c>
{
  private int aKQ;
  private int aKR;
  private d.c csU;
  private final String mUserAgent;
  
  public b(d.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(247557);
    this.aKQ = 60000;
    this.aKR = 60000;
    this.csU = paramc;
    int i = paramc.OJ();
    int j = paramc.OL();
    if ((i <= 0) || (j <= 0)) {}
    for (;;)
    {
      this.mUserAgent = paramc.getUserAgentString();
      AppMethodBeat.o(247557);
      return;
      this.aKQ = i;
      this.aKR = j;
      Log.i("AppBrandImageHttpFetcher", "Http Timeout Set: connection[%d] read[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    }
  }
  
  public final boolean V(Object paramObject)
  {
    AppMethodBeat.i(247559);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(247559);
      return false;
    }
    if ((((String)paramObject).startsWith("http://")) || (((String)paramObject).startsWith("https://")))
    {
      AppMethodBeat.o(247559);
      return true;
    }
    AppMethodBeat.o(247559);
    return false;
  }
  
  public final b.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(247561);
    locala = new b.a();
    String str2 = this.csU.a(paramImageDecodeConfig.mReferrerPolicy);
    localObject2 = null;
    try
    {
      localObject1 = (String)paramObject;
      i = 0;
    }
    catch (SocketTimeoutException paramImageDecodeConfig)
    {
      for (;;)
      {
        int j;
        Log.e("AppBrandImageHttpFetcher", "ImageFetch Timeout! path[%s] connectionTimeout[%d] readTimeout[%d] error[%s]", new Object[] { paramObject, Integer.valueOf(this.aKQ), Integer.valueOf(this.aKR), paramImageDecodeConfig.toString() });
        locala.errorMsg = MMApplicationContext.getContext().getString(a.e.appbrand_game_image_stream_error_http_timeout);
        paramObject = localObject2;
      }
    }
    catch (Exception paramImageDecodeConfig)
    {
      for (;;)
      {
        int i;
        HttpURLConnection localHttpURLConnection;
        String str1;
        Log.e("AppBrandImageHttpFetcher", "fetch error. path = [%s], error = [%s]", new Object[] { paramObject, paramImageDecodeConfig.toString() });
        locala.errorMsg = String.format(MMApplicationContext.getContext().getString(a.e.appbrand_game_image_stream_error_http_inner), new Object[] { paramImageDecodeConfig.toString() });
        paramObject = localObject2;
        continue;
        paramObject = null;
        continue;
        i += 1;
        Object localObject1 = str1;
        continue;
        paramImageDecodeConfig = localHttpURLConnection;
      }
    }
    localHttpURLConnection = (HttpURLConnection)new URL((String)localObject1).openConnection();
    if ((paramImageDecodeConfig != null) && (!TextUtils.isEmpty(str2))) {
      localHttpURLConnection.addRequestProperty("Referer", str2);
    }
    localHttpURLConnection.setRequestProperty("User-Agent", this.mUserAgent);
    localHttpURLConnection.setReadTimeout(this.aKR);
    localHttpURLConnection.setConnectTimeout(this.aKQ);
    j = localHttpURLConnection.getResponseCode();
    if ((j == 301) || (j == 302))
    {
      str1 = localHttpURLConnection.getHeaderField("location");
      Log.i("AppBrandImageHttpFetcher", "redirect from[%s] to[%s]", new Object[] { localObject1, str1 });
      localHttpURLConnection.disconnect();
      if (str1 != null) {
        break label263;
      }
    }
    for (paramImageDecodeConfig = null; (paramImageDecodeConfig != null) && (TextUtils.isEmpty(locala.errorMsg)); paramImageDecodeConfig = null)
    {
      paramImageDecodeConfig = new BufferedInputStream(paramImageDecodeConfig.getInputStream());
      paramObject = paramImageDecodeConfig;
      locala.aFw = paramObject;
      AppMethodBeat.o(247561);
      return locala;
      if ((j >= 200) && (j < 300)) {
        break label430;
      }
      locala.errorMsg = String.format(MMApplicationContext.getContext().getString(a.e.appbrand_game_image_stream_error_http_code), new Object[] { Integer.valueOf(j) });
      break label430;
      label263:
      if (i < 3) {
        break label419;
      }
      Log.e("AppBrandImageHttpFetcher", "too much redirection!");
      locala.errorMsg = MMApplicationContext.getContext().getString(a.e.appbrand_game_image_stream_error_http_redirect);
    }
  }
  
  public final String qG()
  {
    return "http";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.b.a.b
 * JD-Core Version:    0.7.0.1
 */