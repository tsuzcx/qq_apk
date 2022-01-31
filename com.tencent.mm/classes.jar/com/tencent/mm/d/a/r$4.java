package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r$4
  implements JavaVoidCallback
{
  r$4(r paramr) {}
  
  public final void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    AppMethodBeat.i(113873);
    if ((paramV8Array.length() <= 0) || (paramV8Array.getType(0) != 1))
    {
      AppMethodBeat.o(113873);
      return;
    }
    r.a(this.cch, paramV8Array.getInteger(0));
    AppMethodBeat.o(113873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.d.a.r.4
 * JD-Core Version:    0.7.0.1
 */