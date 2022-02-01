package com.tencent.mm.plugin.appbrand.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends e
{
  public l(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(158898);
    cC("SOAPACTION", "\"" + paramString2 + "#" + this.jIk + "\"");
    bbD();
    AppMethodBeat.o(158898);
  }
  
  public final String bbB()
  {
    return "Stop";
  }
  
  public final String bbC()
  {
    AppMethodBeat.i(158899);
    String str = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>" + new StringBuilder("<u:").append(this.jIk).append(" xmlns:u=\"").append(this.jIl).append("\">\n<InstanceID>0</InstanceID>\n</u:").append(this.jIk).append(">\n").toString() + "</s:Body></s:Envelope>";
    AppMethodBeat.o(158899);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.a.l
 * JD-Core Version:    0.7.0.1
 */