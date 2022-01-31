package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Function;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t$3
  implements Runnable
{
  public t$3(t paramt, l paraml, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(113893);
    l locall = this.ccy;
    String str = this.byh;
    if (locall.Cu().getType("onmessage") == 7)
    {
      V8Function localV8Function = (V8Function)locall.Cu().get("onmessage");
      V8Array localV8Array = locall.Cu().newV8Array();
      localV8Array.push(str);
      localV8Function.call(locall.Cu().getGlobalObject(), localV8Array);
      localV8Function.release();
      localV8Array.release();
    }
    AppMethodBeat.o(113893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.d.a.t.3
 * JD-Core Version:    0.7.0.1
 */