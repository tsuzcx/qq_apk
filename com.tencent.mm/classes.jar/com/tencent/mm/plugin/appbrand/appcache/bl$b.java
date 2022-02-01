package com.tencent.mm.plugin.appbrand.appcache;

import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

abstract interface bl$b<T>
{
  public abstract T b(String paramString, InputStream paramInputStream);
  
  public static final class a
  {
    static final Map<Class, bl.b> nHH;
    
    static
    {
      AppMethodBeat.i(134691);
      HashMap localHashMap = new HashMap();
      nHH = localHashMap;
      localHashMap.put(InputStream.class, new bl.c((byte)0));
      nHH.put(WebResourceResponse.class, new bl.e((byte)0));
      nHH.put(String.class, new bl.d((byte)0));
      nHH.put([B.class, new bl.a((byte)0));
      AppMethodBeat.o(134691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bl.b
 * JD-Core Version:    0.7.0.1
 */