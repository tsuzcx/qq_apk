package com.tencent.mm.plugin.appbrand.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.v.a;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.g.b.a.il;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.o;

public class c
  extends b
{
  static
  {
    AppMethodBeat.i(50024);
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(50024);
      return;
    }
  }
  
  public c(w paramw)
  {
    super(paramw);
  }
  
  protected final void a(v.a parama)
  {
    AppMethodBeat.i(50023);
    if (!parama.filePath.endsWith("WAWorker.js"))
    {
      AppMethodBeat.o(50023);
      return;
    }
    if ((!$assertionsDisabled) && (!(parama instanceof b.a)))
    {
      parama = new AssertionError();
      AppMethodBeat.o(50023);
      throw parama;
    }
    parama = (b.a)parama;
    o localo = com.tencent.mm.plugin.appbrand.a.Kj(parama.appId);
    if ((localo == null) || (localo.isDestroyed()))
    {
      AppMethodBeat.o(50023);
      return;
    }
    com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
    il localil = com.tencent.mm.plugin.appbrand.report.quality.b.a(parama.nqc, parama.appId, null).qY("WAWorker.js");
    localil.evB = parama.script.length();
    parama = localil.qZ(localo.aVF().aZn());
    parama.evD = 5L;
    parama.aLk();
    AppMethodBeat.o(50023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.c
 * JD-Core Version:    0.7.0.1
 */