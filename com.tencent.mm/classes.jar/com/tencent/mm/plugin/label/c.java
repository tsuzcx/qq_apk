package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class c
{
  public static String dU(List<String> paramList)
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
  
  public static String ha(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26129);
    ad.d("MicroMsg.Label.LabelUtils", "original:%s,waitToAddLabel:%s", new Object[] { paramString1, paramString2 });
    if (bt.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(26129);
      return paramString1;
    }
    if (bt.isNullOrNil(paramString1))
    {
      paramString1 = paramString2 + "";
      AppMethodBeat.o(26129);
      return paramString1;
    }
    String str = paramString1;
    if (paramString1.endsWith("")) {
      str = paramString1.replace("", "");
    }
    if (bt.S(str.split(",")).contains(paramString2))
    {
      paramString1 = str + "";
      AppMethodBeat.o(26129);
      return paramString1;
    }
    paramString1 = str + "," + paramString2 + "";
    AppMethodBeat.o(26129);
    return paramString1;
  }
  
  public static String hb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26130);
    ad.d("MicroMsg.Label.LabelUtils", "original:%s,waitToDelLabel:%s", new Object[] { paramString1, paramString2 });
    if (bt.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(26130);
      return paramString1;
    }
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(26130);
      return "";
    }
    String str = paramString1;
    if (paramString1.endsWith("")) {
      str = paramString1.replace("", "");
    }
    paramString1 = bt.S(str.split(","));
    if (paramString1.contains(paramString2))
    {
      paramString1.remove(paramString2);
      paramString1 = dU(paramString1);
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