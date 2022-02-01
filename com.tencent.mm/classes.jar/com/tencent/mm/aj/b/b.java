package com.tencent.mm.aj.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class b
{
  public String fUd;
  public String gbn;
  public int lmu;
  public String lnb;
  public String lpP;
  public int lqG;
  public int opType;
  public String title;
  public String url;
  
  public static b Pa(String paramString)
  {
    AppMethodBeat.i(220517);
    paramString = XmlParser.parseXml(paramString, "msg", null);
    b localb = new b();
    if (paramString == null)
    {
      Log.i("TemplateMsgContent", "values map is null.");
      AppMethodBeat.o(220517);
      return localb;
    }
    localb.opType = Util.getInt((String)paramString.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
    localb.fUd = Util.nullAsNil((String)paramString.get(".msg.fromusername"));
    localb.title = ((String)paramString.get(".msg.appmsg.mmreader.category.item.title"));
    localb.url = ((String)paramString.get(".msg.appmsg.mmreader.category.item.url"));
    localb.lmu = Util.getInt((String)paramString.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    localb.gbn = ((String)paramString.get(".msg.appmsg.mmreader.category.item.native_url"));
    localb.lnb = ((String)paramString.get(".msg.appmsg.template_id"));
    localb.lpP = ((String)paramString.get(".msg.appmsg.mmreader.category.item.weapp_username"));
    localb.lqG = Util.getInt((String)paramString.get(".msg.appmsg.mmreader.template_detail.new_tmpl_type"), -1);
    AppMethodBeat.o(220517);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.b.b
 * JD-Core Version:    0.7.0.1
 */