package com.tencent.mm.network;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class v
{
  public HttpsURLConnection eOx = null;
  
  public v(String paramString)
  {
    this(new URL(paramString));
  }
  
  private v(URL paramURL)
  {
    try
    {
      this.eOx = ((HttpsURLConnection)paramURL.openConnection());
      return;
    }
    catch (MalformedURLException paramURL)
    {
      y.e("MicroMsg.MMHttpsUrlConnection", "MalformedURLException : %s", new Object[] { paramURL.getMessage() });
      y.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bk.j(paramURL) });
      return;
    }
    catch (IOException paramURL)
    {
      y.e("MicroMsg.MMHttpsUrlConnection", "IOException : %s", new Object[] { paramURL.getMessage() });
      y.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bk.j(paramURL) });
      return;
    }
    catch (Exception paramURL)
    {
      y.e("MicroMsg.MMHttpsUrlConnection", "Exception :" + paramURL.getMessage());
      y.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bk.j(paramURL) });
    }
  }
  
  public final void Uf()
  {
    this.eOx.setConnectTimeout(3000);
  }
  
  public final void Ug()
  {
    this.eOx.setReadTimeout(3000);
  }
  
  public final void Uh()
  {
    this.eOx.setUseCaches(true);
  }
  
  public final void oM(String paramString)
  {
    this.eOx.setRequestProperty("Referer", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.v
 * JD-Core Version:    0.7.0.1
 */