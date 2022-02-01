package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.n;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cardDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "cardPositionCache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "readAlbumFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "readAlbumFeedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "checkForReportReadStats", "", "list", "token", "call", "Lkotlin/Function0;", "clearAlbumReadFeeds", "isDestroy", "", "collectReadFeeds", "getCardLastPosition", "item", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "getThisAlbumReadFeeds", "getThisReadStats", "recordCardLastPosition", "position", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends n<PluginFinder>
{
  public static final a GLc;
  public final ConcurrentHashMap<String, List<FinderObject>> GLd;
  public final HashMap<String, Integer> GLe;
  private final LinkedList<dmk> GLf;
  private final HashSet<Long> GLg;
  
  static
  {
    AppMethodBeat.i(337180);
    GLc = new a((byte)0);
    AppMethodBeat.o(337180);
  }
  
  public f()
  {
    AppMethodBeat.i(337164);
    this.GLd = new ConcurrentHashMap();
    this.GLe = new HashMap();
    this.GLf = new LinkedList();
    this.GLg = new HashSet();
    AppMethodBeat.o(337164);
  }
  
  public final List<dmk> fmO()
  {
    AppMethodBeat.i(337204);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.GLf)
    {
      localLinkedList.addAll((Collection)this.GLf);
      ??? = (List)localLinkedList;
      AppMethodBeat.o(337204);
      return ???;
    }
  }
  
  public final void hN(List<? extends dmk> paramList)
  {
    AppMethodBeat.i(337195);
    s.u(paramList, "list");
    for (;;)
    {
      int i;
      synchronized (this.GLf)
      {
        paramList = ((Iterable)paramList).iterator();
        if (!paramList.hasNext()) {
          break label182;
        }
        dmk localdmk = (dmk)paramList.next();
        Iterator localIterator = ((List)this.GLf).iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break label177;
        }
        if (((dmk)localIterator.next()).hKN == localdmk.hKN)
        {
          j = 1;
          break label195;
          label103:
          if ((i >= 0) || (this.GLg.contains(Long.valueOf(localdmk.hKN)))) {
            continue;
          }
          this.GLf.add(localdmk);
          this.GLg.add(Long.valueOf(localdmk.hKN));
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
        paramList = ah.aiuX;
        AppMethodBeat.o(337195);
        return;
      }
    }
  }
  
  public final void vi(boolean paramBoolean)
  {
    AppMethodBeat.i(337217);
    Log.i("Finder.StreamCardVM", s.X("clearAlbumReadFeeds... size=", Integer.valueOf(this.GLf.size())));
    synchronized (this.GLf)
    {
      this.GLf.clear();
      if (paramBoolean) {
        this.GLg.clear();
      }
      ah localah = ah.aiuX;
      AppMethodBeat.o(337217);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM$Companion;", "", "()V", "TAG", "", "getCardToken", "item", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String c(au paramau)
    {
      Object localObject2 = null;
      AppMethodBeat.i(337129);
      s.u(paramau, "item");
      StringBuilder localStringBuilder = new StringBuilder().append(paramau.AYW.ECY).append('_');
      Object localObject1 = paramau.AYW.object;
      s.s(localObject1, "item.card.`object`");
      localObject1 = (FinderObject)p.oL((List)localObject1);
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject1 = localStringBuilder.append(localObject1).append('_');
        paramau = paramau.AYW.object;
        s.s(paramau, "item.card.`object`");
        paramau = (FinderObject)p.oN((List)paramau);
        if (paramau != null) {
          break label136;
        }
      }
      label136:
      for (paramau = localObject2;; paramau = Long.valueOf(paramau.id))
      {
        paramau = paramau;
        AppMethodBeat.o(337129);
        return paramau;
        localObject1 = Long.valueOf(((FinderObject)localObject1).id);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.f
 * JD-Core Version:    0.7.0.1
 */