package com.tencent.mm.plugin.expt.edge.h.b.a;

import com.eclipsesource.mmv8.V8Array;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.edge.b;
import org.apache.commons.c.i;

public final class a
  extends com.tencent.mm.plugin.expt.edge.h.b.a
{
  public final Object b(V8Array paramV8Array)
  {
    AppMethodBeat.i(299739);
    if ((paramV8Array == null) || (paramV8Array.length() <= 0))
    {
      AppMethodBeat.o(299739);
      return null;
    }
    paramV8Array = paramV8Array.getString(0);
    if (i.hm(paramV8Array))
    {
      AppMethodBeat.o(299739);
      return null;
    }
    b.hf("EdgeComputingJsApiBase", "[EdgeComputingJsApiDebugAlert] logic, msg : ".concat(String.valueOf(paramV8Array)));
    com.tencent.mm.plugin.expt.edge.f.a.aqr(paramV8Array);
    AppMethodBeat.o(299739);
    return null;
  }
  
  public final String dIx()
  {
    return "debug_alert";
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.h.b.a.a
 * JD-Core Version:    0.7.0.1
 */