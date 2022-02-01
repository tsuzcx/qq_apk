package com.tencent.mm.plugin.appbrand.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends e
{
  public g(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(158889);
    cs("SOAPACTION", "\"" + paramString2 + "#" + this.jhV + "\"");
    aUF();
    AppMethodBeat.o(158889);
  }
  
  public final String aUD()
  {
    return "Play";
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(158890);
    String str = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>" + new StringBuilder("<u:").append(this.jhV).append(" xmlns:u=\"").append(this.jhW).append("\">\n <InstanceID>0</InstanceID>\n <Speed>1</Speed>\n</u:").append(this.jhV).append(">\n").toString() + "</s:Body></s:Envelope>";
    AppMethodBeat.o(158890);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.a.g
 * JD-Core Version:    0.7.0.1
 */