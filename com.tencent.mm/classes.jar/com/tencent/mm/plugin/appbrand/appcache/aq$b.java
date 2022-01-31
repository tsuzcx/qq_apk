package com.tencent.mm.plugin.appbrand.appcache;

import android.webkit.WebResourceResponse;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

abstract interface aq$b<T>
{
  public abstract T c(String paramString, InputStream paramInputStream);
  
  public static final class a
  {
    static final Map<Class, aq.b> fEA;
    
    static
    {
      HashMap localHashMap = new HashMap();
      fEA = localHashMap;
      localHashMap.put(InputStream.class, new aq.c((byte)0));
      fEA.put(WebResourceResponse.class, new aq.e((byte)0));
      fEA.put(String.class, new aq.d((byte)0));
      fEA.put([B.class, new aq.a((byte)0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aq.b
 * JD-Core Version:    0.7.0.1
 */