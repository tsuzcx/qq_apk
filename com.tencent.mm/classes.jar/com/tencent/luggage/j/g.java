package com.tencent.luggage.j;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  public static String bi(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf('?');
    } while (i < 0);
    return paramString.substring(0, i);
  }
  
  public static Map<String, String> bj(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {
      return localHashMap;
    }
    int i = paramString.indexOf('?');
    if (i < 0) {
      return localHashMap;
    }
    i += 1;
    int j = paramString.lastIndexOf('&');
    int k = paramString.lastIndexOf('#');
    if ((k >= 0) && (k > j)) {}
    for (paramString = paramString.substring(i, k); TextUtils.isEmpty(paramString); paramString = paramString.substring(i, paramString.length())) {
      return localHashMap;
    }
    j = 0;
    int m = paramString.length();
    int n = paramString.indexOf('&', j);
    label116:
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
        break label194;
      }
    }
    label194:
    for (String str1 = "";; str1 = paramString.substring(k + 1, i))
    {
      localHashMap.put(str2, str1);
      if (n == -1) {
        break label207;
      }
      j = n + 1;
      break;
      i = m;
      break label116;
    }
    label207:
    return localHashMap;
  }
  
  public static boolean n(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() < 0) || (paramString2.length() < 0)) {}
    while ((paramString2.length() > paramString1.length()) || (!paramString2.equalsIgnoreCase(paramString1.substring(0, paramString2.length())))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.j.g
 * JD-Core Version:    0.7.0.1
 */