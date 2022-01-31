package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.platformtools.bn;
import java.util.Map;

public final class g
{
  public static String a(d paramd)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<from_username>").append(paramd.imy).append("</from_username>");
    localStringBuilder.append("<card_id>").append(paramd.bZc).append("</card_id>");
    localStringBuilder.append("<card_type>").append(paramd.ilo).append("</card_type>");
    localStringBuilder.append("<from_scene>").append(paramd.bZe).append("</from_scene>");
    localStringBuilder.append("<color>").append(paramd.color).append("</color>");
    localStringBuilder.append("<card_type_name>").append(paramd.imz).append("</card_type_name>");
    localStringBuilder.append("<brand_name>").append(paramd.imA).append("</brand_name>");
    if (TextUtils.isEmpty(paramd.bZd)) {
      localStringBuilder.append("<card_ext></card_ext>");
    }
    for (;;)
    {
      localStringBuilder.append("<is_recommend>").append(paramd.imB).append("</is_recommend>");
      localStringBuilder.append("<recommend_card_id>").append(paramd.imC).append("</recommend_card_id>");
      return localStringBuilder.toString();
      localStringBuilder.append("<card_ext>").append(paramd.bZd).append("</card_ext>");
    }
  }
  
  public static d yM(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    d locald = new d();
    paramString = bn.s(paramString, "msg");
    locald.imy = ((String)paramString.get(".msg.appmsg.carditem.from_username"));
    locald.bZc = ((String)paramString.get(".msg.appmsg.carditem.card_id"));
    locald.ilo = yO((String)paramString.get(".msg.appmsg.carditem.card_type"));
    locald.bZe = yO((String)paramString.get(".msg.appmsg.carditem.from_scene"));
    locald.color = ((String)paramString.get(".msg.appmsg.carditem.color"));
    locald.imz = ((String)paramString.get(".msg.appmsg.carditem.card_type_name"));
    locald.imA = ((String)paramString.get(".msg.appmsg.carditem.brand_name"));
    locald.bZd = ((String)paramString.get(".msg.appmsg.carditem.card_ext"));
    locald.imB = yO((String)paramString.get(".msg.appmsg.carditem.is_recommend"));
    locald.imC = ((String)paramString.get(".msg.appmsg.carditem.recommend_card_id"));
    return locald;
  }
  
  public static String yN(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (String)bn.s(paramString, "msg").get(".msg.appmsg.fromusername");
  }
  
  private static int yO(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!l.yS(paramString))) {
      return 0;
    }
    return Integer.valueOf(paramString).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.g
 * JD-Core Version:    0.7.0.1
 */