package com.tencent.mm.plugin.appbrand.dynamic.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(10733);
    if (!com.tencent.mm.ipcinvoker.b.PK().lX("com.tencent.mm:support"))
    {
      AppMethodBeat.o(10733);
      return;
    }
    f.a("com.tencent.mm:support", null, b.a.class, new b.2.1(this));
    AppMethodBeat.o(10733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.b.2
 * JD-Core Version:    0.7.0.1
 */