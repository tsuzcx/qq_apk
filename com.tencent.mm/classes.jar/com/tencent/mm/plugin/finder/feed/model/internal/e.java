package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DefaultInitResponse;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "()V", "plugin-finder-base_release"})
public final class e<T extends k>
  extends IResponse<T>
{
  public e()
  {
    super(0, 0, null, 7, null);
    AppMethodBeat.i(259400);
    setPullType(1000);
    setIncrementList((List)v.aaAd);
    AppMethodBeat.o(259400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.e
 * JD-Core Version:    0.7.0.1
 */