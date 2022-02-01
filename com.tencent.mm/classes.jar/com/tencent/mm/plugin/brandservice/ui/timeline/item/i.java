package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.g.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "T", "", "callback", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "newObj", "pool", "Ljava/util/LinkedList;", "get", "()Ljava/lang/Object;", "put", "", "view", "(Ljava/lang/Object;)Z", "plugin-brandservice_release"})
public final class i<T>
{
  private final LinkedList<T> sDw;
  private a<? extends T> sDx;
  
  public i(a<? extends T> parama)
  {
    AppMethodBeat.i(263766);
    this.sDw = new LinkedList();
    this.sDx = parama;
    AppMethodBeat.o(263766);
  }
  
  public final boolean cX(T paramT)
  {
    AppMethodBeat.i(263763);
    boolean bool = this.sDw.add(paramT);
    AppMethodBeat.o(263763);
    return bool;
  }
  
  public final T get()
  {
    AppMethodBeat.i(263765);
    if (this.sDw.size() > 0) {}
    for (Object localObject = this.sDw.remove(0);; localObject = this.sDx.invoke())
    {
      AppMethodBeat.o(263765);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.i
 * JD-Core Version:    0.7.0.1
 */