package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "T", "", "callback", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "newObj", "pool", "Ljava/util/LinkedList;", "get", "()Ljava/lang/Object;", "put", "", "view", "(Ljava/lang/Object;)Z", "plugin-brandservice_release"})
public final class c<T>
{
  final LinkedList<T> mYF;
  a<? extends T> mYG;
  
  public c(a<? extends T> parama)
  {
    AppMethodBeat.i(193038);
    this.mYF = new LinkedList();
    this.mYG = parama;
    AppMethodBeat.o(193038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.c
 * JD-Core Version:    0.7.0.1
 */