package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.m;

abstract interface r
  extends q
{
  public abstract String LO(String paramString);
  
  public abstract <T> T f(String paramString, Class<T> paramClass);
  
  public static final class a
  {
    static r jIP;
    
    static
    {
      AppMethodBeat.i(178520);
      jIP = (r)m.g("IWxaPkgRuntimeReaderEx.DUMMY", r.class);
      AppMethodBeat.o(178520);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.r
 * JD-Core Version:    0.7.0.1
 */