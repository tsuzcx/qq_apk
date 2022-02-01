package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getIViewActionCallback", "initViewCallback", "", "keep", "p0", "loadInitData", "loadMoreData", "onAttach", "callback", "onBackPressed", "", "onDetach", "onUIPause", "onUIResume", "requestRefresh", "plugin-finder_release"})
public abstract class c$a
  implements com.tencent.mm.plugin.finder.presenter.base.a<c.b>, b<com.tencent.mm.vending.e.a>
{
  final MMActivity iXq;
  public final BaseFinderFeedLoader xnX;
  public c.b xvU;
  private j xvV;
  
  public c$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    this.iXq = paramMMActivity;
    this.xnX = paramBaseFinderFeedLoader;
    this.xvV = ((j)new j()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(283012);
        Object localObject = this.xvW.xvU;
        if (localObject != null)
        {
          localObject = (j)((c.b)localObject).xvJ;
          if (localObject != null)
          {
            ((j)localObject).onChanged();
            AppMethodBeat.o(283012);
            return;
          }
        }
        AppMethodBeat.o(283012);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(283013);
        Object localObject1 = this.xvW.xvU;
        if (localObject1 != null)
        {
          localObject1 = (j)((c.b)localObject1).xvJ;
          if (localObject1 != null)
          {
            Object localObject2 = this.xvW.xvU;
            if (localObject2 != null)
            {
              localObject2 = ((c.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((h)localObject2).YSk.size();; i = 0)
            {
              ((j)localObject1).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(283013);
              return;
            }
          }
        }
        AppMethodBeat.o(283013);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(283014);
        Object localObject1 = this.xvW.xvU;
        if (localObject1 != null)
        {
          localObject1 = (j)((c.b)localObject1).xvJ;
          if (localObject1 != null)
          {
            Object localObject2 = this.xvW.xvU;
            if (localObject2 != null)
            {
              localObject2 = ((c.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((h)localObject2).YSk.size();; i = 0)
            {
              ((j)localObject1).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
              AppMethodBeat.o(283014);
              return;
            }
          }
        }
        AppMethodBeat.o(283014);
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(283015);
        Object localObject1 = this.xvW.xvU;
        if (localObject1 != null)
        {
          localObject1 = (j)((c.b)localObject1).xvJ;
          if (localObject1 != null)
          {
            Object localObject2 = this.xvW.xvU;
            if (localObject2 != null)
            {
              localObject2 = ((c.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((h)localObject2).YSk.size();; i = 0)
            {
              ((j)localObject1).onItemRangeInserted(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(283015);
              return;
            }
          }
        }
        AppMethodBeat.o(283015);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(283016);
        Object localObject1 = this.xvW.xvU;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (j)((c.b)localObject1).xvJ;
          if (localObject1 != null)
          {
            localObject2 = this.xvW.xvU;
            if (localObject2 == null) {
              break label105;
            }
            localObject2 = ((c.b)localObject2).getAdapter();
            if (localObject2 == null) {
              break label105;
            }
          }
        }
        label105:
        for (int i = ((h)localObject2).YSk.size();; i = 0)
        {
          ((j)localObject1).onItemRangeRemoved(i + paramAnonymousInt1, paramAnonymousInt2);
          localObject1 = this.xvW.xvU;
          if (localObject1 == null) {
            break;
          }
          ((c.b)localObject1).dsL();
          AppMethodBeat.o(283016);
          return;
        }
        AppMethodBeat.o(283016);
      }
      
      public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(283010);
        p.k(paramAnonymousc, "reason");
        Object localObject = this.xvW.xvU;
        if (localObject != null)
        {
          localObject = (j)((c.b)localObject).xvJ;
          if (localObject != null)
          {
            ((j)localObject).onPreFinishLoadMore(paramAnonymousc);
            AppMethodBeat.o(283010);
            return;
          }
        }
        AppMethodBeat.o(283010);
      }
      
      public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(283011);
        p.k(paramAnonymousc, "reason");
        Object localObject = this.xvW.xvU;
        if (localObject != null)
        {
          localObject = (j)((c.b)localObject).xvJ;
          if (localObject != null)
          {
            ((j)localObject).onPreFinishLoadMoreSmooth(paramAnonymousc);
            AppMethodBeat.o(283011);
            return;
          }
        }
        AppMethodBeat.o(283011);
      }
      
      public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(283009);
        p.k(paramAnonymousc, "reason");
        Object localObject = this.xvW.xvU;
        if (localObject != null)
        {
          localObject = (j)((c.b)localObject).xvJ;
          if (localObject != null)
          {
            ((j)localObject).onPreFinishRefresh(paramAnonymousc);
            AppMethodBeat.o(283009);
            return;
          }
        }
        AppMethodBeat.o(283009);
      }
    });
  }
  
  public void a(c.b paramb)
  {
    p.k(paramb, "callback");
    this.xvU = paramb;
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    j localj = dsE();
    paramb = localj;
    if (localj == null) {
      paramb = this.xvV;
    }
    localBaseFinderFeedLoader.register(paramb);
    dsr();
  }
  
  public abstract void byN();
  
  public j dsE()
  {
    return null;
  }
  
  public void dsF() {}
  
  public abstract void dsr();
  
  public abstract f dsu();
  
  public void keep(com.tencent.mm.vending.e.a parama) {}
  
  public final boolean onBackPressed()
  {
    Object localObject = this.xvU;
    if (localObject == null) {
      p.iCn();
    }
    localObject = ((c.b)localObject).dsz();
    if (localObject == null) {
      p.iCn();
    }
    if (((FinderLikeDrawer)localObject).eis())
    {
      localObject = this.xvU;
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((c.b)localObject).dsz();
      if (localObject == null) {
        p.iCn();
      }
      ((FinderLikeDrawer)localObject).eir();
      return true;
    }
    return false;
  }
  
  public void onDetach()
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    j localj2 = dsE();
    j localj1 = localj2;
    if (localj2 == null) {
      localj1 = this.xvV;
    }
    localBaseFinderFeedLoader.unregister(localj1);
  }
  
  public void onUIResume() {}
  
  public abstract void requestRefresh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.c.a
 * JD-Core Version:    0.7.0.1
 */