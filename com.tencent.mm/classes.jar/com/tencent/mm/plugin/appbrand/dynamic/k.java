package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class k
{
  private static final Map<String, WxaWidgetContext> kfk;
  
  static
  {
    AppMethodBeat.i(121197);
    kfk = new ConcurrentHashMap();
    AppMethodBeat.o(121197);
  }
  
  public static WxaWidgetContext OA(String paramString)
  {
    AppMethodBeat.i(121196);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(121196);
      return null;
    }
    paramString = (WxaWidgetContext)kfk.remove(paramString);
    AppMethodBeat.o(121196);
    return paramString;
  }
  
  public static WxaWidgetContext Oz(String paramString)
  {
    AppMethodBeat.i(121195);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(121195);
      return null;
    }
    paramString = (WxaWidgetContext)kfk.get(paramString);
    AppMethodBeat.o(121195);
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
    kfk.put(paramString, paramWxaWidgetContext);
    AppMethodBeat.o(121194);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.k
 * JD-Core Version:    0.7.0.1
 */