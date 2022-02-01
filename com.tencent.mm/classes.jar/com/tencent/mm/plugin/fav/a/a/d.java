package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.Map;

public final class d
{
  public static String a(akq paramakq)
  {
    int j = 0;
    AppMethodBeat.i(103502);
    if ((paramakq == null) || ((paramakq.GjJ.isEmpty()) && (paramakq.GjI.isEmpty())))
    {
      ad.v("MicroMsg.FavTagParser", "tag list toXml data list empty");
      AppMethodBeat.o(103502);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int k = paramakq.GjJ.size();
    localStringBuffer.append("<taglist count='").append(k).append("'>");
    int i = 0;
    while (i < k)
    {
      localStringBuffer.append("<tag>").append(bt.aRc((String)paramakq.GjJ.get(i))).append("</tag>");
      i += 1;
    }
    localStringBuffer.append("</taglist>");
    k = paramakq.GjI.size();
    localStringBuffer.append("<recommendtaglist count='").append(k).append("'>");
    i = j;
    while (i < k)
    {
      localStringBuffer.append("<tag>").append(bt.aRc((String)paramakq.GjI.get(i))).append("</tag>");
      i += 1;
    }
    localStringBuffer.append("</recommendtaglist>");
    paramakq = localStringBuffer.toString();
    AppMethodBeat.o(103502);
    return paramakq;
  }
  
  public static void a(Map<String, String> paramMap, akq paramakq)
  {
    AppMethodBeat.i(103501);
    if ((paramMap == null) || (paramakq == null))
    {
      ad.w("MicroMsg.FavTagParser", "maps is null or item is null");
      AppMethodBeat.o(103501);
      return;
    }
    paramakq.GjJ.clear();
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
        paramakq.GjJ.add(localObject);
        i += 1;
        break;
      }
    }
    label107:
    if (!paramakq.GjJ.isEmpty()) {
      ad.d("MicroMsg.FavTagParser", "user def tag not empty, res=%s", new Object[] { paramakq.GjJ });
    }
    paramakq.GjI.clear();
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
        paramakq.GjI.add(localObject);
        i += 1;
        break;
      }
    }
    label216:
    if (!paramakq.GjI.isEmpty()) {
      ad.d("MicroMsg.FavTagParser", "recommended tag not empty, res=%s", new Object[] { paramakq.GjI });
    }
    AppMethodBeat.o(103501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.d
 * JD-Core Version:    0.7.0.1
 */