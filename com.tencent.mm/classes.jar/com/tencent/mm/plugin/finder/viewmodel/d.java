package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.an;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.i;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cardDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "cardPositionCache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "readAlbumFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "readAlbumFeedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "checkForReportReadStats", "", "list", "token", "call", "Lkotlin/Function0;", "clearAlbumReadFeeds", "isDestroy", "", "collectReadFeeds", "getCardLastPosition", "item", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "getThisAlbumReadFeeds", "getThisReadStats", "recordCardLastPosition", "position", "Companion", "plugin-finder_release"})
public final class d
  extends i<PluginFinder>
{
  public static final a Bhg;
  public final ConcurrentHashMap<String, List<FinderObject>> Bhc;
  public final HashMap<String, Integer> Bhd;
  private final LinkedList<cve> Bhe;
  private final HashSet<Long> Bhf;
  
  static
  {
    AppMethodBeat.i(270513);
    Bhg = new a((byte)0);
    AppMethodBeat.o(270513);
  }
  
  public d()
  {
    AppMethodBeat.i(270512);
    this.Bhc = new ConcurrentHashMap();
    this.Bhd = new HashMap();
    this.Bhe = new LinkedList();
    this.Bhf = new HashSet();
    AppMethodBeat.o(270512);
  }
  
  public final void a(List<? extends FinderObject> paramList, String paramString, a<x> parama)
  {
    AppMethodBeat.i(270504);
    p.k(paramList, "list");
    p.k(paramString, "token");
    p.k(parama, "call");
    if (!this.Bhc.containsKey(paramString))
    {
      Log.i("Finder.StreamCardVM", "[checkPreloadForReportReadStats] token=" + paramString + " not exist.");
      ((Map)this.Bhc).put(paramString, paramList);
      parama.invoke();
      AppMethodBeat.o(270504);
      return;
    }
    Log.i("Finder.StreamCardVM", "[checkPreloadForReportReadStats] token=" + paramString + " has exist.");
    AppMethodBeat.o(270504);
  }
  
  public final List<cve> ekd()
  {
    AppMethodBeat.i(270507);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.Bhe)
    {
      localLinkedList.addAll((Collection)this.Bhe);
      ??? = (List)localLinkedList;
      AppMethodBeat.o(270507);
      return ???;
    }
  }
  
  public final void fb(List<? extends cve> paramList)
  {
    AppMethodBeat.i(270505);
    p.k(paramList, "list");
    for (;;)
    {
      int i;
      synchronized (this.Bhe)
      {
        paramList = ((Iterable)paramList).iterator();
        if (!paramList.hasNext()) {
          break label182;
        }
        cve localcve = (cve)paramList.next();
        Iterator localIterator = ((List)this.Bhe).iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break label177;
        }
        if (((cve)localIterator.next()).xbk == localcve.xbk)
        {
          j = 1;
          break label195;
          label103:
          if ((i >= 0) || (this.Bhf.contains(Long.valueOf(localcve.xbk)))) {
            continue;
          }
          this.Bhe.add(localcve);
          this.Bhf.add(Long.valueOf(localcve.xbk));
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
        paramList = x.aazN;
        AppMethodBeat.o(270505);
        return;
      }
    }
  }
  
  public final void rz(boolean paramBoolean)
  {
    AppMethodBeat.i(270508);
    Log.i("Finder.StreamCardVM", "clearAlbumReadFeeds... size=" + this.Bhe.size());
    synchronized (this.Bhe)
    {
      this.Bhe.clear();
      if (paramBoolean) {
        this.Bhf.clear();
      }
      x localx = x.aazN;
      AppMethodBeat.o(270508);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM$Companion;", "", "()V", "TAG", "", "getCardToken", "item", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "plugin-finder_release"})
  public static final class a
  {
    public static String b(an paraman)
    {
      Object localObject2 = null;
      AppMethodBeat.i(291703);
      p.k(paraman, "item");
      Object localObject3 = new StringBuilder().append(paraman.xBH.zAO).append('_');
      Object localObject1 = paraman.xBH.object;
      p.j(localObject1, "item.card.`object`");
      localObject1 = (FinderObject)j.lp((List)localObject1);
      if (localObject1 != null) {}
      for (localObject1 = Long.valueOf(((FinderObject)localObject1).id);; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject3).append(localObject1).append('_');
        paraman = paraman.xBH.object;
        p.j(paraman, "item.card.`object`");
        localObject3 = (FinderObject)j.lr((List)paraman);
        paraman = localObject2;
        if (localObject3 != null) {
          paraman = Long.valueOf(((FinderObject)localObject3).id);
        }
        paraman = paraman;
        AppMethodBeat.o(291703);
        return paraman;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.d
 * JD-Core Version:    0.7.0.1
 */