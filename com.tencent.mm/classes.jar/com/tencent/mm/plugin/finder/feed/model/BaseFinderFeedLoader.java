package com.tencent.mm.plugin.finder.feed.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.g.a.hc.a;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hf.a;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.upload.g.a;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.b.q;
import d.o;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "backCache", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "getBackCache", "()Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "cache", "getCache", "value", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "feedChangeListener", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1;", "feedDeleteListener", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1;", "initPos", "", "getInitPos", "()I", "Lcom/tencent/mm/protobuf/ByteString;", "lastBuffer", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "store", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore;", "getStore", "()Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore;", "initBackCache", "", "intent", "Landroid/content/Intent;", "initFromCache", "isObservePostEvent", "", "onAlive", "onDead", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onPostEnd", "localId", "", "isOk", "onPostNotify", "onPostOk", "svrID", "onPostStart", "isFromSns", "onSaveLastBuffer", "remove", "feedId", "notify", "removeByLocalId", "feedLocalId", "saveCache", "position", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "saveCacheToIntent", "feedList", "", "transformFinderObj", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "updateByLocalId", "newFeed", "updateItem", "svrId", "updateProgressByLoalId", "plugin-finder_release"})
public abstract class BaseFinderFeedLoader
  extends BaseFeedLoader<am>
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
  
  public BaseFinderFeedLoader(final arn paramarn)
  {
    this.store.rQw = paramarn;
    this.feedDeleteListener = new com.tencent.mm.sdk.b.c()
    {
      public final boolean callback(final hc paramAnonymoushc)
      {
        AppMethodBeat.i(202780);
        if (paramAnonymoushc != null) {
          com.tencent.mm.ac.c.h((d.g.a.a)new q(paramAnonymoushc)
          {
            public final void invoke()
            {
              AppMethodBeat.i(202779);
              if (paramAnonymoushc.duz.id != 0L)
              {
                this.this$0.this$0.remove(paramAnonymoushc.duz.id, true);
                AppMethodBeat.o(202779);
                return;
              }
              this.this$0.this$0.removeByLocalId(paramAnonymoushc.duz.doE, true);
              AppMethodBeat.o(202779);
            }
          });
        }
        AppMethodBeat.o(202780);
        return false;
      }
    };
    this.feedChangeListener = new com.tencent.mm.sdk.b.c()
    {
      public final boolean callback(final hf paramAnonymoushf)
      {
        AppMethodBeat.i(202778);
        d.g.b.p.h(paramAnonymoushf, "event");
        com.tencent.mm.ac.c.a(0L, (d.g.a.a)new q(paramAnonymoushf)
        {
          public final void invoke()
          {
            int m = 0;
            int k = 0;
            AppMethodBeat.i(202777);
            ae.i(this.this$0.this$0.getTAG(), "feedChangeListener " + paramAnonymoushf.duE.id + ",fav = " + paramAnonymoushf.duE.duF + ',' + "like = " + paramAnonymoushf.duE.duH + ",likeCount = " + paramAnonymoushf.duE.likeCount + " ,needChangeData = " + paramAnonymoushf.duE.duG);
            switch (paramAnonymoushf.duE.type)
            {
            }
            Object localObject2;
            int j;
            label317:
            label383:
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            AppMethodBeat.o(202777);
                            return;
                          } while (paramAnonymoushf.duE.id == 0L);
                          localObject1 = com.tencent.mm.plugin.finder.storage.data.d.sKD;
                          localObject1 = paramAnonymoushf.duE;
                          if (localObject1 == null) {
                            d.g.b.p.gkB();
                          }
                          localObject1 = d.a.xk(((hf.a)localObject1).id);
                          if (localObject1 != null)
                          {
                            localObject2 = ((List)this.this$0.this$0.getDataList()).iterator();
                            i = 0;
                            if (((Iterator)localObject2).hasNext())
                            {
                              am localam = (am)((Iterator)localObject2).next();
                              if (((localam instanceof BaseFinderFeed)) && (((BaseFinderFeed)localam).feedObject.getId() == paramAnonymoushf.duE.id))
                              {
                                j = 1;
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
                              AppMethodBeat.o(202777);
                              return;
                              j = 0;
                              break label317;
                              i += 1;
                              break;
                              i = -1;
                            }
                          }
                          AppMethodBeat.o(202777);
                          return;
                        } while (paramAnonymoushf.duE.id == 0L);
                        localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                        i = 0;
                        if (((Iterator)localObject1).hasNext())
                        {
                          localObject2 = (am)((Iterator)localObject1).next();
                          if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushf.duE.id))
                          {
                            j = 1;
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
                          AppMethodBeat.o(202777);
                          throw ((Throwable)localObject1);
                          j = 0;
                          break label495;
                          i += 1;
                          break label438;
                          i = -1;
                        }
                        localObject1 = (BaseFinderFeed)localObject1;
                        if (paramAnonymoushf.duE.duG != 1) {
                          break;
                        }
                        j = paramAnonymoushf.duE.duH;
                        k = ((BaseFinderFeed)localObject1).feedObject.getLikeFlag();
                        ae.i(this.this$0.this$0.getTAG(), "TYPE_FEED_LIKE_CHANGED oldFlag:" + k + ", newFlag:" + j);
                      } while (k == j);
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
                        localObject2 = com.tencent.mm.plugin.finder.upload.action.g.sVv;
                        com.tencent.mm.plugin.finder.upload.action.g.cNz();
                        com.tencent.mm.plugin.finder.upload.action.g.al(((BaseFinderFeed)localObject1).feedObject.getLikeList());
                      }
                      for (;;)
                      {
                        this.this$0.this$0.dispatcher().f(i, 1, new o(Integer.valueOf(3), Integer.valueOf(1)));
                        AppMethodBeat.o(202777);
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
                          localObject2 = com.tencent.mm.plugin.finder.upload.action.g.sVv;
                          com.tencent.mm.plugin.finder.upload.action.g.cNz();
                          com.tencent.mm.plugin.finder.upload.action.g.an(((BaseFinderFeed)localObject1).feedObject.getLikeList());
                        }
                      }
                      this.this$0.this$0.dispatcher().f(i, 1, new o(Integer.valueOf(3), Integer.valueOf(1)));
                      AppMethodBeat.o(202777);
                      return;
                    } while (paramAnonymoushf.duE.id == 0L);
                    localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                    i = 0;
                    if (((Iterator)localObject1).hasNext())
                    {
                      localObject2 = (am)((Iterator)localObject1).next();
                      if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushf.duE.id))
                      {
                        j = 1;
                        if (j == 0) {
                          break label1030;
                        }
                        if (paramAnonymoushf.duE.duF != 1) {
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
                      AppMethodBeat.o(202777);
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
                    if (paramAnonymoushf.duE.duG == 1) {
                      ((BaseFinderFeed)localObject1).feedObject.setFavFlag(j);
                    }
                  } while (k == 0);
                  this.this$0.this$0.dispatcher().f(i, 1, new o(Integer.valueOf(4), Integer.valueOf(1)));
                  AppMethodBeat.o(202777);
                  return;
                } while (paramAnonymoushf.duE.id == 0L);
                localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                i = 0;
                if (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (am)((Iterator)localObject1).next();
                  if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushf.duE.id))
                  {
                    j = 1;
                    if (j == 0) {
                      break label1275;
                    }
                  }
                }
                while (i != -1)
                {
                  this.this$0.this$0.dispatcher().f(i, 1, new o(Integer.valueOf(5), Integer.valueOf(1)));
                  AppMethodBeat.o(202777);
                  return;
                  j = 0;
                  break label1225;
                  i += 1;
                  break label1168;
                  i = -1;
                }
              } while (paramAnonymoushf.duE.id == 0L);
              localObject1 = this.this$0.$contextObj;
              if ((localObject1 != null) && (((arn)localObject1).sch == 17)) {
                break;
              }
              localObject1 = this.this$0.$contextObj;
              if ((localObject1 != null) && (((arn)localObject1).sch == 18)) {
                break;
              }
              localObject1 = this.this$0.$contextObj;
              if ((localObject1 != null) && (((arn)localObject1).sch == 20)) {
                break;
              }
              localObject1 = this.this$0.$contextObj;
              if ((localObject1 != null) && (((arn)localObject1).sch == 16)) {
                break;
              }
              localObject1 = this.this$0.$contextObj;
              if ((localObject1 != null) && (((arn)localObject1).sch == 6)) {
                break;
              }
              localObject1 = this.this$0.$contextObj;
              if ((localObject1 != null) && (((arn)localObject1).sch == 27)) {
                break;
              }
              localObject1 = this.this$0.$contextObj;
              if ((localObject1 != null) && (((arn)localObject1).sch == 9)) {
                break;
              }
              localObject1 = this.this$0.$contextObj;
              if (localObject1 == null) {
                break label1689;
              }
            } while (((arn)localObject1).sch != 25);
            label438:
            label495:
            label1275:
            Object localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
            label549:
            label561:
            label960:
            label964:
            label1225:
            int i = 0;
            label783:
            label1042:
            label1047:
            label1516:
            boolean bool2;
            label903:
            label1168:
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (am)((Iterator)localObject1).next();
              if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushf.duE.id))
              {
                j = 1;
                label1573:
                if (j == 0) {
                  break label1700;
                }
                label1577:
                if (i == -1) {
                  break label1710;
                }
                localObject1 = (am)this.this$0.this$0.getDataList().get(i);
                j = m;
                if ((localObject1 instanceof BaseFinderFeed))
                {
                  bool2 = ((BaseFinderFeed)localObject1).showCommentEdu;
                  if (paramAnonymoushf.duE.duG != 1) {
                    break label1712;
                  }
                }
              }
            }
            label1030:
            label1689:
            label1700:
            label1710:
            label1712:
            for (boolean bool1 = true;; bool1 = false)
            {
              j = m;
              if (bool2 != bool1) {
                j = 1;
              }
              if (j == 0) {
                break;
              }
              this.this$0.this$0.dispatcher().f(i, 1, new o(Integer.valueOf(6), paramAnonymoushf));
              break;
              AppMethodBeat.o(202777);
              return;
              j = 0;
              break label1573;
              i += 1;
              break label1516;
              i = -1;
              break label1577;
              break;
            }
          }
        });
        AppMethodBeat.o(202778);
        return true;
      }
    };
  }
  
  private final BaseFinderFeed transformFinderObj(FinderItem paramFinderItem)
  {
    b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
    return b.a.j(paramFinderItem);
  }
  
  public final e getBackCache()
  {
    return this.store.sll;
  }
  
  public final e getCache()
  {
    return this.store.slk;
  }
  
  public final arn getContextObj()
  {
    return this.store.rQw;
  }
  
  public final int getInitPos()
  {
    e locale = this.store.slk;
    if (locale != null) {}
    for (int i = locale.position;; i = 0) {
      return Math.max(i, 0);
    }
  }
  
  public final com.tencent.mm.bw.b getLastBuffer()
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
    f.a locala = f.slp;
    localf.sll = f.a.ak(paramIntent);
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
      g.a locala = com.tencent.mm.plugin.finder.upload.g.sUx;
      com.tencent.mm.plugin.finder.upload.g.cNo().a((com.tencent.mm.plugin.finder.upload.l)this);
    }
    this.feedDeleteListener.alive();
    this.feedChangeListener.alive();
  }
  
  public void onDead()
  {
    super.onDead();
    if (isObservePostEvent())
    {
      g.a locala = com.tencent.mm.plugin.finder.upload.g.sUx;
      com.tencent.mm.plugin.finder.upload.g.cNo().b((com.tencent.mm.plugin.finder.upload.l)this);
    }
    this.feedDeleteListener.dead();
    this.feedChangeListener.dead();
  }
  
  public void onFetchDone(IResponse<am> paramIResponse)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.ahF());
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
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
    Object localObject2 = b.a.xx(paramLong);
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = transformFinderObj((FinderItem)localObject2);
      ae.i(getTAG(), "onPostStart localId " + paramLong + " feed " + localObject2);
      com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (!com.tencent.mm.plugin.finder.utils.p.cOj()) {
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
  
  public void onSaveLastBuffer(IResponse<am> paramIResponse)
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
      am localam = (am)localIterator.next();
      if (((localam instanceof BaseFinderFeed)) && (((BaseFinderFeed)localam).feedObject.getId() == paramLong))
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
      am localam = (am)localIterator.next();
      if (((localam instanceof BaseFinderFeed)) && (((BaseFinderFeed)localam).feedObject.getLocalId() == paramLong))
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
  
  public final void saveCacheToIntent(Intent paramIntent, List<? extends am> paramList, com.tencent.mm.bw.b paramb, int paramInt, a parama)
  {
    d.g.b.p.h(paramIntent, "intent");
    d.g.b.p.h(paramList, "feedList");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)paramList);
    paramList = new e(localArrayList, paramb, paramInt, parama);
    this.store.a(paramList, paramIntent);
  }
  
  public final void setContextObj(arn paramarn)
  {
    this.store.rQw = paramarn;
  }
  
  public final void setLastBuffer(com.tencent.mm.bw.b paramb)
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
        j.gkd();
      }
      localObject = (am)localObject;
      if (((localObject instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject).feedObject.getLocalId() == paramBaseFinderFeed.feedObject.getLocalId()))
      {
        paramBaseFinderFeed.showLikeTips = ((BaseFinderFeed)localObject).showLikeTips;
        paramBaseFinderFeed.showShareSns = ((BaseFinderFeed)localObject).showShareSns;
        getDataList().set(i, paramBaseFinderFeed);
        j = i;
        if (!paramBoolean) {
          break;
        }
        ae.i(getTAG(), "updateByLocalId " + paramBaseFinderFeed.feedObject.getLocalId());
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
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
    localObject = b.a.xx(paramLong);
    if (localObject != null)
    {
      ae.i(getTAG(), "updateItem localId:" + paramLong + " itemLoadId:" + ((FinderItem)localObject).getLocalId() + " itemId:" + ((FinderItem)localObject).getId());
      updateByLocalId(transformFinderObj((FinderItem)localObject), true);
    }
  }
  
  protected final void updateItem(long paramLong1, long paramLong2)
  {
    Object localObject = com.tencent.mm.plugin.finder.storage.data.d.sKD;
    localObject = d.a.xk(paramLong2);
    if (localObject != null) {
      ((FinderItem)localObject).setLocalId(paramLong1);
    }
    if (localObject != null)
    {
      ae.i(getTAG(), "updateItem localId:" + paramLong1 + " itemLoadId:" + ((FinderItem)localObject).getLocalId() + " itemId:" + ((FinderItem)localObject).getId());
      updateByLocalId(transformFinderObj((FinderItem)localObject), true);
    }
  }
  
  public final void updateProgressByLoalId(final long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    com.tencent.mm.ac.c.h((d.g.a.a)new q(paramLong)
    {
      public final void invoke()
      {
        AppMethodBeat.i(202782);
        Iterator localIterator = ((Iterable)this.this$0.getDataList()).iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          Object localObject1 = localIterator.next();
          if (i < 0) {
            j.gkd();
          }
          localObject1 = (am)localObject1;
          if (((localObject1 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject1).feedObject.getLocalId() == paramLong))
          {
            Object localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
            Object localObject3 = b.a.xx(paramLong);
            if (localObject3 != null)
            {
              boolean bool = ((BaseFinderFeed)localObject1).showLikeTips;
              localObject2 = this.this$0.getDataList();
              localObject3 = BaseFinderFeedLoader.access$transformFinderObj(this.this$0, (FinderItem)localObject3);
              ((BaseFinderFeed)localObject3).showLikeTips = bool;
              ((BaseFinderFeed)localObject3).showShareSns = ((BaseFinderFeed)localObject1).showShareSns;
              ((DataBuffer)localObject2).set(i, localObject3);
            }
            ae.i(this.this$0.getTAG(), "updateProgressByLoalId " + ((BaseFinderFeed)localObject1).feedObject.getLocalId());
            this.this$0.dispatcher().f(i, 1, new o(Integer.valueOf(2), Integer.valueOf(1)));
          }
          i += 1;
        }
        AppMethodBeat.o(202782);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
 * JD-Core Version:    0.7.0.1
 */