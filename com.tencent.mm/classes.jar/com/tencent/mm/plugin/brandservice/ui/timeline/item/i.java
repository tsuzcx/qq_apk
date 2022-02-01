package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.g.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "T", "", "callback", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "newObj", "pool", "Ljava/util/LinkedList;", "get", "()Ljava/lang/Object;", "put", "", "view", "(Ljava/lang/Object;)Z", "plugin-brandservice_release"})
public final class i<T>
{
  private final LinkedList<T> puj;
  private a<? extends T> puk;
  
  public i(a<? extends T> parama)
  {
    AppMethodBeat.i(195284);
    this.puj = new LinkedList();
    this.puk = parama;
    AppMethodBeat.o(195284);
  }
  
  public final boolean da(T paramT)
  {
    AppMethodBeat.i(195282);
    boolean bool = this.puj.add(paramT);
    AppMethodBeat.o(195282);
    return bool;
  }
  
  public final T get()
  {
    AppMethodBeat.i(195283);
    if (this.puj.size() > 0) {}
    for (Object localObject = this.puj.remove(0);; localObject = this.puk.invoke())
    {
      AppMethodBeat.o(195283);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.i
 * JD-Core Version:    0.7.0.1
 */