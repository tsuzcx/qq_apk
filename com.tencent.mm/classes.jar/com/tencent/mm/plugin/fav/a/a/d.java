package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.Map;

public final class d
{
  public static String a(ala paramala)
  {
    int j = 0;
    AppMethodBeat.i(103502);
    if ((paramala == null) || ((paramala.GCs.isEmpty()) && (paramala.GCr.isEmpty())))
    {
      ae.v("MicroMsg.FavTagParser", "tag list toXml data list empty");
      AppMethodBeat.o(103502);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int k = paramala.GCs.size();
    localStringBuffer.append("<taglist count='").append(k).append("'>");
    int i = 0;
    while (i < k)
    {
      localStringBuffer.append("<tag>").append(bu.aSz((String)paramala.GCs.get(i))).append("</tag>");
      i += 1;
    }
    localStringBuffer.append("</taglist>");
    k = paramala.GCr.size();
    localStringBuffer.append("<recommendtaglist count='").append(k).append("'>");
    i = j;
    while (i < k)
    {
      localStringBuffer.append("<tag>").append(bu.aSz((String)paramala.GCr.get(i))).append("</tag>");
      i += 1;
    }
    localStringBuffer.append("</recommendtaglist>");
    paramala = localStringBuffer.toString();
    AppMethodBeat.o(103502);
    return paramala;
  }
  
  public static void a(Map<String, String> paramMap, ala paramala)
  {
    AppMethodBeat.i(103501);
    if ((paramMap == null) || (paramala == null))
    {
      ae.w("MicroMsg.FavTagParser", "maps is null or item is null");
      AppMethodBeat.o(103501);
      return;
    }
    paramala.GCs.clear();
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
        paramala.GCs.add(localObject);
        i += 1;
        break;
      }
    }
    label107:
    if (!paramala.GCs.isEmpty()) {
      ae.d("MicroMsg.FavTagParser", "user def tag not empty, res=%s", new Object[] { paramala.GCs });
    }
    paramala.GCr.clear();
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
        paramala.GCr.add(localObject);
        i += 1;
        break;
      }
    }
    label216:
    if (!paramala.GCr.isEmpty()) {
      ae.d("MicroMsg.FavTagParser", "recommended tag not empty, res=%s", new Object[] { paramala.GCr });
    }
    AppMethodBeat.o(103501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.d
 * JD-Core Version:    0.7.0.1
 */