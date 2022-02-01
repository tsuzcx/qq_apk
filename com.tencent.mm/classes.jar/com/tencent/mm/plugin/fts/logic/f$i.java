package com.tencent.mm.plugin.fts.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class f$i
{
  public String iaa;
  public List<a> nVO;
  public String title;
  
  f$i()
  {
    AppMethodBeat.i(265475);
    this.nVO = new ArrayList();
    AppMethodBeat.o(265475);
  }
  
  public static String a(i parami)
  {
    AppMethodBeat.i(265484);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parami.title).append(" ");
    if (parami.nVO != null)
    {
      parami = parami.nVO.iterator();
      while (parami.hasNext()) {
        localStringBuilder.append(((a)parami.next()).nVQ).append(" ");
      }
    }
    parami = localStringBuilder.toString();
    AppMethodBeat.o(265484);
    return parami;
  }
  
  public static i aEy(String paramString)
  {
    AppMethodBeat.i(265482);
    Map localMap = XmlParser.parseXml(paramString, "msg", null);
    i locali = new i();
    if (localMap == null)
    {
      Log.i("TemplateMsgContent", "values map is null.");
      AppMethodBeat.o(265482);
      return locali;
    }
    locali.iaa = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
    locali.title = ((String)localMap.get(".msg.appmsg.mmreader.category.item.title"));
    int i = 0;
    if (i < 100) {
      if (i != 0) {
        break label193;
      }
    }
    String str1;
    String str2;
    label193:
    for (paramString = ".msg.appmsg.mmreader.template_detail.line_content.lines.line";; paramString = ".msg.appmsg.mmreader.template_detail.line_content.lines.line".concat(String.valueOf(i)))
    {
      str1 = (String)localMap.get(paramString + ".value.word");
      str2 = (String)localMap.get(paramString + ".key.word");
      if ((!Util.isNullOrNil(str1)) || (!Util.isNullOrNil(str2))) {
        break;
      }
      Log.i("TemplateMsgContent", "visit lines: lines count=%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(265482);
      return locali;
    }
    a locala = new a();
    locala.nVQ = str1;
    locala.nVP = Util.nullAsNil(str2);
    if (Util.getInt((String)localMap.get(paramString + ".key.hide"), 0) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      locala.nVR = bool;
      locali.nVO.add(locala);
      i += 1;
      break;
    }
  }
  
  static final class a
  {
    String nVP;
    String nVQ;
    boolean nVR = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.logic.f.i
 * JD-Core Version:    0.7.0.1
 */