package com.tencent.mm.message.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b
{
  public String displayName;
  public String iaa;
  public String ihx;
  public int nRz;
  public String nSg;
  public String nUO;
  public String nUR;
  public String nVM;
  public int nVN;
  public List<a> nVO;
  public int opType;
  public String title;
  public String url;
  
  public b()
  {
    AppMethodBeat.i(233934);
    this.nVO = new ArrayList();
    AppMethodBeat.o(233934);
  }
  
  public static b Ht(String paramString)
  {
    AppMethodBeat.i(233939);
    Map localMap = XmlParser.parseXml(paramString, "msg", null);
    b localb = new b();
    if (localMap == null)
    {
      Log.i("TemplateMsgContent", "values map is null.");
      AppMethodBeat.o(233939);
      return localb;
    }
    localb.opType = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
    localb.iaa = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
    localb.nVM = Util.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
    localb.displayName = Util.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name"));
    localb.title = ((String)localMap.get(".msg.appmsg.mmreader.category.item.title"));
    localb.url = ((String)localMap.get(".msg.appmsg.mmreader.category.item.url"));
    localb.nRz = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    localb.ihx = ((String)localMap.get(".msg.appmsg.mmreader.category.item.native_url"));
    localb.nSg = ((String)localMap.get(".msg.appmsg.template_id"));
    localb.nUR = ((String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_username"));
    localb.nVN = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.new_tmpl_type"), -1);
    localb.nUO = ((String)localMap.get(".msg.appmsg.mmreader.category.item.digest"));
    int i = 0;
    if (i < 100) {
      if (i != 0) {
        break label371;
      }
    }
    String str1;
    String str2;
    label371:
    for (paramString = ".msg.appmsg.mmreader.template_detail.line_content.lines.line";; paramString = ".msg.appmsg.mmreader.template_detail.line_content.lines.line".concat(String.valueOf(i)))
    {
      str1 = (String)localMap.get(paramString + ".value.word");
      str2 = (String)localMap.get(paramString + ".key.word");
      if ((!Util.isNullOrNil(str1)) || (!Util.isNullOrNil(str2))) {
        break;
      }
      Log.i("TemplateMsgContent", "visit lines: lines count=%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(233939);
      return localb;
    }
    a locala = new a();
    locala.nVQ = str1;
    locala.nVP = Util.nullAsNil(str2);
    if (Util.getInt((String)localMap.get(paramString + ".key.hide"), 0) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      locala.nVR = bool;
      localb.nVO.add(locala);
      i += 1;
      break;
    }
  }
  
  public static final class a
  {
    public String nVP;
    public String nVQ;
    public boolean nVR = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.message.c.b
 * JD-Core Version:    0.7.0.1
 */