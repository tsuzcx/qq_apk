package com.tencent.mm.as.a.b;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class b
  implements com.tencent.mm.as.a.c.b
{
  public final com.tencent.mm.as.a.d.b ms(String paramString)
  {
    y.d("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data from url:%s", new Object[] { paramString });
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setConnectTimeout(15000);
      paramString.setReadTimeout(20000);
      if (paramString == null) {
        y.i("MicroMsg.imageload.DefaultImageDownloader.HttpClientFactory", "open connection failed.");
      }
      if (paramString.getResponseCode() >= 300)
      {
        paramString.disconnect();
        y.w("MicroMsg.imageload.DefaultImageDownloader.HttpClientFactory", "dz[httpURLConnectionGet 300]");
        return null;
      }
      Object localObject = paramString.getInputStream();
      String str = paramString.getContentType();
      localObject = e.r((InputStream)localObject);
      paramString.disconnect();
      paramString = new com.tencent.mm.as.a.d.b((byte[])localObject, str);
      return paramString;
    }
    catch (InterruptedException paramString)
    {
      y.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bk.j(paramString) });
      return new com.tencent.mm.as.a.d.b(null, null);
    }
    catch (UnknownHostException paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bk.j(paramString) });
      }
    }
    catch (SSLHandshakeException paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bk.j(paramString) });
      }
    }
    catch (SocketException paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bk.j(paramString) });
      }
    }
    catch (SocketTimeoutException paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bk.j(paramString) });
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bk.j(paramString) });
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bk.j(paramString) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.as.a.b.b
 * JD-Core Version:    0.7.0.1
 */