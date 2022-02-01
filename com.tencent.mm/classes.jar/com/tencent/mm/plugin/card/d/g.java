package com.tencent.mm.plugin.card.d;

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
    localStringBuilder.append("<card_id>").append(paramd.fUL).append("</card_id>");
    localStringBuilder.append("<card_type>").append(paramd.qJt).append("</card_type>");
    localStringBuilder.append("<from_scene>").append(paramd.fUN).append("</from_scene>");
    localStringBuilder.append("<color>").append(paramd.lmL).append("</color>");
    localStringBuilder.append("<card_type_name>").append(paramd.tpo).append("</card_type_name>");
    localStringBuilder.append("<brand_name>").append(paramd.jEi).append("</brand_name>");
    if (TextUtils.isEmpty(paramd.fUM)) {
      localStringBuilder.append("<card_ext></card_ext>");
    }
    for (;;)
    {
      localStringBuilder.append("<is_recommend>").append(paramd.tpp).append("</is_recommend>");
      localStringBuilder.append("<recommend_card_id>").append(paramd.tpq).append("</recommend_card_id>");
      paramd = localStringBuilder.toString();
      AppMethodBeat.o(113800);
      return paramd;
      localStringBuilder.append("<card_ext>").append(paramd.fUM).append("</card_ext>");
    }
  }
  
  public static d arM(String paramString)
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
    locald.fUL = ((String)paramString.get(".msg.appmsg.carditem.card_id"));
    locald.qJt = arO((String)paramString.get(".msg.appmsg.carditem.card_type"));
    locald.fUN = arO((String)paramString.get(".msg.appmsg.carditem.from_scene"));
    locald.lmL = ((String)paramString.get(".msg.appmsg.carditem.color"));
    locald.tpo = ((String)paramString.get(".msg.appmsg.carditem.card_type_name"));
    locald.jEi = ((String)paramString.get(".msg.appmsg.carditem.brand_name"));
    locald.fUM = ((String)paramString.get(".msg.appmsg.carditem.card_ext"));
    locald.tpp = arO((String)paramString.get(".msg.appmsg.carditem.is_recommend"));
    locald.tpq = ((String)paramString.get(".msg.appmsg.carditem.recommend_card_id"));
    AppMethodBeat.o(113797);
    return locald;
  }
  
  public static String arN(String paramString)
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
  
  private static int arO(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.g
 * JD-Core Version:    0.7.0.1
 */