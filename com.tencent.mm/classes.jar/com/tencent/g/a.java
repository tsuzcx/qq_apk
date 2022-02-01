package com.tencent.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class a
  implements com.tencent.g.b.a
{
  private g SoO;
  private boolean aqH = true;
  
  protected a(g paramg)
  {
    this.SoO = paramg;
  }
  
  public final void F(String paramString, Object paramObject)
  {
    AppMethodBeat.i(62811);
    if (!this.aqH)
    {
      AppMethodBeat.o(62811);
      return;
    }
    f localf = f.hpQ();
    if (paramObject == null)
    {
      paramString = new h("TpfServiceCenter|registerService|name or service should not be null");
      AppMethodBeat.o(62811);
      throw paramString;
    }
    synchronized (localf.SoU)
    {
      localf.SoS.put(paramString, paramObject);
      AppMethodBeat.o(62811);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.g.a
 * JD-Core Version:    0.7.0.1
 */