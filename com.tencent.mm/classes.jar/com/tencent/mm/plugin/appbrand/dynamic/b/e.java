package com.tencent.mm.plugin.appbrand.dynamic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private static volatile e hot;
  private Map<String, SoftReference<WxaPkgWrappingInfo>> eEE;
  
  private e()
  {
    AppMethodBeat.i(10789);
    this.eEE = new ConcurrentHashMap();
    AppMethodBeat.o(10789);
  }
  
  public static WxaPkgWrappingInfo Bf(String paramString)
  {
    AppMethodBeat.i(10791);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(10791);
      return null;
    }
    paramString = (SoftReference)azO().eEE.get(paramString);
    if (paramString != null)
    {
      paramString = (WxaPkgWrappingInfo)paramString.get();
      AppMethodBeat.o(10791);
      return paramString;
    }
    AppMethodBeat.o(10791);
    return null;
  }
  
  public static boolean a(String paramString, WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(10790);
    if ((paramString == null) || (paramString.length() == 0) || (paramWxaPkgWrappingInfo == null))
    {
      AppMethodBeat.o(10790);
      return false;
    }
    azO().eEE.put(paramString, new SoftReference(paramWxaPkgWrappingInfo));
    AppMethodBeat.o(10790);
    return true;
  }
  
  private static e azO()
  {
    AppMethodBeat.i(10788);
    if (hot == null) {}
    try
    {
      if (hot == null) {
        hot = new e();
      }
      e locale = hot;
      AppMethodBeat.o(10788);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(10788);
    }
  }
  
  public static void removeAll()
  {
    AppMethodBeat.i(10792);
    azO().eEE.clear();
    AppMethodBeat.o(10792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.e
 * JD-Core Version:    0.7.0.1
 */