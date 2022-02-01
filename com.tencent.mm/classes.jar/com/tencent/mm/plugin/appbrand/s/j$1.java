package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class j$1
  implements HostnameVerifier
{
  j$1(HostnameVerifier paramHostnameVerifier, ArrayList paramArrayList) {}
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    AppMethodBeat.i(144364);
    if ((this.qjw.verify(paramString, paramSSLSession)) || (j.c(this.qjx, paramString)))
    {
      AppMethodBeat.o(144364);
      return true;
    }
    AppMethodBeat.o(144364);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.j.1
 * JD-Core Version:    0.7.0.1
 */