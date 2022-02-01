package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class y
{
  public HttpsURLConnection hMh;
  
  public y(String paramString)
  {
    this(new URL(paramString));
    AppMethodBeat.i(132883);
    AppMethodBeat.o(132883);
  }
  
  private y(URL paramURL)
  {
    AppMethodBeat.i(132884);
    this.hMh = null;
    try
    {
      this.hMh = ((HttpsURLConnection)paramURL.openConnection());
      AppMethodBeat.o(132884);
      return;
    }
    catch (MalformedURLException paramURL)
    {
      ad.e("MicroMsg.MMHttpsUrlConnection", "MalformedURLException : %s", new Object[] { paramURL.getMessage() });
      ad.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bt.m(paramURL) });
      AppMethodBeat.o(132884);
      return;
    }
    catch (IOException paramURL)
    {
      ad.e("MicroMsg.MMHttpsUrlConnection", "IOException : %s", new Object[] { paramURL.getMessage() });
      ad.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bt.m(paramURL) });
      AppMethodBeat.o(132884);
      return;
    }
    catch (Exception paramURL)
    {
      ad.e("MicroMsg.MMHttpsUrlConnection", "Exception :" + paramURL.getMessage());
      ad.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bt.m(paramURL) });
      AppMethodBeat.o(132884);
    }
  }
  
  public final void Bc(String paramString)
  {
    AppMethodBeat.i(132888);
    this.hMh.setRequestProperty("Referer", paramString);
    AppMethodBeat.o(132888);
  }
  
  public final void aFa()
  {
    AppMethodBeat.i(132889);
    this.hMh.setUseCaches(true);
    AppMethodBeat.o(132889);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(132885);
    if (this.hMh != null) {}
    try
    {
      this.hMh.getInputStream().close();
      this.hMh.disconnect();
      AppMethodBeat.o(132885);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.MMHttpsUrlConnection", localException.getMessage());
      }
    }
  }
  
  public final InputStream getInputStream()
  {
    AppMethodBeat.i(202272);
    InputStream localInputStream = this.hMh.getInputStream();
    AppMethodBeat.o(202272);
    return localInputStream;
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    AppMethodBeat.i(132886);
    this.hMh.setConnectTimeout(paramInt);
    AppMethodBeat.o(132886);
  }
  
  public final void setReadTimeout(int paramInt)
  {
    AppMethodBeat.i(132887);
    this.hMh.setReadTimeout(paramInt);
    AppMethodBeat.o(132887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.y
 * JD-Core Version:    0.7.0.1
 */