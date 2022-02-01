package com.tencent.mm.plugin.appbrand.jsruntime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.ad;

final class f
  extends d
{
  private final IJSRuntime cPC;
  private final m kDt;
  private final int kDu;
  
  public f(m paramm, int paramInt)
  {
    this.cPC = paramm.cPC;
    this.kDt = paramm;
    this.kDu = paramInt;
  }
  
  protected final m bfA()
  {
    return this.kDt;
  }
  
  public final boolean bfB()
  {
    return false;
  }
  
  public final int bfC()
  {
    return this.kDu;
  }
  
  protected final IJSRuntime bfz()
  {
    return this.cPC;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(144173);
    ad.w("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not pause");
    AppMethodBeat.o(144173);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(144174);
    ad.w("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not resume");
    AppMethodBeat.o(144174);
  }
  
  public final void setJsExceptionHandler(h paramh)
  {
    AppMethodBeat.i(144172);
    this.kDt.a(this.kDu, paramh);
    AppMethodBeat.o(144172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.f
 * JD-Core Version:    0.7.0.1
 */