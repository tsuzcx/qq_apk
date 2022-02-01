package com.tencent.mm.plugin.appbrand.jsruntime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.appbrand.v8.f;
import com.tencent.mm.appbrand.v8.h;
import com.tencent.mm.appbrand.v8.m;

public class x
  extends a
{
  public x()
  {
    super((byte)0);
  }
  
  public x(IJSRuntime.Config paramConfig)
  {
    super(paramConfig);
  }
  
  protected final m a(IJSRuntime paramIJSRuntime, int paramInt)
  {
    AppMethodBeat.i(144176);
    paramIJSRuntime = ((h)paramIJSRuntime).Nt();
    AppMethodBeat.o(144176);
    return paramIJSRuntime;
  }
  
  protected IJSRuntime g(IJSRuntime.Config paramConfig)
  {
    AppMethodBeat.i(144175);
    paramConfig = f.b(paramConfig);
    AppMethodBeat.o(144175);
    return paramConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.x
 * JD-Core Version:    0.7.0.1
 */