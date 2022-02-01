package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getIViewActionCallback", "initViewCallback", "", "keep", "p0", "loadInitData", "loadMoreData", "onAttach", "callback", "onBackPressed", "", "onDetach", "onUIPause", "onUIResume", "requestRefresh", "plugin-finder_release"})
public abstract class b$a
  implements com.tencent.mm.plugin.finder.presenter.base.a<b.b>, b<com.tencent.mm.vending.e.a>
{
  final MMActivity fNT;
  public b.b scu;
  private com.tencent.mm.view.d scv;
  public final BaseFinderFeedLoader scw;
  
  public b$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    this.fNT = paramMMActivity;
    this.scw = paramBaseFinderFeedLoader;
    this.scv = ((com.tencent.mm.view.d)new com.tencent.mm.view.d()
    {
      public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(202148);
        Object localObject1 = this.scx.scu;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.d)((b.b)localObject1).scj;
          if (localObject1 != null)
          {
            Object localObject2 = this.scx.scu;
            if (localObject2 != null)
            {
              localObject2 = ((b.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).LRV.size();; i = 0)
            {
              ((com.tencent.mm.view.d)localObject1).au(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(202148);
              return;
            }
          }
        }
        AppMethodBeat.o(202148);
      }
      
      public final void av(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(202149);
        Object localObject1 = this.scx.scu;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.d)((b.b)localObject1).scj;
          if (localObject1 != null)
          {
            localObject2 = this.scx.scu;
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
          localObject1 = this.scx.scu;
          if (localObject1 == null) {
            break;
          }
          ((b.b)localObject1).cCF();
          AppMethodBeat.o(202149);
          return;
        }
        AppMethodBeat.o(202149);
      }
      
      public final void c(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(202144);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.scx.scu;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.d)((b.b)localObject).scj;
          if (localObject != null)
          {
            ((com.tencent.mm.view.d)localObject).c(paramAnonymousc);
            AppMethodBeat.o(202144);
            return;
          }
        }
        AppMethodBeat.o(202144);
      }
      
      public final void d(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(202145);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.scx.scu;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.d)((b.b)localObject).scj;
          if (localObject != null)
          {
            ((com.tencent.mm.view.d)localObject).d(paramAnonymousc);
            AppMethodBeat.o(202145);
            return;
          }
        }
        AppMethodBeat.o(202145);
      }
      
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(202147);
        Object localObject1 = this.scx.scu;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.d)((b.b)localObject1).scj;
          if (localObject1 != null)
          {
            Object localObject2 = this.scx.scu;
            if (localObject2 != null)
            {
              localObject2 = ((b.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).LRV.size();; i = 0)
            {
              ((com.tencent.mm.view.d)localObject1).f(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
              AppMethodBeat.o(202147);
              return;
            }
          }
        }
        AppMethodBeat.o(202147);
      }
      
      public final void onChanged()
      {
        AppMethodBeat.i(202146);
        Object localObject = this.scx.scu;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.d)((b.b)localObject).scj;
          if (localObject != null)
          {
            ((com.tencent.mm.view.d)localObject).onChanged();
            AppMethodBeat.o(202146);
            return;
          }
        }
        AppMethodBeat.o(202146);
      }
    });
  }
  
  public void a(b.b paramb)
  {
    p.h(paramb, "callback");
    this.scu = paramb;
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.scw;
    com.tencent.mm.view.d locald = cCz();
    paramb = locald;
    if (locald == null) {
      paramb = this.scv;
    }
    localBaseFinderFeedLoader.register(paramb);
    cCm();
  }
  
  public abstract void aTS();
  
  public void cCA() {}
  
  public abstract void cCm();
  
  public abstract c cCq();
  
  public com.tencent.mm.view.d cCz()
  {
    return null;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama) {}
  
  public void onDetach()
  {
    this.scw.unregister(this.scv);
  }
  
  public abstract void requestRefresh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.b.a
 * JD-Core Version:    0.7.0.1
 */