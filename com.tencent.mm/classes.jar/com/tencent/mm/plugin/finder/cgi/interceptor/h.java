package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/OrderInterceptor;", "T", "", "interceptor", "order", "", "(Ljava/lang/Object;I)V", "getInterceptor", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getOrder", "()I", "equals", "", "other", "hashCode", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h<T>
{
  public final T AFd;
  public final int order;
  
  public h(T paramT, int paramInt)
  {
    this.AFd = paramT;
    this.order = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(336735);
    boolean bool = s.p(this.AFd, paramObject);
    AppMethodBeat.o(336735);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(336729);
    Object localObject = this.AFd;
    if (localObject != null)
    {
      int i = localObject.hashCode();
      AppMethodBeat.o(336729);
      return i;
    }
    AppMethodBeat.o(336729);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.h
 * JD-Core Version:    0.7.0.1
 */