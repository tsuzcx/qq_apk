package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage$Companion;", "", "()V", "TAG", "", "clearAll", "", "plugin-finder_release"})
public final class f$a
{
  public static void clearAll()
  {
    AppMethodBeat.i(167060);
    ac.i(f.access$getTAG$cp(), "clearAll");
    Object localObject = n.rPN;
    localObject = n.EA(1);
    if (i.eA((String)localObject)) {
      i.cU((String)localObject, true);
    }
    AppMethodBeat.o(167060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.f.a
 * JD-Core Version:    0.7.0.1
 */