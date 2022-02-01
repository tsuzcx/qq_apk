package com.tencent.mm.plugin.finder.megavideo.loader;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hy;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.publish.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "feedChangeListener", "com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedChangeListener$1;", "feedDeleteListener", "com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader$feedDeleteListener$1;", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "isObservePostEvent", "onAlive", "onDead", "onPostEnd", "localId", "", "isOk", "onPostNotify", "onPostOk", "svrID", "onPostStart", "remove", "finderFeedId", "notify", "removeLocal", "", "requestLoadMore", "isAuto", "updateByLocalId", "newFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isPostUpdate", "updateItem", "svrId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseMegaVideoLoader
  extends BaseFeedLoader<cc>
  implements com.tencent.mm.plugin.finder.upload.r
{
  private final feedDeleteListener.1 EzC = new IListener(com.tencent.mm.app.f.hfK)
  {
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(hy paramhy1, BaseMegaVideoLoader paramBaseMegaVideoLoader, hy paramhy2)
      {
        super();
      }
    }
  };
  private final feedChangeListener.1 EzD = new IListener(com.tencent.mm.app.f.hfK)
  {
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(BaseMegaVideoLoader paramBaseMegaVideoLoader, if paramif)
      {
        super();
      }
    }
  };
  public kotlin.g.a.b<? super IResponse<cc>, ah> fetchEndCallback;
  public boolean hasMore = true;
  
  public BaseMegaVideoLoader(bui parambui)
  {
    super(parambui);
  }
  
  private void e(FinderItem paramFinderItem)
  {
    s.u(paramFinderItem, "newFeed");
    if (paramFinderItem.getLocalId() <= 0L) {}
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)getDataList()).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (i < 0) {
          p.kkW();
        }
        localObject = (cc)localObject;
        if ((localObject instanceof ca))
        {
          FinderItem localFinderItem = ((ca)localObject).EDG;
          if ((localFinderItem != null) && (localFinderItem.getLocalId() == paramFinderItem.getLocalId())) {}
          for (int j = 1; j != 0; j = 0)
          {
            ((ca)localObject).EDG = paramFinderItem;
            ((ca)localObject).m(paramFinderItem.getFeedObject());
            Log.i(getTAG(), s.X("updateByLocalId ", Long.valueOf(paramFinderItem.getLocalId())));
            dispatcher().onItemRangeChanged(i, 1, (Serializable)new kotlin.r(Integer.valueOf(4), Integer.valueOf(1)));
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  private void pg(long paramLong)
  {
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    localObject = d.a.qr(paramLong);
    if (localObject != null)
    {
      Log.i(getTAG(), "updateItem localId:" + paramLong + " itemLoadId:" + ((FinderItem)localObject).getLocalId() + " itemId:" + ((FinderItem)localObject).getId());
      e((FinderItem)localObject);
    }
  }
  
  public boolean isObservePostEvent()
  {
    return false;
  }
  
  public void onAlive()
  {
    super.onAlive();
    this.EzD.alive();
    this.EzC.alive();
    if (isObservePostEvent()) {
      ((c)h.az(c.class)).finderPostManager().a((com.tencent.mm.plugin.finder.upload.r)this);
    }
  }
  
  public void onDead()
  {
    super.onDead();
    this.EzD.dead();
    this.EzC.dead();
    if (isObservePostEvent()) {
      ((c)h.az(c.class)).finderPostManager().b((com.tencent.mm.plugin.finder.upload.r)this);
    }
  }
  
  public void onFetchDone(IResponse paramIResponse)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aYj());
    super.onFetchDone(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
  }
  
  public void onPostEnd(long paramLong, boolean paramBoolean)
  {
    pg(paramLong);
  }
  
  public void onPostNotify(long paramLong, boolean paramBoolean)
  {
    pg(paramLong);
  }
  
  public void onPostOk(long paramLong1, long paramLong2)
  {
    Object localObject = e.FMN;
    localObject = e.a.jn(paramLong2);
    if (localObject != null) {
      ((FinderItem)localObject).setLocalId(paramLong1);
    }
    if (localObject != null)
    {
      Log.i(getTAG(), "updateItem localId:" + paramLong1 + " itemLoadId:" + ((FinderItem)localObject).getLocalId() + " itemId:" + ((FinderItem)localObject).getId());
      e((FinderItem)localObject);
    }
  }
  
  public void onPostStart(long paramLong)
  {
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    Object localObject2 = d.a.qr(paramLong);
    if (localObject2 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label31;
      }
    }
    label31:
    while (localObject2 == null)
    {
      return;
      localObject1 = ((FinderItem)localObject2).getMegaVideo();
      break;
    }
    localObject1 = new ArrayList();
    Log.i(getTAG(), s.X("onPostStart localId ", Long.valueOf(paramLong)));
    ca localca = new ca(((FinderItem)localObject2).getFeedObject());
    localca.EDG = ((FinderItem)localObject2);
    localObject2 = ah.aiuX;
    ((ArrayList)localObject1).add(localca);
    com.tencent.mm.plugin.finder.feed.model.internal.d.mergeDataAndNotify$default(getMerger(), 2, (List)localObject1, true, null, 8, null);
  }
  
  public final long pf(long paramLong)
  {
    Object localObject = ((List)getDataList()).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext())
    {
      cc localcc = (cc)((Iterator)localObject).next();
      if (((localcc instanceof ca)) && (((ca)localcc).eDF() == paramLong))
      {
        j = 1;
        label62:
        if (j == 0) {
          break label110;
        }
      }
    }
    for (;;)
    {
      localObject = null;
      if (i != -1)
      {
        localObject = (ca)getDataList().remove(i);
        dispatcher().onItemRangeRemoved(i, 1);
      }
      if (localObject != null) {
        break label122;
      }
      return 0L;
      j = 0;
      break label62;
      label110:
      i += 1;
      break;
      i = -1;
    }
    label122:
    return ((ca)localObject).bZA();
  }
  
  public void requestLoadMore(boolean paramBoolean)
  {
    if (!this.hasMore) {
      return;
    }
    super.requestLoadMore(paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class feedChangeListener$1$a
    extends u
    implements kotlin.g.a.a<ah>
  {
    feedChangeListener$1$a(BaseMegaVideoLoader paramBaseMegaVideoLoader, if paramif)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class feedDeleteListener$1$a
    extends u
    implements kotlin.g.a.a<ah>
  {
    feedDeleteListener$1$a(hy paramhy1, BaseMegaVideoLoader paramBaseMegaVideoLoader, hy paramhy2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader
 * JD-Core Version:    0.7.0.1
 */