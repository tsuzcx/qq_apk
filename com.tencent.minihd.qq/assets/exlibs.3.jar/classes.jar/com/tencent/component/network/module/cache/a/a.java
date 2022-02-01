package com.tencent.component.network.module.cache.a;

import com.tencent.component.network.module.cache.common.LruCache;
import com.tencent.component.network.utils.FileUtils;

public class a
  extends LruCache
{
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  private static int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0;
    }
    return 1;
  }
  
  protected int a(Object paramObject, String paramString)
  {
    return a(paramString);
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      FileUtils.a(paramString);
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject, String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {}
    while ((paramString1 != null) && (paramString1.equals(paramString2))) {
      return;
    }
    try
    {
      a(paramString1);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.cache.a.a
 * JD-Core Version:    0.7.0.1
 */