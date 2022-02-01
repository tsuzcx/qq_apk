package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.Map;

public final class d
{
  public static String a(asi paramasi)
  {
    int j = 0;
    AppMethodBeat.i(103502);
    if ((paramasi == null) || ((paramasi.ZBH.isEmpty()) && (paramasi.ZBG.isEmpty())))
    {
      Log.v("MicroMsg.FavTagParser", "tag list toXml data list empty");
      AppMethodBeat.o(103502);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int k = paramasi.ZBH.size();
    localStringBuffer.append("<taglist count='").append(k).append("'>");
    int i = 0;
    while (i < k)
    {
      localStringBuffer.append("<tag>").append(Util.escapeStringForXml((String)paramasi.ZBH.get(i))).append("</tag>");
      i += 1;
    }
    localStringBuffer.append("</taglist>");
    k = paramasi.ZBG.size();
    localStringBuffer.append("<recommendtaglist count='").append(k).append("'>");
    i = j;
    while (i < k)
    {
      localStringBuffer.append("<tag>").append(Util.escapeStringForXml((String)paramasi.ZBG.get(i))).append("</tag>");
      i += 1;
    }
    localStringBuffer.append("</recommendtaglist>");
    paramasi = localStringBuffer.toString();
    AppMethodBeat.o(103502);
    return paramasi;
  }
  
  public static void a(Map<String, String> paramMap, asi paramasi)
  {
    AppMethodBeat.i(103501);
    if ((paramMap == null) || (paramasi == null))
    {
      Log.w("MicroMsg.FavTagParser", "maps is null or item is null");
      AppMethodBeat.o(103501);
      return;
    }
    paramasi.ZBH.clear();
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
        paramasi.ZBH.add(localObject);
        i += 1;
        break;
      }
    }
    label107:
    if (!paramasi.ZBH.isEmpty()) {
      Log.d("MicroMsg.FavTagParser", "user def tag not empty, res=%s", new Object[] { paramasi.ZBH });
    }
    paramasi.ZBG.clear();
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
        paramasi.ZBG.add(localObject);
        i += 1;
        break;
      }
    }
    label216:
    if (!paramasi.ZBG.isEmpty()) {
      Log.d("MicroMsg.FavTagParser", "recommended tag not empty, res=%s", new Object[] { paramasi.ZBG });
    }
    AppMethodBeat.o(103501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.d
 * JD-Core Version:    0.7.0.1
 */