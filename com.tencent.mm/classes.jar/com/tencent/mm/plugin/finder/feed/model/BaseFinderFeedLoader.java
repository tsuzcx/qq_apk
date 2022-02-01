package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.g.a.hg.a;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.hn.a;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.d.a;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.upload.g.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.arb;
import com.tencent.mm.protocal.protobuf.arl;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "feedChangeListener", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1;", "feedDeleteListener", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1;", "addRvFeed", "", "index", "", "feed", "colletExtraPageName", "", "getItem", "feedId", "", "getPageName", "insert", "notify", "", "interceptMvFeed", "interceptMvPostStart", "interceptPostStart", "isObservePostEvent", "onAlive", "onDataChanged", "onDead", "onMvPostStart", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "onPostEnd", "localId", "isOk", "onPostNotify", "onPostOk", "svrID", "onPostStart", "isFromSns", "remove", "removeByLocalId", "feedLocalId", "transformFinderObj", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedObj", "transformToMusicData", "updateByLocalId", "newFeed", "updateFinderPageItem", "updateItem", "svrId", "updateProgressByLocalId", "plugin-finder_release"})
public abstract class BaseFinderFeedLoader
  extends BaseFeedLoader<bo>
  implements com.tencent.mm.plugin.finder.upload.q
{
  private byte _hellAccFlag_;
  private final feedChangeListener.1 feedChangeListener;
  private final feedDeleteListener.1 feedDeleteListener = new IListener()
  {
    public final boolean callback(final hg paramAnonymoushg)
    {
      AppMethodBeat.i(244544);
      if (paramAnonymoushg != null) {
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new kotlin.g.b.q(paramAnonymoushg)
        {
          public final void invoke()
          {
            AppMethodBeat.i(244543);
            if (paramAnonymoushg.dLJ.dLK == 1)
            {
              AppMethodBeat.o(244543);
              return;
            }
            if (paramAnonymoushg.dLJ.id != 0L)
            {
              this.this$0.this$0.remove(paramAnonymoushg.dLJ.id, true);
              AppMethodBeat.o(244543);
              return;
            }
            this.this$0.this$0.removeByLocalId(paramAnonymoushg.dLJ.localId, true);
            AppMethodBeat.o(244543);
          }
        });
      }
      AppMethodBeat.o(244544);
      return false;
    }
  };
  
  public BaseFinderFeedLoader()
  {
    this(null, 1, null);
  }
  
  public BaseFinderFeedLoader(final bbn parambbn)
  {
    super(parambbn);
    this.feedChangeListener = new IListener()
    {
      public final boolean callback(final hn paramAnonymoushn)
      {
        AppMethodBeat.i(244542);
        p.h(paramAnonymoushn, "event");
        com.tencent.mm.ac.d.a(0L, (kotlin.g.a.a)new kotlin.g.b.q(paramAnonymoushn)
        {
          public final void invoke()
          {
            int i2 = 0;
            int n = 0;
            int i1 = 0;
            int k = 0;
            int m = 0;
            AppMethodBeat.i(244541);
            if (paramAnonymoushn.dLW.dLK == 1)
            {
              AppMethodBeat.o(244541);
              return;
            }
            Log.i(this.this$0.this$0.getTAG(), "feedChangeListener " + paramAnonymoushn.dLW.id + ",fav = " + paramAnonymoushn.dLW.dLX + ',' + "like = " + paramAnonymoushn.dLW.dLZ + ",likeCount = " + paramAnonymoushn.dLW.likeCount + " ,needChangeData = " + paramAnonymoushn.dLW.dLY);
            int i = m;
            Object localObject1;
            Object localObject2;
            label339:
            Object localObject3;
            int j;
            label396:
            label580:
            label846:
            label2005:
            switch (paramAnonymoushn.dLW.type)
            {
            default: 
              i = m;
            case 1: 
            case 2: 
            case 3: 
            case 10: 
            case 0: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 12: 
            case 13: 
            case 8: 
              label471:
              label639:
              label767:
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
                              do
                              {
                                for (;;)
                                {
                                  if (i != 0) {
                                    this.this$0.this$0.onDataChanged();
                                  }
                                  AppMethodBeat.o(244541);
                                  return;
                                  i = m;
                                  if (paramAnonymoushn.dLW.id != 0L)
                                  {
                                    localObject1 = e.vFX;
                                    localObject1 = paramAnonymoushn.dLW;
                                    if (localObject1 == null) {
                                      p.hyc();
                                    }
                                    localObject1 = e.a.Fy(((hn.a)localObject1).id);
                                    i = m;
                                    if (localObject1 != null)
                                    {
                                      localObject2 = ((List)this.this$0.this$0.getDataList()).iterator();
                                      i = 0;
                                      if (((Iterator)localObject2).hasNext())
                                      {
                                        localObject3 = (bo)((Iterator)localObject2).next();
                                        if (((localObject3 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject3).feedObject.getId() == paramAnonymoushn.dLW.id))
                                        {
                                          j = 1;
                                          if (j == 0) {
                                            break label471;
                                          }
                                        }
                                      }
                                      for (j = i;; j = -1)
                                      {
                                        i = i2;
                                        if (j != -1)
                                        {
                                          this.this$0.this$0.getDataList().set(j, this.this$0.this$0.transformFinderObj((FinderItem)localObject1));
                                          this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, Integer.valueOf(1));
                                          i = 1;
                                        }
                                        localObject1 = kotlin.x.SXb;
                                        break;
                                        j = 0;
                                        break label396;
                                        i += 1;
                                        break label339;
                                      }
                                      i = m;
                                      if (paramAnonymoushn.dLW.id != 0L)
                                      {
                                        localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                                        i = 0;
                                        if (((Iterator)localObject1).hasNext())
                                        {
                                          localObject2 = (bo)((Iterator)localObject1).next();
                                          if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushn.dLW.id))
                                          {
                                            j = 1;
                                            if (j == 0) {
                                              break label639;
                                            }
                                          }
                                        }
                                        for (j = i;; j = -1)
                                        {
                                          i = m;
                                          if (j == -1) {
                                            break;
                                          }
                                          localObject1 = this.this$0.this$0.getDataList().get(j);
                                          if (localObject1 != null) {
                                            break label651;
                                          }
                                          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                                          AppMethodBeat.o(244541);
                                          throw ((Throwable)localObject1);
                                          j = 0;
                                          break label580;
                                          i += 1;
                                          break label523;
                                        }
                                        localObject1 = (BaseFinderFeed)localObject1;
                                        if (paramAnonymoushn.dLW.dLY == 1)
                                        {
                                          i = paramAnonymoushn.dLW.dLZ;
                                          k = ((BaseFinderFeed)localObject1).feedObject.getLikeFlag();
                                          Log.i(this.this$0.this$0.getTAG(), "TYPE_FEED_LIKE_CHANGED oldFlag:" + k + ", newFlag:" + i);
                                          if (k != i)
                                          {
                                            ((BaseFinderFeed)localObject1).feedObject.setLikeFlag(i);
                                            if (k != 0) {
                                              break label846;
                                            }
                                            localObject2 = ((BaseFinderFeed)localObject1).feedObject;
                                            ((FinderItem)localObject2).setLikeCount(((FinderItem)localObject2).getLikeCount() + 1);
                                            if (i != 1) {
                                              break label872;
                                            }
                                            localObject2 = ((BaseFinderFeed)localObject1).feedObject;
                                            ((FinderItem)localObject2).setFriendLikeCount(((FinderItem)localObject2).getFriendLikeCount() + 1);
                                            localObject2 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
                                            com.tencent.mm.plugin.finder.upload.action.j.dBt();
                                            com.tencent.mm.plugin.finder.upload.action.j.aG(((BaseFinderFeed)localObject1).feedObject.getLikeList());
                                            this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(3), Integer.valueOf(1)));
                                          }
                                        }
                                        for (;;)
                                        {
                                          i = 1;
                                          break;
                                          if (i != 0) {
                                            break label767;
                                          }
                                          localObject2 = ((BaseFinderFeed)localObject1).feedObject;
                                          ((FinderItem)localObject2).setLikeCount(((FinderItem)localObject2).getLikeCount() - 1);
                                          break label767;
                                          if (k != 1) {
                                            break label811;
                                          }
                                          localObject2 = ((BaseFinderFeed)localObject1).feedObject;
                                          ((FinderItem)localObject2).setFriendLikeCount(((FinderItem)localObject2).getFriendLikeCount() - 1);
                                          localObject2 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
                                          com.tencent.mm.plugin.finder.upload.action.j.dBt();
                                          com.tencent.mm.plugin.finder.upload.action.j.aI(((BaseFinderFeed)localObject1).feedObject.getLikeList());
                                          break label811;
                                          this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(3), Integer.valueOf(1)));
                                        }
                                        i = m;
                                        if (paramAnonymoushn.dLW.id != 0L)
                                        {
                                          localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                                          i = 0;
                                          if (((Iterator)localObject1).hasNext())
                                          {
                                            localObject2 = (bo)((Iterator)localObject1).next();
                                            if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushn.dLW.id))
                                            {
                                              j = 1;
                                              if (j == 0) {
                                                break label1124;
                                              }
                                              j = i;
                                              if (paramAnonymoushn.dLW.dLX != 1) {
                                                break label1136;
                                              }
                                            }
                                          }
                                          for (k = 1;; k = 0)
                                          {
                                            i = m;
                                            if (j == -1) {
                                              break;
                                            }
                                            localObject1 = this.this$0.this$0.getDataList().get(j);
                                            if (localObject1 != null) {
                                              break label1141;
                                            }
                                            localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                                            AppMethodBeat.o(244541);
                                            throw ((Throwable)localObject1);
                                            j = 0;
                                            break label1049;
                                            i += 1;
                                            break label992;
                                            j = -1;
                                            break label1055;
                                          }
                                          localObject1 = (BaseFinderFeed)localObject1;
                                          i = n;
                                          if (((BaseFinderFeed)localObject1).feedObject.getFavFlag() != k) {
                                            i = 1;
                                          }
                                          if (paramAnonymoushn.dLW.dLY == 1) {
                                            ((BaseFinderFeed)localObject1).feedObject.setFavFlag(k);
                                          }
                                          if (i != 0) {
                                            this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(4), Integer.valueOf(1)));
                                          }
                                          i = 1;
                                        }
                                      }
                                    }
                                  }
                                }
                                i = m;
                              } while (paramAnonymoushn.dLW.id == 0L);
                              localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                              i = 0;
                              if (((Iterator)localObject1).hasNext())
                              {
                                localObject2 = (bo)((Iterator)localObject1).next();
                                if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushn.dLW.id))
                                {
                                  j = 1;
                                  if (j == 0) {
                                    break label1378;
                                  }
                                }
                              }
                              for (j = i;; j = -1)
                              {
                                i = m;
                                if (j == -1) {
                                  break;
                                }
                                this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(5), Integer.valueOf(1)));
                                i = 1;
                                break;
                                j = 0;
                                break label1324;
                                i += 1;
                                break label1267;
                              }
                              i = m;
                            } while (paramAnonymoushn.dLW.id == 0L);
                            localObject1 = this.this$0.$contextObj;
                            if ((localObject1 != null) && (((bbn)localObject1).tCE == 17)) {
                              break;
                            }
                            localObject1 = this.this$0.$contextObj;
                            if ((localObject1 != null) && (((bbn)localObject1).tCE == 18)) {
                              break;
                            }
                            localObject1 = this.this$0.$contextObj;
                            if ((localObject1 != null) && (((bbn)localObject1).tCE == 20)) {
                              break;
                            }
                            localObject1 = this.this$0.$contextObj;
                            if ((localObject1 != null) && (((bbn)localObject1).tCE == 16)) {
                              break;
                            }
                            localObject1 = this.this$0.$contextObj;
                            if ((localObject1 != null) && (((bbn)localObject1).tCE == 6)) {
                              break;
                            }
                            localObject1 = this.this$0.$contextObj;
                            if ((localObject1 != null) && (((bbn)localObject1).tCE == 27)) {
                              break;
                            }
                            localObject1 = this.this$0.$contextObj;
                            if ((localObject1 != null) && (((bbn)localObject1).tCE == 9)) {
                              break;
                            }
                            localObject1 = this.this$0.$contextObj;
                            i = m;
                          } while (localObject1 == null);
                          i = m;
                        } while (((bbn)localObject1).tCE != 25);
                        localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                        i = 0;
                        if (!((Iterator)localObject1).hasNext()) {
                          break label1820;
                        }
                        localObject2 = (bo)((Iterator)localObject1).next();
                        if ((!(localObject2 instanceof BaseFinderFeed)) || (((BaseFinderFeed)localObject2).feedObject.getId() != paramAnonymoushn.dLW.id)) {
                          break;
                        }
                        j = 1;
                        if (j == 0) {
                          break label1813;
                        }
                        j = i;
                        i = m;
                      } while (j == -1);
                      localObject1 = (bo)this.this$0.this$0.getDataList().get(j);
                      i = i1;
                      boolean bool2;
                      if ((localObject1 instanceof BaseFinderFeed))
                      {
                        bool2 = ((BaseFinderFeed)localObject1).showCommentEdu;
                        if (paramAnonymoushn.dLW.dLY != 1) {
                          break label1825;
                        }
                      }
                      for (boolean bool1 = true;; bool1 = false)
                      {
                        i = i1;
                        if (bool2 != bool1) {
                          i = 1;
                        }
                        if (i != 0) {
                          this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(6), paramAnonymoushn));
                        }
                        i = 1;
                        break;
                        j = 0;
                        break label1685;
                        i += 1;
                        break label1628;
                        j = -1;
                        break label1691;
                      }
                      Log.i(this.this$0.this$0.getTAG(), "FeedUpdateEvent TYPE_ACTIVITY_REMOVED id:" + paramAnonymoushn.dLW.id + ",username:" + paramAnonymoushn.dLW.username + ",liveStaus:" + paramAnonymoushn.dLW.liveStatus);
                      i = m;
                    } while (paramAnonymoushn.dLW.id == 0L);
                    localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                    i = 0;
                    if (((Iterator)localObject1).hasNext())
                    {
                      localObject2 = (bo)((Iterator)localObject1).next();
                      if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushn.dLW.id))
                      {
                        j = 1;
                        if (j == 0) {
                          break label2064;
                        }
                      }
                    }
                    for (j = i;; j = -1)
                    {
                      i = m;
                      if (j == -1) {
                        break;
                      }
                      localObject1 = this.this$0.this$0.getDataList().get(j);
                      if (localObject1 != null) {
                        break label2076;
                      }
                      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                      AppMethodBeat.o(244541);
                      throw ((Throwable)localObject1);
                      j = 0;
                      break label2005;
                      i += 1;
                      break label1948;
                    }
                    localObject1 = (BaseFinderFeed)localObject1;
                    if (paramAnonymoushn.dLW.dLY == 1)
                    {
                      localObject2 = ((BaseFinderFeed)localObject1).feedObject.getFeedObject().objectDesc;
                      if (localObject2 != null) {
                        ((FinderObjectDesc)localObject2).event = null;
                      }
                      this.this$0.this$0.dispatcher().IN(j);
                      BaseFinderFeedLoader.access$updateFinderPageItem(this.this$0.this$0, (BaseFinderFeed)localObject1);
                    }
                    for (;;)
                    {
                      i = 1;
                      break;
                      this.this$0.this$0.dispatcher().IN(j);
                    }
                    Log.i(this.this$0.this$0.getTAG(), "FeedUpdateEvent TYPE_ACTIVITY_ANTI_SPAM id:" + paramAnonymoushn.dLW.id);
                    i = m;
                  } while (paramAnonymoushn.dLW.id == 0L);
                  localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                  i = 0;
                  if (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (bo)((Iterator)localObject1).next();
                    if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushn.dLW.id))
                    {
                      j = 1;
                      if (j == 0) {
                        break label2364;
                      }
                    }
                  }
                  for (j = i;; j = -1)
                  {
                    i = m;
                    if (j == -1) {
                      break;
                    }
                    localObject1 = this.this$0.this$0.getDataList().get(j);
                    if (localObject1 != null) {
                      break label2376;
                    }
                    localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                    AppMethodBeat.o(244541);
                    throw ((Throwable)localObject1);
                    j = 0;
                    break label2305;
                    i += 1;
                    break label2248;
                  }
                  localObject1 = (BaseFinderFeed)localObject1;
                  if (paramAnonymoushn.dLW.dLY == 1)
                  {
                    localObject2 = ((BaseFinderFeed)localObject1).feedObject.getFeedObject().objectDesc;
                    if (localObject2 != null)
                    {
                      localObject2 = ((FinderObjectDesc)localObject2).event;
                      if (localObject2 != null)
                      {
                        ((azs)localObject2).eventName = "";
                        ((azs)localObject2).LJx = "";
                        Log.i(this.this$0.this$0.getTAG(), "TYPE_ACTIVITY_ANTI_SPAM value changed");
                        localObject2 = kotlin.x.SXb;
                      }
                    }
                    this.this$0.this$0.dispatcher().IN(j);
                    BaseFinderFeedLoader.access$updateFinderPageItem(this.this$0.this$0, (BaseFinderFeed)localObject1);
                  }
                  for (;;)
                  {
                    i = 1;
                    break;
                    this.this$0.this$0.dispatcher().IN(j);
                  }
                  Log.i(this.this$0.this$0.getTAG(), "FeedUpdateEvent TYPE_LIVE_CHANGE id:" + paramAnonymoushn.dLW.id + ",username:" + paramAnonymoushn.dLW.username + ",liveStaus:" + paramAnonymoushn.dLW.liveStatus);
                  i = m;
                } while (paramAnonymoushn.dLW.id == 0L);
                i = m;
              } while (paramAnonymoushn.dLW.dLY != 1);
              label872:
              label1136:
              label1141:
              localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
              label992:
              label1124:
              label1267:
              i = 0;
              label1378:
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (bo)((Iterator)localObject1).next();
                if ((localObject2 instanceof w))
                {
                  localObject2 = ((w)localObject2).feedObject.getLiveInfo();
                  if ((localObject2 != null) && (((awe)localObject2).liveId == paramAnonymoushn.dLW.id))
                  {
                    j = 1;
                    if (j == 0) {
                      break label3094;
                    }
                    if (i < 0) {
                      break label4560;
                    }
                    localObject2 = (bo)this.this$0.this$0.getDataList().get(i);
                    localObject1 = localObject2;
                    if (!(localObject2 instanceof w)) {
                      localObject1 = null;
                    }
                    localObject1 = (w)localObject1;
                    if (localObject1 != null)
                    {
                      localObject1 = ((BaseFinderFeed)localObject1).feedObject.getLiveInfo();
                      if (localObject1 != null) {
                        ((awe)localObject1).liveStatus = paramAnonymoushn.dLW.liveStatus;
                      }
                      this.this$0.this$0.dispatcher().IN(i);
                      localObject1 = kotlin.x.SXb;
                    }
                  }
                }
              }
              label1628:
              break;
            }
            label523:
            label651:
            label811:
            label1324:
            label2248:
            label2376:
            label4552:
            label4557:
            label4560:
            for (i = 1;; i = 0)
            {
              localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
              j = 0;
              if (((Iterator)localObject1).hasNext()) {
                if (((bo)((Iterator)localObject1).next() instanceof com.tencent.mm.plugin.finder.model.x)) {
                  if (j >= 0)
                  {
                    localObject1 = (bo)this.this$0.this$0.getDataList().get(j);
                    if ((localObject1 instanceof com.tencent.mm.plugin.finder.model.x))
                    {
                      i = ((com.tencent.mm.plugin.finder.model.x)localObject1).getIndex(paramAnonymoushn.dLW.id);
                      if (i >= 0)
                      {
                        if (paramAnonymoushn.dLW.liveStatus != 2) {
                          break label3118;
                        }
                        localObject1 = (com.tencent.mm.plugin.finder.model.y)((com.tencent.mm.plugin.finder.model.x)localObject1).dtS.remove(i);
                        this.this$0.this$0.dispatcher().IN(j);
                        localObject2 = this.this$0.this$0.getTAG();
                        localObject3 = new StringBuilder("FeedUpdateEvent nickname:");
                        if (localObject1 == null) {
                          break label3198;
                        }
                        localObject1 = ((com.tencent.mm.plugin.finder.model.y)localObject1).uOo;
                        if (localObject1 == null) {
                          break label3198;
                        }
                        localObject1 = ((FinderObject)localObject1).contact;
                        if (localObject1 == null) {
                          break label3198;
                        }
                      }
                    }
                  }
                }
              }
              label3198:
              for (localObject1 = ((FinderContact)localObject1).nickname;; localObject1 = null)
              {
                Log.i((String)localObject2, (String)localObject1 + ", live status:" + paramAnonymoushn.dLW.liveStatus);
                i = 1;
                localObject2 = paramAnonymoushn.dLW.username;
                if (!Util.isNullOrNil((String)localObject2)) {
                  break label3204;
                }
                AppMethodBeat.o(244541);
                return;
                j = 0;
                break label2715;
                i += 1;
                break;
                i = -1;
                break label2719;
                j += 1;
                break label2842;
                j = -1;
                break label2868;
                localObject2 = (com.tencent.mm.plugin.finder.model.y)((com.tencent.mm.plugin.finder.model.x)localObject1).dtS.get(i);
                localObject1 = localObject2;
                if (localObject2 == null) {
                  break label2953;
                }
                localObject3 = ((com.tencent.mm.plugin.finder.model.y)localObject2).uOo;
                localObject1 = localObject2;
                if (localObject3 == null) {
                  break label2953;
                }
                localObject3 = ((FinderObject)localObject3).liveInfo;
                localObject1 = localObject2;
                if (localObject3 == null) {
                  break label2953;
                }
                ((awe)localObject3).liveStatus = paramAnonymoushn.dLW.liveStatus;
                localObject1 = localObject2;
                break label2953;
              }
              localObject3 = ((Iterable)this.this$0.this$0.getDataList()).iterator();
              j = k;
              Object localObject4;
              label3289:
              Object localObject5;
              Object localObject6;
              if (((Iterator)localObject3).hasNext())
              {
                localObject1 = ((Iterator)localObject3).next();
                if (j < 0) {
                  kotlin.a.j.hxH();
                }
                localObject4 = (bo)localObject1;
                if (!(localObject4 instanceof BaseFinderFeed)) {
                  break label4557;
                }
                localObject1 = ((BaseFinderFeed)localObject4).contact;
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).getUsername();
                  if (!p.j(localObject1, localObject2)) {
                    break label4557;
                  }
                  localObject1 = ((BaseFinderFeed)localObject4).contact;
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.plugin.finder.api.g)localObject1).field_liveStatus = paramAnonymoushn.dLW.liveStatus;
                    localObject1 = kotlin.x.SXb;
                  }
                  localObject1 = ((BaseFinderFeed)localObject4).feedObject.getFeedObject().contact;
                  if (localObject1 != null)
                  {
                    ((FinderContact)localObject1).liveStatus = paramAnonymoushn.dLW.liveStatus;
                    localObject1 = kotlin.x.SXb;
                  }
                  this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(7), paramAnonymoushn));
                  BaseFinderFeedLoader.access$updateFinderPageItem(this.this$0.this$0, (BaseFinderFeed)localObject4);
                  localObject5 = this.this$0.this$0.getTAG();
                  localObject6 = new StringBuilder("FeedUpdateEvent TYPE_LIVE_CHANGE username:").append((String)localObject2).append(",nickname:");
                  localObject1 = ((BaseFinderFeed)localObject4).contact;
                  if (localObject1 == null) {
                    break label3543;
                  }
                  localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).getNickname();
                  Log.i((String)localObject5, (String)localObject1 + ",feed id:" + ((bo)localObject4).lT() + ",live status:" + paramAnonymoushn.dLW.liveStatus);
                  i = 1;
                }
              }
              for (;;)
              {
                j += 1;
                break label3226;
                localObject1 = null;
                break label3289;
                label3543:
                localObject1 = null;
                break label3478;
                break;
                Log.i(this.this$0.this$0.getTAG(), "FeedUpdateEvent TYPE_LIVE_STREAM_CHANGE id:" + paramAnonymoushn.dLW.id + ",feedList:" + paramAnonymoushn.dLW.dMc + ",liveStaus:" + paramAnonymoushn.dLW.liveStatus + ",username:" + paramAnonymoushn.dLW.username);
                if (paramAnonymoushn.dLW.dLY == 1)
                {
                  localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                  i = 0;
                  if (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (bo)((Iterator)localObject1).next();
                    if (((localObject2 instanceof com.tencent.mm.plugin.finder.model.x)) && (((com.tencent.mm.plugin.finder.model.x)localObject2).uOl == paramAnonymoushn.dLW.id))
                    {
                      j = 1;
                      if (j == 0) {
                        break label4243;
                      }
                      if (i < 0) {
                        break label4552;
                      }
                      localObject2 = (bo)this.this$0.this$0.getDataList().get(i);
                      localObject1 = localObject2;
                      if (!(localObject2 instanceof com.tencent.mm.plugin.finder.model.x)) {
                        localObject1 = null;
                      }
                      if ((com.tencent.mm.plugin.finder.model.x)localObject1 != null)
                      {
                        this.this$0.this$0.dispatcher().onItemRangeChanged(i, 1, Integer.valueOf(2));
                        localObject1 = kotlin.x.SXb;
                      }
                    }
                  }
                }
                for (i = 1;; i = 0)
                {
                  localObject1 = com.tencent.mm.plugin.finder.model.d.uNN;
                  localObject1 = paramAnonymoushn.dLW.username;
                  p.g(localObject1, "event.data.username");
                  localObject2 = ((Iterable)d.a.auh((String)localObject1)).iterator();
                  for (;;)
                  {
                    if (!((Iterator)localObject2).hasNext()) {
                      break label4276;
                    }
                    localObject3 = (String)((Iterator)localObject2).next();
                    localObject4 = ((Iterable)this.this$0.this$0.getDataList()).iterator();
                    j = 0;
                    if (((Iterator)localObject4).hasNext())
                    {
                      localObject1 = ((Iterator)localObject4).next();
                      if (j < 0) {
                        kotlin.a.j.hxH();
                      }
                      localObject5 = (bo)localObject1;
                      label3947:
                      StringBuilder localStringBuilder;
                      if (((CharSequence)localObject3).length() > 0)
                      {
                        m = 1;
                        k = i;
                        if (m != 0)
                        {
                          k = i;
                          if ((localObject5 instanceof BaseFinderFeed))
                          {
                            localObject1 = ((BaseFinderFeed)localObject5).contact;
                            if (localObject1 == null) {
                              break label4261;
                            }
                            localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).getUsername();
                            k = i;
                            if (p.j(localObject1, localObject3))
                            {
                              localObject1 = ((BaseFinderFeed)localObject5).contact;
                              if (localObject1 != null)
                              {
                                ((com.tencent.mm.plugin.finder.api.g)localObject1).field_liveStatus = paramAnonymoushn.dLW.liveStatus;
                                localObject1 = kotlin.x.SXb;
                              }
                              localObject1 = ((BaseFinderFeed)localObject5).feedObject.getFeedObject().contact;
                              if (localObject1 != null)
                              {
                                ((FinderContact)localObject1).liveStatus = paramAnonymoushn.dLW.liveStatus;
                                localObject1 = kotlin.x.SXb;
                              }
                              this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(7), paramAnonymoushn));
                              BaseFinderFeedLoader.access$updateFinderPageItem(this.this$0.this$0, (BaseFinderFeed)localObject5);
                              localObject6 = this.this$0.this$0.getTAG();
                              localStringBuilder = new StringBuilder("FeedUpdateEvent username:").append((String)localObject3).append(",nickname:");
                              localObject1 = ((BaseFinderFeed)localObject5).contact;
                              if (localObject1 == null) {
                                break label4267;
                              }
                            }
                          }
                        }
                      }
                      for (localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).getNickname();; localObject1 = null)
                      {
                        Log.i((String)localObject6, (String)localObject1 + ",feed id:" + ((bo)localObject5).lT() + ",live status:" + paramAnonymoushn.dLW.liveStatus);
                        k = 1;
                        j += 1;
                        i = k;
                        break label3898;
                        j = 0;
                        break label3738;
                        i += 1;
                        break;
                        i = -1;
                        break label3742;
                        m = 0;
                        break label3947;
                        localObject1 = null;
                        break label3986;
                      }
                    }
                  }
                  break;
                  localObject1 = f.tWl;
                  localObject1 = paramAnonymoushn.dLW.username;
                  p.g(localObject1, "event.data.username");
                  p.h(localObject1, "str");
                  localObject2 = ((Iterable)n.b((CharSequence)localObject1, new String[] { "," })).iterator();
                  i = m;
                  if (!((Iterator)localObject2).hasNext()) {
                    break;
                  }
                  localObject3 = (String)((Iterator)localObject2).next();
                  localObject4 = ((Iterable)this.this$0.this$0.getDataList()).iterator();
                  i = 0;
                  if (((Iterator)localObject4).hasNext())
                  {
                    localObject1 = ((Iterator)localObject4).next();
                    if (i < 0) {
                      kotlin.a.j.hxH();
                    }
                    localObject1 = (bo)localObject1;
                    if (((CharSequence)localObject3).length() <= 0) {
                      break label4541;
                    }
                    j = 1;
                    label4435:
                    if ((j != 0) && ((localObject1 instanceof BaseFinderFeed)))
                    {
                      localObject1 = ((BaseFinderFeed)localObject1).contact;
                      if (localObject1 == null) {
                        break label4546;
                      }
                    }
                  }
                  for (localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).getUsername();; localObject1 = null)
                  {
                    if (p.j(localObject1, localObject3))
                    {
                      this.this$0.this$0.dispatcher().onItemRangeChanged(i, 1, new o(Integer.valueOf(8), paramAnonymoushn));
                      Log.i(this.this$0.this$0.getTAG(), "TYPE_FEED_LIVE_NOTICE username:".concat(String.valueOf(localObject3)));
                    }
                    i += 1;
                    break label4387;
                    break;
                    j = 0;
                    break label4435;
                  }
                }
              }
            }
          }
        });
        AppMethodBeat.o(244542);
        return false;
      }
    };
  }
  
  private final void updateFinderPageItem(BaseFinderFeed paramBaseFinderFeed)
  {
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(Integer.valueOf(getPageName()));
    ((ArrayList)localObject1).addAll((Collection)colletExtraPageName());
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      int i = ((Number)((Iterator)localObject1).next()).intValue();
      if (i >= 0)
      {
        Object localObject2 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
        long l = paramBaseFinderFeed.lT();
        localObject2 = paramBaseFinderFeed.feedObject.getFeedObject();
        p.h(localObject2, "item");
        Log.i("Finder.FinderPage", "updatePageData pageName:" + i + ", svrId:" + l);
        if (i >= 0) {
          try
          {
            l.a.Lf(i);
            Object localObject3 = com.tencent.mm.plugin.finder.storage.data.l.dyD().Lg(i).vFP.zns;
            if (localObject3 != null)
            {
              localObject3 = (arl)kotlin.a.j.L((List)localObject3, 0);
              if (localObject3 != null)
              {
                localObject3 = ((arl)localObject3).gCs;
                if (localObject3 != null)
                {
                  i locali = i.vGl;
                  if (i.a(l, (FinderObject)localObject2, (LinkedList)localObject3))
                  {
                    localObject2 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                    l.a.a(com.tencent.mm.plugin.finder.storage.data.l.dyD().Lg(i));
                  }
                }
              }
            }
          }
          catch (Throwable localThrowable)
          {
            if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
              throw localThrowable;
            }
            Log.printErrStackTrace("Finder.FinderPage", localThrowable, "updatePageData ".concat(String.valueOf(i)), new Object[0]);
          }
        }
      }
    }
  }
  
  public void addRvFeed(int paramInt, bo parambo)
  {
    p.h(parambo, "feed");
    getDataList().add(paramInt, parambo);
  }
  
  public List<Integer> colletExtraPageName()
  {
    return (List)new ArrayList();
  }
  
  protected final bo getItem(long paramLong)
  {
    Iterator localIterator = ((List)getDataList()).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((bo)localIterator.next()).lT() == paramLong)
      {
        j = 1;
        label49:
        if (j == 0) {
          break label88;
        }
      }
    }
    for (;;)
    {
      if ((i == -1) || (i >= getDataList().size())) {
        break label100;
      }
      return (bo)getDataList().get(i);
      j = 0;
      break label49;
      label88:
      i += 1;
      break;
      i = -1;
    }
    label100:
    return null;
  }
  
  public int getPageName()
  {
    return -1;
  }
  
  public int insert(bo parambo, int paramInt, boolean paramBoolean)
  {
    p.h(parambo, "feed");
    int i = getDataList().indexOf(parambo);
    if (i == paramInt) {}
    do
    {
      do
      {
        return paramInt;
        if (i >= 0) {
          getDataList().remove(parambo);
        }
      } while (paramInt < 0);
      addRvFeed(paramInt, parambo);
    } while (!paramBoolean);
    dispatcher().onItemRangeRemoved(paramInt, 1);
    return paramInt;
  }
  
  public boolean interceptMvFeed()
  {
    return false;
  }
  
  public boolean interceptMvPostStart()
  {
    return true;
  }
  
  public boolean interceptPostStart()
  {
    return false;
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
      g.a locala = com.tencent.mm.plugin.finder.upload.g.vSJ;
      com.tencent.mm.plugin.finder.upload.g.dBa().a((com.tencent.mm.plugin.finder.upload.q)this);
    }
    this.feedDeleteListener.alive();
    this.feedChangeListener.alive();
  }
  
  public void onDataChanged() {}
  
  public void onDead()
  {
    super.onDead();
    if (isObservePostEvent())
    {
      g.a locala = com.tencent.mm.plugin.finder.upload.g.vSJ;
      com.tencent.mm.plugin.finder.upload.g.dBa().b((com.tencent.mm.plugin.finder.upload.q)this);
    }
    this.feedDeleteListener.dead();
    this.feedChangeListener.dead();
  }
  
  public void onFetchDone(IResponse paramIResponse)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.axR());
    super.onFetchDone(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
  }
  
  public void onMvPostStart(FinderItem paramFinderItem)
  {
    p.h(paramFinderItem, "item");
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
    BaseFinderFeed localBaseFinderFeed = updateItem(paramLong1, paramLong2);
    if (localBaseFinderFeed != null) {
      localBaseFinderFeed.isFinishPostSoon = true;
    }
  }
  
  public void onPostStart(long paramLong)
  {
    onPostStart(paramLong, false);
  }
  
  public void onPostStart(final long paramLong, boolean paramBoolean)
  {
    onDataChanged();
    if (interceptPostStart()) {}
    Object localObject;
    final ArrayList localArrayList;
    BaseFinderFeed localBaseFinderFeed;
    do
    {
      do
      {
        return;
        localObject = c.vGN;
        localObject = c.a.FS(paramLong);
      } while (localObject == null);
      localArrayList = new ArrayList();
      localBaseFinderFeed = transformFinderObj((FinderItem)localObject);
    } while ((localBaseFinderFeed.feedObject.isMvFeed()) && (interceptMvPostStart()));
    Log.i(getTAG(), "onPostStart localId " + paramLong + " feed " + localBaseFinderFeed);
    com.tencent.mm.plugin.finder.utils.y localy = com.tencent.mm.plugin.finder.utils.y.vXH;
    if (!com.tencent.mm.plugin.finder.utils.y.dnv()) {}
    for (boolean bool = true;; bool = false)
    {
      localBaseFinderFeed.showLikeTips = bool;
      localBaseFinderFeed.showShareSns = paramBoolean;
      if (!(kotlin.a.j.kt((List)getDataList()) instanceof com.tencent.mm.plugin.finder.model.x)) {
        break;
      }
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new kotlin.g.b.q(localBaseFinderFeed)
      {
        public final void invoke()
        {
          AppMethodBeat.i(244546);
          jdField_this.getDataList().add(1, this.$feed$inlined);
          jdField_this.dispatcher().onItemRangeInserted(1, 1);
          AppMethodBeat.o(244546);
        }
      });
      return;
    }
    localArrayList.add(localBaseFinderFeed);
    com.tencent.mm.plugin.finder.feed.model.internal.b.mergeDataAndNotify$default(getMerger(), 2, (List)localArrayList, true, null, 8, null);
  }
  
  public final int remove(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = ((List)getDataList()).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((bo)localIterator.next()).lT() == paramLong)
      {
        j = 1;
        label50:
        if (j == 0) {
          break label103;
        }
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        p.g(getDataList().remove(i), "dataList.removeAt(index)");
        if (paramBoolean)
        {
          dispatcher().onItemRangeRemoved(i, 1);
          onDataChanged();
        }
      }
      return i;
      j = 0;
      break label50;
      label103:
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
      bo localbo = (bo)localIterator.next();
      if (((localbo instanceof BaseFinderFeed)) && (((BaseFinderFeed)localbo).feedObject.getLocalId() == paramLong))
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
        p.g(getDataList().remove(i), "dataList.removeAt(index)");
        if (paramBoolean) {
          dispatcher().onItemRangeRemoved(i, 1);
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
  
  public BaseFinderFeed transformFinderObj(FinderItem paramFinderItem)
  {
    p.h(paramFinderItem, "feedObj");
    c.a locala = c.vGN;
    return c.a.s(paramFinderItem);
  }
  
  public BaseFinderFeed transformToMusicData(FinderItem paramFinderItem)
  {
    p.h(paramFinderItem, "item");
    return transformFinderObj(paramFinderItem);
  }
  
  public final int updateByLocalId(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean)
  {
    p.h(paramBaseFinderFeed, "newFeed");
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
        break label231;
      }
      Object localObject = localIterator.next();
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localObject = (bo)localObject;
      if (((localObject instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject).feedObject.getLocalId() == paramBaseFinderFeed.feedObject.getLocalId()))
      {
        paramBaseFinderFeed.showLikeTips = ((BaseFinderFeed)localObject).showLikeTips;
        paramBaseFinderFeed.showShareSns = ((BaseFinderFeed)localObject).showShareSns;
        getDataList().set(i, paramBaseFinderFeed);
        j = i;
        if (!paramBoolean) {
          break;
        }
        Log.i(getTAG(), "updateByLocalId " + paramBaseFinderFeed.feedObject.getLocalId());
        if (interceptMvFeed())
        {
          dispatcher().onItemRangeChanged(i, 1, new o(Integer.valueOf(20), Integer.valueOf(1)));
          return i;
        }
        dispatcher().onItemRangeChanged(i, 1, Integer.valueOf(1));
        return i;
      }
      i += 1;
    }
    label231:
    return -1;
  }
  
  protected final BaseFinderFeed updateItem(long paramLong1, long paramLong2)
  {
    Object localObject = e.vFX;
    localObject = e.a.Fy(paramLong2);
    if (localObject != null) {
      ((FinderItem)localObject).setLocalId(paramLong1);
    }
    if (localObject != null)
    {
      Log.i(getTAG(), "updateItem localId:" + paramLong1 + " itemLoadId:" + ((FinderItem)localObject).getLocalId() + " itemId:" + ((FinderItem)localObject).getId());
      localObject = transformFinderObj((FinderItem)localObject);
      updateByLocalId((BaseFinderFeed)localObject, true);
      return localObject;
    }
    return null;
  }
  
  protected final void updateItem(long paramLong)
  {
    Object localObject = c.vGN;
    localObject = c.a.FS(paramLong);
    if (localObject != null)
    {
      Log.i(getTAG(), "updateItem localId:" + paramLong + " itemLoadId:" + ((FinderItem)localObject).getLocalId() + " itemId:" + ((FinderItem)localObject).getId());
      updateByLocalId(transformFinderObj((FinderItem)localObject), true);
    }
  }
  
  public final void updateProgressByLocalId(final long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new kotlin.g.b.q(paramLong)
    {
      public final void invoke()
      {
        AppMethodBeat.i(244548);
        Iterator localIterator = ((Iterable)this.this$0.getDataList()).iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          Object localObject1 = localIterator.next();
          if (i < 0) {
            kotlin.a.j.hxH();
          }
          localObject1 = (bo)localObject1;
          if (((localObject1 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject1).feedObject.getLocalId() == paramLong))
          {
            Object localObject2 = c.vGN;
            Object localObject3 = c.a.FS(paramLong);
            if (localObject3 != null)
            {
              boolean bool = ((BaseFinderFeed)localObject1).showLikeTips;
              localObject2 = this.this$0.getDataList();
              localObject3 = this.this$0.transformFinderObj((FinderItem)localObject3);
              ((BaseFinderFeed)localObject3).showLikeTips = bool;
              ((BaseFinderFeed)localObject3).showShareSns = ((BaseFinderFeed)localObject1).showShareSns;
              ((DataBuffer)localObject2).set(i, localObject3);
            }
            Log.i(this.this$0.getTAG(), "updateProgressByLoalId " + ((BaseFinderFeed)localObject1).feedObject.getLocalId());
            this.this$0.dispatcher().onItemRangeChanged(i, 1, new o(Integer.valueOf(2), Integer.valueOf(1)));
          }
          i += 1;
        }
        AppMethodBeat.o(244548);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
 * JD-Core Version:    0.7.0.1
 */