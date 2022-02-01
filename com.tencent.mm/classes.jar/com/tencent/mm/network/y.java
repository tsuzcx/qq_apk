package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class y
  implements z
{
  public HttpURLConnection connection;
  public int pnI;
  String poY;
  public Map<String, List<String>> requestProperties;
  public URL url;
  
  public y(URL paramURL, int paramInt)
  {
    AppMethodBeat.i(132849);
    this.requestProperties = null;
    this.url = paramURL;
    this.pnI = paramInt;
    this.connection = ((HttpURLConnection)this.url.openConnection());
    if (1 == this.pnI) {
      this.connection.setInstanceFollowRedirects(false);
    }
    AppMethodBeat.o(132849);
  }
  
  public final void Rx(String paramString)
  {
    AppMethodBeat.i(132852);
    this.connection.setRequestMethod(paramString);
    AppMethodBeat.o(132852);
  }
  
  public final void Ry(String paramString)
  {
    AppMethodBeat.i(132867);
    this.connection.setRequestProperty("Referer", paramString);
    AppMethodBeat.o(132867);
  }
  
  public final int bRd()
  {
    AppMethodBeat.i(132854);
    int i = this.connection.getContentLength();
    AppMethodBeat.o(132854);
    return i;
  }
  
  public final String bRe()
  {
    AppMethodBeat.i(132855);
    String str = this.connection.getContentType();
    AppMethodBeat.o(132855);
    return str;
  }
  
  public final Map<String, List<String>> bRf()
  {
    AppMethodBeat.i(132856);
    if ((1 == this.pnI) && (this.requestProperties == null)) {
      this.requestProperties = this.connection.getRequestProperties();
    }
    Map localMap = this.connection.getHeaderFields();
    AppMethodBeat.o(132856);
    return localMap;
  }
  
  public final String bRg()
  {
    return this.poY;
  }
  
  public final int bRh()
  {
    return this.pnI;
  }
  
  public final int bk(String paramString, int paramInt)
  {
    AppMethodBeat.i(132858);
    if ((1 == this.pnI) && (this.requestProperties == null)) {
      this.requestProperties = this.connection.getRequestProperties();
    }
    paramInt = this.connection.getHeaderFieldInt(paramString, paramInt);
    AppMethodBeat.o(132858);
    return paramInt;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(132853);
    if ((1 == this.pnI) && (this.requestProperties == null)) {
      this.requestProperties = this.connection.getRequestProperties();
    }
    this.connection.connect();
    AppMethodBeat.o(132853);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(132850);
    if (this.connection != null) {}
    try
    {
      this.connection.getInputStream().close();
      this.connection.disconnect();
      AppMethodBeat.o(132850);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.getMessage();
      }
    }
  }
  
  public final String getHeaderField(String paramString)
  {
    AppMethodBeat.i(132857);
    if ((1 == this.pnI) && (this.requestProperties == null)) {
      this.requestProperties = this.connection.getRequestProperties();
    }
    paramString = this.connection.getHeaderField(paramString);
    AppMethodBeat.o(132857);
    return paramString;
  }
  
  public final String getHost()
  {
    AppMethodBeat.i(132869);
    String str = this.url.getHost();
    AppMethodBeat.o(132869);
    return str;
  }
  
  public final InputStream getInputStream()
  {
    AppMethodBeat.i(132859);
    if (1 == this.pnI)
    {
      if (this.requestProperties == null) {
        this.requestProperties = this.connection.getRequestProperties();
      }
      getResponseCode();
    }
    InputStream localInputStream = this.connection.getInputStream();
    AppMethodBeat.o(132859);
    return localInputStream;
  }
  
  public final int getResponseCode()
  {
    AppMethodBeat.i(132851);
    if ((1 == this.pnI) && (this.requestProperties == null)) {
      this.requestProperties = this.connection.getRequestProperties();
    }
    int i = -1;
    int k;
    try
    {
      k = this.connection.getResponseCode();
      i = k;
      if ((1 != this.pnI) || (302 != k)) {
        break label390;
      }
      i = k;
      Object localObject = this.connection.getHeaderField("Location");
      if (localObject == null)
      {
        AppMethodBeat.o(132851);
        return k;
      }
      i = k;
      this.url = new URL(this.url, (String)localObject);
      try
      {
        this.connection.getInputStream().close();
        i = k;
        this.connection.disconnect();
        i = k;
        this.connection = ((HttpURLConnection)this.url.openConnection());
        i = k;
        this.connection.setInstanceFollowRedirects(false);
        i = k;
        if (this.requestProperties != null)
        {
          i = k;
          localObject = this.requestProperties.keySet().iterator();
          String str;
          do
          {
            do
            {
              i = k;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              i = k;
              str = (String)((Iterator)localObject).next();
              i = k;
            } while (str.equals("Host"));
            i = k;
          } while (str.equals("X-Online-Host"));
          i = k;
          List localList = (List)this.requestProperties.get(str);
          j = 0;
          for (;;)
          {
            i = k;
            if (j >= localList.size()) {
              break;
            }
            i = k;
            this.connection.setRequestProperty(str, (String)localList.get(j));
            j += 1;
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          i = k;
          localException1.getMessage();
        }
      }
      i = k;
    }
    catch (Exception localException2)
    {
      if ((1 == this.pnI) && (200 != i) && (NetStatusUtil.isConnected(MMApplicationContext.getContext()))) {
        d.reportFailIp(this.poY);
      }
      AppMethodBeat.o(132851);
      throw localException2;
    }
    this.connection.setRequestProperty("Host", this.url.getHost());
    i = k;
    this.connection.setRequestProperty("X-Online-Host", this.url.getHost());
    i = k;
    int j = getResponseCode();
    AppMethodBeat.o(132851);
    return j;
    label390:
    if ((1 == this.pnI) && (200 != k) && (NetStatusUtil.isConnected(MMApplicationContext.getContext()))) {
      d.reportFailIp(this.poY);
    }
    AppMethodBeat.o(132851);
    return k;
  }
  
  public final void hB(boolean paramBoolean)
  {
    AppMethodBeat.i(132864);
    this.connection.setUseCaches(paramBoolean);
    AppMethodBeat.o(132864);
  }
  
  public final void setRequestProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132863);
    this.connection.setRequestProperty(paramString1, paramString2);
    AppMethodBeat.o(132863);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(132868);
    String str = this.connection.toString();
    AppMethodBeat.o(132868);
    return str;
  }
  
  public final void xx(int paramInt)
  {
    AppMethodBeat.i(132865);
    this.connection.setConnectTimeout(paramInt);
    AppMethodBeat.o(132865);
  }
  
  public final void xy(int paramInt)
  {
    AppMethodBeat.i(132866);
    this.connection.setReadTimeout(paramInt);
    AppMethodBeat.o(132866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.y
 * JD-Core Version:    0.7.0.1
 */