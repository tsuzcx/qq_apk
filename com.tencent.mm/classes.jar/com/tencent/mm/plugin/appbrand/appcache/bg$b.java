package com.tencent.mm.plugin.appbrand.appcache;

import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

abstract interface bg$b<T>
{
  public abstract T b(String paramString, InputStream paramInputStream);
  
  public static final class a
  {
    static final Map<Class, bg.b> jLI;
    
    static
    {
      AppMethodBeat.i(134691);
      HashMap localHashMap = new HashMap();
      jLI = localHashMap;
      localHashMap.put(InputStream.class, new bg.c((byte)0));
      jLI.put(WebResourceResponse.class, new bg.e((byte)0));
      jLI.put(String.class, new bg.d((byte)0));
      jLI.put([B.class, new bg.a((byte)0));
      AppMethodBeat.o(134691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bg.b
 * JD-Core Version:    0.7.0.1
 */