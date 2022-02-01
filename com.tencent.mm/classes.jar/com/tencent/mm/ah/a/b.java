package com.tencent.mm.ah.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class b
{
  public String appId;
  public String ccd;
  public String content;
  private String hlO;
  public int hlP;
  public int hlQ;
  public String path;
  public String title;
  public int type;
  public String username;
  
  public static b vJ(String paramString)
  {
    AppMethodBeat.i(2615);
    paramString = bv.L(paramString, "sysmsg");
    b localb = new b();
    if (paramString == null)
    {
      AppMethodBeat.o(2615);
      return localb;
    }
    localb.hlO = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.template"));
    localb.title = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.title"));
    localb.content = localb.hlO.replace("$wxaapp_view$", localb.title);
    localb.appId = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.appid"));
    localb.username = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.username"));
    localb.path = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.path"));
    localb.type = bs.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.type"), 0);
    localb.ccd = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key"));
    localb.hlP = bs.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.forbids"), 0);
    localb.hlQ = bs.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.wxaapp_type"), 1);
    AppMethodBeat.o(2615);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ah.a.b
 * JD-Core Version:    0.7.0.1
 */