package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.storage.k;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.storage.z;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderFeedLayoutFactory;", "", "()V", "getLayoutConfig", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "plugin-finder_release"})
public final class e
{
  public static final e sWq;
  
  static
  {
    AppMethodBeat.i(205089);
    sWq = new e();
    AppMethodBeat.o(205089);
  }
  
  public static z cNH()
  {
    AppMethodBeat.i(205088);
    Object localObject = b.sHP;
    if (b.cIr())
    {
      localObject = (z)new k();
      AppMethodBeat.o(205088);
      return localObject;
    }
    localObject = (z)new x();
    AppMethodBeat.o(205088);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.e
 * JD-Core Version:    0.7.0.1
 */