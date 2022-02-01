package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.a;
import java.util.Map;

public abstract interface i
{
  public static final class a
    extends p.a
  {
    public a(String paramString, Object... paramVarArgs)
    {
      super(paramVarArgs);
    }
    
    public final a N(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(140673);
      paramMap = (a)super.I(paramMap);
      AppMethodBeat.o(140673);
      return paramMap;
    }
    
    public final a q(String paramString, Object paramObject)
    {
      AppMethodBeat.i(140672);
      paramString = (a)super.o(paramString, paramObject);
      AppMethodBeat.o(140672);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.i
 * JD-Core Version:    0.7.0.1
 */