package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.video.FinderVideoViewForTopic;
import com.tencent.mm.plugin.finder.view.FinderTagFlowLayout;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.view.FinderTagView.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTopicFeedCache;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "TAB_TYPE", "getTAB_TYPE", "()I", "setTAB_TYPE", "(I)V", "TAG", "", "bgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "getBgmInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "setBgmInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;)V", "disableFlag", "getDisableFlag", "setDisableFlag", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$feedProgressListener$1;", "flag", "getFlag", "setFlag", "iconUrl", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "onRequestFinished", "Lkotlin/Function0;", "", "getOnRequestFinished", "()Lkotlin/jvm/functions/Function0;", "setOnRequestFinished", "(Lkotlin/jvm/functions/Function0;)V", "removeEvent", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "getRemoveEvent", "setRemoveEvent", "selectedTag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getSelectedTag", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setSelectedTag", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCache;", "topic", "getTopic", "setTopic", "topicRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getTopicRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setTopicRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "totalCount", "", "getTotalCount", "()J", "setTotalCount", "(J)V", "totalDy", "type", "getType", "setType", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dealFirstRsp", "rsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "distinctResponseList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "incrementList", "", "getIViewActionCallback", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "ifDummyTag", "", "tag", "initViewCallback", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "scrollToTop", "endCallBack", "showNoMoreView", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
public final class av$a
  extends c.a
{
  final String TAG;
  public bdr bgmInfo;
  int cSx;
  public String dST;
  private String iconUrl;
  azk musicInfo;
  private IListener<ig> tOh;
  bds tRJ;
  public int tTm;
  public long tTn;
  int tTo;
  private IListener<com.tencent.mm.g.a.f> tTp;
  final FinderTopicFeedCache tTq;
  private final b tTr;
  private com.tencent.mm.view.j tTs;
  int totalDy;
  public int type;
  
  public av$a(final MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(244468);
    this.TAG = "Finder.FinderTopicFeedUIContract.TopicFeedPresenter";
    this.dST = "";
    paramBaseFinderFeedLoader = new bds();
    FinderTagView.a locala = FinderTagView.wpv;
    paramBaseFinderFeedLoader.twp = FinderTagView.dHl();
    this.tRJ = paramBaseFinderFeedLoader;
    this.iconUrl = "";
    this.tTq = new FinderTopicFeedCache();
    this.tTr = new b(this);
    this.tTs = ((com.tencent.mm.view.j)new com.tencent.mm.view.j()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(244440);
        Object localObject = this.tTt.tMd;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.j)((c.b)localObject).tLS;
          if (localObject != null)
          {
            ((com.tencent.mm.view.j)localObject).onChanged();
            AppMethodBeat.o(244440);
            return;
          }
        }
        AppMethodBeat.o(244440);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(244441);
        Object localObject1 = this.tTt.tMd;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.j)((c.b)localObject1).tLS;
          if (localObject1 != null)
          {
            Object localObject2 = this.tTt.tMd;
            if (localObject2 != null)
            {
              localObject2 = ((c.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((g)localObject2).RqM.size();; i = 0)
            {
              ((com.tencent.mm.view.j)localObject1).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(244441);
              return;
            }
          }
        }
        AppMethodBeat.o(244441);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(244442);
        Object localObject1 = this.tTt.tMd;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.j)((c.b)localObject1).tLS;
          if (localObject1 != null)
          {
            Object localObject2 = this.tTt.tMd;
            if (localObject2 != null)
            {
              localObject2 = ((c.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((g)localObject2).RqM.size();; i = 0)
            {
              ((com.tencent.mm.view.j)localObject1).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
              AppMethodBeat.o(244442);
              return;
            }
          }
        }
        AppMethodBeat.o(244442);
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(244443);
        Object localObject1 = this.tTt.tMd;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.j)((c.b)localObject1).tLS;
          if (localObject1 != null)
          {
            Object localObject2 = this.tTt.tMd;
            if (localObject2 != null)
            {
              localObject2 = ((c.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((g)localObject2).RqM.size();; i = 0)
            {
              ((com.tencent.mm.view.j)localObject1).onItemRangeInserted(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(244443);
              return;
            }
          }
        }
        AppMethodBeat.o(244443);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(244444);
        Object localObject1 = this.tTt.tMd;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.j)((c.b)localObject1).tLS;
          if (localObject1 != null)
          {
            localObject2 = this.tTt.tMd;
            if (localObject2 == null) {
              break label105;
            }
            localObject2 = ((c.b)localObject2).getAdapter();
            if (localObject2 == null) {
              break label105;
            }
          }
        }
        label105:
        for (int i = ((g)localObject2).RqM.size();; i = 0)
        {
          ((com.tencent.mm.view.j)localObject1).onItemRangeRemoved(i + paramAnonymousInt1, paramAnonymousInt2);
          localObject1 = this.tTt.tMd;
          if (localObject1 == null) {
            break;
          }
          ((c.b)localObject1).dcv();
          AppMethodBeat.o(244444);
          return;
        }
        AppMethodBeat.o(244444);
      }
      
      public final void onPreFinishLoadMore(final RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(244438);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.tTt.tMd;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.j)((c.b)localObject).tLS;
          if (localObject != null) {
            ((com.tencent.mm.view.j)localObject).onPreFinishLoadMore(paramAnonymousc);
          }
        }
        d.h((kotlin.g.a.a)new a(this, paramAnonymousc));
        AppMethodBeat.o(244438);
      }
      
      public final void onPreFinishLoadMoreSmooth(final RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(244439);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.tTt.tMd;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.j)((c.b)localObject).tLS;
          if (localObject != null) {
            ((com.tencent.mm.view.j)localObject).onPreFinishLoadMoreSmooth(paramAnonymousc);
          }
        }
        d.h((kotlin.g.a.a)new b(this, paramAnonymousc));
        AppMethodBeat.o(244439);
      }
      
      public final void onPreFinishRefresh(final RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(244437);
        p.h(paramAnonymousc, "reason");
        d.h((kotlin.g.a.a)new c(this, paramAnonymousc));
        AppMethodBeat.o(244437);
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
      static final class a
        extends q
        implements kotlin.g.a.a<x>
      {
        a(av.a.1 param1, RefreshLoadMoreLayout.c paramc)
        {
          super();
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
      static final class b
        extends q
        implements kotlin.g.a.a<x>
      {
        b(av.a.1 param1, RefreshLoadMoreLayout.c paramc)
        {
          super();
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
      static final class c
        extends q
        implements kotlin.g.a.a<x>
      {
        c(av.a.1 param1, RefreshLoadMoreLayout.c paramc)
        {
          super();
        }
      }
    });
    AppMethodBeat.o(244468);
  }
  
  public static boolean d(bds parambds)
  {
    AppMethodBeat.i(244463);
    p.h(parambds, "tag");
    long l = parambds.twp;
    parambds = FinderTagView.wpv;
    if (l == FinderTagView.dHl())
    {
      AppMethodBeat.o(244463);
      return true;
    }
    AppMethodBeat.o(244463);
    return false;
  }
  
  public final void F(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(244462);
    Object localObject = this.tMd;
    if (localObject != null)
    {
      localObject = ((c.b)localObject).tLS.getRecyclerView();
      if (localObject != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter", "scrollToTop", "(Lkotlin/jvm/functions/Function0;)V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter", "scrollToTop", "(Lkotlin/jvm/functions/Function0;)V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
    localObject = this.tMd;
    if (localObject != null)
    {
      localObject = ((c.b)localObject).tLS.getRecyclerView();
      if (localObject != null)
      {
        ((RecyclerView)localObject).post((Runnable)new g(parama));
        AppMethodBeat.o(244462);
        return;
      }
    }
    AppMethodBeat.o(244462);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(244461);
    p.h(paramb, "callback");
    super.a(paramb);
    EventCenter.instance.add((IListener)this.tTr);
    paramb = this.tMd;
    if (paramb != null)
    {
      Object localObject2 = paramb.dcl().getIntent().getByteArrayExtra("key_topic_poi_location");
      if (localObject2 != null)
      {
        localObject1 = new axt();
        ((axt)localObject1).parseFrom((byte[])localObject2);
        localObject2 = this.tFM;
        if (localObject2 == null)
        {
          paramb = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
          AppMethodBeat.o(244461);
          throw paramb;
        }
        ((FinderTopicFeedLoader)localObject2).tXM = ((axt)localObject1);
      }
      long l = paramb.dcl().getIntent().getLongExtra("key_ref_object_id", 0L);
      Object localObject1 = this.tFM;
      if (localObject1 == null)
      {
        paramb = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(244461);
        throw paramb;
      }
      ((FinderTopicFeedLoader)localObject1).tXN = Long.valueOf(l);
      if (this.type == 4) {
        paramb.tLS.getRecyclerView().a((RecyclerView.l)new d(paramb, this));
      }
      if (this.type == 7)
      {
        this.tTp = ((IListener)new e(this));
        paramb = this.tTp;
        if (paramb != null) {
          paramb.alive();
        }
      }
    }
    paramb = this.tFM;
    if (paramb == null)
    {
      paramb = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
      AppMethodBeat.o(244461);
      throw paramb;
    }
    ((FinderTopicFeedLoader)paramb).tXO = ((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(244461);
  }
  
  public final void atn(String paramString)
  {
    AppMethodBeat.i(244459);
    p.h(paramString, "<set-?>");
    this.dST = paramString;
    AppMethodBeat.o(244459);
  }
  
  public final void boE()
  {
    AppMethodBeat.i(244466);
    if (d(this.tRJ))
    {
      localObject = this.tFM;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(244466);
        throw ((Throwable)localObject);
      }
      FinderTopicFeedLoader.b((FinderTopicFeedLoader)localObject, this.tTm);
      AppMethodBeat.o(244466);
      return;
    }
    Object localObject = new dmk();
    ((dmk)localObject).MPW = new LinkedList();
    ((dmk)localObject).MPW.add(this.tRJ);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
      AppMethodBeat.o(244466);
      throw ((Throwable)localObject);
    }
    ((FinderTopicFeedLoader)localBaseFinderFeedLoader).a(this.tTm, (dmk)localObject);
    AppMethodBeat.o(244466);
  }
  
  public final void c(bds parambds)
  {
    AppMethodBeat.i(244460);
    p.h(parambds, "<set-?>");
    this.tRJ = parambds;
    AppMethodBeat.o(244460);
  }
  
  public final void dcb()
  {
    AppMethodBeat.i(244465);
    c.b localb = this.tMd;
    if (localb != null) {
      localb.ab((ArrayList)this.tFM.getDataListJustForAdapter());
    }
    this.tOh = ((IListener)new c(this));
    EventCenter.instance.add(this.tOh);
    AppMethodBeat.o(244465);
  }
  
  public final com.tencent.mm.view.recyclerview.f dce()
  {
    AppMethodBeat.i(244464);
    Object localObject = this.tMd;
    if (localObject == null) {
      p.hyc();
    }
    localObject = ((c.b)localObject).dcs().G((kotlin.g.a.b)new a(this));
    AppMethodBeat.o(244464);
    return localObject;
  }
  
  public final com.tencent.mm.view.j dco()
  {
    return this.tTs;
  }
  
  public final void e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(244467);
    p.h(paramc, "reason");
    paramc = paramc.tXF;
    if (paramc == null)
    {
      paramc = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicResponse");
      AppMethodBeat.o(244467);
      throw paramc;
    }
    if (!((FinderTopicFeedLoader.e)paramc).getHasMore())
    {
      paramc = this.tMd;
      if (paramc != null)
      {
        paramc = paramc.tLS;
        if (paramc != null) {
          if (this.tFM.getSize() <= 10) {
            break label203;
          }
        }
      }
      label203:
      for (boolean bool = true;; bool = false)
      {
        paramc.setEnableLoadMore(bool);
        paramc = this.tMd;
        if (paramc != null)
        {
          paramc = paramc.tLS;
          if (paramc != null)
          {
            paramc = paramc.getLoadMoreFooter();
            if (paramc != null)
            {
              paramc = (TextView)paramc.findViewById(2131303685);
              if (paramc != null) {
                paramc.setText(2131760235);
              }
            }
          }
        }
        paramc = this.tMd;
        if (paramc == null) {
          break;
        }
        paramc = paramc.tLS;
        if (paramc == null) {
          break;
        }
        paramc = paramc.getLoadMoreFooter();
        if (paramc == null) {
          break;
        }
        paramc = (TextView)paramc.findViewById(2131303685);
        if (paramc == null) {
          break;
        }
        paramc.setTextColor(this.gte.getResources().getColor(2131099749));
        AppMethodBeat.o(244467);
        return;
      }
      AppMethodBeat.o(244467);
      return;
    }
    paramc = this.tMd;
    if (paramc != null)
    {
      paramc = paramc.tLS;
      if (paramc != null)
      {
        paramc.setEnableLoadMore(true);
        AppMethodBeat.o(244467);
        return;
      }
    }
    AppMethodBeat.o(244467);
  }
  
  public final String getIconUrl()
  {
    AppMethodBeat.i(165953);
    Object localObject = this.tFM.getListOfType(BaseFinderFeed.class);
    if (!((List)localObject).isEmpty())
    {
      localObject = (cjl)kotlin.a.j.L((List)((BaseFinderFeed)((List)localObject).get(0)).feedObject.getMediaList(), 0);
      if (localObject != null)
      {
        localObject = ((cjl)localObject).thumbUrl + ((cjl)localObject).thumb_url_token;
        AppMethodBeat.o(165953);
        return localObject;
      }
    }
    AppMethodBeat.o(165953);
    return "";
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165956);
    super.onDetach();
    this.tTq.onCleared();
    Object localObject1 = this.tMd;
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
      AppMethodBeat.o(165956);
      throw ((Throwable)localObject1);
    }
    av.b localb = (av.b)localObject1;
    localObject1 = localb.gte;
    Object localObject2 = FinderTagView.wpv;
    localObject2 = (FinderTagView)((MMActivity)localObject1).findViewById(FinderTagView.dHk());
    if (localObject2 == null)
    {
      localObject1 = localb.tLS.getRecyclerView();
      localObject2 = FinderTagView.wpv;
      localObject2 = (FinderTagView)((RecyclerView)localObject1).findViewById(FinderTagView.dHk());
    }
    for (;;)
    {
      Object localObject3;
      if ((localb.tOT instanceof FinderFollowTopicHeaderView))
      {
        localObject1 = localb.tOT;
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView");
          AppMethodBeat.o(165956);
          throw ((Throwable)localObject1);
        }
        localObject1 = (FinderFollowTopicHeaderView)localObject1;
        localObject3 = ((FinderFollowTopicHeaderView)localObject1).uPi;
        if (localObject3 != null) {
          ((FinderImgFeedMusicTag)localObject3).dle();
        }
        localObject1 = ((FinderFollowTopicHeaderView)localObject1).uPc;
        if (localObject1 != null) {
          ((FinderVideoViewForTopic)localObject1).stop();
        }
      }
      localObject1 = localb.tTI;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.activity.view.a)localObject1).destroy();
      }
      if (localObject2 != null)
      {
        localObject1 = FinderReporterUIC.wzC;
        localObject1 = FinderReporterUIC.a.fH((Context)localb.gte);
        if (localObject1 == null) {
          break label637;
        }
        bbn localbbn = ((FinderReporterUIC)localObject1).dIx();
        if (localbbn == null) {
          break label637;
        }
        localObject1 = "";
        StringBuilder localStringBuilder;
        if (((FinderTagView)localObject2).wpn == 1)
        {
          j = ((FinderTagView)localObject2).getTagData().MPW.size();
          i = 0;
          for (;;)
          {
            localObject3 = localObject1;
            if (i >= j) {
              break;
            }
            localObject3 = (bds)((FinderTagView)localObject2).getTagData().MPW.get(i);
            localStringBuilder = new StringBuilder().append((String)localObject1).append(((bds)localObject3).dST).append(";1;");
            localObject3 = (Integer)((FinderTagView)localObject2).getTagClickMap().get(Long.valueOf(((bds)localObject3).twp));
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = Integer.valueOf(0);
            }
            localObject1 = localObject1 + '#';
            i += 1;
          }
        }
        int j = ((List)((FinderTagView)localObject2).getTagLayout().woZ.get(0)).size();
        int i = 0;
        for (;;)
        {
          localObject3 = localObject1;
          if (i >= j) {
            break;
          }
          localObject3 = (bds)((FinderTagView)localObject2).getTagData().MPW.get(i);
          localStringBuilder = new StringBuilder().append((String)localObject1).append(((bds)localObject3).dST).append(";1;");
          localObject3 = (Integer)((FinderTagView)localObject2).getTagClickMap().get(Long.valueOf(((bds)localObject3).twp));
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = Integer.valueOf(0);
          }
          localObject1 = localObject1 + '#';
          i += 1;
        }
        localObject1 = k.vfA;
        k.a(localbbn, localb.dST, (String)localObject3, ((FinderTagView)localObject2).getHasExpandBtn(), ((FinderTagView)localObject2).wpn);
      }
      label637:
      for (localObject1 = x.SXb;; localObject1 = null)
      {
        if (localObject1 == null)
        {
          localObject1 = (av.b)localb;
          localObject2 = FinderReporterUIC.wzC;
          localObject2 = FinderReporterUIC.a.fH((Context)((c.b)localObject1).gte);
          if (localObject2 != null)
          {
            localObject2 = ((FinderReporterUIC)localObject2).dIx();
            if (localObject2 != null)
            {
              localObject3 = k.vfA;
              k.a((bbn)localObject2, ((av.b)localObject1).dST, "", 0, 0);
              localObject1 = x.SXb;
            }
          }
        }
        localObject1 = this.tTp;
        if (localObject1 != null) {
          ((IListener)localObject1).dead();
        }
        EventCenter.instance.removeListener(this.tOh);
        EventCenter.instance.removeListener((IListener)this.tTr);
        AppMethodBeat.o(165956);
        return;
      }
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(165957);
    if (d(this.tRJ))
    {
      localObject = this.tFM;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(165957);
        throw ((Throwable)localObject);
      }
      FinderTopicFeedLoader.a((FinderTopicFeedLoader)localObject, this.tTm);
      AppMethodBeat.o(165957);
      return;
    }
    Object localObject = new dmk();
    ((dmk)localObject).MPW = new LinkedList();
    ((dmk)localObject).MPW.add(this.tRJ);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
      AppMethodBeat.o(165957);
      throw ((Throwable)localObject);
    }
    ((FinderTopicFeedLoader)localBaseFinderFeedLoader).a(this.tTm, (dmk)localObject, 4);
    AppMethodBeat.o(165957);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Integer, e<?>>
  {
    a(av.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<hk>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$initViewCallback$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<ig>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$initViewCallback$1$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(av.a.c paramc, ig paramig)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$1$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.l
  {
    d(c.b paramb, av.a parama) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(244454);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(244454);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(244453);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = jdField_this;
      paramRecyclerView.totalDy += paramInt2;
      paramRecyclerView = jdField_this;
      if (jdField_this.totalDy < 0) {}
      float f;
      for (paramInt1 = 0;; paramInt1 = jdField_this.totalDy)
      {
        paramRecyclerView.totalDy = paramInt1;
        paramInt1 = jdField_this.gte.getResources().getDimensionPixelOffset(2131165283);
        f = jdField_this.totalDy / paramInt1;
        if (f != 0.0F) {
          break label209;
        }
        paramRecyclerView = this.tTA;
        if (paramRecyclerView != null) {
          break;
        }
        paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
        AppMethodBeat.o(244453);
        throw paramRecyclerView;
      }
      ((av.b)paramRecyclerView).dds().setVisibility(4);
      for (;;)
      {
        paramRecyclerView = this.tTA;
        if (paramRecyclerView != null) {
          break;
        }
        paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
        AppMethodBeat.o(244453);
        throw paramRecyclerView;
        label209:
        paramRecyclerView = this.tTA;
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
          AppMethodBeat.o(244453);
          throw paramRecyclerView;
        }
        if (((av.b)paramRecyclerView).dds().getVisibility() == 4)
        {
          paramRecyclerView = i.vfo;
          i.H(true, 6);
        }
        paramRecyclerView = this.tTA;
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
          AppMethodBeat.o(244453);
          throw paramRecyclerView;
        }
        ((av.b)paramRecyclerView).dds().setVisibility(0);
      }
      ((av.b)paramRecyclerView).dds().setAlpha(f);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(244453);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$1$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<com.tencent.mm.g.a.f>
  {
    e(av.a parama) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(av.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(kotlin.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(244458);
      kotlin.g.a.a locala = this.tRS;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(244458);
        return;
      }
      AppMethodBeat.o(244458);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.av.a
 * JD-Core Version:    0.7.0.1
 */