package com.github.henryye.nativeiv.b;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

public final class a
  implements b
{
  public int bbx = 60000;
  public int bby = 60000;
  
  public final b.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(209419);
    paramImageDecodeConfig = new b.a();
    try
    {
      URLConnection localURLConnection = new URL((String)paramObject).openConnection();
      localURLConnection.setReadTimeout(this.bby);
      localURLConnection.setConnectTimeout(this.bbx);
      paramImageDecodeConfig.inputStream = new BufferedInputStream(localURLConnection.getInputStream());
      AppMethodBeat.o(209419);
      return paramImageDecodeConfig;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      for (;;)
      {
        paramImageDecodeConfig.errorMsg = "http请求超时";
        com.github.henryye.nativeiv.a.b.e("NativeImageHttpFetcher", "ImageFetch Timeout! path[%s] connectionTimeout[%d] readTimeout[%d] error[%s]", new Object[] { paramObject, Integer.valueOf(this.bbx), Integer.valueOf(this.bby), localSocketTimeoutException.toString() });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramImageDecodeConfig.errorMsg = "http请求出现错误";
        com.github.henryye.nativeiv.a.b.e("NativeImageHttpFetcher", "fetch error. path = [%s], error = [%s]", new Object[] { paramObject, localException.toString() });
      }
    }
  }
  
  public final boolean accept(Object paramObject)
  {
    AppMethodBeat.i(127391);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(127391);
      return false;
    }
    if ((((String)paramObject).startsWith("http://")) || (((String)paramObject).startsWith("https://")))
    {
      AppMethodBeat.o(127391);
      return true;
    }
    AppMethodBeat.o(127391);
    return false;
  }
  
  public final String sP()
  {
    return "http";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.github.henryye.nativeiv.b.a
 * JD-Core Version:    0.7.0.1
 */