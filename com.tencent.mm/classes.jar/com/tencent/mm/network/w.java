package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class w
{
  public HttpsURLConnection gel;
  
  public w(String paramString)
  {
    this(new URL(paramString));
    AppMethodBeat.i(58635);
    AppMethodBeat.o(58635);
  }
  
  private w(URL paramURL)
  {
    AppMethodBeat.i(58636);
    this.gel = null;
    try
    {
      this.gel = ((HttpsURLConnection)paramURL.openConnection());
      AppMethodBeat.o(58636);
      return;
    }
    catch (MalformedURLException paramURL)
    {
      ab.e("MicroMsg.MMHttpsUrlConnection", "MalformedURLException : %s", new Object[] { paramURL.getMessage() });
      ab.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bo.l(paramURL) });
      AppMethodBeat.o(58636);
      return;
    }
    catch (IOException paramURL)
    {
      ab.e("MicroMsg.MMHttpsUrlConnection", "IOException : %s", new Object[] { paramURL.getMessage() });
      ab.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bo.l(paramURL) });
      AppMethodBeat.o(58636);
      return;
    }
    catch (Exception paramURL)
    {
      ab.e("MicroMsg.MMHttpsUrlConnection", "Exception :" + paramURL.getMessage());
      ab.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bo.l(paramURL) });
      AppMethodBeat.o(58636);
    }
  }
  
  public final void ans()
  {
    AppMethodBeat.i(58640);
    this.gel.setUseCaches(true);
    AppMethodBeat.o(58640);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(155861);
    if (this.gel != null) {}
    try
    {
      this.gel.getInputStream().close();
      this.gel.disconnect();
      AppMethodBeat.o(155861);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.MMHttpsUrlConnection", localException.getMessage());
      }
    }
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    AppMethodBeat.i(146148);
    this.gel.setConnectTimeout(paramInt);
    AppMethodBeat.o(146148);
  }
  
  public final void setReadTimeout(int paramInt)
  {
    AppMethodBeat.i(146149);
    this.gel.setReadTimeout(paramInt);
    AppMethodBeat.o(146149);
  }
  
  public final void we(String paramString)
  {
    AppMethodBeat.i(58639);
    this.gel.setRequestProperty("Referer", paramString);
    AppMethodBeat.o(58639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.w
 * JD-Core Version:    0.7.0.1
 */