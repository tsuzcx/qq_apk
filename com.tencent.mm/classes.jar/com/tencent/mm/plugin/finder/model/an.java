package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.protocal.protobuf.apx;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/model/RVFeedUtil;", "", "()V", "genBaseLocalFeed", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "localType", "", "genLocalItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "wording", "", "plugin-finder_release"})
public final class an
{
  public static final an stA;
  
  static
  {
    AppMethodBeat.i(203483);
    stA = new an();
    AppMethodBeat.o(203483);
  }
  
  public static b cEM()
  {
    AppMethodBeat.i(203482);
    p.h("", "wording");
    Object localObject = new apx();
    ((apx)localObject).GGY = 2001;
    ((apx)localObject).dyI = "";
    localObject = new b(new u((apx)localObject));
    AppMethodBeat.o(203482);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.an
 * JD-Core Version:    0.7.0.1
 */