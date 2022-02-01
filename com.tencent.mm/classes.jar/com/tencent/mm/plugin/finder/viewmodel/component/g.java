package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.m;
import com.tencent.mm.plugin.finder.feed.model.internal.m.b;
import com.tencent.mm.plugin.finder.feed.model.internal.m.c;
import com.tencent.mm.plugin.finder.feed.model.internal.m.d;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "actionCallback", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "atFeedManageGroup", "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$atFeedManageGroup$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$atFeedManageGroup$1;", "atFeedState", "Lcom/tencent/mm/plugin/finder/viewmodel/atfeed/AtFeedState;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedLoader", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;)V", "isSelfFlag", "", "()Z", "isSelfFlag$delegate", "layoutConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderAtFeedManagerLayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderAtFeedManagerLayoutConfig;", "layoutConfig$delegate", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "removeFeedEventListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$removeFeedEventListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$removeFeedEventListener$1;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "stateLayout", "Landroid/widget/FrameLayout;", "getStateLayout", "()Landroid/widget/FrameLayout;", "stateLayout$delegate", "username", "", "initLoader", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "refresh", "isShouldSelect", "Companion", "ViewActionCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends UIComponent
{
  public static final a GNa;
  private final kotlin.j AIq;
  private final com.tencent.mm.plugin.finder.viewmodel.atfeed.a ALJ;
  private final bui Auc;
  private final kotlin.j BaO;
  public FinderAtFeedLoader BlJ;
  private final kotlin.j CNQ;
  private final kotlin.j EKZ;
  private final kotlin.j FcO;
  private final kotlin.j FcP;
  private final kotlin.j FcQ;
  private final d GNb;
  private final FinderAtFeedManageUIC.removeFeedEventListener.1 GNc;
  private String username;
  
  static
  {
    AppMethodBeat.i(337928);
    GNa = new a((byte)0);
    AppMethodBeat.o(337928);
  }
  
  public g(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337836);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    this.Auc = ((as)com.tencent.mm.ui.component.k.d(paramAppCompatActivity).q(as.class)).fou();
    String str = getIntent().getStringExtra("KEY_PARAMS_USERNAME");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.username = ((String)localObject);
    this.AIq = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.ALJ = new com.tencent.mm.plugin.finder.viewmodel.atfeed.a();
    this.FcO = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.EKZ = kotlin.k.cm((kotlin.g.a.a)new j(this, paramAppCompatActivity));
    this.FcQ = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.FcP = kotlin.k.cm((kotlin.g.a.a)new n(paramAppCompatActivity));
    this.BaO = kotlin.k.cm((kotlin.g.a.a)new m(paramAppCompatActivity));
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.GNb = new d(this);
    this.GNc = new FinderAtFeedManageUIC.removeFeedEventListener.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(337836);
  }
  
  private final com.tencent.mm.plugin.finder.storage.b fni()
  {
    AppMethodBeat.i(337844);
    com.tencent.mm.plugin.finder.storage.b localb = (com.tencent.mm.plugin.finder.storage.b)this.FcO.getValue();
    AppMethodBeat.o(337844);
    return localb;
  }
  
  private final b fnj()
  {
    AppMethodBeat.i(337851);
    b localb = (b)this.FcQ.getValue();
    AppMethodBeat.o(337851);
    return localb;
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(337867);
    RecyclerView localRecyclerView = (RecyclerView)this.CNQ.getValue();
    AppMethodBeat.o(337867);
    return localRecyclerView;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(337861);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.BaO.getValue();
    AppMethodBeat.o(337861);
    return localRefreshLoadMoreLayout;
  }
  
  public final FinderAtFeedLoader fnh()
  {
    AppMethodBeat.i(337937);
    FinderAtFeedLoader localFinderAtFeedLoader = this.BlJ;
    if (localFinderAtFeedLoader != null)
    {
      AppMethodBeat.o(337937);
      return localFinderAtFeedLoader;
    }
    s.bIx("feedLoader");
    AppMethodBeat.o(337937);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(337956);
    super.onCreate(paramBundle);
    paramBundle = new FinderAtFeedLoader(com.tencent.mm.plugin.finder.feed.model.internal.g.Bkt, this.username, this.Auc);
    s.u(paramBundle, "<set-?>");
    this.BlJ = paramBundle;
    fnh().register((com.tencent.mm.view.k)fnj());
    getRlLayout().setEnableRefresh(false);
    getRlLayout().setSuperNestedScroll(false);
    getRlLayout().setActionCallback((RefreshLoadMoreLayout.b)new g(this));
    paramBundle = getRlLayout();
    Object localObject1 = af.mU((Context)getActivity()).inflate(e.f.load_more_footer, null);
    s.s(localObject1, "getInflater(activity).in…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter((View)localObject1);
    getRecyclerView().setLayoutManager((RecyclerView.LayoutManager)this.EKZ.getValue());
    getRecyclerView().a(fni().getItemDecoration());
    getRecyclerView().setRecycledViewPool(fni().j((MMActivity)getActivity()));
    getRecyclerView().setAdapter((RecyclerView.a)new WxRecyclerAdapter(fni().ech(), (ArrayList)fnh().getDataListJustForAdapter()));
    fnh().setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new e(this));
    fnh().BbB = ((kotlin.g.a.a)new f(this));
    BaseFeedLoader.requestInit$default((BaseFeedLoader)fnh(), false, 1, null);
    fnh().requestRefresh();
    fnh().BfX = ((kotlin.g.a.b)new k(this));
    this.GNc.alive();
    paramBundle = m.Bkx;
    paramBundle = (m.d)this.GNb;
    s.u(paramBundle, "owner");
    localObject1 = paramBundle.eec();
    Object localObject2;
    if (m.edX().keySet().contains(localObject1))
    {
      localObject2 = (m.b)m.edX().get(localObject1);
      if (localObject2 != null) {
        ((m.b)localObject2).Bkz = paramBundle;
      }
    }
    while (m.edX().keySet().contains(localObject1))
    {
      paramBundle = (m.b)m.edX().get(localObject1);
      if ((paramBundle == null) || (paramBundle.Bkz == null)) {
        break;
      }
      paramBundle = paramBundle.BkA.iterator();
      while (paramBundle.hasNext()) {
        ((m.c)paramBundle.next()).eea();
      }
      localObject2 = (Map)m.edX();
      m.b localb = new m.b();
      localb.Bkz = paramBundle;
      ((Map)localObject2).put(localObject1, localb);
    }
    Log.i("Finder.LoaderShareStore", "");
    AppMethodBeat.o(337956);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(337967);
    super.onDestroy();
    fnh().unregister((com.tencent.mm.view.k)fnj());
    this.GNc.dead();
    Object localObject1 = m.Bkx;
    localObject1 = (m.d)this.GNb;
    s.u(localObject1, "owner");
    localObject1 = ((m.d)localObject1).eec();
    if (m.edX().keySet().contains(localObject1))
    {
      m.b localb = (m.b)m.edX().get(localObject1);
      if (localb != null)
      {
        Object localObject2 = m.Bkx;
        if (m.edX().keySet().contains(localObject1))
        {
          localObject2 = (m.b)m.edX().get(localObject1);
          if ((localObject2 != null) && (((m.b)localObject2).Bkz != null))
          {
            localObject2 = ((m.b)localObject2).BkA.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((m.c)((Iterator)localObject2).next()).eeb();
            }
          }
        }
        localObject2 = localb.BkA.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Iterator)localObject2).next();
        }
        if (localb.BkA.isEmpty()) {
          m.edX().remove(localObject1);
        }
        AppMethodBeat.o(337967);
      }
    }
    else
    {
      Log.i("Finder.LoaderShareStore", "unregisterOwner not exit");
    }
    AppMethodBeat.o(337967);
  }
  
  public final void refresh(boolean paramBoolean)
  {
    AppMethodBeat.i(337973);
    this.ALJ.GLR = paramBoolean;
    fnh().dispatcher().onChanged();
    AppMethodBeat.o(337973);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "updateState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.view.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(337547);
      AppMethodBeat.o(337547);
    }
    
    public final void evt()
    {
      AppMethodBeat.i(337552);
      d.a(0L, (kotlin.g.a.a)new a(g.this, this));
      AppMethodBeat.o(337552);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(g paramg, g.b paramb)
      {
        super();
      }
      
      private static final void a(g paramg, g.b paramb, View paramView)
      {
        AppMethodBeat.i(337584);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramg);
        localb.cH(paramb);
        localb.cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$ViewActionCallback$updateState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
        s.u(paramg, "this$0");
        s.u(paramb, "this$1");
        paramg = g.c(paramg);
        s.s(paramg, "rlLayout");
        RefreshLoadMoreLayout.a(paramg, 0, 3);
        paramb.evt();
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$ViewActionCallback$updateState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(337584);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<g.b>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$atFeedManageGroup$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupOwner;", "dataSource", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "groupKey", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends m.d
  {
    d(g paramg) {}
    
    public final String eec()
    {
      return "atFeedManage";
    }
    
    public final DataBuffer<cc> eed()
    {
      AppMethodBeat.i(337595);
      DataBuffer localDataBuffer = this.GNd.fnh().getDataListJustForAdapter();
      AppMethodBeat.o(337595);
      return localDataBuffer;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$initLoader$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    e(g paramg) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(337598);
      g.b(this.GNd).evt();
      AppMethodBeat.o(337598);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends RefreshLoadMoreLayout.b
  {
    g(g paramg) {}
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(337588);
      s.u(paramd, "reason");
      super.a(paramd);
      paramd = com.tencent.mm.ui.component.k.aeZF;
      paramd = (h)com.tencent.mm.ui.component.k.d(this.GNd.getActivity()).q(h.class);
      Object localObject = this.GNd.fnh().EwF;
      paramd = paramd.GNj;
      Iterator localIterator;
      if (paramd == null)
      {
        s.bIx("stateMachine");
        paramd = null;
        if ((paramd.GMb == b.d.GMk) || (paramd.GMb == b.d.GMl))
        {
          Log.i("Finder.AtFeedSelectStateMachine", "onLoadMore update");
          if (localObject != null) {
            localIterator = ((Iterable)localObject).iterator();
          }
        }
      }
      else
      {
        label181:
        for (;;)
        {
          label107:
          if (!localIterator.hasNext()) {
            break label183;
          }
          localObject = (cc)localIterator.next();
          if ((localObject instanceof BaseFinderFeed)) {}
          for (localObject = (BaseFinderFeed)localObject;; localObject = null)
          {
            if (localObject == null) {
              break label181;
            }
            ((Map)paramd.GMd).put(Long.valueOf(((BaseFinderFeed)localObject).bZA()), Integer.valueOf(((BaseFinderFeed)localObject).feedObject.getMentionListSelected()));
            break label107;
            break;
          }
        }
      }
      label183:
      AppMethodBeat.o(337588);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(337578);
      super.qI(paramInt);
      BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.GNd.fnh(), false, 1, null);
      AppMethodBeat.o(337578);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    h(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderAtFeedManagerLayoutConfig;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.storage.b>
  {
    i(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<RecyclerView.LayoutManager>
  {
    j(g paramg, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    k(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    l(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    m(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<FrameLayout>
  {
    n(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.g
 * JD-Core Version:    0.7.0.1
 */