package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ab;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cardDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "cardPositionCache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "checkPreloadForReportReadStats", "", "list", "token", "call", "Lkotlin/Function0;", "getCardLastPosition", "item", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "getThisReadStats", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "recordCardLastPosition", "position", "Companion", "plugin-finder_release"})
public final class FinderStreamCardVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final a tla;
  public final ConcurrentHashMap<String, List<FinderObject>> tkY;
  public final HashMap<String, Integer> tkZ;
  
  static
  {
    AppMethodBeat.i(206065);
    tla = new a((byte)0);
    AppMethodBeat.o(206065);
  }
  
  public FinderStreamCardVM()
  {
    AppMethodBeat.i(206064);
    this.tkY = new ConcurrentHashMap();
    this.tkZ = new HashMap();
    AppMethodBeat.o(206064);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM$Companion;", "", "()V", "TAG", "", "getCardToken", "item", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "plugin-finder_release"})
  public static final class a
  {
    public static String a(ab paramab)
    {
      Object localObject2 = null;
      AppMethodBeat.i(206063);
      p.h(paramab, "item");
      Object localObject3 = new StringBuilder().append(paramab.sgG.GIB).append('_');
      Object localObject1 = paramab.sgG.object;
      p.g(localObject1, "item.card.`object`");
      localObject1 = (FinderObject)j.jm((List)localObject1);
      if (localObject1 != null) {}
      for (localObject1 = Long.valueOf(((FinderObject)localObject1).id);; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject3).append(localObject1).append('_');
        paramab = paramab.sgG.object;
        p.g(paramab, "item.card.`object`");
        localObject3 = (FinderObject)j.jo((List)paramab);
        paramab = localObject2;
        if (localObject3 != null) {
          paramab = Long.valueOf(((FinderObject)localObject3).id);
        }
        paramab = paramab;
        AppMethodBeat.o(206063);
        return paramab;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM
 * JD-Core Version:    0.7.0.1
 */