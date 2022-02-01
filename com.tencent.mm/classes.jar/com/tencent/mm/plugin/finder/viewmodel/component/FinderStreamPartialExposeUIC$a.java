package com.tencent.mm.plugin.finder.viewmodel.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC$Companion;", "", "()V", "TAG", "", "partialExposeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "takePartialExposeObject", "tabType", "plugin-finder_release"})
public final class FinderStreamPartialExposeUIC$a
{
  public static long GX(int paramInt)
  {
    AppMethodBeat.i(206287);
    Long localLong = (Long)FinderStreamPartialExposeUIC.cRe().remove(Integer.valueOf(paramInt));
    if (localLong != null)
    {
      long l = localLong.longValue();
      AppMethodBeat.o(206287);
      return l;
    }
    AppMethodBeat.o(206287);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC.a
 * JD-Core Version:    0.7.0.1
 */