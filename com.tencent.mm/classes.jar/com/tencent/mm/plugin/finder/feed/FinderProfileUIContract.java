package com.tencent.mm.plugin.finder.feed;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.plugin.finder.convert.ap;
import com.tencent.mm.plugin.finder.convert.aq;
import com.tencent.mm.plugin.finder.convert.ar;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.v;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.a.j;
import d.g;
import d.g.b.u;
import d.g.b.w;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract;", "", "()V", "HEADERCOUNT", "", "getHEADERCOUNT", "()I", "ProfilePresenter", "ProfileViewCallback", "plugin-finder_release"})
public final class FinderProfileUIContract
{
  private static final int riO = 1;
  public static final FinderProfileUIContract riP;
  
  static
  {
    AppMethodBeat.i(165838);
    riP = new FinderProfileUIContract();
    riO = 1;
    AppMethodBeat.o(165838);
  }
  
  public static int cuW()
  {
    return riO;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "header", "Landroid/view/View;", "selfFlag", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter;Landroid/view/View;Z)V", "TAG", "", "cachedState", "", "getCachedState", "()I", "setCachedState", "(I)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "context", "curCount", "enterState", "getEnterState", "setEnterState", "gridSpanCount", "getGridSpanCount", "setGridSpanCount", "getHeader", "()Landroid/view/View;", "loadingBar", "noContentTipTv", "Landroid/widget/TextView;", "onScrollListener", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "retryTipTv", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getSelfFlag", "()Z", "stateLayout", "Landroid/view/ViewGroup;", "tryLoadCount", "checkDataSize", "", "needAutoLoadMore", "getActivity", "getItemSpace", "getModel", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getRecyclerView", "initView", "onFetchEnd", "onUIAttach", "onUIDestroy", "onUIPause", "onUIResume", "setOnScrollListener", "listener", "toastRefreshFailed", "updateEnterState", "Companion", "FinderProfileAdapter", "plugin-finder_release"})
  public static final class ProfileViewCallback
    implements com.tencent.mm.plugin.finder.presenter.base.c<FinderProfileUIContract.a>
  {
    private static final int rje = 0;
    private static final int rjf = 1;
    static final int rjg = 2;
    private static final int rjh = 0;
    static final int rji = 1;
    private static final int rjj = 2;
    public static final FinderProfileUIContract.ProfileViewCallback.a rjk;
    public final String TAG;
    public RecyclerView fTr;
    public RecyclerView.m fuK;
    public final MMActivity iMV;
    public RefreshLoadMoreLayout rfT;
    public com.tencent.mm.view.d rgg;
    public r rgm;
    public final FinderProfileUIContract.a riT;
    int riU;
    int riV;
    private ViewGroup riW;
    private TextView riX;
    private TextView riY;
    private View riZ;
    final boolean riv;
    private int rja;
    private int rjb;
    private int rjc;
    final View rjd;
    
    static
    {
      AppMethodBeat.i(165837);
      rjk = new FinderProfileUIContract.ProfileViewCallback.a((byte)0);
      rjf = 1;
      rjg = 2;
      rji = 1;
      rjj = 2;
      AppMethodBeat.o(165837);
    }
    
    public ProfileViewCallback(MMActivity paramMMActivity, FinderProfileUIContract.a parama, View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(165836);
      this.rjd = paramView;
      this.riv = paramBoolean;
      this.TAG = "Finder.FinderProfileSelfContract.ProfileViewCallback";
      this.riT = parama;
      this.iMV = paramMMActivity;
      this.riU = rje;
      this.riV = rjh;
      this.rjc = 3;
      paramMMActivity = com.tencent.mm.plugin.finder.utils.d.rOJ;
      this.rgm = com.tencent.mm.plugin.finder.utils.d.cCM();
      paramMMActivity = this.iMV.findViewById(2131304203);
      d.g.b.k.g(paramMMActivity, "context.findViewById(R.id.rl_layout)");
      this.rfT = ((RefreshLoadMoreLayout)paramMMActivity);
      paramMMActivity = this.rfT.getRecyclerView();
      if (paramMMActivity == null) {
        d.g.b.k.fOy();
      }
      this.fTr = paramMMActivity;
      paramMMActivity = this.rjd.findViewById(2131303474);
      d.g.b.k.g(paramMMActivity, "header.findViewById(R.id…_loading_state_container)");
      this.riW = ((ViewGroup)paramMMActivity);
      paramMMActivity = this.rjd.findViewById(2131300060);
      d.g.b.k.g(paramMMActivity, "header.findViewById(R.id…_profile_tips_no_content)");
      this.riX = ((TextView)paramMMActivity);
      paramMMActivity = this.rjd.findViewById(2131300061);
      d.g.b.k.g(paramMMActivity, "header.findViewById(R.id…inder_profile_tips_retry)");
      this.riY = ((TextView)paramMMActivity);
      paramMMActivity = this.rjd.findViewById(2131300059);
      d.g.b.k.g(paramMMActivity, "header.findViewById(R.id…der_profile_tips_loading)");
      this.riZ = paramMMActivity;
      this.riW.setVisibility(8);
      this.rgg = ((com.tencent.mm.view.d)new com.tencent.mm.view.d()
      {
        public final void at(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(165811);
          RefreshLoadMoreLayout localRefreshLoadMoreLayout = FinderProfileUIContract.ProfileViewCallback.g(this.rjl);
          FinderProfileUIContract localFinderProfileUIContract = FinderProfileUIContract.riP;
          localRefreshLoadMoreLayout.at(FinderProfileUIContract.cuW() + paramAnonymousInt1, paramAnonymousInt2);
          FinderProfileUIContract.ProfileViewCallback.b(this.rjl);
          AppMethodBeat.o(165811);
        }
        
        public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(165812);
          RefreshLoadMoreLayout localRefreshLoadMoreLayout = FinderProfileUIContract.ProfileViewCallback.g(this.rjl);
          FinderProfileUIContract localFinderProfileUIContract = FinderProfileUIContract.riP;
          localRefreshLoadMoreLayout.au(FinderProfileUIContract.cuW() + paramAnonymousInt1, paramAnonymousInt2);
          FinderProfileUIContract.ProfileViewCallback.b(this.rjl);
          AppMethodBeat.o(165812);
        }
        
        public final void c(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(165808);
          d.g.b.k.h(paramAnonymousc, "reason");
          FinderProfileUIContract.ProfileViewCallback.g(this.rjl).c(paramAnonymousc);
          FinderProfileUIContract.ProfileViewCallback.b(this.rjl);
          AppMethodBeat.o(165808);
        }
        
        public final void d(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(165807);
          d.g.b.k.h(paramAnonymousc, "reason");
          FinderProfileUIContract.ProfileViewCallback.g(this.rjl).d(paramAnonymousc);
          FinderProfileUIContract.ProfileViewCallback.b(this.rjl);
          AppMethodBeat.o(165807);
        }
        
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(165810);
          RefreshLoadMoreLayout localRefreshLoadMoreLayout = FinderProfileUIContract.ProfileViewCallback.g(this.rjl);
          FinderProfileUIContract localFinderProfileUIContract = FinderProfileUIContract.riP;
          localRefreshLoadMoreLayout.f(FinderProfileUIContract.cuW() + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
          FinderProfileUIContract.ProfileViewCallback.b(this.rjl);
          AppMethodBeat.o(165810);
        }
        
        public final void onChanged()
        {
          AppMethodBeat.i(165809);
          FinderProfileUIContract.ProfileViewCallback.g(this.rjl).onChanged();
          this.rjl.lx(false);
          AppMethodBeat.o(165809);
        }
      });
      AppMethodBeat.o(165836);
    }
    
    private final BaseFinderFeedLoader getModel()
    {
      AppMethodBeat.i(201774);
      BaseFinderFeedLoader localBaseFinderFeedLoader = (BaseFinderFeedLoader)this.riT.cuV();
      AppMethodBeat.o(201774);
      return localBaseFinderFeedLoader;
    }
    
    public final void cuY()
    {
      AppMethodBeat.i(165835);
      com.tencent.mm.ac.c.g((d.g.a.a)new f(this));
      AppMethodBeat.o(165835);
    }
    
    public final MMActivity getActivity()
    {
      return this.iMV;
    }
    
    public final void lx(final boolean paramBoolean)
    {
      AppMethodBeat.i(165833);
      com.tencent.mm.ac.c.g((d.g.a.a)new c(this, paramBoolean));
      AppMethodBeat.o(165833);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$FinderProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback;)V", "VT_HEADER", "", "getVT_HEADER", "()I", "VT_MEDIA", "getVT_MEDIA", "VT_PLAIN_TEXT", "getVT_PLAIN_TEXT", "bindData", "", "holder", "position", "bindImage", "", "getItemCount", "getItemViewType", "isHeader", "jumpProfileTimeline", "pos", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "plugin-finder_release"})
    public final class b
      extends RecyclerView.a<RecyclerView.w>
    {
      private final int rjm = 1;
      private final int rjn = 2;
      private final int rjo = 3;
      
      private void c(final RecyclerView.w paramw, boolean paramBoolean)
      {
        AppMethodBeat.i(165820);
        d.g.b.k.h(paramw, "holder");
        if ((paramw instanceof ap))
        {
          ((ap)paramw).dW(this.rjl.rjd);
          AppMethodBeat.o(165820);
          return;
        }
        Object localObject1;
        int i;
        Object localObject2;
        FinderProfileUIContract localFinderProfileUIContract;
        if ((paramw instanceof aq))
        {
          localObject1 = FinderProfileUIContract.ProfileViewCallback.c(this.rjl);
          i = ((aq)paramw).lv();
          localObject2 = FinderProfileUIContract.riP;
          localObject1 = (BaseFinderFeed)((BaseFinderFeedLoader)localObject1).get(i - FinderProfileUIContract.cuW());
          localObject2 = (aq)paramw;
          if (localObject1 == null) {
            d.g.b.k.fOy();
          }
          localFinderProfileUIContract = FinderProfileUIContract.riP;
          FinderProfileUIContract.cuW();
          aq.a((aq)localObject2, (BaseFinderFeed)localObject1, paramBoolean, (d.g.a.a)new a(this, paramw, (BaseFinderFeed)localObject1));
          AppMethodBeat.o(165820);
          return;
        }
        if ((paramw instanceof com.tencent.mm.plugin.finder.convert.y))
        {
          localObject1 = FinderProfileUIContract.ProfileViewCallback.c(this.rjl);
          i = ((com.tencent.mm.plugin.finder.convert.y)paramw).lv();
          localObject2 = FinderProfileUIContract.riP;
          localObject1 = (BaseFinderFeed)((BaseFinderFeedLoader)localObject1).get(i - FinderProfileUIContract.cuW());
          localObject2 = (com.tencent.mm.plugin.finder.convert.y)paramw;
          if (localObject1 == null) {
            d.g.b.k.fOy();
          }
          localFinderProfileUIContract = FinderProfileUIContract.riP;
          FinderProfileUIContract.cuW();
          com.tencent.mm.plugin.finder.convert.y.a((com.tencent.mm.plugin.finder.convert.y)localObject2, (BaseFinderFeed)localObject1, (d.g.a.a)new b(this, paramw, (BaseFinderFeed)localObject1));
        }
        AppMethodBeat.o(165820);
      }
      
      public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
      {
        AppMethodBeat.i(165818);
        d.g.b.k.h(paramViewGroup, "parent");
        if (paramInt == this.rjm)
        {
          paramViewGroup = FinderProfileUIContract.ProfileViewCallback.d(this.rjl).getLayoutInflater().inflate(2131494096, null);
          d.g.b.k.g(paramViewGroup, "headerLayout");
          paramViewGroup = (RecyclerView.w)new ap(paramViewGroup);
          AppMethodBeat.o(165818);
          return paramViewGroup;
        }
        if (paramInt == this.rjo)
        {
          paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494097, paramViewGroup, false);
          d.g.b.k.g(paramViewGroup, "convertView");
          paramViewGroup = (RecyclerView.w)new ar(paramViewGroup);
          AppMethodBeat.o(165818);
          return paramViewGroup;
        }
        paramViewGroup = this.rjl.rgm.q(paramViewGroup);
        AppMethodBeat.o(165818);
        return paramViewGroup;
      }
      
      public final void a(RecyclerView.w paramw, int paramInt)
      {
        AppMethodBeat.i(165821);
        d.g.b.k.h(paramw, "holder");
        c(paramw, true);
        AppMethodBeat.o(165821);
      }
      
      public final void a(RecyclerView.w paramw, int paramInt, List<Object> paramList)
      {
        AppMethodBeat.i(165819);
        d.g.b.k.h(paramw, "holder");
        d.g.b.k.h(paramList, "payloads");
        if (d.g.b.k.g(j.iP(paramList), Boolean.FALSE))
        {
          AppMethodBeat.o(165819);
          return;
        }
        if (paramList.size() > 0)
        {
          c(paramw, false);
          AppMethodBeat.o(165819);
          return;
        }
        super.a(paramw, paramInt, paramList);
        AppMethodBeat.o(165819);
      }
      
      public final int getItemCount()
      {
        AppMethodBeat.i(165815);
        int i = FinderProfileUIContract.ProfileViewCallback.c(this.rjl).getSize();
        FinderProfileUIContract localFinderProfileUIContract = FinderProfileUIContract.riP;
        int j = FinderProfileUIContract.cuW();
        AppMethodBeat.o(165815);
        return i + j;
      }
      
      public final int getItemViewType(int paramInt)
      {
        AppMethodBeat.i(165816);
        if (paramInt == 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          paramInt = this.rjm;
          AppMethodBeat.o(165816);
          return paramInt;
        }
        Object localObject = FinderProfileUIContract.ProfileViewCallback.c(this.rjl);
        FinderProfileUIContract localFinderProfileUIContract = FinderProfileUIContract.riP;
        localObject = ((BaseFinderFeedLoader)localObject).get(paramInt - FinderProfileUIContract.cuW());
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        if (((BaseFinderFeed)localObject).feedObject.getMediaType() == 1)
        {
          paramInt = this.rjo;
          AppMethodBeat.o(165816);
          return paramInt;
        }
        paramInt = this.rjn;
        AppMethodBeat.o(165816);
        return paramInt;
      }
      
      public final void k(RecyclerView.w paramw)
      {
        AppMethodBeat.i(165817);
        d.g.b.k.h(paramw, "holder");
        super.k(paramw);
        Object localObject = paramw.asD;
        d.g.b.k.g(localObject, "holder.itemView");
        localObject = ((View)localObject).getLayoutParams();
        if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
        {
          localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
          if (paramw.ly() != this.rjm) {
            break label75;
          }
        }
        label75:
        for (boolean bool = true;; bool = false)
        {
          ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(bool);
          AppMethodBeat.o(165817);
          return;
        }
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
      static final class a
        extends d.g.b.l
        implements d.g.a.a<d.y>
      {
        a(FinderProfileUIContract.ProfileViewCallback.b paramb, RecyclerView.w paramw, BaseFinderFeed paramBaseFinderFeed)
        {
          super();
        }
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
      static final class b
        extends d.g.b.l
        implements d.g.a.a<d.y>
      {
        b(FinderProfileUIContract.ProfileViewCallback.b paramb, RecyclerView.w paramw, BaseFinderFeed paramBaseFinderFeed)
        {
          super();
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<d.y>
    {
      c(FinderProfileUIContract.ProfileViewCallback paramProfileViewCallback, boolean paramBoolean)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "plugin-finder_release"})
    public static final class d
      extends RefreshLoadMoreLayout.a
    {
      public final void Ad(int paramInt)
      {
        AppMethodBeat.i(201771);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.lS(paramInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aeE());
        super.Ad(paramInt);
        ac.i(FinderProfileUIContract.ProfileViewCallback.f(this.rjl), "onRequestRefresh");
        h.JZN.aS((Runnable)new b(this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
        AppMethodBeat.o(201771);
      }
      
      public final void a(RefreshLoadMoreLayout.c<Object> paramc)
      {
        AppMethodBeat.i(165829);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramc);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
        d.g.b.k.h(paramc, "reason");
        super.a(paramc);
        ac.i(FinderProfileUIContract.ProfileViewCallback.f(this.rjl), "[onLoadMoreEnd] reason=".concat(String.valueOf(paramc)));
        if (!paramc.Jyb) {
          FinderProfileUIContract.ProfileViewCallback.e(this.rjl).hasMore = false;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(165829);
      }
      
      public final void b(RefreshLoadMoreLayout.c paramc)
      {
        AppMethodBeat.i(201772);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramc);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
        super.b(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(201772);
      }
      
      public final void bTG()
      {
        AppMethodBeat.i(165828);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
        super.bTG();
        ac.i(FinderProfileUIContract.ProfileViewCallback.f(this.rjl), "onRequestLoadMore");
        h.JZN.aS((Runnable)new a(this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(165828);
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(FinderProfileUIContract.ProfileViewCallback.d paramd) {}
        
        public final void run()
        {
          AppMethodBeat.i(165825);
          BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)FinderProfileUIContract.ProfileViewCallback.c(this.rjs.rjl).getLast();
          if ((!FinderProfileUIContract.ProfileViewCallback.c(this.rjs.rjl).isEmpty()) && (localBaseFinderFeed != null)) {
            FinderProfileUIContract.ProfileViewCallback.e(this.rjs.rjl).cuX();
          }
          AppMethodBeat.o(165825);
        }
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
      static final class b
        implements Runnable
      {
        b(FinderProfileUIContract.ProfileViewCallback.d paramd) {}
        
        public final void run()
        {
          AppMethodBeat.i(165826);
          FinderProfileUIContract.a locala = FinderProfileUIContract.ProfileViewCallback.e(this.rjs.rjl);
          ac.i(locala.TAG, "requestRefresh feedLoader hashCode:" + locala.cuV().hashCode());
          locala.cuV().requestRefresh();
          AppMethodBeat.o(165826);
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    public static final class e
      extends d.g.b.l
      implements d.g.a.a<d.y>
    {
      public e(FinderProfileUIContract.ProfileViewCallback paramProfileViewCallback)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class f
      extends d.g.b.l
      implements d.g.a.a<d.y>
    {
      f(FinderProfileUIContract.ProfileViewCallback paramProfileViewCallback)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "username", "", "(Lcom/tencent/mm/ui/MMActivity;Ljava/lang/String;)V", "TAG", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "feedLoader$delegate", "Lkotlin/Lazy;", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter$feedProgressListener$1;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getUsername", "()Ljava/lang/String;", "viewCallback", "dataStore", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "doSceneNextPage", "", "loadMoreData", "onAttach", "callback", "onDetach", "onUIPause", "onUIResume", "requestRefresh", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.finder.presenter.base.a<FinderProfileUIContract.ProfileViewCallback>
  {
    final String TAG;
    final MMActivity activity;
    boolean hasMore;
    private final b riQ;
    private final d.f ris;
    final String username;
    private FinderProfileUIContract.ProfileViewCallback viewCallback;
    
    static
    {
      AppMethodBeat.i(201768);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(a.class), "feedLoader", "getFeedLoader()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;")) };
      AppMethodBeat.o(201768);
    }
    
    public a(MMActivity paramMMActivity, String paramString)
    {
      AppMethodBeat.i(201770);
      this.activity = paramMMActivity;
      this.username = paramString;
      this.TAG = "Finder.FinderProfileSelfContract.ProfilePresenter";
      this.ris = g.K((d.g.a.a)new a(this));
      this.hasMore = true;
      this.riQ = new b(this);
      AppMethodBeat.o(201770);
    }
    
    public final void a(FinderProfileUIContract.ProfileViewCallback paramProfileViewCallback)
    {
      AppMethodBeat.i(165802);
      d.g.b.k.h(paramProfileViewCallback, "callback");
      this.viewCallback = paramProfileViewCallback;
      com.tencent.mm.sdk.b.a.GpY.b((com.tencent.mm.sdk.b.c)this.riQ);
      cuV().setFetchEndCallback((d.g.a.a)new d(this));
      cuV().setOnFetchCallback((d.g.a.b)new e(this));
      AppMethodBeat.o(165802);
    }
    
    public final FinderProfileFeedLoader cuV()
    {
      AppMethodBeat.i(201769);
      FinderProfileFeedLoader localFinderProfileFeedLoader = (FinderProfileFeedLoader)this.ris.getValue();
      AppMethodBeat.o(201769);
      return localFinderProfileFeedLoader;
    }
    
    public final void cuX()
    {
      AppMethodBeat.i(165805);
      if (this.hasMore)
      {
        cuV().requestLoadMore();
        AppMethodBeat.o(165805);
        return;
      }
      ac.i(this.TAG, "doSceneNextPage: no more, return");
      AppMethodBeat.o(165805);
    }
    
    public final void onDetach()
    {
      AppMethodBeat.i(165804);
      com.tencent.mm.sdk.b.a.GpY.d((com.tencent.mm.sdk.b.c)this.riQ);
      this.viewCallback = null;
      AppMethodBeat.o(165804);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<FinderProfileFeedLoader>
    {
      a(FinderProfileUIContract.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class b
      extends com.tencent.mm.sdk.b.c<gz>
    {}
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter$loadMoreData$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class c
      implements com.tencent.mm.plugin.finder.feed.model.internal.f
    {
      public final void call(int paramInt)
      {
        AppMethodBeat.i(165799);
        com.tencent.mm.ac.c.g((d.g.a.a)new a(this));
        AppMethodBeat.o(165799);
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
      static final class a
        extends d.g.b.l
        implements d.g.a.a<d.y>
      {
        a(FinderProfileUIContract.a.c paramc)
        {
          super();
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<d.y>
    {
      d(FinderProfileUIContract.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/ProfileResponse;", "invoke"})
    static final class e
      extends d.g.b.l
      implements d.g.a.b<v, d.y>
    {
      e(FinderProfileUIContract.a parama)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderProfileUIContract
 * JD-Core Version:    0.7.0.1
 */