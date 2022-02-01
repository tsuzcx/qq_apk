package com.tencent.luggage.game.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

public final class b
  extends c<c.c>
{
  private int bbs;
  private int bbt;
  private c.c cuI;
  private final String mUserAgent;
  
  public b(c.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(222869);
    this.bbs = 60000;
    this.bbt = 60000;
    this.cuI = paramc;
    int i = paramc.LS();
    int j = paramc.LU();
    if ((i <= 0) || (j <= 0)) {}
    for (;;)
    {
      this.mUserAgent = paramc.getUserAgentString();
      AppMethodBeat.o(222869);
      return;
      this.bbs = i;
      this.bbt = j;
      Log.i("AppBrandImageHttpFetcher", "Http Timeout Set: connection[%d] read[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    }
  }
  
  public final b.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(222871);
    locala = new b.a();
    String str2 = this.cuI.a(paramImageDecodeConfig.mReferrerPolicy);
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
        Log.e("AppBrandImageHttpFetcher", "ImageFetch Timeout! path[%s] connectionTimeout[%d] readTimeout[%d] error[%s]", new Object[] { paramObject, Integer.valueOf(this.bbs), Integer.valueOf(this.bbt), paramImageDecodeConfig.toString() });
        locala.errorMsg = MMApplicationContext.getContext().getString(2131756071);
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
        locala.errorMsg = String.format(MMApplicationContext.getContext().getString(2131756069), new Object[] { paramImageDecodeConfig.toString() });
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
    localHttpURLConnection.setReadTimeout(this.bbt);
    localHttpURLConnection.setConnectTimeout(this.bbs);
    j = localHttpURLConnection.getResponseCode();
    if ((j == 301) || (j == 302))
    {
      str1 = localHttpURLConnection.getHeaderField("location");
      Log.i("AppBrandImageHttpFetcher", "redirect from[%s] to[%s]", new Object[] { localObject1, str1 });
      localHttpURLConnection.disconnect();
      if (str1 != null) {
        break label262;
      }
    }
    for (paramImageDecodeConfig = null; (paramImageDecodeConfig != null) && (TextUtils.isEmpty(locala.errorMsg)); paramImageDecodeConfig = null)
    {
      paramImageDecodeConfig = new BufferedInputStream(paramImageDecodeConfig.getInputStream());
      paramObject = paramImageDecodeConfig;
      locala.inputStream = paramObject;
      AppMethodBeat.o(222871);
      return locala;
      if ((j >= 200) && (j < 300)) {
        break label426;
      }
      locala.errorMsg = String.format(MMApplicationContext.getContext().getString(2131756068), new Object[] { Integer.valueOf(j) });
      break label426;
      label262:
      if (i < 3) {
        break label415;
      }
      Log.e("AppBrandImageHttpFetcher", "too much redirection!");
      locala.errorMsg = MMApplicationContext.getContext().getString(2131756070);
    }
  }
  
  public final boolean accept(Object paramObject)
  {
    AppMethodBeat.i(222870);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(222870);
      return false;
    }
    if ((((String)paramObject).startsWith("http://")) || (((String)paramObject).startsWith("https://")))
    {
      AppMethodBeat.o(222870);
      return true;
    }
    AppMethodBeat.o(222870);
    return false;
  }
  
  public final String sS()
  {
    return "http";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.b.a.b
 * JD-Core Version:    0.7.0.1
 */