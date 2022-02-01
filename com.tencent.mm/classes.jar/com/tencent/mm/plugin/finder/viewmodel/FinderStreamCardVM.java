package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponentPlugin;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cardDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "cardPositionCache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "readAlbumFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "readAlbumFeedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "checkForReportReadStats", "", "list", "token", "call", "Lkotlin/Function0;", "clearAlbumReadFeeds", "isDestroy", "", "collectReadFeeds", "getCardLastPosition", "item", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "getThisAlbumReadFeeds", "getThisReadStats", "recordCardLastPosition", "position", "Companion", "plugin-finder_release"})
public final class FinderStreamCardVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final a wuH;
  public final ConcurrentHashMap<String, List<FinderObject>> wuD;
  public final HashMap<String, Integer> wuE;
  private final LinkedList<cmm> wuF;
  private final HashSet<Long> wuG;
  
  static
  {
    AppMethodBeat.i(255367);
    wuH = new a((byte)0);
    AppMethodBeat.o(255367);
  }
  
  public FinderStreamCardVM()
  {
    AppMethodBeat.i(255366);
    this.wuD = new ConcurrentHashMap();
    this.wuE = new HashMap();
    this.wuF = new LinkedList();
    this.wuG = new HashSet();
    AppMethodBeat.o(255366);
  }
  
  public final void a(List<? extends FinderObject> paramList, String paramString, a<x> parama)
  {
    AppMethodBeat.i(255361);
    p.h(paramList, "list");
    p.h(paramString, "token");
    p.h(parama, "call");
    if (!this.wuD.containsKey(paramString))
    {
      Log.i("Finder.StreamCardVM", "[checkPreloadForReportReadStats] token=" + paramString + " not exist.");
      ((Map)this.wuD).put(paramString, paramList);
      parama.invoke();
      AppMethodBeat.o(255361);
      return;
    }
    Log.i("Finder.StreamCardVM", "[checkPreloadForReportReadStats] token=" + paramString + " has exist.");
    AppMethodBeat.o(255361);
  }
  
  public final List<cmm> dHT()
  {
    AppMethodBeat.i(255363);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.wuF)
    {
      localLinkedList.addAll((Collection)this.wuF);
      ??? = (List)localLinkedList;
      AppMethodBeat.o(255363);
      return ???;
    }
  }
  
  public final void eH(List<? extends cmm> paramList)
  {
    AppMethodBeat.i(255362);
    p.h(paramList, "list");
    for (;;)
    {
      int i;
      synchronized (this.wuF)
      {
        paramList = ((Iterable)paramList).iterator();
        if (!paramList.hasNext()) {
          break label182;
        }
        cmm localcmm = (cmm)paramList.next();
        Iterator localIterator = ((List)this.wuF).iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break label177;
        }
        if (((cmm)localIterator.next()).hFK == localcmm.hFK)
        {
          j = 1;
          break label195;
          label103:
          if ((i >= 0) || (this.wuG.contains(Long.valueOf(localcmm.hFK)))) {
            continue;
          }
          this.wuF.add(localcmm);
          this.wuG.add(Long.valueOf(localcmm.hFK));
        }
      }
      int j = 0;
      label177:
      label182:
      label195:
      while (j == 0)
      {
        i += 1;
        break;
        i = -1;
        break label103;
        paramList = x.SXb;
        AppMethodBeat.o(255362);
        return;
      }
    }
  }
  
  public final void pg(boolean paramBoolean)
  {
    AppMethodBeat.i(255364);
    Log.i("Finder.StreamCardVM", "clearAlbumReadFeeds... size=" + this.wuF.size());
    synchronized (this.wuF)
    {
      this.wuF.clear();
      if (paramBoolean) {
        this.wuG.clear();
      }
      x localx = x.SXb;
      AppMethodBeat.o(255364);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM$Companion;", "", "()V", "TAG", "", "getCardToken", "item", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "plugin-finder_release"})
  public static final class a
  {
    public static String b(ag paramag)
    {
      Object localObject2 = null;
      AppMethodBeat.i(255360);
      p.h(paramag, "item");
      Object localObject3 = new StringBuilder().append(paramag.tQQ.uOx).append('_');
      Object localObject1 = paramag.tQQ.object;
      p.g(localObject1, "item.card.`object`");
      localObject1 = (FinderObject)j.kt((List)localObject1);
      if (localObject1 != null) {}
      for (localObject1 = Long.valueOf(((FinderObject)localObject1).id);; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject3).append(localObject1).append('_');
        paramag = paramag.tQQ.object;
        p.g(paramag, "item.card.`object`");
        localObject3 = (FinderObject)j.kv((List)paramag);
        paramag = localObject2;
        if (localObject3 != null) {
          paramag = Long.valueOf(((FinderObject)localObject3).id);
        }
        paramag = paramag;
        AppMethodBeat.o(255360);
        return paramag;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM
 * JD-Core Version:    0.7.0.1
 */