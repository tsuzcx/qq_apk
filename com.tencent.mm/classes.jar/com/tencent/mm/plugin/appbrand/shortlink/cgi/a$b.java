package com.tencent.mm.plugin.appbrand.shortlink.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "", "(Ljava/lang/String;I)V", "BusinessTypeNone", "BusinessTypeWxaBase", "BusinessTypeOpenSdk", "BusinessTypeVideoAct", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a$b
{
  static
  {
    AppMethodBeat.i(321868);
    tVe = new b("BusinessTypeNone", 0);
    tVf = new b("BusinessTypeWxaBase", 1);
    tVg = new b("BusinessTypeOpenSdk", 2);
    tVh = new b("BusinessTypeVideoAct", 3);
    tVi = new b[] { tVe, tVf, tVg, tVh };
    AppMethodBeat.o(321868);
  }
  
  private a$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.cgi.a.b
 * JD-Core Version:    0.7.0.1
 */