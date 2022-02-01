package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.as;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderGetJustWatched;", "", "username", "", "curTopicId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "nowLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "nowHasMore", "", "nowMaxId", "readExist", "dataListSize", "", "readFeedId", "callback", "Lkotlin/Function7;", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "", "finishLoadingMoreCallback", "Lkotlin/Function0;", "(Ljava/lang/String;JLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protobuf/ByteString;ZJZILjava/lang/Long;Lkotlin/jvm/functions/Function7;Lkotlin/jvm/functions/Function0;)V", "beginIndex", "getCallback", "()Lkotlin/jvm/functions/Function7;", "cancelLoadMore", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getCurTopicId", "()J", "getDataListSize", "()I", "setDataListSize", "(I)V", "getFinishLoadingMoreCallback", "()Lkotlin/jvm/functions/Function0;", "hasMore", "isCancel", "lastBuffer", "maxId", "needToFilterLiveData", "getNowHasMore", "()Z", "getNowLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getNowMaxId", "getReadExist", "setReadExist", "(Z)V", "getReadFeedId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "thisTimeLoopCount", "getUsername", "()Ljava/lang/String;", "watchedDataList", "cancel", "getLastItem", "justWatchedLooper", "updateIndex", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
{
  public static final u.a AVL;
  private final com.tencent.mm.bx.b AVM;
  private final boolean AVN;
  private final long AVO;
  int AVP;
  final kotlin.g.a.u<Boolean, Long, Boolean, ArrayList<cc>, com.tencent.mm.bx.b, Integer, Boolean, ah> AVQ;
  private ArrayList<cc> AVR;
  public boolean AVS;
  public int AVT;
  private int AVU;
  final bui Auc;
  final long curTopicId;
  final kotlin.g.a.a<ah> finishLoadingMoreCallback;
  private boolean hasMore;
  private com.tencent.mm.bx.b lastBuffer;
  private long maxId;
  private boolean needToFilterLiveData;
  private boolean nzW;
  boolean readExist;
  final Long readFeedId;
  final String username;
  
  static
  {
    AppMethodBeat.i(362733);
    AVL = new u.a((byte)0);
    AppMethodBeat.o(362733);
  }
  
  public u(String paramString, long paramLong, bui parambui, com.tencent.mm.bx.b paramb, boolean paramBoolean1, boolean paramBoolean2, int paramInt, Long paramLong1, kotlin.g.a.u<? super Boolean, ? super Long, ? super Boolean, ? super ArrayList<cc>, ? super com.tencent.mm.bx.b, ? super Integer, ? super Boolean, ah> paramu, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(362620);
    this.username = paramString;
    this.curTopicId = paramLong;
    this.Auc = parambui;
    this.AVM = paramb;
    this.AVN = paramBoolean1;
    this.AVO = 0L;
    this.readExist = paramBoolean2;
    this.AVP = paramInt;
    this.readFeedId = paramLong1;
    this.AVQ = paramu;
    this.finishLoadingMoreCallback = parama;
    this.AVR = new ArrayList();
    this.lastBuffer = this.AVM;
    this.hasMore = this.AVN;
    this.maxId = this.AVO;
    this.AVU = 5;
    AppMethodBeat.o(362620);
  }
  
  public final long getLastItem()
  {
    AppMethodBeat.i(362742);
    int i = this.AVR.size() - 1;
    if (i >= 0) {}
    for (;;)
    {
      int j = i - 1;
      Object localObject = this.AVR.get(i);
      s.s(localObject, "watchedDataList[index]");
      localObject = (cc)localObject;
      if (((localObject instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject).feedObject.getId() != 0L))
      {
        long l = ((BaseFinderFeed)localObject).feedObject.getId();
        AppMethodBeat.o(362742);
        return l;
      }
      if (j < 0)
      {
        AppMethodBeat.o(362742);
        return 0L;
      }
      i = j;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    public c(u paramu, ah.a parama, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(363557);
      paramd = new c(this.AVV, this.AVW, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(363557);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(363552);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(363552);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = (aq)this.L$0;
      }
      final int i;
      Object localObject6;
      try
      {
        paramObject = this.AVV;
        i = u.a(paramObject);
        u.a(paramObject, i - 1);
        if ((i != 0) && (!this.AVV.readExist) && (u.b(this.AVV)) && (!u.c(this.AVV)))
        {
          paramObject = (com.tencent.mm.am.b)new as(this.AVV.username, u.d(this.AVV), u.e(this.AVV), this.AVV.Auc, this.AVV.curTopicId);
          localObject2 = (kotlin.d.d)this;
          this.L$0 = localObject1;
          this.label = 1;
          localObject2 = com.tencent.mm.af.b.a(paramObject, (kotlin.d.d)localObject2);
          localObject3 = localObject2;
          paramObject = localObject1;
          if (localObject2 == locala)
          {
            AppMethodBeat.o(363552);
            return locala;
            localObject2 = (aq)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            localObject1 = paramObject;
            paramObject = localObject2;
            localObject3 = localObject1;
          }
          localObject1 = (FinderUserPageResponse)localObject3;
          localObject2 = ((FinderUserPageResponse)localObject1).object;
          s.checkNotNull(localObject2);
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList();
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = ((Iterator)localObject3).next();
            localObject5 = (FinderObject)localObject4;
            localObject6 = av.GiL;
            if (av.y((FinderObject)localObject5)) {
              ((Collection)localObject2).add(localObject4);
            }
          }
        }
        localObject2 = (List)localObject2;
      }
      catch (Exception paramObject)
      {
        this.AVW.aiwY = true;
        paramObject = this.AVV.AVQ;
        if (paramObject != null) {
          paramObject.invoke(Boolean.valueOf(this.AVW.aiwY), kotlin.d.b.a.b.BF(u.d(this.AVV)), Boolean.valueOf(u.b(this.AVV)), u.g(this.AVV), u.e(this.AVV), Integer.valueOf(-2), Boolean.TRUE);
        }
        Log.i("Finder.FinderGetJustWatched", "justWatched request ERROR");
        paramObject = ah.aiuX;
        AppMethodBeat.o(363552);
        return paramObject;
      }
      Object localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      localObject3 = d.a.a((List)localObject2, 2, this.AVV.Auc);
      Object localObject2 = new ah.f();
      Object localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (FinderItem)((Iterator)localObject4).next();
        localObject6 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        ((Collection)localObject3).add(d.a.a((FinderItem)localObject5));
      }
      Object localObject5 = (Iterable)localObject3;
      localObject3 = this.AVV;
      localObject4 = (Collection)new ArrayList();
      localObject5 = ((Iterable)localObject5).iterator();
      label581:
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = ((Iterator)localObject5).next();
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)localObject6;
        if ((!u.h((u)localObject3)) || (localBaseFinderFeed.feedObject.getMediaType() != 9)) {
          break label1017;
        }
        i = 1;
        label630:
        if (i != 0) {
          break label1020;
        }
        ((Collection)localObject4).add(localObject6);
      }
      ((ah.f)localObject2).aqH = ((List)localObject4);
      u.a(this.AVV, ((FinderUserPageResponse)localObject1).lastBuffer);
      u.a(this.AVV, this.AVV.getLastItem());
      localObject3 = this.AVV;
      boolean bool;
      if (((FinderUserPageResponse)localObject1).continueFlag == 1)
      {
        bool = true;
        label701:
        u.a((u)localObject3, bool);
        localObject1 = (List)((ah.f)localObject2).aqH;
        if (localObject1 != null)
        {
          localObject4 = (Iterable)localObject1;
          localObject1 = this.AVV;
          localObject3 = this.AVW;
          i = 0;
          localObject4 = ((Iterable)localObject4).iterator();
        }
      }
      for (;;)
      {
        int j;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = ((Iterator)localObject4).next();
          j = i + 1;
          if (i < 0) {
            p.kkW();
          }
          localObject5 = (BaseFinderFeed)localObject5;
          if ((localObject5 instanceof BaseFinderFeed))
          {
            long l = ((BaseFinderFeed)localObject5).feedObject.getId();
            localObject6 = ((u)localObject1).readFeedId;
            if (localObject6 == null)
            {
              i = j;
              continue;
            }
            if ((l == ((Long)localObject6).longValue()) && (!((BaseFinderFeed)localObject5).feedObject.isLiveFeed()))
            {
              ((BaseFinderFeed)localObject5).markRead = true;
              ((u)localObject1).readExist = true;
              if (!u.c((u)localObject1)) {
                j.a(paramObject, (f)bg.kCh(), null, (m)new a((u)localObject1, (ah.f)localObject2, i, (ah.a)localObject3, null), 2);
              }
            }
          }
        }
        else
        {
          localObject1 = paramObject;
          if (this.AVV.readExist) {
            break;
          }
          if (u.f(this.AVV) != 0)
          {
            localObject1 = this.AVV;
            u.b((u)localObject1, u.f((u)localObject1) - 1);
            localObject1 = this.AVV;
            i = ((u)localObject1).AVP;
            ((u)localObject1).AVP = (((List)((ah.f)localObject2).aqH).size() + i);
            localObject1 = paramObject;
            break;
          }
          localObject3 = u.g(this.AVV);
          localObject1 = paramObject;
          if (localObject3 == null) {
            break;
          }
          ((ArrayList)localObject3).addAll((Collection)((ah.f)localObject2).aqH);
          localObject1 = paramObject;
          break;
          label1017:
          i = 0;
          break label630;
          label1020:
          break label581;
          bool = false;
          break label701;
        }
        i = j;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      a(u paramu, ah.f<List<BaseFinderFeed>> paramf, int paramInt, ah.a parama, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(362868);
        paramObject = (kotlin.d.d)new a(this.AVV, this.AVX, i, this.AVW, paramd);
        AppMethodBeat.o(362868);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(362862);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(362862);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        int i;
        if (u.f(this.AVV) != 0)
        {
          paramObject = this.AVV;
          u.b(paramObject, u.f(paramObject) - 1);
          paramObject = this.AVV;
          i = paramObject.AVP;
          paramObject.AVP = (((List)this.AVX.aqH).size() + i);
        }
        for (;;)
        {
          i = i;
          int j = u.g(this.AVV).size();
          int k = this.AVV.AVP;
          int m = ((List)this.AVX.aqH).size();
          paramObject = this.AVV.AVQ;
          if (paramObject != null) {
            paramObject.invoke(Boolean.valueOf(this.AVW.aiwY), kotlin.d.b.a.b.BF(u.d(this.AVV)), Boolean.valueOf(u.b(this.AVV)), u.g(this.AVV), u.e(this.AVV), Integer.valueOf(k + (i + j) - m), Boolean.valueOf(this.AVV.readExist));
          }
          paramObject = ah.aiuX;
          AppMethodBeat.o(362862);
          return paramObject;
          paramObject = u.g(this.AVV);
          if (paramObject != null) {
            paramObject.addAll((Collection)this.AVX.aqH);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.u
 * JD-Core Version:    0.7.0.1
 */