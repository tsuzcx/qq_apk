package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.Log;

final class f
  extends d
{
  private final IJSRuntime dpQ;
  private final m mNT;
  private final int mNU;
  
  public f(m paramm, int paramInt)
  {
    this.dpQ = paramm.dpQ;
    this.mNT = paramm;
    this.mNU = paramInt;
  }
  
  protected final m bMA()
  {
    return this.mNT;
  }
  
  public final boolean bMB()
  {
    return false;
  }
  
  public final int bMC()
  {
    return this.mNU;
  }
  
  public final IJSRuntime bMz()
  {
    return this.dpQ;
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
    this.mNT.a(this.mNU, paramh);
    AppMethodBeat.o(144172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.f
 * JD-Core Version:    0.7.0.1
 */