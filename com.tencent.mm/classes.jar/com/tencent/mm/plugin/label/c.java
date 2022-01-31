package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class c
{
  public static String cd(List<String> paramList)
  {
    AppMethodBeat.i(22508);
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
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(22508);
    return paramList;
  }
  
  public static String eZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(22506);
    ab.d("MicroMsg.Label.LabelUtils", "original:%s,waitToAddLabel:%s", new Object[] { paramString1, paramString2 });
    if (bo.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(22506);
      return paramString1;
    }
    if (bo.isNullOrNil(paramString1))
    {
      paramString1 = paramString2 + "";
      AppMethodBeat.o(22506);
      return paramString1;
    }
    String str = paramString1;
    if (paramString1.endsWith("")) {
      str = paramString1.replace("", "");
    }
    if (bo.P(str.split(",")).contains(paramString2))
    {
      paramString1 = str + "";
      AppMethodBeat.o(22506);
      return paramString1;
    }
    paramString1 = str + "," + paramString2 + "";
    AppMethodBeat.o(22506);
    return paramString1;
  }
  
  public static String fa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(22507);
    ab.d("MicroMsg.Label.LabelUtils", "original:%s,waitToDelLabel:%s", new Object[] { paramString1, paramString2 });
    if (bo.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(22507);
      return paramString1;
    }
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(22507);
      return "";
    }
    String str = paramString1;
    if (paramString1.endsWith("")) {
      str = paramString1.replace("", "");
    }
    paramString1 = bo.P(str.split(","));
    if (paramString1.contains(paramString2))
    {
      paramString1.remove(paramString2);
      paramString1 = cd(paramString1);
      AppMethodBeat.o(22507);
      return paramString1;
    }
    AppMethodBeat.o(22507);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.c
 * JD-Core Version:    0.7.0.1
 */