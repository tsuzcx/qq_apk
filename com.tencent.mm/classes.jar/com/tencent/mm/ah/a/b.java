package com.tencent.mm.ah.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class b
{
  public String appId;
  public String cmw;
  public String content;
  private String hGT;
  public int hGU;
  public int hGV;
  public String path;
  public String title;
  public int type;
  public String username;
  
  public static b zk(String paramString)
  {
    AppMethodBeat.i(2615);
    paramString = bx.M(paramString, "sysmsg");
    b localb = new b();
    if (paramString == null)
    {
      AppMethodBeat.o(2615);
      return localb;
    }
    localb.hGT = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.template"));
    localb.title = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.title"));
    localb.content = localb.hGT.replace("$wxaapp_view$", localb.title);
    localb.appId = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.appid"));
    localb.username = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.username"));
    localb.path = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.path"));
    localb.type = bu.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.type"), 0);
    localb.cmw = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key"));
    localb.hGU = bu.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.forbids"), 0);
    localb.hGV = bu.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.wxaapp_type"), 1);
    AppMethodBeat.o(2615);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ah.a.b
 * JD-Core Version:    0.7.0.1
 */