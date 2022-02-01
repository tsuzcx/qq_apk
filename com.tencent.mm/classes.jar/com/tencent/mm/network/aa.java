package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class aa
{
  public HttpsURLConnection mvV;
  
  public aa(String paramString)
  {
    this(new URL(paramString));
    AppMethodBeat.i(132883);
    AppMethodBeat.o(132883);
  }
  
  private aa(URL paramURL)
  {
    AppMethodBeat.i(132884);
    this.mvV = null;
    try
    {
      this.mvV = ((HttpsURLConnection)paramURL.openConnection());
      AppMethodBeat.o(132884);
      return;
    }
    catch (MalformedURLException paramURL)
    {
      Log.e("MicroMsg.MMHttpsUrlConnection", "MalformedURLException : %s", new Object[] { paramURL.getMessage() });
      Log.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { Util.stackTraceToString(paramURL) });
      AppMethodBeat.o(132884);
      return;
    }
    catch (IOException paramURL)
    {
      Log.e("MicroMsg.MMHttpsUrlConnection", "IOException : %s", new Object[] { paramURL.getMessage() });
      Log.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { Util.stackTraceToString(paramURL) });
      AppMethodBeat.o(132884);
      return;
    }
    catch (Exception paramURL)
    {
      Log.e("MicroMsg.MMHttpsUrlConnection", "Exception :" + paramURL.getMessage());
      Log.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { Util.stackTraceToString(paramURL) });
      AppMethodBeat.o(132884);
    }
  }
  
  public final void Zw(String paramString)
  {
    AppMethodBeat.i(132888);
    this.mvV.setRequestProperty("Referer", paramString);
    AppMethodBeat.o(132888);
  }
  
  public final void btG()
  {
    AppMethodBeat.i(132889);
    this.mvV.setUseCaches(true);
    AppMethodBeat.o(132889);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(132885);
    if (this.mvV != null) {}
    try
    {
      this.mvV.getInputStream().close();
      this.mvV.disconnect();
      AppMethodBeat.o(132885);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.MMHttpsUrlConnection", localException.getMessage());
      }
    }
  }
  
  public final void xA(int paramInt)
  {
    AppMethodBeat.i(132887);
    this.mvV.setReadTimeout(paramInt);
    AppMethodBeat.o(132887);
  }
  
  public final void xz(int paramInt)
  {
    AppMethodBeat.i(132886);
    this.mvV.setConnectTimeout(paramInt);
    AppMethodBeat.o(132886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.aa
 * JD-Core Version:    0.7.0.1
 */