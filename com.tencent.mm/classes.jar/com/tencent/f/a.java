package com.tencent.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class a
  implements com.tencent.f.b.a
{
  private boolean Nl = true;
  private g ahUR;
  
  protected a(g paramg)
  {
    this.ahUR = paramg;
  }
  
  public final void W(String paramString, Object paramObject)
  {
    AppMethodBeat.i(62811);
    if (!this.Nl)
    {
      AppMethodBeat.o(62811);
      return;
    }
    f localf = f.kcN();
    if (paramObject == null)
    {
      paramString = new h("TpfServiceCenter|registerService|name or service should not be null");
      AppMethodBeat.o(62811);
      throw paramString;
    }
    synchronized (localf.ahUX)
    {
      localf.ahUV.put(paramString, paramObject);
      AppMethodBeat.o(62811);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.f.a
 * JD-Core Version:    0.7.0.1
 */