package com.tencent.mm.af.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class a
{
  public String appId;
  public String bCZ;
  public String content;
  private String fkh;
  public int fki;
  public int fkj;
  public String path;
  public String title;
  public int type;
  public String username;
  
  public static a ne(String paramString)
  {
    AppMethodBeat.i(51122);
    paramString = br.F(paramString, "sysmsg");
    a locala = new a();
    if (paramString == null)
    {
      AppMethodBeat.o(51122);
      return locala;
    }
    locala.fkh = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.template"));
    locala.title = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.title"));
    locala.content = locala.fkh.replace("$wxaapp_view$", locala.title);
    locala.appId = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.appid"));
    locala.username = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.username"));
    locala.path = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.path"));
    locala.type = bo.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.type"), 0);
    locala.bCZ = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key"));
    locala.fki = bo.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.forbids"), 0);
    locala.fkj = bo.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.wxaapp_type"), 1);
    AppMethodBeat.o(51122);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.af.a.a
 * JD-Core Version:    0.7.0.1
 */