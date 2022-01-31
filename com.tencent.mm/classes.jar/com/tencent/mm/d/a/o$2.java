package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class o$2
  implements JavaCallback
{
  o$2(o paramo, l paraml) {}
  
  public final Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    AppMethodBeat.i(113858);
    if ((paramV8Array.length() <= 0) || (paramV8Array.getType(0) != 1))
    {
      ab.w("V8DirectApiBuffer", "getNativeBuffer invalid parameters");
      AppMethodBeat.o(113858);
      return null;
    }
    ab.i("V8DirectApiBuffer", "getNativeBuffer, id:%d", new Object[] { Integer.valueOf(paramV8Array.getInteger(0)) });
    paramV8Object = this.cbX.cbf.gk(paramV8Array.getInteger(0));
    if (paramV8Object == null)
    {
      ab.w("V8DirectApiBuffer", "getNativeBuffer bb null");
      AppMethodBeat.o(113858);
      return null;
    }
    paramV8Object = this.cbY.Cu().newV8ArrayBuffer(paramV8Object);
    AppMethodBeat.o(113858);
    return paramV8Object;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.d.a.o.2
 * JD-Core Version:    0.7.0.1
 */