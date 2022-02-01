package com.tencent.luggage.game.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b.a;
import com.tencent.luggage.wxa.a.a.f;
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
  private int cEM;
  private int cEN;
  private final String ekO;
  private d.c ekP;
  
  public b(d.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(220120);
    this.cEM = 60000;
    this.cEN = 60000;
    this.ekP = paramc;
    int i = paramc.aoR();
    int j = paramc.aoT();
    if ((i <= 0) || (j <= 0)) {}
    for (;;)
    {
      this.ekO = paramc.getUserAgentString();
      AppMethodBeat.o(220120);
      return;
      this.cEM = i;
      this.cEN = j;
      Log.i("AppBrandImageHttpFetcher", "Http Timeout Set: connection[%d] read[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    }
  }
  
  public final String Qj()
  {
    return "http";
  }
  
  public final b.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(220129);
    locala = new b.a();
    String str2 = this.ekP.a(paramImageDecodeConfig.mReferrerPolicy);
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
        Log.e("AppBrandImageHttpFetcher", "ImageFetch Timeout! path[%s] connectionTimeout[%d] readTimeout[%d] error[%s]", new Object[] { paramObject, Integer.valueOf(this.cEM), Integer.valueOf(this.cEN), paramImageDecodeConfig.toString() });
        locala.errorMsg = MMApplicationContext.getContext().getString(a.f.appbrand_game_image_stream_error_http_timeout);
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
        locala.errorMsg = String.format(MMApplicationContext.getContext().getString(a.f.appbrand_game_image_stream_error_http_inner), new Object[] { paramImageDecodeConfig.toString() });
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
    localHttpURLConnection.setRequestProperty("User-Agent", this.ekO);
    localHttpURLConnection.setReadTimeout(this.cEN);
    localHttpURLConnection.setConnectTimeout(this.cEM);
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
      locala.inputStream = paramObject;
      AppMethodBeat.o(220129);
      return locala;
      if ((j >= 200) && (j < 300)) {
        break label430;
      }
      locala.errorMsg = String.format(MMApplicationContext.getContext().getString(a.f.appbrand_game_image_stream_error_http_code), new Object[] { Integer.valueOf(j) });
      break label430;
      label263:
      if (i < 3) {
        break label419;
      }
      Log.e("AppBrandImageHttpFetcher", "too much redirection!");
      locala.errorMsg = MMApplicationContext.getContext().getString(a.f.appbrand_game_image_stream_error_http_redirect);
    }
  }
  
  public final boolean be(Object paramObject)
  {
    AppMethodBeat.i(220123);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(220123);
      return false;
    }
    if ((((String)paramObject).startsWith("http://")) || (((String)paramObject).startsWith("https://")))
    {
      AppMethodBeat.o(220123);
      return true;
    }
    AppMethodBeat.o(220123);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.b.a.b
 * JD-Core Version:    0.7.0.1
 */