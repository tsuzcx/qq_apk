package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.protocal.protobuf.ben;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/RVFeedUtil;", "", "()V", "genBaseLocalFeed", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "localType", "", "genLocalItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "wording", "", "plugin-finder_release"})
public final class bv
{
  public static final bv zBv;
  
  static
  {
    AppMethodBeat.i(271255);
    zBv = new bv();
    AppMethodBeat.o(271255);
  }
  
  public static b Oh(int paramInt)
  {
    AppMethodBeat.i(271254);
    p.k("", "wording");
    Object localObject = new ben();
    ((ben)localObject).SPE = paramInt;
    ((ben)localObject).wording = "";
    localObject = new b(new x((ben)localObject));
    AppMethodBeat.o(271254);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bv
 * JD-Core Version:    0.7.0.1
 */