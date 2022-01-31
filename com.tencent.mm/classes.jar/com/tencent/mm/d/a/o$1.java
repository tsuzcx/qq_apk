package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class o$1
  implements JavaCallback
{
  o$1(o paramo) {}
  
  public final Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    AppMethodBeat.i(113857);
    paramV8Object = Integer.valueOf(this.cbX.cbf.Co());
    ab.i("V8DirectApiBuffer", "generateId:%d", new Object[] { paramV8Object });
    AppMethodBeat.o(113857);
    return paramV8Object;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.d.a.o.1
 * JD-Core Version:    0.7.0.1
 */