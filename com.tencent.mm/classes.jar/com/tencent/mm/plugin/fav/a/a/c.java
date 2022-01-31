package com.tencent.mm.plugin.fav.a.a;

import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  public static String a(yw paramyw)
  {
    int j = 0;
    if ((paramyw == null) || ((paramyw.sXq.isEmpty()) && (paramyw.sXp.isEmpty())))
    {
      y.v("MicroMsg.FavTagParser", "tag list toXml data list empty");
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int k = paramyw.sXq.size();
    localStringBuffer.append("<taglist count='").append(k).append("'>");
    int i = 0;
    while (i < k)
    {
      localStringBuffer.append("<tag>").append(bk.ZP((String)paramyw.sXq.get(i))).append("</tag>");
      i += 1;
    }
    localStringBuffer.append("</taglist>");
    k = paramyw.sXp.size();
    localStringBuffer.append("<recommendtaglist count='").append(k).append("'>");
    i = j;
    while (i < k)
    {
      localStringBuffer.append("<tag>").append(bk.ZP((String)paramyw.sXp.get(i))).append("</tag>");
      i += 1;
    }
    localStringBuffer.append("</recommendtaglist>");
    return localStringBuffer.toString();
  }
  
  public static void a(Map<String, String> paramMap, yw paramyw)
  {
    if ((paramMap == null) || (paramyw == null)) {
      y.w("MicroMsg.FavTagParser", "maps is null or item is null");
    }
    label97:
    do
    {
      return;
      paramyw.sXq.clear();
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
            break label97;
          }
          paramyw.sXq.add(localObject);
          i += 1;
          break;
        }
      }
      if (!paramyw.sXq.isEmpty()) {
        y.d("MicroMsg.FavTagParser", "user def tag not empty, res=%s", new Object[] { paramyw.sXq });
      }
      paramyw.sXp.clear();
      i = 0;
      if (i < 1024)
      {
        localStringBuilder = new StringBuilder(".favitem.recommendtaglist.tag");
        if (i > 0) {}
        for (localObject = Integer.valueOf(i);; localObject = "")
        {
          localObject = (String)paramMap.get(localObject);
          if (localObject == null) {
            break label206;
          }
          paramyw.sXp.add(localObject);
          i += 1;
          break;
        }
      }
    } while (paramyw.sXp.isEmpty());
    label206:
    y.d("MicroMsg.FavTagParser", "recommended tag not empty, res=%s", new Object[] { paramyw.sXp });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.c
 * JD-Core Version:    0.7.0.1
 */