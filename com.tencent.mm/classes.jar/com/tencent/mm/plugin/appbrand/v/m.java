package com.tencent.mm.plugin.appbrand.v;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class m
{
  private static final Map<String, String> hly;
  private static final Map<String, String> hlz;
  
  static
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new Pair("silk", "audio/silk"));
    ((ArrayList)localObject).add(new Pair("jpg", "image/jpg"));
    ((ArrayList)localObject).add(new Pair("json", "application/json"));
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
      localHashMap1.put(localPair.first, localPair.second);
      localHashMap2.put(localPair.second, localPair.first);
    }
    hly = Collections.unmodifiableMap(localHashMap1);
    hlz = Collections.unmodifiableMap(localHashMap2);
  }
  
  public static String wJ(String paramString)
  {
    Object localObject2;
    if (TextUtils.isEmpty(paramString)) {
      localObject2 = null;
    }
    do
    {
      Object localObject1;
      do
      {
        return localObject2;
        localObject2 = (String)hly.get(paramString.toLowerCase());
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramString)) {
            localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
          }
        }
        localObject2 = localObject1;
      } while (!TextUtils.isEmpty((CharSequence)localObject1));
      localObject2 = localObject1;
    } while (!"mp3".equals(paramString));
    return "audio/mpeg";
  }
  
  public static String wK(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      return wJ((String)localObject1);
      int i = paramString.lastIndexOf('.');
      localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = localObject2;
        if (i < paramString.length() - 1) {
          localObject1 = paramString.substring(i + 1);
        }
      }
    }
  }
  
  public static String wL(String paramString)
  {
    Object localObject2;
    if (TextUtils.isEmpty(paramString)) {
      localObject2 = null;
    }
    do
    {
      Object localObject1;
      do
      {
        return localObject2;
        localObject2 = (String)hlz.get(paramString.toLowerCase());
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString);
        }
        localObject2 = localObject1;
      } while (!TextUtils.isEmpty((CharSequence)localObject1));
      if ("audio/mpeg".equals(paramString)) {
        return "mp3";
      }
      if ("audio/mp3".equals(paramString)) {
        return "mp3";
      }
      localObject2 = localObject1;
    } while (!"audio/mp4".equals(paramString));
    return "mp4";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.m
 * JD-Core Version:    0.7.0.1
 */