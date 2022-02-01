package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.Map;

public final class d
{
  public static String a(ahb paramahb)
  {
    int j = 0;
    AppMethodBeat.i(103502);
    if ((paramahb == null) || ((paramahb.DiR.isEmpty()) && (paramahb.DiQ.isEmpty())))
    {
      ad.v("MicroMsg.FavTagParser", "tag list toXml data list empty");
      AppMethodBeat.o(103502);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int k = paramahb.DiR.size();
    localStringBuffer.append("<taglist count='").append(k).append("'>");
    int i = 0;
    while (i < k)
    {
      localStringBuffer.append("<tag>").append(bt.aGf((String)paramahb.DiR.get(i))).append("</tag>");
      i += 1;
    }
    localStringBuffer.append("</taglist>");
    k = paramahb.DiQ.size();
    localStringBuffer.append("<recommendtaglist count='").append(k).append("'>");
    i = j;
    while (i < k)
    {
      localStringBuffer.append("<tag>").append(bt.aGf((String)paramahb.DiQ.get(i))).append("</tag>");
      i += 1;
    }
    localStringBuffer.append("</recommendtaglist>");
    paramahb = localStringBuffer.toString();
    AppMethodBeat.o(103502);
    return paramahb;
  }
  
  public static void a(Map<String, String> paramMap, ahb paramahb)
  {
    AppMethodBeat.i(103501);
    if ((paramMap == null) || (paramahb == null))
    {
      ad.w("MicroMsg.FavTagParser", "maps is null or item is null");
      AppMethodBeat.o(103501);
      return;
    }
    paramahb.DiR.clear();
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
        paramahb.DiR.add(localObject);
        i += 1;
        break;
      }
    }
    label107:
    if (!paramahb.DiR.isEmpty()) {
      ad.d("MicroMsg.FavTagParser", "user def tag not empty, res=%s", new Object[] { paramahb.DiR });
    }
    paramahb.DiQ.clear();
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
        paramahb.DiQ.add(localObject);
        i += 1;
        break;
      }
    }
    label216:
    if (!paramahb.DiQ.isEmpty()) {
      ad.d("MicroMsg.FavTagParser", "recommended tag not empty, res=%s", new Object[] { paramahb.DiQ });
    }
    AppMethodBeat.o(103501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.d
 * JD-Core Version:    0.7.0.1
 */