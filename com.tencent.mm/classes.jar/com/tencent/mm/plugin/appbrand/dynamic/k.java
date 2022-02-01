package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class k
{
  private static final Map<String, WxaWidgetContext> jkM;
  
  static
  {
    AppMethodBeat.i(121197);
    jkM = new ConcurrentHashMap();
    AppMethodBeat.o(121197);
  }
  
  public static WxaWidgetContext Hb(String paramString)
  {
    AppMethodBeat.i(121195);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(121195);
      return null;
    }
    paramString = (WxaWidgetContext)jkM.get(paramString);
    AppMethodBeat.o(121195);
    return paramString;
  }
  
  public static WxaWidgetContext Hc(String paramString)
  {
    AppMethodBeat.i(121196);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(121196);
      return null;
    }
    paramString = (WxaWidgetContext)jkM.remove(paramString);
    AppMethodBeat.o(121196);
    return paramString;
  }
  
  public static boolean a(String paramString, WxaWidgetContext paramWxaWidgetContext)
  {
    AppMethodBeat.i(121194);
    if ((bt.isNullOrNil(paramString)) || (paramWxaWidgetContext == null))
    {
      AppMethodBeat.o(121194);
      return false;
    }
    jkM.put(paramString, paramWxaWidgetContext);
    AppMethodBeat.o(121194);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.k
 * JD-Core Version:    0.7.0.1
 */