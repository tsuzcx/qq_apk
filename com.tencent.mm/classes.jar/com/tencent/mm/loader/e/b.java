package com.tencent.mm.loader.e;

import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.loader.f.f;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class b
  extends com.tencent.mm.loader.d.b<String>
{
  public final void a(a<String> parama, f paramf, b.b paramb)
  {
    ab.d("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data from url:%s", new Object[] { parama });
    try
    {
      paramb.a(b.a.mL((String)parama.value()));
      return;
    }
    catch (InterruptedException parama)
    {
      ab.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bo.l(parama) });
      paramb.onError();
      return;
    }
    catch (UnknownHostException parama)
    {
      for (;;)
      {
        ab.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bo.l(parama) });
      }
    }
    catch (SSLHandshakeException parama)
    {
      for (;;)
      {
        ab.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bo.l(parama) });
      }
    }
    catch (SocketException parama)
    {
      for (;;)
      {
        ab.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bo.l(parama) });
      }
    }
    catch (SocketTimeoutException parama)
    {
      for (;;)
      {
        ab.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bo.l(parama) });
      }
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ab.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bo.l(parama) });
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ab.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bo.l(parama) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.loader.e.b
 * JD-Core Version:    0.7.0.1
 */