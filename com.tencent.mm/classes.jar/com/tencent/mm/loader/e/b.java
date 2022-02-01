package com.tencent.mm.loader.e;

import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  public final void a(a<String> parama, g paramg, b.b paramb)
  {
    ae.i("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data from url:%s", new Object[] { parama });
    try
    {
      paramb.a(a.yK((String)parama.value()));
      return;
    }
    catch (InterruptedException parama)
    {
      ae.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bu.o(parama) });
      ae.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] onError");
      paramb.onError();
      return;
    }
    catch (UnknownHostException parama)
    {
      for (;;)
      {
        ae.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bu.o(parama) });
      }
    }
    catch (SSLHandshakeException parama)
    {
      for (;;)
      {
        ae.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bu.o(parama) });
      }
    }
    catch (SocketException parama)
    {
      for (;;)
      {
        ae.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bu.o(parama) });
      }
    }
    catch (SocketTimeoutException parama)
    {
      for (;;)
      {
        ae.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bu.o(parama) });
      }
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ae.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bu.o(parama) });
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ae.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bu.o(parama) });
      }
    }
  }
  
  static final class a
  {
    public static com.tencent.mm.loader.h.b yK(String paramString)
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setConnectTimeout(15000);
      paramString.setReadTimeout(20000);
      if (paramString == null) {
        ae.i("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", "open connection failed.");
      }
      if (paramString.getResponseCode() >= 300) {
        try
        {
          paramString.getInputStream().close();
          paramString.disconnect();
          ae.w("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", "dz[httpURLConnectionGet 300]");
          return null;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ae.e("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", localException1.getMessage());
          }
        }
      }
      Object localObject = paramString.getInputStream();
      String str = paramString.getContentType();
      localObject = e.s((InputStream)localObject);
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
          ae.e("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", localException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.e.b
 * JD-Core Version:    0.7.0.1
 */