package com.tencent.mm.plugin.appbrand.m;

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
    AppMethodBeat.i(108186);
    if ((this.iti.verify(paramString, paramSSLSession)) || (j.d(this.itj, paramString)))
    {
      AppMethodBeat.o(108186);
      return true;
    }
    AppMethodBeat.o(108186);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.j.1
 * JD-Core Version:    0.7.0.1
 */