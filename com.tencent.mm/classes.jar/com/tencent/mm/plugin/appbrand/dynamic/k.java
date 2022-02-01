package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class k
{
  private static final Map<String, WxaWidgetContext> kiA;
  
  static
  {
    AppMethodBeat.i(121197);
    kiA = new ConcurrentHashMap();
    AppMethodBeat.o(121197);
  }
  
  public static WxaWidgetContext Ph(String paramString)
  {
    AppMethodBeat.i(121195);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(121195);
      return null;
    }
    paramString = (WxaWidgetContext)kiA.get(paramString);
    AppMethodBeat.o(121195);
    return paramString;
  }
  
  public static WxaWidgetContext Pi(String paramString)
  {
    AppMethodBeat.i(121196);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(121196);
      return null;
    }
    paramString = (WxaWidgetContext)kiA.remove(paramString);
    AppMethodBeat.o(121196);
    return paramString;
  }
  
  public static boolean a(String paramString, WxaWidgetContext paramWxaWidgetContext)
  {
    AppMethodBeat.i(121194);
    if ((bu.isNullOrNil(paramString)) || (paramWxaWidgetContext == null))
    {
      AppMethodBeat.o(121194);
      return false;
    }
    kiA.put(paramString, paramWxaWidgetContext);
    AppMethodBeat.o(121194);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.k
 * JD-Core Version:    0.7.0.1
 */