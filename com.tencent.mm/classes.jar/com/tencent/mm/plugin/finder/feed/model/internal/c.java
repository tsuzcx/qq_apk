package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DefaultInitResponse;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "()V", "plugin-finder_release"})
public final class c<T extends i>
  extends IResponse<T>
{
  public c()
  {
    super(0, 0, null, 7, null);
    AppMethodBeat.i(245006);
    setPullType(1000);
    setIncrementList((List)v.SXr);
    AppMethodBeat.o(245006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.c
 * JD-Core Version:    0.7.0.1
 */