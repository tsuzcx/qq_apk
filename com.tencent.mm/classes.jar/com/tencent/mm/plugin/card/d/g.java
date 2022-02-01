package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class g
{
  public static d ZT(String paramString)
  {
    AppMethodBeat.i(113797);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113797);
      return null;
    }
    d locald = new d();
    paramString = bx.M(paramString, "msg");
    if (paramString == null)
    {
      AppMethodBeat.o(113797);
      return locald;
    }
    locald.oBM = ((String)paramString.get(".msg.appmsg.carditem.from_username"));
    locald.dJb = ((String)paramString.get(".msg.appmsg.carditem.card_id"));
    locald.mwj = ZV((String)paramString.get(".msg.appmsg.carditem.card_type"));
    locald.dJd = ZV((String)paramString.get(".msg.appmsg.carditem.from_scene"));
    locald.hDr = ((String)paramString.get(".msg.appmsg.carditem.color"));
    locald.oFF = ((String)paramString.get(".msg.appmsg.carditem.card_type_name"));
    locald.oFG = ((String)paramString.get(".msg.appmsg.carditem.brand_name"));
    locald.dJc = ((String)paramString.get(".msg.appmsg.carditem.card_ext"));
    locald.oFH = ZV((String)paramString.get(".msg.appmsg.carditem.is_recommend"));
    locald.oFI = ((String)paramString.get(".msg.appmsg.carditem.recommend_card_id"));
    AppMethodBeat.o(113797);
    return locald;
  }
  
  public static String ZU(String paramString)
  {
    AppMethodBeat.i(113798);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113798);
      return null;
    }
    paramString = bx.M(paramString, "msg");
    if (paramString == null)
    {
      AppMethodBeat.o(113798);
      return null;
    }
    paramString = (String)paramString.get(".msg.appmsg.fromusername");
    AppMethodBeat.o(113798);
    return paramString;
  }
  
  private static int ZV(String paramString)
  {
    AppMethodBeat.i(113799);
    if ((TextUtils.isEmpty(paramString)) || (!l.isNumeric(paramString)))
    {
      AppMethodBeat.o(113799);
      return 0;
    }
    int i = bu.getInt(paramString, 0);
    AppMethodBeat.o(113799);
    return i;
  }
  
  public static String a(d paramd)
  {
    AppMethodBeat.i(113800);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<from_username>").append(paramd.oBM).append("</from_username>");
    localStringBuilder.append("<card_id>").append(paramd.dJb).append("</card_id>");
    localStringBuilder.append("<card_type>").append(paramd.mwj).append("</card_type>");
    localStringBuilder.append("<from_scene>").append(paramd.dJd).append("</from_scene>");
    localStringBuilder.append("<color>").append(paramd.hDr).append("</color>");
    localStringBuilder.append("<card_type_name>").append(paramd.oFF).append("</card_type_name>");
    localStringBuilder.append("<brand_name>").append(paramd.oFG).append("</brand_name>");
    if (TextUtils.isEmpty(paramd.dJc)) {
      localStringBuilder.append("<card_ext></card_ext>");
    }
    for (;;)
    {
      localStringBuilder.append("<is_recommend>").append(paramd.oFH).append("</is_recommend>");
      localStringBuilder.append("<recommend_card_id>").append(paramd.oFI).append("</recommend_card_id>");
      paramd = localStringBuilder.toString();
      AppMethodBeat.o(113800);
      return paramd;
      localStringBuilder.append("<card_ext>").append(paramd.dJc).append("</card_ext>");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.g
 * JD-Core Version:    0.7.0.1
 */