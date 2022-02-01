package com.tencent.mm.loader.e;

import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.loader.f.f;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class b
  extends com.tencent.mm.loader.d.b<String>
{
  public final void a(a<String> parama, f paramf, b.b paramb)
  {
    ac.i("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data from url:%s", new Object[] { parama });
    try
    {
      paramb.a(a.vj((String)parama.value()));
      return;
    }
    catch (InterruptedException parama)
    {
      ac.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bs.m(parama) });
      ac.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] onError");
      paramb.onError();
      return;
    }
    catch (UnknownHostException parama)
    {
      for (;;)
      {
        ac.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bs.m(parama) });
      }
    }
    catch (SSLHandshakeException parama)
    {
      for (;;)
      {
        ac.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bs.m(parama) });
      }
    }
    catch (SocketException parama)
    {
      for (;;)
      {
        ac.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bs.m(parama) });
      }
    }
    catch (SocketTimeoutException parama)
    {
      for (;;)
      {
        ac.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bs.m(parama) });
      }
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ac.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bs.m(parama) });
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ac.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bs.m(parama) });
      }
    }
  }
  
  static final class a
  {
    public static com.tencent.mm.loader.h.b vj(String paramString)
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setConnectTimeout(15000);
      paramString.setReadTimeout(20000);
      if (paramString == null) {
        ac.i("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", "open connection failed.");
      }
      if (paramString.getResponseCode() >= 300) {
        try
        {
          paramString.getInputStream().close();
          paramString.disconnect();
          ac.w("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", "dz[httpURLConnectionGet 300]");
          return null;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ac.e("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", localException1.getMessage());
          }
        }
      }
      Object localObject = paramString.getInputStream();
      String str = paramString.getContentType();
      localObject = d.o((InputStream)localObject);
      try
      {
        paramString.getInputStream().close();
        paramString.disconnect();
        return com.tencent.mm.loader.h.b.d((byte[])localObject, str);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ac.e("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", localException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.e.b
 * JD-Core Version:    0.7.0.1
 */