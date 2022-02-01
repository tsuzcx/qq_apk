package com.tencent.mm.plugin.finder.feed.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.a;
import com.tencent.mm.g.a.he;
import com.tencent.mm.g.a.he.a;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.upload.g.a;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.q;
import d.o;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "backCache", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "getBackCache", "()Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "cache", "getCache", "value", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "feedChangeListener", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1;", "feedDeleteListener", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1;", "initPos", "", "getInitPos", "()I", "Lcom/tencent/mm/protobuf/ByteString;", "lastBuffer", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "store", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore;", "getStore", "()Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore;", "initBackCache", "", "intent", "Landroid/content/Intent;", "initFromCache", "isObservePostEvent", "", "onAlive", "onDead", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onPostEnd", "localId", "", "isOk", "onPostNotify", "onPostOk", "svrID", "onPostStart", "isFromSns", "onSaveLastBuffer", "remove", "feedId", "notify", "removeByLocalId", "feedLocalId", "saveCache", "position", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "saveCacheToIntent", "feedList", "", "transformFinderObj", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "updateByLocalId", "newFeed", "updateItem", "svrId", "updateProgressByLoalId", "plugin-finder_release"})
public abstract class BaseFinderFeedLoader
  extends BaseFeedLoader<al>
  implements com.tencent.mm.plugin.finder.upload.l
{
  private byte _hellAccFlag_;
  private final feedChangeListener.1 feedChangeListener;
  private final feedDeleteListener.1 feedDeleteListener;
  private final f store = new f();
  
  public BaseFinderFeedLoader()
  {
    this(null, 1, null);
  }
  
  public BaseFinderFeedLoader(aqy paramaqy)
  {
    this.store.rIl = paramaqy;
    this.feedDeleteListener = new com.tencent.mm.sdk.b.c()
    {
      public final boolean callback(final hb paramAnonymoushb)
      {
        AppMethodBeat.i(202314);
        if (paramAnonymoushb != null) {
          com.tencent.mm.ad.c.g((d.g.a.a)new q(paramAnonymoushb)
          {
            public final void invoke()
            {
              AppMethodBeat.i(202313);
              if (paramAnonymoushb.dtu.id != 0L)
              {
                this.this$0.this$0.remove(paramAnonymoushb.dtu.id, true);
                AppMethodBeat.o(202313);
                return;
              }
              this.this$0.this$0.removeByLocalId(paramAnonymoushb.dtu.dnz, true);
              AppMethodBeat.o(202313);
            }
          });
        }
        AppMethodBeat.o(202314);
        return false;
      }
    };
    this.feedChangeListener = new com.tencent.mm.sdk.b.c()
    {
      public final boolean callback(final he paramAnonymoushe)
      {
        AppMethodBeat.i(202312);
        d.g.b.p.h(paramAnonymoushe, "event");
        com.tencent.mm.ad.c.a(0L, (d.g.a.a)new q(paramAnonymoushe)
        {
          public final void invoke()
          {
            int k = 0;
            AppMethodBeat.i(202311);
            ad.i(this.this$0.this$0.getTAG(), "feedChangeListener " + paramAnonymoushe.dtz.id + ",fav = " + paramAnonymoushe.dtz.dtA + ',' + "like = " + paramAnonymoushe.dtz.dtC + ",likeCount = " + paramAnonymoushe.dtz.likeCount + " ,needChangeData = " + paramAnonymoushe.dtz.dtB);
            switch (paramAnonymoushe.dtz.type)
            {
            }
            label783:
            label1042:
            label1047:
            label1439:
            for (;;)
            {
              AppMethodBeat.o(202311);
              return;
              if (paramAnonymoushe.dtz.id != 0L)
              {
                Object localObject1 = com.tencent.mm.plugin.finder.storage.data.d.szI;
                localObject1 = paramAnonymoushe.dtz;
                if (localObject1 == null) {
                  d.g.b.p.gfZ();
                }
                localObject1 = d.a.wT(((he.a)localObject1).id);
                Object localObject2;
                int i;
                int j;
                if (localObject1 != null)
                {
                  localObject2 = ((List)this.this$0.this$0.getDataList()).iterator();
                  i = 0;
                  if (((Iterator)localObject2).hasNext())
                  {
                    al localal = (al)((Iterator)localObject2).next();
                    if (((localal instanceof BaseFinderFeed)) && (((BaseFinderFeed)localal).feedObject.getId() == paramAnonymoushe.dtz.id))
                    {
                      j = 1;
                      label317:
                      if (j == 0) {
                        break label383;
                      }
                    }
                  }
                  for (;;)
                  {
                    if (i != -1)
                    {
                      this.this$0.this$0.getDataList().set(i, BaseFinderFeedLoader.access$transformFinderObj(this.this$0.this$0, (FinderItem)localObject1));
                      this.this$0.this$0.dispatcher().f(i, 1, Integer.valueOf(1));
                    }
                    AppMethodBeat.o(202311);
                    return;
                    j = 0;
                    break label317;
                    label383:
                    i += 1;
                    break;
                    i = -1;
                  }
                }
                AppMethodBeat.o(202311);
                return;
                if (paramAnonymoushe.dtz.id != 0L)
                {
                  localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                  i = 0;
                  label438:
                  if (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (al)((Iterator)localObject1).next();
                    if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushe.dtz.id))
                    {
                      j = 1;
                      label495:
                      if (j == 0) {
                        break label549;
                      }
                    }
                  }
                  while (i != -1)
                  {
                    localObject1 = this.this$0.this$0.getDataList().get(i);
                    if (localObject1 != null) {
                      break label561;
                    }
                    localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                    AppMethodBeat.o(202311);
                    throw ((Throwable)localObject1);
                    j = 0;
                    break label495;
                    label549:
                    i += 1;
                    break label438;
                    i = -1;
                  }
                  label561:
                  localObject1 = (BaseFinderFeed)localObject1;
                  if (paramAnonymoushe.dtz.dtB == 1)
                  {
                    j = paramAnonymoushe.dtz.dtC;
                    k = ((BaseFinderFeed)localObject1).feedObject.getLikeFlag();
                    ad.i(this.this$0.this$0.getTAG(), "TYPE_FEED_LIKE_CHANGED oldFlag:" + k + ", newFlag:" + j);
                    if (k != j)
                    {
                      ((BaseFinderFeed)localObject1).feedObject.setLikeFlag(j);
                      if (k == 0)
                      {
                        localObject2 = ((BaseFinderFeed)localObject1).feedObject;
                        ((FinderItem)localObject2).setLikeCount(((FinderItem)localObject2).getLikeCount() + 1);
                        if (j != 1) {
                          break label783;
                        }
                        localObject2 = ((BaseFinderFeed)localObject1).feedObject;
                        ((FinderItem)localObject2).setFriendLikeCount(((FinderItem)localObject2).getFriendLikeCount() + 1);
                        localObject2 = com.tencent.mm.plugin.finder.upload.action.g.sKi;
                        com.tencent.mm.plugin.finder.upload.action.g.cKV();
                        com.tencent.mm.plugin.finder.upload.action.g.al(((BaseFinderFeed)localObject1).feedObject.getLikeList());
                      }
                      for (;;)
                      {
                        this.this$0.this$0.dispatcher().f(i, 1, new o(Integer.valueOf(3), Integer.valueOf(1)));
                        AppMethodBeat.o(202311);
                        return;
                        if (j != 0) {
                          break;
                        }
                        localObject2 = ((BaseFinderFeed)localObject1).feedObject;
                        ((FinderItem)localObject2).setLikeCount(((FinderItem)localObject2).getLikeCount() - 1);
                        break;
                        if (k == 1)
                        {
                          localObject2 = ((BaseFinderFeed)localObject1).feedObject;
                          ((FinderItem)localObject2).setFriendLikeCount(((FinderItem)localObject2).getFriendLikeCount() - 1);
                          localObject2 = com.tencent.mm.plugin.finder.upload.action.g.sKi;
                          com.tencent.mm.plugin.finder.upload.action.g.cKV();
                          com.tencent.mm.plugin.finder.upload.action.g.an(((BaseFinderFeed)localObject1).feedObject.getLikeList());
                        }
                      }
                    }
                  }
                  else
                  {
                    this.this$0.this$0.dispatcher().f(i, 1, new o(Integer.valueOf(3), Integer.valueOf(1)));
                    AppMethodBeat.o(202311);
                    return;
                    if (paramAnonymoushe.dtz.id != 0L)
                    {
                      localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                      i = 0;
                      if (((Iterator)localObject1).hasNext())
                      {
                        localObject2 = (al)((Iterator)localObject1).next();
                        if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushe.dtz.id))
                        {
                          j = 1;
                          label960:
                          if (j == 0) {
                            break label1030;
                          }
                          label964:
                          if (paramAnonymoushe.dtz.dtA != 1) {
                            break label1042;
                          }
                        }
                      }
                      for (j = 1; i != -1; j = 0)
                      {
                        localObject1 = this.this$0.this$0.getDataList().get(i);
                        if (localObject1 != null) {
                          break label1047;
                        }
                        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                        AppMethodBeat.o(202311);
                        throw ((Throwable)localObject1);
                        j = 0;
                        break label960;
                        i += 1;
                        break label903;
                        i = -1;
                        break label964;
                      }
                      localObject1 = (BaseFinderFeed)localObject1;
                      if (((BaseFinderFeed)localObject1).feedObject.getFavFlag() != j) {
                        k = 1;
                      }
                      if (paramAnonymoushe.dtz.dtB == 1) {
                        ((BaseFinderFeed)localObject1).feedObject.setFavFlag(j);
                      }
                      if (k != 0)
                      {
                        this.this$0.this$0.dispatcher().f(i, 1, new o(Integer.valueOf(4), Integer.valueOf(1)));
                        AppMethodBeat.o(202311);
                        return;
                        if (paramAnonymoushe.dtz.id != 0L)
                        {
                          localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                          i = 0;
                          if (((Iterator)localObject1).hasNext())
                          {
                            localObject2 = (al)((Iterator)localObject1).next();
                            if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushe.dtz.id))
                            {
                              j = 1;
                              label1225:
                              if (j == 0) {
                                break label1275;
                              }
                            }
                          }
                          while (i != -1)
                          {
                            this.this$0.this$0.dispatcher().f(i, 1, new o(Integer.valueOf(5), Integer.valueOf(1)));
                            AppMethodBeat.o(202311);
                            return;
                            j = 0;
                            break label1225;
                            label1275:
                            i += 1;
                            break label1168;
                            i = -1;
                          }
                          if (paramAnonymoushe.dtz.id != 0L)
                          {
                            localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                            i = 0;
                            label1324:
                            if (((Iterator)localObject1).hasNext())
                            {
                              localObject2 = (al)((Iterator)localObject1).next();
                              if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushe.dtz.id))
                              {
                                j = 1;
                                label1381:
                                if (j == 0) {
                                  break label1429;
                                }
                              }
                            }
                            for (;;)
                            {
                              if (i == -1) {
                                break label1439;
                              }
                              this.this$0.this$0.dispatcher().f(i, 1, new o(Integer.valueOf(6), Integer.valueOf(0)));
                              break;
                              j = 0;
                              break label1381;
                              i += 1;
                              break label1324;
                              i = -1;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        });
        AppMethodBeat.o(202312);
        return true;
      }
    };
  }
  
  private final BaseFinderFeed transformFinderObj(FinderItem paramFinderItem)
  {
    b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
    return b.a.j(paramFinderItem);
  }
  
  public final e getBackCache()
  {
    return this.store.scu;
  }
  
  public final e getCache()
  {
    return this.store.sct;
  }
  
  public final aqy getContextObj()
  {
    return this.store.rIl;
  }
  
  public final int getInitPos()
  {
    e locale = this.store.sct;
    if (locale != null) {}
    for (int i = locale.position;; i = 0) {
      return Math.max(i, 0);
    }
  }
  
  public final com.tencent.mm.bx.b getLastBuffer()
  {
    return this.store.lastBuffer;
  }
  
  protected final f getStore()
  {
    return this.store;
  }
  
  public final void initBackCache(Intent paramIntent)
  {
    d.g.b.p.h(paramIntent, "intent");
    f localf = this.store;
    d.g.b.p.h(paramIntent, "intent");
    f.a locala = f.scy;
    localf.scu = f.a.aj(paramIntent);
  }
  
  public final void initFromCache(Intent paramIntent)
  {
    d.g.b.p.h(paramIntent, "intent");
    f.a(this.store, paramIntent);
  }
  
  public boolean isObservePostEvent()
  {
    return false;
  }
  
  public void onAlive()
  {
    super.onAlive();
    if (isObservePostEvent())
    {
      g.a locala = com.tencent.mm.plugin.finder.upload.g.sJk;
      com.tencent.mm.plugin.finder.upload.g.cKK().a((com.tencent.mm.plugin.finder.upload.l)this);
    }
    this.feedDeleteListener.alive();
    this.feedChangeListener.alive();
  }
  
  public void onDead()
  {
    super.onDead();
    if (isObservePostEvent())
    {
      g.a locala = com.tencent.mm.plugin.finder.upload.g.sJk;
      com.tencent.mm.plugin.finder.upload.g.cKK().b((com.tencent.mm.plugin.finder.upload.l)this);
    }
    this.feedDeleteListener.dead();
    this.feedChangeListener.dead();
  }
  
  public void onFetchDone(IResponse<al> paramIResponse)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.ahq());
    d.g.b.p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    onSaveLastBuffer(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
  }
  
  public void onPostEnd(long paramLong, boolean paramBoolean)
  {
    updateItem(paramLong);
  }
  
  public void onPostNotify(long paramLong, boolean paramBoolean)
  {
    updateItem(paramLong);
  }
  
  public void onPostOk(long paramLong1, long paramLong2)
  {
    updateItem(paramLong1, paramLong2);
  }
  
  public void onPostStart(long paramLong)
  {
    onPostStart(paramLong, false);
  }
  
  public void onPostStart(long paramLong, boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
    Object localObject2 = b.a.xg(paramLong);
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = transformFinderObj((FinderItem)localObject2);
      ad.i(getTAG(), "onPostStart localId " + paramLong + " feed " + localObject2);
      com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (!com.tencent.mm.plugin.finder.utils.p.cLC()) {
        break label119;
      }
    }
    label119:
    for (((BaseFinderFeed)localObject2).showLikeTips = false;; ((BaseFinderFeed)localObject2).showLikeTips = true)
    {
      ((BaseFinderFeed)localObject2).showShareSns = paramBoolean;
      ((ArrayList)localObject1).add(localObject2);
      com.tencent.mm.plugin.finder.feed.model.internal.b.mergeDataAndNotify$default(getMerger(), 2, (List)localObject1, true, null, 8, null);
      return;
    }
  }
  
  public void onSaveLastBuffer(IResponse<al> paramIResponse)
  {
    d.g.b.p.h(paramIResponse, "response");
    setLastBuffer(paramIResponse.getLastBuffer());
  }
  
  public final int remove(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = ((List)getDataList()).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      al localal = (al)localIterator.next();
      if (((localal instanceof BaseFinderFeed)) && (((BaseFinderFeed)localal).feedObject.getId() == paramLong))
      {
        j = 1;
        label66:
        if (j == 0) {
          break label115;
        }
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        d.g.b.p.g(getDataList().remove(i), "dataList.removeAt(index)");
        if (paramBoolean) {
          dispatcher().av(i, 1);
        }
      }
      return i;
      j = 0;
      break label66;
      label115:
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final int removeByLocalId(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = ((List)getDataList()).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      al localal = (al)localIterator.next();
      if (((localal instanceof BaseFinderFeed)) && (((BaseFinderFeed)localal).feedObject.getLocalId() == paramLong))
      {
        j = 1;
        label66:
        if (j == 0) {
          break label115;
        }
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        d.g.b.p.g(getDataList().remove(i), "dataList.removeAt(index)");
        if (paramBoolean) {
          dispatcher().av(i, 1);
        }
      }
      return i;
      j = 0;
      break label66;
      label115:
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void saveCache(Intent paramIntent, int paramInt, a parama)
  {
    d.g.b.p.h(paramIntent, "intent");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)getDataList());
    parama = new e(localArrayList, getLastBuffer(), paramInt, parama);
    this.store.a(parama, paramIntent);
  }
  
  public final void saveCacheToIntent(Intent paramIntent, List<? extends al> paramList, com.tencent.mm.bx.b paramb, int paramInt, a parama)
  {
    d.g.b.p.h(paramIntent, "intent");
    d.g.b.p.h(paramList, "feedList");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)paramList);
    paramList = new e(localArrayList, paramb, paramInt, parama);
    this.store.a(paramList, paramIntent);
  }
  
  public final void setContextObj(aqy paramaqy)
  {
    this.store.rIl = paramaqy;
  }
  
  public final void setLastBuffer(com.tencent.mm.bx.b paramb)
  {
    this.store.lastBuffer = paramb;
  }
  
  public final int updateByLocalId(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean)
  {
    d.g.b.p.h(paramBaseFinderFeed, "newFeed");
    int j;
    if (paramBaseFinderFeed.feedObject.getLocalId() <= 0L)
    {
      j = -1;
      return j;
    }
    Iterator localIterator = ((Iterable)getDataList()).iterator();
    int i = 0;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label197;
      }
      Object localObject = localIterator.next();
      if (i < 0) {
        j.gfB();
      }
      localObject = (al)localObject;
      if (((localObject instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject).feedObject.getLocalId() == paramBaseFinderFeed.feedObject.getLocalId()))
      {
        paramBaseFinderFeed.showLikeTips = ((BaseFinderFeed)localObject).showLikeTips;
        paramBaseFinderFeed.showShareSns = ((BaseFinderFeed)localObject).showShareSns;
        getDataList().set(i, paramBaseFinderFeed);
        j = i;
        if (!paramBoolean) {
          break;
        }
        ad.i(getTAG(), "updateByLocalId " + paramBaseFinderFeed.feedObject.getLocalId());
        dispatcher().f(i, 1, Integer.valueOf(1));
        return i;
      }
      i += 1;
    }
    label197:
    return -1;
  }
  
  protected final void updateItem(long paramLong)
  {
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
    localObject = b.a.xg(paramLong);
    if (localObject != null)
    {
      ad.i(getTAG(), "updateItem localId:" + paramLong + " itemLoadId:" + ((FinderItem)localObject).getLocalId() + " itemId:" + ((FinderItem)localObject).getId());
      updateByLocalId(transformFinderObj((FinderItem)localObject), true);
    }
  }
  
  protected final void updateItem(long paramLong1, long paramLong2)
  {
    Object localObject = com.tencent.mm.plugin.finder.storage.data.d.szI;
    localObject = d.a.wT(paramLong2);
    if (localObject != null) {
      ((FinderItem)localObject).setLocalId(paramLong1);
    }
    if (localObject != null)
    {
      ad.i(getTAG(), "updateItem localId:" + paramLong1 + " itemLoadId:" + ((FinderItem)localObject).getLocalId() + " itemId:" + ((FinderItem)localObject).getId());
      updateByLocalId(transformFinderObj((FinderItem)localObject), true);
    }
  }
  
  public final void updateProgressByLoalId(final long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    com.tencent.mm.ad.c.g((d.g.a.a)new q(paramLong)
    {
      public final void invoke()
      {
        AppMethodBeat.i(202316);
        Iterator localIterator = ((Iterable)this.this$0.getDataList()).iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          Object localObject1 = localIterator.next();
          if (i < 0) {
            j.gfB();
          }
          localObject1 = (al)localObject1;
          if (((localObject1 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject1).feedObject.getLocalId() == paramLong))
          {
            Object localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
            Object localObject3 = b.a.xg(paramLong);
            if (localObject3 != null)
            {
              boolean bool = ((BaseFinderFeed)localObject1).showLikeTips;
              localObject2 = this.this$0.getDataList();
              localObject3 = BaseFinderFeedLoader.access$transformFinderObj(this.this$0, (FinderItem)localObject3);
              ((BaseFinderFeed)localObject3).showLikeTips = bool;
              ((BaseFinderFeed)localObject3).showShareSns = ((BaseFinderFeed)localObject1).showShareSns;
              ((DataBuffer)localObject2).set(i, localObject3);
            }
            ad.i(this.this$0.getTAG(), "updateProgressByLoalId " + ((BaseFinderFeed)localObject1).feedObject.getLocalId());
            this.this$0.dispatcher().f(i, 1, new o(Integer.valueOf(2), Integer.valueOf(1)));
          }
          i += 1;
        }
        AppMethodBeat.o(202316);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
 * JD-Core Version:    0.7.0.1
 */