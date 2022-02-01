package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hr;
import com.tencent.mm.f.a.iv;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.convert.ad;
import com.tencent.mm.plugin.finder.convert.ag;
import com.tencent.mm.plugin.finder.convert.ai;
import com.tencent.mm.plugin.finder.convert.an;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.video.FinderVideoViewForTopic;
import com.tencent.mm.plugin.finder.view.FinderTagFlowLayout;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.view.FinderTagView.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.RefreshLoadMoreLayout.c<Ljava.lang.Object;>;
import com.tencent.mm.view.recyclerview.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "TAB_TYPE", "getTAB_TYPE", "()I", "setTAB_TYPE", "(I)V", "TAG", "", "bgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "getBgmInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "setBgmInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;)V", "disableFlag", "getDisableFlag", "setDisableFlag", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$feedProgressListener$1;", "flag", "getFlag", "setFlag", "iconUrl", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "onRequestFinished", "Lkotlin/Function0;", "", "getOnRequestFinished", "()Lkotlin/jvm/functions/Function0;", "setOnRequestFinished", "(Lkotlin/jvm/functions/Function0;)V", "removeEvent", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "getRemoveEvent", "setRemoveEvent", "selectedTag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getSelectedTag", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setSelectedTag", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCache;", "topic", "getTopic", "setTopic", "topicRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getTopicRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setTopicRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "totalCount", "", "getTotalCount", "()J", "setTotalCount", "(J)V", "totalDy", "type", "getType", "setType", "wrapper", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$FinderTopicInfoWrapper;", "getWrapper", "()Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$FinderTopicInfoWrapper;", "buildCampaignConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "buildItemCoverts", "dealFirstRsp", "rsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "distinctResponseList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "incrementList", "", "getIViewActionCallback", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "ifDummyTag", "", "tag", "initViewCallback", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "onUIResume", "requestRefresh", "scrollToTop", "endCallBack", "setNoMoreForActivity", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;", "size", "showNoMoreView", "plugin-finder_release"})
public final class bb$b
  extends c.a
{
  private final String TAG;
  public bkq bgmInfo;
  int cUP;
  private String iconUrl;
  bfg musicInfo;
  public String topic;
  private int totalDy;
  public int type;
  bkr xCB;
  public int xEb;
  public long xEc;
  int xEd;
  private IListener<com.tencent.mm.f.a.f> xEe;
  private final com.tencent.mm.plugin.finder.viewmodel.i xEf;
  private final c xEg;
  private com.tencent.mm.view.j xEh;
  final bb.a xmb;
  private IListener<iv> xyI;
  
  public bb$b(final MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(288567);
    this.TAG = "Finder.FinderTopicFeedUIContract.TopicFeedPresenter";
    this.topic = "";
    paramBaseFinderFeedLoader = new bkr();
    FinderTagView.a locala = FinderTagView.BaE;
    paramBaseFinderFeedLoader.xee = FinderTagView.ejm();
    this.xCB = paramBaseFinderFeedLoader;
    this.iconUrl = "";
    this.xmb = new bb.a((byte)0);
    this.xEf = new com.tencent.mm.plugin.finder.viewmodel.i();
    this.xEg = new c(this);
    this.xEh = ((com.tencent.mm.view.j)new com.tencent.mm.view.j()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(292094);
        Object localObject = this.xEi.xvU;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.j)((c.b)localObject).xvJ;
          if (localObject != null)
          {
            ((com.tencent.mm.view.j)localObject).onChanged();
            AppMethodBeat.o(292094);
            return;
          }
        }
        AppMethodBeat.o(292094);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(292095);
        Object localObject1 = this.xEi.xvU;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.j)((c.b)localObject1).xvJ;
          if (localObject1 != null)
          {
            Object localObject2 = this.xEi.xvU;
            if (localObject2 != null)
            {
              localObject2 = ((c.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((com.tencent.mm.view.recyclerview.h)localObject2).YSk.size();; i = 0)
            {
              ((com.tencent.mm.view.j)localObject1).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(292095);
              return;
            }
          }
        }
        AppMethodBeat.o(292095);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(292096);
        Object localObject1 = this.xEi.xvU;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.j)((c.b)localObject1).xvJ;
          if (localObject1 != null)
          {
            Object localObject2 = this.xEi.xvU;
            if (localObject2 != null)
            {
              localObject2 = ((c.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((com.tencent.mm.view.recyclerview.h)localObject2).YSk.size();; i = 0)
            {
              ((com.tencent.mm.view.j)localObject1).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
              AppMethodBeat.o(292096);
              return;
            }
          }
        }
        AppMethodBeat.o(292096);
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(292097);
        Object localObject1 = this.xEi.xvU;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.j)((c.b)localObject1).xvJ;
          if (localObject1 != null)
          {
            Object localObject2 = this.xEi.xvU;
            if (localObject2 != null)
            {
              localObject2 = ((c.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((com.tencent.mm.view.recyclerview.h)localObject2).YSk.size();; i = 0)
            {
              ((com.tencent.mm.view.j)localObject1).onItemRangeInserted(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(292097);
              return;
            }
          }
        }
        AppMethodBeat.o(292097);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(292098);
        Object localObject1 = this.xEi.xvU;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.j)((c.b)localObject1).xvJ;
          if (localObject1 != null)
          {
            localObject2 = this.xEi.xvU;
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
        for (int i = ((com.tencent.mm.view.recyclerview.h)localObject2).YSk.size();; i = 0)
        {
          ((com.tencent.mm.view.j)localObject1).onItemRangeRemoved(i + paramAnonymousInt1, paramAnonymousInt2);
          localObject1 = this.xEi.xvU;
          if (localObject1 == null) {
            break;
          }
          ((c.b)localObject1).dsL();
          AppMethodBeat.o(292098);
          return;
        }
        AppMethodBeat.o(292098);
      }
      
      public final void onPreFinishLoadMore(final RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(292092);
        p.k(paramAnonymousc, "reason");
        Object localObject = this.xEi.xvU;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.j)((c.b)localObject).xvJ;
          if (localObject != null) {
            ((com.tencent.mm.view.j)localObject).onPreFinishLoadMore(paramAnonymousc);
          }
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramAnonymousc));
        AppMethodBeat.o(292092);
      }
      
      public final void onPreFinishLoadMoreSmooth(final RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(292093);
        p.k(paramAnonymousc, "reason");
        Object localObject = this.xEi.xvU;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.j)((c.b)localObject).xvJ;
          if (localObject != null) {
            ((com.tencent.mm.view.j)localObject).onPreFinishLoadMoreSmooth(paramAnonymousc);
          }
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramAnonymousc));
        AppMethodBeat.o(292093);
      }
      
      public final void onPreFinishRefresh(final RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(292091);
        p.k(paramAnonymousc, "reason");
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, paramAnonymousc));
        AppMethodBeat.o(292091);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
      static final class a
        extends kotlin.g.b.q
        implements kotlin.g.a.a<x>
      {
        a(bb.b.1 param1, RefreshLoadMoreLayout.c paramc)
        {
          super();
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
      static final class b
        extends kotlin.g.b.q
        implements kotlin.g.a.a<x>
      {
        b(bb.b.1 param1, RefreshLoadMoreLayout.c paramc)
        {
          super();
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
      static final class c
        extends kotlin.g.b.q
        implements kotlin.g.a.a<x>
      {
        c(bb.b.1 param1, RefreshLoadMoreLayout.c paramc)
        {
          super();
        }
      }
    });
    AppMethodBeat.o(288567);
  }
  
  public static boolean d(bkr parambkr)
  {
    AppMethodBeat.i(288561);
    p.k(parambkr, "tag");
    long l = parambkr.xee;
    parambkr = FinderTagView.BaE;
    if (l == FinderTagView.ejm())
    {
      AppMethodBeat.o(288561);
      return true;
    }
    AppMethodBeat.o(288561);
    return false;
  }
  
  public final void E(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(288560);
    Object localObject = this.xvU;
    if (localObject != null)
    {
      localObject = ((c.b)localObject).xvJ.getRecyclerView();
      if (localObject != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter", "scrollToTop", "(Lkotlin/jvm/functions/Function0;)V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject).scrollToPosition(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter", "scrollToTop", "(Lkotlin/jvm/functions/Function0;)V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
    localObject = this.xvU;
    if (localObject != null)
    {
      localObject = ((c.b)localObject).xvJ.getRecyclerView();
      if (localObject != null)
      {
        ((RecyclerView)localObject).post((Runnable)new h(parama));
        AppMethodBeat.o(288560);
        return;
      }
    }
    AppMethodBeat.o(288560);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(288559);
    p.k(paramb, "callback");
    super.a(paramb);
    EventCenter.instance.add((IListener)this.xEg);
    paramb = this.xvU;
    if (paramb != null)
    {
      Object localObject2 = paramb.dsB().getIntent().getByteArrayExtra("key_topic_poi_location");
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = new bdm();
        ((bdm)localObject1).parseFrom((byte[])localObject2);
        localObject2 = this.xnX;
        if (localObject2 == null)
        {
          paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
          AppMethodBeat.o(288559);
          throw paramb;
        }
        ((FinderTopicFeedLoader)localObject2).xJG = ((bdm)localObject1);
      }
      long l = paramb.dsB().getIntent().getLongExtra("key_ref_object_id", 0L);
      if (this.type != 7)
      {
        localObject1 = this.xnX;
        if (localObject1 == null)
        {
          paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
          AppMethodBeat.o(288559);
          throw paramb;
        }
        ((FinderTopicFeedLoader)localObject1).xJH = Long.valueOf(l);
      }
      if (this.type == 4) {
        paramb.xvJ.getRecyclerView().a((RecyclerView.l)new e(paramb, this));
      }
      if (this.type == 7)
      {
        this.xEe = ((IListener)new f(this));
        paramb = this.xEe;
        if (paramb != null) {
          paramb.alive();
        }
      }
    }
    paramb = this.xnX;
    if (paramb == null)
    {
      paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
      AppMethodBeat.o(288559);
      throw paramb;
    }
    ((FinderTopicFeedLoader)paramb).xJJ = ((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(288559);
  }
  
  public final void aBE(String paramString)
  {
    AppMethodBeat.i(288556);
    p.k(paramString, "<set-?>");
    this.topic = paramString;
    AppMethodBeat.o(288556);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(288565);
    if (d(this.xCB))
    {
      localObject = this.xnX;
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(288565);
        throw ((Throwable)localObject);
      }
      FinderTopicFeedLoader.b((FinderTopicFeedLoader)localObject, this.xEb);
      AppMethodBeat.o(288565);
      return;
    }
    Object localObject = new dwb();
    ((dwb)localObject).Uca = new LinkedList();
    ((dwb)localObject).Uca.add(this.xCB);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
      AppMethodBeat.o(288565);
      throw ((Throwable)localObject);
    }
    ((FinderTopicFeedLoader)localBaseFinderFeedLoader).a(this.xEb, (dwb)localObject);
    AppMethodBeat.o(288565);
  }
  
  public final void c(bkr parambkr)
  {
    AppMethodBeat.i(288557);
    p.k(parambkr, "<set-?>");
    this.xCB = parambkr;
    AppMethodBeat.o(288557);
  }
  
  public final com.tencent.mm.view.j dsE()
  {
    return this.xEh;
  }
  
  public final void dsr()
  {
    AppMethodBeat.i(288564);
    c.b localb = this.xvU;
    if (localb != null) {
      localb.ab((ArrayList)this.xnX.getDataListJustForAdapter());
    }
    this.xyI = ((IListener)new d(this));
    EventCenter.instance.add(this.xyI);
    AppMethodBeat.o(288564);
  }
  
  public final com.tencent.mm.view.recyclerview.f dsu()
  {
    AppMethodBeat.i(288563);
    if (this.type == 7)
    {
      localObject = (com.tencent.mm.view.recyclerview.f)new a(this);
      AppMethodBeat.o(288563);
      return localObject;
    }
    Object localObject = this.xvU;
    if (localObject == null) {
      p.iCn();
    }
    localObject = ((c.b)localObject).dsI().O((kotlin.g.a.b)new b(this));
    AppMethodBeat.o(288563);
    return localObject;
  }
  
  public final String getIconUrl()
  {
    AppMethodBeat.i(165953);
    Object localObject = this.xnX.getListOfType(BaseFinderFeed.class);
    if (!((List)localObject).isEmpty())
    {
      localObject = (csg)kotlin.a.j.M((List)((BaseFinderFeed)((List)localObject).get(0)).feedObject.getMediaList(), 0);
      if (localObject != null)
      {
        localObject = ((csg)localObject).thumbUrl + ((csg)localObject).thumb_url_token;
        AppMethodBeat.o(165953);
        return localObject;
      }
    }
    AppMethodBeat.o(165953);
    return "";
  }
  
  public final void i(RefreshLoadMoreLayout.c<Object> paramc)
  {
    View localView1 = null;
    boolean bool = true;
    int i = 1;
    AppMethodBeat.i(288566);
    p.k(paramc, "reason");
    paramc = paramc.xJA;
    if (paramc == null)
    {
      paramc = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicResponse");
      AppMethodBeat.o(288566);
      throw paramc;
    }
    paramc = (FinderTopicFeedLoader.e)paramc;
    if (!paramc.getHasMore())
    {
      if (this.type == 7)
      {
        int j = this.xnX.getSize();
        Object localObject = this.xvU;
        if (localObject != null)
        {
          localObject = ((c.b)localObject).xvJ;
          if (localObject != null)
          {
            View localView2 = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
            if (localView2 != null)
            {
              paramc = paramc.fGc;
              if (paramc != null)
              {
                paramc = paramc.SVJ;
                if (paramc != null)
                {
                  paramc = paramc.coverImgUrl;
                  if (Util.isNullOrNil(paramc)) {
                    break label334;
                  }
                }
              }
              for (;;)
              {
                localObject = this.xvU;
                paramc = (RefreshLoadMoreLayout.c<Object>)localObject;
                if (!(localObject instanceof bb.c)) {
                  paramc = null;
                }
                localObject = (bb.c)paramc;
                paramc = localView1;
                if (localObject != null) {
                  paramc = ((bb.c)localObject).xEy;
                }
                if (j <= 0) {
                  break label413;
                }
                localView2.setVisibility(0);
                localView1 = localView2.findViewById(b.f.load_more_footer_tip_tv);
                p.j(localView1, "findViewById<View>(R.id.load_more_footer_tip_tv)");
                localView1.setVisibility(8);
                localView1 = localView2.findViewById(b.f.load_more_footer_end_layout);
                p.j(localView1, "findViewById<View>(R.id.…d_more_footer_end_layout)");
                localView1.setVisibility(0);
                if (paramc != null) {
                  paramc.setVisibility(8);
                }
                if (i == 0) {
                  break label339;
                }
                i = localView2.getResources().getColor(b.c.BW_100_Alpha_0_3);
                paramc = localView2.findViewById(b.f.center_icon);
                p.j(paramc, "findViewById<View>(R.id.center_icon)");
                paramc.setBackground(localView2.getResources().getDrawable(b.e.finder_footer_covered_center_dot));
                localView2.findViewById(b.f.left_icon).setBackgroundColor(i);
                localView2.findViewById(b.f.right_icon).setBackgroundColor(i);
                AppMethodBeat.o(288566);
                return;
                paramc = null;
                break;
                label334:
                i = 0;
              }
              label339:
              i = localView2.getResources().getColor(b.c.FG_2);
              paramc = localView2.findViewById(b.f.center_icon);
              p.j(paramc, "findViewById<View>(R.id.center_icon)");
              paramc.setBackground(localView2.getResources().getDrawable(b.e.finder_footer_normal_center_dot));
              localView2.findViewById(b.f.left_icon).setBackgroundColor(i);
              localView2.findViewById(b.f.right_icon).setBackgroundColor(i);
              AppMethodBeat.o(288566);
              return;
              label413:
              localView2.setVisibility(8);
              if (paramc != null) {
                paramc.setVisibility(0);
              }
              if (paramc != null)
              {
                localView1 = paramc.findViewById(b.f.empty_tip);
                if (localView1 != null) {
                  localView1.setVisibility(0);
                }
              }
              if (paramc != null)
              {
                localView1 = paramc.findViewById(b.f.retry_tip);
                if (localView1 != null) {
                  localView1.setVisibility(8);
                }
              }
              if (paramc != null)
              {
                localView1 = paramc.findViewById(b.f.progress);
                if (localView1 != null) {
                  localView1.setVisibility(8);
                }
              }
              if (i != 0)
              {
                if (paramc != null)
                {
                  paramc = (TextView)paramc.findViewById(b.f.empty_tip);
                  if (paramc != null)
                  {
                    paramc.setTextColor(localView2.getResources().getColor(b.c.BW_100_Alpha_0_3));
                    AppMethodBeat.o(288566);
                    return;
                  }
                }
                AppMethodBeat.o(288566);
                return;
              }
              if (paramc != null)
              {
                paramc = (TextView)paramc.findViewById(b.f.empty_tip);
                if (paramc != null)
                {
                  paramc.setTextColor(localView2.getResources().getColor(b.c.FG_2));
                  AppMethodBeat.o(288566);
                  return;
                }
              }
              AppMethodBeat.o(288566);
              return;
            }
          }
        }
        AppMethodBeat.o(288566);
        return;
      }
      paramc = this.xvU;
      if (paramc != null)
      {
        paramc = paramc.xvJ;
        if (paramc != null) {
          if (this.xnX.getSize() <= 10) {
            break label761;
          }
        }
      }
      for (;;)
      {
        paramc.setEnableLoadMore(bool);
        paramc = this.xvU;
        if (paramc != null)
        {
          paramc = paramc.xvJ;
          if (paramc != null)
          {
            paramc = paramc.getLoadMoreFooter();
            if (paramc != null)
            {
              paramc = (TextView)paramc.findViewById(b.f.load_more_footer_tip_tv);
              if (paramc != null) {
                paramc.setText(b.j.finder_load_more_no_result_tip);
              }
            }
          }
        }
        paramc = this.xvU;
        if (paramc == null) {
          break;
        }
        paramc = paramc.xvJ;
        if (paramc == null) {
          break;
        }
        paramc = paramc.getLoadMoreFooter();
        if (paramc == null) {
          break;
        }
        paramc = (TextView)paramc.findViewById(b.f.load_more_footer_tip_tv);
        if (paramc == null) {
          break;
        }
        paramc.setTextColor(this.iXq.getResources().getColor(b.c.FG_2));
        AppMethodBeat.o(288566);
        return;
        label761:
        bool = false;
      }
      AppMethodBeat.o(288566);
      return;
    }
    paramc = this.xvU;
    if (paramc != null)
    {
      paramc = paramc.xvJ;
      if (paramc != null)
      {
        paramc.setEnableLoadMore(true);
        AppMethodBeat.o(288566);
        return;
      }
    }
    AppMethodBeat.o(288566);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165956);
    super.onDetach();
    this.xEf.onCleared();
    Object localObject1 = this.xvU;
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
      AppMethodBeat.o(165956);
      throw ((Throwable)localObject1);
    }
    bb.c localc = (bb.c)localObject1;
    localObject1 = localc.iXq;
    Object localObject2 = FinderTagView.BaE;
    localObject2 = (FinderTagView)((MMActivity)localObject1).findViewById(FinderTagView.ejl());
    if (localObject2 == null)
    {
      localObject1 = localc.xvJ.getRecyclerView();
      localObject2 = FinderTagView.BaE;
      localObject2 = (FinderTagView)((RecyclerView)localObject1).findViewById(FinderTagView.ejl());
    }
    for (;;)
    {
      Object localObject3;
      if ((localc.xzF instanceof FinderFollowTopicHeaderView))
      {
        localObject1 = localc.xzF;
        if (localObject1 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView");
          AppMethodBeat.o(165956);
          throw ((Throwable)localObject1);
        }
        localObject1 = (FinderFollowTopicHeaderView)localObject1;
        localObject3 = ((FinderFollowTopicHeaderView)localObject1).zBE;
        if (localObject3 != null) {
          ((FinderImgFeedMusicTag)localObject3).dLe();
        }
        localObject3 = ((FinderFollowTopicHeaderView)localObject1).zBy;
        if (localObject3 != null) {
          ((FinderVideoViewForTopic)localObject3).stop();
        }
        com.tencent.mm.kernel.h.aGY().b(3761, (com.tencent.mm.an.i)localObject1);
      }
      localObject1 = localc.xEx;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.activity.view.a)localObject1).destroy();
      }
      if (localObject2 != null)
      {
        localObject1 = aj.Bnu;
        localObject1 = aj.a.fZ((Context)localc.iXq);
        if (localObject1 == null) {
          break label653;
        }
        bid localbid = ((aj)localObject1).ekY();
        if (localbid == null) {
          break label653;
        }
        localObject1 = "";
        StringBuilder localStringBuilder;
        if (((FinderTagView)localObject2).Baw == 1)
        {
          j = ((FinderTagView)localObject2).getTagData().Uca.size();
          i = 0;
          for (;;)
          {
            localObject3 = localObject1;
            if (i >= j) {
              break;
            }
            localObject3 = (bkr)((FinderTagView)localObject2).getTagData().Uca.get(i);
            localStringBuilder = new StringBuilder().append((String)localObject1).append(((bkr)localObject3).topic).append(";1;");
            localObject3 = (Integer)((FinderTagView)localObject2).getTagClickMap().get(Long.valueOf(((bkr)localObject3).xee));
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = Integer.valueOf(0);
            }
            localObject1 = localObject1 + '#';
            i += 1;
          }
        }
        int j = ((List)((FinderTagView)localObject2).getTagLayout().Bai.get(0)).size();
        int i = 0;
        for (;;)
        {
          localObject3 = localObject1;
          if (i >= j) {
            break;
          }
          localObject3 = (bkr)((FinderTagView)localObject2).getTagData().Uca.get(i);
          localStringBuilder = new StringBuilder().append((String)localObject1).append(((bkr)localObject3).topic).append(";1;");
          localObject3 = (Integer)((FinderTagView)localObject2).getTagClickMap().get(Long.valueOf(((bkr)localObject3).xee));
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = Integer.valueOf(0);
          }
          localObject1 = localObject1 + '#';
          i += 1;
        }
        localObject1 = n.zWF;
        n.a(localbid, localc.topic, (String)localObject3, ((FinderTagView)localObject2).getHasExpandBtn(), ((FinderTagView)localObject2).Baw);
      }
      label653:
      for (localObject1 = x.aazN;; localObject1 = null)
      {
        if (localObject1 == null)
        {
          localObject1 = (bb.c)localc;
          localObject2 = aj.Bnu;
          localObject2 = aj.a.fZ((Context)((c.b)localObject1).iXq);
          if (localObject2 != null)
          {
            localObject2 = ((aj)localObject2).ekY();
            if (localObject2 != null)
            {
              localObject3 = n.zWF;
              n.a((bid)localObject2, ((bb.c)localObject1).topic, "", 0, 0);
              localObject1 = x.aazN;
            }
          }
        }
        localObject1 = this.xEe;
        if (localObject1 != null) {
          ((IListener)localObject1).dead();
        }
        EventCenter.instance.removeListener(this.xyI);
        EventCenter.instance.removeListener((IListener)this.xEg);
        AppMethodBeat.o(165956);
        return;
      }
    }
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(288558);
    super.onUIResume();
    Object localObject2 = this.xvU;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof bb.c)) {
      localObject1 = null;
    }
    localObject1 = (bb.c)localObject1;
    if (localObject1 != null) {}
    for (localObject1 = ((bb.c)localObject1).xzF;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof FinderFollowTopicHeaderView)) {
        localObject2 = null;
      }
      localObject1 = (FinderFollowTopicHeaderView)localObject2;
      if (localObject1 == null) {
        break label120;
      }
      if (((FinderFollowTopicHeaderView)localObject1).wZz == null)
      {
        localObject2 = new ch(11);
        com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)localObject2);
      }
      localObject1 = ((FinderFollowTopicHeaderView)localObject1).wZA;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.ui.post.d)localObject1).onResume();
      AppMethodBeat.o(288558);
      return;
    }
    AppMethodBeat.o(288558);
    return;
    label120:
    AppMethodBeat.o(288558);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(165957);
    if (d(this.xCB))
    {
      localObject = this.xnX;
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(165957);
        throw ((Throwable)localObject);
      }
      FinderTopicFeedLoader.a((FinderTopicFeedLoader)localObject, this.xEb);
      AppMethodBeat.o(165957);
      return;
    }
    Object localObject = new dwb();
    ((dwb)localObject).Uca = new LinkedList();
    ((dwb)localObject).Uca.add(this.xCB);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
      AppMethodBeat.o(165957);
      throw ((Throwable)localObject);
    }
    ((FinderTopicFeedLoader)localBaseFinderFeedLoader).a(this.xEb, (dwb)localObject, 4);
    AppMethodBeat.o(165957);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$buildCampaignConvert$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(291571);
      switch (paramInt)
      {
      default: 
        localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(291571);
        return localObject;
      case 4: 
      case 9: 
      case 3002: 
        localObject = new an();
        ((ag)localObject).xmb = this.xEi.xmb;
        localObject = (e)localObject;
        AppMethodBeat.o(291571);
        return localObject;
      case 2: 
      case 3001: 
        localObject = new w();
        ((ag)localObject).xmb = this.xEi.xmb;
        localObject = (e)localObject;
        AppMethodBeat.o(291571);
        return localObject;
      case -3: 
        localObject = (e)new ai();
        AppMethodBeat.o(291571);
        return localObject;
      }
      Object localObject = (e)new ad();
      AppMethodBeat.o(291571);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, e<?>>
  {
    b(bb.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<hr>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$initViewCallback$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends IListener<iv>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$initViewCallback$1$callback$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(bb.b.d paramd, iv paramiv)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$1$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.l
  {
    e(c.b paramb, bb.b paramb1) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(268802);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$$inlined$let$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$$inlined$let$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(268802);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(268801);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$$inlined$let$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = jdField_this;
      bb.b.a(paramRecyclerView, bb.b.a(paramRecyclerView) + paramInt2);
      paramRecyclerView = jdField_this;
      if (bb.b.a(jdField_this) < 0) {}
      float f;
      for (paramInt1 = 0;; paramInt1 = bb.b.a(jdField_this))
      {
        bb.b.a(paramRecyclerView, paramInt1);
        paramInt1 = jdField_this.iXq.getResources().getDimensionPixelOffset(b.d.Edge_14A);
        f = bb.b.a(jdField_this) / paramInt1;
        if (f != 0.0F) {
          break label210;
        }
        paramRecyclerView = this.xEo;
        if (paramRecyclerView != null) {
          break;
        }
        paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
        AppMethodBeat.o(268801);
        throw paramRecyclerView;
      }
      ((bb.c)paramRecyclerView).dua().setVisibility(4);
      for (;;)
      {
        paramRecyclerView = this.xEo;
        if (paramRecyclerView != null) {
          break;
        }
        paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
        AppMethodBeat.o(268801);
        throw paramRecyclerView;
        label210:
        paramRecyclerView = this.xEo;
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
          AppMethodBeat.o(268801);
          throw paramRecyclerView;
        }
        if (((bb.c)paramRecyclerView).dua().getVisibility() == 4)
        {
          paramRecyclerView = k.zWs;
          k.R(true, 6);
        }
        paramRecyclerView = this.xEo;
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
          AppMethodBeat.o(268801);
          throw paramRecyclerView;
        }
        ((bb.c)paramRecyclerView).dua().setVisibility(0);
      }
      ((bb.c)paramRecyclerView).dua().setAlpha(f);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$$inlined$let$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(268801);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$1$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class f
    extends IListener<com.tencent.mm.f.a.f>
  {
    f(bb.b paramb) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    g(bb.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(kotlin.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(221722);
      kotlin.g.a.a locala = this.xCK;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(221722);
        return;
      }
      AppMethodBeat.o(221722);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.bb.b
 * JD-Core Version:    0.7.0.1
 */