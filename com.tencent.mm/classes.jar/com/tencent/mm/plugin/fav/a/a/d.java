package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.Map;

public final class d
{
  public static String a(aia paramaia)
  {
    int j = 0;
    AppMethodBeat.i(103502);
    if ((paramaia == null) || ((paramaia.EBX.isEmpty()) && (paramaia.EBW.isEmpty())))
    {
      ac.v("MicroMsg.FavTagParser", "tag list toXml data list empty");
      AppMethodBeat.o(103502);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int k = paramaia.EBX.size();
    localStringBuffer.append("<taglist count='").append(k).append("'>");
    int i = 0;
    while (i < k)
    {
      localStringBuffer.append("<tag>").append(bs.aLw((String)paramaia.EBX.get(i))).append("</tag>");
      i += 1;
    }
    localStringBuffer.append("</taglist>");
    k = paramaia.EBW.size();
    localStringBuffer.append("<recommendtaglist count='").append(k).append("'>");
    i = j;
    while (i < k)
    {
      localStringBuffer.append("<tag>").append(bs.aLw((String)paramaia.EBW.get(i))).append("</tag>");
      i += 1;
    }
    localStringBuffer.append("</recommendtaglist>");
    paramaia = localStringBuffer.toString();
    AppMethodBeat.o(103502);
    return paramaia;
  }
  
  public static void a(Map<String, String> paramMap, aia paramaia)
  {
    AppMethodBeat.i(103501);
    if ((paramMap == null) || (paramaia == null))
    {
      ac.w("MicroMsg.FavTagParser", "maps is null or item is null");
      AppMethodBeat.o(103501);
      return;
    }
    paramaia.EBX.clear();
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
        paramaia.EBX.add(localObject);
        i += 1;
        break;
      }
    }
    label107:
    if (!paramaia.EBX.isEmpty()) {
      ac.d("MicroMsg.FavTagParser", "user def tag not empty, res=%s", new Object[] { paramaia.EBX });
    }
    paramaia.EBW.clear();
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
        paramaia.EBW.add(localObject);
        i += 1;
        break;
      }
    }
    label216:
    if (!paramaia.EBW.isEmpty()) {
      ac.d("MicroMsg.FavTagParser", "recommended tag not empty, res=%s", new Object[] { paramaia.EBW });
    }
    AppMethodBeat.o(103501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.d
 * JD-Core Version:    0.7.0.1
 */