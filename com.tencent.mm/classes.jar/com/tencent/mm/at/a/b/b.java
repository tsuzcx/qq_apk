package com.tencent.mm.at.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class b
  implements com.tencent.mm.at.a.c.b
{
  public final com.tencent.mm.at.a.d.b tB(String paramString)
  {
    AppMethodBeat.i(116082);
    ab.d("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data from url:%s", new Object[] { paramString });
    try
    {
      paramString = b.a.tC(paramString);
      AppMethodBeat.o(116082);
      return paramString;
    }
    catch (InterruptedException paramString)
    {
      ab.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bo.l(paramString) });
      paramString = new com.tencent.mm.at.a.d.b(null, null);
      AppMethodBeat.o(116082);
      return paramString;
    }
    catch (UnknownHostException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bo.l(paramString) });
      }
    }
    catch (SSLHandshakeException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bo.l(paramString) });
      }
    }
    catch (SocketException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bo.l(paramString) });
      }
    }
    catch (SocketTimeoutException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bo.l(paramString) });
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bo.l(paramString) });
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bo.l(paramString) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.at.a.b.b
 * JD-Core Version:    0.7.0.1
 */