package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class g
{
  public static d Vt(String paramString)
  {
    AppMethodBeat.i(113797);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113797);
      return null;
    }
    d locald = new d();
    paramString = bv.L(paramString, "msg");
    if (paramString == null)
    {
      AppMethodBeat.o(113797);
      return locald;
    }
    locald.nVI = ((String)paramString.get(".msg.appmsg.carditem.from_username"));
    locald.dvO = ((String)paramString.get(".msg.appmsg.carditem.card_id"));
    locald.lRv = Vv((String)paramString.get(".msg.appmsg.carditem.card_type"));
    locald.dvQ = Vv((String)paramString.get(".msg.appmsg.carditem.from_scene"));
    locald.hiu = ((String)paramString.get(".msg.appmsg.carditem.color"));
    locald.nVJ = ((String)paramString.get(".msg.appmsg.carditem.card_type_name"));
    locald.nVK = ((String)paramString.get(".msg.appmsg.carditem.brand_name"));
    locald.dvP = ((String)paramString.get(".msg.appmsg.carditem.card_ext"));
    locald.nVL = Vv((String)paramString.get(".msg.appmsg.carditem.is_recommend"));
    locald.nVM = ((String)paramString.get(".msg.appmsg.carditem.recommend_card_id"));
    AppMethodBeat.o(113797);
    return locald;
  }
  
  public static String Vu(String paramString)
  {
    AppMethodBeat.i(113798);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113798);
      return null;
    }
    paramString = bv.L(paramString, "msg");
    if (paramString == null)
    {
      AppMethodBeat.o(113798);
      return null;
    }
    paramString = (String)paramString.get(".msg.appmsg.fromusername");
    AppMethodBeat.o(113798);
    return paramString;
  }
  
  private static int Vv(String paramString)
  {
    AppMethodBeat.i(113799);
    if ((TextUtils.isEmpty(paramString)) || (!l.isNumeric(paramString)))
    {
      AppMethodBeat.o(113799);
      return 0;
    }
    int i = bs.getInt(paramString, 0);
    AppMethodBeat.o(113799);
    return i;
  }
  
  public static String a(d paramd)
  {
    AppMethodBeat.i(113800);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<from_username>").append(paramd.nVI).append("</from_username>");
    localStringBuilder.append("<card_id>").append(paramd.dvO).append("</card_id>");
    localStringBuilder.append("<card_type>").append(paramd.lRv).append("</card_type>");
    localStringBuilder.append("<from_scene>").append(paramd.dvQ).append("</from_scene>");
    localStringBuilder.append("<color>").append(paramd.hiu).append("</color>");
    localStringBuilder.append("<card_type_name>").append(paramd.nVJ).append("</card_type_name>");
    localStringBuilder.append("<brand_name>").append(paramd.nVK).append("</brand_name>");
    if (TextUtils.isEmpty(paramd.dvP)) {
      localStringBuilder.append("<card_ext></card_ext>");
    }
    for (;;)
    {
      localStringBuilder.append("<is_recommend>").append(paramd.nVL).append("</is_recommend>");
      localStringBuilder.append("<recommend_card_id>").append(paramd.nVM).append("</recommend_card_id>");
      paramd = localStringBuilder.toString();
      AppMethodBeat.o(113800);
      return paramd;
      localStringBuilder.append("<card_ext>").append(paramd.dvP).append("</card_ext>");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.g
 * JD-Core Version:    0.7.0.1
 */