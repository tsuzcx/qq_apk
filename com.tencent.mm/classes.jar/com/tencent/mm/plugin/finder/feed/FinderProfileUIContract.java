package com.tencent.mm.plugin.finder.feed;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.presenter.base.b;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.d;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract;", "", "()V", "HEADERCOUNT", "", "getHEADERCOUNT", "()I", "ProfilePresenter", "ProfileViewCallback", "plugin-finder_release"})
public final class FinderProfileUIContract
{
  private static final int qvX = 1;
  public static final FinderProfileUIContract qvY;
  
  static
  {
    AppMethodBeat.i(165838);
    qvY = new FinderProfileUIContract();
    qvX = 1;
    AppMethodBeat.o(165838);
  }
  
  public static int cmc()
  {
    return qvX;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "header", "Landroid/view/View;", "selfFlag", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter;Landroid/view/View;Z)V", "TAG", "", "cachedState", "", "getCachedState", "()I", "setCachedState", "(I)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "context", "curCount", "enterState", "getEnterState", "setEnterState", "gridSpanCount", "getGridSpanCount", "setGridSpanCount", "getHeader", "()Landroid/view/View;", "loadingBar", "noContentTipTv", "Landroid/widget/TextView;", "onScrollListener", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "retryTipTv", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getSelfFlag", "()Z", "stateLayout", "Landroid/view/ViewGroup;", "tryLoadCount", "checkDataSize", "", "needAutoLoadMore", "getActivity", "getItemSpace", "getModel", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getRecyclerView", "initView", "onFetchEnd", "onUIAttach", "onUIDestroy", "onUIPause", "onUIResume", "setOnScrollListener", "listener", "toastRefreshFailed", "updateEnterState", "Companion", "FinderProfileAdapter", "plugin-finder_release"})
  public static final class ProfileViewCallback
    implements b<g.a>
  {
    private static final int qwq = 0;
    private static final int qwr = 1;
    static final int qws = 2;
    private static final int qwt = 0;
    static final int qwu = 1;
    private static final int qwv = 2;
    public static final g.b.a qww;
    public v KMT;
    private int KNS;
    public final String TAG;
    public RecyclerView fPw;
    public RecyclerView.m frd;
    public final MMActivity imP;
    public RefreshLoadMoreLayout quj;
    final boolean qvC;
    public d qvO;
    public final g.a qwe;
    int qwf;
    int qwg;
    private ViewGroup qwh;
    private TextView qwi;
    private TextView qwj;
    private View qwk;
    private int qwl;
    private int qwm;
    final View qwn;
    
    static
    {
      AppMethodBeat.i(165837);
      qww = new g.b.a((byte)0);
      qwr = 1;
      qws = 2;
      qwu = 1;
      qwv = 2;
      AppMethodBeat.o(165837);
    }
    
    public ProfileViewCallback(MMActivity paramMMActivity, g.a parama, View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(165836);
      this.qwn = paramView;
      this.qvC = paramBoolean;
      this.TAG = "Finder.FinderProfileSelfContract.ProfileViewCallback";
      this.qwe = parama;
      this.imP = paramMMActivity;
      this.qwf = qwq;
      this.qwg = qwt;
      this.KNS = 3;
      paramMMActivity = o.LaG;
      this.KMT = o.fVP();
      paramMMActivity = this.imP.findViewById(2131304203);
      k.g(paramMMActivity, "context.findViewById(R.id.rl_layout)");
      this.quj = ((RefreshLoadMoreLayout)paramMMActivity);
      paramMMActivity = this.quj.getRecyclerView();
      if (paramMMActivity == null) {
        k.fvU();
      }
      this.fPw = paramMMActivity;
      paramMMActivity = this.qwn.findViewById(2131303474);
      k.g(paramMMActivity, "header.findViewById(R.id…_loading_state_container)");
      this.qwh = ((ViewGroup)paramMMActivity);
      paramMMActivity = this.qwn.findViewById(2131300060);
      k.g(paramMMActivity, "header.findViewById(R.id…_profile_tips_no_content)");
      this.qwi = ((TextView)paramMMActivity);
      paramMMActivity = this.qwn.findViewById(2131300061);
      k.g(paramMMActivity, "header.findViewById(R.id…inder_profile_tips_retry)");
      this.qwj = ((TextView)paramMMActivity);
      paramMMActivity = this.qwn.findViewById(2131300059);
      k.g(paramMMActivity, "header.findViewById(R.id…der_profile_tips_loading)");
      this.qwk = paramMMActivity;
      this.qwh.setVisibility(8);
      this.qvO = ((d)new g.b.1(this));
      AppMethodBeat.o(165836);
    }
    
    private final BaseFinderFeedLoader getModel()
    {
      AppMethodBeat.i(197877);
      BaseFinderFeedLoader localBaseFinderFeedLoader = (BaseFinderFeedLoader)this.qwe.fTm();
      AppMethodBeat.o(197877);
      return localBaseFinderFeedLoader;
    }
    
    public final void cme()
    {
      AppMethodBeat.i(165835);
      c.g((a)new g.b.g(this));
      AppMethodBeat.o(165835);
    }
    
    public final MMActivity getActivity()
    {
      return this.imP;
    }
    
    public final void kU(boolean paramBoolean)
    {
      AppMethodBeat.i(165833);
      c.g((a)new g.b.d(this, paramBoolean));
      AppMethodBeat.o(165833);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    public static final class a
      extends d.g.b.l
      implements a<y>
    {
      public a(FinderProfileUIContract.ProfileViewCallback paramProfileViewCallback)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderProfileUIContract
 * JD-Core Version:    0.7.0.1
 */