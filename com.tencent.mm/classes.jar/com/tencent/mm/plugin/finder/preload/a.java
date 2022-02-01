package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.preload.model.a.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.ako;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/FinderPreloadTransform;", "", "()V", "TAG", "", "buildPreloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "info", "transform", "", "list", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "print", "plugin-finder_release"})
public final class a
{
  public static final a KTw;
  
  static
  {
    AppMethodBeat.i(198666);
    KTw = new a();
    AppMethodBeat.o(198666);
  }
  
  public static void a(akp paramakp, List<? extends BaseFinderFeed> paramList)
  {
    int i = 1;
    AppMethodBeat.i(198665);
    k.h(paramList, "list");
    Object localObject2 = new StringBuilder("[transform] info=");
    if (paramakp != null) {
      k.h(paramakp, "$this$print");
    }
    com.tencent.mm.plugin.finder.preload.model.a locala;
    for (Object localObject1 = "[preloadId=" + paramakp.Dmj + " hotFeed=" + paramakp.Dml.size() + ']';; localObject1 = null)
    {
      ad.i("Finder.PreloadTransform", (String)localObject1 + " list=" + paramList.size());
      locala = ((PluginFinder)g.ad(PluginFinder.class)).getMediaPreloadModel();
      localObject1 = paramakp;
      if (paramakp != null) {
        break label326;
      }
      paramakp = g.afB();
      k.g(paramakp, "MMKernel.storage()");
      paramakp = paramakp.afk().get(ae.a.LBc, "");
      if (paramakp != null) {
        break;
      }
      paramakp = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(198665);
      throw paramakp;
    }
    paramakp = bt.aGd((String)paramakp);
    localObject1 = new StringBuilder("[buildPreloadInfo] buffer isEmpty? ");
    k.g(paramakp, "buffer");
    boolean bool;
    if (paramakp.length == 0)
    {
      bool = true;
      ad.i("Finder.PreloadTransform", bool);
      if (paramakp.length != 0) {
        break label407;
      }
      label225:
      if (i == 0) {
        break label412;
      }
      localObject1 = new akp();
      ako localako = new ako();
      localObject2 = ((PluginFinder)g.ad(PluginFinder.class)).getMediaPreloadModel().KTO;
      paramakp = (akp)localObject2;
      if (localObject2 == null) {
        paramakp = new a.c();
      }
      localako.wAk = paramakp.KUd;
      localako.Dmf = paramakp.KUc;
      localako.Dmh = (paramakp.KUb / 100.0F);
      localako.Lya = paramakp.KUe;
      ((akp)localObject1).Dmk = localako;
    }
    for (;;)
    {
      label326:
      paramakp = new HashMap();
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        localObject2 = (BaseFinderFeed)paramList.next();
        if (((BaseFinderFeed)localObject2).feedObject.getMediaType() == 4) {
          ((Map)paramakp).put(Long.valueOf(((BaseFinderFeed)localObject2).feedObject.getExpectId()), localObject2);
        }
      }
      bool = false;
      break;
      label407:
      i = 0;
      break label225;
      label412:
      localObject1 = new akp();
      ((akp)localObject1).parseFrom(paramakp);
    }
    locala.a((akp)localObject1, paramakp);
    AppMethodBeat.o(198665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.a
 * JD-Core Version:    0.7.0.1
 */