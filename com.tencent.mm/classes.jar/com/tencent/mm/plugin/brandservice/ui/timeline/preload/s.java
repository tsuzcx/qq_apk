package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"resettableLazy", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "PROPTYPE", "manager", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "init", "Lkotlin/Function0;", "resettableManager", "plugin-brandservice_release"})
public final class s
{
  public static final <PROPTYPE> q<PROPTYPE> a(r paramr, a<? extends PROPTYPE> parama)
  {
    AppMethodBeat.i(6732);
    p.h(paramr, "manager");
    p.h(parama, "init");
    paramr = new q(paramr, parama);
    AppMethodBeat.o(6732);
    return paramr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.s
 * JD-Core Version:    0.7.0.1
 */