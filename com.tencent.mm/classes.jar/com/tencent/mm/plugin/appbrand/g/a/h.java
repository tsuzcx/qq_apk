package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  implements d
{
  private boolean kcI;
  
  public h(boolean paramBoolean)
  {
    this.kcI = paramBoolean;
  }
  
  private static String cF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192860);
    paramString1 = "M-SEARCH * HTTP/1.1\r\nST:" + paramString1 + "\r\nHOST: " + paramString2 + ":1900\r\nMX: 3\r\nMAN: \"ssdp:discover\"\r\n\r\n";
    AppMethodBeat.o(192860);
    return paramString1;
  }
  
  public final String bfg()
  {
    AppMethodBeat.i(158891);
    if (this.kcI)
    {
      str = cF("ssdp:all", "[FF0x::C]");
      AppMethodBeat.o(158891);
      return str;
    }
    String str = cF("ssdp:all", "239.255.255.250");
    AppMethodBeat.o(158891);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a.h
 * JD-Core Version:    0.7.0.1
 */