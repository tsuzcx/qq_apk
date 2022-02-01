package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/OrderInterceptor;", "T", "", "interceptor", "order", "", "(Ljava/lang/Object;I)V", "getInterceptor", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getOrder", "()I", "equals", "", "other", "hashCode", "plugin-finder_release"})
public final class g<T>
{
  public final int order;
  public final T rTp;
  
  public g(T paramT, int paramInt)
  {
    this.rTp = paramT;
    this.order = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(201658);
    boolean bool = p.i(this.rTp, paramObject);
    AppMethodBeat.o(201658);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(201657);
    Object localObject = this.rTp;
    if (localObject != null)
    {
      int i = localObject.hashCode();
      AppMethodBeat.o(201657);
      return i;
    }
    AppMethodBeat.o(201657);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.g
 * JD-Core Version:    0.7.0.1
 */