package com.tencent.mm.plugin.appbrand.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.v.a;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.g.b.a.hh;
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
    o localo = com.tencent.mm.plugin.appbrand.a.GU(parama.appId);
    if ((localo == null) || (localo.isDestroyed()))
    {
      AppMethodBeat.o(50023);
      return;
    }
    com.tencent.mm.plugin.appbrand.report.quality.a.btI();
    hh localhh = com.tencent.mm.plugin.appbrand.report.quality.b.a(parama.mPF, parama.appId, null).ou("WAWorker.js");
    localhh.eeO = parama.script.length();
    parama = localhh.ov(localo.aSt().aVS());
    parama.eeQ = 5L;
    parama.aHZ();
    AppMethodBeat.o(50023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.c
 * JD-Core Version:    0.7.0.1
 */