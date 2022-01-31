package com.tencent.mm.plugin.appbrand.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.t.a;
import com.tencent.mm.d.a.u;
import com.tencent.mm.plugin.appbrand.report.quality.a;

public class c
  extends b
{
  static
  {
    AppMethodBeat.i(143671);
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(143671);
      return;
    }
  }
  
  public c(u paramu)
  {
    super(paramu);
  }
  
  protected final void a(t.a parama, long paramLong)
  {
    AppMethodBeat.i(143670);
    if (!parama.filePath.endsWith("WAWorker.js"))
    {
      AppMethodBeat.o(143670);
      return;
    }
    if ((!$assertionsDisabled) && (!(parama instanceof b.a)))
    {
      parama = new AssertionError();
      AppMethodBeat.o(143670);
      throw parama;
    }
    b.a locala = (b.a)parama;
    a.aLt();
    com.tencent.mm.plugin.appbrand.report.quality.b.a(locala.jxo, locala.appId, paramLong, "WAWorker.js", parama.script.length());
    AppMethodBeat.o(143670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.c
 * JD-Core Version:    0.7.0.1
 */