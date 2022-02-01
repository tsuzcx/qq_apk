package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class m$a
{
  public final String errMsg;
  public final Map<String, Object> values;
  
  public m$a(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(140640);
    this.values = new HashMap();
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      this.errMsg = paramString;
      AppMethodBeat.o(140640);
      return;
    }
    this.errMsg = String.format(paramString, paramVarArgs);
    AppMethodBeat.o(140640);
  }
  
  public a q(String paramString, Object paramObject)
  {
    AppMethodBeat.i(140641);
    this.values.put(paramString, paramObject);
    AppMethodBeat.o(140641);
    return this;
  }
  
  public a z(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(140642);
    if (paramMap != null) {
      this.values.putAll(paramMap);
    }
    AppMethodBeat.o(140642);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a
 * JD-Core Version:    0.7.0.1
 */