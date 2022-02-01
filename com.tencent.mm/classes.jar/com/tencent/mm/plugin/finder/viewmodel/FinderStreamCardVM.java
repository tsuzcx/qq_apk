package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ab;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aro;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cardDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "cardPositionCache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "checkPreloadForReportReadStats", "", "list", "token", "call", "Lkotlin/Function0;", "getCardLastPosition", "item", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "getThisReadStats", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "recordCardLastPosition", "position", "Companion", "plugin-finder_release"})
public final class FinderStreamCardVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final a sZM;
  public final ConcurrentHashMap<String, List<FinderObject>> sZK;
  public final HashMap<String, Integer> sZL;
  
  static
  {
    AppMethodBeat.i(205417);
    sZM = new a((byte)0);
    AppMethodBeat.o(205417);
  }
  
  public FinderStreamCardVM()
  {
    AppMethodBeat.i(205416);
    this.sZK = new ConcurrentHashMap();
    this.sZL = new HashMap();
    AppMethodBeat.o(205416);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM$Companion;", "", "()V", "TAG", "", "getCardToken", "item", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "plugin-finder_release"})
  public static final class a
  {
    public static String a(ab paramab)
    {
      Object localObject2 = null;
      AppMethodBeat.i(205415);
      p.h(paramab, "item");
      Object localObject3 = new StringBuilder().append(paramab.rXV.Gpl).append('_');
      Object localObject1 = paramab.rXV.object;
      p.g(localObject1, "item.card.`object`");
      localObject1 = (FinderObject)j.jd((List)localObject1);
      if (localObject1 != null) {}
      for (localObject1 = Long.valueOf(((FinderObject)localObject1).id);; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject3).append(localObject1).append('_');
        paramab = paramab.rXV.object;
        p.g(paramab, "item.card.`object`");
        localObject3 = (FinderObject)j.jf((List)paramab);
        paramab = localObject2;
        if (localObject3 != null) {
          paramab = Long.valueOf(((FinderObject)localObject3).id);
        }
        paramab = paramab;
        AppMethodBeat.o(205415);
        return paramab;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM
 * JD-Core Version:    0.7.0.1
 */