package com.tencent.mm.message.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class c
{
  public String appId;
  public String content;
  public String eoU;
  private String nVS;
  public int nVT;
  public int nVU;
  public String path;
  public String title;
  public int type;
  public String username;
  
  public static c Hu(String paramString)
  {
    AppMethodBeat.i(2615);
    paramString = XmlParser.parseXml(paramString, "sysmsg", null);
    c localc = new c();
    if (paramString == null)
    {
      AppMethodBeat.o(2615);
      return localc;
    }
    localc.nVS = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.template"));
    localc.title = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.title"));
    localc.content = localc.nVS.replace("$wxaapp_view$", localc.title);
    localc.appId = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.appid"));
    localc.username = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.username"));
    localc.path = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.path"));
    localc.type = Util.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.type"), 0);
    localc.eoU = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key"));
    localc.nVT = Util.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.forbids"), 0);
    localc.nVU = Util.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.wxaapp_type"), 1);
    AppMethodBeat.o(2615);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.message.c.c
 * JD-Core Version:    0.7.0.1
 */