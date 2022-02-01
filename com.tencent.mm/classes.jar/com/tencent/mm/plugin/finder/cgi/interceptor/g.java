package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/OrderInterceptor;", "T", "", "interceptor", "order", "", "(Ljava/lang/Object;I)V", "getInterceptor", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getOrder", "()I", "equals", "", "other", "hashCode", "plugin-finder_release"})
public final class g<T>
{
  public final int order;
  public final T xfJ;
  
  public g(T paramT, int paramInt)
  {
    this.xfJ = paramT;
    this.order = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(290399);
    boolean bool = p.h(this.xfJ, paramObject);
    AppMethodBeat.o(290399);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(290398);
    Object localObject = this.xfJ;
    if (localObject != null)
    {
      int i = localObject.hashCode();
      AppMethodBeat.o(290398);
      return i;
    }
    AppMethodBeat.o(290398);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.g
 * JD-Core Version:    0.7.0.1
 */