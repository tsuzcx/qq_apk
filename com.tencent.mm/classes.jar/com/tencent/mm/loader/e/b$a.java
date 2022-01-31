package com.tencent.mm.loader.e;

import com.tencent.mm.loader.h.b;
import com.tencent.mm.loader.h.b.1;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

final class b$a
{
  public static b mL(String paramString)
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setConnectTimeout(15000);
    paramString.setReadTimeout(20000);
    if (paramString == null) {
      ab.i("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", "open connection failed.");
    }
    if (paramString.getResponseCode() >= 300) {
      try
      {
        paramString.getInputStream().close();
        paramString.disconnect();
        ab.w("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", "dz[httpURLConnectionGet 300]");
        return null;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          ab.e("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", localException1.getMessage());
        }
      }
    }
    Object localObject = paramString.getInputStream();
    String str = paramString.getContentType();
    localObject = d.a((InputStream)localObject, false);
    try
    {
      paramString.getInputStream().close();
      paramString.disconnect();
      return new b((byte[])localObject, str, new b.1((byte[])localObject));
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ab.e("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", localException2.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.a
 * JD-Core Version:    0.7.0.1
 */