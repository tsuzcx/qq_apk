package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.appbrand.v8.f;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.m.9;
import java.nio.ByteBuffer;

public class c
  extends a
{
  public c()
  {
    super(null);
  }
  
  public c(byte paramByte)
  {
    super(new IJSRuntime.Config(null, null));
    AppMethodBeat.i(144158);
    AppMethodBeat.o(144158);
  }
  
  public c(IJSRuntime.Config paramConfig)
  {
    super(paramConfig);
  }
  
  protected final m a(IJSRuntime paramIJSRuntime, int paramInt)
  {
    AppMethodBeat.i(144161);
    paramIJSRuntime = paramIJSRuntime.iP(paramInt);
    AppMethodBeat.o(144161);
    return paramIJSRuntime;
  }
  
  public final void a(z paramz)
  {
    AppMethodBeat.i(144159);
    if (this.mNC != null)
    {
      m localm = this.mNC;
      localm.dpQ.r(new m.9(localm, paramz));
    }
    AppMethodBeat.o(144159);
  }
  
  protected IJSRuntime g(IJSRuntime.Config paramConfig)
  {
    AppMethodBeat.i(144160);
    paramConfig = f.c(paramConfig);
    AppMethodBeat.o(144160);
    return paramConfig;
  }
  
  public final void releaseDirectByteBuffer(ByteBuffer paramByteBuffer) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.c
 * JD-Core Version:    0.7.0.1
 */