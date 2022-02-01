package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o.a;
import java.util.Map;

public abstract interface i
{
  public static final class a
    extends o.a
  {
    public a(String paramString, Object... paramVarArgs)
    {
      super(paramVarArgs);
    }
    
    public final a G(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(140673);
      paramMap = (a)super.B(paramMap);
      AppMethodBeat.o(140673);
      return paramMap;
    }
    
    public final a p(String paramString, Object paramObject)
    {
      AppMethodBeat.i(140672);
      paramString = (a)super.n(paramString, paramObject);
      AppMethodBeat.o(140672);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.i
 * JD-Core Version:    0.7.0.1
 */