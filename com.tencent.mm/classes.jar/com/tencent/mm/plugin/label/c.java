package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public final class c
{
  public static String dY(List<String> paramList)
  {
    AppMethodBeat.i(26131);
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
    AppMethodBeat.o(26131);
    return paramList;
  }
  
  public static String hr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26129);
    ac.d("MicroMsg.Label.LabelUtils", "original:%s,waitToAddLabel:%s", new Object[] { paramString1, paramString2 });
    if (bs.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(26129);
      return paramString1;
    }
    if (bs.isNullOrNil(paramString1))
    {
      paramString1 = paramString2 + "";
      AppMethodBeat.o(26129);
      return paramString1;
    }
    String str = paramString1;
    if (paramString1.endsWith("")) {
      str = paramString1.replace("", "");
    }
    if (bs.S(str.split(",")).contains(paramString2))
    {
      paramString1 = str + "";
      AppMethodBeat.o(26129);
      return paramString1;
    }
    paramString1 = str + "," + paramString2 + "";
    AppMethodBeat.o(26129);
    return paramString1;
  }
  
  public static String hs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26130);
    ac.d("MicroMsg.Label.LabelUtils", "original:%s,waitToDelLabel:%s", new Object[] { paramString1, paramString2 });
    if (bs.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(26130);
      return paramString1;
    }
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(26130);
      return "";
    }
    String str = paramString1;
    if (paramString1.endsWith("")) {
      str = paramString1.replace("", "");
    }
    paramString1 = bs.S(str.split(","));
    if (paramString1.contains(paramString2))
    {
      paramString1.remove(paramString2);
      paramString1 = dY(paramString1);
      AppMethodBeat.o(26130);
      return paramString1;
    }
    AppMethodBeat.o(26130);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.c
 * JD-Core Version:    0.7.0.1
 */