package com.tencent.mm.ag.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class b
{
  public String appId;
  public String content;
  public String cyr;
  private String iBd;
  public int iBe;
  public int iBf;
  public String path;
  public String title;
  public int type;
  public String username;
  
  public static b HM(String paramString)
  {
    AppMethodBeat.i(2615);
    paramString = XmlParser.parseXml(paramString, "sysmsg", null);
    b localb = new b();
    if (paramString == null)
    {
      AppMethodBeat.o(2615);
      return localb;
    }
    localb.iBd = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.template"));
    localb.title = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.title"));
    localb.content = localb.iBd.replace("$wxaapp_view$", localb.title);
    localb.appId = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.appid"));
    localb.username = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.username"));
    localb.path = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.path"));
    localb.type = Util.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.type"), 0);
    localb.cyr = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key"));
    localb.iBe = Util.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.forbids"), 0);
    localb.iBf = Util.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.wxaapp_type"), 1);
    AppMethodBeat.o(2615);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ag.a.b
 * JD-Core Version:    0.7.0.1
 */