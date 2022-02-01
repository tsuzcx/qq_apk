package com.tencent.mm.plugin.appbrand.dynamic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private static volatile e rll;
  private Map<String, SoftReference<WxaPkgWrappingInfo>> mMap;
  
  private e()
  {
    AppMethodBeat.i(121271);
    this.mMap = new ConcurrentHashMap();
    AppMethodBeat.o(121271);
  }
  
  public static WxaPkgWrappingInfo Ze(String paramString)
  {
    AppMethodBeat.i(121273);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(121273);
      return null;
    }
    paramString = (SoftReference)cnJ().mMap.get(paramString);
    if (paramString != null)
    {
      paramString = (WxaPkgWrappingInfo)paramString.get();
      AppMethodBeat.o(121273);
      return paramString;
    }
    AppMethodBeat.o(121273);
    return null;
  }
  
  public static boolean b(String paramString, WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(121272);
    if ((paramString == null) || (paramString.length() == 0) || (paramWxaPkgWrappingInfo == null))
    {
      AppMethodBeat.o(121272);
      return false;
    }
    cnJ().mMap.put(paramString, new SoftReference(paramWxaPkgWrappingInfo));
    AppMethodBeat.o(121272);
    return true;
  }
  
  private static e cnJ()
  {
    AppMethodBeat.i(121270);
    if (rll == null) {}
    try
    {
      if (rll == null) {
        rll = new e();
      }
      e locale = rll;
      AppMethodBeat.o(121270);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(121270);
    }
  }
  
  public static void removeAll()
  {
    AppMethodBeat.i(121274);
    cnJ().mMap.clear();
    AppMethodBeat.o(121274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.e
 * JD-Core Version:    0.7.0.1
 */