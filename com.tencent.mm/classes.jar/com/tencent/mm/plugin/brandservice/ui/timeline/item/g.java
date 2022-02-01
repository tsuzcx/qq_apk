package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "T", "", "callback", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "newObj", "pool", "Ljava/util/LinkedList;", "get", "()Ljava/lang/Object;", "put", "", "view", "(Ljava/lang/Object;)Z", "plugin-brandservice_release"})
public final class g<T>
{
  private final LinkedList<T> oiD;
  private a<? extends T> oiE;
  
  public g(a<? extends T> parama)
  {
    AppMethodBeat.i(208672);
    this.oiD = new LinkedList();
    this.oiE = parama;
    AppMethodBeat.o(208672);
  }
  
  public final boolean cT(T paramT)
  {
    AppMethodBeat.i(208670);
    boolean bool = this.oiD.add(paramT);
    AppMethodBeat.o(208670);
    return bool;
  }
  
  public final T get()
  {
    AppMethodBeat.i(208671);
    if (this.oiD.size() > 0) {}
    for (Object localObject = this.oiD.remove(0);; localObject = this.oiE.invoke())
    {
      AppMethodBeat.o(208671);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.g
 * JD-Core Version:    0.7.0.1
 */