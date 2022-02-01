package com.tencent.mm.plugin.expt.d.h.b.a;

import com.eclipsesource.v8.V8Array;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.apache.commons.b.g;

public final class a
  extends com.tencent.mm.plugin.expt.d.h.b.a
{
  public final Object b(V8Array paramV8Array)
  {
    AppMethodBeat.i(220363);
    if ((paramV8Array == null) || (paramV8Array.length() <= 0))
    {
      AppMethodBeat.o(220363);
      return null;
    }
    paramV8Array = paramV8Array.getString(0);
    if (g.eP(paramV8Array))
    {
      AppMethodBeat.o(220363);
      return null;
    }
    Log.d("EdgeComputingJsApiBase", "[EdgeComputingJsApiDebugAlert] logic, msg : ".concat(String.valueOf(paramV8Array)));
    AppMethodBeat.o(220363);
    return null;
  }
  
  public final String cNb()
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