package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class g
{
  public static d Iw(String paramString)
  {
    AppMethodBeat.i(88869);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(88869);
      return null;
    }
    d locald = new d();
    paramString = br.F(paramString, "msg");
    if (paramString == null)
    {
      AppMethodBeat.o(88869);
      return locald;
    }
    locald.knu = ((String)paramString.get(".msg.appmsg.carditem.from_username"));
    locald.cHn = ((String)paramString.get(".msg.appmsg.carditem.card_id"));
    locald.iFL = Iy((String)paramString.get(".msg.appmsg.carditem.card_type"));
    locald.cHp = Iy((String)paramString.get(".msg.appmsg.carditem.from_scene"));
    locald.color = ((String)paramString.get(".msg.appmsg.carditem.color"));
    locald.knv = ((String)paramString.get(".msg.appmsg.carditem.card_type_name"));
    locald.knw = ((String)paramString.get(".msg.appmsg.carditem.brand_name"));
    locald.cHo = ((String)paramString.get(".msg.appmsg.carditem.card_ext"));
    locald.knx = Iy((String)paramString.get(".msg.appmsg.carditem.is_recommend"));
    locald.kny = ((String)paramString.get(".msg.appmsg.carditem.recommend_card_id"));
    AppMethodBeat.o(88869);
    return locald;
  }
  
  public static String Ix(String paramString)
  {
    AppMethodBeat.i(88870);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(88870);
      return null;
    }
    paramString = br.F(paramString, "msg");
    if (paramString == null)
    {
      AppMethodBeat.o(88870);
      return null;
    }
    paramString = (String)paramString.get(".msg.appmsg.fromusername");
    AppMethodBeat.o(88870);
    return paramString;
  }
  
  private static int Iy(String paramString)
  {
    AppMethodBeat.i(88871);
    if ((TextUtils.isEmpty(paramString)) || (!l.isNumeric(paramString)))
    {
      AppMethodBeat.o(88871);
      return 0;
    }
    int i = Integer.valueOf(paramString).intValue();
    AppMethodBeat.o(88871);
    return i;
  }
  
  public static String a(d paramd)
  {
    AppMethodBeat.i(88872);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<from_username>").append(paramd.knu).append("</from_username>");
    localStringBuilder.append("<card_id>").append(paramd.cHn).append("</card_id>");
    localStringBuilder.append("<card_type>").append(paramd.iFL).append("</card_type>");
    localStringBuilder.append("<from_scene>").append(paramd.cHp).append("</from_scene>");
    localStringBuilder.append("<color>").append(paramd.color).append("</color>");
    localStringBuilder.append("<card_type_name>").append(paramd.knv).append("</card_type_name>");
    localStringBuilder.append("<brand_name>").append(paramd.knw).append("</brand_name>");
    if (TextUtils.isEmpty(paramd.cHo)) {
      localStringBuilder.append("<card_ext></card_ext>");
    }
    for (;;)
    {
      localStringBuilder.append("<is_recommend>").append(paramd.knx).append("</is_recommend>");
      localStringBuilder.append("<recommend_card_id>").append(paramd.kny).append("</recommend_card_id>");
      paramd = localStringBuilder.toString();
      AppMethodBeat.o(88872);
      return paramd;
      localStringBuilder.append("<card_ext>").append(paramd.cHo).append("</card_ext>");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.g
 * JD-Core Version:    0.7.0.1
 */