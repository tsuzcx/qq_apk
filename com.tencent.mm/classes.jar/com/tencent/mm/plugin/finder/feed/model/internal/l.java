package com.tencent.mm.plugin.finder.feed.model.internal;

import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/IPreload;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "getCache", "", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "request", "Lkotlin/Function0;", "setCache", "response", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface l<T extends k>
{
  public abstract void aT(a<ah> parama);
  
  public abstract void al(b<? super IResponse<T>, ah> paramb);
  
  public abstract void b(IResponse<T> paramIResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.l
 * JD-Core Version:    0.7.0.1
 */