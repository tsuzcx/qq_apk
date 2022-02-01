package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getIViewActionCallback", "initViewCallback", "", "keep", "p0", "loadInitData", "loadMoreData", "onAttach", "callback", "onBackPressed", "", "onDetach", "onUIPause", "onUIResume", "requestRefresh", "plugin-finder_release"})
public abstract class c$a
  implements com.tencent.mm.plugin.finder.presenter.base.a<c.b>, b<com.tencent.mm.vending.e.a>
{
  final MMActivity gte;
  public final BaseFinderFeedLoader tFM;
  public c.b tMd;
  private j tMe;
  
  public c$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    this.gte = paramMMActivity;
    this.tFM = paramBaseFinderFeedLoader;
    this.tMe = ((j)new j()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(243688);
        Object localObject = this.tMf.tMd;
        if (localObject != null)
        {
          localObject = (j)((c.b)localObject).tLS;
          if (localObject != null)
          {
            ((j)localObject).onChanged();
            AppMethodBeat.o(243688);
            return;
          }
        }
        AppMethodBeat.o(243688);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(243689);
        Object localObject1 = this.tMf.tMd;
        if (localObject1 != null)
        {
          localObject1 = (j)((c.b)localObject1).tLS;
          if (localObject1 != null)
          {
            Object localObject2 = this.tMf.tMd;
            if (localObject2 != null)
            {
              localObject2 = ((c.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((g)localObject2).RqM.size();; i = 0)
            {
              ((j)localObject1).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(243689);
              return;
            }
          }
        }
        AppMethodBeat.o(243689);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(243690);
        Object localObject1 = this.tMf.tMd;
        if (localObject1 != null)
        {
          localObject1 = (j)((c.b)localObject1).tLS;
          if (localObject1 != null)
          {
            Object localObject2 = this.tMf.tMd;
            if (localObject2 != null)
            {
              localObject2 = ((c.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((g)localObject2).RqM.size();; i = 0)
            {
              ((j)localObject1).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
              AppMethodBeat.o(243690);
              return;
            }
          }
        }
        AppMethodBeat.o(243690);
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(243691);
        Object localObject1 = this.tMf.tMd;
        if (localObject1 != null)
        {
          localObject1 = (j)((c.b)localObject1).tLS;
          if (localObject1 != null)
          {
            Object localObject2 = this.tMf.tMd;
            if (localObject2 != null)
            {
              localObject2 = ((c.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((g)localObject2).RqM.size();; i = 0)
            {
              ((j)localObject1).onItemRangeInserted(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(243691);
              return;
            }
          }
        }
        AppMethodBeat.o(243691);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(243692);
        Object localObject1 = this.tMf.tMd;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (j)((c.b)localObject1).tLS;
          if (localObject1 != null)
          {
            localObject2 = this.tMf.tMd;
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
        for (int i = ((g)localObject2).RqM.size();; i = 0)
        {
          ((j)localObject1).onItemRangeRemoved(i + paramAnonymousInt1, paramAnonymousInt2);
          localObject1 = this.tMf.tMd;
          if (localObject1 == null) {
            break;
          }
          ((c.b)localObject1).dcv();
          AppMethodBeat.o(243692);
          return;
        }
        AppMethodBeat.o(243692);
      }
      
      public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(243686);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.tMf.tMd;
        if (localObject != null)
        {
          localObject = (j)((c.b)localObject).tLS;
          if (localObject != null)
          {
            ((j)localObject).onPreFinishLoadMore(paramAnonymousc);
            AppMethodBeat.o(243686);
            return;
          }
        }
        AppMethodBeat.o(243686);
      }
      
      public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(243687);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.tMf.tMd;
        if (localObject != null)
        {
          localObject = (j)((c.b)localObject).tLS;
          if (localObject != null)
          {
            ((j)localObject).onPreFinishLoadMoreSmooth(paramAnonymousc);
            AppMethodBeat.o(243687);
            return;
          }
        }
        AppMethodBeat.o(243687);
      }
      
      public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(243685);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.tMf.tMd;
        if (localObject != null)
        {
          localObject = (j)((c.b)localObject).tLS;
          if (localObject != null)
          {
            ((j)localObject).onPreFinishRefresh(paramAnonymousc);
            AppMethodBeat.o(243685);
            return;
          }
        }
        AppMethodBeat.o(243685);
      }
    });
  }
  
  public void a(c.b paramb)
  {
    p.h(paramb, "callback");
    this.tMd = paramb;
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    j localj = dco();
    paramb = localj;
    if (localj == null) {
      paramb = this.tMe;
    }
    localBaseFinderFeedLoader.register(paramb);
    dcb();
  }
  
  public abstract void boE();
  
  public abstract void dcb();
  
  public abstract f dce();
  
  public j dco()
  {
    return null;
  }
  
  public void dcp() {}
  
  public void keep(com.tencent.mm.vending.e.a parama) {}
  
  public final boolean onBackPressed()
  {
    Object localObject = this.tMd;
    if (localObject == null) {
      p.hyc();
    }
    localObject = ((c.b)localObject).dcj();
    if (localObject == null) {
      p.hyc();
    }
    if (((FinderLikeDrawer)localObject).dGs())
    {
      localObject = this.tMd;
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((c.b)localObject).dcj();
      if (localObject == null) {
        p.hyc();
      }
      ((FinderLikeDrawer)localObject).dGr();
      return true;
    }
    return false;
  }
  
  public void onDetach()
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    j localj2 = dco();
    j localj1 = localj2;
    if (localj2 == null) {
      localj1 = this.tMe;
    }
    localBaseFinderFeedLoader.unregister(localj1);
  }
  
  public abstract void requestRefresh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.c.a
 * JD-Core Version:    0.7.0.1
 */