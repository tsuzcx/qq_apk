package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.storage.n;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.storage.v;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderFeedLayoutFactory;", "", "()V", "getLayoutConfig", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "plugin-finder_release"})
public final class o
{
  public static final o LaG;
  
  static
  {
    AppMethodBeat.i(199625);
    LaG = new o();
    AppMethodBeat.o(199625);
  }
  
  public static v fVP()
  {
    AppMethodBeat.i(199624);
    Object localObject = b.qJA;
    if (b.fUs())
    {
      localObject = (v)new n();
      AppMethodBeat.o(199624);
      return localObject;
    }
    localObject = (v)new t();
    AppMethodBeat.o(199624);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.o
 * JD-Core Version:    0.7.0.1
 */