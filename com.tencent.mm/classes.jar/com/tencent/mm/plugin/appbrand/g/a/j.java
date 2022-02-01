package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.c.k;

public final class j
  extends e
{
  private String ljK;
  
  public j(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(158894);
    this.ljK = paramString3;
    cV("SOAPACTION", "\"" + paramString2 + "#" + this.ljw + "\"");
    bBi();
    AppMethodBeat.o(158894);
  }
  
  public final String bBg()
  {
    return "SetAVTransportURI";
  }
  
  public final String bBh()
  {
    AppMethodBeat.i(158895);
    String str = this.ljK;
    Object localObject1 = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>");
    new k();
    str = k.Yg(str);
    Object localObject2 = new StringBuilder("&lt;DIDL-Lite xmlns=&quot;urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/&quot; xmlns:upnp=&quot;urn:schemas-upnp-org:metadata-1-0/upnp/&quot; xmlns:dc=&quot;http://purl.org/dc/elements/1.1/&quot; xmlns:sec=&quot;http://www.sec.co.kr/&quot;&gt;&lt;item id=&quot;123&quot; parentID=&quot;-1&quot; restricted=&quot;1&quot;&gt;&lt;upnp:storageMedium&gt;UNKNOWN&lt;/upnp:storageMedium&gt;&lt;upnp:writeStatus&gt;UNKNOWN&lt;/upnp:writeStatus&gt;&lt;dc:title&gt;Video&lt;/dc:title&gt;&lt;dc:creator&gt;QGame&lt;/dc:creator&gt;&lt;upnp:class&gt;object.item.videoItem&lt;/upnp:class&gt;&lt;res protocolInfo=&quot;http-get:*:video/*:DLNA.ORG_OP=01;DLNA.ORG_CI=0;DLNA.ORG_FLAGS=01700000000000000000000000000000&quot;&gt;");
    new k();
    localObject2 = k.Yg(str) + "&lt;/res&gt;&lt;/item&gt;&lt;/DIDL-Lite&gt;";
    localObject1 = new StringBuilder("<u:").append(this.ljw).append(" xmlns:u=\"").append(this.ljx).append("\">\n<InstanceID>0</InstanceID>\n<CurrentURI>").append(str).append("</CurrentURI>\n<CurrentURIMetaData>").append((String)localObject2).append("</CurrentURIMetaData>\n</u:SetAVTransportURI>\n").toString() + "</s:Body></s:Envelope>";
    AppMethodBeat.o(158895);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a.j
 * JD-Core Version:    0.7.0.1
 */