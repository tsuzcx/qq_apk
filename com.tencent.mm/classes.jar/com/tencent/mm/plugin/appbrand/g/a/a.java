package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends e
{
  public a(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(158878);
    cG("SOAPACTION", "\"" + paramString2 + "#" + this.kfN + "\"");
    bfP();
    AppMethodBeat.o(158878);
  }
  
  public final String bfN()
  {
    return "GetMediaInfo";
  }
  
  public final String bfO()
  {
    AppMethodBeat.i(158879);
    String str = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>" + new StringBuilder("<u:").append(this.kfN).append(" xmlns:u=\"").append(this.kfO).append("\">\n<InstanceID>0</InstanceID>\n</u:").append(this.kfN).append(">\n").toString() + "</s:Body></s:Envelope>";
    AppMethodBeat.o(158879);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a.a
 * JD-Core Version:    0.7.0.1
 */