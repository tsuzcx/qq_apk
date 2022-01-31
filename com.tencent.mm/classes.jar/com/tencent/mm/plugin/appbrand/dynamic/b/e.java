package com.tencent.mm.plugin.appbrand.dynamic.b;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private static volatile e fUR;
  private Map<String, SoftReference<WxaPkgWrappingInfo>> dHb = new ConcurrentHashMap();
  
  public static boolean a(String paramString, WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramWxaPkgWrappingInfo == null)) {
      return false;
    }
    afk().dHb.put(paramString, new SoftReference(paramWxaPkgWrappingInfo));
    return true;
  }
  
  private static e afk()
  {
    if (fUR == null) {}
    try
    {
      if (fUR == null) {
        fUR = new e();
      }
      return fUR;
    }
    finally {}
  }
  
  public static void removeAll()
  {
    afk().dHb.clear();
  }
  
  public static WxaPkgWrappingInfo td(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    paramString = (SoftReference)afk().dHb.get(paramString);
    if (paramString != null) {
      return (WxaPkgWrappingInfo)paramString.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.e
 * JD-Core Version:    0.7.0.1
 */