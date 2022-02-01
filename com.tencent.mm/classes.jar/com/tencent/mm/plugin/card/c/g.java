package com.tencent.mm.plugin.card.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class g
{
  public static String a(d paramd)
  {
    AppMethodBeat.i(113800);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<from_username>").append(paramd.from_username).append("</from_username>");
    localStringBuilder.append("<card_id>").append(paramd.iaI).append("</card_id>");
    localStringBuilder.append("<card_type>").append(paramd.tNW).append("</card_type>");
    localStringBuilder.append("<from_scene>").append(paramd.iaK).append("</from_scene>");
    localStringBuilder.append("<color>").append(paramd.nRQ).append("</color>");
    localStringBuilder.append("<card_type_name>").append(paramd.wtN).append("</card_type_name>");
    localStringBuilder.append("<brand_name>").append(paramd.mee).append("</brand_name>");
    if (TextUtils.isEmpty(paramd.iaJ)) {
      localStringBuilder.append("<card_ext></card_ext>");
    }
    for (;;)
    {
      localStringBuilder.append("<is_recommend>").append(paramd.wtO).append("</is_recommend>");
      localStringBuilder.append("<recommend_card_id>").append(paramd.wtP).append("</recommend_card_id>");
      paramd = localStringBuilder.toString();
      AppMethodBeat.o(113800);
      return paramd;
      localStringBuilder.append("<card_ext>").append(paramd.iaJ).append("</card_ext>");
    }
  }
  
  public static d alq(String paramString)
  {
    AppMethodBeat.i(113797);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113797);
      return null;
    }
    d locald = new d();
    paramString = XmlParser.parseXml(paramString, "msg", null);
    if (paramString == null)
    {
      AppMethodBeat.o(113797);
      return locald;
    }
    locald.from_username = ((String)paramString.get(".msg.appmsg.carditem.from_username"));
    locald.iaI = ((String)paramString.get(".msg.appmsg.carditem.card_id"));
    locald.tNW = als((String)paramString.get(".msg.appmsg.carditem.card_type"));
    locald.iaK = als((String)paramString.get(".msg.appmsg.carditem.from_scene"));
    locald.nRQ = ((String)paramString.get(".msg.appmsg.carditem.color"));
    locald.wtN = ((String)paramString.get(".msg.appmsg.carditem.card_type_name"));
    locald.mee = ((String)paramString.get(".msg.appmsg.carditem.brand_name"));
    locald.iaJ = ((String)paramString.get(".msg.appmsg.carditem.card_ext"));
    locald.wtO = als((String)paramString.get(".msg.appmsg.carditem.is_recommend"));
    locald.wtP = ((String)paramString.get(".msg.appmsg.carditem.recommend_card_id"));
    AppMethodBeat.o(113797);
    return locald;
  }
  
  public static String alr(String paramString)
  {
    AppMethodBeat.i(113798);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113798);
      return null;
    }
    paramString = XmlParser.parseXml(paramString, "msg", null);
    if (paramString == null)
    {
      AppMethodBeat.o(113798);
      return null;
    }
    paramString = (String)paramString.get(".msg.appmsg.fromusername");
    AppMethodBeat.o(113798);
    return paramString;
  }
  
  private static int als(String paramString)
  {
    AppMethodBeat.i(113799);
    if ((TextUtils.isEmpty(paramString)) || (!l.isNumeric(paramString)))
    {
      AppMethodBeat.o(113799);
      return 0;
    }
    int i = Util.getInt(paramString, 0);
    AppMethodBeat.o(113799);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.g
 * JD-Core Version:    0.7.0.1
 */