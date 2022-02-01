package com.tencent.mm.loader.d;

import com.tencent.mm.loader.c.b.b;
import com.tencent.mm.loader.e.g;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class b
  extends com.tencent.mm.loader.c.b<String>
{
  public final void a(a<String> parama, g paramg, b.b paramb)
  {
    Log.i("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data from url:%s", new Object[] { parama });
    try
    {
      paramb.a(a.GI((String)parama.bmg()));
      return;
    }
    catch (InterruptedException parama)
    {
      Log.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { Util.stackTraceToString(parama) });
      Log.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] onError");
      paramb.atR();
      return;
    }
    catch (UnknownHostException parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { Util.stackTraceToString(parama) });
      }
    }
    catch (SSLHandshakeException parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { Util.stackTraceToString(parama) });
      }
    }
    catch (SocketException parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { Util.stackTraceToString(parama) });
      }
    }
    catch (SocketTimeoutException parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { Util.stackTraceToString(parama) });
      }
    }
    catch (IOException parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { Util.stackTraceToString(parama) });
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { Util.stackTraceToString(parama) });
      }
    }
  }
  
  static final class a
  {
    public static com.tencent.mm.loader.g.b GI(String paramString)
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setConnectTimeout(15000);
      paramString.setReadTimeout(20000);
      if (paramString == null) {
        Log.i("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", "open connection failed.");
      }
      if (paramString.getResponseCode() >= 300) {
        try
        {
          paramString.getInputStream().close();
          paramString.disconnect();
          Log.w("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", "dz[httpURLConnectionGet 300]");
          return null;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Log.e("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", localException1.getMessage());
          }
        }
      }
      Object localObject = paramString.getInputStream();
      String str = paramString.getContentType();
      localObject = e.B((InputStream)localObject);
      try
      {
        paramString.getInputStream().close();
        paramString.disconnect();
        return com.tencent.mm.loader.g.b.d((byte[])localObject, str);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", localException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.d.b
 * JD-Core Version:    0.7.0.1
 */