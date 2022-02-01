package com.tencent.mm.plugin.expt.d.h.b.a;

import com.eclipsesource.v8.V8Array;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import org.apache.commons.b.g;

public final class a
  extends com.tencent.mm.plugin.expt.d.h.b.a
{
  public a(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public final Object b(V8Array paramV8Array)
  {
    AppMethodBeat.i(195940);
    if ((paramV8Array == null) || (paramV8Array.length() <= 0))
    {
      AppMethodBeat.o(195940);
      return null;
    }
    paramV8Array = paramV8Array.getString(0);
    if (g.ef(paramV8Array))
    {
      AppMethodBeat.o(195940);
      return null;
    }
    ae.d("EdgeComputingJsApiBase", "[EdgeComputingJsApiDebugAlert] logic, msg : ".concat(String.valueOf(paramV8Array)));
    AppMethodBeat.o(195940);
    return null;
  }
  
  public final String coO()
  {
    return "debug_alert";
  }
  
  public final int getType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.h.b.a.a
 * JD-Core Version:    0.7.0.1
 */