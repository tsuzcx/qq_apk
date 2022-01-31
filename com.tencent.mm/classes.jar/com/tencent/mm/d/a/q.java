package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends n
{
  final e cbD;
  
  public q(e parame)
  {
    super("WeixinArrayBuffer");
    this.cbD = parame;
  }
  
  protected final void a(l paraml, V8Object paramV8Object)
  {
    AppMethodBeat.i(113869);
    paramV8Object.registerJavaMethod(new q.1(this), "get");
    AppMethodBeat.o(113869);
  }
  
  final void cleanup() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.d.a.q
 * JD-Core Version:    0.7.0.1
 */