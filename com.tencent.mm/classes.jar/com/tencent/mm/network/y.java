package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class y
{
  public HttpsURLConnection iIO;
  
  public y(String paramString)
  {
    this(new URL(paramString));
    AppMethodBeat.i(132883);
    AppMethodBeat.o(132883);
  }
  
  private y(URL paramURL)
  {
    AppMethodBeat.i(132884);
    this.iIO = null;
    try
    {
      this.iIO = ((HttpsURLConnection)paramURL.openConnection());
      AppMethodBeat.o(132884);
      return;
    }
    catch (MalformedURLException paramURL)
    {
      ae.e("MicroMsg.MMHttpsUrlConnection", "MalformedURLException : %s", new Object[] { paramURL.getMessage() });
      ae.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bu.o(paramURL) });
      AppMethodBeat.o(132884);
      return;
    }
    catch (IOException paramURL)
    {
      ae.e("MicroMsg.MMHttpsUrlConnection", "IOException : %s", new Object[] { paramURL.getMessage() });
      ae.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bu.o(paramURL) });
      AppMethodBeat.o(132884);
      return;
    }
    catch (Exception paramURL)
    {
      ae.e("MicroMsg.MMHttpsUrlConnection", "Exception :" + paramURL.getMessage());
      ae.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bu.o(paramURL) });
      AppMethodBeat.o(132884);
    }
  }
  
  public final void IX(String paramString)
  {
    AppMethodBeat.i(132888);
    this.iIO.setRequestProperty("Referer", paramString);
    AppMethodBeat.o(132888);
  }
  
  public final void aPw()
  {
    AppMethodBeat.i(132889);
    this.iIO.setUseCaches(true);
    AppMethodBeat.o(132889);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(132885);
    if (this.iIO != null) {}
    try
    {
      this.iIO.getInputStream().close();
      this.iIO.disconnect();
      AppMethodBeat.o(132885);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.MMHttpsUrlConnection", localException.getMessage());
      }
    }
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    AppMethodBeat.i(132886);
    this.iIO.setConnectTimeout(paramInt);
    AppMethodBeat.o(132886);
  }
  
  public final void setReadTimeout(int paramInt)
  {
    AppMethodBeat.i(132887);
    this.iIO.setReadTimeout(paramInt);
    AppMethodBeat.o(132887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.y
 * JD-Core Version:    0.7.0.1
 */