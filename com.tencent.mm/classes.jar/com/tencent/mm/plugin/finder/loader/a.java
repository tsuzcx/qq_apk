package com.tencent.mm.plugin.finder.loader;

import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hz;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.feed.model.internal.m.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.profile.uic.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.Long;Ljava.lang.Integer;>;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge;", "", "fragment", "Landroidx/fragment/app/Fragment;", "atFeedLoader", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "(Landroidx/fragment/app/Fragment;Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;)V", "atFeedDataObserver", "com/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge$atFeedDataObserver$1", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge$atFeedDataObserver$1;", "data", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "limit", "", "attach", "", "detach", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a zsD;
  private final Fragment fragment;
  private final int limit;
  public DataBuffer<bu> zsA;
  public final b zsB;
  public final FinderAtFeedLoader zsC;
  
  static
  {
    AppMethodBeat.i(272068);
    zsD = new a((byte)0);
    AppMethodBeat.o(272068);
  }
  
  public a(Fragment paramFragment, FinderAtFeedLoader paramFinderAtFeedLoader)
  {
    AppMethodBeat.i(272067);
    this.fragment = paramFragment;
    this.zsC = paramFinderAtFeedLoader;
    this.limit = 300;
    this.zsB = new b(this);
    AppMethodBeat.o(272067);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge$atFeedDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupObserver;", "fetchData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isRefreshAll", "", "updateAtFeedListener", "com/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge$atFeedDataObserver$1$updateAtFeedListener$1", "getUpdateAtFeedListener", "()Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge$atFeedDataObserver$1$updateAtFeedListener$1;", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge$atFeedDataObserver$1$updateAtFeedListener$1;", "findInsertIndex", "", "pos", "getFetchData", "", "interceptChange", "size", "observeKey", "", "onAllItemChange", "idMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onItemChange", "position", "feedId", "onOwnerAlive", "onOwnerDead", "refreshAll", "safeGet", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataBuffer", "updateCacheState", "plugin-finder_release"})
  public static final class b
    extends m.c
  {
    boolean zsE;
    private DataBuffer<bu> zsF;
    public final a zsG;
    
    b()
    {
      AppMethodBeat.i(291727);
      this.zsE = true;
      this.zsG = new a(this);
      AppMethodBeat.o(291727);
    }
    
    private static BaseFinderFeed a(int paramInt, DataBuffer<bu> paramDataBuffer)
    {
      AppMethodBeat.i(291724);
      int i;
      if (paramDataBuffer != null) {
        if ((paramInt >= 0) && (paramInt < paramDataBuffer.size()))
        {
          i = 1;
          if (i == 0) {
            break label68;
          }
          label27:
          if (paramDataBuffer == null) {
            break label73;
          }
        }
      }
      label68:
      label73:
      for (paramDataBuffer = (bu)paramDataBuffer.get(paramInt);; paramDataBuffer = null)
      {
        DataBuffer<bu> localDataBuffer = paramDataBuffer;
        if (!(paramDataBuffer instanceof BaseFinderFeed)) {
          localDataBuffer = null;
        }
        paramDataBuffer = (BaseFinderFeed)localDataBuffer;
        AppMethodBeat.o(291724);
        return paramDataBuffer;
        i = 0;
        break;
        paramDataBuffer = null;
        break label27;
      }
    }
    
    private final void dIT()
    {
      AppMethodBeat.i(291723);
      if (this.zsF == null) {
        this.zsF = duA();
      }
      AppMethodBeat.o(291723);
    }
    
    public final void ah(int paramInt, long paramLong)
    {
      int k = 0;
      AppMethodBeat.i(291722);
      if (this.zsE)
      {
        dIU();
        AppMethodBeat.o(291722);
        return;
      }
      dIT();
      Object localObject1;
      Object localObject2;
      int j;
      int i;
      if (paramInt == -1)
      {
        localObject1 = this.zsF;
        if (localObject1 != null)
        {
          Object localObject3 = ((List)localObject1).iterator();
          paramInt = 0;
          if (((Iterator)localObject3).hasNext())
          {
            localObject2 = (bu)((Iterator)localObject3).next();
            localObject1 = localObject2;
            if (!(localObject2 instanceof BaseFinderFeed)) {
              localObject1 = null;
            }
            localObject1 = (BaseFinderFeed)localObject1;
            if (localObject1 != null)
            {
              localObject1 = ((BaseFinderFeed)localObject1).feedObject;
              if ((localObject1 == null) || (((FinderItem)localObject1).getId() != paramLong)) {}
            }
            for (j = 1;; j = 0)
            {
              i = paramInt;
              if (j != 0) {
                break label481;
              }
              paramInt += 1;
              break;
            }
          }
          paramInt = -1;
          localObject1 = a(paramInt, this.zsF);
          if (localObject1 != null)
          {
            localObject2 = a.a(this.zsH);
            if (localObject2 == null) {
              break label508;
            }
            localObject2 = ((List)localObject2).iterator();
            i = 0;
            label200:
            if (!((Iterator)localObject2).hasNext()) {
              break label502;
            }
            if (((bu)((Iterator)localObject2).next()).a((k)localObject1) != 0) {
              break label487;
            }
            j = 1;
            label236:
            if (j == 0) {
              break label493;
            }
            label241:
            Log.i("Finder.AtFeedExtraMerge", "get changeIndex :".concat(String.valueOf(i)));
            if (i != -1) {
              break label546;
            }
            i = paramInt - 1;
            label267:
            if (i < 0) {
              break label612;
            }
            localObject2 = a(i, this.zsF);
            if (localObject2 == null) {
              break label537;
            }
            localObject3 = ((BaseFinderFeed)localObject2).feedObject;
            if ((localObject3 == null) || (((FinderItem)localObject3).getMentionListSelected() != 2)) {
              break label537;
            }
            localObject3 = a.a(this.zsH);
            if (localObject3 == null) {
              break label532;
            }
            localObject3 = ((List)localObject3).iterator();
            paramInt = 0;
            label337:
            if (!((Iterator)localObject3).hasNext()) {
              break label527;
            }
            if (((bu)((Iterator)localObject3).next()).a((k)localObject2) != 0) {
              break label514;
            }
            j = 1;
            label373:
            if (j == 0) {
              break label520;
            }
          }
        }
      }
      for (;;)
      {
        label378:
        Log.i("Finder.AtFeedExtraMerge", "changePos :" + i + " insertIndex:" + paramInt);
        localObject2 = a.a(this.zsH);
        if (localObject2 != null)
        {
          ((DataBuffer)localObject2).add(paramInt, localObject1);
          dIV();
          a.b(this.zsH).dispatcher().onItemRangeInserted(paramInt, 1);
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            Log.i("Finder.AtFeedExtraMerge", "get no data");
            localObject1 = x.aazN;
          }
          AppMethodBeat.o(291722);
          return;
          paramInt = -1;
          break;
          i = paramInt;
          label481:
          paramInt = i;
          break;
          label487:
          j = 0;
          break label236;
          label493:
          i += 1;
          break label200;
          label502:
          i = -1;
          break label241;
          label508:
          i = -1;
          break label241;
          label514:
          j = 0;
          break label373;
          label520:
          paramInt += 1;
          break label337;
          label527:
          paramInt = -1;
          break label378;
          label532:
          paramInt = 0;
          break label378;
          label537:
          i -= 1;
          break label267;
          label546:
          paramInt = k;
          if (((BaseFinderFeed)localObject1).feedObject.getMentionListSelected() == 2) {
            paramInt = 1;
          }
          if (paramInt == 0)
          {
            localObject2 = a.a(this.zsH);
            if (localObject2 != null) {
              ((DataBuffer)localObject2).remove(i);
            }
            dIV();
            a.b(this.zsH).dispatcher().onItemRangeRemoved(i, 1);
          }
        }
        label612:
        paramInt = 0;
      }
    }
    
    final void dIU()
    {
      AppMethodBeat.i(291725);
      a.b(this.zsH).requestRefresh();
      AppMethodBeat.o(291725);
    }
    
    final void dIV()
    {
      AppMethodBeat.i(291726);
      FinderAtFeedLoader localFinderAtFeedLoader = a.b(this.zsH);
      Object localObject = a.a(this.zsH);
      int i;
      if (localObject != null) {
        if (!((Collection)localObject).isEmpty())
        {
          i = 1;
          if (i != 1) {
            break label90;
          }
          localObject = g.Xox;
          ((c)g.h(a.c(this.zsH)).i(c.class)).dNq();
          localObject = FinderAtFeedLoader.c.zsU;
        }
      }
      for (;;)
      {
        localFinderAtFeedLoader.a((FinderAtFeedLoader.c)localObject);
        AppMethodBeat.o(291726);
        return;
        i = 0;
        break;
        label90:
        if (a.b(this.zsH).mentionCount > 0)
        {
          localObject = g.Xox;
          ((c)g.h(a.c(this.zsH)).i(c.class)).dNq();
          localObject = FinderAtFeedLoader.c.zsV;
        }
        else
        {
          localObject = FinderAtFeedLoader.c.zsT;
        }
      }
    }
    
    public final void duB()
    {
      AppMethodBeat.i(291719);
      Log.i("Finder.AtFeedExtraMerge", "onOwnerAlive");
      this.zsG.dead();
      AppMethodBeat.o(291719);
    }
    
    public final void duC()
    {
      AppMethodBeat.i(291720);
      Log.i("Finder.AtFeedExtraMerge", "onOwnerDead");
      this.zsF = null;
      this.zsG.alive();
      AppMethodBeat.o(291720);
    }
    
    public final String duz()
    {
      return "atFeedManage";
    }
    
    public final void l(HashMap<Long, Integer> paramHashMap)
    {
      AppMethodBeat.i(291721);
      p.k(paramHashMap, "idMap");
      if (this.zsE)
      {
        dIU();
        AppMethodBeat.o(291721);
        return;
      }
      dIT();
      Log.i("Finder.AtFeedExtraMerge", "fetchData :" + this.zsF);
      paramHashMap = this.zsF;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      label178:
      label220:
      Object localObject5;
      if (paramHashMap != null)
      {
        paramHashMap = (Iterable)paramHashMap;
        localObject2 = (Collection)new ArrayList();
        localObject3 = paramHashMap.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          localObject1 = (bu)localObject4;
          paramHashMap = (HashMap<Long, Integer>)localObject1;
          if (!(localObject1 instanceof BaseFinderFeed)) {
            paramHashMap = null;
          }
          paramHashMap = (BaseFinderFeed)paramHashMap;
          if (paramHashMap != null)
          {
            paramHashMap = paramHashMap.feedObject;
            if ((paramHashMap == null) || (paramHashMap.getMentionListSelected() != 2)) {}
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label178;
            }
            ((Collection)localObject2).add(localObject4);
            break;
          }
        }
        paramHashMap = (List)localObject2;
        localObject1 = this.zsF;
        if (localObject1 != null)
        {
          localObject1 = (Iterable)localObject1;
          localObject3 = (Collection)new ArrayList();
          localObject4 = ((Iterable)localObject1).iterator();
        }
      }
      else
      {
        label321:
        for (;;)
        {
          if (!((Iterator)localObject4).hasNext()) {
            break label323;
          }
          localObject5 = ((Iterator)localObject4).next();
          localObject2 = (bu)localObject5;
          localObject1 = localObject2;
          if (!(localObject2 instanceof BaseFinderFeed)) {
            localObject1 = null;
          }
          localObject1 = (BaseFinderFeed)localObject1;
          if (localObject1 != null)
          {
            localObject1 = ((BaseFinderFeed)localObject1).feedObject;
            if ((localObject1 == null) || (((FinderItem)localObject1).getMentionListSelected() != 3)) {}
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label321;
            }
            ((Collection)localObject3).add(localObject5);
            break label220;
            paramHashMap = (List)new ArrayList();
            break;
          }
        }
        label323:
        localObject1 = (List)localObject3;
        localObject2 = new ArrayList();
        Log.i("Finder.AtFeedExtraMerge", "visibleList :" + paramHashMap.size() + "  invisibleList: " + ((List)localObject1).size());
        localObject3 = paramHashMap.iterator();
        label388:
        if (!((Iterator)localObject3).hasNext()) {
          break label571;
        }
        localObject4 = (bu)((Iterator)localObject3).next();
        paramHashMap = a.a(this.zsH);
        if (paramHashMap == null) {
          break label566;
        }
        localObject5 = ((Iterable)paramHashMap).iterator();
        label433:
        if (!((Iterator)localObject5).hasNext()) {
          break label561;
        }
        paramHashMap = ((Iterator)localObject5).next();
        if (((bu)paramHashMap).a((k)localObject4) != 0) {
          break label556;
        }
        i = 1;
        label470:
        if (i == 0) {
          break label559;
        }
      }
      label474:
      for (paramHashMap = (bu)paramHashMap;; paramHashMap = null)
      {
        if (paramHashMap != null)
        {
          Log.i("Finder.AtFeedExtraMerge", "visibleFeedId add id:".concat(String.valueOf(localObject4)));
          ((ArrayList)localObject2).add(paramHashMap);
          localObject5 = a.a(this.zsH);
          if (localObject5 != null) {
            ((DataBuffer)localObject5).remove(paramHashMap);
          }
          if (paramHashMap != null) {
            break label388;
          }
        }
        ((ArrayList)localObject2).add(localObject4);
        break label388;
        localObject1 = (List)new ArrayList();
        break;
        i = 0;
        break label470;
        break label433;
        paramHashMap = null;
        break label474;
      }
      label556:
      label559:
      label561:
      label566:
      label571:
      Object localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (bu)((Iterator)localObject1).next();
        Log.i("Finder.AtFeedExtraMerge", "invisibleFeed :".concat(String.valueOf(localObject3)));
        paramHashMap = a.a(this.zsH);
        if (paramHashMap != null)
        {
          localObject4 = ((Iterable)paramHashMap).iterator();
          label637:
          if (((Iterator)localObject4).hasNext())
          {
            paramHashMap = ((Iterator)localObject4).next();
            if (((bu)paramHashMap).a((k)localObject3) == 0)
            {
              i = 1;
              if (i == 0) {
                break label729;
              }
            }
          }
          for (;;)
          {
            label674:
            paramHashMap = (bu)paramHashMap;
            if (paramHashMap == null) {
              break;
            }
            Log.i("Finder.AtFeedExtraMerge", "data remove :".concat(String.valueOf(paramHashMap)));
            localObject3 = a.a(this.zsH);
            if (localObject3 == null) {
              break;
            }
            ((DataBuffer)localObject3).remove(paramHashMap);
            break;
            i = 0;
            break label674;
            label729:
            break label637;
            paramHashMap = null;
          }
        }
      }
      int i = ((ArrayList)localObject2).size() - 1;
      while (i >= 0)
      {
        Log.i("Finder.AtFeedExtraMerge", "data visibleFeed from tempList index: ".concat(String.valueOf(i)));
        paramHashMap = a.a(this.zsH);
        if (paramHashMap != null) {
          paramHashMap.add(0, ((ArrayList)localObject2).get(i));
        }
        i -= 1;
      }
      dIV();
      a.b(this.zsH).dispatcher().onChanged();
      AppMethodBeat.o(291721);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge$atFeedDataObserver$1$updateAtFeedListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderAtFeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class a
      extends IListener<hz>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.a
 * JD-Core Version:    0.7.0.1
 */