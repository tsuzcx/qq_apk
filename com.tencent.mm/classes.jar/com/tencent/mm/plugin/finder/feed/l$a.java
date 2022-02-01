package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.feed.model.i;
import com.tencent.mm.plugin.finder.feed.model.i.a;
import com.tencent.mm.plugin.finder.feed.model.i.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.view.FinderTagFlowLayout;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.viewmodel.FinderTopicFeedCache;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.ebq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.d.c;
import d.a.j;
import d.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "type", "", "topic", "", "onRequestFinished", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/ui/MMActivity;ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "TAB_TYPE", "getTAB_TYPE", "()I", "setTAB_TYPE", "(I)V", "TAG", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "iconUrl", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getOnRequestFinished", "()Lkotlin/jvm/functions/Function0;", "selectedTag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getSelectedTag", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setSelectedTag", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCache;", "getTopic", "totalCount", "", "getTotalCount", "()J", "setTotalCount", "(J)V", "getType", "viewCallback", "dealFirstRsp", "cache", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Companion$TopicTimelineCache;", "rsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "distinctResponseList", "Ljava/util/LinkedList;", "incrementList", "", "getData", "ifDummyTag", "", "tag", "onAttach", "callback", "onDetach", "onLoadEnd", "response", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;", "onResume", "onStop", "requestLoadMore", "requestRefresh", "scrollToTop", "endCallBack", "plugin-finder_release"})
public final class l$a
  implements i.a, com.tencent.mm.plugin.finder.presenter.base.a<l.b>
{
  dzw KOK;
  public int KPs;
  final FinderTopicFeedCache KPt;
  final String TAG;
  final ArrayList<BaseFinderFeed> dataList;
  public final String dqA;
  private String iconUrl;
  private final MMActivity imP;
  l.b qxA;
  public long qxB;
  final d.g.a.a<y> qxC;
  public final i qxz;
  public final int type;
  private com.tencent.mm.sdk.b.c<yp> xpb;
  
  public l$a(MMActivity paramMMActivity, int paramInt, String paramString, d.g.a.a<y> parama)
  {
    AppMethodBeat.i(198099);
    this.imP = paramMMActivity;
    this.type = paramInt;
    this.dqA = paramString;
    this.qxC = parama;
    this.TAG = "Finder.FinderTopicFeedUIContract.TopicFeedPresenter";
    paramInt = this.type;
    paramMMActivity = this.dqA;
    paramString = com.tencent.mm.ui.component.a.LCX;
    this.qxz = new i(paramInt, paramMMActivity, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.imP).get(FinderReporterUIC.class)).fXs());
    this.dataList = new ArrayList();
    paramMMActivity = new dzw();
    paramString = FinderTagView.LfB;
    paramMMActivity.LyD = FinderTagView.fWX();
    this.KOK = paramMMActivity;
    this.iconUrl = "";
    this.KPt = new FinderTopicFeedCache();
    AppMethodBeat.o(198099);
  }
  
  public static boolean b(dzw paramdzw)
  {
    AppMethodBeat.i(198098);
    d.g.b.k.h(paramdzw, "tag");
    long l = paramdzw.LyD;
    paramdzw = FinderTagView.LfB;
    if (l == FinderTagView.fWX())
    {
      AppMethodBeat.o(198098);
      return true;
    }
    AppMethodBeat.o(198098);
    return false;
  }
  
  public final void R(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(198097);
    Object localObject1 = this.qxA;
    if (localObject1 != null)
    {
      localObject1 = ((l.b)localObject1).getRecyclerView();
      if (localObject1 == null) {}
    }
    for (localObject1 = ((WxRecyclerView)localObject1).getLayoutManager(); (localObject1 instanceof StaggeredGridLayoutManager); localObject1 = null)
    {
      ((StaggeredGridLayoutManager)localObject1).af(0, 0);
      Object localObject2 = this.qxA;
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((l.b)localObject2).getRecyclerView();
      if (localObject2 == null) {
        break;
      }
      ((WxRecyclerView)localObject2).post((Runnable)new l.a.c((RecyclerView.i)localObject1, parama));
      AppMethodBeat.o(198097);
      return;
    }
    AppMethodBeat.o(198097);
  }
  
  public final void a(l.b paramb)
  {
    AppMethodBeat.i(165954);
    d.g.b.k.h(paramb, "callback");
    this.qxA = paramb;
    this.qxz.onAlive();
    paramb = this.qxA;
    Object localObject1;
    Object localObject2;
    if (paramb != null)
    {
      localObject1 = paramb.activity.getIntent().getByteArrayExtra("key_topic_poi_location");
      if (localObject1 != null)
      {
        localObject2 = new ajq();
        ((ajq)localObject2).parseFrom((byte[])localObject1);
        this.qxz.qyK = ((ajq)localObject2);
      }
      long l = paramb.activity.getIntent().getLongExtra("key_ref_object_id", 0L);
      this.qxz.qxU = Long.valueOf(l);
    }
    this.qxz.qyJ = ((i.a)this);
    this.xpb = ((com.tencent.mm.sdk.b.c)new l.a.b(this));
    com.tencent.mm.sdk.b.a.ESL.b(this.xpb);
    paramb = this.qxA;
    if (paramb != null)
    {
      localObject1 = paramb.activity.findViewById(2131306030);
      d.g.b.k.g(localObject1, "activity.findViewById(R.id.topic_recycler_view)");
      paramb.KPx = ((WxRecyclerView)localObject1);
      paramb.qul = ((WxRecyclerAdapter)new l.b.c(paramb, paramb.KMT.H((d.g.a.b)new l.b.a(paramb)), paramb.qxF.dataList));
      localObject1 = paramb.KPx;
      if (localObject1 == null) {
        d.g.b.k.aPZ("recyclerView");
      }
      ((WxRecyclerView)localObject1).setLayoutManager(paramb.KMT.lw((Context)paramb.activity));
      localObject1 = paramb.KPx;
      if (localObject1 == null) {
        d.g.b.k.aPZ("recyclerView");
      }
      ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)paramb.qul);
      localObject1 = paramb.activity.findViewById(2131303916);
      d.g.b.k.g(localObject1, "activity.findViewById(R.id.recycler_view_bg)");
      paramb.qxH = ((View)localObject1);
      localObject1 = paramb.activity.findViewById(2131306031);
      d.g.b.k.g(localObject1, "activity.findViewById<Te…>(R.id.topic_refresh_tip)");
      paramb.qxI = ((TextView)localObject1);
      localObject1 = paramb.qxI;
      if (localObject1 == null) {
        d.g.b.k.aPZ("refreshTip");
      }
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)new l.b.d(paramb));
      localObject1 = paramb.activity.findViewById(2131306029);
      d.g.b.k.g(localObject1, "activity.findViewById(R.id.topic_progress)");
      paramb.progressBar = ((View)localObject1);
      localObject1 = View.inflate((Context)paramb.activity, 2131494118, null);
      d.g.b.k.g(localObject1, "View.inflate(activity, R…_topic_feed_header, null)");
      paramb.qxG = ((View)localObject1);
      localObject1 = paramb.qxG;
      if (localObject1 == null) {
        d.g.b.k.aPZ("topicHeader");
      }
      localObject1 = ((View)localObject1).findViewById(2131306038);
      d.g.b.k.g(localObject1, "topicHeader.findViewById<TextView>(R.id.topic_tv)");
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)paramb.activity, (CharSequence)paramb.dqA));
      switch (paramb.type)
      {
      }
      for (;;)
      {
        localObject1 = paramb.qul;
        if (localObject1 != null)
        {
          localObject2 = paramb.qxG;
          if (localObject2 == null) {
            d.g.b.k.aPZ("topicHeader");
          }
          d.a((d)localObject1, (View)localObject2, paramb.qxJ);
        }
        localObject1 = paramb.qxH;
        if (localObject1 == null) {
          d.g.b.k.aPZ("recyclerBg");
        }
        ((View)localObject1).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new l.b.e(paramb));
        localObject1 = paramb.KPx;
        if (localObject1 == null) {
          d.g.b.k.aPZ("recyclerView");
        }
        ((WxRecyclerView)localObject1).b(paramb.KMT.getItemDecoration());
        localObject1 = paramb.KPx;
        if (localObject1 == null) {
          d.g.b.k.aPZ("recyclerView");
        }
        ((WxRecyclerView)localObject1).a((RecyclerView.m)new l.b.f(paramb));
        localObject1 = paramb.qul;
        if (localObject1 != null) {
          ((d)localObject1).Ibo = ((d.c)new l.b.b(paramb));
        }
        localObject1 = com.tencent.mm.ui.component.a.LCX;
        localObject1 = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramb.activity).get(FinderReporterUIC.class));
        if (localObject1 == null) {
          break;
        }
        paramb = paramb.KPx;
        if (paramb == null) {
          d.g.b.k.aPZ("recyclerView");
        }
        ((e)localObject1).v((RecyclerView)paramb);
        AppMethodBeat.o(165954);
        return;
        localObject1 = paramb.qxG;
        if (localObject1 == null) {
          d.g.b.k.aPZ("topicHeader");
        }
        ((ImageView)((View)localObject1).findViewById(2131306026)).setImageResource(2131690589);
        localObject1 = paramb.qxG;
        if (localObject1 == null) {
          d.g.b.k.aPZ("topicHeader");
        }
        localObject1 = ((View)localObject1).findViewById(2131306027);
        d.g.b.k.g(localObject1, "topicHeader.findViewById…w>(R.id.topic_icon_right)");
        ((ImageView)localObject1).setVisibility(8);
      }
      AppMethodBeat.o(165954);
      return;
    }
    AppMethodBeat.o(165954);
  }
  
  public final void a(final i.f paramf)
  {
    AppMethodBeat.i(165958);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.be(paramf);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter", "com/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback", "onLoadEnd", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;)V", this, localb.ado());
    d.g.b.k.h(paramf, "response");
    com.tencent.mm.ad.c.g((d.g.a.a)new a(this, paramf));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter", "com/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback", "onLoadEnd", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;)V");
    AppMethodBeat.o(165958);
  }
  
  public final void a(dzw paramdzw)
  {
    AppMethodBeat.i(198096);
    d.g.b.k.h(paramdzw, "<set-?>");
    this.KOK = paramdzw;
    AppMethodBeat.o(198096);
  }
  
  public final String cmt()
  {
    AppMethodBeat.i(165953);
    if (!this.dataList.isEmpty())
    {
      Object localObject = (bmd)j.C((List)((BaseFinderFeed)this.dataList.get(0)).feedObject.getMediaList(), 0);
      if (localObject != null)
      {
        localObject = ((bmd)localObject).thumbUrl + ((bmd)localObject).thumb_url_token;
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
    this.qxz.onDead();
    this.dataList.clear();
    l.b localb = this.qxA;
    Object localObject1;
    Object localObject2;
    if (localb != null)
    {
      localObject1 = localb.imP;
      localObject2 = FinderTagView.LfB;
      localObject2 = (FinderTagView)((MMActivity)localObject1).findViewById(FinderTagView.fWW());
      if (localObject2 != null) {
        break label526;
      }
      localObject1 = localb.KPx;
      if (localObject1 == null) {
        d.g.b.k.aPZ("recyclerView");
      }
      localObject2 = FinderTagView.LfB;
      localObject2 = (FinderTagView)((WxRecyclerView)localObject1).findViewById(FinderTagView.fWW());
    }
    label521:
    label526:
    for (;;)
    {
      Object localObject3;
      if (localObject2 != null)
      {
        localObject1 = FinderReporterUIC.Ljl;
        localObject1 = FinderReporterUIC.a.lB((Context)localb.imP);
        if (localObject1 == null) {
          break label521;
        }
        dzp localdzp = ((FinderReporterUIC)localObject1).fXs();
        if (localdzp == null) {
          break label521;
        }
        localObject1 = "";
        StringBuilder localStringBuilder;
        if (((FinderTagView)localObject2).Lft == 1)
        {
          j = ((FinderTagView)localObject2).getTagData().LAk.size();
          i = 0;
          for (;;)
          {
            localObject3 = localObject1;
            if (i >= j) {
              break;
            }
            localObject3 = (dzw)((FinderTagView)localObject2).getTagData().LAk.get(i);
            localStringBuilder = new StringBuilder().append((String)localObject1).append(((dzw)localObject3).dqA).append(";1;");
            localObject3 = (Integer)((FinderTagView)localObject2).getTagClickMap().get(Long.valueOf(((dzw)localObject3).LyD));
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = Integer.valueOf(0);
            }
            localObject1 = localObject1 + '#';
            i += 1;
          }
        }
        int j = ((List)((FinderTagView)localObject2).getTagLayout().qXQ.get(0)).size();
        int i = 0;
        for (;;)
        {
          localObject3 = localObject1;
          if (i >= j) {
            break;
          }
          localObject3 = (dzw)((FinderTagView)localObject2).getTagData().LAk.get(i);
          localStringBuilder = new StringBuilder().append((String)localObject1).append(((dzw)localObject3).dqA).append(";1;");
          localObject3 = (Integer)((FinderTagView)localObject2).getTagClickMap().get(Long.valueOf(((dzw)localObject3).LyD));
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = Integer.valueOf(0);
          }
          localObject1 = localObject1 + '#';
          i += 1;
        }
        localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
        com.tencent.mm.plugin.finder.report.b.a(localdzp, localb.dqA, (String)localObject3, ((FinderTagView)localObject2).getHasExpandBtn(), ((FinderTagView)localObject2).Lft);
      }
      for (localObject1 = y.JfV;; localObject1 = null)
      {
        if (localObject1 == null)
        {
          localObject1 = (l.b)localb;
          localObject2 = FinderReporterUIC.Ljl;
          localObject2 = FinderReporterUIC.a.lB((Context)((l.b)localObject1).imP);
          if (localObject2 != null)
          {
            localObject2 = ((FinderReporterUIC)localObject2).fXs();
            if (localObject2 != null)
            {
              localObject3 = com.tencent.mm.plugin.finder.report.b.qFq;
              com.tencent.mm.plugin.finder.report.b.a((dzp)localObject2, ((l.b)localObject1).dqA, "", 0, 0);
              localObject1 = y.JfV;
            }
          }
        }
        this.qxA = null;
        this.KPt.ae();
        com.tencent.mm.sdk.b.a.ESL.d(this.xpb);
        AppMethodBeat.o(165956);
        return;
      }
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(165957);
    if (b(this.KOK))
    {
      this.qxz.a(this.KPs, null, -1);
      localObject = this.qxA;
      if (localObject != null) {
        ((l.b)localObject).kV(true);
      }
      localObject = this.qxA;
      if (localObject != null)
      {
        ((l.b)localObject).n(null, 0, false);
        AppMethodBeat.o(165957);
        return;
      }
      AppMethodBeat.o(165957);
      return;
    }
    Object localObject = new ebq();
    ((ebq)localObject).LAk = new LinkedList();
    ((ebq)localObject).LAk.add(this.KOK);
    this.qxz.a(this.KPs, (ebq)localObject, 4);
    AppMethodBeat.o(165957);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(l.a parama, i.f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.l.a
 * JD-Core Version:    0.7.0.1
 */