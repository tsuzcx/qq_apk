package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "getLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;)V", "generateAdapter", "getData", "Ljava/util/ArrayList;", "loadMore", "", "onAttach", "callback", "onDetach", "refresh", "Companion", "plugin-finder_release"})
public abstract class BaseFinderLotteryContract$Presenter
  implements com.tencent.mm.plugin.finder.presenter.base.a<BaseFinderLotteryContract.ViewCallback>
{
  public static final Companion uWh = new Companion((byte)0);
  public WxRecyclerAdapter<bo> tFp;
  private j tMe;
  BaseFinderLotteryContract.ViewCallback uWf;
  public final BaseFeedLoader<bo> uWg;
  
  public BaseFinderLotteryContract$Presenter(BaseFeedLoader<bo> paramBaseFeedLoader)
  {
    this.uWg = paramBaseFeedLoader;
    this.tMe = ((j)new j()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(249665);
        Object localObject = this.uWi.uWf;
        if (localObject != null)
        {
          localObject = ((BaseFinderLotteryContract.ViewCallback)localObject).dcQ();
          if (localObject != null)
          {
            ((RefreshLoadMoreLayout)localObject).onChanged();
            AppMethodBeat.o(249665);
            return;
          }
        }
        AppMethodBeat.o(249665);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(249666);
        Object localObject = this.uWi.uWf;
        if (localObject != null)
        {
          localObject = ((BaseFinderLotteryContract.ViewCallback)localObject).dcQ();
          if (localObject != null)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(this.uWi.getAdapter().RqM.size() + paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(249666);
            return;
          }
        }
        AppMethodBeat.o(249666);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(249667);
        Object localObject = this.uWi.uWf;
        if (localObject != null)
        {
          localObject = ((BaseFinderLotteryContract.ViewCallback)localObject).dcQ();
          if (localObject != null)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(this.uWi.getAdapter().RqM.size() + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
            AppMethodBeat.o(249667);
            return;
          }
        }
        AppMethodBeat.o(249667);
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(249668);
        Object localObject = this.uWi.uWf;
        if (localObject != null)
        {
          localObject = ((BaseFinderLotteryContract.ViewCallback)localObject).dcQ();
          if (localObject != null)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeInserted(this.uWi.getAdapter().RqM.size() + paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(249668);
            return;
          }
        }
        AppMethodBeat.o(249668);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(249669);
        Object localObject = this.uWi.uWf;
        if (localObject != null)
        {
          localObject = ((BaseFinderLotteryContract.ViewCallback)localObject).dcQ();
          if (localObject != null)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeRemoved(this.uWi.getAdapter().RqM.size() + paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(249669);
            return;
          }
        }
        AppMethodBeat.o(249669);
      }
      
      public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(249663);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.uWi.uWf;
        if (localObject != null)
        {
          localObject = ((BaseFinderLotteryContract.ViewCallback)localObject).dcQ();
          if (localObject != null)
          {
            ((RefreshLoadMoreLayout)localObject).onPreFinishLoadMore(paramAnonymousc);
            AppMethodBeat.o(249663);
            return;
          }
        }
        AppMethodBeat.o(249663);
      }
      
      public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(249664);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.uWi.uWf;
        if (localObject != null)
        {
          localObject = ((BaseFinderLotteryContract.ViewCallback)localObject).dcQ();
          if (localObject != null)
          {
            ((RefreshLoadMoreLayout)localObject).onPreFinishLoadMoreSmooth(paramAnonymousc);
            AppMethodBeat.o(249664);
            return;
          }
        }
        AppMethodBeat.o(249664);
      }
      
      public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(249662);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.uWi.uWf;
        if (localObject != null)
        {
          localObject = ((BaseFinderLotteryContract.ViewCallback)localObject).dcQ();
          if (localObject != null)
          {
            ((RefreshLoadMoreLayout)localObject).onPreFinishRefresh(paramAnonymousc);
            AppMethodBeat.o(249662);
            return;
          }
        }
        AppMethodBeat.o(249662);
      }
    });
  }
  
  public void a(BaseFinderLotteryContract.ViewCallback paramViewCallback)
  {
    p.h(paramViewCallback, "callback");
    this.tFp = dlN();
    this.uWf = paramViewCallback;
    paramViewCallback = this.uWf;
    if (paramViewCallback != null)
    {
      Object localObject = paramViewCallback.activity.findViewById(2131307118);
      p.g(localObject, "activity.findViewById(R.id.rl_layout)");
      paramViewCallback.tLS = ((RefreshLoadMoreLayout)localObject);
      localObject = paramViewCallback.tLS;
      if (localObject == null) {
        p.btv("rlLayout");
      }
      ((RefreshLoadMoreLayout)localObject).setEnableRefresh(false);
      localObject = paramViewCallback.tLS;
      if (localObject == null) {
        p.btv("rlLayout");
      }
      localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)paramViewCallback.uWj.getAdapter());
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = paramViewCallback.tLS;
      if (localRefreshLoadMoreLayout == null) {
        p.btv("rlLayout");
      }
      localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new BaseFinderLotteryContract.ViewCallback.initView.1(paramViewCallback, (RecyclerView)localObject));
      paramViewCallback.nK(true);
      d.a(300L, (kotlin.g.a.a)new BaseFinderLotteryContract.ViewCallback.initView.2(paramViewCallback));
    }
    this.uWg.register(this.tMe);
  }
  
  public final ArrayList<bo> cDk()
  {
    return (ArrayList)this.uWg.getDataListJustForAdapter();
  }
  
  public abstract WxRecyclerAdapter<bo> dlN();
  
  public final WxRecyclerAdapter<bo> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.tFp;
    if (localWxRecyclerAdapter == null) {
      p.btv("adapter");
    }
    return localWxRecyclerAdapter;
  }
  
  public void onDetach()
  {
    this.uWg.unregister(this.tMe);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.Presenter
 * JD-Core Version:    0.7.0.1
 */