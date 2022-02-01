package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/OrderInterceptor;", "T", "", "interceptor", "order", "", "(Ljava/lang/Object;I)V", "getInterceptor", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getOrder", "()I", "equals", "", "other", "hashCode", "plugin-finder_release"})
public final class g<T>
{
  public final int order;
  public final T txH;
  
  public g(T paramT, int paramInt)
  {
    this.txH = paramT;
    this.order = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(242635);
    boolean bool = p.j(this.txH, paramObject);
    AppMethodBeat.o(242635);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(242634);
    Object localObject = this.txH;
    if (localObject != null)
    {
      int i = localObject.hashCode();
      AppMethodBeat.o(242634);
      return i;
    }
    AppMethodBeat.o(242634);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.g
 * JD-Core Version:    0.7.0.1
 */