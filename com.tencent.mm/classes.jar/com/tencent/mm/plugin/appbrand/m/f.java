package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.Log;

final class f
  extends d
{
  private final IJSRuntime fiy;
  private final m pOL;
  private final int pOM;
  
  public f(m paramm, int paramInt)
  {
    this.fiy = paramm.fiy;
    this.pOL = paramm;
    this.pOM = paramInt;
  }
  
  public final IJSRuntime bYQ()
  {
    return this.fiy;
  }
  
  protected final m bYR()
  {
    return this.pOL;
  }
  
  public final boolean bYS()
  {
    return false;
  }
  
  public final int bYT()
  {
    return this.pOM;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(144173);
    Log.w("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not pause");
    AppMethodBeat.o(144173);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(144174);
    Log.w("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not resume");
    AppMethodBeat.o(144174);
  }
  
  public final void setJsExceptionHandler(h paramh)
  {
    AppMethodBeat.i(144172);
    this.pOL.a(this.pOM, paramh);
    AppMethodBeat.o(144172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.f
 * JD-Core Version:    0.7.0.1
 */