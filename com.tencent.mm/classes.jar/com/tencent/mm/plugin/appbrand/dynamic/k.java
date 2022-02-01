package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class k
{
  private static final Map<String, WxaWidgetContext> jKZ;
  
  static
  {
    AppMethodBeat.i(121197);
    jKZ = new ConcurrentHashMap();
    AppMethodBeat.o(121197);
  }
  
  public static WxaWidgetContext Lf(String paramString)
  {
    AppMethodBeat.i(121195);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(121195);
      return null;
    }
    paramString = (WxaWidgetContext)jKZ.get(paramString);
    AppMethodBeat.o(121195);
    return paramString;
  }
  
  public static WxaWidgetContext Lg(String paramString)
  {
    AppMethodBeat.i(121196);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(121196);
      return null;
    }
    paramString = (WxaWidgetContext)jKZ.remove(paramString);
    AppMethodBeat.o(121196);
    return paramString;
  }
  
  public static boolean a(String paramString, WxaWidgetContext paramWxaWidgetContext)
  {
    AppMethodBeat.i(121194);
    if ((bs.isNullOrNil(paramString)) || (paramWxaWidgetContext == null))
    {
      AppMethodBeat.o(121194);
      return false;
    }
    jKZ.put(paramString, paramWxaWidgetContext);
    AppMethodBeat.o(121194);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.k
 * JD-Core Version:    0.7.0.1
 */