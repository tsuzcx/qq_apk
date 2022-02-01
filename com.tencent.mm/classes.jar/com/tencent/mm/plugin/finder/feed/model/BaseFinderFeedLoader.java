package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hn;
import com.tencent.mm.f.a.hn.a;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.f.a.hu.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.d.a;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.h;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.upload.g.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ath;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "feedChangeListener", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1;", "feedDeleteListener", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1;", "addRvFeed", "", "index", "", "feed", "colletExtraPageName", "", "getItem", "feedId", "", "getPageName", "insert", "notify", "", "insertAll", "feeds", "interceptMvFeed", "interceptMvPostStart", "interceptPostStart", "isObservePostEvent", "onAlive", "onDataChanged", "onDead", "onMvPostStart", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "onPostEnd", "localId", "isOk", "onPostNotify", "onPostOk", "svrID", "onPostStart", "isFromSns", "remove", "removeAll", "afterIndex", "removeByLocalId", "feedLocalId", "transformFinderObj", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedObj", "transformToMusicData", "updateByLocalId", "newFeed", "updateFinderPageItem", "updateItem", "svrId", "updateProgressByLocalId", "plugin-finder_release"})
public abstract class BaseFinderFeedLoader
  extends BaseFeedLoader<bu>
  implements com.tencent.mm.plugin.finder.upload.q
{
  private byte _hellAccFlag_;
  private final feedChangeListener.1 feedChangeListener;
  private final feedDeleteListener.1 feedDeleteListener = new IListener()
  {
    public final boolean callback(final hn paramAnonymoushn)
    {
      AppMethodBeat.i(288235);
      if (paramAnonymoushn != null) {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new kotlin.g.b.q(paramAnonymoushn)
        {
          public final void invoke()
          {
            AppMethodBeat.i(288678);
            if (paramAnonymoushn.fEy.fEz == 1)
            {
              AppMethodBeat.o(288678);
              return;
            }
            if (paramAnonymoushn.fEy.id != 0L)
            {
              this.this$0.this$0.remove(paramAnonymoushn.fEy.id, true);
              AppMethodBeat.o(288678);
              return;
            }
            this.this$0.this$0.removeByLocalId(paramAnonymoushn.fEy.localId, true);
            AppMethodBeat.o(288678);
          }
        });
      }
      AppMethodBeat.o(288235);
      return false;
    }
  };
  
  public BaseFinderFeedLoader()
  {
    this(null, 1, null);
  }
  
  public BaseFinderFeedLoader(final bid parambid)
  {
    super(parambid);
    this.feedChangeListener = new IListener()
    {
      public final boolean callback(final hu paramAnonymoushu)
      {
        AppMethodBeat.i(282567);
        kotlin.g.b.p.k(paramAnonymoushu, "event");
        com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new kotlin.g.b.q(paramAnonymoushu)
        {
          public final void invoke()
          {
            Object localObject2 = null;
            int i2 = 0;
            int n = 0;
            int i1 = 0;
            int k = 0;
            int m = 0;
            AppMethodBeat.i(288108);
            if (paramAnonymoushu.fEL.fEz == 1)
            {
              AppMethodBeat.o(288108);
              return;
            }
            Log.i(this.this$0.this$0.getTAG(), "feedChangeListener " + paramAnonymoushu.fEL.id + ",fav = " + paramAnonymoushu.fEL.fEM + ',' + "like = " + paramAnonymoushu.fEL.fEO + ",likeCount = " + paramAnonymoushu.fEL.likeCount + " ,needChangeData = " + paramAnonymoushu.fEL.fEN);
            int i = m;
            Object localObject1;
            label363:
            Object localObject3;
            int j;
            label420:
            label835:
            label1740:
            label1746:
            label2770:
            switch (paramAnonymoushu.fEL.type)
            {
            default: 
              i = m;
            case 1: 
            case 2: 
            case 3: 
            case 10: 
            case 14: 
            case 0: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 12: 
            case 13: 
            case 8: 
              label495:
              label1016:
              label1148:
              label2303:
              label2431:
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
                                  AppMethodBeat.o(288108);
                                  return;
                                  i = m;
                                  if (paramAnonymoushu.fEL.id != 0L)
                                  {
                                    localObject1 = e.AmW;
                                    localObject1 = paramAnonymoushu.fEL;
                                    if (localObject1 == null) {
                                      kotlin.g.b.p.iCn();
                                    }
                                    localObject1 = e.a.MH(((hu.a)localObject1).id);
                                    i = m;
                                    if (localObject1 != null)
                                    {
                                      localObject2 = ((List)this.this$0.this$0.getDataList()).iterator();
                                      i = 0;
                                      if (((Iterator)localObject2).hasNext())
                                      {
                                        localObject3 = (bu)((Iterator)localObject2).next();
                                        if (((localObject3 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject3).feedObject.getId() == paramAnonymoushu.fEL.id))
                                        {
                                          j = 1;
                                          if (j == 0) {
                                            break label495;
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
                                        localObject1 = kotlin.x.aazN;
                                        break;
                                        j = 0;
                                        break label420;
                                        i += 1;
                                        break label363;
                                      }
                                      i = m;
                                      if (paramAnonymoushu.fEL.id != 0L)
                                      {
                                        localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                                        i = 0;
                                        if (((Iterator)localObject1).hasNext())
                                        {
                                          localObject2 = (bu)((Iterator)localObject1).next();
                                          if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushu.fEL.id))
                                          {
                                            j = 1;
                                            if (j == 0) {
                                              break label663;
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
                                            break label675;
                                          }
                                          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                                          AppMethodBeat.o(288108);
                                          throw ((Throwable)localObject1);
                                          j = 0;
                                          break label604;
                                          i += 1;
                                          break label547;
                                        }
                                        localObject1 = (BaseFinderFeed)localObject1;
                                        if (paramAnonymoushu.fEL.fEN == 1)
                                        {
                                          i = paramAnonymoushu.fEL.fEO;
                                          k = ((BaseFinderFeed)localObject1).feedObject.getLikeFlag();
                                          Log.i(this.this$0.this$0.getTAG(), "TYPE_FEED_LIKE_CHANGED oldFlag:" + k + ", newFlag:" + i);
                                          if (k != i)
                                          {
                                            ((BaseFinderFeed)localObject1).feedObject.setLikeFlag(i);
                                            if (k != 0) {
                                              break label870;
                                            }
                                            localObject2 = ((BaseFinderFeed)localObject1).feedObject;
                                            ((FinderItem)localObject2).setLikeCount(((FinderItem)localObject2).getLikeCount() + 1);
                                            if (i != 1) {
                                              break label896;
                                            }
                                            localObject2 = ((BaseFinderFeed)localObject1).feedObject;
                                            ((FinderItem)localObject2).setFriendLikeCount(((FinderItem)localObject2).getFriendLikeCount() + 1);
                                            localObject2 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
                                            com.tencent.mm.plugin.finder.upload.action.l.ecG();
                                            com.tencent.mm.plugin.finder.upload.action.l.aX(((BaseFinderFeed)localObject1).feedObject.getLikeList());
                                            this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(3), Integer.valueOf(1)));
                                          }
                                        }
                                        for (;;)
                                        {
                                          i = 1;
                                          break;
                                          if (i != 0) {
                                            break label791;
                                          }
                                          localObject2 = ((BaseFinderFeed)localObject1).feedObject;
                                          ((FinderItem)localObject2).setLikeCount(((FinderItem)localObject2).getLikeCount() - 1);
                                          break label791;
                                          if (k != 1) {
                                            break label835;
                                          }
                                          localObject2 = ((BaseFinderFeed)localObject1).feedObject;
                                          ((FinderItem)localObject2).setFriendLikeCount(((FinderItem)localObject2).getFriendLikeCount() - 1);
                                          localObject2 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
                                          com.tencent.mm.plugin.finder.upload.action.l.ecG();
                                          com.tencent.mm.plugin.finder.upload.action.l.aZ(((BaseFinderFeed)localObject1).feedObject.getLikeList());
                                          break label835;
                                          this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(3), Integer.valueOf(1)));
                                        }
                                        i = m;
                                        if (paramAnonymoushu.fEL.id != 0L)
                                        {
                                          localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                                          i = 0;
                                          if (((Iterator)localObject1).hasNext())
                                          {
                                            localObject2 = (bu)((Iterator)localObject1).next();
                                            if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushu.fEL.id))
                                            {
                                              j = 1;
                                              if (j == 0) {
                                                break label1148;
                                              }
                                              j = i;
                                              if (paramAnonymoushu.fEL.fEM != 1) {
                                                break label1160;
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
                                              break label1165;
                                            }
                                            localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                                            AppMethodBeat.o(288108);
                                            throw ((Throwable)localObject1);
                                            j = 0;
                                            break label1073;
                                            i += 1;
                                            break label1016;
                                            j = -1;
                                            break label1079;
                                          }
                                          localObject1 = (BaseFinderFeed)localObject1;
                                          i = n;
                                          if (((BaseFinderFeed)localObject1).feedObject.getFavFlag() != k) {
                                            i = 1;
                                          }
                                          if (paramAnonymoushu.fEL.fEN == 1) {
                                            ((BaseFinderFeed)localObject1).feedObject.setFavFlag(k);
                                          }
                                          if (i != 0)
                                          {
                                            this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(4), Integer.valueOf(1)));
                                            this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(9), Integer.valueOf(1)));
                                          }
                                          i = 1;
                                        }
                                      }
                                    }
                                  }
                                }
                                i = m;
                              } while (paramAnonymoushu.fEL.id == 0L);
                              localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                              i = 0;
                              if (((Iterator)localObject1).hasNext())
                              {
                                localObject2 = (bu)((Iterator)localObject1).next();
                                if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushu.fEL.id))
                                {
                                  j = 1;
                                  if (j == 0) {
                                    break label1433;
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
                                break label1379;
                                i += 1;
                                break label1322;
                              }
                              i = m;
                            } while (paramAnonymoushu.fEL.id == 0L);
                            localObject1 = this.this$0.$contextObj;
                            if ((localObject1 != null) && (((bid)localObject1).xkX == 17)) {
                              break;
                            }
                            localObject1 = this.this$0.$contextObj;
                            if ((localObject1 != null) && (((bid)localObject1).xkX == 18)) {
                              break;
                            }
                            localObject1 = this.this$0.$contextObj;
                            if ((localObject1 != null) && (((bid)localObject1).xkX == 20)) {
                              break;
                            }
                            localObject1 = this.this$0.$contextObj;
                            if ((localObject1 != null) && (((bid)localObject1).xkX == 16)) {
                              break;
                            }
                            localObject1 = this.this$0.$contextObj;
                            if ((localObject1 != null) && (((bid)localObject1).xkX == 6)) {
                              break;
                            }
                            localObject1 = this.this$0.$contextObj;
                            if ((localObject1 != null) && (((bid)localObject1).xkX == 27)) {
                              break;
                            }
                            localObject1 = this.this$0.$contextObj;
                            if ((localObject1 != null) && (((bid)localObject1).xkX == 9)) {
                              break;
                            }
                            localObject1 = this.this$0.$contextObj;
                            i = m;
                          } while (localObject1 == null);
                          i = m;
                        } while (((bid)localObject1).xkX != 25);
                        localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                        i = 0;
                        if (!((Iterator)localObject1).hasNext()) {
                          break label1875;
                        }
                        localObject2 = (bu)((Iterator)localObject1).next();
                        if ((!(localObject2 instanceof BaseFinderFeed)) || (((BaseFinderFeed)localObject2).feedObject.getId() != paramAnonymoushu.fEL.id)) {
                          break;
                        }
                        j = 1;
                        if (j == 0) {
                          break label1868;
                        }
                        j = i;
                        i = m;
                      } while (j == -1);
                      localObject1 = (bu)this.this$0.this$0.getDataList().get(j);
                      i = i1;
                      boolean bool2;
                      if ((localObject1 instanceof BaseFinderFeed))
                      {
                        bool2 = ((BaseFinderFeed)localObject1).showCommentEdu;
                        if (paramAnonymoushu.fEL.fEN != 1) {
                          break label1880;
                        }
                      }
                      for (boolean bool1 = true;; bool1 = false)
                      {
                        i = i1;
                        if (bool2 != bool1) {
                          i = 1;
                        }
                        if (i != 0) {
                          this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(6), paramAnonymoushu));
                        }
                        i = 1;
                        break;
                        j = 0;
                        break label1740;
                        i += 1;
                        break label1683;
                        j = -1;
                        break label1746;
                      }
                      Log.i(this.this$0.this$0.getTAG(), "FeedUpdateEvent TYPE_ACTIVITY_REMOVED id:" + paramAnonymoushu.fEL.id + ",username:" + paramAnonymoushu.fEL.username + ",liveStaus:" + paramAnonymoushu.fEL.liveStatus);
                      i = m;
                    } while (paramAnonymoushu.fEL.id == 0L);
                    localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                    i = 0;
                    if (((Iterator)localObject1).hasNext())
                    {
                      localObject2 = (bu)((Iterator)localObject1).next();
                      if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushu.fEL.id))
                      {
                        j = 1;
                        if (j == 0) {
                          break label2119;
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
                        break label2131;
                      }
                      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                      AppMethodBeat.o(288108);
                      throw ((Throwable)localObject1);
                      j = 0;
                      break label2060;
                      i += 1;
                      break label2003;
                    }
                    localObject1 = (BaseFinderFeed)localObject1;
                    if (paramAnonymoushu.fEL.fEN == 1)
                    {
                      localObject2 = ((BaseFinderFeed)localObject1).feedObject.getFeedObject().objectDesc;
                      if (localObject2 != null) {
                        ((FinderObjectDesc)localObject2).event = null;
                      }
                      this.this$0.this$0.dispatcher().MF(j);
                      BaseFinderFeedLoader.access$updateFinderPageItem(this.this$0.this$0, (BaseFinderFeed)localObject1);
                    }
                    for (;;)
                    {
                      i = 1;
                      break;
                      this.this$0.this$0.dispatcher().MF(j);
                    }
                    Log.i(this.this$0.this$0.getTAG(), "FeedUpdateEvent TYPE_ACTIVITY_ANTI_SPAM id:" + paramAnonymoushu.fEL.id);
                    i = m;
                  } while (paramAnonymoushu.fEL.id == 0L);
                  localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                  i = 0;
                  if (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (bu)((Iterator)localObject1).next();
                    if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushu.fEL.id))
                    {
                      j = 1;
                      if (j == 0) {
                        break label2419;
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
                      break label2431;
                    }
                    localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                    AppMethodBeat.o(288108);
                    throw ((Throwable)localObject1);
                    j = 0;
                    break label2360;
                    i += 1;
                    break label2303;
                  }
                  localObject1 = (BaseFinderFeed)localObject1;
                  if (paramAnonymoushu.fEL.fEN == 1)
                  {
                    localObject2 = ((BaseFinderFeed)localObject1).feedObject.getFeedObject().objectDesc;
                    if (localObject2 != null)
                    {
                      localObject2 = ((FinderObjectDesc)localObject2).event;
                      if (localObject2 != null)
                      {
                        ((bfv)localObject2).eventName = "";
                        ((bfv)localObject2).SQA = "";
                        Log.i(this.this$0.this$0.getTAG(), "TYPE_ACTIVITY_ANTI_SPAM value changed");
                        localObject2 = kotlin.x.aazN;
                      }
                    }
                    this.this$0.this$0.dispatcher().MF(j);
                    BaseFinderFeedLoader.access$updateFinderPageItem(this.this$0.this$0, (BaseFinderFeed)localObject1);
                  }
                  for (;;)
                  {
                    i = 1;
                    break;
                    this.this$0.this$0.dispatcher().MF(j);
                  }
                  Log.i(this.this$0.this$0.getTAG(), "FeedUpdateEvent TYPE_LIVE_CHANGE id:" + paramAnonymoushu.fEL.id + ",username:" + paramAnonymoushu.fEL.username + ",liveStaus:" + paramAnonymoushu.fEL.liveStatus);
                  i = m;
                } while (paramAnonymoushu.fEL.id == 0L);
                i = m;
              } while (paramAnonymoushu.fEL.fEN != 1);
              label604:
              label870:
              label2419:
              localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
              label1379:
              i = 0;
              label1875:
              label1880:
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (bu)((Iterator)localObject1).next();
                if ((localObject2 instanceof w))
                {
                  localObject2 = ((w)localObject2).feedObject.getLiveInfo();
                  if ((localObject2 != null) && (((bac)localObject2).liveId == paramAnonymoushu.fEL.id))
                  {
                    j = 1;
                    if (j == 0) {
                      break label3245;
                    }
                    if (i < 0) {
                      break label5877;
                    }
                    localObject2 = (bu)this.this$0.this$0.getDataList().get(i);
                    localObject1 = localObject2;
                    if (!(localObject2 instanceof w)) {
                      localObject1 = null;
                    }
                    localObject1 = (w)localObject1;
                    if (localObject1 != null)
                    {
                      localObject1 = ((BaseFinderFeed)localObject1).feedObject.getLiveInfo();
                      if (localObject1 != null) {
                        ((bac)localObject1).liveStatus = paramAnonymoushu.fEL.liveStatus;
                      }
                      this.this$0.this$0.dispatcher().MF(i);
                      localObject1 = kotlin.x.aazN;
                    }
                  }
                }
              }
              label2003:
              label2131:
              label2774:
              break;
            }
            label547:
            label675:
            label1073:
            label1079:
            label1868:
            label2897:
            label2923:
            label3056:
            label5874:
            label5877:
            for (i = 1;; i = 0)
            {
              localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
              j = 0;
              if (((Iterator)localObject1).hasNext()) {
                if (((bu)((Iterator)localObject1).next() instanceof com.tencent.mm.plugin.finder.model.x)) {
                  if (j >= 0)
                  {
                    localObject1 = (bu)this.this$0.this$0.getDataList().get(j);
                    if ((localObject1 instanceof com.tencent.mm.plugin.finder.model.x))
                    {
                      i = ((com.tencent.mm.plugin.finder.model.x)localObject1).Mb(paramAnonymoushu.fEL.id);
                      if (i >= 0)
                      {
                        if (paramAnonymoushu.fEL.liveStatus != 2) {
                          break label3293;
                        }
                        localObject1 = (com.tencent.mm.plugin.finder.model.x)localObject1;
                        m = ((com.tencent.mm.plugin.finder.model.x)localObject1).fmA.size();
                        if (i >= 0) {
                          break label3269;
                        }
                        if (!((Collection)((com.tencent.mm.plugin.finder.model.x)localObject1).dKy()).isEmpty()) {
                          break label3288;
                        }
                        i = 1;
                        if (i != 0)
                        {
                          ((com.tencent.mm.plugin.finder.model.x)localObject1).fmA.clear();
                          Log.i("FinderFeedLiveList", "removeItem clear list!");
                        }
                        localObject1 = kotlin.x.aazN;
                        this.this$0.this$0.dispatcher().MF(j);
                        if ((localObject1 instanceof y))
                        {
                          localObject2 = ((y)localObject1).zAF;
                          if (localObject2 != null)
                          {
                            localObject2 = ((FinderObject)localObject2).liveInfo;
                            if (localObject2 != null) {
                              ((bac)localObject2).liveStatus = paramAnonymoushu.fEL.liveStatus;
                            }
                          }
                          localObject2 = this.this$0.this$0.getTAG();
                          localObject3 = new StringBuilder("FeedUpdateEvent nickname:");
                          localObject1 = ((y)localObject1).zAF;
                          if (localObject1 == null) {
                            break label3318;
                          }
                          localObject1 = ((FinderObject)localObject1).contact;
                          if (localObject1 == null) {
                            break label3318;
                          }
                        }
                      }
                    }
                  }
                }
              }
              label3318:
              for (localObject1 = ((FinderContact)localObject1).nickname;; localObject1 = null)
              {
                Log.i((String)localObject2, (String)localObject1 + ", live status:" + paramAnonymoushu.fEL.liveStatus);
                i = 1;
                localObject2 = paramAnonymoushu.fEL.username;
                if (!Util.isNullOrNil((String)localObject2)) {
                  break label3324;
                }
                AppMethodBeat.o(288108);
                return;
                j = 0;
                break label2770;
                i += 1;
                break;
                i = -1;
                break label2774;
                j += 1;
                break label2897;
                j = -1;
                break label2923;
                if (m <= i) {
                  break label3012;
                }
                ((com.tencent.mm.plugin.finder.model.x)localObject1).fmA.remove(i);
                break label3012;
                i = 0;
                break label3030;
                localObject1 = ((com.tencent.mm.plugin.finder.model.x)localObject1).fmA.get(i);
                kotlin.g.b.p.j(localObject1, "liveList.list[indexListItem]");
                break label3056;
              }
              label3324:
              localObject3 = ((Iterable)this.this$0.this$0.getDataList()).iterator();
              j = k;
              Object localObject4;
              Object localObject5;
              Object localObject6;
              if (((Iterator)localObject3).hasNext())
              {
                localObject1 = ((Iterator)localObject3).next();
                if (j < 0) {
                  j.iBO();
                }
                localObject4 = (bu)localObject1;
                if (!(localObject4 instanceof BaseFinderFeed)) {
                  break label5874;
                }
                localObject1 = ((BaseFinderFeed)localObject4).contact;
                if (localObject1 != null)
                {
                  localObject1 = ((i)localObject1).getUsername();
                  if (!kotlin.g.b.p.h(localObject1, localObject2)) {
                    break label5874;
                  }
                  localObject1 = ((BaseFinderFeed)localObject4).contact;
                  if (localObject1 != null)
                  {
                    ((i)localObject1).field_liveStatus = paramAnonymoushu.fEL.liveStatus;
                    localObject1 = kotlin.x.aazN;
                  }
                  localObject1 = ((BaseFinderFeed)localObject4).feedObject.getFeedObject().contact;
                  if (localObject1 != null)
                  {
                    ((FinderContact)localObject1).liveStatus = paramAnonymoushu.fEL.liveStatus;
                    localObject1 = kotlin.x.aazN;
                  }
                  this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(7), paramAnonymoushu));
                  BaseFinderFeedLoader.access$updateFinderPageItem(this.this$0.this$0, (BaseFinderFeed)localObject4);
                  localObject5 = this.this$0.this$0.getTAG();
                  localObject6 = new StringBuilder("FeedUpdateEvent TYPE_LIVE_CHANGE username:").append((String)localObject2).append(",nickname:");
                  localObject1 = ((BaseFinderFeed)localObject4).contact;
                  if (localObject1 == null) {
                    break label3663;
                  }
                  localObject1 = ((i)localObject1).getNickname();
                  Log.i((String)localObject5, (String)localObject1 + ",feed id:" + ((bu)localObject4).mf() + ",live status:" + paramAnonymoushu.fEL.liveStatus);
                  i = 1;
                }
              }
              for (;;)
              {
                j += 1;
                break label3346;
                localObject1 = null;
                break label3409;
                localObject1 = null;
                break label3598;
                break;
                Log.i(this.this$0.this$0.getTAG(), "FeedUpdateEvent TYPE_LIVE_STREAM_CHANGE id:" + paramAnonymoushu.fEL.id + ",feedList:" + paramAnonymoushu.fEL.fEQ + ",liveStaus:" + paramAnonymoushu.fEL.liveStatus + ",username:" + paramAnonymoushu.fEL.username);
                if (paramAnonymoushu.fEL.fEN == 1)
                {
                  localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                  i = 0;
                  if (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (bu)((Iterator)localObject1).next();
                    if (((localObject2 instanceof com.tencent.mm.plugin.finder.model.x)) && (((com.tencent.mm.plugin.finder.model.x)localObject2).zAB == paramAnonymoushu.fEL.id))
                    {
                      j = 1;
                      if (j == 0) {
                        break label4383;
                      }
                      if (i < 0) {
                        break label5869;
                      }
                      localObject2 = (bu)this.this$0.this$0.getDataList().get(i);
                      localObject1 = localObject2;
                      if (!(localObject2 instanceof com.tencent.mm.plugin.finder.model.x)) {
                        localObject1 = null;
                      }
                      if ((com.tencent.mm.plugin.finder.model.x)localObject1 != null)
                      {
                        this.this$0.this$0.dispatcher().onItemRangeChanged(i, 1, new o(Integer.valueOf(2), Long.valueOf(paramAnonymoushu.fEL.id)));
                        localObject1 = kotlin.x.aazN;
                      }
                    }
                  }
                }
                for (i = 1;; i = 0)
                {
                  localObject1 = com.tencent.mm.plugin.finder.model.d.zAb;
                  localObject1 = paramAnonymoushu.fEL.username;
                  kotlin.g.b.p.j(localObject1, "event.data.username");
                  localObject2 = ((Iterable)d.a.aDt((String)localObject1)).iterator();
                  for (;;)
                  {
                    if (!((Iterator)localObject2).hasNext()) {
                      break label4416;
                    }
                    localObject3 = (String)((Iterator)localObject2).next();
                    localObject4 = ((Iterable)this.this$0.this$0.getDataList()).iterator();
                    j = 0;
                    if (((Iterator)localObject4).hasNext())
                    {
                      localObject1 = ((Iterator)localObject4).next();
                      if (j < 0) {
                        j.iBO();
                      }
                      localObject5 = (bu)localObject1;
                      label4087:
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
                              break label4401;
                            }
                            localObject1 = ((i)localObject1).getUsername();
                            k = i;
                            if (kotlin.g.b.p.h(localObject1, localObject3))
                            {
                              localObject1 = ((BaseFinderFeed)localObject5).contact;
                              if (localObject1 != null)
                              {
                                ((i)localObject1).field_liveStatus = paramAnonymoushu.fEL.liveStatus;
                                localObject1 = kotlin.x.aazN;
                              }
                              localObject1 = ((BaseFinderFeed)localObject5).feedObject.getFeedObject().contact;
                              if (localObject1 != null)
                              {
                                ((FinderContact)localObject1).liveStatus = paramAnonymoushu.fEL.liveStatus;
                                localObject1 = kotlin.x.aazN;
                              }
                              this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(7), paramAnonymoushu));
                              BaseFinderFeedLoader.access$updateFinderPageItem(this.this$0.this$0, (BaseFinderFeed)localObject5);
                              localObject6 = this.this$0.this$0.getTAG();
                              localStringBuilder = new StringBuilder("FeedUpdateEvent username:").append((String)localObject3).append(",nickname:");
                              localObject1 = ((BaseFinderFeed)localObject5).contact;
                              if (localObject1 == null) {
                                break label4407;
                              }
                            }
                          }
                        }
                      }
                      for (localObject1 = ((i)localObject1).getNickname();; localObject1 = null)
                      {
                        Log.i((String)localObject6, (String)localObject1 + ",feed id:" + ((bu)localObject5).mf() + ",live status:" + paramAnonymoushu.fEL.liveStatus);
                        k = 1;
                        j += 1;
                        i = k;
                        break label4038;
                        j = 0;
                        break label3858;
                        i += 1;
                        break;
                        i = -1;
                        break label3862;
                        m = 0;
                        break label4087;
                        localObject1 = null;
                        break label4126;
                      }
                    }
                  }
                  break;
                  localObject1 = k.xIe;
                  localObject1 = paramAnonymoushu.fEL.username;
                  kotlin.g.b.p.j(localObject1, "event.data.username");
                  kotlin.g.b.p.k(localObject1, "str");
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
                      j.iBO();
                    }
                    localObject1 = (bu)localObject1;
                    if (((CharSequence)localObject3).length() <= 0) {
                      break label4681;
                    }
                    j = 1;
                    if ((j != 0) && ((localObject1 instanceof BaseFinderFeed)))
                    {
                      localObject1 = ((BaseFinderFeed)localObject1).contact;
                      if (localObject1 == null) {
                        break label4686;
                      }
                    }
                  }
                  for (localObject1 = ((i)localObject1).getUsername();; localObject1 = null)
                  {
                    if (kotlin.g.b.p.h(localObject1, localObject3))
                    {
                      this.this$0.this$0.dispatcher().onItemRangeChanged(i, 1, new o(Integer.valueOf(8), paramAnonymoushu));
                      Log.i(this.this$0.this$0.getTAG(), "TYPE_FEED_LIVE_NOTICE username:".concat(String.valueOf(localObject3)));
                    }
                    i += 1;
                    break label4527;
                    break;
                    j = 0;
                    break label4575;
                  }
                  localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                  i = 0;
                  if (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (bu)((Iterator)localObject1).next();
                    if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushu.fEL.id))
                    {
                      j = 1;
                      if (j == 0) {
                        break label4879;
                      }
                    }
                  }
                  for (j = i;; j = -1)
                  {
                    i = m;
                    if (j == -1) {
                      break;
                    }
                    this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(26), Integer.valueOf(1)));
                    Log.i(this.this$0.this$0.getTAG(), "TYPE_FINDER_AD_MUTUAL_INFO index:" + j + " id:" + com.tencent.mm.ae.d.Fw(paramAnonymoushu.fEL.id));
                    i = m;
                    break;
                    j = 0;
                    break label4771;
                    i += 1;
                    break label4714;
                  }
                  localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                  i = 0;
                  if (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (bu)((Iterator)localObject1).next();
                    if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushu.fEL.id))
                    {
                      j = 1;
                      if (j == 0) {
                        break label5079;
                      }
                    }
                  }
                  for (j = i;; j = -1)
                  {
                    i = m;
                    if (j == -1) {
                      break;
                    }
                    this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(27), Integer.valueOf(10)));
                    Log.i(this.this$0.this$0.getTAG(), "TYPE_FINDER_AD_SNS_INFO index:" + j + " id:" + com.tencent.mm.ae.d.Fw(paramAnonymoushu.fEL.id));
                    i = m;
                    break;
                    j = 0;
                    break label4970;
                    i += 1;
                    break label4913;
                  }
                  localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                  i = 0;
                  label5113:
                  if (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (bu)((Iterator)localObject1).next();
                    if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == paramAnonymoushu.fEL.id))
                    {
                      j = 1;
                      if (j == 0) {
                        break label5449;
                      }
                    }
                  }
                  for (j = i;; j = -1)
                  {
                    i = m;
                    if (j == -1) {
                      break;
                    }
                    localObject2 = this.this$0.this$0.getDataList().get(j);
                    localObject1 = localObject2;
                    if (!(localObject2 instanceof BaseFinderFeed)) {
                      localObject1 = null;
                    }
                    localObject1 = (BaseFinderFeed)localObject1;
                    if (localObject1 != null)
                    {
                      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
                      if (localObject1 != null)
                      {
                        localObject1 = ((FinderItem)localObject1).getFeedObject();
                        if (localObject1 != null)
                        {
                          i = m;
                          if (((FinderObject)localObject1).adFlag == paramAnonymoushu.fEL.adFlag) {
                            break;
                          }
                        }
                      }
                    }
                    localObject2 = this.this$0.this$0.getDataList().get(j);
                    localObject1 = localObject2;
                    if (!(localObject2 instanceof BaseFinderFeed)) {
                      localObject1 = null;
                    }
                    localObject1 = (BaseFinderFeed)localObject1;
                    if (localObject1 != null)
                    {
                      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
                      if (localObject1 != null)
                      {
                        localObject1 = ((FinderItem)localObject1).getFeedObject();
                        if (localObject1 != null) {
                          ((FinderObject)localObject1).adFlag = paramAnonymoushu.fEL.adFlag;
                        }
                      }
                    }
                    this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(28), Integer.valueOf(10)));
                    Log.i(this.this$0.this$0.getTAG(), "TYPE_FINDER_AD_STAT_CHANGED index:" + j + " id:" + com.tencent.mm.ae.d.Fw(paramAnonymoushu.fEL.id));
                    i = m;
                    break;
                    j = 0;
                    break label5170;
                    i += 1;
                    break label5113;
                  }
                  Log.i(this.this$0.this$0.getTAG(), "FeedLiveListItemUpdateEvent TYPE_LIVE_LIST_ITEM_STATUS_CHANGE id:" + paramAnonymoushu.fEL.id + ",feedList:" + paramAnonymoushu.fEL.fEQ + ",liveStaus:" + paramAnonymoushu.fEL.liveStatus + ",username:" + paramAnonymoushu.fEL.username);
                  localObject1 = ((List)this.this$0.this$0.getDataList()).iterator();
                  i = 0;
                  if (((Iterator)localObject1).hasNext()) {
                    if (!((bu)((Iterator)localObject1).next() instanceof com.tencent.mm.plugin.finder.model.x)) {}
                  }
                  for (j = i;; j = -1)
                  {
                    i = m;
                    if (j < 0) {
                      break;
                    }
                    localObject1 = (bu)this.this$0.this$0.getDataList().get(j);
                    i = m;
                    if (!(localObject1 instanceof com.tencent.mm.plugin.finder.model.x)) {
                      break;
                    }
                    localObject1 = ((com.tencent.mm.plugin.finder.model.x)localObject1).Mc(paramAnonymoushu.fEL.id);
                    i = m;
                    if (localObject1 == null) {
                      break;
                    }
                    localObject3 = ((y)localObject1).zAF;
                    if (localObject3 != null)
                    {
                      localObject3 = ((FinderObject)localObject3).liveInfo;
                      if (localObject3 != null) {
                        ((bac)localObject3).liveStatus = paramAnonymoushu.fEL.liveStatus;
                      }
                    }
                    localObject3 = this.this$0.this$0.getTAG();
                    localObject4 = new StringBuilder("FeedLiveListItemUpdateEvent nickname:");
                    localObject5 = ((y)localObject1).zAF;
                    localObject1 = localObject2;
                    if (localObject5 != null)
                    {
                      localObject5 = ((FinderObject)localObject5).contact;
                      localObject1 = localObject2;
                      if (localObject5 != null) {
                        localObject1 = ((FinderContact)localObject5).nickname;
                      }
                    }
                    Log.i((String)localObject3, (String)localObject1 + ", live status:" + paramAnonymoushu.fEL.liveStatus);
                    this.this$0.this$0.dispatcher().onItemRangeChanged(j, 1, new o(Integer.valueOf(3), Long.valueOf(paramAnonymoushu.fEL.id)));
                    localObject1 = kotlin.x.aazN;
                    i = 1;
                    break;
                    i += 1;
                    break label5579;
                  }
                }
              }
            }
          }
        });
        AppMethodBeat.o(282567);
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
        Object localObject2 = com.tencent.mm.plugin.finder.storage.data.k.Anu;
        long l = paramBaseFinderFeed.mf();
        localObject2 = paramBaseFinderFeed.feedObject.getFeedObject();
        kotlin.g.b.p.k(localObject2, "item");
        Log.i("Finder.FinderPage", "updatePageData pageName:" + i + ", svrId:" + l);
        if (i >= 0) {
          try
          {
            k.a.Qp(i);
            Object localObject3 = k.a.a(com.tencent.mm.plugin.finder.storage.data.k.dZv().Qq(i), "");
            if (localObject3 != null)
            {
              localObject3 = ((ath)localObject3).jmy;
              if (localObject3 != null)
              {
                h localh = h.Ang;
                if (h.a(l, (FinderObject)localObject2, (LinkedList)localObject3))
                {
                  localObject2 = com.tencent.mm.plugin.finder.storage.data.k.Anu;
                  k.a.a(com.tencent.mm.plugin.finder.storage.data.k.dZv().Qq(i));
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
  
  public void addRvFeed(int paramInt, bu parambu)
  {
    kotlin.g.b.p.k(parambu, "feed");
    getDataList().add(paramInt, parambu);
  }
  
  public List<Integer> colletExtraPageName()
  {
    return (List)new ArrayList();
  }
  
  protected final bu getItem(long paramLong)
  {
    Iterator localIterator = ((List)getDataList()).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((bu)localIterator.next()).mf() == paramLong)
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
      return (bu)getDataList().get(i);
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
  
  public int insert(bu parambu, int paramInt, boolean paramBoolean)
  {
    kotlin.g.b.p.k(parambu, "feed");
    int i = getDataList().indexOf(parambu);
    if (i == paramInt) {}
    do
    {
      do
      {
        return paramInt;
        if (i >= 0) {
          getDataList().remove(parambu);
        }
      } while (paramInt < 0);
      addRvFeed(paramInt, parambu);
    } while (!paramBoolean);
    dispatcher().onItemRangeInserted(paramInt, 1);
    return paramInt;
  }
  
  public void insertAll(List<? extends bu> paramList, int paramInt)
  {
    kotlin.g.b.p.k(paramList, "feeds");
    if (paramInt >= 0)
    {
      getDataList().addAll(paramInt, (Collection)paramList);
      dispatcher().onItemRangeInserted(paramInt, paramList.size());
    }
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
      g.a locala = g.AAk;
      g.ecj().a((com.tencent.mm.plugin.finder.upload.q)this);
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
      g.a locala = g.AAk;
      g.ecj().b((com.tencent.mm.plugin.finder.upload.q)this);
    }
    this.feedDeleteListener.dead();
    this.feedChangeListener.dead();
  }
  
  public void onFetchDone(IResponse paramIResponse)
  {
    b localb = new b();
    localb.bn(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aFi());
    super.onFetchDone(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
  }
  
  public void onMvPostStart(FinderItem paramFinderItem)
  {
    kotlin.g.b.p.k(paramFinderItem, "item");
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
        localObject = c.AnK;
        localObject = c.a.MS(paramLong);
      } while (localObject == null);
      localArrayList = new ArrayList();
      localBaseFinderFeed = transformFinderObj((FinderItem)localObject);
    } while ((localBaseFinderFeed.feedObject.isMvFeed()) && (interceptMvPostStart()));
    Log.i(getTAG(), "onPostStart localId " + paramLong + " feed " + localBaseFinderFeed);
    aj localaj = aj.AGc;
    if (!aj.dOO()) {}
    for (boolean bool = true;; bool = false)
    {
      localBaseFinderFeed.showLikeTips = bool;
      localBaseFinderFeed.showShareSns = paramBoolean;
      if (!(j.lp((List)getDataList()) instanceof com.tencent.mm.plugin.finder.model.x)) {
        break;
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new kotlin.g.b.q(localBaseFinderFeed)
      {
        public final void invoke()
        {
          AppMethodBeat.i(223265);
          jdField_this.getDataList().add(1, this.$feed$inlined);
          jdField_this.dispatcher().onItemRangeInserted(1, 1);
          AppMethodBeat.o(223265);
        }
      });
      return;
    }
    localArrayList.add(localBaseFinderFeed);
    com.tencent.mm.plugin.finder.feed.model.internal.d.mergeDataAndNotify$default(getMerger(), 2, (List)localArrayList, true, null, 8, null);
  }
  
  public int remove(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = ((List)getDataList()).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((bu)localIterator.next()).mf() == paramLong)
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
        kotlin.g.b.p.j(getDataList().remove(i), "dataList.removeAt(index)");
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
  
  public void removeAll(int paramInt)
  {
    int i = getDataList().size();
    if ((paramInt != -1) && (paramInt <= i))
    {
      LinkedList localLinkedList = new LinkedList((Collection)getDataList().subList(0, paramInt));
      getDataList().clear();
      getDataList().addAll((Collection)localLinkedList);
      i -= localLinkedList.size();
      if (i > 0)
      {
        dispatcher().onItemRangeRemoved(paramInt, i);
        onDataChanged();
      }
    }
  }
  
  public final int removeByLocalId(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = ((List)getDataList()).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      bu localbu = (bu)localIterator.next();
      if (((localbu instanceof BaseFinderFeed)) && (((BaseFinderFeed)localbu).feedObject.getLocalId() == paramLong))
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
        kotlin.g.b.p.j(getDataList().remove(i), "dataList.removeAt(index)");
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
    kotlin.g.b.p.k(paramFinderItem, "feedObj");
    c.a locala = c.AnK;
    return c.a.a(paramFinderItem);
  }
  
  public BaseFinderFeed transformToMusicData(FinderItem paramFinderItem)
  {
    kotlin.g.b.p.k(paramFinderItem, "item");
    return transformFinderObj(paramFinderItem);
  }
  
  public final int updateByLocalId(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean)
  {
    kotlin.g.b.p.k(paramBaseFinderFeed, "newFeed");
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
        j.iBO();
      }
      localObject = (bu)localObject;
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
    Object localObject = e.AmW;
    localObject = e.a.MH(paramLong2);
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
    Object localObject = c.AnK;
    localObject = c.a.MS(paramLong);
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
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new kotlin.g.b.q(paramLong)
    {
      public final void invoke()
      {
        AppMethodBeat.i(292184);
        Iterator localIterator = ((Iterable)this.this$0.getDataList()).iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          Object localObject1 = localIterator.next();
          if (i < 0) {
            j.iBO();
          }
          localObject1 = (bu)localObject1;
          if (((localObject1 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject1).feedObject.getLocalId() == paramLong))
          {
            Object localObject2 = c.AnK;
            Object localObject3 = c.a.MS(paramLong);
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
        AppMethodBeat.o(292184);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
 * JD-Core Version:    0.7.0.1
 */