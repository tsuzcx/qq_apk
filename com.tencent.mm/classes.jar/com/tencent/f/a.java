package com.tencent.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class a
  implements com.tencent.f.b.a
{
  private g ZQt;
  private boolean aji = true;
  
  protected a(g paramg)
  {
    this.ZQt = paramg;
  }
  
  public final void F(String paramString, Object paramObject)
  {
    AppMethodBeat.i(62811);
    if (!this.aji)
    {
      AppMethodBeat.o(62811);
      return;
    }
    f localf = f.itv();
    if (paramObject == null)
    {
      paramString = new h("TpfServiceCenter|registerService|name or service should not be null");
      AppMethodBeat.o(62811);
      throw paramString;
    }
    synchronized (localf.ZQz)
    {
      localf.ZQx.put(paramString, paramObject);
      AppMethodBeat.o(62811);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.f.a
 * JD-Core Version:    0.7.0.1
 */