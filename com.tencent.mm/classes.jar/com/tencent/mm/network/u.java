package com.tencent.mm.network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class u
{
  public HttpURLConnection aRG;
  public Map<String, List<String>> aRP = null;
  public int eNz;
  public String eOw;
  public URL url;
  
  public u(URL paramURL, int paramInt)
  {
    this.url = paramURL;
    this.eNz = paramInt;
    this.aRG = ((HttpURLConnection)this.url.openConnection());
    if (1 == this.eNz) {
      this.aRG.setInstanceFollowRedirects(false);
    }
  }
  
  public final void Ud()
  {
    this.aRG.setDoInput(true);
  }
  
  public final void Ue()
  {
    this.aRG.setDoOutput(true);
  }
  
  public final void connect()
  {
    if ((1 == this.eNz) && (this.aRP == null)) {
      this.aRP = this.aRG.getRequestProperties();
    }
    this.aRG.connect();
  }
  
  public final String getHeaderField(String paramString)
  {
    if ((1 == this.eNz) && (this.aRP == null)) {
      this.aRP = this.aRG.getRequestProperties();
    }
    return this.aRG.getHeaderField(paramString);
  }
  
  public final Map<String, List<String>> getHeaderFields()
  {
    if ((1 == this.eNz) && (this.aRP == null)) {
      this.aRP = this.aRG.getRequestProperties();
    }
    return this.aRG.getHeaderFields();
  }
  
  public final InputStream getInputStream()
  {
    if (1 == this.eNz)
    {
      if (this.aRP == null) {
        this.aRP = this.aRG.getRequestProperties();
      }
      getResponseCode();
    }
    return this.aRG.getInputStream();
  }
  
  public final OutputStream getOutputStream()
  {
    if (1 == this.eNz)
    {
      if (this.aRP == null) {
        this.aRP = this.aRG.getRequestProperties();
      }
      getResponseCode();
    }
    return this.aRG.getOutputStream();
  }
  
  public final int getResponseCode()
  {
    for (;;)
    {
      if ((1 == this.eNz) && (this.aRP == null)) {
        this.aRP = this.aRG.getRequestProperties();
      }
      int i = this.aRG.getResponseCode();
      Object localObject;
      if ((1 == this.eNz) && (302 == i))
      {
        localObject = this.aRG.getHeaderField("Location");
        if (localObject != null) {}
      }
      else
      {
        return i;
      }
      this.url = new URL(this.url, (String)localObject);
      this.aRG = ((HttpURLConnection)this.url.openConnection());
      this.aRG.setInstanceFollowRedirects(false);
      if (this.aRP != null)
      {
        localObject = this.aRP.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if ((!str.equals("Host")) && (!str.equals("X-Online-Host")))
          {
            List localList = (List)this.aRP.get(str);
            i = 0;
            while (i < localList.size())
            {
              this.aRG.setRequestProperty(str, (String)localList.get(i));
              i += 1;
            }
          }
        }
      }
      this.aRG.setRequestProperty("Host", this.url.getHost());
      this.aRG.setRequestProperty("X-Online-Host", this.url.getHost());
    }
  }
  
  public final void oM(String paramString)
  {
    this.aRG.setRequestProperty("Referer", paramString);
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    this.aRG.setConnectTimeout(paramInt);
  }
  
  public final void setReadTimeout(int paramInt)
  {
    this.aRG.setReadTimeout(paramInt);
  }
  
  public final void setRequestMethod(String paramString)
  {
    this.aRG.setRequestMethod(paramString);
  }
  
  public final void setRequestProperty(String paramString1, String paramString2)
  {
    this.aRG.setRequestProperty(paramString1, paramString2);
  }
  
  public final void setUseCaches(boolean paramBoolean)
  {
    this.aRG.setUseCaches(paramBoolean);
  }
  
  public final String toString()
  {
    return this.aRG.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.u
 * JD-Core Version:    0.7.0.1
 */