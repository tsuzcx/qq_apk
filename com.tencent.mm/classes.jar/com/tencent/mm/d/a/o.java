package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o
  extends n
{
  f cbf;
  
  o(f paramf)
  {
    this.cbf = paramf;
  }
  
  protected final void a(l paraml, V8Object paramV8Object)
  {
    AppMethodBeat.i(113860);
    paramV8Object.registerJavaMethod(new o.1(this), "getNativeBufferId");
    paramV8Object.registerJavaMethod(new o.2(this, paraml), "getNativeBuffer");
    paramV8Object.registerJavaMethod(new o.3(this), "setNativeBuffer");
    AppMethodBeat.o(113860);
  }
  
  public final void cleanup() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.d.a.o
 * JD-Core Version:    0.7.0.1
 */