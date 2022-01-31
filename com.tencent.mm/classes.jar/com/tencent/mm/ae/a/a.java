package com.tencent.mm.ae.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import java.util.Map;

public final class a
{
  public String appId;
  public String content;
  private String dTW;
  public String dTX;
  public int dTY;
  public int dTZ;
  public String path;
  public String title;
  public int type;
  public String username;
  
  public static a gw(String paramString)
  {
    paramString = bn.s(paramString, "sysmsg");
    a locala = new a();
    if (paramString == null) {
      return locala;
    }
    locala.dTW = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.template"));
    locala.title = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.title"));
    locala.content = locala.dTW.replace("$wxaapp_view$", locala.title);
    locala.appId = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.appid"));
    locala.username = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.username"));
    locala.path = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.path"));
    locala.type = bk.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.type"), 0);
    locala.dTX = ((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key"));
    locala.dTY = bk.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.forbids"), 0);
    locala.dTZ = bk.getInt((String)paramString.get(".sysmsg.subscribesysmsg.content_template.link_list.link.wxaapp_type"), 1);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ae.a.a
 * JD-Core Version:    0.7.0.1
 */