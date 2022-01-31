package com.tencent.mm.d.a;

import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements l.a
{
  a$1(a parama, int paramInt) {}
  
  public final V8Context Cn()
  {
    AppMethodBeat.i(113794);
    if (a.a(this.cbl) == null)
    {
      localObject = new IllegalStateException("createContext mV8 not ready!");
      AppMethodBeat.o(113794);
      throw ((Throwable)localObject);
    }
    Object localObject = a.a(this.cbl).createContext(this.cbk);
    AppMethodBeat.o(113794);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.d.a.a.1
 * JD-Core Version:    0.7.0.1
 */