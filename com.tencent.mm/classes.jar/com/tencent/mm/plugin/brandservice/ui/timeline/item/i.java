package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "T", "", "callback", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "newObj", "pool", "Ljava/util/LinkedList;", "get", "()Ljava/lang/Object;", "put", "", "view", "(Ljava/lang/Object;)Z", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i<T>
{
  private final LinkedList<T> vJm;
  private a<? extends T> vJn;
  
  public i(a<? extends T> parama)
  {
    AppMethodBeat.i(302692);
    this.vJm = new LinkedList();
    this.vJn = parama;
    AppMethodBeat.o(302692);
  }
  
  public final boolean et(T paramT)
  {
    AppMethodBeat.i(302699);
    boolean bool = this.vJm.add(paramT);
    AppMethodBeat.o(302699);
    return bool;
  }
  
  public final T get()
  {
    AppMethodBeat.i(302704);
    if (this.vJm.size() > 0) {}
    for (Object localObject = this.vJm.remove(0);; localObject = this.vJn.invoke())
    {
      AppMethodBeat.o(302704);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.i
 * JD-Core Version:    0.7.0.1
 */