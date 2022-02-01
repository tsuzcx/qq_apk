package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.storage.k;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.storage.z;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderFeedLayoutFactory;", "", "()V", "getLayoutConfig", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "plugin-finder_release"})
public final class e
{
  public static final e sLf;
  
  static
  {
    AppMethodBeat.i(204471);
    sLf = new e();
    AppMethodBeat.o(204471);
  }
  
  public static z cLd()
  {
    AppMethodBeat.i(204470);
    Object localObject = b.sxa;
    if (b.cGu())
    {
      localObject = (z)new k();
      AppMethodBeat.o(204470);
      return localObject;
    }
    localObject = (z)new x();
    AppMethodBeat.o(204470);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.e
 * JD-Core Version:    0.7.0.1
 */