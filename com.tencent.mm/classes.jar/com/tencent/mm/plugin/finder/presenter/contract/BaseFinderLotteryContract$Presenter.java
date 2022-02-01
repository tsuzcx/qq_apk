package com.tencent.mm.plugin.finder.presenter.contract;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "getLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;)V", "generateAdapter", "getData", "Ljava/util/ArrayList;", "loadMore", "", "onAttach", "callback", "onDetach", "refresh", "Companion", "plugin-finder_release"})
public abstract class BaseFinderLotteryContract$Presenter
  implements com.tencent.mm.plugin.finder.presenter.base.a<BaseFinderLotteryContract.ViewCallback>
{
  public static final Companion zMx = new Companion((byte)0);
  public WxRecyclerAdapter<bu> xnR;
  private j xvV;
  BaseFinderLotteryContract.ViewCallback zMv;
  public final BaseFeedLoader<bu> zMw;
  
  public BaseFinderLotteryContract$Presenter(BaseFeedLoader<bu> paramBaseFeedLoader)
  {
    this.zMw = paramBaseFeedLoader;
    this.xvV = ((j)new j()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(268409);
        Object localObject = this.zMy.zMv;
        if (localObject != null)
        {
          localObject = ((BaseFinderLotteryContract.ViewCallback)localObject).dtq();
          if (localObject != null)
          {
            ((RefreshLoadMoreLayout)localObject).onChanged();
            AppMethodBeat.o(268409);
            return;
          }
        }
        AppMethodBeat.o(268409);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(268410);
        Object localObject = this.zMy.zMv;
        if (localObject != null)
        {
          localObject = ((BaseFinderLotteryContract.ViewCallback)localObject).dtq();
          if (localObject != null)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(this.zMy.getAdapter().YSk.size() + paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(268410);
            return;
          }
        }
        AppMethodBeat.o(268410);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(268411);
        Object localObject = this.zMy.zMv;
        if (localObject != null)
        {
          localObject = ((BaseFinderLotteryContract.ViewCallback)localObject).dtq();
          if (localObject != null)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(this.zMy.getAdapter().YSk.size() + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
            AppMethodBeat.o(268411);
            return;
          }
        }
        AppMethodBeat.o(268411);
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(268412);
        Object localObject = this.zMy.zMv;
        if (localObject != null)
        {
          localObject = ((BaseFinderLotteryContract.ViewCallback)localObject).dtq();
          if (localObject != null)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeInserted(this.zMy.getAdapter().YSk.size() + paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(268412);
            return;
          }
        }
        AppMethodBeat.o(268412);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(268413);
        Object localObject = this.zMy.zMv;
        if (localObject != null)
        {
          localObject = ((BaseFinderLotteryContract.ViewCallback)localObject).dtq();
          if (localObject != null)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeRemoved(this.zMy.getAdapter().YSk.size() + paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(268413);
            return;
          }
        }
        AppMethodBeat.o(268413);
      }
      
      public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(268407);
        p.k(paramAnonymousc, "reason");
        Object localObject = this.zMy.zMv;
        if (localObject != null)
        {
          localObject = ((BaseFinderLotteryContract.ViewCallback)localObject).dtq();
          if (localObject != null)
          {
            ((RefreshLoadMoreLayout)localObject).onPreFinishLoadMore(paramAnonymousc);
            AppMethodBeat.o(268407);
            return;
          }
        }
        AppMethodBeat.o(268407);
      }
      
      public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(268408);
        p.k(paramAnonymousc, "reason");
        Object localObject = this.zMy.zMv;
        if (localObject != null)
        {
          localObject = ((BaseFinderLotteryContract.ViewCallback)localObject).dtq();
          if (localObject != null)
          {
            ((RefreshLoadMoreLayout)localObject).onPreFinishLoadMoreSmooth(paramAnonymousc);
            AppMethodBeat.o(268408);
            return;
          }
        }
        AppMethodBeat.o(268408);
      }
      
      public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(268406);
        p.k(paramAnonymousc, "reason");
        Object localObject = this.zMy.zMv;
        if (localObject != null)
        {
          localObject = ((BaseFinderLotteryContract.ViewCallback)localObject).dtq();
          if (localObject != null)
          {
            ((RefreshLoadMoreLayout)localObject).onPreFinishRefresh(paramAnonymousc);
            AppMethodBeat.o(268406);
            return;
          }
        }
        AppMethodBeat.o(268406);
      }
    });
  }
  
  public void a(BaseFinderLotteryContract.ViewCallback paramViewCallback)
  {
    p.k(paramViewCallback, "callback");
    this.xnR = dMR();
    this.zMv = paramViewCallback;
    paramViewCallback = this.zMv;
    if (paramViewCallback != null)
    {
      Object localObject = paramViewCallback.activity.findViewById(b.f.rl_layout);
      p.j(localObject, "activity.findViewById(R.id.rl_layout)");
      paramViewCallback.xvJ = ((RefreshLoadMoreLayout)localObject);
      localObject = paramViewCallback.xvJ;
      if (localObject == null) {
        p.bGy("rlLayout");
      }
      ((RefreshLoadMoreLayout)localObject).setEnableRefresh(false);
      localObject = paramViewCallback.xvJ;
      if (localObject == null) {
        p.bGy("rlLayout");
      }
      localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)paramViewCallback.zMz.getAdapter());
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = paramViewCallback.xvJ;
      if (localRefreshLoadMoreLayout == null) {
        p.bGy("rlLayout");
      }
      localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new BaseFinderLotteryContract.ViewCallback.initView.1(paramViewCallback, (RecyclerView)localObject));
      paramViewCallback.pW(true);
      d.a(300L, (kotlin.g.a.a)new BaseFinderLotteryContract.ViewCallback.initView.2(paramViewCallback));
    }
    this.zMw.register(this.xvV);
  }
  
  public final ArrayList<bu> cRP()
  {
    return (ArrayList)this.zMw.getDataListJustForAdapter();
  }
  
  public abstract WxRecyclerAdapter<bu> dMR();
  
  public final WxRecyclerAdapter<bu> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.xnR;
    if (localWxRecyclerAdapter == null) {
      p.bGy("adapter");
    }
    return localWxRecyclerAdapter;
  }
  
  public void onDetach()
  {
    this.zMw.unregister(this.xvV);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.Presenter
 * JD-Core Version:    0.7.0.1
 */