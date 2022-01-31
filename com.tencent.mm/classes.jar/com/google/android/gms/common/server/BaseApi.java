package com.google.android.gms.common.server;

import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class BaseApi
{
  @Deprecated
  public static String append(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(61434);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    if (paramString1.indexOf("?") != -1) {
      localStringBuilder.append('&');
    }
    for (;;)
    {
      localStringBuilder.append(paramString2);
      localStringBuilder.append('=');
      localStringBuilder.append(paramString3);
      paramString1 = localStringBuilder.toString();
      AppMethodBeat.o(61434);
      return paramString1;
      localStringBuilder.append('?');
    }
  }
  
  public static void append(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    AppMethodBeat.i(61435);
    if (paramStringBuilder.indexOf("?") != -1) {
      paramStringBuilder.append('&');
    }
    for (;;)
    {
      paramStringBuilder.append(paramString1);
      paramStringBuilder.append('=');
      paramStringBuilder.append(paramString2);
      AppMethodBeat.o(61435);
      return;
      paramStringBuilder.append('?');
    }
  }
  
  public static String enc(String paramString)
  {
    AppMethodBeat.i(61432);
    Preconditions.checkNotNull(paramString, "Encoding a null parameter!");
    paramString = Uri.encode(paramString);
    AppMethodBeat.o(61432);
    return paramString;
  }
  
  protected static List<String> enc(List<String> paramList)
  {
    AppMethodBeat.i(61433);
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(enc((String)paramList.get(i)));
      i += 1;
    }
    AppMethodBeat.o(61433);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.server.BaseApi
 * JD-Core Version:    0.7.0.1
 */