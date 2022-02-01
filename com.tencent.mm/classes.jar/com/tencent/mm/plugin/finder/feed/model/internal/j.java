package com.tencent.mm.plugin.finder.feed.model.internal;

import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/internal/IPreload;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "getCache", "", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "request", "Lkotlin/Function0;", "setCache", "response", "plugin-finder_release"})
public abstract interface j<T extends i>
{
  public abstract void D(b<? super IResponse<T>, x> paramb);
  
  public abstract void G(a<x> parama);
  
  public abstract void a(IResponse<T> paramIResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.j
 * JD-Core Version:    0.7.0.1
 */