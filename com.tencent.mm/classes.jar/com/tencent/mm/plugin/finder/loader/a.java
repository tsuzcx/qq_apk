package com.tencent.mm.plugin.finder.loader;

import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.m.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.profile.uic.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge;", "", "fragment", "Landroidx/fragment/app/Fragment;", "atFeedLoader", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "(Landroidx/fragment/app/Fragment;Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;)V", "atFeedDataObserver", "com/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge$atFeedDataObserver$1", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge$atFeedDataObserver$1;", "data", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "limit", "", "attach", "", "detach", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Ews;
  public final FinderAtFeedLoader Ewt;
  public DataBuffer<cc> Ewu;
  public final b Ewv;
  private final Fragment fragment;
  private final int limit;
  
  static
  {
    AppMethodBeat.i(331825);
    Ews = new a((byte)0);
    AppMethodBeat.o(331825);
  }
  
  public a(Fragment paramFragment, FinderAtFeedLoader paramFinderAtFeedLoader)
  {
    AppMethodBeat.i(331809);
    this.fragment = paramFragment;
    this.Ewt = paramFinderAtFeedLoader;
    this.limit = 300;
    this.Ewv = new b(this);
    AppMethodBeat.o(331809);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge$atFeedDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupObserver;", "fetchData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isRefreshAll", "", "updateAtFeedListener", "com/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge$atFeedDataObserver$1$updateAtFeedListener$1", "getUpdateAtFeedListener", "()Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge$atFeedDataObserver$1$updateAtFeedListener$1;", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedExtraMerge$atFeedDataObserver$1$updateAtFeedListener$1;", "findInsertIndex", "", "pos", "getFetchData", "", "interceptChange", "size", "observeKey", "", "onAllItemChange", "idMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onItemChange", "position", "feedId", "onOwnerAlive", "onOwnerDead", "refreshAll", "safeGet", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataBuffer", "updateCacheState", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends m.c
  {
    boolean Eww;
    private DataBuffer<cc> Ewx;
    public final FinderAtFeedExtraMerge.atFeedDataObserver.1.updateAtFeedListener.1 Ewy;
    
    b(a parama)
    {
      AppMethodBeat.i(331671);
      this.Eww = true;
      parama = com.tencent.mm.app.f.hfK;
      this.Ewy = new FinderAtFeedExtraMerge.atFeedDataObserver.1.updateAtFeedListener.1(this.Ewz, this, parama);
      AppMethodBeat.o(331671);
    }
    
    private static BaseFinderFeed a(int paramInt, DataBuffer<cc> paramDataBuffer)
    {
      AppMethodBeat.i(331683);
      if (paramDataBuffer == null) {
        paramDataBuffer = null;
      }
      while ((paramDataBuffer instanceof BaseFinderFeed))
      {
        paramDataBuffer = (BaseFinderFeed)paramDataBuffer;
        AppMethodBeat.o(331683);
        return paramDataBuffer;
        int i;
        if ((paramInt >= 0) && (paramInt < paramDataBuffer.size()))
        {
          i = 1;
          label44:
          if (i == 0) {
            break label62;
          }
        }
        for (;;)
        {
          if (paramDataBuffer != null) {
            break label67;
          }
          paramDataBuffer = null;
          break;
          i = 0;
          break label44;
          label62:
          paramDataBuffer = null;
        }
        label67:
        paramDataBuffer = (cc)paramDataBuffer.get(paramInt);
      }
      AppMethodBeat.o(331683);
      return null;
    }
    
    private final void eBZ()
    {
      AppMethodBeat.i(331675);
      if (this.Ewx == null) {
        this.Ewx = edZ();
      }
      AppMethodBeat.o(331675);
    }
    
    public final void al(int paramInt, long paramLong)
    {
      int m = 0;
      int k = 0;
      AppMethodBeat.i(331724);
      if (this.Eww)
      {
        eCa();
        AppMethodBeat.o(331724);
        return;
      }
      eBZ();
      Object localObject1;
      Object localObject2;
      if (paramInt == -1)
      {
        localObject1 = this.Ewx;
        if (localObject1 == null)
        {
          paramInt = -1;
          localObject2 = a(paramInt, this.Ewx);
          if (localObject2 != null) {
            break label208;
          }
          localObject1 = null;
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          Log.i("Finder.AtFeedExtraMerge", "get no data");
        }
        AppMethodBeat.o(331724);
        return;
        localObject2 = ((List)localObject1).iterator();
        paramInt = 0;
        label137:
        int j;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (cc)((Iterator)localObject2).next();
          if ((localObject1 instanceof BaseFinderFeed))
          {
            localObject1 = (BaseFinderFeed)localObject1;
            if (localObject1 == null) {
              break label188;
            }
            localObject1 = ((BaseFinderFeed)localObject1).feedObject;
            if ((localObject1 == null) || (((FinderItem)localObject1).getId() != paramLong)) {
              break label188;
            }
          }
          label188:
          for (j = 1;; j = 0)
          {
            i = paramInt;
            if (j != 0) {
              break label202;
            }
            paramInt += 1;
            break;
            localObject1 = null;
            break label137;
          }
        }
        paramInt = -1;
        break;
        int i = paramInt;
        label202:
        paramInt = i;
        break;
        label208:
        a locala = this.Ewz;
        localObject1 = a.a(locala);
        label277:
        label282:
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          i = 0;
          label241:
          if (((Iterator)localObject1).hasNext()) {
            if (((cc)((Iterator)localObject1).next()).a((com.tencent.mm.plugin.finder.feed.model.internal.k)localObject2) == 0)
            {
              j = 1;
              if (j == 0) {
                break label461;
              }
              Log.i("Finder.AtFeedExtraMerge", s.X("get changeIndex :", Integer.valueOf(i)));
              if (i != -1) {
                break label566;
              }
              i = paramInt - 1;
            }
          }
        }
        for (;;)
        {
          paramInt = k;
          Object localObject3;
          if (i >= 0)
          {
            localObject1 = a(i, this.Ewx);
            if (localObject1 == null) {
              break label476;
            }
            localObject3 = ((BaseFinderFeed)localObject1).feedObject;
            if ((localObject3 == null) || (((FinderItem)localObject3).getMentionListSelected() != 2)) {
              break label476;
            }
            paramInt = 1;
            label355:
            if (paramInt == 0) {
              break label557;
            }
            localObject3 = a.a(this.Ewz);
            if (localObject3 != null) {
              break label481;
            }
            paramInt = k;
          }
          for (;;)
          {
            Log.i("Finder.AtFeedExtraMerge", "changePos :" + i + " insertIndex:" + paramInt);
            localObject3 = a.a(locala);
            localObject1 = localObject2;
            if (localObject3 == null) {
              break;
            }
            ((DataBuffer)localObject3).add(paramInt, localObject2);
            eCb();
            a.b(locala).dispatcher().onItemRangeInserted(paramInt, 1);
            localObject1 = localObject2;
            break;
            j = 0;
            break label277;
            label461:
            i += 1;
            break label241;
            i = -1;
            break label282;
            label476:
            paramInt = 0;
            break label355;
            label481:
            localObject3 = ((List)localObject3).iterator();
            paramInt = 0;
            for (;;)
            {
              if (!((Iterator)localObject3).hasNext()) {
                break label552;
              }
              if (((cc)((Iterator)localObject3).next()).a((com.tencent.mm.plugin.finder.feed.model.internal.k)localObject1) == 0) {}
              for (j = 1;; j = 0)
              {
                if (j == 0) {
                  break label545;
                }
                break;
              }
              label545:
              paramInt += 1;
            }
            label552:
            paramInt = -1;
          }
          label557:
          i -= 1;
        }
        label566:
        paramInt = m;
        if (((BaseFinderFeed)localObject2).feedObject.getMentionListSelected() == 2) {
          paramInt = 1;
        }
        localObject1 = localObject2;
        if (paramInt == 0)
        {
          localObject1 = a.a(locala);
          if (localObject1 != null) {
            ((DataBuffer)localObject1).remove(i);
          }
          eCb();
          a.b(locala).dispatcher().onItemRangeRemoved(i, 1);
          localObject1 = localObject2;
        }
      }
    }
    
    final void eCa()
    {
      AppMethodBeat.i(331729);
      a.b(this.Ewz).requestRefresh();
      AppMethodBeat.o(331729);
    }
    
    final void eCb()
    {
      AppMethodBeat.i(331737);
      FinderAtFeedLoader localFinderAtFeedLoader = a.b(this.Ewz);
      Object localObject = a.a(this.Ewz);
      int i;
      if (localObject != null) {
        if (!((Collection)localObject).isEmpty())
        {
          i = 1;
          if (i != 1) {
            break label96;
          }
          i = 1;
          label46:
          if (i == 0) {
            break label101;
          }
          localObject = com.tencent.mm.ui.component.k.aeZF;
          ((c)com.tencent.mm.ui.component.k.y(a.c(this.Ewz)).q(c.class)).eIR();
          localObject = FinderAtFeedLoader.c.EwN;
        }
      }
      for (;;)
      {
        localFinderAtFeedLoader.a((FinderAtFeedLoader.c)localObject);
        AppMethodBeat.o(331737);
        return;
        i = 0;
        break;
        label96:
        i = 0;
        break label46;
        label101:
        if (a.b(this.Ewz).mentionCount > 0)
        {
          localObject = com.tencent.mm.ui.component.k.aeZF;
          ((c)com.tencent.mm.ui.component.k.y(a.c(this.Ewz)).q(c.class)).eIR();
          localObject = FinderAtFeedLoader.c.EwO;
        }
        else
        {
          localObject = FinderAtFeedLoader.c.EwM;
        }
      }
    }
    
    public final String edY()
    {
      return "atFeedManage";
    }
    
    public final void eea()
    {
      AppMethodBeat.i(331696);
      Log.i("Finder.AtFeedExtraMerge", "onOwnerAlive");
      this.Ewy.dead();
      AppMethodBeat.o(331696);
    }
    
    public final void eeb()
    {
      AppMethodBeat.i(331704);
      Log.i("Finder.AtFeedExtraMerge", "onOwnerDead");
      this.Ewx = null;
      this.Ewy.alive();
      AppMethodBeat.o(331704);
    }
    
    public final void p(HashMap<Long, Integer> paramHashMap)
    {
      AppMethodBeat.i(331713);
      s.u(paramHashMap, "idMap");
      if (this.Eww)
      {
        eCa();
        AppMethodBeat.o(331713);
        return;
      }
      eBZ();
      Log.i("Finder.AtFeedExtraMerge", s.X("fetchData :", this.Ewx));
      paramHashMap = this.Ewx;
      label77:
      label88:
      Object localObject2;
      label104:
      Object localObject3;
      Object localObject4;
      if (paramHashMap == null)
      {
        paramHashMap = null;
        if (paramHashMap != null) {
          break label346;
        }
        localObject1 = (List)new ArrayList();
        paramHashMap = this.Ewx;
        if (paramHashMap != null) {
          break label352;
        }
        paramHashMap = null;
        if (paramHashMap != null) {
          break label473;
        }
        localObject2 = (List)new ArrayList();
        localObject3 = new ArrayList();
        Log.i("Finder.AtFeedExtraMerge", "visibleList :" + ((List)localObject1).size() + "  invisibleList: " + ((List)localObject2).size());
        localObject4 = ((List)localObject1).iterator();
      }
      label166:
      label332:
      label335:
      label473:
      label601:
      for (;;)
      {
        if (!((Iterator)localObject4).hasNext()) {
          break label603;
        }
        cc localcc = (cc)((Iterator)localObject4).next();
        paramHashMap = a.a(this.Ewz);
        if (paramHashMap == null)
        {
          paramHashMap = null;
          if (paramHashMap != null) {
            break label549;
          }
          localObject1 = null;
        }
        for (;;)
        {
          if (localObject1 != null) {
            break label601;
          }
          ((ArrayList)localObject3).add(localcc);
          break label166;
          paramHashMap = (Iterable)paramHashMap;
          localObject1 = (Collection)new ArrayList();
          localObject2 = paramHashMap.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            paramHashMap = (cc)localObject3;
            if ((paramHashMap instanceof BaseFinderFeed))
            {
              paramHashMap = (BaseFinderFeed)paramHashMap;
              if (paramHashMap == null) {
                break label332;
              }
              paramHashMap = paramHashMap.feedObject;
              if ((paramHashMap == null) || (paramHashMap.getMentionListSelected() != 2)) {
                break label332;
              }
            }
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label335;
              }
              ((Collection)localObject1).add(localObject3);
              break;
              paramHashMap = null;
              break label287;
            }
          }
          paramHashMap = (List)localObject1;
          break;
          label346:
          localObject1 = paramHashMap;
          break label77;
          label352:
          paramHashMap = (Iterable)paramHashMap;
          localObject2 = (Collection)new ArrayList();
          localObject3 = paramHashMap.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = ((Iterator)localObject3).next();
            paramHashMap = (cc)localObject4;
            if ((paramHashMap instanceof BaseFinderFeed))
            {
              paramHashMap = (BaseFinderFeed)paramHashMap;
              if (paramHashMap == null) {
                break label459;
              }
              paramHashMap = paramHashMap.feedObject;
              if ((paramHashMap == null) || (paramHashMap.getMentionListSelected() != 3)) {
                break label459;
              }
            }
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label462;
              }
              ((Collection)localObject2).add(localObject4);
              break;
              paramHashMap = null;
              break label414;
            }
          }
          paramHashMap = (List)localObject2;
          break label88;
          localObject2 = paramHashMap;
          break label104;
          localObject1 = ((Iterable)paramHashMap).iterator();
          label490:
          if (((Iterator)localObject1).hasNext())
          {
            paramHashMap = ((Iterator)localObject1).next();
            if (((cc)paramHashMap).a((com.tencent.mm.plugin.finder.feed.model.internal.k)localcc) == 0)
            {
              i = 1;
              if (i == 0) {
                break label542;
              }
            }
          }
          for (;;)
          {
            paramHashMap = (cc)paramHashMap;
            break;
            i = 0;
            break label527;
            break label490;
            paramHashMap = null;
          }
          localObject1 = this.Ewz;
          Log.i("Finder.AtFeedExtraMerge", s.X("visibleFeedId add id:", localcc));
          ((ArrayList)localObject3).add(paramHashMap);
          DataBuffer localDataBuffer = a.a((a)localObject1);
          localObject1 = paramHashMap;
          if (localDataBuffer != null)
          {
            localDataBuffer.remove(paramHashMap);
            localObject1 = paramHashMap;
          }
        }
      }
      label287:
      label459:
      label462:
      label603:
      Object localObject1 = ((List)localObject2).iterator();
      label414:
      label549:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cc)((Iterator)localObject1).next();
        Log.i("Finder.AtFeedExtraMerge", s.X("invisibleFeed :", localObject2));
        paramHashMap = a.a(this.Ewz);
        if (paramHashMap != null)
        {
          localObject4 = ((Iterable)paramHashMap).iterator();
          if (((Iterator)localObject4).hasNext())
          {
            paramHashMap = ((Iterator)localObject4).next();
            if (((cc)paramHashMap).a((com.tencent.mm.plugin.finder.feed.model.internal.k)localObject2) == 0)
            {
              i = 1;
              label707:
              if (i == 0) {
                break label763;
              }
            }
          }
          for (;;)
          {
            paramHashMap = (cc)paramHashMap;
            if (paramHashMap == null) {
              break;
            }
            localObject2 = this.Ewz;
            Log.i("Finder.AtFeedExtraMerge", s.X("data remove :", paramHashMap));
            localObject2 = a.a((a)localObject2);
            if (localObject2 == null) {
              break;
            }
            ((DataBuffer)localObject2).remove(paramHashMap);
            break;
            i = 0;
            break label707;
            label763:
            break label670;
            paramHashMap = null;
          }
        }
      }
      label527:
      label542:
      label670:
      int i = ((ArrayList)localObject3).size() - 1;
      if (i >= 0) {}
      for (;;)
      {
        int j = i - 1;
        Log.i("Finder.AtFeedExtraMerge", s.X("data visibleFeed from tempList index: ", Integer.valueOf(i)));
        paramHashMap = a.a(this.Ewz);
        if (paramHashMap != null) {
          paramHashMap.add(0, ((ArrayList)localObject3).get(i));
        }
        if (j < 0)
        {
          eCb();
          a.b(this.Ewz).dispatcher().onChanged();
          AppMethodBeat.o(331713);
          return;
        }
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.a
 * JD-Core Version:    0.7.0.1
 */