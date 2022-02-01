package com.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

final class i
  extends ProxySelector
{
  private static final List<Proxy> aFx;
  private final int aFA;
  private final ProxySelector aFy;
  private final String aFz;
  
  static
  {
    AppMethodBeat.i(183599);
    aFx = Arrays.asList(new Proxy[] { Proxy.NO_PROXY });
    AppMethodBeat.o(183599);
  }
  
  private i(ProxySelector paramProxySelector, String paramString, int paramInt)
  {
    AppMethodBeat.i(183595);
    this.aFy = ((ProxySelector)l.checkNotNull(paramProxySelector));
    this.aFz = ((String)l.checkNotNull(paramString));
    this.aFA = paramInt;
    AppMethodBeat.o(183595);
  }
  
  static void l(String paramString, int paramInt)
  {
    AppMethodBeat.i(183596);
    ProxySelector.setDefault(new i(ProxySelector.getDefault(), paramString, paramInt));
    AppMethodBeat.o(183596);
  }
  
  public final void connectFailed(URI paramURI, SocketAddress paramSocketAddress, IOException paramIOException)
  {
    AppMethodBeat.i(183598);
    this.aFy.connectFailed(paramURI, paramSocketAddress, paramIOException);
    AppMethodBeat.o(183598);
  }
  
  public final List<Proxy> select(URI paramURI)
  {
    AppMethodBeat.i(183597);
    if ((this.aFz.equals(paramURI.getHost())) && (this.aFA == paramURI.getPort())) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramURI = aFx;
      AppMethodBeat.o(183597);
      return paramURI;
    }
    paramURI = this.aFy.select(paramURI);
    AppMethodBeat.o(183597);
    return paramURI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.b.a.i
 * JD-Core Version:    0.7.0.1
 */