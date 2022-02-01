package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends e
{
  public f(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(158887);
    de("SOAPACTION", "\"" + paramString2 + "#" + this.oef + "\"");
    bMD();
    AppMethodBeat.o(158887);
  }
  
  public final String bMB()
  {
    return "Pause";
  }
  
  public final String bMC()
  {
    AppMethodBeat.i(158888);
    String str = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>" + new StringBuilder("<u:").append(this.oef).append(" xmlns:u=\"").append(this.oeg).append("\">\n<InstanceID>0</InstanceID>\n</u:").append(this.oef).append(">\n").toString() + "</s:Body></s:Envelope>";
    AppMethodBeat.o(158888);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a.f
 * JD-Core Version:    0.7.0.1
 */