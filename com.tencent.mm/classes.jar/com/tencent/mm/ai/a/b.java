package com.tencent.mm.ai.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class b
{
  public String appId;
  public String cmu;
  public String content;
  private String hEb;
  public int hEc;
  public int hEd;
  public String path;
  public String title;
  public int type;
  public String username;
  
  public static b yA(String paramString)
  {
    AppMethodBeat.i(2615);
    paramString = bw.M(paramString, "sysmsg");
    b localb = new b();
    if (paramString == null)
    {
      AppMethodBeat.o(2615);
      return localb;
    }
    localb.hEb = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.template"));
    localb.title = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.title"));
    localb.content = localb.hEb.replace("$wxaapp_view$", localb.title);
    localb.appId = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.appid"));
    localb.username = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.username"));
    localb.path = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.path"));
    localb.type = bt.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.type"), 0);
    localb.cmu = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key"));
    localb.hEc = bt.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.forbids"), 0);
    localb.hEd = bt.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.wxaapp_type"), 1);
    AppMethodBeat.o(2615);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.a.b
 * JD-Core Version:    0.7.0.1
 */