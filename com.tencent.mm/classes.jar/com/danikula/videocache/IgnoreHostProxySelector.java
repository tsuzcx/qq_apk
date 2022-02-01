package com.danikula.videocache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

class IgnoreHostProxySelector
  extends ProxySelector
{
  private static final List<Proxy> NO_PROXY_LIST;
  private final ProxySelector defaultProxySelector;
  private final String hostToIgnore;
  private final int portToIgnore;
  
  static
  {
    AppMethodBeat.i(183599);
    NO_PROXY_LIST = Arrays.asList(new Proxy[] { Proxy.NO_PROXY });
    AppMethodBeat.o(183599);
  }
  
  IgnoreHostProxySelector(ProxySelector paramProxySelector, String paramString, int paramInt)
  {
    AppMethodBeat.i(183595);
    this.defaultProxySelector = ((ProxySelector)Preconditions.checkNotNull(paramProxySelector));
    this.hostToIgnore = ((String)Preconditions.checkNotNull(paramString));
    this.portToIgnore = paramInt;
    AppMethodBeat.o(183595);
  }
  
  static void install(String paramString, int paramInt)
  {
    AppMethodBeat.i(183596);
    ProxySelector.setDefault(new IgnoreHostProxySelector(ProxySelector.getDefault(), paramString, paramInt));
    AppMethodBeat.o(183596);
  }
  
  public void connectFailed(URI paramURI, SocketAddress paramSocketAddress, IOException paramIOException)
  {
    AppMethodBeat.i(183598);
    this.defaultProxySelector.connectFailed(paramURI, paramSocketAddress, paramIOException);
    AppMethodBeat.o(183598);
  }
  
  public List<Proxy> select(URI paramURI)
  {
    AppMethodBeat.i(183597);
    if ((this.hostToIgnore.equals(paramURI.getHost())) && (this.portToIgnore == paramURI.getPort())) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramURI = NO_PROXY_LIST;
      AppMethodBeat.o(183597);
      return paramURI;
    }
    paramURI = this.defaultProxySelector.select(paramURI);
    AppMethodBeat.o(183597);
    return paramURI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.danikula.videocache.IgnoreHostProxySelector
 * JD-Core Version:    0.7.0.1
 */