package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class y
{
  public HttpsURLConnection imE;
  
  public y(String paramString)
  {
    this(new URL(paramString));
    AppMethodBeat.i(132883);
    AppMethodBeat.o(132883);
  }
  
  private y(URL paramURL)
  {
    AppMethodBeat.i(132884);
    this.imE = null;
    try
    {
      this.imE = ((HttpsURLConnection)paramURL.openConnection());
      AppMethodBeat.o(132884);
      return;
    }
    catch (MalformedURLException paramURL)
    {
      ac.e("MicroMsg.MMHttpsUrlConnection", "MalformedURLException : %s", new Object[] { paramURL.getMessage() });
      ac.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bs.m(paramURL) });
      AppMethodBeat.o(132884);
      return;
    }
    catch (IOException paramURL)
    {
      ac.e("MicroMsg.MMHttpsUrlConnection", "IOException : %s", new Object[] { paramURL.getMessage() });
      ac.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bs.m(paramURL) });
      AppMethodBeat.o(132884);
      return;
    }
    catch (Exception paramURL)
    {
      ac.e("MicroMsg.MMHttpsUrlConnection", "Exception :" + paramURL.getMessage());
      ac.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bs.m(paramURL) });
      AppMethodBeat.o(132884);
    }
  }
  
  public final void Fh(String paramString)
  {
    AppMethodBeat.i(132888);
    this.imE.setRequestProperty("Referer", paramString);
    AppMethodBeat.o(132888);
  }
  
  public final void aLR()
  {
    AppMethodBeat.i(132889);
    this.imE.setUseCaches(true);
    AppMethodBeat.o(132889);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(132885);
    if (this.imE != null) {}
    try
    {
      this.imE.getInputStream().close();
      this.imE.disconnect();
      AppMethodBeat.o(132885);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.MMHttpsUrlConnection", localException.getMessage());
      }
    }
  }
  
  public final InputStream getInputStream()
  {
    AppMethodBeat.i(210308);
    InputStream localInputStream = this.imE.getInputStream();
    AppMethodBeat.o(210308);
    return localInputStream;
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    AppMethodBeat.i(132886);
    this.imE.setConnectTimeout(paramInt);
    AppMethodBeat.o(132886);
  }
  
  public final void setReadTimeout(int paramInt)
  {
    AppMethodBeat.i(132887);
    this.imE.setReadTimeout(paramInt);
    AppMethodBeat.o(132887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.y
 * JD-Core Version:    0.7.0.1
 */