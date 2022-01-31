package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.Map;

public final class d
{
  public static String a(add paramadd)
  {
    int j = 0;
    AppMethodBeat.i(102757);
    if ((paramadd == null) || ((paramadd.wVq.isEmpty()) && (paramadd.wVp.isEmpty())))
    {
      ab.v("MicroMsg.FavTagParser", "tag list toXml data list empty");
      AppMethodBeat.o(102757);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int k = paramadd.wVq.size();
    localStringBuffer.append("<taglist count='").append(k).append("'>");
    int i = 0;
    while (i < k)
    {
      localStringBuffer.append("<tag>").append(bo.apT((String)paramadd.wVq.get(i))).append("</tag>");
      i += 1;
    }
    localStringBuffer.append("</taglist>");
    k = paramadd.wVp.size();
    localStringBuffer.append("<recommendtaglist count='").append(k).append("'>");
    i = j;
    while (i < k)
    {
      localStringBuffer.append("<tag>").append(bo.apT((String)paramadd.wVp.get(i))).append("</tag>");
      i += 1;
    }
    localStringBuffer.append("</recommendtaglist>");
    paramadd = localStringBuffer.toString();
    AppMethodBeat.o(102757);
    return paramadd;
  }
  
  public static void a(Map<String, String> paramMap, add paramadd)
  {
    AppMethodBeat.i(102756);
    if ((paramMap == null) || (paramadd == null))
    {
      ab.w("MicroMsg.FavTagParser", "maps is null or item is null");
      AppMethodBeat.o(102756);
      return;
    }
    paramadd.wVq.clear();
    int i = 0;
    StringBuilder localStringBuilder;
    Object localObject;
    if (i < 1024)
    {
      localStringBuilder = new StringBuilder(".favitem.taglist.tag");
      if (i > 0) {}
      for (localObject = Integer.valueOf(i);; localObject = "")
      {
        localObject = (String)paramMap.get(localObject);
        if (localObject == null) {
          break label107;
        }
        paramadd.wVq.add(localObject);
        i += 1;
        break;
      }
    }
    label107:
    if (!paramadd.wVq.isEmpty()) {
      ab.d("MicroMsg.FavTagParser", "user def tag not empty, res=%s", new Object[] { paramadd.wVq });
    }
    paramadd.wVp.clear();
    i = 0;
    if (i < 1024)
    {
      localStringBuilder = new StringBuilder(".favitem.recommendtaglist.tag");
      if (i > 0) {}
      for (localObject = Integer.valueOf(i);; localObject = "")
      {
        localObject = (String)paramMap.get(localObject);
        if (localObject == null) {
          break label216;
        }
        paramadd.wVp.add(localObject);
        i += 1;
        break;
      }
    }
    label216:
    if (!paramadd.wVp.isEmpty()) {
      ab.d("MicroMsg.FavTagParser", "recommended tag not empty, res=%s", new Object[] { paramadd.wVp });
    }
    AppMethodBeat.o(102756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.d
 * JD-Core Version:    0.7.0.1
 */