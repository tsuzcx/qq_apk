package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "T", "", "callback", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "newObj", "pool", "Ljava/util/LinkedList;", "get", "()Ljava/lang/Object;", "put", "", "view", "(Ljava/lang/Object;)Z", "plugin-brandservice_release"})
public final class c<T>
{
  final LinkedList<T> nBe;
  a<? extends T> nBf;
  
  public c(a<? extends T> parama)
  {
    AppMethodBeat.i(198832);
    this.nBe = new LinkedList();
    this.nBf = parama;
    AppMethodBeat.o(198832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.c
 * JD-Core Version:    0.7.0.1
 */