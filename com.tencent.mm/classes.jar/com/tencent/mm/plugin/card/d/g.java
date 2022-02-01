package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class g
{
  public static d Rh(String paramString)
  {
    AppMethodBeat.i(113797);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113797);
      return null;
    }
    d locald = new d();
    paramString = bw.K(paramString, "msg");
    if (paramString == null)
    {
      AppMethodBeat.o(113797);
      return locald;
    }
    locald.nsI = ((String)paramString.get(".msg.appmsg.carditem.from_username"));
    locald.dyc = ((String)paramString.get(".msg.appmsg.carditem.card_id"));
    locald.lpz = Rj((String)paramString.get(".msg.appmsg.carditem.card_type"));
    locald.dye = Rj((String)paramString.get(".msg.appmsg.carditem.from_scene"));
    locald.gHT = ((String)paramString.get(".msg.appmsg.carditem.color"));
    locald.nsJ = ((String)paramString.get(".msg.appmsg.carditem.card_type_name"));
    locald.nsK = ((String)paramString.get(".msg.appmsg.carditem.brand_name"));
    locald.dyd = ((String)paramString.get(".msg.appmsg.carditem.card_ext"));
    locald.nsL = Rj((String)paramString.get(".msg.appmsg.carditem.is_recommend"));
    locald.nsM = ((String)paramString.get(".msg.appmsg.carditem.recommend_card_id"));
    AppMethodBeat.o(113797);
    return locald;
  }
  
  public static String Ri(String paramString)
  {
    AppMethodBeat.i(113798);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113798);
      return null;
    }
    paramString = bw.K(paramString, "msg");
    if (paramString == null)
    {
      AppMethodBeat.o(113798);
      return null;
    }
    paramString = (String)paramString.get(".msg.appmsg.fromusername");
    AppMethodBeat.o(113798);
    return paramString;
  }
  
  private static int Rj(String paramString)
  {
    AppMethodBeat.i(113799);
    if ((TextUtils.isEmpty(paramString)) || (!l.isNumeric(paramString)))
    {
      AppMethodBeat.o(113799);
      return 0;
    }
    int i = bt.getInt(paramString, 0);
    AppMethodBeat.o(113799);
    return i;
  }
  
  public static String a(d paramd)
  {
    AppMethodBeat.i(113800);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<from_username>").append(paramd.nsI).append("</from_username>");
    localStringBuilder.append("<card_id>").append(paramd.dyc).append("</card_id>");
    localStringBuilder.append("<card_type>").append(paramd.lpz).append("</card_type>");
    localStringBuilder.append("<from_scene>").append(paramd.dye).append("</from_scene>");
    localStringBuilder.append("<color>").append(paramd.gHT).append("</color>");
    localStringBuilder.append("<card_type_name>").append(paramd.nsJ).append("</card_type_name>");
    localStringBuilder.append("<brand_name>").append(paramd.nsK).append("</brand_name>");
    if (TextUtils.isEmpty(paramd.dyd)) {
      localStringBuilder.append("<card_ext></card_ext>");
    }
    for (;;)
    {
      localStringBuilder.append("<is_recommend>").append(paramd.nsL).append("</is_recommend>");
      localStringBuilder.append("<recommend_card_id>").append(paramd.nsM).append("</recommend_card_id>");
      paramd = localStringBuilder.toString();
      AppMethodBeat.o(113800);
      return paramd;
      localStringBuilder.append("<card_ext>").append(paramd.dyd).append("</card_ext>");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.g
 * JD-Core Version:    0.7.0.1
 */