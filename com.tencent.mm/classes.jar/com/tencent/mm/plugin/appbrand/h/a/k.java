package com.tencent.mm.plugin.appbrand.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends e
{
  private int gpP;
  
  public k(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(158896);
    this.gpP = paramInt;
    cC("SOAPACTION", "\"" + paramString2 + "#" + this.jIk + "\"");
    AppMethodBeat.o(158896);
  }
  
  public final String bbB()
  {
    return "SetVolume";
  }
  
  public final String bbC()
  {
    AppMethodBeat.i(158897);
    int i = this.gpP;
    String str = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>" + new StringBuilder("<u:").append(this.jIk).append(" xmlns:u=\"").append(this.jIl).append("\">\n<InstanceID>0</InstanceID>\n<Channel>").append("Master").append("</Channel>\n<DesiredVolume>").append(i).append("</DesiredVolume>\n</u:").append(this.jIk).append(">\n").toString() + "</s:Body></s:Envelope>";
    AppMethodBeat.o(158897);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.a.k
 * JD-Core Version:    0.7.0.1
 */