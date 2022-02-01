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
import com.tencent.mm.g.a.hk;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.feed.model.n;
import com.tencent.mm.plugin.finder.feed.model.n.a;
import com.tencent.mm.plugin.finder.feed.model.n.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.view.FinderTagFlowLayout;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.viewmodel.FinderTopicFeedCache;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.d.c;
import d.a.j;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "type", "", "topic", "", "onRequestFinished", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/ui/MMActivity;ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "TAB_TYPE", "getTAB_TYPE", "()I", "setTAB_TYPE", "(I)V", "TAG", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "iconUrl", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getOnRequestFinished", "()Lkotlin/jvm/functions/Function0;", "selectedTag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getSelectedTag", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setSelectedTag", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCache;", "getTopic", "totalCount", "", "getTotalCount", "()J", "setTotalCount", "(J)V", "getType", "viewCallback", "dealFirstRsp", "cache", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Companion$TopicTimelineCache;", "rsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "distinctResponseList", "Ljava/util/LinkedList;", "incrementList", "", "getData", "ifDummyTag", "", "tag", "onAttach", "callback", "onDetach", "onLoadEnd", "response", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;", "onResume", "onStop", "requestLoadMore", "requestRefresh", "scrollToTop", "endCallBack", "plugin-finder_release"})
public final class ai$a
  implements n.a, com.tencent.mm.plugin.finder.presenter.base.a<ai.b>
{
  final String TAG;
  final ArrayList<BaseFinderFeed> dataList;
  public final String dol;
  private final MMActivity iMV;
  private String iconUrl;
  public long rfD;
  private com.tencent.mm.sdk.b.c<hk> rhM;
  aop rkv;
  public final n rlI;
  ai.b rlJ;
  public int rlK;
  final FinderTopicFeedCache rlL;
  final d.g.a.a<y> rlM;
  public final int type;
  
  public ai$a(MMActivity paramMMActivity, int paramInt, String paramString, d.g.a.a<y> parama)
  {
    AppMethodBeat.i(202007);
    this.iMV = paramMMActivity;
    this.type = paramInt;
    this.dol = paramString;
    this.rlM = parama;
    this.TAG = "Finder.FinderTopicFeedUIContract.TopicFeedPresenter";
    paramInt = this.type;
    paramMMActivity = this.dol;
    paramString = com.tencent.mm.ui.component.a.IrY;
    this.rlI = new n(paramInt, paramMMActivity, ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.iMV).get(FinderReporterUIC.class)).cGb());
    this.dataList = new ArrayList();
    paramMMActivity = new aop();
    paramString = FinderTagView.rYW;
    paramMMActivity.EHG = FinderTagView.cFi();
    this.rkv = paramMMActivity;
    this.iconUrl = "";
    this.rlL = new FinderTopicFeedCache();
    AppMethodBeat.o(202007);
  }
  
  public static boolean b(aop paramaop)
  {
    AppMethodBeat.i(202006);
    d.g.b.k.h(paramaop, "tag");
    long l = paramaop.EHG;
    paramaop = FinderTagView.rYW;
    if (l == FinderTagView.cFi())
    {
      AppMethodBeat.o(202006);
      return true;
    }
    AppMethodBeat.o(202006);
    return false;
  }
  
  public final void a(ai.b paramb)
  {
    AppMethodBeat.i(165954);
    d.g.b.k.h(paramb, "callback");
    this.rlJ = paramb;
    this.rlI.onAlive();
    paramb = this.rlJ;
    Object localObject1;
    Object localObject2;
    if (paramb != null)
    {
      localObject1 = paramb.activity.getIntent().getByteArrayExtra("key_topic_poi_location");
      if (localObject1 != null)
      {
        localObject2 = new alt();
        ((alt)localObject2).parseFrom((byte[])localObject1);
        this.rlI.rnp = ((alt)localObject2);
      }
      long l = paramb.activity.getIntent().getLongExtra("key_ref_object_id", 0L);
      this.rlI.rmi = Long.valueOf(l);
    }
    this.rlI.rno = ((n.a)this);
    this.rhM = ((com.tencent.mm.sdk.b.c)new a(this));
    com.tencent.mm.sdk.b.a.GpY.b(this.rhM);
    paramb = this.rlJ;
    if (paramb != null)
    {
      localObject1 = paramb.activity.findViewById(2131306030);
      d.g.b.k.g(localObject1, "activity.findViewById(R.id.topic_recycler_view)");
      paramb.rlU = ((WxRecyclerView)localObject1);
      paramb.rfX = ((WxRecyclerAdapter)new ai.b.a(paramb, paramb.rgm.A((d.g.a.b)new ai.b.b(paramb)), paramb.rlS.dataList));
      localObject1 = paramb.rlU;
      if (localObject1 == null) {
        d.g.b.k.aVY("recyclerView");
      }
      ((WxRecyclerView)localObject1).setLayoutManager(paramb.rgm.eL((Context)paramb.activity));
      localObject1 = paramb.rlU;
      if (localObject1 == null) {
        d.g.b.k.aVY("recyclerView");
      }
      ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)paramb.rfX);
      localObject1 = paramb.activity.findViewById(2131303916);
      d.g.b.k.g(localObject1, "activity.findViewById(R.id.recycler_view_bg)");
      paramb.rlV = ((View)localObject1);
      localObject1 = paramb.activity.findViewById(2131306031);
      d.g.b.k.g(localObject1, "activity.findViewById<Te…>(R.id.topic_refresh_tip)");
      paramb.rlW = ((TextView)localObject1);
      localObject1 = paramb.rlW;
      if (localObject1 == null) {
        d.g.b.k.aVY("refreshTip");
      }
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)new ai.b.c(paramb));
      localObject1 = paramb.activity.findViewById(2131306029);
      d.g.b.k.g(localObject1, "activity.findViewById(R.id.topic_progress)");
      paramb.progressBar = ((View)localObject1);
      localObject1 = View.inflate((Context)paramb.activity, 2131494118, null);
      d.g.b.k.g(localObject1, "View.inflate(activity, R…_topic_feed_header, null)");
      paramb.rlT = ((View)localObject1);
      localObject1 = paramb.rlT;
      if (localObject1 == null) {
        d.g.b.k.aVY("topicHeader");
      }
      localObject1 = ((View)localObject1).findViewById(2131306038);
      d.g.b.k.g(localObject1, "topicHeader.findViewById<TextView>(R.id.topic_tv)");
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)paramb.activity, (CharSequence)paramb.dol));
      switch (paramb.type)
      {
      }
      for (;;)
      {
        localObject1 = paramb.rfX;
        if (localObject1 != null)
        {
          localObject2 = paramb.rlT;
          if (localObject2 == null) {
            d.g.b.k.aVY("topicHeader");
          }
          com.tencent.mm.view.recyclerview.d.a((com.tencent.mm.view.recyclerview.d)localObject1, (View)localObject2, paramb.rgk);
        }
        localObject1 = paramb.rlV;
        if (localObject1 == null) {
          d.g.b.k.aVY("recyclerBg");
        }
        ((View)localObject1).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new ai.b.d(paramb));
        localObject1 = paramb.rlU;
        if (localObject1 == null) {
          d.g.b.k.aVY("recyclerView");
        }
        ((WxRecyclerView)localObject1).b(paramb.rgm.getItemDecoration());
        localObject1 = paramb.rlU;
        if (localObject1 == null) {
          d.g.b.k.aVY("recyclerView");
        }
        ((WxRecyclerView)localObject1).a((RecyclerView.m)new ai.b.e(paramb));
        localObject1 = paramb.rfX;
        if (localObject1 != null) {
          ((com.tencent.mm.view.recyclerview.d)localObject1).JCe = ((d.c)new ai.b.f(paramb));
        }
        localObject1 = com.tencent.mm.ui.component.a.IrY;
        localObject1 = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.q(paramb.activity).get(FinderReporterUIC.class));
        if (localObject1 == null) {
          break;
        }
        paramb = paramb.rlU;
        if (paramb == null) {
          d.g.b.k.aVY("recyclerView");
        }
        ((f)localObject1).s((RecyclerView)paramb);
        AppMethodBeat.o(165954);
        return;
        localObject1 = paramb.rlT;
        if (localObject1 == null) {
          d.g.b.k.aVY("topicHeader");
        }
        ((ImageView)((View)localObject1).findViewById(2131306026)).setImageResource(2131690589);
        localObject1 = paramb.rlT;
        if (localObject1 == null) {
          d.g.b.k.aVY("topicHeader");
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
  
  public final void a(final n.f paramf)
  {
    AppMethodBeat.i(165958);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bb(paramf);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter", "com/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback", "onLoadEnd", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;)V", this, localb.aeE());
    d.g.b.k.h(paramf, "response");
    com.tencent.mm.ac.c.g((d.g.a.a)new b(this, paramf));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter", "com/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$FeedLoadCallback", "onLoadEnd", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;)V");
    AppMethodBeat.o(165958);
  }
  
  public final void a(aop paramaop)
  {
    AppMethodBeat.i(202004);
    d.g.b.k.h(paramaop, "<set-?>");
    this.rkv = paramaop;
    AppMethodBeat.o(202004);
  }
  
  public final String cvw()
  {
    AppMethodBeat.i(165953);
    if (!this.dataList.isEmpty())
    {
      Object localObject = (bqs)j.C((List)((BaseFinderFeed)this.dataList.get(0)).feedObject.getMediaList(), 0);
      if (localObject != null)
      {
        localObject = ((bqs)localObject).thumbUrl + ((bqs)localObject).thumb_url_token;
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
    this.rlI.onDead();
    this.dataList.clear();
    ai.b localb = this.rlJ;
    Object localObject1;
    Object localObject2;
    if (localb != null)
    {
      localObject1 = localb.iMV;
      localObject2 = FinderTagView.rYW;
      localObject2 = (FinderTagView)((MMActivity)localObject1).findViewById(FinderTagView.cFh());
      if (localObject2 != null) {
        break label526;
      }
      localObject1 = localb.rlU;
      if (localObject1 == null) {
        d.g.b.k.aVY("recyclerView");
      }
      localObject2 = FinderTagView.rYW;
      localObject2 = (FinderTagView)((WxRecyclerView)localObject1).findViewById(FinderTagView.cFh());
    }
    label521:
    label526:
    for (;;)
    {
      Object localObject3;
      if (localObject2 != null)
      {
        localObject1 = FinderReporterUIC.seQ;
        localObject1 = FinderReporterUIC.a.eV((Context)localb.iMV);
        if (localObject1 == null) {
          break label521;
        }
        anm localanm = ((FinderReporterUIC)localObject1).cGb();
        if (localanm == null) {
          break label521;
        }
        localObject1 = "";
        StringBuilder localStringBuilder;
        if (((FinderTagView)localObject2).rYO == 1)
        {
          j = ((FinderTagView)localObject2).getTagData().FBb.size();
          i = 0;
          for (;;)
          {
            localObject3 = localObject1;
            if (i >= j) {
              break;
            }
            localObject3 = (aop)((FinderTagView)localObject2).getTagData().FBb.get(i);
            localStringBuilder = new StringBuilder().append((String)localObject1).append(((aop)localObject3).dol).append(";1;");
            localObject3 = (Integer)((FinderTagView)localObject2).getTagClickMap().get(Long.valueOf(((aop)localObject3).EHG));
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = Integer.valueOf(0);
            }
            localObject1 = localObject1 + '#';
            i += 1;
          }
        }
        int j = ((List)((FinderTagView)localObject2).getTagLayout().rYA.get(0)).size();
        int i = 0;
        for (;;)
        {
          localObject3 = localObject1;
          if (i >= j) {
            break;
          }
          localObject3 = (aop)((FinderTagView)localObject2).getTagData().FBb.get(i);
          localStringBuilder = new StringBuilder().append((String)localObject1).append(((aop)localObject3).dol).append(";1;");
          localObject3 = (Integer)((FinderTagView)localObject2).getTagClickMap().get(Long.valueOf(((aop)localObject3).EHG));
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = Integer.valueOf(0);
          }
          localObject1 = localObject1 + '#';
          i += 1;
        }
        localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
        com.tencent.mm.plugin.finder.report.d.a(localanm, localb.dol, (String)localObject3, ((FinderTagView)localObject2).getHasExpandBtn(), ((FinderTagView)localObject2).rYO);
      }
      for (localObject1 = y.KTp;; localObject1 = null)
      {
        if (localObject1 == null)
        {
          localObject1 = (ai.b)localb;
          localObject2 = FinderReporterUIC.seQ;
          localObject2 = FinderReporterUIC.a.eV((Context)((ai.b)localObject1).iMV);
          if (localObject2 != null)
          {
            localObject2 = ((FinderReporterUIC)localObject2).cGb();
            if (localObject2 != null)
            {
              localObject3 = com.tencent.mm.plugin.finder.report.d.rxr;
              com.tencent.mm.plugin.finder.report.d.a((anm)localObject2, ((ai.b)localObject1).dol, "", 0, 0);
              localObject1 = y.KTp;
            }
          }
        }
        this.rlJ = null;
        this.rlL.ae();
        com.tencent.mm.sdk.b.a.GpY.d(this.rhM);
        AppMethodBeat.o(165956);
        return;
      }
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(165957);
    if (b(this.rkv))
    {
      this.rlI.a(this.rlK, null, -1);
      localObject = this.rlJ;
      if (localObject != null) {
        ((ai.b)localObject).lA(true);
      }
      localObject = this.rlJ;
      if (localObject != null)
      {
        ((ai.b)localObject).n(null, 0, false);
        AppMethodBeat.o(165957);
        return;
      }
      AppMethodBeat.o(165957);
      return;
    }
    Object localObject = new cnx();
    ((cnx)localObject).FBb = new LinkedList();
    ((cnx)localObject).FBb.add(this.rkv);
    this.rlI.a(this.rlK, (cnx)localObject, 4);
    AppMethodBeat.o(165957);
  }
  
  public final void v(final d.g.a.a<y> parama)
  {
    AppMethodBeat.i(202005);
    Object localObject1 = this.rlJ;
    if (localObject1 != null)
    {
      localObject1 = ((ai.b)localObject1).getRecyclerView();
      if (localObject1 == null) {}
    }
    for (localObject1 = ((WxRecyclerView)localObject1).getLayoutManager(); (localObject1 instanceof StaggeredGridLayoutManager); localObject1 = null)
    {
      ((StaggeredGridLayoutManager)localObject1).af(0, 0);
      Object localObject2 = this.rlJ;
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((ai.b)localObject2).getRecyclerView();
      if (localObject2 == null) {
        break;
      }
      ((WxRecyclerView)localObject2).post((Runnable)new c((RecyclerView.i)localObject1, parama));
      AppMethodBeat.o(202005);
      return;
    }
    AppMethodBeat.o(202005);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.sdk.b.c<hk>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$2$callback$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(ai.a.a parama, hk paramhk)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(ai.a parama, n.f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(RecyclerView.i parami, d.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(202003);
      ((StaggeredGridLayoutManager)this.rjQ).af(0, 0);
      d.g.a.a locala = parama;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(202003);
        return;
      }
      AppMethodBeat.o(202003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ai.a
 * JD-Core Version:    0.7.0.1
 */