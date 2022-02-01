package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends e
{
  private String kga;
  
  public i(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(158892);
    this.kga = paramString3;
    cG("SOAPACTION", "\"" + paramString2 + "#" + this.kfN + "\"");
    bfP();
    AppMethodBeat.o(158892);
  }
  
  public final String bfN()
  {
    return "Seek";
  }
  
  public final String bfO()
  {
    AppMethodBeat.i(158893);
    String str = this.kga;
    str = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>" + new StringBuilder("<u:").append(this.kfN).append(" xmlns:u=\"").append(this.kfO).append("\">\n <InstanceID>0</InstanceID>\n <Unit>").append("REL_TIME").append("</Unit>\n <Target>").append(str).append("</Target>\n</u:").append(this.kfN).append(">\n").toString() + "</s:Body></s:Envelope>";
    AppMethodBeat.o(158893);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a.i
 * JD-Core Version:    0.7.0.1
 */