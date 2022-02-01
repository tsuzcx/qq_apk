package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DefaultInitResponse;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "()V", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e<T extends k>
  extends IResponse<T>
{
  public e()
  {
    super(0, 0, null, 7, null);
    AppMethodBeat.i(366549);
    setPullType(1000);
    setIncrementList((List)ab.aivy);
    AppMethodBeat.o(366549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.e
 * JD-Core Version:    0.7.0.1
 */