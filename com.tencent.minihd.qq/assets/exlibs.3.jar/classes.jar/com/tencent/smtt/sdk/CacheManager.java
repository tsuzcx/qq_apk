package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.i;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

@Deprecated
public final class CacheManager
{
  @Deprecated
  public static boolean cacheDisabled()
  {
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b())) {
      return ((Boolean)((x)localObject).c().c()).booleanValue();
    }
    localObject = i.a("android.webkit.CacheManager", "cacheDisabled");
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public static InputStream getCacheFile(String paramString, boolean paramBoolean)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().a(paramString, paramBoolean);
    }
    return null;
  }
  
  public static Object getCacheFile(String paramString, Map<String, String> paramMap)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().g();
    }
    try
    {
      paramString = i.a(Class.forName("android.webkit.CacheManager"), "getCacheFile", new Class[] { String.class, Map.class }, new Object[] { paramString, paramMap });
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  @Deprecated
  public static File getCacheFileBaseDir()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return (File)localx.c().g();
    }
    return (File)i.a("android.webkit.CacheManager", "getCacheFileBaseDir");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.CacheManager
 * JD-Core Version:    0.7.0.1
 */