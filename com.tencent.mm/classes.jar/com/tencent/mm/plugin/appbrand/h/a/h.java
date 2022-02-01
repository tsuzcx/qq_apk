package com.tencent.mm.plugin.appbrand.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  implements d
{
  private boolean jIw;
  
  public h(boolean paramBoolean)
  {
    this.jIw = paramBoolean;
  }
  
  private static String cD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(200798);
    paramString1 = "M-SEARCH * HTTP/1.1\r\nST:" + paramString1 + "\r\nHOST: " + paramString2 + ":1900\r\nMX: 3\r\nMAN: \"ssdp:discover\"\r\n\r\n";
    AppMethodBeat.o(200798);
    return paramString1;
  }
  
  public final String bbC()
  {
    AppMethodBeat.i(158891);
    if (this.jIw)
    {
      str = cD("ssdp:all", "[FF0x::C]");
      AppMethodBeat.o(158891);
      return str;
    }
    String str = cD("ssdp:all", "239.255.255.250");
    AppMethodBeat.o(158891);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.a.h
 * JD-Core Version:    0.7.0.1
 */