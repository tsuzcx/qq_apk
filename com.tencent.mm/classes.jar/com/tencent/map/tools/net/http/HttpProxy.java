package com.tencent.map.tools.net.http;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.Proxy;
import java.net.URL;

public class HttpProxy
{
  private final boolean mIsForward;
  private final Proxy mProxy;
  private final String mProxyUrl;
  
  public HttpProxy(Proxy paramProxy, String paramString, boolean paramBoolean)
  {
    this.mProxy = paramProxy;
    this.mProxyUrl = paramString;
    this.mIsForward = paramBoolean;
  }
  
  public static Proxy getForwardProxy(HttpProxy paramHttpProxy)
  {
    AppMethodBeat.i(211016);
    if ((paramHttpProxy != null) && (paramHttpProxy.isForward()))
    {
      paramHttpProxy = paramHttpProxy.getProxy();
      AppMethodBeat.o(211016);
      return paramHttpProxy;
    }
    paramHttpProxy = Proxy.NO_PROXY;
    AppMethodBeat.o(211016);
    return paramHttpProxy;
  }
  
  public static URL getProxyURL(HttpProxy paramHttpProxy)
  {
    AppMethodBeat.i(211012);
    if ((paramHttpProxy != null) && (!paramHttpProxy.isForward()))
    {
      paramHttpProxy = new URL(paramHttpProxy.getProxyUrl());
      AppMethodBeat.o(211012);
      return paramHttpProxy;
    }
    AppMethodBeat.o(211012);
    return null;
  }
  
  public Proxy getProxy()
  {
    return this.mProxy;
  }
  
  public String getProxyUrl()
  {
    return this.mProxyUrl;
  }
  
  public boolean isForward()
  {
    return this.mIsForward;
  }
  
  public String toString()
  {
    AppMethodBeat.i(211026);
    String str = "HttpProxy{mProxy=" + this.mProxy + ", mProxyUrl='" + this.mProxyUrl + '\'' + ", mIsForward=" + this.mIsForward + '}';
    AppMethodBeat.o(211026);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.tools.net.http.HttpProxy
 * JD-Core Version:    0.7.0.1
 */