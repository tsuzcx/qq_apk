package com.tencent.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class a
  implements com.tencent.h.b.a
{
  private g ByC;
  private boolean agB = true;
  
  protected a(g paramg)
  {
    this.ByC = paramg;
  }
  
  public final void u(String paramString, Object paramObject)
  {
    AppMethodBeat.i(127741);
    if (!this.agB)
    {
      AppMethodBeat.o(127741);
      return;
    }
    f localf = f.dWW();
    if (paramObject == null)
    {
      paramString = new h("TpfServiceCenter|registerService|name or service should not be null");
      AppMethodBeat.o(127741);
      throw paramString;
    }
    synchronized (localf.ByI)
    {
      localf.ByG.put(paramString, paramObject);
      AppMethodBeat.o(127741);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.h.a
 * JD-Core Version:    0.7.0.1
 */