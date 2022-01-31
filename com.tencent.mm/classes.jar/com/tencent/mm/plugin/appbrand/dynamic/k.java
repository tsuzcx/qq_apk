package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class k
{
  private static final Map<String, WxaWidgetContext> hnE;
  
  static
  {
    AppMethodBeat.i(10716);
    hnE = new ConcurrentHashMap();
    AppMethodBeat.o(10716);
  }
  
  public static WxaWidgetContext Bd(String paramString)
  {
    AppMethodBeat.i(10714);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(10714);
      return null;
    }
    paramString = (WxaWidgetContext)hnE.get(paramString);
    AppMethodBeat.o(10714);
    return paramString;
  }
  
  public static WxaWidgetContext Be(String paramString)
  {
    AppMethodBeat.i(10715);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(10715);
      return null;
    }
    paramString = (WxaWidgetContext)hnE.remove(paramString);
    AppMethodBeat.o(10715);
    return paramString;
  }
  
  public static boolean a(String paramString, WxaWidgetContext paramWxaWidgetContext)
  {
    AppMethodBeat.i(10713);
    if ((bo.isNullOrNil(paramString)) || (paramWxaWidgetContext == null))
    {
      AppMethodBeat.o(10713);
      return false;
    }
    hnE.put(paramString, paramWxaWidgetContext);
    AppMethodBeat.o(10713);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.k
 * JD-Core Version:    0.7.0.1
 */