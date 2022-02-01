package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.mm.g.a.hg;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.upload.g.a;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "feedChangeListener", "com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedChangeListener$1;", "feedDeleteListener", "com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedDeleteListener$1;", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "isObservePostEvent", "onAlive", "onDead", "onPostEnd", "localId", "", "isOk", "onPostNotify", "onPostOk", "svrID", "onPostStart", "remove", "finderFeedId", "notify", "removeLocal", "", "requestLoadMore", "updateByLocalId", "newFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isPostUpdate", "updateItem", "svrId", "plugin-finder_release"})
public abstract class BaseMegaVideoLoader
  extends BaseFeedLoader<bo>
  implements com.tencent.mm.plugin.finder.upload.q
{
  public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
  public boolean hasMore = true;
  private final b uKF = new b(this);
  private final a uKG = new a(this);
  
  public BaseMegaVideoLoader(bbn parambbn)
  {
    super(parambbn);
  }
  
  private void ES(long paramLong)
  {
    Object localObject = c.vGN;
    localObject = c.a.FS(paramLong);
    if (localObject != null)
    {
      Log.i(getTAG(), "updateItem localId:" + paramLong + " itemLoadId:" + ((FinderItem)localObject).getLocalId() + " itemId:" + ((FinderItem)localObject).getId());
      c((FinderItem)localObject);
    }
  }
  
  private void c(FinderItem paramFinderItem)
  {
    p.h(paramFinderItem, "newFeed");
    if (paramFinderItem.getLocalId() <= 0L) {}
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)getDataList()).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          j.hxH();
        }
        localObject = (bo)localObject;
        if ((localObject instanceof bm))
        {
          FinderItem localFinderItem = ((bm)localObject).uOW;
          if (localFinderItem != null)
          {
            if (localFinderItem.getLocalId() == paramFinderItem.getLocalId())
            {
              ((bm)localObject).uOW = paramFinderItem;
              ((bm)localObject).g(paramFinderItem.getFeedObject());
              Log.i(getTAG(), "updateByLocalId " + paramFinderItem.getLocalId());
              dispatcher().onItemRangeChanged(i, 1, (Serializable)new o(Integer.valueOf(4), Integer.valueOf(1)));
            }
          }
          else
          {
            i = j;
            continue;
          }
        }
        i = j;
      }
    }
  }
  
  public final long ER(long paramLong)
  {
    Object localObject = ((List)getDataList()).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext())
    {
      bo localbo = (bo)((Iterator)localObject).next();
      if (((localbo instanceof bm)) && (((bm)localbo).dkW() == paramLong))
      {
        j = 1;
        label62:
        if (j == 0) {
          break label106;
        }
      }
    }
    for (;;)
    {
      localObject = null;
      if (i == -1) {
        break label134;
      }
      localObject = getDataList().remove(i);
      if (localObject != null) {
        break label118;
      }
      throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
      j = 0;
      break label62;
      label106:
      i += 1;
      break;
      i = -1;
    }
    label118:
    localObject = (bm)localObject;
    dispatcher().onItemRangeRemoved(i, 1);
    label134:
    if (localObject != null) {
      return ((bm)localObject).lT();
    }
    return 0L;
  }
  
  public boolean isObservePostEvent()
  {
    return false;
  }
  
  public void onAlive()
  {
    super.onAlive();
    this.uKG.alive();
    this.uKF.alive();
    if (isObservePostEvent())
    {
      g.a locala = g.vSJ;
      g.dBa().a((com.tencent.mm.plugin.finder.upload.q)this);
    }
  }
  
  public void onDead()
  {
    super.onDead();
    this.uKG.dead();
    this.uKF.dead();
    if (isObservePostEvent())
    {
      g.a locala = g.vSJ;
      g.dBa().b((com.tencent.mm.plugin.finder.upload.q)this);
    }
  }
  
  public void onFetchDone(IResponse paramIResponse)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.axR());
    super.onFetchDone(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
  }
  
  public void onPostEnd(long paramLong, boolean paramBoolean)
  {
    ES(paramLong);
  }
  
  public void onPostNotify(long paramLong, boolean paramBoolean)
  {
    ES(paramLong);
  }
  
  public void onPostOk(long paramLong1, long paramLong2)
  {
    Object localObject = e.vFX;
    localObject = e.a.Fy(paramLong2);
    if (localObject != null) {
      ((FinderItem)localObject).setLocalId(paramLong1);
    }
    if (localObject != null)
    {
      Log.i(getTAG(), "updateItem localId:" + paramLong1 + " itemLoadId:" + ((FinderItem)localObject).getLocalId() + " itemId:" + ((FinderItem)localObject).getId());
      c((FinderItem)localObject);
    }
  }
  
  public void onPostStart(long paramLong)
  {
    Object localObject = c.vGN;
    FinderItem localFinderItem = c.a.FS(paramLong);
    if (localFinderItem != null)
    {
      localObject = localFinderItem.getMegaVideo();
      if (localObject != null) {
        break label31;
      }
    }
    label31:
    while (localFinderItem == null)
    {
      return;
      localObject = null;
      break;
    }
    localObject = new ArrayList();
    Log.i(getTAG(), "onPostStart localId ".concat(String.valueOf(paramLong)));
    bm localbm = new bm(localFinderItem.getFeedObject());
    localbm.uOW = localFinderItem;
    ((ArrayList)localObject).add(localbm);
    com.tencent.mm.plugin.finder.feed.model.internal.b.mergeDataAndNotify$default(getMerger(), 2, (List)localObject, true, null, 8, null);
  }
  
  public void requestLoadMore()
  {
    if (!this.hasMore) {
      return;
    }
    super.requestLoadMore();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends IListener<hn>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(BaseMegaVideoLoader.a parama, hn paramhn)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<hg>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedDeleteListener$1$callback$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(hg paramhg1, BaseMegaVideoLoader.b paramb, hg paramhg2)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader
 * JD-Core Version:    0.7.0.1
 */