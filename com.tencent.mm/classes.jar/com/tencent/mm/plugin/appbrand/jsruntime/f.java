package com.tencent.mm.plugin.appbrand.jsruntime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.ae;

final class f
  extends d
{
  private final IJSRuntime cZl;
  private final m lGj;
  private final int lGk;
  
  public f(m paramm, int paramInt)
  {
    this.cZl = paramm.cZl;
    this.lGj = paramm;
    this.lGk = paramInt;
  }
  
  protected final IJSRuntime Nx()
  {
    return this.cZl;
  }
  
  protected final m bqO()
  {
    return this.lGj;
  }
  
  public final boolean bqP()
  {
    return false;
  }
  
  public final int bqQ()
  {
    return this.lGk;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(144173);
    ae.w("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not pause");
    AppMethodBeat.o(144173);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(144174);
    ae.w("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not resume");
    AppMethodBeat.o(144174);
  }
  
  public final void setJsExceptionHandler(h paramh)
  {
    AppMethodBeat.i(144172);
    this.lGj.a(this.lGk, paramh);
    AppMethodBeat.o(144172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.f
 * JD-Core Version:    0.7.0.1
 */