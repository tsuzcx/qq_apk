package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.aa;
import com.tencent.mm.protocal.protobuf.ays;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/RVFeedUtil;", "", "()V", "genBaseLocalFeed", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "localType", "", "genLocalItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "wording", "", "plugin-finder_release"})
public final class bp
{
  public static final bp uOZ;
  
  static
  {
    AppMethodBeat.i(248870);
    uOZ = new bp();
    AppMethodBeat.o(248870);
  }
  
  public static b Ju(int paramInt)
  {
    AppMethodBeat.i(248869);
    p.h("", "wording");
    Object localObject = new ays();
    ((ays)localObject).LIS = paramInt;
    ((ays)localObject).dQx = "";
    localObject = new b(new aa((ays)localObject));
    AppMethodBeat.o(248869);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bp
 * JD-Core Version:    0.7.0.1
 */