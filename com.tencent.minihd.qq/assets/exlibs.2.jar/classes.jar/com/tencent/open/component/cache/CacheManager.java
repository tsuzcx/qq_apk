package com.tencent.open.component.cache;

import android.content.Context;
import com.tencent.open.component.cache.database.DbCacheService;
import java.io.File;
import lfh;

public class CacheManager
{
  protected static DbCacheService a;
  
  public static DbCacheService a()
  {
    return a;
  }
  
  protected static String a(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramContext = lfh.a(paramContext); paramContext == null; paramContext = lfh.a(paramContext, "cache")) {
      return null;
    }
    return paramContext.getAbsolutePath();
  }
  
  public static void a(Context paramContext)
  {
    a = DbCacheService.a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.component.cache.CacheManager
 * JD-Core Version:    0.7.0.1
 */