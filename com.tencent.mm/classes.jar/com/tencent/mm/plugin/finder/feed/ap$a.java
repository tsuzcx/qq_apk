package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderTagFlowLayout;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.view.FinderTagView.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTopicFeedCache;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.cta;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "TAB_TYPE", "getTAB_TYPE", "()I", "setTAB_TYPE", "(I)V", "TAG", "", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "iconUrl", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "onRequestFinished", "Lkotlin/Function0;", "", "getOnRequestFinished", "()Lkotlin/jvm/functions/Function0;", "setOnRequestFinished", "(Lkotlin/jvm/functions/Function0;)V", "selectedTag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getSelectedTag", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setSelectedTag", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCache;", "topic", "getTopic", "setTopic", "topicRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getTopicRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setTopicRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "totalCount", "", "getTotalCount", "()J", "setTotalCount", "(J)V", "type", "getType", "setType", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dealFirstRsp", "rsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "distinctResponseList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "incrementList", "", "getIViewActionCallback", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "ifDummyTag", "", "tag", "initViewCallback", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "scrollToTop", "endCallBack", "showNoMoreView", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
public final class ap$a
  extends b.a
{
  final String TAG;
  public String dzZ;
  private String iconUrl;
  public long rTp;
  private com.tencent.mm.sdk.b.c<hr> rVT;
  asg rYW;
  public int sar;
  final FinderTopicFeedCache sas;
  private com.tencent.mm.view.d sat;
  public int type;
  
  public ap$a(final MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(202286);
    this.TAG = "Finder.FinderTopicFeedUIContract.TopicFeedPresenter";
    this.dzZ = "";
    paramBaseFinderFeedLoader = new asg();
    FinderTagView.a locala = FinderTagView.sVS;
    paramBaseFinderFeedLoader.Gqv = FinderTagView.cNC();
    this.rYW = paramBaseFinderFeedLoader;
    this.iconUrl = "";
    this.sas = new FinderTopicFeedCache();
    this.sat = ((com.tencent.mm.view.d)new com.tencent.mm.view.d()
    {
      public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(202267);
        Object localObject1 = this.sau.rTQ;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.d)((b.b)localObject1).rTF;
          if (localObject1 != null)
          {
            Object localObject2 = this.sau.rTQ;
            if (localObject2 != null)
            {
              localObject2 = ((b.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).Lvi.size();; i = 0)
            {
              ((com.tencent.mm.view.d)localObject1).au(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(202267);
              return;
            }
          }
        }
        AppMethodBeat.o(202267);
      }
      
      public final void av(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(202268);
        Object localObject1 = this.sau.rTQ;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.d)((b.b)localObject1).rTF;
          if (localObject1 != null)
          {
            localObject2 = this.sau.rTQ;
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
        for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).Lvi.size();; i = 0)
        {
          ((com.tencent.mm.view.d)localObject1).av(i + paramAnonymousInt1, paramAnonymousInt2);
          localObject1 = this.sau.rTQ;
          if (localObject1 == null) {
            break;
          }
          ((b.b)localObject1).cAT();
          AppMethodBeat.o(202268);
          return;
        }
        AppMethodBeat.o(202268);
      }
      
      public final void c(final RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(202263);
        p.h(paramAnonymousc, "reason");
        com.tencent.mm.ad.c.g((d.g.a.a)new b(this, paramAnonymousc));
        AppMethodBeat.o(202263);
      }
      
      public final void d(final RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(202264);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.sau.rTQ;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.d)((b.b)localObject).rTF;
          if (localObject != null) {
            ((com.tencent.mm.view.d)localObject).d(paramAnonymousc);
          }
        }
        com.tencent.mm.ad.c.g((d.g.a.a)new a(this, paramAnonymousc));
        AppMethodBeat.o(202264);
      }
      
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(202266);
        Object localObject1 = this.sau.rTQ;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.d)((b.b)localObject1).rTF;
          if (localObject1 != null)
          {
            Object localObject2 = this.sau.rTQ;
            if (localObject2 != null)
            {
              localObject2 = ((b.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).Lvi.size();; i = 0)
            {
              ((com.tencent.mm.view.d)localObject1).f(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
              AppMethodBeat.o(202266);
              return;
            }
          }
        }
        AppMethodBeat.o(202266);
      }
      
      public final void onChanged()
      {
        AppMethodBeat.i(202265);
        Object localObject = this.sau.rTQ;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.d)((b.b)localObject).rTF;
          if (localObject != null)
          {
            ((com.tencent.mm.view.d)localObject).onChanged();
            AppMethodBeat.o(202265);
            return;
          }
        }
        AppMethodBeat.o(202265);
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
      static final class a
        extends q
        implements d.g.a.a<d.z>
      {
        a(ap.a.1 param1, RefreshLoadMoreLayout.c paramc)
        {
          super();
        }
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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
    AppMethodBeat.o(202286);
  }
  
  public static boolean b(asg paramasg)
  {
    AppMethodBeat.i(202281);
    p.h(paramasg, "tag");
    long l = paramasg.Gqv;
    paramasg = FinderTagView.sVS;
    if (l == FinderTagView.cNC())
    {
      AppMethodBeat.o(202281);
      return true;
    }
    AppMethodBeat.o(202281);
    return false;
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(202279);
    p.h(paramb, "callback");
    super.a(paramb);
    paramb = this.rTQ;
    if (paramb != null)
    {
      Object localObject = paramb.getActivity().getIntent().getByteArrayExtra("key_topic_poi_location");
      if (localObject != null)
      {
        aoy localaoy = new aoy();
        localaoy.parseFrom((byte[])localObject);
        localObject = this.rTS;
        if (localObject == null)
        {
          paramb = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
          AppMethodBeat.o(202279);
          throw paramb;
        }
        ((FinderTopicFeedLoader)localObject).sck = localaoy;
      }
      long l = paramb.getActivity().getIntent().getLongExtra("key_ref_object_id", 0L);
      paramb = this.rTS;
      if (paramb == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(202279);
        throw paramb;
      }
      ((FinderTopicFeedLoader)paramb).scl = Long.valueOf(l);
    }
    paramb = this.rTS;
    if (paramb == null)
    {
      paramb = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
      AppMethodBeat.o(202279);
      throw paramb;
    }
    ((FinderTopicFeedLoader)paramb).scm = ((d.g.a.a)new c(this));
    AppMethodBeat.o(202279);
  }
  
  public final void a(asg paramasg)
  {
    AppMethodBeat.i(202278);
    p.h(paramasg, "<set-?>");
    this.rYW = paramasg;
    AppMethodBeat.o(202278);
  }
  
  public final void aTt()
  {
    AppMethodBeat.i(202284);
    if (b(this.rYW))
    {
      localObject = this.rTS;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(202284);
        throw ((Throwable)localObject);
      }
      FinderTopicFeedLoader.b((FinderTopicFeedLoader)localObject, this.sar);
      AppMethodBeat.o(202284);
      return;
    }
    Object localObject = new cta();
    ((cta)localObject).Hlo = new LinkedList();
    ((cta)localObject).Hlo.add(this.rYW);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rTS;
    if (localBaseFinderFeedLoader == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
      AppMethodBeat.o(202284);
      throw ((Throwable)localObject);
    }
    ((FinderTopicFeedLoader)localBaseFinderFeedLoader).a(this.sar, (cta)localObject);
    AppMethodBeat.o(202284);
  }
  
  public final void cAA()
  {
    AppMethodBeat.i(202283);
    b.b localb = this.rTQ;
    if (localb != null) {
      localb.U((ArrayList)this.rTS.getDataListJustForAdapter());
    }
    this.rVT = ((com.tencent.mm.sdk.b.c)new b(this));
    com.tencent.mm.sdk.b.a.IbL.b(this.rVT);
    AppMethodBeat.o(202283);
  }
  
  public final com.tencent.mm.view.recyclerview.c cAE()
  {
    AppMethodBeat.i(202282);
    Object localObject = this.rTQ;
    if (localObject == null) {
      p.gfZ();
    }
    localObject = ((b.b)localObject).cAR().B((d.g.a.b)new a(this));
    AppMethodBeat.o(202282);
    return localObject;
  }
  
  public final com.tencent.mm.view.d cAN()
  {
    return this.sat;
  }
  
  public final String getIconUrl()
  {
    AppMethodBeat.i(165953);
    Object localObject = this.rTS.getListOfType(BaseFinderFeed.class);
    if (!((List)localObject).isEmpty())
    {
      localObject = (bvf)j.E((List)((BaseFinderFeed)((List)localObject).get(0)).feedObject.getMediaList(), 0);
      if (localObject != null)
      {
        localObject = ((bvf)localObject).thumbUrl + ((bvf)localObject).thumb_url_token;
        AppMethodBeat.o(165953);
        return localObject;
      }
    }
    AppMethodBeat.o(165953);
    return "";
  }
  
  public final void h(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202285);
    p.h(paramc, "reason");
    paramc = paramc.scd;
    if (paramc == null)
    {
      paramc = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicResponse");
      AppMethodBeat.o(202285);
      throw paramc;
    }
    if (!((FinderTopicFeedLoader.e)paramc).getHasMore())
    {
      paramc = this.rTQ;
      if (paramc != null)
      {
        paramc = paramc.rTF;
        if (paramc != null) {
          if (this.rTS.getSize() <= 10) {
            break label203;
          }
        }
      }
      label203:
      for (boolean bool = true;; bool = false)
      {
        paramc.setEnableLoadMore(bool);
        paramc = this.rTQ;
        if (paramc != null)
        {
          paramc = paramc.rTF;
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
        paramc = this.rTQ;
        if (paramc == null) {
          break;
        }
        paramc = paramc.rTF;
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
        paramc.setTextColor(this.fLP.getResources().getColor(2131099735));
        AppMethodBeat.o(202285);
        return;
      }
      AppMethodBeat.o(202285);
      return;
    }
    paramc = this.rTQ;
    if (paramc != null)
    {
      paramc = paramc.rTF;
      if (paramc != null)
      {
        paramc.setEnableLoadMore(true);
        AppMethodBeat.o(202285);
        return;
      }
    }
    AppMethodBeat.o(202285);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165956);
    super.onDetach();
    this.sas.af();
    Object localObject1 = this.rTQ;
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
      AppMethodBeat.o(165956);
      throw ((Throwable)localObject1);
    }
    ap.b localb = (ap.b)localObject1;
    localObject1 = localb.fLP;
    Object localObject2 = FinderTagView.sVS;
    localObject2 = (FinderTagView)((MMActivity)localObject1).findViewById(FinderTagView.cNB());
    if (localObject2 == null)
    {
      localObject1 = localb.rTF.getRecyclerView();
      localObject2 = FinderTagView.sVS;
      localObject2 = (FinderTagView)((RecyclerView)localObject1).findViewById(FinderTagView.cNB());
    }
    for (;;)
    {
      Object localObject3;
      if (localObject2 != null)
      {
        localObject1 = FinderReporterUIC.tcM;
        localObject1 = FinderReporterUIC.a.eY((Context)localb.fLP);
        if (localObject1 == null) {
          break label522;
        }
        aqy localaqy = ((FinderReporterUIC)localObject1).cOu();
        if (localaqy == null) {
          break label522;
        }
        localObject1 = "";
        StringBuilder localStringBuilder;
        if (((FinderTagView)localObject2).sVK == 1)
        {
          j = ((FinderTagView)localObject2).getTagData().Hlo.size();
          i = 0;
          for (;;)
          {
            localObject3 = localObject1;
            if (i >= j) {
              break;
            }
            localObject3 = (asg)((FinderTagView)localObject2).getTagData().Hlo.get(i);
            localStringBuilder = new StringBuilder().append((String)localObject1).append(((asg)localObject3).dzZ).append(";1;");
            localObject3 = (Integer)((FinderTagView)localObject2).getTagClickMap().get(Long.valueOf(((asg)localObject3).Gqv));
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = Integer.valueOf(0);
            }
            localObject1 = localObject1 + '#';
            i += 1;
          }
        }
        int j = ((List)((FinderTagView)localObject2).getTagLayout().sVw.get(0)).size();
        int i = 0;
        for (;;)
        {
          localObject3 = localObject1;
          if (i >= j) {
            break;
          }
          localObject3 = (asg)((FinderTagView)localObject2).getTagData().Hlo.get(i);
          localStringBuilder = new StringBuilder().append((String)localObject1).append(((asg)localObject3).dzZ).append(";1;");
          localObject3 = (Integer)((FinderTagView)localObject2).getTagClickMap().get(Long.valueOf(((asg)localObject3).Gqv));
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = Integer.valueOf(0);
          }
          localObject1 = localObject1 + '#';
          i += 1;
        }
        localObject1 = h.soM;
        h.a(localaqy, localb.dzZ, (String)localObject3, ((FinderTagView)localObject2).getHasExpandBtn(), ((FinderTagView)localObject2).sVK);
      }
      label522:
      for (localObject1 = d.z.MKo;; localObject1 = null)
      {
        if (localObject1 == null)
        {
          localObject1 = (ap.b)localb;
          localObject2 = FinderReporterUIC.tcM;
          localObject2 = FinderReporterUIC.a.eY((Context)((b.b)localObject1).fLP);
          if (localObject2 != null)
          {
            localObject2 = ((FinderReporterUIC)localObject2).cOu();
            if (localObject2 != null)
            {
              localObject3 = h.soM;
              h.a((aqy)localObject2, ((ap.b)localObject1).dzZ, "", 0, 0);
              localObject1 = d.z.MKo;
            }
          }
        }
        com.tencent.mm.sdk.b.a.IbL.d(this.rVT);
        AppMethodBeat.o(165956);
        return;
      }
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(165957);
    if (b(this.rYW))
    {
      localObject = this.rTS;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(165957);
        throw ((Throwable)localObject);
      }
      FinderTopicFeedLoader.a((FinderTopicFeedLoader)localObject, this.sar);
      AppMethodBeat.o(165957);
      return;
    }
    Object localObject = new cta();
    ((cta)localObject).Hlo = new LinkedList();
    ((cta)localObject).Hlo.add(this.rYW);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rTS;
    if (localBaseFinderFeedLoader == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
      AppMethodBeat.o(165957);
      throw ((Throwable)localObject);
    }
    ((FinderTopicFeedLoader)localBaseFinderFeedLoader).a(this.sar, (cta)localObject, 4);
    AppMethodBeat.o(165957);
  }
  
  public final void z(d.g.a.a<d.z> parama)
  {
    AppMethodBeat.i(202280);
    Object localObject = this.rTQ;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).rTF.getRecyclerView();
      if (localObject != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter", "scrollToTop", "(Lkotlin/jvm/functions/Function0;)V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject).ca(((Integer)locala.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter", "scrollToTop", "(Lkotlin/jvm/functions/Function0;)V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
    localObject = this.rTQ;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).rTF.getRecyclerView();
      if (localObject != null)
      {
        ((RecyclerView)localObject).post((Runnable)new d(parama));
        AppMethodBeat.o(202280);
        return;
      }
    }
    AppMethodBeat.o(202280);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<Integer, com.tencent.mm.view.recyclerview.b<?>>
  {
    a(ap.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$initViewCallback$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<hr>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$initViewCallback$1$callback$1$1"})
    static final class a
      extends q
      implements d.g.a.a<d.z>
    {
      a(ap.a.b paramb, hr paramhr)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<d.z>
  {
    c(ap.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(d.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(202277);
      d.g.a.a locala = this.rZf;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(202277);
        return;
      }
      AppMethodBeat.o(202277);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ap.a
 * JD-Core Version:    0.7.0.1
 */