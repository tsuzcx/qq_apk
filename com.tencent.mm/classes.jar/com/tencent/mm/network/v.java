package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class v
{
  private Map<String, List<String>> aZp;
  public HttpURLConnection connection;
  public int gdn;
  public String gek;
  public URL url;
  
  public v(URL paramURL, int paramInt)
  {
    AppMethodBeat.i(58618);
    this.aZp = null;
    this.url = paramURL;
    this.gdn = paramInt;
    this.connection = ((HttpURLConnection)this.url.openConnection());
    if (1 == this.gdn) {
      this.connection.setInstanceFollowRedirects(false);
    }
    AppMethodBeat.o(58618);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(58627);
    this.connection.setDoInput(true);
    AppMethodBeat.o(58627);
  }
  
  public final void anr()
  {
    AppMethodBeat.i(58628);
    this.connection.setDoOutput(true);
    AppMethodBeat.o(58628);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(58621);
    if ((1 == this.gdn) && (this.aZp == null)) {
      this.aZp = this.connection.getRequestProperties();
    }
    this.connection.connect();
    AppMethodBeat.o(58621);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(155860);
    if (this.connection != null) {}
    try
    {
      this.connection.getInputStream().close();
      this.connection.disconnect();
      AppMethodBeat.o(155860);
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
    AppMethodBeat.i(58623);
    if ((1 == this.gdn) && (this.aZp == null)) {
      this.aZp = this.connection.getRequestProperties();
    }
    paramString = this.connection.getHeaderField(paramString);
    AppMethodBeat.o(58623);
    return paramString;
  }
  
  public final int getHeaderFieldInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(58624);
    if ((1 == this.gdn) && (this.aZp == null)) {
      this.aZp = this.connection.getRequestProperties();
    }
    paramInt = this.connection.getHeaderFieldInt(paramString, paramInt);
    AppMethodBeat.o(58624);
    return paramInt;
  }
  
  public final Map<String, List<String>> getHeaderFields()
  {
    AppMethodBeat.i(58622);
    if ((1 == this.gdn) && (this.aZp == null)) {
      this.aZp = this.connection.getRequestProperties();
    }
    Map localMap = this.connection.getHeaderFields();
    AppMethodBeat.o(58622);
    return localMap;
  }
  
  public final InputStream getInputStream()
  {
    AppMethodBeat.i(58625);
    if (1 == this.gdn)
    {
      if (this.aZp == null) {
        this.aZp = this.connection.getRequestProperties();
      }
      getResponseCode();
    }
    InputStream localInputStream = this.connection.getInputStream();
    AppMethodBeat.o(58625);
    return localInputStream;
  }
  
  public final OutputStream getOutputStream()
  {
    AppMethodBeat.i(58626);
    if (1 == this.gdn)
    {
      if (this.aZp == null) {
        this.aZp = this.connection.getRequestProperties();
      }
      getResponseCode();
    }
    OutputStream localOutputStream = this.connection.getOutputStream();
    AppMethodBeat.o(58626);
    return localOutputStream;
  }
  
  public final int getResponseCode()
  {
    AppMethodBeat.i(58619);
    if ((1 == this.gdn) && (this.aZp == null)) {
      this.aZp = this.connection.getRequestProperties();
    }
    int i = -1;
    int k;
    try
    {
      k = this.connection.getResponseCode();
      i = k;
      if ((1 != this.gdn) || (302 != k)) {
        break label390;
      }
      i = k;
      Object localObject = this.connection.getHeaderField("Location");
      if (localObject == null)
      {
        AppMethodBeat.o(58619);
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
        if (this.aZp != null)
        {
          i = k;
          localObject = this.aZp.keySet().iterator();
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
          List localList = (List)this.aZp.get(str);
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
      if ((1 == this.gdn) && (200 != i) && (at.isConnected(ah.getContext()))) {
        b.reportFailIp(this.gek);
      }
      AppMethodBeat.o(58619);
      throw localException2;
    }
    this.connection.setRequestProperty("Host", this.url.getHost());
    i = k;
    this.connection.setRequestProperty("X-Online-Host", this.url.getHost());
    i = k;
    int j = getResponseCode();
    AppMethodBeat.o(58619);
    return j;
    label390:
    if ((1 == this.gdn) && (200 != k) && (at.isConnected(ah.getContext()))) {
      b.reportFailIp(this.gek);
    }
    AppMethodBeat.o(58619);
    return k;
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    AppMethodBeat.i(58631);
    this.connection.setConnectTimeout(paramInt);
    AppMethodBeat.o(58631);
  }
  
  public final void setReadTimeout(int paramInt)
  {
    AppMethodBeat.i(58632);
    this.connection.setReadTimeout(paramInt);
    AppMethodBeat.o(58632);
  }
  
  public final void setRequestMethod(String paramString)
  {
    AppMethodBeat.i(58620);
    this.connection.setRequestMethod(paramString);
    AppMethodBeat.o(58620);
  }
  
  public final void setRequestProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(58629);
    this.connection.setRequestProperty(paramString1, paramString2);
    AppMethodBeat.o(58629);
  }
  
  public final void setUseCaches(boolean paramBoolean)
  {
    AppMethodBeat.i(58630);
    this.connection.setUseCaches(paramBoolean);
    AppMethodBeat.o(58630);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58634);
    String str = this.connection.toString();
    AppMethodBeat.o(58634);
    return str;
  }
  
  public final void we(String paramString)
  {
    AppMethodBeat.i(58633);
    this.connection.setRequestProperty("Referer", paramString);
    AppMethodBeat.o(58633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.v
 * JD-Core Version:    0.7.0.1
 */