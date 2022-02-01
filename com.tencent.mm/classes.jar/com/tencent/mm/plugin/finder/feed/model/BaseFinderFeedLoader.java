package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.d.a.a.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hy;
import com.tencent.mm.autogen.a.hy.a;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.autogen.a.if.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.feed.jumper.i;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse<Lcom.tencent.mm.plugin.finder.model.cc;>;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.publish.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.upload.action.l;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.g;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axv;
import com.tencent.mm.protocal.protobuf.azl;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.blf;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "feedChangeListener", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1;", "feedDeleteListener", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1;", "addRvFeed", "", "index", "", "feed", "colletExtraPageName", "", "getItem", "feedId", "", "getPageName", "insert", "notify", "", "insertAll", "feeds", "interceptMvFeed", "interceptMvPostStart", "interceptPostStart", "isObservePostEvent", "onAlive", "onDataChanged", "onDead", "onFetchInitDone", "initResponse", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onFetchInsertedDone", "onFetchLoadMoreDone", "onFetchRefreshDone", "onMvPostStart", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "onPostEnd", "localId", "isOk", "onPostNotify", "onPostOk", "svrID", "onPostStart", "isFromSns", "remove", "removeAll", "afterIndex", "removeByLocalId", "feedLocalId", "requestLoadMore", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "transformFinderObj", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedObj", "transformToMusicData", "updateByLocalId", "newFeed", "updateFinderPageItem", "updateItem", "svrId", "updateProgressByLocalId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseFinderFeedLoader
  extends BaseFeedLoader<cc>
  implements com.tencent.mm.plugin.finder.upload.r
{
  private byte _hellAccFlag_;
  private final feedChangeListener.1 feedChangeListener;
  private final feedDeleteListener.1 feedDeleteListener = new IListener(com.tencent.mm.app.f.hfK)
  {
    public final boolean callback(hy paramAnonymoushy)
    {
      AppMethodBeat.i(366141);
      s.u(paramAnonymoushy, "event");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new u(paramAnonymoushy)
      {
        public final void invoke()
        {
          AppMethodBeat.i(366378);
          if (this.$event.hJo.hJp == 1)
          {
            AppMethodBeat.o(366378);
            return;
          }
          if (this.$event.hJo.id != 0L)
          {
            this.this$0.remove(this.$event.hJo.id, true);
            AppMethodBeat.o(366378);
            return;
          }
          this.this$0.removeByLocalId(this.$event.hJo.localId, true);
          AppMethodBeat.o(366378);
        }
      });
      AppMethodBeat.o(366141);
      return false;
    }
  };
  
  public BaseFinderFeedLoader()
  {
    this(null, 1, null);
  }
  
  public BaseFinderFeedLoader(final bui parambui)
  {
    super(parambui);
    this.feedChangeListener = new IListener(parambui)
    {
      public final boolean callback(if paramAnonymousif)
      {
        AppMethodBeat.i(366306);
        s.u(paramAnonymousif, "event");
        com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new u(paramAnonymousif)
        {
          public final void invoke()
          {
            AppMethodBeat.i(366173);
            if (this.$event.hJB.hJp == 1)
            {
              AppMethodBeat.o(366173);
              return;
            }
            Log.i(this.this$0.getTAG(), "feedChangeListener " + this.$event.hJB.id + ",fav = " + this.$event.hJB.hJC + ",like = " + this.$event.hJB.hJE + ",likeCount = " + this.$event.hJB.likeCount + " ,needChangeData = " + this.$event.hJB.hJD);
            final ah.a locala = new ah.a();
            Object localObject3;
            label375:
            int j;
            switch (this.$event.hJB.type)
            {
            case 2: 
            case 3: 
            case 10: 
            case 14: 
            case 19: 
            case 22: 
            case 23: 
            case 24: 
            default: 
            case 0: 
            case 1: 
            case 25: 
            case 26: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 12: 
            case 13: 
            case 21: 
            case 8: 
            case 9: 
            case 11: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
              Object localObject4;
              Object localObject5;
              label430:
              label434:
              label453:
              label608:
              label870:
              label1137:
              label1141:
              label2165:
              label2422:
              label2427:
              label3326:
              Object localObject6;
              label530:
              label542:
              label547:
              label714:
              label981:
              label1268:
              label3321:
              label3709:
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
                          Object localObject7;
                          Object localObject8;
                          do
                          {
                            do
                            {
                              int k;
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
                                                                  do
                                                                  {
                                                                    do
                                                                    {
                                                                      if (locala.aiwY) {
                                                                        this.this$0.onDataChanged();
                                                                      }
                                                                      AppMethodBeat.o(366173);
                                                                      return;
                                                                    } while (this.$event.hJB.id == 0L);
                                                                    localObject1 = e.FMN;
                                                                    localObject1 = this.$event.hJB;
                                                                    s.checkNotNull(localObject1);
                                                                    localObject2 = e.a.jn(((if.a)localObject1).id);
                                                                  } while (localObject2 == null);
                                                                  localObject1 = this.this$0;
                                                                  localObject3 = this.$event;
                                                                  localObject4 = (List)((BaseFinderFeedLoader)localObject1).getDataList();
                                                                  i = 0;
                                                                  localObject4 = ((List)localObject4).iterator();
                                                                  if (((Iterator)localObject4).hasNext())
                                                                  {
                                                                    localObject5 = (cc)((Iterator)localObject4).next();
                                                                    if (((localObject5 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject5).feedObject.getId() == ((if)localObject3).hJB.id))
                                                                    {
                                                                      j = 1;
                                                                      if (j == 0) {
                                                                        break label530;
                                                                      }
                                                                      if (i != -1)
                                                                      {
                                                                        if (((if)localObject3).hJB.hJH != 1) {
                                                                          break label542;
                                                                        }
                                                                        j = 1;
                                                                        localObject3 = ((BaseFinderFeedLoader)localObject1).getDataList();
                                                                        localObject2 = ((BaseFinderFeedLoader)localObject1).transformFinderObj((FinderItem)localObject2);
                                                                        if (j != 0) {
                                                                          ((BaseFinderFeed)localObject2).isHistoryFeed = true;
                                                                        }
                                                                        localObject4 = ah.aiuX;
                                                                        ((DataBuffer)localObject3).set(i, localObject2);
                                                                        if (j == 0) {
                                                                          break label547;
                                                                        }
                                                                        ((BaseFinderFeedLoader)localObject1).dispatcher().Oc(i);
                                                                      }
                                                                    }
                                                                  }
                                                                  for (;;)
                                                                  {
                                                                    locala.aiwY = true;
                                                                    localObject1 = ah.aiuX;
                                                                    localObject1 = ah.aiuX;
                                                                    break;
                                                                    j = 0;
                                                                    break label430;
                                                                    i += 1;
                                                                    break label375;
                                                                    i = -1;
                                                                    break label434;
                                                                    j = 0;
                                                                    break label453;
                                                                    ((BaseFinderFeedLoader)localObject1).dispatcher().onItemRangeChanged(i, 1, Integer.valueOf(1));
                                                                  }
                                                                } while (this.$event.hJB.id == 0L);
                                                                localObject2 = (List)this.this$0.getDataList();
                                                                localObject1 = this.$event;
                                                                i = 0;
                                                                localObject2 = ((List)localObject2).iterator();
                                                                if (((Iterator)localObject2).hasNext())
                                                                {
                                                                  localObject3 = (cc)((Iterator)localObject2).next();
                                                                  if (((localObject3 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject3).feedObject.getId() == ((if)localObject1).hJB.id))
                                                                  {
                                                                    j = 1;
                                                                    if (j == 0) {
                                                                      break label714;
                                                                    }
                                                                  }
                                                                }
                                                                while (i != -1)
                                                                {
                                                                  this.this$0.dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(29), Integer.valueOf(1)));
                                                                  locala.aiwY = true;
                                                                  break;
                                                                  j = 0;
                                                                  break label663;
                                                                  i += 1;
                                                                  break label608;
                                                                  i = -1;
                                                                }
                                                              } while (this.$event.hJB.id == 0L);
                                                              localObject2 = (List)this.this$0.getDataList();
                                                              localObject1 = this.$event;
                                                              i = 0;
                                                              localObject2 = ((List)localObject2).iterator();
                                                              if (((Iterator)localObject2).hasNext())
                                                              {
                                                                localObject3 = (cc)((Iterator)localObject2).next();
                                                                if (((localObject3 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject3).feedObject.getId() == ((if)localObject1).hJB.id))
                                                                {
                                                                  j = 1;
                                                                  if (j == 0) {
                                                                    break label870;
                                                                  }
                                                                }
                                                              }
                                                              while (i != -1)
                                                              {
                                                                this.this$0.dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(31), this.$event));
                                                                break;
                                                                j = 0;
                                                                break label825;
                                                                i += 1;
                                                                break label770;
                                                                i = -1;
                                                              }
                                                            } while (this.$event.hJB.id == 0L);
                                                            localObject2 = (List)this.this$0.getDataList();
                                                            localObject1 = this.$event;
                                                            i = 0;
                                                            localObject2 = ((List)localObject2).iterator();
                                                            if (((Iterator)localObject2).hasNext())
                                                            {
                                                              localObject3 = (cc)((Iterator)localObject2).next();
                                                              if (((localObject3 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject3).feedObject.getId() == ((if)localObject1).hJB.id))
                                                              {
                                                                j = 1;
                                                                if (j == 0) {
                                                                  break label1026;
                                                                }
                                                              }
                                                            }
                                                            while (i != -1)
                                                            {
                                                              this.this$0.dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(32), this.$event));
                                                              break;
                                                              j = 0;
                                                              break label981;
                                                              i += 1;
                                                              break label926;
                                                              i = -1;
                                                            }
                                                          } while (this.$event.hJB.id == 0L);
                                                          localObject2 = (List)this.this$0.getDataList();
                                                          localObject1 = this.$event;
                                                          i = 0;
                                                          localObject2 = ((List)localObject2).iterator();
                                                          if (!((Iterator)localObject2).hasNext()) {
                                                            break label1360;
                                                          }
                                                          localObject3 = (cc)((Iterator)localObject2).next();
                                                          if ((!(localObject3 instanceof BaseFinderFeed)) || (((BaseFinderFeed)localObject3).feedObject.getId() != ((if)localObject1).hJB.id)) {
                                                            break;
                                                          }
                                                          j = 1;
                                                          if (j == 0) {
                                                            break label1353;
                                                          }
                                                        } while (i == -1);
                                                        localObject1 = (BaseFinderFeed)this.this$0.getDataList().get(i);
                                                        if (this.$event.hJB.hJD == 1)
                                                        {
                                                          j = this.$event.hJB.hJE;
                                                          k = ((BaseFinderFeed)localObject1).feedObject.getLikeFlag();
                                                          Log.i(this.this$0.getTAG(), "TYPE_FEED_LIKE_CHANGED oldFlag:" + k + ", newFlag:" + j);
                                                          if (k != j)
                                                          {
                                                            ((BaseFinderFeed)localObject1).feedObject.setLikeFlag(j);
                                                            if (k != 0) {
                                                              break label1365;
                                                            }
                                                            localObject2 = ((BaseFinderFeed)localObject1).feedObject;
                                                            ((FinderItem)localObject2).setLikeCount(((FinderItem)localObject2).getLikeCount() + 1);
                                                            if (j != 1) {
                                                              break label1391;
                                                            }
                                                            localObject2 = ((BaseFinderFeed)localObject1).feedObject;
                                                            ((FinderItem)localObject2).setFriendLikeCount(((FinderItem)localObject2).getFriendLikeCount() + 1);
                                                            localObject2 = l.Gdj;
                                                            l.fek();
                                                            l.bd(((BaseFinderFeed)localObject1).feedObject.getLikeList());
                                                            this.this$0.dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(3), Integer.valueOf(1)));
                                                          }
                                                        }
                                                        for (;;)
                                                        {
                                                          locala.aiwY = true;
                                                          break;
                                                          j = 0;
                                                          break label1137;
                                                          i += 1;
                                                          break label1082;
                                                          i = -1;
                                                          break label1141;
                                                          if (j != 0) {
                                                            break label1268;
                                                          }
                                                          localObject2 = ((BaseFinderFeed)localObject1).feedObject;
                                                          ((FinderItem)localObject2).setLikeCount(((FinderItem)localObject2).getLikeCount() - 1);
                                                          break label1268;
                                                          if (k != 1) {
                                                            break label1312;
                                                          }
                                                          localObject2 = ((BaseFinderFeed)localObject1).feedObject;
                                                          ((FinderItem)localObject2).setFriendLikeCount(((FinderItem)localObject2).getFriendLikeCount() - 1);
                                                          localObject2 = l.Gdj;
                                                          l.fek();
                                                          l.bf(((BaseFinderFeed)localObject1).feedObject.getLikeList());
                                                          break label1312;
                                                          this.this$0.dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(3), Integer.valueOf(1)));
                                                        }
                                                      } while (this.$event.hJB.id == 0L);
                                                      localObject2 = (List)this.this$0.getDataList();
                                                      localObject1 = this.$event;
                                                      i = 0;
                                                      localObject2 = ((List)localObject2).iterator();
                                                      if (!((Iterator)localObject2).hasNext()) {
                                                        break label1763;
                                                      }
                                                      localObject3 = (cc)((Iterator)localObject2).next();
                                                      if ((!(localObject3 instanceof BaseFinderFeed)) || (((BaseFinderFeed)localObject3).feedObject.getId() != ((if)localObject1).hJB.id)) {
                                                        break;
                                                      }
                                                      j = 1;
                                                      if (j == 0) {
                                                        break label1756;
                                                      }
                                                      if (this.$event.hJB.hJC != 1) {
                                                        break label1768;
                                                      }
                                                      j = 1;
                                                    } while (i == -1);
                                                    localObject1 = (BaseFinderFeed)this.this$0.getDataList().get(i);
                                                    if (this.$event.hJB.hJD == 1)
                                                    {
                                                      Log.i(this.this$0.getTAG(), "TYPE_FAV_CHANGED oldFlag = " + ((BaseFinderFeed)localObject1).feedObject.getFavFlag() + ", eventFlag = " + j);
                                                      if (((BaseFinderFeed)localObject1).feedObject.getFavFlag() != j)
                                                      {
                                                        ((BaseFinderFeed)localObject1).feedObject.setFavFlag(j);
                                                        this.this$0.dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(4), Integer.valueOf(1)));
                                                        this.this$0.dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(9), Integer.valueOf(1)));
                                                      }
                                                    }
                                                    for (;;)
                                                    {
                                                      locala.aiwY = true;
                                                      break;
                                                      j = 0;
                                                      break label1567;
                                                      i += 1;
                                                      break label1512;
                                                      i = -1;
                                                      break label1571;
                                                      j = 0;
                                                      break label1587;
                                                      this.this$0.dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(4), Integer.valueOf(1)));
                                                      this.this$0.dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(9), Integer.valueOf(1)));
                                                    }
                                                  } while (this.$event.hJB.id == 0L);
                                                  localObject2 = (List)this.this$0.getDataList();
                                                  localObject1 = this.$event;
                                                  i = 0;
                                                  localObject2 = ((List)localObject2).iterator();
                                                  if (((Iterator)localObject2).hasNext())
                                                  {
                                                    localObject3 = (cc)((Iterator)localObject2).next();
                                                    if (((localObject3 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject3).feedObject.getId() == ((if)localObject1).hJB.id))
                                                    {
                                                      j = 1;
                                                      if (j == 0) {
                                                        break label1980;
                                                      }
                                                    }
                                                  }
                                                  while (i != -1)
                                                  {
                                                    this.this$0.dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(5), Integer.valueOf(1)));
                                                    locala.aiwY = true;
                                                    break;
                                                    j = 0;
                                                    break label1930;
                                                    i += 1;
                                                    break label1875;
                                                    i = -1;
                                                  }
                                                } while (this.$event.hJB.id == 0L);
                                                localObject1 = this.$contextObj;
                                                if ((localObject1 == null) || (((bui)localObject1).AJo != 17)) {
                                                  break label2417;
                                                }
                                                i = 1;
                                                if (i != 0) {
                                                  break;
                                                }
                                                localObject1 = this.$contextObj;
                                                if ((localObject1 == null) || (((bui)localObject1).AJo != 18)) {
                                                  break label2422;
                                                }
                                                i = 1;
                                                if (i != 0) {
                                                  break;
                                                }
                                                localObject1 = this.$contextObj;
                                                if ((localObject1 == null) || (((bui)localObject1).AJo != 20)) {
                                                  break label2427;
                                                }
                                                i = 1;
                                                if (i != 0) {
                                                  break;
                                                }
                                                localObject1 = this.$contextObj;
                                                if ((localObject1 == null) || (((bui)localObject1).AJo != 16)) {
                                                  break label2432;
                                                }
                                                i = 1;
                                                if (i != 0) {
                                                  break;
                                                }
                                                localObject1 = this.$contextObj;
                                                if ((localObject1 == null) || (((bui)localObject1).AJo != 6)) {
                                                  break label2437;
                                                }
                                                i = 1;
                                                if (i != 0) {
                                                  break;
                                                }
                                                localObject1 = this.$contextObj;
                                                if ((localObject1 == null) || (((bui)localObject1).AJo != 27)) {
                                                  break label2442;
                                                }
                                                i = 1;
                                                if (i != 0) {
                                                  break;
                                                }
                                                localObject1 = this.$contextObj;
                                                if ((localObject1 == null) || (((bui)localObject1).AJo != 9)) {
                                                  break label2447;
                                                }
                                                i = 1;
                                                if (i != 0) {
                                                  break;
                                                }
                                                localObject1 = this.$contextObj;
                                                if ((localObject1 == null) || (((bui)localObject1).AJo != 25)) {
                                                  break label2452;
                                                }
                                                i = 1;
                                              } while (i == 0);
                                              localObject2 = (List)this.this$0.getDataList();
                                              localObject1 = this.$event;
                                              i = 0;
                                              localObject2 = ((List)localObject2).iterator();
                                              if (!((Iterator)localObject2).hasNext()) {
                                                break label2469;
                                              }
                                              localObject3 = (cc)((Iterator)localObject2).next();
                                              if ((!(localObject3 instanceof BaseFinderFeed)) || (((BaseFinderFeed)localObject3).feedObject.getId() != ((if)localObject1).hJB.id)) {
                                                break label2457;
                                              }
                                              j = 1;
                                              if (j == 0) {
                                                break label2462;
                                              }
                                            } while (i == -1);
                                            localObject1 = (cc)this.this$0.getDataList().get(i);
                                            boolean bool1;
                                            if ((localObject1 instanceof BaseFinderFeed))
                                            {
                                              boolean bool2 = ((BaseFinderFeed)localObject1).showCommentEdu;
                                              if (this.$event.hJB.hJD == 1)
                                              {
                                                bool1 = true;
                                                if (bool2 == bool1) {
                                                  break label2480;
                                                }
                                              }
                                            }
                                            for (j = 1;; j = 0)
                                            {
                                              if (j != 0) {
                                                this.this$0.dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(6), this.$event));
                                              }
                                              locala.aiwY = true;
                                              break;
                                              i = 0;
                                              break label2030;
                                              i = 0;
                                              break label2057;
                                              i = 0;
                                              break label2084;
                                              i = 0;
                                              break label2111;
                                              i = 0;
                                              break label2138;
                                              i = 0;
                                              break label2165;
                                              i = 0;
                                              break label2192;
                                              i = 0;
                                              break label2219;
                                              j = 0;
                                              break label2307;
                                              i += 1;
                                              break label2252;
                                              i = -1;
                                              break label2311;
                                              bool1 = false;
                                              break label2367;
                                            }
                                            Log.i(this.this$0.getTAG(), "FeedUpdateEvent TYPE_ACTIVITY_REMOVED id:" + this.$event.hJB.id + ",username:" + this.$event.hJB.username + ",liveStaus:" + this.$event.hJB.liveStatus);
                                          } while (this.$event.hJB.id == 0L);
                                          localObject2 = (List)this.this$0.getDataList();
                                          localObject1 = this.$event;
                                          i = 0;
                                          localObject2 = ((List)localObject2).iterator();
                                          if (!((Iterator)localObject2).hasNext()) {
                                            break label2762;
                                          }
                                          localObject3 = (cc)((Iterator)localObject2).next();
                                          if ((!(localObject3 instanceof BaseFinderFeed)) || (((BaseFinderFeed)localObject3).feedObject.getId() != ((if)localObject1).hJB.id)) {
                                            break;
                                          }
                                          j = 1;
                                          if (j == 0) {
                                            break label2755;
                                          }
                                        } while (i == -1);
                                        localObject1 = (BaseFinderFeed)this.this$0.getDataList().get(i);
                                        if (this.$event.hJB.hJD == 1)
                                        {
                                          localObject2 = ((BaseFinderFeed)localObject1).feedObject.getFeedObject().objectDesc;
                                          if (localObject2 != null) {
                                            ((FinderObjectDesc)localObject2).event = null;
                                          }
                                          this.this$0.dispatcher().Oc(i);
                                          BaseFinderFeedLoader.access$updateFinderPageItem(this.this$0, (BaseFinderFeed)localObject1);
                                        }
                                        for (;;)
                                        {
                                          locala.aiwY = true;
                                          break;
                                          j = 0;
                                          break label2658;
                                          i += 1;
                                          break label2603;
                                          i = -1;
                                          break label2662;
                                          this.this$0.dispatcher().Oc(i);
                                        }
                                        Log.i(this.this$0.getTAG(), s.X("FeedUpdateEvent TYPE_ACTIVITY_ANTI_SPAM id:", Long.valueOf(this.$event.hJB.id)));
                                      } while (this.$event.hJB.id == 0L);
                                      localObject2 = (List)this.this$0.getDataList();
                                      localObject1 = this.$event;
                                      i = 0;
                                      localObject2 = ((List)localObject2).iterator();
                                      if (!((Iterator)localObject2).hasNext()) {
                                        break label3057;
                                      }
                                      localObject3 = (cc)((Iterator)localObject2).next();
                                      if ((!(localObject3 instanceof BaseFinderFeed)) || (((BaseFinderFeed)localObject3).feedObject.getId() != ((if)localObject1).hJB.id)) {
                                        break;
                                      }
                                      j = 1;
                                      if (j == 0) {
                                        break label3050;
                                      }
                                    } while (i == -1);
                                    localObject1 = (BaseFinderFeed)this.this$0.getDataList().get(i);
                                    if (this.$event.hJB.hJD == 1)
                                    {
                                      localObject2 = ((BaseFinderFeed)localObject1).feedObject.getFeedObject().objectDesc;
                                      if (localObject2 != null)
                                      {
                                        localObject2 = ((FinderObjectDesc)localObject2).event;
                                        if (localObject2 != null)
                                        {
                                          localObject3 = this.this$0;
                                          ((brg)localObject2).eventName = "";
                                          ((brg)localObject2).ZZl = "";
                                          Log.i(((BaseFinderFeedLoader)localObject3).getTAG(), "TYPE_ACTIVITY_ANTI_SPAM value changed");
                                          localObject2 = ah.aiuX;
                                        }
                                      }
                                      this.this$0.dispatcher().Oc(i);
                                      BaseFinderFeedLoader.access$updateFinderPageItem(this.this$0, (BaseFinderFeed)localObject1);
                                    }
                                    for (;;)
                                    {
                                      locala.aiwY = true;
                                      break;
                                      j = 0;
                                      break label2909;
                                      i += 1;
                                      break label2854;
                                      i = -1;
                                      break label2913;
                                      this.this$0.dispatcher().Oc(i);
                                    }
                                  } while ((this.$event.hJB.id == 0L) || (this.$event.hJB.hJD != 1));
                                  localObject2 = (List)this.this$0.getDataList();
                                  localObject1 = this.$event;
                                  i = 0;
                                  localObject2 = ((List)localObject2).iterator();
                                  if (!((Iterator)localObject2).hasNext()) {
                                    break label3333;
                                  }
                                  localObject3 = (cc)((Iterator)localObject2).next();
                                  if (!(localObject3 instanceof x)) {
                                    break label3321;
                                  }
                                  localObject3 = ((x)localObject3).feedObject.getLiveInfo();
                                  if ((localObject3 == null) || (((bip)localObject3).liveId != ((if)localObject1).hJB.id)) {
                                    break;
                                  }
                                  j = 1;
                                  if (j == 0) {
                                    break label3321;
                                  }
                                  j = 1;
                                  if (j == 0) {
                                    break label3326;
                                  }
                                } while (i < 0);
                                localObject1 = this.this$0.getDataList().get(i);
                                if ((localObject1 instanceof x)) {}
                                for (localObject1 = (x)localObject1; localObject1 != null; localObject1 = null)
                                {
                                  localObject2 = this.$event;
                                  localObject3 = this.this$0;
                                  ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getLiveInfo(((if)localObject2).hJB.id, true, null, (b.d)new b.d()
                                  {
                                    public final void onLiveStatusCallback(long paramAnonymous3Long, int paramAnonymous3Int, Object paramAnonymous3Object)
                                    {
                                      Object localObject2 = null;
                                      AppMethodBeat.i(366278);
                                      Object localObject1;
                                      if ((paramAnonymous3Long == this.$event.hJB.id) && ((paramAnonymous3Object instanceof azl)))
                                      {
                                        String str = this.this$0.getTAG();
                                        StringBuilder localStringBuilder = new StringBuilder("TYPE_LIVE_REFRESH id:").append(this.$event.hJB.id).append(",username:").append(this.$event.hJB.username).append(",liveStaus:").append(this.$event.hJB.liveStatus).append(',');
                                        localObject1 = ((azl)paramAnonymous3Object).liveInfo;
                                        if (localObject1 != null) {
                                          break label309;
                                        }
                                        localObject1 = null;
                                        localStringBuilder = localStringBuilder.append(localObject1).append(", ori streamUrl:");
                                        localObject1 = this.$feed.feedObject.getLiveInfo();
                                        if (localObject1 != null) {
                                          break label342;
                                        }
                                        localObject1 = null;
                                        label157:
                                        localStringBuilder = localStringBuilder.append(localObject1).append(" ,new streamUrl:");
                                        localObject1 = ((azl)paramAnonymous3Object).liveInfo;
                                        if (localObject1 != null) {
                                          break label352;
                                        }
                                        localObject1 = null;
                                        label189:
                                        Log.i(str, localObject1);
                                        this.$feed.feedObject.setLiveInfo(((azl)paramAnonymous3Object).liveInfo);
                                        localObject1 = this.$feed.feedObject.getLiveFinderMedia();
                                        if (localObject1 != null)
                                        {
                                          paramAnonymous3Object = this.$feed.feedObject.getLiveInfo();
                                          if (paramAnonymous3Object != null) {
                                            break label362;
                                          }
                                        }
                                      }
                                      label309:
                                      label342:
                                      label352:
                                      label362:
                                      for (paramAnonymous3Object = localObject2;; paramAnonymous3Object = paramAnonymous3Object.mIE)
                                      {
                                        ((dji)localObject1).url = paramAnonymous3Object;
                                        this.this$0.dispatcher().Oc(i);
                                        BaseFinderFeedLoader.access$updateFinderPageItem(this.this$0, (BaseFinderFeed)this.$feed);
                                        locala.aiwY = true;
                                        AppMethodBeat.o(366278);
                                        return;
                                        localObject1 = ((bip)localObject1).ZSc;
                                        if (localObject1 == null)
                                        {
                                          localObject1 = null;
                                          break;
                                        }
                                        com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
                                        localObject1 = com.tencent.mm.plugin.finder.live.view.convert.a.a((blf)localObject1);
                                        break;
                                        localObject1 = ((bip)localObject1).mIE;
                                        break label157;
                                        localObject1 = ((bip)localObject1).mIE;
                                        break label189;
                                      }
                                    }
                                  });
                                  localObject1 = ah.aiuX;
                                  localObject1 = ah.aiuX;
                                  break;
                                  j = 0;
                                  break label3201;
                                  j = 0;
                                  break label3207;
                                  i += 1;
                                  break label3134;
                                  i = -1;
                                  break label3211;
                                }
                                Log.i(this.this$0.getTAG(), "FeedUpdateEvent TYPE_LIVE_CHANGE id:" + this.$event.hJB.id + ",username:" + this.$event.hJB.username + ",liveStaus:" + this.$event.hJB.liveStatus);
                              } while ((this.$event.hJB.id == 0L) || (this.$event.hJB.hJD != 1));
                              localObject2 = (List)this.this$0.getDataList();
                              localObject1 = this.$event;
                              i = 0;
                              localObject2 = ((List)localObject2).iterator();
                              if (((Iterator)localObject2).hasNext())
                              {
                                localObject3 = (cc)((Iterator)localObject2).next();
                                if ((localObject3 instanceof x))
                                {
                                  localObject3 = ((x)localObject3).feedObject.getLiveInfo();
                                  if ((localObject3 != null) && (((bip)localObject3).liveId == ((if)localObject1).hJB.id))
                                  {
                                    j = 1;
                                    if (j == 0) {
                                      break label4035;
                                    }
                                    j = 1;
                                    if (j == 0) {
                                      break label4040;
                                    }
                                    if (i >= 0)
                                    {
                                      localObject1 = (cc)this.this$0.getDataList().get(i);
                                      if (!(localObject1 instanceof x)) {
                                        break label4052;
                                      }
                                      localObject1 = (x)localObject1;
                                      if (localObject1 != null)
                                      {
                                        localObject2 = this.$event;
                                        localObject3 = this.this$0;
                                        localObject1 = ((BaseFinderFeed)localObject1).feedObject.getLiveInfo();
                                        if (localObject1 != null) {
                                          ((bip)localObject1).liveStatus = ((if)localObject2).hJB.liveStatus;
                                        }
                                        ((BaseFinderFeedLoader)localObject3).dispatcher().Oc(i);
                                        localObject1 = ah.aiuX;
                                        localObject1 = ah.aiuX;
                                      }
                                      locala.aiwY = true;
                                    }
                                    localObject1 = (List)this.this$0.getDataList();
                                    i = 0;
                                    localObject1 = ((List)localObject1).iterator();
                                    if (!((Iterator)localObject1).hasNext()) {
                                      break label4065;
                                    }
                                    if (!((cc)((Iterator)localObject1).next() instanceof y)) {
                                      break label4058;
                                    }
                                    j = i;
                                    if (j >= 0)
                                    {
                                      localObject1 = (cc)this.this$0.getDataList().get(j);
                                      if ((localObject1 instanceof y))
                                      {
                                        k = ((y)localObject1).pi(this.$event.hJB.id);
                                        if (k >= 0)
                                        {
                                          if (this.$event.hJB.liveStatus != 2) {
                                            break label4085;
                                          }
                                          localObject1 = (y)localObject1;
                                          i = ((y)localObject1).hqL.size();
                                          if (k < 0) {
                                            break label4075;
                                          }
                                          if (k >= i) {
                                            break label4070;
                                          }
                                          i = 1;
                                          if (i != 0) {
                                            ((y)localObject1).hqL.remove(k);
                                          }
                                          localObject2 = (Collection)((y)localObject1).eDm();
                                          if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
                                            break label4080;
                                          }
                                          i = 1;
                                          if (i != 0)
                                          {
                                            ((y)localObject1).hqL.clear();
                                            Log.i("FinderFeedLiveList", "removeItem clear list!");
                                          }
                                          localObject1 = ah.aiuX;
                                          this.this$0.dispatcher().Oc(j);
                                          if ((localObject1 instanceof z))
                                          {
                                            localObject2 = ((z)localObject1).ECN;
                                            if (localObject2 != null) {
                                              break label4110;
                                            }
                                            localObject2 = null;
                                            if (localObject2 != null) {
                                              ((bip)localObject2).liveStatus = this.$event.hJB.liveStatus;
                                            }
                                            localObject2 = this.this$0.getTAG();
                                            localObject3 = new StringBuilder("FeedUpdateEvent nickname:");
                                            localObject1 = ((z)localObject1).ECN;
                                            if (localObject1 != null) {
                                              break label4120;
                                            }
                                            localObject1 = null;
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                              for (;;)
                              {
                                Log.i((String)localObject2, localObject1 + ", live status:" + this.$event.hJB.liveStatus);
                                locala.aiwY = true;
                                localObject2 = this.$event.hJB.username;
                                if (!Util.isNullOrNil((String)localObject2)) {
                                  break label4148;
                                }
                                AppMethodBeat.o(366173);
                                return;
                                j = 0;
                                break label3543;
                                j = 0;
                                break label3549;
                                i += 1;
                                break;
                                i = -1;
                                break label3553;
                                localObject1 = null;
                                break label3588;
                                i += 1;
                                break label3681;
                                j = -1;
                                break label3709;
                                i = 0;
                                break label3801;
                                i = 0;
                                break label3801;
                                i = 0;
                                break label3842;
                                localObject1 = ((y)localObject1).hqL.get(k);
                                s.s(localObject1, "{\n                      …                        }");
                                break label3868;
                                localObject2 = ((FinderObject)localObject2).liveInfo;
                                break label3905;
                                localObject1 = ((FinderObject)localObject1).contact;
                                if (localObject1 == null) {
                                  localObject1 = null;
                                } else {
                                  localObject1 = ((FinderContact)localObject1).nickname;
                                }
                              }
                              localObject1 = (Iterable)this.this$0.getDataList();
                              localObject3 = this.this$0;
                              localObject4 = this.$event;
                              localObject5 = ((Iterable)localObject1).iterator();
                              i = 0;
                            } while (!((Iterator)localObject5).hasNext());
                            localObject1 = ((Iterator)localObject5).next();
                            if (i < 0) {
                              p.kkW();
                            }
                            localObject6 = (cc)localObject1;
                            if ((localObject6 instanceof BaseFinderFeed))
                            {
                              localObject1 = ((BaseFinderFeed)localObject6).contact;
                              if (localObject1 != null) {
                                break label4477;
                              }
                              localObject1 = null;
                              if (s.p(localObject1, localObject2))
                              {
                                localObject1 = ((BaseFinderFeed)localObject6).contact;
                                if (localObject1 != null)
                                {
                                  ((m)localObject1).field_liveStatus = ((if)localObject4).hJB.liveStatus;
                                  localObject1 = ah.aiuX;
                                  localObject1 = ah.aiuX;
                                }
                                localObject1 = ((BaseFinderFeed)localObject6).feedObject.getFeedObject().contact;
                                if (localObject1 != null)
                                {
                                  ((FinderContact)localObject1).liveStatus = ((if)localObject4).hJB.liveStatus;
                                  localObject1 = ah.aiuX;
                                  localObject1 = ah.aiuX;
                                }
                                ((BaseFinderFeedLoader)localObject3).dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(7), localObject4));
                                BaseFinderFeedLoader.access$updateFinderPageItem((BaseFinderFeedLoader)localObject3, (BaseFinderFeed)localObject6);
                                localObject7 = ((BaseFinderFeedLoader)localObject3).getTAG();
                                localObject8 = new StringBuilder("FeedUpdateEvent TYPE_LIVE_CHANGE username:").append(localObject2).append(",nickname:");
                                localObject1 = ((BaseFinderFeed)localObject6).contact;
                                if (localObject1 != null) {
                                  break label4487;
                                }
                              }
                            }
                            for (localObject1 = null;; localObject1 = ((m)localObject1).getNickname())
                            {
                              Log.i((String)localObject7, localObject1 + ",feed id:" + ((cc)localObject6).bZA() + ",live status:" + ((if)localObject4).hJB.liveStatus);
                              locala.aiwY = true;
                              i += 1;
                              break;
                              localObject1 = ((m)localObject1).getUsername();
                              break label4242;
                            }
                            Log.i(this.this$0.getTAG(), "FeedUpdateEvent TYPE_LIVE_STREAM_CHANGE id:" + this.$event.hJB.id + ",feedList:" + this.$event.hJB.hJG + ",liveStaus:" + this.$event.hJB.liveStatus + ",username:" + this.$event.hJB.username);
                            if (this.$event.hJB.hJD == 1)
                            {
                              localObject2 = (List)this.this$0.getDataList();
                              localObject1 = this.$event;
                              i = 0;
                              localObject2 = ((List)localObject2).iterator();
                              if (!((Iterator)localObject2).hasNext()) {
                                break label5209;
                              }
                              localObject3 = (cc)((Iterator)localObject2).next();
                              if ((!(localObject3 instanceof y)) || (((y)localObject3).ECK != ((if)localObject1).hJB.id)) {
                                break;
                              }
                              j = 1;
                              if (j == 0) {
                                break label5202;
                              }
                              if (i >= 0)
                              {
                                localObject1 = (cc)this.this$0.getDataList().get(i);
                                if (!(localObject1 instanceof y)) {
                                  break label5214;
                                }
                                localObject1 = (y)localObject1;
                                if (localObject1 != null)
                                {
                                  localObject1 = this.this$0;
                                  localObject2 = this.$event;
                                  ((BaseFinderFeedLoader)localObject1).dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(2), Long.valueOf(((if)localObject2).hJB.id)));
                                  localObject1 = ah.aiuX;
                                  localObject1 = ah.aiuX;
                                }
                                locala.aiwY = true;
                              }
                            }
                            localObject1 = com.tencent.mm.plugin.finder.model.d.ECf;
                            localObject1 = this.$event.hJB.username;
                            s.s(localObject1, "event.data.username");
                            localObject1 = (Iterable)com.tencent.mm.plugin.finder.model.d.a.ayP((String)localObject1);
                            localObject2 = this.this$0;
                            localObject3 = this.$event;
                            localObject4 = ((Iterable)localObject1).iterator();
                          } while (!((Iterator)localObject4).hasNext());
                          localObject5 = (String)((Iterator)localObject4).next();
                          localObject6 = ((Iterable)((BaseFinderFeedLoader)localObject2).getDataList()).iterator();
                          i = 0;
                          StringBuilder localStringBuilder;
                          if (((Iterator)localObject6).hasNext())
                          {
                            localObject1 = ((Iterator)localObject6).next();
                            if (i < 0) {
                              p.kkW();
                            }
                            localObject7 = (cc)localObject1;
                            if (((CharSequence)localObject5).length() <= 0) {
                              break label5220;
                            }
                            j = 1;
                            if ((j != 0) && ((localObject7 instanceof BaseFinderFeed)))
                            {
                              localObject1 = ((BaseFinderFeed)localObject7).contact;
                              if (localObject1 != null) {
                                break label5225;
                              }
                              localObject1 = null;
                              if (s.p(localObject1, localObject5))
                              {
                                localObject1 = ((BaseFinderFeed)localObject7).contact;
                                if (localObject1 != null)
                                {
                                  ((m)localObject1).field_liveStatus = ((if)localObject3).hJB.liveStatus;
                                  localObject1 = ah.aiuX;
                                  localObject1 = ah.aiuX;
                                }
                                localObject1 = ((BaseFinderFeed)localObject7).feedObject.getFeedObject().contact;
                                if (localObject1 != null)
                                {
                                  ((FinderContact)localObject1).liveStatus = ((if)localObject3).hJB.liveStatus;
                                  localObject1 = ah.aiuX;
                                  localObject1 = ah.aiuX;
                                }
                                ((BaseFinderFeedLoader)localObject2).dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(7), localObject3));
                                BaseFinderFeedLoader.access$updateFinderPageItem((BaseFinderFeedLoader)localObject2, (BaseFinderFeed)localObject7);
                                localObject8 = ((BaseFinderFeedLoader)localObject2).getTAG();
                                localStringBuilder = new StringBuilder("FeedUpdateEvent username:").append((String)localObject5).append(",nickname:");
                                localObject1 = ((BaseFinderFeed)localObject7).contact;
                                if (localObject1 != null) {
                                  break label5235;
                                }
                              }
                            }
                          }
                          for (localObject1 = null;; localObject1 = ((m)localObject1).getNickname())
                          {
                            Log.i((String)localObject8, localObject1 + ",feed id:" + ((cc)localObject7).bZA() + ",live status:" + ((if)localObject3).hJB.liveStatus);
                            locala.aiwY = true;
                            i += 1;
                            break label4884;
                            break label4845;
                            j = 0;
                            break label4685;
                            i += 1;
                            break;
                            i = -1;
                            break label4689;
                            localObject1 = null;
                            break label4724;
                            j = 0;
                            break label4932;
                            localObject1 = ((m)localObject1).getUsername();
                            break label4962;
                          }
                          localObject1 = (g)com.tencent.mm.kernel.h.ax(g.class);
                          localObject2 = this.$event.hJB.username;
                          s.s(localObject2, "event.data.username");
                          localObject1 = (Iterable)((g)localObject1).Sx((String)localObject2);
                          localObject2 = this.this$0;
                          localObject3 = this.$event;
                          localObject4 = ((Iterable)localObject1).iterator();
                        } while (!((Iterator)localObject4).hasNext());
                        localObject5 = (String)((Iterator)localObject4).next();
                        localObject6 = ((Iterable)((BaseFinderFeedLoader)localObject2).getDataList()).iterator();
                        i = 0;
                        if (((Iterator)localObject6).hasNext())
                        {
                          localObject1 = ((Iterator)localObject6).next();
                          if (i < 0) {
                            p.kkW();
                          }
                          localObject1 = (cc)localObject1;
                          if (((CharSequence)localObject5).length() <= 0) {
                            break label5485;
                          }
                          j = 1;
                          if ((j != 0) && ((localObject1 instanceof BaseFinderFeed)))
                          {
                            localObject1 = ((BaseFinderFeed)localObject1).contact;
                            if (localObject1 != null) {
                              break label5490;
                            }
                          }
                        }
                        for (localObject1 = null;; localObject1 = ((m)localObject1).getUsername())
                        {
                          if (s.p(localObject1, localObject5))
                          {
                            ((BaseFinderFeedLoader)localObject2).dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(8), localObject3));
                            Log.i(((BaseFinderFeedLoader)localObject2).getTAG(), s.X("TYPE_FEED_LIVE_NOTICE username:", localObject5));
                          }
                          i += 1;
                          break label5350;
                          break;
                          j = 0;
                          break label5398;
                        }
                        localObject2 = (List)this.this$0.getDataList();
                        localObject1 = this.$event;
                        i = 0;
                        localObject2 = ((List)localObject2).iterator();
                        if (((Iterator)localObject2).hasNext())
                        {
                          localObject3 = (cc)((Iterator)localObject2).next();
                          if (((localObject3 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject3).feedObject.getId() == ((if)localObject1).hJB.id))
                          {
                            j = 1;
                            if (j == 0) {
                              break label5678;
                            }
                          }
                        }
                        while (i != -1)
                        {
                          this.this$0.dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(26), Integer.valueOf(1)));
                          Log.i(this.this$0.getTAG(), "TYPE_FINDER_AD_MUTUAL_INFO index:" + i + " id:" + com.tencent.mm.ae.d.hF(this.$event.hJB.id));
                          break;
                          j = 0;
                          break label5584;
                          i += 1;
                          break label5529;
                          i = -1;
                        }
                        localObject2 = (List)this.this$0.getDataList();
                        localObject1 = this.$event;
                        i = 0;
                        localObject2 = ((List)localObject2).iterator();
                        if (((Iterator)localObject2).hasNext())
                        {
                          localObject3 = (cc)((Iterator)localObject2).next();
                          if (((localObject3 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject3).feedObject.getId() == ((if)localObject1).hJB.id))
                          {
                            j = 1;
                            if (j == 0) {
                              break label5869;
                            }
                          }
                        }
                        while (i != -1)
                        {
                          this.this$0.dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(27), Integer.valueOf(10)));
                          Log.i(this.this$0.getTAG(), "TYPE_FINDER_AD_SNS_INFO index:" + i + " id:" + com.tencent.mm.ae.d.hF(this.$event.hJB.id));
                          break;
                          j = 0;
                          break label5774;
                          i += 1;
                          break label5719;
                          i = -1;
                        }
                        localObject2 = (List)this.this$0.getDataList();
                        localObject1 = this.$event;
                        i = 0;
                        localObject2 = ((List)localObject2).iterator();
                        if (!((Iterator)localObject2).hasNext()) {
                          break label6204;
                        }
                        localObject3 = (cc)((Iterator)localObject2).next();
                        if ((!(localObject3 instanceof BaseFinderFeed)) || (((BaseFinderFeed)localObject3).feedObject.getId() != ((if)localObject1).hJB.id)) {
                          break;
                        }
                        j = 1;
                        if (j == 0) {
                          break label6197;
                        }
                      } while (i == -1);
                      localObject1 = this.this$0.getDataList().get(i);
                      if (!(localObject1 instanceof BaseFinderFeed)) {
                        break label6209;
                      }
                      localObject1 = (BaseFinderFeed)localObject1;
                      if (localObject1 == null) {
                        break label6215;
                      }
                      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
                      if (localObject1 == null) {
                        break label6215;
                      }
                      localObject1 = ((FinderItem)localObject1).getFeedObject();
                      if ((localObject1 == null) || (((FinderObject)localObject1).adFlag != this.$event.hJB.adFlag)) {
                        break label6215;
                      }
                      j = 1;
                    } while (j != 0);
                    localObject1 = this.this$0.getDataList().get(i);
                    if ((localObject1 instanceof BaseFinderFeed))
                    {
                      localObject1 = (BaseFinderFeed)localObject1;
                      if (localObject1 != null) {
                        break label6226;
                      }
                      localObject1 = null;
                    }
                    for (;;)
                    {
                      if (localObject1 != null) {
                        ((FinderObject)localObject1).adFlag = this.$event.hJB.adFlag;
                      }
                      this.this$0.dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(28), Integer.valueOf(10)));
                      Log.i(this.this$0.getTAG(), "TYPE_FINDER_AD_STAT_CHANGED index:" + i + " id:" + com.tencent.mm.ae.d.hF(this.$event.hJB.id));
                      break;
                      j = 0;
                      break label5965;
                      i += 1;
                      break label5910;
                      i = -1;
                      break label5969;
                      localObject1 = null;
                      break label6002;
                      j = 0;
                      break label6051;
                      localObject1 = null;
                      break label6083;
                      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
                      if (localObject1 == null) {
                        localObject1 = null;
                      } else {
                        localObject1 = ((FinderItem)localObject1).getFeedObject();
                      }
                    }
                    Log.i(this.this$0.getTAG(), "FeedLiveListItemUpdateEvent TYPE_LIVE_LIST_ITEM_STATUS_CHANGE id:" + this.$event.hJB.id + ",feedList:" + this.$event.hJB.hJG + ",liveStaus:" + this.$event.hJB.liveStatus + ",username:" + this.$event.hJB.username);
                    localObject1 = (List)this.this$0.getDataList();
                    i = 0;
                    localObject1 = ((List)localObject1).iterator();
                    if (!((Iterator)localObject1).hasNext()) {
                      break label6618;
                    }
                    if (!((cc)((Iterator)localObject1).next() instanceof y)) {
                      break;
                    }
                  } while (i < 0);
                  localObject1 = (cc)this.this$0.getDataList().get(i);
                } while (!(localObject1 instanceof y));
                localObject6 = ((y)localObject1).pj(this.$event.hJB.id);
              } while (localObject6 == null);
              label663:
              label825:
              label1082:
              label1353:
              label1360:
              label1365:
              label1391:
              label2417:
              label4085:
              label4477:
              localObject2 = this.$event;
              label770:
              label926:
              label1312:
              label1512:
              label2030:
              label3057:
              label4724:
              label6396:
              localObject3 = this.this$0;
              label1026:
              label1567:
              label1571:
              label1587:
              label1756:
              label1763:
              label1768:
              label3050:
              label4075:
              label4080:
              label5235:
              localObject1 = ((z)localObject6).ECN;
              label1875:
              label2138:
              label2658:
              label2662:
              label4845:
              label5490:
              label6002:
              if (localObject1 == null)
              {
                localObject1 = null;
                if (localObject1 != null) {
                  ((bip)localObject1).liveStatus = ((if)localObject2).hJB.liveStatus;
                }
                localObject4 = ((BaseFinderFeedLoader)localObject3).getTAG();
                localObject5 = new StringBuilder("FeedLiveListItemUpdateEvent nickname:");
                localObject1 = ((z)localObject6).ECN;
                if (localObject1 != null) {
                  break label6633;
                }
                localObject1 = null;
              }
              for (;;)
              {
                label1930:
                label1980:
                label2111:
                label2252:
                label2909:
                label2913:
                label3553:
                label4070:
                label5225:
                label5485:
                Log.i((String)localObject4, localObject1 + ", live status:" + ((if)localObject2).hJB.liveStatus);
                label2057:
                label2084:
                label2219:
                label2367:
                label2755:
                label2762:
                label3543:
                label3549:
                label3681:
                label4962:
                label5220:
                label5350:
                label5869:
                ((BaseFinderFeedLoader)localObject3).dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(3), Long.valueOf(((if)localObject2).hJB.id)));
                label2192:
                label2452:
                label2457:
                label2462:
                label2469:
                label2480:
                label3134:
                label3801:
                label4058:
                label4065:
                label6370:
                locala.aiwY = true;
                label2307:
                label2311:
                label2442:
                label2447:
                label2603:
                label3905:
                label4035:
                label4040:
                label4052:
                label5209:
                label5214:
                localObject1 = ah.aiuX;
                label2432:
                label2437:
                label2854:
                label4148:
                label4685:
                label4689:
                label5202:
                label5719:
                localObject1 = ah.aiuX;
                label3201:
                label3207:
                label3211:
                label3868:
                label4932:
                label5584:
                label5969:
                label6226:
                break;
                label3333:
                label4110:
                label4120:
                label5529:
                label5678:
                label5965:
                i += 1;
                label3588:
                label4242:
                label4884:
                label5398:
                label5910:
                label6051:
                label6083:
                label6215:
                label6476:
                break label6370;
                label3842:
                label4487:
                label5774:
                label6197:
                label6204:
                label6209:
                label6618:
                i = -1;
                break label6396;
                localObject1 = ((FinderObject)localObject1).liveInfo;
                break label6476;
                label6633:
                localObject1 = ((FinderObject)localObject1).contact;
                if (localObject1 == null) {
                  localObject1 = null;
                } else {
                  localObject1 = ((FinderContact)localObject1).nickname;
                }
              }
            }
            Object localObject2 = (List)this.this$0.getDataList();
            Object localObject1 = this.$event;
            final int i = 0;
            localObject2 = ((List)localObject2).iterator();
            label6690:
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (cc)((Iterator)localObject2).next();
              if (((localObject3 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject3).feedObject.getId() == ((if)localObject1).hJB.id))
              {
                j = 1;
                label6745:
                if (j == 0) {
                  break label6833;
                }
              }
            }
            for (;;)
            {
              Log.i(this.this$0.getTAG(), "FeedUpdateEvent TYPE_OP_COUNT_CHANGED, feedId = " + this.$event.hJB.id + ", index = " + i);
              if (i == -1) {
                break;
              }
              this.this$0.dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(12), null));
              break;
              j = 0;
              break label6745;
              label6833:
              i += 1;
              break label6690;
              i = -1;
            }
          }
        });
        AppMethodBeat.o(366306);
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
        Object localObject2 = com.tencent.mm.plugin.finder.storage.data.k.FNg;
        long l = paramBaseFinderFeed.bZA();
        localObject2 = paramBaseFinderFeed.feedObject.getFeedObject();
        s.u(localObject2, "item");
        Log.i("Finder.FinderPage", "updatePageData pageName:" + i + ", svrId:" + l);
        if (i >= 0) {
          try
          {
            k.a.Tw(i);
            Object localObject3 = k.a.a(com.tencent.mm.plugin.finder.storage.data.k.faf().Tx(i), "");
            if (localObject3 != null)
            {
              localObject3 = ((axv)localObject3).lPK;
              if (localObject3 != null)
              {
                com.tencent.mm.plugin.finder.storage.data.h localh = com.tencent.mm.plugin.finder.storage.data.h.FMZ;
                if (com.tencent.mm.plugin.finder.storage.data.h.a(l, (FinderObject)localObject2, (LinkedList)localObject3))
                {
                  localObject2 = com.tencent.mm.plugin.finder.storage.data.k.FNg;
                  k.a.a(com.tencent.mm.plugin.finder.storage.data.k.faf().Tx(i));
                }
              }
            }
          }
          finally
          {
            if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
              throw localThrowable;
            }
            Log.printErrStackTrace("Finder.FinderPage", localThrowable, s.X("updatePageData ", Integer.valueOf(i)), new Object[0]);
          }
        }
      }
    }
  }
  
  public void addRvFeed(int paramInt, cc paramcc)
  {
    s.u(paramcc, "feed");
    getDataList().add(paramInt, paramcc);
  }
  
  public List<Integer> colletExtraPageName()
  {
    return (List)new ArrayList();
  }
  
  protected final cc getItem(long paramLong)
  {
    Iterator localIterator = ((List)getDataList()).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((cc)localIterator.next()).bZA() == paramLong)
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
      return (cc)getDataList().get(i);
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
  
  public int insert(cc paramcc, int paramInt, boolean paramBoolean)
  {
    s.u(paramcc, "feed");
    int i = getDataList().indexOf(paramcc);
    if (i == paramInt) {}
    do
    {
      do
      {
        return paramInt;
        if (i >= 0) {
          getDataList().remove(paramcc);
        }
      } while (paramInt < 0);
      addRvFeed(paramInt, paramcc);
    } while (!paramBoolean);
    dispatcher().onItemRangeInserted(paramInt, 1);
    return paramInt;
  }
  
  public void insertAll(List<? extends cc> paramList, int paramInt)
  {
    s.u(paramList, "feeds");
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
    if (isObservePostEvent()) {
      ((c)com.tencent.mm.kernel.h.az(c.class)).finderPostManager().a((com.tencent.mm.plugin.finder.upload.r)this);
    }
    this.feedDeleteListener.alive();
    this.feedChangeListener.alive();
  }
  
  public void onDataChanged() {}
  
  public void onDead()
  {
    super.onDead();
    if (isObservePostEvent()) {
      ((c)com.tencent.mm.kernel.h.az(c.class)).finderPostManager().b((com.tencent.mm.plugin.finder.upload.r)this);
    }
    this.feedDeleteListener.dead();
    this.feedChangeListener.dead();
  }
  
  public void onFetchDone(IResponse paramIResponse)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aYj());
    super.onFetchDone(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
  }
  
  public void onFetchInitDone(IResponse<cc> paramIResponse)
  {
    Object localObject = null;
    s.u(paramIResponse, "initResponse");
    super.onFetchInitDone(paramIResponse);
    paramIResponse = paramIResponse.getIncrementList();
    if (paramIResponse == null) {
      paramIResponse = (IResponse<cc>)localObject;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.feed.component.d.Bca;
      com.tencent.mm.plugin.finder.feed.component.d.a.edf().gb(paramIResponse);
      return;
      List localList = p.a((Iterable)paramIResponse, BaseFinderFeed.class);
      paramIResponse = (IResponse<cc>)localObject;
      if (localList != null)
      {
        localObject = (Iterable)localList;
        paramIResponse = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramIResponse.add(((BaseFinderFeed)((Iterator)localObject).next()).feedObject);
        }
        paramIResponse = (List)paramIResponse;
      }
    }
  }
  
  public void onFetchInsertedDone(IResponse<cc> paramIResponse)
  {
    Object localObject = null;
    s.u(paramIResponse, "initResponse");
    super.onFetchInsertedDone(paramIResponse);
    paramIResponse = paramIResponse.getIncrementList();
    if (paramIResponse == null) {
      paramIResponse = (IResponse<cc>)localObject;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.feed.component.d.Bca;
      com.tencent.mm.plugin.finder.feed.component.d.a.edf().gb(paramIResponse);
      return;
      List localList = p.a((Iterable)paramIResponse, BaseFinderFeed.class);
      paramIResponse = (IResponse<cc>)localObject;
      if (localList != null)
      {
        localObject = (Iterable)localList;
        paramIResponse = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramIResponse.add(((BaseFinderFeed)((Iterator)localObject).next()).feedObject);
        }
        paramIResponse = (List)paramIResponse;
      }
    }
  }
  
  public void onFetchLoadMoreDone(IResponse<cc> paramIResponse)
  {
    Object localObject = null;
    s.u(paramIResponse, "initResponse");
    super.onFetchLoadMoreDone(paramIResponse);
    paramIResponse = paramIResponse.getIncrementList();
    if (paramIResponse == null) {
      paramIResponse = (IResponse<cc>)localObject;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.feed.component.d.Bca;
      com.tencent.mm.plugin.finder.feed.component.d.a.edf().gb(paramIResponse);
      return;
      List localList = p.a((Iterable)paramIResponse, BaseFinderFeed.class);
      paramIResponse = (IResponse<cc>)localObject;
      if (localList != null)
      {
        localObject = (Iterable)localList;
        paramIResponse = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramIResponse.add(((BaseFinderFeed)((Iterator)localObject).next()).feedObject);
        }
        paramIResponse = (List)paramIResponse;
      }
    }
  }
  
  public void onFetchRefreshDone(IResponse<cc> paramIResponse)
  {
    Object localObject = null;
    s.u(paramIResponse, "initResponse");
    super.onFetchRefreshDone(paramIResponse);
    paramIResponse = paramIResponse.getIncrementList();
    if (paramIResponse == null) {
      paramIResponse = (IResponse<cc>)localObject;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.feed.component.d.Bca;
      com.tencent.mm.plugin.finder.feed.component.d.a.edf().gb(paramIResponse);
      return;
      List localList = p.a((Iterable)paramIResponse, BaseFinderFeed.class);
      paramIResponse = (IResponse<cc>)localObject;
      if (localList != null)
      {
        localObject = (Iterable)localList;
        paramIResponse = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramIResponse.add(((BaseFinderFeed)((Iterator)localObject).next()).feedObject);
        }
        paramIResponse = (List)paramIResponse;
      }
    }
  }
  
  public void onMvPostStart(FinderItem paramFinderItem)
  {
    s.u(paramFinderItem, "item");
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
  
  public void onPostStart(long paramLong, boolean paramBoolean)
  {
    int i = 0;
    onDataChanged();
    if (interceptPostStart()) {}
    Object localObject1;
    Object localObject2;
    Object localObject3;
    do
    {
      do
      {
        return;
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.a.qr(paramLong);
      } while (localObject1 == null);
      localObject2 = new ArrayList();
      localObject3 = transformFinderObj((FinderItem)localObject1);
    } while ((((BaseFinderFeed)localObject3).feedObject.isMvFeed()) && (interceptMvPostStart()));
    Log.i(getTAG(), "onPostStart localId " + paramLong + " feed " + localObject3);
    aw localaw = aw.Gjk;
    boolean bool;
    if (!aw.eKm())
    {
      bool = true;
      ((BaseFinderFeed)localObject3).showLikeTips = bool;
      ((BaseFinderFeed)localObject3).showShareSns = paramBoolean;
      if (!(p.oL((List)getDataList()) instanceof y)) {
        break label216;
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new u((BaseFinderFeed)localObject3)
      {
        public final void invoke()
        {
          AppMethodBeat.i(365848);
          this.this$0.getDataList().add(1, this.$feed);
          this.this$0.dispatcher().onItemRangeInserted(1, 1);
          AppMethodBeat.o(365848);
        }
      });
      label160:
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject2 = (i)com.tencent.mm.ui.component.k.cn(cn.class).q(i.class);
      localObject1 = p.listOf(localObject1);
      localObject3 = getContextObj();
      if (localObject3 != null) {
        break label246;
      }
    }
    for (;;)
    {
      ((i)localObject2).F((List)localObject1, i);
      return;
      bool = false;
      break;
      label216:
      ((ArrayList)localObject2).add(localObject3);
      com.tencent.mm.plugin.finder.feed.model.internal.d.mergeDataAndNotify$default(getMerger(), 2, (List)localObject2, true, null, 8, null);
      break label160;
      label246:
      i = ((bui)localObject3).AJo;
    }
  }
  
  public int remove(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = ((List)getDataList()).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((cc)localIterator.next()).bZA() == paramLong)
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
        s.s(getDataList().remove(i), "dataList.removeAt(index)");
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
      cc localcc = (cc)localIterator.next();
      if (((localcc instanceof BaseFinderFeed)) && (((BaseFinderFeed)localcc).feedObject.getLocalId() == paramLong))
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
        s.s(getDataList().remove(i), "dataList.removeAt(index)");
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
  
  public void requestLoadMore(bnn parambnn) {}
  
  public BaseFinderFeed transformFinderObj(FinderItem paramFinderItem)
  {
    s.u(paramFinderItem, "feedObj");
    com.tencent.mm.plugin.finder.storage.logic.d.a locala = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    return com.tencent.mm.plugin.finder.storage.logic.d.a.a(paramFinderItem);
  }
  
  public BaseFinderFeed transformToMusicData(FinderItem paramFinderItem)
  {
    s.u(paramFinderItem, "item");
    return transformFinderObj(paramFinderItem);
  }
  
  public final int updateByLocalId(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean)
  {
    s.u(paramBaseFinderFeed, "newFeed");
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
        break label224;
      }
      Object localObject = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (cc)localObject;
      if (((localObject instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject).feedObject.getLocalId() == paramBaseFinderFeed.feedObject.getLocalId()))
      {
        paramBaseFinderFeed.showLikeTips = ((BaseFinderFeed)localObject).showLikeTips;
        paramBaseFinderFeed.showShareSns = ((BaseFinderFeed)localObject).showShareSns;
        getDataList().set(i, paramBaseFinderFeed);
        j = i;
        if (!paramBoolean) {
          break;
        }
        Log.i(getTAG(), s.X("updateByLocalId ", Long.valueOf(paramBaseFinderFeed.feedObject.getLocalId())));
        if (interceptMvFeed())
        {
          dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(20), Integer.valueOf(1)));
          return i;
        }
        dispatcher().onItemRangeChanged(i, 1, Integer.valueOf(1));
        return i;
      }
      i += 1;
    }
    label224:
    return -1;
  }
  
  protected final BaseFinderFeed updateItem(long paramLong1, long paramLong2)
  {
    Object localObject1 = e.FMN;
    localObject1 = e.a.jn(paramLong2);
    if (localObject1 != null) {
      ((FinderItem)localObject1).setLocalId(paramLong1);
    }
    if (localObject1 != null)
    {
      Log.i(getTAG(), "updateItem localId:" + paramLong1 + " itemLoadId:" + ((FinderItem)localObject1).getLocalId() + " itemId:" + ((FinderItem)localObject1).getId());
      Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject2 = (i)com.tencent.mm.ui.component.k.cn(cn.class).q(i.class);
      List localList = p.listOf(localObject1);
      bui localbui = getContextObj();
      if (localbui == null) {}
      for (int i = 0;; i = localbui.AJo)
      {
        ((i)localObject2).F(localList, i);
        localObject1 = transformFinderObj((FinderItem)localObject1);
        updateByLocalId((BaseFinderFeed)localObject1, true);
        return localObject1;
      }
    }
    return null;
  }
  
  protected final void updateItem(long paramLong)
  {
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    localObject = com.tencent.mm.plugin.finder.storage.logic.d.a.qr(paramLong);
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
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new u(paramLong)
    {
      public final void invoke()
      {
        AppMethodBeat.i(366202);
        Object localObject1 = (Iterable)this.this$0.getDataList();
        long l = paramLong;
        BaseFinderFeedLoader localBaseFinderFeedLoader = this.this$0;
        localObject1 = ((Iterable)localObject1).iterator();
        int i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          if (i < 0) {
            p.kkW();
          }
          localObject2 = (cc)localObject2;
          if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getLocalId() == l))
          {
            Object localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
            Object localObject4 = com.tencent.mm.plugin.finder.storage.logic.d.a.qr(l);
            if (localObject4 != null)
            {
              boolean bool = ((BaseFinderFeed)localObject2).showLikeTips;
              localObject3 = localBaseFinderFeedLoader.getDataList();
              localObject4 = localBaseFinderFeedLoader.transformFinderObj((FinderItem)localObject4);
              ((BaseFinderFeed)localObject4).showLikeTips = bool;
              ((BaseFinderFeed)localObject4).showShareSns = ((BaseFinderFeed)localObject2).showShareSns;
              ah localah = ah.aiuX;
              ((DataBuffer)localObject3).set(i, localObject4);
            }
            Log.i(localBaseFinderFeedLoader.getTAG(), s.X("updateProgressByLoalId ", Long.valueOf(((BaseFinderFeed)localObject2).feedObject.getLocalId())));
            localBaseFinderFeedLoader.dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(2), Integer.valueOf(1)));
          }
          i += 1;
        }
        AppMethodBeat.o(366202);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
 * JD-Core Version:    0.7.0.1
 */