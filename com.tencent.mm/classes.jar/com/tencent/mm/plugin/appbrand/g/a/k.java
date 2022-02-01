package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends e
{
  private int hBI;
  
  public k(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(158896);
    this.hBI = paramInt;
    cV("SOAPACTION", "\"" + paramString2 + "#" + this.ljw + "\"");
    AppMethodBeat.o(158896);
  }
  
  public final String bBg()
  {
    return "SetVolume";
  }
  
  public final String bBh()
  {
    AppMethodBeat.i(158897);
    int i = this.hBI;
    String str = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>" + new StringBuilder("<u:").append(this.ljw).append(" xmlns:u=\"").append(this.ljx).append("\">\n<InstanceID>0</InstanceID>\n<Channel>").append("Master").append("</Channel>\n<DesiredVolume>").append(i).append("</DesiredVolume>\n</u:").append(this.ljw).append(">\n").toString() + "</s:Body></s:Envelope>";
    AppMethodBeat.o(158897);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a.k
 * JD-Core Version:    0.7.0.1
 */