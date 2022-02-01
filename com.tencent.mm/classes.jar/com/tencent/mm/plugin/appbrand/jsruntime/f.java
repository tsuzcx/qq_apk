package com.tencent.mm.plugin.appbrand.jsruntime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.ac;

final class f
  extends d
{
  private final IJSRuntime cMX;
  private final m leL;
  private final int leM;
  
  public f(m paramm, int paramInt)
  {
    this.cMX = paramm.cMX;
    this.leL = paramm;
    this.leM = paramInt;
  }
  
  protected final IJSRuntime bmt()
  {
    return this.cMX;
  }
  
  protected final m bmu()
  {
    return this.leL;
  }
  
  public final boolean bmv()
  {
    return false;
  }
  
  public final int bmw()
  {
    return this.leM;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(144173);
    ac.w("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not pause");
    AppMethodBeat.o(144173);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(144174);
    ac.w("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not resume");
    AppMethodBeat.o(144174);
  }
  
  public final void setJsExceptionHandler(h paramh)
  {
    AppMethodBeat.i(144172);
    this.leL.a(this.leM, paramh);
    AppMethodBeat.o(144172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.f
 * JD-Core Version:    0.7.0.1
 */