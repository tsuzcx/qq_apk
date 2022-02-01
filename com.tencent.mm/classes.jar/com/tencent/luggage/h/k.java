package com.tencent.luggage.h;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class k
{
  public static boolean C(String paramString1, String paramString2)
  {
    AppMethodBeat.i(140523);
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() < 0) || (paramString2.length() < 0))
    {
      AppMethodBeat.o(140523);
      return false;
    }
    if (paramString2.length() > paramString1.length())
    {
      AppMethodBeat.o(140523);
      return false;
    }
    if (paramString2.equalsIgnoreCase(paramString1.substring(0, paramString2.length())))
    {
      AppMethodBeat.o(140523);
      return true;
    }
    AppMethodBeat.o(140523);
    return false;
  }
  
  public static String ds(String paramString)
  {
    AppMethodBeat.i(201171);
    try
    {
      paramString = Uri.parse(paramString).getHost();
      AppMethodBeat.o(201171);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(201171);
    }
    return "";
  }
  
  public static String dt(String paramString)
  {
    AppMethodBeat.i(140521);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140521);
      return paramString;
    }
    int i = paramString.indexOf('?');
    if (i < 0)
    {
      AppMethodBeat.o(140521);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(140521);
    return paramString;
  }
  
  public static Map<String, String> du(String paramString)
  {
    AppMethodBeat.i(140522);
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140522);
      return localHashMap;
    }
    int i = paramString.indexOf('?');
    if (i < 0)
    {
      AppMethodBeat.o(140522);
      return localHashMap;
    }
    i += 1;
    int j = paramString.lastIndexOf('&');
    int k = paramString.lastIndexOf('#');
    if ((k >= 0) && (k > j) && (i <= k)) {}
    for (paramString = paramString.substring(i, k); TextUtils.isEmpty(paramString); paramString = paramString.substring(i, paramString.length()))
    {
      AppMethodBeat.o(140522);
      return localHashMap;
    }
    j = 0;
    int m = paramString.length();
    int n = paramString.indexOf('&', j);
    label141:
    String str2;
    if (n != -1)
    {
      i = n;
      int i1 = paramString.indexOf('=', j);
      if (i1 <= i)
      {
        k = i1;
        if (i1 != -1) {}
      }
      else
      {
        k = i;
      }
      str2 = Uri.decode(paramString.substring(j, k));
      if (k != i) {
        break label219;
      }
    }
    label219:
    for (String str1 = "";; str1 = paramString.substring(k + 1, i))
    {
      localHashMap.put(str2, str1);
      if (n == -1) {
        break label232;
      }
      j = n + 1;
      break;
      i = m;
      break label141;
    }
    label232:
    AppMethodBeat.o(140522);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.h.k
 * JD-Core Version:    0.7.0.1
 */