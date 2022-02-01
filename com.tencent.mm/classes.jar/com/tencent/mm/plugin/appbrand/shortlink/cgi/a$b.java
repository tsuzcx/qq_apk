package com.tencent.mm.plugin.appbrand.shortlink.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "", "(Ljava/lang/String;I)V", "BusinessTypeNone", "BusinessTypeWxaBase", "BusinessTypeOpenSdk", "BusinessTypeVideoAct", "luggage-wechat-full-sdk_release"})
public enum a$b
{
  static
  {
    AppMethodBeat.i(230177);
    b localb1 = new b("BusinessTypeNone", 0);
    nNW = localb1;
    b localb2 = new b("BusinessTypeWxaBase", 1);
    nNX = localb2;
    b localb3 = new b("BusinessTypeOpenSdk", 2);
    nNY = localb3;
    b localb4 = new b("BusinessTypeVideoAct", 3);
    nNZ = localb4;
    nOa = new b[] { localb1, localb2, localb3, localb4 };
    AppMethodBeat.o(230177);
  }
  
  private a$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.cgi.a.b
 * JD-Core Version:    0.7.0.1
 */