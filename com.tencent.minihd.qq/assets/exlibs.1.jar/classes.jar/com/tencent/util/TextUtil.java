package com.tencent.util;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TextUtil
{
  private static String a(String paramString)
  {
    try
    {
      paramString = new URL(paramString).getQuery();
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    paramString1 = (HashMap)a(a(paramString1));
    if (paramString1 != null) {
      return (String)paramString1.get(paramString2);
    }
    return "";
  }
  
  private static Map a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("&")))
    {
      paramString = paramString.split("&");
      if (paramString != null)
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          String[] arrayOfString = paramString[i];
          if (arrayOfString.contains("="))
          {
            arrayOfString = arrayOfString.split("=");
            localHashMap.put(arrayOfString[0], arrayOfString[1]);
          }
          for (;;)
          {
            i += 1;
            break;
            localHashMap.put(arrayOfString, "");
          }
        }
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.util.TextUtil
 * JD-Core Version:    0.7.0.1
 */