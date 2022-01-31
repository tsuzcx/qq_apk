package com.tencent.mm.plugin.label;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  public static String bG(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)paramList.get(i));
        if (i < j - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
      localStringBuilder.append("");
    }
    return localStringBuilder.toString();
  }
  
  public static String dH(String paramString1, String paramString2)
  {
    y.d("MicroMsg.Label.LabelUtils", "original:%s,waitToAddLabel:%s", new Object[] { paramString1, paramString2 });
    if (bk.bl(paramString2)) {
      return paramString1;
    }
    if (bk.bl(paramString1)) {
      return paramString2 + "";
    }
    String str = paramString1;
    if (paramString1.endsWith("")) {
      str = paramString1.replace("", "");
    }
    if (bk.G(str.split(",")).contains(paramString2)) {
      return str + "";
    }
    return str + "," + paramString2 + "";
  }
  
  public static String dI(String paramString1, String paramString2)
  {
    y.d("MicroMsg.Label.LabelUtils", "original:%s,waitToDelLabel:%s", new Object[] { paramString1, paramString2 });
    if (bk.bl(paramString2)) {}
    ArrayList localArrayList;
    do
    {
      return paramString1;
      if (bk.bl(paramString1)) {
        return "";
      }
      String str = paramString1;
      if (paramString1.endsWith("")) {
        str = paramString1.replace("", "");
      }
      localArrayList = bk.G(str.split(","));
      paramString1 = str;
    } while (!localArrayList.contains(paramString2));
    localArrayList.remove(paramString2);
    return bG(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.c
 * JD-Core Version:    0.7.0.1
 */