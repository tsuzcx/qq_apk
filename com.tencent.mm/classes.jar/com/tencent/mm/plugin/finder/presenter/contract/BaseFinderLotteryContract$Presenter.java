package com.tencent.mm.plugin.finder.presenter.contract;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.k;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "getLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;)V", "generateAdapter", "getData", "Ljava/util/ArrayList;", "loadMore", "", "onAttach", "callback", "onDetach", "refresh", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseFinderLotteryContract$Presenter
  implements com.tencent.mm.plugin.finder.presenter.base.a<BaseFinderLotteryContract.ViewCallback>
{
  public static final Companion EXp = new Companion((byte)0);
  public WxRecyclerAdapter<cc> ALE;
  private k ATF;
  public final BaseFeedLoader<cc> CNJ;
  BaseFinderLotteryContract.ViewCallback EXq;
  
  public BaseFinderLotteryContract$Presenter(BaseFeedLoader<cc> paramBaseFeedLoader)
  {
    this.CNJ = paramBaseFeedLoader;
    this.ATF = ((k)new k()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(343728);
        BaseFinderLotteryContract.ViewCallback localViewCallback = this.EXr.EXq;
        if (localViewCallback != null) {
          localViewCallback.getRlLayout().onChanged();
        }
        AppMethodBeat.o(343728);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(343744);
        BaseFinderLotteryContract.ViewCallback localViewCallback = this.EXr.EXq;
        if (localViewCallback != null) {
          localViewCallback.getRlLayout().onItemRangeChanged(this.EXr.getAdapter().agOb.size() + paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(343744);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(343754);
        BaseFinderLotteryContract.ViewCallback localViewCallback = this.EXr.EXq;
        if (localViewCallback != null) {
          localViewCallback.getRlLayout().onItemRangeChanged(this.EXr.getAdapter().agOb.size() + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        }
        AppMethodBeat.o(343754);
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(343763);
        BaseFinderLotteryContract.ViewCallback localViewCallback = this.EXr.EXq;
        if (localViewCallback != null) {
          localViewCallback.getRlLayout().onItemRangeInserted(this.EXr.getAdapter().agOb.size() + paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(343763);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(343771);
        BaseFinderLotteryContract.ViewCallback localViewCallback = this.EXr.EXq;
        if (localViewCallback != null) {
          localViewCallback.getRlLayout().onItemRangeRemoved(this.EXr.getAdapter().agOb.size() + paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(343771);
      }
      
      public final void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(343710);
        s.u(paramAnonymousd, "reason");
        BaseFinderLotteryContract.ViewCallback localViewCallback = this.EXr.EXq;
        if (localViewCallback != null) {
          localViewCallback.getRlLayout().onPreFinishLoadMore(paramAnonymousd);
        }
        AppMethodBeat.o(343710);
      }
      
      public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(343718);
        s.u(paramAnonymousd, "reason");
        BaseFinderLotteryContract.ViewCallback localViewCallback = this.EXr.EXq;
        if (localViewCallback != null) {
          localViewCallback.getRlLayout().onPreFinishLoadMoreSmooth(paramAnonymousd);
        }
        AppMethodBeat.o(343718);
      }
      
      public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(343702);
        s.u(paramAnonymousd, "reason");
        BaseFinderLotteryContract.ViewCallback localViewCallback = this.EXr.EXq;
        if (localViewCallback != null) {
          localViewCallback.getRlLayout().onPreFinishRefresh(paramAnonymousd);
        }
        AppMethodBeat.o(343702);
      }
    });
  }
  
  public void a(BaseFinderLotteryContract.ViewCallback paramViewCallback)
  {
    s.u(paramViewCallback, "callback");
    Object localObject = eHW();
    s.u(localObject, "<set-?>");
    this.ALE = ((WxRecyclerAdapter)localObject);
    this.EXq = paramViewCallback;
    paramViewCallback = this.EXq;
    if (paramViewCallback != null)
    {
      localObject = paramViewCallback.activity.findViewById(p.e.rl_layout);
      s.s(localObject, "activity.findViewById(R.id.rl_layout)");
      localObject = (RefreshLoadMoreLayout)localObject;
      s.u(localObject, "<set-?>");
      paramViewCallback.ATx = ((RefreshLoadMoreLayout)localObject);
      paramViewCallback.getRlLayout().setEnableRefresh(false);
      localObject = paramViewCallback.getRlLayout().getRecyclerView();
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)paramViewCallback.EXs.getAdapter());
      paramViewCallback.getRlLayout().setActionCallback((RefreshLoadMoreLayout.b)new BaseFinderLotteryContract.ViewCallback.initView.1(paramViewCallback, (RecyclerView)localObject));
      paramViewCallback.pZ(true);
      d.a(300L, (kotlin.g.a.a)new BaseFinderLotteryContract.ViewCallback.initView.2(paramViewCallback));
    }
    this.CNJ.register(this.ATF);
  }
  
  public final ArrayList<cc> dwi()
  {
    return (ArrayList)this.CNJ.getDataListJustForAdapter();
  }
  
  public abstract WxRecyclerAdapter<cc> eHW();
  
  public final WxRecyclerAdapter<cc> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.ALE;
    if (localWxRecyclerAdapter != null) {
      return localWxRecyclerAdapter;
    }
    s.bIx("adapter");
    return null;
  }
  
  public void onDetach()
  {
    this.CNJ.unregister(this.ATF);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.Presenter
 * JD-Core Version:    0.7.0.1
 */