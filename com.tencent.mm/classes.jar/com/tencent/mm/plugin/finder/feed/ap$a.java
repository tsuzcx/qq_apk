package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderTagFlowLayout;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.view.FinderTagView.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTopicFeedCache;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.ctu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "TAB_TYPE", "getTAB_TYPE", "()I", "setTAB_TYPE", "(I)V", "TAG", "", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "iconUrl", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "onRequestFinished", "Lkotlin/Function0;", "", "getOnRequestFinished", "()Lkotlin/jvm/functions/Function0;", "setOnRequestFinished", "(Lkotlin/jvm/functions/Function0;)V", "selectedTag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getSelectedTag", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setSelectedTag", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCache;", "topic", "getTopic", "setTopic", "topicRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getTopicRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setTopicRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "totalCount", "", "getTotalCount", "()J", "setTotalCount", "(J)V", "type", "getType", "setType", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dealFirstRsp", "rsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "distinctResponseList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "incrementList", "", "getIViewActionCallback", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "ifDummyTag", "", "tag", "initViewCallback", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "scrollToTop", "endCallBack", "showNoMoreView", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
public final class ap$a
  extends b.a
{
  final String TAG;
  public String dBe;
  private String iconUrl;
  public long sbT;
  private com.tencent.mm.sdk.b.c<hs> seA;
  asv shI;
  public int sjg;
  final FinderTopicFeedCache sjh;
  private com.tencent.mm.view.d sji;
  public int type;
  
  public ap$a(final MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(202751);
    this.TAG = "Finder.FinderTopicFeedUIContract.TopicFeedPresenter";
    this.dBe = "";
    paramBaseFinderFeedLoader = new asv();
    FinderTagView.a locala = FinderTagView.thj;
    paramBaseFinderFeedLoader.GJQ = FinderTagView.cQm();
    this.shI = paramBaseFinderFeedLoader;
    this.iconUrl = "";
    this.sjh = new FinderTopicFeedCache();
    this.sji = ((com.tencent.mm.view.d)new com.tencent.mm.view.d()
    {
      public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(202732);
        Object localObject1 = this.sjj.scu;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.d)((b.b)localObject1).scj;
          if (localObject1 != null)
          {
            Object localObject2 = this.sjj.scu;
            if (localObject2 != null)
            {
              localObject2 = ((b.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).LRV.size();; i = 0)
            {
              ((com.tencent.mm.view.d)localObject1).au(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(202732);
              return;
            }
          }
        }
        AppMethodBeat.o(202732);
      }
      
      public final void av(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(202733);
        Object localObject1 = this.sjj.scu;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.d)((b.b)localObject1).scj;
          if (localObject1 != null)
          {
            localObject2 = this.sjj.scu;
            if (localObject2 == null) {
              break label105;
            }
            localObject2 = ((b.b)localObject2).getAdapter();
            if (localObject2 == null) {
              break label105;
            }
          }
        }
        label105:
        for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).LRV.size();; i = 0)
        {
          ((com.tencent.mm.view.d)localObject1).av(i + paramAnonymousInt1, paramAnonymousInt2);
          localObject1 = this.sjj.scu;
          if (localObject1 == null) {
            break;
          }
          ((b.b)localObject1).cCF();
          AppMethodBeat.o(202733);
          return;
        }
        AppMethodBeat.o(202733);
      }
      
      public final void c(final RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(202728);
        p.h(paramAnonymousc, "reason");
        com.tencent.mm.ac.c.h((d.g.a.a)new b(this, paramAnonymousc));
        AppMethodBeat.o(202728);
      }
      
      public final void d(final RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(202729);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.sjj.scu;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.d)((b.b)localObject).scj;
          if (localObject != null) {
            ((com.tencent.mm.view.d)localObject).d(paramAnonymousc);
          }
        }
        com.tencent.mm.ac.c.h((d.g.a.a)new a(this, paramAnonymousc));
        AppMethodBeat.o(202729);
      }
      
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(202731);
        Object localObject1 = this.sjj.scu;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.d)((b.b)localObject1).scj;
          if (localObject1 != null)
          {
            Object localObject2 = this.sjj.scu;
            if (localObject2 != null)
            {
              localObject2 = ((b.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).LRV.size();; i = 0)
            {
              ((com.tencent.mm.view.d)localObject1).f(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
              AppMethodBeat.o(202731);
              return;
            }
          }
        }
        AppMethodBeat.o(202731);
      }
      
      public final void onChanged()
      {
        AppMethodBeat.i(202730);
        Object localObject = this.sjj.scu;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.d)((b.b)localObject).scj;
          if (localObject != null)
          {
            ((com.tencent.mm.view.d)localObject).onChanged();
            AppMethodBeat.o(202730);
            return;
          }
        }
        AppMethodBeat.o(202730);
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
      static final class a
        extends q
        implements d.g.a.a<d.z>
      {
        a(ap.a.1 param1, RefreshLoadMoreLayout.c paramc)
        {
          super();
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
      static final class b
        extends q
        implements d.g.a.a<d.z>
      {
        b(ap.a.1 param1, RefreshLoadMoreLayout.c paramc)
        {
          super();
        }
      }
    });
    AppMethodBeat.o(202751);
  }
  
  public static boolean b(asv paramasv)
  {
    AppMethodBeat.i(202746);
    p.h(paramasv, "tag");
    long l = paramasv.GJQ;
    paramasv = FinderTagView.thj;
    if (l == FinderTagView.cQm())
    {
      AppMethodBeat.o(202746);
      return true;
    }
    AppMethodBeat.o(202746);
    return false;
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(202744);
    p.h(paramb, "callback");
    super.a(paramb);
    paramb = this.scu;
    if (paramb != null)
    {
      Object localObject = paramb.getActivity().getIntent().getByteArrayExtra("key_topic_poi_location");
      if (localObject != null)
      {
        apl localapl = new apl();
        localapl.parseFrom((byte[])localObject);
        localObject = this.scw;
        if (localObject == null)
        {
          paramb = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
          AppMethodBeat.o(202744);
          throw paramb;
        }
        ((FinderTopicFeedLoader)localObject).slb = localapl;
      }
      long l = paramb.getActivity().getIntent().getLongExtra("key_ref_object_id", 0L);
      paramb = this.scw;
      if (paramb == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(202744);
        throw paramb;
      }
      ((FinderTopicFeedLoader)paramb).slc = Long.valueOf(l);
    }
    paramb = this.scw;
    if (paramb == null)
    {
      paramb = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
      AppMethodBeat.o(202744);
      throw paramb;
    }
    ((FinderTopicFeedLoader)paramb).sld = ((d.g.a.a)new c(this));
    AppMethodBeat.o(202744);
  }
  
  public final void a(asv paramasv)
  {
    AppMethodBeat.i(202743);
    p.h(paramasv, "<set-?>");
    this.shI = paramasv;
    AppMethodBeat.o(202743);
  }
  
  public final void aTS()
  {
    AppMethodBeat.i(202749);
    if (b(this.shI))
    {
      localObject = this.scw;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(202749);
        throw ((Throwable)localObject);
      }
      FinderTopicFeedLoader.b((FinderTopicFeedLoader)localObject, this.sjg);
      AppMethodBeat.o(202749);
      return;
    }
    Object localObject = new ctu();
    ((ctu)localObject).HEO = new LinkedList();
    ((ctu)localObject).HEO.add(this.shI);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.scw;
    if (localBaseFinderFeedLoader == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
      AppMethodBeat.o(202749);
      throw ((Throwable)localObject);
    }
    ((FinderTopicFeedLoader)localBaseFinderFeedLoader).a(this.sjg, (ctu)localObject);
    AppMethodBeat.o(202749);
  }
  
  public final void cCm()
  {
    AppMethodBeat.i(202748);
    b.b localb = this.scu;
    if (localb != null) {
      localb.U((ArrayList)this.scw.getDataListJustForAdapter());
    }
    this.seA = ((com.tencent.mm.sdk.b.c)new b(this));
    com.tencent.mm.sdk.b.a.IvT.b(this.seA);
    AppMethodBeat.o(202748);
  }
  
  public final com.tencent.mm.view.recyclerview.c cCq()
  {
    AppMethodBeat.i(202747);
    Object localObject = this.scu;
    if (localObject == null) {
      p.gkB();
    }
    localObject = ((b.b)localObject).cCD().B((d.g.a.b)new a(this));
    AppMethodBeat.o(202747);
    return localObject;
  }
  
  public final com.tencent.mm.view.d cCz()
  {
    return this.sji;
  }
  
  public final String getIconUrl()
  {
    AppMethodBeat.i(165953);
    Object localObject = this.scw.getListOfType(BaseFinderFeed.class);
    if (!((List)localObject).isEmpty())
    {
      localObject = (bvz)j.F((List)((BaseFinderFeed)((List)localObject).get(0)).feedObject.getMediaList(), 0);
      if (localObject != null)
      {
        localObject = ((bvz)localObject).thumbUrl + ((bvz)localObject).thumb_url_token;
        AppMethodBeat.o(165953);
        return localObject;
      }
    }
    AppMethodBeat.o(165953);
    return "";
  }
  
  public final void h(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202750);
    p.h(paramc, "reason");
    paramc = paramc.skU;
    if (paramc == null)
    {
      paramc = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicResponse");
      AppMethodBeat.o(202750);
      throw paramc;
    }
    if (!((FinderTopicFeedLoader.e)paramc).getHasMore())
    {
      paramc = this.scu;
      if (paramc != null)
      {
        paramc = paramc.scj;
        if (paramc != null) {
          if (this.scw.getSize() <= 10) {
            break label203;
          }
        }
      }
      label203:
      for (boolean bool = true;; bool = false)
      {
        paramc.setEnableLoadMore(bool);
        paramc = this.scu;
        if (paramc != null)
        {
          paramc = paramc.scj;
          if (paramc != null)
          {
            paramc = paramc.getLoadMoreFooter();
            if (paramc != null)
            {
              paramc = (TextView)paramc.findViewById(2131301486);
              if (paramc != null) {
                paramc.setText(2131759245);
              }
            }
          }
        }
        paramc = this.scu;
        if (paramc == null) {
          break;
        }
        paramc = paramc.scj;
        if (paramc == null) {
          break;
        }
        paramc = paramc.getLoadMoreFooter();
        if (paramc == null) {
          break;
        }
        paramc = (TextView)paramc.findViewById(2131301486);
        if (paramc == null) {
          break;
        }
        paramc.setTextColor(this.fNT.getResources().getColor(2131099735));
        AppMethodBeat.o(202750);
        return;
      }
      AppMethodBeat.o(202750);
      return;
    }
    paramc = this.scu;
    if (paramc != null)
    {
      paramc = paramc.scj;
      if (paramc != null)
      {
        paramc.setEnableLoadMore(true);
        AppMethodBeat.o(202750);
        return;
      }
    }
    AppMethodBeat.o(202750);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165956);
    super.onDetach();
    this.sjh.af();
    Object localObject1 = this.scu;
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
      AppMethodBeat.o(165956);
      throw ((Throwable)localObject1);
    }
    ap.b localb = (ap.b)localObject1;
    localObject1 = localb.fNT;
    Object localObject2 = FinderTagView.thj;
    localObject2 = (FinderTagView)((MMActivity)localObject1).findViewById(FinderTagView.cQl());
    if (localObject2 == null)
    {
      localObject1 = localb.scj.getRecyclerView();
      localObject2 = FinderTagView.thj;
      localObject2 = (FinderTagView)((RecyclerView)localObject1).findViewById(FinderTagView.cQl());
    }
    for (;;)
    {
      Object localObject3;
      if (localObject2 != null)
      {
        localObject1 = FinderReporterUIC.tnG;
        localObject1 = FinderReporterUIC.a.fc((Context)localb.fNT);
        if (localObject1 == null) {
          break label522;
        }
        arn localarn = ((FinderReporterUIC)localObject1).cQZ();
        if (localarn == null) {
          break label522;
        }
        localObject1 = "";
        StringBuilder localStringBuilder;
        if (((FinderTagView)localObject2).thb == 1)
        {
          j = ((FinderTagView)localObject2).getTagData().HEO.size();
          i = 0;
          for (;;)
          {
            localObject3 = localObject1;
            if (i >= j) {
              break;
            }
            localObject3 = (asv)((FinderTagView)localObject2).getTagData().HEO.get(i);
            localStringBuilder = new StringBuilder().append((String)localObject1).append(((asv)localObject3).dBe).append(";1;");
            localObject3 = (Integer)((FinderTagView)localObject2).getTagClickMap().get(Long.valueOf(((asv)localObject3).GJQ));
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = Integer.valueOf(0);
            }
            localObject1 = localObject1 + '#';
            i += 1;
          }
        }
        int j = ((List)((FinderTagView)localObject2).getTagLayout().tgN.get(0)).size();
        int i = 0;
        for (;;)
        {
          localObject3 = localObject1;
          if (i >= j) {
            break;
          }
          localObject3 = (asv)((FinderTagView)localObject2).getTagData().HEO.get(i);
          localStringBuilder = new StringBuilder().append((String)localObject1).append(((asv)localObject3).dBe).append(";1;");
          localObject3 = (Integer)((FinderTagView)localObject2).getTagClickMap().get(Long.valueOf(((asv)localObject3).GJQ));
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = Integer.valueOf(0);
          }
          localObject1 = localObject1 + '#';
          i += 1;
        }
        localObject1 = i.syT;
        i.a(localarn, localb.dBe, (String)localObject3, ((FinderTagView)localObject2).getHasExpandBtn(), ((FinderTagView)localObject2).thb);
      }
      label522:
      for (localObject1 = d.z.Nhr;; localObject1 = null)
      {
        if (localObject1 == null)
        {
          localObject1 = (ap.b)localb;
          localObject2 = FinderReporterUIC.tnG;
          localObject2 = FinderReporterUIC.a.fc((Context)((b.b)localObject1).fNT);
          if (localObject2 != null)
          {
            localObject2 = ((FinderReporterUIC)localObject2).cQZ();
            if (localObject2 != null)
            {
              localObject3 = i.syT;
              i.a((arn)localObject2, ((ap.b)localObject1).dBe, "", 0, 0);
              localObject1 = d.z.Nhr;
            }
          }
        }
        com.tencent.mm.sdk.b.a.IvT.d(this.seA);
        AppMethodBeat.o(165956);
        return;
      }
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(165957);
    if (b(this.shI))
    {
      localObject = this.scw;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(165957);
        throw ((Throwable)localObject);
      }
      FinderTopicFeedLoader.a((FinderTopicFeedLoader)localObject, this.sjg);
      AppMethodBeat.o(165957);
      return;
    }
    Object localObject = new ctu();
    ((ctu)localObject).HEO = new LinkedList();
    ((ctu)localObject).HEO.add(this.shI);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.scw;
    if (localBaseFinderFeedLoader == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
      AppMethodBeat.o(165957);
      throw ((Throwable)localObject);
    }
    ((FinderTopicFeedLoader)localBaseFinderFeedLoader).a(this.sjg, (ctu)localObject, 4);
    AppMethodBeat.o(165957);
  }
  
  public final void y(d.g.a.a<d.z> parama)
  {
    AppMethodBeat.i(202745);
    Object localObject = this.scu;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).scj.getRecyclerView();
      if (localObject != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter", "scrollToTop", "(Lkotlin/jvm/functions/Function0;)V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject).ca(((Integer)locala.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter", "scrollToTop", "(Lkotlin/jvm/functions/Function0;)V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
    localObject = this.scu;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).scj.getRecyclerView();
      if (localObject != null)
      {
        ((RecyclerView)localObject).post((Runnable)new ap.a.d(parama));
        AppMethodBeat.o(202745);
        return;
      }
    }
    AppMethodBeat.o(202745);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<Integer, com.tencent.mm.view.recyclerview.b<?>>
  {
    a(ap.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$initViewCallback$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<hs>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$initViewCallback$1$callback$1$1"})
    static final class a
      extends q
      implements d.g.a.a<d.z>
    {
      a(ap.a.b paramb, hs paramhs)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<d.z>
  {
    c(ap.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ap.a
 * JD-Core Version:    0.7.0.1
 */