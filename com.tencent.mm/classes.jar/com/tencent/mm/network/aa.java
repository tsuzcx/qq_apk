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
  public HttpsURLConnection jFs;
  
  public aa(String paramString)
  {
    this(new URL(paramString));
    AppMethodBeat.i(132883);
    AppMethodBeat.o(132883);
  }
  
  private aa(URL paramURL)
  {
    AppMethodBeat.i(132884);
    this.jFs = null;
    try
    {
      this.jFs = ((HttpsURLConnection)paramURL.openConnection());
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
  
  public final void RU(String paramString)
  {
    AppMethodBeat.i(132888);
    this.jFs.setRequestProperty("Referer", paramString);
    AppMethodBeat.o(132888);
  }
  
  public final void bjX()
  {
    AppMethodBeat.i(132889);
    this.jFs.setUseCaches(true);
    AppMethodBeat.o(132889);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(132885);
    if (this.jFs != null) {}
    try
    {
      this.jFs.getInputStream().close();
      this.jFs.disconnect();
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
  
  public final void setConnectTimeout(int paramInt)
  {
    AppMethodBeat.i(132886);
    this.jFs.setConnectTimeout(paramInt);
    AppMethodBeat.o(132886);
  }
  
  public final void setReadTimeout(int paramInt)
  {
    AppMethodBeat.i(132887);
    this.jFs.setReadTimeout(paramInt);
    AppMethodBeat.o(132887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.aa
 * JD-Core Version:    0.7.0.1
 */