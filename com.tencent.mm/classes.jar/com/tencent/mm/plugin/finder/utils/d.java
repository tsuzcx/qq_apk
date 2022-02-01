package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.plugin.finder.storage.p;
import com.tencent.mm.plugin.finder.storage.r;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/FinderFeedLayoutFactory;", "", "()V", "getLayoutConfig", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "plugin-finder_release"})
public final class d
{
  public static final d rOJ;
  
  static
  {
    AppMethodBeat.i(203601);
    rOJ = new d();
    AppMethodBeat.o(203601);
  }
  
  public static r cCM()
  {
    AppMethodBeat.i(203600);
    Object localObject = b.rCU;
    if (b.czP())
    {
      localObject = (r)new h();
      AppMethodBeat.o(203600);
      return localObject;
    }
    localObject = (r)new p();
    AppMethodBeat.o(203600);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.d
 * JD-Core Version:    0.7.0.1
 */