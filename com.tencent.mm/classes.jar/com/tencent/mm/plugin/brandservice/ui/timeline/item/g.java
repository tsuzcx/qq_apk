package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "T", "", "callback", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "newObj", "pool", "Ljava/util/LinkedList;", "get", "()Ljava/lang/Object;", "put", "", "view", "(Ljava/lang/Object;)Z", "plugin-brandservice_release"})
public final class g<T>
{
  private final LinkedList<T> ocO;
  private a<? extends T> ocP;
  
  public g(a<? extends T> parama)
  {
    AppMethodBeat.i(209698);
    this.ocO = new LinkedList();
    this.ocP = parama;
    AppMethodBeat.o(209698);
  }
  
  public final boolean cS(T paramT)
  {
    AppMethodBeat.i(209696);
    boolean bool = this.ocO.add(paramT);
    AppMethodBeat.o(209696);
    return bool;
  }
  
  public final T get()
  {
    AppMethodBeat.i(209697);
    if (this.ocO.size() > 0) {}
    for (Object localObject = this.ocO.remove(0);; localObject = this.ocP.invoke())
    {
      AppMethodBeat.o(209697);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.g
 * JD-Core Version:    0.7.0.1
 */