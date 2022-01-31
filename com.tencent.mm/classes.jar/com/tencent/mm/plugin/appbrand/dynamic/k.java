package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class k
{
  private static final Map<String, WxaWidgetContext> fUc = new ConcurrentHashMap();
  
  public static boolean a(String paramString, WxaWidgetContext paramWxaWidgetContext)
  {
    if ((bk.bl(paramString)) || (paramWxaWidgetContext == null)) {
      return false;
    }
    fUc.put(paramString, paramWxaWidgetContext);
    return true;
  }
  
  public static WxaWidgetContext tb(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return (WxaWidgetContext)fUc.get(paramString);
  }
  
  public static WxaWidgetContext tc(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return (WxaWidgetContext)fUc.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.k
 * JD-Core Version:    0.7.0.1
 */