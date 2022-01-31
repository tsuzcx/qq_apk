package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class p$4
  implements JavaVoidCallback
{
  p$4(p paramp) {}
  
  public final void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    AppMethodBeat.i(113863);
    ab.w("MicroMsg.J2V8_Console", paramV8Array.toString());
    AppMethodBeat.o(113863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.d.a.p.4
 * JD-Core Version:    0.7.0.1
 */