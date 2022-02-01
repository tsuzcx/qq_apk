package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends e
{
  public c(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(158882);
    cE("SOAPACTION", "\"" + paramString2 + "#" + this.kcw + "\"");
    bfh();
    AppMethodBeat.o(158882);
  }
  
  public final String bff()
  {
    return "GetVolume";
  }
  
  public final String bfg()
  {
    AppMethodBeat.i(158883);
    String str = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>" + new StringBuilder("<u:").append(this.kcw).append(" xmlns:u=\"").append(this.kcx).append("\">\n<InstanceID>0</InstanceID>\n<Channel>").append("Master").append("</Channel>\n</u:").append(this.kcw).append(">\n").toString() + "</s:Body></s:Envelope>";
    AppMethodBeat.o(158883);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a.c
 * JD-Core Version:    0.7.0.1
 */