package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends e
{
  private String ljJ;
  
  public i(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(158892);
    this.ljJ = paramString3;
    cV("SOAPACTION", "\"" + paramString2 + "#" + this.ljw + "\"");
    bBi();
    AppMethodBeat.o(158892);
  }
  
  public final String bBg()
  {
    return "Seek";
  }
  
  public final String bBh()
  {
    AppMethodBeat.i(158893);
    String str = this.ljJ;
    str = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>" + new StringBuilder("<u:").append(this.ljw).append(" xmlns:u=\"").append(this.ljx).append("\">\n <InstanceID>0</InstanceID>\n <Unit>").append("REL_TIME").append("</Unit>\n <Target>").append(str).append("</Target>\n</u:").append(this.ljw).append(">\n").toString() + "</s:Body></s:Envelope>";
    AppMethodBeat.o(158893);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a.i
 * JD-Core Version:    0.7.0.1
 */