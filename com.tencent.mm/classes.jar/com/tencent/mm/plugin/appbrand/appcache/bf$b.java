package com.tencent.mm.plugin.appbrand.appcache;

import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

abstract interface bf$b<T>
{
  public abstract T b(String paramString, InputStream paramInputStream);
  
  public static final class a
  {
    static final Map<Class, bf.b> jIH;
    
    static
    {
      AppMethodBeat.i(134691);
      HashMap localHashMap = new HashMap();
      jIH = localHashMap;
      localHashMap.put(InputStream.class, new bf.c((byte)0));
      jIH.put(WebResourceResponse.class, new bf.e((byte)0));
      jIH.put(String.class, new bf.d((byte)0));
      jIH.put([B.class, new bf.a((byte)0));
      AppMethodBeat.o(134691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bf.b
 * JD-Core Version:    0.7.0.1
 */