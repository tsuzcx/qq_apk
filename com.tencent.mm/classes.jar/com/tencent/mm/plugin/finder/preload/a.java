package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.preload.model.a.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/FinderPreloadTransform;", "", "()V", "TAG", "", "buildPreloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "info", "transform", "", "list", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "print", "plugin-finder_release"})
public final class a
{
  public static final a rvk;
  
  static
  {
    AppMethodBeat.i(202593);
    rvk = new a();
    AppMethodBeat.o(202593);
  }
  
  public static void a(anb paramanb, List<? extends BaseFinderFeed> paramList)
  {
    int i = 1;
    AppMethodBeat.i(202592);
    k.h(paramList, "list");
    Object localObject2 = new StringBuilder("[transform] info=");
    if (paramanb != null) {
      k.h(paramanb, "$this$print");
    }
    com.tencent.mm.plugin.finder.preload.model.a locala;
    for (Object localObject1 = "[preloadId=" + paramanb.rvL + " hotFeed=" + paramanb.EGj.size() + ']';; localObject1 = null)
    {
      ac.i("Finder.PreloadTransform", (String)localObject1 + " list=" + paramList.size());
      locala = ((PluginFinder)g.ad(PluginFinder.class)).getMediaPreloadModel();
      localObject1 = paramanb;
      if (paramanb != null) {
        break label326;
      }
      paramanb = g.agR();
      k.g(paramanb, "MMKernel.storage()");
      paramanb = paramanb.agA().get(ah.a.GUO, "");
      if (paramanb != null) {
        break;
      }
      paramanb = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(202592);
      throw paramanb;
    }
    paramanb = bs.aLu((String)paramanb);
    localObject1 = new StringBuilder("[buildPreloadInfo] buffer isEmpty? ");
    k.g(paramanb, "buffer");
    boolean bool;
    if (paramanb.length == 0)
    {
      bool = true;
      ac.i("Finder.PreloadTransform", bool);
      if (paramanb.length != 0) {
        break label407;
      }
      label225:
      if (i == 0) {
        break label412;
      }
      localObject1 = new anb();
      ana localana = new ana();
      localObject2 = ((PluginFinder)g.ad(PluginFinder.class)).getMediaPreloadModel().rvD;
      paramanb = (anb)localObject2;
      if (localObject2 == null) {
        paramanb = new a.c();
      }
      localana.rvG = paramanb.rvX;
      localana.rvF = paramanb.rvW;
      localana.EGf = (paramanb.rvV / 100.0F);
      localana.EGh = paramanb.rvY;
      ((anb)localObject1).EGi = localana;
    }
    for (;;)
    {
      label326:
      paramanb = new HashMap();
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        localObject2 = (BaseFinderFeed)paramList.next();
        if (((BaseFinderFeed)localObject2).feedObject.getMediaType() == 4) {
          ((Map)paramanb).put(Long.valueOf(((BaseFinderFeed)localObject2).feedObject.getExpectId()), localObject2);
        }
      }
      bool = false;
      break;
      label407:
      i = 0;
      break label225;
      label412:
      localObject1 = new anb();
      ((anb)localObject1).parseFrom(paramanb);
    }
    locala.a((anb)localObject1, paramanb);
    AppMethodBeat.o(202592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.a
 * JD-Core Version:    0.7.0.1
 */