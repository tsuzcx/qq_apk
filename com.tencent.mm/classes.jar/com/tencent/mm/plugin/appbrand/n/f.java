package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.Log;

final class f
  extends d
{
  private final IJSRuntime hmL;
  private final m sTk;
  private final int sTl;
  
  public f(m paramm, int paramInt)
  {
    this.hmL = paramm.hmL;
    this.sTk = paramm;
    this.sTl = paramInt;
  }
  
  public final IJSRuntime cze()
  {
    return this.hmL;
  }
  
  protected final m czf()
  {
    return this.sTk;
  }
  
  public final boolean czg()
  {
    return false;
  }
  
  public final int czh()
  {
    return this.sTl;
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
    this.sTk.a(this.sTl, paramh);
    AppMethodBeat.o(144172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.f
 * JD-Core Version:    0.7.0.1
 */